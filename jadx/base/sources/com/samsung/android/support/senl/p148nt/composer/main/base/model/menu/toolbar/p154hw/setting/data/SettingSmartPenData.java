package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingSmartPenData {
    public static final int MENU_NONE = 0;
    private ChangeListener mChangeListener;
    private int mSelectedPenMenu = 0;
    private final Set<Integer> mDisabledMenuIdSet = new HashSet();
    private final Set<Integer> mGoneMenuIdSet = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ChangeListener {
        void onEnabledMenu(int i, boolean z);
    }

    public void addGoneMenu(int i) {
        this.mGoneMenuIdSet.add(Integer.valueOf(i));
    }

    public Set<Integer> getDisabledMenuIdSet() {
        return this.mDisabledMenuIdSet;
    }

    public Set<Integer> getGoneMenuIds() {
        return this.mGoneMenuIdSet;
    }

    public int getSelectedMenuId() {
        return this.mSelectedPenMenu;
    }

    public void setChangeListener(ChangeListener changeListener) {
        this.mChangeListener = changeListener;
    }

    public void setEnabledMenuState(int i, boolean z) {
        if (z) {
            this.mDisabledMenuIdSet.remove(Integer.valueOf(i));
        } else {
            this.mDisabledMenuIdSet.add(Integer.valueOf(i));
        }
        ChangeListener changeListener = this.mChangeListener;
        if (changeListener != null) {
            changeListener.onEnabledMenu(i, z);
        }
    }

    public void setSelectedMenuId(int i) {
        this.mSelectedPenMenu = i;
    }
}
