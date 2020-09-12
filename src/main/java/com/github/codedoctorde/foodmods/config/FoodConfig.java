package com.github.codedoctorde.foodmods.config;

import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CodeDoctorDE
 */
public class FoodConfig {
    private List<PotionEffect> effects = new ArrayList<>();
    private int saturation;
    private int foodLevel;

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
}
