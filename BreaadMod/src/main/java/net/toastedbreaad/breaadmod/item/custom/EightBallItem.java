package net.toastedbreaad.breaadmod.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class EightBallItem extends Item {
	public EightBallItem(Properties p_41383_) {
		super(p_41383_);
	}
	
	//right click ability
	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41382_, Player p_41383_, InteractionHand p_41384_) {
		if(!p_41382_.isClientSide() && p_41384_ == InteractionHand.MAIN_HAND) {
			outputRandomNumber(p_41383_);
			p_41383_.getCooldowns().addCooldown(this, 20);
		}
		
		
		return super.use(p_41382_, p_41383_, p_41384_);
	}
	
	//tooltip
	@Override
	public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
		if(Screen.hasShiftDown()) {
			p_41423_.add(Component.literal("RIGHT CLICK for a random number")
					.withStyle(ChatFormatting.AQUA)
					);
		} else {
			p_41423_.add(Component.literal("Press SHIFT for more info")
					.withStyle(ChatFormatting.YELLOW)
					);
		}
		
		
		
		
		
		super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);	
		
	}
	
	
	
	private void outputRandomNumber(Player player) {
		player.sendSystemMessage(Component.literal("Your number is " + getRandomNumber()));
	}
	
	private int getRandomNumber() {
		return RandomSource.createNewThreadLocalInstance().nextInt(10);
	}
}
