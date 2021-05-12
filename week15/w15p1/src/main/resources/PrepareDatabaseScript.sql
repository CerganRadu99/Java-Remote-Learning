CREATE TABLE IF NOT EXISTS event(
id INT PRIMARY KEY,
start_date_time DATETIME,
end_date_time DATETIME,
summary VARCHAR(45),
location VARCHAR(45)
) ENGINE = INNODB;
INSERT INTO mydb.event(id, start_date_time, end_date_time, summary, location) VALUES(1, '2021-05-15 15:30:00', '2018-04-25 17:00:00', 'Remote Learning meeting1', 'Somesului nr 14');
INSERT INTO mydb.event(id, start_date_time, end_date_time, summary, location) VALUES(2, '2018-02-23 12:30:00', '2018-04-25 17:00:00', 'Remote Learning meeting2', 'Somesului nr 13');
INSERT INTO mydb.event(id, start_date_time, end_date_time, summary, location) VALUES(3, '2018-04-22 15:30:00', '2018-04-25 17:00:00', 'Remote Learning meeting3', 'Somesului nr 12');
INSERT INTO mydb.event(id, start_date_time, end_date_time, summary, location) VALUES(4, '2021-05-16 15:30:00', '2018-04-25 17:00:00', 'Remote Learning meeting4', 'Somesului nr 11');
INSERT INTO mydb.event(id, start_date_time, end_date_time, summary, location) VALUES(5, '2018-02-20 15:30:00', '2018-04-25 17:00:00', 'Remote Learning meeting5', 'Somesului nr 10');
SELECT * FROM mydb.event