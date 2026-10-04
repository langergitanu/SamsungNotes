package p198l0;

import android.text.TextUtils;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import p185h0.InterfaceC12016a;
import p185h0.InterfaceC12017b;
import p191j0.AbstractC12916b;

/* JADX INFO: renamed from: l0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13492a implements InterfaceC12016a, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public AbstractC12916b f9460a = null;

    /* JADX INFO: renamed from: b */
    public String f9461b = null;

    /* JADX INFO: renamed from: c */
    public int f9462c = 0;

    /* JADX INFO: renamed from: d */
    public int f9463d = 0;

    /* JADX INFO: renamed from: e */
    public int f9464e = 0;

    /* JADX INFO: renamed from: f */
    public int f9465f = 0;

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "objectSpan";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: b */
    public final String mo13616b() {
        return "objectSpan";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: c */
    public final boolean mo13617c(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 3) {
            this.f9461b = strArrSplit[0];
            this.f9464e = Integer.parseInt(strArrSplit[1]);
            this.f9465f = Integer.parseInt(strArrSplit[2]);
            return true;
        }
        if (strArrSplit.length != 1) {
            Log.e("WCon_ TextObjectSpan", "applyProperty fail.");
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        int iIndexOf = sb.indexOf(",");
        if (iIndexOf == -1) {
            this.f9461b = str;
        } else {
            this.f9461b = sb.substring(0, iIndexOf);
        }
        return true;
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: d */
    public final String mo13618d() {
        return "'objectSpan/objectSpan'";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: e */
    public final String mo13619e() {
        StringBuilder sb = new StringBuilder("'objectSpan/objectSpan'='");
        sb.append(this.f9461b);
        sb.append(",");
        sb.append(this.f9464e);
        sb.append(",");
        return AbstractC2821a.m2223n(sb, "'", this.f9465f);
    }

    @Override // p185h0.InterfaceC12016a
    public final int end() {
        return this.f9463d;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (!(obj instanceof C13492a)) {
            return false;
        }
        C13492a c13492a = (C13492a) obj;
        if (this == c13492a) {
            return true;
        }
        if (this.f9462c == c13492a.f9462c && this.f9463d == c13492a.f9463d && this.f9464e == c13492a.f9464e && this.f9465f == c13492a.f9465f) {
            return TextUtils.equals(this.f9461b, c13492a.f9461b);
        }
        return false;
    }

    @Override // p185h0.InterfaceC12016a
    public final int start() {
        return this.f9462c;
    }

    @Override // p185h0.InterfaceC12016a
    public final void end(int i) {
        this.f9463d = i;
    }

    @Override // p185h0.InterfaceC12016a
    public final void start(int i) {
        this.f9462c = i;
    }
}
