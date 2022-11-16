package github.erb3.plugin.Hugger.effects;

public interface Effect {
    /**
     * Function that executes when someone gets hugged
     */
    void runEffect();

    /**
     * String that contains the effect name. This is used in config file
     */
    String getName();
}
