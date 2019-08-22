package com.discovery.hooks;

import com.discovery.basetest.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends BaseClass {
	@Before("@Hooks")
	public void browserInitialization() {
		launchBrowser();
	}

	@After("@Hooks")
	public void closeBrowser(Scenario scenario) {
		driver.close();
	}
}