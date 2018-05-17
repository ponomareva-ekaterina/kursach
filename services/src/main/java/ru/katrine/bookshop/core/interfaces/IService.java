package ru.katrine.bookshop.core.interfaces;

import java.util.List;


/**
 * Интерфейс базового сервиса для всех view.
 * @param <V> - класс фронэнда
 */
public interface IService<V extends IView> {

    /**
     * Получение объекта по id.
     * @param id объекта
     * @return V объект
     * @throws Exception
     */
    V getById(int id) throws Exception;

    /**
     * Получение списка объектов.
     * @return List<V> - список объектов
     * @throws Exception
     */
    List<V> getAll() throws Exception;

    /**
     * Добавление объектов.
     * @param view объект для добавления
     * @throws Exception
     */
    V add(V view) throws Exception;

    /**
     * Удаление объектов по id. 
     * @param id объекта для удаления
     * @throws Exception
     */
    void delete(int id) throws Exception;

    /**
     * Редактирования объекта.
     * @param view объект для редактирования
     * @throws Exception
     */
    void edit(V view) throws Exception;

}

