create table if not exists users (
    id serial primary key,
    username varchar(50) unique not null,
    password varchar(255) not null,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(100) unique not null,
    phone varchar(50),
    is_enabled boolean not null,
    is_account_non_locked boolean not null,
    is_account_non_expired boolean not null,
    is_credentials_non_expired boolean not null
);

create table if not exists authorities(
    id serial primary key,
    user_id bigint not null,
    name varchar(25) not null,
    foreign key (user_id) references users(id)
);

create table if not exists files (
    id serial primary key,
    user_id bigint not null,
    file_name varchar(255) not null,
    file_type varchar(25) not null,
    parent_id bigint not null,
    child_id bigint not null,
    foreign key(user_id) references users (id),
    foreign key(parent_id) references files (id),
    foreign key(child_id) references files (id)
);

create table if not exists acl(
    id serial not null,
    user_id bigint not null,
    file_id bigint not null,
    foreign key(user_id) references users(id),
    foreign key(file_id) references files(id)
);