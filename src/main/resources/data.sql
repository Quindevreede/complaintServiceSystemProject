
INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('quin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customerService', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('production', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('management', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('quin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('quin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('customer', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('customerService', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('customerService', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('production', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('production', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('management', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('management', 'ROLE_ADMIN');

INSERT INTO complaint (code, name, commentary ) VALUES ('BadCOLOR', 'someKindOfNameHere?', 'qwertyp');
INSERT INTO complaint (code, name, commentary) VALUES ('BadPAPER', 'KindOfNameTHere?', 'asdf');

INSERT INTO customers (first_name, last_name, customer_nr)
VALUES
      ('Tom', 'de Boer', '345674')
     ,('Yassine', 'Azdad', '123124')
     ,('Debby', 'Huismans', '452235')
     ,('Jay', 'Richardson', '467892')
     ,('Maninder', 'Singh', '745631')
     ,('Ilias', 'al Gris', '928345')
     ,('Eghbol', 'Sarwar', '372940')
     ,('Bart', 'Heijenk', '344611')
     ,('Quincy', 'Soerkarso', '946389')
     ,('Asare', 'Twum', '329573');

INSERT INTO customer_complaint_results (complaint_id, customer_id, date)
VALUES
      ('1', '1', '2020-10-10')
     ,('1', '2', '2020-10-10')
     ,('1', '3', '2020-10-10')
     ,('2', '1', '2020-10-15')
     ,('2', '3', '2020-10-15')
     ,('2', '4', '2020-10-15')
     ,('2', '5', '2020-10-15');