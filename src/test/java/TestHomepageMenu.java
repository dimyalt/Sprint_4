import sitepages.HomePageSamokat;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class TestHomepageMenu {
    WebDriver driver;
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    private final String textLine;
    private final String browserDriver;

    public TestHomepageMenu(String textLine, String browserDriver) {
        this.textLine = textLine;
        this.browserDriver = browserDriver;
    }
    @Parameterized.Parameters
    public static Object[][] getTextLine(){
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Chrome"},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Chrome"},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Chrome"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Chrome"},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Chrome"},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Chrome"},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Chrome"},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", "Chrome"},
        };
    }
    @Test
    public void testMenuItems(){

        System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\bin\\geckodriver.exe");
        if(browserDriver.equals("Chrome")){
            driver = new ChromeDriver(); //Драйвер для Chrome
        }else{
            driver = new FirefoxDriver(); //Драйвер для FireFox
        }

        driver.get(PAGE_URL); //Переходим на главную страницу приложения

        //Создаем объект класса HomePage
        HomePageSamokat objHomePage = new HomePageSamokat(driver);

        objHomePage.clickCookieButton(); //Кликаем по кнопки принятия cookie
        objHomePage.scrollForMenuHomePageSamokat(); //Скроллим до меню аккордеона

        assertTrue(objHomePage.testAllMenuItemsValues(textLine));
    }
    @After
    public void tearsDown(){
        driver.quit();
    }
}
