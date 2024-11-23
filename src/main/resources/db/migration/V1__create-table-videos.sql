create table videos(
    id bigint not null auto_increment,
    title varchar(100) not null,
    description varchar(200) not null,
    url varchar(100) not null unique,

    primary key(id)
);