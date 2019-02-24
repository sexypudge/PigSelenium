package com.pig.Utils;

import org.openqa.selenium.WebElement;

public class Utils {

    public static void clearAndType(WebElement e, String value) {
        // clear noi dung cu~ cua element trc
        e.clear();
        // dien` noi dung moi' vao`
        e.sendKeys(value);
    }
}
