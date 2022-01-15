package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:selenoidSecrets.properties",
                "classpath:browserstackSecrets.properties"})

public interface SecretsConfig extends Config {

    @Key("selenoid_user")
    String selenoidUser();

    @Key ("selenoid_password")
    String selenoidPassword();

    @Key("browserstack_user")
    String browserstackUser();

    @Key("browserstack_key")
    String browserstackKey();

    @Key("browserstack_app")
    String browserstackApp();

}
