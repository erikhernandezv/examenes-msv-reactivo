CREATE DATABASE examenes-msv-reactivo
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.examen
(
    id integer NOT NULL DEFAULT nextval('examen_id_seq'::regclass),
    nombre character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT examen_pkey PRIMARY KEY (id),
    CONSTRAINT examen_unique UNIQUE (nombre)
        INCLUDE(nombre)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.examen
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.pregunta
(
    id integer NOT NULL DEFAULT nextval('pregunta_id_seq'::regclass),
    nombre character varying COLLATE pg_catalog."default" NOT NULL,
    idexamen integer NOT NULL,
    CONSTRAINT pregunta_pkey PRIMARY KEY (id),
    CONSTRAINT preguntas_fk_examen FOREIGN KEY (idexamen)
        REFERENCES public.examen (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pregunta
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.opcionrespuesta
(
    id integer NOT NULL DEFAULT nextval('opcionrespuesta_id_seq'::regclass),
    opcion character varying COLLATE pg_catalog."default" NOT NULL,
    idpregunta integer NOT NULL,
    CONSTRAINT opcionrespuesta_pkey PRIMARY KEY (id),
    CONSTRAINT opcionrespuesta_fk_pregunta FOREIGN KEY (idpregunta)
        REFERENCES public.pregunta (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.opcionrespuesta
    OWNER to postgres;