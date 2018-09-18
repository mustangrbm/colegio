--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.10
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-1.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: alumnos; Type: TABLE; Schema: public; Owner: rbm
--

CREATE TABLE public.alumnos (
    idalumno numeric NOT NULL,
    nombre character varying(200),
    apellido character varying,
    cedula integer
);


ALTER TABLE public.alumnos OWNER TO rbm;

--
-- Name: alumnos_idalumno_seq; Type: SEQUENCE; Schema: public; Owner: rbm
--

CREATE SEQUENCE public.alumnos_idalumno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.alumnos_idalumno_seq OWNER TO rbm;

--
-- Name: alumnos_idalumno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rbm
--

ALTER SEQUENCE public.alumnos_idalumno_seq OWNED BY public.alumnos.idalumno;


--
-- Name: cuota; Type: TABLE; Schema: public; Owner: rbm
--

CREATE TABLE public.cuota (
    id_cuota integer NOT NULL,
    id_alumno integer,
    descripcion character varying,
    pagado boolean,
    fecha_pago date
);


ALTER TABLE public.cuota OWNER TO rbm;

--
-- Name: cuota_id_cuota_seq; Type: SEQUENCE; Schema: public; Owner: rbm
--

CREATE SEQUENCE public.cuota_id_cuota_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuota_id_cuota_seq OWNER TO rbm;

--
-- Name: cuota_id_cuota_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rbm
--

ALTER SEQUENCE public.cuota_id_cuota_seq OWNED BY public.cuota.id_cuota;


--
-- Name: inscripciones; Type: TABLE; Schema: public; Owner: rbm
--

CREATE TABLE public.inscripciones (
    idinscripcion integer NOT NULL,
    idalumno integer,
    idprofesor integer,
    idmateria integer,
    fecha date
);


ALTER TABLE public.inscripciones OWNER TO rbm;

--
-- Name: inscripciones_idinscripciones_seq; Type: SEQUENCE; Schema: public; Owner: rbm
--

CREATE SEQUENCE public.inscripciones_idinscripciones_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inscripciones_idinscripciones_seq OWNER TO rbm;

--
-- Name: inscripciones_idinscripciones_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rbm
--

ALTER SEQUENCE public.inscripciones_idinscripciones_seq OWNED BY public.inscripciones.idinscripcion;


--
-- Name: materias; Type: TABLE; Schema: public; Owner: rbm
--

CREATE TABLE public.materias (
    descripcion character varying,
    cantmax integer,
    idmateria integer NOT NULL
);


ALTER TABLE public.materias OWNER TO rbm;

--
-- Name: materias_idmateria_seq; Type: SEQUENCE; Schema: public; Owner: rbm
--

CREATE SEQUENCE public.materias_idmateria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.materias_idmateria_seq OWNER TO rbm;

--
-- Name: materias_idmateria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rbm
--

ALTER SEQUENCE public.materias_idmateria_seq OWNED BY public.materias.idmateria;


--
-- Name: profesores; Type: TABLE; Schema: public; Owner: rbm
--

CREATE TABLE public.profesores (
    idprofesor integer NOT NULL,
    nombre character varying,
    apellido character varying,
    idmateria integer,
    cedula integer
);


ALTER TABLE public.profesores OWNER TO rbm;

--
-- Name: profesores_idprofesor_seq; Type: SEQUENCE; Schema: public; Owner: rbm
--

CREATE SEQUENCE public.profesores_idprofesor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profesores_idprofesor_seq OWNER TO rbm;

--
-- Name: profesores_idprofesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rbm
--

ALTER SEQUENCE public.profesores_idprofesor_seq OWNED BY public.profesores.idprofesor;


--
-- Name: alumnos idalumno; Type: DEFAULT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.alumnos ALTER COLUMN idalumno SET DEFAULT nextval('public.alumnos_idalumno_seq'::regclass);


--
-- Name: cuota id_cuota; Type: DEFAULT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.cuota ALTER COLUMN id_cuota SET DEFAULT nextval('public.cuota_id_cuota_seq'::regclass);


--
-- Name: inscripciones idinscripcion; Type: DEFAULT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.inscripciones ALTER COLUMN idinscripcion SET DEFAULT nextval('public.inscripciones_idinscripciones_seq'::regclass);


--
-- Name: materias idmateria; Type: DEFAULT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.materias ALTER COLUMN idmateria SET DEFAULT nextval('public.materias_idmateria_seq'::regclass);


--
-- Name: profesores idprofesor; Type: DEFAULT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.profesores ALTER COLUMN idprofesor SET DEFAULT nextval('public.profesores_idprofesor_seq'::regclass);


--
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: rbm
--

