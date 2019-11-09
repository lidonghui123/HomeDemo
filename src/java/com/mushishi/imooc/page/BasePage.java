package com.mushishi.imooc.page;

import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    //实例化log4j
    static Logger logger=Logger.getLogger(BasePage.class);
    //声明driver
    public WebDriver driver1;
    //构造方法,传入driver
    public BasePage(WebDriver driver){
        //因为driver1是没有数值的，需要给它进行赋值
        this.driver1=driver;
    }
    /**
     * Element方法封装
     */
    public WebElement GetElement(String key){
        WebElement element = driver1.findElement(this.GetByLocal(key));
        return  element;
    }
    /**
     * 元素定位类型封装
     */
    public By GetByLocal(String key) {
        ProUtil pro = new ProUtil("element.properties");
        //定位信息输出debug（key）值
        logger.debug("你的定位信息的key为:"+key);
        //key比对，
        String Locator = pro.GetPro(key);
        // value值进行拆分
        String LocatorBy = Locator.split("<")[0];
        String LocatorValue = Locator.split("<")[1];
        logger.debug("你的定位方式为"+LocatorBy);
        logger.debug("你的定位值为"+LocatorValue);
        // 判断对应BY类型
        if (LocatorBy.equals("id")) {
            return By.id(LocatorValue);
        } else if (LocatorBy.equals("name")) {
            return By.name(LocatorValue);
        } else if (LocatorBy.equals("className")) {
            return By.className(LocatorValue);
        } else {
            return By.xpath(LocatorValue);
        }
    }

    /**
     * 鼠标悬停
     * @param
     */
    public void MoveToElement(WebElement ToElement){
        //new action对象
        Actions actions = new Actions(driver1);
        //鼠标悬停在图片Elemet上面
        actions.moveToElement(ToElement).perform();
    }
}
