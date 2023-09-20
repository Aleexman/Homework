package org.example.PageObjects;

import org.example.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScientificCalculatorPage {
    private WebDriver driver = DriverFactory.getWebDriverInstance();
    public By eightButton = By.xpath("//span[@onclick='r(8)']");
    public By multipleButton = By.xpath("//span[text()='×']");
    public By sqrtButton = By.xpath("//span[@onclick=\"r('sqrt')\"]");
    public By divideButton = By.xpath("//span[text()='÷']");
    public By leftBracketButton = By.xpath("//span[text()='(']");
    public By minusButton = By.xpath("//span[text()='–']");
    public By threeButton = By.xpath("//span[@onclick='r(3)']");
    public By fourButton = By.xpath("//span[@onclick='r(4)']");
    public By fiveButton = By.xpath("//span[@onclick='r(5)']");
    public By sixButton = By.xpath("//span[@onclick='r(6)']");
    public By oneButton = By.xpath("//span[@onclick='r(1)']");
    public By zeroButton = By.xpath("//span[@onclick='r(0)']");
    public By acButton = By.xpath("//span[text()='AC']");
    public By lnButton = By.xpath("//span[text()='ln']");
    public By logButton = By.xpath("//span[text()='log']");
    public By rightBracketButton = By.xpath("//span[text()=')']");
    public By resultButton = By.xpath("//span[text()='=']");
    public By sciInPut = By.xpath("//div[@id='sciInPut']");
    public By sciOutPut = By.xpath("//div[@id='sciOutPut']");

    public void clickEightButton() {
        driver.findElement(eightButton).click();
    }

    public void clickMultipleButton() {
        driver.findElement(multipleButton).click();
    }

    public void clickLeftBracketButton() {
        driver.findElement(leftBracketButton).click();
    }

    public void clickMinusButton() {
        driver.findElement(minusButton).click();
    }

    public void clickThreeButton() {
        driver.findElement(threeButton).click();
    }

    public void clickRightBracketButton() {
        driver.findElement(rightBracketButton).click();
    }

    public void clickResultButton() {
        driver.findElement(resultButton).click();
    }

    public void clickLnButton() {
        driver.findElement(lnButton).click();
    }

    public void clickLogButton() {
        driver.findElement(logButton).click();
    }

    public void clickSqrtButton() {
        driver.findElement(sqrtButton).click();
    }
    public double getValueFromResultOutput() {
        String result = driver.findElement(sciOutPut).getText();
        return Double.parseDouble(result.replaceAll(" ", ""));
    }

}
