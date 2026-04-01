package dev.hxragi.util;

import dev.hxragi.VisualRatio;
import dev.hxragi.render.ProjectionCache;

public final class RatioManager {

  private RatioManager() {
  }

  public static void increaseRatio() {
    var config = VisualRatio.config;
    config.aspectRatio
        .setAndUpdate(config.aspectRatio.get() + config.ratioStep.get());
    ProjectionCache.invalidate();
  }

  public static void decreaseRatio() {
    var config = VisualRatio.config;
    config.aspectRatio
        .setAndUpdate(config.aspectRatio.get() - config.ratioStep.get());
    ProjectionCache.invalidate();
  }
}
