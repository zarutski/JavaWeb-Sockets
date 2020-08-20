package by.emaptc.zarutski.service.impl;

import by.emaptc.zarutski.dao.DAOFactory;
import by.emaptc.zarutski.dao.TextDAO;
import by.emaptc.zarutski.dao.exception.DaoException;
import by.emaptc.zarutski.entity.Text;
import by.emaptc.zarutski.service.TextService;
import by.emaptc.zarutski.service.exception.ServiceException;

public class TextServiceImpl implements TextService {

    @Override
    public Text getText() throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        TextDAO dao = factory.getTextDAO();

        Text text = null;
        try {
            text = dao.loadText();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return text;
    }
}