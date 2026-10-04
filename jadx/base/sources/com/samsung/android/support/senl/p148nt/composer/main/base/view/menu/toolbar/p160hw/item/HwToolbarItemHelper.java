package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsItemOrderInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarItemHelper {
    private static final String ITEM_ORDER_CANDIDATE_KEY = "settings_candidate_toolbar_item_order";
    private static final String ITEM_ORDER_KEY = "settings_toolbar_item_order";
    private static final String ITEM_ORDER_PREFERENCE = "Settings";
    private static final String TAG = Logger.createTag("HwToolbarNewItemHelper");

    private static LinkedHashMap<DefaultItemOrder.TabletItem, AbsItemOrderInfo> loadJsonFromSharedPref(String str) {
        String string = SharedPreferencesCompat.getInstance("Settings").getString(str, "");
        LinkedHashMap<DefaultItemOrder.TabletItem, AbsItemOrderInfo> linkedHashMap = new LinkedHashMap<>();
        JSONArray jSONArray = new JSONArray(string);
        for (int i = 0; i < jSONArray.length(); i++) {
            DefaultItemOrder.TabletItem tabletItemFind = DefaultItemOrder.TabletItem.find(jSONArray.getString(i));
            if (tabletItemFind != null) {
                linkedHashMap.put(tabletItemFind, tabletItemFind.getItemInfo().getInfo());
            }
        }
        return linkedHashMap;
    }

    private static void recoverItemOrder(ArrayList<DefaultItemOrder.TabletItem> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        String string = SharedPreferencesCompat.getInstance("Settings").getString("settings_toolbar_item_order", "");
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArray = new JSONArray(string);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList2.add((String) jSONArray.get(i));
        }
        for (DefaultItemOrder.TabletItem tabletItem : arrayList) {
            int iOrdinal = tabletItem.ordinal();
            if (iOrdinal > arrayList2.size()) {
                iOrdinal = Math.max(arrayList2.size() - 1, 0);
            }
            arrayList2.add(iOrdinal, tabletItem.name());
        }
        JSONArray jSONArray2 = new JSONArray((Collection) arrayList2);
        SharedPreferencesCompat.getInstance("Settings").edit().putString("settings_toolbar_item_order", jSONArray2.toString()).commit();
        Logger.m11000e(TAG, "recovered item order : " + jSONArray2.toString());
    }

    public static void reflectNewItem() {
        try {
            LinkedHashMap<DefaultItemOrder.TabletItem, AbsItemOrderInfo> linkedHashMapLoadJsonFromSharedPref = loadJsonFromSharedPref("settings_toolbar_item_order");
            LinkedHashMap<DefaultItemOrder.TabletItem, AbsItemOrderInfo> linkedHashMapLoadJsonFromSharedPref2 = loadJsonFromSharedPref("settings_candidate_toolbar_item_order");
            ArrayList arrayList = new ArrayList();
            for (DefaultItemOrder.TabletItem tabletItem : DefaultItemOrder.TabletItem.values()) {
                if (!linkedHashMapLoadJsonFromSharedPref.containsKey(tabletItem) && !linkedHashMapLoadJsonFromSharedPref2.containsKey(tabletItem)) {
                    arrayList.add(tabletItem);
                }
            }
            recoverItemOrder(arrayList);
        } catch (NoSuchFieldException | JSONException e) {
            Logger.m11003i(TAG, e.getMessage());
        }
    }
}
