package org.hamso.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // TODO: open the web app
        driver.navigate().to("https://mymovies.africa");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        if(title.equalsIgnoreCase("mymovies.africa")){
            System.out.println("Title fits");
        }else {
            System.out.println(title);
        }

        // TODO: locate a web element
        String tagname= " ";
        tagname=driver.findElement(By.cssSelector("btn btn-nav btn-warning")).getText();
        System.out.println(tagname);

        WebElement category = driver.findElement(By.cssSelector("btn btn-nav btn-warning"));
        Actions action = new Actions(driver);
        action.moveToElement(category);
        action.click();
        action.perform();
        Thread.sleep(3000);

        driver.findElement(By.linkText("LOGIN")).click();
        Thread.sleep(2000);


    }
}
