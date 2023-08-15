package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class utilityTest {
    WebDriver driver;

    @Test
    public void navigationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\RojaDunuka\\Documents\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tvolearn.com/");
        driver.manage().window().maximize();
        driver.findElement(By.className("site-nav__label")).click();
        driver.findElement(By.cssSelector("#SiteNavLabel-elementary-k-8 > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.xpath("//div[@class='button-subject-name' and text()='Science & Technology']")).click();
}
}
