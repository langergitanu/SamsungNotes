package p198l0;

import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13510s extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public boolean f9497d;

    public C13510s() {
        super(6);
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "parsingState";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9497d = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f) == 1;
        return (iMo14263f + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        this.f9497d = ((C13510s) abstractC13493b).f9497d;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13649v(iMo14265h, this.f9497d ? 1 : 0);
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
        if (!(obj instanceof C13510s)) {
            return false;
        }
        C13510s c13510s = (C13510s) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ParsingStParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9497d == c13510s.f9497d) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - isParsed[");
        sb.append(this.f9497d);
        sb.append(" - ");
        AbstractC11014a.m12339x(sb, "]", "WCon_ParsingStParagraph", c13510s.f9497d);
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        return Boolean.toString(this.f9497d);
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        this.f9497d = Boolean.parseBoolean(str);
        return true;
    }
}
