package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingRemoverLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingRemoverLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingRemoverLayout;", "isCoeditNote", "", "<init>", "(Z)V", "init", "", "hideEraseAllOption", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingRemoverLayout extends HwSettingRemoverLayout {
    public InAppSettingRemoverLayout(boolean z) {
        super(z);
    }

    public final void hideEraseAllOption() {
        SpenSettingRemoverLayout spenSettingRemoverLayout = this.mSpenSettingRemoverLayout;
        if (spenSettingRemoverLayout != null) {
            spenSettingRemoverLayout.hideEraseAllOption();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingRemoverLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        super.init();
        this.mSpenSettingRemoverLayout.hideCloseButton();
        this.mSpenSettingRemoverLayout.setSelfClose(false);
        InAppSettingLayoutUtils.removeBackground(this.mSpenSettingRemoverLayout);
    }
}
