package com.japaricraft.japaricraftmod.item;

import net.minecraft.item.ItemFood;

import static com.japaricraft.japaricraftmod.JapariCraftMod.tabJapariCraft;


public class Japariman extends ItemFood {

    public Japariman(){
        super(4,3,false);
        this.setCreativeTab(tabJapariCraft);
        this.setUnlocalizedName("Japariman");
        this.setMaxStackSize(64);

    }
}