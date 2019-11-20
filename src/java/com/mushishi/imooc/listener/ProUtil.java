package com.mushishi.imooc.listener;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
    // 全局变量
    public Properties Pro;

    // 构造方法
    public ProUtil(String FilePath) {
        Pro = RedProperties(FilePath);
    }

    // 读取配置文件方法
    private Properties RedProperties(String FilePath) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(FilePath);
            BufferedInputStream In = new BufferedInputStream(fileInputStream);
            properties.load(In);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    // get方法,进行key的判断
    public String GetPro(String key) {
        String value;
        if (Pro.containsKey(key)) {
            // 返回成功
            value = Pro.getProperty(key);
            return value;
        } else {
            // 返回失败为空
            return "";
        }
    }

    public int GetLines() {
        return Pro.size();
    }
}
