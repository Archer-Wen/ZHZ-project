package com.zhzteam.zhz233.common.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Schedul4399Utils {

    public static void closeWebDriver(WebDriver webDriver){
            webDriver.close();
    }

    public static WebDriver Schedul4399(String username, String password){
        WebDriver webDriver = Schedul4399Utils.getWebDriver();
        webDriver.get("http://www.4399.com/");
        WebElement btnLoginBox = webDriver.findElement(By.id("login_tologin"));
        btnLoginBox.click();
        webDriver.switchTo().frame(0);
        WebElement usernameBox = webDriver.findElement(By.id("username"));
        WebElement passwordBox = webDriver.findElement(By.id("password"));
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        WebElement submitBtn = webDriver.findElement(By.className("ptlogin_btn"));
        submitBtn.click();
        return webDriver;
    }

    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.gecko.driver", "G:\\Zhz233File\\Driver\\32\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return webDriver;
    }
}
