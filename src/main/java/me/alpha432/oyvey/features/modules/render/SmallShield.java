package me.alpha432.oyvey.features.modules.render;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;

public class SmallShield
        extends Module {
    public Setting<Boolean> normalOffset = this.register(new Setting<Boolean>("OffNormal", false));
    public Setting<Float> offset = this.register(new Setting<Object>("Offset", Float.valueOf(0.7f), Float.valueOf(0.0f), Float.valueOf(1.0f), v -> this.normalOffset.getValue()));
    public Setting<Float> offX = this.register(new Setting<Object>("OffX", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f), v -> this.normalOffset.getValue() == false));
    public Setting<Float> offY = this.register(new Setting<Object>("OffY", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f), v -> this.normalOffset.getValue() == false));
    public Setting<Float> mainX = this.register(new Setting<Float>("MainX", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    public Setting<Float> mainY = this.register(new Setting<Float>("MainY", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    private static SmallShield INSTANCE = new SmallShield();

    public SmallShield() {
        super("SmallShield", "Makes you offhand lower.", Module.Category.RENDER, false, false, false);
        this.setInstance();
    }

    private void setInstance() {
        INSTANCE = this;
    }

    @Override
    public void onUpdate() {
        if (this.normalOffset.getValue().booleanValue()) {
            SmallShield.mc.entityRenderer.itemRenderer.equippedProgressOffHand = this.offset.getValue().floatValue();
        }
    }

    public static SmallShield getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SmallShield();
        }
        return INSTANCE;
    }
}
