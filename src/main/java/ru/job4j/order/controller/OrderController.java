package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.model.Order;
import ru.job4j.order.service.OrderService;

import java.util.List;

/**
 * OrderController - контроллер, отвечающий за работу с заказами
 *
 * @author Ilya Kaltygin
 */
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    /**
     * Сервис по работе с заказами
     */
    private final OrderService orderService;

    /**
     * Получить список заказов
     *
     * @return список заказов
     */
    @GetMapping("/")
    List<Order> findAll() {
        return orderService.findAll();
    }

    /**
     * Получить заказ
     *
     * @param id идентификатор заказа
     * @return объект типа ResponseEntity<Order>, содержащий объект типа Order, найденный по указанному идентификатору
     * и статус ответа ОК.
     * Если по заданному идентификатору не найден объект типа Product, ResponseEntity<Order> будет содержать пустой объект типа Order
     * и статус ответа NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        var card = orderService.findById(id);
        return new ResponseEntity<>(
                card.orElse(new Order()),
                card.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Сохранить заказ
     *
     * @param order заказ
     * @return объект типа ResponseEntity<Order>, содержащий созданный объект типа Order и статус ответа CREATED.
     */
    @PostMapping("/")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return new ResponseEntity<>(
                orderService.create(order),
                HttpStatus.CREATED
        );
    }

    /**
     * Обновить заказ
     *
     * @param id   идентификатор заказа
     * @param order заказ
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если заказ успешно обновлен,
     * иначе статус ответа NOT_FOUND.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Order order) {
        var update = orderService.update(order, id);
        return new ResponseEntity<>(
                update ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Удалить заказ
     *
     * @param id идентификатор заказа
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если заказ удален успешно,
     * иначе статус ответа NOT_FOUND.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        var delete = orderService.deleteById(id);
        return new ResponseEntity<>(
                delete ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

}
