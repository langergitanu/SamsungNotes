package p194k0;

import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12961s implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public final int f9253a;

    /* JADX INFO: renamed from: b */
    public final float f9254b;

    public C12961s(int i, float f) {
        this.f9253a = i;
        this.f9254b = f;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C12961s.class == obj.getClass()) {
            C12961s c12961s = (C12961s) obj;
            if (this.f9253a == c12961s.f9253a && Float.compare(this.f9254b, c12961s.f9254b) == 0) {
                return true;
            }
        }
        return false;
    }
}
