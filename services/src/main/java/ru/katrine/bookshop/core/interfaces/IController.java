package ru.katrine.bookshop.core.interfaces;

import java.util.List;


/**
 * Базовый интерфеск котроллера.
 * @param <V> - класс для отправки на фронт
 * @param <S> - сервис для работы с классом <V>
 */
public interface IController<V extends IView, S extends IService<V>> {

    /**
     * Добавление объекта .
     * @param view - объект для добавления
     * @throws Exception
     */
    void add(V view) throws Exception;

    /**
     * Редактирование объекта.
     * @param view - объект для редактирования
     * @throws Exception
     */
    void edit(V view) throws Exception;

    /**
     * Получение объекта.
     * @param id - идентификатор объекта
     * @return V - объект
     * @throws Exception
     */
    V getById(int id) throws Exception;

    /**
     * Получение списка объектов.
     * @return List<V> - список объектов
     * @throws Exception
     */
    List<V> getAll() throws Exception;

//    /**
//     * Редактирование объекта через PatchMap.
//     * @param view - PatchMap для редактирования
//     * @param id - идентификатор объекта
//     * @throws Exception
//     */
//    void patch(PatchMap view, int id) throws Exception;
}
