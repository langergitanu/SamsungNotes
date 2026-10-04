package com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface KeyguardPresenter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Observer {
        void onDismissed();
    }

    void addObserver(@NonNull Observer observer);

    void dismissKeyguard(@Nullable Activity activity, @NonNull Runnable runnable);

    void init(@NonNull ComposerSaveModel composerSaveModel);

    boolean isInitialLockDismissed();

    void removeObserver(@NonNull Observer observer);

    void updateStatus(Activity activity);
}
