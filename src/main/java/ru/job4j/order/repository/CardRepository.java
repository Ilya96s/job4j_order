package ru.job4j.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.order.model.Card;

/**
 * CardRepository - хранилище бонусных карт
 *
 * @author Ilya Kaltygin
 */
public interface CardRepository extends JpaRepository<Card, Integer> {
}
