package p191j0;

import android.graphics.Rect;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import p079T.AbstractC0299q;
import p178f0.C11979b;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12924j extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public int f9066U;

    /* JADX INFO: renamed from: V */
    public int f9067V;

    /* JADX INFO: renamed from: W */
    public float f9068W;

    /* JADX INFO: renamed from: X */
    public Rect f9069X;

    /* JADX INFO: renamed from: Y */
    public SpenRectD f9070Y;

    public C12924j(C6906i c6906i) {
        super(14, c6906i);
        this.f9066U = -1;
        this.f9067V = -1;
        this.f9069X = new Rect();
        this.f9070Y = new SpenRectD();
        this.f9066U = -1;
        this.f9067V = -1;
        this.f9068W = 1.0f;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        int i = this.f9066U;
        C11979b c11979b = this.f8989T;
        if (i != -1) {
            c6742k.m4851h("attachFile", c11979b.m13559e(i));
        }
        int i2 = this.f9067V;
        if (i2 != -1) {
            c6742k.m4851h("thumbnailFile", c11979b.m13559e(i2));
        }
        float f = this.f9068W;
        if (f != 1.0f) {
            c6742k.m4849e("ratio", f);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        Rect rect = this.f9069X;
        if (rect != null && (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0)) {
            c6742k.m4844C("cropRect", rect);
        }
        SpenRectD spenRectD = this.f9070Y;
        if (spenRectD != null) {
            if (spenRectD.left == 0.0d && spenRectD.top == 0.0d && spenRectD.right == 0.0d && spenRectD.bottom == 0.0d) {
                return;
            }
            XmlSerializer xmlSerializer = (XmlSerializer) c6742k.f4110b;
            c6742k.m4846F("originalRect");
            xmlSerializer.attribute("", "l", Double.toString(spenRectD.left));
            xmlSerializer.attribute("", "t", Double.toString(spenRectD.top));
            xmlSerializer.attribute("", "r", Double.toString(spenRectD.right));
            xmlSerializer.attribute("", "b", Double.toString(spenRectD.bottom));
            c6742k.m4856m("originalRect");
        }
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12924j)) {
            return false;
        }
        C12924j c12924j = (C12924j) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectPainting", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9066U != c12924j.f9066U) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mAttachFileID[");
            sb.append(this.f9066U);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12924j.f9066U, "]", "WCon_ObjectPainting", sb);
            return false;
        }
        if (this.f9067V != c12924j.f9067V) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mThumbnailFileID[");
            sb2.append(this.f9067V);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12924j.f9067V, "]", "WCon_ObjectPainting", sb2);
            return false;
        }
        if (this.f9068W != c12924j.f9068W) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mRatio[");
            sb3.append(this.f9068W);
            sb3.append(" - ");
            AbstractC2821a.m2234y(sb3, c12924j.f9068W, "]", "WCon_ObjectPainting");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9069X, c12924j.f9069X)) {
            Log.i("WCon_ObjectPainting", " !! equals() - NE - mCropRect[" + this.f9069X + " - " + c12924j.f9069X + "]");
            return false;
        }
        SpenRectD spenRectD = this.f9070Y;
        double d = spenRectD.left;
        SpenRectD spenRectD2 = c12924j.f9070Y;
        if (d == spenRectD2.left && spenRectD.top == spenRectD2.top && spenRectD.right == spenRectD2.right && spenRectD.bottom == spenRectD2.bottom) {
            return true;
        }
        Log.i("WCon_ObjectPainting", " !! equals() - NE - mOriginalRect[" + this.f9070Y + " - " + c12924j.f9070Y + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectPainting");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 14) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectPainting");
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
                    this.f9066U = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 2) != 0) {
                    this.f9067V = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((s2 & 4) != 0) {
                    this.f9068W = ((ByteBuffer) c12020a.f8772b).getFloat(i10);
                    i10 += 4;
                }
                if ((s2 & 8) != 0) {
                    this.f9069X = c12020a.m13641n(i10);
                    i10 += 16;
                }
                if ((s2 & 16) != 0) {
                    this.f9070Y = c12020a.m13642o(i10);
                }
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectPainting newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectPainting");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectPainting");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int i4 = iMo13814n + 15;
        int i5 = i4 - iMo13814n;
        int i6 = this.f9066U;
        if (i6 != -1) {
            c12020a.m13649v(i4, i6);
            i4 = iMo13814n + 19;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i7 = this.f9067V;
        if (i7 != -1) {
            c12020a.m13649v(i4, i7);
            i4 += 4;
            i2 |= 2;
        }
        float f = this.f9068W;
        if (f != 1.0f) {
            c12020a.m13648u(f, i4);
            i4 += 4;
            i2 |= 4;
        }
        Rect rect = this.f9069X;
        if (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0) {
            c12020a.m13653z(i4, rect);
            i4 += 16;
            i2 |= 8;
        }
        SpenRectD spenRectD = this.f9070Y;
        if (spenRectD.left != 0.0d || spenRectD.top != 0.0d || spenRectD.right != 0.0d || spenRectD.bottom != 0.0d) {
            c12020a.m13622A(i4, spenRectD);
            i4 += 32;
            i2 |= 16;
        }
        int i8 = i4 - iMo13814n;
        if (i2 == 0) {
            i5 = 0;
        }
        c12020a.m13649v(iMo13814n, i8);
        c12020a.m13647t(iMo13814n + 4, 14);
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
        int i = this.f9066U != -1 ? 19 : 15;
        if (this.f9067V != -1) {
            i += 4;
        }
        if (this.f9068W != 1.0f) {
            i += 4;
        }
        Rect rect = this.f9069X;
        if (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0) {
            i += 16;
        }
        SpenRectD spenRectD = this.f9070Y;
        if (spenRectD.left != 0.0d || spenRectD.top != 0.0d || spenRectD.right != 0.0d || spenRectD.bottom != 0.0d) {
            i += 32;
        }
        return iMo13814n + i;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        boolean zEqualsIgnoreCase = attributeName.equalsIgnoreCase("attachFile");
        C11979b c11979b = this.f8989T;
        if (zEqualsIgnoreCase) {
            this.f9066U = c11979b.m13558d(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("thumbnailFile")) {
            this.f9067V = c11979b.m13558d(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("ratio")) {
            this.f9068W = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (name.equalsIgnoreCase("cropRect")) {
            this.f9069X = AbstractC14517a.m15125J(xmlPullParser);
        } else if (name.equalsIgnoreCase("originalRect")) {
            this.f9070Y = AbstractC14517a.m15126K(xmlPullParser);
        } else {
            super.mo13816p(xmlPullParser);
        }
    }
}
