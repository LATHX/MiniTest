package indi.test;

import indi.test.factory.DictFactory;
import indi.test.model.Provider;

import java.util.*;
import java.util.stream.Collectors;

public class Start {
    private List<String> systemDict;
    private List<String> userDict;
    private String inputText;

    public Start() {

    }

    public void supplySystemDict(List<String> systemDict) {
        systemDict.add("i");
        systemDict.add("like");
        systemDict.add("sam");
        systemDict.add("sung");
        systemDict.add("samsung");
        systemDict.add("mobile");
        systemDict.add("ice");
        systemDict.add("cream");
        systemDict.add("man go");
    }

    public void supplyUserDict(List<String> userDict) {
        userDict.add("i");
        userDict.add("like");
        userDict.add("sam");
        userDict.add("sung");
        userDict.add("samsung");
        userDict.add("mobile");
        userDict.add("ice");
        userDict.add("cream");
        userDict.add("man go");
        userDict.add("mango");
    }

    public void begin() {
        DictFactory dictFactory = new DictFactory();
        dictFactory.disPlayResult(stage1(systemDict, getInputText()), "stage1");
        dictFactory.disPlayResult(stage2(systemDict, userDict, getInputText()), "stage2");
        dictFactory.disPlayResult(stage3(systemDict, userDict, getInputText()), "stage3");
    }

    public static void main(String[] args) {
        Start start = new Start();
        List<String> systemDict = new ArrayList<>();
        List<String> userDict = new ArrayList<>();
        start.supplySystemDict(systemDict);
        start.supplyUserDict(userDict);
        start.setSystemDict(systemDict);
        start.setUserDict(userDict);
        start.setInputText("ilikesamsungmobilemango");
        start.begin();
    }


    public Provider stage1(List<String> system, String inputText) {
        DictFactory dictFactory = new DictFactory();
        Provider systemProvider = dictFactory.init(system, inputText);
        return systemProvider;
    }

    //If user provide a customized dictionary of valid English words as additional input, and the program will only find in the user customized dictionary
    public Provider stage2(List<String> system, List<String> user, String inputText) {
        if (user != null && !user.isEmpty()) {
            DictFactory dictFactory = new DictFactory();
            Provider userProvider = dictFactory.init(user, inputText);
            return userProvider;
        } else {
            DictFactory dictFactory = new DictFactory();
            Provider systemProvider = dictFactory.init(system, inputText);
            return systemProvider;
        }
    }

    //If user provide a customized dictionary of valid English words as additional input, and the program will find all the valid words in the both dictionaries
    public Provider stage3(List<String> system, List<String> user, String inputText) {
        Set<String> set = new HashSet<>();
        set.addAll(user);
        set.addAll(system);
        DictFactory dictFactory = new DictFactory();
        Provider userProvider = dictFactory.init(set.stream().collect(Collectors.toList()), inputText);
        return userProvider;
    }

    public List<String> getSystemDict() {
        return systemDict;
    }

    public void setSystemDict(List<String> systemDict) {
        this.systemDict = systemDict;
    }

    public List<String> getUserDict() {
        return userDict;
    }

    public void setUserDict(List<String> userDict) {
        this.userDict = userDict;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
