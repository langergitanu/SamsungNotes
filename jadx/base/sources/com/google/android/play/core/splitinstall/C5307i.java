package com.google.android.play.core.splitinstall;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.i */
/* JADX INFO: loaded from: classes5.dex */
final class C5307i implements SplitInstallManager {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5215cj<C5333w> f3126a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC5215cj<FakeSplitInstallManager> f3127b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5215cj<File> f3128c;

    public C5307i(InterfaceC5215cj<C5333w> interfaceC5215cj, InterfaceC5215cj<FakeSplitInstallManager> interfaceC5215cj2, InterfaceC5215cj<File> interfaceC5215cj3) {
        this.f3126a = interfaceC5215cj;
        this.f3127b = interfaceC5215cj2;
        this.f3128c = interfaceC5215cj3;
    }

    /* JADX INFO: renamed from: a */
    private final SplitInstallManager m4138a() {
        return (SplitInstallManager) (this.f3128c.m3979a() == null ? this.f3126a : this.f3127b).m3979a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<Void> cancelInstall(int i) {
        return m4138a().cancelInstall(i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<Void> deferredInstall(List<String> list) {
        return m4138a().deferredInstall(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return m4138a().deferredLanguageInstall(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return m4138a().deferredLanguageUninstall(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<Void> deferredUninstall(List<String> list) {
        return m4138a().deferredUninstall(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Set<String> getInstalledLanguages() {
        return m4138a().getInstalledLanguages();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Set<String> getInstalledModules() {
        return m4138a().getInstalledModules();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return m4138a().getSessionState(i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    @NonNull
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return m4138a().getSessionStates();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void registerListener(@NonNull SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m4138a().registerListener(splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(@NonNull SplitInstallSessionState splitInstallSessionState, @NonNull Activity activity, int i) {
        return m4138a().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Integer> startInstall(@NonNull SplitInstallRequest splitInstallRequest) {
        return m4138a().startInstall(splitInstallRequest);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final void unregisterListener(@NonNull SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m4138a().unregisterListener(splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(@NonNull SplitInstallSessionState splitInstallSessionState, @NonNull IntentSenderForResultStarter intentSenderForResultStarter, int i) {
        return m4138a().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }
}
