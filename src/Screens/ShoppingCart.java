package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	WebDriver driver = null;

	@FindBy(name = "cart_quantity[]")
	private WebElement cartQuantity;

	@FindBy(id = "tdb4")
	private WebElement updateButton;

	@FindBy(id = "tdb5")
	private WebElement checkOut;

	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void updateQuantity(WebDriverWait wait, String quantity) {
		wait.until(ExpectedConditions.elementToBeClickable(cartQuantity));
		cartQuantity.clear();
		cartQuantity.sendKeys(quantity);
		wait.until(ExpectedConditions.elementToBeClickable(updateButton));
		updateButton.click();
	}

	public void clickCheckout(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(checkOut));
		checkOut.click();
	}

}
