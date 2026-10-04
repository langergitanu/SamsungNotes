package p191j0;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenPointD;
import com.samsung.android.sdk.pen.base.SpenRectD;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p186h1.C12020a;
import p194k0.C12958p;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12921g extends AbstractC12929o {

    /* JADX INFO: renamed from: Z */
    public int f9041Z;

    /* JADX INFO: renamed from: a0 */
    public int f9042a0;

    /* JADX INFO: renamed from: b0 */
    public ArrayList f9043b0;

    /* JADX INFO: renamed from: c0 */
    public PointF f9044c0;

    /* JADX INFO: renamed from: d0 */
    public PointF f9045d0;

    /* JADX INFO: renamed from: e0 */
    public RectF f9046e0;

    /* JADX INFO: renamed from: f0 */
    public RectF f9047f0;

    /* JADX INFO: renamed from: g0 */
    public float f9048g0;

    /* JADX INFO: renamed from: h0 */
    public int f9049h0;

    /* JADX INFO: renamed from: i0 */
    public int f9050i0;

    /* JADX INFO: renamed from: j0 */
    public int f9051j0;

    /* JADX INFO: renamed from: k0 */
    public C12958p f9052k0;

    public C12921g(C6906i c6906i) {
        super(8, c6906i);
        this.f9049h0 = -1;
        this.f9050i0 = -1;
        this.f9051j0 = -1;
        this.f9043b0 = new ArrayList();
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        c6742k.m4848d(this.f9041Z, "connectorType");
        c6742k.m4848d(this.f9042a0, "startDirection");
        c6742k.m4849e("originalDegree", this.f9048g0);
        int i = this.f9051j0;
        if (i != -1) {
            c6742k.m4848d(i, "penName");
        }
        int i2 = this.f9049h0;
        if (i2 != -1) {
            c6742k.m4848d(i2, "defaultPenName");
        }
        int i4 = this.f9050i0;
        if (i4 != -1) {
            c6742k.m4848d(i4, "penStyle");
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws SyncException, IOException {
        super.mo13805d(c6742k);
        c6742k.m4842A(this.f9043b0);
        c6742k.m4843B(this.f9044c0, "beginPos");
        c6742k.m4843B(this.f9045d0, "endPos");
        c6742k.m4845D("originalDrawnRect", this.f9046e0);
        c6742k.m4845D("originalRect", this.f9047f0);
        C12958p c12958p = this.f9052k0;
        if (c12958p != null) {
            c6742k.m4864v("path", c12958p);
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) {
        int i4;
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectLine");
            return iMo13812l;
        }
        int i5 = i + iMo13812l;
        int i6 = ((ByteBuffer) c12020a.f8772b).getInt(i5);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i5 + 4);
        int i7 = i5 + 6;
        char c = '\b';
        if (s != 8) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectLine");
            i4 = -1;
        } else {
            int i8 = ((ByteBuffer) c12020a.f8772b).getInt(i7);
            int i9 = i5 + 11;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i5 + 10);
            c12020a.m13636i(i9);
            int i10 = b + i9;
            int i11 = i10 + 1;
            byte b5 = ((ByteBuffer) c12020a.f8772b).get(i10);
            byte b6 = ((ByteBuffer) c12020a.f8772b).get(i11);
            int i12 = i11 + b5;
            this.f9041Z = ((ByteBuffer) c12020a.f8772b).get(i12);
            int i13 = i12 + 2;
            this.f9042a0 = ((ByteBuffer) c12020a.f8772b).get(i12 + 1);
            int i14 = i12 + 3;
            byte b7 = ((ByteBuffer) c12020a.f8772b).get(i13);
            this.f9043b0.clear();
            int i15 = 0;
            while (i15 < b7) {
                SpenPointD spenPointDM13640m = c12020a.m13640m(i14);
                this.f9043b0.add(new PointF((float) spenPointDM13640m.x, (float) spenPointDM13640m.y));
                i15++;
                c = c;
                i14 += 16;
                i5 = i5;
                i6 = i6;
            }
            int i16 = i5;
            int i17 = i6;
            SpenPointD spenPointDM13640m2 = c12020a.m13640m(i14);
            this.f9044c0 = new PointF((float) spenPointDM13640m2.x, (float) spenPointDM13640m2.y);
            SpenPointD spenPointDM13640m3 = c12020a.m13640m(i14 + 16);
            this.f9045d0 = new PointF((float) spenPointDM13640m3.x, (float) spenPointDM13640m3.y);
            SpenRectD spenRectDM13642o = c12020a.m13642o(i14 + 32);
            this.f9046e0 = new RectF((float) spenRectDM13642o.left, (float) spenRectDM13642o.top, (float) spenRectDM13642o.right, (float) spenRectDM13642o.bottom);
            SpenRectD spenRectDM13642o2 = c12020a.m13642o(i14 + 64);
            this.f9047f0 = new RectF((float) spenRectDM13642o2.left, (float) spenRectDM13642o2.top, (float) spenRectDM13642o2.right, (float) spenRectDM13642o2.bottom);
            this.f9048g0 = ((ByteBuffer) c12020a.f8772b).getFloat(i14 + 96);
            if (i8 != 0) {
                int i18 = i16 + i8;
                if ((b6 & 1) != 0) {
                    this.f9049h0 = ((ByteBuffer) c12020a.f8772b).getInt(i18);
                    i18 += 4;
                }
                if ((b6 & 2) != 0) {
                    this.f9050i0 = ((ByteBuffer) c12020a.f8772b).getInt(i18);
                    i18 += 4;
                }
                if ((b6 & 4) != 0) {
                    this.f9051j0 = ((ByteBuffer) c12020a.f8772b).getInt(i18);
                    i18 += 4;
                }
                if (this.f9051j0 == -1) {
                    this.f9051j0 = this.f9049h0;
                }
                if ((b6 & 8) != 0) {
                    C12958p c12958p = new C12958p();
                    this.f9052k0 = c12958p;
                    c12958p.m13850b(c12020a, i18);
                }
            }
            i4 = i17;
        }
        if (i4 >= 0) {
            return i4 + iMo13812l;
        }
        AbstractC0541b.m758D(i4, "ObjectLine newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectLine");
        return i4;
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectLine");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        c12020a.m13646s(iMo13814n + 14, this.f9041Z);
        c12020a.m13646s(iMo13814n + 15, this.f9042a0);
        int i4 = iMo13814n + 17;
        c12020a.m13646s(iMo13814n + 16, this.f9043b0.size());
        SpenPointD spenPointD = new SpenPointD();
        Iterator it = this.f9043b0.iterator();
        while (it.hasNext()) {
            spenPointD.set((PointF) it.next());
            c12020a.m13652y(i4, spenPointD);
            i4 += 16;
        }
        spenPointD.set(this.f9044c0);
        c12020a.m13652y(i4, spenPointD);
        spenPointD.set(this.f9045d0);
        c12020a.m13652y(i4 + 16, spenPointD);
        c12020a.m13622A(i4 + 32, new SpenRectD(this.f9046e0));
        c12020a.m13622A(i4 + 64, new SpenRectD(this.f9047f0));
        c12020a.m13648u(this.f9048g0, i4 + 96);
        int iM13851c = i4 + 100;
        int i5 = iM13851c - iMo13814n;
        int i6 = this.f9049h0;
        if (i6 != -1) {
            c12020a.m13649v(iM13851c, i6);
            iM13851c = i4 + 104;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i7 = this.f9050i0;
        if (i7 != -1) {
            c12020a.m13649v(iM13851c, i7);
            iM13851c += 4;
            i2 |= 2;
        }
        int i8 = this.f9051j0;
        if (i8 != -1) {
            c12020a.m13649v(iM13851c, i8);
            iM13851c += 4;
            i2 |= 4;
        }
        C12958p c12958p = this.f9052k0;
        if (c12958p != null) {
            iM13851c += c12958p.m13851c(c12020a, iM13851c);
            i2 |= 8;
        }
        int i9 = iM13851c - iMo13814n;
        if (i2 == 0) {
            i5 = 0;
        }
        c12020a.m13649v(iMo13814n, i9);
        c12020a.m13647t(iMo13814n + 4, 8);
        c12020a.m13649v(iMo13814n + 6, i5);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, 0);
        c12020a.m13646s(iMo13814n + 12, 1);
        c12020a.m13646s(iMo13814n + 13, i2);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        int iMo13814n = super.mo13814n();
        int size = this.f9043b0.size() * 16;
        int iM13852d = size + 117;
        if (this.f9049h0 != -1) {
            iM13852d = size + 121;
        }
        if (this.f9050i0 != -1) {
            iM13852d += 4;
        }
        if (this.f9051j0 != -1) {
            iM13852d += 4;
        }
        C12958p c12958p = this.f9052k0;
        if (c12958p != null) {
            iM13852d += c12958p.m13852d();
        }
        return iMo13814n + iM13852d;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equalsIgnoreCase("connectorType")) {
            this.f9041Z = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("startDirection")) {
            this.f9042a0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("originalDegree")) {
            this.f9048g0 = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("penName")) {
            this.f9051j0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("defaultPenName")) {
            this.f9049h0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("penStyle")) {
            this.f9050i0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        int eventType = xmlPullParser.getEventType();
        if (!name.equalsIgnoreCase("controlPointList")) {
            if (name.equalsIgnoreCase("beginPos")) {
                this.f9044c0 = AbstractC14517a.m15124I(xmlPullParser);
                return;
            }
            if (name.equalsIgnoreCase("endPos")) {
                this.f9045d0 = AbstractC14517a.m15124I(xmlPullParser);
                return;
            }
            if (name.equalsIgnoreCase("originalDrawnRect")) {
                this.f9046e0 = AbstractC14517a.m15127L(xmlPullParser);
                return;
            }
            if (name.equalsIgnoreCase("originalRect")) {
                this.f9047f0 = AbstractC14517a.m15127L(xmlPullParser);
                return;
            } else {
                if (!name.equalsIgnoreCase("path")) {
                    super.mo13816p(xmlPullParser);
                    return;
                }
                C12958p c12958p = new C12958p();
                this.f9052k0 = c12958p;
                c12958p.m13853e(xmlPullParser);
                return;
            }
        }
        this.f9043b0 = new ArrayList();
        AbstractC14517a.m15118C(xmlPullParser);
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("controlPointList")) {
                return;
            }
            this.f9043b0.add(AbstractC14517a.m15124I(xmlPullParser));
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }
}
