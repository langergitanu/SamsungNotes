package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.u */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5331u implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SplitInstallRequest f3203a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5333w f3204b;

    public RunnableC5331u(C5333w c5333w, SplitInstallRequest splitInstallRequest) {
        this.f3204b = c5333w;
        this.f3203a = splitInstallRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C5319t c5319t = this.f3204b.f3207b;
        List<String> moduleNames = this.f3203a.getModuleNames();
        List listM4179b = C5333w.m4179b(this.f3203a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(moduleNames));
        }
        if (!listM4179b.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(listM4179b));
        }
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        c5319t.m4034a(SplitInstallSessionState.m4103a(bundle));
    }
}
