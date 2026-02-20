package pipythonmc.hexshadowing;

import at.petrak.hexcasting.api.casting.ActionRegistryEntry;
import at.petrak.hexcasting.api.casting.castables.Action;
import at.petrak.hexcasting.api.casting.math.HexDir;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import at.petrak.hexcasting.common.lib.hex.HexActions;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pipythonmc.hexshadowing.actions.ShadowItemAction;

public class Patterns {
    public static void init() {
        register("shadow_item", "wewewdeqqqqqawwqqwewqwwqwqwqwqwqwaqeeeeedwwqqwewqaweaedeaew", HexDir.NORTH_EAST, ShadowItemAction.INSTANCE);
    }

    private static void register(String name, String signature, HexDir startDir, Action action) {
        Registry.register(HexActions.REGISTRY, new Identifier(HexShadowing.MOD_ID, name), new ActionRegistryEntry(HexPattern.fromAngles(signature, startDir), action));
    }
}
