# security-jwt-template
Spring Security + JWT 통합 설정 템플릿


## 🛠 필수 수정 파일 및 항목

| 파일 경로 | 수정 위치 | 설명 |
|-----------|-----------|------|
| `/src/main/resources/application-example.yml` | `spring.application.name` | 어플리케이션 이름을 프로젝트에 맞게 수정해야 합니다. |
| `/src/main/resources/application-secret-example.yml` | `schema.base` | 사용할 데이터베이스 스키마명을 `.env.common`의 `DATABASE=`에서 설정해야 합니다. |
| 〃 | `spring.datasource.url`, `username`, `password` | 사용하는 DB 종류(MySQL, PostgreSQL 등)에 따라 주석을 해제하고, 해당 값들은 `.env.local` 또는 `.env.prod`에서 설정해야 합니다. |
| `.env.common` | `DATABASE` | 사용할 데이터베이스 스키마명을 입력해야 합니다. |
| 〃 | `JWT_SECRET_KEY` | JWT 서명을 위한 비밀 키를 반드시 입력해야 합니다. |
| `.env.local` | `SPRING_DATASOURCE_URL_MYSQL`, `SPRING_DATASOURCE_URL_POSTGRESQL`, `SPRING_DATASOURCE_URL_H2` | URL 내 `example`이라는 DB 이름을 실제 사용하는 DB 이름으로 수정해야 합니다. |
| 〃 | `SPRING_DATASOURCE_USERNAME_MYSQL`, `SPRING_DATASOURCE_PASSWORD_MYSQL` | 로컬 MySQL 사용자명과 비밀번호를 입력해야 합니다. |
| 〃 | `SPRING_DATASOURCE_USERNAME_POSTGRESQL`, `SPRING_DATASOURCE_PASSWORD_POSTGRESQL` | 로컬 PostgreSQL 사용자명과 비밀번호를 입력해야 합니다. |
| 〃 | `SPRING_DATASOURCE_USERNAME_H2`, `SPRING_DATASOURCE_PASSWORD_H2` | 로컬 H2 DB 사용자명과 비밀번호를 입력해야 합니다. |
| `.env.prod` | `SPRING_DATASOURCE_USERNAME_MYSQL`, `SPRING_DATASOURCE_PASSWORD_MYSQL`, `MYSQL_ROOT_PASSWORD` | 운영 MySQL 사용자명, 비밀번호, 루트 비밀번호를 반드시 입력해야 합니다. |
| 〃 | `SPRING_DATASOURCE_USERNAME_POSTGRESQL`, `SPRING_DATASOURCE_PASSWORD_POSTGRESQL` | 운영 PostgreSQL 사용자명과 비밀번호를 입력해야 합니다. |


---



> 🔥 모든 민감한 값은 Git에 커밋되지 않도록 `.gitignore` 파일을 확인하세요.



