package p191j0;

import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenPointD;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p194k0.C12949g;
import p194k0.C12950h;
import p194k0.C12951i;
import p194k0.C12966x;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12929o extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public C12950h f9092U;

    /* JADX INFO: renamed from: V */
    public C12951i f9093V;

    /* JADX INFO: renamed from: W */
    public ArrayList f9094W;

    /* JADX INFO: renamed from: X */
    public ArrayList f9095X;

    /* JADX INFO: renamed from: Y */
    public ArrayList f9096Y;

    public AbstractC12929o(int i, C6906i c6906i) {
        super(i, c6906i);
        this.f9094W = new ArrayList();
        this.f9096Y = new ArrayList();
        this.f9095X = new ArrayList();
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public void mo13805d(C6742k c6742k) {
        super.mo13805d(c6742k);
        ArrayList arrayList = this.f9096Y;
        if (arrayList != null && !arrayList.isEmpty()) {
            c6742k.m4846F("connectionPointList");
            Iterator it = this.f9096Y.iterator();
            while (it.hasNext()) {
                c6742k.m4843B(((C12928n) it.next()).f9090a, "point");
            }
            c6742k.m4856m("connectionPointList");
        }
        ArrayList arrayList2 = this.f9095X;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            c6742k.m4846F("connectedInfoList");
            for (C12928n c12928n : this.f9095X) {
                c6742k.m4846F("connectedInfo");
                c6742k.m4843B(c12928n.f9090a, "point");
                c6742k.m4846F("objectUuidList");
                Iterator it2 = c12928n.f9091b.iterator();
                while (it2.hasNext()) {
                    c6742k.m4867y("uuid", ((C12966x) it2.next()).f9296a);
                }
                c6742k.m4856m("objectUuidList");
                c6742k.m4856m("connectedInfo");
            }
            c6742k.m4856m("connectedInfoList");
        }
        c6742k.m4864v("lineColorEffect", this.f9092U);
        c6742k.m4864v("lineStyleEffect", this.f9093V);
        ArrayList arrayList3 = this.f9094W;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return;
        }
        c6742k.m4846F("slaveUuidList");
        Iterator it3 = this.f9094W.iterator();
        while (it3.hasNext()) {
            String str = ((C12966x) it3.next()).f9296a;
            XmlSerializer xmlSerializer = (XmlSerializer) c6742k.f4110b;
            if (!TextUtils.isEmpty(str)) {
                xmlSerializer.startTag("", "uuid");
                xmlSerializer.attribute("", VElementFormulasCmd.FVAL, str);
                xmlSerializer.endTag("", "uuid");
            }
        }
        c6742k.m4856m("slaveUuidList");
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC12929o)) {
            return false;
        }
        AbstractC12929o abstractC12929o = (AbstractC12929o) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectShapeBase", " !! equals() - NE - super check");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9092U, abstractC12929o.f9092U)) {
            Log.i("WCon_ObjectShapeBase", " !! equals() - NE - mLineColorEffect[" + this.f9092U + " - " + abstractC12929o.f9092U + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9093V, abstractC12929o.f9093V)) {
            Log.i("WCon_ObjectShapeBase", " !! equals() - NE - mLineStyleEffect[" + this.f9093V + " - " + abstractC12929o.f9093V + "]");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f9094W, abstractC12929o.f9094W)) {
            Log.i("WCon_ObjectShapeBase", " !! equals() - NE - mSlaveUuidList[" + this.f9094W + " - " + abstractC12929o.f9094W + "]");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f9095X, abstractC12929o.f9095X)) {
            Log.i("WCon_ObjectShapeBase", " !! equals() - NE - mConnectedList[" + this.f9095X + " - " + abstractC12929o.f9095X + "]");
            return false;
        }
        if (AbstractC0299q.m631h(this.f9096Y, abstractC12929o.f9096Y)) {
            return true;
        }
        Log.i("WCon_ObjectShapeBase", " !! equals() - NE - mConnectionPointInfoList[" + this.f9096Y + " - " + abstractC12929o.f9096Y + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public int mo13812l(C12020a c12020a, int i, int i2) {
        int i4;
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectShapeBase");
            return iMo13812l;
        }
        int i5 = i + iMo13812l;
        int i6 = ((ByteBuffer) c12020a.f8772b).getInt(i5);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i5 + 4);
        int i7 = i5 + 6;
        if (s != 6) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectShapeBase");
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
            int i13 = ((ByteBuffer) c12020a.f8772b).getInt(i12);
            int i14 = i12 + 4;
            ArrayList arrayList = new ArrayList();
            for (int i15 = 0; i15 < i13; i15++) {
                SpenPointD spenPointDM13640m = c12020a.m13640m(i14);
                i14 += 16;
                arrayList.add(new PointF((float) spenPointDM13640m.x, (float) spenPointDM13640m.y));
            }
            int size = this.f9096Y.size();
            for (int i16 = 0; i16 < size && i16 < i13; i16++) {
                C12928n c12928n = (C12928n) this.f9096Y.get(i16);
                if (c12928n == null) {
                    break;
                }
                if (c12928n.f9090a.x != ((PointF) arrayList.get(i16)).x || c12928n.f9090a.y != ((PointF) arrayList.get(i16)).y) {
                    c12928n.f9090a = (PointF) arrayList.get(i16);
                }
            }
            if (size < i13) {
                while (size < i13) {
                    C12928n c12928n2 = new C12928n();
                    c12928n2.f9090a = (PointF) arrayList.get(size);
                    this.f9096Y.add(c12928n2);
                    size++;
                }
            } else if (size > i13) {
                while (this.f9096Y.size() > i13) {
                    this.f9096Y.remove((C12928n) this.f9096Y.get(this.f9096Y.size() - 1));
                }
            }
            this.f9095X.clear();
            int i17 = ((ByteBuffer) c12020a.f8772b).getInt(i14 + 4);
            int iM13870a = i14 + 8;
            int i18 = 0;
            while (i18 < i17) {
                C12928n c12928n3 = new C12928n();
                SpenPointD spenPointDM13640m2 = c12020a.m13640m(iM13870a);
                int i19 = i5;
                int i20 = i6;
                c12928n3.f9090a = new PointF((float) spenPointDM13640m2.x, (float) spenPointDM13640m2.y);
                c12928n3.f9091b.clear();
                int i21 = ((ByteBuffer) c12020a.f8772b).getInt(iM13870a + 16);
                iM13870a += 20;
                for (int i22 = 0; i22 < i21; i22++) {
                    C12966x c12966x = new C12966x();
                    iM13870a += c12966x.m13870a(c12020a, iM13870a);
                    c12928n3.f9091b.add(c12966x);
                }
                this.f9095X.add(c12928n3);
                i18++;
                i5 = i19;
                i6 = i20;
            }
            int i23 = i5;
            int i24 = i6;
            if (i8 != 0) {
                int i25 = i23 + i8;
                if ((b6 & 4) != 0) {
                    int i26 = ((ByteBuffer) c12020a.f8772b).getInt(i25);
                    int i27 = i25 + 4;
                    C12950h c12950h = new C12950h();
                    this.f9092U = c12950h;
                    int i28 = i25 + 6;
                    c12950h.f9177f = ((ByteBuffer) c12020a.f8772b).get(i25 + 5) == 1;
                    c12950h.f9172a = ((ByteBuffer) c12020a.f8772b).get(i28);
                    c12950h.f9173b = ((ByteBuffer) c12020a.f8772b).getInt(i25 + 7);
                    c12950h.f9174c = ((ByteBuffer) c12020a.f8772b).get(i25 + 11);
                    c12950h.f9175d = ((ByteBuffer) c12020a.f8772b).getShort(i25 + 12);
                    c12950h.f9176e = c12020a.m13638k(i25 + 14);
                    int i29 = i25 + 22;
                    int i30 = i25 + 23;
                    byte b7 = ((ByteBuffer) c12020a.f8772b).get(i29);
                    ArrayList arrayList2 = c12950h.f9178g;
                    arrayList2.clear();
                    for (int i31 = 0; i31 < b7; i31++) {
                        C12949g c12949g = new C12949g();
                        c12949g.f9170a = ((ByteBuffer) c12020a.f8772b).getInt(i30);
                        c12949g.f9171b = ((ByteBuffer) c12020a.f8772b).getFloat(i30 + 4);
                        i30 += 8;
                        arrayList2.add(c12949g);
                    }
                    i25 = i27 + i26;
                }
                if ((b6 & 8) != 0) {
                    int i32 = ((ByteBuffer) c12020a.f8772b).getInt(i25);
                    int i33 = i25 + 4;
                    C12951i c12951i = new C12951i();
                    this.f9093V = c12951i;
                    c12951i.f9179a = ((ByteBuffer) c12020a.f8772b).getFloat(i33);
                    c12951i.f9180b = ((ByteBuffer) c12020a.f8772b).get(i25 + 8);
                    c12951i.f9181c = ((ByteBuffer) c12020a.f8772b).get(i25 + 9);
                    c12951i.f9182d = ((ByteBuffer) c12020a.f8772b).get(i25 + 10);
                    c12951i.f9183e = ((ByteBuffer) c12020a.f8772b).get(i25 + 11);
                    c12951i.f9184f = ((ByteBuffer) c12020a.f8772b).get(i25 + 12);
                    c12951i.f9185g = ((ByteBuffer) c12020a.f8772b).get(i25 + 13);
                    c12951i.f9186h = ((ByteBuffer) c12020a.f8772b).get(i25 + 14);
                    c12951i.f9187i = ((ByteBuffer) c12020a.f8772b).get(i25 + 15);
                    i25 = i33 + i32;
                }
                if ((b6 & 128) != 0) {
                    short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i25);
                    int iM13870a2 = i25 + 2;
                    for (int i34 = 0; i34 < s2; i34++) {
                        C12966x c12966x2 = new C12966x();
                        iM13870a2 += c12966x2.m13870a(c12020a, iM13870a2);
                        this.f9094W.add(c12966x2);
                    }
                }
            }
            i4 = i24;
        }
        if (i4 >= 0) {
            return i4 + iMo13812l;
        }
        AbstractC0541b.m758D(i4, "ObjectShapeBase newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectShapeBase");
        return i4;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectShapeBase");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int size = this.f9096Y.size();
        c12020a.m13649v(iMo13814n + 14, size);
        int i4 = iMo13814n + 18;
        SpenPointD spenPointD = new SpenPointD();
        for (int i5 = 0; i5 < size; i5++) {
            spenPointD.set(((C12928n) this.f9096Y.get(i5)).f9090a);
            c12020a.m13652y(i4, spenPointD);
            i4 += 16;
        }
        int i6 = i4 + 4;
        int size2 = this.f9095X.size();
        c12020a.m13649v(i6, size2);
        int iM13871b = i4 + 8;
        if (!this.f9095X.isEmpty()) {
            for (int i7 = 0; i7 < size2; i7++) {
                C12928n c12928n = (C12928n) this.f9095X.get(i7);
                int size3 = c12928n.f9091b.size();
                spenPointD.set(c12928n.f9090a);
                c12020a.m13652y(iM13871b, spenPointD);
                c12020a.m13649v(iM13871b + 16, size3);
                iM13871b += 20;
                for (int i8 = 0; i8 < size3; i8++) {
                    iM13871b += ((C12966x) c12928n.f9091b.get(i8)).m13871b(c12020a, iM13871b);
                }
            }
        }
        c12020a.m13649v(i4, iM13871b - i6);
        c12020a.m13646s(iM13871b, 0);
        int iM13871b2 = iM13871b + 1;
        int i9 = iM13871b2 - iMo13814n;
        C12950h c12950h = this.f9092U;
        if (c12950h != null) {
            c12020a.m13649v(iM13871b2, (c12950h.f9178g.size() * 8) + 19);
            int i10 = iM13871b + 5;
            C12950h c12950h2 = this.f9092U;
            c12950h2.getClass();
            c12020a.m13646s(i10, 1);
            c12020a.m13646s(iM13871b + 6, c12950h2.f9177f ? 1 : 0);
            c12020a.m13646s(iM13871b + 7, c12950h2.f9172a);
            c12020a.m13649v(iM13871b + 8, c12950h2.f9173b);
            c12020a.m13646s(iM13871b + 12, c12950h2.f9174c);
            c12020a.m13647t(iM13871b + 13, c12950h2.f9175d);
            c12020a.m13650w(iM13871b + 15, c12950h2.f9176e);
            ArrayList<C12949g> arrayList = c12950h2.f9178g;
            c12020a.m13646s(iM13871b + 23, arrayList.size());
            int i11 = iM13871b + 24;
            for (C12949g c12949g : arrayList) {
                c12020a.m13649v(i11, c12949g.f9170a);
                c12020a.m13648u(c12949g.f9171b, i11 + 4);
                i11 += 8;
            }
            iM13871b2 = i10 + (i11 - i10);
            i2 = 4;
        } else {
            i2 = 0;
        }
        if (this.f9093V != null) {
            c12020a.m13649v(iM13871b2, 12);
            int i12 = iM13871b2 + 4;
            C12951i c12951i = this.f9093V;
            c12020a.m13648u(c12951i.f9179a, i12);
            c12020a.m13646s(iM13871b2 + 8, c12951i.f9180b);
            c12020a.m13646s(iM13871b2 + 9, c12951i.f9181c);
            c12020a.m13646s(iM13871b2 + 10, c12951i.f9182d);
            c12020a.m13646s(iM13871b2 + 11, c12951i.f9183e);
            c12020a.m13646s(iM13871b2 + 12, c12951i.f9184f);
            c12020a.m13646s(iM13871b2 + 13, c12951i.f9185g);
            c12020a.m13646s(iM13871b2 + 14, c12951i.f9186h);
            c12020a.m13646s(iM13871b2 + 15, c12951i.f9187i);
            iM13871b2 = ((iM13871b2 + 16) - i12) + i12;
            i2 |= 8;
        }
        int size4 = this.f9094W.size();
        if (size4 > 0) {
            c12020a.m13647t(iM13871b2, size4);
            iM13871b2 += 2;
            Iterator it = this.f9094W.iterator();
            while (it.hasNext()) {
                iM13871b2 += ((C12966x) it.next()).m13871b(c12020a, iM13871b2);
            }
            i2 |= 128;
        }
        int i13 = iM13871b2 - iMo13814n;
        if (i2 == 0) {
            i9 = 0;
        }
        c12020a.m13649v(iMo13814n, i13);
        c12020a.m13647t(iMo13814n + 4, 6);
        c12020a.m13649v(iMo13814n + 6, i9);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, 0);
        c12020a.m13646s(iMo13814n + 12, 1);
        c12020a.m13646s(iMo13814n + 13, i2);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public int mo13814n() {
        int iMo13814n = super.mo13814n();
        int size = this.f9096Y.size() * 16;
        int size2 = this.f9095X.size();
        int i = size + 26;
        for (int i2 = 0; i2 < size2; i2++) {
            i += 20;
            Iterator it = ((C12928n) this.f9095X.get(i2)).f9091b.iterator();
            while (it.hasNext()) {
                ((C12966x) it.next()).getClass();
                i += 38;
            }
        }
        int size3 = i + 1;
        C12950h c12950h = this.f9092U;
        if (c12950h != null) {
            size3 = (c12950h.f9178g.size() * 8) + 19 + i + 5;
        }
        if (this.f9093V != null) {
            size3 += 16;
        }
        if (!this.f9094W.isEmpty()) {
            size3 += 2;
            Iterator it2 = this.f9094W.iterator();
            while (it2.hasNext()) {
                ((C12966x) it2.next()).getClass();
                size3 += 38;
            }
        }
        return iMo13814n + size3;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public void mo13816p(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        xmlPullParser.require(2, null, null);
        if (eventType != 2) {
            return;
        }
        String name = xmlPullParser.getName();
        if (name.equalsIgnoreCase("connectionPointList")) {
            this.f9096Y = new ArrayList();
            AbstractC14517a.m15118C(xmlPullParser);
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("connectionPointList")) {
                    return;
                }
                C12928n c12928n = new C12928n();
                c12928n.f9090a = AbstractC14517a.m15124I(xmlPullParser);
                this.f9096Y.add(c12928n);
                eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            }
        } else {
            int i = 4;
            if (name.equalsIgnoreCase("connectedInfoList")) {
                this.f9095X = new ArrayList();
                AbstractC14517a.m15118C(xmlPullParser);
                while (true) {
                    if (eventType == 3 && xmlPullParser.getName().equals("connectedInfoList")) {
                        return;
                    }
                    C12928n c12928n2 = new C12928n();
                    int eventType2 = xmlPullParser.getEventType();
                    xmlPullParser.require(2, null, "connectedInfo");
                    while (true) {
                        if (eventType2 != 3 || !xmlPullParser.getName().equals("connectedInfo")) {
                            if (eventType2 == 2) {
                                String name2 = xmlPullParser.getName();
                                if (!name2.equalsIgnoreCase("connectedInfo")) {
                                    if (name2.equalsIgnoreCase("point")) {
                                        c12928n2.f9090a = AbstractC14517a.m15124I(xmlPullParser);
                                    } else if (name2.equalsIgnoreCase("objectUuidList")) {
                                        int iM15118C = AbstractC14517a.m15118C(xmlPullParser);
                                        while (true) {
                                            if (iM15118C != 3 || !xmlPullParser.getName().equals("objectUuidList")) {
                                                C12966x c12966x = new C12966x();
                                                c12966x.f9296a = AbstractC14517a.m15123H(xmlPullParser);
                                                c12928n2.f9091b.add(c12966x);
                                                iM15118C = AbstractC14517a.m15119D(xmlPullParser, 1);
                                            }
                                        }
                                    }
                                }
                            } else if (eventType2 != 3 && eventType2 != 4) {
                                AbstractC2322a.m1632v(eventType2, "parseXml - invalid eventType = [", "]", "WCon_ObjectShapeBase");
                            }
                            eventType2 = AbstractC14517a.m15119D(xmlPullParser, 1);
                        }
                    }
                    this.f9095X.add(c12928n2);
                    eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
                }
            } else if (name.equalsIgnoreCase("lineColorEffect")) {
                C12950h c12950h = new C12950h();
                this.f9092U = c12950h;
                xmlPullParser.require(2, null, "lineColorEffect");
                int attributeCount = xmlPullParser.getAttributeCount();
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    String attributeName = xmlPullParser.getAttributeName(i2);
                    if (attributeName.equalsIgnoreCase("colorType")) {
                        c12950h.f9172a = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i2));
                    } else if (attributeName.equalsIgnoreCase("gradientRotatable")) {
                        c12950h.f9177f = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i2));
                    } else if (attributeName.equalsIgnoreCase("solidColor")) {
                        c12950h.f9173b = (int) Long.parseLong(xmlPullParser.getAttributeValue(i2));
                    } else if (attributeName.equalsIgnoreCase("gradientType")) {
                        c12950h.f9174c = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i2));
                    } else if (attributeName.equalsIgnoreCase("angle")) {
                        c12950h.f9175d = Integer.parseInt(xmlPullParser.getAttributeValue(i2));
                    }
                }
                int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
                while (true) {
                    if (iM15119D == 3 && xmlPullParser.getName().equals("lineColorEffect")) {
                        return;
                    }
                    if (iM15119D == 2) {
                        int eventType3 = xmlPullParser.getEventType();
                        String name3 = xmlPullParser.getName();
                        if (name3.equalsIgnoreCase("radialGradientPosition")) {
                            c12950h.f9176e = AbstractC14517a.m15124I(xmlPullParser);
                        } else if (name3.equalsIgnoreCase("gradientColorInfoList")) {
                            ArrayList arrayList = c12950h.f9178g;
                            arrayList.clear();
                            AbstractC14517a.m15118C(xmlPullParser);
                            while (true) {
                                if (eventType3 != 3 || !xmlPullParser.getName().equals("gradientColorInfoList")) {
                                    C12949g c12949g = new C12949g();
                                    int attributeCount2 = xmlPullParser.getAttributeCount();
                                    for (int i4 = 0; i4 < attributeCount2; i4++) {
                                        String attributeName2 = xmlPullParser.getAttributeName(i4);
                                        if (attributeName2.equalsIgnoreCase("color")) {
                                            c12949g.f9170a = (int) Long.parseLong(xmlPullParser.getAttributeValue(i4));
                                        } else if (attributeName2.equalsIgnoreCase("position")) {
                                            c12949g.f9171b = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i4));
                                        }
                                    }
                                    arrayList.add(c12949g);
                                    eventType3 = AbstractC14517a.m15119D(xmlPullParser, 2);
                                }
                            }
                        }
                    } else if (iM15119D != 3 && iM15119D != i) {
                        AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_LineColorEffect");
                    }
                    iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
                    i = 4;
                }
            } else {
                if (name.equalsIgnoreCase("lineStyleEffect")) {
                    C12951i c12951i = new C12951i();
                    this.f9093V = c12951i;
                    xmlPullParser.require(2, null, "lineStyleEffect");
                    int attributeCount3 = xmlPullParser.getAttributeCount();
                    for (int i5 = 0; i5 < attributeCount3; i5++) {
                        String attributeName3 = xmlPullParser.getAttributeName(i5);
                        if (attributeName3.equalsIgnoreCase("width")) {
                            c12951i.f9179a = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("compoundType")) {
                            c12951i.f9180b = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("dashType")) {
                            c12951i.f9181c = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("capType")) {
                            c12951i.f9182d = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("joinType")) {
                            c12951i.f9183e = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("beginArrowType")) {
                            c12951i.f9184f = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("beginArrowSize")) {
                            c12951i.f9185g = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("endArrowType")) {
                            c12951i.f9186h = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        } else if (attributeName3.equalsIgnoreCase("endArrowSize")) {
                            c12951i.f9187i = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i5));
                        }
                    }
                    return;
                }
                if (!name.equalsIgnoreCase("slaveUuidList")) {
                    super.mo13816p(xmlPullParser);
                    return;
                }
                this.f9094W = new ArrayList();
                AbstractC14517a.m15118C(xmlPullParser);
                while (true) {
                    if (eventType == 3 && xmlPullParser.getName().equals("slaveUuidList")) {
                        return;
                    }
                    C12966x c12966x2 = new C12966x();
                    c12966x2.f9296a = AbstractC14517a.m15128M(xmlPullParser);
                    this.f9094W.add(c12966x2);
                    eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
                }
            }
        }
    }
}
