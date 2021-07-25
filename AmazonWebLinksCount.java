import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AmazonWebLinksCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Initialise Chrome Incognito mode
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bharg\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);

		// Launch Amazon Website
		driver.get("https://www.amazon.co.uk/");

		// Count total number of links on Amazon Home Page
		System.out.println("Total number of links on Amazon Home Page as of current date: "
				+ driver.findElements(By.tagName("a")).size());

		// Count total number of links on Amazon Home Page - Footer section
		
		WebElement footertable = driver.findElement(By.id("navFooter"));// Limiting webdriver scope

		System.out.println(
				"Total number of links in Amazon Footer tabledsfasdgfasdfgafdgafdgd:" + footertable.findElements(By.tagName("a")).size());

		// Count total number of links on Amazon Home Page - Footer section third column/table
		WebElement thirdcolumn = footertable
				.findElement(By.xpath("//body/div[@id='a-page']/div[@id='navFooter']/div[1]/div[1]/div[5]"));
		System.out.println("Total number of links in footer table third column table: "
				+ thirdcolumn.findElements(By.tagName("a")).size());

		// Click on each link in the column/table and check if the pages are fully operational-
		for (int i = 1; i < thirdcolumn.findElements(By.tagName("a")).size(); i++) {

			// To enable open each link in new tab
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			thirdcolumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);

		} // opens all the tabs
		Set<String> abc = driver.getWindowHandles();// 4
		Iterator<String> it = abc.iterator();
		// Switch to each opened tab and get the webpage title
		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}

}
