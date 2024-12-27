package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

	WebDriver driver = null;

	@FindBy(name = "email_address")
	private WebElement emailCase;

	@FindBy(name = "password")
	private WebElement passwordCase;

	@FindBy(id = "tdb1")
	private WebElement signInButton;

	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserCredentials(WebDriverWait wait, String eMail, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		emailCase.clear();
		emailCase.sendKeys(eMail);
		passwordCase.clear();
		passwordCase.sendKeys(password);
		signInButton.submit();
	}

}
