package com.pig;

import com.pig.helper.Helper;
import com.pig.testcase.LoginCase;
import com.pig.testcase.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestExecutor {

    public static void main(String[] args) {
        LoginCase loginCase =  new LoginCase(Helper.getDriver());
        List<TestCase> lst = new ArrayList<TestCase>();
        lst.add(loginCase);
        new TestExecutor().run(lst);
    }

    private void run(List<TestCase> lst) {
        for (TestCase t : lst) {
            t.execute();
        }
    }
}
