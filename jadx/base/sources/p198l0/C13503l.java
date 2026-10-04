package p198l0;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13503l extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public String f9486f;

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "fontName";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        int i2 = iMo14270f + 8;
        String strM13644q = c12020a.m13644q(iMo14270f + 10, c12020a.m13637j(i2));
        this.f9486f = strM13644q;
        return (C12020a.m13621f(strM13644q) + i2) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        this.f9486f = ((C13503l) abstractC13495d).f9486f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i + 8;
        return (c12020a.m13624C(iMo14272i, this.f9486f) + iMo14272i) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13503l)) {
            return false;
        }
        C13503l c13503l = (C13503l) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_FontNameSpan", " !! equals() - NE - super check");
            return false;
        }
        if (TextUtils.equals(this.f9486f, c13503l.f9486f)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - mName[");
        sb.append(this.f9486f);
        sb.append(" - ");
        AbstractC4539a.m3209s(sb, c13503l.f9486f, "]", "WCon_FontNameSpan");
        return false;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: j */
    public final int mo14273j() {
        return this.f9486f.getBytes().length + 26;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: l */
    public final String mo14275l() {
        return this.f9486f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        this.f9486f = str;
        return true;
    }
}
