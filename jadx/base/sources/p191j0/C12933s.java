package p191j0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12933s extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public String f9111U;

    /* JADX INFO: renamed from: V */
    public int f9112V;

    /* JADX INFO: renamed from: W */
    public int f9113W;

    /* JADX INFO: renamed from: X */
    public int f9114X;

    /* JADX INFO: renamed from: Y */
    public byte[] f9115Y;

    /* JADX INFO: renamed from: Z */
    public boolean f9116Z;

    public C12933s(C6906i c6906i) {
        super(19, c6906i);
        this.f9116Z = false;
        this.f9111U = null;
        this.f9112V = 0;
        this.f9113W = 0;
        this.f9114X = 0;
        this.f9115Y = null;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        c6742k.m4848d(this.f9112V, "originalType");
        c6742k.m4848d(this.f9113W, "originalFormatVersion");
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        byte[] bArr = this.f9115Y;
        if (bArr != null) {
            c6742k.m4865w("originalBinary", Base64Utils.encodeBase64(bArr));
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: e */
    public final void mo13806e(C6742k c6742k) throws SyncException, IOException {
        if (this.f9111U == null) {
            if (this.f9115Y == null) {
                throw new SyncException(326, "ObjectUnknown.composeNormalXml() - no original data");
            }
            Log.d("WCon_ObjectUnknown", "composeNormalXml - binary. size = [" + this.f9114X + "]");
            super.mo13806e(c6742k);
            return;
        }
        Log.d("WCon_ObjectUnknown", "composeNormalXml - xml. length = [" + this.f9111U.length() + "]");
        String str = this.f9111U;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2) {
                    if (xmlPullParserNewPullParser.getName().compareTo(CoeditServiceConstants.Element.NAME_OBJECT) != 0) {
                        c6742k.m4846F(xmlPullParserNewPullParser.getName());
                    }
                    for (int i = 0; i < xmlPullParserNewPullParser.getAttributeCount(); i++) {
                        c6742k.m4851h(xmlPullParserNewPullParser.getAttributeName(i), xmlPullParserNewPullParser.getAttributeValue(i));
                    }
                } else if (eventType != 3) {
                    if (eventType == 4) {
                        ((XmlSerializer) c6742k.f4110b).text(xmlPullParserNewPullParser.getText());
                    }
                } else if (xmlPullParserNewPullParser.getName().compareTo(CoeditServiceConstants.Element.NAME_OBJECT) != 0) {
                    c6742k.m4856m(xmlPullParserNewPullParser.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12933s)) {
            return false;
        }
        C12933s c12933s = (C12933s) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectUnknown", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9112V != c12933s.f9112V) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mOriginalType[");
            sb.append(this.f9112V);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12933s.f9112V, "]", "WCon_ObjectUnknown", sb);
            return false;
        }
        if (this.f9113W != c12933s.f9113W) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mOriginalFormatVersion[");
            sb2.append(this.f9113W);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12933s.f9113W, "]", "WCon_ObjectUnknown", sb2);
            return false;
        }
        if (!TextUtils.equals(this.f9111U, c12933s.f9111U)) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mOriginalXml[");
            sb3.append(this.f9111U);
            sb3.append(" - ");
            AbstractC4539a.m3209s(sb3, c12933s.f9111U, "]", "WCon_ObjectUnknown");
            return false;
        }
        if (this.f9114X == c12933s.f9114X) {
            if (Arrays.equals(this.f9115Y, c12933s.f9115Y)) {
                return true;
            }
            Log.i("WCon_ObjectUnknown", " !! equals() - NE - mOriginalBinary");
            return false;
        }
        StringBuilder sb4 = new StringBuilder(" !! equals() - NE - mOriginalBinarySize[");
        sb4.append(this.f9114X);
        sb4.append(" - ");
        AbstractC11014a.m12329n(c12933s.f9114X, "]", "WCon_ObjectUnknown", sb4);
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws SyncException, IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectUnknown");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 19) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectUnknown");
            i5 = -1;
        } else {
            int i7 = ((ByteBuffer) c12020a.f8772b).getInt(i6);
            int i8 = i4 + 11;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i4 + 10);
            c12020a.m13636i(i8);
            int i9 = b + i8;
            int i10 = i9 + 1;
            byte b5 = ((ByteBuffer) c12020a.f8772b).get(i9);
            short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
            int i11 = i10 + b5;
            this.f9112V = ((ByteBuffer) c12020a.f8772b).getInt(i11);
            this.f9113W = ((ByteBuffer) c12020a.f8772b).getInt(i11 + 4);
            if (i7 != 0) {
                int i12 = i4 + i7;
                if ((s2 & 1) != 0) {
                    int iM13637j = c12020a.m13637j(i12);
                    i12 += 2;
                    if (iM13637j > 0) {
                        this.f9111U = c12020a.m13645r(i12, iM13637j);
                        i12 += iM13637j * 2;
                    }
                }
                if ((s2 & 2) != 0) {
                    int i13 = ((ByteBuffer) c12020a.f8772b).getInt(i12);
                    this.f9114X = i13;
                    int i14 = i12 + 4;
                    if (i13 > 2097152) {
                        throw new SyncException(326, AbstractC2821a.m2223n(new StringBuilder("applyOwnBinary_FlexibleArea() - too large original data. ("), ")", this.f9114X));
                    }
                    this.f9115Y = Arrays.copyOfRange(((ByteBuffer) c12020a.f8772b).array(), i14, this.f9114X + i14);
                    i12 = i14 + this.f9114X;
                }
                if ((s2 & 4) != 0) {
                    int i15 = ((ByteBuffer) c12020a.f8772b).getInt(i12);
                    int i16 = i12 + 4;
                    if (i15 > 0) {
                        this.f9111U = c12020a.m13645r(i16, i15);
                    }
                }
            }
        }
        if (i5 < 0) {
            AbstractC0541b.m758D(i5, "ObjectUnknown newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectUnknown");
            return i5;
        }
        if (this.f9111U == null && this.f9115Y == null) {
            throw new SyncException(326, "ObjectUnknown.newApplyBinary() - no original data.");
        }
        return i5 + iMo13812l;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) throws SyncException {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectUnknown");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        if (this.f9111U == null && this.f9115Y == null) {
            throw new SyncException(326, "ObjectUnknown.newGetBinary() - no original data.");
        }
        c12020a.m13649v(iMo13814n + 15, this.f9112V);
        c12020a.m13649v(iMo13814n + 19, this.f9113W);
        int i4 = iMo13814n + 23;
        int i5 = i4 - iMo13814n;
        if (this.f9115Y != null) {
            c12020a.m13649v(i4, this.f9114X);
            int i6 = iMo13814n + 27;
            c12020a.m13651x(i6, this.f9115Y);
            i4 = i6 + this.f9114X;
            i2 = 2;
        } else {
            i2 = 0;
        }
        String str = this.f9111U;
        if (str != null) {
            int length = str.length();
            c12020a.m13649v(i4, length);
            int i7 = i4 + 4;
            c12020a.m13626E(i7, this.f9111U);
            i4 = i7 + (length * 2);
            i2 |= 4;
        }
        int i8 = i4 - iMo13814n;
        if (i2 == 0) {
            i5 = 0;
        }
        c12020a.m13649v(iMo13814n, i8);
        c12020a.m13647t(iMo13814n + 4, 19);
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
        int iM3193c = this.f9115Y != null ? 27 + this.f9114X : 23;
        String str = this.f9111U;
        if (str != null) {
            iM3193c = AbstractC4539a.m3193c(2, iM3193c + 4, str);
        }
        return iMo13814n + iM3193c;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equalsIgnoreCase("originalType")) {
            this.f9112V = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("originalFormatVersion")) {
            this.f9113W = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getName().equalsIgnoreCase("originalBinary")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        byte[] bArrDecodeBase64ToByteArray = Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15134S(xmlPullParser));
        this.f9115Y = bArrDecodeBase64ToByteArray;
        this.f9114X = bArrDecodeBase64ToByteArray.length;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: q */
    public final void mo13817q(XmlPullParser xmlPullParser) throws XmlPullParserException, SyncException, IOException {
        if (this.f9116Z) {
            xmlPullParser.require(2, null, CoeditServiceConstants.Element.NAME_OBJECT);
            if (xmlPullParser.getEventType() != 2) {
                String str = "convertToXmlString - invalid eventType = [" + xmlPullParser.getEventType() + "]";
                Log.e("WDocXmlUtil", str);
                throw new XmlPullParserException(str, xmlPullParser, null);
            }
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            xmlSerializerNewSerializer.setOutput(stringWriter);
            AbstractC14517a.m15141a(xmlPullParser, xmlSerializerNewSerializer);
            xmlSerializerNewSerializer.endDocument();
            this.f9111U = stringWriter.toString();
            xmlPullParser.require(3, null, CoeditServiceConstants.Element.NAME_OBJECT);
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlPullParserNewPullParser.setInput(new StringReader(this.f9111U));
            if (xmlPullParserNewPullParser.getEventType() == 0) {
                AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
            }
            super.mo13817q(xmlPullParserNewPullParser);
            this.f8990a = 19;
            this.f9113W = this.f9005p;
            Log.d("WCon_ObjectUnknown", "parseNormalXml - xml. length = [" + this.f9111U.length() + "]");
        } else {
            super.mo13817q(xmlPullParser);
            Log.d("WCon_ObjectUnknown", "parseNormalXml - binary. size = [" + this.f9114X + "]");
        }
        if (this.f9111U == null && this.f9115Y == null) {
            throw new SyncException(327, "ObjectUnknown.parseNormalXml() - no original data");
        }
    }
}
