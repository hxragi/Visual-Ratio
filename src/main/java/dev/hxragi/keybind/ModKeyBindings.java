package dev.hxragi.keybind;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

public class ModKeyBindings {
  public static final String CATEGORY = "category.visualratio";

  public static KeyMapping increaseRatio;
  public static KeyMapping decreaseRatio;

  public static void register() {
    increaseRatio = KeyBindingHelper.registerKeyBinding(new KeyMapping(
        "key.visualratio.increase",
        GLFW.GLFW_KEY_UNKNOWN,
        CATEGORY));

    decreaseRatio = KeyBindingHelper.registerKeyBinding(new KeyMapping(
        "key.visualratio.decrease",
        GLFW.GLFW_KEY_UNKNOWN,
        CATEGORY));
  }
}
