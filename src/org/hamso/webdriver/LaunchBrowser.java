package org.hamso.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // TODO: open the web app
        driver.navigate().to("https://essayshark.com/latest-orders.html");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        if(title.equalsIgnoreCase("essays writing service")){
            System.out.println("Title fits");
        }else {
            System.out.println(title);
        }

        // TODO: login to mymovies africa
        String tagname= "";
//        tagname=driver.findElement(By.cssSelector("button[class='header__button--account-desktop button--ghost button--ghost-blue js--account']")).getText();
        tagname=driver.findElement(By.className("bb-accountEmptyButtonText")).getText();
        System.out.println(tagname);

//        WebElement category = driver.findElement(By.cssSelector("button[class='header__button--account-desktop button--ghost button--ghost-blue js--account']"));
        WebElement category = driver.findElement((By.className("bb-accountEmptyButtonText")));
        Actions action = new Actions(driver);
        action.moveToElement(category);
        action.click();
        action.perform();
        Thread.sleep(3000);

//        driver.findElement(By.linkText("LOGIN")).click();
//        Thread.sleep(2000);

        loginAccount(driver);
        placeOrder(driver);
    }
    private static void loginAccount(WebDriver driver) throws InterruptedException {
//        String loginname = "";
//        loginname=driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled']")).getText();
//        System.out.println(loginname);

//        WebElement login = driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(login).click(login).build().perform();
//        Thread.sleep(3000);

        WebElement d = driver.findElement(By.className("bb-modalContainer"));
        WebElement email = d.findElement(By.xpath("//input[contains(@class, 'login')]"));
//        WebElement email= driver.findElement(By.name("login"));
//        email.clear();
        email.sendKeys("edgarmugeni@gmail.com");
        System.out.println(email);

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("edgarshark");
        System.out.println(password);

        WebElement login = driver.findElement(By.cssSelector("button[class='button button--auth auth__submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(login).click(login).build().perform();
        Thread.sleep(5000);

//        WebElement submit = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-block btn-warning']"));
//        Actions actions1 = new Actions(driver);
//        actions1.moveToElement(submit).click(submit).build().perform();
//        Thread.sleep(3000);
//
//        WebElement phoneNumber = driver.findElement(By.cssSelector("button[class='swal2-confirm swal2-styled']"));
//        Actions actions2 = new Actions(driver);
//        actions1.moveToElement(phoneNumber).click(phoneNumber).build().perform();
//        Thread.sleep(3000);

    }

    private static void placeOrder(WebDriver driver) throws InterruptedException {
        //current
        WebElement order = driver.findElement(By.linkText("Orders"));
        Actions actions = new Actions(driver);
        actions.moveToElement(order).click(order).build().perform();
        Thread.sleep(3000);

        boolean displayed = false;
        do{
            try{
                displayed = driver.findElement(By.cssSelector("action_core")).isDisplayed();
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        } while (!displayed);



    }
}
