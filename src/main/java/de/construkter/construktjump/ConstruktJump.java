package de.construkter.construktjump;

import de.construkter.construktjump.commands.LobbyCommand;
import de.construkter.construktjump.commands.StartCommand;
import de.construkter.construktjump.lobby.DisableDefaultEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConstruktJump extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new DisableDefaultEvents(), this);
        getCommand("lobby").setExecutor(new LobbyCommand());
        getCommand("hub").setExecutor(new LobbyCommand());
        getCommand("start").setExecutor(new StartCommand());
    }

    @Override
    public void onDisable() {
    }
}
