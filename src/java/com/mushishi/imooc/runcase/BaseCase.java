package com.mushishi.imooc.runcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseCase {
    //创建一个方法，传入参数是为了甄别，传入的是哪个浏览器。
    public WebDriver GetDriver(String browser){
        WebDriver driver;
        //判断传入的值,别用纯equals判断，可能会忽略大小写。
        if(browser.equalsIgnoreCase("chrome")){
            //driver文件配置
            System.setProperty("webdriver.chrome.driver", "D:\\web_selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "D:\\web_selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
