package ru.katrine.bookshop.core;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ru.katrine.bookshop.core.interfaces.IDAO;
import ru.katrine.bookshop.core.interfaces.IEntity;

/**
 * Абстрактный класс Data Access Object для получения сущностей из базы.
 *
 * @param <E> - класс-модель, соответствующая одной из таблиц базы
 */
@Stateless
public abstract class BaseDAO<E extends IEntity> implements IDAO<E> {

    @PersistenceContext(unitName = "persistence")
    protected EntityManager entityManager;


    /**
     * Базоый метод добавления сущности в базу.
     */
    @Override
    public void add(E model) throws Exception {
        entityManager.persist(model);
    }

    /**
     * Базовый метод получения сущности из базы по id.
     */
    @Override
    public E getById(int id) throws Exception {
        E result =entityManager.find(getPersistentClass(), id);
        return result;
    }

    /**
     * Базовый метод получения всех значений из таблицы в базе.
     */
    @Override
    public List<E> getAll() throws Exception {
        Query query = entityManager.createQuery("SELECT entity from " + getPersistentClass().getSimpleName() + " as entity");
        return query.getResultList();
    }

    /**
     * Базовый метод создания сущности.
     */
    @Override
    public void create(E model) throws Exception {

    }

    /**
     * Базовый метод удаления сущности по id.
     */
    @Override
    public void delete(int id) throws Exception {
        E model = getById(id);
        entityManager.remove(model);
    }

    /**
     * Базовый метод редактирования сущности в базе.
     */
    @Override
    public E edit(E model) throws Exception {
        E returnedModel = entityManager.merge(model);
        return returnedModel;
    }

    /**
     * Возвращает класс persistent'a.
     * @return Class<E>
     */
    protected Class<E> getPersistentClass() {
        return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
