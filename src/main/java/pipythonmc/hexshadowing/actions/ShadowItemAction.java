package pipythonmc.hexshadowing.actions;

import at.petrak.hexcasting.api.casting.OperatorUtils;
import at.petrak.hexcasting.api.casting.ParticleSpray;
import at.petrak.hexcasting.api.casting.RenderedSpell;
import at.petrak.hexcasting.api.casting.castables.SpellAction;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.OperationResult;
import at.petrak.hexcasting.api.casting.eval.vm.CastingImage;
import at.petrak.hexcasting.api.casting.eval.vm.SpellContinuation;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.mishaps.Mishap;
import at.petrak.hexcasting.api.misc.MediaConstants;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pipythonmc.hexshadowing.mishaps.ShadowingFailMishap;

import java.util.List;
import java.util.Objects;

public class ShadowItemAction implements SpellAction {
    public static final ShadowItemAction INSTANCE = new ShadowItemAction();

    @Override
    public int getArgc() {
        return 2;
    }

    @Override
    public SpellAction.@NotNull Result execute(@NotNull List<? extends Iota> args, @NotNull CastingEnvironment ctx) {
        ItemEntity item1 = OperatorUtils.getItemEntity(args, 0, getArgc());
        ctx.assertEntityInRange(item1);

        ItemEntity item2 = OperatorUtils.getItemEntity(args, 1, getArgc());
        ctx.assertEntityInRange(item2);

        ItemStack stack1 = item1.getStack();
        if (stack1.getCount() < stack1.getMaxCount()) throw new ShadowingFailMishap();

        ItemStack stack2 = item2.getStack();
        if (stack2.getCount() < stack2.getMaxCount()) throw new ShadowingFailMishap();

        if (!stack1.isOf(stack2.getItem())) throw new ShadowingFailMishap();
        if (!Objects.equals(stack1.getNbt(), stack2.getNbt())) throw new ShadowingFailMishap();

        return new SpellAction.Result(
                new Spell(item1, item2),
                MediaConstants.DUST_UNIT * 50,
                List.of(ParticleSpray.burst(item1.getPos(), 1, 20), ParticleSpray.burst(item2.getPos(), 1, 20)),
                1
        );
    }

    public record Spell(ItemEntity item1, ItemEntity item2) implements RenderedSpell {
        @Override
        public void cast(@NotNull CastingEnvironment env) {
            item2.setStack(item1.getStack());
        }

        @Override
        public @Nullable CastingImage cast(@NotNull CastingEnvironment env, @NotNull CastingImage image) {
            return DefaultImpls.cast(this, env, image);
        }
    }

    @Override
    public @NotNull Result executeWithUserdata(@NotNull List<? extends Iota> args, @NotNull CastingEnvironment env, @NotNull NbtCompound data) throws Mishap {
        return SpellAction.DefaultImpls.executeWithUserdata(this, args, env, data);
    }

    @Override
    public boolean hasCastingSound(@NotNull CastingEnvironment env) {
        return SpellAction.DefaultImpls.hasCastingSound(this, env);
    }

    @Override
    public boolean awardsCastingStat(@NotNull CastingEnvironment env) {
        return SpellAction.DefaultImpls.awardsCastingStat(this, env);
    }

    @Override
    public @NotNull OperationResult operate(@NotNull CastingEnvironment env, @NotNull CastingImage image, @NotNull SpellContinuation continuation) {
        return SpellAction.DefaultImpls.operate(this, env, image, continuation);
    }
}
