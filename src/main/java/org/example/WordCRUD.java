package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    private static final ArrayList<Word> wordList = new ArrayList<Word>(); //list of words
    Scanner scanner = new Scanner(System.in);
    //method to add word
    @Override
    public void addWord() {
        Word newWord = new Word();

        System.out.println("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = scanner.nextInt();
        String name = scanner.nextLine();

        System.out.println("뜻 입력 : ");
        String meaning = scanner.nextLine();

        newWord.setLevel(level);
        newWord.setName(name);
        newWord.setMeaning(meaning);
        newWord.setId(wordList.size()+1);

        wordList.add(newWord);

        System.out.println("단어가 추가되었습니다\n");

    }
    //method to update meaning of word
    @Override
    public void updateWord() {
        System.out.println("수정할 단어를 입력하세요 ");
        String searchedWord = scanner.nextLine();

        ArrayList<Integer> searchedIndex = searchWord(searchedWord);

        //print searched words
        System.out.println("-------------------------------- ");
        for(int i=0; i<searchedIndex.size(); i++) {
            System.out.println(i+1 + wordList.get(searchedIndex.get(i)).toString());
        }
        System.out.println("-------------------------------- ");

        //ask which word will be updated
        System.out.println("수정할 번호 선택: ");
        int chosenNum = scanner.nextInt();
        //문자열 씹힘
        scanner.nextLine();
        System.out.println("뜻 입력: ");
        String updatedMeaning = scanner.nextLine();

        //update meaning
        wordList.get(searchedIndex.get(chosenNum-1)).setMeaning(updatedMeaning);

        System.out.println("성공적으로 수정 되었습니다");

    }
    //method to delete word
    @Override
    public void deleteWord() {
        System.out.println("삭제할 단어를 입력하세요 ");
        String searchedWord = scanner.nextLine();

        ArrayList<Integer> searchedIndex = searchWord(searchedWord);

        //print searched words
        System.out.println("-------------------------------- ");
        for(int i=0; i<searchedIndex.size(); i++) {
            System.out.println(i+1 + wordList.get(searchedIndex.get(i)).toString());
        }
        System.out.println("-------------------------------- ");

        //ask which word will be updated
        System.out.println("삭제할 번호 선택: ");
        int chosenNum = scanner.nextInt();
        //스트링 씹혀서 추가함
        scanner.nextLine();
        System.out.println("정말로 삭제하시겠어요?(Y/N): ");
        String reallyDelete = scanner.nextLine();
        //if user chose really to delete -> delete
        if(reallyDelete.equalsIgnoreCase("Y")) {
            wordList.remove((int)searchedIndex.get(chosenNum-1));
        }
        System.out.println("삭제가 완료되었습니다");
    }
    //method to show words by input word
    public void listByWord() {
        System.out.println("검색할 단어를 입력하세요 ");
        String searchedWord = scanner.nextLine();

        ArrayList<Integer> searchedIndex = searchWord(searchedWord);

        //print searched words
        System.out.println("-------------------------------- ");
        for(int i=0; i<searchedIndex.size(); i++) {
            System.out.println(i+1 + wordList.get(searchedIndex.get(i)).toString());
        }
        System.out.println("-------------------------------- ");
    }
    //method to show some words by level
    public void listByLevel() {
        System.out.println("=> 레벨(1:초급, 2:중급, 3:고급) 선택 : ");
        int searchedLevel = scanner.nextInt();
        ArrayList<Integer> searchedIndex = searchLevel(searchedLevel);

        //print searched words
        System.out.println("-------------------------------- ");
        for(int i=0; i<searchedIndex.size(); i++) {
            System.out.println(i+1 + wordList.get(searchedIndex.get(i)).toString());
        }
        System.out.println("-------------------------------- ");

    }
    //method to show all of words
    @Override
    public void listAll() {
        System.out.println("-------------------------------- ");
        for (int i=0; i<wordList.size(); i++) {
            System.out.println(i+1 + wordList.get(i).toString());
        }
        System.out.println("-------------------------------- ");
    }
    //method to search words by input word and return their index
    public ArrayList<Integer> searchWord(String searchedWord){
        ArrayList<Integer> searchedIndex = new ArrayList<>();

        for(int i=0; i<wordList.size(); i++) {
            if (wordList.get(i).getName().contains(searchedWord)) {
                searchedIndex.add(i);
            }
        }

        return searchedIndex;
    }
    //method to search words by level and return their index
    public ArrayList<Integer> searchLevel(int searchedLevel){
        ArrayList<Integer> searchedIndex = new ArrayList<>();

        for(int i=0; i<wordList.size(); i++) {
            if (wordList.get(i).getLevel() == searchedLevel) {
                searchedIndex.add(i);
            }
        }

        return searchedIndex;
    }
    //static method to read words from the file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                wordList.add(Word.fromLine(line));
                count ++;
            }
            System.out.println(count + "개 단어 로딩 완료!");
        } catch (IOException e) {
            System.out.println("파일 로드 실패");
            e.printStackTrace();
        }
    }
    //static method to save words as a file
    public static void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i=0; i<wordList.size(); i++) {
                writer.write(i + wordList.get(i).toStringForSave());
                writer.newLine();
            }
            System.out.println("저장 완료!");
        } catch (IOException e) {
        System.out.println("파일 저장 실패");
        e.printStackTrace();
        }
    }
}
