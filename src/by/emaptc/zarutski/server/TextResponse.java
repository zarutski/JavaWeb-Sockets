package by.emaptc.zarutski.server;

import by.emaptc.zarutski.entity.Text;
import by.emaptc.zarutski.service.ServiceFactory;
import by.emaptc.zarutski.service.TextService;
import by.emaptc.zarutski.service.exception.ServiceException;

import java.io.*;
import java.net.Socket;

public class TextResponse extends Thread {

    private final Socket socket;

    public TextResponse(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {

            ServiceFactory factory = ServiceFactory.getInstance();
            TextService textService = factory.getTextService();

            Text txt = new Text();
            try {
                txt = textService.getText();
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            objectOutputStream.writeObject(txt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
