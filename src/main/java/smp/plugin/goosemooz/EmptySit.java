package smp.plugin.goosemooz;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getCommandMap;

public final class EmptySit extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommandMap().register("", new SitCommand("sit"));
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (player.isInsideVehicle()) {
            Entity vehicle = player.getVehicle();
            assert vehicle != null;
            if (vehicle.getType() == EntityType.BLOCK_DISPLAY) {
                player.leaveVehicle();
                player.teleport(player.getLocation().subtract(0, -0.2, 0));
                vehicle.remove();
            }
        }
    }
}
