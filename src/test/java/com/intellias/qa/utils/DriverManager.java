package com.intellias.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    TestUtils utils = new TestUtils();
    DesiredCapabilities caps = new DesiredCapabilities();
    public DesiredCapabilities getCaps() throws IOException, URISyntaxException {
// Assign all standard values here include automation name, platformName, deviceName, app and udid)
        try {
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("deviceName", "pixel_3a");
            caps.setCapability("automationName", "uiAutomator2");
            //            caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
            //caps.setCapability("appActivity", "Android-MyDemoAppRN.1.3.0.build-244");
            caps.setCapability("systemPort", "10001");

            String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "apps" + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

            caps.setCapability("app", androidAppUrl);
        }
        catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
        return caps;
    }
    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        if(driver == null){
            try{
                URI url = new URI("http://127.0.0.1:4723");
                driver = new AndroidDriver(url.toURL(), getCaps());

                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
               this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

}
