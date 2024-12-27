package Processes;

import org.openqa.selenium.WebDriver;

public class PurchaseProcess extends Process {

	private String url;
	private String product;
	private String quantity;
	private String methodOfPayment;
	private String email;
	private String password;

	public PurchaseProcess(WebDriver driver, String url, String product, String quantity, String methodOfPayment,
			String email, String password) {

		super(driver);
		this.url = url;
		this.product = product;
		this.quantity = quantity;
		this.methodOfPayment = methodOfPayment;
		this.email = email;
		this.password = password;
	}

	private void enterSite(String url) {
		driver.get(url);
	}

	private void selectProduct(String product) {
		if (product.equals("SamsungGalaxyTab")) {
			catalog.clickManufacturerSamsung(wait);
			manufacturerCatalog.clickSamsungGalaxyTab(wait);
		} else if (product.equals("Beloved")) {
			catalog.clickManufacturerWarner(wait);
			manufacturerCatalog.clickBeloved(wait);
		}
	}

	public void addToCart() {
		productSheet.clickAddToCart(wait);
	}

	public void updateQuantityCart(String quantity) {
		shoppingCart.updateQuantity(wait, quantity);
		shoppingCart.clickCheckout(wait);
	}

	public void signInAccount() {
		signIn.enterUserCredentials(wait, email, password);
	}

	public void processDelivery() {
		deliveryInformation.clickContinueOnDeliveryInformation(wait);
	}

	public void processPayment() {
		paymentInformation.clickPaymentMethod(wait, methodOfPayment);
		paymentInformation.clickContinueOnPaymentInformation(wait);
	}

	public void processConfirmation() {
		orderConfirmation.clickConfirmOrder(wait);
	}

	public void verifyProcess() {
		orderProcessed.verifyOrder(wait);
	}

	@Override
	public void executeProcess() {
		enterSite(url);
		selectProduct(product);
		addToCart();
		updateQuantityCart(quantity);
		signInAccount();
		processDelivery();
		processPayment();
		processConfirmation();
		verifyProcess();
	}

}
