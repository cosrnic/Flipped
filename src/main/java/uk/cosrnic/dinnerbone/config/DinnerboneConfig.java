package uk.cosrnic.dinnerbone.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name="dinnerbone")
public class DinnerboneConfig implements ConfigData {
    public boolean dinnerboneToggle = true;

    public static void register() {
        AutoConfig.register(DinnerboneConfig.class, GsonConfigSerializer::new);
    }

    public static DinnerboneConfig get() {
        return AutoConfig.getConfigHolder(DinnerboneConfig.class).getConfig();
    }

    public static void save() {
        AutoConfig.getConfigHolder(DinnerboneConfig.class).save();
    }
}
