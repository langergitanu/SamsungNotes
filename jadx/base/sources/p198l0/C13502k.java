package p198l0;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13502k extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public boolean f9485f;

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return null;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9485f = ((ByteBuffer) c12020a.f8772b).get(iMo14270f) == 1;
        return (iMo14270f + 8) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        c12020a.m13646s(iMo14272i, this.f9485f ? 1 : 0);
        return (iMo14272i + 8) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13502k)) {
            return false;
        }
        C13502k c13502k = (C13502k) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ComposingTagSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9485f == c13502k.f9485f) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - isComposingTag[");
        sb.append(this.f9485f);
        sb.append(" - ");
        AbstractC11014a.m12339x(sb, "]", "WCon_ComposingTagSpan", c13502k.f9485f);
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
        return null;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        return true;
    }
}
