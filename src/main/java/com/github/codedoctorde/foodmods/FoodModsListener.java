package com.github.codedoctorde.foodmods;

import com.github.codedoctorde.foodmods.template.FoodTemplate;
import com.github.codedoctorde.itemmods.api.item.CustomItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;

/**
 * @author CodeDoctorDE
 */
public class FoodModsListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getItem() == null)
            return;
        CustomItem customItem = new CustomItem(event.getItem());
        if (customItem.getConfig() == null || !(customItem.getConfig().getTemplate() instanceof FoodTemplate)) return;
        FoodTemplate template = (FoodTemplate) customItem.getConfig().getTemplate();
    }
}
