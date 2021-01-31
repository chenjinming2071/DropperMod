package chenjinming2071.liquiddropper.liquiddropper;

import chenjinming2071.liquiddropper.item.ItemDropper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = LiquidDropper.MODID)
public class EventBusSubscriber {
    public static final SoundEvent DROPPER_SOUND = new SoundEvent(new ResourceLocation(LiquidDropper.MODID, "dropper_sound"));
    public static final ItemDropper ITEM_DROPPER = new ItemDropper();
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(ITEM_DROPPER);
    }
    @SubscribeEvent
    public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(DROPPER_SOUND.setRegistryName(new ResourceLocation(LiquidDropper.MODID, "dropper_sound")));
    }
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ITEM_DROPPER , 0 , new ModelResourceLocation(ITEM_DROPPER.getRegistryName() , "inventory"));

    }
}
