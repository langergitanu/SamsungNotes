package com.samsung.android.app.notes.sync.network.networkutils;

import android.content.Context;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.http.Header;
import p020E.C0073a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6863n {

    /* JADX INFO: renamed from: a */
    public int f4333a;

    /* JADX INFO: renamed from: b */
    public HashMap f4334b;

    /* JADX INFO: renamed from: c */
    public String f4335c;

    /* JADX INFO: renamed from: d */
    public InputStream f4336d;

    /* JADX INFO: renamed from: e */
    public String f4337e;

    /* JADX INFO: renamed from: f */
    public String f4338f;

    /* JADX INFO: renamed from: g */
    public Context f4339g;

    /* JADX INFO: renamed from: h */
    public String f4340h;

    /* JADX INFO: renamed from: i */
    public C0073a f4341i;

    /* JADX INFO: renamed from: j */
    public String f4342j;

    /* JADX INFO: renamed from: k */
    public InterfaceC6855f f4343k;

    /* JADX INFO: renamed from: a */
    public final C6865p m5045a() {
        C6865p c6865p = new C6865p();
        c6865p.f4347d = this.f4336d;
        c6865p.f4348e = this.f4338f;
        c6865p.f4345b = this.f4334b;
        c6865p.f4344a = this.f4333a;
        c6865p.f4346c = this.f4335c;
        c6865p.f4354k = this.f4341i;
        c6865p.f4349f = this.f4342j;
        c6865p.f4351h = this.f4339g;
        c6865p.f4352i = this.f4343k;
        c6865p.f4350g = this.f4337e;
        c6865p.f4353j = this.f4340h;
        return c6865p;
    }

    /* JADX INFO: renamed from: b */
    public final void m5046b(Header[] headerArr) {
        if (this.f4334b == null) {
            this.f4334b = new HashMap();
        }
        if (headerArr != null) {
            for (Header header : headerArr) {
                this.f4334b.put(header.getName(), header.getValue());
            }
        }
    }
}
