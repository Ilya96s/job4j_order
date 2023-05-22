CREATE TABLE IF NOT EXISTS products
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

comment on table products is 'Таблица продуктов';
comment on column products.id is 'Идентификатор продукта';
comment on column products.name is 'Название продукта';
