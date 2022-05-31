package com.rettichlp.UnicacityAddon;

import net.labymod.addon.AddonTransformer;
import net.labymod.api.TransformerType;

public class UnicacityAddonTransformer extends AddonTransformer {

    @Override public void registerTransformers() {
        this.registerTransformer(TransformerType.VANILLA, "unicacityAddon.mixin.json");
    }
}
