package JDKFeaturesApplication.genericsUsage.sdk;

public class Channel2Helper {
    public static Channel2Helper instance;

    public static void init() {
        instance=new Channel2Helper();
        System.out.println("Channel2 channel inited");
    }
    public String login(){
        System.out.println("登陆成功");
        return "Channel2test1";
    }
}
