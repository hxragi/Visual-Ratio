package dev.hxragi.config;

import dev.hxragi.VisualRatio;
import me.fzzyhmstrs.fzzy_config.annotations.NonSync;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedFloat;
import net.minecraft.resources.Identifier;

public class VisualRatioConfig extends Config {
  private static final float DEFAULT_RATIO = 1.5f;
  private static final float MIN_RATIO = 0.3f;
  private static final float MAX_RATIO = 10.0f;

  private static final float DEFAULT_STEP_RATIO = 0.5f;
  private static final float MIN_STEP_RATIO = 0.1f;
  private static final float MAX_STEP_RATIO = 2.0f;

  public VisualRatioConfig() {
    super(Identifier.fromNamespaceAndPath(VisualRatio.MOD_ID, "config"));
  }

  @NonSync
  public ValidatedBoolean enable = new ValidatedBoolean(false);

  @NonSync
  public ValidatedFloat aspectRatio = new ValidatedFloat(DEFAULT_RATIO, MAX_RATIO, MIN_RATIO);

  @NonSync
  public ValidatedFloat ratioStep = new ValidatedFloat(DEFAULT_STEP_RATIO, MAX_STEP_RATIO, MIN_STEP_RATIO);
}
