package ru.katrine.bookshop.core.interfaces;

import java.util.List;

/**
 * Базовый интерфейс DAO.
 * @param <E> - класс-модель сучности из базы
 */
public interface IDAO<E extends IEntity> {

    /**
     * Добавление сущности.
     * @param model - сущность для добавления
     * @throws Exception
     */
    void add(E model) throws Exception;

    /**
     * Получение сущности по id.
     * @param id сущности
     * @return E - сущность
     * @throws Exception
     */
    E getById(int id) throws Exception;

    /**
     * Получение списка всех сущностей.
     * @return List<E> - список сущностей
     * @throws Exception
     */
    List<E> getAll() throws Exception;

    /**
     * Создание сущности.
     * @param model - сущность для добавления в базу
     * @throws Exception
     */
    void create(E model) throws Exception;

    /**
     * Удаление сущности по id.
     * @param id сущности
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     * Редактирование сущности.
     * @param model - сущность для редактирования
     * @throws Exception
     */
    E edit(E model) throws Exception;

}
