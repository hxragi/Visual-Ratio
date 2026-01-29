package dev.hxragi;

import dev.hxragi.config.VisualRatioConfig;
import dev.hxragi.keybind.KeyBindingHandler;
import dev.hxragi.keybind.ModKeyBindings;
import kotlin.jvm.functions.Function0;
import me.fzzyhmstrs.fzzy_config.api.ConfigApi;
import net.fabricmc.api.ClientModInitializer;

public class VisualRatio implements ClientModInitializer {
  public static final String MOD_ID = "visual-ratio";
  public static VisualRatioConfig CONFIG;

  @Override
  public void onInitializeClient() {
    CONFIG = ConfigApi.registerAndLoadConfig((Function0<? extends VisualRatioConfig>) () -> new VisualRatioConfig());

    ModKeyBindings.register();
    KeyBindingHandler.register();
  }
}
