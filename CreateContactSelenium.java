package week3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactSelenium {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[@style='color: black;']")).click();
		driver.findElement(By.xpath("(//ul[@class='sectionTabBar']//a)[3]")).click();
		driver.findElement(By.xpath("(//div[@id='left-content-column']//a)[2]")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("PRASANNASABARI");
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("M.A");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Prasanna");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Sabari");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("MechanicalEngineering");
		driver.findElement(By.xpath("(//textarea[@class='inputBox'])[1]")).sendKeys("Nothing");
		driver.findElement(By.xpath("//input[contains(@id,'_primaryEmail')]")).sendKeys("sabaripavi99@gamil.com");
		WebElement dd1 = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select drop1=new Select(dd1);
		drop1.selectByIndex(20);
		WebElement dd2 = driver.findElement(By.xpath("//select[contains(@id,'_generalCountryGeoId')]"));
		Select drop2=new Select(dd2);
		drop2.selectByVisibleText("United States Minor Outlying Islands");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Nothing");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());

	}

}
