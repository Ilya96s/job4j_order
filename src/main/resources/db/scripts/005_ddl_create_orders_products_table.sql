CREATE TABLE IF NOT EXISTS orders_products
(
    id         SERIAL PRIMARY KEY,
    order_id   INT NOT NULL REFERENCES orders (id),
    product_id INT NOT NULL REFERENCES products (id)
);

comment on table orders_products is 'Таблица для связи заказов и продуктов (многие ко многим)';
comment on column orders_products.id is 'Идентификатор записи';
comment on column orders_products.order_id is 'Идентификатор заказа';
comment on column orders_products.product_id is 'Идентификатор продукта';