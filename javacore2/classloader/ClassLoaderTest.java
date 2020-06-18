package javacore2.classloader;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 实现一个类加载器，用于加载 加密过的 类文件
 * 本程序要求用户输入一个包含main函数的要加载的类名，和秘钥
 * 然后根据秘钥对解密，并加载其他非加密的类
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ClassLoaderFrame();
            frame.setTitle("ClassLoaderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    void test() throws MalformedURLException, ClassNotFoundException {

        //自定义插件类加载器
        URL url = new URL("file:///path/to/plugin.jar");
        URLClassLoader pulginLoader = new URLClassLoader(new URL[]{url});
        Class<?> cl = pulginLoader.loadClass("mypackage.MyClass");
    }
}
