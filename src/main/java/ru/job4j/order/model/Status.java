package ru.job4j.order.model;

/**
 * Status - статус заказа
 *
 * @author Ilya Kaltygin
 */
public enum Status {
    PENDING,
    CONFIRMED,
    PROCESSING,
    READY,
    SENT,
    DELIVERED
}
