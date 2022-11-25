package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomePageSamokat {
    private final WebDriver driver;

    //Локатор кнопки "Заказать" в хедере страницы
    private final By orderButtonHeader = By.xpath("//div[@class='Header_Nav__AGCXC']/button");
    //Локатор кнопки "Заказать" в теле страницы
    private final By orderButtonBody = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Локатор кнопки принятия cookie
    private final By cookieButton = By.id("rcc-confirm-button");
    //Локатор раздела сайта с меню
    private final By homepageAccordion = By.className("Home_FourPart__1uthg");
    //Локатор параграфа пункта меню "Сколько это стоит? И как оплатить?"
    private final By accordeonItemHowMuchP = By.xpath("//div[@id = 'accordion__panel-0']/p");
    //Локатор пункта меню "Сколько это стоит? И как оплатить?"
    private final By accordeonItemHowMuch = By.xpath("//div[@id = 'accordion__heading-0']/parent::div");
    //Локатор параграфа пункта меню "Хочу сразу несколько самокатов! Так можно?"
    private final By accordeonItemNumberOfScootersP  = By.xpath("//div[@id = 'accordion__panel-1']/p");
    //Локатор выпадающего пункта меню "Хочу сразу несколько самокатов! Так можно?"
    private final By accordeonItemNumberOfScooters = By.xpath("//div[@id = 'accordion__heading-1']/parent::div");
    //Локатор параграфа пункта меню "Как рассчитывается время аренды?"
    private final By accordeonItemRentalTimeCalculationP = By.xpath("//div[@id = 'accordion__panel-2']/p");
    //Локатор выпадающего пункта меню "Как рассчитывается время аренды?"
    private final By accordeonItemRentalTimeCalculation = By.xpath("//div[@id = 'accordion__heading-2']/parent::div");
    //Локатор параграфа пункта меню "Можно ли заказать самокат прямо на сегодня?"
    private final By accordeonItemRightTodayP = By.xpath("//div[@id = 'accordion__panel-3']/p");
    //Локатор выпадающего пункта меню "Можно ли заказать самокат прямо на сегодня?"
    private final By accordeonItemRightToday = By.xpath("//div[@id = 'accordion__heading-3']/parent::div");
    //Локатор параграфа пункта меню "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By accordeonItemExtensionReductionOrderP = By.xpath("//div[@id = 'accordion__panel-4']/p");
    //Локатор выпадающего пункта меню "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By accordeonItemExtensionReductionOrder = By.xpath("//div[@id = 'accordion__heading-4']/parent::div");
    //Локатор параграфа пункта меню "Вы привозите зарядку вместе с самокатом?"
    private final By accordeonItemScooterChargingP = By.xpath("//div[@id = 'accordion__panel-5']/p");
    //Локатор выпадающего пункта меню "Вы привозите зарядку вместе с самокатом?"
    private final By accordeonItemScooterCharging = By.xpath("//div[@id = 'accordion__heading-5']/parent::div");
    //Локатор параграфа пункта меню "Можно ли отменить заказ?"
    private final By accordeonItemCancelTheOrderP = By.xpath("//div[@id = 'accordion__panel-6']/p");
    //Локатор выпадающего пункта меню "Можно ли отменить заказ?"
    private final By accordeonItemCancelTheOrder = By.xpath("//div[@id = 'accordion__heading-6']/parent::div");
    //Локатор параграфа пункта меню "Я жизу за МКАДом, привезёте?
    private final By accordeonItemMKADP = By.xpath("//div[@id = 'accordion__panel-7']/p");
    //Локатор выпадающего пункта меню "Я жизу за МКАДом, привезёте?
    private final By accordeonItemMKAD = By.xpath("//div[@id = 'accordion__heading-7']/parent::div");


    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для работы с кнопкой "Заказать" в хедере
    public void choseOrderButtonHeader(){
        waitForLoadHeaderButton();
        clickOrderButtonHeader();
    }
    //Метод ожидания загрузки кнопки "Заказать" в хедере
    public void waitForLoadHeaderButton(){
        WebElement element = driver.findElement(By.className("Button_Button__ra12g"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Метод клика по кнопке "Заказать" в хедере
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }
    //Метод для работы с кнопкой "Заказать" в теле
    public void choseOrderButtonBody(){
        waitForLoadBodyButton();
        clickOrderButtonBody();
    }
    //Метод клика по кнопке "Заказать" в теле
    public void clickOrderButtonBody() {
        driver.findElement(orderButtonBody).click();
    }
    //Метод ожидания загрузки кнопки "Заказать" в теле
    public void waitForLoadBodyButton(){
        //WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        WebElement element = driver.findElement(By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Метод выбора на какую кнопку "Заказать" кликать (в хедере или в теле)
    public void choseOrderButton(String buttonPlace){
        if (buttonPlace == "header"){
            choseOrderButtonHeader();
        } else {
            choseOrderButtonBody();
        }
    }
    //Метод сбора значений пунктов меню
    public boolean testAllMenuItemsValues(String lineOfText){

        List menuElementsValues = new ArrayList();
        menuElementsValues.add(clickAccordeonItemHowMuch());

        menuElementsValues.add(clickAccordeonItemItemNumberOfScooters());

        menuElementsValues.add(clickAccordeonItemRentalTimeCalculation());

        menuElementsValues.add(clickAccordeonItemRightToday());

        menuElementsValues.add(clickAccordeonItemExtensionReductionOrder());

        menuElementsValues.add(clickAccordeonItemCancelTheOrder());

        menuElementsValues.add(clickAccordeonItemScooterCharging());

        menuElementsValues.add(clickAccordeonItemMKAD());

        boolean actualResult = menuElementsValues.toString().contains(lineOfText);
        return actualResult;

    }

    //Метод нажатия на кнопки меню аккордеона
    public String clickAccordeonItemHowMuch(){
        driver.findElement(accordeonItemHowMuch).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemHowMuchP));
        return driver.findElement(accordeonItemHowMuchP).getText();

    }
    public String clickAccordeonItemItemNumberOfScooters(){
        driver.findElement(accordeonItemNumberOfScooters).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemNumberOfScootersP));
        return driver.findElement(accordeonItemNumberOfScootersP).getText();
    }
    public String clickAccordeonItemRentalTimeCalculation(){
        driver.findElement(accordeonItemRentalTimeCalculation).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemRentalTimeCalculationP));
        return driver.findElement(accordeonItemRentalTimeCalculationP).getText();
    }
    public String clickAccordeonItemRightToday(){
        driver.findElement(accordeonItemRightToday).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemRightTodayP));
        return driver.findElement(accordeonItemRightTodayP).getText();
    }
    public String clickAccordeonItemExtensionReductionOrder(){
        driver.findElement(accordeonItemExtensionReductionOrder).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemExtensionReductionOrderP));
        return driver.findElement(accordeonItemExtensionReductionOrderP).getText();
    }
    public String clickAccordeonItemCancelTheOrder(){
        driver.findElement(accordeonItemCancelTheOrder).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemCancelTheOrderP));
        return driver.findElement(accordeonItemCancelTheOrderP).getText();
    }
    public String clickAccordeonItemScooterCharging(){
        driver.findElement(accordeonItemScooterCharging).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemScooterChargingP));
        return driver.findElement(accordeonItemScooterChargingP).getText();
    }
    public String clickAccordeonItemMKAD(){
        driver.findElement(accordeonItemMKAD).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(accordeonItemMKADP));
        return driver.findElement(accordeonItemMKADP).getText();
    }
    //Метод нажатия кнопки принять cookie
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    //Метод скролла до меню
    public void scrollForMenuHomePageSamokat() {
        WebElement element = driver.findElement(homepageAccordion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }


}
//Финальное измененние для pull request