package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import androidx.annotation.AnyThread;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface LiveSharingContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        @AnyThread
        void onLiveSharingDisconnected();
    }

    boolean isLiveSharingNote();

    void setListener(Listener listener);
}
