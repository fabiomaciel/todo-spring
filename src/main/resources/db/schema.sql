CREATE TABLE IF NOT EXISTS task (
    id INT PRIMARY KEY auto_increment,
    description VARCHAR(255) NOT NULL,
    completed BOOLEAN NOT NULL
);
