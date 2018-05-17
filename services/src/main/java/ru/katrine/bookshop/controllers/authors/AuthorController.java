package ru.katrine.bookshop.controllers.authors;

import ru.katrine.bookshop.core.BaseController;
import ru.katrine.bookshop.service.authors.AuthorService;
import ru.katrine.bookshop.service.genres.GenreService;
import ru.katrine.bookshop.view.authors.AuthorView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import java.util.List;

import static ru.katrine.bookshop.core.BaseController.BASE_API_PATH;

@Path(BASE_API_PATH + "/author")
public class AuthorController extends BaseController<AuthorView, AuthorService> {

    @Inject
    public AuthorController(AuthorService service) {
        super(service);
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<AuthorView> getAll(@Context HttpServletRequest request) throws Exception{
        return service.getAll();
    }
}
