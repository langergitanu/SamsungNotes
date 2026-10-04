package p194k0;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12943a extends AbstractC12946d {

    /* JADX INFO: renamed from: b */
    public float f9143b;

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        super.m13847b(c6742k);
        c6742k.m4849e("transparency", this.f9143b);
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: c */
    public final int mo13844c() {
        return 4;
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: d */
    public final void mo13845d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "fillEffect");
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("transparency")) {
                this.f9143b = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            }
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("fillEffect")) {
                return;
            }
            if (iM15119D != 2 && iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_FillBgEffect");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12943a)) {
            return false;
        }
        C12943a c12943a = (C12943a) obj;
        int i = c12943a.f9154a;
        int i2 = this.f9154a;
        if (i2 != i) {
            Log.i("WCon_FillBgEffect", AbstractC0622a.m1164j(i2, i, " !! equals() - NE - type[", " - ", "]"));
            return false;
        }
        if (this.f9143b == c12943a.f9143b) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - transparency[");
        sb.append(this.f9143b);
        sb.append(" - ");
        AbstractC2821a.m2234y(sb, c12943a.f9143b, "]", "WCon_FillBgEffect");
        return false;
    }
}
