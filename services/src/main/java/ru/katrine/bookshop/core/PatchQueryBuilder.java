package ru.katrine.bookshop.core;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ru.katrine.bookshop.core.interfaces.IEntity;

/**
 * Класс-конструктор запросов для обновления через PatchMap.
 */
public class PatchQueryBuilder {

    //TODO: валидность значения
    private static boolean validate(Object value) {
        return true;
    }

    /**
     * Метод-конструктор запросов для обновления через PatchMap.
     * @param entityManager для работы с базой
     * @param entity класс-модель сущности из базы
     * @param values - Map содержащий значения для обновления
     * @param id сущности в базе
     * @return Query запрос для обновления
     */
    public static Query build(EntityManager entityManager, Class<? extends IEntity> entity, Map<String, Object> values, int id) {


        StringBuilder sql = new StringBuilder();
        String className = "o";
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            if (validate(entry.getValue())) {
                sql.append(className)
                        .append(".")
                        .append(entry.getKey())
                        .append("=:")
                        .append(entry.getKey())
                        .append(",");
            }
        }
        sql.deleteCharAt(sql.length()-1);
        Query query = entityManager.createQuery("update " + entity.getSimpleName() + " " + className + " set " + sql + " where id=:id");
        query.setParameter("id",id);
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            if (entry.getValue().getClass() == BigDecimal.class) {
                BigDecimal value = (BigDecimal) entry.getValue();
                query.setParameter(entry.getKey(), entry.getValue() == null ? null : value.doubleValue());
            }
            else query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }
}
