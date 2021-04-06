package driver.browser;

import org.openqa.selenium.firefox.*;
import io.github.bonigarcia.wdm.*;

public class FireFoxDriverManager extends driver.DriverManager {

    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        this.driver = new FirefoxDriver(options);
    }

}
