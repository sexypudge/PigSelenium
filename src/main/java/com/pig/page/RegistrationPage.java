package com.pig.page;

import com.pig.Utils.Utils;
import com.pig.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage{

    @FindBy(id="name")
    private WebElement name;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="pass")
    private WebElement pass;

    @FindBy(id="passRepeat")
    private WebElement passRepeat;

    @FindBy(id="address")
    private WebElement address;

    @FindBy(id="phone")
    private WebElement phone;

    @FindBy(id="register")
    private WebElement registerButton;

    @FindBy(id="message")
    private WebElement message;

    private final WebDriver DRIVER;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(Helper.getDriver(), this);
        this.DRIVER = driver;
        load();
    }

    public void fillLoginForm(String email, String pass, String name, String address, String phone, String passRepeat){
        Utils.clearAndType(this.email, email);
        Utils.clearAndType(this.pass, pass);
        Utils.clearAndType(this.name, name);
        Utils.clearAndType(this.address, address);
        Utils.clearAndType(this.phone, phone);
        Utils.clearAndType(this.passRepeat, passRepeat);
    }

    public void clickButtonRegister(){
        registerButton.click();
    }

    public WebElement getMessage() {
        return message;
    }

    public void setMessage(WebElement message) {
        this.message = message;
    }

    private void load() {
        DRIVER.get("http://localhost/fashion/dang-ky");
    }
}
