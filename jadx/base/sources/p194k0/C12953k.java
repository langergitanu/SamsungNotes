package p194k0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12953k implements InterfaceC12017b {

    /* JADX INFO: renamed from: d */
    public String f9203d;

    /* JADX INFO: renamed from: f */
    public int f9205f;

    /* JADX INFO: renamed from: i */
    public String f9208i;

    /* JADX INFO: renamed from: a */
    public Rect f9200a = new Rect();

    /* JADX INFO: renamed from: b */
    public RectF f9201b = new RectF();

    /* JADX INFO: renamed from: c */
    public int f9202c = -1;

    /* JADX INFO: renamed from: e */
    public Rect f9204e = new Rect();

    /* JADX INFO: renamed from: g */
    public final int f9206g = -1;

    /* JADX INFO: renamed from: h */
    public int f9207h = -1;

    /* JADX INFO: renamed from: j */
    public boolean f9209j = false;

    /* JADX INFO: renamed from: k */
    public Rect f9210k = new Rect();

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12953k)) {
            return false;
        }
        C12953k c12953k = (C12953k) obj;
        int i = c12953k.f9206g;
        if (!AbstractC0299q.m635j(this.f9200a, c12953k.f9200a)) {
            Log.i("WCon_ObjectShapeImage", " !! equals() - NE - cropRect[" + this.f9200a + " - " + c12953k.f9200a + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9201b, c12953k.f9201b)) {
            Log.i("WCon_ObjectShapeImage", " !! equals() - NE - imageBorderLineWidth[" + this.f9201b + " - " + c12953k.f9201b + "]");
            return false;
        }
        if (this.f9202c != c12953k.f9202c) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - borderImageId[");
            sb.append(this.f9202c);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12953k.f9202c, "]", "WCon_ObjectShapeImage", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9203d, c12953k.f9203d)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - borderImageHash[");
            sb2.append(this.f9203d);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12953k.f9203d, "]", "WCon_ObjectShapeImage");
            return false;
        }
        if (!this.f9204e.equals(c12953k.f9204e)) {
            Log.i("WCon_ObjectShapeImage", " !! equals() - NE - borderImageNinePatchRect[" + this.f9204e + " - " + c12953k.f9204e + "]");
            return false;
        }
        if (this.f9205f != c12953k.f9205f) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - borderImageNinePatchWidth[");
            sb3.append(this.f9205f);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12953k.f9205f, "]", "WCon_ObjectShapeImage", sb3);
            return false;
        }
        int i2 = this.f9206g;
        if (i2 != i) {
            Log.i("WCon_ObjectShapeImage", AbstractC0622a.m1164j(i2, i, " !! equals() - NE - compatImageId[", " - ", "]"));
            return false;
        }
        if (this.f9209j != c12953k.f9209j) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - isTransparency[");
            sb4.append(this.f9209j);
            sb4.append(" - ");
            AbstractC11014a.m12339x(sb4, "]", "WCon_ObjectShapeImage", c12953k.f9209j);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9210k, c12953k.f9210k)) {
            Log.i("WCon_ObjectShapeImage", " !! equals() - NE - originalRect[" + this.f9210k + " - " + c12953k.f9210k + "]");
            return false;
        }
        if (this.f9207h != c12953k.f9207h) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - originalImageId[");
            sb5.append(this.f9207h);
            sb5.append(" - ");
            AbstractC11014a.m12329n(c12953k.f9207h, "]", "WCon_ObjectShapeImage", sb5);
            return false;
        }
        if (TextUtils.equals(this.f9208i, c12953k.f9208i)) {
            return true;
        }
        StringBuilder sb6 = new StringBuilder(" !! equals() - NE - originalImageHash[");
        sb6.append(this.f9208i);
        sb6.append(" - ");
        AbstractC4539a.m3209s(sb6, c12953k.f9208i, "]", "WCon_ObjectShapeImage");
        return false;
    }
}
