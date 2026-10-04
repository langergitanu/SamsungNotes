package p198l0;

import android.util.Log;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocAlignmentParagraph$Align;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13496e extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public int f9476d;

    public C13496e() {
        super(3);
        this.f9476d = WDocAlignmentParagraph$Align.ALIGN_LEFT.ordinal();
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "alignment";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9476d = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f);
        return (iMo14263f + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        this.f9476d = ((C13496e) abstractC13493b).f9476d;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13649v(iMo14265h, this.f9476d);
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
        if (!(obj instanceof C13496e)) {
            return false;
        }
        C13496e c13496e = (C13496e) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_AlignmentParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9476d == c13496e.f9476d) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - mAlignmentType[");
        sb.append(this.f9476d);
        sb.append(" - ");
        AbstractC11014a.m12329n(c13496e.f9476d, "]", "WCon_AlignmentParagraph", sb);
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        return Integer.toString(this.f9476d);
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        this.f9476d = Integer.parseInt(str);
        return true;
    }
}
