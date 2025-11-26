#!/bin/bash

echo "--- Iniciando Script de Inicio ---"

# 1. Comprobar y abrir Docker
# Intentamos obtener información de docker. Si falla, es que no está corriendo.
if ! docker info > /dev/null 2>&1; then
    echo "Docker no esta corriendo. Intentando iniciar..."

    # DETECCIÓN DE SO
    if [[ "$OSTYPE" == "darwin"* ]]; then
        # Comando para macOS
        open -a Docker
    else
        # Comando para Linux (Docker Desktop o servicio estándar)
        echo "Por favor inicia Docker manualmente o descomenta la línea de inicio en el script para tu distribución Linux."
        # systemctl --user start docker-desktop 
    fi

    echo "Esperando a que Docker se inicie..."
    # Bucle de espera
    while ! docker info > /dev/null 2>&1; do
        sleep 2
        printf "."
    done
    echo ""
    echo "Docker esta listo."
fi

# 2. Entrar en deployments
if [ -d "./deployments" ]; then
    cd deployments
    echo "Directorio cambiado a 'deployments'"
else
    echo "Error: La carpeta 'deployments' no existe."
    exit 1
fi

# 3. Docker Compose Up
echo "Levantando contenedores..."
docker compose up -d

# 4. Salir del directorio
cd ..
echo "Regresando al directorio raíz..."

# 5. Maven Clean Package
echo "Ejecutando Maven Clean Package..."
# Usamos && para asegurar que el siguiente paso solo ocurre si este tiene éxito
mvn clean package

# Comprobamos el resultado del comando anterior ($?)
if [ $? -eq 0 ]; then
    # 6. Maven Spring-Boot Run
    echo "Iniciando Spring Boot..."
    mvn spring-boot:run
else
    echo "Error en la compilacion de Maven. Abortando inicio."
    exit 1
fi