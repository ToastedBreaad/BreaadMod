package net.toastedbreaad.breaadmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class JumpyBlock extends Block{

	public JumpyBlock(Properties p_49795_) {
		super(p_49795_);
	}
	
	@Override
	public void stepOn(Level p_152431_, BlockPos p_152432_, BlockState p_152433_, Entity p_152434_) {
		super.stepOn(p_152431_, p_152432_, p_152433_, p_152434_);
	}
	
}
