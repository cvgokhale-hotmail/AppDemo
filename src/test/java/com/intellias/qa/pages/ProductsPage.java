package com.intellias.qa.pages;

//import com.intellias.qa.utils.GlobalParams;
import com.intellias.qa.utils.DriverManager;
import com.intellias.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends MenuPage {
    TestUtils utils = new TestUtils();
    private AppiumDriver driver;

    //	@AndroidFindBy (xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding-sibling::android.view.ViewGroup/android.widget.TextView")
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Products']")
    private WebElement titleTxt;

    public ProductsPage()  {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public String getTitle() {
        return getText(titleTxt, "product page title is - ");
    }

}

