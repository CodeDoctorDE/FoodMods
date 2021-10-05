package dev.linwood.foodmods.gui;

import dev.linwood.foodmods.template.FoodTemplate;
import com.github.codedoctorde.itemmods.config.ItemConfig;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeDoctorDE
 */
public class FoodTemplateData {
    private final FoodTemplate template;
    private final ItemConfig itemConfig;
    private List<PotionEffect> effects = new ArrayList<>();
    private int saturation;
    private int foodLevel;

    public FoodTemplateData(FoodTemplate template, ItemConfig itemConfig) {
        this.template = template;
        this.itemConfig = itemConfig;
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
