package com.intellias.qa.stepdefinitions;

import com.intellias.qa.pages.LoginPage;
import com.intellias.qa.pages.MenuPage;
import com.intellias.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {

    @Given("I am on login page")
    public void iMLoggedIn() throws InterruptedException {
        Thread.sleep(5000);
        new MenuPage().pressSettingsBtn();
        new MenuPage().pressLogoutBtn();
    }
}
