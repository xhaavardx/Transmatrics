package at.korti.transmatrics.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Korti on 24.02.2016.
 */
public final class Constants {

    public static class Mod{
        public static final String MODID = "Transmatrics";
        public static final String NAME = "Transmatrics";
        public static final String VERSION = "@VERSION@";

        public static final String COMMON_PROXY = "at.korti.transmatrics.proxy.CommonProxy";
        public static final String CLIENT_PROXY = "at.korti.transmatrics.proxy.ClientProxy";

        public static final String CREATIVE_TAB_LABEL = "transmatrics";
    }

    public static class ModIntegrationIds{
        public static final String WAILA = "Waila";
    }

    public static class NBT {
        //Inventory
        public static final String SLOT = "slot";
        public static final String INVENTORY = "inventory";

        //Energy
        public static final String ENERGY = "energy";
        public static final String CAPACITY = "capacity";
    }

    public static class Energy{
        //Solar Panel
        public static final int SOLAR_PANEL_GENERATE = 1;
        public static final int SOLAR_PANEL_CAPACITY = 1000;
        public static final int SOLAR_PANEL_EXTRACTION = 10;

        //Advanced Solar Panel
        public static final int ADVANCED_SOLAR_PANEL_GENERATE = 10;
        public static final int ADVANCED_SOLAR_PANEL_CAPACITY = 5000;
        public static final int ADVANCED_SOLAR_PANEL_EXTRACTION = 100;

        //Lava Generator
        public static final int LAVA_GENERATOR_GENERATE = 3;
        public static final int LAVA_GENERATOR_FLUID_USE = 10;
        public static final int LAVA_GENERATOR_CAPACITY = 2500;
        public static final int LAVA_GENERATOR_EXTRACTION = 25;

        //Windmill
        public static final int WINDMILL_MIN_GENERATE = 5;
        public static final int WINDMILL_MAX_GENERATE = 20;
        public static final int WINDMILL_MIN_HEIGHT = 80;
        public static final int WINDMILL_MAX_HEIGHT = 256;
        public static final int WINDMILL_CAPACITY = 2000;
        public static final int WINDMILL_EXTRACTION = 20;

        //Watermill
        public static final int WATERMILL_GENERATE = 1;
        public static final int WATERMILL_CAPACITY = 1000;
        public static final int WATERMILL_EXTRACTION = 10;

        //Thermal Generator
        public static final int THERMAL_GENERATOR_MIN_GENERATE = 10;
        public static final int THERMAL_GENERATOR_MAX_GENERATE = 100;
        public static final int THERMAL_GENERATOR_MIN_HEIGHT = 64;
        public static final int THERMAL_GENERATOR_MAX_HEIGHT = 12;
        public static final int THERMAL_GENERATOR_CAPACITY = 10000;
        public static final int THERMAL_GENERATOR_EXTRACTION = 100;

        //Hydrogen Generator
        public static final int HYDROGEN_GENERATOR_GENERATE = 75;
        public static final int HYDROGEN_GENERATOR_FLUID_USE = 100;
        public static final int HYDROGEN_GENERATOR_CAPACITY = 10000;
        public static final int HYDROGEN_GENERATOR_EXTRACTION = 75;
    }

    public static class Tanks{
        //Lava Generator
        public static final int LAVA_GENERATOR_CAPACITY = 10000;
        public static final Fluid LAVA_GENERATOR_FLUID = FluidRegistry.LAVA;

        //Hydrogen Generator
        public static final int HYDROGEN_GENERATOR_CAPACITY = 10000;
        public static final Fluid HYDROGEN_GENERATOR_FLUID = TransmatricsFluid.HYDROGEN_GAS.getFluid();
    }

    public enum TransmatricsBlock {
        SOLAR_PANEL("SolarPanel"),
        ADVANCED_SOLAR_PANEL("AdvancedSolarPanel"),
        LAVA_GENERATOR("LavaGenerator"),
        THERMAL_GENERATOR("ThermalGenerator"),
        HYDROGEN_GENERATOR("HydrogenGenerator"),
        WINDMILL("Windmill"),
        WATERMILL("Watermill");

        private final String regName;

        TransmatricsBlock(String regName) {
            this.regName = regName;
        }

        public Block getBlock() {
            return TransmatricsApi.getBlock(regName);
        }

        public String getRegName() {
            return regName;
        }
    }

    public enum TransmatricsItem {
        WRENCH("Wrench");

        private final String regName;

        TransmatricsItem(String regName) {
            this.regName = regName;
        }

        public Item getItem() {
            return TransmatricsApi.getItem(regName);
        }

        public String getRegName() {
            return regName;
        }
    }

    public enum TransmatricsTileEntity{
        SOLAR_PANEL("TileSolarPanel"),
        ADVANCED_SOLAR_PANEL("TileAdvancedSolarPanel"),
        LAVA_GENERATOR("TileLavaGenerator"),
        THERMAL_GENERATOR("TileThermalGenerator"),
        HYDROGEN_GENERATOR("TileHydrogenGenerator"),
        WINDMILL("Windmill"),
        WATERMILL("Watermill");

        private final String regName;

        TransmatricsTileEntity(String regName) {
            this.regName = regName;
        }

        public String getRegName() {
            return regName;
        }
    }

    public enum TransmatricsFluid{
        HYDROGEN_GAS("HydrogenGas");

        private final String regName;

        TransmatricsFluid(String regName) {
            this.regName = regName;
        }

        public Fluid getFluid() {
            return TransmatricsApi.getFluid(regName);
        }

        public String getRegName() {
            return regName;
        }
    }
}
