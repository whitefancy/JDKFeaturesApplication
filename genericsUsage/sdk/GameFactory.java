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
                    Field field = newQ.getClass().getField("instance");
                    //设置对象的访问权限，保证对private的属性的访问

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
                     account= (String) getName.invoke(newT);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                Method call= null;
                try {
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

    }
}
