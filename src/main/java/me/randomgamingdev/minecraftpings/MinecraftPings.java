package me.randomgamingdev.minecraftpings;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftPings extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("MinecraftPings is starting!");
        this.getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("MinecraftPings is shutting down!");
    }
}
