package ru.job4j.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.order.model.Customer;

/**
 * CustomerRepository - хранилище заказчиков
 *
 * @author Ilya Kaltygin
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
