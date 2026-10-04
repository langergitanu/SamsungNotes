package p194k0;

import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12955m implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public boolean f9214a;

    /* JADX INFO: renamed from: b */
    public boolean f9215b;

    /* JADX INFO: renamed from: c */
    public RectF f9216c;

    /* JADX INFO: renamed from: d */
    public float f9217d;

    /* JADX INFO: renamed from: e */
    public C12958p f9218e;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        C12958p c12958p;
        C12958p c12958p2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12955m)) {
            return false;
        }
        C12955m c12955m = (C12955m) obj;
        if (this.f9214a != c12955m.f9214a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mHorizontalFlip[");
            sb.append(this.f9214a);
            sb.append(" - ");
            AbstractC11014a.m12339x(sb, "]", "WCon_ShapeTemplateBase", c12955m.f9214a);
            return false;
        }
        if (this.f9215b != c12955m.f9215b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mVerticalFlip[");
            sb2.append(this.f9215b);
            sb2.append(" - ");
            AbstractC11014a.m12339x(sb2, "]", "WCon_ShapeTemplateBase", c12955m.f9215b);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9216c, c12955m.f9216c)) {
            Log.e("WCon_ShapeTemplateBase", " !! equals() - NE - mOwnerRect[" + this.f9216c + " - " + c12955m.f9216c + "]");
        }
        if (this.f9217d != c12955m.f9217d) {
            Log.e("WCon_ShapeTemplateBase", " !! equals() - NE - mRotation[" + this.f9217d + " - " + c12955m.f9217d + "]");
        }
        if (AbstractC0299q.m635j(this.f9218e, c12955m.f9218e) || ((this.f9218e == null && (c12958p2 = c12955m.f9218e) != null && c12958p2.f9242a.size() == 0) || ((c12958p = this.f9218e) != null && c12958p.f9242a.size() == 0 && c12955m.f9218e == null))) {
            return true;
        }
        Log.i("WCon_ShapeTemplateBase", " !! equals() - NE - mPath[" + this.f9218e + " - " + c12955m.f9218e + "]");
        return false;
    }
}
