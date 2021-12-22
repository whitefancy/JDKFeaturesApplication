package JDKFeaturesApplication.genericsUsage.sdk;

public class LocalHelper {
    public static LocalHelper instance;

    public static void init() {
        instance=new LocalHelper();
        System.out.println("local channel inited");
    }
    public String login(){
        System.out.println("登陆成功");
        return "test1";
    }
}
