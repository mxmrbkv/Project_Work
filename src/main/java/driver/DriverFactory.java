package driver;

import driver.factory.ChromeWebDriver;
import exceptions.NotSupportedException;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public WebDriver create(DriverManagerType driverData, MutableCapabilities options) throws NotSupportedException {
        switch(driverData) {
            case CHROME:
               return new ChromeWebDriver().newDriver();

            default:
                throw new NotSupportedException(driverData);
        }
    }
}
