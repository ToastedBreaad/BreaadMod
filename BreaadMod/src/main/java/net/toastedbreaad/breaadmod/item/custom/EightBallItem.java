package net.toastedbreaad.breaadmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EightBallItem extends Item {
	public EightBallItem(Properties p_41383_) {
		super(p_41383_);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41382_, Player p_41383_, InteractionHand p_41384_) {
		if(!p_41382_.isClientSide() && p_41384_ == InteractionHand.MAIN_HAND) {
			outputRandomNumber(p_41383_);
			p_41383_.getCooldowns().addCooldown(this, 20);
		}
		
		
		return super.use(p_41382_, p_41383_, p_41384_);
	}
	
	private void outputRandomNumber(Player player) {
		player.sendSystemMessage(Component.literal("Your number is " + getRandomNumber()));
	}
	
	private int getRandomNumber() {
		return RandomSource.createNewThreadLocalInstance().nextInt(10);
	}
}
