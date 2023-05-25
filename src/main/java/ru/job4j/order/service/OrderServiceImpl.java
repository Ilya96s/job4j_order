package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.order.dto.DishDTO;
import ru.job4j.order.dto.OrderDTO;
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

    private final RestTemplate restTemplate;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * Сохранить заказ
     *
     * @param order заказ
     * @return сохраненный заказ
     */
    @Override
    public Order create(Order order) {
        var savedOrder = orderRepository.save(order);
        kafkaTemplate.send("job4j_orders", savedOrder);
        kafkaTemplate.send("messengers", savedOrder);
        return savedOrder;
    }

    /**
     * Получить заказ по идентификатору
     *
     * @param id идентификатор заказа
     * @return Optional.of(orderDTO) если заказ найден, иначе Optional.empty()
     */
    @Override
    public Optional<OrderDTO> findById(int id) {
        Optional<OrderDTO> result = Optional.empty();
        List<DishDTO> dishDTOS;
        var orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            dishDTOS = orderOptional.get().getDishIds().stream()
                    .map(this::findDishById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
            result = Optional.of(OrderDTO.builder()
                    .order(orderOptional.get())
                    .dish(dishDTOS)
                    .build());
        }

        return result;
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

    /**
     * Метод выполняет GET-запрос к удаленному вэб-сервису
     * @param id идентификатор
     * @return объект типа DishDTO
     */
    private Optional<DishDTO> findDishById(int id) {
        var apiUrl = "http://localhost:8080/dish/";
        return Optional.ofNullable(restTemplate.getForEntity(
                String.format(apiUrl + "%s", id),
                DishDTO.class
        ).getBody());
    }
}
