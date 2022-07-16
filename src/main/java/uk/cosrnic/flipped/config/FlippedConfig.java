package uk.cosrnic.flipped.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name="flipped")
public class FlippedConfig implements ConfigData {
    public boolean flippedToggle = true;
    public boolean allFlippedToggle = false;

    public static void register() {
        AutoConfig.register(FlippedConfig.class, GsonConfigSerializer::new);
    }

    public static FlippedConfig get() {
        return AutoConfig.getConfigHolder(FlippedConfig.class).getConfig();
    }

    public static void save() {
        AutoConfig.getConfigHolder(FlippedConfig.class).save();
    }
}
