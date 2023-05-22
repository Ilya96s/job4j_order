package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Product;
import ru.job4j.order.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * ProductServiceImpl - реализация сервиса по работе с продуктами
 *
 * @author Ilya Kaltygin
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    /**
     * Хранилище продуктов
     */
    private final ProductRepository productRepository;

    /**
     * Сохранить продукт
     *
     * @param product продукт
     * @return сохраненный продукт
     */
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    /**
     * Получить продукт по идентификатору
     *
     * @param id идентификатор продукта
     * @return Optional.of(product) если продукт найден, иначе Optional.empty()
     */
    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    /**
     * Получить список всех продуктов
     *
     * @return список продуктов
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Обновить продукт
     *
     * @param product продукт
     * @param id    идентификатор продукта
     * @return true если продукт успешно обновлен, иначе false
     */
    @Override
    public boolean update(Product product, int id) {
        boolean result = false;
        if (productRepository.existsById(id)) {
            productRepository.save(product);
            result = true;
        }
        return result;
    }

    /**
     * Удалить продукт
     *
     * @param id идентификатор продукт
     * @return true если продукт успешно удален, иначе false
     */
    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            result = true;
        }
        return result;
    }
}
