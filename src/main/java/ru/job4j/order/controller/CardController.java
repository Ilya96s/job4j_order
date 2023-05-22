package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.order.model.Card;
import ru.job4j.order.service.CardService;

import java.util.List;

/**
 * CardController - контроллер, отвечающий за работу с бонусными картами
 *
 * @author Ilya Kaltygin
 */
@RestController
@RequestMapping("/card")
@AllArgsConstructor
public class CardController {

    /**
     * Сервис по работе с бонуснми картами
     */
    private final CardService cardService;

    /**
     * Получить список всех бонусных карт
     *
     * @return список бонусных карт
     */
    @GetMapping("/")
    List<Card> findAll() {
        return cardService.findAll();
    }

    /**
     * Получить бонусную карту
     *
     * @param id идентификатор бонусной карты
     * @return объект типа ResponseEntity<Card>, содержащий объект типа Card, найденный по указанному идентификатору
     * и статус ответа ОК.
     * Если по заданному идентификаторуне найден объект типа Card, ResponseEntity<Card> будет содержать пустой объект типа Card
     * и статус ответа NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable int id) {
        var card = cardService.findById(id);
        return new ResponseEntity<>(
                card.orElse(new Card()),
                card.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Сохранить бонусную карту
     *
     * @param card бонусная карта
     * @return объект типа ResponseEntity<Card>, содержащий созданный объект типа Card и статус ответа CREATED.
     */
    @PostMapping("/")
    public ResponseEntity<Card> create(@RequestBody Card card) {
        return new ResponseEntity<>(
                cardService.create(card),
                HttpStatus.CREATED
        );
    }

    /**
     * Обновить бонусную карту
     *
     * @param id   идентификатор бонусной карты
     * @param card блюдо
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если бонусная карта успешно обновлена,
     * иначе статус ответа NOT_FOUND.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Card card) {
        var update = cardService.update(card, id);
        return new ResponseEntity<>(
                update ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Удалить бонусную карту
     *
     * @param id идентификатор бонусной карты
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если бонусная карта удалена успешно,
     * иначе статус ответа NOT_FOUND.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        var delete = cardService.deleteById(id);
        return new ResponseEntity<>(
                delete ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
