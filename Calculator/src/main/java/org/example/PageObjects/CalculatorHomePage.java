package org.example.PageObjects;

import org.example.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorHomePage {

    private WebDriver driver = DriverFactory.getWebDriverInstance();
    public By allCalculatorsButton = By.xpath("//img[@alt='All Calculators']");

    public void clickAllCalculatorsButton(){
        driver.findElement(allCalculatorsButton).click();
    }
}
