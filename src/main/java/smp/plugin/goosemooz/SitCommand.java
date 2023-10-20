package smp.plugin.goosemooz;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.bukkit.block.Block;

public class SitCommand extends Command {
    public SitCommand(String name) {
        super(name);
    }
    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String command, String[] args) {
            if (sender instanceof Player player) {
                Location create = player.getLocation();
                Block blockUnder = create.subtract(0, 1, 0).getBlock();
                if (blockUnder.getType() != Material.AIR || !player.isInsideVehicle()) {
                    create.setY(create.getY() + 0.8);
                    BlockDisplay entity = (BlockDisplay) player.getWorld().spawnEntity(create, EntityType.BLOCK_DISPLAY);
                    entity.addPassenger(player);
                }
            }
        return true;
    }
}
