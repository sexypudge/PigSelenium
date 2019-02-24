package com.pig.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id="xxx")
    private WebElement name;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="xxx")
    private WebElement pass;

    @FindBy(id="xxx")
    private WebElement passRepeat;

    @FindBy(id="xxx")
    private WebElement address;

    @FindBy(id="xxx")
    private WebElement phone;

    private final WebDriver DRIVER;

    public LoginPage(WebDriver driver) {
        this.DRIVER = driver;
        load();
    }

    public void fillName(String name) {
        clearAndType(this.name, name);
    }

    public void fillPass(String pass) {
        clearAndType(this.pass, pass);
    }

    public void fillPassRepeat(String passRepeat) {
        clearAndType(this.passRepeat, passRepeat);
    }

    public void fillAddress(String address) {
        clearAndType(this.address, address);
    }

    public void fillPhone(String phone) {
        clearAndType(this.phone, phone);
    }

    public void fillEmail(String email) {
        clearAndType(this.email, email);
    }

    public void clearAndType(WebElement e, String value) {
        e.clear();
        e.sendKeys(value);
    }

    private void load() {
    DRIVER.get("http://localhost:8080/imagebusiness/login");
}
}
