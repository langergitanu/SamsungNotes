package p198l0;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13497f extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public int f9477f;

    public C13497f() {
        super(17);
        this.f9477f = 0;
    }

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "backgroundColor";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9477f = ((ByteBuffer) c12020a.f8772b).getInt(iMo14270f);
        return (iMo14270f + 8) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        this.f9477f = ((C13497f) abstractC13495d).f9477f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        c12020a.m13649v(iMo14272i, this.f9477f);
        c12020a.m13649v(iMo14272i + 4, 0);
        return (iMo14272i + 8) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13497f)) {
            return false;
        }
        C13497f c13497f = (C13497f) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_BgColorSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9477f == c13497f.f9477f) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - mColor[");
        sb.append(this.f9477f);
        sb.append(" - ");
        AbstractC11014a.m12329n(c13497f.f9477f, "]", "WCon_BgColorSpan", sb);
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
        return Integer.toString(this.f9477f);
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        this.f9477f = Integer.parseInt(str);
        return true;
    }
}
