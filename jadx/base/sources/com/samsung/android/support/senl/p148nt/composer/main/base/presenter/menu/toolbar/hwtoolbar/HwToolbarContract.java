package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface HwToolbarContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void callOnSelected(int i);

        void dismissSmartTip();

        void executeAiAssist();

        void executePenSetting();

        void executeRemoteEraser();

        View getToolbarView();

        void hide();

        void hidePopupsWithSpoid();

        void hideSettingPenMini();

        boolean isSelected(int i);

        boolean isShowing();

        void offEasyWritingPad();

        void onItemSelected(int i);

        void onNoteAssistClick(Runnable runnable);

        void onSaveInstanceState(@NonNull Bundle bundle);

        boolean onTouchOutside();

        void reboundSettingPenMiniVI();

        void restore(Bundle bundle);

        void setColorTheme(int i);

        void setQtHwToolbarStateListener(QtHwToolbarStateListener qtHwToolbarStateListener);

        void show();

        void showSettingPenMini();

        void showSettingPopupOfLaserPen(boolean z, View.OnClickListener onClickListener);

        void toggleZoomLock();

        void unselect(int i);

        void updateBackgroundColor(int i, boolean z, boolean z2);

        void updateDeleteOnlyState(boolean z);

        void updateMoveOnlyState(boolean z);

        void updatePolicy(int i, boolean z);

        void updateRemoteFavoritePen(boolean z, int i);

        void updateSelectionState(int i, boolean z, boolean z2);

        void updateToolbarItemList();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface QtHwToolbarStateListener {
        void notifyToUpdateInfo();

        void onConfigurationChanged();

        void onEyeDropperChanged();

        void onFocusStickyMemo(boolean z);

        void onPreClick(int i);

        void onShownSettingViewsChange(@NotNull Map<Integer, Integer> map);
    }
}
