package p198l0;

import android.util.Log;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import java.nio.ByteBuffer;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: l0.v */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13513v extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public float f9501d;

    public C13513v() {
        super(8);
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "spacingBefore";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9501d = ((ByteBuffer) c12020a.f8772b).getFloat(iMo14263f);
        return (iMo14263f + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        this.f9501d = ((C13513v) abstractC13493b).f9501d;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13648u(this.f9501d, iMo14265h);
        c12020a.m13649v(iMo14265h + 4, 0);
        return (iMo14265h + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: i */
    public final int mo14266i() {
        return 20;
    }

    @Override // p198l0.AbstractC13493b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13513v)) {
            return false;
        }
        C13513v c13513v = (C13513v) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_SpacingBeforeParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9501d == c13513v.f9501d) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - spacing[");
        sb.append(this.f9501d);
        sb.append(" - ");
        AbstractC2821a.m2234y(sb, c13513v.f9501d, "]", "WCon_SpacingBeforeParagraph");
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        return AbstractC1038a.m1217r(new StringBuilder(), "", this.f9501d);
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        this.f9501d = AbstractC14517a.m15121F(str);
        return true;
    }
}
