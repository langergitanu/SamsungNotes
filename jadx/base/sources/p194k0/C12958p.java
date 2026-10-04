package p194k0;

import android.graphics.PointF;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.sdk.pen.base.SpenPointD;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12958p implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public ArrayList f9242a = new ArrayList();

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws SyncException {
        try {
            c6742k.m4846F("segmentList");
            for (C12957o c12957o : this.f9242a) {
                c6742k.m4846F("segment");
                c6742k.m4848d(c12957o.f9235a, "type");
                int i = c12957o.f9235a;
                if (i == 1 || i == 2) {
                    c6742k.m4849e("x", c12957o.f9236b);
                    c6742k.m4849e("y", c12957o.f9237c);
                } else if (i == 3) {
                    c6742k.m4849e("x", c12957o.f9236b);
                    c6742k.m4849e("y", c12957o.f9237c);
                    c6742k.m4849e("x2", c12957o.f9240f);
                    c6742k.m4849e("y2", c12957o.f9241g);
                } else if (i == 4 || i == 5) {
                    c6742k.m4849e("x", c12957o.f9236b);
                    c6742k.m4849e("y", c12957o.f9237c);
                    c6742k.m4849e("x1", c12957o.f9238d);
                    c6742k.m4849e("y1", c12957o.f9239e);
                    c6742k.m4849e("x2", c12957o.f9240f);
                    c6742k.m4849e("y2", c12957o.f9241g);
                } else if (i == 7) {
                    c6742k.m4849e("x", c12957o.f9236b);
                    c6742k.m4849e("y", c12957o.f9237c);
                    c6742k.m4849e("x1", c12957o.f9238d);
                    c6742k.m4849e("y1", c12957o.f9239e);
                }
                c6742k.m4856m("segment");
            }
            c6742k.m4856m("segmentList");
        } catch (IOException e) {
            Debugger.m8609e("WCon_Path", "composeXml : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m13850b(C12020a c12020a, int i) {
        this.f9242a.clear();
        int i2 = ((ByteBuffer) c12020a.f8772b).getInt(i);
        int i4 = i + 4;
        for (int i5 = 0; i5 < i2; i5++) {
            C12957o c12957o = new C12957o();
            int i6 = i4 + 1;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i4);
            c12957o.f9235a = b;
            if (b == 1 || b == 2) {
                SpenPointD spenPointDM13640m = c12020a.m13640m(i6);
                i4 += 17;
                c12957o.f9236b = (float) spenPointDM13640m.x;
                c12957o.f9237c = (float) spenPointDM13640m.y;
            } else if (b == 3) {
                SpenPointD spenPointDM13640m2 = c12020a.m13640m(i6);
                c12957o.f9236b = (float) spenPointDM13640m2.x;
                c12957o.f9237c = (float) spenPointDM13640m2.y;
                SpenPointD spenPointDM13640m3 = c12020a.m13640m(i4 + 17);
                i4 += 33;
                c12957o.f9240f = (float) spenPointDM13640m3.x;
                c12957o.f9241g = (float) spenPointDM13640m3.y;
            } else if (b == 4 || b == 5) {
                SpenPointD spenPointDM13640m4 = c12020a.m13640m(i6);
                c12957o.f9236b = (float) spenPointDM13640m4.x;
                c12957o.f9237c = (float) spenPointDM13640m4.y;
                SpenPointD spenPointDM13640m5 = c12020a.m13640m(i4 + 17);
                c12957o.f9238d = (float) spenPointDM13640m5.x;
                c12957o.f9239e = (float) spenPointDM13640m5.y;
                SpenPointD spenPointDM13640m6 = c12020a.m13640m(i4 + 33);
                i4 += 49;
                c12957o.f9240f = (float) spenPointDM13640m6.x;
                c12957o.f9241g = (float) spenPointDM13640m6.y;
            } else if (b != 7) {
                i4 = i6;
            } else {
                SpenPointD spenPointDM13640m7 = c12020a.m13640m(i6);
                c12957o.f9236b = (float) spenPointDM13640m7.x;
                c12957o.f9237c = (float) spenPointDM13640m7.y;
                SpenPointD spenPointDM13640m8 = c12020a.m13640m(i4 + 17);
                i4 += 33;
                c12957o.f9238d = (float) spenPointDM13640m8.x;
                c12957o.f9239e = (float) spenPointDM13640m8.y;
            }
            this.f9242a.add(c12957o);
        }
        return i4 - i;
    }

    /* JADX INFO: renamed from: c */
    public final int m13851c(C12020a c12020a, int i) {
        c12020a.m13649v(i, this.f9242a.size());
        int i2 = i + 4;
        PointF pointF = new PointF();
        SpenPointD spenPointD = new SpenPointD();
        for (C12957o c12957o : this.f9242a) {
            int i4 = i2 + 1;
            c12020a.m13646s(i2, c12957o.f9235a);
            int i5 = c12957o.f9235a;
            if (i5 == 1 || i5 == 2) {
                pointF.set(c12957o.f9236b, c12957o.f9237c);
                spenPointD.set(pointF);
                c12020a.m13652y(i4, spenPointD);
                i2 += 17;
            } else {
                if (i5 == 3) {
                    pointF.set(c12957o.f9236b, c12957o.f9237c);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i4, spenPointD);
                    pointF.set(c12957o.f9240f, c12957o.f9241g);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i2 + 17, spenPointD);
                } else if (i5 == 4 || i5 == 5) {
                    pointF.set(c12957o.f9236b, c12957o.f9237c);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i4, spenPointD);
                    pointF.set(c12957o.f9238d, c12957o.f9239e);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i2 + 17, spenPointD);
                    pointF.set(c12957o.f9240f, c12957o.f9241g);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i2 + 33, spenPointD);
                    i2 += 49;
                } else if (i5 != 7) {
                    i2 = i4;
                } else {
                    pointF.set(c12957o.f9236b, c12957o.f9237c);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i4, spenPointD);
                    pointF.set(c12957o.f9238d, c12957o.f9239e);
                    spenPointD.set(pointF);
                    c12020a.m13652y(i2 + 17, spenPointD);
                }
                i2 += 33;
            }
        }
        return i2 - i;
    }

    /* JADX INFO: renamed from: d */
    public final int m13852d() {
        Iterator it = this.f9242a.iterator();
        int i = 4;
        while (it.hasNext()) {
            int i2 = i + 1;
            int i4 = ((C12957o) it.next()).f9235a;
            if (i4 == 1 || i4 == 2) {
                i += 17;
            } else {
                if (i4 != 3) {
                    if (i4 == 4 || i4 == 5) {
                        i += 49;
                    } else if (i4 != 7) {
                        i = i2;
                    }
                }
                i += 33;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: e */
    public final void m13853e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        xmlPullParser.require(2, null, "path");
        while (true) {
            if (eventType != 2) {
                if (eventType != 3 && eventType != 4) {
                    AbstractC2322a.m1632v(eventType, "parseXml - invalid eventType = [", "]", "WCon_Path");
                }
            } else if (xmlPullParser.getName().equalsIgnoreCase("segmentList")) {
                this.f9242a = new ArrayList();
                AbstractC14517a.m15118C(xmlPullParser);
                while (true) {
                    if (eventType == 3 && xmlPullParser.getName().equals("segmentList")) {
                        break;
                    }
                    C12957o c12957o = new C12957o();
                    int attributeCount = xmlPullParser.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        String attributeName = xmlPullParser.getAttributeName(i);
                        if (attributeName.equalsIgnoreCase("type")) {
                            c12957o.f9235a = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                        } else if (attributeName.equalsIgnoreCase("x")) {
                            c12957o.f9236b = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                        } else if (attributeName.equalsIgnoreCase("y")) {
                            c12957o.f9237c = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                        } else if (attributeName.equalsIgnoreCase("x1")) {
                            c12957o.f9238d = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                        } else if (attributeName.equalsIgnoreCase("y1")) {
                            c12957o.f9239e = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                        } else if (attributeName.equalsIgnoreCase("x2")) {
                            c12957o.f9240f = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                        } else if (attributeName.equalsIgnoreCase("y2")) {
                            c12957o.f9241g = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                        }
                    }
                    this.f9242a.add(c12957o);
                    eventType = AbstractC14517a.m15119D(xmlPullParser, 2);
                }
            }
            eventType = xmlPullParser.nextTag();
            if (eventType == 3 && xmlPullParser.getName().equals("path")) {
                return;
            }
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C12958p) {
            return AbstractC0299q.m631h(this.f9242a, ((C12958p) obj).f9242a);
        }
        return false;
    }
}
