package com.pig.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {

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
        if (driver == null) driver = new ChromeDriver();
        return driver;
    }

    public String getConfig(String key) throws IOException {

        InputStream inputStream = null;

        if (null == this.prop) {
            try {
                prop = new Properties();

                String propFileName = "input.properties";

                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                inputStream.close();
            }
        }
        return String.valueOf(this.prop.get(key));
    }
}
