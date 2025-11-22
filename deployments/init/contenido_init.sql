--
-- PostgreSQL database dump
--

\restrict 8I2TJc4qpah3hUINoKs44mua30DF3Kcglvxm1fIZXUw8mmMGKaMFRBq3pZuwxSG

-- Dumped from database version 16.11 (Debian 16.11-1.pgdg13+1)
-- Dumped by pg_dump version 16.11 (Debian 16.11-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
    id bigint NOT NULL,
    artist_id integer NOT NULL,
    label_id integer,
    title character varying(255) NOT NULL,
    publishedat date,
    coverurl character varying(255)
);


ALTER TABLE public.albums OWNER TO usuario;

--
-- Name: albums_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.albums_id_seq
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
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description text,
    genre character varying(100)
);


ALTER TABLE public.artists OWNER TO usuario;

--
-- Name: artists_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.artists_id_seq
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
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description text
);


ALTER TABLE public.labels OWNER TO usuario;

--
-- Name: labels_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.labels_id_seq
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
-- Name: tracks; Type: TABLE; Schema: public; Owner: usuario
--

CREATE TABLE public.tracks (
    id bigint NOT NULL,
    album_id integer NOT NULL,
    title character varying(255) NOT NULL,
    genre character varying(100) NOT NULL,
    duration interval,
    fileurl character varying(255),
    publishedat timestamp without time zone
);


ALTER TABLE public.tracks OWNER TO usuario;

--
-- Name: tracks_id_seq; Type: SEQUENCE; Schema: public; Owner: usuario
--

CREATE SEQUENCE public.tracks_id_seq
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

COPY public.albums (id, artist_id, label_id, title, publishedat, coverurl) FROM stdin;
1	1	1	A Night at the Opera	1975-11-21	http://url-de-ejemplo.com/cover.jpg
2	2	2	Back in Black	1980-07-25	http://url-ejemplo.com/acdc-cover.jpg
\.


--
-- Data for Name: artists; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.artists (id, name, description, genre) FROM stdin;
1	Queen	Legendary British rock band	Rock
2	AC/DC	Legendary Australian hard rock band formed in Sydney	Hard Rock
\.


--
-- Data for Name: labels; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.labels (id, name, description) FROM stdin;
1	EMI Records	British multinational music recording and publishing company
2	Atlantic Records	American major record label founded in 1947
\.


--
-- Data for Name: tracks; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.tracks (id, album_id, title, genre, duration, fileurl, publishedat) FROM stdin;
1	1	Bohemian Rhapsody	Rock	00:05:55	http://files.com/track1.mp3	2025-11-19 18:03:25.207978
2	1	You're My Best Friend	Pop Rock	00:02:52	http://files.com/track2.mp3	2025-11-19 18:03:25.207978
3	1	Love of My Life	Ballad	00:03:39	http://files.com/track3.mp3	2025-11-19 18:03:25.207978
4	2	Hells Bells	Hard Rock	00:05:12	http://files.com/hellsbells.mp3	2025-11-19 18:05:13.355234
5	2	Shoot to Thrill	Hard Rock	00:05:17	http://files.com/shottothrill.mp3	2025-11-19 18:05:13.355234
6	2	Back in Black	Hard Rock	00:04:15	http://files.com/backinblack.mp3	2025-11-19 18:05:13.355234
\.


--
-- Name: albums_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.albums_id_seq', 2, true);


--
-- Name: artists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.artists_id_seq', 2, true);


--
-- Name: labels_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.labels_id_seq', 2, true);


--
-- Name: tracks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.tracks_id_seq', 6, true);


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
-- Name: tracks tracks_album_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: usuario
--

ALTER TABLE ONLY public.tracks
    ADD CONSTRAINT tracks_album_id_fkey FOREIGN KEY (album_id) REFERENCES public.albums(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

\unrestrict 8I2TJc4qpah3hUINoKs44mua30DF3Kcglvxm1fIZXUw8mmMGKaMFRBq3pZuwxSG

