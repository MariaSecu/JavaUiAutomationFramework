package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The {string} link is accessed")
    public void theLinkIsAccessed(String urlValue) {
        driver.get(urlValue);
        System.out.println("The" + urlValue + "was accessed by the driver");
    }

    @Then("the following error messages is displayed:")
    public void theFollowingErrorMessagesIsDisplayed(List<String> errorMessageList) throws InterruptedException {
        for (int i = 0; i < errorMessageList.size(); i++) {
            Thread.sleep(500);
            String elementXpath = ".//*[contains(text(),'" + errorMessageList.get(i) + "')]";
            WebElement errorMessageElement = driver.findElement(By.xpath(elementXpath));
            boolean isErrorMessageNumberIDisplayed = errorMessageElement.isDisplayed();
            Assertions.assertTrue(isErrorMessageNumberIDisplayed, "The error message" + errorMessageList.get(i) + "is displayed");
        }
    }

    @Then("the url contains the following keyword: {string}")
    public void theUrlContainsTheFollowingKeyword(String keyword) throws InterruptedException {
        Thread.sleep(500);
        boolean urlContainsCollectString = driver.getCurrentUrl().contains(keyword);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(urlContainsCollectString, "The " + keyword + "is present with the url");

    }

    @When("{string} from {string} is clicked")
    public void fromIsClicked(String elementName, String elementContainingPage) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            Class classInstance = Class.forName("com.opencart.pageobjects." + elementContainingPage);
            Field webElementField = classInstance.getDeclaredField(elementName);
            webElementField.setAccessible(true);
            WebElement webElementToBeClicked = (WebElement) webElementField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            ScrollManager.scrollToElement(webElementToBeClicked);
            webElementToBeClicked.click();
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
