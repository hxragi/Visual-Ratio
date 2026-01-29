package dev.hxragi.mixin;

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
    if (VisualRatio.getConfig().enable.get()) {
      Matrix4f original = cir.getReturnValue();
      Matrix4f modified = new Matrix4f(original);

      modified.setPerspective(
          (float) Math.toRadians(fov),
          VisualRatio.getConfig().aspectRatio.get(),
          original.m22(),
          original.m23());
      cir.setReturnValue(modified);
    }
  }
}
