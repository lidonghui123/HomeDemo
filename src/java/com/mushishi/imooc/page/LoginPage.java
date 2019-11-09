package com.mushishi.imooc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //用户名
    public WebElement GetEmaileElement(){
        return GetElement("email");
    }
    //密码
    public WebElement GetPasswordElement(){
        return GetElement("password");
    }
    //用户7天登陆element
    public WebElement GetSenvenElement(){
        return GetElement("senven");
    }
    //登陆按钮
    public WebElement GetLoginButtonElement(){
        return GetElement("loginbutton");
    }
    //获取png元素方法
    public WebElement GetUsePngElement(){
        return GetElement("headpng");
    }
    //获取登录后元素的方法
    public WebElement GetUseInfoElement(){
        return GetElement("userinfo");
    }
    //获取登录按钮
    public WebElement GetSiginButtonElement(){
        return GetElement("signin_button");
    }
}
