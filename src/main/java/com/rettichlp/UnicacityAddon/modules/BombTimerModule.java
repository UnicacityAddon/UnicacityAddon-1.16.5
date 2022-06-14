package com.rettichlp.UnicacityAddon.modules;

import com.rettichlp.UnicacityAddon.base.abstraction.AbstractionLayer;
import com.rettichlp.UnicacityAddon.base.event.UCEvent;
import com.rettichlp.UnicacityAddon.base.module.UCModule;
import com.rettichlp.UnicacityAddon.base.module.UCModuleHandler;
import com.rettichlp.UnicacityAddon.base.text.ColorCode;
import com.rettichlp.UnicacityAddon.base.text.PatternHandler;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.TickEvent;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.labymod.utils.ModUtils;

@UCModule
@UCEvent
public class BombTimerModule extends SimpleModule {

    private int currentCount = 0;
    private int currentTick = 0;
    private static boolean isBomb = false;
    private String timer = "";

    public BombTimerModule() {
        AbstractionLayer.getLabymod().getEventService().registerListener(this);
    }

    @Override public String getControlName() {
        return "Bomben-Timer";
    }

    @Override public String getSettingName() {
        return null;
    }

    @Override public String getDisplayName() {
        return "Bombe";
    }

    @Override public String getDisplayValue() {
        return this.timer;
    }

    @Override public String getDefaultValue() {
        return "00:00";
    }

    @Override public String getDescription() {
        return "Zeigt die Zeit an, die seit dem Legen einer Bombe vergangen ist.";
    }

    @Override public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.TNT);
    }

    @Override public ModuleCategory getCategory() {
        return UCModuleHandler.UNICACITY;
    }

    @Override public boolean isShown() {
        return !this.timer.isEmpty();
    }

    @Override public int getSortingId() {
        return 0;
    }

    @Override public void loadSettings() {
    }

    @Subscribe
    public void onTick(TickEvent event) {
        if (event.getPhase() != TickEvent.Phase.POST) return;

        if (!isBomb || ++this.currentTick != 20) return;
        this.currentTick = 0;

        if (this.currentCount++ >= 780) this.timer = ColorCode.RED.getCode() + ModUtils.parseTimer(this.currentCount);
        else this.timer = ModUtils.parseTimer(this.currentCount);
    }

    @Subscribe
    public void onMesageReceive(MessageReceiveEvent e) {
        String msg = e.getComponent().getString();

        if (PatternHandler.BOMB_PLACED_PATTERN.matcher(msg).find()) {
            isBomb = true;
            this.timer = "00:00";
            return;
        }

        if (PatternHandler.BOMB_REMOVED_PATTERN.matcher(msg).find()) {
            isBomb = false;
            this.currentCount = 0;
            this.timer = "";
        }
    }
}