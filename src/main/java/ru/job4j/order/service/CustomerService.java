package ru.job4j.order.service;

import ru.job4j.order.model.Customer;

import java.util.List;
import java.util.Optional;

/**
 * CustomerService - интерфейс, описывающий бизнес-логику по работе с заказчиками
 *
 * @author Ilya Kaltygin
 */
public interface CustomerService {

    /**
     * Сохранить заказчика
     *
     * @param customer заказчик
     * @return сохраненная заказчик
     */
    Customer create(Customer customer);

    /**
     * Получить заказчика по идентификатору
     *
     * @param id идентификатор заказчика
     * @return Optional.of(customer) если заказчик найден, иначе Optional.empty()
     */
    Optional<Customer> findById(int id);

    /**
     * Получить список всех заказчиков
     *
     * @return список заказчиков
     */
    List<Customer> findAll();

    /**
     * Обновить заказчика
     *
     * @param customer заказчик
     * @param id    идентификатор заказчика
     * @return true если заказчик успешно обновлен, иначе false
     */
    boolean update(Customer customer, int id);

    /**
     * Удалить заказчика
     *
     * @param id идентификатор заказчика
     * @return true если заказчик успешно удален, иначе false
     */
    boolean deleteById(int id);
}
