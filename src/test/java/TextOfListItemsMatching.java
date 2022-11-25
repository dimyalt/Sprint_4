import SitePages.HomePageSamokat;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class TextOfListItemsMatching {
    WebDriver driver;
    private final String textLine;
    private final boolean isThisLine;
    private final String browserDriver;

    public TextOfListItemsMatching(String textLine, boolean isThisLine, String browserDriver) {
        this.textLine = textLine;
        this.isThisLine = isThisLine;
        this.browserDriver = browserDriver;
    }
    @Parameterized.Parameters
    public static Object[][] getTextLine(){
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true, "Chrome"},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true, "Chrome"},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true, "Chrome"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true, "Chrome"},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true, "Chrome"},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true, "Chrome"},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true, "Chrome"},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", true, "Chrome"},
        };
    }
    @Test
    public void test(){

        System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\bin\\geckodriver.exe");
        if(browserDriver.equals("Chrome")){
            driver = new ChromeDriver(); //Драйвер для Chrome
        }else{
            driver = new FirefoxDriver(); //Драйвер для FireFox
        }

        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объект класса HomePage
        HomePageSamokat objHomePage = new HomePageSamokat(driver);

        objHomePage.clickCookieButton(); //Кликаем по кнопки принятия cookie
        objHomePage.scrollForMenuHomePageSamokat(); //Скроллим до меню аккордеона

        MatcherAssert.assertThat(String.valueOf(objHomePage.testAllMenuItemsValues(textLine)), isThisLine);

    }
    @After
    public void teasDown(){
        driver.quit();
    }
}
//Финальное измененние для pull request