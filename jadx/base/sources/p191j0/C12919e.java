package p191j0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p201m0.C13520a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12919e extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public int f9023U;

    /* JADX INFO: renamed from: V */
    public String f9024V;

    /* JADX INFO: renamed from: W */
    public ArrayList f9025W;

    /* JADX INFO: renamed from: X */
    public ArrayList f9026X;

    /* JADX INFO: renamed from: Y */
    public ArrayList f9027Y;

    /* JADX INFO: renamed from: Z */
    public ArrayList f9028Z;

    /* JADX INFO: renamed from: a0 */
    public int f9029a0;

    /* JADX INFO: renamed from: b0 */
    public String f9030b0;

    /* JADX INFO: renamed from: c0 */
    public RectF f9031c0;

    /* JADX INFO: renamed from: d0 */
    public RectF f9032d0;

    /* JADX INFO: renamed from: e0 */
    public RectF f9033e0;

    /* JADX INFO: renamed from: f0 */
    public Rect f9034f0;

    /* JADX INFO: renamed from: g0 */
    public int f9035g0;

    /* JADX INFO: renamed from: h0 */
    public boolean f9036h0;

    /* JADX INFO: renamed from: i0 */
    public float f9037i0;

    /* JADX INFO: renamed from: j0 */
    public boolean f9038j0;

    /* JADX INFO: renamed from: k0 */
    public int f9039k0;

    public C12919e(C6906i c6906i) {
        super(11, c6906i);
        this.f9023U = -1;
        this.f9035g0 = 0;
        this.f9030b0 = "";
        this.f9025W = new ArrayList();
        this.f9026X = new ArrayList();
        this.f9027Y = new ArrayList();
        this.f9028Z = new ArrayList();
    }

    /* JADX INFO: renamed from: v */
    public static void m13822v(C13520a c13520a, ArrayList arrayList) {
        int size = arrayList.size();
        C12020a c12020a = c13520a.f9509a;
        c12020a.m13649v(c13520a.f9510b, size);
        c13520a.f9510b += 4;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C12930p c12930p = (C12930p) it.next();
            try {
                int iMo13814n = c12930p.mo13814n();
                c12020a.m13649v(c13520a.f9510b, iMo13814n);
                int i = c13520a.f9510b + 4;
                c13520a.f9510b = i;
                try {
                    c12930p.mo13813m(c12020a, i);
                    c13520a.f9510b += iMo13814n;
                } catch (SyncException e) {
                    throw new RuntimeException(e);
                }
            } catch (SyncException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public static int m13823w(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return 0;
        }
        Iterator it = arrayList.iterator();
        int iMo13814n = 4;
        while (it.hasNext()) {
            try {
                iMo13814n = iMo13814n + 4 + ((C12930p) it.next()).mo13814n();
            } catch (SyncException e) {
                throw new RuntimeException(e);
            }
        }
        return iMo13814n;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        int i = this.f9023U;
        if (i != -1) {
            String strM13559e = this.f8989T.m13559e(i);
            this.f9024V = strM13559e;
            c6742k.m4851h("mediaHash", strM13559e);
        }
        int i2 = this.f9035g0;
        if (i2 != 0) {
            c6742k.m4848d(i2, "angleType");
        }
        float f = this.f9037i0;
        if (f != 0.0f) {
            c6742k.m4849e("fontSize", f);
        }
        boolean z = this.f9036h0;
        if (z) {
            c6742k.m4852i("hasTrigonometryCalculation", z);
        }
        boolean z2 = this.f9038j0;
        if (z2) {
            c6742k.m4852i("isPlotable", z2);
        }
        int i4 = this.f9029a0;
        if (i4 != 0) {
            c6742k.m4848d(i4, "answerStrokeColor");
        }
        int i5 = this.f9039k0;
        if (i5 != 0) {
            c6742k.m4848d(i5, "expressionType");
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws SyncException, IOException {
        super.mo13805d(c6742k);
        ArrayList arrayList = this.f9025W;
        if (arrayList != null && !arrayList.isEmpty()) {
            c6742k.m4846F("latexList");
            Iterator it = this.f9025W.iterator();
            while (it.hasNext()) {
                c6742k.m4867y(HtmlConstants.LATEX, (String) it.next());
            }
            c6742k.m4856m("latexList");
        }
        RectF rectF = this.f9031c0;
        if (rectF != null) {
            c6742k.m4845D("latexResultRect", rectF);
        }
        Rect rect = this.f9034f0;
        if (rect != null) {
            c6742k.m4844C("ninepatchRect", rect);
        }
        ArrayList arrayList2 = this.f9026X;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            c6742k.m4846F("latexResultList");
            Iterator it2 = this.f9026X.iterator();
            while (it2.hasNext()) {
                c6742k.m4867y("latexResult", (String) it2.next());
            }
            c6742k.m4856m("latexResultList");
        }
        String str = this.f9030b0;
        if (str != null) {
            c6742k.m4867y("answerString", str);
        }
        ArrayList arrayList3 = this.f9027Y;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            c6742k.m4868z("strokeList", CoeditServiceConstants.Element.NAME_OBJECT, this.f9027Y);
        }
        ArrayList arrayList4 = this.f9028Z;
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            c6742k.m4868z("answerStrokeList", CoeditServiceConstants.Element.NAME_OBJECT, this.f9028Z);
        }
        RectF rectF2 = this.f9032d0;
        if (rectF2 != null) {
            c6742k.m4845D("relativeOriginalFormulaRect", rectF2);
        }
        RectF rectF3 = this.f9033e0;
        if (rectF3 != null) {
            c6742k.m4845D("relativeOriginalAnswerRect", rectF3);
        }
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12919e)) {
            return false;
        }
        C12919e c12919e = (C12919e) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9023U != c12919e.f9023U) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mMediaId[");
            sb.append(this.f9023U);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12919e.f9023U, "]", "WCon_ObjectFormula", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9024V, c12919e.f9024V)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mMediaHash[");
            sb2.append(this.f9024V);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12919e.f9024V, "]", "WCon_ObjectFormula");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f9025W, c12919e.f9025W)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mLatexList[" + this.f9025W + " - " + c12919e.f9025W + "]");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f9026X, c12919e.f9026X)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mLatexResultList[" + this.f9026X + " - " + c12919e.f9026X + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9031c0, c12919e.f9031c0)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mLatexResultRect[" + this.f9031c0 + " - " + c12919e.f9031c0 + "]");
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9034f0, c12919e.f9034f0)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mImageNinePathRect[" + this.f9034f0 + " - " + c12919e.f9034f0 + "]");
            return false;
        }
        if (this.f9035g0 != c12919e.f9035g0) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mAngleType[");
            sb3.append(this.f9035g0);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12919e.f9035g0, "]", "WCon_ObjectFormula", sb3);
            return false;
        }
        if (this.f9037i0 != c12919e.f9037i0) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - mFontSize[");
            sb4.append(this.f9037i0);
            sb4.append(" - ");
            AbstractC2821a.m2234y(sb4, c12919e.f9037i0, "]", "WCon_ObjectFormula");
            return false;
        }
        if (this.f9036h0 != c12919e.f9036h0) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - mHasTrigonometryCalculation[");
            sb5.append(this.f9036h0);
            sb5.append(" - ");
            AbstractC11014a.m12339x(sb5, "]", "WCon_ObjectFormula", c12919e.f9036h0);
            return false;
        }
        if (!AbstractC0299q.m631h(this.f9027Y, c12919e.f9027Y)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mStrokeList[" + this.f9027Y + " - " + c12919e.f9027Y + "]");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f9028Z, c12919e.f9028Z)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mAnswerStrokeList[" + this.f9028Z + " - " + c12919e.f9028Z + "]");
            return false;
        }
        if (this.f9029a0 != c12919e.f9029a0) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - mAnswerStrokeColor[");
            sb6.append(this.f9029a0);
            sb6.append(" - ");
            AbstractC11014a.m12329n(c12919e.f9029a0, "]", "WCon_ObjectFormula", sb6);
            return false;
        }
        if (this.f9030b0.compareTo(c12919e.f9030b0) != 0) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - answerString[");
            sb7.append(this.f9030b0);
            sb7.append(" - ");
            AbstractC4539a.m3209s(sb7, c12919e.f9030b0, "]", "WCon_ObjectFormula");
            return false;
        }
        if (this.f9038j0 != c12919e.f9038j0) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - mIsPlottable[");
            sb8.append(this.f9038j0);
            sb8.append(" - ");
            AbstractC11014a.m12339x(sb8, "]", "WCon_ObjectFormula", c12919e.f9038j0);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f9032d0, c12919e.f9032d0)) {
            Log.i("WCon_ObjectFormula", " !! equals() - NE - mRelativeOriginalFormulaRect[" + this.f9032d0 + " - " + c12919e.f9032d0 + "]");
            return false;
        }
        if (AbstractC0299q.m635j(this.f9033e0, c12919e.f9033e0)) {
            if (this.f9039k0 == c12919e.f9039k0) {
                return true;
            }
            StringBuilder sb9 = new StringBuilder(" !! equals() - NE - mExpressionType[");
            sb9.append(this.f9039k0);
            sb9.append(" - ");
            AbstractC11014a.m12329n(c12919e.f9039k0, "]", "WCon_ObjectFormula", sb9);
            return false;
        }
        Log.i("WCon_ObjectFormula", " !! equals() - NE - mRelativeOriginalAnswerRect[" + this.f9033e0 + " - " + c12919e.f9033e0 + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectFormula");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 11) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectFormula");
            i5 = -1;
        } else {
            int i7 = ((ByteBuffer) c12020a.f8772b).getInt(i6);
            int i8 = i4 + 11;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i4 + 10);
            byte b5 = ((ByteBuffer) c12020a.f8772b).get(i8);
            int i9 = i8 + b;
            ((ByteBuffer) c12020a.f8772b).get(i9);
            short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i9 + 1);
            if ((b5 & 1) != 0) {
                this.f9036h0 = true;
            } else {
                this.f9036h0 = false;
            }
            if ((b5 & 2) != 0) {
                this.f9038j0 = true;
            } else {
                this.f9038j0 = false;
            }
            if (i7 != 0) {
                int iM13824u = i4 + i7;
                if ((s2 & 1) != 0) {
                    int i10 = ((ByteBuffer) c12020a.f8772b).getInt(iM13824u);
                    iM13824u += 4;
                    if (i10 > 0) {
                        this.f9025W.clear();
                        for (int i11 = 0; i11 < i10; i11++) {
                            String strM13644q = c12020a.m13644q(iM13824u + 2, c12020a.m13637j(iM13824u));
                            iM13824u += C12020a.m13621f(strM13644q);
                            this.f9025W.add(strM13644q);
                        }
                    }
                }
                if ((s2 & 2) != 0) {
                    SpenRectD spenRectDM13642o = c12020a.m13642o(iM13824u);
                    this.f9031c0 = new RectF((float) spenRectDM13642o.left, (float) spenRectDM13642o.top, (float) spenRectDM13642o.right, (float) spenRectDM13642o.bottom);
                    iM13824u += 32;
                }
                if ((s2 & 8) != 0) {
                    this.f9034f0 = c12020a.m13641n(iM13824u);
                    iM13824u += 16;
                }
                if ((s2 & 4) != 0) {
                    this.f9023U = ((ByteBuffer) c12020a.f8772b).getInt(iM13824u);
                    iM13824u += 4;
                }
                if ((s2 & 16) != 0) {
                    int i12 = ((ByteBuffer) c12020a.f8772b).getInt(iM13824u);
                    iM13824u += 4;
                    if (i12 > 0) {
                        this.f9026X.clear();
                        for (int i13 = 0; i13 < i12; i13++) {
                            String strM13644q2 = c12020a.m13644q(iM13824u + 2, c12020a.m13637j(iM13824u));
                            iM13824u += C12020a.m13621f(strM13644q2);
                            this.f9026X.add(strM13644q2);
                        }
                    }
                }
                if ((s2 & 32) != 0) {
                    this.f9035g0 = ((ByteBuffer) c12020a.f8772b).getInt(iM13824u);
                    iM13824u += 4;
                }
                if ((s2 & 64) != 0) {
                    this.f9037i0 = ((ByteBuffer) c12020a.f8772b).getFloat(iM13824u);
                    iM13824u += 4;
                }
                if ((s2 & 128) != 0) {
                    iM13824u += m13824u(c12020a, iM13824u, this.f9027Y);
                }
                if ((s2 & Http2CodecUtil.MAX_WEIGHT) != 0) {
                    iM13824u += m13824u(c12020a, iM13824u, this.f9028Z);
                }
                if ((s2 & 512) != 0) {
                    short s3 = ((ByteBuffer) c12020a.f8772b).getShort(iM13824u);
                    int i14 = iM13824u + 2;
                    this.f9030b0 = c12020a.m13645r(i14, s3);
                    iM13824u = i14 + (s3 * 2);
                }
                if ((s2 & 1024) != 0) {
                    this.f9029a0 = ((ByteBuffer) c12020a.f8772b).getInt(iM13824u);
                    iM13824u += 4;
                }
                if ((s2 & 2048) != 0) {
                    SpenRectD spenRectDM13642o2 = c12020a.m13642o(iM13824u);
                    this.f9032d0 = new RectF((float) spenRectDM13642o2.left, (float) spenRectDM13642o2.top, (float) spenRectDM13642o2.right, (float) spenRectDM13642o2.bottom);
                    iM13824u += 32;
                }
                if ((s2 & 4096) != 0) {
                    SpenRectD spenRectDM13642o3 = c12020a.m13642o(iM13824u);
                    this.f9033e0 = new RectF((float) spenRectDM13642o3.left, (float) spenRectDM13642o3.top, (float) spenRectDM13642o3.right, (float) spenRectDM13642o3.bottom);
                    iM13824u += 32;
                }
                if ((s2 & 8192) != 0) {
                    this.f9039k0 = ((ByteBuffer) c12020a.f8772b).getInt(iM13824u);
                }
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectFormula newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectFormula");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectFormula");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int i2 = iMo13814n + 15;
        int i4 = this.f9036h0 ? 1 : 0;
        if (this.f9038j0) {
            i4 |= 2;
        }
        int i5 = i2 - iMo13814n;
        C13520a c13520a = new C13520a();
        c13520a.f9509a = c12020a;
        c13520a.f9510b = i2;
        c13520a.f9511c = 0;
        int size = this.f9025W.size();
        if (size > 0) {
            c12020a.m13649v(c13520a.f9510b, size);
            c13520a.f9510b += 4;
            for (int i6 = 0; i6 < size; i6++) {
                int i7 = c13520a.f9510b;
                c13520a.f9510b = c13520a.f9509a.m13624C(i7, (String) this.f9025W.get(i6)) + i7;
            }
            c13520a.f9511c |= 1;
        }
        RectF rectF = this.f9031c0;
        if (rectF != null && (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f)) {
            c13520a.f9509a.m13622A(c13520a.f9510b, new SpenRectD(rectF));
            c13520a.f9510b += 32;
            c13520a.f9511c |= 2;
        }
        Rect rect = this.f9034f0;
        if (rect != null && (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0)) {
            c13520a.f9509a.m13653z(c13520a.f9510b, rect);
            c13520a.f9510b += 16;
            c13520a.f9511c |= 8;
        }
        int i8 = this.f9023U;
        if (i8 >= 0) {
            c13520a.f9509a.m13649v(c13520a.f9510b, i8);
            c13520a.f9510b += 4;
            c13520a.f9511c |= 4;
        }
        int size2 = this.f9026X.size();
        if (size2 > 0) {
            c13520a.f9509a.m13649v(c13520a.f9510b, size2);
            c13520a.f9510b += 4;
            for (int i9 = 0; i9 < size2; i9++) {
                int i10 = c13520a.f9510b;
                c13520a.f9510b = c13520a.f9509a.m13624C(i10, (String) this.f9026X.get(i9)) + i10;
            }
            c13520a.f9511c |= 16;
        }
        int i11 = this.f9035g0;
        if (i11 != 0) {
            c13520a.f9509a.m13649v(c13520a.f9510b, i11);
            c13520a.f9510b += 4;
            c13520a.f9511c |= 32;
        }
        float f = this.f9037i0;
        if (f != 0.0f) {
            c13520a.f9509a.m13648u(f, c13520a.f9510b);
            c13520a.f9510b += 4;
            c13520a.f9511c |= 64;
        }
        if (this.f9027Y.size() > 0) {
            m13822v(c13520a, this.f9027Y);
            c13520a.f9511c |= 128;
        }
        if (this.f9028Z.size() > 0) {
            m13822v(c13520a, this.f9028Z);
            c13520a.f9511c |= 256;
        }
        if (!this.f9030b0.isEmpty()) {
            int length = this.f9030b0.length();
            c13520a.f9509a.m13647t(c13520a.f9510b, length);
            int i12 = c13520a.f9510b + 2;
            c13520a.f9510b = i12;
            c13520a.f9509a.m13626E(i12, this.f9030b0);
            c13520a.f9510b = (length * 2) + c13520a.f9510b;
            c13520a.f9511c |= 512;
        }
        int i13 = this.f9029a0;
        if (i13 != -16777216) {
            c13520a.f9509a.m13649v(c13520a.f9510b, i13);
            c13520a.f9510b += 4;
            c13520a.f9511c |= 1024;
        }
        RectF rectF2 = this.f9032d0;
        if (rectF2 != null && (rectF2.left != 0.0f || rectF2.top != 0.0f || rectF2.right != 0.0f || rectF2.bottom != 0.0f)) {
            c13520a.f9509a.m13622A(c13520a.f9510b, new SpenRectD(rectF2));
            c13520a.f9510b += 32;
            c13520a.f9511c |= 2048;
        }
        RectF rectF3 = this.f9033e0;
        if (rectF3 != null && (rectF3.left != 0.0f || rectF3.top != 0.0f || rectF3.right != 0.0f || rectF3.bottom != 0.0f)) {
            c13520a.f9509a.m13622A(c13520a.f9510b, new SpenRectD(rectF3));
            c13520a.f9510b += 32;
            c13520a.f9511c |= 4096;
        }
        int i14 = this.f9039k0;
        if (i14 != 0) {
            c13520a.f9509a.m13649v(c13520a.f9510b, i14);
            c13520a.f9510b += 4;
            c13520a.f9511c |= 8192;
        }
        int i15 = c13520a.f9510b;
        int i16 = c13520a.f9511c;
        int i17 = i15 - iMo13814n;
        int i18 = i16 != 0 ? i5 : 0;
        c12020a.m13649v(iMo13814n, i17);
        c12020a.m13647t(iMo13814n + 4, 11);
        c12020a.m13649v(iMo13814n + 6, i18);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, i4);
        c12020a.m13646s(iMo13814n + 12, 2);
        c12020a.m13647t(iMo13814n + 13, i16);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        int length;
        int iMo13814n = super.mo13814n();
        int size = this.f9025W.size();
        if (size > 0) {
            length = 19;
            for (int i = 0; i < size; i++) {
                length += ((String) this.f9025W.get(i)).getBytes().length + 2;
            }
        } else {
            length = 15;
        }
        RectF rectF = this.f9031c0;
        if (rectF != null && (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f)) {
            length += 32;
        }
        Rect rect = this.f9034f0;
        if (rect != null && (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0)) {
            length += 16;
        }
        if (this.f9023U >= 0) {
            length += 4;
        }
        int size2 = this.f9026X.size();
        if (size2 > 0) {
            length += 4;
            for (int i2 = 0; i2 < size2; i2++) {
                length += ((String) this.f9026X.get(i2)).getBytes().length + 2;
            }
        }
        if (this.f9035g0 != 0) {
            length += 4;
        }
        if (this.f9037i0 != 0.0d) {
            length += 4;
        }
        int iM13823w = m13823w(this.f9028Z) + m13823w(this.f9027Y) + length;
        if (!this.f9030b0.isEmpty()) {
            iM13823w = AbstractC4539a.m3193c(2, iM13823w + 2, this.f9030b0);
        }
        if (this.f9029a0 != -16777216) {
            iM13823w += 4;
        }
        RectF rectF2 = this.f9032d0;
        if (rectF2 != null && (rectF2.left != 0.0f || rectF2.top != 0.0f || rectF2.right != 0.0f || rectF2.bottom != 0.0f)) {
            iM13823w += 32;
        }
        RectF rectF3 = this.f9033e0;
        if (rectF3 != null && (rectF3.left != 0.0f || rectF3.top != 0.0f || rectF3.right != 0.0f || rectF3.bottom != 0.0f)) {
            iM13823w += 32;
        }
        if (this.f9039k0 != 0) {
            iM13823w += 4;
        }
        return iMo13814n + iM13823w;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equalsIgnoreCase("mediaHash")) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            this.f9024V = attributeValue;
            this.f9023U = this.f8989T.m13558d(attributeValue);
            return;
        }
        if (attributeName.equalsIgnoreCase("angleType")) {
            this.f9035g0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("fontSize")) {
            this.f9037i0 = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("hasTrigonometryCalculation")) {
            this.f9036h0 = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("isPlotable")) {
            this.f9038j0 = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("answerStrokeColor")) {
            this.f9029a0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("expressionType")) {
            this.f9039k0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        int eventType = xmlPullParser.getEventType();
        if (name.equalsIgnoreCase("latexList")) {
            this.f9025W = new ArrayList();
            AbstractC14517a.m15118C(xmlPullParser);
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("latexList")) {
                    return;
                }
                this.f9025W.add(AbstractC14517a.m15123H(xmlPullParser));
                eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            }
        } else {
            if (name.equalsIgnoreCase("latexResultRect")) {
                this.f9031c0 = AbstractC14517a.m15127L(xmlPullParser);
                return;
            }
            if (name.equalsIgnoreCase("ninepatchRect")) {
                this.f9034f0 = AbstractC14517a.m15125J(xmlPullParser);
                return;
            }
            if (!name.equalsIgnoreCase("latexResultList")) {
                if (name.equalsIgnoreCase("answerString")) {
                    this.f9030b0 = AbstractC14517a.m15123H(xmlPullParser);
                    return;
                }
                if (name.equalsIgnoreCase("strokeList")) {
                    this.f9027Y = m13825x(xmlPullParser, "strokeList");
                    return;
                }
                if (name.equalsIgnoreCase("answerStrokeList")) {
                    this.f9028Z = m13825x(xmlPullParser, "answerStrokeList");
                    return;
                }
                if (name.equalsIgnoreCase("relativeOriginalFormulaRect")) {
                    this.f9032d0 = AbstractC14517a.m15127L(xmlPullParser);
                    return;
                } else if (name.equalsIgnoreCase("relativeOriginalAnswerRect")) {
                    this.f9033e0 = AbstractC14517a.m15127L(xmlPullParser);
                    return;
                } else {
                    super.mo13816p(xmlPullParser);
                    return;
                }
            }
            this.f9026X = new ArrayList();
            AbstractC14517a.m15118C(xmlPullParser);
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equals("latexResultList")) {
                    return;
                }
                this.f9026X.add(AbstractC14517a.m15123H(xmlPullParser));
                eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            }
        }
    }

    /* JADX INFO: renamed from: u */
    public final int m13824u(C12020a c12020a, int i, ArrayList arrayList) {
        arrayList.clear();
        int i2 = ((ByteBuffer) c12020a.f8772b).getInt(i);
        int i4 = i + 4;
        for (int i5 = 0; i5 < i2; i5++) {
            AbstractC12916b abstractC12916bM15143c = AbstractC14517a.m15143c(1, this.f8988S);
            int i6 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
            int i7 = i4 + 4;
            try {
                if (abstractC12916bM15143c.mo13812l(c12020a, i7, i6) < 0) {
                    return 0;
                }
                i4 = i7 + i6;
                arrayList.add((C12930p) abstractC12916bM15143c);
            } catch (SyncException e) {
                throw new RuntimeException(e);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return i4 - i;
    }

    /* JADX INFO: renamed from: x */
    public final ArrayList m13825x(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String attributeValue;
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        AbstractC14517a.m15118C(xmlPullParser);
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(str)) {
                return arrayList;
            }
            int attributeCount = xmlPullParser.getAttributeCount();
            int i = 0;
            while (true) {
                if (i >= attributeCount) {
                    attributeValue = null;
                    break;
                }
                if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("type")) {
                    attributeValue = xmlPullParser.getAttributeValue(i);
                    break;
                }
                i++;
            }
            if ("stroke".compareTo(attributeValue) != 0) {
                AbstractC14517a.m15138W(xmlPullParser);
                return null;
            }
            AbstractC12916b abstractC12916bM15144d = AbstractC14517a.m15144d(attributeValue, this.f8988S);
            if (abstractC12916bM15144d == null) {
                AbstractC14517a.m15138W(xmlPullParser);
                return null;
            }
            abstractC12916bM15144d.m13818r(xmlPullParser);
            arrayList.add((C12930p) abstractC12916bM15144d);
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }
}
