package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class SeleniumFunctions {

    public static WebDriver driver = null;
    public static WebDriverWait waitVar = null;
    public static String baseURL = "tttps://github.com/";

    public WebDriver createDriver() throws MalformedURLException,
            InterruptedException {
        File fileFF = new File("./src/drivers/chromedriver_mac");
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

    public void isHomePageDisplayed() {
        waitVar.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign in")));
        driver.findElement(By.linkText("Sign in")).isDisplayed();
    }

    public void clickSigninLink() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void inputLogin(String login) {
        driver.findElement(By.id("user[login]")).clear();
        driver.findElement(By.id("user[login]")).sendKeys(login);
    }

    public void inputPassword(String pass) {
        driver.findElement(By.id("user[password]")).clear();
        driver.findElement(By.id("user[password]")).sendKeys(pass);
    }

    public void loginToSite(String login, String pass) {
        driver.findElement(By.id("user[login]")).clear();
        driver.findElement(By.id("user[login]")).sendKeys(login);
        driver.findElement(By.id("user[password]")).clear();
        driver.findElement(By.id("user[password]")).sendKeys(pass);
        driver.findElement(By.linkText("Sign in")).click();
    }

    public boolean isLoginSectionDisplayed() {
        boolean isOpen = false;
        waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className("auth-form-body")));
        waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className("commit")));

        isOpen = (driver.findElement(By.className("auth-form-body")).isDisplayed()) && (driver.findElement(By.name("commit")).isDisplayed());
        return isOpen;
    }
}
