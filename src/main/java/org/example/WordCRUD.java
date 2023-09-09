package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    private ArrayList<Word> wordList = new ArrayList<Word>();
    @Override
    public void addWord() {
        Word newWord = new Word();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = scanner.nextInt();
        String name = scanner.nextLine();

        System.out.println("뜻 입력 : ");
        String meaning = scanner.nextLine();

        newWord.setLevel(level);
        newWord.setName(name);
        newWord.setMeaning(meaning);
        newWord.setId(wordList.size());

        wordList.add(newWord);

    }

    @Override
    public void updateWord(Object obj) {

    }

    @Override
    public void deleteWord(Object obj) {

    }

    @Override
    public void selectWord(long id) {

    }

    @Override
    public void listAll() {
        System.out.println("-------------------------------- ");
        for (int i=0; i<wordList.size(); i++) {
            System.out.println(wordList.get(i).toString());
        }
        System.out.println("-------------------------------- ");
    }
}
