package com.intellias.qa.runners;
import com.intellias.qa.utils.DriverManager;
import com.intellias.qa.utils.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.testng.annotations.*;

public class RunnerBase {
    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner(){
        return testNGCucumberRunner.get();
    }

    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }

//    @Parameters({"platformName", "udid", "deviceName", "systemPort",
//            })
    @BeforeClass(alwaysRun = true)
    public void setUpClass(@Optional("Android") String platformName, @Optional("emulator-5554") String udid, @Optional("Pixel_3a") String deviceName,
                           @Optional("4723") String systemPort, @Optional("Android") String chromeDriverPort
                           ) throws Exception {

        ThreadContext.put("ROUTINGKEY", platformName + "_" + deviceName);
        //new ServerManager().startServer();
        //new DriverManager().initializeDriver();
        System.out.println("Line 31 executed");
        setRunner(new TestNGCucumberRunner(this.getClass()));
        System.out.println("Line 33 executed");
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        System.out.println("Line 49 executed");
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }



//        ServerManager serverManager = new ServerManager();
//        if(serverManager.getServer() != null){
//            serverManager.getServer().stop();
//        }
        if(testNGCucumberRunner != null){
            getRunner().finish();
        }
    }
}

