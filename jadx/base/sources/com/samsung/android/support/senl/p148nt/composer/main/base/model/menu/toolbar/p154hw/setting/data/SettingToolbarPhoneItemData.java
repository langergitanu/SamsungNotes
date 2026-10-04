package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingToolbarPhoneItemData extends SettingToolbarItemData {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public int getQuickColorUseCount() {
        return 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public int getQuickSizeUseCount() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnableQuickColor() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnableQuickSize() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledAssistance() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.Assistance.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledAutoFixShapes() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.Shape.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledCleanUpAndConvertText() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.CleanUpAndConvertText.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledConvertToText() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.ConvertText.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledEasyWritingPad() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.EasyWritePad.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledLaserPointer() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.LaserPen.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledLockCanvas() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.LockCanvas.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledPenStyle() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.Style.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledSpenToText() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.DirectWrite.name());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData
    public boolean isEnabledStraighten() {
        return isEnableFunction(DefaultItemOrder.ItemInfo.Align.name());
    }
}
