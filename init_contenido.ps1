# init_contenido.ps1

Write-Host "--- Iniciando Script de Inicio ---" -ForegroundColor Cyan

# 1. Comprobar si Docker está corriendo
$dockerIsRunning = Get-Process "Docker Desktop" -ErrorAction SilentlyContinue

if (!$dockerIsRunning) {
    Write-Host "Docker Desktop no esta abierto. Iniciando Docker Desktop..." -ForegroundColor Yellow
    
    # Ruta estándar de Docker Desktop. Ajustar si es necesario.
    $dockerPath = "C:\Program Files\Docker\Docker\Docker Desktop.exe"
    
    if (Test-Path $dockerPath) {
        Start-Process $dockerPath
    } else {
        Write-Error "No se ha encontrado el ejecutable de Docker Desktop en la ruta: C:\Program Files\Docker\Docker\Docker Desktop.exe."
        exit 1
    }

    # Bucle de espera hasta que el motor de Docker esté listo para recibir comandos
    Write-Host "Esperando a que el motor de Docker este listo..." -NoNewline
    do {
        Start-Sleep -Seconds 2
        Write-Host "." -NoNewline
        $dockerInfo = docker info 2>&1 | Out-String
    } until ($dockerInfo -notmatch "error" -and $dockerInfo -notmatch "Is the docker daemon running")
    Write-Host "`nDocker esta listo." -ForegroundColor Green
} else {
    Write-Host "Docker se esta ejecutando." -ForegroundColor Green
}

# 2. Entrar en la carpeta deployments
if (Test-Path ".\deployments") {
    Set-Location ".\deployments"
    Write-Host "Entrando en el directorio 'deployments'..."
} else {
    Write-Error "La carpeta 'deployments' no existe."
    exit 1
}

# 3. Docker Compose Up
Write-Host "Ejecutando Docker Compose..." -ForegroundColor Cyan
docker compose up -d

# 4. Salir del directorio
Set-Location ..
Write-Host "Regresando al directorio raiz..."

# 5. Maven Clean Package
Write-Host "Ejecutando Maven Clean Package..." -ForegroundColor Cyan
# cmd /c es necesario a veces para que PowerShell ejecute mvn correctamente si no está en las variables de entorno como función PS
cmd /c mvn clean package

# Comprobar si el build fue exitoso antes de intentar correrlo
if ($LASTEXITCODE -eq 0) {
    # 6. Maven Spring-Boot Run
    Write-Host "Iniciando la aplicacion Spring Boot..." -ForegroundColor Cyan
    cmd /c mvn spring-boot:run
} else {
    Write-Error "El build de Maven ha fallado. No se puede iniciar la aplicacion."
}