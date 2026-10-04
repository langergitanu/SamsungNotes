package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.IBaseListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface PageListContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IContainerPresenter {
        void hide(boolean z);

        void show(boolean z);

        void updateTemplateResult(Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPageHolder {
        String getPageId();

        void setPageIndexText(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter extends IBaseListContract.IPresenter {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView extends PageListModeContract.IView {
        void clearPageFocus();

        void clearRecyclerViewPool();

        void clearThumbnail();

        int getSpanCount();

        View getView();

        boolean hasSearchFieldFocus();

        void hideSearchMode(boolean z);

        void init();

        void initAdapter(IPageList iPageList, int i, int i2);

        boolean isComputingLayout();

        boolean onKeyEvent(int i, KeyEvent keyEvent);

        boolean onRequestSearchMode();

        void setBottomNavigationButtonEnabled(boolean z);

        void setDisableAddPage(boolean z);

        void setPageBackgroundColor(int i);

        void startLongPressMultiSelection(int i);

        void updateSearchButtonVisibility(boolean z);
    }
}
