package ru.katrine.bookshop.service.authors;

import ru.katrine.bookshop.core.EntityBaseService;
import ru.katrine.bookshop.dao.authors.AuthorDAO;
import ru.katrine.bookshop.model.AuthorModel;
import ru.katrine.bookshop.view.authors.AuthorView;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class AuthorService extends EntityBaseService<AuthorView, AuthorModel, AuthorDAO> {

    @Inject
    public AuthorService(AuthorDAO dao) {
        this.entityDAO = dao;
    }

    @Transactional
    public List<AuthorView> getAll() throws Exception{
        List<AuthorModel> AuthorModelList = entityDAO.getAll();
        List<AuthorView> AuthorViewList = new ArrayList<>();

        for (AuthorModel model:
                AuthorModelList) {
            AuthorViewList.add(fromModelToView(model));
        }

        return AuthorViewList;
    }

    @Transactional
    public AuthorView addAndReturn(AuthorView authorView) throws Exception{
        AuthorModel authorModel = fromViewToModel(authorView);
        entityDAO.add(authorModel);

        return fromModelToView(authorModel);
    }

    public AuthorView fromModelToView(AuthorModel model){
        AuthorView view = new AuthorView();
        view.setId(model.getId());
        view.setFirstName(model.getFirstName());
        view.setLastName(model.getLastName());
        view.setMiddleName(model.getMiddleName());
        return view;
    }

    public AuthorModel fromViewToModel(AuthorView view){
        AuthorModel model = new AuthorModel();
        if(view.getId() != -1){
            model.setId(view.getId());
        }
        model.setFirstName(view.getFirstName());
        model.setLastName(view.getLastName());
        model.setMiddleName(view.getMiddleName());
        return model;
    }
}
