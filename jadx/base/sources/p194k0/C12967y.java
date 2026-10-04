package p194k0;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.y */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12967y implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9297a;

    /* JADX INFO: renamed from: b */
    public long f9298b;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12967y)) {
            return false;
        }
        C12967y c12967y = (C12967y) obj;
        if (this.f9297a != c12967y.f9297a) {
            StringBuilder sb = new StringBuilder(" !! equals - NE - action[");
            sb.append(this.f9297a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12967y.f9297a, "]", "WCon_VoiceData", sb);
            return false;
        }
        if (this.f9298b == c12967y.f9298b) {
            return true;
        }
        Log.i("WCon_VoiceData", " !! equals - NE - timeStamp[" + this.f9298b + " - " + c12967y.f9298b + "]");
        return false;
    }
}
