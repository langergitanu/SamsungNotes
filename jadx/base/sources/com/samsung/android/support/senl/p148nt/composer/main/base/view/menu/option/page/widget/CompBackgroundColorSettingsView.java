package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteCreator;
import com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CompBackgroundColorSettingsView extends AbsSwipeBackgroundColorSettingView {
    private static final String TAG = Logger.createTag("CompBackgroundColorSettingsView");
    private Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean canEnableInvertLayout();

        int getBackgroundColor();

        void invertBackgroundColor(boolean z);

        boolean isBackgroundColorInverted();

        boolean isCoeditNote();

        void loggingOnInvertChanged(boolean z);

        void loggingOnPaletteClicked();

        void notifyChanged();

        void setBackgroundColor(int i);
    }

    public CompBackgroundColorSettingsView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedColor(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "setSelectedColor# paletteId=", ", colorIndex=", TAG);
        int i4 = this.mCurrentPaletteId;
        if (i4 >= 0 && (i4 != i || this.mCurrentColorIndex != i2)) {
            this.mPalette.getPaletteContainerViewList().get(this.mCurrentPaletteId).updatePaletteItem(this.mCurrentColorIndex, false, true);
        }
        this.mCurrentPaletteId = i;
        this.mCurrentColorIndex = i2;
        if (this.mPalette.getColorPaletteData().size() > i) {
            int[] iArr = this.mPalette.getColorPaletteData().get(i).values;
            if (iArr.length > i2) {
                this.mCurrentColor = iArr[i2];
            }
        }
        this.mPalette.getPaletteContainerViewList().get(i).updatePaletteItem(i2, true, true);
        setBackgroundColor(this.mCurrentColor);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public boolean canEnableInvertLayout() {
        return this.mContract.canEnableInvertLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public boolean getDefaultBackgroundInvert() {
        return BackgroundColorUtil.getDefaultBackgroundInvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public PaletteCreator.OnItemActionListener getPaletteItemActionListener() {
        return new PaletteCreator.OnItemActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.widget.CompBackgroundColorSettingsView.1
            @Override // com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteCreator.OnItemActionListener
            public void onPaletteClicked(int i, int i2) {
                CompBackgroundColorSettingsView.this.setSelectedColor(i, i2);
                CompBackgroundColorSettingsView.this.mContract.loggingOnPaletteClicked();
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public void init() {
        super.init();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public void initStatus() {
        this.mCurrentColor = this.mContract.getBackgroundColor();
        this.mCurrentInvert = this.mContract.isBackgroundColorInverted();
        super.initStatus();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public void invertBackgroundColor(boolean z) {
        this.mContract.invertBackgroundColor(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public boolean isCoeditDarkThemeOfF() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public boolean isCoeditNote() {
        return this.mContract.isCoeditNote();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public void loggingOnInvertChanged(boolean z) {
        this.mContract.loggingOnInvertChanged(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView
    public void notifyChanged() {
        this.mContract.notifyChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView, android.view.View
    public void setBackgroundColor(int i) {
        this.mContract.setBackgroundColor(i);
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
        Logger.m10999d(TAG, "setContract# mContract " + this.mContract);
    }

    public CompBackgroundColorSettingsView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompBackgroundColorSettingsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
