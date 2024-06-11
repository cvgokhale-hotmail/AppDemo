package com.intellias.qa.stepdefinitions;

import com.intellias.qa.pages.BasePage;
import com.intellias.qa.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new DriverManager().initializeDriver();
        System.out.println("Hooks line 16 of Before executed");
        BasePage basePage = new BasePage();
        basePage.closeApp();
        basePage.launchApp();
        System.out.println("Hooks line 20 of Before executed");
    }

//    @BeforeMethod
//    public void launchApp() throws Exception {
//        new DriverManager().initializeDriver();
//        System.out.println("Hooks line 29 of BeforeMethod executed");
//        BasePage basePage = new BasePage();
//        basePage.closeApp();
//        basePage.launchApp();
//        System.out.println("Hooks line 20 of Before executed");
//    }
    @After
    public void quit(Scenario scenario) throws IOException, InterruptedException {
        System.out.println("Hooks line 25 of After executed");
        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("Hooks line 30 of After executed");
        BasePage basePage = new BasePage();
        basePage.closeApp();
        System.out.println("Line 35 executed");
        Thread.sleep(20000);
    }

//    @AfterMethod
//    public void closeApp(Scenario scenario) throws IOException {
//        System.out.println("Hooks line 40 of AfterMethod executed");
//        if(scenario.isFailed()){
//            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
//        System.out.println("Hooks line 45 of AfterMethod executed");
//        BasePage basePage = new BasePage();
//        basePage.closeApp();
//        System.out.println("Line 49 executed");
//    }
}

