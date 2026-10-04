package p182g0;

import android.text.TextUtils;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: g0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11996f implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f8636a;

    /* JADX INFO: renamed from: b */
    public String f8637b;

    /* JADX INFO: renamed from: c */
    public String f8638c;

    /* JADX INFO: renamed from: d */
    public int f8639d;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11996f) {
            C11996f c11996f = (C11996f) obj;
            if (equals(obj) && TextUtils.equals(this.f8636a, c11996f.f8636a) && TextUtils.equals(this.f8637b, c11996f.f8637b) && TextUtils.equals(this.f8638c, c11996f.f8638c) && this.f8639d == c11996f.f8639d) {
                return true;
            }
        }
        return false;
    }
}
