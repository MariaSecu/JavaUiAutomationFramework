package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("the following set of credentials is entered into the login form:")
    public void theFollowingSetOfCredentialsIsEnteredIntoTheLoginForm(List<String> userDetailsList) {
        String emailValue = userDetailsList.get(0);
        String passwordValue = userDetailsList.get(1);
        loginPage.fillInLoginForm(emailValue, passwordValue);
    }

    @When("login button is clicked")
    public void loginButtonIsClicked() {
        loginPage.clickLoginBtn();
    }

}
