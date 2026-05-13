package dev.hxragi.mixin;

import dev.hxragi.VisualRatio;
import net.minecraft.client.renderer.Projection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Projection.class)
public abstract class ProjectionMixin {
  @Shadow
  private float width;
  @Shadow
  private float height;
  @Shadow
  private boolean isMatrixDirty;

  @Inject(method = "setupPerspective", at = @At("TAIL"))
  private void visualratio$modifyAspectRatio(
      float fov, float width, float height, float zNear, float zFar,
      CallbackInfo ci) {
    if (!VisualRatio.getConfig().enable.get())
      return;

    float targetAspect = VisualRatio.getConfig().aspectRatio.get();

    this.width = this.height * targetAspect;
    this.isMatrixDirty = true;
  }
}
