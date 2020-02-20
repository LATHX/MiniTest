package indi.test.factory;

import indi.test.model.Dict;
import indi.test.model.Provider;
import indi.test.util.Utils;

import java.util.*;

public class DictFactory {
    public void convert(String text, Map<Character, Dict> dictMap) {
        Map<Character, Dict> dictMapNext = dictMap;
        Dict dict = null;
        boolean isEnd = false;
        if (Utils.isNotEmpty(text)) {
            for (int i = 0; i < text.length(); i++) {
                Character letter = text.charAt(i);
                if (dictMapNext.containsKey(letter)) {
                    dict = dictMapNext.get(letter);
                    dictMapNext = dict.getNext();
                    continue;
                } else {
                    dict = new Dict();
                    dictMapNext.put(letter, dict);
                }
                if (i == text.length() - 1) {
                    dict.setLetter(letter);
                    dict.setEnd(true);
                    dict.setNext(new HashMap<>());
                }else {
                    dict.setLetter(letter);
                    dict.setEnd(false);
                    Map<Character, Dict> newMap = null;
                    if (dict.getNext() == null) {
                        newMap = new HashMap<>();
                    } else {
                        newMap = dict.getNext();
                    }
                    dict.setNext(newMap);
                    dictMapNext = newMap;
                }
            }
        }
    }

    public Provider init(List<String> list, String inputText) {
        Map<Character, Dict> dictMap = new HashMap<>();
        Stack<Character> characterStack = new Stack<>();
        Map<String, List<String>> record = new HashMap<>();
        Set<String> temp = new HashSet<>();
        Provider provider = new Provider();
        provider.setDictMap(dictMap);
        provider.setLetterList(list);
        provider.setTemp(temp);
        provider.setCharacterStack(characterStack);
        provider.setRecord(record);
        convert(list, provider);
//        textToStack(inputText, provider);
        split(provider, inputText, "");
        return provider;
    }

    public void split(Provider provider, String inputText, String temp) {
        List<String> letterList = provider.getLetterList();
        if (Utils.isEmpty(inputText)) {
            provider.getTemp().add(temp.trim());
        }
        for (int i = 0; i < letterList.size(); i++) {
            Set<String> strings = provider.getRecord().keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (inputText.startsWith(s)) {
                    List<String> strings1 = provider.getRecord().get(s);
                    for (int i1 = 0; i1 < strings1.size(); i1++) {
                        split(provider, inputText.substring(strings1.get(i1).replaceAll(" ", "").length()), temp + strings1.get(i1) + " ");
                    }
                }
            }
            if (inputText.startsWith(letterList.get(i))) {
                split(provider, inputText.substring(letterList.get(i).length()), temp + letterList.get(i) + " ");
            }
        }
    }

    private void convert(List<String> list, Provider provider) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(" ")) {
                String key = list.get(i).replaceAll(" ", "");
                if (provider.getRecord().containsKey(key)) {
                    List<String> strings = provider.getRecord().get(key);
                    strings.add(list.get(i));
                } else {
                    List<String> lists = new ArrayList<>();
                    lists.add(list.get(i));
                    provider.getRecord().put(key, lists);
                }
            }
        }
    }

    private void convert(List<String> list, Map<Character, Dict> dictMap) {
        Map<Character, Dict> dictMapNext = dictMap;
        for (int i = 0; i < list.size(); i++) {
            convert(list.get(i), dictMapNext);
            dictMapNext = dictMap;
        }
    }

    private void textToStack(String inputText, Provider provider) {
        for (int i = inputText.length() - 1; i >= 0; i--) {
            provider.getCharacterStack().push(inputText.charAt(i));
        }
    }

    private void split(Provider provider) {
        Stack<Character> stack = provider.getCharacterStack();
        Map<Character, Dict> dictMap = provider.getDictMap();
        Map<Character, Dict> nextDict = dictMap;
        Map<String, List<String>> record = provider.getRecord();
        List<String> recordEachTime = new ArrayList<>();
        Set<String> set = new HashSet<>();
        StringBuilder temp = new StringBuilder("");
        boolean isLetterStart = true;
        StringBuilder sb = new StringBuilder("");
        int curTime = 0;
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (isLetterStart) {
                isLetterStart = false;
            }
            Dict dict = nextDict.get(c);
            if (dict == null) {
                continue;
            }
            nextDict = dict.getNext();
            sb.append(c);
            temp.append(c);
            if (nextDict == null) {
                continue;
            }
            if (dict.isEnd()) {
                recordEachTime.add(temp.toString());
                temp.setLength(0);
                curTime++;
                isLetterStart = true;
                nextDict = dictMap;
                sb.append(" ");
            }

        }
        String s = sb.toString().trim().replaceAll("%", " ");
        set.add(s);
        System.out.println(s);
    }

    public void disPlayResult(Provider provider, String title) {
        System.out.println("------------------" + title + "------------------");
        Iterator<String> iterator = provider.getTemp().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
