package com.kudikan.gancube.event;

import com.kudikan.gancube.event.DummyRecipe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event){

    }
    @SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		removeRecipe(modRegistry, new ResourceLocation("minecraft:diamond_block"));
		removeRecipe(modRegistry, new ResourceLocation("minecraft:bread"));
    }
    public void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe) {
        IRecipe p = (IRecipe)modRegistry.getValue(recipe);
		
		modRegistry.remove(recipe);
		//modRegistry.register(DummyRecipe.from(p));
    }
}   
