package dev.hxragi.util;

import dev.hxragi.VisualRatio;
import dev.hxragi.render.ProjectionCache;

public final class RatioManager {
  public RatioManager() {
  }

  public void increaseRatio() {
    var config = VisualRatio.config;
    config.aspectRatio
        .setAndUpdate(config.aspectRatio.get() + config.ratioStep.get());
    ProjectionCache.invalidate();
  }

  public void decreaseRatio() {
    var config = VisualRatio.config;
    config.aspectRatio
        .setAndUpdate(config.aspectRatio.get() - config.ratioStep.get());
    ProjectionCache.invalidate();
  }
}
