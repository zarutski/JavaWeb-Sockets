package by.emaptc.zarutski.controller;

import by.emaptc.zarutski.entity.Text;

public interface TextOperation {

    void printSentencesByWordsCount(Text text);

    void swapSentenceFirstLastWords(Text text);

    void printWordsAlphabetOrder(Text text);

}
