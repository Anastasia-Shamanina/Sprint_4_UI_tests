package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageScooterForWho {
    private WebDriver driver;

    public PageScooterForWho(WebDriver driver) {  // конструктор класса

        this.driver = driver;
    }

    // Поле имя
    private By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    public void setName(String name) {

        driver.findElement(fieldName).sendKeys(name);
    }


    //Поле фамилия
    private By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    public void setSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }


    // Поле адрес
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    public void setAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }


    // Поле телефон
    private By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    public void setPhone(String phone) {

        driver.findElement(fieldPhone).sendKeys(phone);
    }


    // Поле станция метро (свернуто)
    private By fieldMetro = By.xpath(".//input[@placeholder='* Станция метро']");

    public void clickfieldMetro() {

        driver.findElement(fieldMetro).click();
    }

    // Поле станция метро (выпадающий список)
    private By fieldMetroListCherkizovskaya = By.xpath(".//li[@class='select-search__row']/button[@value='2']"); // Выбираем Черкизовская

    public void clickfieldMetroListCherkizovskaya() {
        driver.findElement(fieldMetroListCherkizovskaya).click();
    }

    private By fieldMetroListTverskaya = By.xpath(".//li[@class='select-search__row']/button[@value='31']"); // Выбираем Тверская

    public void clickfieldMetroListTverskaya() {
        driver.findElement(fieldMetroListTverskaya).click();
    }

    //Объединяем методы для метро в шаг (выбираем Черкизовскую)
    public void setMetroStationCherkizovskaya() {
        clickfieldMetro();
        clickfieldMetroListCherkizovskaya();
    }

    //Объединяем методы для метро в шаг (выбираем Тверскую)
    public void setMetroStationTverskaya() {
        clickfieldMetro();
        clickfieldMetroListTverskaya();
    }

    // Кнопка "Далее"
    private By buttonNext = By.xpath(".//button[text()='Далее']");

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    // Объединяем методы в шаг (выбираем Черкизовскую)
    public void formScooterForWho1(String name, String surname, String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStationCherkizovskaya();
        setPhone(phone);
        clickButtonNext();

    }

    // Объединяем методы в шаг (выбираем Тверскую)
    public void formScooterForWho2(String name, String surname, String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStationTverskaya();
        setPhone(phone);
        clickButtonNext();
    }


}
