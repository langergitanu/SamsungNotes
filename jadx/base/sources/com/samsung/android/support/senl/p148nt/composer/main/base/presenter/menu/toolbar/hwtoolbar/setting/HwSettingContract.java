package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface HwSettingContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IItemView {
        void applyToolbarEnabledState(boolean z);

        void checkValidQuickColorItem(int i);

        void checkValidQuickSizeItem(int i);

        void clearQuickTypeItem();

        boolean correctSelectionMenu(HwToolbarState hwToolbarState);

        void enableMenus(boolean z, List<Integer> list);

        void executeAiAssist();

        List<Integer> getDisabledMenus();

        HwToolbarState getHwToolbarState();

        void hideDirectWrite();

        boolean isAssistanceSelected();

        boolean isDirectWriteUsing();

        boolean isSolveMathEnabled();

        void onItemSelected(int i);

        void onObjectChanged();

        void onUpdateToolbarItem();

        void onUpdateToolbarQuickItem();

        void onUpdateToolbarSelectionState(int i);

        void onUpdatedHighlighter(String str, int i);

        void onUpdatedLaserPen(Pair<Integer, Integer> pair);

        void onUpdatedPen(String str, int i);

        void onUpdatedQuickColor(int i, int i2);

        void onUpdatedQuickSize(int i, int i2);

        void onUpdatedSelection(int i);

        void onUpdatedSmartPen(int i, int i2);

        void onUpdatedStyle(int i);

        void restoreHwToolbarState(HwToolbarState hwToolbarState);

        void setDirectWrite(boolean z);

        void setSelectMenu(int i, boolean z);

        void setSolveMathEnabled(boolean z);

        void showAiAssistMenu(View view);

        void showCleanUpAndCTT();

        void showDirectWrite();

        void showToolTypeActionPen();

        void updateAlignment(boolean z);

        void updateAssistance(boolean z);

        void updateEasyWritingPad(boolean z);

        void updateLastPenTypeSelectionState();

        void updateRedoMenu(boolean z);

        void updateSelectionMode();

        void updateStateSelected(int i, boolean z);

        void updateTextMode(boolean z);

        void updateUndoMenu(boolean z);

        void updateVisible(boolean z, List<Integer> list);

        void updateZoomLockMenu(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        Activity getActivity();

        HwToolbarState getHwToolbarState();

        SpenSettingUIPenInfo getSelectedPenInfo();

        SettingInfoManager getSettingInfoManager();

        ISettingView getSettingView();

        void notifyRecentColorChanged();

        void onUpdateEyedropperColor();

        void setAllTypePenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void setEnableLaserPen(boolean z);

        boolean setHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        boolean setPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void updateLastPenInfo();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IQuickToolView {
        void onColorPalettesChanged(List<Integer> list);

        void onColorThemeChanged(int i);

        void onRecentColorsChanged(List<SpenHSVColor> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISettingInfoManger {
        Context getContext();

        SpenPenManager getPenManager();

        WritingToolManager getWritingToolManager();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISettingMiniView {
        void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        View getView();

        void onPickerColorChanged(int i, float[] fArr);

        void setColorTheme(int i);

        void setFavoriteList(List<SpenSettingUIPenInfo> list);

        void setPaletteList(List<Integer> list);

        void setPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void setRecentColor(List<SpenHSVColor> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISettingView {
        boolean hide();

        boolean hideColorSpoid();

        void hideSettingView(int i);

        void hideSettingViews(boolean z);

        boolean isShownSettingViews(int i);

        void notifyChangedRecentColor(List<SpenHSVColor> list);

        void notifyPaletteSetChanged(List<Integer> list);

        boolean onTouchOutside();

        void onUpdateEyedropperColor();

        void onUpdateFavoriteButton(boolean z);

        void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4);

        void setAssistanceOptions(boolean z, boolean z2, boolean z3);

        void setColorTheme(int i);

        void setEnabledSettingView(int i, boolean z);

        void setEyedropperPosition(int i, int i2);

        void setHighlighterOnlyEnabled(boolean z);

        void setIsSupportDynamicPenWeightByTextSize(boolean z);

        void setIsSupportFixedOpacity(boolean z);

        void setItemChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo);

        void setItemHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void setItemPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void setLaserPenSettingInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo);

        void setQuickColorSettingInfo(float[] fArr);

        void setQuickSizeInfo(int i);

        void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo);

        void setSelectedToolbarItem(int i);

        void setSelectionSettingInfo(SpenSettingSelectionInfo spenSettingSelectionInfo);

        void show(int i, int i2);

        void show(int i, int i2, View view);

        void showAddFavoritePen(int i, ViewGroup viewGroup, boolean z);

        void showByAnchor(int i, int i2, AnchorInfo anchorInfo);

        void showColorPicker(int i, View view, float[] fArr);

        void showEyedropper(int i, View view, float[] fArr, SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener);

        void showSelectionChangeStyle(int i, SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z, AnchorInfo anchorInfo);

        void updateBeautifierLanguage(String str, boolean z);

        void updateByAnchor(int i, int i2, AnchorInfo anchorInfo);

        void updateRemoverSettingLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NullItemView implements IItemView {
        private static final String TAG = Logger.createTag("NullItemView");
        String mCaller;

        public NullItemView(String str) {
            this.mCaller = str;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void applyToolbarEnabledState(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " applyToolbarViewState " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void checkValidQuickColorItem(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " checkValidQuickColorItem", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void checkValidQuickSizeItem(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " checkValidQuickSizeItem", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void clearQuickTypeItem() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " clearQuickTypeItem", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public boolean correctSelectionMenu(HwToolbarState hwToolbarState) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " correctSelectionMenu", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void enableMenus(boolean z, List<Integer> list) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void executeAiAssist() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " executeAiAssist", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public List<Integer> getDisabledMenus() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public HwToolbarState getHwToolbarState() {
            Logger.m11003i(TAG, this.mCaller + " getHwToolbarState");
            return new HwToolbarState();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void hideDirectWrite() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " hideDirectWrite", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public boolean isAssistanceSelected() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " isAssistanceSelected ", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public boolean isDirectWriteUsing() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " isDirectWriteUsing", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public boolean isSolveMathEnabled() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " isSolveMathEnabled ", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onItemSelected(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onItemSelected", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onObjectChanged() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onObjectChanged", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdateToolbarItem() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdateToolbarItem", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdateToolbarQuickItem() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdateToolbarQuickItem", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdateToolbarSelectionState(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdateToolbarSelectionState", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedHighlighter(String str, int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdatedHighlighter", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedLaserPen(Pair<Integer, Integer> pair) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedPen(String str, int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdatedPen", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedQuickColor(int i, int i2) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdatedQuickColor", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedQuickSize(int i, int i2) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdatedQuickSize", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedSelection(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdatedSelection", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedSmartPen(int i, int i2) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void onUpdatedStyle(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdatedStyle", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void restoreHwToolbarState(HwToolbarState hwToolbarState) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " restoreHwToolbarState", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void setDirectWrite(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " setDirectWrite " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void setSelectMenu(int i, boolean z) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCaller);
            sb.append(" setSelectMenu ");
            sb.append(i);
            sb.append(" ");
            AbstractC8014b.m7222x(sb, z, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void setSolveMathEnabled(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " setSolveMathEnabled " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void showAiAssistMenu(View view) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showAiAssistMenu", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void showCleanUpAndCTT() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showCleanUpAndCTT", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void showDirectWrite() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showDirectWrite", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void showToolTypeActionPen() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showToolTypeActionPen", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateAlignment(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " updateAlignment " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateAssistance(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " updateAssistance " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateEasyWritingPad(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " updateEasyWritingPad " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateLastPenTypeSelectionState() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " updateLastPenTypeSelectionState", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateRedoMenu(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " updateRedoMenu " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateSelectionMode() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateStateSelected(int i, boolean z) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCaller);
            sb.append(" updateStateSelected ");
            sb.append(i);
            sb.append(" isSelected ");
            AbstractC8014b.m7222x(sb, z, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateTextMode(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " updateTextMode " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateUndoMenu(boolean z) {
            Logger.m11003i(TAG, this.mCaller + " updateUndoMenu " + z);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateVisible(boolean z, List<Integer> list) {
            Logger.m11003i(TAG, this.mCaller + " updateVisible " + z + " itemIdList " + list);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
        public void updateZoomLockMenu(boolean z) {
            Logger.m10999d(TAG, this.mCaller + " updateZoomLockMenu " + z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NullSettingMiniView implements ISettingMiniView {
        private static final String TAG = Logger.createTag("NullSettingMiniView");
        String mCaller;

        public NullSettingMiniView(String str) {
            this.mCaller = str;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " addFavoritePenInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public View getView() {
            return null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void onPickerColorChanged(int i, float[] fArr) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onPickerColorChanged", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void setColorTheme(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setColorTheme", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void setFavoriteList(List<SpenSettingUIPenInfo> list) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setFavoriteList", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void setPaletteList(List<Integer> list) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setPaletteList", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void setPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setPenInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingMiniView
        public void setRecentColor(List<SpenHSVColor> list) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setRecentColor", TAG);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NullSettingView implements ISettingView {
        private static final String TAG = Logger.createTag("NullSettingView");
        String mCaller;

        public NullSettingView(String str) {
            this.mCaller = str;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public boolean hide() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " hide setting views", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public boolean hideColorSpoid() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " hideColorSpoid", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void hideSettingView(int i) {
            Logger.m11003i(TAG, this.mCaller + " hideSettingView " + i);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void hideSettingViews(boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " hideSettingViews", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public boolean isShownSettingViews(int i) {
            Logger.m11003i(TAG, this.mCaller + " isShownSettingViews " + i);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void notifyChangedRecentColor(List<SpenHSVColor> list) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " notifyChangedRecentColor", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void notifyPaletteSetChanged(List<Integer> list) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " notifyPaletteSetChanged", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public boolean onTouchOutside() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onTouchOutside", TAG);
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void onUpdateEyedropperColor() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdateEyedropperColor", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void onUpdateFavoriteButton(boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " onUpdateFavoriteButton", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setAlignmentOptions", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setAssistanceOptions(boolean z, boolean z2, boolean z3) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setAlignmentOptions", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setColorTheme(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setColorTheme", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setEnabledSettingView(int i, boolean z) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCaller);
            sb.append(" setEnabledSettingView ");
            sb.append(i);
            sb.append(" ");
            AbstractC8014b.m7222x(sb, z, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setEyedropperPosition(int i, int i2) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setEyedropperPosition", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setHighlighterOnlyEnabled(boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setHighlighterOnlyEnabled", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setIsSupportDynamicPenWeightByTextSize(boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setIsSupportDynamicPenWeightByTextSize", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setIsSupportFixedOpacity(boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setIsSupportFixedOpacity", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setItemChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setItemChangeStyleInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setItemHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setItemHighlighterSettingInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setItemPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setItemPenSettingInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setLaserPenSettingInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setLaserPenSettingInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setQuickColorSettingInfo(float[] fArr) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setQuickColorSettingInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setQuickSizeInfo(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setQuickSizeInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setRemoverSettingInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setSelectedToolbarItem(int i) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setSelectedToolbarItem", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void setSelectionSettingInfo(SpenSettingSelectionInfo spenSettingSelectionInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " setSelectionSettingInfo", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void show(int i, int i2) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCaller);
            sb.append(" show ");
            sb.append(i);
            sb.append(" ");
            AbstractC8014b.m7195A(sb, str, i2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void showAddFavoritePen(int i, ViewGroup viewGroup, boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showAddFavoritePen", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void showByAnchor(int i, int i2, AnchorInfo anchorInfo) {
            Logger.m11003i(TAG, this.mCaller + " show with anchorInfo " + i + " " + i2 + " " + anchorInfo.toString());
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void showColorPicker(int i, View view, float[] fArr) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showColorPicker", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void showEyedropper(int i, View view, float[] fArr, SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showEyedropper", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void showSelectionChangeStyle(int i, SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z, AnchorInfo anchorInfo) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " showSelectionChangeStyle", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void updateBeautifierLanguage(String str, boolean z) {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " updateBeautifierLanguage", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void updateByAnchor(int i, int i2, AnchorInfo anchorInfo) {
            Logger.m11003i(TAG, this.mCaller + " update with anchorInfo " + i + " " + i2 + " " + anchorInfo.toString());
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void updateRemoverSettingLayout() {
            AbstractC8014b.m7214p(new StringBuilder(), this.mCaller, " updateRemoverSettingLayout", TAG);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
        public void show(int i, int i2, View view) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCaller);
            sb.append(" show with view ");
            sb.append(i);
            sb.append(" ");
            AbstractC8014b.m7195A(sb, str, i2);
        }
    }
}