COPY public.alumnos (idalumno, nombre, apellido, cedula) FROM stdin;
1	Carlos	Bustamante	\N
2	Rodrigo	Bustamante	\N
4	Matias	Fernandez	\N
5	Alexis	Sanchez	\N
6	Julio	Gonzalez	\N
3	C.Sebastian	Bustamante	\N
\.


--
-- Data for Name: cuota; Type: TABLE DATA; Schema: public; Owner: rbm
--

COPY public.cuota (id_cuota, id_alumno, descripcion, pagado, fecha_pago) FROM stdin;
\.


--
-- Data for Name: inscripciones; Type: TABLE DATA; Schema: public; Owner: rbm
--

COPY public.inscripciones (idinscripcion, idalumno, idprofesor, idmateria, fecha) FROM stdin;
2	3	3	1	\N
4	1	3	1	\N
6	1	4	3	\N
7	3	4	3	\N
8	2	1	2	\N
9	4	4	3	\N
10	5	1	1	\N
11	6	3	1	\N
\.


--
-- Data for Name: materias; Type: TABLE DATA; Schema: public; Owner: rbm
--

COPY public.materias (descripcion, cantmax, idmateria) FROM stdin;
Matematicas	45	1
Ingles	60	2
Sql	50	3
Base	9	4
\.


--
-- Data for Name: profesores; Type: TABLE DATA; Schema: public; Owner: rbm
--

COPY public.profesores (idprofesor, nombre, apellido, idmateria, cedula) FROM stdin;
1	Chapatin	Bonaparte	2	\N
3	Hail	Hitler	1	\N
4	Manuel	Julio	3	\N
5	Bodoke	barrios	\N	999999
\.


--
-- Name: alumnos_idalumno_seq; Type: SEQUENCE SET; Schema: public; Owner: rbm
--

SELECT pg_catalog.setval('public.alumnos_idalumno_seq', 9, true);


--
-- Name: cuota_id_cuota_seq; Type: SEQUENCE SET; Schema: public; Owner: rbm
--

SELECT pg_catalog.setval('public.cuota_id_cuota_seq', 1, false);


--
-- Name: inscripciones_idinscripciones_seq; Type: SEQUENCE SET; Schema: public; Owner: rbm
--

SELECT pg_catalog.setval('public.inscripciones_idinscripciones_seq', 11, true);


--
-- Name: materias_idmateria_seq; Type: SEQUENCE SET; Schema: public; Owner: rbm
--

SELECT pg_catalog.setval('public.materias_idmateria_seq', 7, true);


--
-- Name: profesores_idprofesor_seq; Type: SEQUENCE SET; Schema: public; Owner: rbm
--

SELECT pg_catalog.setval('public.profesores_idprofesor_seq', 5, true);


--
-- Name: alumnos pk_alumnos; Type: CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT pk_alumnos PRIMARY KEY (idalumno);


--
-- Name: cuota pk_idcuota; Type: CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.cuota
    ADD CONSTRAINT pk_idcuota PRIMARY KEY (id_cuota);


--
-- Name: inscripciones pk_inscripcion; Type: CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.inscripciones
    ADD CONSTRAINT pk_inscripcion PRIMARY KEY (idinscripcion);


--
-- Name: materias pk_materias; Type: CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.materias
    ADD CONSTRAINT pk_materias PRIMARY KEY (idmateria);


--
-- Name: profesores pk_profesores; Type: CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT pk_profesores PRIMARY KEY (idprofesor);


--
-- Name: inscripciones uniq_inscripciones; Type: CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.inscripciones
    ADD CONSTRAINT uniq_inscripciones UNIQUE (idalumno, idprofesor, idmateria);


--
-- Name: cuota fk_almuno; Type: FK CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.cuota
    ADD CONSTRAINT fk_almuno FOREIGN KEY (id_alumno) REFERENCES public.alumnos(idalumno);


--
-- Name: inscripciones fk_inscripciones_alumnos; Type: FK CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.inscripciones
    ADD CONSTRAINT fk_inscripciones_alumnos FOREIGN KEY (idalumno) REFERENCES public.alumnos(idalumno);


--
-- Name: inscripciones fk_inscripciones_materias; Type: FK CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.inscripciones
    ADD CONSTRAINT fk_inscripciones_materias FOREIGN KEY (idmateria) REFERENCES public.materias(idmateria);


--
-- Name: inscripciones fk_inscripciones_profesores; Type: FK CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.inscripciones
    ADD CONSTRAINT fk_inscripciones_profesores FOREIGN KEY (idprofesor) REFERENCES public.profesores(idprofesor);


--
-- Name: profesores fk_profesores_materias; Type: FK CONSTRAINT; Schema: public; Owner: rbm
--

ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT fk_profesores_materias FOREIGN KEY (idmateria) REFERENCES public.materias(idmateria);


--
-- PostgreSQL database dump complete
--

