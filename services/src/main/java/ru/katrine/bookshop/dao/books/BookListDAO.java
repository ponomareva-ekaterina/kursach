package ru.katrine.bookshop.dao.books;

import ru.katrine.bookshop.core.BaseDAO;
import ru.katrine.bookshop.model.BookModel;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookListDAO extends BaseDAO<BookModel> {

    public List<BookModel> get(Integer offset, Integer limit, String sortKey, String direction, String searchKey, String searchName) {

        String sqlRequest = "SELECT entity from " + getPersistentClass().getSimpleName() + " as entity";
        Map<String, String> parameters = new HashMap<String, String>();
        if(sortKey != null && !sortKey.equals("") && direction != null && !direction.equals("")){
            sqlRequest += " ORDER BY entity." + sortKey + " :direction";
            parameters.put("direction", direction);
        }
        if(searchKey != null && !searchKey.equals("") && searchName != null && !searchName.equals("")){
            sqlRequest += " WHERE entity." + searchKey + " LIKE :searchName";
            parameters.put("searchName", "%" + searchName + "%");
        }
        Query query = entityManager.createQuery(sqlRequest);
        for (String key : parameters.keySet()) {
            query.setParameter(key, parameters.get(key));
        }
        if(offset != -1 && limit != -1){
            query.setFirstResult(offset);
            query.setMaxResults(limit - offset);
        }
        return query.getResultList();
    }
}
