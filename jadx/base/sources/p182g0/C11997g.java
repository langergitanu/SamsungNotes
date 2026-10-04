package p182g0;

import java.util.HashMap;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: g0.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11997g implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public final HashMap f8640a = new HashMap();

    /* JADX INFO: renamed from: b */
    public final HashMap f8641b = new HashMap();

    /* JADX INFO: renamed from: c */
    public int f8642c = 0;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11997g) {
            C11997g c11997g = (C11997g) obj;
            if (this.f8642c == c11997g.f8642c && AbstractC0299q.m633i(this.f8640a, c11997g.f8640a) && AbstractC0299q.m633i(this.f8641b, c11997g.f8641b)) {
                return true;
            }
        }
        return false;
    }
}
