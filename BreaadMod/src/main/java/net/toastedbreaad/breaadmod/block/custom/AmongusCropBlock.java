package net.toastedbreaad.breaadmod.block.custom;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.toastedbreaad.breaadmod.item.ModItems;

public class AmongusCropBlock extends CropBlock{
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
	
	
	
	public AmongusCropBlock(Properties p_52247_) {
		super(p_52247_);
	}
	
	@Override
	protected ItemLike getBaseSeedId() {
	   return ModItems.SUS_SEEDS.get();
	}
	
	@Override
	public IntegerProperty getAgeProperty() {
	   return AGE;
	}
	
	@Override
	public int getMaxAge() {
	   return 6;
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52286_) {
	    p_52286_.add(AGE);
	}
	
	
	
}
