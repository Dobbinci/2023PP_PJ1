package org.example;

public class Word {
    long id;
    int level;
    String name;
    String meaning;

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

        return getId() + "  " + Asterisk + "     " + getName() + "  " + getMeaning();
    }
}
