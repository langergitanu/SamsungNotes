package p198l0;

import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocLineSpacingParagraph$Type;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: l0.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13509r extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public int f9495d;

    /* JADX INFO: renamed from: e */
    public float f9496e;

    public C13509r() {
        super(4);
        this.f9495d = WDocLineSpacingParagraph$Type.TYPE_PIXEL.ordinal();
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "lineSpacing";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9495d = ((ByteBuffer) c12020a.f8772b).get(iMo14263f);
        this.f9496e = ((ByteBuffer) c12020a.f8772b).getFloat(iMo14263f + 4);
        return (iMo14263f + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        C13509r c13509r = (C13509r) abstractC13493b;
        this.f9495d = c13509r.f9495d;
        this.f9496e = c13509r.f9496e;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13646s(iMo14265h, this.f9495d);
        c12020a.m13648u(this.f9496e, iMo14265h + 4);
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
        if (!(obj instanceof C13509r)) {
            return false;
        }
        C13509r c13509r = (C13509r) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_LineSpaceParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9495d != c13509r.f9495d) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mLineSpacingType[");
            sb.append(this.f9495d);
            sb.append(" - ");
            AbstractC11014a.m12329n(c13509r.f9495d, "]", "WCon_LineSpaceParagraph", sb);
            return false;
        }
        if (this.f9496e == c13509r.f9496e) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mSpacing[");
        sb2.append(this.f9496e);
        sb2.append(" - ");
        AbstractC2821a.m2234y(sb2, c13509r.f9496e, "]", "WCon_LineSpaceParagraph");
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        return this.f9495d + "," + this.f9496e;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length < 2) {
            Log.e("WCon_LineSpaceParagraph", "setProperty - fail : ".concat(str));
            return false;
        }
        this.f9495d = Integer.parseInt(strArrSplit[0]);
        this.f9496e = AbstractC14517a.m15121F(strArrSplit[1]);
        return true;
    }
}
