package ru.job4j.order.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Order - модель данных, описывающая заказ
 *
 * @author Ilya Kaltygin
 */
@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "status"})
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "order_dishes",
            joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "dish_id")
    private List<Integer> dishIds = new ArrayList<>();
}
