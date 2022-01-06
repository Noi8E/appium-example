package config;


import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:resources/${host}.properties"})
public interface BrowserstackConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("app")
    String getApp();

    @Key("hostName")
    String getHostName();

}
