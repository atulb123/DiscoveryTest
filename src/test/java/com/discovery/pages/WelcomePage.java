package com.discovery.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.discovery.basetest.BaseClass;
import com.discovery.utils.Context;

public class WelcomePage extends BaseClass {
	@FindBy(xpath = "//section[contains(@class,'ShowCarousel')]//div[contains(.,'Recommended')]/../..//div[contains(@class,'carousel-tile-wrapper')]")
	public List<WebElement> vidoesList;

	@FindBy(xpath = "//section[contains(@class,'ShowCarousel')]//div[contains(.,'Recommended')]/../..//div[contains(@class,'carousel-tile-wrapper')]//h3")
	public List<WebElement> vidoesTitleList;

	@FindBy(xpath = "//section[contains(@class,'ShowCarousel')]//div[contains(.,'Recommended')]/../..//div[contains(@class,'carousel-tile-wrapper')]//div[@class='showTileSquare__description']/div")
	public List<WebElement> vidoesDescriptionList;

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WelcomePage addVidoesToFavourites() {
		for (int i = 0; i < 2; i++) {
			actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(vidoesList.get(i)))).perform();
			Context.videoTitleAndDescription.put("Title_" + i,
					wait.until(ExpectedConditions.visibilityOf(vidoesTitleList.get(i))).getText());
			Context.videoTitleAndDescription.put("Description_" + i,
					wait.until(ExpectedConditions.visibilityOf(vidoesDescriptionList.get(i))).getText());
			wait.until(ExpectedConditions.visibilityOf(vidoesList.get(i))).findElement(By.tagName("i")).click();
		}
		return this;
	}
}
