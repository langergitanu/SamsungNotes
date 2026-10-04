package p198l0;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p185h0.InterfaceC12016a;
import p185h0.InterfaceC12017b;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC13495d implements InterfaceC12016a, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9471a;

    /* JADX INFO: renamed from: b */
    public int f9472b;

    /* JADX INFO: renamed from: c */
    public int f9473c;

    /* JADX INFO: renamed from: d */
    public int f9474d;

    /* JADX INFO: renamed from: e */
    public int f9475e;

    public AbstractC13495d(int i) {
        this.f9471a = i;
    }

    /* JADX INFO: renamed from: h */
    public static AbstractC13495d m14269h(String str) {
        if (str.equals("foregroundColor")) {
            return new C13505n();
        }
        if (str.equals("fontSize")) {
            return new C13504m(3);
        }
        if (str.equals("fontName")) {
            return new C13503l(4);
        }
        if (str.equals("bold")) {
            return new C13498g(5);
        }
        if (str.equals("italic")) {
            return new C13508q();
        }
        if (str.equals("underline")) {
            return new C13516y();
        }
        if (str.equals("hyperText")) {
            return new C13506o();
        }
        if (str.equals("backgroundColor")) {
            return new C13497f();
        }
        if (str.equals("timeStamp")) {
            return new C13515x();
        }
        if (str.equals("strikethrough")) {
            return new C13514w();
        }
        return null;
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public abstract String mo13615a();

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: b */
    public final String mo13616b() {
        return "span";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: c */
    public final boolean mo13617c(String str) {
        if (str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        int iIndexOf = sb.indexOf(",");
        this.f9474d = Integer.parseInt(sb.substring(0, iIndexOf));
        return mo14276m(sb.substring(iIndexOf + 1, sb.length()));
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: d */
    public final String mo13618d() {
        return "'span/" + mo13615a() + "'";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: e */
    public final String mo13619e() {
        return "'span/" + mo13615a() + "'='" + this.f9474d + "," + mo14275l() + "'";
    }

    @Override // p185h0.InterfaceC12016a
    public final int end() {
        return this.f9473c;
    }

    /* JADX INFO: renamed from: f */
    public int mo14270f(C12020a c12020a, int i) {
        this.f9471a = ((ByteBuffer) c12020a.f8772b).getInt(i);
        this.f9472b = ((ByteBuffer) c12020a.f8772b).getInt(i + 4);
        this.f9473c = ((ByteBuffer) c12020a.f8772b).getInt(i + 8);
        this.f9474d = ((ByteBuffer) c12020a.f8772b).getInt(i + 12);
        return (i + 16) - i;
    }

    /* JADX INFO: renamed from: g */
    public void mo14271g(AbstractC13495d abstractC13495d) {
        this.f9471a = abstractC13495d.f9471a;
        this.f9472b = abstractC13495d.f9472b;
        this.f9473c = abstractC13495d.f9473c;
        this.f9474d = abstractC13495d.f9474d;
        this.f9475e = abstractC13495d.f9475e;
    }

    /* JADX INFO: renamed from: i */
    public int mo14272i(C12020a c12020a, int i) {
        c12020a.m13649v(i, this.f9471a);
        c12020a.m13649v(i + 4, this.f9472b);
        c12020a.m13649v(i + 8, this.f9473c);
        c12020a.m13649v(i + 12, this.f9474d);
        return (i + 16) - i;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC13495d)) {
            return false;
        }
        AbstractC13495d abstractC13495d = (AbstractC13495d) obj;
        if (this.f9471a != abstractC13495d.f9471a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f9471a);
            sb.append(" - ");
            AbstractC11014a.m12329n(abstractC13495d.f9471a, "]", "WCon_TextSpanBase", sb);
            return false;
        }
        if (this.f9472b != abstractC13495d.f9472b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - startPos[");
            sb2.append(this.f9472b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(abstractC13495d.f9472b, "]", "WCon_TextSpanBase", sb2);
            return false;
        }
        if (this.f9473c != abstractC13495d.f9473c) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - endPos[");
            sb3.append(this.f9473c);
            sb3.append(" - ");
            AbstractC11014a.m12329n(abstractC13495d.f9473c, "]", "WCon_TextSpanBase", sb3);
            return false;
        }
        if (this.f9474d == abstractC13495d.f9474d) {
            return true;
        }
        StringBuilder sb4 = new StringBuilder(" !! equals() - NE - intervalType[");
        sb4.append(this.f9474d);
        sb4.append(" - ");
        AbstractC11014a.m12329n(abstractC13495d.f9474d, "]", "WCon_TextSpanBase", sb4);
        return false;
    }

    /* JADX INFO: renamed from: j */
    public abstract int mo14273j();

    /* JADX INFO: renamed from: k */
    public final String m14274k() {
        return this.f9471a + "," + this.f9472b + "," + this.f9473c + "," + this.f9474d + "," + mo14275l();
    }

    /* JADX INFO: renamed from: l */
    public abstract String mo14275l();

    /* JADX INFO: renamed from: m */
    public abstract boolean mo14276m(String str);

    @Override // p185h0.InterfaceC12016a
    public final int start() {
        return this.f9472b;
    }

    @Override // p185h0.InterfaceC12016a
    public final void end(int i) {
        this.f9473c = i;
    }

    @Override // p185h0.InterfaceC12016a
    public final void start(int i) {
        this.f9472b = i;
    }
}
