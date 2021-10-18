package dev.linwood.foodmods;

import dev.linwood.itemmods.ItemMods;
import dev.linwood.itemmods.pack.PackObject;
import dev.linwood.itemmods.pack.asset.TemplateReadyPackAsset;
import dev.linwood.itemmods.pack.custom.CustomData;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeDoctorDE
 */
public class FoodTemplateData {
    private final PackObject packObject;
    private final TemplateReadyPackAsset packAsset;
    private final CustomData customData;
    private List<PotionEffect> effects = new ArrayList<>();
    private int saturation;
    private int foodLevel;

    public FoodTemplateData(PackObject packObject, CustomData customData, TemplateReadyPackAsset packAsset) {
        this.packObject = packObject;
        this.customData = customData;
        this.packAsset = packAsset;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public int getSaturation() {
        return saturation;
    }

    public List<PotionEffect> getEffects() {
        return effects;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public void save() {
        customData.setData(ItemMods.GSON.toJsonTree(this));
        customData.save();
    }
}
