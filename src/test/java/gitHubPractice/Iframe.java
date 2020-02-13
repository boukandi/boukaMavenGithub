package gitHubPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;






public class Iframe {
	
	public void UserSholdBeAbleToSwitchFrames() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		Thread.sleep(5000);
		//driver.switchTo().frame("packageFrame");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='allclasses-frame.html']")));
	//	Thread.sleep(5000);;
		By ABSTRACT_ACTION_LOCATOR=By.xpath("//a[@href='javax/swing/AbstractAction.html']");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ABSTRACT_ACTION_LOCATOR));
		driver.findElement(ABSTRACT_ACTION_LOCATOR).click();
		Thread.sleep(3000);
		//driver.findElement(By.linkText("compact1")).click();
    	//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='overview-summary.html']")));
		
		//driver.switchTo().frame("classFrame");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Serializable")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageListFrame");
		new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("java.sql")));
		driver.findElement(By.linkText("java.sql")).click();
		Thread.sleep(3000);
		By JAVA_APPLET_LOCATOR =By.xpath("//a[text()='java.applet'and@target='packageFrame']");
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//a[@target='packageFrame'and@href='java/awt/color/package-frame.html']"));
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(JAVA_APPLET_LOCATOR));
		driver.findElement(JAVA_APPLET_LOCATOR).click();
		Thread.sleep(4000);
		int size=driver.findElements(By.xpath("//frame")).size(); 
		System.out.println(size);
		driver.close();
		driver.quit();

	}

}
