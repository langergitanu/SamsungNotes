package p194k0;

import android.graphics.PointF;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12945c extends AbstractC12946d {

    /* JADX INFO: renamed from: b */
    public int f9146b;

    /* JADX INFO: renamed from: c */
    public byte f9147c;

    /* JADX INFO: renamed from: d */
    public boolean f9148d;

    /* JADX INFO: renamed from: e */
    public byte f9149e;

    /* JADX INFO: renamed from: f */
    public int f9150f;

    /* JADX INFO: renamed from: g */
    public PointF f9151g;

    /* JADX INFO: renamed from: h */
    public byte f9152h;

    /* JADX INFO: renamed from: i */
    public final ArrayList f9153i;

    public C12945c() {
        super(1);
        this.f9153i = new ArrayList();
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        super.m13847b(c6742k);
        c6742k.m4848d(this.f9146b, "solidColor");
        c6742k.m4848d(this.f9147c, "colorType");
        c6742k.m4852i("gradientRatatable", this.f9148d);
        c6742k.m4848d(this.f9149e, "gradientType");
        c6742k.m4848d(this.f9150f, "angle");
        c6742k.m4848d(this.f9152h, "colotCount");
        c6742k.m4843B(this.f9151g, "radialGradientPosition");
        ArrayList<C12944b> arrayList = this.f9153i;
        if (arrayList.isEmpty()) {
            return;
        }
        c6742k.m4846F("gradientColorInfoList");
        for (C12944b c12944b : arrayList) {
            c6742k.m4846F("gradientColorInfo");
            c6742k.m4848d(c12944b.f9144a, "color");
            c6742k.m4849e("position", c12944b.f9145b);
            c6742k.m4856m("gradientColorInfo");
        }
        c6742k.m4856m("gradientColorInfoList");
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: c */
    public final int mo13844c() {
        int i = 18;
        for (int i2 = 0; i2 < this.f9153i.size(); i2++) {
            i += 8;
        }
        return i;
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: d */
    public final void mo13845d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "fillEffect");
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("solidColor")) {
                this.f9146b = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("colorType")) {
                this.f9147c = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("gradientRatatable")) {
                this.f9148d = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("gradientType")) {
                this.f9149e = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("angle")) {
                this.f9150f = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("colotCount")) {
                this.f9152h = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            }
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("fillEffect")) {
                return;
            }
            if (iM15119D == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("radialGradientPosition")) {
                    this.f9151g = AbstractC14517a.m15124I(xmlPullParser);
                } else if (name.equalsIgnoreCase("gradientColorInfoList")) {
                    ArrayList arrayList = this.f9153i;
                    arrayList.clear();
                    int iM15118C = AbstractC14517a.m15118C(xmlPullParser);
                    while (true) {
                        if (iM15118C != 3 || !xmlPullParser.getName().equals("gradientColorInfoList")) {
                            C12944b c12944b = new C12944b();
                            int attributeCount2 = xmlPullParser.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount2; i2++) {
                                String attributeName2 = xmlPullParser.getAttributeName(i2);
                                if (attributeName2.equalsIgnoreCase("color")) {
                                    c12944b.f9144a = Integer.parseInt(xmlPullParser.getAttributeValue(i2));
                                } else if (attributeName2.equalsIgnoreCase("position")) {
                                    c12944b.f9145b = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i2));
                                }
                            }
                            arrayList.add(c12944b);
                            iM15118C = AbstractC14517a.m15119D(xmlPullParser, 2);
                        }
                    }
                }
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_FillColorEffect");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m13846e(C12020a c12020a, int i) {
        int i2 = i + 1;
        c12020a.m13646s(i, 1);
        c12020a.m13646s(i2, (byte) (this.f9147c | (this.f9148d ? (byte) 2 : (byte) 0)));
        c12020a.m13649v(i + 2, this.f9146b);
        c12020a.m13646s(i + 6, this.f9149e);
        c12020a.m13647t(i + 7, this.f9150f);
        c12020a.m13650w(i + 9, this.f9151g);
        int i4 = i + 18;
        ArrayList<C12944b> arrayList = this.f9153i;
        c12020a.m13646s(i + 17, arrayList.size());
        for (C12944b c12944b : arrayList) {
            c12020a.m13649v(i4, c12944b.f9144a);
            c12020a.m13648u(c12944b.f9145b, i4 + 4);
            i4 += 8;
        }
        return i4 - i;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12945c)) {
            return false;
        }
        C12945c c12945c = (C12945c) obj;
        return this.f9154a == c12945c.f9154a && this.f9146b == c12945c.f9146b && this.f9147c == c12945c.f9147c && this.f9148d == c12945c.f9148d && this.f9149e == c12945c.f9149e && this.f9150f == c12945c.f9150f && this.f9151g.equals(c12945c.f9151g) && this.f9152h == c12945c.f9152h && AbstractC0299q.m631h(this.f9153i, c12945c.f9153i);
    }
}
