package com.save.util.UrlUtils;

import com.alibaba.fastjson.JSON;
import com.save.entity.User;
import org.nutz.json.Json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsdevotion on 15/10/17.
 */
public class UrlUtil {


    

    public static List<Online> getUrl(List<String> list) {

        List<Online> lists = new ArrayList<Online>();
        for (String classes : list) {
            try {
                Class<?> aClass = Class.forName(classes);
                Method[] methods = aClass.getMethods();

                for (Method method : methods) {
                    OnlineMethod annotation = method.getAnnotation(OnlineMethod.class);
                    if (annotation != null) {
                        Online o = new Online();
                        o.setType(1);
                        o.setMethod(annotation.method());
                        o.setMemo(annotation.memo());
                        o.setParam(annotation.param());
                        o.setUrl(annotation.url());
                        lists.add(o);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



        return lists;
    }

    public static List<String> getClassName(String packageName) {
//        String s = ClassLoader.getSystemResource("").getPath();
        String filePath = UrlUtil.class.getClassLoader().getResource("").getPath() + packageName.replace(".", "/");
        List<String> strings = FileUtils.listClassFileAbsolutePath(filePath);
        return strings;
    }

    


}
