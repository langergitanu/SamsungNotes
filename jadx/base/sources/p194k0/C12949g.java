package p194k0;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12949g implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9170a = -16777216;

    /* JADX INFO: renamed from: b */
    public float f9171b = 1.0f;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12949g)) {
            return false;
        }
        C12949g c12949g = (C12949g) obj;
        if (this.f9170a != c12949g.f9170a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - color[");
            sb.append(this.f9170a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12949g.f9170a, "]", "WCon_LineColorEffect", sb);
            return false;
        }
        if (this.f9171b == c12949g.f9171b) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(" !! equals() - NE - position[");
        sb2.append(this.f9171b);
        sb2.append(" - ");
        AbstractC2821a.m2234y(sb2, c12949g.f9171b, "]", "WCon_LineColorEffect");
        return false;
    }
}
