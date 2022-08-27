package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		WebElement brand = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
	    Actions build= new Actions(driver);
		build.moveToElement(brand).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		String title="Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
		String title2 = driver.getTitle();
		if (title.equals(title2)) {
			System.out.println("true");
		}
		System.out.println(driver.getTitle());
	}
}
