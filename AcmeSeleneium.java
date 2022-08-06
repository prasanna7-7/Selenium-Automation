package week3;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSeleneium
{
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.getTitle());//first of get text method
		String text1 = driver.findElement(By.tagName("a")).getText();//second method os et text
		System.out.println(text1);
		String title="ACME System 1 -  Dashboard";//third method of get text
		String title2=driver.getTitle();
		System.out.println(title2);
		System.out.println(title);
		driver.findElement(By.xpath("//a[contains(@onclick,'event.preventDefault(); document.')]")).click();
		driver.close();
		Thread.sleep(6000);
		
	}

}
