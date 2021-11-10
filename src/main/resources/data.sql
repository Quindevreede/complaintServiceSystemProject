
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

INSERT INTO customer_complaint (order_number, customer_commentary, customer_details_id)
VALUES
    ('123', 'qwertyuiop', 1)
   ,('321', 'poiuytrewq', 1),
    ('Justin Bijlow', 'GK', 1),
    ('Tim Krul', 'GK', 1),
    ('Joël Drommel', 'GK', 1),
    ('Jurriën Timber', 'DF', 2),
    ('Matthijs de Ligt', 'DF', 2);

insert into teams (id, naam, land, jaar)
values
    (1, 'Oranje', 'NL', 2020),
    (2, 'Oranje', 'NL', 2016),
    (3, 'Oranje', 'NL', 2012);

insert into spelers (rugnummer, naam, positie, team_id)
values
    (1, 'Justin Bijlow', 'GK', 1),
    (13, 'Tim Krul', 'GK', 1),
    (23, 'Joël Drommel', 'GK', 1),
    (2, 'Jurriën Timber', 'DF', 2),
    (3, 'Matthijs de Ligt', 'DF', 2),
    (4, 'Virgil van Dijk (captain)', 'DF', 2),
    (5, 'Tyrell Malacia', 'DF', 3);
*/