INSERT INTO roles VALUES (1, 'USER');
INSERT INTO roles VALUES (2, 'CHEF');
INSERT INTO users VALUES (100, true, 'student', '$2a$10$HQQAtZiOTIT0TnNj0Qw6ceeqHcR8vgcyrnzW84sMV2cyuEfldbfby');
INSERT INTO users VALUES (200, true, 'chef', '$2a$10$HQQAtZiOTIT0TnNj0Qw6ceeqHcR8vgcyrnzW84sMV2cyuEfldbfby');
INSERT INTO user_role VALUES (100, 1);
INSERT INTO user_role VALUES (200, 1);
INSERT INTO user_role VALUES (200, 2);

INSERT INTO recipes VALUES (1, 100, 'Description', 'Breakfast', 10);
INSERT INTO recipes VALUES (2, 100, 'Description', 'Burger', 10);
INSERT INTO recipes VALUES (3, 100, 'Description', 'Pancakes', 10);
INSERT INTO recipes VALUES (4, 100, 'Description', 'Curry', 10);

INSERT INTO ingredients VALUES (1, 1, 'Test', 1);
INSERT INTO ingredients VALUES (2, 1, 'Test', 2);
INSERT INTO ingredients VALUES (3, 1, 'Test', 3);
INSERT INTO ingredients VALUES (4, 1, 'Test', 4);
