package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingAddFavoritePenLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingAddFavoritePenLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingAddFavoritePenLayout;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/impl/InAppSettingImpl;", "isAdd", "", "<init>", "(Z)V", "init", "", "setLayoutOrientation", "closeColorPopup", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingAddFavoritePenLayout extends HwSettingAddFavoritePenLayout implements InAppSettingImpl {
    public InAppSettingAddFavoritePenLayout(boolean z) {
        super(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl
    public void closeColorPopup() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.closeColorPickerPopup();
        }
        SpenSettingPenLayout spenSettingPenLayout2 = this.mSpenSettingLayout;
        if (spenSettingPenLayout2 != null) {
            spenSettingPenLayout2.closeColorSettingPopup();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingAddFavoritePenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        this.mIsSupportEyedropper = false;
        super.init();
        InAppSettingLayoutUtils.removeBackground(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void setLayoutOrientation() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.setLayoutOrientation(1);
        }
    }
}
