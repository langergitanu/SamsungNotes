package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface SearchModeContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        View getView();

        boolean hasFocusSearchText();

        void hide();

        boolean isShowing();

        boolean isStatusBarHidden();

        void release();

        void setColorTheme(int i, boolean z, boolean z2);

        void setSearchText(String str);

        void show(String str);

        void updateMoveButton(boolean z, boolean z2);
    }
}
