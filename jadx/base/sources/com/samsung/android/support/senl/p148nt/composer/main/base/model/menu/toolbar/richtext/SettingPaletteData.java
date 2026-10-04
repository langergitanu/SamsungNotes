package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.richtext;

import android.content.Context;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPaletteData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingPaletteData {
    private static final String PREFS_KEY_FOR_FONT_COLOR_PALLET_LIST = "RichTextFontColorPalletList";
    private static final String PREFS_NAME_COLOR = "color_shared_preferences";
    private final List<Integer> mPaletteList;

    public SettingPaletteData(Context context) {
        ArrayList arrayList = new ArrayList();
        this.mPaletteList = arrayList;
        if (!loadPaletteList(arrayList)) {
            loadDefaultSelectList(arrayList);
        }
        new SpenColorPaletteUtil(context).getValidTaleIDs(arrayList);
    }

    private boolean loadPaletteList(List<Integer> list) {
        String string = SharedPreferencesCompat.getInstance(PREFS_NAME_COLOR).getString(PREFS_KEY_FOR_FONT_COLOR_PALLET_LIST, "");
        if (string.isEmpty()) {
            return false;
        }
        for (String str : string.split(":")) {
            list.add(Integer.valueOf(str));
        }
        return true;
    }

    public List<Integer> getPaletteList() {
        return this.mPaletteList;
    }

    public String getPaletteListString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(':');
        }
        return sb.toString();
    }

    public boolean isEquals(List<Integer> list) {
        return this.mPaletteList.size() == list.size() && this.mPaletteList.containsAll(list);
    }

    public void loadDefaultSelectList(List<Integer> list) {
        list.clear();
        list.addAll(ColorPaletteData.getDefaultSelectList());
    }

    public void setPaletteList(List<Integer> list) {
        this.mPaletteList.clear();
        this.mPaletteList.addAll(list);
        SharedPreferencesCompat.getInstance(PREFS_NAME_COLOR).putString(PREFS_KEY_FOR_FONT_COLOR_PALLET_LIST, getPaletteListString(list));
    }
}
