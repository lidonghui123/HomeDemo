package com.test;

import com.mushishi.imooc.runcase.BaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历课程
 */
public class TestCourseList extends BaseCase {
    public WebDriver driver1;

    // 调用driver,构造方法调用
    public TestCourseList() {
        this.driver1 = GetDriver("chrome");
    }

    //遍历课程
    public void CourseList1() {
        driver1.get("https://coding.imooc.com/class/");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver1.findElement(By.className("redrain-closeBtn")).click();
        //循环遍历
        List<WebElement> courseList = driver1.findElements(By.className("shizan-name"));
        for (int i = 0; i < courseList.size(); i++) {
            courseList.get(i).click();
            driver1.navigate().back();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 重新进行列表赋值，如果是循环element就循环不了，拿不到元素。因为页面进行了刷新。
            //courseList = driver1.findElements(By.className("shizan-name"));
        }
    }
    @Test
    public void CourseList() {
        driver1.get("https://coding.imooc.com/class/");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver1.findElement(By.className("redrain-closeBtn")).click();
        //导入课程名称的list
        List<String> listString = this.ListElement();
        //进行for循环，用xpath进行定位
        for (int i=0;i<listString.size();i++){
            driver1.findElement(By.xpath("//p[@title='"+listString.get(i)+"']")).click();            driver1.navigate().back();
        }
    }
        //获取所有课程的list
        public List<String> ListElement() {

            List<String> listString = new ArrayList<String>();
            //影响
            WebElement element = driver1.findElement(By.className("shizhan-course-list"));
            //
            List<WebElement> listElement = driver1.findElements(By.className("shizhan-course-box"));
            //循环遍历
            for (WebElement el : listElement) {
                listString.add(el.findElement(By.className("shizan-name")).getText());
            }
            System.out.println(listString);
            return listString;
        }

}
