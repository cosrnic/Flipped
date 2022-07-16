package uk.cosrnic.flipped.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import uk.cosrnic.flipped.config.FlippedConfig;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
	@Inject(method = "setupTransforms", at = @At(value = "TAIL"))
	private void flipPlayer(LivingEntity entity, MatrixStack matrices, float _animationProgress, float _bodyYaw, float _tickDelta, CallbackInfo _info) {
		if (!(entity instanceof PlayerEntity)) return;
		if (MinecraftClient.getInstance().player != null) {
			if (entity.getUuidAsString().equals(MinecraftClient.getInstance().player.getUuidAsString()) && FlippedConfig.get().flippedToggle) {
				matrices.translate(0.0D, entity.getHeight() + 0.1F, 0.0D);
				matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180.0F));
			}
			else if (FlippedConfig.get().allFlippedToggle) {
				if (entity.getUuidAsString().equals(MinecraftClient.getInstance().player.getUuidAsString()) && !FlippedConfig.get().flippedToggle) {
					matrices.translate(0.0D, entity.getHeight() + 0.1F, 0.0D);
					matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180.0F));
				}
				matrices.translate(0.0D, entity.getHeight() + 0.1F, 0.0D);
				matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180.0F));
			}
		}
	}

}
