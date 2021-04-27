package config;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;

public class TestConfig {

    private static Logger LOGGER = Logger.getLogger(TestConfig.class);


    public static void initConfig() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = true;
        Configuration.browser = Browsers.CHROME;
        Configuration.headless = false;

    }
}

