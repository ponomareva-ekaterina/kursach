package ru.katrine.bookshop.controllers.books;

import ru.katrine.bookshop.core.BaseController;
import ru.katrine.bookshop.service.books.BookListService;
import ru.katrine.bookshop.view.books.BookListView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import static ru.katrine.bookshop.core.BaseController.BASE_API_PATH;

@Path(BASE_API_PATH + "/book/list")
public class BookListController extends BaseController<BookListView, BookListService> {

    @Inject
    public BookListController(BookListService service) {
        super(service);
    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public BookListView get(@Context HttpHeaders headers, @Context HttpServletResponse response, @Context HttpServletRequest request) throws Exception {
        Integer offset = request.getParameter("offset") != null ? Integer.parseInt(request.getParameter("offset")) : -1;
        Integer limit = request.getParameter("limit") != null ? Integer.parseInt(request.getParameter("limit")) : -1;
        String sortKey = request.getParameter("sortKey");
        String direction = request.getParameter("direction");
        String searchKey = request.getParameter("searchKey");
        String searchName = request.getParameter("searchName");

        return service.get(offset, limit, sortKey, direction, searchKey, searchName);
    }

}
