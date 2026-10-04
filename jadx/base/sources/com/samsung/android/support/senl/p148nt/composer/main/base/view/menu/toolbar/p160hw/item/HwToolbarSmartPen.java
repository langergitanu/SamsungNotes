package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingSmartPenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.IHwToolbarSmartPenGroup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarSmartPen extends HwToolbarItem implements IHwToolbarSmartPenGroup.Parent {
    private static final String TAG = Logger.createTag("HwToolbarSmartPen");
    Map<Integer, HwToolbarItem> mChildItemMap;

    public HwToolbarSmartPen(View view, HwToolbarItemContract hwToolbarItemContract, @NonNull Map<Integer, HwToolbarItem> map) {
        super(view, hwToolbarItemContract);
        initState(map);
    }

    private void initState(Map<Integer, HwToolbarItem> map) {
        this.mChildItemMap = map;
        Iterator<Map.Entry<Integer, HwToolbarItem>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ((IHwToolbarSmartPenGroup.Child) it.next().getValue()).setParent(this);
        }
        SettingSmartPenData smartPenData = this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getSmartPenData();
        for (int i : HwToolbarConstants.SMART_PEN_ITEMS) {
            if (!this.mChildItemMap.containsKey(Integer.valueOf(i))) {
                smartPenData.addGoneMenu(i);
            }
        }
    }

    private void updateIcon(int i) {
        ImageView imageView = (ImageView) this.mView.findViewById(C9086R.id.smart_pen_icon);
        if (i == 8192) {
            imageView.setImageResource(C9086R.drawable.comp_dw_toolbar_ic_direct_writing);
        } else if (i != 131072) {
            imageView.setImageDrawable(null);
        } else {
            imageView.setImageResource(C9086R.drawable.comp_hw_toolbar_ic_assistance);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
    }

    public Map<Integer, HwToolbarItem> getChildItemMap() {
        return this.mChildItemMap;
    }

    public int getSelectedMenuId() {
        return this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getSmartPenData().getSelectedMenuId();
    }

    public void initSelectedMenu() {
        updateSelectedMenu(0, getSelectedMenuId(), false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.IHwToolbarSmartPenGroup.Parent
    public void notifyEnabled(int i, boolean z) {
        this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getSmartPenData().setEnabledMenuState(i, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.IHwToolbarSmartPenGroup.Parent
    public void notifyFunctionEnabled(int i, boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.IHwToolbarSmartPenGroup.Parent
    public void notifySelected(int i, boolean z) {
        if (z) {
            updateIcon(i);
            setSelectedMenuIdData(i);
        } else if (i == getSelectedMenuId()) {
            updateIcon(0);
            setSelectedMenuIdData(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        this.mHwSettingViewManager.show(getViewId(), 65536);
    }

    public void setSelectedMenuIdData(int i) {
        this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getSmartPenData().setSelectedMenuId(i);
    }

    public void updateDirectWrite() {
        if (!this.mHwToolbarItemManager.isDirectWriteUsing() || getSelectedMenuId() == 8192) {
            return;
        }
        updateSelectedMenu(0, 8192, true);
    }

    public void updateSelectedMenu(int i, int i2, boolean z) {
        if (i != 0 && i != 524288) {
            HwToolbarItem hwToolbarItem = this.mChildItemMap.get(Integer.valueOf(i));
            HwSettingViewManager hwSettingViewManager = this.mHwSettingViewManager;
            String str = TAG;
            hwSettingViewManager.setBlockHideSettingView(true, str);
            if (hwToolbarItem != null) {
                hwToolbarItem.onClick();
            }
            this.mHwSettingViewManager.setBlockHideSettingView(false, str);
        }
        HwToolbarItem hwToolbarItem2 = this.mChildItemMap.get(Integer.valueOf(i2));
        if (hwToolbarItem2 != null) {
            if (i2 != 524288 && i2 != 8192) {
                this.mHwSettingViewManager.setBlockHideSettingView(true, TAG);
            }
            if (i2 == 131072) {
                ((HwToolbarAssistance) hwToolbarItem2).runAction();
            } else {
                hwToolbarItem2.onClick();
            }
        }
        updateIcon(i2);
        this.mHwSettingViewManager.setBlockHideSettingView(false, TAG);
        if (z) {
            setSelectedMenuIdData(i2);
        }
    }
}
