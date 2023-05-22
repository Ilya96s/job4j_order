package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Customer;
import ru.job4j.order.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    /**
     * Хранилище заказчиков
     */
    private final CustomerRepository customerRepository;

    /**
     * Сохранить заказчика
     *
     * @param customer заказчик
     * @return сохраненная заказчик
     */
    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Получить заказчика по идентификатору
     *
     * @param id идентификатор заказчика
     * @return Optional.of(customer) если заказчик найден, иначе Optional.empty()
     */
    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    /**
     * Получить список всех заказчиков
     *
     * @return список заказчиков
     */
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * Обновить заказчика
     *
     * @param customer заказчик
     * @param id       идентификатор заказчика
     * @return true если заказчик успешно обновлен, иначе false
     */
    @Override
    public boolean update(Customer customer, int id) {
        boolean result = false;
        if (customerRepository.existsById(id)) {
            customerRepository.save(customer);
            result = true;
        }
        return result;
    }

    /**
     * Удалить заказчика
     *
     * @param id идентификатор заказчика
     * @return true если заказчик успешно удален, иначе false
     */
    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            result = true;
        }
        return result;
    }
}
