package xyz.weikuwu.cute.mixins;

import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.util.IChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.weikuwu.cute.modules.DamageComma;


@Mixin(RendererLivingEntity.class)
public class MixinRendererLivingEntity {
    @Redirect(method = "renderName", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/entity/EntityLivingBase;getDisplayName()Lnet/minecraft/util/IChatComponent;"))
    public IChatComponent renderName_getDisplayName(EntityLivingBase entity) {
        if (entity instanceof EntityArmorStand) {
//            return entity.getDisplayName();
            return DamageComma.replaceName(entity);
        } else {
            return entity.getDisplayName();
        }
    }
}
