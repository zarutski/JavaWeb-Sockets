package by.emaptc.zarutski.service;

import by.emaptc.zarutski.entity.Text;
import by.emaptc.zarutski.service.exception.ServiceException;

public interface TextService {

    Text getText() throws ServiceException;

}
