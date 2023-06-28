package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps {

    HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());

    @Given("Home Page is accessed")
    public void homePageIsAccessed() {
        DriverManager.getInstance().getDriver().get("https://andreisecuqa.host/");
    }

    @And("RegisterPage is accessed from HomePage menu")
    public void registerPageIsAccessedFromHomePageMenu() {
        homePage.navigateToRegisterPage();
    }
}
