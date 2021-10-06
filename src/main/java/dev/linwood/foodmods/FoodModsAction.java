package dev.linwood.foodmods;

import dev.linwood.api.translations.Translation;
import dev.linwood.itemmods.action.CommandAction;
import dev.linwood.itemmods.action.TranslationCommandAction;
import dev.linwood.itemmods.pack.PackObject;
import dev.linwood.itemmods.pack.asset.PackAsset;
import dev.linwood.itemmods.pack.custom.CustomData;

/**
 * @author CodeDoctorDE
 */
public class FoodModsAction implements TranslationCommandAction {
    private final PackObject packObject;
    private final CustomData data;
    private final PackAsset asset;

    public FoodModsAction(PackObject packObject, CustomData data, PackAsset asset) {
        this.packObject = packObject;
        this.data = data;
        this.asset = asset;
    }

    @Override
    public Translation getTranslationNamespace() {
        return FoodMods.getTranslationConfig().subTranslation("action");
    }
}
