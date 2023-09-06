package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getChromeWebDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getFirefoxWebDriver(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\askuzenkov\\IdeaProjects\\Calculator\\src\\main\\resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getWebDriverInstance(){

        String browser = ConfigurationProperties.getProperty("browser");

        if(driver==null){
            switch (browser){
                case "Chrome":
                    driver = getChromeWebDriver();
                    break;
                case "FireFox":
                    driver = getFirefoxWebDriver();
                    break;
            }
        }
        return driver;
    }
}
