package p198l0;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocHyperTextSpan$DateTimeType;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocHyperTextSpan$Type;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13506o extends AbstractC13495d {

    /* JADX INFO: renamed from: f */
    public int f9489f;

    /* JADX INFO: renamed from: g */
    public int f9490g;

    /* JADX INFO: renamed from: h */
    public String f9491h;

    public C13506o() {
        super(9);
        this.f9489f = WDocHyperTextSpan$Type.TYPE_UNKNOWN.ordinal();
        this.f9490g = WDocHyperTextSpan$DateTimeType.DATETIME_TYPE_NONE.ordinal();
        this.f9491h = "";
    }

    @Override // p198l0.AbstractC13495d, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "hyperText";
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: f */
    public final int mo14270f(C12020a c12020a, int i) {
        int iMo14270f = super.mo14270f(c12020a, i) + i;
        this.f9489f = ((ByteBuffer) c12020a.f8772b).getInt(iMo14270f);
        this.f9490g = ((ByteBuffer) c12020a.f8772b).getInt(iMo14270f + 4);
        int i2 = ((ByteBuffer) c12020a.f8772b).getInt(iMo14270f + 8);
        int i4 = iMo14270f + 12;
        if (i2 > 0) {
            this.f9491h = c12020a.m13645r(i4, i2);
            i4 += i2 * 2;
        }
        return i4 - i;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: g */
    public final void mo14271g(AbstractC13495d abstractC13495d) {
        super.mo14271g(abstractC13495d);
        C13506o c13506o = (C13506o) abstractC13495d;
        this.f9489f = c13506o.f9489f;
        this.f9490g = c13506o.f9490g;
        this.f9491h = c13506o.f9491h;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: i */
    public final int mo14272i(C12020a c12020a, int i) {
        int iMo14272i = super.mo14272i(c12020a, i) + i;
        c12020a.m13649v(iMo14272i, this.f9489f);
        c12020a.m13649v(iMo14272i + 4, this.f9490g);
        c12020a.m13649v(iMo14272i + 8, this.f9491h.length());
        int i2 = iMo14272i + 12;
        c12020a.m13626E(i2, this.f9491h);
        return ((this.f9491h.length() * 2) + i2) - i;
    }

    @Override // p198l0.AbstractC13495d, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13506o)) {
            return false;
        }
        C13506o c13506o = (C13506o) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_HyperTextSpan", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9489f != c13506o.f9489f) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mHyperTextType[");
            sb.append(this.f9489f);
            sb.append(" - ");
            AbstractC11014a.m12329n(c13506o.f9489f, "]", "WCon_HyperTextSpan", sb);
            return false;
        }
        if (this.f9490g != c13506o.f9490g) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mDateTimeType[");
            sb2.append(this.f9490g);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c13506o.f9490g, "]", "WCon_HyperTextSpan", sb2);
            return false;
        }
        if (TextUtils.equals(this.f9491h, c13506o.f9491h)) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mCustomData[");
        sb3.append(this.f9491h);
        sb3.append(" - ");
        AbstractC4539a.m3209s(sb3, c13506o.f9491h, "]", "WCon_HyperTextSpan");
        return false;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: j */
    public final int mo14273j() {
        String str = this.f9491h;
        if (str != null) {
            return AbstractC4539a.m3193c(2, 28, str);
        }
        return 28;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: l */
    public final String mo14275l() {
        return this.f9489f + "," + this.f9490g + "," + this.f9491h;
    }

    @Override // p198l0.AbstractC13495d
    /* JADX INFO: renamed from: m */
    public final boolean mo14276m(String str) {
        String[] strArrSplit = str.split(",", -1);
        if (strArrSplit.length < 2) {
            Log.e("WCon_HyperTextSpan", "setProperty - fail : ".concat(str));
            return false;
        }
        this.f9489f = Integer.parseInt(strArrSplit[0]);
        this.f9490g = Integer.parseInt(strArrSplit[1]);
        if (strArrSplit.length > 2) {
            this.f9491h = strArrSplit[2];
        }
        return true;
    }
}
