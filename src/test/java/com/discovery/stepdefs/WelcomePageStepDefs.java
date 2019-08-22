package com.discovery.stepdefs;

import com.discovery.basetest.BaseClass;
import com.discovery.pages.MyVideosPage;
import com.discovery.pages.WelcomePage;
import com.discovery.utils.Context;
import com.discovery.utils.UtilityMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class WelcomePageStepDefs extends BaseClass {

	private WelcomePage welcomePage = new WelcomePage(driver);
	private MyVideosPage myVideosPage = new MyVideosPage(driver);

	@Given("^I launch discover website$")
	public void i_launch_discover_website() throws Throwable {
		driver.get(UtilityMethods.getPropertyValues("welcompageurl"));
	}

	@Given("^I add two vidoes to favourite list$")
	public void i_add_two_vidoes_to_favourite_list() throws Throwable {
		welcomePage.addVidoesToFavourites();
	}

	@When("^I navigate to my vidoes page$")
	public void i_navigate_to_my_vidoes_page() throws Throwable {
		driver.get(UtilityMethods.getPropertyValues("myvidoesurl"));
		myVideosPage.getFavouriteVideoTitleAndDescription();
	}

	@Then("^I should see cooresponding vidoes with same name and title in my videos page$")
	public void i_should_see_cooresponding_vidoes_with_same_name_and_title_in_my_videos_page() throws Throwable {
		for (int i = 0; i < 2; i++) {
			Assert.assertTrue("Video Title and description text mismatch",
					Context.videoTitleAndDescription.equals(Context.favouriteVideoTitleAndDescription));
		}
	}
}
