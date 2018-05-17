package ru.katrine.bookshop.core;

import java.util.List;

import ru.katrine.bookshop.core.interfaces.IView;

/**
 * Базовая таблица.
 * @param <V> - View.
 */
public class TableView<V extends IView> implements IView {
    private Long totalCount;
    private List<V> items;

    /**
     * Конструктор.
     * @param totalCount количество элементов в таблице
     * @param items список элементов
     */
    public TableView(Long totalCount, List<V> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    /**
     * Получить количество элементов в таблице.
     * @return количество элементов в таблице
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * Установить количество элементов в таблице.
     * @param totalCount количество элементов в таблице
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Получить список элементов в таблице.
     * @return список элементов в таблице
     */
    public List<V> getItems() {
        return items;
    }

    /**
     * Установить список элементов в таблице.
     * @param items список элементов в таблице
     */
    public void setItems(List<V> items) {
        this.items = items;
    }
}
