package net.toastedbreaad.breaadmod.block.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class AmongusLamp extends Block{
	public static final BooleanProperty LIT = BooleanProperty.create("lit");

	public AmongusLamp(Properties p_49795_) {
		super(p_49795_);
	}
	
	//lighting the block
	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, 
			InteractionHand p_60507_, BlockHitResult p_60508_) {
		if(!p_60504_.isClientSide() && p_60507_ == InteractionHand.MAIN_HAND) {
			p_60504_.setBlock(p_60505_, p_60503_.cycle(LIT), 3);
			p_60506_.sendSystemMessage(Component.literal("Right Clicked This!"));
		}
		
		return super.use(p_60503_, p_60504_, p_60505_, p_60506_, p_60507_, p_60508_);
	}
	
	@Override
	public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> p_49818_, TooltipFlag p_49819_) {
		if(Screen.hasShiftDown()) {
		} else {
			p_49818_.add(Component.literal("RIGHT CLICK on the block to light it up")
					.withStyle(ChatFormatting.RED)
					);
			
		}
	}
	
	
	
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
		p_49915_.add(LIT);
	}
	
	
	
	
}
