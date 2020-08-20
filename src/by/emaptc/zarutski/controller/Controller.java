package by.emaptc.zarutski.controller;

import by.emaptc.zarutski.controller.exception.ControllerException;
import by.emaptc.zarutski.controller.print.PrintText;
import by.emaptc.zarutski.entity.Text;

public class Controller {

    public static void main(String[] args) throws ControllerException {
        ClientConnect clientConnect = new ClientConnect();
        Text text = clientConnect.getTextResponse();

        //////////////////////////////////////////////////////////////////
        OperationFactory factory = OperationFactory.getInstance();
        TextOperation operation = factory.getTextOperation();

        //////////////////////////////////////////////////////////////////
        PrintText.printText(text);
        System.out.println();

        //////////////////////////////////////////////////////////////////
        operation.printSentencesByWordsCount(text);
        System.out.println();

        //////////////////////////////////////////////////////////////////
        operation.printWordsAlphabetOrder(text);
        System.out.println();

        //////////////////////////////////////////////////////////////////
        operation.swapSentenceFirstLastWords(text);
        PrintText.printText(text);
    }
}