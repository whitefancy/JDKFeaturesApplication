package JDKFeaturesApplication.genericsUsage.sdk;

public class CocosCallback {
    public static CocosCallback instance;
    public static void callback(String ans){
        System.out.println("回调返回cocos格式给游戏 "+ans);
    }

}
