package net.toastedbreaad.breaadmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.toastedbreaad.breaadmod.BreaadModMain;
import net.toastedbreaad.breaadmod.ModCreativeModeTab;
import net.toastedbreaad.breaadmod.block.ModBlocks;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, BreaadModMain.MOD_ID);
	
	//basic amongus item
	public static final RegistryObject<Item> AMONGUS = ITEMS.register("amongus",
			() -> new Item(new Item.Properties()
					.tab(ModCreativeModeTab.BREAAD_TAB)
					));
	//UNFISHIED. amongus fuel
//	public static final RegistryObject<Item> SUS_FUEL = ITEMS.register("susfuel",
//			() -> new Item(new Item.Properties()
//					.tab(ModCreativeModeTab.BREAAD_TAB)
//					));
	//suspicious food item
	public static final RegistryObject<Item> SUS_FOOD = ITEMS.register("susfood",
			() -> new Item(new Item.Properties()
					.food(new FoodProperties.Builder().nutrition(2).saturationMod(0).build())
					.tab(ModCreativeModeTab.BREAAD_TAB)
					));
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
