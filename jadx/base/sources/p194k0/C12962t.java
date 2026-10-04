package p194k0;

import android.util.Log;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.t */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12962t implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public final ArrayList f9255a = new ArrayList();

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) {
        ArrayList<C12961s> arrayList = this.f9255a;
        if (arrayList.isEmpty()) {
            return;
        }
        c6742k.m4846F("bgGradientColorList");
        for (C12961s c12961s : arrayList) {
            c6742k.m4846F("gradientColor");
            c6742k.m4848d(c12961s.f9253a, "color");
            c6742k.m4851h("position", String.valueOf(c12961s.f9254b));
            c6742k.m4856m("gradientColor");
        }
        c6742k.m4856m("bgGradientColorList");
    }

    /* JADX INFO: renamed from: b */
    public final boolean m13856b(C12020a c12020a, int i) {
        ((ByteBuffer) c12020a.f8772b).getInt(i);
        int i2 = ((ByteBuffer) c12020a.f8772b).getInt(i + 9);
        int i4 = i + 13;
        ArrayList arrayList = this.f9255a;
        arrayList.clear();
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
            float f = ((ByteBuffer) c12020a.f8772b).getFloat(i4 + 4);
            i4 += 8;
            arrayList.add(new C12961s(i6, f));
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m13857c(C12020a c12020a, int i) {
        ArrayList<C12961s> arrayList = this.f9255a;
        c12020a.m13649v(i + 9, arrayList.size());
        int i2 = i + 13;
        for (C12961s c12961s : arrayList) {
            c12020a.m13649v(i2, c12961s.f9253a);
            c12020a.m13648u(c12961s.f9254b, i2 + 4);
            i2 += 8;
        }
        c12020a.m13649v(i, 0);
        c12020a.m13646s(i + 4, 1);
        c12020a.m13646s(i + 5, 0);
        c12020a.m13646s(i + 6, 2);
        ((ByteBuffer) c12020a.f8772b).putShort(i + 7, (short) 0);
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final int m13858d() {
        return (this.f9255a.size() * 8) + 13;
    }

    /* JADX INFO: renamed from: e */
    public final void m13859e(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, "bgGradientColorList");
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
        }
        ArrayList arrayList = this.f9255a;
        arrayList.clear();
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("bgGradientColorList")) {
                return;
            }
            if (iM15119D == 2 && xmlPullParser.getName().equalsIgnoreCase("gradientColor")) {
                int attributeCount = xmlPullParser.getAttributeCount();
                float f = 0.0f;
                int i2 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    String attributeName = xmlPullParser.getAttributeName(i4);
                    String attributeValue = xmlPullParser.getAttributeValue(i4);
                    if (attributeName.equalsIgnoreCase("color")) {
                        i2 = Integer.parseInt(attributeValue);
                    } else if (attributeName.equalsIgnoreCase("position")) {
                        f = Float.parseFloat(attributeValue);
                    }
                }
                arrayList.add(new C12961s(i2, f));
                AbstractC14517a.m15138W(xmlPullParser);
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12962t)) {
            return false;
        }
        if (AbstractC0299q.m631h(this.f9255a, ((C12962t) obj).f9255a)) {
            return true;
        }
        Log.i("WCon_BgGradientColor", " !! equals() - NE - mColors check");
        return false;
    }
}
