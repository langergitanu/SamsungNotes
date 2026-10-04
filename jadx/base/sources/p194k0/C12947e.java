package p194k0;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p178f0.C11979b;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12947e extends AbstractC12946d {

    /* JADX INFO: renamed from: b */
    public byte f9155b;

    /* JADX INFO: renamed from: c */
    public int f9156c;

    /* JADX INFO: renamed from: d */
    public String f9157d;

    /* JADX INFO: renamed from: e */
    public Rect f9158e;

    /* JADX INFO: renamed from: f */
    public int f9159f;

    /* JADX INFO: renamed from: g */
    public RectF f9160g;

    /* JADX INFO: renamed from: h */
    public PointF f9161h;

    /* JADX INFO: renamed from: i */
    public float f9162i;

    /* JADX INFO: renamed from: j */
    public float f9163j;

    /* JADX INFO: renamed from: k */
    public float f9164k;

    /* JADX INFO: renamed from: l */
    public boolean f9165l;

    /* JADX INFO: renamed from: m */
    public final C11979b f9166m;

    public C12947e(C6906i c6906i) {
        super(2);
        this.f9156c = -1;
        this.f9158e = new Rect();
        this.f9166m = (C11979b) c6906i.f4483b;
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        super.m13847b(c6742k);
        c6742k.m4848d(this.f9155b, "imageType");
        if (this.f9157d == null) {
            this.f9157d = this.f9166m.m13559e(this.f9156c);
        }
        c6742k.m4851h("imageId", this.f9157d);
        c6742k.m4849e("tilingScaleX", this.f9162i);
        c6742k.m4849e("tilingScaleY", this.f9163j);
        c6742k.m4849e("transparency", this.f9164k);
        c6742k.m4852i("rotatable", this.f9165l);
        c6742k.m4848d(this.f9159f, "ninePatchWidth");
        c6742k.m4845D("stretchOffset", this.f9160g);
        c6742k.m4843B(this.f9161h, "tilingOffset");
        c6742k.m4844C("ninePatchRect", this.f9158e);
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: c */
    public final int mo13844c() {
        return 62;
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: d */
    public final void mo13845d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "fillEffect");
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("imageType")) {
                this.f9155b = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("imageId")) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                this.f9157d = attributeValue;
                this.f9156c = this.f9166m.m13558d(attributeValue);
            } else if (attributeName.equalsIgnoreCase("tilingScaleX")) {
                this.f9162i = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("tilingScaleY")) {
                this.f9163j = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("transparency")) {
                this.f9164k = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("rotatable")) {
                this.f9165l = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("ninePatchWidth")) {
                this.f9159f = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            }
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("fillEffect")) {
                return;
            }
            if (iM15119D == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("stretchOffset")) {
                    this.f9160g = AbstractC14517a.m15127L(xmlPullParser);
                } else if (name.equalsIgnoreCase("tilingOffset")) {
                    this.f9161h = AbstractC14517a.m15124I(xmlPullParser);
                } else if (name.equalsIgnoreCase("ninePatchRect")) {
                    this.f9158e = AbstractC14517a.m15125J(xmlPullParser);
                }
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_FillImageEffect");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m13848e(C12020a c12020a, int i) {
        int i2 = i + 1;
        c12020a.m13646s(i, this.f9155b);
        String str = this.f9157d;
        if (str != null) {
            this.f9156c = this.f9166m.m13558d(str);
        }
        c12020a.m13649v(i2, this.f9156c);
        c12020a.m13623B(i + 5, this.f9160g);
        c12020a.m13650w(i + 21, this.f9161h);
        c12020a.m13648u(this.f9162i, i + 29);
        c12020a.m13648u(this.f9163j, i + 33);
        c12020a.m13648u(this.f9164k, i + 37);
        c12020a.m13646s(i + 41, this.f9165l ? 1 : 0);
        c12020a.m13653z(i + 42, this.f9158e);
        c12020a.m13649v(i + 58, this.f9159f);
        return (i + 62) - i;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12947e)) {
            return false;
        }
        C12947e c12947e = (C12947e) obj;
        int i = c12947e.f9154a;
        int i2 = this.f9154a;
        if (i2 != i) {
            Log.i("WCon_FillImageEffect", AbstractC0622a.m1164j(i2, i, " !! equals() - NE - type[", " - ", "]"));
            return false;
        }
        if (this.f9156c != c12947e.f9156c) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - imageId[");
            sb.append(this.f9156c);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12947e.f9156c, "]", "WCon_FillImageEffect", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9157d, c12947e.f9157d)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - imageHash[");
            sb2.append(this.f9157d);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12947e.f9157d, "]", "WCon_FillImageEffect");
            return false;
        }
        if (!this.f9158e.equals(c12947e.f9158e)) {
            Log.i("WCon_FillImageEffect", " !! equals() - NE - imageNinePatchRect[" + this.f9158e + " - " + c12947e.f9158e + "]");
            return false;
        }
        if (this.f9159f != c12947e.f9159f) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - imageNinePatchWidth[");
            sb3.append(this.f9159f);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12947e.f9159f, "]", "WCon_FillImageEffect", sb3);
            return false;
        }
        RectF rectF = this.f9160g;
        float f = rectF.left;
        RectF rectF2 = c12947e.f9160g;
        if (f != rectF2.left) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - stretchOffset.left[");
            sb4.append(this.f9160g.left);
            sb4.append(" - ");
            AbstractC2821a.m2234y(sb4, c12947e.f9160g.left, "]", "WCon_FillImageEffect");
            return false;
        }
        if (rectF.top != rectF2.top) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - stretchOffset.top[");
            sb5.append(this.f9160g.top);
            sb5.append(" - ");
            AbstractC2821a.m2234y(sb5, c12947e.f9160g.top, "]", "WCon_FillImageEffect");
            return false;
        }
        if (rectF.right != rectF2.right) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - stretchOffset.right[");
            sb6.append(this.f9160g.right);
            sb6.append(" - ");
            AbstractC2821a.m2234y(sb6, c12947e.f9160g.right, "]", "WCon_FillImageEffect");
            return false;
        }
        if (rectF.bottom != rectF2.bottom) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - stretchOffset.bottom[");
            sb7.append(this.f9160g.bottom);
            sb7.append(" - ");
            AbstractC2821a.m2234y(sb7, c12947e.f9160g.bottom, "]", "WCon_FillImageEffect");
            return false;
        }
        if (!this.f9161h.equals(c12947e.f9161h)) {
            Log.i("WCon_FillImageEffect", " !! equals() - NE - tilingOffset[" + this.f9161h + " - " + c12947e.f9161h + "]");
            return false;
        }
        if (this.f9162i != c12947e.f9162i) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - tilingScaleX[");
            sb8.append(this.f9162i);
            sb8.append(" - ");
            AbstractC2821a.m2234y(sb8, c12947e.f9162i, "]", "WCon_FillImageEffect");
            return false;
        }
        if (this.f9163j != c12947e.f9163j) {
            StringBuilder sb9 = new StringBuilder(" !! equals() - NE - tilingScaleY[");
            sb9.append(this.f9163j);
            sb9.append(" - ");
            AbstractC2821a.m2234y(sb9, c12947e.f9163j, "]", "WCon_FillImageEffect");
            return false;
        }
        if (this.f9164k != c12947e.f9164k) {
            StringBuilder sb10 = new StringBuilder(" !! equals() - NE - transparency[");
            sb10.append(this.f9164k);
            sb10.append(" - ");
            AbstractC2821a.m2234y(sb10, c12947e.f9164k, "]", "WCon_FillImageEffect");
            return false;
        }
        if (this.f9165l == c12947e.f9165l) {
            return true;
        }
        StringBuilder sb11 = new StringBuilder(" !! equals() - NE - rotatable[");
        sb11.append(this.f9165l);
        sb11.append(" - ");
        AbstractC11014a.m12339x(sb11, "]", "WCon_FillImageEffect", c12947e.f9165l);
        return false;
    }
}
