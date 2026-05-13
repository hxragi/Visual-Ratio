package dev.hxragi.config;

import dev.hxragi.VisualRatio;
import me.fzzyhmstrs.fzzy_config.annotations.NonSync;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedFloat;
import net.minecraft.resources.Identifier;

public class VisualRatioConfig extends Config {

  public VisualRatioConfig() {
    super(Identifier.fromNamespaceAndPath(VisualRatio.MOD_ID, "config"));
  }

  @NonSync
  public ValidatedBoolean enable = new ValidatedBoolean(false);

  @NonSync
  public ValidatedFloat aspectRatio = new ValidatedFloat(1.5f, 10.0f, 0.3f);

  @NonSync
  public ValidatedFloat ratioStep = new ValidatedFloat(0.5f, 2.0f, 0.01f);
}
