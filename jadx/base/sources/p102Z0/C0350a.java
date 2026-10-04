package p102Z0;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: Z0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0350a {

    /* JADX INFO: renamed from: a */
    public String f873a;

    /* JADX INFO: renamed from: b */
    public String f874b;

    /* JADX INFO: renamed from: c */
    public long f875c;

    /* JADX INFO: renamed from: d */
    public long f876d;

    /* JADX INFO: renamed from: e */
    public ArrayList f877e;

    /* JADX INFO: renamed from: f */
    public String f878f;

    /* JADX INFO: renamed from: g */
    public boolean f879g;

    /* JADX INFO: renamed from: h */
    public String f880h;

    /* JADX INFO: renamed from: i */
    public ArrayList f881i;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0350a)) {
            return false;
        }
        C0350a c0350a = (C0350a) obj;
        return Intrinsics.areEqual(this.f873a, c0350a.f873a) && Intrinsics.areEqual(this.f874b, c0350a.f874b) && this.f875c == c0350a.f875c && this.f876d == c0350a.f876d && Intrinsics.areEqual(this.f877e, c0350a.f877e) && Intrinsics.areEqual(this.f878f, c0350a.f878f) && this.f879g == c0350a.f879g && Intrinsics.areEqual(this.f880h, c0350a.f880h) && Intrinsics.areEqual(this.f881i, c0350a.f881i);
    }

    public final int hashCode() {
        int iHashCode = (this.f877e.hashCode() + AbstractC1974b.m1311d(this.f876d, AbstractC1974b.m1311d(this.f875c, AbstractC1038a.m1202c(this.f873a.hashCode() * 31, 31, this.f874b), 31), 31)) * 31;
        String str = this.f878f;
        return this.f881i.hashCode() + AbstractC1038a.m1202c(AbstractC0622a.m1160f(this.f879g, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31, this.f880h);
    }

    public final String toString() {
        String str = this.f873a;
        String str2 = this.f874b;
        long j = this.f875c;
        long j2 = this.f876d;
        ArrayList arrayList = this.f877e;
        String str3 = this.f878f;
        boolean z = this.f879g;
        String str4 = this.f880h;
        ArrayList arrayList2 = this.f881i;
        StringBuilder sbM16m = AbstractC0000a.m16m("MetaMessage(uuid=", str, ", title=", str2, ", createdAt=");
        sbM16m.append(j);
        AbstractC1038a.m1223x(sbM16m, ", modifiedAt=", j2, ", tags=");
        sbM16m.append(arrayList);
        sbM16m.append(", folderPath=");
        sbM16m.append(str3);
        sbM16m.append(", cloudSynced=");
        sbM16m.append(z);
        sbM16m.append(", markdownPath=");
        sbM16m.append(str4);
        sbM16m.append(", attachments=");
        sbM16m.append(arrayList2);
        sbM16m.append(")");
        return sbM16m.toString();
    }
}
