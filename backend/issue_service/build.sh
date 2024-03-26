docker compose up -d db
mvn clean package
docker build -t issuetracker_issue_service .
docker compose up -d db issues