package PageTitles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Firefox {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://dev.mk2.jujumedia.co.uk/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void Firefox() throws Exception {

        HomePage();
        assertEquals(getTitle(), "Home Page");
        PrintTitle();

        driver.findElement(By.cssSelector(".blog a")).click();
        assertEquals(getTitle(), "Лукбук");
        PrintTitle();

        driver.findElement(By.cssSelector("a.level-top > span")).click();
        assertEquals(getTitle(), "Заколки");
        PrintTitle();

        driver.findElement(By.xpath("//li[3]/a/span")).click();
        assertEquals(getTitle(), "Резинки");
        PrintTitle();

        driver.findElement(By.xpath("//li[4]/a/span")).click();
        assertEquals(getTitle(), "Ободки");
        PrintTitle();

        driver.findElement(By.cssSelector(".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/customer/account/login/\"]")).click();
        assertEquals(getTitle(), "Вход в систему");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/checkout/cart/\"]"))).click();
        assertEquals(getTitle(), "Корзина");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/returns/\"]"))).click();
        assertEquals(getTitle(), "Покупка и возврат");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/shipping/\"]"))).click();
        assertEquals(getTitle(), "Доставка");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/payments/\"]"))).click();
        assertEquals(getTitle(), "Оплата");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/contacts\"]"))).click();
        assertEquals(getTitle(), "Связаться с нами");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/privacy-policy-cookie-restriction-mode\"]"))).click();
        assertEquals(getTitle(), "Политика конфиденциальности");
        PrintTitle();

        System.out.println("Test Succeeded");

    }

    public void PrintTitle() {
        Print();
    }

    public void HomePage() {
        driver.get(baseUrl);
    }
    public void Print() {
        System.out.println(getTitle());
    }
    private String getTitle() {
        return driver.getTitle();
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
