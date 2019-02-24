package com.pig.testcase;

import com.pig.helper.Helper;
import com.pig.page.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginCase implements TestCase{
    private WebDriver driver;

    public LoginCase(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void execute() {
        LoginPage page = new LoginPage(this.driver);
        try {
            page.fillName(Helper.getInstance().getConfig("user.name"));
            page.fillPass(Helper.getInstance().getConfig("user.pass"));
            page.fillPass(Helper.getInstance().getConfig("user.pass"));
            page.fillPass(Helper.getInstance().getConfig("user.pass"));
            page.fillPass(Helper.getInstance().getConfig("user.pass"));
            page.fillPass(Helper.getInstance().getConfig("user.pass"));
            page.fillPass(Helper.getInstance().getConfig("user.pass"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
