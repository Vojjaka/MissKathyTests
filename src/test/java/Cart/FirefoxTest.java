package Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FirefoxTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void Firefox() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://misskathy.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void AddingProductToCart() throws Exception {
        driver.get(baseUrl);
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.xpath("//li[3]/a/span")).click();
        driver.findElement(By.xpath("(//img[@alt='Два шарика'])[3]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Рассчитать стоимость доставки и величину налога")).click();
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
