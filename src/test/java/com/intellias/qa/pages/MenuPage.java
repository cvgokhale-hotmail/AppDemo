package com.intellias.qa.pages;
import com.intellias.qa.utils.DriverManager;
import com.intellias.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage{
    TestUtils utils = new TestUtils();
    private AppiumDriver driver;

    @AndroidFindBy (uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(0)" +
            "")
    private WebElement settingsBtn;

    @AndroidFindBy (uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(6)" +
            "")
    private WebElement logoutBtn;

    public MenuPage()  {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MenuPage pressSettingsBtn() {
        click(settingsBtn, "press Settings button");
        return new MenuPage();
    }

    public MenuPage pressLogoutBtn() {
        click(logoutBtn, "press Logout button");
        return new MenuPage();
    }

}