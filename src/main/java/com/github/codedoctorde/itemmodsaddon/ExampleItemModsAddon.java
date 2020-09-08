package com.github.codedoctorde.itemmodsaddon;

import com.github.codedoctorde.itemmods.api.ItemModsAddon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author CodeDoctorDE
 */
public class ExampleItemModsAddon extends ItemModsAddon {
    @NotNull
    public String getName() {
        return "Example Name";
    }

    @NotNull
    public org.bukkit.inventory.ItemStack getIcon() {
        return null;
    }

    @Nullable
    public boolean openConfigGui() {
        return false;
    }
}
