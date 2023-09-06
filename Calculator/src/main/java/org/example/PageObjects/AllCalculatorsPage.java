package org.example.PageObjects;

import org.example.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllCalculatorsPage {

    private WebDriver driver = DriverFactory.getWebDriverInstance();
    public By scientificCalculatorButton = By.xpath("//a[text()='Scientific Calculator']");

    public void clickScientificCalculatorsButton(){
        driver.findElement(scientificCalculatorButton).click();
    }
}
