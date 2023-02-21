package sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



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
        if (buttonPlace.equals("header")){
            choseOrderButtonHeader();
        } else {
            choseOrderButtonBody();
        }
    }
    //Метод сбора проверки пункта меню на текст заголовка и текс значения
    public boolean testAllMenuItemsValues(String lineOfTextQuestion, String lineOfTextAnswer){
        if (clickAccordeonItemHowMuch(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        }if (clickAccordeonItemItemNumberOfScooters(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        }if (clickAccordeonItemRentalTimeCalculation(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        }if (clickAccordeonItemRightToday(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        }if (clickAccordeonItemExtensionReductionOrder(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        }if (clickAccordeonItemCancelTheOrder(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        }if (clickAccordeonItemScooterCharging(lineOfTextQuestion, lineOfTextAnswer)){
            return true;
        } else return clickAccordeonItemMKAD(lineOfTextQuestion, lineOfTextAnswer);
    }

    //Метод нажатия на кнопки меню аккордеона и проверки ответа
    public boolean clickAccordeonItemHowMuch(String lineOfTextQuestion, String lineOfTextAnswer) {
        boolean result = false;
        if ((driver.findElement(accordeonItemHowMuch).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemHowMuch).click(); // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemHowMuchP));
        }
        if ((driver.findElement(accordeonItemHowMuchP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
                result = true;
        }
        return result;
    }
    public boolean clickAccordeonItemItemNumberOfScooters(String lineOfTextQuestion, String lineOfTextAnswer){
        boolean result = false;
        if ((driver.findElement(accordeonItemNumberOfScooters).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemNumberOfScooters).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemNumberOfScootersP));
        }
        if ((driver.findElement(accordeonItemNumberOfScootersP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;
    }
    public boolean clickAccordeonItemRentalTimeCalculation(String lineOfTextQuestion, String lineOfTextAnswer){
        boolean result = false;
        if ((driver.findElement(accordeonItemRentalTimeCalculation).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemRentalTimeCalculation).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemRentalTimeCalculationP));
        }
        if ((driver.findElement(accordeonItemRentalTimeCalculationP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;
    }

    public boolean clickAccordeonItemRightToday(String lineOfTextQuestion, String lineOfTextAnswer) {
        boolean result = false;
        if ((driver.findElement(accordeonItemRightToday).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemRightToday).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemRightTodayP));
        }
        if ((driver.findElement(accordeonItemRightTodayP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;
    }
    public boolean clickAccordeonItemExtensionReductionOrder(String lineOfTextQuestion, String lineOfTextAnswer) {
        boolean result = false;
        if ((driver.findElement(accordeonItemExtensionReductionOrder).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemExtensionReductionOrder).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemExtensionReductionOrderP));
        }
        if ((driver.findElement(accordeonItemExtensionReductionOrderP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;
    }
    public boolean clickAccordeonItemCancelTheOrder(String lineOfTextQuestion, String lineOfTextAnswer) {
        boolean result = false;
        if ((driver.findElement(accordeonItemCancelTheOrder).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemCancelTheOrder).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemCancelTheOrderP));
        }
        if ((driver.findElement(accordeonItemCancelTheOrderP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;

    }
    public boolean clickAccordeonItemScooterCharging(String lineOfTextQuestion, String lineOfTextAnswer) {
        boolean result = false;
        if ((driver.findElement(accordeonItemScooterCharging).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemScooterCharging).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemScooterChargingP));
        }
        if ((driver.findElement(accordeonItemScooterChargingP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;
    }
    public boolean clickAccordeonItemMKAD(String lineOfTextQuestion, String lineOfTextAnswer) {
        boolean result = false;
        if ((driver.findElement(accordeonItemMKAD).getText()).contains(lineOfTextQuestion)) { // Если заголовок содержит текст вопроса
            driver.findElement(accordeonItemMKAD).click();  // Кликаем на заголовок
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));  // Даем время открыться пункту меню
            wait.until(ExpectedConditions.elementToBeClickable(accordeonItemMKADP));
        }
        if ((driver.findElement(accordeonItemMKADP).getText()).contains(lineOfTextAnswer)) { //Проверяем содержимое пункта меню
            result = true;
        }
        return result;
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