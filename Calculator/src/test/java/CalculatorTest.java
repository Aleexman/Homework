import org.example.PageObjects.AllCalculatorsPage;
import org.example.PageObjects.CalculatorHomePage;
import org.example.DriverFactory;
import org.example.PageObjects.ScientificCalculatorPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    WebDriver driver = DriverFactory.getWebDriverInstance();
    @BeforeTest
    public void setUp(){

        driver.get("https://www.calculator.net/");
    }

    @AfterTest
    public void cleanUp(){
         driver.close();
    }

    @Test
    public void calculationsTest(){
        CalculatorHomePage calculatorHomePage = new CalculatorHomePage();
        AllCalculatorsPage allCalculatorsPage = new AllCalculatorsPage();
        ScientificCalculatorPage scientificCalculatorPage = new ScientificCalculatorPage();

        calculatorHomePage.clickAllCalculatorsButton();
        allCalculatorsPage.clickScientificCalculatorsButton();
        scientificCalculatorPage.clickEightButton();
        scientificCalculatorPage.clickMultipleButton();
        scientificCalculatorPage.clickLeftBracketButton();
        scientificCalculatorPage.clickEightButton();
        scientificCalculatorPage.clickMinusButton();
        scientificCalculatorPage.clickThreeButton();
        scientificCalculatorPage.clickRightBracketButton();
        scientificCalculatorPage.clickResultButton();
        double result = scientificCalculatorPage.getValueFromResultOutput();
        Assert.assertEquals(result,8*(8-3));
        driver.switchTo().activeElement().sendKeys(Keys.DELETE);

        Actions actions = new Actions(driver);
        scientificCalculatorPage.clickLogButton();
        actions.sendKeys("56")
                .keyDown(Keys.SHIFT)
                .sendKeys(")")
                .keyUp(Keys.SHIFT)
                .sendKeys("/")
                .perform();
        scientificCalculatorPage.clickLnButton();
        actions.sendKeys("56")
                .keyDown(Keys.SHIFT)
                .sendKeys(")*")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.SHIFT)
                .sendKeys("(")
                .keyUp(Keys.SHIFT)
                .sendKeys("5")
                .keyDown(Keys.SHIFT)
                .sendKeys("*")
                .keyUp(Keys.SHIFT)
                .perform();
        scientificCalculatorPage.clickSqrtButton();
        actions.sendKeys("4")
                .keyDown(Keys.SHIFT)
                .sendKeys(")*")
                .keyUp(Keys.SHIFT)
                .sendKeys("10")
                .keyDown(Keys.SHIFT)
                .sendKeys(")")
                .keyUp(Keys.SHIFT)
                .sendKeys("=")
                .sendKeys(Keys.BACK_SPACE)
                .perform();

        double secondResult = Math.log10(56)/Math.log(56)*(5*Math.sqrt(4)*10);
        String secondResultFormatted = String.format("%.8f",secondResult).replace(",",".");
        System.out.println(secondResult);
        double valueFromSecondOutput = scientificCalculatorPage.getValueFromResultOutput();
        Assert.assertEquals(String.valueOf(valueFromSecondOutput),secondResultFormatted);
    }
}
