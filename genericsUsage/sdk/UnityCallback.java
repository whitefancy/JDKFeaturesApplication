package JDKFeaturesApplication.genericsUsage.sdk;

public class UnityCallback {
    public static UnityCallback instance;
    public static void callback(String ans){
        System.out.println("回调返回unity格式给游戏 "+ans);
    }

}
