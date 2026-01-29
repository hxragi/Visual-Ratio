package dev.hxragi;

import dev.hxragi.config.VisualRatioConfig;
import dev.hxragi.keybind.KeyBinding;
import kotlin.jvm.functions.Function0;
import me.fzzyhmstrs.fzzy_config.api.ConfigApi;
import net.fabricmc.api.ClientModInitializer;

public class VisualRatio implements ClientModInitializer {
  public static final String MOD_ID = "visual-ratio";
  public static VisualRatioConfig config;

  public static VisualRatioConfig getConfig() {
    return config;
  }

  @Override
  public void onInitializeClient() {
    config = ConfigApi.registerAndLoadConfig(VisualRatioConfig::new);
    KeyBinding.register();
  }
}
