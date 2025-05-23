-- 개발 시 사용되는 스크립트로 DB 연결 시 사용될 계정, 비밀번호와 일치해야 합니다.

CREATE DATABASE IF NOT EXISTS example;

CREATE USER IF NOT EXISTS 'username'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON example.* TO 'username'@'%';
FLUSH PRIVILEGES;
