package pipythonmc.hexshadowing.mishaps;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.mishaps.Mishap;
import at.petrak.hexcasting.api.pigment.FrozenPigment;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pipythonmc.hexshadowing.HexShadowing;

import java.util.List;

public class ShadowingFailMishap extends Mishap {
    @Override
    public @NotNull FrozenPigment accentColor(@NotNull CastingEnvironment castingEnvironment, @NotNull Mishap.Context context) {
        return dyeColor(DyeColor.RED);
    }

    @Override
    public void execute(@NotNull CastingEnvironment castingEnvironment, @NotNull Mishap.Context context, @NotNull List<Iota> list) {
    }

    @Override
    protected @Nullable Text errorMessage(@NotNull CastingEnvironment castingEnvironment, @NotNull Mishap.Context context) {
        return error(HexShadowing.MOD_ID + ":shadowing_fail");
    }
}
