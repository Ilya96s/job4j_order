package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.model.Product;
import ru.job4j.order.service.ProductService;

import java.util.List;

/**
 * ProductController - контроллер, отвечающий за работу с продуктами
 *
 * @author Ilya Kaltygin
 */
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    /**
     * Сервис по работе с продуктами
     */
    private final ProductService productService;

    /**
     * Получить список всех продуктов
     *
     * @return список продуктов
     */
    @GetMapping("/")
    List<Product> findAll() {
        return productService.findAll();
    }

    /**
     * Получить продукт
     *
     * @param id идентификатор продукта
     * @return объект типа ResponseEntity<Product>, содержащий объект типа Product, найденный по указанному идентификатору
     * и статус ответа ОК.
     * Если по заданному идентификатору не найден объект типа Product, ResponseEntity<Product> будет содержать пустой объект типа Product
     * и статус ответа NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        var card = productService.findById(id);
        return new ResponseEntity<>(
                card.orElse(new Product()),
                card.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Сохранить продукт
     *
     * @param product продукт
     * @return объект типа ResponseEntity<Product>, содержащий созданный объект типа Product и статус ответа CREATED.
     */
    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(
                productService.create(product),
                HttpStatus.CREATED
        );
    }

    /**
     * Обновить продукт
     *
     * @param id   идентификатор продукта
     * @param product продукт
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если продукт успешно обновлен,
     * иначе статус ответа NOT_FOUND.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Product product) {
        var update = productService.update(product, id);
        return new ResponseEntity<>(
                update ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Удалить продукт
     *
     * @param id идентификатор продукта
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если продукт удален успешно,
     * иначе статус ответа NOT_FOUND.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        var delete = productService.deleteById(id);
        return new ResponseEntity<>(
                delete ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
