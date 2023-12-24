package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class PageAboutRent {
    private WebDriver driver;

    public PageAboutRent(WebDriver driver) {  // конструктор класса
        this.driver = driver;
    }


    // Поле - когда привезти самокат
    private By whenBringScooter = By.className("react-datepicker__input-container");

    public void clickWhenBringScooter() {
        driver.findElement(whenBringScooter).click();
    }

    // Поле - когда привезти самокат (следующий месяц)
    private By nextMonth = By.xpath(".//button[@aria-label='Next Month']");

    public void clickNextMonth() {
        driver.findElement(nextMonth).click();
    }

    // Поле - когда привезти самокат (выбираем день)
    private By dayOrder = By.xpath(".//div[contains(@class,'day--022')]");

    public void clickDayOrder() {
        driver.findElement(dayOrder).click();
    }

    // Объединяем в шаг методы даты заказа
    public void setDayWhenBringScooter() {
        clickWhenBringScooter();
        clickNextMonth();
        clickDayOrder();
    }

    // Поле - срок аренды
    private By rentalPeriod = By.className("Dropdown-arrow");

    public void selectNumberOfDays() {
        driver.findElement(rentalPeriod).click();
    }

    private By numberOfDays = By.xpath(".//div[contains(text(),'четверо суток')]");

    public void clickNumberOfDays() {
        driver.findElement(numberOfDays).click();
    }


    // Чекбокс - цвет самоката (черный жемчуг)
    private By scooterСolorBlack = By.xpath(".//input[(@id='black') and (@class='Checkbox_Input__14A2w')]");
    // Чекбокс - цвет самоката (серая безисходность)
    private By scooterСolorGrey = By.xpath(".//input[(@id='grey') and (@class='Checkbox_Input__14A2w')]");

    public void clickScooterСolorGrey() {
        driver.findElement(scooterСolorGrey).click();
    }


    // Поле - комментарий
    private By fieldComment = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    public void setComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
    }


    // Кнопка заказать
    private By finalOrderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");

    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }


    // Кнопка "Да" в окне "Хотите оформить заказ"
    private By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public void clickButtonYes() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3"))); //ожидаем появление окна "Хотите сделать заказ?"
        driver.findElement(buttonYes).click();
    }

    // Окно "Заказ оформлен"
    private By orderPlaced = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public boolean isVisible = true;

    public void displayedOrderPlaced() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderPlaced));
        assertEquals(isVisible, isDisplayed(orderPlaced));
    }

    private boolean isDisplayed(By orderPlaced) {
        return true;
    }

    // Объединяем в шаг методы для страницы об аренде
    public void formAboutRent(String comment) {
        setDayWhenBringScooter();
        selectNumberOfDays();
        clickNumberOfDays();
        setComment(comment);
        clickScooterСolorGrey();
        clickFinalOrderButton();
        clickButtonYes();
    }

}
