package dev.hxragi.config;

import dev.hxragi.VisualRatio;
import dev.hxragi.hoseki.Hoseki;
import dev.hxragi.hoseki.api.HosekiConfig;
import dev.hxragi.hoseki.api.Option;

public class VisualRatioConfig {
  private final HosekiConfig hosekiConfig;
  public Option<Boolean> enable;
  public Option<Float> aspectRatio;
  public Option<Float> ratioStep;

  public VisualRatioConfig() {
    this.hosekiConfig = Hoseki.config(VisualRatio.MOD_ID)
        .title("Visual Ratio")
        .category("General", cat -> {
          this.enable = cat.addToggle("enable", false, b -> b
              .name("Enable Aspect Ratio")
              .description("Toggle custom aspect ratio modifications"));

          this.aspectRatio = cat.addFloatSlider("aspectRatio", 1.5f, 0.3f, 10.0f, b -> b
              .step(0.01f)
              .name("Aspect Ratio")
              .description("Custom viewport aspect ratio (width / height)"));

          this.ratioStep = cat.addFloatSlider("ratioStep", 0.5f, 0.01f, 2.0f, b -> b
              .step(0.01f)
              .name("Ratio Step")
              .description("Step size when adjusting ratio via hotkeys"));
        })
        .buildAndLoad();
  }

  public HosekiConfig getHosekiConfig() {
    return hosekiConfig;
  }

  public void save() {
    hosekiConfig.save();
  }
}
