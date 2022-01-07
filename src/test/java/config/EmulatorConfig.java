package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:resources/${host}.properties"})
public interface EmulatorConfig extends Config {
    @Key("url")
    String url();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("osVersion")
    String version();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();


}
