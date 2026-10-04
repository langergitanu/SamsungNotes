package p191j0;

import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12926l extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public RectF f9075U;

    /* JADX INFO: renamed from: V */
    public int f9076V;

    /* JADX INFO: renamed from: W */
    public int f9077W;

    /* JADX INFO: renamed from: X */
    public final ArrayList f9078X;

    /* JADX INFO: renamed from: Y */
    public int f9079Y;

    public C12926l(C6906i c6906i) {
        super(20, c6906i);
        this.f9079Y = 0;
        this.f9078X = new ArrayList();
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        int i = this.f9076V;
        if (i != 0) {
            c6742k.m4848d(i, "coordinateColor");
        }
        int i2 = this.f9077W;
        if (i2 != 0) {
            c6742k.m4848d(i2, "backgroundColor");
        }
        int i4 = this.f9079Y;
        if (i4 != 0) {
            c6742k.m4848d(i4, "angleType");
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        RectF rectF = this.f9075U;
        if (rectF != null) {
            c6742k.m4845D("coordinateRect", rectF);
        }
        ArrayList<C12925k> arrayList = this.f9078X;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        c6742k.m4846F("graphDataList");
        for (C12925k c12925k : arrayList) {
            c6742k.m4846F("graph");
            c6742k.m4851h(HtmlConstants.LATEX, Base64Utils.encodeBase64(c12925k.f9071a));
            c6742k.m4848d(c12925k.f9072b, "color");
            c6742k.m4849e("lineWidth", c12925k.f9073c);
            c6742k.m4852i("isShow", c12925k.f9074d);
            c6742k.m4856m("graph");
        }
        c6742k.m4856m("graphDataList");
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12926l)) {
            return false;
        }
        C12926l c12926l = (C12926l) obj;
        ArrayList arrayList = c12926l.f9078X;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectPlot", " !! equals() - NE - super check");
            return false;
        }
        if (!TextUtils.equals(null, null)) {
            Log.i("WCon_ObjectPlot", " !! equals() - NE - mImageHash[null - null]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9075U, c12926l.f9075U)) {
            Log.i("WCon_ObjectPlot", " !! equals() - NE - mCoordinateRect[null - null]");
            return false;
        }
        if (this.f9076V != c12926l.f9076V) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mCoordinateColor[");
            sb.append(this.f9076V);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12926l.f9076V, "]", "WCon_ObjectPlot", sb);
            return false;
        }
        if (this.f9077W != c12926l.f9077W) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mBackgroundColor[");
            sb2.append(this.f9077W);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12926l.f9077W, "]", "WCon_ObjectPlot", sb2);
            return false;
        }
        ArrayList arrayList2 = this.f9078X;
        if (AbstractC0299q.m631h(arrayList2, arrayList)) {
            if (this.f9079Y == c12926l.f9079Y) {
                return true;
            }
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mAngleType[");
            sb3.append(this.f9079Y);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12926l.f9079Y, "]", "WCon_ObjectPlot", sb3);
            return false;
        }
        Log.i("WCon_ObjectPlot", " !! equals() - NE - mGraphDataList[" + arrayList2 + " - " + arrayList + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase::NewApplyBinary() fail. baseSize: ", "WCon_ObjectPlot");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 20) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectPlot");
            i5 = -1;
        } else {
            int i7 = ((ByteBuffer) c12020a.f8772b).getInt(i6);
            int i8 = i4 + 11;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i4 + 10);
            c12020a.m13636i(i8);
            int i9 = b + i8;
            ((ByteBuffer) c12020a.f8772b).get(i9);
            short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i9 + 1);
            if (i7 != 0) {
                int i10 = i4 + i7;
                if ((s2 & 1) != 0) {
                    i10 += 4;
                }
                if ((s2 & 2) != 0) {
                    SpenRectD spenRectDM13642o = c12020a.m13642o(i10);
                    this.f9075U = new RectF((float) spenRectDM13642o.left, (float) spenRectDM13642o.top, (float) spenRectDM13642o.right, (float) spenRectDM13642o.bottom);
                    i10 += 32;
                }
                if ((s2 & 4) != 0) {
                    this.f9076V = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 8) != 0) {
                    this.f9077W = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 16) != 0) {
                    int i11 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                    if (i11 > 0) {
                        ArrayList arrayList = this.f9078X;
                        arrayList.clear();
                        for (int i12 = 0; i12 < i11; i12++) {
                            C12925k c12925k = new C12925k();
                            String strM13644q = c12020a.m13644q(i10 + 2, c12020a.m13637j(i10));
                            c12925k.f9071a = strM13644q;
                            int iM13621f = C12020a.m13621f(strM13644q) + i10;
                            c12925k.f9072b = ((ByteBuffer) c12020a.f8772b).getInt(iM13621f);
                            c12925k.f9073c = ((ByteBuffer) c12020a.f8772b).getFloat(iM13621f + 4);
                            boolean z = true;
                            if (((ByteBuffer) c12020a.f8772b).get(iM13621f + 8) != 1) {
                                z = false;
                            }
                            c12925k.f9074d = z;
                            i10 = iM13621f + 9;
                            arrayList.add(c12925k);
                        }
                    }
                }
                if ((s2 & 32) != 0) {
                    this.f9079Y = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                }
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectPlot::NewApplyBinary() fail to apply own binary. ", "WCon_ObjectPlot");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectPlot");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int i4 = iMo13814n + 15;
        int i5 = i4 - iMo13814n;
        RectF rectF = this.f9075U;
        if (rectF == null || (rectF.left == 0.0f && rectF.top == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f)) {
            i2 = 0;
        } else {
            c12020a.m13622A(i4, new SpenRectD(rectF));
            i4 = iMo13814n + 47;
            i2 = 2;
        }
        int i6 = this.f9076V;
        if (i6 != -16777216) {
            c12020a.m13649v(i4, i6);
            i4 += 4;
            i2 |= 4;
        }
        int i7 = this.f9077W;
        if (i7 != -16777216) {
            c12020a.m13649v(i4, i7);
            i4 += 4;
            i2 |= 8;
        }
        ArrayList<C12925k> arrayList = this.f9078X;
        int size = arrayList.size();
        if (size > 0) {
            c12020a.m13649v(i4, size);
            i4 += 4;
            for (C12925k c12925k : arrayList) {
                int iM13624C = c12020a.m13624C(i4, c12925k.f9071a) + i4;
                c12020a.m13649v(iM13624C, c12925k.f9072b);
                c12020a.m13648u(c12925k.f9073c, iM13624C + 4);
                c12020a.m13646s(iM13624C + 8, c12925k.f9074d ? 1 : 0);
                i4 = iM13624C + 9;
            }
            i2 |= 16;
        }
        int i8 = this.f9079Y;
        if (i8 != 0) {
            c12020a.m13649v(i4, i8);
            i4 += 4;
            i2 |= 32;
        }
        int i9 = i4 - iMo13814n;
        if ((i2 & 255) == 0) {
            i5 = 0;
        }
        c12020a.m13649v(iMo13814n, i9);
        c12020a.m13647t(iMo13814n + 4, 20);
        c12020a.m13649v(iMo13814n + 6, i5);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, 0);
        c12020a.m13646s(iMo13814n + 12, 2);
        c12020a.m13647t(iMo13814n + 13, i2);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        int iMo13814n = super.mo13814n();
        RectF rectF = this.f9075U;
        int length = (rectF == null || (rectF.left == 0.0f && rectF.top == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f)) ? 15 : 47;
        if (this.f9076V != -16777216) {
            length += 4;
        }
        if (this.f9077W != -16777216) {
            length += 4;
        }
        ArrayList arrayList = this.f9078X;
        if (arrayList.size() > 0) {
            length += 4;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                length = ((C12925k) it.next()).f9071a.getBytes().length + 2 + length + 9;
            }
        }
        if (this.f9079Y != 0) {
            length += 4;
        }
        return iMo13814n + length;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equalsIgnoreCase("imageHash")) {
            return;
        }
        if (attributeName.equalsIgnoreCase("coordinateColor")) {
            this.f9076V = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("backgroundColor")) {
            this.f9077W = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("angleType")) {
            this.f9079Y = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        int eventType = xmlPullParser.getEventType();
        if (name.equalsIgnoreCase("coordinateRect")) {
            this.f9075U = AbstractC14517a.m15127L(xmlPullParser);
            return;
        }
        if (!name.equalsIgnoreCase("graphDataList")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        ArrayList arrayList = this.f9078X;
        arrayList.clear();
        AbstractC14517a.m15118C(xmlPullParser);
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("graphDataList")) {
                return;
            }
            C12925k c12925k = new C12925k();
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                if (attributeName.equalsIgnoreCase(HtmlConstants.LATEX)) {
                    c12925k.f9071a = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
                } else if (attributeName.equalsIgnoreCase("color")) {
                    c12925k.f9072b = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                } else if (attributeName.equalsIgnoreCase("lineWidth")) {
                    c12925k.f9073c = Float.parseFloat(xmlPullParser.getAttributeValue(i));
                } else if (attributeName.equalsIgnoreCase("isShow")) {
                    c12925k.f9074d = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                }
            }
            arrayList.add(c12925k);
            eventType = AbstractC14517a.m15119D(xmlPullParser, 2);
        }
    }
}
