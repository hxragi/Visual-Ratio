package dev.hxragi.util;

import dev.hxragi.VisualRatio;

public final class RatioManager {

  private RatioManager() {
  }

  public static void increaseRatio() {
    var config = VisualRatio.getConfig();
    float current = config.aspectRatio.get();
    float step = config.ratioStep.get();
    float next = Math.min((float) config.aspectRatio.getMax(), current + step);
    config.aspectRatio.set(next);
    config.save();
  }

  public static void decreaseRatio() {
    var config = VisualRatio.getConfig();
    float current = config.aspectRatio.get();
    float step = config.ratioStep.get();
    float next = Math.max((float) config.aspectRatio.getMin(), current - step);
    config.aspectRatio.set(next);
    config.save();
  }
}
