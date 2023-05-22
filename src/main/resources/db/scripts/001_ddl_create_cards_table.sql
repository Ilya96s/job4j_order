CREATE TABLE IF NOT EXISTS cards
(
    id         SERIAL PRIMARY KEY,
    cardNumber INT NOT NULL UNIQUE
);
comment on table cards is 'Таблица бонусных карт';
comment on column cards.id is 'Идентификатор карты';
comment on column cards.cardNumber is 'Номер карты';