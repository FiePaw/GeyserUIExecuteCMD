package dev.fiepaw.my5stpl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.UUID;

public class MyFormClass {
    public static void sendTutorialForm(Player player) {
        UUID uuid = player.getUniqueId();
        if (!FloodgateApi.getInstance().isFloodgatePlayer(uuid)) return;
        FloodgateApi.getInstance().getPlayer(uuid).sendForm(
                SimpleForm.builder()
                        .title("§1§lTOLKON VERSION BY FIEPAW")
                        .content("§7YEAA IAM UPGRADING MY SELF")
                        .button("§6§lGMC")
                        .button("§c§lGMS")
                        .button("§b§lVANISH")
                        .button("§9§lFLY")
                        .button("§4§lGOD")
                        .responseHandler((f, r) -> {
                            SimpleFormResponse response = f.parseResponse(r);
                            if (response.isCorrect()) {
                                int id = response.getClickedButtonId();
                                if (id == 0) Bukkit.getServer().dispatchCommand(player, "gmc");
                                else if (id == 1) Bukkit.getServer().dispatchCommand(player, "gms");
                                else if (id == 2) Bukkit.getServer().dispatchCommand(player, "vanish");
                                else if (id == 3) Bukkit.getServer().dispatchCommand(player, "fly");
                                else if (id == 4) Bukkit.getServer().dispatchCommand(player, "god");
                            }
                        })
        );
    }
}