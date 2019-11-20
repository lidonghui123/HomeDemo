package com.mushishi.imooc.runcase;


import com.mushishi.imooc.business.CoursePagePro;
import com.mushishi.imooc.handle.CoursePageHandle;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login   {
    public WebDriver driver;
    public CoursePagePro cpp;
    public CoursePageHandle c1;
    @BeforeClass
    public void courseList1() {
        //预加载
        //应该引入log4j的目录以及文件
        PropertyConfigurator.configure("log4j.properties");
        // 加载配置文件
        System.setProperty("webdriver.chrome.driver", "D:\\web_selenium\\chromedriver.exe");
        // 实例化driver对象
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // driver.findElement(By.className("redrain-closeBtn")).click();
    }
    @Test
    public void checkBox() {
        // ID定位
        driver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // name定位
        driver.findElement(By.name("email")).sendKeys("1323134804@qq.com");
        // className定位
        driver.findElement(By.className("js-loginPassword")).sendKeys("libowen8866");
        //登录按钮
        driver.findElement(By.className("moco-btn-red")).click();
        //等待页面加载
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://coding.imooc.com/class/330.html");
        cpp = new CoursePagePro(driver);
    }
    /**
     * 添加购物车
     */
    @Test(dependsOnMethods = {"checkBox"})
    public void  TestAddCart() throws InterruptedException {
        cpp.addCart();

    }
    /**
     * 下单流程
     */

//    public void buyCourse() throws InterruptedException {
//        driver.get("https://coding.imooc.com/class/330.html");
//        String cousrseDetail = this.buyCourseNow();
//        this.sureOrder();
//        if (this.getOder() != null) {
//            Thread.sleep(1000);
//            Assert.assertEquals(cousrseDetail,this.getOrderCourse(), "购买的商品信息不一样");
//        }
//
//    }





}