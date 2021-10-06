package dev.linwood.foodmods;

import dev.linwood.api.item.ItemStackBuilder;
import dev.linwood.api.translations.Translation;
import dev.linwood.itemmods.action.CommandAction;
import dev.linwood.itemmods.pack.PackObject;
import dev.linwood.itemmods.pack.asset.TemplateReadyPackAsset;
import dev.linwood.itemmods.pack.custom.CustomData;
import dev.linwood.itemmods.pack.custom.CustomTemplate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FoodTemplate extends CustomTemplate {
    Translation templateTranslation = FoodMods.getTranslationConfig().subTranslation("template");

    public FoodTemplate() {
        super("food_template");
    }

    @Override
    public @NotNull ItemStack getIcon(PackObject packObject, CustomData customData, TemplateReadyPackAsset packAsset) {
        return templateTranslation.subTranslation("icon").translate(new ItemStackBuilder(Material.GOLDEN_APPLE).displayName("title")
                .lore("description")).build();
    }

    @Override
    public @NotNull ItemStack getMainIcon() {
        return templateTranslation.subTranslation("main-icon").translate(new ItemStackBuilder(Material.GOLDEN_APPLE).displayName("title")
                .lore("description")).build();
    }

    @Override
    public @Nullable CommandAction generateAction(PackObject packObject, CustomData data, TemplateReadyPackAsset asset) {
        return new FoodModsAction(packObject, data, asset);
    }
}
