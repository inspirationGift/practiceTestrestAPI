# create database trade;

use trade;

create table client_type
(
    id int identity
        constraint client_type_pk
            primary key nonclustered,
    name varchar(11) not null
)
go

create unique index client_type_id_uindex
    on client_type (id)
go

INSERT INTO trade.dbo.client_type (name) VALUES ('INTERNAL');
INSERT INTO trade.dbo.client_type (name) VALUES ('EXTERNAL');

create table client
(
    id      int not null,
    type_id int not null
        constraint client_client_type_id_fk
            references client_type,
    name    varchar(77),
    constraint client_pk
        primary key nonclustered (id, type_id)
)
go

INSERT INTO trade.dbo.client (id, type_id, name) VALUES (1, 2, 'knight');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (1, 1, 'bishop');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (2, 2, 'queen');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (2, 1, 'сastling');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (3, 2, 'forking');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (4, 1, 'piece');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (5, 2, 'chessboard');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (5, 1, 'pawn');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (6, 2, 'castle');
INSERT INTO trade.dbo.client (id, type_id, name) VALUES (7, 1, 'king');

create table deal
(
    id          int identity
        constraint deal_pk
            primary key nonclustered,
    volume      float not null,
    date_create datetime,
    type        varchar(2)
)
go

create unique index deal_id_uindex
    on deal (id)
go

INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (99.555, '2021-02-09 16:32:11.000', 'A');
INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (12, '2021-02-02 16:32:14.000', 'B');
INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (0.553, '2021-02-07 16:32:19.000', 'C');
INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (44.4, '2021-02-05 16:32:29.000', '');
INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (0, '2021-02-05 16:32:34.000', 'D');
INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (18, '2021-01-09 16:32:41.000', 'N');
INSERT INTO trade.dbo.deal (volume, date_create, type) VALUES (922.333333333, '2020-02-09 16:32:47.000', 'L');

create table deal_client
(
    deal_id     int not null
        constraint deal_client_deal_id_fk
            references deal,
    client_id   int not null,
    client_type int not null,
    constraint deal_client_pk
        primary key nonclustered (deal_id, client_type, client_id),
    constraint deal_client_client_id_type_fk
        foreign key (client_id, client_type) references client
)
go

INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (1, 1, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (1, 2, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (1, 1, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (1, 2, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (2, 4, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (2, 3, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (2, 5, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (3, 5, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (3, 7, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (3, 5, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (3, 6, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (4, 5, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (4, 7, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (4, 1, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (4, 6, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (5, 1, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (5, 2, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (5, 2, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (6, 4, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (6, 3, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (7, 5, 1);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (7, 5, 2);
INSERT INTO trade.dbo.deal_client (deal_id, client_id, client_type) VALUES (7, 6, 2);

create table invoice
(
    id          int identity
        constraint invoice_pk
            primary key nonclustered,
    date_create datetime not null,
    date_update datetime,
    amount      float,
    deal_id     int      not null
        constraint invoice_deal_id_fk
            references deal
)
go

create unique index invoice_id_uindex
    on invoice (id)
go

INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:46.000', null, 100, 1);
INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:50.000', null, 120, 2);
INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:51.000', null, 200, 3);
INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:53.000', null, 500, 4);
INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:55.000', null, 800, 5);
INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:56.000', null, 200, 6);
INSERT INTO trade.dbo.invoice (date_create, date_update, amount, deal_id) VALUES ('2021-02-09 16:37:57.000', null, 5, 7);

create table payment
(
    id          int identity
        constraint payment_pk
            primary key nonclustered,
    status      int      not null,
    amount      float    not null,
    date_create datetime not null,
    invoice_id  int      not null
        constraint payment_invoice_id_fk
            references invoice
)
go

create unique index payment_id_uindex
    on payment (id)
go

INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (2, 50, '2021-02-09 16:38:36.000', 1);
INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (2, 25, '2021-02-09 16:38:38.000', 1);
INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (3, 25, '2021-02-09 16:38:42.000', 1);
INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (1, 120, '2021-02-09 16:38:55.000', 2);
INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (2, 0.01, '2021-02-09 16:39:25.000', 3);
INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (2, 99.99, '2021-02-09 16:39:27.000', 3);
INSERT INTO trade.dbo.payment (status, amount, date_create, invoice_id) VALUES (2, 120, '2021-02-09 16:39:38.000', 4);

create table payment_status
(
    id   int identity
        constraint payment_status_pk
            primary key nonclustered,
    name varchar(10) not null
)
go

create unique index payment_status_id_uindex
    on payment_status (id)
go

INSERT INTO trade.dbo.payment_status (name) VALUES ('PROCESSING');
INSERT INTO trade.dbo.payment_status (name) VALUES ('ACCEPTED');
INSERT INTO trade.dbo.payment_status (name) VALUES ('REJECTED');
