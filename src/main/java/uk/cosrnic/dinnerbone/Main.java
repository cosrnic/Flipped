package uk.cosrnic.dinnerbone;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.cosrnic.dinnerbone.config.DinnerboneConfig;

public class Main implements ModInitializer {

	@Override
	public void onInitialize() {
		DinnerboneConfig.register();
	}
}
