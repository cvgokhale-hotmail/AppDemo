package com.intellias.qa.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/Pixel_3a/cucumber/report.html"
                , "summary"
//        , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"
        }
        ,features = {"src/test/resources/features"}
        ,glue = {"com.intellias.qa.stepdefinitions"}
        ,dryRun=false
        ,monochrome=true
        ,tags = "@Test"
)
public class MyPixel3aTestNGRunnerTest extends RunnerBase {
}
