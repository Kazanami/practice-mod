package kazanami.kazanami_shop.main;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemNameTag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import kazanami.kazanami_shop.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)



public class shop_kazanami {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)

    public static CommonProxy proxy;

    @Mod.Instance
    public static shop_kazanami instance;

    public static Logger logger = LogManager.getLogger("Kazanami Shop");

    //Minecraft Item
    public static Item exp_bottle;

    //Shincolle Items
    public static Item Onnen_Item;
    public static Block Onnen_Block;
    public static Block Onnen_Heavy_Block;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
/*        NBTTagCompound nbt = new NBTTagCompound();

        if (Loader.isModLoaded("shincolle")){
           try{
                this.Onnen_Item = Item.getByNameOrId("shincolle:Grudge");
                logger.info(this.getNBTShareTag(Onnen_Item));
                GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 5),
                        "GGG",
                        "   ",
                        "   ",
                        "G", this.Onnen_Item
                );
            }
            catch(Throwable t){
                logger.warn("Faild to get of Shincolle");
            }
        }*/
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 1), new ItemStack(Items.IRON_INGOT, 3));
        GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE),
                " I ",
                "I I",
                "   ",
                'I', new ItemStack(Items.IRON_INGOT)
        );
        proxy.postInit(event);
    }

}
