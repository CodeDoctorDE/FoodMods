package com.github.codedoctorde.foodmods.gui;

import com.github.codedoctorde.api.ui.Gui;
import com.github.codedoctorde.api.ui.GuiItem;
import com.github.codedoctorde.api.ui.template.gui.ListGui;
import com.github.codedoctorde.api.ui.template.gui.events.GuiListEvent;
import com.github.codedoctorde.foodmods.FoodMods;

/**
 * @author CodeDoctorDE
 */
public class FoodPotionListGui {
    public Gui createGui(){
        return new ListGui(FoodMods.getPlugin(), new GuiListEvent() {
            @Override
            public String title(int i, int i1) {
                return null;
            }

            @Override
            public GuiItem[] pages(String s) {
                return new GuiItem[0];
            }
        }).createGui(FoodMods.getPlugin().);
    }
}
