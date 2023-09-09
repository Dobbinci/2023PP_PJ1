package org.example;

public interface ICRUD {
    public void addWord();
    public void updateWord(Object obj);
    public void deleteWord(Object obj);
    public void selectWord(long id);
    public void listAll();
}
