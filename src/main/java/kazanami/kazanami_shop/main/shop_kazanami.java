package kazanami.kazanami_shop.main;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.Loader;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
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
    //public static Item exp_bottle;

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
    public static Item Bauxi;
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
	    item_bauxite ボーキサイト
     */

    //Shincolle Items

    public static Item shincolle_grudge;
    public static Item shincolle_eggs;
    public static Item shincolle_humer;
    public static Item heavy_block;
    public static Item tf_cokeblock;


    /*バニラ小麦のたね
    minecraft:
        wheat_seeds
     */
    /* TF
        tf
            cokeblock
     */
    public static Item test_item;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        if (Loader.isModLoaded("chinjufumod")){
            try{
                logger.info("Loading Recipe...");
                /*アイテム変数追加処理*/
                //this.Bauxi = GameRegistry.findItem("chinjufumod","item_bauxite");
                //this.Seed_corn = GameRegistry.findItem("chinjufumod","item_seeds_corn");
                //this.Seed_cabbage = GameRegistry.findItem("chinjufumod","item_seeds_cabbage");
                //this.Seed_hakusai = GameRegistry.findItem("chinjufumod", "item_seeds_hakusai");
                //this.Seed_onion = GameRegistry.findItem("chinjufumod", "item_seeds_onion");
                //this.Seed_rice = GameRegistry.findItem("chinjufumod", "item_seeds_rice");
                //this.Seed_soy = GameRegistry.findItem("chinjufumod", "item_seeds_soy");
                //this.Seed_spinach = GameRegistry.findItem("chinjufumod", "item_seeds_spinach");
                //this.Seed_tomato = GameRegistry.findItem("chinjufumod", "item_seeds_tomato");

                this.Bauxi = Item.getByNameOrId("chinjufumod:item_bauxite");
                this.Seed_corn = Item.getByNameOrId("chinjufumod:item_seeds_corn");
                this.Seed_cabbage = Item.getByNameOrId("chinjufumod:item_seeds_cabbage");
                this.Seed_hakusai = Item.getByNameOrId("chinjufumod:item_seeds_hakusai");
                this.Seed_onion = Item.getByNameOrId("chinjufumod:item_seeds_onion");
                this.Seed_rice = Item.getByNameOrId("chinjufumod:item_seeds_rice");
                this.Seed_soy = Item.getByNameOrId("chinjufumod:item_seeds_soy");
                this.Seed_spinach = Item.getByNameOrId("chinjufumod:item_seeds_spinach");
                this.Seed_tomato = Item.getByNameOrId("chinjufumod:item_seeds_tomato");


                /*カスタムレシピ追加処理*/
                GameRegistry.addRecipe(new ItemStack(this.Seed_corn),
                        "B  ",
                        " S ",
                        "   ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_cabbage),
                        " B ",
                        " S ",
                        "   ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_hakusai),
                        "  S",
                        " B ",
                        "   ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_onion),
                        "   ",
                        " SB",
                        "   ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_rice),
                        "   ",
                        " S ",
                        "  B",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_soy),
                        "   ",
                        " S ",
                        " B ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_spinach),
                        "   ",
                        " B ",
                        "S  ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

                GameRegistry.addRecipe(new ItemStack(this.Seed_tomato),
                        "   ",
                        "SB ",
                        "   ",
                        'B', new ItemStack(this.Bauxi),
                        'S', new ItemStack(Items.WHEAT_SEEDS)
                );

            }catch (Throwable t){
                logger.warn("Faild to get Item of Chinjufu-mod");
            }finally{
                logger.debug("Loaded Recipe in Chinjufu-mod");
            }
        }
        // Shincolle がロードされているか
        if (Loader.isModLoaded("shincolle")){
            try{
                this.shincolle_grudge = Item.getByNameOrId("shincolle:Grudge");
                this.shincolle_eggs = Item.getByNameOrId("shincolle:ShipSpawnEgg");
                this.shincolle_humer = Item.getByNameOrId("shincolle:KaitaiHammer");
                this.heavy_block = Item.getByNameOrId("shincolle:BlockGrudgeHeavy");
                //Shincolle アイテムを使用したトレードの追加 なおこれはテスト版

                GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 3),
                        " I ",
                        "I I",
                        "   ",
                        'I', new ItemStack(this.shincolle_grudge)
                );

                GameRegistry.addRecipe(new ItemStack(this.shincolle_grudge,1,1),
                        " O ",
                        "OHO",
                        " O ",
                        'O', new ItemStack(this.shincolle_eggs,1,1),
                        'H', new ItemStack(this.shincolle_humer, 1, OreDictionary.WILDCARD_VALUE)
                );

                GameRegistry.addRecipe(new ItemStack(Blocks.SOUL_SAND),
                        "JJJ",
                        "JDJ",
                        "JJJ",
                        'J', new ItemStack(this.shincolle_grudge,1,0),
                        'D', new ItemStack(Blocks.DIRT)
                );

                GameRegistry.addRecipe(new ItemStack(Items.SKULL,1,1),
                        "HKH",
                        "KHK",
                        "HKH",
                        'H', new ItemStack(this.heavy_block),
                        'K', new ItemStack(Blocks.SOUL_SAND)
                );

            }catch (Throwable t){
                logger.warn("Faild to get Item of Shincolle-mod");
            }finally {
                logger.debug("Loaded Recipe in Shincolle-mod");
                //logger.info((String) new ItemStack(this.shincolle_grudge).setItemDamage("1"));
            }

        }

        if (Loader.isModLoaded("tf")){
            try {
                this.tf_cokeblock = Item.getByNameOrId("tf:cokeblock");
                GameRegistry.addRecipe(new ItemStack(Items.SKULL,1,1),
                        "HKH",
                        "KHK",
                        "HKH",
                        'H', new ItemStack(Blocks.COAL_BLOCK),
                        'K', new ItemStack(this.tf_cokeblock)
                );
            }catch (Throwable t){
                logger.warn("Failed to get Item of TacticalFrame.");
            }finally {
                logger.debug("Loaded Recipe");
            }
        }

        /*最後に読み込ませる 鉄インゴット3から経験値瓶3*/
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE,3), new ItemStack(Items.IRON_INGOT,3));
        proxy.postInit(event);
    }

}
