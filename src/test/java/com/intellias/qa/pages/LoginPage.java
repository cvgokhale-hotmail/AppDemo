package com.intellias.qa.pages;

import com.intellias.qa.utils.DriverManager;
import com.intellias.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    TestUtils utils = new TestUtils();
    private AppiumDriver driver;

    @AndroidFindBy (accessibility = "Username input field")
    private WebElement usernameTxtFld;

    @AndroidFindBy (accessibility = "Password input field")
    private WebElement passwordTxtFld;

    @AndroidFindBy (accessibility = "Login button")
    private WebElement loginBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Provided credentials do not match any user in this service.\")")
    private WebElement errTxt;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sorry, this user has been locked out.\")")
    private WebElement lockedUserErrorText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password is required\")")
    private WebElement passworderrText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Username is required\")")
    private WebElement usernameerrText;

    public LoginPage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public LoginPage enterUserName(String username) throws InterruptedException {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld, username, "login with " + username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld, password, "password is " + password);
        return this;
    }

    public ProductsPage pressLoginBtn() {
        click(loginBtn, "press login button");
        return new ProductsPage();
    }

    public ProductsPage login(String username, String password) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrTxt() {
        String err = getText(errTxt, "error text is - ");
        return err;
    }

    public String getLockedUserErrTxt() {
        String err = getText(lockedUserErrorText, "error text is - ");
        return err;
    }

    public String getPasswordErrTxt() {
        String err = getText(passworderrText, "error text is - ");
        return err;
    }

    public String getUsernameErrTxt() {
        String err = getText(usernameerrText, "error text is - ");
        return err;
    }
}
