package com.discovery.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.discovery.basetest.BaseClass;
import com.discovery.utils.Context;

public class MyVideosPage extends BaseClass {
	@FindBy(xpath = "//section[contains(@class,'FavoriteShowsCarousel')]//div[contains(@class,'carousel__tileWrapper')]")
	public List<WebElement> favouriteVidoesList;

	@FindBy(xpath = "//section[contains(@class,'FavoriteShowsCarousel')]//div[contains(@class,'carousel__tileWrapper')]//h3")
	public List<WebElement> favouriteVidoesTitleList;

	@FindBy(xpath = "//section[contains(@class,'FavoriteShowsCarousel')]//div[contains(@class,'carousel__tileWrapper')]//div[@class='showTileSquare__description']/div")
	public List<WebElement> favouriteVidoesDescriptionList;

	public MyVideosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public MyVideosPage getFavouriteVideoTitleAndDescription() {
		for (int i = 0; i < 2; i++) {
			actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(favouriteVidoesList.get(i)))).perform();
			Context.favouriteVideoTitleAndDescription.put("Title_" + i,
					wait.until(ExpectedConditions.visibilityOf(favouriteVidoesTitleList.get(i))).getText());
			Context.favouriteVideoTitleAndDescription.put("Description_" + i,
					wait.until(ExpectedConditions.visibilityOf(favouriteVidoesDescriptionList.get(i))).getText());
		}
		return this;
	}
}
