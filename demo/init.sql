BEGIN;
--new Film(1,"1+1",2011, "Иногда вы должны заглянуть в чужой мир, чтобы узнать, чего не хватает в своём",
--                        "драма, комедия"),
--                new Film(2,"Форрест Гамп", 1994, "Мир уже никогда не будет прежним, после того как вы увидите его глазами Форреста Гампа",
--                        "драма, комедия, мелодрама, история, военный"),
--                new Film(3,"Остров проклятых", 2009, "Некоторые места никогда не отпустят тебя", "."),
--                new Film(4,"Легенда", 2015, "Преступление – как профессия. Взлет и падение легендарных близнецов Крэй", "криминал, триллер, драма"),
--                new Film(5,"Синистер", 2012, "Увидевший его не спасётся","ужасы"),
--                new Film(6,"Шоу Трумана", 1998, "Он в прямом эфире и даже не подозревает...", "драма, комедия"),
--                new Film(7,"Начало", 2010, "Твой разум - место преступления","фантастика, боевик, триллер, драма, детектив"),
--                new Film(8,"Оппенгеймер", 2023, "-", "биография, драма, история"),
--                new Film(9,"Довод", 2020, "Время уходит", "фантастика, боевик, триллер"),
--                new Film(10,"Исходный код", 2011, "Считай каждую секунду", "фантастика, боевик, триллер, драма"),
--                new Film(11,"Социальная сеть", 2010, "Нельзя завести 500 миллионов друзей, не нажив ни одного врага", "драма, биография")
--
DROP TABLE IF EXISTS film_info CASCADE;
CREATE TABLE film_info (id bigserial PRIMARY KEY, name VARCHAR(255), year VARCHAR(255));
INSERT INTO film_info (name, year) VALUES
('1+1', '2011'),
('Шоу Трумана', '1998'),
('Синистер', '2012');

DROP TABLE IF EXISTS geners CASCADE;
CREATE TABLE geners (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO geners (name) VALUES
('драма, комедия'),
('ужасы');

DROP TABLE IF EXISTS groups CASCADE;
CREATE TABLE groups (id bigserial PRIMARY KEY, number bigint);
INSERT INTO groups (number) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8);

DROP TABLE IF EXISTS films CASCADE;
CREATE TABLE films (id bigserial PRIMARY KEY, name VARCHAR(255), slogan bigint, info_id bigint, gener_id bigint, FOREIGN KEY (info_id) REFERENCES film_info(id), FOREIGN KEY (film_id) REFERENCES films(id));
INSERT INTO films (name, slogan, info_id, gener_id) VALUES
('1+1', 'Иногда вы должны заглянуть в чужой мир, чтобы узнать, чего не хватает в своём', 1, 1),
('Шоу Трумана', 'Он в прямом эфире и даже не подозревает...', 2, 1),
('Синистер', 'Увидевший его не спасётся', 3, 2);

DROP TABLE IF EXISTS groups_films CASCADE;
CREATE TABLE groups_films (group_id bigint, film_id bigint, FOREIGN KEY (film_id) REFERENCES groups (id), FOREIGN KEY (film_id) REFERENCES films (id));
INSERT INTO groups_films (group_id, film_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 2),
(3, 2),
(7, 2),
(8, 3),
(1, 3),
(2, 3);

COMMIT;