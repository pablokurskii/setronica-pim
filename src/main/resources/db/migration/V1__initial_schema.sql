create table product
(
    id   bigserial not null primary key,
    name text not null,
    description text,
    prices text not null,
    created_date bigserial not null,
    modified_date bigserial not null
);

