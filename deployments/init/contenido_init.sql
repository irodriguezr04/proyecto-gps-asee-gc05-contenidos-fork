--
-- PostgreSQL database dump
--

\restrict DyxaBMN8x5dPJUlSpRPVkyHRnECUDP23uDp7EyjMxNgkc6IoHzpa0f6zUSEvIxY

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
3	3	3	Kind of Blue	1959-08-17	https://m.media-amazon.com/images/I/71UUU3OLX2L._UF894,1000_QL80_.jpg
4	4	4	Por la boca vive el pez	2006-09-11	https://m.media-amazon.com/images/I/91iGr1p7SBL._UF350,350_QL50_.jpg
5	5	5	Metallica (The Black Album)	1991-08-12	https://mariskalrock.com/wp-content/uploads/2018/09/metallica-the-black-album-web.jpg
7	7	7	Beethoven: The Essentials	1985-10-15	https://images.universal-music.de/img/assets/446/446845/4/1280/beethoven-the-essentials.jpg
8	8	8	True	2013-09-13	https://m.media-amazon.com/images/I/61Nol3quayL.jpg
9	9	9	Un Verano Sin Ti	2022-05-06	https://i.scdn.co/image/ab67616d0000b27349d694203245f241a1bcaa72
10	10	10	Brothers in Arms	1985-05-13	https://upload.wikimedia.org/wikipedia/en/6/67/DS_Brothers_in_Arms.jpg
11	11	11	AM	2013-09-09	https://m.media-amazon.com/images/I/71-Y-3usHkL._UF894,1000_QL80_.jpg
13	13	13	11 Razones	2020-12-11	https://m.media-amazon.com/images/I/810gU8ZdyCL._UF894,1000_QL80_.jpg
14	14	14	The Eminem Show	2002-05-26	https://m.media-amazon.com/images/I/61jxguiMreL.jpg
15	15	15	Back to Rockport	2020-08-28	https://m.media-amazon.com/images/I/61Qtf00b3IL._UF894,1000_QL80_.jpg
16	16	16	Nothing but the Beat	2011-08-26	https://m.media-amazon.com/images/I/710ZkhTLgJL._UF894,1000_QL80_.jpg
\.


--
-- Data for Name: artists; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.artists (id, name, description, genre) FROM stdin;
1	Queen	Legendary British rock band	Rock
2	AC/DC	Legendary Australian hard rock band formed in Sydney	Hard Rock
3	Miles Davis	American jazz trumpeter, bandleader, and composer	Jazz
4	Fito & Fitipaldis	Spanish rock band formed by Fito Cabrales	Pop Rock
5	Metallica	American heavy metal band formed in Los Angeles	Metal
7	Ludwig van Beethoven	German composer and pianist, a crucial figure in the transition between the Classical and Romantic eras	Cl├ísica
8	Avicii	Swedish DJ, remixer, and music producer known for melodic house	Electr├│nica
9	Bad Bunny	Puerto Rican rapper and singer, known as the King of Latin Trap	Urbano
10	Dire Straits	British rock band led by Mark Knopfler, known for their distinct sound and guitar style	Rock
11	Arctic Monkeys	English rock band formed in Sheffield, famous for their internet-driven rise	Indie
13	Aitana	Spanish singer and songwriter, gained national recognition in Operaci├│n Triunfo	Pop
14	Eminem	American rapper, songwriter, and record producer, cited as one of the greatest of all time	Urbano
15	Kidd Keo	Spanish trap artist known for his bilingual flow mixing English and Spanish	Urbano
16	David Guetta	French DJ and music producer, considered the grandfather of EDM	Electr├│nica
\.


--
-- Data for Name: labels; Type: TABLE DATA; Schema: public; Owner: usuario
--

