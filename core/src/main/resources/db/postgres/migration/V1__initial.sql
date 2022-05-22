create table advert
(
    id          uuid not null,
    address     varchar(255),
    description varchar(255),
    executor_id uuid,
    price       float8,
    title       varchar(255),

    primary key (id)
);
create table appointment
(
    id                    uuid not null,
    appointment_date_time timestamp,
    customer_id           uuid,
    phone_number          varchar(255),
    service_id            uuid,

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