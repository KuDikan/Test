package com.kudikan.gancube.item;

import com.kudikan.gancube.Gancube;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class itemCtrlC extends Item {
    public itemCtrlC()
    {
        this.setRegistryName(Gancube.MOD_ID,"ctrl_c");
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

            for (EntityPlayer player : server.getPlayerList().getPlayers()) {
                player.sendStatusMessage(
                        new TextComponentString(
                                TextFormatting.YELLOW+
                                        new TextComponentTranslation(
                                                "multiplayer.player.left",
                                                playerIn.getDisplayNameString())
                                                .getUnformattedComponentText()),false);
            }


        }

        return ActionResult.newResult(EnumActionResult.SUCCESS, item);
    }
}
