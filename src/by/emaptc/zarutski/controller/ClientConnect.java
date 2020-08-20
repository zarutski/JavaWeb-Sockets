package by.emaptc.zarutski.controller;

import by.emaptc.zarutski.controller.exception.ControllerException;
import by.emaptc.zarutski.entity.Text;

import java.io.*;
import java.net.Socket;

public class ClientConnect {

    public static final String SERVER_CONNECTION_MESSAGE = "Error creating socket";
    public static final String SOCKET_MESSAGE = "Socket error while creating input stream";
    public static final String SERIALIZED_CLASS_MESSAGE = "Can't find serialized class";
    public static final String HOST = "localhost";

    public Text getTextResponse() throws ControllerException {
        Text text = null;

        try (Socket socket = new Socket(HOST, 5000)) {
            text = receiveText(socket);
        } catch (IOException e) {
            throw new ControllerException(SERVER_CONNECTION_MESSAGE, e);
        }
        return text;
    }

    private Text receiveText(Socket socket) throws ControllerException{
        Text text = null;

        try (InputStream inputStream = socket.getInputStream();
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            Object serverResponse = objectInputStream.readObject();
            if (serverResponse instanceof Text) {
                text = (Text) serverResponse;
            }
        } catch (IOException e) {
            throw new ControllerException(SOCKET_MESSAGE, e);
        } catch (ClassNotFoundException e) {
            throw new ControllerException(SERIALIZED_CLASS_MESSAGE, e);
        }
        return text;
    }
}