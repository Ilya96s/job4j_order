package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.model.Customer;
import ru.job4j.order.service.CustomerService;

import java.util.List;

/**
 * CustomerController - контроллер, отвечающий за работу с заказами
 *
 * @author Ilya Kaltygin
 */
@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    /**
     * Сервис по работе с заказчиками
     */
    private final CustomerService customerService;

    /**
     * Получить список заказчиков
     *
     * @return список заказчиков
     */
    @GetMapping("/")
    List<Customer> findAll() {
        return customerService.findAll();
    }

    /**
     * Получить заказчика
     *
     * @param id идентификатор заказчика
     * @return объект типа ResponseEntity<Customer>, содержащий объект типа Customer, найденный по указанному идентификатору
     * и статус ответа ОК.
     * Если по заданному идентификатору не найден объект типа Product, ResponseEntity<Customer> будет содержать пустой объект типа Customer
     * и статус ответа NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable int id) {
        var card = customerService.findById(id);
        return new ResponseEntity<>(
                card.orElse(new Customer()),
                card.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Сохранить заказчика
     *
     * @param customer заказчик
     * @return объект типа ResponseEntity<Customer>, содержащий созданный объект типа Customer и статус ответа CREATED.
     */
    @PostMapping("/")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(
                customerService.create(customer),
                HttpStatus.CREATED
        );
    }

    /**
     * Обновить заказчика
     *
     * @param id   идентификатор заказчика
     * @param customer заказчик
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если заказчик успешно обновлен,
     * иначе статус ответа NOT_FOUND.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Customer customer) {
        var update = customerService.update(customer, id);
        return new ResponseEntity<>(
                update ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Удалить заказчика
     *
     * @param id идентификатор заказчика
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если заказчик удален успешно,
     * иначе статус ответа NOT_FOUND.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        var delete = customerService.deleteById(id);
        return new ResponseEntity<>(
                delete ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
