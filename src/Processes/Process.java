package Processes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Screens.Catalog;
import Screens.DeliveryInformation;
import Screens.ManufacturerCatalog;
import Screens.OrderConfirmation;
import Screens.OrderProcessed;
import Screens.PaymentInformation;
import Screens.ProductSheet;
import Screens.ShoppingCart;
import Screens.SignIn;

public abstract class Process {
	private static final int ESPERA = 10;

	protected WebDriverWait wait;
	protected WebDriver driver;

	public Catalog catalog;
	public DeliveryInformation deliveryInformation;
	public OrderConfirmation orderConfirmation;
	public PaymentInformation paymentInformation;
	public ProductSheet productSheet;
	public ShoppingCart shoppingCart;
	public SignIn signIn;
	public ManufacturerCatalog manufacturerCatalog;
	public OrderProcessed orderProcessed;

	public Process(WebDriver driver) {
		processInitialization(driver);
	}

	public abstract void executeProcess();

	private void processInitialization(WebDriver driver) {
		this.driver = driver;
		catalog = new Catalog(driver);
		deliveryInformation = new DeliveryInformation(driver);
		manufacturerCatalog = new ManufacturerCatalog(driver);
		orderConfirmation = new OrderConfirmation(driver);
		paymentInformation = new PaymentInformation(driver);
		productSheet = new ProductSheet(driver);
		shoppingCart = new ShoppingCart(driver);
		signIn = new SignIn(driver);
		orderProcessed = new OrderProcessed(driver);
		wait = new WebDriverWait(driver, ESPERA);
	}

}
