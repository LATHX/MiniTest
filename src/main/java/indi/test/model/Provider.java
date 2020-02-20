package indi.test.model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Provider {
    private List<String> letterList;
    private Stack<Character> characterStack;
    private Map<Character, Dict> dictMap;
    private Map<String,List<String>> record;
    private Set<String> temp;

    public Set<String> getTemp() {
        return temp;
    }

    public void setTemp(Set<String> temp) {
        this.temp = temp;
    }

    public Map<String, List<String>> getRecord() {
        return record;
    }

    public void setRecord(Map<String, List<String>> record) {
        this.record = record;
    }

    public Map<Character, Dict> getDictMap() {
        return dictMap;
    }

    public void setDictMap(Map<Character, Dict> dictMap) {
        this.dictMap = dictMap;
    }

    public List<String> getLetterList() {
        return letterList;
    }

    public void setLetterList(List<String> letterList) {
        this.letterList = letterList;
    }

    public Stack<Character> getCharacterStack() {
        return characterStack;
    }

    public void setCharacterStack(Stack<Character> characterStack) {
        this.characterStack = characterStack;
    }
}
