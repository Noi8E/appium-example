package config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:deviceHost.properties"})
public interface DevicesConfig extends Config {
    @Key("browserstack")
    String getBrowserstack();

    @Key("emulation")
    String getEmulation();

    @Key("real")
    String getReal();

    @Key("selenoid")
    String getSelenoid();

    /*
    browserstack=browserstack
emulation=Pixel_4_API_30
real=Xiaomi_Mi_9_Lite
selenoid=Google_Nexus_8
     */


}
