import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeHeadlessTest {
    public static void main(String[] args){
        String chromeDriverPath = "D:\\Drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //Add Desired Capabilities for Chrome Headless browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable--gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--silent");
        WebDriver driver = new ChromeDriver(options);

        // Get the login page
        driver.get("https://news.ycombinator.com/login?goto=news");

        // Search for username / password input and fill the inputs
        driver.findElement(By.xpath("//input[@name='acct']")).sendKeys("");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");

        // Locate the login button and click on it
        driver.findElement(By.xpath("//input[@value='login']")).click();

        if(driver.getCurrentUrl().equals("https://news.ycombinator.com/login")){
            System.out.println("Incorrect credentials");
            driver.quit();
            System.exit(1);
        }else{
            System.out.println("Successfuly logged in");
        }

        // Take a screenshot of the current page
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("D:\\screenshot.png"));

        // Logout
        driver.findElement(By.id("logout")).click();
        driver.quit();

    }
}
