import SitePages.HomePageSamokat;
import SitePages.OrderPagesSamokat;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class AllStepsOfOrderOrderPlaced {
    WebDriver driver;
    private final String orderName;
    private final String orderLastname;
    private final String orderAdres;
    private final String orderSubstantion;
    private final String orderPhone;
    private final String orderStartDate;
    private final String orderDuration;
    private final String scooterColor;
    private final String orderComment;
    private final String expectedResult;
    private final String browserDriver;  //Переменная для выбора браузера для тестирования (или Chrome или Firefox)
    private final String buttonPlace; //Переменная для выбора кнопки "Заказать" (или header или body)

    public AllStepsOfOrderOrderPlaced(String orderName, String orderLastname, String orderAdres,
                                      String orderSubstantion, String orderPhone, String orderStartDate,
                                      String orderDuration, String scooterColor, String orderComment,
                                      String expectedResult, String browserDriver, String buttonPlace){
        this.orderName = orderName;
        this.orderLastname = orderLastname;
        this.orderAdres = orderAdres;
        this.orderSubstantion = orderSubstantion;
        this.orderPhone = orderPhone;
        this.orderStartDate = orderStartDate;
        this.orderDuration = orderDuration;
        this.scooterColor = scooterColor;
        this.orderComment = orderComment;
        this.expectedResult = expectedResult;
        this.browserDriver = browserDriver;
        this.buttonPlace = buttonPlace;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Горев", "Сергей", "Россия, г. Мытищи, Дачная ул., д. 14 кв.133", "Люблино", "+79912069080",
                        "31.12.2022", "трое суток", "серый", "Надеюсь курьер не приедет на моем самокате", "Заказ оформлен",
                        "Chrome", "body"},
                {"Кузькина", "Ярослава", "Россия, г. Москва, Пионерская ул., д. 3 кв.145", "Угрешская", "+79052053461",
                        "30.11.2022", "семеро суток", "черный", "Мне хватит недели чтобы научится на нем кататься?",
                        "Заказ оформлен", "Chrome", "header"},
        };
    }
    @Test
    public void testOrder() {

        System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\bin\\geckodriver.exe");

        if(browserDriver.equals("Chrome")){
            driver = new ChromeDriver(); //Драйвер для Chrome
        }else{
            driver = new FirefoxDriver(); //Драйвер для FireFox
        }

        driver.get("https://qa-scooter.praktikum-services.ru"); //Переходим на главную страницу приложения
        HomePageSamokat objHomePage = new HomePageSamokat(driver); //Создаем объект гласса главной страницы
        objHomePage.clickCookieButton(); //Кликаем на кнопку "Cookies"
        objHomePage.choseOrderButton(buttonPlace);
        OrderPagesSamokat objOrderPage = new OrderPagesSamokat(driver); //Создаем объект гласса главной страницы
        objOrderPage.setContactInfo(orderName, orderLastname, orderAdres, orderSubstantion, orderPhone);

        String result = objOrderPage.setDeliveryInfo(orderStartDate, orderDuration, scooterColor, orderComment);
        MatcherAssert.assertThat(result, containsString(expectedResult));


    }
    @After
    public void teasDown(){
        driver.quit();
    }
}
//Финальное измененние для pull request