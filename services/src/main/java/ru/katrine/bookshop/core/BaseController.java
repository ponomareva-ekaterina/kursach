package ru.katrine.bookshop.core;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ru.katrine.bookshop.core.interfaces.IController;
import ru.katrine.bookshop.core.interfaces.IService;
import ru.katrine.bookshop.core.interfaces.IView;

/**
 * Абстрактный класс-контроллер для работы через rest.
 * @param <V> - класс для передачи на фронт
 * @param <S> - сервис для работы с классом <V>
 */
public abstract class BaseController<V extends IView, S extends IService<V>> implements IController<V,S> {

    public static final String BASE_API_PATH = "/api";
    public static final String APPLICATION_JSON = "application/json";
    public static final String ID_PATH = "/{id}";

    protected S service;

    /**
     * Конструктор rest контроллера.
     * @param service - сервис для работы с классом <V>
     */
    public BaseController(S service) {
        this.service = service;
    }

    /**
     * Базоывй метод добавления сущности через rest.
     * @param view json-объект с данными
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(V view) throws Exception {
        service.add(view);
    }

    /**
     * Базовый метод редактирования сущности через rest.
     * @param view json-объект с данными
     */
    @PUT
    @Consumes(APPLICATION_JSON)
    public void edit(V view) throws Exception {
        service.edit(view);
    }

    /**
     * Базовый метод поиска сущности по id.
     * @param id идентификатор сущности
     */
    @GET
    @Path(ID_PATH)
    @Produces(APPLICATION_JSON)
    public V getById(@PathParam("id") int id) throws Exception {
        return service.getById(id);
    }

    /**
     * Базовый метод получения всех сущностей.
     */
    @GET
    @Produces(APPLICATION_JSON)
    public List<V> getAll() throws Exception {
        return service.getAll();
    }


    /**
     * Базовый метод удаления сущности по id.
     * @param id идентификатор сущности
     * @throws Exception
     */
    @DELETE
    @Path(ID_PATH)
    public void delete(@PathParam("id") int id) throws Exception {
        service.delete(id);
    }

//    /**
//     * Базовый метод редактирования сущностей через patch.
//     * @param map PatchMap с данными
//     * @param id идентификатор сущности
//     */
//    @PATCH
//    @Path(ID_PATH)
//    @Consumes(APPLICATION_JSON)
//    public void patch(PatchMap map, @PathParam("id") int id) throws Exception {
//        if (map.size() !=0)
//            service.patch(map, id);
//        //TODO: пока работает с простыми значениями (строки и числа ), нужно валидировать значения
//    }


}
