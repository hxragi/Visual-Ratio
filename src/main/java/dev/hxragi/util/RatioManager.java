package dev.hxragi.util;

import dev.hxragi.VisualRatio;

public final class RatioManager {
  public RatioManager() {
  }

  public void increaseRatio() {
    var config = VisualRatio.config;
    config.aspectRatio
        .setAndUpdate(config.aspectRatio.get() + config.ratioStep.get());
  }

  public void decreaseRatio() {
    var config = VisualRatio.config;
    config.aspectRatio
        .setAndUpdate(config.aspectRatio.get() - config.ratioStep.get());
  }
}
