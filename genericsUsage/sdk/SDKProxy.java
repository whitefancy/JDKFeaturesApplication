package JDKFeaturesApplication.genericsUsage.sdk;

public interface SDKProxy<T,Q> {
    void init();
    T getInstance();
    void login();
    Q getCallback();
}
