package uk.cosrnic.flipped;

import net.fabricmc.api.ModInitializer;
import uk.cosrnic.flipped.config.FlippedConfig;

public class Main implements ModInitializer {

	@Override
	public void onInitialize() {
		FlippedConfig.register();
	}
}
