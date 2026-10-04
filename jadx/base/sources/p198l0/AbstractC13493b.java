package p198l0;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import p185h0.InterfaceC12016a;
import p185h0.InterfaceC12017b;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC13493b implements InterfaceC12016a, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9466a;

    /* JADX INFO: renamed from: b */
    public int f9467b;

    /* JADX INFO: renamed from: c */
    public int f9468c;

    public AbstractC13493b(int i) {
        this.f9466a = i;
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public abstract String mo13615a();

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: b */
    public final String mo13616b() {
        return "paragraph";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: c */
    public final boolean mo13617c(String str) {
        if (str == null) {
            return false;
        }
        return mo14268k(str);
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: d */
    public final String mo13618d() {
        return "'paragraph/" + mo13615a() + "'";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: e */
    public final String mo13619e() {
        return "'paragraph/" + mo13615a() + "'='" + mo14267j() + "'";
    }

    @Override // p185h0.InterfaceC12016a
    public final int end() {
        return this.f9468c;
    }

    /* JADX INFO: renamed from: f */
    public int mo14263f(C12020a c12020a, int i) {
        this.f9466a = ((ByteBuffer) c12020a.f8772b).getInt(i);
        this.f9467b = ((ByteBuffer) c12020a.f8772b).getInt(i + 4);
        this.f9468c = ((ByteBuffer) c12020a.f8772b).getInt(i + 8);
        return (i + 12) - i;
    }

    /* JADX INFO: renamed from: g */
    public void mo14264g(AbstractC13493b abstractC13493b) {
        this.f9466a = abstractC13493b.f9466a;
        this.f9467b = abstractC13493b.f9467b;
        this.f9468c = abstractC13493b.f9468c;
    }

    /* JADX INFO: renamed from: h */
    public int mo14265h(C12020a c12020a, int i) {
        c12020a.m13649v(i, this.f9466a);
        c12020a.m13649v(i + 4, this.f9467b);
        c12020a.m13649v(i + 8, this.f9468c);
        return (i + 12) - i;
    }

    /* JADX INFO: renamed from: i */
    public abstract int mo14266i();

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC13493b)) {
            return false;
        }
        AbstractC13493b abstractC13493b = (AbstractC13493b) obj;
        if (this.f9466a != abstractC13493b.f9466a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f9466a);
            sb.append(" - ");
            AbstractC11014a.m12329n(abstractC13493b.f9466a, "]", "WCon_TextParagraphBase", sb);
            return false;
        }
        if (this.f9467b != abstractC13493b.f9467b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - startPos[");
            sb2.append(this.f9467b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(abstractC13493b.f9467b, "]", "WCon_TextParagraphBase", sb2);
            return false;
        }
        if (this.f9468c == abstractC13493b.f9468c) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder(" !! equals() - NE - endPos[");
        sb3.append(this.f9468c);
        sb3.append(" - ");
        AbstractC11014a.m12329n(abstractC13493b.f9468c, "]", "WCon_TextParagraphBase", sb3);
        return false;
    }

    /* JADX INFO: renamed from: j */
    public abstract String mo14267j();

    /* JADX INFO: renamed from: k */
    public abstract boolean mo14268k(String str);

    @Override // p185h0.InterfaceC12016a
    public final int start() {
        return this.f9467b;
    }

    @Override // p185h0.InterfaceC12016a
    public final void end(int i) {
        this.f9468c = i;
    }

    @Override // p185h0.InterfaceC12016a
    public final void start(int i) {
        this.f9467b = i;
    }
}
