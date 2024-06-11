//package com.intellias.qa.utils;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URI;
//import java.util.Properties;
//
//public class CapabilitiesManager {
//    TestUtils utils = new TestUtils();
//
//    public DesiredCapabilities getCaps() throws IOException {
//// Assign all standard values here include automation name, platformName, deviceName, app and udid)
//        try{
//            utils.log().info("getting capabilities");
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("udid", "emulator-5554");
//            caps.setCapability("deviceName", "pixel_3a");
//            caps.setCapability("automationName", "uiAutomator2");
////            caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
//            caps.setCapability("appActivity", "Android-MyDemoAppRN.1.3.0.build-244");
//            caps.setCapability("systemPort", "4723");
//
//            String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
//
//            utils.log().info("appUrl is" + androidAppUrl);
//            URI url = new URI("http://127.0.0.1:4723");
//
//
//            caps.setCapability("app", androidAppUrl);
//            return caps;
//
//        } catch(Exception e){
//            e.printStackTrace();
//            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
//            throw e;
//        }
//    }
//}
//
