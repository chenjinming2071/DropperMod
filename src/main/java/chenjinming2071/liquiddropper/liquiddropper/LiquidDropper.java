package chenjinming2071.liquiddropper.liquiddropper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = LiquidDropper.MODID, name = LiquidDropper.NAME, version = LiquidDropper.VERSION)
public class LiquidDropper
{
    public static final String MODID = "dropper";
    public static final String NAME = "LiquidDropper";
    public static final String VERSION = "1.0";
    public static final CreativeTabs LIQUIDDROPPER_TAB = new CreativeTabs("LiquidDropper_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(EventBusSubscriber.ITEM_DROPPER);
        }
    };
}
