package chenjinming2071.liquiddropper.item;
import chenjinming2071.liquiddropper.liquiddropper.EventBusSubscriber;
import chenjinming2071.liquiddropper.liquiddropper.LiquidDropper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            System.out.println("test");
            world.playSound(player, player.posX, player.posY, player.posZ, EventBusSubscriber.DROPPER_SOUND, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        }
        return EnumActionResult.SUCCESS;
    }
}