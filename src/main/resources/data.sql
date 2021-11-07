
INSERT INTO users (username, password, enabled)
VALUES
     ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
    ,('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES
     ('user', 'ROLE_USER')
    ,('admin', 'ROLE_ADMIN');

/*
INSERT INTO customer_details (first_name, last_name, email)
VALUES
      ('John', 'Doe', 'johndoe@hotmail.com')
     ,('Jane', 'Doe', 'janedoe@hotmail.com');

INSERT INTO customer_complaint (order_number, customer_commentary)
VALUES
      ('123', 'qwertyuiop')
     ,('321', 'poiuytrewq');

 */

