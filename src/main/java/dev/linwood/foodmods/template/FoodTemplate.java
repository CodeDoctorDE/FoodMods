package dev.linwood.foodmods.template;

import dev.linwood.foodmods.FoodMods;
import dev.linwood.foodmods.gui.FoodTemplateGui;
import com.github.codedoctorde.itemmods.ItemMods;
import com.github.codedoctorde.itemmods.api.item.CustomItemTemplate;
import com.github.codedoctorde.itemmods.config.ItemConfig;
import com.github.codedoctorde.api.utils.ItemStackBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.linwood.itemmods.ItemMods;
import dev.linwood.itemmods.pack.PackObject;
import dev.linwood.itemmods.pack.asset.PackAsset;
import dev.linwood.itemmods.pack.custom.CustomData;
import dev.linwood.itemmods.pack.custom.CustomTemplate;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FoodTemplate extends CustomTemplate {
    JsonObject templateTranslation = FoodMods.getTranslationConfig().getJsonObject().getAsJsonObject("addon")
            .getAsJsonObject("templates").getAsJsonObject("item").getAsJsonObject("food");

    static class FoodTemplateData {
        private final FoodTemplate template;
        private final ItemConfig itemConfig;
        private int level;
        private float exhaustion;
        private List<PotionEffect> effects = new ArrayList<>();

        private final Gson gson = new Gson();

        FoodTemplateData(FoodTemplate template, ItemConfig itemConfig) {
            this.template = template;
            this.itemConfig = itemConfig;
            JsonObject jsonObject = itemConfig.getTemplateConfig();
            if (jsonObject.has("level") && jsonObject.get("level").isJsonPrimitive())
                this.level = jsonObject.get("level").getAsInt();
            if (jsonObject.has("exhaustion") && jsonObject.get("exhaustion").isJsonPrimitive())
                this.level = jsonObject.get("exhaustion").getAsInt();
            if (jsonObject.has("effects") && jsonObject.get("effects").isJsonArray())
                jsonObject.getAsJsonArray("effects").forEach(element -> {
                    JsonObject effect = (JsonObject) element;
                    PotionEffectType type = PotionEffectType.getByName(effect.get("name").getAsString());
                    if(type != null)
                        effects.add(new PotionEffect(type,
                                effect.get("duration").getAsInt(), effect.get("amplifier").getAsInt()
                        ));
                });
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public float getExhaustion() {
            return exhaustion;
        }

        public void setExhaustion(float exhaustion) {
            this.exhaustion = exhaustion;
        }

        public List<PotionEffect> getEffects() {
            return effects;
        }

        public FoodTemplate getTemplate() {
            return template;
        }

        public void save() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("level", level);
            jsonObject.addProperty("exhaustion", exhaustion);
            JsonArray effectsArray = new JsonArray();
            effects.forEach(potionEffect -> {
                JsonObject object = new JsonObject();
                object.addProperty("amplifier", potionEffect.getAmplifier());
                object.addProperty("duration", potionEffect.getDuration());
                effectsArray.add(object);
            });
            jsonObject.add("effects", effectsArray);
            itemConfig.setTemplateConfig(jsonObject);
            ItemMods.getPlugin().saveBaseConfig();
        }
    }
}
