package exceptions;

import io.github.bonigarcia.wdm.config.DriverManagerType;

import java.util.Locale;

public class NotSupportedException extends Exception {

    public NotSupportedException(DriverManagerType browserType) {
        System.out.println(String.format("Browser %s not supported", browserType.name().toLowerCase(Locale.ROOT)));
    }
}
