package com.samsung.android.support.senl.p148nt.app.main.folder.model;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderAnimateMap {
    private final HashMap<String, Object> mCheckedItem = new HashMap<>();

    public void addAnimateItem(String str) {
        this.mCheckedItem.put(str, Boolean.TRUE);
    }

    public void clearAnimateItems() {
        this.mCheckedItem.clear();
    }

    public boolean isAnimateItem(String str) {
        if (this.mCheckedItem.get(str) == null) {
            return false;
        }
        this.mCheckedItem.remove(str);
        return true;
    }
}
