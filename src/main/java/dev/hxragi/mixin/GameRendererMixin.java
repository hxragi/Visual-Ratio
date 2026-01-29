package dev.hxragi.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.hxragi.VisualRatio;
import net.minecraft.client.renderer.GameRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

	@Shadow
	private float renderDistance;

	@Inject(method = "getProjectionMatrix", at = @At("TAIL"), cancellable = true)
	private void visualratio$modifyProjectionMatrix(float fov, CallbackInfoReturnable<Matrix4f> cir) {
		if (VisualRatio.CONFIG.enable.get()) {
			PoseStack poseStack = new PoseStack();
			poseStack.last().pose().identity();
			poseStack.last().pose().mul(new Matrix4f().setPerspective(
					(float) Math.toRadians(fov),
					VisualRatio.CONFIG.aspectRatio.get(),
					0.05f,
					this.renderDistance * 4.0f
			));
			cir.setReturnValue(poseStack.last().pose());
		}
	}
}