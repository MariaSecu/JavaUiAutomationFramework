package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-edge-driver/4.9.1");

        driver.close();
        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://www.google.com/");
        driver.quit();
        System.out.println("The driver is closed");
    }
}