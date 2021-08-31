create table employees(
    id serial primary key not null,
    name varchar(200),
    surname varchar(200),
    UNN varchar(10),
    hiring_date TIMESTAMP
);
create table person (
                        id serial primary key not null,
                        login varchar(2000),
                        password varchar(2000),
                        employee_id int REFERENCES employees(id)
);


insert into employees(name, surname, UNN, hiring_date) VALUES ('alex', 'zel','123456789','2021-08-31');

insert into person (login, password, employee_id) values ('parsentev', '123', 1);
insert into person (login, password, employee_id) values ('ban', '123', 1);
insert into person (login, password, employee_id) values ('ivan', '123', 1);