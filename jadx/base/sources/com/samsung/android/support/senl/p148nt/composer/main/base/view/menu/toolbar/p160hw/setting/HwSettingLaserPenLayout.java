package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.LazyUpdateHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingLaserPenLayout extends AbsHwSettingAnchorLayout {
    private static final String TAG = Logger.createTag("HwSettingLaserPenLayout");
    View.OnClickListener mClickListener;
    private ConstraintSet mConstraintSet;
    private boolean mIsAppBarMode;
    private boolean mLastEnabled;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    protected SpenSettingLaserPenLayout mSpenSettingLaserPenLayout;

    public HwSettingLaserPenLayout() {
        new LazyUpdateHelper(new LazyUpdateHelper.Callback<SpenSettingUILaserPenInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.LazyUpdateHelper.Callback
            public void onLazyUpdate(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
                HwSettingLaserPenLayout hwSettingLaserPenLayout = HwSettingLaserPenLayout.this;
                hwSettingLaserPenLayout.applyLaserPenInfo(spenSettingUILaserPenInfo, hwSettingLaserPenLayout.mIsAppBarMode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyLaserPenInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo, boolean z) {
        if (spenSettingUILaserPenInfo == null) {
            Logger.m11000e(TAG, "applyChangeStyleInfo param is null");
            return;
        }
        boolean zIsEyedropperVisible = isEyedropperVisible();
        this.mSettingViewManager.getSettingInstance().setLaserPenInfo(spenSettingUILaserPenInfo, z, zIsEyedropperVisible);
        if (zIsEyedropperVisible) {
            return;
        }
        this.mSettingViewManager.getSettingInstance().addRecentColor(spenSettingUILaserPenInfo.color);
    }

    private boolean isColorPickerPopupVisible() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        return spenSettingLaserPenLayout != null && spenSettingLaserPenLayout.isColorPickerPopupVisible();
    }

    private boolean isColorSettingPopupVisible() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        return spenSettingLaserPenLayout != null && spenSettingLaserPenLayout.isColorSettingPopupVisible();
    }

    private boolean isEyedropperVisible() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        return (spenSettingLaserPenLayout != null && spenSettingLaserPenLayout.isEyedropperVisible()) || this.mSettingViewManager.getHWToolbarState().isColorSpoidEnable(getViewId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null) {
            return;
        }
        spenSettingLaserPenLayout.requestFocus();
        this.mSpenSettingLaserPenLayout.sendAccessibilityEvent(8);
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(this.mSpenSettingLaserPenLayout.getResources(), C9086R.string.hw_toolbar_item_laser_pen, sb, SQLKeyword.COMMA);
        this.mSpenSettingLaserPenLayout.announceForAccessibility(AbstractC0000a.m12i(this.mSpenSettingLaserPenLayout.getResources(), C9086R.string.base_string_settings, sb));
    }

    private void setListeners() {
        this.mSpenSettingLaserPenLayout.setLaserPenInfoChangedListener(new SpenSettingLaserPenLayout.LaserPenInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.3
            @Override // com.samsung.android.sdk.pen.setting.laserpen.SpenSettingLaserPenManager.LaserPenInfoChangedListener
            public void onLaserPenInfoChanged(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
                HwSettingLaserPenLayout hwSettingLaserPenLayout = HwSettingLaserPenLayout.this;
                hwSettingLaserPenLayout.applyLaserPenInfo(spenSettingUILaserPenInfo, hwSettingLaserPenLayout.mIsAppBarMode);
            }
        });
        this.mSpenSettingLaserPenLayout.setVisibilityChangedListener(new SpenPopupLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.4
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int i) {
                HwSettingLaserPenLayout hwSettingLaserPenLayout = HwSettingLaserPenLayout.this;
                hwSettingLaserPenLayout.mSettingViewManager.updateShowState(hwSettingLaserPenLayout.getCallerType(), HwSettingLaserPenLayout.this.getViewId(), i == 0);
                if (i != 0) {
                    HwSettingLaserPenLayout hwSettingLaserPenLayout2 = HwSettingLaserPenLayout.this;
                    if (hwSettingLaserPenLayout2.mAnchorInfo != null) {
                        hwSettingLaserPenLayout2.close();
                    }
                }
            }
        });
        this.mSpenSettingLaserPenLayout.setColorPickerVisibilityChangeListener(new SpenSettingChangeStyleLayout.SpenColorPickerViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.5
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                HwSettingLaserPenLayout.this.mSettingViewManager.getHWToolbarState().setColorPickerEnable(HwSettingLaserPenLayout.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingLaserPenLayout.setColorSettingVisibilityChangeListener(new SpenSettingChangeStyleLayout.SpenColorSettingViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.6
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                HwSettingLaserPenLayout.this.mSettingViewManager.getHWToolbarState().setColorSettingEnable(HwSettingLaserPenLayout.this.getViewId(), i == 0);
            }
        });
        this.mSpenSettingLaserPenLayout.setPaletteChangedListener(new SpenSettingChangeStyleLayout.SpenPaletteChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.7
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.PaletteChangedListener
            public void onPaletteChanged(List<Integer> list) {
                HwSettingLaserPenLayout.this.mSettingViewManager.getSettingInstance().onPaletteChanged(list);
            }
        });
        this.mSpenSettingLaserPenLayout.setEyedropperVisibilityChangedListener(new SpenColorControlPopupLayout.SettingViewListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.8
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout.SettingViewListener
            public void onVisibilityChanged(int i) {
                AbstractC0000a.m3D(i, "setEyedropperVisibilityChangedListener onVisibilityChanged visibility = ", HwSettingLaserPenLayout.TAG);
                boolean z = i == 0;
                if (z) {
                    HwSettingLaserPenLayout.this.mSettingViewManager.getHWToolbarState().setEyedropperColor(HwSettingLaserPenLayout.this.mSettingViewManager.getSelectedPenInfo().color);
                }
                HwSettingLaserPenLayout.this.mSettingViewManager.getHWToolbarState().setColorSpoidEnable(HwSettingLaserPenLayout.this.getViewId(), z);
                HwSettingLaserPenLayout.this.mSettingViewManager.getSettingInstance().setEyedropperMode(z);
            }
        });
        final String screenID = ComposerSA.getScreenID(true, true, this.mSettingViewManager.isTabletLayout());
        this.mSpenSettingLaserPenLayout.setLoggingListener(new SpenSettingLaserPenLayout.LoggingListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.9
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout.LoggingListener
            public void onClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorCirclePressed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onColorPickerDone() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorPickerSelected() {
                ComposerSA.insertLog(screenID, HwSettingLaserPenLayout.this.mIsAppBarMode ? HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_PEN_COLOR_PICKER : HWToolbarSAConstants.EVENT_HW_LASER_PEN_COLOR_PICKER);
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSelected(int i) {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingCancel() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorSettingsLoggingListener
            public void onColorSettingDone(int i) {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onColorSettingSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperClosed() {
            }

            @Override // com.samsung.android.sdk.pen.setting.EyedropperLoggingListener
            public void onEyedropperHandlerTapped() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onEyedropperSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.PenPaletteLoggingListener
            public void onPaletteSwiped(int i) {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onRecentColorSelected() {
            }

            @Override // com.samsung.android.sdk.pen.setting.ColorPickerLoggingListener
            public void onSeekbarChanged() {
            }
        });
    }

    private void updateSettingInfo() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null) {
            return;
        }
        spenSettingLaserPenLayout.setInfo(this.mSettingViewManager.getSettingInfoManager().getLaserPenData().getLaserPenInfo());
        this.mSpenSettingLaserPenLayout.setRecentColor(this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors());
        this.mSpenSettingLaserPenLayout.setPalette(this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList());
        if (this.mSettingViewManager.getHWToolbarState().getPaletteId(getViewId()) > -1) {
            this.mSpenSettingLaserPenLayout.setCurrentPalette(this.mSettingViewManager.getHWToolbarState().getPaletteId(getViewId()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        hide(false);
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null) {
            this.mConstraintSet = null;
        } else {
            spenSettingLaserPenLayout.close();
            this.mSpenSettingLaserPenLayout = null;
        }
    }

    @NonNull
    public SpenSettingLaserPenLayout createSpenSettingLaserPenLayout(boolean z) {
        return new SpenSettingLaserPenLayout(this.mFloatingContainer.getContext(), this.mFloatingContainer, this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getSelectList(), this.mSettingViewManager.getSettingInfoManager().getColorRecentData().getRecentColors(), this.mSettingViewManager.getSettingInfoManager().getColorPaletteData().getColorSettingInfo(), z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout
    public View getView() {
        return this.mSpenSettingLaserPenLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null) {
            return;
        }
        inOutVI(spenSettingLaserPenLayout, z);
        if (this.mSpenSettingLaserPenLayout.isColorPickerPopupVisible()) {
            this.mSpenSettingLaserPenLayout.closeColorPickerPopup();
        }
        if (this.mSpenSettingLaserPenLayout.isColorSettingPopupVisible()) {
            this.mSpenSettingLaserPenLayout.closeColorSettingPopup();
        }
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null && anchorInfo.getAnchorBorderView() != null && this.mAnchorInfo.getAnchorBorderView().getVisibility() == 0) {
            this.mAnchorInfo.getAnchorBorderView().setVisibility(8);
        }
        this.mSpenSettingLaserPenLayout.setVisibility(8);
        super.hide(z);
        if (this.mPreTouchListener != null) {
            getSettingInstance().removePreTouchListener(this.mPreTouchListener);
        }
    }

    public void hideEyedropper() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null) {
            return;
        }
        spenSettingLaserPenLayout.hideEyedropper();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout;
        if (this.mAnchorInfo != null && !this.mIsAppBarMode && (spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout) != null) {
            spenSettingLaserPenLayout.close();
            this.mSpenSettingLaserPenLayout = null;
            this.mConstraintSet = null;
        }
        if (this.mAnchorInfo != null) {
            this.mIsAppBarMode = true;
            this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLaserPenLayout.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0 && motionEvent.getAction() != 211) {
                        return false;
                    }
                    HwSettingLaserPenLayout.this.hide(true);
                    return false;
                }
            };
        } else {
            this.mIsAppBarMode = false;
            this.mPreTouchListener = null;
        }
        SpenSettingLaserPenLayout spenSettingLaserPenLayout2 = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout2 != null) {
            updateConstraintSet(spenSettingLaserPenLayout2, this.mIsAppBarMode);
            updateSettingInfo();
            return;
        }
        SpenSettingLaserPenLayout spenSettingLaserPenLayoutCreateSpenSettingLaserPenLayout = createSpenSettingLaserPenLayout(!this.mIsAppBarMode);
        this.mSpenSettingLaserPenLayout = spenSettingLaserPenLayoutCreateSpenSettingLaserPenLayout;
        spenSettingLaserPenLayoutCreateSpenSettingLaserPenLayout.setVisibility(8);
        this.mSpenSettingLaserPenLayout.setColorTheme(this.mSettingViewManager.getColorTheme());
        this.mFloatingContainer.addView(this.mSpenSettingLaserPenLayout);
        if (this.mSpenSettingLaserPenLayout.getId() == -1) {
            this.mSpenSettingLaserPenLayout.setId(View.generateViewId());
        }
        updateConstraintSet(this.mSpenSettingLaserPenLayout, this.mIsAppBarMode);
        this.mSettingViewManager.getHWToolbarState().setColorSettingState(getViewId());
        updateSettingInfo();
        setListeners();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        return spenSettingLaserPenLayout != null && spenSettingLaserPenLayout.getVisibility() == 0;
    }

    public void setActionButton(boolean z, View.OnClickListener onClickListener) {
        this.mLastEnabled = z;
        this.mClickListener = onClickListener;
    }

    public void setEyedropperColor(int i) {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null) {
            return;
        }
        spenSettingLaserPenLayout.setEyedropperColor(i);
    }

    public void setPalette(List<Integer> list) {
        if (isVisible()) {
            this.mSpenSettingLaserPenLayout.setPalette(list);
        }
    }

    public void setSettingInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        SpenSettingLaserPenLayout spenSettingLaserPenLayout = this.mSpenSettingLaserPenLayout;
        if (spenSettingLaserPenLayout == null || CommonUtil.compareLaserPenInfo(spenSettingLaserPenLayout.getInfo(), spenSettingUILaserPenInfo)) {
            return;
        }
        this.mSpenSettingLaserPenLayout.setInfo(spenSettingUILaserPenInfo);
    }

    public void settingVisible() {
        if (this.mSettingViewManager.getHWToolbarState().isColorPickerEnable(getViewId()) && !isColorPickerPopupVisible()) {
            this.mSpenSettingLaserPenLayout.setColorPickerViewMode(this.mSettingViewManager.getSettingInfoManager().getColorPickerData().getColorPickerViewMode());
        }
        if (!this.mSettingViewManager.getHWToolbarState().isColorSettingEnable(getViewId()) || isColorSettingPopupVisible()) {
            return;
        }
        this.mSpenSettingLaserPenLayout.showColorSettingPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (isVisible()) {
            return;
        }
        inOutVI(this.mSpenSettingLaserPenLayout, z);
        this.mSpenSettingLaserPenLayout.setFocusable(true);
        this.mSpenSettingLaserPenLayout.setVisibility(0);
        settingVisible();
        updatePosition(i, view, z);
        this.mSpenSettingLaserPenLayout.postDelayed(new RunnableC9767a(this, 9), z ? 300L : 0L);
        super.show(i, view, z);
        if (this.mPreTouchListener != null) {
            getSettingInstance().addPreTouchListener(this.mPreTouchListener);
        }
    }

    public void updateConstraintSet(View view, boolean z) {
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.clear(view.getId());
        }
        ConstraintSet constraintSet2 = new ConstraintSet();
        this.mConstraintSet = constraintSet2;
        constraintSet2.clone(this.mFloatingContainer);
        this.mConstraintSet.connect(view.getId(), 6, 0, 6);
        this.mConstraintSet.connect(view.getId(), 7, 0, 7);
        this.mConstraintSet.connect(view.getId(), 3, 0, 3);
        if (!z) {
            this.mConstraintSet.connect(view.getId(), 4, 0, 4);
        }
        this.mConstraintSet.applyTo(this.mFloatingContainer);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        if (this.mSpenSettingLaserPenLayout == null) {
            return;
        }
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null) {
            if (anchorInfo.getAnchorBorderView() != null && this.mAnchorInfo.getAnchorBorderView().getVisibility() != 0) {
                this.mAnchorInfo.getAnchorBorderView().setVisibility(0);
            }
            this.mSpenSettingLaserPenLayout.setActionButton(this.mSpenSettingLaserPenLayout.getResources().getString(this.mLastEnabled ? C9086R.string.hw_laser_pen_off : C9086R.string.hw_laser_pen_on), this.mClickListener);
        }
        super.updatePosition(i, view, z);
    }
}
