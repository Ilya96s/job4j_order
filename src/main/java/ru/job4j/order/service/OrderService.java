package ru.job4j.order.service;

import ru.job4j.order.dto.OrderDTO;
import ru.job4j.order.model.Order;

import java.util.List;
import java.util.Optional;

/**
 * OrderService - интерфейс, описывающий бизнес-логику по работе с заказми
 *
 * @author Ilya Kaltygin
 */
public interface OrderService {

    /**
     * Сохранить заказ
     *
     * @param order заказ
     * @return сохраненный заказ
     */
    Order create(Order order);

    /**
     * Получить заказ по идентификатору
     *
     * @param id идентификатор заказа
     * @return Optional.of(orderDTO) если заказ найден, иначе Optional.empty()
     */
    Optional<OrderDTO> findById(int id);

    /**
     * Получить список всез заказов
     *
     * @return список заказов
     */
    List<Order> findAll();

    /**
     * Обновить заказ
     *
     * @param order заказ
     * @param id    идентификатор заказа
     * @return true если заказ успешно обновлен, иначе false
     */
    boolean update(Order order, int id);

    /**
     * Удалить заказ
     *
     * @param id идентификатор заказа
     * @return true если заказ успешно удален, иначе false
     */
    boolean deleteById(int id);
}
