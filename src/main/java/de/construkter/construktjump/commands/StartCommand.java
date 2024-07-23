package de.construkter.construktjump.commands;

import de.construkter.construktjump.ConstruktJump;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.ChatColor.GOLD;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player && commandSender.hasPermission("*")) {
            Player p = (Player) commandSender;
            new BukkitRunnable() {
                int countdown = 10;

                @Override
                public void run() {
                    if (countdown > 0) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendTitle(GOLD + "Event wird gestartet...", ChatColor.AQUA + String.valueOf(countdown), 0, 20, 0);
                        }
                        Bukkit.broadcastMessage(GOLD + String.valueOf(countdown));
                        countdown--;
                    } else {
                        Bukkit.broadcastMessage(GOLD + "Los gehts!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 10000 5");
                        this.cancel();
                    }
                }
            }.runTaskTimer(new ConstruktJump(), 0L, 20L);
            return true;
        }
        commandSender.sendMessage(ChatColor.RED + "Fehler!");
        return false;
    }
}
