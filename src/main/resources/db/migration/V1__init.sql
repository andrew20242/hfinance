
create table account (
	id integer primary key,
	name varchar(255), 
	type varchar(255)
);

insert into account(name,type) values ('Freelance', 'income');
insert into account(name,type) values ('Food', 'outcome');
insert into account(name,type) values ('bank card A', 'both');
insert into account(name,type) values ('bank card B', 'both');
insert into account(name,type) values ('Sport', 'outcome');

