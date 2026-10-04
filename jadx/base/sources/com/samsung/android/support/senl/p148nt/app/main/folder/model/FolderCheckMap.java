package com.samsung.android.support.senl.p148nt.app.main.folder.model;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderCheckMap {
    private static final String KEY_CHECKLIST = "key_folder_check_list";
    private HashMap<String, Object> mCheckedItems = new HashMap<>();

    private <key, value> List<key> getAllKeysForValue(Map<key, value> map, value value) {
        if (!map.containsValue(value)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<key, value> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public void addCheckedItem(String str, Object obj) {
        this.mCheckedItems.put(str, obj);
    }

    public void clearCheckedItems() {
        this.mCheckedItems.clear();
    }

    public Object getCheckItem(String str) {
        return this.mCheckedItems.get(str);
    }

    public int getCheckedItemCount() {
        return this.mCheckedItems.size();
    }

    public ArrayList<String> getCheckedItemUuidList() {
        return new ArrayList<>(this.mCheckedItems.keySet());
    }

    public ArrayList<String> getCheckedRootItemUuidList() {
        List allKeysForValue = getAllKeysForValue(this.mCheckedItems, Boolean.TRUE);
        return allKeysForValue == null ? new ArrayList<>() : new ArrayList<>(allKeysForValue);
    }

    public boolean isCheckedItem(String str) {
        return this.mCheckedItems.get(str) != null;
    }

    @CallSuper
    public void loadCheckedItem(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mCheckedItems = (HashMap) bundle.getSerializable(KEY_CHECKLIST);
    }

    public void removeCheckedItem(String str) {
        this.mCheckedItems.remove(str);
    }

    @CallSuper
    public void saveCheckedItem(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(KEY_CHECKLIST, this.mCheckedItems);
    }
}
