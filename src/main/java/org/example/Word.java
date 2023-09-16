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

        return "  " + Asterisk + "     " + getName() + "  " + getMeaning();
    }

    public void fromLine(String line) {
        String[] parts = line.split(" ", 4);
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid format");
        }
        setId(Long.parseLong(parts[0]));
        setLevel(Integer.parseInt(parts[1]));
        setName(parts[2]);
        setMeaning(parts[3]);
    }
}
