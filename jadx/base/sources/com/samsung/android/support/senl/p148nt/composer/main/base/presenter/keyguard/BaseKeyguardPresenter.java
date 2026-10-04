package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.keyguard;

import android.app.Activity;
import android.app.KeyguardManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseKeyguardPresenter implements KeyguardPresenter {
    private static final String TAG = "BaseKeyguardPresenter";
    protected ComposerSaveModel mSaveModel;
    private final List<KeyguardPresenter.Observer> mObservers = new ArrayList();
    protected boolean mIsInitialLockDismissed = true;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter
    public void addObserver(@NonNull KeyguardPresenter.Observer observer) {
        Logger.m10999d(TAG, "addObserver");
        this.mObservers.add(observer);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter
    public void dismissKeyguard(@Nullable Activity activity, @NonNull final Runnable runnable) {
        if (this.mIsInitialLockDismissed) {
            runnable.run();
        } else {
            KeyguardManagerCompat.INSTANCE.getInstance().requestDismissKeyguard(activity, new KeyguardManager.KeyguardDismissCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.keyguard.BaseKeyguardPresenter.1
                @Override // android.app.KeyguardManager.KeyguardDismissCallback
                public void onDismissSucceeded() {
                    BaseKeyguardPresenter.this.onLockDismissed();
                    runnable.run();
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter
    public void init(@NonNull ComposerSaveModel composerSaveModel) {
        this.mSaveModel = composerSaveModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter
    public boolean isInitialLockDismissed() {
        return this.mIsInitialLockDismissed;
    }

    public void onLockDismissed() {
        this.mIsInitialLockDismissed = true;
        Iterator it = new ArrayList(this.mObservers).iterator();
        while (it.hasNext()) {
            ((KeyguardPresenter.Observer) it.next()).onDismissed();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter
    public void removeObserver(@NonNull KeyguardPresenter.Observer observer) {
        Logger.m10999d(TAG, "removeObserver");
        this.mObservers.remove(observer);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter
    public void updateStatus(Activity activity) {
        if (this.mIsInitialLockDismissed || KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(activity, true)) {
            return;
        }
        onLockDismissed();
    }
}
