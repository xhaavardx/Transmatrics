package at.korti.transmatrics.event;

import at.korti.transmatrics.block.ActiveMachineBlock;
import at.korti.transmatrics.tileentity.crafting.TileEntityCircuitStamper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Korti on 20.04.2016.
 */
public final class EventHandler {

    @SubscribeEvent
    public void handleCircuitStamperActive(MachineCraftingEvent.Pre<ItemStack, ItemStack> event) {
        if (event.inventory instanceof TileEntityCircuitStamper) {
            TileEntityCircuitStamper tileEntity = (TileEntityCircuitStamper) event.inventory;
            tileEntity.shouldActive = true;
            ActiveMachineBlock.setState(true, tileEntity.getWorld(), tileEntity.getPos());
        }
    }

}
