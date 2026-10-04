package com.samsung.android.support.senl.p148nt.app.labs.actionbar;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ComposerOptionsMenu {
    private final List<MenuItem> menuItemList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MenuItem {
        final int icon;
        final int title;

        public MenuItem(int i, int i2) {
            this.title = i;
            this.icon = i2;
        }
    }

    public ComposerOptionsMenu() {
        ArrayList arrayList = new ArrayList();
        this.menuItemList = arrayList;
        arrayList.add(new MenuItem(C8003R.string.action_edit, C8003R.drawable.comp_option_menu_ic_edit));
        arrayList.add(new MenuItem(C8003R.string.composer_sort_pages, C8003R.drawable.comp_appbar_ic_page_sorter));
        arrayList.add(new MenuItem(C8003R.string.action_search, C8003R.drawable.comp_search_ic));
        arrayList.add(new MenuItem(C8003R.string.action_share, C8003R.drawable.comp_appbar_ic_share));
        arrayList.add(new MenuItem(C8003R.string.save_as, C8003R.drawable.comp_appbar_ic_attach));
        arrayList.add(new MenuItem(C8003R.string.composer_add_to_favorite, C8003R.drawable.comp_appbar_ic_favorite_off));
        arrayList.add(new MenuItem(C8003R.string.composer_add_tag, C8003R.drawable.btn_expand));
        arrayList.add(new MenuItem(C8003R.string.composer_pin_to_homescreen, C8003R.drawable.template_editor_zoom_in));
        arrayList.add(new MenuItem(C8003R.string.composer_send_to_reminder, C8003R.drawable.selection_rectangle));
        arrayList.add(new MenuItem(C8003R.string.action_print, C8003R.drawable.iris_recognize_fingerprint));
        arrayList.add(new MenuItem(C8003R.string.action_save, C8003R.drawable.comp_appbar_ic_save));
        arrayList.add(new MenuItem(C8003R.string.composer_reading_mode, C8003R.drawable.comp_appbar_ic_reading_mode_off));
        arrayList.add(new MenuItem(C8003R.string.composer_opt_text_only_mode, C8003R.drawable.comp_appbar_ic_text_only_mode_off));
    }

    public List<MenuItem> getList() {
        return this.menuItemList;
    }
}
