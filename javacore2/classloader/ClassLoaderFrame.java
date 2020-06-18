package javacore2.classloader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderFrame extends JFrame {
    private static final long serialVersionUID = -786655895239662291L;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JTextField keyField = new JTextField("4", 4);
    private JTextField nameField = new JTextField("javacore2.classloader.Test1", 30);

    public ClassLoaderFrame() {
        setSize(ClassLoaderFrame.DEFAULT_WIDTH, ClassLoaderFrame.DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());
        add(new JLabel("Class"));
        add(nameField);
        JButton loadButton = new JButton("load");
        add(loadButton);
        loadButton.addActionListener(event -> runClass(nameField.getText(), keyField.getText()));
        pack();
    }

    private void runClass(String name, String key) {
        ClassLoader loader = new CyptoClassLoader(Integer.parseInt(key));
        try {
            Class<?> c = loader.loadClass(name);
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[]{});
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

}

class CyptoClassLoader extends ClassLoader {
    private int key;

    public CyptoClassLoader(int k) {
        key = k;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> cl = null;
        try {
            byte[] classBytes = null;
            classBytes = loadClassBytes(name);
            cl = defineClass(name, classBytes, 0, classBytes.length);
            if (cl == null) {
                throw new ClassNotFoundException(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cl;
    }

    private byte[] loadClassBytes(String name) throws IOException {
        String cname = name.replace('.', '/') + ".caesar";
        byte[] bytes = Files.readAllBytes(Paths.get(cname));
        //解密算法
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }
        return bytes;
    }
}