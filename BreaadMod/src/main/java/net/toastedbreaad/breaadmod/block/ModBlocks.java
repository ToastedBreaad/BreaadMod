package net.toastedbreaad.breaadmod.block;

import java.util.function.Supplier;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.toastedbreaad.breaadmod.BreaadModMain;
import net.toastedbreaad.breaadmod.ModCreativeModeTab;
import net.toastedbreaad.breaadmod.block.custom.AmongusLamp;
import net.toastedbreaad.breaadmod.block.custom.JumpyBlock;
import net.toastedbreaad.breaadmod.item.ModItems;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = 
			DeferredRegister.create(ForgeRegistries.BLOCKS, BreaadModMain.MOD_ID);
	
	//amongus block (stone texture lmao)
	public static final RegistryObject<Block> AMONGUS_BLOCK = registerBlock("amongus_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE)
					.strength(6f, 1200f)
					.requiresCorrectToolForDrops()
					.lightLevel((state) -> 15)
					),
					new Item.Properties()
					.tab(ModCreativeModeTab.BREAAD_TAB)
					.fireResistant()
					);
	//jumpy block
	public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
			() -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
					.strength(6f, 1200f)
					.requiresCorrectToolForDrops()
					),
					new Item.Properties()
					.tab(ModCreativeModeTab.BREAAD_TAB)
					);
	//working amongus lamp
	public static final RegistryObject<Block> AMONGUS_LAMP= registerBlock("amongus_lamp",
			() -> new AmongusLamp(BlockBehaviour.Properties.of(Material.STONE)
					.strength(6f, 1200f)
					.requiresCorrectToolForDrops()
					.lightLevel((state) -> state.getValue(AmongusLamp.LIT) ? 15 : 0)
					),
					new Item.Properties()
					.tab(ModCreativeModeTab.BREAAD_TAB)
					);
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier, Item.Properties properties) {
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
		return block;
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
