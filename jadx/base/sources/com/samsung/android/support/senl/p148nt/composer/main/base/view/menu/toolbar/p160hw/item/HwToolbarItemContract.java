package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface HwToolbarItemContract {
    void clearAllToolbarItem(int... iArr);

    void clearContextMenu();

    void doActionAfterDismissKeyguard(@NonNull Runnable runnable);

    int getColorTheme(int i);

    /* JADX INFO: renamed from: getHwSettingViewManager */
    HwSettingViewManager getMInAppSettingViewManager();

    HwToolbarPresenterImpl getHwToolbarPresenter();

    HwSettingPresenter getSettingInstance();

    WritingToolManager getWritingToolManager();

    boolean hide();

    boolean isDirectWriteUsing();

    boolean isSelected(int i);

    boolean isTextMode();

    void onItemClickSALogging(int i);

    boolean onPreClick(int i);

    void onSelected(int i);

    void onSelected(int i, boolean z);

    void setMenuDirty();

    void setSolveMathEnabled(boolean z);

    void showAiAssistMenu(View view);

    void toolbarMovePosition(View view);

    void updateHighlighterSettingInfo();

    void updateLastPenTypeSelectionState();

    void updateLastPrimitiveTypeSelectionState();

    void updatePenSettingInfo();

    void updatePolicy(int i, boolean z);

    void updateQuickColor(int i);

    void updateQuickSize(int i);

    void updateStateSelected(int i, boolean z);

    void updateToolbarItemList();
}
