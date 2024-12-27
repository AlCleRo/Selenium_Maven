package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import Processes.PurchaseProcess;
import io.github.bonigarcia.wdm.WebDriverManager;

class TestCase1 {

	private static WebDriver driver;
	private static ChromeOptions chromeOptions;

	// URL
	private final String url = "<url>";

	// INSERT ACCOUNT + Method of payment
	private String email = "<email>";
	private String password = "<password>";
	private String methodOfPayment = "CashOnDelivery"; // must be CashOnDelivery or Paypal (paypal screen code must be implemented yet)

	// INITIALIZATION TEST VARIABLES
	private String product = "";
	private String quantity = "";

	public static void createAndStartService() throws IOException {
		WebDriverManager.chromedriver().setup();
		ArrayList<String> optionsList = new ArrayList<String>();
		chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

	}

	public static void createDriver() {
		driver = new ChromeDriver(chromeOptions);
	}

	public static void quitDriver() {
		driver.quit();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		createAndStartService();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		createDriver();
		driver.manage().window().maximize();

	}

	@AfterEach
	void tearDown() throws Exception {
		quitDriver();
	}

	@Test
	void test1() {
		product = "SamsungGalaxyTab";
		quantity = "2";
		PurchaseProcess purchaseProcess = new PurchaseProcess(driver, url, product, quantity, methodOfPayment, email,
				password);
		purchaseProcess.executeProcess();
	}

	@Test
	void test2() {
		product = "Beloved";
		quantity = "3";
		PurchaseProcess purchaseProcess = new PurchaseProcess(driver, url, product, quantity, methodOfPayment, email,
				password);
		purchaseProcess.executeProcess();
	}

}
