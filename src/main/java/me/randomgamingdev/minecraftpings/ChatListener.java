package me.randomgamingdev.minecraftpings;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class ChatListener implements Listener {
    final private MinecraftPings plugin;

    ChatListener(MinecraftPings plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPLayerChatEvent(AsyncPlayerChatEvent event) {
        Server server = plugin.getServer();
        String newMsg = event.getMessage();
        for (Player player : server.getOnlinePlayers()) {
            String ping = '@' + player.getName();
            if (!newMsg.contains(ping))
                continue;
            newMsg = newMsg.replace(ping, "§e" + ping + "§r");
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
                }
            }.runTask(plugin);
        }
        event.setMessage(newMsg);
    }
}
