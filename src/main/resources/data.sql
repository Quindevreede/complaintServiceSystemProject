
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

INSERT INTO complaint (code, name, commentary) VALUES ('BadCOLOR', 'Dog picture', 'Black is grey, PRINT AGAIN with better ink');
INSERT INTO complaint (code, name, commentary) VALUES ('BadPAPER', 'Family photo', 'Too much ink for paper,PRINT AGAIN with better paper ');
INSERT INTO complaint (code, name, commentary) VALUES ('BadPRINT', 'Car painting', 'Glitch in print, PRINT AGAIN');
INSERT INTO complaint (code, name, commentary) VALUES ('BadMISC', 'Disney art', 'Borders too wide, PRINT AGAIN without borders');
INSERT INTO complaint (code, name, commentary) VALUES ('BadCOLOR', 'Business sticker', 'Ink is running in top left corner, PRINT AGAIN with better ink');


INSERT INTO customers (first_name, last_name, order_nr)
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
/*
INSERT INTO customer_complaint_results (complaint_id, customer_id, date, extra_costs)
VALUES
      ('1', '1', 'now' , 12.22)
     ,('2', '1', 'now', 0.90)
     ,('3', '3', 'now', 0.00)
     ,('4', '4', 'now', 2.88)
     ,('5', '5', 'now', 4);
*/
INSERT INTO production_employees (last_name, production_department, company_phone_number)
VALUES
('de Vreede', 'Posters & Stickers', '201')
     ,('van de Berg', 'Books', '202')
     ,('Meyers', 'Small Prints', '203')
     ,('Ruyters', 'Postcards', '204');

INSERT INTO customer_service_employees (last_name, position, company_phone_number)
VALUES
('van Dongen(M)', 'Head of Service', '101')
     ,('van Dongen(R)', 'Service Representative', '102')
     ,('Wong', 'Phone/Email Representative', '103');

INSERT INTO roles (id,name) VALUES('1','ROLE_USER');
INSERT INTO roles (id,name) VALUES('2','ROLE_ADMIN');
