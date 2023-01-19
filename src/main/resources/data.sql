create table if not exists role (
    id bigint not null,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table if not exists role_sq (next_val bigint) engine = InnoDB;

create table if not exists user (
    id bigint not null,
    name varchar(255),
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;

create table if not exists user_roles (
    user_id bigint not null,
    roles_id bigint not null
) engine = InnoDB;

create table if not exists user_sq (next_val bigint) engine = InnoDB;

insert into role_sq values ( 1 );
insert into user_sq values ( 1 )