package p198l0;

import android.util.Log;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocIndentLevelParagraph$Direction;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13507p extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public int f9492d;

    /* JADX INFO: renamed from: e */
    public int f9493e;

    public C13507p() {
        super(2);
        this.f9492d = WDocIndentLevelParagraph$Direction.DIRECTION_LTR.ordinal();
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "indentLevel";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9493e = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f);
        this.f9492d = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f + 4);
        return (iMo14263f + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        C13507p c13507p = (C13507p) abstractC13493b;
        this.f9492d = c13507p.f9492d;
        this.f9493e = c13507p.f9493e;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13649v(iMo14265h, this.f9493e);
        c12020a.m13649v(iMo14265h + 4, this.f9492d);
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
        if (!(obj instanceof C13507p)) {
            return false;
        }
        C13507p c13507p = (C13507p) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_IndentLvParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9492d != c13507p.f9492d) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mDirection[");
            sb.append(this.f9492d);
            sb.append(" - ");
            AbstractC11014a.m12329n(c13507p.f9492d, "]", "WCon_IndentLvParagraph", sb);
            return false;
        }
        if (this.f9493e == c13507p.f9493e) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mLevel[");
        sb2.append(this.f9493e);
        sb2.append(" - ");
        AbstractC11014a.m12329n(c13507p.f9493e, "]", "WCon_IndentLvParagraph", sb2);
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        return this.f9493e + "," + this.f9492d;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length < 2) {
            Log.e("WCon_IndentLvParagraph", "setProperty - fail : ".concat(str));
            return false;
        }
        this.f9493e = Integer.parseInt(strArrSplit[0]);
        this.f9492d = Integer.parseInt(strArrSplit[1]);
        return true;
    }
}
