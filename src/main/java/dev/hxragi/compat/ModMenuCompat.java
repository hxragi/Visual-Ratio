package dev.hxragi.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.hxragi.VisualRatio;
import dev.hxragi.hoseki.modmenu.HosekiModMenu;

public class ModMenuCompat implements ModMenuApi {
  @Override
  public ConfigScreenFactory<?> getModConfigScreenFactory() {
    return HosekiModMenu.createFactory(VisualRatio.getConfig().getHosekiConfig());
  }
}
