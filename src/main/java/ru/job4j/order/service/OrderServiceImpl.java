package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Order;
import ru.job4j.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

/**
 * OrderServiceImpl - реализация сервиса по работе с заказами
 *
 * @author Ilya Kaltygin
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    /**
     * Хранилище заказов
     */
    private final OrderRepository orderRepository;

    /**
     * Сохранить заказ
     *
     * @param order заказ
     * @return сохраненный заказ
     */
    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Получить заказ по идентификатору
     *
     * @param id идентификатор заказа
     * @return Optional.of(order) если заказ найден, иначе Optional.empty()
     */
    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    /**
     * Получить список всез заказов
     *
     * @return список заказов
     */
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    /**
     * Обновить заказ
     *
     * @param order заказ
     * @param id    идентификатор заказа
     * @return true если заказ успешно обновлен, иначе false
     */
    @Override
    public boolean update(Order order, int id) {
        boolean result = false;
        if (orderRepository.existsById(id)) {
            orderRepository.save(order);
            result = true;
        }
        return result;
    }

    /**
     * Удалить заказ
     *
     * @param id идентификатор заказа
     * @return true если заказ успешно удален, иначе false
     */
    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            result = true;
        }
        return result;
    }
}
