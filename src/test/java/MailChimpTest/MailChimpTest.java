package MailChimpTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MailChimpTest {

    public static final String MAILCHIMP_URL = "https://login.mailchimp.com/";
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(MAILCHIMP_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        WebDriverWait wait  = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@id= 'onetrust-accept-btn-handler']")));
        WebElement acceptCookiesBtn = driver.findElement(By.xpath("//button [@id= 'onetrust-accept-btn-handler']"));
        acceptCookiesBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void validateTestTitle(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Login | Mailchimp");
    }

    @Test
    public void logInPageTest(){
        WebElement logInText =  driver.findElement(By.xpath("//*[@class= 'text-align--center !margin-bottom--lv3']"));
        Assert.assertEquals(logInText.getText(), "Log In");
        WebElement needMailAccountText = driver.findElement(By.xpath("//*[@class = 'padding-right--lv1']"));
        Assert.assertEquals(needMailAccountText.getText(), "Need a Mailchimp account?");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }


}
