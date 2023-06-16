package com.opencart;

import com.opencart.managers.DataFakeManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.md/");
        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");
        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        accountIcon.click();
        WebElement registerButton = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerButton.click();

        String firstName = DataFakeManager.getRandomName();
        System.out.println("The generated first name is: " + firstName);
        String randomEmail = DataFakeManager.getRandomEmail();
        System.out.println("The generated email is: " + randomEmail);

        String lastName = DataFakeManager.getRandomName();
        System.out.println("The generated last name is: " + lastName);

        String randomPassword = DataFakeManager.getRandomPassword(20, 25);
        System.out.println("The generated password is: " + randomPassword);

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='input-email']"));
        emailInput.sendKeys(randomEmail);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='input-password']"));
        passwordInput.sendKeys(randomPassword);
        Thread.sleep(500);

        WebElement privacyCheckBox = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(driver, privacyCheckBox);
        privacyCheckBox.click();

        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement continueNavigate = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        continueNavigate.click();
        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.get("https://andreisecuqa.host/");
        driver.quit();
        System.out.println("The execution was finished");
    }
}