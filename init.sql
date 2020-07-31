USE myrooms;
-- Drop Tables
DROP TABLE IF EXISTS Pictures;
DROP TABLE IF EXISTS Rooms;
DROP TABLE IF EXISTS Accounts;

-- Create Tables
create table Accounts (
                          account_id int primary key auto_increment,
                          first_name varchar(128),
                          last_name varchar(128),
                          birth_date date,
                          email varchar(128) unique,
                          username varchar(128) unique,
                          password varchar(128),
                          phone varchar(128) unique
);

create table Rooms (
                        room_id int primary key auto_increment,
                        reserved_start date,
                        reserved_end date,
                        price_per_day int,
                        number_of_beds int,
                        account_id int,
                        img varchar(128),
                        wifi bool,
                        tv bool,
                        hot_water bool,
                        constraint fk_account_id foreign key(account_id) references Accounts(account_id)
);


insert into accounts(first_name, last_name, birth_date, email, username, password, phone) values
-- /password = username(lowercase)
("admin", "admin", "1999-02-12", "admin@gmail.com", "admin", "d033e22ae348aeb5660fc2140aec35850c4da997", "555123456"),
("dimitra", "plexanovski", "1999-09-30", "dimitri@gmail.com", "ditmena", "6f0d3732cab6b6e4d6d79e1e78abc421b5a5a9ba", "599212121"),
("levana", "taqsista", "1998-11-12", "levana@gmail.com", "levanski", "cf1402817dfe0ac6938f82d2764737650b25530f", "599282828"),
("misho", "gordeziani", "1999-01-21", "gordeza@gmail.com", "gordeza", "16a259da86752e98e7dfdb658205ea98ba303243", "555223344"),
("dato", "gogina", "1876-11-11", "gogina@gmail.com", "gogina", "164913103595f38082f1aacd85e17210549ba9d3", "555223314"),
("beber", "beberovichi", "1721-01-11", "beber@gmail.com", "beberi", "51456acf9b0f42692d513df3aedfc15eacdfa4a8", "597223314"),
("nikoloz", "machavariani", "1987-02-12", "machika@gmail.com", "machika", "f371283b99063571609fe56239cc98fd301ebbad", "551123456"),
("beqa", "alibegashvili", "1999-09-07", "beqa@gmail.com", "beqa", "2206664d5d3390714504be01210b4c944b9fd2fd", "599212111"),
("sandro", "elieshvili", "1999-12-21", "sandrika@gmail.com", "sandrika", "b92ff2524ce7c23268c7d1fde906874ec459283d", "597112233");


insert into rooms(price_per_day, img, reserved_start, reserved_end, number_of_beds, account_id, wifi, tv, hot_water) values
(60, "11.jpg", "2020-08-01", "2020-08-10", 2, (select account_id from accounts where username = 'ditmena'), false, true, true),
(80, "21.jpg", "2020-08-05", "2020-08-20", 3, (select account_id from accounts where username = 'levanski'), true, false, true),
(100, "32.jpg", "2020-08-01", "2020-09-10", 2, (select account_id from accounts where username = 'gordeza'), true, true, true),
(80, "42.jpg", "2020-09-05", "2020-10-20", 3, (select account_id from accounts where username = 'gogina'), true, false, true),
(120, "51.jpg", "2020-08-01", "2020-08-20", 2, (select account_id from accounts where username = 'beberi'), true, true, true),
(90, "61.jpg", "2020-08-15", "2020-08-20", 1, (select account_id from accounts where username = 'machika'), true, false, false),
(70, "71.jpg", "2020-08-17", "2020-09-10", 2, (select account_id from accounts where username = 'beqa'), true, true, false),
(40, "81.jpg", "2020-08-02", "2020-08-04", 1, (select account_id from accounts where username = 'sandrika'), false, false, true),
(80, "1.11.jpg", "2020-08-18", "2020-08-16", 2, (select account_id from accounts where username = 'ditmena'), true, true, true),
(70, "1.21.jpg", "2020-08-01", "2020-08-13", 2, (select account_id from accounts where username = 'beqa'), true, true, false),
(40, "1.31.jpg", "2020-08-02", "2020-08-04", 1, (select account_id from accounts where username = 'sandrika'), false, true, true),

(60, "12.jpg", "2020-08-01", "2020-08-10", 2, (select account_id from accounts where username = 'ditmena'), false, true, true),
(80, "22.jpg", "2020-08-05", "2020-08-20", 3, (select account_id from accounts where username = 'levanski'), true, false, true),
(100, "33.jpg", "2020-08-01", "2020-09-10", 2, (select account_id from accounts where username = 'gordeza'), true, true, true),
(80, "43.jpg", "2020-09-05", "2020-10-20", 3, (select account_id from accounts where username = 'gogina'), true, false, true),
(120, "52.jpg", "2020-08-01", "2020-08-20", 2, (select account_id from accounts where username = 'beberi'), true, true, true),
(90, "62.jpg", "2020-08-15", "2020-08-20", 1, (select account_id from accounts where username = 'machika'), true, false, false),
(70, "72.jpg", "2020-08-17", "2020-09-10", 2, (select account_id from accounts where username = 'beqa'), true, true, false),
(40, "82.jpg", "2020-08-02", "2020-08-04", 1, (select account_id from accounts where username = 'sandrika'), false, false, true),
(80, "91.jpg", "2020-08-18", "2020-08-16", 2, (select account_id from accounts where username = 'ditmena'), true, true, true),
(70, "1.22.jpg", "2020-08-01", "2020-08-13", 2, (select account_id from accounts where username = 'beqa'), true, true, false),
(40, "1.32.jpg", "2020-08-02", "2020-08-04", 1, (select account_id from accounts where username = 'sandrika'), false, true, true);




