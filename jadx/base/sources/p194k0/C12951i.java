package p194k0;

import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;

/* JADX INFO: renamed from: k0.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12951i implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public float f9179a;

    /* JADX INFO: renamed from: b */
    public byte f9180b;

    /* JADX INFO: renamed from: c */
    public byte f9181c;

    /* JADX INFO: renamed from: d */
    public byte f9182d;

    /* JADX INFO: renamed from: e */
    public byte f9183e;

    /* JADX INFO: renamed from: f */
    public byte f9184f;

    /* JADX INFO: renamed from: g */
    public byte f9185g;

    /* JADX INFO: renamed from: h */
    public byte f9186h;

    /* JADX INFO: renamed from: i */
    public byte f9187i;

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        c6742k.m4849e("width", this.f9179a);
        c6742k.m4848d(this.f9180b, "compoundType");
        c6742k.m4848d(this.f9181c, "dashType");
        c6742k.m4848d(this.f9182d, "capType");
        c6742k.m4848d(this.f9183e, "joinType");
        c6742k.m4848d(this.f9184f, "beginArrowType");
        c6742k.m4848d(this.f9185g, "beginArrowSize");
        c6742k.m4848d(this.f9186h, "endArrowType");
        c6742k.m4848d(this.f9187i, "endArrowSize");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12951i)) {
            return false;
        }
        C12951i c12951i = (C12951i) obj;
        if (this.f9179a != c12951i.f9179a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - width[");
            sb.append(this.f9179a);
            sb.append(" - ");
            AbstractC2821a.m2234y(sb, c12951i.f9179a, "]", "WCon_LineStyleEffect");
            return false;
        }
        if (this.f9180b != c12951i.f9180b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - compoundType[");
            sb2.append((int) this.f9180b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9180b, "]", "WCon_LineStyleEffect", sb2);
            return false;
        }
        if (this.f9181c != c12951i.f9181c) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mFileId[");
            sb3.append((int) this.f9181c);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9181c, "]", "WCon_LineStyleEffect", sb3);
            return false;
        }
        if (this.f9182d != c12951i.f9182d) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - capType[");
            sb4.append((int) this.f9182d);
            sb4.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9182d, "]", "WCon_LineStyleEffect", sb4);
            return false;
        }
        if (this.f9183e != c12951i.f9183e) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - joinType[");
            sb5.append((int) this.f9183e);
            sb5.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9183e, "]", "WCon_LineStyleEffect", sb5);
            return false;
        }
        if (this.f9184f != c12951i.f9184f) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - beginArrowType[");
            sb6.append((int) this.f9184f);
            sb6.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9184f, "]", "WCon_LineStyleEffect", sb6);
            return false;
        }
        if (this.f9185g != c12951i.f9185g) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - mFileId[");
            sb7.append((int) this.f9185g);
            sb7.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9185g, "]", "WCon_LineStyleEffect", sb7);
            return false;
        }
        if (this.f9186h != c12951i.f9186h) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - endArrowType[");
            sb8.append((int) this.f9186h);
            sb8.append(" - ");
            AbstractC11014a.m12329n(c12951i.f9186h, "]", "WCon_LineStyleEffect", sb8);
            return false;
        }
        if (this.f9187i == c12951i.f9187i) {
            return true;
        }
        StringBuilder sb9 = new StringBuilder(" !! equals() - NE - endArrowSize[");
        sb9.append((int) this.f9187i);
        sb9.append(" - ");
        AbstractC11014a.m12329n(c12951i.f9187i, "]", "WCon_LineStyleEffect", sb9);
        return false;
    }
}
