package p194k0;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12948f extends AbstractC12946d {

    /* JADX INFO: renamed from: b */
    public byte[] f9167b;

    /* JADX INFO: renamed from: c */
    public int f9168c;

    /* JADX INFO: renamed from: d */
    public int f9169d;

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        super.m13847b(c6742k);
        c6742k.m4851h("pattern", Base64Utils.encodeBase64(this.f9167b));
        c6742k.m4848d(this.f9168c, "foregroundColor");
        c6742k.m4848d(this.f9169d, "backgroundColor");
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: c */
    public final int mo13844c() {
        return 16;
    }

    @Override // p194k0.AbstractC12946d
    /* JADX INFO: renamed from: d */
    public final void mo13845d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "fillEffect");
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("pattern")) {
                this.f9167b = Base64Utils.decodeBase64ToByteArray(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("foregroundColor")) {
                this.f9168c = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("backgroundColor")) {
                this.f9169d = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            }
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("fillEffect")) {
                return;
            }
            if (iM15119D != 2 && iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_FillPatternEffect");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12948f)) {
            return false;
        }
        C12948f c12948f = (C12948f) obj;
        int i = c12948f.f9154a;
        int i2 = this.f9154a;
        if (i2 != i) {
            Log.i("WCon_FillPatternEffect", AbstractC0622a.m1164j(i2, i, " !! equals() - NE - type[", " - ", "]"));
            return false;
        }
        if (!Arrays.equals(this.f9167b, c12948f.f9167b)) {
            Log.i("WCon_FillPatternEffect", " !! equals() - NE - pattern[" + this.f9167b + " - " + c12948f.f9167b + "]");
            return false;
        }
        if (this.f9168c != c12948f.f9168c) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - foregroundColor[");
            sb.append(this.f9168c);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12948f.f9168c, "]", "WCon_FillPatternEffect", sb);
            return false;
        }
        if (this.f9169d == c12948f.f9169d) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(" !! equals() - NE - backgroundColor[");
        sb2.append(this.f9169d);
        sb2.append(" - ");
        AbstractC11014a.m12329n(c12948f.f9169d, "]", "WCon_FillPatternEffect", sb2);
        return false;
    }
}
