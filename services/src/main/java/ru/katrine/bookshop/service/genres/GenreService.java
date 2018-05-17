package ru.katrine.bookshop.service.genres;

import ru.katrine.bookshop.core.EntityBaseService;
import ru.katrine.bookshop.dao.genres.GenreDAO;
import ru.katrine.bookshop.model.GenreModel;
import ru.katrine.bookshop.view.genres.GenreView;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class GenreService extends EntityBaseService<GenreView, GenreModel, GenreDAO> {

    @Inject
    public GenreService(GenreDAO dao) {
        this.entityDAO = dao;
    }

    @Transactional
    public List<GenreView> getAll() throws Exception{
        List<GenreModel> genreModelList = entityDAO.getAll();
        List<GenreView> genreViewList = new ArrayList<>();

        for (GenreModel model:
             genreModelList) {
            genreViewList.add(fromModelToView(model));
        }

        return genreViewList;
    }

    public GenreView fromModelToView(GenreModel model){
        GenreView view = new GenreView();
        view.setId(model.getId());
        view.setName(model.getName());
        return view;
    }

    public GenreModel fromViewToModel(GenreView view){
        GenreModel model = new GenreModel();
        model.setId(view.getId());
        model.setName(view.getName());
        return model;
    }

}
