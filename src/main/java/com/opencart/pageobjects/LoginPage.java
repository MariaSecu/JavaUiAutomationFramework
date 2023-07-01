package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButtonInput;

    public void fillInLoginForm(String email, String password) {
        emailInput.sendKeys(email);
        System.out.println("Entered email:" + email);
        passwordInput.sendKeys(password);
        System.out.println("Entered password: " + password);
    }

    public void clickLoginBtn() {
        loginButtonInput.click();
        System.out.println("The login button was clicked");
    }

}
