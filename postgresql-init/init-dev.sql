-- 개발 시 사용되는 스크립트로 DB 연결 시 사용될 계정, 비밀번호와 일치해야 합니다.

-- 1. 데이터베이스 생성
CREATE DATABASE example;

-- 2. 유저 생성
CREATE USER username WITH PASSWORD 'password';

-- 3. 권한 부여 (데이터베이스 존재함)
GRANT CONNECT ON DATABASE example TO username;

-- 4. DB 접속 후, 스키마 존재 확인 or 생성
-- (public 스키마는 기본 생성됨)

-- 5. ALTER DEFAULT PRIVILEGES 실행 (스키마 존재 전제)
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO username;
