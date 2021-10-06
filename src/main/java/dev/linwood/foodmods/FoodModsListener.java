package dev.linwood.foodmods;

import dev.linwood.itemmods.api.item.CustomItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author CodeDoctorDE
 */
public class FoodModsListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getItem() == null)
            return;
        CustomItem customItem = new CustomItem(event.getItem());
        if (customItem.getConfig() == null) return;
        customItem.getConfig().getCustomTemplates().forEach(
                customData -> {
                    if(!(customData.getTemplate() instanceof FoodTemplate))
                        return;
                    FoodTemplate template = (FoodTemplate) customData.getTemplate();
                }
        );
    }
}
