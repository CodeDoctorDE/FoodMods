package dev.linwood.foodmods;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dev.linwood.api.item.ItemStackTypeAdapter;
import dev.linwood.api.serializer.BlockDataTypeAdapter;
import dev.linwood.api.serializer.LocationTypeAdapter;
import dev.linwood.api.translations.Translation;
import dev.linwood.api.translations.TranslationConfig;
import dev.linwood.itemmods.ItemMods;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author CodeDoctorDE
 */
public class FoodMods extends JavaPlugin {
    private final FoodModsAddon addon = new FoodModsAddon();
    private static TranslationConfig translationConfig;
    private static FoodMods plugin;
    private static final Gson GSON = new GsonBuilder()
            .registerTypeHierarchyAdapter(Location.class, new LocationTypeAdapter())
            .registerTypeHierarchyAdapter(ItemStack.class, new ItemStackTypeAdapter())
            .registerTypeHierarchyAdapter(BlockData.class, new BlockDataTypeAdapter())
            .serializeNulls()
            .setPrettyPrinting().create();


    @Override
    public void onEnable() {
        plugin = this;
        translationConfig = new TranslationConfig(GSON, Paths.get(getDataFolder().toString(), "translations.json").toString());
        translationConfig.setDefault(new Translation(GSON.fromJson(Objects.requireNonNull(getTextResource("translations.json")), JsonObject.class)));
        translationConfig.save();
        Bukkit.getPluginManager().registerEvents(new FoodModsListener(), this);
        ItemMods.getPackManager().registerPack(addon);
    }

    @Override
    public void onDisable() {
        ItemMods.getPackManager().unregisterPack(addon.getName());
    }

    public static FoodMods getPlugin() {
        return plugin;
    }

    public static TranslationConfig getTranslationConfig() {
        return translationConfig;
    }

    public static String getTranslation(String key, Object... placeholders) {
        return translationConfig.getTranslation(key, placeholders);
    }

    public static Translation subTranslation(String... namespaces) {
        if (namespaces.length == 0)
            return new Translation();
        var t = translationConfig.subTranslation(namespaces[0]);
        for (String namespace : namespaces) t = t.merge(translationConfig.subTranslation(namespace));
        return t;
    }
}
