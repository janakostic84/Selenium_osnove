package d19_09_2022;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapTableTests {

//	Base url: https://s.bootsnipp.com
//		Test #1: Edit Row
//		Podaci:
//		First Name: ime polaznika
//		Last Name: prezime polaznika
//		Middle Name: srednje ime polanzika
//		Koraci:
//		Ucitati stranu /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Klik na Edit dugme prvog reda
//		Sacekati da dijalog za Editovanje bude vidljiv
//		Popuniti formu podacima. 
//		Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi
//		metoda clear. Koristan link
//		Klik na Update dugme
//		Sacekati da dijalog za Editovanje postane nevidljiv
//		Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//		Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//		Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//		Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//		Test #2: Delete Row
//		Podaci:
//		First Name: ime polaznika
//		Last Name: prezime polaznika
//		Middle Name: srednje ime polanzika
//		Koraci:
//		Ucitati stranu /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Klik na Delete dugme prvog reda
//		Sacekati da dijalog za brisanje bude vidljiv
//		Klik na Delete dugme iz dijaloga 
//		Sacekati da dijalog za Editovanje postane nevidljiv
//		Verifikovati da je broj redova u tabeli za jedan manji
//		Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//		Test #3: Take a Screenshot
//		Koraci:
//		Ucitati stranu  /iframe/K5yrx
//		Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//		Kreirati screenshot stranice. Koristan link 
//		https://www.guru99.com/take-screenshot-selenium-webdriver.html
//		Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg.
//		Na putanji: src/paket_za_domaci/nazivslike.png

	private WebDriver driver;
	private WebDriverWait wait;
	String baseUrl = "https://s.bootsnipp.com";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.get(baseUrl);
	}

	@Test(priority = 10)

	public void EditRow() throws InterruptedException {

		driver.get(baseUrl + "/iframe/K5yrx");

		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"ERROR: Unexpected title.");

		driver.findElement(By.xpath("//*[@id='d1']//*[contains(@class, 'update')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='edit']//*[contains(@class, 'modal-content')]")));

		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("fn")).sendKeys("Pera");

		driver.findElement(By.id("ln")).clear();
		driver.findElement(By.id("ln")).sendKeys("Peric");

		driver.findElement(By.id("mn")).clear();
		driver.findElement(By.id("mn")).sendKeys("Zdera");

		driver.findElement(By.id("up")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));

		Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "Pera", "First name should be Pera");
		Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "Peric", "Last name should be Peric");
		Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "Zdera", "Middle name should be Zdera");
	}

	@Test(priority = 10)

	public void DeleteRow() {

		driver.get(baseUrl + "/iframe/K5yrx");

		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"ERROR: Unexpected title.");

		driver.findElement(By.xpath("//*[contains(@class, 'delete')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("del")));

		driver.findElement(By.id("del")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("del")));

		Assert.assertFalse(driver.findElement(By.xpath("//tbody/tr[1]")).isDisplayed(),
				"ERROR: First row should be deleted");

	}

	// @Test (priority = 30)

	// public void TakeAScreenShot {

	// driver.get(baseUrl + "/iframe/K5yrx");

	// Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data -
	// Bootsnipp.com",
	// "ERROR: Unexpected title.");

	// File slika = new File("img/slika.png");
	// File destFile = new File(slika.getAbsolutePath());
	// TakesScreenshot scrShot = ((TakesScreenshot) driver);

//}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
