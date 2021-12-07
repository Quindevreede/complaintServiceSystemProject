
INSERT INTO users (username, password, enabled)
VALUES
     ('customer', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
    ,('production', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
    ,('assist', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE)
    ,('management', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES
     ('customer', 'ROLE_USER')
    ,('production', 'ROLE_ADMIN')
    ,('assist', 'ROLE_ADMIN')
    ,('management', 'ROLE_ADMIN');

INSERT INTO customer_details (id, username, first_name, last_name, email)
VALUES
      (6, 'customer', 'Jane', 'Doe', 'janedoe@hotmail.com');

INSERT INTO upload (id, title, description, order_number_upload, uploaded_by_username)
VALUES
    (6, 'titleOfFile', 'descriptionOfFile', '123', 'customer');

INSERT INTO receipt_upload (id, ordernumber)
VALUES
    (6, '123');

INSERT INTO production_complaint (id, assisted_by, production_department, production_commentary)
VALUES
    (123, 'James', 'Posters&Stickers', 'Can print with better colours, no extra costs');

INSERT INTO assist_complaint (id, assisted_by, assist_department, assist_commentary, extra_costs, invoice_link)
VALUES
    (123, 'James', 'Posters&Stickers', 'print can be fixed and ready by monday, no extra costs', 0.00, '6');

INSERT INTO customer_reply (id, reprint_or_refund, customer_commentary)
VALUES
    (123, 'REPRINT', 'Great, pay extra attention to red colours please');

INSERT INTO customer_complaint (id, username, order_number, customer_commentary, customer_details_id, upload_id, receipt_upload_id, production_complaint_id, assist_complaint_id, customer_reply_id)
VALUES
    (6, 'customer', '123', 'colours are faded', 6, 6, 6, 123, 123,123);