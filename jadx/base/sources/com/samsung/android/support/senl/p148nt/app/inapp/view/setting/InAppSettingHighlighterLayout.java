package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenLayout;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingHighlighterLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0014J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0014J\b\u0010\u0019\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingHighlighterLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingHighlighterLayout;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/impl/InAppSettingImpl;", "<init>", "()V", "mCurrentPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "init", "", "initSettingLayout", "setCommonChangedListener", Constants.ARG_UPDATE, "callerType", "", "container", "Landroid/view/View;", "withAnimation", "", "setHighlighterSettingInfo", "penInfo", "setRotation", "surfaceType", "parentView", "callerView", "setLayoutOrientation", "closeColorPopup", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingHighlighterLayout extends HwSettingHighlighterLayout implements InAppSettingImpl {

    @NotNull
    private static final String TAG = "InAppSettingHighlighterLayout";

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

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingHighlighterLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        this.mIsSupportEyedropper = false;
        this.mSupportDynamicPenWeightByTextSize = this.mSettingViewManager.isSupportDynamicPenWeightByTextSize();
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
        spenSettingPenLayout.setLoggingListener(inAppSettingSALog.getHighlighterLoggingListener());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void setCommonChangedListener() {
        super.setCommonChangedListener();
        this.mSpenSettingLayout.setColorPickerChangedListener(new SpenSettingPenLayout.ColorPickerChangedListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingHighlighterLayout.setCommonChangedListener.1
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.ColorPickerModeChangedListener
            public void onViewModeChanged(int mode) {
                ((HwSettingLayout) InAppSettingHighlighterLayout.this).mSettingViewManager.getSettingInfoManager().getColorPickerData().setColorPickerViewMode(mode);
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, mode == 2 ? InAppSAConstants.EVENT_COLOR_PICKER_SWATCHED : InAppSAConstants.EVENT_COLOR_PICKER_SPECTRUM);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingHighlighterLayout
    public void setHighlighterSettingInfo(@NotNull SpenSettingUIPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        super.setHighlighterSettingInfo(penInfo);
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
                int i2 = (((penInfo.color >> 24) & 255) * 100) / 255;
                SpenSettingUIPenInfo spenSettingUIPenInfo3 = this.mCurrentPenInfo;
                Intrinsics.checkNotNull(spenSettingUIPenInfo3);
                if (i2 != (((spenSettingUIPenInfo3.color >> 24) & 255) * 100) / 255) {
                    CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_SETTINGS_HIGHLIGHTER_OPACITY, i2);
                }
            }
        }
        this.mCurrentPenInfo = penInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenLayoutCommon
    public void setLayoutOrientation() {
        this.mSpenSettingLayout.setLayoutOrientation(1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setRotation(final int surfaceType, @NotNull final View parentView, @NotNull final View callerView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(callerView, "callerView");
        final int width = parentView.getWidth();
        final int height = parentView.getHeight();
        final Rect rect = new Rect((int) parentView.getX(), (int) parentView.getY(), width, height);
        this.mSpenSettingLayout.setRotation(surfaceType != 1 ? surfaceType != 3 ? 0.0f : 270.0f : 90.0f);
        this.mSpenSettingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingHighlighterLayout.setRotation.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                float f;
                int i;
                ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (surfaceType == 0) {
                    ViewAnchorUtil.updatePositionToCenter(callerView, parentView, ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout, (int) parentView.getResources().getDimension(C8003R.dimen.comp_hw_floating_menu_margin));
                    return;
                }
                int width2 = ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getWidth();
                int height2 = ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getHeight();
                if (surfaceType == 1) {
                    Rect rect2 = rect;
                    f = rect2.right - ((width - height2) >> 1);
                    i = rect2.top + ((height - width2) >> 1);
                } else {
                    Rect rect3 = rect;
                    f = rect3.left + ((width - height2) >> 1);
                    i = rect3.bottom - ((height - width2) >> 1);
                }
                float f4 = i;
                ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.setX(f);
                ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.setY(f4);
                ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.setPivotX(0.0f);
                ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.setPivotY(0.0f);
                float x = ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getX();
                float y2 = ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getY();
                float pivotX = ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getPivotX();
                float pivotY = ((HwSettingPenLayoutCommon) InAppSettingHighlighterLayout.this).mSpenSettingLayout.getPivotY();
                StringBuilder sbM1176v = AbstractC0622a.m1176v("setRotation# onGlobalLayout, x : ", x, ", y : ", y2, ", pivotX : ");
                sbM1176v.append(pivotX);
                sbM1176v.append(", pivotY : ");
                sbM1176v.append(pivotY);
                InAppLogger.m8595d(InAppSettingHighlighterLayout.TAG, sbM1176v.toString());
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void update(int callerType, @Nullable View container, boolean withAnimation) {
        super.show(callerType, container, withAnimation);
        if (isPenMiniMode()) {
            return;
        }
        init();
        if (this.mSpenSettingLayout.getVisibility() == 0) {
            return;
        }
        this.mSpenSettingLayout.setVisibility(0);
        this.mSpenSettingLayout.requestFocus();
        setLayoutOrientation();
        settingVisible();
        updateFavoriteButton(false);
    }
}
