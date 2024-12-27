package Screens;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProcessed {

	WebDriver driver = null;
	private final String messageVerification = "Your Order Has Been Processed!";

	@FindBy(xpath = "//h1")
	private WebElement confirmOrderButton;

	public OrderProcessed(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyOrder(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
		Assertions.assertEquals(messageVerification, confirmOrderButton.getText(), "FAILED ORDER VERIFICATION");
	}

}
