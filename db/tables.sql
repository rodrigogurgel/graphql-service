create table "user"
(
    id         uuid primary key,
    name       text unique not null,
    created_at timestamptz not null,
    updated_at timestamptz not null
);

create table pet
(
    id         uuid primary key,
    user_id    uuid        not null,
    name       text        not null,
    pet_type   text        not null,
    created_at timestamptz not null,
    updated_at timestamptz not null
);

alter table pet
    add foreign key (user_id) references "user" (id);