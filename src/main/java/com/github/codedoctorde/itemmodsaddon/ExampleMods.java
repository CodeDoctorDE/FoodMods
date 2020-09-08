package com.github.codedoctorde.itemmodsaddon;

import com.github.codedoctorde.itemmods.ItemMods;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author CodeDoctorDE
 */
public class ExampleMods extends JavaPlugin {
    private ExampleItemModsAddon addon = new ExampleItemModsAddon();

    @Override
    public void onEnable() {
        ItemMods.getPlugin().getApi().registerAddon(addon);
    }

    @Override
    public void onDisable() {
        ItemMods.getPlugin().getApi().unregisterAddon(addon);
    }
}
