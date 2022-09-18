package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
	
//		Napisati program koji ucitava stranicu https://www.plus2net.com/jquery/msg-demo/dropdown3.php
//		Bira Country, State i City po vasoj zelji
//		Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//		I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//		Izabrerit Country, State i City tako da imate podatke da selektujete!

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");
		
		Select selectCountry = new Select(driver.findElement(By.name("country_code")));
		selectCountry.selectByVisibleText("INDIA");
		
		Select selectState = new Select(driver.findElement(By.name("state_id")));
		selectState.selectByValue("3");
		
		Select selectCity = new Select(driver.findElement(By.name("city_id")));
		selectCity.selectByValue("1");
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		

	}

}
