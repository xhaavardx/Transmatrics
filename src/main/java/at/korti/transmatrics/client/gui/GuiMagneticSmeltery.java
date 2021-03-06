package at.korti.transmatrics.client.gui;

import at.korti.transmatrics.client.util.RenderHelper;
import at.korti.transmatrics.tileentity.TileEntityFluidCraftingMachine;
import at.korti.transmatrics.tileentity.container.ContainerMagneticSmeltery;
import at.korti.transmatrics.util.helper.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidTankInfo;

import java.util.List;

/**
 * Created by Korti on 31.03.2016.
 */
public class GuiMagneticSmeltery extends GuiCrafting {

    public GuiMagneticSmeltery(InventoryPlayer inventoryPlayer, IInventory inventory) {
        super(new ContainerMagneticSmeltery(inventoryPlayer, inventory), inventory, "textures/gui/MagneticSmeltery.png");
    }

    @Override
    protected void addInformation(int mouseX, int mouseY, List<String> textLines) {
        super.addInformation(mouseX, mouseY, textLines);
        if (inventory instanceof TileEntityFluidCraftingMachine && isInRect(mouseX, mouseY, 107, 10, 107 + 16, 10 + 64)) {
            TileEntityFluidCraftingMachine machine = (TileEntityFluidCraftingMachine) inventory;
            FluidTankInfo tankInfo = machine.getTankInfo(EnumFacing.UP)[0];
            textLines.add(tankInfo.fluid != null ? tankInfo.fluid.getLocalizedName() : TextHelper.localize("gui.tank.empty"));
            textLines.add(String.format("%d/%d mB",
                    tankInfo.fluid != null ? tankInfo.fluid.amount : 0, tankInfo.capacity));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);

        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;

        int craftingProgress = getCraftingProgress(24);
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, craftingProgress + 1, 16);

        int energyBar = getEnergyBar(64);
        this.drawTexturedModalRect(i + 17, j + 10 + 64 - energyBar, 176, 31 + 64 - energyBar, 16, energyBar + 1);

        int efficiencyBar = getEfficiencyBar(14);
        this.drawTexturedModalRect(i + 56, j + 53 + 14 - efficiencyBar, 176, 14 - efficiencyBar, 14, efficiencyBar);

        if (inventory instanceof TileEntityFluidCraftingMachine) {
            TileEntityFluidCraftingMachine fluidCraftingMachine = (TileEntityFluidCraftingMachine) inventory;
            FluidTankInfo tankInfo = fluidCraftingMachine.getTankInfo(EnumFacing.UP)[0];
            RenderHelper.drawGuiFluid(tankInfo.fluid, i + 107, j + 10, zLevel, 16, 64, tankInfo.capacity);
        }
    }
}
