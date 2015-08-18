package Cart;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Chrome {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "D:\\Vlad\\chromedriver.exe");
//        driver = new ChromeDriver();
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:9515"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        baseUrl = "http://misskathy.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void AddingProductToCart() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//li[3]/a/span")).click();
        driver.findElement(By.xpath("(//img[@alt='Два шарика'])[3]")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Рассчитать стоимость доставки и величину налога")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.findElement(By.id("city")).isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        new Select(driver.findElement(By.id("city"))).selectByVisibleText("Голицыно");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.id("checkout-form-submit")).click();
        assertEquals(driver.getTitle(), "Корзина");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
