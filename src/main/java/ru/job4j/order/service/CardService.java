package ru.job4j.order.service;

import ru.job4j.order.model.Card;

import java.util.List;
import java.util.Optional;

/**
 * CardService - интерфейс, описывающий бизнес-логику по работе с бонусными картами
 *
 * @author Ilya Kaltygin
 */
public interface CardService {

    /**
     * Сохранить бонусную карту
     *
     * @param card бонусная карта
     * @return сохраненная бонусная карта
     */
    Card create(Card card);

    /**
     * Получить бонусную карту по идентификатору
     *
     * @param id идентификатор бонусной карты
     * @return Optional.of(card) если бонусная карта найдена, иначе Optional.empty()
     */
    Optional<Card> findById(int id);

    /**
     * Получить список всез бонусных карт
     *
     * @return список бонусных карт
     */
    List<Card> findAll();

    /**
     * Обновить бонусную карту
     *
     * @param card бонусная карта
     * @param id    идентификатор бонусной карты
     * @return true если бонусная карта успешно обновлена, иначе false
     */
    boolean update(Card card, int id);

    /**
     * Удалить бонусную карту
     *
     * @param id идентификатор бонусной карты
     * @return true если бонусная карта успешно удалена, иначе false
     */
    boolean deleteById(int id);
}
