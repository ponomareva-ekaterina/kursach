package ru.katrine.bookshop.core;

import ru.katrine.bookshop.core.interfaces.IEntity;
import ru.katrine.bookshop.core.interfaces.IView;

/**
 * Этот класс используятся для всех сервисов, которые работают с моделями и дао.
 * @param <V> - класс для отправки на фронт
 * @param <E> - класс-модель соответствующая таблице в базе
 * @param <D> - Data Access Object для работы с классом <E>
 */
public abstract class EntityBaseService<V extends IView, E extends IEntity, D extends BaseDAO<E>> extends BaseService<V> {
    protected D entityDAO;

}
