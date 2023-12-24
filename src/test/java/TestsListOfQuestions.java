import PageObject.HomePageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestsListOfQuestions {
    private WebDriver driver;
    private String expectedText;
    private int index;

    public TestsListOfQuestions(String expectedText, int index) {
        this.expectedText = expectedText;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getExpectedTextOfQuestions() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Before
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "/Users/anastasiashamanina/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("App_CookieButton__3cvqF")));
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    @Test
    public void checkTextInQuestion() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        driver.manage().window().maximize();
        objHomePage.clickTextOfQuestion(index);
        assertEquals(expectedText, objHomePage.getActualText(index));
    }

    //Ниже проверки без использования параметризации, можно не смотреть, оставила для себя
   /* @Test
    public void checkTextFirstQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionHowMuchDoesItCost(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionHowMuchDoesItCostText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextSecondQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionSeveralScooters(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionSeveralScootersText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextThirdQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionRentalTime(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionRentalTimeText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextFourthQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionScooterToday(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionScooterTodayText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextFifthQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionExtendOrderOrReturnScootery(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionExtendOrderOrReturnScooterText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextSixthQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionScooterСharge(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionScooterСhargeText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextSeventhQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionCancelOrder(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionCancelOrderText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }

    @Test
    public void checkTextEighthQuestionInList() {
        HomePageElements objHomePage = new HomePageElements(driver); //создаем объект класса
        objHomePage.clickQuestionMcad(); //метод клика по вопросу

        String buttonText = objHomePage.getQuestionMcadText(); //метод получения текста из раскрывающегося вопроса
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области."; //ожидаемый текст

        assertEquals(expected, buttonText); //сравнение ожидаемого и фактического текста
    }
*/

    @After
    public void closeOut() {
        driver.quit();
    }
}
