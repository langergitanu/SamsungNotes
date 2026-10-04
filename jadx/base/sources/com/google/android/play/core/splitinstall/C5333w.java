package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.w */
/* JADX INFO: loaded from: classes5.dex */
final class C5333w implements SplitInstallManager {

    /* JADX INFO: renamed from: a */
    private final C5295av f3206a;

    /* JADX INFO: renamed from: b */
    private final C5319t f3207b;

    /* JADX INFO: renamed from: c */
    private final C5315p f3208c;

    /* JADX INFO: renamed from: d */
    private final C5297ax f3209d;

    /* JADX INFO: renamed from: e */
    private final Handler f3210e = new Handler(Looper.getMainLooper());

    public C5333w(C5295av c5295av, C5319t c5319t, C5315p c5315p, C5297ax c5297ax) {
        this.f3206a = c5295av;
        this.f3207b = c5319t;
        this.f3208c = c5315p;
        this.f3209d = c5297ax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static List<String> m4179b(List<Locale> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Locale> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toLanguageTag());
        }
        return arrayList;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> cancelInstall(int i) {
        return this.f3206a.m4117b(i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredInstall(List<String> list) {
        return this.f3206a.m4118b(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return this.f3206a.m4119c(m4179b(list));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return this.f3206a.m4120d(m4179b(list));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<Void> deferredUninstall(List<String> list) {
        this.f3209d.m4123a(list);
        return this.f3206a.m4116a(list);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledLanguages() {
        Set<String> setM4149b = this.f3208c.m4149b();
        return setM4149b == null ? Collections.EMPTY_SET : setM4149b;
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set<String> getInstalledModules() {
        return this.f3208c.m4148a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return this.f3206a.m4114a(i);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return this.f3206a.m4113a();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f3207b.m4033a((StateUpdatedListener) splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) {
        return startConfirmationDialogForResult(splitInstallSessionState, new C5332v(activity), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        splitInstallRequest.getLanguages().isEmpty();
        List<Locale> languages = splitInstallRequest.getLanguages();
        Set<String> setM4149b = this.f3208c.m4149b();
        if (setM4149b == null) {
            if (getInstalledModules().containsAll(splitInstallRequest.getModuleNames()) && Collections.disjoint(splitInstallRequest.getModuleNames(), this.f3209d.m4122a())) {
                this.f3210e.post(new RunnableC5331u(this, splitInstallRequest));
                return Tasks.m4185a(0);
            }
        } else {
            HashSet hashSet = new HashSet();
            Iterator<Locale> it = languages.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getLanguage());
            }
            if (setM4149b.containsAll(hashSet)) {
            }
        }
        return this.f3206a.m4115a(splitInstallRequest.getModuleNames(), m4179b(splitInstallRequest.getLanguages()));
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f3207b.m4036b(splitInstallStateUpdatedListener);
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) {
        if (splitInstallSessionState.status() != 8 || splitInstallSessionState.resolutionIntent() == null) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(splitInstallSessionState.resolutionIntent().getIntentSender(), i, null, 0, 0, 0, null);
        return true;
    }
}
