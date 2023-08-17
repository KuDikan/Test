package com.kudikan.gancube.event;

import java.util.Random;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.minecraft.item.Item;

@Mod.EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void onPlayerJoin(EntityJoinWorldEvent event) {

	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		// removeRecipe(modRegistry, new ResourceLocation("minecraft:diamond_block"));
		// removeRecipe(modRegistry, new ResourceLocation("minecraft:bread"));
		ArrayList<IRecipe> recipes = new ArrayList<IRecipe>(modRegistry.getValuesCollection());
		/*Iterator<IRecipe> iterator = recipes.iterator();
		while (iterator.hasNext()) {
			IRecipe tmpRecipe = iterator.next();
			Item recipeResult = tmpRecipe.getRecipeOutput().getItem();
			if ("minecraft".equals(recipeResult.getRegistryName().getNamespace())) {
				removeRecipe(modRegistry, recipeResult.getRegistryName());
				//iterator.remove();
			}*/
		Random r = new Random(114514);
	        for (IRecipe recipe:recipes){
			Item item = recipe.getRecipeOutput().getItem();
			if ("minecraft".equals(item.getRegistryName().getNamespace()) && r.nextDouble()<0.90) {
				removeRecipe(modRegistry, item.getRegistryName());
			}
		}
	}

	public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe) {
		//IRecipe p = (IRecipe) modRegistry.getValue(recipe);

		modRegistry.remove(recipe);
		//modRegistry.register(DummyRecipe.from(p));
	}
}
