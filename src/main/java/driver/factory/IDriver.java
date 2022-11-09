package driver.factory;

import exceptions.NotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import static data.DriverData.CHROME;

public interface IDriver {

    WebDriver newDriver() throws NotSupportedException;

    default public void downloadLocalWebDriver(DriverManagerType driverType) throws NotSupportedException {
        Config wdmConfig = WebDriverManager.globalConfig();
        wdmConfig.setAvoidBrowserDetection(true);

        String browserVersion = System.getProperty("browser.version", "");

        if (!browserVersion.isEmpty()) {
            switch (driverType) {
                case CHROME:
                    wdmConfig.setChromeDriverVersion(browserVersion);
                    break;
                default:
                    throw new NotSupportedException(driverType);
            }
        }

        WebDriverManager.getInstance(driverType).setup();
    }
}
