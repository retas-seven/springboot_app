CREATE USER mybootapp_user WITH PASSWORD 'mybootapp_user' SUPERUSER;

CREATE DATABASE mybootapp OWNER = mybootapp_user TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';
