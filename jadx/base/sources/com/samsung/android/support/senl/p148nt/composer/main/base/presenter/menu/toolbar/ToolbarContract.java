package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ToolbarContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void clearSelectedButtonsOfHandWritingToolbarItem();

        void close();

        SpenPreTouchListenerImpl.PreTouchListener getPreTouchListener();

        View getToolbarView();

        void hide(boolean z);

        boolean isToolbarShowing();

        void onClickHwToggleFab();

        void setEnableToolTip(boolean z);

        void show(boolean z);
    }
}
