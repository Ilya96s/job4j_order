package ru.job4j.order.service;

import ru.job4j.order.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * ProductService - интерфейс, описывающий бизнес-логику по работе с продуктами
 *
 * @author Ilya Kaltygin
 */
public interface ProductService {

    /**
     * Сохранить продукт
     *
     * @param product продукт
     * @return сохраненный продукт
     */
    Product create(Product product);

    /**
     * Получить продукт по идентификатору
     *
     * @param id идентификатор продукта
     * @return Optional.of(product) если продукт найден, иначе Optional.empty()
     */
    Optional<Product> findById(int id);

    /**
     * Получить список всех продуктов
     *
     * @return список продуктов
     */
    List<Product> findAll();

    /**
     * Обновить продукт
     *
     * @param product продукт
     * @param id    идентификатор продукта
     * @return true если продукт успешно обновлен, иначе false
     */
    boolean update(Product product, int id);

    /**
     * Удалить продукт
     *
     * @param id идентификатор продукт
     * @return true если продукт успешно удален, иначе false
     */
    boolean deleteById(int id);
}
