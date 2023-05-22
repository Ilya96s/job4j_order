package ru.job4j.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.order.model.Order;

/**
 * OrderRepository - хранилище заказов
 *
 * @author Ilya Kaltygin
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
