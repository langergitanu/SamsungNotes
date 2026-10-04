package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import android.view.View;
import android.widget.EditText;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.IBaseListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface PageListModeContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView extends IBaseListContract.IView {
        IPageAdapter getAdapter();

        View getKeyboardTargetView();

        EditText getPageSearchEditView();

        void notifyCurrentPageIndexChanged(int i, boolean z, boolean z2);

        void onModeChanged(int i, int i2);

        void onModeChangedPost(int i, int i2);

        void onSelectedPageUpdated(int i, int i2);

        void onToggleCheckBox(int i);

        void updateNoBookmarkView(boolean z);

        void updateNoResultView(boolean z);

        void updatePageCountInfo();

        void updatePageCountInfo(int i);

        void updateScrollbar(int i);
    }
}
