package com.samsung.android.support.senl.p148nt.app.main.folder.model;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderMoveMap {
    private static final String KEY_MOVED_CHECKED_ITEM = "key_moved_folder_checked_item";
    private static final String KEY_MOVED_CHECKLIST = "key_moved_folder_check_list";
    private static final String KEY_MOVED_SELECTED_ITEM = "key_moved_folder_selected_item";
    private HashMap<MoveItem, Object> mCheckedItem;
    private HashMap<String, Object> mDimStatusItems = new HashMap<>();
    private HashMap<MoveItem, Object> mSelectedItem;

    public void addDimStatusItem(String str) {
        if (str == null) {
            return;
        }
        this.mDimStatusItems.put(str, Boolean.TRUE);
    }

    public void clearDimStatusItems() {
        this.mDimStatusItems.clear();
    }

    public boolean isDimStatusItem(String str) {
        return this.mDimStatusItems.get(str) != null;
    }

    @CallSuper
    public void loadCheckedItem(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mDimStatusItems = (HashMap) bundle.getSerializable(KEY_MOVED_CHECKLIST);
        this.mCheckedItem = (HashMap) bundle.getSerializable(KEY_MOVED_CHECKED_ITEM);
        this.mSelectedItem = (HashMap) bundle.getSerializable(KEY_MOVED_SELECTED_ITEM);
    }

    public void onStart() {
        this.mCheckedItem = new HashMap<>();
        this.mSelectedItem = new HashMap<>();
    }

    @CallSuper
    public void saveCheckedItem(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(KEY_MOVED_CHECKLIST, this.mDimStatusItems);
        bundle.putSerializable(KEY_MOVED_CHECKED_ITEM, this.mCheckedItem);
        bundle.putSerializable(KEY_MOVED_SELECTED_ITEM, this.mSelectedItem);
    }
}
