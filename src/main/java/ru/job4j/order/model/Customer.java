package ru.job4j.order.model;

import lombok.*;

import javax.persistence.*;

/**
 * Customer - модель данных, описывающая покупателя
 *
 * @author Ilya Kaltygin
 */
@Entity
@Data
@ToString(exclude = "card")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;
}
