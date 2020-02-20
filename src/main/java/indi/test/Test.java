package indi.test;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testStage1() {
        List<String> userDict = new ArrayList<String>();
        List<String> systemDict = new ArrayList<String>();
        String inputText = "ilikesamsungmobilemango";
        init(userDict, systemDict);
        Assert.assertTrue("Exists -> i like samsung mobile man go",new Start().stage1(systemDict, inputText).getTemp().contains("i like samsung mobile man go"));
    }

    public void init(List<String> userDict, List<String> systemDict) {
        supplyUserDict(userDict);
        supplySystemDict(systemDict);
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
}
