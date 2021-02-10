
INSERT INTO client (id, type_id, name) VALUES (1, 2, 'knight');
INSERT INTO client (id, type_id, name) VALUES (1, 1, 'bishop');
INSERT INTO client (id, type_id, name) VALUES (2, 2, 'queen');
INSERT INTO client (id, type_id, name) VALUES (2, 1, 'сastling');
INSERT INTO client (id, type_id, name) VALUES (3, 2, 'forking');
INSERT INTO client (id, type_id, name) VALUES (4, 1, 'piece');
INSERT INTO client (id, type_id, name) VALUES (5, 2, 'chessboard');
INSERT INTO client (id, type_id, name) VALUES (5, 1, 'pawn');
INSERT INTO client (id, type_id, name) VALUES (6, 2, 'castle');
INSERT INTO client (id, type_id, name) VALUES (7, 1, 'king');

INSERT INTO deal (volume, date_create, type) VALUES (99.555, '2021-02-09 16:32:11.000', 'A');
INSERT INTO deal (volume, date_create, type) VALUES (12, '2021-02-02 16:32:14.000', 'B');
INSERT INTO deal (volume, date_create, type) VALUES (0.553, '2021-02-07 16:32:19.000', 'C');
INSERT INTO deal (volume, date_create, type) VALUES (44.4, '2021-02-05 16:32:29.000', '');
INSERT INTO deal (volume, date_create, type) VALUES (0, '2021-02-05 16:32:34.000', 'D');
INSERT INTO deal (volume, date_create, type) VALUES (18, '2021-01-09 16:32:41.000', 'N');
INSERT INTO deal (volume, date_create, type) VALUES (922.333333333, '2020-02-09 16:32:47.000', 'L');



INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (1, 1, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (1, 2, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (1, 1, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (1, 2, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (2, 4, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (2, 3, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (2, 5, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (3, 5, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (3, 7, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (3, 5, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (3, 6, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (4, 5, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (4, 7, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (4, 1, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (4, 6, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (5, 1, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (5, 2, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (5, 2, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (6, 4, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (6, 3, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (7, 5, 1);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (7, 5, 2);
INSERT INTO deal_client (deal_id, client_id, client_type) VALUES (7, 6, 2);

INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:46.000', null, 100, 1);
INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:50.000', null, 120, 2);
INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:51.000', null, 200, 3);
INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:53.000', null, 500, 4);
INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:55.000', null, 800, 5);
INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:56.000', null, 200, 6);
INSERT INTO invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:57.000', null, 5, 7);

INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (2, 50, '2021-02-09 16:38:36.000', 1);
INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (2, 25, '2021-02-09 16:38:38.000', 1);
INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (3, 25, '2021-02-09 16:38:42.000', 1);
INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (1, 120, '2021-02-09 16:38:55.000', 2);
INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (2, 0.01, '2021-02-09 16:39:25.000', 3);
INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (2, 99.99, '2021-02-09 16:39:27.000', 3);
INSERT INTO payment (status, amount, date_create, invoice_id) VALUES (2, 120, '2021-02-09 16:39:38.000', 4);

-- INSERT INTO payment_status (name) VALUES ('PROCESSING');
-- INSERT INTO payment_status (name) VALUES ('ACCEPTED');
-- INSERT INTO payment_status (name) VALUES ('REJECTED');

-- INSERT INTO client_type (name) VALUES ('INTERNAL');
-- INSERT INTO client_type (name) VALUES ('EXTERNAL');
