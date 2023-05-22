package ru.job4j.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.order.model.Product;

/**
 * ProductRepository - хранилище продуктов
 *
 * @author Ilya Kaltygin
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
