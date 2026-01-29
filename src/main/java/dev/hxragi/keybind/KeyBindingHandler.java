package dev.hxragi.keybind;

import dev.hxragi.VisualRatio;
import dev.hxragi.util.NotifyUtils;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class KeyBindingHandler {
  private static final float MIN_RATIO = 0.3f;
  private static final float MAX_RATIO = 10.0f;

  public static void register() {
    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      handleIncreaseRatio();
      handleDecreaseRatio();
    });
  }

  public static void handleIncreaseRatio() {
    while (ModKeyBindings.increaseRatio.consumeClick()) {
      changeAspectRatio(VisualRatio.CONFIG.ratioStep.get());
    }
  }

  public static void handleDecreaseRatio() {
    while (ModKeyBindings.decreaseRatio.consumeClick()) {
      changeAspectRatio(-VisualRatio.CONFIG.ratioStep.get());
    }
  }

  private static void changeAspectRatio(float delta) {
    float current = VisualRatio.CONFIG.aspectRatio.get();
    float newValue = Math.max(MIN_RATIO, Math.min(MAX_RATIO, current + delta));

    VisualRatio.CONFIG.aspectRatio.accept(newValue);
    NotifyUtils.showActionBarMessage("Current Ratio is: " + String.format("%.2f", newValue));
  }
}
