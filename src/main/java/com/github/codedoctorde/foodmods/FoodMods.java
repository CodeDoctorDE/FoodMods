package com.github.codedoctorde.foodmods;

import com.github.codedoctorde.api.config.ObjectConfig;
import com.github.codedoctorde.api.serializer.BlockDataTypeAdapter;
import com.github.codedoctorde.api.serializer.ItemStackTypeAdapter;
import com.github.codedoctorde.api.serializer.LocationTypeAdapter;
import com.github.codedoctorde.itemmods.ItemMods;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

/**
 * @author CodeDoctorDE
 */
public class FoodMods extends JavaPlugin {
    private FoodModsAddon addon = new FoodModsAddon();
    private ObjectConfig translationConfig;
    private static FoodMods plugin;
    private Gson gson;

    public FoodMods() {
        gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(Location.class, new LocationTypeAdapter())
                .registerTypeHierarchyAdapter(ItemStack.class, new ItemStackTypeAdapter())
                .registerTypeHierarchyAdapter(BlockData.class, new BlockDataTypeAdapter())
                .serializeNulls()
                .setPrettyPrinting().create();
    }

    @Override
    public void onEnable() {
        plugin = this;
        translationConfig = new ObjectConfig(gson, new File(getDataFolder(), "translations.json"));
        translationConfig.setDefault(gson.fromJson(Objects.requireNonNull(getTextResource("translations.json")), JsonObject.class));
        translationConfig.save();
        Bukkit.getPluginManager().registerEvents(new FoodModsListener(), this);
        ItemMods.getPlugin().getApi().registerAddon(addon);
    }

    @Override
    public void onDisable() {
        ItemMods.getPlugin().getApi().unregisterAddon(addon);
    }

    public static FoodMods getPlugin() {
        return plugin;
    }

    public ObjectConfig getTranslationConfig() {
        return translationConfig;
    }
}
