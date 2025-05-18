package com.benrift.progressionmod.event;

import com.benrift.progressionmod.PlayerData.DataAttachmentRegistry;
import com.benrift.progressionmod.ProgressionMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = ProgressionMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event){
        Minecraft minecraft = Minecraft.getInstance();
        Player player = event.getEntity();

        int playerInsanity = player.getData(DataAttachmentRegistry.INSANITY);
        Component HADGE = Component.translatable("NOOOOOOOOOOO");

        if(playerInsanity >= 100){
            player.kill();
        }else{

            Component SADGE = Component.translatable(String.valueOf(playerInsanity));

            player.displayClientMessage(SADGE, true);

           // player.setData(DataAttachmentRegistry.INSANITY, playerInsanity + 1);
        }
    }
}
