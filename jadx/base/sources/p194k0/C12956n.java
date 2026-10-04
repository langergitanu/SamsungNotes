package p194k0;

import android.text.TextUtils;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$AutoFitOption;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$EllipsisType;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$IMEActionType;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$TextInputType;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12956n implements InterfaceC12017b {

    /* JADX INFO: renamed from: e */
    public C12960r f9223e;

    /* JADX INFO: renamed from: f */
    public int f9224f;

    /* JADX INFO: renamed from: g */
    public String f9225g;

    /* JADX INFO: renamed from: j */
    public float f9228j;

    /* JADX INFO: renamed from: k */
    public int f9229k;

    /* JADX INFO: renamed from: l */
    public int f9230l;

    /* JADX INFO: renamed from: m */
    public boolean f9231m;

    /* JADX INFO: renamed from: n */
    public boolean f9232n;

    /* JADX INFO: renamed from: o */
    public boolean f9233o;

    /* JADX INFO: renamed from: p */
    public final C6906i f9234p;

    /* JADX INFO: renamed from: i */
    public float f9227i = 10.0f;

    /* JADX INFO: renamed from: h */
    public int f9226h = -16777216;

    /* JADX INFO: renamed from: c */
    public int f9221c = ObjectShapeConst$IMEActionType.IME_ACTION_TYPE_NONE.ordinal();

    /* JADX INFO: renamed from: d */
    public int f9222d = ObjectShapeConst$TextInputType.INPUT_TYPE_TEXT.ordinal();

    /* JADX INFO: renamed from: a */
    public int f9219a = ObjectShapeConst$EllipsisType.ELLIPSIS_TYPE_TRIANGLE.ordinal();

    /* JADX INFO: renamed from: b */
    public int f9220b = ObjectShapeConst$AutoFitOption.AUTO_FIT_OPTION_BOTH.ordinal();

    public C12956n(C6906i c6906i) {
        this.f9234p = null;
        this.f9234p = c6906i;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12956n)) {
            return false;
        }
        C12956n c12956n = (C12956n) obj;
        if (this.f9219a != c12956n.f9219a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - ellipsisType[");
            sb.append(this.f9219a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9219a, "]", "WCon_ObjectShapeText", sb);
            return false;
        }
        if (this.f9220b != c12956n.f9220b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - textAutoFit[");
            sb2.append(this.f9220b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9220b, "]", "WCon_ObjectShapeText", sb2);
            return false;
        }
        if (this.f9221c != c12956n.f9221c) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - imeActionType[");
            sb3.append(this.f9221c);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9221c, "]", "WCon_ObjectShapeText", sb3);
            return false;
        }
        if (this.f9222d != c12956n.f9222d) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - textInputType[");
            sb4.append(this.f9222d);
            sb4.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9222d, "]", "WCon_ObjectShapeText", sb4);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9223e, c12956n.f9223e)) {
            Log.i("WCon_ObjectShapeText", " !! equals() - NE - textCommon[" + this.f9223e + " - " + c12956n.f9223e + "]");
            return false;
        }
        if (this.f9224f != c12956n.f9224f) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - textAreaType[");
            sb5.append(this.f9224f);
            sb5.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9224f, "]", "WCon_ObjectShapeText", sb5);
            return false;
        }
        if (!TextUtils.equals(this.f9225g, c12956n.f9225g)) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - hintText[");
            sb6.append(this.f9225g);
            sb6.append(" - ");
            AbstractC4539a.m3209s(sb6, c12956n.f9225g, "]", "WCon_ObjectShapeText");
            return false;
        }
        if (this.f9226h != c12956n.f9226h) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - hintTextColor[");
            sb7.append(this.f9226h);
            sb7.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9226h, "]", "WCon_ObjectShapeText", sb7);
            return false;
        }
        if (this.f9227i != c12956n.f9227i) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - hintTextFontSize[");
            sb8.append(this.f9227i);
            sb8.append(" - ");
            AbstractC2821a.m2234y(sb8, c12956n.f9227i, "]", "WCon_ObjectShapeText");
            return false;
        }
        if (this.f9228j != c12956n.f9228j) {
            StringBuilder sb9 = new StringBuilder(" !! equals() - NE - hintTextVerticalOffset[");
            sb9.append(this.f9228j);
            sb9.append(" - ");
            AbstractC2821a.m2234y(sb9, c12956n.f9228j, "]", "WCon_ObjectShapeText");
            return false;
        }
        if (this.f9229k != c12956n.f9229k) {
            StringBuilder sb10 = new StringBuilder(" !! equals() - NE - hintTextStyle[");
            sb10.append(this.f9229k);
            sb10.append(" - ");
            AbstractC11014a.m12329n(c12956n.f9229k, "]", "WCon_ObjectShapeText", sb10);
            return false;
        }
        if (this.f9230l != c12956n.f9230l) {
            Log.e("WCon_ObjectShapeText", " !! equals() - NE - textBinarySize[" + this.f9230l + " - " + c12956n.f9230l + "]");
        }
        if (this.f9231m != c12956n.f9231m) {
            StringBuilder sb11 = new StringBuilder(" !! equals() - NE - isHintTextVisiable[");
            sb11.append(this.f9231m);
            sb11.append(" - ");
            AbstractC11014a.m12339x(sb11, "]", "WCon_ObjectShapeText", c12956n.f9231m);
            return false;
        }
        if (this.f9232n != c12956n.f9232n) {
            StringBuilder sb12 = new StringBuilder(" !! equals() - NE - textReadOnly[");
            sb12.append(this.f9232n);
            sb12.append(" - ");
            AbstractC11014a.m12339x(sb12, "]", "WCon_ObjectShapeText", c12956n.f9232n);
            return false;
        }
        if (this.f9233o == c12956n.f9233o) {
            return true;
        }
        StringBuilder sb13 = new StringBuilder(" !! equals() - NE - isTextEditable[");
        sb13.append(this.f9233o);
        sb13.append(" - ");
        AbstractC11014a.m12339x(sb13, "]", "WCon_ObjectShapeText", c12956n.f9233o);
        return false;
    }
}
