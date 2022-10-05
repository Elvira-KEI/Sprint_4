package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru";

    private static final  By CHECK_ORDER_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
    private static final  By ORDER_NUMBER_INPUT_FIELDER = By.cssSelector("input.Input_Input__1iN_Z");
    private static final By SUBMIT_ORDER_NUMBER_BUTTON =
            By.cssSelector("div.Header_SearchInput__3YRIQ > button.Button_Button__ra12g");
    private final WebDriver driver;
    public Main(WebDriver driver){
        this.driver=driver;
    }
    public Main clicksCheckOrderStatusButton(){ //public void clicksCheckOrderStatusButton()
        driver.findElement(CHECK_ORDER_BUTTON).click();
        return this;
    }
    public Main enterOrderNumber(String orderNumber){//public void enterOrderNumber(String orderNumber)
        driver.findElement(ORDER_NUMBER_INPUT_FIELDER).sendKeys(orderNumber);
        return this;
    }

    public OrderStatusPage clickSubmitOrderNumberButton() {//  public void clickSubmitOrderNumberButton()
        driver.findElement(SUBMIT_ORDER_NUMBER_BUTTON).click();
        return new OrderStatusPage(driver);
    }
}