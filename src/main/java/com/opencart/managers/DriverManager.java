package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver was initiated");
                break;
            case "FIREFOX":
                driver = new ChromeDriver();
                System.out.println("The FIREFOX Driver was initiated");
                break;
            case "EDGE":
                driver = new ChromeDriver();
                System.out.println("The Edge Driver was initiated");
                break;
            case "SAFARI":
                driver = new ChromeDriver();
                System.out.println("The Safari Driver was initiated");
                break;
            default:
                System.out.println("there is not defined such a driver" + webDriverType);
        }
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }
}
