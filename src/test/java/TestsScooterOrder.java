import PageObject.PageAboutRent;
import PageObject.PageScooterForWho;
import PageObject.HomePageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


public class TestsScooterOrder {
    private WebDriver driver;

    @Before
    public void openSite() {
        //Драйвер для хрома
        System.setProperty("webdriver.chrome.driver", "/Users/anastasiashamanina/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();

        //Драйвер для лисы
       /* System.setProperty("webdriver.gecko.driver", "/Users/anastasiashamanina/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();*/

        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("App_CookieButton__3cvqF")));
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    //Первый набор данных - проверка первой кнопки заказать вверху страницы
    @Test
    public void makeOrderFirstCheck() {
        HomePageElements objHomePage = new HomePageElements(driver);
        objHomePage.clickFirstOrderButton();

        PageScooterForWho objScooterForWho = new PageScooterForWho(driver);
        objScooterForWho.formScooterForWho1("Анастасия", "Шаманина", "Невский проспект 1", "79110930000");

        PageAboutRent objAboutRent = new PageAboutRent(driver);
        objAboutRent.formAboutRent("");

        objAboutRent.displayedOrderPlaced();  // проверяем, что появилось окно "Заказ оформлен"
    }

    //Второй набор данных - проверка второй кнопки заказать внизу страницы
    @Test
    public void makeOrderSecondCheck() {
        HomePageElements objHomePage = new HomePageElements(driver);
        // сделать скролл
        driver.manage().window().maximize();
        objHomePage.clickSecondOrderButton();

        PageScooterForWho objScooterForWho = new PageScooterForWho(driver);
        objScooterForWho.formScooterForWho1("Валерия", "Еремеева", "проспект Большевиков 1", "89110930001");

        PageAboutRent objAboutRent = new PageAboutRent(driver);
        objAboutRent.formAboutRent("Позвонить за час до доставки.");

        objAboutRent.displayedOrderPlaced();  // проверяем, что появилось окно "Заказ оформлен"
    }

    @After
    public void closeOut() {
        driver.quit();
    }
}
