CREATE TABLE account (
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(50) UNIQUE NOT NULL ,
    email VARCHAR(50) UNIQUE NOT NULL ,
    password VARCHAR(120) ,
    first_name VARCHAR(50) ,
    last_name VARCHAR(50) ,
    is_active BOOLEAN NOT NULL ,
    created_at timestamp ,
    updated_at timestamp
);

CREATE TABLE todo (
    id BIGSERIAL PRIMARY KEY ,
    account_id BIGINT NOT NULL ,
    task VARCHAR(1000) NOT NULL ,
    completed BOOLEAN NOT NULL ,
    created_at timestamp ,
    updated_at timestamp
);

INSERT INTO account (username, email, password, first_name, last_name, is_active, created_at, updated_at)
VALUES ('user1', 'user1@temp.com', '$2a$10$dyCNAiQWruiRxoYcf.moMuyYApu3htePyG2EGOzbtKmsy0i/Iz4k2', 'User', 'Doe', true, NOW(), NOW()),
       ('user2', 'user2@temp.com', '$2a$10$dyCNAiQWruiRxoYcf.moMuyYApu3htePyG2EGOzbtKmsy0i/Iz4k2', 'User2', 'Doe', true, NOW(), NOW());

INSERT INTO todo (account_id, task, completed, created_at, updated_at)
VALUES (1, 'One Commit to Git', false, NOW(), NOW()),
       (1, 'Solve Algorithm problem', false, NOW(), NOW()),
       (1, 'Reading Books', true, NOW(), NOW()),
       (1, 'Create new toy project', false, NOW(), NOW());
