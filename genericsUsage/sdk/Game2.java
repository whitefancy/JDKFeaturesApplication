package JDKFeaturesApplication.genericsUsage.sdk;

public class Game2 implements SDKProxy<LocalHelper, UnityCallback> {
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
}
