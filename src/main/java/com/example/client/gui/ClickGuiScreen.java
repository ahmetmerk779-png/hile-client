package com.example.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {

    public ClickGuiScreen() {
        super(Text.literal("Cheat Menu"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Arka planı hafif koyu saydam yap
        context.fill(0, 0, this.width, this.height, 0x70000000);

        // Ana Panel (Saydam Koyu Gri + İnce Beyaz Çerçeve)
        int panelX = 50, panelY = 40, panelW = 320, panelH = 220;
        context.fill(panelX, panelY, panelX + panelW, panelY + panelH, 0xAA111115); 
        context.drawBorder(panelX, panelY, panelW, panelH, 0x44FFFFFF);

        // Başlık
        context.drawText(this.textRenderer, "§b§lPROJECT §fCLIENT §7| Anti-Cheat Bypass", panelX + 12, panelY + 12, 0xFFFFFFFF, false);
        context.fill(panelX + 10, panelY + 28, panelX + panelW - 10, panelY + 29, 0x33FFFFFF);

        // Modül Kartları
        renderModuleCard(context, panelX + 15, panelY + 40, "Legit Killaura", "Randomized Delay & Smooth Aim", mouseX, mouseY);
        renderModuleCard(context, panelX + 15, panelY + 90, "ESP / Tracers", "Glow & Line Render", mouseX, mouseY);
        renderModuleCard(context, panelX + 15, panelY + 140, "Fullbright", "Max Brightness / Night Vision", mouseX, mouseY);

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderModuleCard(DrawContext context, int x, int y, String title, String desc, int mouseX, int mouseY) {
        boolean hovered = mouseX >= x && mouseX <= x + 290 && mouseY >= y && mouseY <= y + 40;
        int bgColor = hovered ? 0x66ffffff : 0x22ffffff;
        
        context.fill(x, y, x + 290, y + 40, bgColor);
        context.drawBorder(x, y, 290, 40, 0x22FFFFFF);
        context.drawText(this.textRenderer, "§f" + title, x + 10, y + 8, 0xFFFFFFFF, false);
        context.drawText(this.textRenderer, "§7" + desc, x + 10, y + 22, 0xAAAAAAAA, false);
    }

    @Override
    public boolean shouldPause() {
        return false; // Menü açıldığında oyun durmaz
    }
}
