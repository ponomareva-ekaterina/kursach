package ru.katrine.bookshop.core;

import java.util.List;

import ru.katrine.bookshop.core.interfaces.IService;
import ru.katrine.bookshop.core.interfaces.IView;

/**
 * Базовый класс-сервис для обработки данных из базы.
 * @param <V> - класс дла передачи на фронт
 */
public abstract class BaseService<V extends IView> implements IService<V> {


    /**
     * Базовый метод для получения объекта по id.
     * @param id идентификатор объекта
     */
    public V getById(int id) throws Exception {
        return null;
    }

    /**
     * Базовый метод для получения списка всех объектов.
     */
    @Override
    public List<V> getAll() throws Exception {
        return null;
    }

    /**
     * Базовый метод для добавления объекта.
     * @param view объект с данными
     */
    @Override
    public V add(V view) throws Exception {
        return null;
    }

    /**
     * Базовый метод для удаления объекта.
     * @param id идентификатор объекта
     */
    @Override
    public void delete(int id) throws Exception {

    }

    /**
     * Базовый метод редактирования объекта.
     * @param view объект с данными
     */
    @Override
    public void edit(V view) throws Exception {

    }

//    /**
//     * Базовый метод редактирования объектов через PatchMap.
//     * @param values PatchMap с данными
//     * @param id идентификатор объекта
//     */
//    @Override
//    public void patch(PatchMap values, int id) throws Exception {
//
//    }
}
