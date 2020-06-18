package JavaBasics;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class FileUsages {
    public void test(){
        File file = new File("data/cat4177186479533515005.html");// 这里使用在项目下的路径，而不是对应于java文件的相对路径。
        String s ;
        s =file.getName();
        s=file.getPath();//返回原始路径，定义时用的路径
        s =file.getAbsolutePath();//路径相关的判断都是靠字符串的规则来判断的，和系统无关。
        s=file.getParent();//返回上一级目录
        System.out.println(s);

        boolean valid;
        valid= file.renameTo(new File("data/abc.txt"));//这里也要使用在项目下的路径，而不是只写新名字
        // rename之后，再用原来的file，就找不到了，要用new File。
        valid = file.exists();
        valid = file.canWrite();
        valid = file.isFile();
        valid = file.isDirectory();
        valid = file.isAbsolute();//是否是绝对路径
        System.out.println(valid);
        long info;
        info= file.length();
        info = file.lastModified();
        System.out.println(info);

        // 文件操作
        File file1 = new File("data/dog.csv");
        try {
            valid =file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(valid);

        try {
            File file2 = File.createTempFile("cat",".html",new File("data"));
// 创建临时文件 cat4177186479533515005.html
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1.deleteOnExit();//删除文件
        valid = file1.exists();// 进程退出时才删，所以这里是true
        System.out.println(valid);

        File file2 = new File("data/temp");
        valid =file2.mkdir();
        System.out.println(valid);
        file2 = new File("data");
        String[] list = file2.list();// 列出子目录和文件
        System.out.println(Arrays.deepToString(list));
        File[] lists = file2.listFiles();
        lists = File.listRoots();// listRoots 这种static的方法，只能用类名调用，而不能用生成的实例调用。
        System.out.println(Arrays.deepToString(lists));//[C:\, D:\, E:\, F:\]
        // 路径符号 windows用\ 其他平台用/

        //文件过滤
        list = file2.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.indexOf(".html")!=-1)
                    return false;
                return true;
            }
        });
        System.out.println(Arrays.deepToString(list));
    }
}
