package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.LazyUpdateHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingChangeStyleSelectedLayout extends HwSettingChangeStyleLayout {
    private static final String TAG = Logger.createTag("HwSettingChangeStyleSelectedLayout");
    private AnchorInfo mAnchorInfo;
    private int mLastToolTypeAction = 0;
    private LazyUpdateHelper<SpenSettingUIChangeStyleInfo> mLazyUpdateHelper;
    private SpenSettingUIChangeStyleInfo mPreviousChangeStyleInfo;

    public HwSettingChangeStyleSelectedLayout() {
        this.mIsSupportEyedropper = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        if (spenSettingUIChangeStyleInfo == null) {
            Logger.m11000e(TAG, "applyChangeStyleInfo param is null");
            return;
        }
        this.mSettingViewManager.executeSelectedChangeStyle(spenSettingUIChangeStyleInfo);
        this.mSettingViewManager.getSettingInstance().setStyleSettingInfo(spenSettingUIChangeStyleInfo);
        this.mSettingViewManager.getSettingInstance().addRecentColor(spenSettingUIChangeStyleInfo.color);
        if (spenSettingUIChangeStyleInfo.type == 1) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_CHANGE_STYLE_FILL);
            this.mSettingViewManager.getSettingInstance().addRecentColor(spenSettingUIChangeStyleInfo.fillColor);
        }
        ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_CHANGE_STYLE_NO_FILL, spenSettingUIChangeStyleInfo.isBlankShape ? "a" : "b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blockContextMenu(boolean z) {
        this.mSettingViewManager.setBlockContextMenu(z);
        if (z) {
            this.mSettingViewManager.clearContextMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blockSpenInput(boolean z) {
        int i;
        if (z) {
            this.mLastToolTypeAction = this.mWritingToolManager.getToolTypeAction(2);
            i = 1;
        } else {
            i = this.mLastToolTypeAction;
            if (i == 0) {
                return;
            }
        }
        this.mWritingToolManager.setToolTypeAction(2, i);
    }

    private void colorCorrection(int i, float[] fArr) {
        int i2 = i | (-16777216);
        if (i2 != Color.HSVToColor(fArr)) {
            Logger.m11003i(TAG, "Different with color and hsv");
            Color.colorToHSV(i2, fArr);
        }
    }

    private void makeDialogButtons() {
        Context context = this.mFloatingContainer.getContext();
        this.mSpenSettingChangeStyleLayout.addActionButton(context.getResources().getString(C9086R.string.composer_string_cancel), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleSelectedLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HwSettingChangeStyleSelectedLayout.this.mPreviousChangeStyleInfo != null) {
                    HwSettingChangeStyleSelectedLayout.this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().setSelectionBlankShape(HwSettingChangeStyleSelectedLayout.this.mPreviousChangeStyleInfo.isBlankShape);
                    HwSettingChangeStyleSelectedLayout.this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().setSelectionType(HwSettingChangeStyleSelectedLayout.this.mPreviousChangeStyleInfo.type);
                    HwSettingChangeStyleSelectedLayout.this.mPreviousChangeStyleInfo = null;
                }
                HwSettingChangeStyleSelectedLayout hwSettingChangeStyleSelectedLayout = HwSettingChangeStyleSelectedLayout.this;
                hwSettingChangeStyleSelectedLayout.mChangeStyleInfo = null;
                hwSettingChangeStyleSelectedLayout.hide(true);
                HwSettingChangeStyleSelectedLayout.this.mWritingToolManager.clearSelection();
            }
        });
        this.mSpenSettingChangeStyleLayout.addActionButton(context.getResources().getString(C9086R.string.composer_string_done), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleSelectedLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingChangeStyleSelectedLayout hwSettingChangeStyleSelectedLayout = HwSettingChangeStyleSelectedLayout.this;
                hwSettingChangeStyleSelectedLayout.applyChangeStyleInfo(hwSettingChangeStyleSelectedLayout.mChangeStyleInfo);
                HwSettingChangeStyleSelectedLayout.this.hide(true);
            }
        });
    }

    private void restoreBlankShape(boolean z) {
        this.mChangeStyleInfo.isBlankShape = !z || this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().isSelectionBlankShape();
    }

    private void updateBackgroundThemeColor() {
        float[] fArr = new float[3];
        colorCorrection(this.mSettingViewManager.getBackgroundThemeColor(), fArr);
        this.mSpenSettingChangeStyleLayout.setCanvasBackground(fArr);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        super.close();
        blockContextMenu(false);
        blockSpenInput(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        super.hide(z);
        this.mPreviousChangeStyleInfo = null;
        this.mAnchorInfo = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        super.init();
        makeDialogButtons();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean onTouchOutside() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout
    public void restoreChangeStyleInfo() {
        super.restoreChangeStyleInfo();
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = new SpenSettingUIChangeStyleInfo(this.mChangeStyleInfo);
        this.mPreviousChangeStyleInfo = spenSettingUIChangeStyleInfo;
        spenSettingUIChangeStyleInfo.type = this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().getSelectionType();
        this.mPreviousChangeStyleInfo.isBlankShape = this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().isSelectionBlankShape();
    }

    public void setAnchoredInfo(AnchorInfo anchorInfo) {
    }

    public void setChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z) {
        init();
        setViewMode(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout
    public void setInfoChangeListener() {
        super.setInfoChangeListener();
        this.mSpenSettingChangeStyleLayout.setChangeStyleInfoChangedListener(new SpenSettingChangeStyleLayout.ChangeStyleInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleSelectedLayout.4
            @Override // com.samsung.android.sdk.pen.setting.changestyle.SpenSettingChangeStyleManager.ChangeStyleInfoChangedListener
            public void onChangeStyleInfoChanged(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
                SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo2 = HwSettingChangeStyleSelectedLayout.this.mChangeStyleInfo;
                if (spenSettingUIChangeStyleInfo2 == null) {
                    Logger.m11000e(HwSettingChangeStyleSelectedLayout.TAG, "onChangeStyleInfoChanged# mChangeStyleInfo is null ");
                    return;
                }
                spenSettingUIChangeStyleInfo2.copy(spenSettingUIChangeStyleInfo);
                HwSettingChangeStyleSelectedLayout.this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().setSelectionBlankShape(HwSettingChangeStyleSelectedLayout.this.mChangeStyleInfo.isBlankShape);
                HwSettingChangeStyleSelectedLayout.this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().setSelectionType(HwSettingChangeStyleSelectedLayout.this.mChangeStyleInfo.type);
            }
        });
    }

    public void setViewMode(boolean z) {
        int i;
        if (z) {
            this.mChangeStyleInfo.type = this.mSettingViewManager.getSettingInfoManager().getChangeStyleData().getSelectionType();
            updateBackgroundThemeColor();
            i = 1;
        } else {
            this.mChangeStyleInfo.type = 0;
            i = 2;
        }
        restoreBlankShape(z);
        this.mSpenSettingChangeStyleLayout.setViewMode(i);
        this.mSettingViewManager.getHWToolbarState().setSelectionChangeStyleViewMode(i);
        String str = TAG;
        StringBuilder sb = new StringBuilder("setViewMode# type : ");
        sb.append(this.mChangeStyleInfo.type);
        sb.append("  isBlankShape : ");
        AbstractC8014b.m7222x(sb, this.mChangeStyleInfo.isBlankShape, str);
        this.mSpenSettingChangeStyleLayout.setInfo(this.mChangeStyleInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout
    public void setVisibilityChangeListener() {
        super.setVisibilityChangeListener();
        this.mSpenSettingChangeStyleLayout.setVisibilityChangedListener(new SpenPopupLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingChangeStyleSelectedLayout.5
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int i) {
                boolean z = i == 0;
                HwSettingChangeStyleSelectedLayout hwSettingChangeStyleSelectedLayout = HwSettingChangeStyleSelectedLayout.this;
                hwSettingChangeStyleSelectedLayout.mSettingViewManager.updateShowState(hwSettingChangeStyleSelectedLayout.getCallerType(), HwSettingChangeStyleSelectedLayout.this.getViewId(), z);
                HwSettingChangeStyleSelectedLayout.this.blockContextMenu(z);
                HwSettingChangeStyleSelectedLayout.this.blockSpenInput(z);
                HwSettingChangeStyleSelectedLayout.this.getSettingInstance().setFocusSelectedObjects(z);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSpenSettingChangeStyleLayout.getVisibility() == 0 || this.mWritingToolManager.getSelectedStrokeList().isEmpty()) {
            return;
        }
        setViewMode(this.mSettingViewManager.getHWToolbarState().getSelectionChangeStyleViewMode() == 1);
        inOutVI(this.mSpenSettingChangeStyleLayout, z);
        this.mSpenSettingChangeStyleLayout.setVisibility(0);
        this.mSpenSettingChangeStyleLayout.requestFocus();
        settingVisible();
        updatePosition(i, view, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null) {
            this.mSettingViewManager.updateLayoutParam(anchorInfo, this.mSpenSettingChangeStyleLayout);
        } else {
            this.mSettingViewManager.updateLayoutParam(i, view, this.mSpenSettingChangeStyleLayout);
        }
    }
}
