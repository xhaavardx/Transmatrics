package at.korti.transmatrics.item.tool;

import at.korti.transmatrics.api.Constants.TransmatricsItem;
import at.korti.transmatrics.api.block.IDismantable;
import at.korti.transmatrics.api.block.IRotatable;
import at.korti.transmatrics.item.ModItem;
import at.korti.transmatrics.util.helper.TextHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Korti on 29.02.2016.
 */
public class ItemWrench extends ModItem {

    public ItemWrench() {
        super(TransmatricsItem.WRENCH.getRegName(), EnumChatFormatting.YELLOW);

        setMaxStackSize(1);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState blockState = world.getBlockState(pos);
        Block affectedBlock = blockState.getBlock();

        if (player.isSneaking()) {
            if (affectedBlock instanceof IDismantable) {
                ((IDismantable) affectedBlock).dismantleBlock(player, world, pos, blockState);
            }
        } else {
            if (affectedBlock instanceof IRotatable) {
                ((IRotatable) affectedBlock).rotate(world, player, pos, blockState);
            }
        }

        return super.onItemUseFirst(stack, player, world, pos, side, hitX, hitY, hitZ);
    }
}
