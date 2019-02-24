package com.pig.testcase;

import com.pig.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginCase implements TestCase{

    private String email;

    private String pass;

    private String resultMessage;

    private WebDriver driver;

    public LoginCase(WebDriver driver, String email, String pass, String resultMessage) {
        this.email = email;
        this.pass = pass;
        this.resultMessage = resultMessage;
        this.driver = driver;
    }

    @Override
    public boolean execute() {
        LoginPage page = new LoginPage(this.driver);
        // fill form
        page.fillLoginForm(email, pass);
        // sau khi dien form xong thi chuong trinh se~ click button login
        page.clickButtonLogin();

        // check ket qua mong muon tu` file excel vs cac' element tren man hinh va` return ket qua
        if("Đăng nhập thành công.".equals(resultMessage)){
            return "http://localhost/fashion/".equals(driver.getCurrentUrl());
        }

        return resultMessage.equals(page.getMessage().getText());
    }
}
