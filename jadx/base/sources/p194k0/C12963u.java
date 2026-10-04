package p194k0;

import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k0.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12963u implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public final LinkedHashMap f9256a = new LinkedHashMap();

    /* JADX INFO: renamed from: b */
    public final LinkedHashMap f9257b = new LinkedHashMap();

    /* JADX INFO: renamed from: c */
    public final LinkedHashMap f9258c = new LinkedHashMap();

    /* JADX INFO: renamed from: d */
    public final LinkedHashMap f9259d = new LinkedHashMap();

    /* JADX INFO: renamed from: e */
    public String f9260e;

    public C12963u(String str) {
        this.f9260e = str;
    }

    /* JADX INFO: renamed from: f */
    public static int m13860f(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                i2++;
            } else if (cCharAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(cCharAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) {
        LinkedHashMap linkedHashMap = this.f9256a;
        boolean zIsEmpty = linkedHashMap.isEmpty();
        LinkedHashMap linkedHashMap2 = this.f9257b;
        if (zIsEmpty && linkedHashMap2.isEmpty()) {
            return;
        }
        c6742k.m4846F("bundle");
        c6742k.m4851h("name", this.f9260e);
        if (!linkedHashMap2.isEmpty()) {
            c6742k.m4846F("mapInt");
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                c6742k.m4846F("pair");
                c6742k.m4853j("key", (String) entry.getKey());
                c6742k.m4848d(((Integer) entry.getValue()).intValue(), "value");
                c6742k.m4856m("pair");
            }
            c6742k.m4856m("mapInt");
        }
        if (!linkedHashMap.isEmpty()) {
            c6742k.m4846F("mapString");
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                c6742k.m4846F("pair");
                c6742k.m4853j("key", (String) entry2.getKey());
                c6742k.m4853j("value", (String) entry2.getValue());
                c6742k.m4856m("pair");
            }
            c6742k.m4856m("mapString");
        }
        c6742k.m4856m("bundle");
    }

    /* JADX INFO: renamed from: b */
    public final int m13861b(C12020a c12020a, int i) {
        int i2 = i + 1;
        byte b = ((ByteBuffer) c12020a.f8772b).get(i);
        if ((b & 1) != 0) {
            short s = ((ByteBuffer) c12020a.f8772b).getShort(i2);
            int i4 = i + 3;
            for (int i5 = 0; i5 < s; i5++) {
                short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i4);
                int i6 = i4 + 2;
                String strM13644q = c12020a.m13644q(i6, s2);
                int i7 = i6 + s2;
                short s3 = ((ByteBuffer) c12020a.f8772b).getShort(i7);
                i4 = i7 + 2;
                if (s3 > 0) {
                    this.f9256a.put(strM13644q, c12020a.m13645r(i4, s3));
                    i4 = (s3 * 2) + i4;
                }
            }
            i2 = i4;
        }
        if ((b & 2) != 0) {
            short s4 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
            i2 += 2;
            for (int i8 = 0; i8 < s4; i8++) {
                short s5 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
                int i9 = i2 + 2;
                String strM13644q2 = c12020a.m13644q(i9, s5);
                int i10 = i9 + s5;
                int i11 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                i2 = i10 + 4;
                this.f9257b.put(strM13644q2, Integer.valueOf(i11));
            }
        }
        if ((b & 4) != 0) {
            short s6 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
            i2 += 2;
            for (int i12 = 0; i12 < s6; i12++) {
                short s7 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
                int i13 = i2 + 2;
                String strM13644q3 = c12020a.m13644q(i13, s7);
                int i14 = i13 + s7;
                short s8 = ((ByteBuffer) c12020a.f8772b).getShort(i14);
                i2 = i14 + 2;
                ArrayList arrayList = new ArrayList();
                for (int i15 = 0; i15 < s8; i15++) {
                    short s9 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
                    int i16 = i2 + 2;
                    String strM13645r = c12020a.m13645r(i16, s9);
                    i2 = i16 + (s9 * 2);
                    arrayList.add(strM13645r);
                }
                this.f9258c.put(strM13644q3, arrayList);
            }
        }
        if ((b & 8) != 0) {
            short s10 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
            i2 += 2;
            for (int i17 = 0; i17 < s10; i17++) {
                short s11 = ((ByteBuffer) c12020a.f8772b).getShort(i2);
                int i18 = i2 + 2;
                String strM13644q4 = c12020a.m13644q(i18, s11);
                int i19 = i18 + s11;
                int i20 = ((ByteBuffer) c12020a.f8772b).getInt(i19);
                int i21 = i19 + 4;
                byte[] bArr = new byte[i20];
                c12020a.m13639l(i21, bArr);
                i2 = i21 + i20;
                this.f9259d.put(strM13644q4, bArr);
            }
        }
        return i2 - i;
    }

    /* JADX INFO: renamed from: c */
    public final void m13862c(RandomAccessFile randomAccessFile) {
        byte b = randomAccessFile.readByte();
        if ((b & 1) != 0) {
            int iM609S = AbstractC0299q.m609S(randomAccessFile);
            for (int i = 0; i < iM609S; i++) {
                String strM610T = AbstractC0299q.m610T(randomAccessFile, AbstractC0299q.m609S(randomAccessFile));
                String strM611U = AbstractC0299q.m611U(randomAccessFile, -1);
                if (strM610T != null) {
                    this.f9256a.put(strM610T, strM611U);
                }
            }
        }
        if ((b & 2) != 0) {
            int iM609S2 = AbstractC0299q.m609S(randomAccessFile);
            for (int i2 = 0; i2 < iM609S2; i2++) {
                String strM610T2 = AbstractC0299q.m610T(randomAccessFile, AbstractC0299q.m609S(randomAccessFile));
                int iM606P = AbstractC0299q.m606P(randomAccessFile);
                if (strM610T2 != null) {
                    this.f9257b.put(strM610T2, Integer.valueOf(iM606P));
                }
            }
        }
        if ((b & 4) != 0) {
            int iM609S3 = AbstractC0299q.m609S(randomAccessFile);
            for (int i4 = 0; i4 < iM609S3; i4++) {
                String strM610T3 = AbstractC0299q.m610T(randomAccessFile, AbstractC0299q.m609S(randomAccessFile));
                int iM609S4 = AbstractC0299q.m609S(randomAccessFile);
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < iM609S4; i5++) {
                    arrayList.add(AbstractC0299q.m611U(randomAccessFile, -1));
                }
                if (strM610T3 != null) {
                    this.f9258c.put(strM610T3, arrayList);
                }
            }
        }
        if ((b & 8) != 0) {
            int iM609S5 = AbstractC0299q.m609S(randomAccessFile);
            for (int i6 = 0; i6 < iM609S5; i6++) {
                String strM610T4 = AbstractC0299q.m610T(randomAccessFile, AbstractC0299q.m609S(randomAccessFile));
                if (strM610T4 == null) {
                    return;
                }
                int iM606P2 = AbstractC0299q.m606P(randomAccessFile);
                randomAccessFile.getFilePointer();
                byte[] bArr = new byte[iM606P2];
                randomAccessFile.read(bArr);
                if (strM610T4.compareTo("SPEN_SDK_KEY_SYSTEM_RESERVED_EXTRA_DATA\u0000") != 0) {
                    this.f9259d.put(strM610T4, bArr);
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m13863d(C12020a c12020a, int i) {
        LinkedHashMap linkedHashMap = this.f9256a;
        int i2 = !linkedHashMap.isEmpty() ? 1 : 0;
        LinkedHashMap linkedHashMap2 = this.f9257b;
        if (!linkedHashMap2.isEmpty()) {
            i2 |= 2;
        }
        LinkedHashMap linkedHashMap3 = this.f9258c;
        if (!linkedHashMap3.isEmpty()) {
            i2 |= 4;
        }
        LinkedHashMap linkedHashMap4 = this.f9259d;
        if (!linkedHashMap4.isEmpty()) {
            i2 |= 8;
        }
        int length = i + 1;
        c12020a.m13646s(i, i2);
        if (!linkedHashMap.isEmpty()) {
            c12020a.m13647t(length, linkedHashMap.size());
            length = i + 3;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iM13624C = c12020a.m13624C(length, (String) entry.getKey()) + length;
                String str = (String) entry.getValue();
                c12020a.m13647t(iM13624C, str.length());
                int i4 = iM13624C + 2;
                c12020a.m13626E(i4, str);
                length = (str.length() * 2) + i4;
            }
        }
        if (!linkedHashMap2.isEmpty()) {
            c12020a.m13647t(length, linkedHashMap2.size());
            length += 2;
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                int iM13624C2 = c12020a.m13624C(length, (String) entry2.getKey()) + length;
                c12020a.m13649v(iM13624C2, ((Integer) entry2.getValue()).intValue());
                length = iM13624C2 + 4;
            }
        }
        if (!linkedHashMap3.isEmpty()) {
            c12020a.m13647t(length, linkedHashMap3.size());
            length += 2;
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int iM13624C3 = c12020a.m13624C(length, (String) entry3.getKey()) + length;
                List list = (List) entry3.getValue();
                int size = list.size();
                c12020a.m13647t(iM13624C3, size);
                int length2 = iM13624C3 + 2;
                for (int i5 = 0; i5 < size; i5++) {
                    String str2 = (String) list.get(i5);
                    c12020a.m13647t(length2, str2.length());
                    int i6 = length2 + 2;
                    c12020a.m13626E(i6, str2);
                    length2 = i6 + (str2.length() * 2);
                }
                length = length2;
            }
        }
        if (!linkedHashMap4.isEmpty()) {
            c12020a.m13647t(length, linkedHashMap4.size());
            length += 2;
            for (Map.Entry entry4 : linkedHashMap4.entrySet()) {
                int iM13624C4 = c12020a.m13624C(length, (String) entry4.getKey()) + length;
                byte[] bArr = (byte[]) entry4.getValue();
                c12020a.m13649v(iM13624C4, bArr.length);
                int i7 = iM13624C4 + 4;
                c12020a.m13651x(i7, bArr);
                length = i7 + bArr.length;
            }
        }
        return length - i;
    }

    /* JADX INFO: renamed from: e */
    public final int m13864e() {
        int length;
        if (m13865g()) {
            return 0;
        }
        LinkedHashMap linkedHashMap = this.f9256a;
        if (linkedHashMap.isEmpty()) {
            length = 1;
        } else {
            length = 3;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iM13860f = m13860f((String) entry.getKey()) + 2 + length;
                String str = (String) entry.getValue();
                int i = iM13860f + 2;
                length = str != null ? AbstractC4539a.m3193c(2, i, str) : i;
            }
        }
        LinkedHashMap linkedHashMap2 = this.f9257b;
        if (!linkedHashMap2.isEmpty()) {
            length += 2;
            Iterator it = linkedHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                length = m13860f((String) ((Map.Entry) it.next()).getKey()) + 2 + length + 4;
            }
        }
        LinkedHashMap linkedHashMap3 = this.f9258c;
        if (!linkedHashMap3.isEmpty()) {
            length += 2;
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                int iM13860f2 = m13860f((String) entry2.getKey()) + 2 + length + 2;
                Iterator it2 = ((List) entry2.getValue()).iterator();
                while (it2.hasNext()) {
                    iM13860f2 = AbstractC4539a.m3193c(2, iM13860f2 + 2, (String) it2.next());
                }
                length = iM13860f2;
            }
        }
        LinkedHashMap linkedHashMap4 = this.f9259d;
        if (!linkedHashMap4.isEmpty()) {
            length += 2;
            for (Map.Entry entry3 : linkedHashMap4.entrySet()) {
                length = ((byte[]) entry3.getValue()).length + m13860f((String) entry3.getKey()) + 2 + length + 4;
            }
        }
        return length;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m13865g() {
        return this.f9256a.isEmpty() && this.f9257b.isEmpty() && this.f9258c.isEmpty() && this.f9259d.isEmpty();
    }

    /* JADX INFO: renamed from: h */
    public final void m13866h(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, "bundle");
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("name")) {
                this.f9260e = xmlPullParser.getAttributeValue(i);
            }
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("bundle")) {
                return;
            }
            if (iM15119D == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("mapInt")) {
                    int iM15119D2 = AbstractC14517a.m15119D(xmlPullParser, 1);
                    while (true) {
                        if (iM15119D2 != 3 || !xmlPullParser.getName().equals("mapInt")) {
                            int attributeCount2 = xmlPullParser.getAttributeCount();
                            String strDecodeBase64 = null;
                            int i2 = 0;
                            for (int i4 = 0; i4 < attributeCount2; i4++) {
                                String attributeName = xmlPullParser.getAttributeName(i4);
                                if (attributeName.equalsIgnoreCase("key")) {
                                    strDecodeBase64 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i4));
                                } else if (attributeName.equalsIgnoreCase("value")) {
                                    i2 = Integer.parseInt(xmlPullParser.getAttributeValue(i4));
                                }
                            }
                            this.f9257b.put(strDecodeBase64, Integer.valueOf(i2));
                            iM15119D2 = AbstractC14517a.m15119D(xmlPullParser, 2);
                        }
                    }
                } else if (name.equalsIgnoreCase("mapString")) {
                    int iM15119D3 = AbstractC14517a.m15119D(xmlPullParser, 1);
                    while (true) {
                        if (iM15119D3 != 3 || !xmlPullParser.getName().equals("mapString")) {
                            int attributeCount3 = xmlPullParser.getAttributeCount();
                            String strDecodeBase642 = null;
                            String strDecodeBase643 = null;
                            for (int i5 = 0; i5 < attributeCount3; i5++) {
                                String attributeName2 = xmlPullParser.getAttributeName(i5);
                                if (attributeName2.equalsIgnoreCase("key")) {
                                    strDecodeBase643 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i5));
                                } else if (attributeName2.equalsIgnoreCase("value")) {
                                    strDecodeBase642 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i5));
                                }
                            }
                            if (strDecodeBase642 == null) {
                                strDecodeBase642 = "";
                            }
                            this.f9256a.put(strDecodeBase643, strDecodeBase642);
                            iM15119D3 = AbstractC14517a.m15119D(xmlPullParser, 2);
                        }
                    }
                }
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_WDocBundleData");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m13867i() {
        this.f9256a.clear();
        this.f9257b.clear();
        this.f9258c.clear();
        this.f9259d.clear();
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12963u)) {
            return false;
        }
        C12963u c12963u = (C12963u) obj;
        LinkedHashMap linkedHashMap = c12963u.f9257b;
        LinkedHashMap linkedHashMap2 = c12963u.f9256a;
        LinkedHashMap linkedHashMap3 = this.f9256a;
        if (!AbstractC0299q.m633i(linkedHashMap3, linkedHashMap2)) {
            Log.i("WCon_WDocBundleData", " !! equals() - NE - mapStr[" + linkedHashMap3 + " - " + linkedHashMap2 + "]");
            return false;
        }
        LinkedHashMap linkedHashMap4 = this.f9257b;
        if (AbstractC0299q.m633i(linkedHashMap4, linkedHashMap)) {
            return true;
        }
        Log.i("WCon_WDocBundleData", " !! equals() - NE - mapInt[" + linkedHashMap4 + " - " + linkedHashMap + "]");
        return false;
    }
}
