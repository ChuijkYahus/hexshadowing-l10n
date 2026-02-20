package pipythonmc.hexshadowing.mixin;

import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HopperBlockEntity.class)
public class HopperBlockEntityMixin {
    @Redirect(method = "extract(Lnet/minecraft/inventory/Inventory;Lnet/minecraft/entity/ItemEntity;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;copy()Lnet/minecraft/item/ItemStack;"))
    private static ItemStack extract_copyItemstack(ItemStack stack) {
        // skip the .copy() step so that hoppers can pick up shadowed items without breaking the link
        // technically a deviation from normal shadowing behavior, but normal shadowing operates within the inventory and never becomes an item entity
        // this change should be safe because by the end of the method, the item entity will be despawned (if the entire stack was transferred into an empty hopper slot), or the stack decremented and saved back into the item entity (which is really a nop here)
        return stack;
    }
}
