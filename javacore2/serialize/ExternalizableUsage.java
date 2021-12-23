package JDKFeaturesApplication.javacore2.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExternalizableUsage implements Externalizable {
    private static final long serialVersionUID = 1L;
    String userName;
    String password;
    String age;
//对于实现Java的序列化接口需要注意一下几点:
//
//           1.java中的序列化时transient变量(这个关键字的作用就是告知JAVA我不可以被序列化)
//           和静态变量不会被序列化(下面是一个测试的例子)
    private transient String password1;
    private static int count = 0;
    //2. 也是最应该注意的，如果你先序列化对象A后序列化B，那么在反序列化的时候一定记着JAVA规定先读到的对象
    //
    //                   是先被序列化的对象，不要先接收对象B，那样会报错.尤其在使用上面的Externalizable的时候一定要注意读取
    //
    //                   的先后顺序。
    //
    //                3.实现序列化接口的对象并不强制声明唯一的serialVersionUID，是否声明serialVersionUID对于对象序列化的向
    //
    //                  上向下的兼容性有很大的影响。
    //如果没有明确指定serialVersionUID，序列化的时候会根据字段和特定的算法生成一个serialVersionUID，当属性有变化时这个id发生了变化，所以反序列化的时候
    //
    //就会失败。抛出“本地classd的唯一id和流中class的唯一id不匹配”
    //如果可序列化类未显式声明 serialVersionUID，则序列化运行时将基于该类的各个方面计算该类的默认 serialVersionUID 值，
    // 如“Java(TM) 对象序列化规范”中所述。
    // 不过，强烈建议 所有可序列化类都显式声明 serialVersionUID 值，
    // 原因是计算默认的 serialVersionUID 对类的详细信息具有较高的敏感性，
    // 根据编译器实现的不同可能千差万别，这样在反序列化过程中可能会导致意外的 InvalidClassException。
    // 因此，为保证 serialVersionUID 值跨不同 java 编译器实现的一致性，
    // 序列化类必须声明一个明确的 serialVersionUID 值。
    // 还强烈建议使用 private 修饰符显示声明 serialVersionUID（如果可能），
    // 原因是这种声明仅应用于直接声明类 -- serialVersionUID 字段作为继承成员没有用处。
    // 数组类不能声明一个明确的 serialVersionUID，因此它们总是具有默认的计算值，
    // 但是数组类没有匹配 serialVersionUID 值的要求。
    //Object Serializalbe 优点：java原生支持，不需要提供第三方的类库，使用比较简单。
    //
    //缺点：无法跨语言，字节数占用比较大，某些情况下对于对象属性的变化比较敏感。
    //
    //对象在进行序列化和反序列化的时候，必须实现Serializable接口，但并不强制声明唯一的serialVersionUID
    //
    //是否声明serialVersionUID对于对象序列化的向上向下的兼容性有很大的影响。
    //实现序列化的其它方式  (这是一个扩展内容，感兴趣的可以扩展一下)
    //
    //       1)是把对象包装成JSON字符串传输。
    //
    //         这里采用JSON格式同时使用采用Google的gson-2.2.2.jar 进行转义
    //Json的优点：明文结构一目了然，可以跨语言，属性的增加减少对解析端影响较小。缺点：字节数过多，依赖于不同的第三方类库。
    //      2)采用谷歌的ProtoBuf
    //google protobuf 优点：字节数很小，适合网络传输节省io，跨语言 。
    //
    //缺点：需要依赖于工具生成代码。
    //         随着Google工具protoBuf的开源，protobuf也是个不错的选择。对JSON,Object Serialize(Java的序列化和反序列化),

    public ExternalizableUsage(String userName, String password, String age) {
        super();
        this.userName = userName;
        this.password = password;
        this.age = age;
    }


    public ExternalizableUsage() {
        super();
    }


    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 序列化操作的扩展类
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //增加一个新的对象
        Date date=new Date();
        out.writeObject(userName);
        out.writeObject(password);
        out.writeObject(date);
    }

    /**
     * 反序列化的扩展类
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        //注意这里的接受顺序是有限制的哦，否则的话会出错的
        // 例如上面先write的是A对象的话，那么下面先接受的也一定是A对象...
        userName=(String) in.readObject();
        password=(String) in.readObject();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=(Date)in.readObject();
        System.out.println("反序列化后的日期为:"+sdf.format(date));

    }
    @Override
    public String toString() {
        //注意这里的年龄是不会被序列化的，所以在反序列化的时候是读取不到数据的
        return "用户名:"+userName+"密 码:"+password+"年龄:"+age;
    }
}
