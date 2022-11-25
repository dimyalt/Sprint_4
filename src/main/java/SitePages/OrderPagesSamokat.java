package SitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


//Класс страницы заказа
public class OrderPagesSamokat {
    private final WebDriver driver;
    //Локатор поля "Имя"
    private final By orderName = By.xpath("//input[contains(@placeholder,'* Имя')]");
    //Локатор поля "Фамилия"
    private final By orderLastname = By.xpath("//input[contains(@placeholder,'* Фамилия')]");
    //Локатор поля "Адрес"
    private final By orderAdres = By.xpath("//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");
    //Локатор поля "Метро"
    private final By orderSubstantion = By.xpath("//input[contains(@placeholder,'* Станция метро')]");
    //Локатор поля "Телефон"
    private final By orderPhone = By.xpath("//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    //Локатор поля "Когда привезти самокат"
    private final By orderDate = By.xpath("//input[contains(@placeholder,'* Когда привезти самокат')]");
    //Локатор поля "Срок аренды"
    private final By orderDuration = By.cssSelector(".Dropdown-arrow");
    //Локатор чекбокса "черный"
    private final By colorBlack = By.xpath("//input[@id = 'black']");
    //Локатор чекбокса "серый"
    private final By colorGrey = By.xpath("//input[@id = 'grey']");
    //Локатор поля "Комментарий"
    private final By orderComment = By.xpath("//input[contains(@placeholder,'Комментарий для курьера')]");

    //Локатор кнопки "Далее"
    private final By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    //Локатор кнопки "Заказать"
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор кнопки "Ok"
    private final By orderButtonOk = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    //Локатор окна завершения заказа
    private final By orderOk = By.xpath("//div[text()='Заказ оформлен']");

    public OrderPagesSamokat(WebDriver driver){
        this.driver = driver;
    }
    //Метод заполнения поля "Имя"
    public void setNameField(String setOrderName){
        driver.findElement(orderName).isEnabled();
        driver.findElement(orderName).clear();
        driver.findElement(orderName).sendKeys(setOrderName);
    }
    //Метод заполнения поля "Фамилия"
    public void setLastnameField(String setOrderLastname){
        driver.findElement(orderLastname).isEnabled();
        driver.findElement(orderLastname).clear();
        driver.findElement(orderLastname).sendKeys(setOrderLastname);
    }
    //Метод заполнения поля "Имя"
    public void serAdresField(String setOrderAdres){
        driver.findElement(orderAdres).isEnabled();
        driver.findElement(orderAdres).clear();
        driver.findElement(orderAdres).sendKeys(setOrderAdres);
    }
    //Метод заполнения поля "Станция метро"
    public void setSubstantionField(String setOrderSubstantion){
        driver.findElement(orderSubstantion).isEnabled();
        driver.findElement(orderSubstantion).clear();
        driver.findElement(orderSubstantion).click();
        driver.findElement(orderSubstantion).sendKeys(setOrderSubstantion);
        //Клик на пункт выпадающего меню с подсказкой
        driver.findElement(By.xpath("//li[@class='select-search__row'][@data-index='0']")).click();
    }
    //Метод заполнения поля "Телефон"
    public void setPhoneField(String setOrderPhone){
        driver.findElement(orderPhone).isEnabled();
        driver.findElement(orderPhone).clear();
        driver.findElement(orderPhone).sendKeys(setOrderPhone);
    }
    //Метод заполнения контактной информации
    public void setContactInfo(String setOrderName, String setOrderLastname, String setOrderAdres, String
            setOrderSubstantion,  String setOrderPhone){
        setNameField(setOrderName);
        setLastnameField(setOrderLastname);
        serAdresField(setOrderAdres);
        setSubstantionField(setOrderSubstantion);
        setPhoneField(setOrderPhone);
        driver.findElement(nextButton).click();
    }
    //Метод заполнения даты заказа
    public void setOrderDateField(String setStartDate){
        driver.findElement(orderDate).isEnabled();
        driver.findElement(orderDate).clear();
        driver.findElement(orderDate).sendKeys(setStartDate);
        driver.findElement(By.className("Order_Header__BZXOb")).click();
    }
    //Метод заполнения срока аренды
    public void setOrderDurationField(String setOrderDuration){
        driver.findElement(orderDuration).isEnabled();
        driver.findElement(orderDuration).click();
        driver.findElement(By.xpath("//div[@class = 'Dropdown-option'][text() = '"+setOrderDuration+"']")).click();
    }
    //Метод выбора цвета
    public void setColorCheckbox(String setColor){
        if(setColor.equals("серый")){
            driver.findElement(colorGrey).click();
        }else if(setColor.equals("черный")){
            driver.findElement(colorBlack).click();
        }
    }
    //Метод заполнения комментария
    public void setOrderCommentField(String setOrderComment){
        driver.findElement(orderComment).isEnabled();
        driver.findElement(orderComment).sendKeys(setOrderComment);
    }
    //Метод заполнения информации о доставке
    public String setDeliveryInfo(String setStartDate, String setOrderDuration, String setColor, String setOrderComment){
        setOrderDateField(setStartDate);
        setOrderDurationField(setOrderDuration);
        setColorCheckbox(setColor);
        setOrderCommentField(setOrderComment);
        driver.findElement(orderButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.findElement(orderButtonOk).click();
        return getOrderStatus();
    }
    //Метод проверки успешного оформления заказа
    public String getOrderStatus(){
        return driver.findElement(orderOk).getText();
    }
}
//Финальное измененние для pull request