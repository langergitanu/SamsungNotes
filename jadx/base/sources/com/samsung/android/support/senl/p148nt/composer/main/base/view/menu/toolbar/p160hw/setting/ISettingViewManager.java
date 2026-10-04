package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.graphics.PointF;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ISettingViewManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnUpdatePositionListener {
        void onPositionUpdated(View view, PointF pointF, PointF pointF2);
    }

    void clearContextMenu();

    void executeEraseAllOnAllPages();

    void executeEraseAllOnCurrentPage(int i);

    void executeSelectedChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo);

    int getBackgroundThemeColor();

    int getColorTheme();

    String getCurrentPageInfo();

    HwToolbarState getHWToolbarState();

    SpenSettingUIPenInfo getSelectedPenInfo();

    int getSelectedToolbarItem();

    SettingInfoManager getSettingInfoManager();

    HwSettingPresenter getSettingInstance();

    WritingToolManager getWritingToolManager();

    boolean hide();

    boolean isCoeditNote();

    boolean isEraseCurrentTwoPage();

    boolean isShownSettingViews(int i);

    boolean isShownSettingViews(int i, int i2);

    boolean isSupportDynamicPenWeightByTextSize();

    boolean isSupportEraseCurrentPage();

    boolean isSupportFixedOpacity();

    boolean isTabletLayout();

    void notifyChangedRecentColor(List<SpenHSVColor> list);

    void notifyPaletteSetChanged(List<Integer> list);

    void onShowSettingPenMini();

    void onUpdatedSelection(int i);

    void onUpdatedStyle(int i);

    void requestFocusToComposerView();

    void setBlockContextMenu(boolean z);

    void setSelectedToolbarItem(int i);

    void setSkipHideFavoriteList(boolean z);

    void show(int i, int i2);

    void show(int i, int i2, View view);

    void show(int i, int i2, View view, boolean z);

    void updateLayoutParam(int i, View view);

    void updateLayoutParam(int i, View view, View view2);

    void updateLayoutParam(int i, View view, OnUpdatePositionListener onUpdatePositionListener);

    void updateLayoutParam(AnchorInfo anchorInfo, View view);

    void updateLayoutParam(AnchorInfo anchorInfo, View view, OnUpdatePositionListener onUpdatePositionListener);

    void updateShowState(int i, int i2, boolean z);

    void updateShowState(int i, int i2, boolean z, boolean z2);

    void updateShowState(int i, int i2, boolean z, boolean z2, boolean z3);
}