COPY public.labels (id, name, description) FROM stdin;
1	EMI Records	British multinational music recording and publishing company
2	Atlantic Records	American major record label founded in 1947
3	Blue Note Records	Famous American jazz record label established in 1939
4	DRO Atlantic	Historic Spanish record label, now part of Warner Music Group
5	Blackened Recordings	Label founded by Metallica to take control of their master recordings
7	Deutsche Grammophon	German record label that is the oldest surviving record label in the world
8	PRMD Music	Record label founded by Ash Pournouri, best known for representing Avicii
9	Rimas Entertainment	Puerto Rican record label founded by Noah Assad
10	Vertigo Records	British record label that was a subsidiary of Philips Records, famous for progressive rock
11	Domino Recording Company	British independent record label based in London
13	Universal Music Spain	Spanish division of the Universal Music Group
14	Shady Records	American record label founded by Eminem and Paul Rosenberg
15	DB Trap Records	Independent label founded by Kidd Keo focused on Trap and Drill music
16	What A Music	Electronic music label founded by David Guetta
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
7	3	So What	Jazz	00:09:22	\N	2025-11-23 21:10:22.217977
8	3	Freddie Freeloader	Jazz	00:09:46	\N	2025-11-23 21:10:22.217977
9	4	Por la boca vive el pez	Rock	00:04:13	\N	2025-11-23 21:14:01.399583
10	4	Me equivocar├¡a otra vez	Pop Rock	00:05:20	\N	2025-11-23 21:14:01.399583
11	4	Abrazado a la tristeza	Rock	00:04:45	\N	2025-11-23 21:14:01.399583
18	5	Enter Sandman	Metal	00:05:31	\N	2025-11-23 21:25:55.033773
19	5	Nothing Else Matters	Ballad	00:06:28	\N	2025-11-23 21:25:55.033773
20	5	Sad But True	Metal	00:05:24	\N	2025-11-23 21:25:55.033773
21	7	Symphony No. 5: Allegro con brio	Cl├ísica	00:07:18	\N	2025-11-23 21:27:54.37997
22	7	F├╝r Elise (Bagatelle No. 25)	Cl├ísica	00:03:25	\N	2025-11-23 21:27:54.37997
23	7	Moonlight Sonata (Adagio sostenuto)	Cl├ísica	00:06:00	\N	2025-11-23 21:27:54.37997
24	8	Wake Me Up	Electr├│nica	00:04:07	\N	2025-11-23 21:29:40.14986
25	8	Hey Brother	Electr├│nica	00:04:15	\N	2025-11-23 21:29:40.14986
26	8	Addicted to You	Pop	00:02:28	\N	2025-11-23 21:29:40.14986
27	9	Tit├¡ Me Pregunt├│	Urbano	00:04:03	\N	2025-11-23 21:35:55.953306
28	9	Me Porto Bonito	Urbano	00:02:58	\N	2025-11-23 21:35:55.953306
29	9	Ojitos Lindos	Pop	00:04:30	\N	2025-11-23 21:35:55.953306
30	10	Money for Nothing	Rock	00:08:26	\N	2025-11-23 21:38:40.131229
31	10	Walk of Life	Pop Rock	00:04:12	\N	2025-11-23 21:38:40.131229
32	10	Brothers in Arms	Ballad	00:06:59	\N	2025-11-23 21:38:40.131229
33	11	Do I Wanna Know?	Indie	00:04:32	\N	2025-11-23 21:41:37.52141
34	11	R U Mine?	Rock	00:03:21	\N	2025-11-23 21:41:37.52141
35	11	I Wanna Be Yours	Ballad	00:03:04	\N	2025-11-23 21:41:37.52141
36	13	11 Razones	Pop	00:03:33	\N	2025-11-23 21:44:30.350007
37	13	+ (M├ís)	Pop	00:03:39	\N	2025-11-23 21:44:30.350007
38	13	No te has ido y ya te extra├▒o	Pop	00:03:29	\N	2025-11-23 21:44:30.350007
39	14	Without Me	Urbano	00:04:50	\N	2025-11-23 21:46:58.857144
40	14	Sing for the Moment	Rock	00:05:40	\N	2025-11-23 21:46:58.857144
41	14	Till I Collapse	Urbano	00:04:57	\N	2025-11-23 21:46:58.857144
42	15	Dracukeo	Urbano	00:03:40	\N	2025-11-23 21:48:39.707357
43	15	Moon Talk	Pop	00:03:20	\N	2025-11-23 21:48:39.707357
44	15	Ma Vie	Electr├│nica	00:03:45	\N	2025-11-23 21:48:39.707357
45	16	Titanium (feat. Sia)	Electr├│nica	00:04:05	\N	2025-11-23 21:52:24.713969
46	16	Little Bad Girl (feat. Ludacris)	Urbano	00:03:12	\N	2025-11-23 21:52:24.713969
47	16	Without You (feat. Usher)	Pop	00:03:28	\N	2025-11-23 21:52:24.713969
\.


--
-- Name: albums_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.albums_id_seq', 16, true);


--
-- Name: artists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.artists_id_seq', 16, true);


--
-- Name: labels_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.labels_id_seq', 16, true);


--
-- Name: tracks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: usuario
--

SELECT pg_catalog.setval('public.tracks_id_seq', 47, true);


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

\unrestrict DyxaBMN8x5dPJUlSpRPVkyHRnECUDP23uDp7EyjMxNgkc6IoHzpa0f6zUSEvIxY

