package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Card;
import ru.job4j.order.repository.CardRepository;

import java.util.List;
import java.util.Optional;

/**
 * CardServiceImpl - реализация сервиса по работе с бонусными картами
 *
 * @author Ilya Kaltygin
 */
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    /**
     * Хранилище бонусных карт
     */
    private final CardRepository cardRepository;

    /**
     * Сохранить бонусную карту
     *
     * @param card бонусная карта
     * @return сохраненная бонусная карта
     */
    @Override
    public Card create(Card card) {
        return cardRepository.save(card);
    }

    /**
     * Получить бонусную карту по идентификатору
     *
     * @param id идентификатор бонусной карты
     * @return Optional.of(card) если бонусная карта найдена, иначе Optional.empty()
     */
    @Override
    public Optional<Card> findById(int id) {
        return cardRepository.findById(id);
    }

    /**
     * Получить список всез бонусных карт
     *
     * @return список бонусных карт
     */
    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    /**
     * Обновить бонусную карту
     *
     * @param card бонусная карта
     * @param id    идентификатор бонусной карты
     * @return true если бонусная карта успешно обновлена, иначе false
     */
    @Override
    public boolean update(Card card, int id) {
        boolean result = false;
        if (cardRepository.existsById(id)) {
            cardRepository.save(card);
            result = true;
        }
        return result;
    }

    /**
     * Удалить бонусную карту
     *
     * @param id идентификатор бонусной карты
     * @return true если бонусная карта успешно удалена, иначе false
     */
    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
            result = true;
        }
        return result;
    }
}
