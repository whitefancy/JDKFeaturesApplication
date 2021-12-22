package JDKFeaturesApplication.genericsUsage.sdk;

public class Game implements SDKProxy<LocalHelper, UnityCallback> {
    @Override
    public void init() {
        LocalHelper.init();
    }

    @Override
    public LocalHelper getInstance() {
        return LocalHelper.instance;
    }

    @Override
    public void login() {
        String account=LocalHelper.instance.login();
        UnityCallback.callback(account);
    }

    @Override
    public UnityCallback getCallback() {
        return UnityCallback.instance;
    }

    public static void main(String[] args) {
        SDKProxy game=new Game();
        game.init();
        game.login();
        SDKProxy<Channel2Helper,UnityCallback> game1=new SDKProxy<Channel2Helper, UnityCallback>() {
            @Override
            public void init() {
                Channel2Helper.init();
            }

            @Override
            public Channel2Helper getInstance() {
                return Channel2Helper.instance;
            }

            @Override
            public void login() {
                String account=Channel2Helper.instance.login();
                UnityCallback.callback(account);
            }

            @Override
            public UnityCallback getCallback() {
                return UnityCallback.instance;
            }
        };
        game1.init();
        game1.login();
    }
}
