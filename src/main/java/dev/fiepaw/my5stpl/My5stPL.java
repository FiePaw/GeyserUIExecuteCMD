package dev.fiepaw.my5stpl;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class My5stPL extends JavaPlugin {

    //buat instance nya
    private static My5stPL instance;

    //pasang instance nya
    public static My5stPL getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        // daftarin function loadCommands
        instance = this;
        loadCommands();
    }
    private void loadCommands() {
        // daftarin perintah nya
        PluginCommand tutorialForm = getInstance().getCommand("tutorialForm");
        // gak wajib nambahin ini
        if (tutorialForm == null) {
            getInstance().getLogger().severe("ada yang error pada saat mengload command, apakah kamu menggunakan plugin ini dengan baik?");
            Bukkit.getPluginManager().disablePlugin(getInstance());
            return;
        }
        // tambahin ke executor
        tutorialForm.setExecutor(getInstance());
    }
    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) MyFormClass.sendTutorialForm((Player) sender);
        return true;
    }


}
