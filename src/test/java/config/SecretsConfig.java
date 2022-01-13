package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:selenoidSecrets.properties",
                "classpath:browserstackSecrets.properties"})

public interface SecretsConfig extends Config {

    @Key("selenoid_user")
    String selenoid_user();

    @Key ("selenoid_password")
    String selenoid_password();

    @Key("browserstack_user")
    String browserstack_user();

    @Key("browserstack_key")
    String browserstack_key();

    @Key("browserstack_app")
    String browserstack_app();

}
