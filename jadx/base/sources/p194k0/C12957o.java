package p194k0;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12957o implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9235a;

    /* JADX INFO: renamed from: b */
    public float f9236b;

    /* JADX INFO: renamed from: c */
    public float f9237c;

    /* JADX INFO: renamed from: d */
    public float f9238d;

    /* JADX INFO: renamed from: e */
    public float f9239e;

    /* JADX INFO: renamed from: f */
    public float f9240f;

    /* JADX INFO: renamed from: g */
    public float f9241g;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12957o)) {
            return false;
        }
        C12957o c12957o = (C12957o) obj;
        if (this.f9235a != c12957o.f9235a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f9235a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12957o.f9235a, "]", "WCon_Path", sb);
            return false;
        }
        if (this.f9236b != c12957o.f9236b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - x[");
            sb2.append(this.f9236b);
            sb2.append(" - ");
            AbstractC2821a.m2234y(sb2, c12957o.f9236b, "]", "WCon_Path");
            return false;
        }
        if (this.f9237c != c12957o.f9237c) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - y[");
            sb3.append(this.f9237c);
            sb3.append(" - ");
            AbstractC2821a.m2234y(sb3, c12957o.f9237c, "]", "WCon_Path");
            return false;
        }
        if (this.f9238d != c12957o.f9238d) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - x1[");
            sb4.append(this.f9238d);
            sb4.append(" - ");
            AbstractC2821a.m2234y(sb4, c12957o.f9238d, "]", "WCon_Path");
            return false;
        }
        if (this.f9239e != c12957o.f9239e) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - y1[");
            sb5.append(this.f9239e);
            sb5.append(" - ");
            AbstractC2821a.m2234y(sb5, c12957o.f9239e, "]", "WCon_Path");
            return false;
        }
        if (this.f9240f != c12957o.f9240f) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - x2[");
            sb6.append(this.f9240f);
            sb6.append(" - ");
            AbstractC2821a.m2234y(sb6, c12957o.f9240f, "]", "WCon_Path");
            return false;
        }
        if (this.f9241g == c12957o.f9241g) {
            return true;
        }
        StringBuilder sb7 = new StringBuilder(" !! equals() - NE - y2[");
        sb7.append(this.f9241g);
        sb7.append(" - ");
        AbstractC2821a.m2234y(sb7, c12957o.f9241g, "]", "WCon_Path");
        return false;
    }
}
