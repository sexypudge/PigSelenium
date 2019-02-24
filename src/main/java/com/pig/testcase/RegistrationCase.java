package com.pig.testcase;

import com.pig.page.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegistrationCase implements TestCase {

    private String name;

    private String email;

    private String pass;

    private String passRepeat;

    private String address;

    private String phone;

    private String resultMessage;

    private WebDriver driver;

    public RegistrationCase(WebDriver driver, String name, String email,
                            String pass, String passRepeat,
                            String address, String phone, String resultMessage) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.passRepeat = passRepeat;
        this.address = address;
        this.phone = phone;
        this.resultMessage = resultMessage;
        this.driver = driver;
    }

    @Override
    public boolean execute() {
        RegistrationPage page = new RegistrationPage(this.driver);
        // fill form
        page.fillLoginForm(email, pass, name, address, phone,  passRepeat);
        // sau khi dien form xong thi chuong trinh se~ click button Register
        page.clickButtonRegister();

        // check ket qua mong muon tu` file excel vs cac' element tren man hinh va` return ket qua
        return resultMessage.equals(page.getMessage().getText());
    }
}
