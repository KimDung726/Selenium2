package driver.browser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.*;

public class ChromeDriverManager extends driver.DriverManager {

    @Override
    public void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }

}
