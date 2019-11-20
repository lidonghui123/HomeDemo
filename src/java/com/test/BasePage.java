package com.test;

import com.mushishi.imooc.listener.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    public WebDriver driver1;


    /**
     * 元素定位类型封装
     */
    public By GetByLocal(String key) {
        ProUtil pro = new ProUtil("testlelement.properties");
        //定位信息输出debug（key）值
        //key比对，
        String Locator = pro.GetPro(key);
        // value值进行拆分
        String LocatorBy = Locator.split("<")[0];
        String LocatorValue = Locator.split("<")[1];
        System.out.println(LocatorValue);
        // 判断对应BY类型
        if (LocatorBy.equals("id")) {
            return By.id(LocatorValue);
        } else if (LocatorBy.equals("name")) {
            return By.name(LocatorValue);
        } else if (LocatorBy.equals("className")) {
            return By.className(LocatorValue);
        } else if(LocatorBy.equals("linkText")){
            return By.linkText(LocatorValue);
        }else {
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
