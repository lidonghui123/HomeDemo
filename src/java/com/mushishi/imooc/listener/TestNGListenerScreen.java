package com.mushishi.imooc.listener;

import com.mushishi.imooc.runcase.LoginCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGListenerScreen extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
//System.err.println("第一case失败");
        //实例化testng
        LoginCase s = (LoginCase)tr.getInstance();
        //转换成webdriver
        WebDriver driver= s.driver;
        //调用截图方法
        this.TakeSecreenShot(driver);
        //调用父类方法
        super.onTestFailure(tr);
    }

    public void TakeSecreenShot(WebDriver driver) {

        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String curTime = sdf.format(new Date());
        // 获取当前类名
        String curClassName = getClass().getName();
        String pngPath = curClassName + "_" + curTime + ".png";

        // 获取当前路径
        String curPath = System.getProperty("user.dir");
        // 截屏、图片存储
        File scrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        // 图片存放的位置
        try {
            com.google.common.io.Files.copy(scrFile, new File(curPath + "\\" + pngPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
