-- public.peminjam definition

-- Drop table

-- DROP TABLE public.peminjam;

CREATE TABLE public.peminjam (
	no_ktp varchar(255) NOT NULL,
	email varchar(255) NULL,
	nama varchar(255) NULL,
	CONSTRAINT peminjam_pkey PRIMARY KEY (no_ktp),
	CONSTRAINT ukhdeguq9ri7cwjnejfsa77xe5k UNIQUE (email)
);