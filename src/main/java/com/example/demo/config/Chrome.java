package com.example.demo.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Chrome {
    CHROME_INSTANCE(new ChromeDriver()),
    FIREFOX_INSTANCE(new FirefoxDriver());

    WebDriver driver;

    Chrome(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
