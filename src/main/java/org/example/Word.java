package org.example;

public class Word {
    long id;
    int level;
    String name;
    String meaning;

    public Word(){}
    public Word(long id, int level, String name, String meaning) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.meaning = meaning;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String toString() {
        String Asterisk = new String();

        for (int i=0; i<level; i++) {
            Asterisk = Asterisk + "*";
        }

        return "  " + Asterisk + "     " + getName() + "  " + getMeaning();
    }

    public static Word fromLine(String line) {
        String[] parts = line.split(" ", 4);
        if (parts.length != 4) {
            throw new IllegalArgumentException("잘못된 형식입니다");
        }
        return new Word(Long.parseLong(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3]);
    }
}
