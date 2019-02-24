package com.pig.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {


    public static final String PATH_TO_CHROME_DRIVER = "E:\\GIT\\selenium-test\\src\\main\\java\\SeleniumExe\\chromedriver.exe";
    public static final String PATH_TO_IE_DRIVER = "E:\\GIT\\selenium-test\\src\\main\\java\\SeleniumExe\\IEDriverServer.exe";

    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";

    private static Helper instance;
    private static WebDriver driver;
    private Properties prop;

    public static Helper getInstance() {
        if (null == instance) {
            instance = new Helper();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, PATH_TO_CHROME_DRIVER);
            driver = new ChromeDriver();
        }
        return driver;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(getInstance().getConfig("user.name"));
    }

    public String getConfig(String key) throws IOException {
        return String.valueOf(this.getProp().get(key));
    }

    public Properties getProp() throws IOException {

        InputStream inputStream = null;

        if (null == this.prop) {
            try {
                prop = new Properties();

                inputStream = new FileInputStream("E:\\GIT\\selenium-test\\src\\input.properties");

                prop.load(inputStream);

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }

        return prop;
    }
}
