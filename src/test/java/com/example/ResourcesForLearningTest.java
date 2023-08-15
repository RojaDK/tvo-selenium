package com.example;

import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ResourcesForLearningTest {
    WebDriver driver;

    // Test to click each link under "Resources for Learning" and verify Broken
    // Links and close all tabs except current tab
    @Test
    public void test1() throws InterruptedException {
        UtilityTest landingUrl = new UtilityTest();
        landingUrl.navigationTest();
        List<WebElement> links = driver.findElements(
                By.xpath("/html/body/div[4]/main/div[2]/div/div/div[2]/div[5]/div/div/div[2]/div[4]/ul/li/a"));
        String originalHandle = driver.getWindowHandle();
        for (WebElement link : links) {
            link.click();
            String url = link.getAttribute("href");
            verifyLink(url);
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalHandle)) {
                    driver.switchTo().window(handle);
                    driver.close();
                }
            }
            driver.switchTo().window(originalHandle);
        }
    }

    public static void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }

}
