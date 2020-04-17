package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverBuilder {

    public static WebDriver driver = null;
    public static WebDriverWait waitVar = null;
    public static String baseURL = "http://v3.test.itpmgroup.com";

    public WebDriver createDriver() throws MalformedURLException, InterruptedException {
        File fileFF = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(baseURL);

        waitVar = new WebDriverWait(driver, 15);
        return driver;
    }

    public void teardown() {
        driver.quit();
    }

}
