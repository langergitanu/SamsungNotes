package com.samsung.android.app.notes.sync.network.networkutils;

import com.samsung.android.app.notes.sync.error.SyncException;
import org.apache.http.Header;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C6860k implements InterfaceC6852c {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6862m f4299a;

    /* JADX INFO: renamed from: c */
    public final void m5030c(int i, Header[] headerArr, String str) throws SyncException {
        C6862m c6862m = this.f4299a;
        C6863n c6863nM5039a = c6862m.m5039a();
        c6863nM5039a.f4333a = i;
        c6863nM5039a.m5046b(headerArr);
        c6863nM5039a.f4335c = str;
        C6865p c6865pM5045a = c6863nM5039a.m5045a();
        c6865pM5045a.m5050d();
        c6862m.f4327m = c6865pM5045a;
    }
}
