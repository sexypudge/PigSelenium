package com.pig;

import com.pig.Utils.ReadUtil;
import com.pig.Utils.WriteUtil;
import com.pig.helper.Helper;
import com.pig.model.Login;
import com.pig.model.Registration;
import com.pig.testcase.LoginCase;
import com.pig.testcase.RegistrationCase;
import com.pig.testcase.TestCase;

import java.util.ArrayList;
import java.util.List;

import static com.pig.Utils.WriteUtil.LOGIN;
import static com.pig.Utils.WriteUtil.REGISTRATION;

public class TestExecutor {

    private static final String FILE_NAME = "D:\\PigSelenium\\PigSelenium\\src\\main\\java\\com\\pig\\document\\data.xlsx";

    public static void main(String[] args) {

//        // -------------- LOGIN --------------
//        // Doc thong tin file
//        List<Login> loginList = ReadUtil.readLogins(FILE_NAME);
//        List<LoginCase> loginCaseList = new ArrayList<>();
//        // for each de chuan bi du~ lieu cho test case Login (bao gom driver, thong tin email, password, ket qua mong muon)
//        loginList.forEach( login -> {
//            LoginCase loginCase =  new LoginCase(Helper.getDriver(), login.getEmail(), login.getPassword(), login.getMessageResult());
//            loginCaseList.add(loginCase);
//        });
//
//        List<TestCase> lst = new ArrayList<>(loginCaseList);
//        // Chay. test case Login
//        new TestExecutor().run(lst, LOGIN);

        // -------------- REGISTRATION --------------
        List<Registration> registrationList = ReadUtil.readRegistrations(FILE_NAME);
        List<RegistrationCase> registrationCaseList = new ArrayList<>();
        // for each de chuan bi du~ lieu cho test case RegistrationCase
        registrationList.forEach( login -> {
            RegistrationCase registrationCase =  new RegistrationCase(Helper.getDriver(), login.getName(),
                    login.getEmail(), login.getPass(), login.getPassRepeat(),
                    login.getAddress(), login.getPhone(), login.getMessageResult());
            registrationCaseList.add(registrationCase);
        });

        List<TestCase> registrationCases = new ArrayList<>(registrationCaseList);
        new TestExecutor().run(registrationCases, REGISTRATION);
        // close driver
        Helper.getDriver().close();
    }

    private void run(List<TestCase> lst, int flagPage) {
        List<Boolean> resultsList = new ArrayList<>();
        int i = 1;
        for (TestCase t : lst) {
            resultsList.add(t.execute());
            System.out.println("Test case " + i + " : " + t.execute());
            i ++;
        }
        WriteUtil.write(FILE_NAME, resultsList, flagPage);
    }
}
