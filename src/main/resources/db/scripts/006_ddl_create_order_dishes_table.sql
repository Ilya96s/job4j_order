CREATE TABLE IF NOT EXISTS order_dishes
(
    id       SERIAL PRIMARY KEY,
    order_id INT NOT NULL REFERENCES orders (id),
    dish_id  INT NOT NULL
);
comment on table order_dishes is 'Таблица для хранения идентификаторов блюд заказа';
comment on column order_dishes.id is 'Идентификатор записи';
comment on column order_dishes.order_id is 'Идентификатор заказа';
comment on column order_dishes.dish_id is 'Идентификатор блюда';