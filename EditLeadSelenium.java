package week3;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadSelenium {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div[@id='center-content-column']//input)[2]")).sendKeys("Prasanna");
		//driver.findElement(By.xpath("(//div[@id='center-content-column']//input[@type='text'])[1]")).sendKeys("16822");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Prasanna']")).click();
		Thread.sleep(5000);
		String title="View Lead | opentaps CRM";
		String title2=driver.getTitle();
		System.out.println("own = "+title);
		System.out.println(title2);
		if (title.equals(title2)) {
			System.out.println("correct");
		} else {
			System.out.println("wrong");
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("(//input[@class='inputBox'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='inputBox'])[1]")).sendKeys("TESTLEAFS");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		String comName="TESTLEAFS (16821)";
		System.out.println("own = "+comName);
		String text = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println(text);
		if (comName.equals(text)) {
			System.out.println("company name is changed");
		} else {
			System.out.println("company is not change");
		}	
	}
}