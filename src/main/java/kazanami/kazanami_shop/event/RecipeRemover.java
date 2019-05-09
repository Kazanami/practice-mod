package kazanami.kazanami_shop.event;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;
import java.util.List;

public class RecipeRemover {
    public static void removeRecipe(String item){
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> remover = recipes.iterator();

        while (remover.hasNext()){
            ItemStack itemStack = remover.next().getRecipeOutput();

            if(itemStack != null && itemStack.getItem() == Item.getByNameOrId(item)){
                remover.remove();
            }
        }
    }

    public static void removeRecipe(Block block){
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> remover = recipes.iterator();

        while (remover.hasNext()){
            ItemStack itemStack = remover.next().getRecipeOutput();

            if(itemStack != null && itemStack.getItem() == Item.getItemFromBlock(block)){
                remover.remove();
            }
        }
    }
}


