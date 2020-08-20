package by.emaptc.zarutski.controller;

import by.emaptc.zarutski.controller.operation.TextOperationImpl;

public class OperationFactory {

    private static final OperationFactory instance = new OperationFactory();

    private final TextOperation textOperation = new TextOperationImpl();

    private OperationFactory() {
    }

    public TextOperation getTextOperation() {
        return textOperation;
    }

    public static OperationFactory getInstance() {
        return instance;
    }
}
