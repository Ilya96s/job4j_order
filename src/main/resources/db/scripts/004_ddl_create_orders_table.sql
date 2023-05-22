CREATE TABLE IF NOT EXISTS orders
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    status      TEXT NOT NULL,
    customer_id INT REFERENCES customers (id)
);

comment on table orders is 'Таблица заказов';
comment on column orders.id is 'Идентификатор заказа';
comment on column orders.name is 'Название заказа';
comment on column orders.status is 'Статус заказа';
comment on column orders.customer_id is 'Идентификатор заказчика';