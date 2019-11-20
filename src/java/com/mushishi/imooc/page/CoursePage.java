package com.mushishi.imooc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author libw-c
 */
public class CoursePage extends BasePage{

    public CoursePage(WebDriver driver) {
        super(driver);
    }
    /**
     * 获取立即购买按钮
     */
    public WebElement getBuytriggerElement(){
        return  GetElement("BuyNow");
    }
    /**
     * 获取添加购物车element
     */
    public WebElement getAddCartElement(){
        return GetElement("addCart");
    }
    /**
     * 获取右上角购物车element
     */
    public WebElement getShopCartElement(){
        return  GetElement("shopcart");
    }
    /**
     * 获取购物车数量
     */
    public WebElement getShopCartNumElement(){
        return GetElement("shopcartNum");
    }
    /**
     * 获取课程详情页面左上角课程名element
     */
    public WebElement getCouserNameElement(){
        return  nodeElement("courseInfo","courseInfoText");
    }
    /**
     * 通过子父节点定位
     * 已购买弹窗去购物车结算按钮
     */
    public WebElement getReadyBuy(){
        return nodeElement("readyBuySure","readyBuySureNode");
    }
}
