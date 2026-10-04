package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void finish(boolean z);

        View getRootView();

        int getTotalHeight();

        boolean isMultiWindowMode();

        void onApply();

        void showProgressDialog();
    }
}
