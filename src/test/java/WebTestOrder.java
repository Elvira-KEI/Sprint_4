import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

@RunWith(Parameterized.class)
public class WebTestOrder {

    WebDriver driver;
    MainPage mainPage;
        private final String name;
        private final String surname;
        private final String address;
        private final String phoneNumber;


        public WebTestOrder(String name, String surname, String address, String phoneNumber){
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        @Parameterized.Parameters
        public static Object[][] getParameters(){
            return new Object[][]{
                    {"Эля", "Кондратьева", "Владивосток", "+79024888980"},
                   {"дмитрий", "петропольский", "благовещенск", "84232352365"},
              {"СТАС", "АСАФЬЕВ", "МОСКВА, КУТУЗОВСКИЙ ПРОСПЕКТ 253", "89502818935"},
            };
        }

        @Before
        public void setUp(){
           driver = new ChromeDriver();
               //  driver = new FirefoxDriver();


        }
        //Заказ самоката. Точка входа кнопка «Заказать» вверху страницы
        @Test
        public void checkOrderScooter(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           MainPage mainPage = new MainPage(driver);
            mainPage.open();
            mainPage.clickCloseCookies();
            mainPage.clickOrderButton();
            mainPage.name(name);
            mainPage.surname(surname);
            mainPage.address(address);
            mainPage.metroStation();
            mainPage.metroStationCHOICE();
            mainPage.phoneNumber(phoneNumber);
            mainPage.clickNextButton();
            mainPage.date();
            mainPage.rent();
            mainPage.clickOrderButtonInRentPage();
            mainPage.clicksNextOrderButton();
        }


        //Заказ самоката. Точка входа кнопка «Заказать» внизу страницы
        @Test
        public void checkOrderScooter_withScroll_and_clickOrder(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            MainPage mainPage = new MainPage(driver);
            mainPage.open();
            mainPage.clickCloseCookies();
            WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button")).click();
            mainPage.name(name);
            mainPage.surname(surname);
            mainPage.address(address);
            mainPage.metroStation();
            mainPage.metroStationCHOICE();
            mainPage.phoneNumber(phoneNumber);
            mainPage.clickNextButton();
            mainPage.date();
            mainPage.rent();
            mainPage.clickOrderButtonInRentPage();
            mainPage.clicksNextOrderButton();

        }
    @After
    public void cleanUp() {
        driver.quit();//Закрыть браузер
    }

    }
