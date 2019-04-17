package kazanami.kazanami_shop.main;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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

    //Chinjuhu-mod Items
    //public static String GET_ITEM_MOD = "chinjuhumod";
    public static Item Seed_corn;
    public static Item Seed_hakusai;
    public static Item Seed_onion;
    public static Item Seed_spinach;
    public static Item Seed_cabbage;
    public static Item Seed_rice;
    public static Item Seed_soy;
    public static Item Seed_tomato;
    /*
    アイテムID郡
    chinjufumod
	    item_seeds_corn とうもろこし
	    item_seeds_hakusai 白菜
	    item_seeds_onion 玉ねぎ
	    item_seeds_spinach ほうれん草
	    item_seeds_cabbage キャベツ
	    item_seeds_rice 種籾
	    item_seeds_soy 大豆
	    item_seeds_tomato トマト
     */


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
        if (Loader.isModLoaded("chinjufumod")){
            try{
                /*アイテム変数追加処理*/
                this.Seed_corn = GameRegistry.findItem("chinjufumod", "item_seeds_corn");
                this.Seed_cabbage = GameRegistry.findItem("chinjufumod", "item_seeds_cabage");
                this.Seed_hakusai = GameRegistry.findItem("chinjufumod", "item_seeds_hakusai");
                this.Seed_onion = GameRegistry.findItem("chinjufumod", "item_seeds_onion");
                this.Seed_rice = GameRegistry.findItem("chinjufumod", "item_seeds_rice");
                this.Seed_soy = GameRegistry.findItem("chinjufumod", "item_seeds_soy");
                this.Seed_spinach = GameRegistry.findItem("chinjufumod", "item_seeds_spinach");
                this.Seed_tomato = GameRegistry.findItem("chinjufumod", "item_seeds_tomato");

                /*カスタムレシピ追加処理*/
                GameRegistry.addRecipe(new ItemStack(this.Seed_corn, 64),
                        "SSS",
                        "   ",
                        "   ",
                        'S', new ItemStack(Items.BEETROOT_SEEDS, 1)
                        );

            }catch (Throwable t){
                logger.warn("Faild to get Item of Chinjufu-mod");
            }finally{
                logger.debug("Loaded Recipe");
            }
        }


        /*最後に読み込ませる 鉄インゴット3から経験値瓶3*/
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE,3), new ItemStack(Items.IRON_INGOT,3));
        GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 3),
                " I ",
                "I I",
                "   ",
                'I', new ItemStack(Items.IRON_INGOT)
        );
        GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 20),
                "B  ",
                "B  ",
                "   ",
                'B', new ItemStack(Blocks.IRON_BLOCK)
        );

        /*鉄防具 還元レシピ*/
        GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 3), new ItemStack(Items.BUCKET));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 5), new ItemStack(Items.IRON_HELMET));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 8), new ItemStack(Items.IRON_CHESTPLATE));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 7), new ItemStack(Items.IRON_LEGGINGS));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Items.IRON_BOOTS));


        /*鉄 錬金レシピ*/
        GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT,1),
                "FFF",
                "FFF",
                "FFF",
                'F', new ItemStack(Items.FLINT)
        );
        GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT),
                "GGG",
                "GGG",
                "GGG",
                'G', new ItemStack(Blocks.GRAVEL)
                );

        proxy.postInit(event);
    }

}
