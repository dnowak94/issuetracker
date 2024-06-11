INSERT INTO project (id, name, description) VALUES
(1, 'Issuetracker', '<p>This project is an application for tracking issues and tasks of a project.</p>');

INSERT INTO task (id, title, description, status, created_at, updated_at, project_id) VALUES 
(1,'Implement JWT Authentication', '','TODO', NOW(), NOW(), 1),
(2, 'Add Spring Security Configuration', '','TODO',NOW(), NOW(), 1);

INSERT INTO issue (id, title, description, status, created_at, updated_at, project_id) VALUES
(1,'Edit form', '<p>edit form does not initilialize values from backend</p>','UNRESOLVED', NOW(), NOW(), 1);
