package p198l0;

import android.util.Log;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocPredefinedStyleParagraph$PredefinedStyle;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.t */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13511t extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public int f9498d;

    /* JADX INFO: renamed from: e */
    public int f9499e;

    public C13511t() {
        super(10);
        this.f9498d = WDocPredefinedStyleParagraph$PredefinedStyle.TYPE_HEADING_1.ordinal();
        this.f9499e = WDocPredefinedStyleParagraph$PredefinedStyle.TYPE_BODY_1.ordinal();
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "predefinedStyle";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9498d = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f);
        this.f9499e = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f + 4);
        return (iMo14263f + 8) - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        C13511t c13511t = (C13511t) abstractC13493b;
        this.f9498d = c13511t.f9498d;
        this.f9499e = c13511t.f9499e;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13649v(iMo14265h, this.f9498d);
        c12020a.m13649v(iMo14265h + 4, this.f9499e);
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
        if (!(obj instanceof C13511t)) {
            return false;
        }
        C13511t c13511t = (C13511t) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_PredefinedStyleParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9498d != c13511t.f9498d) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mStyleType[");
            sb.append(this.f9498d);
            sb.append(" - ");
            AbstractC11014a.m12329n(c13511t.f9498d, "]", "WCon_PredefinedStyleParagraph", sb);
            return false;
        }
        if (this.f9499e == c13511t.f9499e) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mFollowingStyleType[");
        sb2.append(this.f9499e);
        sb2.append(" - ");
        AbstractC11014a.m12329n(c13511t.f9499e, "]", "WCon_PredefinedStyleParagraph", sb2);
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        return this.f9498d + "," + this.f9499e;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length < 2) {
            Log.e("WCon_PredefinedStyleParagraph", "setProperty - fail : ".concat(str));
            return false;
        }
        this.f9498d = Integer.parseInt(strArrSplit[0]);
        this.f9499e = Integer.parseInt(strArrSplit[1]);
        return true;
    }
}
