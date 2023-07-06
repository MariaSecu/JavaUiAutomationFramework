package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakeManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.Data;
import java.util.Map;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String firstName = DataFakeManager.getRandomName();
        String lastName = DataFakeManager.getRandomName();
        String randomEmail = DataFakeManager.getRandomEmail();
        String randomPassword = DataFakeManager.getRandomPassword(20, 25);
        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, randomPassword);

    }

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String> userDetailMap) throws InterruptedException {
        String firstNameValue = userDetailMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataFakeManager.getRandomName();
        }
        String lastNameValue = userDetailMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = DataFakeManager.getRandomName();
        }

        String emailValue = userDetailMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = DataFakeManager.getRandomEmail();
        }

        String passwordValue = userDetailMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = DataFakeManager.getRandomPassword(5, 12);
        }

        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);
        registerPage.scrollFromContinueBtn(driver);
    }

}
