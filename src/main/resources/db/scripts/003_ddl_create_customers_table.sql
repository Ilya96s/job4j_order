CREATE TABLE IF NOT EXISTS customers
(
    id      SERIAL PRIMARY KEY,
    name    TEXT,
    card_id INT NOT NULL REFERENCES cards (id)
);

comment on table customers is 'Таблица заказчиков';
comment on column customers.id is 'Идентификатор заказчика';
comment on column customers.name is 'Имя заказчика';
comment on column customers.card_id is 'Идентификатор карты заказчика';