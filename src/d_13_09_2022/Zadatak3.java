package d_13_09_2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) {
//		Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//		Maksimizirati prozor
//		Ucitati stranicu 
//		https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//		Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji 
//		Klik na dugme Add New
//		Unesite name,departmant i phone (uvek iste vrednost)
//		Trazenje po name atributu
//		Kliknite na zeleno Add dugme. 
//		PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici
//		edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne. 
//		Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete
//		koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//		Cekanje od 0.5s
//		Na kraju programa ugasite pretrazivac.

		 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	   	 WebDriver driver = new ChromeDriver();
	   	 driver.manage().window().maximize();
		
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		
		
	}

}
