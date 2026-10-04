package p194k0;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12944b implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9144a;

    /* JADX INFO: renamed from: b */
    public float f9145b;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12944b)) {
            return false;
        }
        C12944b c12944b = (C12944b) obj;
        if (this.f9144a != c12944b.f9144a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - color[");
            sb.append(this.f9144a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12944b.f9144a, "]", "WCon_FillColorEffect", sb);
            return false;
        }
        if (this.f9145b == c12944b.f9145b) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(" !! equals() - NE - position[");
        sb2.append(this.f9145b);
        sb2.append(" - ");
        AbstractC2821a.m2234y(sb2, c12944b.f9145b, "]", "WCon_FillColorEffect");
        return false;
    }
}
