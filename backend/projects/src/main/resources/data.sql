INSERT INTO PROJECT (id, name)
VALUES (1, 'Issuetracker');

INSERT INTO TASK (id, title, description, status, created_at, updated_at, project_id)
VALUES (1,'Implement JWT Authentication', '','TODO', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1),
(2, 'Add Spring Security Configuration', '','TODO',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
