package com.github.codedoctorde.foodmods;

import com.github.codedoctorde.foodmods.template.FoodTemplate;
import com.github.codedoctorde.itemmods.api.ItemModsAddon;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author CodeDoctorDE
 */
public class FoodModsAddon extends ItemModsAddon {
    public FoodModsAddon(){
        registerItemTemplate(new FoodTemplate());
    }

    @NotNull
    public String getName() {
        return "Example Name";
    }

    @NotNull
    public ItemStack getIcon() {
        return null;
    }

    @Nullable
    public boolean openConfigGui() {
        return false;
    }
}
