CREATE TABLE todo (
    id SERIAL PRIMARY KEY ,
    user_id INT NOT NULL,
    task VARCHAR(1000) NOT NULL,
    completed BOOLEAN NOT NULL,
    created_at timestamp,
    updated_at timestamp
);

INSERT INTO todo (user_id, task, completed, created_at, updated_at)
VALUES (1, 'One Commit to Git', false, NOW(), NOW()),
       (1, 'Solve Algorithm problem', false, NOW(), NOW()),
       (1, 'Reading Books', true, NOW(), NOW()),
       (1, 'Create new toy project', false, NOW(), NOW());
