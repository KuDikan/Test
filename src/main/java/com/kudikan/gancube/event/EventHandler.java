package com.kudikan.gancube.event;

import java.util.ArrayList;
import java.util.Iterator;

import com.kudikan.gancube.event.DummyRecipe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event){

    }
    @SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		//removeRecipe(modRegistry, new ResourceLocation("minecraft:diamond_block"));
		//removeRecipe(modRegistry, new ResourceLocation("minecraft:bread"));
		ItemStack recipeResult = null;
		ArrayList<IRecipe> recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> iterator = recipes.iterator();
		while(iterator.hasNext()) {
			IRecipe tmpRecipe = iterator.next();
			recipeResult = tmpRecipe.getRecipeOutput();
			if (true) {
				iterator.remove();
			 }
		}
    }
    public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe) {
        IRecipe p = (IRecipe)modRegistry.getValue(recipe);
		
		modRegistry.remove(recipe);
		modRegistry.register(DummyRecipe.from(p));
    }
}   
