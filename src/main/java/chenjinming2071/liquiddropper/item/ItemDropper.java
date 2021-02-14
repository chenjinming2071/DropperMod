package chenjinming2071.liquiddropper.item;
import chenjinming2071.liquiddropper.liquiddropper.EventBusSubscriber;
import chenjinming2071.liquiddropper.liquiddropper.LiquidDropper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;
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

    public EnumActionResult onItemUse(EntityPlayer player, World worldin, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldin.isRemote) {
            //TODO:修正储罐中液体显示错误
            NBTTagCompound nbt1 = new NBTTagCompound();
            TileEntity a = worldin.getTileEntity(pos);
            a.writeToNBT(nbt1);
            nbt1.setTag("Amount" , new NBTTagInt(0));
            nbt1.setTag("FluidName" , new NBTTagString(""));
            nbt1.getCompoundTag("CoolantTank").setTag("FluidName" , new NBTTagString(""));
            nbt1.getCompoundTag("CoolantTank").setTag("Amount", new NBTTagInt(0));
            a.readFromNBT(nbt1);
            System.out.println(nbt1.toString());
            if (worldin.isRemote) {
                worldin.playSound(player, player.posX, player.posY, player.posZ, EventBusSubscriber.DROPPER_SOUND, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            }
        }
        return EnumActionResult.SUCCESS;
    }
}
