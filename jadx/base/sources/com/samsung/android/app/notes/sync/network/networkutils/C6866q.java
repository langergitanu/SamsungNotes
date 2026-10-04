package com.samsung.android.app.notes.sync.network.networkutils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.InputStreamBody;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6866q extends InputStreamBody {

    /* JADX INFO: renamed from: a */
    public final int f4355a;

    public C6866q(InputStream inputStream, ContentType contentType, String str, int i) {
        super(inputStream, contentType, str);
        this.f4355a = i;
    }

    @Override // org.apache.http.entity.mime.content.InputStreamBody, org.apache.http.entity.mime.content.ContentBody
    public final void writeTo(OutputStream outputStream) throws IOException {
        C6867r c6867r = new C6867r();
        c6867r.f4358c = 0L;
        c6867r.f4359d = 0L;
        c6867r.f4356a = outputStream;
        c6867r.f4357b = this.f4355a;
        super.writeTo(c6867r);
    }
}
