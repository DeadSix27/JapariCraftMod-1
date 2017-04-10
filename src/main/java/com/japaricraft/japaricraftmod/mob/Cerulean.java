package com.japaricraft.japaricraftmod.mob;


import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Cerulean extends EntityMob {


    public Cerulean(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 0.6F);
    }

    protected void initEntityAI(){


        //this.tasks.addTask(0, new Entityattack);
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPigZombie.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityVillager.class, false));
        this.targetTasks.addTask(3,new EntityAINearestAttackableTarget<>(this, KouteiPenguin.class,true));
        this.targetTasks.addTask(3,new EntityAINearestAttackableTarget<>(this, Serval.class,true));
        this.targetTasks.addTask(3,new EntityAINearestAttackableTarget<>(this, WhiteOwl.class,true));
        this.targetTasks.addTask(3,new EntityAINearestAttackableTarget<>(this, BrownOwl.class,true));
    }

    public boolean isAIEnabled() { return true; }



    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SLIME_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_SLIME_HURT;
    }
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SLIME_SQUISH;
    }


    /*
    * このMobが動いているときの音のファイルパスを返す.
    * 引数のblockはMobの下にあるBlock.
    */


    //てき（プレイヤーの登録っぽい
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
    }


    //敵（プレイヤー）の登録解除
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
    }


    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEAD; }



    @Override
    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel) {
        //ほんとは確率とかで落とすものが決めれるんだと思う
        {
            this.entityDropItem(new ItemStack(Items.SLIME_BALL, 1, 0), 0.0F);

        }
    }


    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25D);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1);
    }
}