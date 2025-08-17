package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testFormWithValidData() {
        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Malia");
        driver.findElement(By.id("last-name")).sendKeys("Tester");
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");

        driver.findElement(By.cssSelector("input[value='radio-button-1']")).click();
        driver.findElement(By.id("submit")).click();

        WebElement alert = driver.findElement(By.className("alert"));
        Assert.assertTrue(alert.getText().contains("The form was successfully submitted!"));
    }

    @Test(priority = 2)
    public void testFormWithEmptyFields() {
        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("submit")).click();

        // check if still on form page (validation failed)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("form"));
    }
}
