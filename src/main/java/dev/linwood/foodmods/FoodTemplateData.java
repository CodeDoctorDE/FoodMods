package dev.linwood.foodmods;

import dev.linwood.itemmods.pack.PackObject;
import dev.linwood.itemmods.pack.asset.TemplateReadyPackAsset;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeDoctorDE
 */
public class FoodTemplateData {
    private final PackObject packObject;
    private final TemplateReadyPackAsset packAsset;
    private List<PotionEffect> effects = new ArrayList<>();
    private int saturation;
    private int foodLevel;

    public FoodTemplateData(PackObject packObject, TemplateReadyPackAsset packAsset) {
        this.packObject = packObject;
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

    }
}
