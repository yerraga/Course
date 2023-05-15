insert into course (id, name) values (1001, 'Jpa Repository in 50 steps');
insert into course (id, name) values (1002, 'SpringBoot in 50 steps');
insert into course (id, name) values (1003, 'Java in 50 steps');
insert into course (id, name) values (1004, 'Microservices in 50 steps');

insert into Passport (id, number) values (3001, 'L178375');
insert into Passport (id, number) values (3002, 'E598762');
insert into Passport (id, number) values (3003, 'R963214');
insert into Passport (id, number) values (3004, 'G852146');

insert into Student (id, name, passport_id) values (2001, 'Ganesh', 3001);
insert into Student (id, name, passport_id) values (2002, 'Sunil', 3002);
insert into Student (id, name, passport_id) values (2003, 'Anasuyamma', 3003);
insert into Student (id, name, passport_id) values (2004, 'Narashimha Reddy', 3004);

insert into Review (id, rating, description, course_id) values (4001, '4', 'Awsome course', 1001);
insert into Review (id, rating, description, course_id) values (4002, '4.5', 'Excellent course', 1002);
insert into Review (id, rating, description, course_id) values (4003, '5', 'Over the top course', 1003);
insert into Review (id, rating, description, course_id) values (4004, '4.5', 'Awsome course', 1004);

insert into student_course (student_id, course_id) values (2001, 1003);
insert into student_course (student_id, course_id) values (2002, 1003);
insert into student_course (student_id, course_id) values (2003, 1003);
insert into student_course (student_id, course_id) values (2004, 1002);