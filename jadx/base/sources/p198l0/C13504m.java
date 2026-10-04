package p198l0;

import android.util.Log;
import androidx.glance.AbstractC2821a;
import java.nio.ByteBuffer;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: l0.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13504m extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public float f9487f;

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "fontSize";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9487f = ((ByteBuffer) c12020a.f8772b).getFloat(iMo14270f);
        return (iMo14270f + 8) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        this.f9487f = ((C13504m) abstractC13495d).f9487f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        c12020a.m13648u(this.f9487f, iMo14272i);
        c12020a.m13649v(iMo14272i + 4, 0);
        return (iMo14272i + 8) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13504m)) {
            return false;
        }
        C13504m c13504m = (C13504m) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_FontSizeSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9487f == c13504m.f9487f) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - mSize[");
        sb.append(this.f9487f);
        sb.append(" - ");
        AbstractC2821a.m2234y(sb, c13504m.f9487f, "]", "WCon_FontSizeSpan");
        return false;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: j */
    public final int mo14273j() {
        return 24;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: l */
    public final String mo14275l() {
        return Float.toString(this.f9487f);
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        this.f9487f = AbstractC14517a.m15121F(str);
        return true;
    }
}
