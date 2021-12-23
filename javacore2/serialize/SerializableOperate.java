package JDKFeaturesApplication.javacore2.serialize;

import java.io.*;

public class SerializableOperate {
    /**
     * 序列化方法
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void serializable(SerializableUsage person) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("a.txt"));
        outputStream.writeObject(person);
    }

    /**
     * 反序列化的方法
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public SerializableUsage deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("a.txt"));
        return (SerializableUsage) ois.readObject();
    }
    public void serializable1(ExternalizableUsage person) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("a.txt"));
        outputStream.writeObject(person);
    }
    public ExternalizableUsage deSerializable1() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("a.txt"));
        return (ExternalizableUsage) ois.readObject();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializableOperate operate=new SerializableOperate();
        SerializableUsage person=new SerializableUsage("小浩","123456","20");
        System.out.println("为序列化之前的相关数据如下:\n"+person.toString());
        operate.serializable(person);
        SerializableUsage newPerson=operate.deSerializable();
        System.out.println("-------------------------------------------------------");
        System.out.println("序列化之后的相关数据如下:\n"+newPerson.toString());

        SerializableOperate operate1=new SerializableOperate();
        ExternalizableUsage person1=new ExternalizableUsage("小浩","123456","20");
        System.out.println("为序列化之前的相关数据如下:\n"+person1.toString());
        operate.serializable1(person1);
        ExternalizableUsage newPerson1=operate.deSerializable1();
        System.out.println("-------------------------------------------------------");
        System.out.println("序列化之后的相关数据如下:\n"+newPerson1.toString());
    }
}
