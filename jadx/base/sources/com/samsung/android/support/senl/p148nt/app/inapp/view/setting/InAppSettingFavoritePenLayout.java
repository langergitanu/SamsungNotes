package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.view.View;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingFavoritePenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0014¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingFavoritePenLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingFavoritePenLayout;", "<init>", "()V", "init", "", Constants.IntentExtraValue.SHOW, "callerType", "", "container", "Landroid/view/View;", "withAnimation", "", "hide", "onCloseButtonClick", "onAddButtonClick", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingFavoritePenLayout extends HwSettingFavoritePenLayout {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingFavoritePenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean withAnimation) {
        if (isVisible()) {
            this.mSpenSettingLayout.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingFavoritePenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        super.init();
        InAppSettingLayoutUtils.removeBackground(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingFavoritePenLayout
    public void onAddButtonClick() {
        hide(false);
        super.onAddButtonClick();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingFavoritePenLayout
    public void onCloseButtonClick() {
        hide(false);
        ISettingViewManager iSettingViewManager = this.mSettingViewManager;
        iSettingViewManager.show(1, iSettingViewManager.getSelectedToolbarItem(), null, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingFavoritePenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int callerType, @Nullable View container, boolean withAnimation) {
        super.show(callerType, container, withAnimation);
        if (callerType == 2 || callerType == 2048) {
            CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_FAVORITE_MODE);
        }
    }
}
