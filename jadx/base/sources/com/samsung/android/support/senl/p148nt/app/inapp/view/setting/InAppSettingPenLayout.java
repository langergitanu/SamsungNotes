package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.content.Context;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingPenLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingPenLayout;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/impl/InAppSettingImpl;", "<init>", "()V", "mCurrentPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "init", "", "initSettingLayout", "setCommonChangedListener", "setPenSettingInfo", "penInfo", "setLayoutOrientation", "closeColorPopup", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingPenLayout extends HwSettingPenLayout implements InAppSettingImpl {

    @Nullable
    private SpenSettingUIPenInfo mCurrentPenInfo;

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

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        this.mIsSupportEyedropper = false;
        this.mSupportFixedOpacity = this.mSettingViewManager.isSupportFixedOpacity();
        super.init();
        this.mSpenSettingLayout.hideCloseButton();
        this.mSpenSettingLayout.setSelfClose(false);
        this.mSpenSettingLayout.setColorPickerCloseButtonType(1);
        InAppSettingLayoutUtils.removeBackground(this.mSpenSettingLayout);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void initSettingLayout() {
        super.initSettingLayout();
        Context context = this.mSpenSettingLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        InAppSettingSALog inAppSettingSALog = new InAppSettingSALog(context, this.mSettingViewManager.getSettingInfoManager().getPenInfoData());
        this.mHwSettingSALog = inAppSettingSALog;
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        Intrinsics.checkNotNull(inAppSettingSALog, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingSALog");
        spenSettingPenLayout.setLoggingListener(inAppSettingSALog.getPenLoggingListener(false, false));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void setCommonChangedListener() {
        super.setCommonChangedListener();
        this.mSpenSettingLayout.setColorPickerChangedListener(new SpenSettingPenLayout.ColorPickerChangedListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingPenLayout.setCommonChangedListener.1
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.ColorPickerModeChangedListener
            public void onViewModeChanged(int mode) {
                ((HwSettingLayout) InAppSettingPenLayout.this).mSettingViewManager.getSettingInfoManager().getColorPickerData().setColorPickerViewMode(mode);
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, mode == 2 ? InAppSAConstants.EVENT_COLOR_PICKER_SWATCHED : InAppSAConstants.EVENT_COLOR_PICKER_SPECTRUM);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void setLayoutOrientation() {
        SpenSettingPenLayout spenSettingPenLayout = this.mSpenSettingLayout;
        if (spenSettingPenLayout != null) {
            spenSettingPenLayout.setLayoutOrientation(1);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayout
    public void setPenSettingInfo(@NotNull SpenSettingUIPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        super.setPenSettingInfo(penInfo);
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mCurrentPenInfo;
        if (spenSettingUIPenInfo == null) {
            this.mCurrentPenInfo = penInfo;
            return;
        }
        Intrinsics.checkNotNull(spenSettingUIPenInfo);
        if (Intrinsics.areEqual(spenSettingUIPenInfo.name, penInfo.name)) {
            int i = penInfo.sizeLevel;
            SpenSettingUIPenInfo spenSettingUIPenInfo2 = this.mCurrentPenInfo;
            Intrinsics.checkNotNull(spenSettingUIPenInfo2);
            if (i != spenSettingUIPenInfo2.sizeLevel) {
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_PEN_SIZE, penInfo.sizeLevel);
            } else {
                boolean z = penInfo.isFixedWidth;
                SpenSettingUIPenInfo spenSettingUIPenInfo3 = this.mCurrentPenInfo;
                Intrinsics.checkNotNull(spenSettingUIPenInfo3);
                if (z != spenSettingUIPenInfo3.isFixedWidth) {
                    CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_INK_PEN_THICKNESS, penInfo.isFixedWidth ? "a" : "b");
                } else {
                    int i2 = (((penInfo.color >> 24) & 255) * 100) / 255;
                    SpenSettingUIPenInfo spenSettingUIPenInfo4 = this.mCurrentPenInfo;
                    Intrinsics.checkNotNull(spenSettingUIPenInfo4);
                    if (i2 != (((spenSettingUIPenInfo4.color >> 24) & 255) * 100) / 255) {
                        CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_PENCIL_DARKNESS, i2);
                    }
                }
            }
        } else {
            CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_PEN_TYPE, InAppSettingSALog.INSTANCE.getSADetailPenType(penInfo.name));
        }
        this.mCurrentPenInfo = penInfo;
    }
}
