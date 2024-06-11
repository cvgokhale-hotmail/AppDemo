package com.intellias.qa.stepdefinitions;

import com.intellias.qa.pages.LoginPage;
import com.intellias.qa.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
//import org.junit.Assert;

public class LoginStepDef {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("I click on login button")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String expected) {
        Assert.assertEquals(new LoginPage().getErrTxt(), expected);

    }

    @Then("login should fail with lockedUser error {string}")
    public void loginShouldFailWithLockedUserError(String expected) {
        Assert.assertEquals(new LoginPage().getLockedUserErrTxt(), expected);

    }

    @Then("login should fail with password error {string}")
    public void loginShouldFailWithPasswordError( String expected) {
        Assert.assertEquals(new LoginPage().getPasswordErrTxt(), expected);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }

    @Then("login should fail with username error {string}")
    public void loginShouldFailWithUsernameError(String expected) {
        Assert.assertEquals(new LoginPage().getUsernameErrTxt(), expected);
    }
}