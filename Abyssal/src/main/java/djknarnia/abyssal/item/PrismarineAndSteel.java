package djknarnia.abyssal.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class PrismarineAndSteel extends FlintAndSteelItem {

	public PrismarineAndSteel(Properties builder) {
		super(builder);
	}
	
	/**
    * Called when this item is used when targetting a Block
    */
   public ActionResultType onItemUse(ItemUseContext context) {
      PlayerEntity playerentity = context.getPlayer();
      IWorld iworld = context.getWorld();
      BlockPos blockpos = context.getPos();
      BlockPos blockpos1 = blockpos.offset(context.getFace());
      if (func_219996_a(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
         iworld.playSound(playerentity, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
         BlockState blockstate1 = ((FireBlock)Blocks.FIRE).getStateForPlacement(iworld, blockpos1);
         iworld.setBlockState(blockpos1, blockstate1, 11);
         ItemStack itemstack = context.getItem();
         if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerentity, blockpos1, itemstack);
            itemstack.damageItem(1, playerentity, (p_219999_1_) -> {
               p_219999_1_.sendBreakAnimation(context.getHand());
            });
         }

         return ActionResultType.SUCCESS;
      } else {
         BlockState blockstate = iworld.getBlockState(blockpos);
         if (isUnlitCampfire(blockstate)) {
            iworld.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
            iworld.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
            if (playerentity != null) {
               context.getItem().damageItem(1, playerentity, (p_219998_1_) -> {
                  p_219998_1_.sendBreakAnimation(context.getHand());
               });
            }

            return ActionResultType.SUCCESS;
         } else {
            return ActionResultType.FAIL;
         }
      }
   }

}
