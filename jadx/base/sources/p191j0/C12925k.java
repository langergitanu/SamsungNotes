package p191j0;

import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: j0.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12925k implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f9071a = "";

    /* JADX INFO: renamed from: b */
    public int f9072b = 0;

    /* JADX INFO: renamed from: c */
    public float f9073c = 0.0f;

    /* JADX INFO: renamed from: d */
    public boolean f9074d = false;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12925k)) {
            return false;
        }
        C12925k c12925k = (C12925k) obj;
        if (this.f9071a.compareTo(c12925k.f9071a) != 0) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - latex[");
            sb.append(this.f9071a);
            sb.append(" - ");
            AbstractC4539a.m3209s(sb, c12925k.f9071a, "]", "WCon_ObjectPlot");
            return false;
        }
        if (this.f9072b != c12925k.f9072b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - color[");
            sb2.append(this.f9072b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12925k.f9072b, "]", "WCon_ObjectPlot", sb2);
            return false;
        }
        if (Float.compare(this.f9073c, c12925k.f9073c) != 0) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - lineWidth[");
            sb3.append(this.f9073c);
            sb3.append(" - ");
            AbstractC2821a.m2234y(sb3, c12925k.f9073c, "]", "WCon_ObjectPlot");
            return false;
        }
        if (this.f9074d != c12925k.f9074d) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - isShow[");
            sb4.append(this.f9074d);
            sb4.append(" - ");
            AbstractC11014a.m12339x(sb4, "]", "WCon_ObjectPlot", c12925k.f9074d);
        }
        return false;
    }
}
