package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:resources/${host}.properties"})
public interface RealDeviceConfig extends Config {

    String url();

    String platformName();

    String deviceName();

    String version();

    String locale();

    String language();

    String appPackage();

    String appActivity();



}
