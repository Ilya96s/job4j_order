package ru.job4j.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ru.job4j.order.model.Order;

import java.util.List;

/**
 * @author Ilya Kaltygin
 */
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Order order;

    private List<DishDTO> dish;
}
