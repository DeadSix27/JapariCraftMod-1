package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class StarJapariman extends ItemFood {

    public StarJapariman() {
        super(4, 3, false);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("StarJapariman");
        this.setAlwaysEdible();
    }

    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}