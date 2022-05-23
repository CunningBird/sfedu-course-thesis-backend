create table advert
(
    id          uuid not null,

    executor_id uuid,

    title       varchar(255),
    price       float8,
    address     varchar(255),
    description varchar(255),
    image       varchar(255),

    primary key (id)
);

create table appointment
(
    id                    uuid not null,

    advert_id             uuid,
    customer_id           uuid,
    executor_id           uuid,

    appointment_date_time timestamp,

    primary key (id)
);
create table chat
(
    id          uuid not null,

    executor_id uuid,
    user_id     uuid,

    primary key (id)
);
create table message
(
    id             uuid not null,
    author_id      uuid,
    chat_id        uuid,

    sent_date_time timestamp,
    text           varchar(255),

    primary key (id)
);