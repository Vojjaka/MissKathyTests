package PageTitles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
public void Safari() throws Exception {

        HomePage();
        assertEquals(getTitle(), "Home Page");
        PrintTitle();

        driver.findElement(By.cssSelector(".blog a")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Лукбук"));
        assertEquals(getTitle(), "Лукбук");
        PrintTitle();

        driver.findElement(By.cssSelector("a.level-top > span")).click();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Заколки"));
        assertEquals(getTitle(), "Заколки");
        PrintTitle();

        driver.findElement(By.xpath("//li[3]/a/span")).click();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Резинки"));
        assertEquals(getTitle(), "Резинки");
        PrintTitle();

        driver.findElement(By.xpath("//li[4]/a/span")).click();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Ободки"));
        assertEquals(getTitle(), "Ободки");
        PrintTitle();

        driver.findElement(By.cssSelector(".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/customer/account/login/\"]")).click();
        wait.until(ExpectedConditions.titleContains("Вход в систему"));
        assertEquals(getTitle(), "Вход в систему");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/checkout/cart/\"]"))).click();
        wait.until(ExpectedConditions.titleContains("Корзина"));
        assertEquals(getTitle(), "Корзина");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/returns/\"]"))).click();
        wait.until(ExpectedConditions.titleContains("Покупка и возврат"));
        assertEquals(getTitle(), "Покупка и возврат");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/shipping/\"]"))).click();
        wait.until(ExpectedConditions.titleContains("Доставка"));
        assertEquals(getTitle(), "Доставка");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/payments/\"]"))).click();
        wait.until(ExpectedConditions.titleContains("Оплата"));
        assertEquals(getTitle(), "Оплата");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/contacts\"]"))).click();
        wait.until(ExpectedConditions.titleContains("Связаться с нам"));
        assertEquals(getTitle(), "Связаться с нами");
        PrintTitle();

        driver.findElement(By.cssSelector((".horisontal.footer_links>li>a[href=\"http://dev.mk2.jujumedia.co.uk/privacy-policy-cookie-restriction-mode\"]"))).click();
        wait.until(ExpectedConditions.titleContains("Политика конфиденциальности"));
        assertEquals(getTitle(), "Политика конфиденциальности");
        PrintTitle();

        System.out.println("Test Succeeded");
        }

        private String getTitle() {
                return driver.getTitle();
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
        @After
        public void tearDown() throws Exception {
                driver.quit();
                String verificationErrorString = verificationErrors.toString();
                if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
                }
                }

                }
