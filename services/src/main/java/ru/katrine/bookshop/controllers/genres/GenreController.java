package ru.katrine.bookshop.controllers.genres;

import ru.katrine.bookshop.core.BaseController;
import ru.katrine.bookshop.service.genres.GenreService;
import ru.katrine.bookshop.view.genres.GenreView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import java.util.List;

import static ru.katrine.bookshop.core.BaseController.BASE_API_PATH;

@Path(BASE_API_PATH + "/genre")
public class GenreController extends BaseController<GenreView, GenreService> {

    @Inject
    public GenreController(GenreService service) {
        super(service);
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<GenreView> getAll(@Context HttpServletRequest request) throws Exception{
        return service.getAll();
    }
}
