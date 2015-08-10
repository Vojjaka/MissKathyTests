package Cart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Safari {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new SafariDriver();
        baseUrl = "http://dev.mk2.jujumedia.co.uk/";
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

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
