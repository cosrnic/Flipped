package uk.cosrnic.dinnerbone.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3f;
import uk.cosrnic.dinnerbone.Main;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.cosrnic.dinnerbone.config.DinnerboneConfig;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
	@Inject(method = "setupTransforms", at = @At(value = "TAIL"))
	private void dinnerboneEntities(LivingEntity entity, MatrixStack matrices, float _animationProgress, float _bodyYaw, float _tickDelta, CallbackInfo _info) {
		if (entity instanceof PlayerEntity && entity.getName().equals(MinecraftClient.getInstance().player.getName()) && DinnerboneConfig.get().dinnerboneToggle) {
			matrices.translate(0.0D, entity.getHeight() + 0.1F, 0.0D);
			matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180.0F));
		}
	}
}
