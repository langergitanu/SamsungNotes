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
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.xmlpull.v1.XmlPullParser;
import p178f0.C11979b;
import p186h1.C12020a;
import p194k0.C12962t;

/* JADX INFO: renamed from: j0.t */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12934t extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public int f9117U;

    /* JADX INFO: renamed from: V */
    public String f9118V;

    /* JADX INFO: renamed from: W */
    public String f9119W;

    /* JADX INFO: renamed from: X */
    public boolean f9120X;

    /* JADX INFO: renamed from: Y */
    public int f9121Y;

    /* JADX INFO: renamed from: Z */
    public String f9122Z;

    /* JADX INFO: renamed from: a0 */
    public int f9123a0;

    /* JADX INFO: renamed from: b0 */
    public C12962t f9124b0;

    /* JADX INFO: renamed from: c0 */
    public Pair f9125c0;

    /* JADX INFO: renamed from: d0 */
    public int f9126d0;

    public C12934t(C6906i c6906i) {
        super(10, c6906i);
        this.f9117U = -1;
        this.f9118V = null;
        this.f9119W = null;
        this.f9120X = false;
        this.f9121Y = 1;
        this.f9126d0 = 0;
        this.f9122Z = null;
        this.f9123a0 = -1;
        this.f9124b0 = new C12962t();
        this.f9125c0 = new Pair(-16777216, 0);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        int i = this.f9117U;
        C11979b c11979b = this.f8989T;
        if (i != -1) {
            c6742k.m4851h("attachFile", c11979b.m13559e(i));
        }
        if (!TextUtils.isEmpty(this.f9118V)) {
            c6742k.m4853j("title", this.f9118V);
        }
        if (!TextUtils.isEmpty(this.f9119W)) {
            c6742k.m4853j("playtime", this.f9119W);
        }
        c6742k.m4852i("isRecorded", this.f9120X);
        c6742k.m4848d(this.f9121Y, "version");
        if (!TextUtils.isEmpty(this.f9122Z)) {
            c6742k.m4853j("body", this.f9122Z);
        }
        int i2 = this.f9123a0;
        if (i2 != -1) {
            c6742k.m4851h("thumbnail", c11979b.m13559e(i2));
        }
        if (!((Integer) this.f9125c0.first).equals(-16777216)) {
            c6742k.m4848d(((Integer) this.f9125c0.first).intValue(), "tintColor");
        }
        if (!((Integer) this.f9125c0.second).equals(0)) {
            c6742k.m4848d(((Integer) this.f9125c0.second).intValue(), "bgColor");
        }
        int i4 = this.f9126d0;
        if (i4 != 0) {
            c6742k.m4848d(i4, "viewType");
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        C12962t c12962t = this.f9124b0;
        if (c12962t == null || c12962t.f9255a.isEmpty()) {
            return;
        }
        this.f9124b0.mo47a(c6742k);
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12934t)) {
            return false;
        }
        C12934t c12934t = (C12934t) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectVoice", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9117U != c12934t.f9117U) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mAttachFileId[");
            sb.append(this.f9117U);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12934t.f9117U, "]", "WCon_ObjectVoice", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9118V, c12934t.f9118V)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mTitle[");
            sb2.append(this.f9118V);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12934t.f9118V, "]", "WCon_ObjectVoice");
            return false;
        }
        if (!TextUtils.equals(this.f9119W, c12934t.f9119W)) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mPlayTime[");
            sb3.append(this.f9119W);
            sb3.append(" - ");
            AbstractC4539a.m3209s(sb3, c12934t.f9119W, "]", "WCon_ObjectVoice");
            return false;
        }
        if (this.f9120X != c12934t.f9120X) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - mIsRecorded[");
            sb4.append(this.f9120X);
            sb4.append(" - ");
            AbstractC11014a.m12339x(sb4, "]", "WCon_ObjectVoice", c12934t.f9120X);
            return false;
        }
        if (this.f9121Y != c12934t.f9121Y) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - mVersion[");
            sb5.append(this.f9121Y);
            sb5.append(" - ");
            AbstractC11014a.m12329n(c12934t.f9121Y, "]", "WCon_ObjectVoice", sb5);
            return false;
        }
        if (this.f9122Z != c12934t.f9122Z) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - mBody[");
            sb6.append(this.f9122Z);
            sb6.append(" - ");
            AbstractC4539a.m3209s(sb6, c12934t.f9122Z, "]", "WCon_ObjectVoice");
            return false;
        }
        if (this.f9123a0 != c12934t.f9123a0) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - mThumbnailFileID[");
            sb7.append(this.f9123a0);
            sb7.append(" - ");
            AbstractC11014a.m12329n(c12934t.f9123a0, "]", "WCon_ObjectVoice", sb7);
            return false;
        }
        if (this.f9124b0 != c12934t.f9124b0) {
            Log.i("WCon_ObjectVoice", " !! equals() - NE - mBgColors[" + this.f9124b0 + " - " + c12934t.f9124b0 + "]");
            return false;
        }
        if (this.f9125c0 != c12934t.f9125c0) {
            Log.i("WCon_ObjectVoice", " !! equals() - NE - mDummyThumbnailColors[" + this.f9125c0 + " - " + c12934t.f9125c0 + "]");
            return false;
        }
        if (this.f9126d0 == c12934t.f9126d0) {
            return true;
        }
        StringBuilder sb8 = new StringBuilder(" !! equals() - NE - mViewType[");
        sb8.append(this.f9126d0);
        sb8.append(" - ");
        AbstractC11014a.m12329n(c12934t.f9126d0, "]", "WCon_ObjectVoice", sb8);
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectVoice");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 10) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectVoice");
            i5 = -1;
        } else {
            int i7 = ((ByteBuffer) c12020a.f8772b).getInt(i6);
            int i8 = i4 + 11;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i4 + 10);
            byte b5 = ((ByteBuffer) c12020a.f8772b).get(i8);
            int i9 = i8 + b;
            ((ByteBuffer) c12020a.f8772b).get(i9);
            short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i9 + 1);
            if ((b5 & 1) == 0) {
                this.f9120X = false;
            } else {
                this.f9120X = true;
            }
            if (i7 != 0) {
                int i10 = i4 + i7;
                if ((s2 & 1) != 0) {
                    this.f9117U = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 2) != 0) {
                    short s3 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
                    i10 += 2;
                    if (s3 > 0) {
                        this.f9118V = c12020a.m13645r(i10, s3);
                        i10 += s3 * 2;
                    }
                }
                if ((s2 & 4) != 0) {
                    short s4 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
                    i10 += 2;
                    if (s4 > 0) {
                        this.f9119W = c12020a.m13645r(i10, s4);
                        i10 += s4 * 2;
                    }
                }
                if ((s2 & 8) != 0) {
                    int i11 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    int i12 = i10 + 4;
                    if (this.f9124b0 == null) {
                        this.f9124b0 = new C12962t();
                    }
                    this.f9124b0.m13856b(c12020a, i12);
                    i10 = i12 + i11;
                }
                if ((s2 & 16) != 0) {
                    this.f9121Y = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                } else {
                    this.f9121Y = 0;
                }
                if ((s2 & 64) != 0) {
                    this.f9123a0 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 128) != 0) {
                    short s5 = ((ByteBuffer) c12020a.f8772b).getShort(i10);
                    i10 += 2;
                    if (s5 > 0) {
                        this.f9122Z = c12020a.m13645r(i10, s5);
                        i10 += s5 * 2;
                    }
                }
                if ((s2 & Http2CodecUtil.MAX_WEIGHT) != 0) {
                    int i13 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    int i14 = ((ByteBuffer) c12020a.f8772b).getInt(i10 + 4);
                    i10 += 8;
                    this.f9125c0 = new Pair(Integer.valueOf(i13), Integer.valueOf(i14));
                }
                if ((s2 & 512) != 0) {
                    this.f9126d0 = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                }
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectFormula newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectVoice");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectVoice");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int i4 = iMo13814n + 15;
        int i5 = this.f9120X ? 1 : 0;
        int i6 = i4 - iMo13814n;
        int i7 = this.f9117U;
        if (i7 != -1) {
            c12020a.m13649v(i4, i7);
            i4 = iMo13814n + 19;
            i2 = 1;
        } else {
            i2 = 0;
        }
        String str = this.f9118V;
        if (str != null) {
            int length = str.length();
            c12020a.m13647t(i4, length);
            int i8 = i4 + 2;
            c12020a.m13626E(i8, this.f9118V);
            i4 = i8 + (length * 2);
            i2 |= 2;
        }
        String str2 = this.f9119W;
        if (str2 != null) {
            int length2 = str2.length();
            c12020a.m13647t(i4, length2);
            int i9 = i4 + 2;
            c12020a.m13626E(i9, this.f9119W);
            i4 = i9 + (length2 * 2);
            i2 |= 4;
        }
        C12962t c12962t = this.f9124b0;
        if (c12962t != null && c12962t.f9255a.size() > 0) {
            int iM13858d = this.f9124b0.m13858d();
            c12020a.m13649v(i4, iM13858d);
            int i10 = i4 + 4;
            this.f9124b0.m13857c(c12020a, i10);
            i4 = i10 + iM13858d;
            i2 |= 8;
        }
        c12020a.m13649v(i4, this.f9121Y);
        int i11 = i4 + 4;
        int i12 = i2 | 16;
        int i13 = this.f9123a0;
        if (i13 != -1) {
            c12020a.m13649v(i11, i13);
            i11 = i4 + 8;
            i12 = i2 | 80;
        }
        String str3 = this.f9122Z;
        if (str3 != null) {
            int length3 = str3.length();
            c12020a.m13647t(i11, length3);
            int i14 = i11 + 2;
            c12020a.m13626E(i14, this.f9122Z);
            i11 = i14 + (length3 * 2);
            i12 |= 128;
        }
        if (!((Integer) this.f9125c0.first).equals(-16777216) || !((Integer) this.f9125c0.second).equals(0)) {
            c12020a.m13649v(i11, ((Integer) this.f9125c0.first).intValue());
            c12020a.m13649v(i11 + 4, ((Integer) this.f9125c0.second).intValue());
            i11 += 8;
            i12 |= 256;
        }
        int i15 = this.f9126d0;
        if (i15 != 0) {
            c12020a.m13649v(i11, i15);
            i11 += 4;
            i12 |= 512;
        }
        int i16 = i11 - iMo13814n;
        int i17 = i12 != 0 ? i6 : 0;
        c12020a.m13649v(iMo13814n, i16);
        c12020a.m13647t(iMo13814n + 4, 10);
        c12020a.m13649v(iMo13814n + 6, i17);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, i5);
        c12020a.m13646s(iMo13814n + 12, 2);
        c12020a.m13647t(iMo13814n + 13, i12);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        int iMo13814n = super.mo13814n();
        int iM13858d = this.f9117U != -1 ? 19 : 15;
        String str = this.f9118V;
        if (str != null) {
            iM13858d = AbstractC4539a.m3193c(2, iM13858d + 2, str);
        }
        String str2 = this.f9119W;
        if (str2 != null) {
            iM13858d = AbstractC4539a.m3193c(2, iM13858d + 2, str2);
        }
        C12962t c12962t = this.f9124b0;
        if (c12962t != null && c12962t.f9255a.size() > 0) {
            iM13858d += this.f9124b0.m13858d() + 4;
        }
        int length = iM13858d + 4;
        if (this.f9123a0 != -1) {
            length = iM13858d + 8;
        }
        String str3 = this.f9122Z;
        if (str3 != null) {
            length += (str3.length() * 2) + 2;
        }
        if (!((Integer) this.f9125c0.first).equals(-16777216) || !((Integer) this.f9125c0.second).equals(0)) {
            length += 8;
        }
        if (this.f9126d0 != 0) {
            length += 4;
        }
        return iMo13814n + length;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        String attributeValue = xmlPullParser.getAttributeValue(i);
        boolean zEqualsIgnoreCase = attributeName.equalsIgnoreCase("attachFile");
        C11979b c11979b = this.f8989T;
        if (zEqualsIgnoreCase) {
            this.f9117U = c11979b.m13558d(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("title")) {
            this.f9118V = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("playtime")) {
            this.f9119W = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("isRecorded")) {
            this.f9120X = Boolean.parseBoolean(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("version")) {
            this.f9121Y = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("viewType")) {
            this.f9126d0 = Integer.parseInt(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("body")) {
            this.f9122Z = Base64Utils.decodeBase64(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("thumbnail")) {
            this.f9123a0 = c11979b.m13558d(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("tintColor")) {
            this.f9125c0 = new Pair(Integer.valueOf(Integer.parseInt(attributeValue)), (Integer) this.f9125c0.second);
        } else if (!attributeName.equalsIgnoreCase("bgColor")) {
            super.mo13815o(xmlPullParser, i);
        } else {
            this.f9125c0 = new Pair((Integer) this.f9125c0.first, Integer.valueOf(Integer.parseInt(attributeValue)));
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getName().equalsIgnoreCase("bgGradientColorList")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        if (this.f9124b0 == null) {
            this.f9124b0 = new C12962t();
        }
        this.f9124b0.m13859e(xmlPullParser);
    }
}
