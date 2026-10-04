package p007B0;

import androidx.glance.AbstractC2821a;
import p182g0.C11991a;

/* JADX INFO: renamed from: B0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0019b {

    /* JADX INFO: renamed from: a */
    public String f99a;

    /* JADX INFO: renamed from: b */
    public String f100b;

    /* JADX INFO: renamed from: c */
    public long f101c;

    /* JADX INFO: renamed from: d */
    public String f102d;

    /* JADX INFO: renamed from: e */
    public String f103e;

    /* JADX INFO: renamed from: f */
    public String f104f;

    /* JADX INFO: renamed from: g */
    public C11991a f105g;

    /* JADX INFO: renamed from: h */
    public String f106h;

    /* JADX INFO: renamed from: i */
    public String f107i;

    /* JADX INFO: renamed from: j */
    public int f108j;

    /* JADX INFO: renamed from: k */
    public boolean f109k;

    public final String toString() {
        StringBuilder sb = new StringBuilder("FileInfo[hash = ");
        sb.append(this.f99a);
        sb.append(", contentType = ");
        sb.append(this.f100b);
        sb.append(", size = ");
        sb.append(this.f101c);
        sb.append(", validationKey = ");
        sb.append(this.f102d);
        sb.append(", filePath = ");
        sb.append(this.f103e);
        sb.append(", uploadUrl = ");
        sb.append(this.f104f);
        sb.append(", uploadSuccess = ");
        sb.append(this.f109k);
        sb.append(", state = ");
        sb.append(this.f106h);
        sb.append(", failReason = ");
        sb.append(this.f107i);
        sb.append(", statusCode = ");
        return AbstractC2821a.m2223n(sb, "]", this.f108j);
    }
}
