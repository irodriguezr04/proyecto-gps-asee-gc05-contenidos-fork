--
-- PostgreSQL database dump
--

\restrict Brb1vA5XX0RlYTU3m4DEGH0flZh22uJsRFiMaeJcQvf1SKsNXHKJqEeBLvBuDJK

-- Dumped from database version 18.0 (Debian 18.0-1.pgdg13+3)
-- Dumped by pg_dump version 18.0 (Debian 18.0-1.pgdg13+3)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: albums; Type: TABLE; Schema: public; Owner: usuario
--

CREATE TABLE public.albums (
    id integer NOT NULL,
    artist_id integer NOT NULL,
    label_id integer,
    title character varying(255) NOT NULL,
    releasedate date,
    coverurl character varying(255)
);


ALTER TABLE public.albums OWNER TO usuario;

--
-- Name: albums_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.albums_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.albums_id_seq OWNER TO usuario;

--
-- Name: albums_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: usuario
--

ALTER SEQUENCE public.albums_id_seq OWNED BY public.albums.id;


--
-- Name: artists; Type: TABLE; Schema: public; Owner: usuario
--

CREATE TABLE public.artists (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description text,
    genre character varying(100)
);


ALTER TABLE public.artists OWNER TO usuario;

--
-- Name: artists_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.artists_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.artists_id_seq OWNER TO usuario;

--
-- Name: artists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: usuario
--

ALTER SEQUENCE public.artists_id_seq OWNED BY public.artists.id;


--
-- Name: labels; Type: TABLE; Schema: public; Owner: usuario
--

CREATE TABLE public.labels (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description text
);


ALTER TABLE public.labels OWNER TO usuario;

--
-- Name: labels_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.labels_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.labels_id_seq OWNER TO usuario;

--
-- Name: labels_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: usuario
--

ALTER SEQUENCE public.labels_id_seq OWNED BY public.labels.id;


--
-- Name: subscriptions; Type: TABLE; Schema: public; Owner: usuario
--

CREATE TABLE public.subscriptions (
    userid character varying(50) NOT NULL,
    artistid integer NOT NULL,
    createdat timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.subscriptions OWNER TO usuario;

--
-- Name: tracks; Type: TABLE; Schema: public; Owner: usuario
--

CREATE TABLE public.tracks (
    id integer NOT NULL,
    album_id integer NOT NULL,
    title character varying(255) NOT NULL,
    duration interval,
    fileurl character varying(255),
    publishedat timestamp without time zone
);


ALTER TABLE public.tracks OWNER TO usuario;

--
-- Name: tracks_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.tracks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tracks_id_seq OWNER TO usuario;

--
-- Name: tracks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: usuario
--

ALTER SEQUENCE public.tracks_id_seq OWNED BY public.tracks.id;


--
-- Name: albums id; Type: DEFAULT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.albums ALTER COLUMN id SET DEFAULT nextval('public.albums_id_seq'::regclass);


--
-- Name: artists id; Type: DEFAULT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.artists ALTER COLUMN id SET DEFAULT nextval('public.artists_id_seq'::regclass);


--
-- Name: labels id; Type: DEFAULT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.labels ALTER COLUMN id SET DEFAULT nextval('public.labels_id_seq'::regclass);


--
-- Name: tracks id; Type: DEFAULT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.tracks ALTER COLUMN id SET DEFAULT nextval('public.tracks_id_seq'::regclass);


--
-- Data for Name: albums; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.albums (id, artist_id, label_id, title, releasedate, coverurl) FROM stdin;
\.


--
-- Data for Name: artists; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.artists (id, name, description, genre) FROM stdin;
\.


--
-- Data for Name: labels; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.labels (id, name, description) FROM stdin;
\.


--
-- Data for Name: subscriptions; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.subscriptions (userid, artistid, createdat) FROM stdin;
\.


--
-- Data for Name: tracks; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.tracks (id, album_id, title, duration, fileurl, publishedat) FROM stdin;
\.


--
-- Name: albums_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.albums_id_seq', 1, false);


--
-- Name: artists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.artists_id_seq', 1, false);


--
-- Name: labels_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.labels_id_seq', 1, false);


--
-- Name: tracks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.tracks_id_seq', 1, false);


--
-- Name: albums albums_pkey; Type: CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.albums
    ADD CONSTRAINT albums_pkey PRIMARY KEY (id);


--
-- Name: artists artists_pkey; Type: CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.artists
    ADD CONSTRAINT artists_pkey PRIMARY KEY (id);


--
-- Name: labels labels_pkey; Type: CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.labels
    ADD CONSTRAINT labels_pkey PRIMARY KEY (id);


--
-- Name: subscriptions subscriptions_pkey; Type: CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT subscriptions_pkey PRIMARY KEY (userid, artistid);


--
-- Name: tracks tracks_pkey; Type: CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.tracks
    ADD CONSTRAINT tracks_pkey PRIMARY KEY (id);


--
-- Name: albums albums_artist_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.albums
    ADD CONSTRAINT albums_artist_id_fkey FOREIGN KEY (artist_id) REFERENCES public.artists(id) ON DELETE CASCADE;


--
-- Name: albums albums_label_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.albums
    ADD CONSTRAINT albums_label_id_fkey FOREIGN KEY (label_id) REFERENCES public.labels(id) ON DELETE SET NULL;


--
-- Name: subscriptions subscriptions_artistid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT subscriptions_artistid_fkey FOREIGN KEY (artistid) REFERENCES public.artists(id) ON DELETE CASCADE;


--
-- Name: tracks tracks_album_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.tracks
    ADD CONSTRAINT tracks_album_id_fkey FOREIGN KEY (album_id) REFERENCES public.albums(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

\unrestrict Brb1vA5XX0RlYTU3m4DEGH0flZh22uJsRFiMaeJcQvf1SKsNXHKJqEeBLvBuDJK

