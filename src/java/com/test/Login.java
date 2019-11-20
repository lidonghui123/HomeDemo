package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login  extends BasePage{
    public WebDriver driver;
    @BeforeClass
    public void courseList1() {
        // 加载配置文件
        System.setProperty("webdriver.chrome.driver", "D:\\web_selenium\\chromedriver.exe");
        // 实例化driver对象
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("redrain-closeBtn")).click();
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
    }
    /**
     * 下单流程
     */

    public void buyCourse() throws InterruptedException {
        driver.get("https://coding.imooc.com/class/330.html");
        String cousrseDetail = this.buyCourseNow();
        this.sureOrder();
        if (this.getOder() != null) {
            Thread.sleep(1000);
            Assert.assertEquals(cousrseDetail,this.getOrderCourse(), "购买的商品信息不一样");
        }

    }

    /**
     * 获取element
     * 父element元素。
     */
    public WebElement getElement(By by){
        return driver.findElement(by);
    }
    /**
     * 通过父节点，获取子节点
     */
    public WebElement getElement(WebElement element,By key){
        return  element.findElement(key);
    }
    /**
     * 获取课程信息
     */
    public String getCourseText(WebElement element) {
        return element.getText();
    }
    /**
     * 立即购买,返回课程信息
     */

    public String  buyCourseNow(){

        //父节点的element
        WebElement element= this.getElement(GetByLocal("courseInfo"));
        //子节点
        WebElement elementNode = this.getElement(element,GetByLocal("courseInfoText"));
        //拿到课程信息
        String currentText= this.getCourseText(elementNode);
        //立即购买的按钮点击
        this.getElement(GetByLocal("BuyNow")).click();
        return  currentText;
    }
    /**
     * 点击确定订单
     */
    public void sureOrder(){
        //提交按钮
        this.getElement(GetByLocal("sureOrder")).click();
    }
    /**
     * 获取订单号text
     */
    public String getOder(){
      String  orderText =  this.getCourseText(this.getElement(GetByLocal("order")));
      return orderText;
    }
    /**
     * 获取支付中心商品信息
     */
    public String getOrderCourse(){
       String orderCourse= getCourseText(this.getElement(GetByLocal("orderCourse")));
       return  orderCourse;
    }
    /**
     * 下单流程
     */
    @Test(dependsOnMethods = {"checkBox"})
    public void downOrder() throws InterruptedException {
        driver.get("https://coding.imooc.com/class/330.html");
        String currenttext = this.buyCourseNow();
        System.out.println("当前课程信息:"+currenttext);
        this.sureOrder();
        Thread.sleep(2000);
        this.getOder();
        String orderCourseText = this.getOrderCourse();
        System.out.println("订单页面的课程信息："+orderCourseText);
        if(currenttext.equals(orderCourseText)){
            System.out.println("下单成功！");
        }
    }


}
