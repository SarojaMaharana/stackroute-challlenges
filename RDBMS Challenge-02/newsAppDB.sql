create database newsAppDB;

use newsAppDB;

create table users (
user_id varchar(20) primary key,
password varchar(20) not null);

create table userProfile (
user_id varchar(20) primary key,
user_firstName varchar(10) not null,
user_lastName varchar(10) not null,
user_contact bigint,
user_email varchar(30),
user_createdAt datetime not null,
foreign key(user_id) references users(user_id));

create table news (
news_id int primary key,
news_title varchar(50) not null,
news_content text not null,
news_publishedAt datetime not null,
news_createdBy varchar(20) not null,
news_url text,
news_imgUrl text,
foreign key(news_createdBy) references users(user_id));

create table reminders (
reminder_id int primary key,
reminder_scheduledAt datetime not null,
news_id int not null,
foreign key(news_id) references news(news_id));

insert into users values('Jack', 'pass@123');
insert into users values('John', 'something#121');
insert into users values('Kevin', 'test@123');

insert into userProfile values('Jack', 'Jackson', 'James', 8899776655, 'jack@ymail.com', current_timestamp());
insert into userProfile values('John', 'Johnson', 'dsouza', 7869543210, 'john@gmail.com', current_timestamp());
insert into userProfile values('Kevin', 'Kevin', 'Lloyd', 9878685748, 'kevin@gmail.com', current_timestamp());

insert into news values(101, 'IT industry in 2020', 'IT industry was facing disruptive changes in 2019. It is expected to have positive growth in 2020', current_timestamp(), 'Jack', null, null);
insert into news values(102, '2020 FIFA U17 Women World cup', 'The tournament will be held in India between 2 and 21 November 2020. It will mark the first time that India has hosted a FIFA women football tournament.', current_timestamp(), 'Jack', null, null);
insert into news values(103, 'chandrayaan2 spacecraft', 'The Lander of Chandrayaan-2 was named  Vikram after Dr Vikram A Sarabhai, the Father of the Indian Space Programme. It was designed to function for one lunar day.', current_timestamp(), 'John', null, null);
insert into news values(104, 'NEFT transactions to be avliable 24x7', 'Bank customers will be able to transfer funds through NEFT around the clock on all days including weekends and holidays from December 16.', current_timestamp(), 'John', null, null);

insert into reminders values(1, current_timestamp(), 101);
insert into reminders values(2, current_timestamp(), 102);
insert into reminders values(3, current_timestamp(), 104);

select * from userProfile where user_createdAt >= '2019-12-10';

select u.user_id, n.news_id, n.news_title, n.news_content, n.news_publishedAt, n.news_url, n.news_imgUrl
from news n 
join userProfile u 
on n.news_createdBy = u.user_id ;

select * from userProfile where user_id = (select news_createdBy from news where news_id = 103);

select * from userProfile where user_id not in (select news_createdBy from news);

select news_id, news_title from news where news_id in (select news_id from reminders);

select count(*) from news where news_createdBy = 'Jack';
select count(*) from news where news_createdBy = 'John';
select count(*) from news where news_createdBy = 'Kevin';

update userProfile set `user_contact` = 9192939495 where user_id = 'John';

update news set `news_title` = 'IT industry growth can be seen in 2020' where news_id = 101;

delete from reminders where news_id in (select news_id from news where news_createdBy = 'Jack');

insert into reminders values(4, current_timestamp(), 103);