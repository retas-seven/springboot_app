CREATE DATABASE mybootapp CHARACTER SET = UTF8;

CREATE USER mybootapp_user IDENTIFIED BY 'mybootapp_user!';

GRANT ALL ON mybootapp.* TO mybootapp_user;
