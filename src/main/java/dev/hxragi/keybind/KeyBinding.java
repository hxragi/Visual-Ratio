package dev.hxragi.keybind;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

import dev.hxragi.VisualRatio;
import dev.hxragi.util.RatioManager;

public class KeyBinding {
  private static final RatioManager ratioManager = new RatioManager();
  private static KeyMapping.Category CATEGORY = new KeyMapping.Category(
      Identifier.fromNamespaceAndPath(VisualRatio.MOD_ID, "category.visual-ratio"));

  private static KeyMapping increaseKey;
  private static KeyMapping decreaseKey;

  public static void register() {
    increaseKey = KeyBindingHelper
        .registerKeyBinding(
            new KeyMapping("key.increaseKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, CATEGORY));

    decreaseKey = KeyBindingHelper
        .registerKeyBinding(
            new KeyMapping("key.decreaseKey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, CATEGORY));

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      while (increaseKey.consumeClick()) {
        ratioManager.increaseRatio();
      }

      while (decreaseKey.consumeClick()) {
        ratioManager.decreaseRatio();
      }
    });
  }
}
