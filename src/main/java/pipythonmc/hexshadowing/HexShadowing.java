package pipythonmc.hexshadowing;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HexShadowing implements ModInitializer {
	public static final String MOD_ID = "hexshadowing";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        Patterns.init();

		LOGGER.info("Surely nothing will break in any way...");
	}
}