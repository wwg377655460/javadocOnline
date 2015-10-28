package com.save.util.UrlUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 该方法用于读取文件，保存文件，
 *
 * @author everxs
 */
public class FileUtils {

    public static String charset = "utf-8";


    /**
     * 返回路径下的所有file，并加入list
     *
     * @return
     */
    public static List<String> listFileAbsolutePath(String filePath, List<String> list) {

        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
          /*
           * 递归调用
	       */
                listFileAbsolutePath(file.getAbsolutePath(), list);
            } else {
                list.add(file.getAbsolutePath());

            }
        }
        return list;
    }

    /**
     * 返回路径下的所有file，并加入list
     *
     * @return
     */
    public static List<String> listClassFileAbsolutePath(String filePath) {
        List<String> list = new ArrayList<String>();
        List<String> classList = new ArrayList<String>();
        listFileAbsolutePath(filePath, list);
        for (String s : list) {
            if (s.endsWith(".class")) {
                //s = s.substring(filePath.length());
                String ss = s.substring(s.indexOf("com")).replace("/", ".");
                ss = ss.substring(0, ss.lastIndexOf("."));
                classList.add(ss);
            }
        }
        return classList;
    }


}
