package com.mushishi.imooc.handle;

import org.apache.log4j.Logger;
import com.mushishi.imooc.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginHandle {
    //实例化log4j
    static Logger logger=Logger.getLogger(LoginHandle.class);
    //初始化loginPage对象
    public LoginPage loginPage;
    //构造方法实例化loginpage对象
    public  LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }
    //sendemail调用方法
    public void SendEmail(String email){
        logger.debug("你输入的用户邮箱："+email);
        loginPage.GetEmaileElement().sendKeys(email);
    }
    //password调用方法
    public void SendPassword(String password){
        logger.debug("你输入的密码："+password);
        loginPage.GetPasswordElement().sendKeys(password);
    }
    //7天调用方法
    public void ClickSenvenBox(){
        loginPage.GetSenvenElement().click();
    }
    //点击登录按钮
    public void ClickLogin(){
        logger.debug("你开始点击登录按钮");
        loginPage.GetLoginButtonElement().click();
    }
    //创建一个登录后获取用户名方法
    public String  GetUserText(){
        //把获取图片元素，传入到motoElment上去。
        loginPage.MoveToElement(loginPage.GetUsePngElement());
        //获取登录后的个人信息，存储到一个String里面
        String username = loginPage.GetUseInfoElement().getText();
        //返回username名称
        return username;
    }
    //点击siginButton方法
    public void ClickSigniButton(){
        //点击登录按钮
        loginPage.GetSiginButtonElement().click();
    }
}
