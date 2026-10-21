package com.example.client;

import com.example.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ClientMod implements ClientModInitializer {
    
    private static KeyBinding menuKey;
    public static boolean fullbrightEnabled = false;

    @Override
    public void onInitializeClient() {
        // RSHIFT tuşunu menü için kaydet
        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.customclient.menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.customclient.hacks"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            // RSHIFT tuşuna basıldığında saydam ClickGUI menüsünü aç
            while (menuKey.wasPressed()) {
                client.setScreen(new ClickGuiScreen());
            }
        });
    }
}
