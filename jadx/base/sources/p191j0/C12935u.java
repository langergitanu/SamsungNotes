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
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.xmlpull.v1.XmlPullParser;
import p178f0.C11979b;
import p186h1.C12020a;
import p194k0.C12962t;

/* JADX INFO: renamed from: j0.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12935u extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public int f9127U;

    /* JADX INFO: renamed from: V */
    public String f9128V;

    /* JADX INFO: renamed from: W */
    public int f9129W;

    /* JADX INFO: renamed from: X */
    public String f9130X;

    /* JADX INFO: renamed from: Y */
    public String f9131Y;

    /* JADX INFO: renamed from: Z */
    public String f9132Z;

    /* JADX INFO: renamed from: a0 */
    public String f9133a0;

    /* JADX INFO: renamed from: b0 */
    public int f9134b0;

    /* JADX INFO: renamed from: c0 */
    public int f9135c0;

    /* JADX INFO: renamed from: d0 */
    public int f9136d0;

    /* JADX INFO: renamed from: e0 */
    public int f9137e0;

    /* JADX INFO: renamed from: f0 */
    public C12962t f9138f0;

    /* JADX INFO: renamed from: g0 */
    public Pair f9139g0;

    public C12935u(C6906i c6906i) {
        super(13, c6906i);
        this.f9127U = -1;
        this.f9129W = -1;
        this.f9131Y = null;
        this.f9132Z = null;
        this.f9133a0 = null;
        this.f9134b0 = 0;
        this.f9135c0 = 0;
        this.f9136d0 = 0;
        this.f9137e0 = 0;
        this.f9138f0 = new C12962t();
        this.f9139g0 = new Pair(-16777216, 0);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        int i = this.f9127U;
        C11979b c11979b = this.f8989T;
        if (i != -1) {
            String strM13559e = c11979b.m13559e(i);
            this.f9128V = strM13559e;
            c6742k.m4851h("attachHtml", strM13559e);
        }
        int i2 = this.f9129W;
        if (i2 != -1) {
            String strM13559e2 = c11979b.m13559e(i2);
            this.f9130X = strM13559e2;
            c6742k.m4851h("thumbnail", strM13559e2);
        }
        if (!TextUtils.isEmpty(this.f9131Y)) {
            c6742k.m4853j("body", this.f9131Y);
        }
        if (!TextUtils.isEmpty(this.f9132Z)) {
            c6742k.m4853j("title", this.f9132Z);
        }
        if (!TextUtils.isEmpty(this.f9133a0)) {
            c6742k.m4853j("uri", this.f9133a0);
        }
        c6742k.m4848d(this.f9134b0, "imageType");
        c6742k.m4848d(this.f9135c0, "version");
        c6742k.m4848d(this.f9136d0, "viewType");
        int i4 = this.f9137e0;
        if (i4 != 0) {
            c6742k.m4848d(i4, "state");
        }
        if (((Integer) this.f9139g0.first).intValue() != -16777216) {
            c6742k.m4848d(((Integer) this.f9139g0.first).intValue(), "tintColor");
        }
        if (((Integer) this.f9139g0.second).intValue() != 0) {
            c6742k.m4848d(((Integer) this.f9139g0.second).intValue(), "bgColor");
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        C12962t c12962t = this.f9138f0;
        if (c12962t == null || c12962t.f9255a.isEmpty()) {
            return;
        }
        this.f9138f0.mo47a(c6742k);
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12935u)) {
            return false;
        }
        C12935u c12935u = (C12935u) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectWeb", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9127U != c12935u.f9127U) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mAttachHTMLFileID[");
            sb.append(this.f9127U);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12935u.f9127U, "]", "WCon_ObjectWeb", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9128V, c12935u.f9128V)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mAttachHTMLFileHash[");
            sb2.append(this.f9128V);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12935u.f9128V, "]", "WCon_ObjectWeb");
            return false;
        }
        if (this.f9129W != c12935u.f9129W) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mThumbnailFileID[");
            sb3.append(this.f9129W);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12935u.f9129W, "]", "WCon_ObjectWeb", sb3);
            return false;
        }
        if (!TextUtils.equals(this.f9130X, c12935u.f9130X)) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - mThumbnailFileHash[");
            sb4.append(this.f9130X);
            sb4.append(" - ");
            AbstractC4539a.m3209s(sb4, c12935u.f9130X, "]", "WCon_ObjectWeb");
            return false;
        }
        if (!TextUtils.equals(this.f9131Y, c12935u.f9131Y)) {
            Log.i("WCon_ObjectWeb", " !! equals() - NE - mBody[" + LoggerBase.getEncode(this.f9131Y) + " - " + LoggerBase.getEncode(c12935u.f9131Y) + "]");
            return false;
        }
        if (!TextUtils.equals(this.f9132Z, c12935u.f9132Z)) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - mTitle[");
            sb5.append(this.f9132Z);
            sb5.append(" - ");
            AbstractC4539a.m3209s(sb5, c12935u.f9132Z, "]", "WCon_ObjectWeb");
            return false;
        }
        if (!TextUtils.equals(this.f9133a0, c12935u.f9133a0)) {
            Log.i("WCon_ObjectWeb", " !! equals() - NE - mUri[" + LoggerBase.getEncode(this.f9133a0) + " - " + LoggerBase.getEncode(c12935u.f9133a0) + "]");
            return false;
        }
        if (this.f9134b0 != c12935u.f9134b0) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - mImageTypeId[");
            sb6.append(this.f9134b0);
            sb6.append(" - ");
            AbstractC11014a.m12329n(c12935u.f9134b0, "]", "WCon_ObjectWeb", sb6);
            return false;
        }
        if (this.f9135c0 != c12935u.f9135c0) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - mVersion[");
            sb7.append(this.f9135c0);
            sb7.append(" - ");
            AbstractC11014a.m12329n(c12935u.f9135c0, "]", "WCon_ObjectWeb", sb7);
            return false;
        }
        if (this.f9136d0 != c12935u.f9136d0) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - mViewType[");
            sb8.append(this.f9136d0);
            sb8.append(" - ");
            AbstractC11014a.m12329n(c12935u.f9136d0, "]", "WCon_ObjectWeb", sb8);
            return false;
        }
        if (this.f9137e0 != c12935u.f9137e0) {
            StringBuilder sb9 = new StringBuilder(" !! equals() - NE - mState[");
            sb9.append(this.f9137e0);
            sb9.append(" - ");
            AbstractC11014a.m12329n(c12935u.f9137e0, "]", "WCon_ObjectWeb", sb9);
            return false;
        }
        if (this.f9139g0 != c12935u.f9139g0) {
            Log.i("WCon_ObjectWeb", " !! equals() - NE - mDummyThumbnailColors");
            return false;
        }
        if (this.f9138f0 == c12935u.f9138f0) {
            return true;
        }
        Log.i("WCon_ObjectWeb", " !! equals() - NE - mBgColors");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectWeb");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 13) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectWeb");
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
                    this.f9127U = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 2) != 0) {
                    this.f9129W = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 4) != 0) {
                    short s3 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
                    i10 += 2;
                    if (s3 > 0) {
                        this.f9131Y = c12020a.m13645r(i10, s3);
                        i10 += s3 * 2;
                    }
                }
                if ((s2 & 8) != 0) {
                    short s4 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
                    i10 += 2;
                    if (s4 > 0) {
                        this.f9132Z = c12020a.m13645r(i10, s4);
                        i10 += s4 * 2;
                    }
                }
                if ((s2 & 16) != 0) {
                    short s5 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
                    i10 += 2;
                    if (s5 > 0) {
                        this.f9133a0 = c12020a.m13645r(i10, s5);
                        i10 += s5 * 2;
                    }
                }
                this.f9134b0 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                int i11 = i10 + 4;
                if ((s2 & 32) != 0) {
                    this.f9135c0 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                    i11 = i10 + 8;
                } else {
                    this.f9135c0 = 0;
                }
                if ((s2 & 64) != 0) {
                    this.f9136d0 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                    i11 += 4;
                }
                if ((s2 & 128) != 0) {
                    int i12 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                    int i13 = i11 + 4;
                    if (this.f9138f0 == null) {
                        this.f9138f0 = new C12962t();
                    }
                    this.f9138f0.m13856b(c12020a, i13);
                    i11 = i13 + i12;
                }
                if ((s2 & 512) != 0) {
                    int i14 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                    int i15 = ((ByteBuffer) c12020a.f8772b).getInt(i11 + 4);
                    i11 += 8;
                    this.f9139g0 = new Pair(Integer.valueOf(i14), Integer.valueOf(i15));
                }
                if ((s2 & 1024) != 0) {
                    this.f9137e0 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                } else {
                    this.f9137e0 = 0;
                }
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectWeb newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectWeb");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectWeb");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int i4 = iMo13814n + 15;
        int i5 = i4 - iMo13814n;
        int i6 = this.f9127U;
        if (i6 != -1) {
            c12020a.m13649v(i4, i6);
            i4 = iMo13814n + 19;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i7 = this.f9129W;
        if (i7 != -1) {
            c12020a.m13649v(i4, i7);
            i4 += 4;
            i2 |= 2;
        }
        String str = this.f9131Y;
        if (str != null) {
            int length = str.length();
            c12020a.m13647t(i4, length);
            int i8 = i4 + 2;
            c12020a.m13626E(i8, this.f9131Y);
            i4 = i8 + (length * 2);
            i2 |= 4;
        }
        String str2 = this.f9132Z;
        if (str2 != null) {
            int length2 = str2.length();
            c12020a.m13647t(i4, length2);
            int i9 = i4 + 2;
            c12020a.m13626E(i9, this.f9132Z);
            i4 = i9 + (length2 * 2);
            i2 |= 8;
        }
        String str3 = this.f9133a0;
        if (str3 != null) {
            int length3 = str3.length();
            c12020a.m13647t(i4, length3);
            int i10 = i4 + 2;
            c12020a.m13626E(i10, this.f9133a0);
            i4 = i10 + (length3 * 2);
            i2 |= 16;
        }
        c12020a.m13649v(i4, this.f9134b0);
        c12020a.m13649v(i4 + 4, this.f9135c0);
        int i11 = i4 + 8;
        int i12 = i2 | 32;
        int i13 = this.f9136d0;
        if (i13 != 0) {
            c12020a.m13649v(i11, i13);
            i11 = i4 + 12;
            i12 = i2 | 96;
        }
        C12962t c12962t = this.f9138f0;
        if (c12962t != null && c12962t.f9255a.size() > 0) {
            int iM13858d = this.f9138f0.m13858d();
            c12020a.m13649v(i11, iM13858d);
            int i14 = i11 + 4;
            this.f9138f0.m13857c(c12020a, i14);
            i11 = i14 + iM13858d;
            i12 |= 128;
        }
        if (((Integer) this.f9139g0.first).intValue() != -16777216 || ((Integer) this.f9139g0.second).intValue() != 0) {
            c12020a.m13649v(i11, ((Integer) this.f9139g0.first).intValue());
            c12020a.m13649v(i11 + 4, ((Integer) this.f9139g0.second).intValue());
            i11 += 8;
            i12 |= 512;
        }
        int i15 = this.f9137e0;
        if (i15 != 0) {
            c12020a.m13649v(i11, i15);
            i11 += 4;
            i12 |= 1024;
        }
        int i16 = i11 - iMo13814n;
        if (i12 == 0) {
            i5 = 0;
        }
        c12020a.m13649v(iMo13814n, i16);
        c12020a.m13647t(iMo13814n + 4, 13);
        c12020a.m13649v(iMo13814n + 6, i5);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, 0);
        c12020a.m13646s(iMo13814n + 12, 2);
        c12020a.m13647t(iMo13814n + 13, i12);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        int iMo13814n = super.mo13814n();
        int iM3193c = this.f9127U != -1 ? 19 : 15;
        if (this.f9129W != -1) {
            iM3193c += 4;
        }
        String str = this.f9131Y;
        if (str != null) {
            iM3193c = AbstractC4539a.m3193c(2, iM3193c + 2, str);
        }
        String str2 = this.f9132Z;
        if (str2 != null) {
            iM3193c = AbstractC4539a.m3193c(2, iM3193c + 2, str2);
        }
        String str3 = this.f9133a0;
        if (str3 != null) {
            iM3193c = AbstractC4539a.m3193c(2, iM3193c + 2, str3);
        }
        int iM13858d = iM3193c + 8;
        if (this.f9136d0 != 0) {
            iM13858d = iM3193c + 12;
        }
        C12962t c12962t = this.f9138f0;
        if (c12962t != null && c12962t.f9255a.size() > 0) {
            iM13858d = iM13858d + 4 + this.f9138f0.m13858d();
        }
        if (((Integer) this.f9139g0.first).intValue() != -16777216 || ((Integer) this.f9139g0.second).intValue() != 0) {
            iM13858d += 8;
        }
        if (this.f9137e0 != 0) {
            iM13858d += 4;
        }
        return iMo13814n + iM13858d;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        String attributeValue = xmlPullParser.getAttributeValue(i);
        boolean zEqualsIgnoreCase = attributeName.equalsIgnoreCase("attachHtml");
        C11979b c11979b = this.f8989T;
        if (zEqualsIgnoreCase) {
            this.f9128V = attributeValue;
            this.f9127U = c11979b.m13558d(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("thumbnail")) {
            this.f9130X = attributeValue;
            this.f9129W = c11979b.m13558d(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("body")) {
            this.f9131Y = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("title")) {
            this.f9132Z = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("uri")) {
            this.f9133a0 = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("imageType")) {
            this.f9134b0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("version")) {
            this.f9135c0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("viewType")) {
            this.f9136d0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("state")) {
            this.f9137e0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("tintColor")) {
            this.f9139g0 = new Pair(Integer.valueOf(Integer.parseInt(attributeValue)), (Integer) this.f9139g0.second);
        } else if (!attributeName.equalsIgnoreCase("bgColor")) {
            super.mo13815o(xmlPullParser, i);
        } else {
            this.f9139g0 = new Pair((Integer) this.f9139g0.first, Integer.valueOf(Integer.parseInt(attributeValue)));
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getName().equalsIgnoreCase("bgGradientColorList")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        if (this.f9138f0 == null) {
            this.f9138f0 = new C12962t();
        }
        this.f9138f0.m13859e(xmlPullParser);
    }
}
