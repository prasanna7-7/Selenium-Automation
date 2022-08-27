package week6.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		WebElement mens = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions build=new Actions(driver);
		build.moveToElement(mens).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//p[@class='product-title']"));
		int size=list.size();
		System.out.println("total number of count : "+ size);	
	}
	
}
