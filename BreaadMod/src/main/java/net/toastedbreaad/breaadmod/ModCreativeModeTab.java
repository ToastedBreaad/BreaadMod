package net.toastedbreaad.breaadmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.toastedbreaad.breaadmod.item.ModItems;

public class ModCreativeModeTab {
	public static final CreativeModeTab BREAAD_TAB = new CreativeModeTab("breaadmodtab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.AMONGUS.get());
		}
	};
}
