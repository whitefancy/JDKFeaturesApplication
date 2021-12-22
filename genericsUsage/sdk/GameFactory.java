package JDKFeaturesApplication.genericsUsage.sdk;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameFactory {
    public  static <T> T getInstance(Class<T> cls){
        try {
            return  cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
//    知识点 抽象工厂
//    知识点，多个泛型的使用，泛型方法的使用，通过泛型的类型，来获得实例
    public  static <T,Q> SDKProxy<T,Q> getInstance(Class<T> cls1,Class<Q> cls2){
        return new SDKProxy<T, Q>() {
            T newT = null;
            Q newQ=null;
            @Override
            public void init() {
                try {
                    newT= cls1.newInstance();
                    newQ=cls2.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Method getName = null;
                try {
                    getName = newT.getClass().getMethod("init");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
//                    知识点，调用类的静态方法，obj可以传null，也可以传实例
                    getName.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public T getInstance() {

                try {
//                    知识点：通过类中变量名，来获得变量的值
                    Field field = newQ.getClass().getField("instance");
                    return  (T)field.get(newQ);
                } catch (Exception e) {

                    return null;
                }
            }

            @Override
            public void login() {
                Method getName = null;
                try {
                    getName = newT.getClass().getMethod("login");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                String account = null;
                try {
//                    知识点:带有返回值的方法调用
                     account= (String) getName.invoke(newT);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                Method call= null;
                try {
//                    知识点，需要使用反射调用的方法，必须是public公开的
//                    知识点：带有参数的方法调用
                    call = newQ.getClass().getMethod("callback",String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    call.invoke(null,account);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public Q getCallback() {
                return newQ;
            }
        };
    }
    public static void main(String[] args) {
        Game2 game2=GameFactory.getInstance(Game2.class);
        game2.init();
        game2.login();
        SDKProxy game3=GameFactory.getInstance(Channel2Helper.class,CocosCallback.class);
        game3.init();
        game3.login();
        try {
            Class<?> helperClazz = Class.forName("JDKFeaturesApplication.genericsUsage.sdk.LocalHelper");
            Class<?> callbackClazz = Class.forName("JDKFeaturesApplication.genericsUsage.sdk.UnityCallback");
            SDKProxy game4=GameFactory.getInstance(helperClazz,callbackClazz);
            game4.init();
            game4.login();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String channel="Channel2";
            String gameType="Unity";
//            知识点:通过类名获得类的类型
            Class<?> helperClazz1 = Class.forName("JDKFeaturesApplication.genericsUsage.sdk."+channel+"Helper");
            Class<?> callbackClazz1 = Class.forName("JDKFeaturesApplication.genericsUsage.sdk."+gameType+"Callback");
            SDKProxy game5=GameFactory.getInstance(helperClazz1,callbackClazz1);
            game5.init();
            game5.login();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        SDKProxy game6=GameFactory.getGame("Channel2","Unity");
        game6.init();
        game6.login();
        SDKProxy game7=GameFactory.getGame(channel.Channel2,gameType.Cocos);
        game7.init();
        game7.login();
    }

    private static SDKProxy getGame(channel achannel, gameType atype) {
        return getGame(achannel.name(),atype.name);
    }

    static SDKProxy getGame(String channel,String gameType){
        try{
            Class<?> helperClazz1 = Class.forName("JDKFeaturesApplication.genericsUsage.sdk."+channel+"Helper");
            Class<?> callbackClazz1 = Class.forName("JDKFeaturesApplication.genericsUsage.sdk."+gameType+"Callback");
            SDKProxy game=GameFactory.getInstance(helperClazz1,callbackClazz1);
            return game;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
//    知识点 Enum与String的转化
    enum gameType{
        Cocos("Cocos"),Unity("Unity");

        private final String name;

        gameType(String name) {
            this.name=name;
        }
    }
    enum channel{
        Local("Local"),Channel2("Channel2");

        channel(String channel) {
        }
    }
}
