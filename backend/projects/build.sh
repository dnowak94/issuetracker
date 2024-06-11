docker compose up -d db
mvn clean spring-boot:build-image
docker compose up -d db projects