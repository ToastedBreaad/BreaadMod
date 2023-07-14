package net.toastedbreaad.breaadmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.toastedbreaad.breaadmod.BreaadModMain;
import net.toastedbreaad.breaadmod.ModCreativeModeTab;
import net.toastedbreaad.breaadmod.block.ModBlocks;
import net.toastedbreaad.breaadmod.item.custom.EightBallItem;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, BreaadModMain.MOD_ID);
	
	//basic amongus item
	public static final RegistryObject<Item> AMONGUS = ITEMS.register("amongus",
			() -> new Item(new Item.Properties()
					.tab(ModCreativeModeTab.BREAAD_TAB)
					));
	
	//eight ball item
	public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
			() -> new EightBallItem(new Item.Properties()
					.stacksTo(1)
					.tab(ModCreativeModeTab.BREAAD_TAB)
					));
	
	//amongus SEED
	public static final RegistryObject<Item> SUS_SEEDS = ITEMS.register("sus_seeds",
			() -> new ItemNameBlockItem(ModBlocks.AMONGUS_CROP_BLOCK.get(),
					new Item.Properties()
					.tab(ModCreativeModeTab.BREAAD_TAB)
					));
	
	//suspicious food item
	public static final RegistryObject<Item> SUS_FOOD = ITEMS.register("sus_food",
			() -> new Item(new Item.Properties()
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(0).build())
					.tab(ModCreativeModeTab.BREAAD_TAB)
					));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
