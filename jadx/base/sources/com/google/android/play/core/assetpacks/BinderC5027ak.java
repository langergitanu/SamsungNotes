package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.AbstractBinderC5236t;
import com.google.android.play.core.tasks.C5345i;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ak */
/* JADX INFO: loaded from: classes5.dex */
class BinderC5027ak<T> extends AbstractBinderC5236t {

    /* JADX INFO: renamed from: a */
    final C5345i<T> f2547a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5034ar f2548b;

    public BinderC5027ak(C5034ar c5034ar, C5345i<T> c5345i) {
        this.f2548b = c5034ar;
        this.f2547a = c5345i;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public void mo3632a() {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onCancelDownloads()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: b */
    public void mo3638b() {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onRemoveModule()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: c */
    public void mo3642c(Bundle bundle) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: d */
    public void mo3644d(Bundle bundle) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }

    public BinderC5027ak(C5034ar c5034ar, C5345i c5345i, byte[] bArr) {
        this(c5034ar, c5345i);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public final void mo3633a(int i) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onCancelDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: b */
    public final void mo3639b(int i) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: c */
    public void mo3643c(Bundle bundle, Bundle bundle2) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onRequestDownloadInfo()", new Object[0]);
    }

    public BinderC5027ak(C5034ar c5034ar, C5345i c5345i, char[] cArr) {
        this(c5034ar, c5345i);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public void mo3634a(int i, Bundle bundle) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onStartDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: b */
    public void mo3640b(Bundle bundle) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    public BinderC5027ak(C5034ar c5034ar, C5345i c5345i, int[] iArr) {
        this(c5034ar, c5345i);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public void mo3635a(Bundle bundle) {
        this.f2548b.f2563e.m3896a();
        int i = bundle.getInt("error_code");
        C5034ar.f2559a.m3877b("onError(%d)", Integer.valueOf(i));
        this.f2547a.m4200b(new AssetPackException(i));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: b */
    public void mo3641b(Bundle bundle, Bundle bundle2) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onGetChunkFileDescriptor", new Object[0]);
    }

    public BinderC5027ak(C5034ar c5034ar, C5345i c5345i, short[] sArr) {
        this(c5034ar, c5345i);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public void mo3636a(Bundle bundle, Bundle bundle2) {
        this.f2548b.f2564f.m3896a();
        C5034ar.f2559a.m3878c("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: a */
    public void mo3637a(List<Bundle> list) {
        this.f2548b.f2563e.m3896a();
        C5034ar.f2559a.m3878c("onGetSessionStates", new Object[0]);
    }
}
