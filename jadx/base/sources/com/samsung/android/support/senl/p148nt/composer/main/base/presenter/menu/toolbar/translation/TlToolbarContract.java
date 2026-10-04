package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface TlToolbarContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void addPendingActionAfterInflate(Runnable runnable);

        View getContainer();

        boolean isInflated();

        void onSaveInstanceState(@NonNull Bundle bundle);

        void restore(Bundle bundle);

        void show();
    }
}
