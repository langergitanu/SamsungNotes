package p194k0;

import android.graphics.RectF;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12952j implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9188a;

    /* JADX INFO: renamed from: b */
    public C12943a f9189b;

    /* JADX INFO: renamed from: c */
    public C12945c f9190c;

    /* JADX INFO: renamed from: d */
    public C12947e f9191d;

    /* JADX INFO: renamed from: e */
    public C12948f f9192e;

    /* JADX INFO: renamed from: f */
    public C12955m f9193f = new C12955m();

    /* JADX INFO: renamed from: g */
    public int f9194g;

    /* JADX INFO: renamed from: h */
    public float f9195h;

    /* JADX INFO: renamed from: i */
    public int f9196i;

    /* JADX INFO: renamed from: j */
    public RectF f9197j;

    /* JADX INFO: renamed from: k */
    public RectF f9198k;

    /* JADX INFO: renamed from: l */
    public float f9199l;

    /* JADX INFO: renamed from: a */
    public final AbstractC12946d m13849a() {
        C12945c c12945c = this.f9190c;
        if (c12945c != null) {
            return c12945c;
        }
        C12947e c12947e = this.f9191d;
        if (c12947e != null) {
            return c12947e;
        }
        C12948f c12948f = this.f9192e;
        if (c12948f != null) {
            return c12948f;
        }
        C12943a c12943a = this.f9189b;
        if (c12943a != null) {
            return c12943a;
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12952j)) {
            return false;
        }
        C12952j c12952j = (C12952j) obj;
        if (this.f9188a != c12952j.f9188a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f9188a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12952j.f9188a, "]", "WCon_ObjectShapeData", sb);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9189b, c12952j.f9189b)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - fillBackgroundEffect[" + this.f9189b + " - " + c12952j.f9189b + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9190c, c12952j.f9190c)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - fillColorEffect[" + this.f9190c + " - " + c12952j.f9190c + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9191d, c12952j.f9191d)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - fillImageEffect[" + this.f9191d + " - " + c12952j.f9191d + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9192e, c12952j.f9192e)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - fillPatternEffect[" + this.f9192e + " - " + c12952j.f9192e + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9193f, c12952j.f9193f)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - templateBase[" + this.f9193f + " - " + c12952j.f9193f + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9197j, c12952j.f9197j)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - originDrawnRect[" + this.f9197j + " - " + c12952j.f9197j + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9198k, c12952j.f9198k)) {
            Log.i("WCon_ObjectShapeData", " !! equals() - NE - originRect[" + this.f9198k + " - " + c12952j.f9198k + "]");
        }
        if (this.f9194g != c12952j.f9194g) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - borderColor[");
            sb2.append(this.f9194g);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12952j.f9194g, "]", "WCon_ObjectShapeData", sb2);
            return false;
        }
        if (this.f9195h != c12952j.f9195h) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - borderWidth[");
            sb3.append(this.f9195h);
            sb3.append(" - ");
            AbstractC2821a.m2234y(sb3, c12952j.f9195h, "]", "WCon_ObjectShapeData");
            return false;
        }
        if (this.f9196i != c12952j.f9196i) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - borderType[");
            sb4.append(this.f9196i);
            sb4.append(" - ");
            AbstractC11014a.m12329n(c12952j.f9196i, "]", "WCon_ObjectShapeData", sb4);
            return false;
        }
        if (this.f9199l == c12952j.f9199l) {
            return true;
        }
        StringBuilder sb5 = new StringBuilder(" !! equals() - NE - originDegree[");
        sb5.append(this.f9199l);
        sb5.append(" - ");
        AbstractC2821a.m2234y(sb5, c12952j.f9199l, "]", "WCon_ObjectShapeData");
        return false;
    }
}
