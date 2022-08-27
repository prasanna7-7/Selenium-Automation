package week6.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions hover=new Actions(driver);
		hover.moveToElement(brand).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		//driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		String title="Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
		String title2 = driver.getTitle();
		if (title.equals(title2)) {
			System.out.println("true");
		}
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//span[@class='title'])[4]")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("(//span[@class='filter-name '])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='filter-name '])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String text = driver.findElement(By.xpath("//div[@class='css-19j3ean']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
	    WebElement drop = driver.findElement(By.xpath("//select[@title='SIZE']"));
	    Select drp=new Select(drop);
	    drp.selectByIndex(1);
	    WebElement mrp = driver.findElement(By.xpath("(//span[text()='₹189'])[1]"));
	    System.out.println("MRP : "+mrp.getText());
	    driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
	    driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click(); 
	   // WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
	    driver.switchTo().frame(0);
	   
	    String grandTotal1 = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
	    System.out.println(grandTotal1);
	   
        driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	    driver.findElement(By.xpath("//button[@class='btn full big']")).click();
	    String finalGrandTotal1 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
	    System.out.println(finalGrandTotal1 );
	    if (grandTotal1.equals(finalGrandTotal1)) {
	    	System.out.println("it's same");
		}
	}
}

