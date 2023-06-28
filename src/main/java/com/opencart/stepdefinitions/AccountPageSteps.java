package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String colectedStringKeyWord) throws InterruptedException {
        Thread.sleep(1000);
        boolean urlContainsCollectString = driver.getCurrentUrl().contains(colectedStringKeyWord);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsCollectString, "The " + colectedStringKeyWord + "is present with the url");

    }
}
