package com.example.demo.dataread;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DataReadNumbers {
    private static final String SUPERBER_FIST_PAGE = "https://www.superbet.ro";
    private static WebDriver webDriver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.navigate().to(SUPERBER_FIST_PAGE);

        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[@class='header__right']/button[1]")).click();

        WebElement login = webDriver.findElement(By.xpath("//input[@class='input__field']"));
        Thread.sleep(500);
        WebElement password = webDriver.findElement(By.xpath("//input[@type='password']"));
        login.sendKeys("");
        password.sendKeys("");
        Thread.sleep(500);
        webDriver.findElement(By.xpath("//button[@class='btn btn__primary btn--block btn']")).click();
        Thread.sleep(500);
        webDriver.findElement(By.xpath("//i[@class='icon icon-menu']")).click();
        Thread.sleep(500);
        webDriver.findElement(By.xpath("//a[@href='/casino-live']")).click();
        Thread.sleep(500);

        //hover
        Actions action = new Actions(webDriver);
        WebElement we = webDriver.findElement(By.xpath("(//div[@class='casino-games__item-betting-range-wrapper'])[3]"));
        Thread.sleep(1000);
        action.moveToElement(we).moveToElement(webDriver.findElement(By.xpath("(//button[@class='btn btn--md btn--w-144 btn__primary--yellow casino-games__item-play'])[3]"))).click().build().perform();

//        webDriver.findElement(By.xpath("(//button[@class='btn btn--md btn--w-144 btn__primary--yellow casino-games__item-play'])[3]")).click();
        Thread.sleep(1000000);


        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
