package com.github.codedoctorde.foodmods;

import com.github.codedoctorde.itemmods.ItemMods;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author CodeDoctorDE
 */
public class FoodMods extends JavaPlugin {
    private FoodModsAddon addon = new FoodModsAddon();

    @Override
    public void onEnable() {
        ItemMods.getPlugin().getApi().registerAddon(addon);
    }

    @Override
    public void onDisable() {
        ItemMods.getPlugin().getApi().unregisterAddon(addon);
    }
}
