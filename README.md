# Getting Started

To successfully run this application Postgres database is required.
You should use the deafult port 5455 and you should also create a 'test_db' database.
You can find connection details in application.yml.

You can simply start this app from your IDE or by running `gradle bootRun`.

For more information and help please contact Tomasz Więcław.

## How to run Docker instance localy
1. Copy docker compose file e.g. to `~\Downloads` https://github.com/tomaszwieclaw/enter-the-zone-backend/blob/main/docker-compose.yaml
2. Open CMD in the `~\Downloads`
3. Run command `docker compose up -d`
4. Application server should be available by link : http://localhost:7070
