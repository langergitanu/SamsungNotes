package p194k0;

import android.graphics.PointF;
import android.util.Log;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.util.ArrayList;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;

/* JADX INFO: renamed from: k0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12950h implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9172a;

    /* JADX INFO: renamed from: c */
    public byte f9174c;

    /* JADX INFO: renamed from: d */
    public int f9175d;

    /* JADX INFO: renamed from: f */
    public boolean f9177f;

    /* JADX INFO: renamed from: b */
    public int f9173b = -16777216;

    /* JADX INFO: renamed from: e */
    public PointF f9176e = null;

    /* JADX INFO: renamed from: g */
    public final ArrayList f9178g = new ArrayList();

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        c6742k.m4848d(this.f9172a, "colorType");
        c6742k.m4852i("gradientRotatable", this.f9177f);
        c6742k.m4848d(this.f9173b, "solidColor");
        c6742k.m4848d(this.f9174c, "gradientType");
        c6742k.m4848d(this.f9175d, "angle");
        c6742k.m4843B(this.f9176e, "radialGradientPosition");
        ArrayList<C12949g> arrayList = this.f9178g;
        if (arrayList.isEmpty()) {
            return;
        }
        c6742k.m4846F("gradientColorInfoList");
        for (C12949g c12949g : arrayList) {
            c6742k.m4846F("gradientColorInfo");
            c6742k.m4848d(c12949g.f9170a, "color");
            c6742k.m4849e("position", c12949g.f9171b);
            c6742k.m4856m("gradientColorInfo");
        }
        c6742k.m4856m("gradientColorInfoList");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12950h)) {
            return false;
        }
        C12950h c12950h = (C12950h) obj;
        ArrayList arrayList = c12950h.f9178g;
        if (this.f9172a != c12950h.f9172a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mColorType[");
            sb.append(this.f9172a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12950h.f9172a, "]", "WCon_LineColorEffect", sb);
            return false;
        }
        if (this.f9173b != c12950h.f9173b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mSolidColor[");
            sb2.append(this.f9173b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12950h.f9173b, "]", "WCon_LineColorEffect", sb2);
            return false;
        }
        if (this.f9174c != c12950h.f9174c) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mGradientType[");
            sb3.append((int) this.f9174c);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12950h.f9174c, "]", "WCon_LineColorEffect", sb3);
            return false;
        }
        if (this.f9175d != c12950h.f9175d) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - mAngle[");
            sb4.append(this.f9175d);
            sb4.append(" - ");
            AbstractC11014a.m12329n(c12950h.f9175d, "]", "WCon_LineColorEffect", sb4);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9176e, c12950h.f9176e)) {
            Log.i("WCon_LineColorEffect", " !! equals() - NE - mPosition[" + this.f9176e + " - " + c12950h.f9176e + "]");
            return false;
        }
        if (this.f9177f != c12950h.f9177f) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - mIsRotatable[");
            sb5.append(this.f9177f);
            sb5.append(" - ");
            AbstractC11014a.m12339x(sb5, "]", "WCon_LineColorEffect", c12950h.f9177f);
            return false;
        }
        ArrayList arrayList2 = this.f9178g;
        if (AbstractC0299q.m631h(arrayList2, arrayList)) {
            return true;
        }
        Log.i("WCon_LineColorEffect", " !! equals() - NE - mColorList[" + arrayList2 + " - " + arrayList + "]");
        return false;
    }
}
