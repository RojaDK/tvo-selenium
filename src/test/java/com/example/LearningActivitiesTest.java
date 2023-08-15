package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LearningActivitiesTest {
    WebDriver driver;
// Test to verify each link under "Learning Activities" 
    @Test
    public void test() throws InterruptedException {
        UtilityTest landingUrl = new UtilityTest();
        landingUrl.navigationTest();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tab0 > button")));
        List<WebElement> globalFocusLearningActivities = driver.findElements(
                By.xpath("/html/body/div[4]/main/div[2]/div/div/div[2]/div[4]/div[2]/section/div[1]/div/div/div/a"));
        int size = globalFocusLearningActivities.size();
        for (int i = 0; i < size; ++i) {
            List<WebElement> globalFocusLearningActivities2 = driver.findElements(
                    By.xpath(
                            "/html/body/div[4]/main/div[2]/div/div/div[2]/div[4]/div[2]/section/div[1]/div/div/div/a"));
            Thread.sleep(1000);
            globalFocusLearningActivities2.get(i).click();
            Thread.sleep(1000);
            driver.navigate().back();
        }
    }
}
