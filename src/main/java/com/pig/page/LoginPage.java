package com.pig.page;

import com.pig.Utils.Utils;
import com.pig.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="inputEmail3")
    private WebElement email;

    @FindBy(id="inputPassword")
    private WebElement pass;

    // lay ra the div cua khung message
    @FindBy(id="message")
    private WebElement message;

    // lay ra the button login cua khung message
    @FindBy(id="login")
    private WebElement loginButton;

    private final WebDriver DRIVER;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(Helper.getDriver(), this);
        this.DRIVER = driver;
        load();
    }

    public void fillLoginForm(String email, String pass){
        Utils.clearAndType(this.email, email);
        Utils.clearAndType(this.pass, pass);
    }

    public void clickButtonLogin(){
        loginButton.click();
    }

    public WebElement getMessage() {
        return message;
    }

    public void setMessage(WebElement message) {
        this.message = message;
    }

    private void load() {
    DRIVER.get("http://localhost/fashion/dang-nhap");
}
}
