package dev.hxragi.mixin;

import dev.hxragi.VisualRatio;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Camera.class)
public abstract class CameraMixin {

  @ModifyArg(
      method = "createProjectionMatrixForCulling",
      at = @At(
          value = "INVOKE",
          target = "Lorg/joml/Matrix4f;perspective(FFFFZ)Lorg/joml/Matrix4f;"
      ),
      index = 1
  )
  private float visualratio$modifyCullingAspectRatio(float originalAspectRatio) {
    if (VisualRatio.getConfig().enable.get()) {
      return VisualRatio.getConfig().aspectRatio.get();
    }
    return originalAspectRatio;
  }
}
