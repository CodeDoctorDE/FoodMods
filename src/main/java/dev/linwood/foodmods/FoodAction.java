package dev.linwood.foodmods;

import dev.linwood.api.item.ItemStackBuilder;
import dev.linwood.api.translations.Translation;
import dev.linwood.api.ui.template.gui.TranslatedChestGui;
import dev.linwood.api.ui.template.item.TranslatedGuiItem;
import dev.linwood.itemmods.ItemMods;
import dev.linwood.itemmods.action.CommandAction;
import dev.linwood.itemmods.action.TranslationCommandAction;
import dev.linwood.itemmods.pack.PackObject;
import dev.linwood.itemmods.pack.asset.PackAsset;
import dev.linwood.itemmods.pack.asset.TemplateReadyPackAsset;
import dev.linwood.itemmods.pack.custom.CustomData;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author CodeDoctorDE
 */
public class FoodAction implements TranslationCommandAction {
    private final PackObject packObject;
    private final CustomData data;
    private final TemplateReadyPackAsset asset;

    public FoodAction(PackObject packObject, CustomData data, TemplateReadyPackAsset asset) {
        this.packObject = packObject;
        this.data = data;
        this.asset = asset;
    }

    public FoodTemplateData getTemplateData() {
        return new FoodTemplateData(packObject, data, asset);
    }

    @Override
    public boolean showGui(CommandSender sender) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ItemMods.getTranslation("command.no-player"));
            return true;
        }
        var gui = new TranslatedChestGui(FoodMods.subTranslation("action"));
        gui.addItem(new TranslatedGuiItem(new ItemStackBuilder(Material.CLOCK).displayName("cooldown.title").lore("cooldown.description").build()){{
            setRenderAction((gui) -> setPlaceholders());
        }});
        return true;
    }

    @Override
    public Translation getTranslationNamespace() {
        return FoodMods.getTranslationConfig().subTranslation("action");
    }
}
