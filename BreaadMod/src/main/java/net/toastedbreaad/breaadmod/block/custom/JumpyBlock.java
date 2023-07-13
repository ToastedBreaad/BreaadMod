package net.toastedbreaad.breaadmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class JumpyBlock extends Block{

	public JumpyBlock(Properties p_49795_) {
		super(p_49795_);
	}
	
	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, 
			InteractionHand p_60507_, BlockHitResult p_60508_) {
		if(!p_60504_.isClientSide() && p_60507_ == InteractionHand.MAIN_HAND) {
			p_60506_.sendSystemMessage(Component.literal("Right Clicked This!"));
		}
		
		return super.use(p_60503_, p_60504_, p_60505_, p_60506_, p_60507_, p_60508_);
	}
	
	@Override
	public void stepOn(Level p_152431_, BlockPos p_152432_, BlockState p_152433_, Entity p_152434_) {
		if(p_152434_ instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200));
		}
		
		
		super.stepOn(p_152431_, p_152432_, p_152433_, p_152434_);
	}
	
}
