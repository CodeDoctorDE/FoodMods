package dev.linwood.foodmods;

import dev.linwood.foodmods.template.FoodTemplate;
import dev.linwood.itemmods.pack.ItemModsPack;

/**
 * @author CodeDoctorDE
 */
public class FoodModsAddon extends ItemModsPack {
    public FoodModsAddon(){
        super("foodmods");
        registerTemplate(new FoodTemplate());
    }
}
