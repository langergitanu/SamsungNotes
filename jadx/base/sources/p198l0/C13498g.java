package p198l0;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13498g extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public boolean f9478f;

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "bold";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9478f = ((ByteBuffer) c12020a.f8772b).get(iMo14270f) == 1;
        return (iMo14270f + 8) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        this.f9478f = ((C13498g) abstractC13495d).f9478f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        c12020a.m13646s(iMo14272i, this.f9478f ? 1 : 0);
        return (iMo14272i + 8) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13498g)) {
            return false;
        }
        C13498g c13498g = (C13498g) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_BoldSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9478f == c13498g.f9478f) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - isBold[");
        sb.append(this.f9478f);
        sb.append(" - ");
        AbstractC11014a.m12339x(sb, "]", "WCon_BoldSpan", c13498g.f9478f);
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
        return Boolean.toString(this.f9478f);
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        this.f9478f = Boolean.parseBoolean(str);
        return true;
    }
}
