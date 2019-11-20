package com.mushishi.imooc.business;
import com.mushishi.imooc.handle.CoursePageHandle;
import org.openqa.selenium.WebDriver;

/**
 * 业务逻辑类
 */
public class CoursePagePro {
    public WebDriver driver;
    //初始化coursePageHandle对象
    public CoursePageHandle coursePageHandle;
    //构造方法
    public CoursePagePro(WebDriver driver){
        this.driver = driver;
        coursePageHandle = new CoursePageHandle(driver);
    }
    /**
     * 添加购物车
     */
    public void addCart() throws InterruptedException {
        //定义一个整型存放首次获取的int值
        int beforNum = 0;
        int afterNum = 0;
        //定义一个String，存放第二次的string值
        String afterCourseNum=null;
        String courseNum=coursePageHandle.getshopcartNum();
        System.out.println("courseNum:"+courseNum);
        //try-cath一下
        try{
            //强转成int类型
            beforNum = Integer.valueOf(courseNum);
        }catch(Exception e){
            beforNum = 0;
        }
        //如果brforNum为0时，添加购物车
        coursePageHandle.clickaddCart();
        Thread.sleep(1000);
        try {
            //窗口切换
            switchToMode();
            coursePageHandle.clickReadBuy();
        }catch (Exception e){
            e.printStackTrace();
        }

        //
        Thread.sleep(2000);
        //再次获取存入变量
        afterCourseNum = coursePageHandle.getshopcartNum();
        System.out.println("afterCourseNum:"+afterCourseNum);
        try{
            afterNum = Integer.valueOf(coursePageHandle.getshopcartNum());
        }catch(Exception e){
            System.out.println("转换int类型报错！");
            e.printStackTrace();
        }
        //做判断,如果afternum=befornum+1就证明添加购物车成功
        if(afterNum == beforNum+1){
            System.out.println("添加购物车成功！");
           // coursePageHandle.clickshopcart();
        }else if(afterNum > 0){
            coursePageHandle.clickaddCart();
        }
    }

    /**
     * 应该在driver里面添加，alert，暂且放在这里吧
     */
    public void switchAlert(){
        driver.switchTo().alert();
    }
    /**
     * 模态框切换
     */
    public void switchToMode(){
        driver.switchTo().activeElement();
    }

}
