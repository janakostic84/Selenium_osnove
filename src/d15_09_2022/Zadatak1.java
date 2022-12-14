package d15_09_2022;



import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	
//	  Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//	  Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika
//	  element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//	  POMOC: Brisite elemente odozdo.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		
		
		List<WebElement>elements = driver.findElements(By.className("close"));
		
		for (int i = elements.size(); i <= 1; i--) {
			driver.findElement((By.className("close"))).click();
		  }
			
			try {
				driver.findElement(By.className("close"));
				}
			catch(NoSuchElementException error) {
				System.out.println("Element se obrisao sa stranice.");
			
		}
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
	}

	
	}


