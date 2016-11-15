insert into firm(id ,name) values ('1','Osram');
insert into firm(id, name) values ('2','Philips');

insert into employee(id, name, surname, post, age, firm_id ) VALUES ('1','Jan', 'Kowlaski', 'menager', '12', '1');
insert into employee(id, name, surname, post, age, firm_id ) VALUES ('2','Adam', 'Nowak', 'worker', '22', '1');
insert into employee(id, name, surname, post, age, firm_id ) VALUES ('3','Marek', 'Wojcik', 'worker', '32', '2');
insert into employee(id, name, surname, post, age, firm_id ) VALUES ('4','Krzysztof', 'Borkowski', 'worker', '42', '2');
insert into employee(id, name, surname, post, age, firm_id ) VALUES ('5','Piotr', 'Kapela', 'worker', '52', '1');

INSERT INTO day(id, day, status) VALUES ('1', '2001-01-01','close');
INSERT INTO day(id, day, status) VALUES ('2', '2002-02-02','open');
INSERT INTO day(id, day, status) VALUES ('3', '2003-03-03','open');
INSERT INTO day(id, day, status) VALUES ('4', '2004-04-04','open');

INSERT INTO reportedTerm(beginTime, endTime, employee_id, day_id) VALUES ('08:00:00', '16:00:00', '1', '1');
INSERT INTO reportedTerm(beginTime, endTime, employee_id, day_id) VALUES ('08:00:00', '16:00:00', '2', '2');
INSERT INTO reportedTerm(beginTime, endTime, employee_id, day_id) VALUES ('08:00:00', '16:00:00', '3', '3');
INSERT INTO reportedTerm(beginTime, endTime, employee_id, day_id) VALUES ('08:00:00', '16:00:00', '4', '4');