package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentInformation {

	WebDriver driver = null;
	private final String cashOnDelivery = "CashOnDelivery";
	private final String paypal = "Paypal";

	@FindBy(id = "tdb6")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@value='cod']")
	private WebElement cashOnDeliveryOption;

	@FindBy(xpath = "//input[@value='paypal_express']")
	private WebElement paypalOption;

	public PaymentInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickPaymentMethod(WebDriverWait wait, String methodOfPayment) {
		if (methodOfPayment.equals(cashOnDelivery)) {
			wait.until(ExpectedConditions.elementToBeClickable(cashOnDeliveryOption));
			cashOnDeliveryOption.click();
		} else if (methodOfPayment.equals(paypal)) {
			wait.until(ExpectedConditions.elementToBeClickable(paypalOption));
			paypalOption.click();
		} else
			System.out.println("INVALID PAYMENT METHOD");
	}

	public void clickContinueOnPaymentInformation(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
	}

}
