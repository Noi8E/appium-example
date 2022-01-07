package config;


import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:resources/${host}.properties"})
public interface BrowserstackConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("app")
    String app();

    @Key("hostName")
    String hostName();

}
