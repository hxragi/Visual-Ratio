package dev.hxragi.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public final class NotifyUtils {
  private NotifyUtils() {
    new RuntimeException("Util class");
  }

  public static void showActionBarMessage(String message) {
    Minecraft client = Minecraft.getInstance();
    if (client.player != null) {
      client.player.displayClientMessage(Component.literal(message), true);
    }
  }
}
