package p198l0;

import android.util.Log;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocUnderlineSpan$Type;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.y */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13516y extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public boolean f9504f;

    /* JADX INFO: renamed from: g */
    public int f9505g;

    /* JADX INFO: renamed from: h */
    public int f9506h;

    public C13516y() {
        super(7);
        this.f9505g = WDocUnderlineSpan$Type.TYPE_SINGLE.ordinal();
        this.f9506h = 0;
    }

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "underline";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9504f = ((ByteBuffer) c12020a.f8772b).get(iMo14270f) == 1;
        this.f9505g = ((ByteBuffer) c12020a.f8772b).get(iMo14270f + 1);
        this.f9506h = ((ByteBuffer) c12020a.f8772b).getInt(iMo14270f + 4);
        return (iMo14270f + 8) - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        this.f9504f = ((C13516y) abstractC13495d).f9504f;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        c12020a.m13646s(iMo14272i, this.f9504f ? 1 : 0);
        c12020a.m13646s(iMo14272i + 1, this.f9505g);
        c12020a.m13647t(iMo14272i + 2, 0);
        c12020a.m13649v(iMo14272i + 4, this.f9506h);
        return (iMo14272i + 8) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13516y)) {
            return false;
        }
        C13516y c13516y = (C13516y) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_UnderlineSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9504f != c13516y.f9504f) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - isUnderLine[");
            sb.append(this.f9504f);
            sb.append(" - ");
            AbstractC11014a.m12339x(sb, "]", "WCon_UnderlineSpan", c13516y.f9504f);
            return false;
        }
        if (this.f9505g != c13516y.f9505g) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mUnderLineType[");
            sb2.append(this.f9505g);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c13516y.f9505g, "]", "WCon_UnderlineSpan", sb2);
            return false;
        }
        if (this.f9506h == c13516y.f9506h) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mColor[");
        sb3.append(this.f9506h);
        sb3.append(" - ");
        AbstractC11014a.m12329n(c13516y.f9506h, "]", "WCon_UnderlineSpan", sb3);
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
        return Boolean.toString(this.f9504f);
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        this.f9504f = Boolean.parseBoolean(str);
        return true;
    }
}
