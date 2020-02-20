package indi.test.model;

import java.util.Map;

public class Dict {
    private Character letter;
    private boolean isEnd;
    private Map<Character, Dict> next;

    public Dict(Character letter) {
        this.letter = letter;
    }

    public Dict(Character letter, boolean isEnd, Map<Character, Dict> next) {
        this.letter = letter;
        this.isEnd = isEnd;
        this.next = next;
    }

    public Dict() {
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Map<Character, Dict> getNext() {
        return next;
    }

    public void setNext(Map<Character, Dict> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "letter=" + letter +
                ", isEnd=" + isEnd +
                ", next=" + next +
                '}';
    }
}
