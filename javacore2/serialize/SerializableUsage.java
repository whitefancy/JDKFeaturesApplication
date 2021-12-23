package JDKFeaturesApplication.javacore2.serialize;

import java.util.Date;

// * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
// 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//Stream类就有对应的WriteObject(Object object) 其中要求对应的object实现了java的序列化的接口。
//1)在使用tomcat开发JavaEE相关项目的时候，我们关闭tomcat后，相应的session中的对象就存储在了硬盘上，如果我们想要在tomcat重启的
//
//时候能够从tomcat上面读取对应session中的内容，那么保存在session中的内容就必须实现相关的序列化操作。
//
//  2)如果我们使用的java对象要在分布式中使用或者在rmi远程调用的网络中使用的话，那么相关的对象必须实现java序列化接口。
//Java对象的序列化有两种方式。
//
//           a.是相应的对象实现了序列化接口Serializable，这个使用的比较多，对于序列化接口Serializable接口是一个空的接口，它的主要作用就是
//
//             标识这个对象时可序列化的，jre对象在传输对象的时候会进行相关的封装。
//　b.实现序列化的第二种方式为实现接口Externalizable

public class SerializableUsage implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;  //文章标题
    private String content;  // 文章内容
    private String faceIcon;//表情图标
    private Date postTime; //文章发表的时间
    private String ipAddr;  //用户的ip
    public SerializableUsage(String userName, String password, String age) {
        super();
        this.title = userName;
        this.content = password;
        this.faceIcon = age;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getFaceIcon() {
        return faceIcon;
    }
    public void setFaceIcon(String faceIcon) {
        this.faceIcon = faceIcon;
    }
    public Date getPostTime() {
        return postTime;
    }
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
    public String getIpAddr() {
        return ipAddr;
    }
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
