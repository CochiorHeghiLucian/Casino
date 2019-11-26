package com.example.demo.dataread;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

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
        Thread.sleep(1000);
        WebElement password = webDriver.findElement(By.xpath("//input[@type='password']"));
        webDriver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonAccept']")).click();
        login.sendKeys();
        password.sendKeys();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//button[@class='btn btn__primary btn--block btn']")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//i[@class='icon icon-menu']")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//a[@href='/casino-live']")).click();
        Thread.sleep(1000);

        //hover
        Actions action = new Actions(webDriver);
        WebElement we = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div/div/div[3]/div/div[3]/div/div"));
        String parentWindow = webDriver.getWindowHandle();
        Thread.sleep(1000);
        action.moveToElement(we).moveToElement(webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div/div/div[3]/div/div[3]/div/button"))).click().build().perform();

//        webDriver.findElement(By.xpath("(//button[@class='btn btn--md btn--w-144 btn__primary--yellow casino-games__item-play'])[3]")).click();
        Thread.sleep(1000);

        Set<String> handles = webDriver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                webDriver.switchTo().window(windowHandle);
                webDriver.manage().window().maximize();
                System.out.println(webDriver.getTitle());
            }
        }

        Thread.sleep(5000);

        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[12]/div/div/div/div[2]/div/div[1]/button")).click();

        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[3]/img")).click();

        List<WebElement> numbers = webDriver.findElements(By.cssSelector("div[class='number-container--1mKjk statistics--3-rTs']>div>span"));

        for (WebElement element:numbers){
            System.out.println(element.getText());
        }

        Thread.sleep(10000);

        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
