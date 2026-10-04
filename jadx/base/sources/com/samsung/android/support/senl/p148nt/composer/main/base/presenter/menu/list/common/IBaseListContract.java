package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IBaseListContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void hide();

        boolean hideSoftInput(View view);

        void ignoreInputEvent(boolean z);

        boolean isShowing();

        boolean onBackPressed();

        void onConfigurationChanged(Configuration configuration);

        void onDetachView();

        boolean onKeyEvent(int i);

        void release();

        void show(Activity activity);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISearchPresenter {
        void minimizeSoftInput(View view);

        void onNavigateUpClicked();

        void onSearchCleared();

        void search(String str);

        void showSoftInput(View view);

        void submitSearchKeyword(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void hide();

        void ignoreInputEvent(boolean z);

        boolean isShowing();

        boolean onBackPressed();

        void onConfigurationChanged(Configuration configuration);

        void show();
    }
}
