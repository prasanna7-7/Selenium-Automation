package week3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSelenium {
	
	public static void main(String[] args) {
		//download the driver and set the path
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String sourceData=driver.getPageSource();//get source code of html sources
		System.out.println(sourceData);
		driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Prasanna");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("PS");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9080818140");
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("A1311619@a");
		WebElement dd1 = driver.findElement(By.xpath("//select[contains(@class,'_9407 _5dba _9hk6 _8esg')][1]"));
		Select drop1=new Select(dd1);
		drop1.selectByValue("23");
		WebElement dd2 = driver.findElement(By.xpath("//select[@aria-label='Month']"));
		Select drop2=new Select(dd2);
		drop2.selectByIndex(11);
		WebElement dd3 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select drop3=new Select(dd3);
		drop3.selectByVisibleText("1999");
	    driver.findElement(By.xpath("//label[text()='Male']")).click();
	    driver.close();	  
	}
}