package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakeManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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

    @And("the PrivacyPolacy is enable")
    public void thePrivacyPolacyIsEnable() {
        try {
            registerPage.switchOnThePrivacyPolacy(driver);
        } catch (InterruptedException e) {
            System.out.println("Error ");
        }

    }

    @And("continueButton is clicked")
    public void continuebuttonIsClicked() {
        registerPage.clickOnContinueButton();
    }
}
