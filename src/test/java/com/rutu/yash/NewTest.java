package com.rutu.yash;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void cssSelector() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("#email")).sendKeys("rutu");
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("fvevgetrfg");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
	}
	
	@Test
	public void dragAndDrop() {
		Actions builder = new Actions(driver);
		driver.get("https://www.html5rocks.com/en/tutorials/dnd/basics/");
		WebElement drag = driver.findElement(By.cssSelector("#drag1"));
		WebElement drop = driver.findElement(By.cssSelector("#div2"));
		builder.dragAndDrop(drag, drop).build().perform();
		
	}
	
	@Test
	public void explicitWait() {
		WebDriverWait expWait = new WebDriverWait(driver, 100);
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("test49@gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("eyrgfwdjfc");
		driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		expWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='password']/div[2]/div[2]"), "Not found"));
		
		System.out.println("Printing after 100 Seconds");
	}
	
	@Test
	public void SelectClass() {
		driver.get("https://www.facebook.com/");
		WebElement month = driver.findElement(By.cssSelector("#month"));
		Select select = new Select(month);
		select.selectByIndex(6);
		driver.findElement(By.cssSelector("#day")).sendKeys("8");
		WebElement year = driver.findElement(By.cssSelector("#year"));
		select = new Select(year);
		select.selectByValue("1992");
	}
	
	@Test
	public void frameTest() {
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		System.out.println("in frame");
		driver.switchTo().defaultContent();
		System.out.println("main page");
		
	}
	
	@Test
	public void javaScriptExecutor() {
		driver.get("http://www.mississauga.ca/portal/cityhall/agendas");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement council = driver.findElement(By.linkText("Council"));
		js.executeScript("arguments[0].scrollIntoView(true)", council);
	}
	
	@Test
	public void keyTest() {
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("test49@gmail.com");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("eyrgfwdjfc");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(Keys.ENTER);
	}
	
	@Test
	public void windowSizeTest() {
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void hoverAction() {
		driver.get("http://www.mississauga.ca/portal/home");
		WebElement image = driver.findElement(By.xpath(".//img[@alt='City Hall']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(image).build().perform();
	}
	
	
	@Test
	public void multipleWindowTest() {
		driver.get("https://moodle.cestarcollege.com/moodle/");
		driver.findElement(By.linkText("Faq")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		Object[] ids = windowHandles.toArray();
		
		driver.switchTo().window((String)ids[0]);
		driver.switchTo().window((String)ids[1]);
		
		Iterator<String> itr = windowHandles.iterator();
		String main = itr.next();
		String slave = itr.next();
		
		driver.switchTo().window(main);
		driver.switchTo().window(slave);
		
	}
	
	
	@Test
	public void navigate() {
		driver.navigate().to("https://www.google.ca/");
		driver.navigate().to("https://moodle.cestarcollege.com/moodle/");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
	}
	
	@Test
	public void openPageInNewWindow() {
		Actions builder = new Actions(driver);
		driver.get("https://www.google.com/");
		WebElement image = driver.findElement(By.cssSelector(".Fx4vi"));
		builder.keyDown(Keys.SHIFT).click(image).keyUp(Keys.SHIFT).build().perform();
	}
	
	@Test
	public void pupUpTest() {
		driver.get("https://www.aliexpress.com/");
		List<WebElement> popup = driver.findElements(By.cssSelector(".close-layer"));
		if(popup.size() == 1) {
			popup.get(0).click();
			System.out.println("There was a popup on screen, and I have closed it");
		}else {
			System.out.println("There is No popup");
		}
		
	}
	
	@Test
	public void radioButton() {
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		WebElement radioButton = driver.findElement(By.cssSelector("input[value='Milk']"));
		radioButton.click();
		if(radioButton.isSelected()) {
			System.out.println("Selected");
		}
	}
	
	
	@Test
	public void screenShotTest() throws IOException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.mississauga.ca/portal/home");
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("E:\\ScreenShot\\screenshot.jpeg"));
	}
	
	@Test
	public void dropDownTest() {
		driver.get("https://www.ebay.ca/");
		List<WebElement> dropDownMenu = driver.findElements(By.xpath("//*[@aria-label='Select a category for search']/option"));
		
		System.out.println(dropDownMenu.size());
		System.out.println("**************");
		for(WebElement q : dropDownMenu) {
			System.out.println(q.getText()+"------"+q.isSelected());
		}
		
		driver.findElement(By.xpath("//*[@aria-label='Select a category for search']")).sendKeys("Books");
		System.out.println();
		System.out.println("*****************after****************");
		System.out.println();
		for(WebElement q : dropDownMenu) {
			System.out.println(q.getText()+"------"+q.isSelected());
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}
}
