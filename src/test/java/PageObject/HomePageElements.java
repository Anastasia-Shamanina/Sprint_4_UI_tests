package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageElements {
    private WebDriver driver;

    public HomePageElements(WebDriver driver) {  // конструктор класса
        this.driver = driver;
    }

    // Кнопка заказать в шапке страницы
    private By firstOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    public void clickFirstOrderButton() {

        driver.findElement(firstOrderButton).click();
    }

    // Кнопка заказать внизу страницы
    private By secondOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public void clickSecondOrderButton() {
        driver.findElement(secondOrderButton).click();
    }

    private String closedListOfQuestion = "accordion__heading-%d";
    private String openListOfQuestion = "accordion__panel-%d";

    public void clickTextOfQuestion(int index) {
        driver.findElement(By.id(String.format(closedListOfQuestion, index))).click();
    }

    public String getActualText(int index) {
        return driver.findElement(By.id(String.format(openListOfQuestion, index))).getText();
    }

    // Локаторы и методы, если не использовать параметризацию, оставила для себя
   /* // Выпадающий список - Сколько это стоит? И как оплатить?
    private By questionHowMuchDoesItCost = By.id("accordion__heading-0");

    public void clickQuestionHowMuchDoesItCost() {
        driver.findElement(questionHowMuchDoesItCost).click();
    }

    private By questionHowMuchDoesItCostText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-0']");

    public String getQuestionHowMuchDoesItCostText() {
        return driver.findElement(questionHowMuchDoesItCostText).getText();
    }


    // Выпадающий список - Хочу сразу несколько самокатов! Так можно?
    private By questionSeveralScooters = By.id("accordion__heading-1");

    public void clickQuestionSeveralScooters() {
        driver.findElement(questionSeveralScooters).click();
    }

    private By questionSeveralScootersText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-1']");

    public String getQuestionSeveralScootersText() {
        return driver.findElement(questionSeveralScootersText).getText();
    }


    // Выпадающий список - Как рассчитывается время аренды?
    private By questionRentalTime = By.id("accordion__heading-2");

    public void clickQuestionRentalTime() {
        driver.findElement(questionRentalTime).click();
    }

    private By questionRentalTimeText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-2']");

    public String getQuestionRentalTimeText() {
        return driver.findElement(questionRentalTimeText).getText();
    }


    // Выпадающий список - Можно ли заказать самокат прямо на сегодня?
    private By questionScooterToday = By.id("accordion__heading-3");

    public void clickQuestionScooterToday() {
        driver.findElement(questionScooterToday).click();
    }

    private By questionScooterTodayText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-3']");

    public String getQuestionScooterTodayText() {
        return driver.findElement(questionScooterTodayText).getText();
    }


    // Выпадающий список - Можно ли продлить заказ или вернуть самокат раньше?
    private By questionExtendOrderOrReturnScooter = By.id("accordion__heading-4");

    public void clickQuestionExtendOrderOrReturnScootery() {
        driver.findElement(questionExtendOrderOrReturnScooter).click();
    }

    private By questionExtendOrderOrReturnScooterText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-4']");

    public String getQuestionExtendOrderOrReturnScooterText() {
        return driver.findElement(questionExtendOrderOrReturnScooterText).getText();
    }


    // Выпадающий список - Вы привозите зарядку вместе с самокатом?
    private By questionScooterСharge = By.id("accordion__heading-5");

    public void clickQuestionScooterСharge() {
        driver.findElement(questionScooterСharge).click();
    }

    private By questionScooterСhargeText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-5']");

    public String getQuestionScooterСhargeText() {
        return driver.findElement(questionScooterСhargeText).getText();
    }


    // Выпадающий список - Можно ли отменить заказ?
    private By questionCancelOrder = By.id("accordion__heading-6");

    public void clickQuestionCancelOrder() {
        driver.findElement(questionCancelOrder).click();
    }

    private By questionCancelOrderText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-6']");

    public String getQuestionCancelOrderText() {
        return driver.findElement(questionCancelOrderText).getText();
    }


    // Выпадающий список - Я живу за МКАДом, привезёте?
    private By questionMcad = By.id("accordion__heading-7");

    public void clickQuestionMcad() {
        driver.findElement(questionMcad).click();
    }

    private By questionMcadText = By.xpath(".//div[@class='accordion__panel' and @id='accordion__panel-7']");

    public String getQuestionMcadText() {
        return driver.findElement(questionMcadText).getText();
    }*/
}

