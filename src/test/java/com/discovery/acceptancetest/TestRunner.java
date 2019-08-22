package com.discovery.acceptancetest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", glue = { "com.discovery"}, tags = { "@test_001" })
public class TestRunner {
}
