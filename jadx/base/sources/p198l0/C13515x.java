package p198l0;

import android.util.Log;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13515x extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public long f9503f;

    public C13515x() {
        super(19);
    }

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "timeStamp";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9503f = ((ByteBuffer) c12020a.f8772b).getLong(iMo14270f);
        return (iMo14270f + 8) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        this.f9503f = ((C13515x) abstractC13495d).f9503f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        ((ByteBuffer) c12020a.f8772b).putLong(iMo14272i, this.f9503f);
        return (iMo14272i + 8) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13515x)) {
            return false;
        }
        C13515x c13515x = (C13515x) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_TimeStampSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9503f == c13515x.f9503f) {
            return true;
        }
        Log.i("WCon_TimeStampSpan", " !! equals() - NE - timeStamp[" + this.f9503f + " - " + c13515x.f9503f + "]");
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
        return Long.toString(this.f9503f);
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        this.f9503f = Long.parseLong(str);
        return true;
    }
}
