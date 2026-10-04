package p191j0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.xmlpull.v1.XmlPullParser;
import p186h1.C12020a;
import p194k0.C12962t;

/* JADX INFO: renamed from: j0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12922h extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public String f9053U;

    /* JADX INFO: renamed from: V */
    public String f9054V;

    /* JADX INFO: renamed from: W */
    public int f9055W;

    /* JADX INFO: renamed from: X */
    public String f9056X;

    /* JADX INFO: renamed from: Y */
    public String f9057Y;

    /* JADX INFO: renamed from: Z */
    public String f9058Z;

    /* JADX INFO: renamed from: a0 */
    public int f9059a0;

    /* JADX INFO: renamed from: b0 */
    public int f9060b0;

    /* JADX INFO: renamed from: c0 */
    public int f9061c0;

    /* JADX INFO: renamed from: d0 */
    public C12962t f9062d0;

    /* JADX INFO: renamed from: e0 */
    public Pair f9063e0;

    public C12922h(C6906i c6906i) {
        super(17, c6906i);
        this.f9055W = -1;
        this.f9053U = "";
        this.f9054V = "";
        this.f9057Y = "";
        this.f9056X = "";
        this.f9058Z = "";
        this.f9059a0 = 1;
        this.f9060b0 = 0;
        this.f9061c0 = 0;
        this.f9062d0 = new C12962t();
        this.f9063e0 = new Pair(-16777216, 0);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        if (!TextUtils.isEmpty(this.f9053U)) {
            c6742k.m4853j("packageName", this.f9053U);
        }
        if (!TextUtils.isEmpty(this.f9054V)) {
            c6742k.m4853j("action", this.f9054V);
        }
        int i = this.f9055W;
        if (i != -1) {
            c6742k.m4851h("thumbnail", this.f8989T.m13559e(i));
        }
        if (!TextUtils.isEmpty(this.f9056X)) {
            c6742k.m4853j("title", this.f9056X);
        }
        if (!TextUtils.isEmpty(this.f9057Y)) {
            c6742k.m4853j("body", this.f9057Y);
        }
        if (!TextUtils.isEmpty(this.f9058Z)) {
            c6742k.m4853j("option", this.f9058Z);
        }
        int i2 = this.f9059a0;
        if (i2 != 1) {
            c6742k.m4848d(i2, "version");
        }
        int i4 = this.f9060b0;
        if (i4 != 0) {
            c6742k.m4848d(i4, "viewType");
        }
        int i5 = this.f9061c0;
        if (i5 != 0) {
            c6742k.m4848d(i5, "iconType");
        }
        if (!((Integer) this.f9063e0.first).equals(-16777216)) {
            c6742k.m4848d(((Integer) this.f9063e0.first).intValue(), "tintColor");
        }
        if (((Integer) this.f9063e0.second).equals(0)) {
            return;
        }
        c6742k.m4848d(((Integer) this.f9063e0.second).intValue(), "bgColor");
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        C12962t c12962t = this.f9062d0;
        if (c12962t == null || c12962t.f9255a.isEmpty()) {
            return;
        }
        this.f9062d0.mo47a(c6742k);
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12922h)) {
            return false;
        }
        C12922h c12922h = (C12922h) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectLink", " !! equals() - NE - super check");
            return false;
        }
        if (!this.f9053U.equals(c12922h.f9053U)) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - packageName[");
            sb.append(this.f9053U);
            sb.append(" - ");
            AbstractC4539a.m3209s(sb, c12922h.f9053U, "]", "WCon_ObjectLink");
            return false;
        }
        if (!this.f9054V.equals(c12922h.f9054V)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - action[");
            sb2.append(this.f9054V);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12922h.f9054V, "]", "WCon_ObjectLink");
            return false;
        }
        if (this.f9055W != c12922h.f9055W) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - thumbnailFileID[");
            sb3.append(this.f9055W);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12922h.f9055W, "]", "WCon_ObjectLink", sb3);
            return false;
        }
        if (!this.f9056X.equals(c12922h.f9056X)) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - body[");
            sb4.append(this.f9056X);
            sb4.append(" - ");
            AbstractC4539a.m3209s(sb4, c12922h.f9056X, "]", "WCon_ObjectLink");
            return false;
        }
        if (!this.f9057Y.equals(c12922h.f9057Y)) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - body[");
            sb5.append(this.f9057Y);
            sb5.append(" - ");
            AbstractC4539a.m3209s(sb5, c12922h.f9057Y, "]", "WCon_ObjectLink");
            return false;
        }
        if (!this.f9054V.equals(c12922h.f9054V)) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - action[");
            sb6.append(this.f9054V);
            sb6.append(" - ");
            AbstractC4539a.m3209s(sb6, c12922h.f9054V, "]", "WCon_ObjectLink");
            return false;
        }
        if (this.f9059a0 != c12922h.f9059a0) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - version[");
            sb7.append(this.f9059a0);
            sb7.append(" - ");
            AbstractC11014a.m12329n(c12922h.f9059a0, "]", "WCon_ObjectLink", sb7);
            return false;
        }
        if (this.f9060b0 != c12922h.f9060b0) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - viewType[");
            sb8.append(this.f9060b0);
            sb8.append(" - ");
            AbstractC11014a.m12329n(c12922h.f9060b0, "]", "WCon_ObjectLink", sb8);
            return false;
        }
        if (this.f9061c0 != c12922h.f9061c0) {
            StringBuilder sb9 = new StringBuilder(" !! equals() - NE - iconType[");
            sb9.append(this.f9061c0);
            sb9.append(" - ");
            AbstractC11014a.m12329n(c12922h.f9061c0, "]", "WCon_ObjectLink", sb9);
            return false;
        }
        if (this.f9062d0 != c12922h.f9062d0) {
            Log.i("WCon_ObjectLink", " !! equals() - NE - bgColors[" + this.f9062d0 + " - " + c12922h.f9062d0 + "]");
            return false;
        }
        if (this.f9063e0 == c12922h.f9063e0) {
            return true;
        }
        Log.i("WCon_ObjectLink", " !! equals() - NE - dummyThumbnailColors[" + this.f9063e0 + " - " + c12922h.f9063e0 + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectLink");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 17) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectLink");
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
            short s3 = ((ByteBuffer) c12020a.f8772b).getShort(i11);
            int i12 = i11 + 2;
            if (s3 > 0) {
                this.f9053U = c12020a.m13645r(i12, s3);
                i12 += s3 * 2;
            }
            short s4 = ((ByteBuffer) c12020a.f8772b).getShort(i12);
            int i13 = i12 + 2;
            if (s4 > 0) {
                this.f9054V = c12020a.m13645r(i13, s4);
                i13 += s4 * 2;
            }
            this.f9055W = ((ByteBuffer) c12020a.f8772b).getInt(i13);
            short s5 = ((ByteBuffer) c12020a.f8772b).getShort(i13 + 4);
            int i14 = i13 + 6;
            if (s5 > 0) {
                this.f9056X = c12020a.m13645r(i14, s5);
                i14 += s5 * 2;
            }
            short s6 = ((ByteBuffer) c12020a.f8772b).getShort(i14);
            int i15 = i14 + 2;
            if (s6 > 0) {
                this.f9057Y = c12020a.m13645r(i15, s6);
                i15 += s6 * 2;
            }
            short s7 = ((ByteBuffer) c12020a.f8772b).getShort(i15);
            int i16 = i15 + 2;
            if (s7 > 0) {
                this.f9058Z = c12020a.m13645r(i16, s7);
                i16 += s7 * 2;
            }
            this.f9059a0 = ((ByteBuffer) c12020a.f8772b).getInt(i16);
            this.f9060b0 = ((ByteBuffer) c12020a.f8772b).getInt(i16 + 4);
            if (i7 != 0) {
                int i17 = i4 + i7;
                if ((s2 & 1) != 0) {
                    this.f9061c0 = ((ByteBuffer) c12020a.f8772b).getInt(i17);
                    i17 += 4;
                } else {
                    this.f9061c0 = 0;
                }
                if ((s2 & 2) != 0) {
                    int i18 = ((ByteBuffer) c12020a.f8772b).getInt(i17);
                    int i19 = i17 + 4;
                    if (this.f9062d0 == null) {
                        this.f9062d0 = new C12962t();
                    }
                    this.f9062d0.m13856b(c12020a, i19);
                    i17 = i19 + i18;
                }
                if ((s2 & 8) != 0) {
                    this.f9063e0 = new Pair(Integer.valueOf(((ByteBuffer) c12020a.f8772b).getInt(i17)), Integer.valueOf(((ByteBuffer) c12020a.f8772b).getInt(i17 + 4)));
                }
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectLink newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectLink");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectLink");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int length = this.f9053U.length();
        c12020a.m13647t(iMo13814n + 15, length);
        int i4 = iMo13814n + 17;
        if (length > 0) {
            c12020a.m13626E(i4, this.f9053U);
            i4 += length * 2;
        }
        int length2 = this.f9054V.length();
        c12020a.m13647t(i4, length2);
        int i5 = i4 + 2;
        if (length2 > 0) {
            c12020a.m13626E(i5, this.f9054V);
            i5 += length2 * 2;
        }
        c12020a.m13649v(i5, this.f9055W);
        int length3 = this.f9056X.length();
        c12020a.m13647t(i5 + 4, length3);
        int i6 = i5 + 6;
        if (length3 > 0) {
            c12020a.m13626E(i6, this.f9056X);
            i6 += length3 * 2;
        }
        int length4 = this.f9057Y.length();
        c12020a.m13647t(i6, length4);
        int i7 = i6 + 2;
        if (length4 > 0) {
            c12020a.m13626E(i7, this.f9057Y);
            i7 += length4 * 2;
        }
        int length5 = this.f9058Z.length();
        c12020a.m13647t(i7, length5);
        int i8 = i7 + 2;
        if (length5 > 0) {
            c12020a.m13626E(i8, this.f9058Z);
            i8 += length5 * 2;
        }
        c12020a.m13649v(i8, this.f9059a0);
        c12020a.m13649v(i8 + 4, this.f9060b0);
        int i9 = i8 + 8;
        int i10 = i9 - iMo13814n;
        int i11 = this.f9061c0;
        if (i11 != 0) {
            c12020a.m13649v(i9, i11);
            i9 = i8 + 12;
            i2 = 1;
        } else {
            i2 = 0;
        }
        C12962t c12962t = this.f9062d0;
        if (c12962t != null && !c12962t.f9255a.isEmpty()) {
            int iM13858d = this.f9062d0.m13858d();
            c12020a.m13649v(i9, iM13858d);
            int i12 = i9 + 4;
            this.f9062d0.m13857c(c12020a, i12);
            i9 = i12 + iM13858d;
            i2 |= 2;
        }
        if (!((Integer) this.f9063e0.first).equals(-16777216) || !((Integer) this.f9063e0.second).equals(0)) {
            c12020a.m13649v(i9, ((Integer) this.f9063e0.first).intValue());
            c12020a.m13649v(i9 + 4, ((Integer) this.f9063e0.second).intValue());
            i9 += 8;
            i2 |= 8;
        }
        int i13 = i9 - iMo13814n;
        if (i2 == 0) {
            i10 = 0;
        }
        c12020a.m13649v(iMo13814n, i13);
        c12020a.m13647t(iMo13814n + 4, 17);
        c12020a.m13649v(iMo13814n + 6, i10);
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
        int iM3193c = AbstractC4539a.m3193c(2, (this.f9057Y.length() * 2) + (this.f9056X.length() * 2) + (this.f9054V.length() * 2) + AbstractC4539a.m3193c(2, 19, this.f9053U) + 6 + 2 + 2, this.f9058Z);
        int iM13858d = iM3193c + 8;
        if (this.f9061c0 != 0) {
            iM13858d = iM3193c + 12;
        }
        C12962t c12962t = this.f9062d0;
        if (c12962t != null && !c12962t.f9255a.isEmpty()) {
            iM13858d = iM13858d + 4 + this.f9062d0.m13858d();
        }
        if (!((Integer) this.f9063e0.first).equals(-16777216) || !((Integer) this.f9063e0.second).equals(0)) {
            iM13858d += 8;
        }
        return iMo13814n + iM13858d;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        String attributeValue = xmlPullParser.getAttributeValue(i);
        if (attributeName.equalsIgnoreCase("packageName")) {
            this.f9053U = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("action")) {
            this.f9054V = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("thumbnail")) {
            this.f9055W = this.f8989T.m13558d(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("title")) {
            this.f9056X = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("body")) {
            this.f9057Y = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("option")) {
            this.f9058Z = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("version")) {
            this.f9059a0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("viewType")) {
            this.f9060b0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("iconType")) {
            this.f9061c0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("tintColor")) {
            this.f9063e0 = new Pair(Integer.valueOf(Integer.parseInt(attributeValue)), (Integer) this.f9063e0.second);
        } else if (!attributeName.equalsIgnoreCase("bgColor")) {
            super.mo13815o(xmlPullParser, i);
        } else {
            this.f9063e0 = new Pair((Integer) this.f9063e0.first, Integer.valueOf(Integer.parseInt(attributeValue)));
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getName().equalsIgnoreCase("bgGradientColorList")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        if (this.f9062d0 == null) {
            this.f9062d0 = new C12962t();
        }
        this.f9062d0.m13859e(xmlPullParser);
    }
}
