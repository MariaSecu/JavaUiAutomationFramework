package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    static int counter = 0;

    @BeforeAll
    public static void beforAllTheTestsAreExecuted() {
        System.out.println("The execution started");
    }

    @Before
    public void beforEachTest() {
        counter++;
        System.out.println("The [" + counter + "]  test started");
    }

    @After
    public void afterEachTest() {
        DriverManager.getInstance().quiteTheDriver();
        System.out.println("The [" + counter + "] test finished");
    }

    @AfterAll
    public static void afterAllTestsAreExecuted() {
        System.out.println("The execution of all features is finished");
    }
}
