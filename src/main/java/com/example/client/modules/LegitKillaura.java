package com.example.client.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

import java.util.Random;

public class LegitKillaura {
    private static final Random random = new Random();
    private static long lastAttackTime = 0;

    public static void onTick(MinecraftClient client) {
        if (client.player == null || client.world == null) return;

        HitResult hit = client.crosshairTarget;
        if (hit != null && hit.getType() == HitResult.Type.ENTITY) {
            Entity target = ((EntityHitResult) hit).getEntity();

            if (target instanceof PlayerEntity && target.isAlive()) {
                long currentTime = System.currentTimeMillis();
                long randomDelay = 70 + random.nextInt(65); // 8-14 CPS arası rastgele gecikme

                if (currentTime - lastAttackTime >= randomDelay) {
                    client.interactionManager.attackEntity(client.player, target);
                    client.player.swingHand(Hand.MAIN_HAND);
                    lastAttackTime = currentTime;
                }
            }
        }
    }
}
