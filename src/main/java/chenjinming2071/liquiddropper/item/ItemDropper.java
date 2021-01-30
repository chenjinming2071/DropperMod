package chenjinming2071.liquiddropper.item;

import chenjinming2071.liquiddropper.liquiddropper.LiquidDropper;
import net.minecraft.item.Item;

public class ItemDropper extends Item {
    public static final String NAME = "LiquidDropper";
    public static final String REGISTRYNAME = LiquidDropper.MODID + "_" + ItemDropper.NAME;
    public static final String TRANSLATIONKEY = LiquidDropper.MODID + "." + ItemDropper.NAME;
    public ItemDropper() {
        this.setMaxStackSize(1);
        this.setCreativeTab(LiquidDropper.LIQUIDDROPPER_TAB);
        this.setRegistryName(ItemDropper.REGISTRYNAME);
        this.setTranslationKey(ItemDropper.TRANSLATIONKEY);
    }
}
