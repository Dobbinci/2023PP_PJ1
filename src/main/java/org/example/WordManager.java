package org.example;

import java.util.Scanner;

import static java.lang.System.exit;

public class WordManager {

    public void start() {
        WordCRUD wordCRUD = new WordCRUD();
        Scanner scanner = new Scanner(System.in);

        int choice;

        while(true) {
            System.out.println("********************\n" +
                    "1. 모든 단어 보기\n" +
                    "2. 수준별 단어 보기\n" +
                    "3. 단어 검색\n" +
                    "4. 단어 추가\n" +
                    "5. 단어 수정\n" +
                    "6. 단어 삭제\n" +
                    "7. 파일 저장\n" +
                    "0. 나가기\n" +
                    "********************\n" +
                    "=> 원하는 메뉴는? ");

            choice = scanner.nextInt();

            if (choice == 1) {
                //listAll
                wordCRUD.listAll();
            } else if (choice == 2) {
                //listByLevel
            } else if (choice == 3) {
                //search Word
            } else if (choice == 4) {
                //add Word
                wordCRUD.addWord();
            } else if (choice == 5) {
                //update Word
            } else if (choice == 6) {
                //delete Word
            } else if (choice == 7) {
                //save Word
            } else if (choice == 0) {
                //exit
                System.out.println("으어어어어어어");
                exit(0);
            } else {
                System.out.println("잘못된 메뉴번호 입니다");
            }
        }
    }
}
