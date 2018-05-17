package ru.katrine.bookshop.controllers.books;

import ru.katrine.bookshop.core.BaseController;
import ru.katrine.bookshop.service.books.BookService;
import ru.katrine.bookshop.view.books.BookView;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static ru.katrine.bookshop.core.BaseController.BASE_API_PATH;

@Path(BASE_API_PATH + "/book")
public class BookController extends BaseController<BookView, BookService> {

    @Inject
    public BookController(BookService service) {
        super(service);
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public BookView add(@Context HttpHeaders headers, BookView view) throws Exception {
        return service.add(view);
    }
}
