package Demo.Demo;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import java.io.FileInputStream;
import java.util.Properties;


public class Demo {
  Properties property;
  FileInputStream fs;
  public WebDriver driver;
  GenerateData genData;


  @Before
  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		genData=new GenerateData();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  
  public void testDemo() throws Exception  {
	  
  
	  fs = new FileInputStream(System.getProperty("user.dir")+"\\objects");
	  
	  property = new Properties();
		
	  property.load(fs);
	  
	  //maximizes window	  
	  driver.manage().window().maximize();
	  
	  //gets the DOJ webpage
	  driver.get("https://www.justice.gov/");
	  
	  Thread.sleep(2000);
	  
	  //clicks on Report a Crime
	  driver.findElement(By.xpath(property.getProperty("reportacrime"))).click();
	  
	  Thread.sleep(2000);
	  
	  //verifies Report a Crime page title
	  String title = driver.getTitle();
	  String reportacrimetitle = "Report a Crime | DOJ | Department of Justice";
	  assertEquals(reportacrimetitle,title);
	  
	  Thread.sleep(2000);
	  
	  //waits for FBI Tip
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/article/div[1]/div/div/div/div[2]/ul/li/a[1]")));
	  
	  Thread.sleep(2000);
	  
	  //clicks on FBI tip
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/article/div[1]/div/div/div/div[2]/ul/li/a[1]")).click();
	  
	  Thread.sleep(2000);
	  
	  //clicks on back (browser button)
	  driver.navigate().back();
	  
	  Thread.sleep(2000);
	  
	  //mouse hover over
	  Actions hoverOverAgencies = new Actions(driver);
	  WebElement link = driver.findElement(By.xpath("//*[@id=\"nice-menu-1\"]/li[4]/a"));
	  hoverOverAgencies.moveToElement(link).moveToElement(driver.findElement(By.cssSelector("#nice-menu-1 > li.menu-1260.menuparent.menu-path-node-33666-chart.odd > a"))).build().perform();
	  
	  Thread.sleep(2000);
	  
	  //clicks on Alphabetical Listing
	  WebElement alphabeticalListing = driver.findElement(By.cssSelector("#nice-menu-1 > li.menu-1260.menuparent.menu-path-node-33666-chart.odd > ul > li.menu-90591.menu-path-node-924706.even.last > a"));
	  alphabeticalListing.click();
	  
	  Thread.sleep(2000);
	  
	  //clicks on AntiTrust
	  WebElement antiTrustDivisionLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/article/div[1]/div/div/div/p[2]/a"));
	  antiTrustDivisionLink.click();

	  Thread.sleep(2000);
	  
	  //verifies title of page ANTITRUST DIVISION (not html title)
	  assertEquals("ANTITRUST DIVISION", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/h1")).getText()); 
	  
	  Thread.sleep(2000);

	  //clicks on Contact
	  WebElement Contact = driver.findElement(By.xpath("//*[@id=\"nice-menu-1\"]/li[8]/a"));
	  Contact.click();
	  
	  Thread.sleep(2000);
	  
	  //clicks on Contact Us Form button
	  WebElement form = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/article/div[1]/div/div/div/p[2]/a/img"));
	  form.click();
	  
	  Thread.sleep(2000);
	  
	  //Types name in Name field
	  driver.findElement(By.id("edit-submitted-name")).sendKeys(property.getProperty("personname"));
	  
	  Thread.sleep(2000);
	  
	  //types the email
	  driver.findElement(By.id("edit-submitted-email")).sendKeys(property.getProperty("email"));
	  
	  Thread.sleep(2000);
	  
	  //clicks on dropdown and selects Antritrust
	  Select drpd = new Select (driver.findElement(By.xpath("//*[@id=\"edit-submitted-topic\"]")));
	  drpd.selectByValue("Antitrust");
	  
	  Thread.sleep(2000);
	  
	  //clicks on message box
	  driver.findElement(By.id("edit-submitted-message"));
	  
	  Thread.sleep(2000);
	  
	  //types random letters and numbers
	  WebElement msg = driver.findElement(By.id("edit-submitted-message"));
	  msg.click();
	  driver.findElement(By.id("edit-submitted-message")).sendKeys(genData.generateStringWithAllobedSplChars(300, "abc123_-.!@#$%^&*()|/><")); 
	  
	  Thread.sleep(2000);
	  
	  //clears text box
	  driver.findElement(By.id("edit-submitted-message")).clear();
	  
	  Thread.sleep(2000);
	  
	  //types Hello DOJ
	  msg.sendKeys("Hello DOJ");
	  
	  Thread.sleep(2000);
	  
	  //resizes text box
	  Actions actions = new Actions(driver);
	  WebElement resizeHandle = driver.findElement(By.xpath("//*[@id=\"webform-client-form-432381\"]/div/div[4]/div/div[2]"));
	  actions.dragAndDropBy(resizeHandle, 826, 100).build().perform();
	  
	  Thread.sleep(2000);
	  
	  //resizes text box
	  actions.dragAndDropBy(resizeHandle, 826, -120).build().perform();
	  
	  Thread.sleep(2000);
	  
	  //clicks on browser Back button
	  driver.navigate().back();
	  
	  Thread.sleep(2000);
	  
	  //clicks on Contact Webmaster
	  WebElement cWebmaster = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/article/div[1]/div/div/div/p[7]/a/img"));
	  cWebmaster.click();
	  
	  Thread.sleep(2000);
	  
	  //clicks on browser Back button
	  driver.navigate().back();
	  
	  Thread.sleep(2000);
	  
	  //clicks on Share
	  WebElement shareLink = driver.findElement(By.id("doj-sharing-toggle"));
	  shareLink.click();
	  
	  Thread.sleep(2000);
	  
	  //clicks on Facebook
	  WebElement faceBook = driver.findElement(By.xpath("//*[@id=\"block-doj-sharing-doj-sharing\"]/div/div/ul/li[1]/a"));
	  faceBook.click();
	  
	  Thread.sleep(2000);
	  
	  //switches to new tab
	  String originalHandle = driver.getWindowHandle();
	  
	  Thread.sleep(2000);

	  //switches to new tab
	  for (String newTab: driver.getWindowHandles()) {
		  driver.switchTo().window(newTab);
	  }
	  
	  Thread.sleep(2000);
	  
	  //verifies Facebook is loaded in new tab
	  String title1 = driver.getTitle();
	  String expectedTitle1 = "Facebook";
	  assertEquals(title1, expectedTitle1);
  
	  Thread.sleep(1000);
	  
	  //switches to original tab
	  driver.switchTo().window(originalHandle);
	  
	  Thread.sleep(2000);
	  
	  //clicks on search bar
	  WebElement search = driver.findElement(By.id("edit-usasearch-hosted-box--2"));
	  search.click();
	  
	  //types crime in search bar
	  driver.findElement(By.id("edit-usasearch-hosted-box--2")).sendKeys("crime");
	  
	  Thread.sleep(2000);
	  
	  //hits the ENTER key
	  driver.findElement(By.id("edit-usasearch-hosted-box--2")).sendKeys(Keys.ENTER);
			  
	  Thread.sleep(2000);
	  
	  //verifies if Attorney General's youtube video is present
	  WebElement attorneyGenVid = driver.findElement(By.xpath("//*[@id=\"video-news-item-1\"]/div/a/img"));
	  attorneyGenVid.isDisplayed();
	  
	  Thread.sleep(3000);
	  

  }
  
  @After
	 public void after(){
	  driver.quit();
  }
}
