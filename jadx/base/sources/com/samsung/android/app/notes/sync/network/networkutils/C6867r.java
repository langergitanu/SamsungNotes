package com.samsung.android.app.notes.sync.network.networkutils;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6867r extends OutputStream {

    /* JADX INFO: renamed from: a */
    public OutputStream f4356a;

    /* JADX INFO: renamed from: b */
    public long f4357b;

    /* JADX INFO: renamed from: c */
    public long f4358c;

    /* JADX INFO: renamed from: d */
    public long f4359d;

    /* JADX INFO: renamed from: b */
    public final void m5051b() {
        long j = this.f4357b;
        if (j != 0) {
            if (this.f4358c >= j || ((int) (r2 / 65536)) > this.f4359d) {
                Debugger.m8616s("UploadOutputStream", "Upload transferred " + this.f4358c + "/" + j);
            }
            this.f4359d = this.f4358c / 65536;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f4356a.write(bArr);
        this.f4358c += (long) bArr.length;
        m5051b();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.f4356a.write(bArr, i, i2);
        this.f4358c += (long) i2;
        m5051b();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f4356a.write(i);
        this.f4358c++;
        m5051b();
    }
}
