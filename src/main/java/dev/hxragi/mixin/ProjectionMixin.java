package dev.hxragi.mixin;

import dev.hxragi.VisualRatio;
import net.minecraft.client.renderer.Projection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Projection.class)
public abstract class ProjectionMixin {

  @ModifyVariable(
      method = "setupPerspective",
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 3
  )
  private float visualratio$modifyWidth(
      float width, float zNear, float zFar, float fov, float origWidth, float height) {
    if (!VisualRatio.getConfig().enable.get()) {
      return width;
    }

    return height * VisualRatio.getConfig().aspectRatio.get();
  }
}
