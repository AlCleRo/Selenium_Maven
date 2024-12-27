package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalog {

	WebDriver driver = null;

	@FindBy(name = "manufacturers_id")
	private WebElement manufacturersList;

	public Catalog(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickManufacturerSamsung(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(manufacturersList));
		Select drpManufacturers = new Select(manufacturersList);
		drpManufacturers.selectByVisibleText("Samsung");
	}

	public void clickManufacturerWarner(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(manufacturersList));
		Select drpManufacturers = new Select(manufacturersList);
		drpManufacturers.selectByVisibleText("Warner");
	}

}
