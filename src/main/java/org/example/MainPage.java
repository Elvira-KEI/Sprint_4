package org.example;
import org.openqa.selenium.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainPage {

    private final static String PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    private final static  By CHECK_ORDER_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
    private final static  By ORDER_NUMBER_INPUT_FIELDER = By.cssSelector("input.Input_Input__1iN_Z");

    private final static  By ORDER_BUTTON = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    private final static By NAME = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    private final static By SURNAME = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/input");

    private final static By ADDRESS= By.xpath("//div[@class='Order_Form__17u6u']/div[3]/input");

    private final static By METRO_STATION =
            By.xpath("//div[@class='Order_Form__17u6u']/div[4]"); //поле станции
    private final static By COOKIE =// By.cssSelector("div.App_CookieConsent__1yUIN > button.App_CookieButton__3cvqF");
            By.id("rcc-confirm-button");

    private final static By METRO_STATION_CHOICE =
            By.xpath("//div[@class='select-search__select']/ul/li/button/div[2]");// выбора станции, выбор элемента списка для тестового набора
    private final static By PHONE_NUMBER = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/input");
    private final static  By CLICK_NEXT_BUTTON =
            By.cssSelector("div.Order_NextButton__1_rCA > button.Button_Middle__1CSJM");
    private final static  By ORDER_DATE = By.xpath("//div[@class='Order_Form__17u6u']/div/div/div/input");
    private final static  By RENT =
            By.xpath("//div[@class='Dropdown-control']");
    private final static  By RENT_CHOICE =
            By.xpath("//div[@class='Dropdown-menu']/div[2]");
    private final static  By CLICK_ORDER_BUTTON =
            By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private final static  By CLICK_NEXT_ORDER_BUTTON =
            By.xpath("//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]");
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    public MainPage clicksCheckOrderStatusButton(){
        driver.findElement(CHECK_ORDER_BUTTON).click();
        return this;
    }
    public MainPage enterOrderNumber(String orderNumber){
        driver.findElement(ORDER_NUMBER_INPUT_FIELDER).sendKeys(orderNumber);
        return this;
    }


   public MainPage clickOrderButton(){
        driver.findElement(ORDER_BUTTON).click();
       return this;
}
    public void name(String name){

        driver.findElement(NAME).sendKeys(name);
    }
    public void surname(String surname){
        driver.findElement(SURNAME).sendKeys(surname);

    }
    public void address(String address){
        driver.findElement(ADDRESS).sendKeys(address);
    }
    public MainPage metroStation(){
        driver.findElement(METRO_STATION).click();
        return this;
    }
    public MainPage metroStationCHOICE (){
        driver.findElement(METRO_STATION_CHOICE).click();

     return this;
         }
    public void phoneNumber(String phoneNumber){

        driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);
    }

    public MainPage clickNextButton(){
        driver.findElement(CLICK_NEXT_BUTTON).click();
        return this;
    }
public MainPage date (){
    // Заполнение даты при оформлении заказа
    driver.findElement(ORDER_DATE).click();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
    String date = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
    driver.findElement(ORDER_DATE).sendKeys(date);
    driver.findElement(ORDER_DATE).sendKeys(Keys.ENTER);
    return this;
  }

public MainPage rent (){
    driver.findElement(RENT).click();
    driver.findElement(RENT_CHOICE).click();
    return this;
}

    public MainPage clickOrderButtonInRentPage(){
        driver.findElement(CLICK_ORDER_BUTTON).click();
        return this; }

    public MainPage clicksNextOrderButton(){
        driver.findElement(CLICK_NEXT_ORDER_BUTTON).click();
        return this;
    }
    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public void clickCloseCookies() {
        driver.findElement(COOKIE).click();
    }

    public void clickOnQuestion(int index) {
        By buttonText = By.id("accordion__heading-" + index);
        driver.findElement(buttonText).click();
    }
public void scrollQuestions(){
    WebElement element = driver.findElement(By.id("accordion__heading-0"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

}

    public boolean isAnswerVisible(String constantText, int index) {
        return false;
    }
}