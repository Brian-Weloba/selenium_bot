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

        // TODO: login to mymovies africa
        String tagname= "";
        tagname=driver.findElement(By.cssSelector("a[class='btn btn-nav btn-warning']")).getText();
        System.out.println(tagname);

        WebElement category = driver.findElement(By.cssSelector("a[class='btn btn-nav btn-warning']"));
        Actions action = new Actions(driver);
        action.moveToElement(category);
        action.click();
        action.perform();
        Thread.sleep(3000);

//        driver.findElement(By.linkText("LOGIN")).click();
//        Thread.sleep(2000);

        loginAccount(driver);
    }
    private static void loginAccount(WebDriver driver) throws InterruptedException {
//        String loginname = "";
//        loginname=driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled']")).getText();
//        System.out.println(loginname);

        WebElement login = driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(login).click(login).build().perform();
        Thread.sleep(3000);

        WebElement email= driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hamsoace@gmail.com");
        System.out.println(email);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("Sumeshu1");
        System.out.println(password);

        WebElement submit = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-block btn-warning']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(submit).click(submit).build().perform();
        Thread.sleep(3000);

        WebElement phoneNumber = driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled']"));
        Actions actions2 = new Actions(driver);
        actions1.moveToElement(phoneNumber).click(phoneNumber).build().perform();
        Thread.sleep(3000);

        watchMovie(driver);
    }

    private static void watchMovie(WebDriver driver) {
    }
}
