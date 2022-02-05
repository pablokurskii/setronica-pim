create table product
(
    id   bigserial not null primary key,
    name varchar(50) not null,
    description varchar(50),
    price float8 not null,
    currency varchar(50) not null,
    created_date bigserial not null,
    modified_date bigserial not null
);

