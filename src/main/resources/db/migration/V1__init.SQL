create table if not exists users (
    id serial primary key,
    username varchar(50) unique not null,
    password varchar(255) not null,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(100) unique not null,
    phone varchar(50)
);

create table if not exists files (
    id serial primary key,
    user_id bigint not null,
    filename varchar(255) not null,
    fileType varchar(25) not null,
    parentId bigint not null,
    childId bigint not null,
    foreign key(user_id) references users (id),
    foreign key(parentId) references files (id),
    foreign key(childId) references files (id)
);

create table if not exists acl(
    id serial not null,
    user_id bigint not null,
    file_id bigint not null,
    foreign key(user_id) references users(id),
    foreign key(file_id) references files(id),
);