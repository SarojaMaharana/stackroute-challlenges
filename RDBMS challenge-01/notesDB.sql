create database notesDB;

use notesDB;

create table users (
user_id varchar(20) primary key,
user_name varchar(20) not null,
user_added_date date not null,
user_password varchar(10) not null,
user_mobile bigint);

create table notes (
note_id int primary key,
note_title varchar(30) not null,
note_content text not null,
note_status boolean,
note_creation_date date not null);

create table userNote (
usernote_id int primary key,
user_id varchar(20) not null,
note_id int not null,
foreign key(note_id) references notes(note_id),
foreign key(user_id) references users(user_id));

create table categories (
category_id int primary key,
category_name varchar(20) not null,
category_descr text not null,
category_creation_date date not null,
category_creator varchar(20) not null,
foreign key(category_creator) references users(user_id));

create table noteCategory (
notecategory_id int primary key,
note_id int not null,
category_id int not null,
foreign key(note_id) references notes(note_id),
foreign key(category_id) references categories(category_id));

create table reminders (
reminder_id int primary key,
reminder_name varchar(20) not null,
reminder_descr text not null,
reminder_type varchar(20) not null,
reminder_creation_date date not null,
reminder_creator varchar(20) not null,
foreign key(reminder_creator) references users(user_id));

create table noteReminder (
notereminder_id int primary key,
note_id int not null,
reminder_id int not null,
foreign key(note_id) references notes(note_id),
foreign key(reminder_id) references reminders(reminder_id));

insert into users values('Murphy', 'Murphy', current_date(), '1234567', null);
insert into users values('Patterson', 'Patterson', current_date(), '1234567', null);
insert into users values('Firrelli', 'Firrelli', current_date(), '1234567', null);
insert into users values('Bondur', 'Bondur', current_date(), '1234567', null);
insert into users values('Bow', 'Bow', current_date(), '1234567', null);
insert into users values('Jennings', 'Jennings', current_date(), '1234567', null);

insert into notes values(51, 'IT industry in 2020', 'IT industry was facing disruptive changes in 2019. It is expected to have positive growth in 2020', true, current_date());
insert into notes values(52, '2020 FIFA U17 Women World cup', 'The tournament will be held in India between 2 and 21 November 2020. It will mark the first time that India has hosted a FIFA women football tournament.', true, current_date());
insert into notes values(53, 'chandrayaan2 spacecraft', 'The Lander of Chandrayaan-2 was named  Vikram after Dr Vikram A Sarabhai, the Father of the Indian Space Programme. It was designed to function for one lunar day.', true, current_date());
insert into notes values(54, 'NEFT transactions', 'Bank customers will be able to transfer funds through NEFT around the clock on all days including weekends and holidays from December 16.', true, current_date());
insert into notes values(55, 'IT industry in 2020', 'IT industry was facing disruptive changes in 2019. It is expected to have positive growth in 2020', true, current_date());
insert into notes values(56, '2020 FIFA U17 Women World cup', 'The tournament will be held in India between 2 and 21 November 2020. It will mark the first time that India has hosted a FIFA women football tournament.', true, current_date());
insert into notes values(57, 'chandrayaan2 spacecraft', 'The Lander of Chandrayaan-2 was named  Vikram after Dr Vikram A Sarabhai, the Father of the Indian Space Programme. It was designed to function for one lunar day.', true, current_date());
insert into notes values(58, 'NEFT transactions', 'Bank customers will be able to transfer funds through NEFT around the clock on all days including weekends and holidays from December 16.', true, current_date());

insert into userNote values(1, 'Bondur', 52);
insert into userNote values(2, 'Firrelli', 51);
insert into userNote values(3, 'Bow', 53);
insert into userNote values(4, 'Jennings', 54);

insert into categories values(201, 'IT', 'about it industry', current_date(), 'Firrelli');
insert into categories values(202, 'Sports', 'about sports', current_date(), 'Bondur');
insert into categories values(203, 'Space', 'about space', current_date(), 'Bow');
insert into categories values(204, 'Banking', 'about banking', current_date(), 'Jennings');

insert into noteCategory values(1, 51, 201);
insert into noteCategory values(2, 52, 202);
insert into noteCategory values(3, 53, 203);
insert into noteCategory values(4, 54, 204);

insert into reminders values(251, 'Bank', 'update on NEFT transaction rules', 'alarm', current_date(), 'Jennings');
insert into reminders values(252, 'Sports', 'update on 2020 FIFA U17 Women World cup', 'alarm', current_date(), 'Bondur');

insert into noteReminder values(1, 54, 251);
insert into noteReminder values(2, 52, 252);



select * from users where user_id = 'Patterson' and user_password = '1234567';

select * from notes where note_creation_date = '2020-11-26';

select * from categories where category_creation_date >='2020-11-26';

select note_id from userNote where user_id='Firrelli';

UPDATE notes
SET
`note_title` = '2020 FIFA U17 Women World Cup'
WHERE `note_id` = 52;

select * from notes where note_id in (select note_id from userNote where user_id = 'Bow');

select * from notes where note_id in (select note_id from noteCategory where category_id = 203);

select * from reminders where reminder_id in (select reminder_id from noteReminder where note_id = 52);

select * from reminders where reminder_id = 251;

set autocommit = 0;
insert into notes values (59, 'chandrayaan2 spacecraft', 'The Lander of Chandrayaan-2 was named  Vikram after Dr Vikram A Sarabhai, the Father of the Indian Space Programme. It was designed to function for one lunar day.', true, current_date());
insert into userNote values(5, 'Murphy', 59);
commit;

set autocommit = 0;
insert into notes values (60, 'Html5', 'html is a front end website development language', true, current_date());
insert into userNote values(6, 'Patterson', 60);
insert into noteCategory values(5, 60, 201);
commit;

set autocommit = 0;
insert into reminders values(253, 'html', 'read page no. 375 frm the book', 'alarm', current_date(), 'Patterson');
insert into noteReminder values(3, 60, 253);
commit;

set autocommit = 0;
drop table if exists temp;
create temporary table temp select note_id from userNote where user_id = 'Patterson';
delete from userNote where note_id in (select * from temp);
delete from noteCategory where note_id in (select * from temp);
delete from noteReminder where note_id in (select * from temp);
delete from notes where note_id in (select * from temp);
drop table if exists temp;
commit;

set autocommit = 0;
drop table if exists temp;
create temporary table temp select note_id from noteCategory where category_id = 204;
delete from noteCategory where note_id in (select * from temp);
delete from userNote where note_id in (select * from temp);
delete from noteReminder where note_id in (select * from temp);
delete from notes where note_id in (select * from temp);
drop table if exists temp;
commit;

delimiter //
create trigger delete_note
before delete on notes
for each row
begin
    set @temp_note_id = old.note_id;
    delete from userNote where note_id = @temp_note_id;
    delete from noteCategory where note_id = @temp_note_id;
    delete from noteReminder where note_id = @temp_note_id;
end; //

delimiter ;

delimiter //
create trigger delete_user
before delete on users
for each row
begin
	set @temp_user_id = old.user_id;
	create temporary table temp_note_ids select note_id from userNote where user_id = @temp_user_id;
    delete from userNote where note_id in (select * from temp_note_ids);
    delete from noteCategory where note_id in (select * from temp_note_ids);
    delete from noteReminder where note_id in (select * from temp_note_ids);
    delete from notes where note_id in (select * from temp_note_ids);
    delete from categories where category_creator = @temp_user_id;
    delete from reminders where reminder_creator = @temp_user_id;
end;
//

delete from notes where note_id = 52;
delete from users where user_id = 'Murphy';