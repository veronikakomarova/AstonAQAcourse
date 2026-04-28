import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    void acceptCookie(){
        WebElement cookieButton = driver.findElement(By.id("cookie-agree"));
        cookieButton.click();
    }

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        acceptCookie();
    }

    @AfterEach
    void checkMts() {
        driver.quit();
    }


    @Test
    void checkLogo() {
        WebElement logoOfBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")));
        assertTrue(logoOfBlock.isDisplayed());
    }

    @Test
    void checkTemplates(){
        WebElement tempBelkart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img")));
        assertTrue(tempBelkart.isDisplayed());
        WebElement tempMasterCardSecure = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img")));
        assertTrue(tempMasterCardSecure.isDisplayed());
        WebElement tempMasterCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img")));
        assertTrue(tempMasterCard.isDisplayed());
        WebElement tempVisaVerified = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img")));
        assertTrue(tempVisaVerified.isDisplayed());
        WebElement tempVisa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img")));
        assertTrue(tempVisa.isDisplayed());
    }

    @Test
    void checkLink(){
        WebElement linkHelp = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        linkHelp.click();
        String actualUrl = driver.getCurrentUrl();
        String expUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expUrl, actualUrl);
    }

    @Test
    void checkButtonContinue(){
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        dropDown.click();
        WebElement uslugiSviazi = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        uslugiSviazi.click();
        WebElement phoneNumbField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumbField.click();
        phoneNumbField.sendKeys("297777777");
        WebElement sumField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumField.click();
        sumField.sendKeys("20");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src*='bepaid'], iframe[src*='checkout']")));
        WebElement modalWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container")));
        assertTrue(modalWindow.isDisplayed());


    }


}
