package p191j0;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$AutoFitOption;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$EllipsisType;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$IMEActionType;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$TextAreaType;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$TextInputType;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenPointD;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import p033H0.C0112b;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12016a;
import p186h1.C12020a;
import p194k0.AbstractC12946d;
import p194k0.C12943a;
import p194k0.C12944b;
import p194k0.C12945c;
import p194k0.C12947e;
import p194k0.C12948f;
import p194k0.C12952j;
import p194k0.C12953k;
import p194k0.C12954l;
import p194k0.C12955m;
import p194k0.C12956n;
import p194k0.C12958p;
import p194k0.C12960r;
import p198l0.AbstractC13493b;
import p198l0.AbstractC13495d;
import p198l0.C13492a;
import p198l0.C13494c;
import p201m0.C13521b;
import p201m0.C13523d;
import p201m0.C13524e;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class C12927m extends AbstractC12929o {

    /* JADX INFO: renamed from: Z */
    public final C12952j f9080Z;

    /* JADX INFO: renamed from: a0 */
    public final C12954l f9081a0;

    /* JADX INFO: renamed from: b0 */
    public final C12956n f9082b0;

    /* JADX INFO: renamed from: c0 */
    public final C12953k f9083c0;

    /* JADX INFO: renamed from: d0 */
    public byte f9084d0;

    /* JADX INFO: renamed from: e0 */
    public ArrayList f9085e0;

    /* JADX INFO: renamed from: f0 */
    public int f9086f0;

    /* JADX INFO: renamed from: g0 */
    public int f9087g0;

    /* JADX INFO: renamed from: h0 */
    public final ArrayList f9088h0;

    /* JADX INFO: renamed from: i0 */
    public final ArrayList f9089i0;

    public C12927m(C6906i c6906i) {
        super(7, c6906i);
        this.f9085e0 = new ArrayList();
        this.f9086f0 = -1;
        this.f9087g0 = -1;
        this.f9088h0 = new ArrayList();
        this.f9089i0 = new ArrayList();
        this.f9080Z = new C12952j();
        this.f9081a0 = new C12954l();
        this.f9082b0 = new C12956n(c6906i);
        this.f9083c0 = new C12953k();
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public void mo13804c(C6742k c6742k) {
        super.mo13804c(c6742k);
        C12952j c12952j = this.f9080Z;
        c6742k.m4852i("isHorizontalFlipped", c12952j.f9193f.f9214a);
        c6742k.m4852i("isVerticalFlipped", c12952j.f9193f.f9215b);
        C12956n c12956n = this.f9082b0;
        c6742k.m4852i("isHintTextVisible", c12956n.f9231m);
        c6742k.m4852i("isTextReadOnly", c12956n.f9232n);
        c6742k.m4852i("isTextEditable", c12956n.f9233o);
        c6742k.m4852i("isTransparency", this.f9083c0.f9209j);
        c6742k.m4848d(c12952j.f9188a, "shapeType");
        c6742k.m4849e("originalDegree", c12952j.f9199l);
        C12960r c12960r = c12956n.f9223e;
        if (c12960r != null) {
            c6742k.m4849e("leftMargin", c12960r.f9247e);
            c6742k.m4849e("topMargin", c12956n.f9223e.f9248f);
            c6742k.m4849e("rightMargin", c12956n.f9223e.f9249g);
            c6742k.m4849e("bottomMargin", c12956n.f9223e.f9250h);
            c6742k.m4848d(c12956n.f9223e.f9251i, "textGravity");
        }
        if (c12956n.f9224f != ObjectShapeConst$TextAreaType.TEXT_AREA_TYPE_MARGIN.ordinal()) {
            c6742k.m4848d(c12956n.f9224f, "textAreaType");
        }
        C12954l c12954l = this.f9081a0;
        int i = c12954l.f9211a;
        if (i != -1) {
            c6742k.m4848d(i, "penName");
        }
        int i2 = c12954l.f9212b;
        if (i2 != -1) {
            c6742k.m4848d(i2, "defaultPenName");
        }
        int i4 = c12954l.f9213c;
        if (i4 != -1) {
            c6742k.m4848d(i4, "penStyle");
        }
        String str = c12956n.f9225g;
        if (str != null) {
            c6742k.m4853j("hintText", str);
        }
        int i5 = c12956n.f9226h;
        if (i5 != -16777216) {
            c6742k.m4848d(i5, "hintTextColor");
        }
        float f = c12956n.f9227i;
        if (f != 10.0f) {
            c6742k.m4849e("hintTextFontSize", f);
        }
        int i6 = c12956n.f9229k;
        if (i6 != 0) {
            c6742k.m4848d(i6, "hintTextStyle");
        }
        if (c12956n.f9219a != ObjectShapeConst$EllipsisType.ELLIPSIS_TYPE_NONE.ordinal()) {
            c6742k.m4848d(c12956n.f9219a, "ellipsisType");
        }
        if (c12956n.f9220b != ObjectShapeConst$AutoFitOption.AUTO_FIT_OPTION_BOTH.ordinal()) {
            c6742k.m4848d(c12956n.f9220b, "textAutoFit");
        }
        if (c12956n.f9221c != ObjectShapeConst$IMEActionType.IME_ACTION_TYPE_NONE.ordinal()) {
            c6742k.m4848d(c12956n.f9221c, "imeActionType");
        }
        if (c12956n.f9222d != ObjectShapeConst$TextInputType.INPUT_TYPE_TEXT.ordinal()) {
            c6742k.m4848d(c12956n.f9222d, "textInputType");
        }
        float f4 = c12956n.f9228j;
        if (f4 != 0.0f) {
            c6742k.m4849e("hintTextVerticalOffset", f4);
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public void mo13805d(C6742k c6742k) {
        ArrayList arrayList;
        ArrayList arrayList2;
        super.mo13805d(c6742k);
        C12952j c12952j = this.f9080Z;
        c6742k.m4845D("originalRect", c12952j.f9198k);
        C12958p c12958p = c12952j.f9193f.f9218e;
        if (c12958p != null && (arrayList2 = c12958p.f9242a) != null && !arrayList2.isEmpty()) {
            c6742k.m4864v("path", c12952j.f9193f.f9218e);
        }
        c6742k.m4842A(this.f9085e0);
        c6742k.m4845D("drawnRect", c12952j.f9197j);
        C12956n c12956n = this.f9082b0;
        C12960r c12960r = c12956n.f9223e;
        if (c12960r != null && c12960r.f9243a != null) {
            ArrayList arrayList3 = c12960r.f9244b;
            String strEncodeBase64 = null;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                ArrayList arrayList4 = c12956n.f9223e.f9244b;
                if (arrayList4 == null || arrayList4.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AbstractC13495d) it.next()).m14274k());
                    }
                }
                if (arrayList != null) {
                    c6742k.m4866x("spanOrderDataList", "spanOrderData", arrayList);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            ArrayList<AbstractC13495d> arrayList6 = new ArrayList();
            ArrayList arrayList7 = c12956n.f9223e.f9244b;
            if (arrayList7 != null && !arrayList7.isEmpty()) {
                for (AbstractC13495d abstractC13495d : c12956n.f9223e.f9244b) {
                    if (abstractC13495d.f9472b == abstractC13495d.f9473c) {
                        arrayList5.add(abstractC13495d.m14274k());
                    } else {
                        arrayList6.add(abstractC13495d);
                    }
                }
            }
            if (!arrayList5.isEmpty()) {
                c6742k.m4866x("zeroLengthSpanList", "zeroLengthSpan", arrayList5);
            }
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            C12960r c12960r2 = c12956n.f9223e;
            String str = c12960r2.f9243a;
            ArrayList<AbstractC13493b> arrayList8 = c12960r2.f9245c;
            ArrayList<C13494c> arrayList9 = c12960r2.f9252j;
            ArrayList<C13492a> arrayList10 = c12960r2.f9246d;
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            if (str == null || str.isEmpty()) {
                Log.e("WConverter_WRichTextParser", "empty text");
            } else {
                ArrayList arrayList11 = new ArrayList();
                for (AbstractC13493b abstractC13493b : arrayList8) {
                    AbstractC13493b abstractC13493bM15145e = AbstractC14517a.m15145e(abstractC13493b.f9466a);
                    if (abstractC13493bM15145e != null) {
                        abstractC13493bM15145e.mo14264g(abstractC13493b);
                        arrayList11.add(abstractC13493bM15145e);
                    }
                }
                ArrayList arrayList12 = new ArrayList();
                for (AbstractC13495d abstractC13495d2 : arrayList6) {
                    AbstractC13495d abstractC13495dM15146f = AbstractC14517a.m15146f(abstractC13495d2.f9471a);
                    if (abstractC13495dM15146f != null) {
                        abstractC13495dM15146f.mo14271g(abstractC13495d2);
                        abstractC13495dM15146f.f9473c = abstractC13495d2.f9473c - 1;
                        arrayList12.add(abstractC13495dM15146f);
                    }
                }
                ArrayList arrayList13 = new ArrayList();
                for (C13492a c13492a : arrayList10) {
                    C13492a c13492a2 = new C13492a();
                    c13492a2.f9460a = c13492a.f9460a;
                    c13492a2.f9461b = c13492a.f9461b;
                    c13492a2.f9462c = c13492a.f9462c;
                    c13492a2.f9463d = c13492a.f9463d;
                    c13492a2.f9464e = c13492a.f9464e;
                    c13492a2.f9465f = c13492a.f9465f;
                    c13492a2.f9463d = c13492a.f9463d - 1;
                    arrayList13.add(c13492a2);
                }
                ArrayList arrayList14 = new ArrayList();
                for (C13494c c13494c : arrayList9) {
                    C13494c c13494c2 = new C13494c();
                    c13494c2.f9469a = c13494c.f9469a;
                    c13494c2.f9470b = c13494c.f9470b;
                    arrayList14.add(c13494c2);
                }
                Collections.sort(arrayList11, new C13521b(1));
                if (!str.isEmpty() && !arrayList11.isEmpty()) {
                    ArrayList arrayList15 = new ArrayList();
                    int i = 0;
                    for (int i2 = 0; i2 < str.length(); i2++) {
                        char cCharAt = str.charAt(i2);
                        if (cCharAt == '\n' || cCharAt == '\r') {
                            C13523d c13523d = new C13523d();
                            if (i2 == 0) {
                                c13523d.f9518a = -1;
                                c13523d.f9519b = -2;
                            } else {
                                c13523d.f9518a = i;
                                c13523d.f9519b = i2 - 1;
                                i = i2;
                            }
                            arrayList15.add(c13523d);
                        }
                    }
                    C13523d c13523d2 = new C13523d();
                    c13523d2.f9518a = i;
                    c13523d2.f9519b = str.length() - 1;
                    arrayList15.add(c13523d2);
                    Iterator it2 = arrayList11.iterator();
                    while (it2.hasNext()) {
                        InterfaceC12016a interfaceC12016a = (InterfaceC12016a) it2.next();
                        if (interfaceC12016a.start() >= arrayList15.size()) {
                            it2.remove();
                        } else {
                            C13523d c13523d3 = (C13523d) arrayList15.get(interfaceC12016a.start());
                            interfaceC12016a.start(c13523d3.f9518a);
                            interfaceC12016a.end(c13523d3.f9519b);
                        }
                    }
                }
                ArrayList arrayList16 = new ArrayList(arrayList12);
                arrayList16.addAll(arrayList13);
                arrayList16.addAll(arrayList11);
                arrayList16.addAll(arrayList14);
                ArrayList arrayList17 = new ArrayList(arrayList16);
                Iterator it3 = arrayList17.iterator();
                while (it3.hasNext()) {
                    InterfaceC12016a interfaceC12016a2 = (InterfaceC12016a) it3.next();
                    if (interfaceC12016a2.end() - interfaceC12016a2.start() < 0) {
                        it3.remove();
                    }
                }
                Collections.sort(arrayList16, new C13521b(0));
                Collections.sort(arrayList17, new C13521b(1));
                try {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder sb3 = new StringBuilder();
                    int i4 = 0;
                    while (i4 < str.length()) {
                        char cCharAt2 = str.charAt(i4);
                        ArrayList arrayListM260f = C0112b.m260f(i4, arrayList16);
                        ArrayList arrayListM259e = C0112b.m259e(i4, arrayList17);
                        C0112b.m263n(arrayListM260f, sb2, sb, sb3, true);
                        sb2.append(cCharAt2);
                        C0112b.m263n(arrayListM259e, sb2, sb, sb3, false);
                        i4++;
                    }
                    if (sb.length() > 0) {
                        sb.insert(0, "<?a");
                        sb.append("?>");
                        sb3.append((CharSequence) sb);
                        sb.delete(0, sb.length());
                    }
                    if (sb2.length() > 0) {
                        sb3.append(Base64Utils.encodeBase64(sb2.toString()));
                    }
                    ArrayList arrayListM260f2 = C0112b.m260f(i4, arrayList16);
                    ArrayList arrayListM259e2 = C0112b.m259e(i4, arrayList17);
                    sb.append(C0112b.m258d(arrayListM260f2));
                    sb.append(C0112b.m257c(arrayListM259e2));
                    if (sb.length() > 0) {
                        sb.insert(0, "<?a");
                        sb.append("?>");
                        sb3.append((CharSequence) sb);
                        sb.delete(0, sb.length());
                    }
                    strEncodeBase64 = Base64Utils.encodeBase64(sb3.toString());
                } catch (UnsupportedEncodingException unused) {
                    Log.d("WConverter_WRichTextParser", "fail encoding base64 : ".concat(str));
                    throw new IllegalArgumentException("fail encoding base64!!");
                }
            }
            c6742k.m4865w("text", strEncodeBase64);
        }
        if (c12952j.m13849a() != null) {
            c6742k.m4864v("fillEffect", c12952j.m13849a());
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12927m)) {
            return false;
        }
        C12927m c12927m = (C12927m) obj;
        C12953k c12953k = c12927m.f9083c0;
        C12956n c12956n = c12927m.f9082b0;
        C12954l c12954l = c12927m.f9081a0;
        C12952j c12952j = c12927m.f9080Z;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectShape", " !! equals() - NE - super check");
            return false;
        }
        C12952j c12952j2 = this.f9080Z;
        if (!AbstractC0299q.m635j(c12952j2, c12952j)) {
            Log.i("WCon_ObjectShape", " !! equals() - NE - shapeData[" + c12952j2 + " - " + c12952j + "]");
            return false;
        }
        C12954l c12954l2 = this.f9081a0;
        if (!AbstractC0299q.m635j(c12954l2, c12954l)) {
            Log.i("WCon_ObjectShape", " !! equals() - NE - shapePen[" + c12954l2 + " - " + c12954l + "]");
            return false;
        }
        C12956n c12956n2 = this.f9082b0;
        if (!AbstractC0299q.m635j(c12956n2, c12956n)) {
            Log.i("WCon_ObjectShape", " !! equals() - NE - shapeText[" + c12956n2 + " - " + c12956n + "]");
            return false;
        }
        C12953k c12953k2 = this.f9083c0;
        if (!AbstractC0299q.m635j(c12953k2, c12953k)) {
            Log.i("WCon_ObjectShape", " !! equals() - NE - shapeImage[" + c12953k2 + " - " + c12953k + "]");
            return false;
        }
        if (this.f9084d0 != c12927m.f9084d0) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - controlPointCount[");
            sb.append((int) this.f9084d0);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12927m.f9084d0, "]", "WCon_ObjectShape", sb);
            return false;
        }
        if (AbstractC0299q.m631h(this.f9085e0, c12927m.f9085e0)) {
            return true;
        }
        Log.i("WCon_ObjectShape", " !! equals() - NE - controlPoints[" + this.f9085e0 + " - " + c12927m.f9085e0 + "]");
        return false;
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        byte b;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        AbstractC13493b abstractC13493bM15145e;
        AbstractC13495d abstractC13495dM15146f;
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectShapeBase::NewApplyBinary() fail. baseSize: ", "WCon_ObjectShape");
            return iMo13812l;
        }
        int i15 = i + iMo13812l;
        int i16 = ((ByteBuffer) c12020a.f8772b).getInt(i15);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i15 + 4);
        int i17 = i15 + 6;
        if (s != 7) {
            AbstractC0541b.m758D(s, "ApplyOwnBinary() - Invalid data type: ", "WCon_ObjectShape");
            i6 = iMo13812l;
            i7 = -1;
        } else {
            int i18 = ((ByteBuffer) c12020a.f8772b).getInt(i17);
            byte b5 = ((ByteBuffer) c12020a.f8772b).get(i15 + 10);
            int i19 = i15 + 11;
            if (b5 > 1) {
                b = ((ByteBuffer) c12020a.f8772b).get(i19);
                i19 = i15 + 12;
            } else if (b5 == 1) {
                byte b6 = ((ByteBuffer) c12020a.f8772b).get(i19);
                i19 += b5;
                b = b6;
            } else {
                b = 0;
            }
            byte b7 = ((ByteBuffer) c12020a.f8772b).get(i19);
            int i20 = i19 + 1;
            if (b7 > 4) {
                i5 = ((ByteBuffer) c12020a.f8772b).getInt(i20);
                i20 = i19 + 5;
            } else {
                if (b7 == 1) {
                    i4 = ((ByteBuffer) c12020a.f8772b).get(i20);
                } else if (b7 == 2) {
                    i4 = ((ByteBuffer) c12020a.f8772b).getShort(i20);
                } else if (b7 != 4) {
                    i5 = 0;
                } else {
                    i4 = ((ByteBuffer) c12020a.f8772b).getInt(i20);
                }
                i20 += b7;
                i5 = i4;
            }
            boolean z = (b & 1) != 0;
            boolean z2 = (b & 2) != 0;
            int i21 = b & 8;
            C12956n c12956n = this.f9082b0;
            if (i21 == 0) {
                c12956n.f9231m = false;
            } else {
                c12956n.f9231m = true;
            }
            if ((b & 16) == 0) {
                c12956n.f9232n = false;
            } else {
                c12956n.f9232n = true;
            }
            if ((b & 4) == 0) {
                c12956n.f9233o = false;
            } else {
                c12956n.f9233o = true;
            }
            int i22 = b & 32;
            C12953k c12953k = this.f9083c0;
            if (i22 == 0) {
                c12953k.f9209j = false;
            } else {
                c12953k.f9209j = true;
            }
            int i23 = ((ByteBuffer) c12020a.f8772b).getInt(i20);
            C12952j c12952j = this.f9080Z;
            c12952j.f9188a = i23;
            SpenRectD spenRectDM13642o = c12020a.m13642o(i20 + 4);
            int i24 = i5;
            c12952j.f9198k = new RectF((float) spenRectDM13642o.left, (float) spenRectDM13642o.top, (float) spenRectDM13642o.right, (float) spenRectDM13642o.bottom);
            c12952j.f9199l = ((ByteBuffer) c12020a.f8772b).getFloat(i20 + 36);
            c12952j.f9193f = new C12955m();
            int i25 = ((ByteBuffer) c12020a.f8772b).getInt(i20 + 40);
            int iM13850b = i20 + 44;
            if (i25 > 0) {
                C12955m c12955m = c12952j.f9193f;
                C12958p c12958p = c12955m.f9218e;
                if (c12958p == null && c12958p == null) {
                    c12955m.f9218e = new C12958p();
                }
                C12955m c12955m2 = c12952j.f9193f;
                c12955m2.f9216c = c12952j.f9198k;
                c12955m2.f9217d = c12952j.f9199l;
                c12955m2.f9215b = z2;
                c12955m2.f9214a = z;
                iM13850b += c12955m2.f9218e.m13850b(c12020a, iM13850b);
            }
            this.f9084d0 = ((ByteBuffer) c12020a.f8772b).get(iM13850b);
            int i26 = iM13850b + 1;
            for (int i27 = 0; i27 < this.f9084d0; i27++) {
                SpenPointD spenPointDM13640m = c12020a.m13640m(i26);
                this.f9085e0.add(new PointF((float) spenPointDM13640m.x, (float) spenPointDM13640m.y));
                i26 += 16;
            }
            if (this.f8990a == 7) {
                SpenRectD spenRectDM13642o2 = c12020a.m13642o(i26);
                c12952j.f9197j = new RectF((float) spenRectDM13642o2.left, (float) spenRectDM13642o2.top, (float) spenRectDM13642o2.right, (float) spenRectDM13642o2.bottom);
            }
            if (i18 != 0) {
                int i28 = i15 + i18;
                int i29 = this.f9005p;
                c12956n.getClass();
                if ((i24 & 1) != 0) {
                    c12956n.f9230l = ((ByteBuffer) c12020a.f8772b).getInt(i28);
                    int i30 = i28 + 4;
                    if (c12956n.f9223e == null) {
                        c12956n.f9223e = new C12960r();
                    }
                    C12960r c12960r = c12956n.f9223e;
                    C6906i c6906i = c12956n.f9234p;
                    c12960r.getClass();
                    int i31 = ((ByteBuffer) c12020a.f8772b).getInt(i30);
                    int i32 = i28 + 8;
                    if (i31 > 0) {
                        c12960r.f9243a = c12020a.m13645r(i32, i31);
                        i32 += i31 * 2;
                    }
                    int i33 = ((ByteBuffer) c12020a.f8772b).getInt(i32);
                    int i34 = i32 + 4;
                    int i35 = 0;
                    while (i35 < i33) {
                        short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i34);
                        int i36 = i34 + 2;
                        int i37 = iMo13812l;
                        int i38 = ((ByteBuffer) c12020a.f8772b).getInt(i36);
                        int i39 = i28;
                        if (i38 != 0 && i38 != 8 && i38 != 10 && i38 != 11 && i38 != 12 && i38 != 13 && i38 < 21 && (abstractC13495dM15146f = AbstractC14517a.m15146f(i38)) != null) {
                            abstractC13495dM15146f.mo14270f(c12020a, i36);
                            c12960r.f9244b.add(abstractC13495dM15146f);
                        }
                        i34 = i36 + s2;
                        i35++;
                        iMo13812l = i37;
                        i28 = i39;
                    }
                    i6 = iMo13812l;
                    i8 = i28;
                    int i40 = (i34 - i32) + i32;
                    int i41 = ((ByteBuffer) c12020a.f8772b).getInt(i40);
                    int i42 = i40 + 4;
                    for (int i43 = 0; i43 < i41; i43++) {
                        short s3 = ((ByteBuffer) c12020a.f8772b).getShort(i42);
                        int i44 = i42 + 2;
                        int i45 = ((ByteBuffer) c12020a.f8772b).getInt(i44);
                        if (i45 < 11 && (abstractC13493bM15145e = AbstractC14517a.m15145e(i45)) != null) {
                            abstractC13493bM15145e.mo14263f(c12020a, i44);
                            c12960r.f9245c.add(abstractC13493bM15145e);
                        }
                        i42 = i44 + s3;
                    }
                    int i46 = (i42 - i40) + i40;
                    c12960r.f9247e = ((ByteBuffer) c12020a.f8772b).getFloat(i46);
                    c12960r.f9248f = ((ByteBuffer) c12020a.f8772b).getFloat(i46 + 4);
                    c12960r.f9249g = ((ByteBuffer) c12020a.f8772b).getFloat(i46 + 8);
                    c12960r.f9250h = ((ByteBuffer) c12020a.f8772b).getFloat(i46 + 12);
                    c12960r.f9251i = ((ByteBuffer) c12020a.f8772b).get(i46 + 16);
                    short s4 = ((ByteBuffer) c12020a.f8772b).getShort(i46 + 17);
                    int i47 = i46 + 19;
                    for (int i48 = 0; i48 < s4; i48++) {
                        C13494c c13494c = new C13494c();
                        c13494c.f9469a = ((ByteBuffer) c12020a.f8772b).getInt(i47);
                        c13494c.f9470b = ((ByteBuffer) c12020a.f8772b).getInt(i47 + 4);
                        i47 += 8;
                        c12960r.f9252j.add(c13494c);
                    }
                    if (i29 >= 2035) {
                        int i49 = ((ByteBuffer) c12020a.f8772b).getInt(i47);
                        ((ByteBuffer) c12020a.f8772b).getInt(i47 + 4);
                        int i50 = i47 + 8;
                        if ((i49 & 1) != 0) {
                            c12960r.f9246d.clear();
                            int i51 = ((ByteBuffer) c12020a.f8772b).getInt(i50);
                            int i52 = i47 + 12;
                            int i53 = 0;
                            while (i53 < i51) {
                                int i54 = ((ByteBuffer) c12020a.f8772b).getInt(i52);
                                int i55 = i52 + 4;
                                C13492a c13492a = new C13492a();
                                int i56 = ((ByteBuffer) c12020a.f8772b).getInt(i55);
                                int i57 = i51;
                                int i58 = ((ByteBuffer) c12020a.f8772b).getInt(i52 + 8);
                                int i59 = i52 + 12;
                                AbstractC12916b abstractC12916bM15143c = AbstractC14517a.m15143c(i58, c6906i);
                                c13492a.f9460a = abstractC12916bM15143c;
                                if (abstractC12916bM15143c == null) {
                                    i14 = -1;
                                } else {
                                    abstractC12916bM15143c.mo13812l(c12020a, i59, i56);
                                    int i60 = i59 + i56;
                                    int i61 = ((ByteBuffer) c12020a.f8772b).getInt(i60);
                                    c13492a.f9462c = i61;
                                    c13492a.f9463d = i61 + 1;
                                    c13492a.f9461b = c13492a.f9460a.mo13811k();
                                    c13492a.f9464e = ((ByteBuffer) c12020a.f8772b).getInt(i60 + 4);
                                    c13492a.f9465f = ((ByteBuffer) c12020a.f8772b).getInt(i60 + 8);
                                    Log.i("TextObjectSpan", "Done Apply Bin uuid - " + c13492a.f9461b);
                                    i14 = (i60 + 12) - i55;
                                }
                                if (i14 == -1) {
                                    break;
                                }
                                c12960r.f9246d.add(c13492a);
                                i52 = i55 + i54;
                                i53++;
                                i51 = i57;
                            }
                        }
                    }
                    i9 = i30 + c12956n.f9230l;
                } else {
                    i6 = iMo13812l;
                    i8 = i28;
                    i9 = i8;
                }
                if ((i24 & 2) != 0) {
                    c12956n.f9224f = ((ByteBuffer) c12020a.f8772b).get(i9);
                    i9++;
                }
                int i62 = (i9 - i8) + i8;
                C12954l c12954l = this.f9081a0;
                c12954l.getClass();
                if ((i24 & 4) != 0) {
                    c12954l.f9211a = ((ByteBuffer) c12020a.f8772b).getInt(i62);
                    i10 = i62 + 4;
                } else {
                    i10 = i62;
                }
                if ((i24 & 8) != 0) {
                    c12954l.f9212b = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                if ((i24 & 16) != 0) {
                    c12954l.f9213c = ((ByteBuffer) c12020a.f8772b).getInt(i10);
                    i10 += 4;
                }
                int i63 = (i10 - i62) + i62;
                if ((i24 & 32) != 0) {
                    int i64 = ((ByteBuffer) c12020a.f8772b).getInt(i63);
                    byte b8 = ((ByteBuffer) c12020a.f8772b).get(i63 + 4);
                    int i65 = i63 + 5;
                    if (b8 == 1) {
                        C12945c c12945c = new C12945c();
                        c12952j.f9190c = c12945c;
                        int i66 = i63 + 7;
                        byte b9 = ((ByteBuffer) c12020a.f8772b).get(i63 + 6);
                        c12945c.f9147c = (byte) (b9 & 1);
                        c12945c.f9148d = ((b9 >> 1) & 1) == 1;
                        c12945c.f9146b = ((ByteBuffer) c12020a.f8772b).getInt(i66);
                        c12945c.f9149e = ((ByteBuffer) c12020a.f8772b).get(i63 + 11);
                        c12945c.f9150f = ((ByteBuffer) c12020a.f8772b).getShort(i63 + 12);
                        c12945c.f9151g = c12020a.m13638k(i63 + 14);
                        int i67 = i63 + 23;
                        c12945c.f9152h = ((ByteBuffer) c12020a.f8772b).get(i63 + 22);
                        for (int i68 = 0; i68 < c12945c.f9152h; i68++) {
                            C12944b c12944b = new C12944b();
                            c12944b.f9144a = ((ByteBuffer) c12020a.f8772b).getInt(i67);
                            c12944b.f9145b = ((ByteBuffer) c12020a.f8772b).getFloat(i67 + 4);
                            i67 += 8;
                            c12945c.f9153i.add(c12944b);
                        }
                    } else if (b8 == 2) {
                        C12947e c12947e = new C12947e(this.f8988S);
                        c12952j.f9191d = c12947e;
                        c12947e.f9155b = ((ByteBuffer) c12020a.f8772b).get(i65);
                        c12947e.f9156c = ((ByteBuffer) c12020a.f8772b).getInt(i63 + 6);
                        c12947e.f9160g = c12020a.m13643p(i63 + 10);
                        c12947e.f9161h = c12020a.m13638k(i63 + 26);
                        c12947e.f9162i = ((ByteBuffer) c12020a.f8772b).getFloat(i63 + 34);
                        c12947e.f9163j = ((ByteBuffer) c12020a.f8772b).getFloat(i63 + 38);
                        c12947e.f9164k = ((ByteBuffer) c12020a.f8772b).getFloat(i63 + 42);
                        int i69 = i63 + 47;
                        c12947e.f9165l = ((ByteBuffer) c12020a.f8772b).get(i63 + 46) == 1;
                        Rect rectM13641n = c12020a.m13641n(i69);
                        int i70 = i63 + 63;
                        if (c12947e.f9156c >= 0) {
                            c12947e.f9158e = rectM13641n;
                        }
                        int i71 = ((ByteBuffer) c12020a.f8772b).getInt(i70);
                        if (c12947e.f9156c >= 0) {
                            c12947e.f9159f = i71;
                        }
                    } else if (b8 != 3) {
                        if (b8 == 4) {
                            C12943a c12943a = new C12943a(4);
                            c12952j.f9189b = c12943a;
                            c12943a.f9143b = ((ByteBuffer) c12020a.f8772b).getFloat(i65);
                        }
                        i11 = i65 - i63;
                    } else {
                        C12948f c12948f = new C12948f(3);
                        c12952j.f9192e = c12948f;
                        byte[] bArr = new byte[8];
                        c12948f.f9167b = bArr;
                        c12020a.m13639l(i65, bArr);
                        c12948f.f9168c = ((ByteBuffer) c12020a.f8772b).getInt(i63 + 13);
                        c12948f.f9169d = ((ByteBuffer) c12020a.f8772b).getInt(i63 + 17);
                    }
                    i65 += i64;
                    i11 = i65 - i63;
                } else {
                    i11 = 0;
                }
                int i72 = i63 + i11;
                if ((i24 & 64) != 0) {
                    ((ByteBuffer) c12020a.f8772b).getInt(i72);
                    i12 = i72 + 4;
                } else {
                    i12 = i72;
                }
                if ((i24 & 128) != 0) {
                    ((ByteBuffer) c12020a.f8772b).getInt(i12);
                    i12 += 4;
                }
                if ((i24 & 256) != 0) {
                    ((ByteBuffer) c12020a.f8772b).getShort(i12);
                    i12 += 2;
                }
                int i73 = (i12 - i72) + i72;
                if ((i24 & 512) != 0) {
                    short s5 = ((ByteBuffer) c12020a.f8772b).getShort(i73);
                    int i74 = i73 + 2;
                    c12956n.f9225g = c12020a.m13645r(i74, s5);
                    i13 = (s5 * 2) + i74;
                } else {
                    i13 = i73;
                }
                if ((i24 & 1024) != 0) {
                    c12956n.f9226h = ((ByteBuffer) c12020a.f8772b).getInt(i13);
                    i13 += 4;
                }
                if ((i24 & 2048) != 0) {
                    c12956n.f9227i = ((ByteBuffer) c12020a.f8772b).getFloat(i13);
                    i13 += 4;
                }
                if ((4194304 & i24) != 0) {
                    c12956n.f9229k = ((ByteBuffer) c12020a.f8772b).get(i13);
                    i13++;
                }
                int i75 = (i13 - i73) + i73;
                if ((i24 & 4096) != 0) {
                    c12956n.f9219a = ((ByteBuffer) c12020a.f8772b).get(i75);
                    i75++;
                }
                if ((i24 & 8192) != 0) {
                    c12956n.f9220b = ((ByteBuffer) c12020a.f8772b).get(i75);
                    i75++;
                }
                if ((i24 & 16384) != 0) {
                    c12956n.f9221c = ((ByteBuffer) c12020a.f8772b).get(i75);
                    i75++;
                } else {
                    c12956n.f9221c = ObjectShapeConst$IMEActionType.IME_ACTION_TYPE_NONE.ordinal();
                }
                if ((32768 & i24) != 0) {
                    c12956n.f9222d = ((ByteBuffer) c12020a.f8772b).get(i75);
                    i75++;
                } else {
                    c12956n.f9222d = 1;
                }
                if ((2097152 & i24) != 0) {
                    c12956n.f9228j = ((ByteBuffer) c12020a.f8772b).getFloat(i75);
                }
            } else {
                i6 = iMo13812l;
            }
            i7 = i16;
        }
        if (i7 >= 0) {
            return i7 + i6;
        }
        AbstractC0541b.m758D(i7, "ObjectShape::NewApplyBinary() fail to apply own binary. ", "WCon_ObjectShape");
        return i7;
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public int mo13813m(C12020a c12020a, int i) {
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectShapeBase newGetBinary() fail. err = ", "WCon_ObjectShape");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        C12954l c12954l = this.f9081a0;
        C12956n c12956n = this.f9082b0;
        C12952j c12952j = this.f9080Z;
        int i9 = iMo13814n + 17;
        try {
            C12955m c12955m = c12952j.f9193f;
            byte b = c12955m.f9214a ? (byte) 1 : (byte) 0;
            if (c12955m.f9215b) {
                b = (byte) (b | 2);
            }
            if (c12956n.f9231m) {
                b = (byte) (b | 8);
            }
            if (c12956n.f9232n) {
                b = (byte) (b | 16);
            }
            if (c12956n.f9233o) {
                b = (byte) (b | 4);
            }
            if (this.f9083c0.f9209j) {
                b = (byte) (b | 32);
            }
            c12020a.m13649v(i9, c12952j.f9188a);
            c12020a.m13622A(iMo13814n + 21, new SpenRectD(c12952j.f9198k));
            c12020a.m13648u(c12952j.f9199l, iMo13814n + 53);
            int i10 = iMo13814n + 57;
            C12958p c12958p = c12952j.f9193f.f9218e;
            if (c12958p != null) {
                int iM13852d = c12958p.m13852d();
                c12020a.m13649v(i10, iM13852d);
                int i11 = iMo13814n + 61;
                c12958p.m13851c(c12020a, i11);
                i4 = i11 + iM13852d;
            } else {
                c12020a.m13649v(i10, 0);
                i4 = iMo13814n + 61;
            }
            c12020a.m13646s(i4, this.f9084d0);
            int i12 = i4 + 1;
            if (this.f9084d0 > 0) {
                SpenPointD spenPointD = new SpenPointD();
                for (int i13 = 0; i13 < this.f9084d0; i13++) {
                    spenPointD.set((PointF) this.f9085e0.get(i13));
                    c12020a.m13652y(i12, spenPointD);
                    i12 += 16;
                }
            }
            if (this.f8990a == 7) {
                c12020a.m13622A(i12, new SpenRectD(c12952j.f9197j));
                i12 += 32;
            }
            int i14 = i12 - iMo13814n;
            C12960r c12960r = c12956n.f9223e;
            if (c12960r != null) {
                int iM13855b = c12960r.m13855b(this.f9005p);
                c12020a.m13649v(i12, iM13855b);
                int i15 = i12 + 4;
                c12956n.f9223e.m13854a(c12020a, i15, this.f9005p);
                i12 = i15 + iM13855b;
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (c12956n.f9224f != ObjectShapeConst$TextAreaType.TEXT_AREA_TYPE_MARGIN.ordinal()) {
                c12020a.m13646s(i12, c12956n.f9224f);
                i12++;
                i5 |= 2;
            }
            int i16 = c12954l.f9211a;
            if (i16 != -1) {
                c12020a.m13649v(i12, i16);
                i6 = i12 + 4;
                i2 = 4;
            } else {
                i6 = i12;
                i2 = 0;
            }
            int i17 = c12954l.f9212b;
            if (i17 != -1) {
                c12020a.m13649v(i6, i17);
                i6 += 4;
                i2 |= 8;
            }
            int i18 = c12954l.f9213c;
            if (i18 != -1) {
                c12020a.m13649v(i6, i18);
                i2 |= 16;
            }
            int i19 = i5 | i2;
            int i20 = c12954l.f9211a != -1 ? 4 : 0;
            if (c12954l.f9212b != -1) {
                i20 += 4;
            }
            if (c12954l.f9213c != -1) {
                i20 += 4;
            }
            int i21 = i12 + i20;
            AbstractC12946d abstractC12946dM13849a = c12952j.m13849a();
            try {
                if (abstractC12946dM13849a != null) {
                    int i22 = abstractC12946dM13849a.f9154a;
                    if (i22 == 1) {
                        i2 = -1;
                        int iMo13844c = c12952j.f9190c.mo13844c();
                        c12020a.m13649v(i21, c12952j.f9190c.mo13844c());
                        c12020a.m13646s(i21 + 4, 1);
                        int i23 = i21 + 5;
                        c12952j.f9190c.m13846e(c12020a, i23);
                        i21 = i23 + iMo13844c;
                    } else if (i22 == 2) {
                        i2 = -1;
                        c12952j.f9191d.getClass();
                        c12952j.f9191d.getClass();
                        c12020a.m13649v(i21, 62);
                        c12020a.m13646s(i21 + 4, 2);
                        c12952j.f9191d.m13848e(c12020a, i21 + 5);
                        i21 += 67;
                    } else if (i22 != 3) {
                        i2 = -1;
                        if (i22 == 4) {
                            c12952j.f9189b.getClass();
                            c12952j.f9189b.getClass();
                            c12020a.m13649v(i21, 4);
                            c12020a.m13646s(i21 + 4, 4);
                            c12020a.m13648u(c12952j.f9189b.f9143b, i21 + 5);
                            i21 += 9;
                        }
                    } else {
                        i2 = -1;
                        c12952j.f9192e.getClass();
                        c12952j.f9192e.getClass();
                        c12020a.m13649v(i21, 16);
                        c12020a.m13646s(i21 + 4, 3);
                        C12948f c12948f = c12952j.f9192e;
                        c12020a.m13651x(i21 + 5, c12948f.f9167b);
                        c12020a.m13649v(i21 + 13, c12948f.f9168c);
                        c12020a.m13649v(i21 + 17, c12948f.f9169d);
                        i21 += 21;
                    }
                    i19 |= 32;
                } else {
                    i2 = -1;
                }
                String str = c12956n.f9225g;
                if (str != null) {
                    int length = str.length();
                    c12020a.m13647t(i21, length);
                    int i24 = i21 + 2;
                    c12020a.m13626E(i24, c12956n.f9225g);
                    i7 = (length * 2) + i24;
                    i8 = 512;
                } else {
                    i7 = i21;
                    i8 = 0;
                }
                int i25 = c12956n.f9226h;
                if (i25 != -16777216) {
                    c12020a.m13649v(i7, i25);
                    i7 += 4;
                    i8 |= 1024;
                }
                float f = c12956n.f9227i;
                if (f != 10.0f) {
                    c12020a.m13648u(f, i7);
                    i7 += 4;
                    i8 |= 2048;
                }
                int i26 = c12956n.f9229k;
                if (i26 != 0) {
                    c12020a.m13646s(i7, i26);
                    i7++;
                    i8 |= 4194304;
                }
                int i27 = i7 - i21;
                this.f9086f0 = i27;
                int i28 = i8 | i19;
                if (i27 < 0) {
                    Log.e("WCon_ObjectShape", "Error: please run getShapeBinary_HintText() first to get correct binary size");
                }
                int i29 = i21 + this.f9086f0;
                int iM13828u = m13828u(c12020a, i29) | i28;
                if (this.f9087g0 < 0) {
                    Log.e("WCon_ObjectShape", "Error: please run getShapeBinary_HintText() first to get correct binary size");
                }
                int i30 = i29 + this.f9087g0;
                float f4 = c12956n.f9228j;
                if (f4 != 0.0f) {
                    c12020a.m13648u(f4, i30);
                    i30 += 4;
                    iM13828u |= 2097152;
                }
                int i31 = i30 - iMo13814n;
                int i32 = iM13828u == 0 ? 0 : i14;
                c12020a.m13649v(iMo13814n, i31);
                c12020a.m13647t(iMo13814n + 4, 7);
                c12020a.m13649v(iMo13814n + 6, i32);
                c12020a.m13646s(iMo13814n + 10, 1);
                c12020a.m13646s(iMo13814n + 11, b);
                c12020a.m13646s(iMo13814n + 12, 4);
                c12020a.m13649v(iMo13814n + 13, iM13828u);
                return iMo13813m;
            } catch (IOException e) {
                e = e;
                Debugger.m8610e("WCon_ObjectShape", "Error in IO operation : ", e);
                Log.e("WCon_ObjectShape", "ObjectShape newGetBinary() fail to get own binary. err");
                return i2;
            }
        } catch (IOException e2) {
            e = e2;
            i2 = -1;
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public int mo13814n() {
        int iMo13814n = super.mo13814n();
        C12952j c12952j = this.f9080Z;
        C12958p c12958p = c12952j.f9193f.f9218e;
        int iM1310c = AbstractC1974b.m1310c(this.f9084d0, 16, 1, c12958p != null ? 61 + c12958p.m13852d() : 61);
        if (this.f8990a == 7) {
            iM1310c += 32;
        }
        C12956n c12956n = this.f9082b0;
        C12960r c12960r = c12956n.f9223e;
        if (c12960r != null) {
            iM1310c += c12960r.m13855b(this.f9005p) + 4;
        }
        if (c12956n.f9224f != ObjectShapeConst$TextAreaType.TEXT_AREA_TYPE_MARGIN.ordinal()) {
            iM1310c++;
        }
        C12954l c12954l = this.f9081a0;
        int i = c12954l.f9211a == -1 ? 0 : 4;
        if (c12954l.f9212b != -1) {
            i += 4;
        }
        if (c12954l.f9213c != -1) {
            i += 4;
        }
        int length = i + iM1310c;
        if (c12952j.m13849a() != null) {
            length = length + 5 + c12952j.m13849a().mo13844c();
        }
        String str = c12956n.f9225g;
        if (str != null) {
            length += (str.length() * 2) + 2;
        }
        if (c12956n.f9226h != -16777216) {
            length += 4;
        }
        if (c12956n.f9227i != 10.0f) {
            length += 4;
        }
        if (c12956n.f9229k != 0) {
            length++;
        }
        if (c12956n.f9219a != ObjectShapeConst$EllipsisType.ELLIPSIS_TYPE_NONE.ordinal()) {
            length++;
        }
        if (c12956n.f9220b != ObjectShapeConst$AutoFitOption.AUTO_FIT_OPTION_BOTH.ordinal()) {
            length++;
        }
        if (c12956n.f9221c != ObjectShapeConst$IMEActionType.IME_ACTION_TYPE_NONE.ordinal()) {
            length++;
        }
        if (c12956n.f9222d != ObjectShapeConst$TextInputType.INPUT_TYPE_TEXT.ordinal()) {
            length++;
        }
        if (c12956n.f9228j != 0.0f) {
            length += 4;
        }
        return iMo13814n + length;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        boolean zEqualsIgnoreCase = attributeName.equalsIgnoreCase("isHorizontalFlipped");
        C12952j c12952j = this.f9080Z;
        if (zEqualsIgnoreCase) {
            c12952j.f9193f.f9214a = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("isVerticalFlipped")) {
            c12952j.f9193f.f9215b = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        boolean zEqualsIgnoreCase2 = attributeName.equalsIgnoreCase("isHintTextVisible");
        C12956n c12956n = this.f9082b0;
        if (zEqualsIgnoreCase2) {
            c12956n.f9231m = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("isTextReadOnly")) {
            c12956n.f9232n = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("isTextEditable")) {
            c12956n.f9233o = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("isTransparency")) {
            this.f9083c0.f9209j = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("shapeType")) {
            c12952j.f9188a = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("originalDegree")) {
            c12952j.f9199l = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("leftMargin")) {
            if (c12956n.f9223e == null) {
                c12956n.f9223e = new C12960r();
            }
            c12956n.f9223e.f9247e = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("topMargin")) {
            if (c12956n.f9223e == null) {
                c12956n.f9223e = new C12960r();
            }
            c12956n.f9223e.f9248f = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("rightMargin")) {
            if (c12956n.f9223e == null) {
                c12956n.f9223e = new C12960r();
            }
            c12956n.f9223e.f9249g = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("bottomMargin")) {
            if (c12956n.f9223e == null) {
                c12956n.f9223e = new C12960r();
            }
            c12956n.f9223e.f9250h = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("textGravity")) {
            if (c12956n.f9223e == null) {
                c12956n.f9223e = new C12960r();
            }
            c12956n.f9223e.f9251i = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("textAreaType")) {
            c12956n.f9224f = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        boolean zEqualsIgnoreCase3 = attributeName.equalsIgnoreCase("penName");
        C12954l c12954l = this.f9081a0;
        if (zEqualsIgnoreCase3) {
            c12954l.f9211a = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("defaultPenName")) {
            c12954l.f9212b = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("penStyle")) {
            c12954l.f9213c = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("hintText")) {
            c12956n.f9225g = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("hintTextColor")) {
            c12956n.f9226h = (int) Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("hintTextFontSize")) {
            c12956n.f9227i = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("hintTextStyle")) {
            c12956n.f9229k = (byte) Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("ellipsisType")) {
            c12956n.f9219a = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("textAutoFit")) {
            c12956n.f9220b = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("imeActionType")) {
            c12956n.f9221c = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("textInputType")) {
            c12956n.f9222d = Integer.parseInt(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("hintTextVerticalOffset")) {
            c12956n.f9228j = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public void mo13816p(XmlPullParser xmlPullParser) {
        String attributeValue;
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        boolean zEqualsIgnoreCase = name.equalsIgnoreCase("originalRect");
        C12952j c12952j = this.f9080Z;
        if (zEqualsIgnoreCase) {
            c12952j.f9198k = AbstractC14517a.m15127L(xmlPullParser);
            return;
        }
        if (name.equalsIgnoreCase("path")) {
            C12955m c12955m = c12952j.f9193f;
            C12958p c12958p = c12955m.f9218e;
            if (c12958p == null && c12958p == null) {
                c12955m.f9218e = new C12958p();
            }
            c12952j.f9193f.f9218e.m13853e(xmlPullParser);
            return;
        }
        if (name.equalsIgnoreCase("controlPointList")) {
            this.f9085e0 = new ArrayList();
            AbstractC14517a.m15118C(xmlPullParser);
            while (true) {
                if (eventType == 3 && xmlPullParser.getName().equalsIgnoreCase("controlPointList")) {
                    this.f9084d0 = (byte) this.f9085e0.size();
                    return;
                } else {
                    this.f9085e0.add(AbstractC14517a.m15124I(xmlPullParser));
                    eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
                }
            }
        } else {
            if (name.equalsIgnoreCase("drawnRect")) {
                c12952j.f9197j = AbstractC14517a.m15127L(xmlPullParser);
                return;
            }
            int i = 0;
            AbstractC12946d c12948f = null;
            c13524e = null;
            C13524e c13524e = null;
            c12948f = null;
            if (name.equalsIgnoreCase("text")) {
                String strM15134S = AbstractC14517a.m15134S(xmlPullParser);
                C0112b c0112b = new C0112b();
                c0112b.f362a = new ArrayList();
                C13524e c13524e2 = new C13524e();
                c13524e2.f9520a = "";
                c13524e2.f9521b = new ArrayList();
                c13524e2.f9522c = new ArrayList();
                c13524e2.f9523d = new ArrayList();
                c13524e2.f9524e = new ArrayList();
                c0112b.f363b = c13524e2;
                ArrayList<InterfaceC12016a> arrayList = (ArrayList) c0112b.f362a;
                C13524e c13524e3 = (C13524e) c0112b.f363b;
                if (strM15134S != null && strM15134S.length() != 0) {
                    try {
                        String strDecodeBase64 = Base64Utils.decodeBase64(strM15134S);
                        arrayList.clear();
                        c13524e3.f9520a = "";
                        c13524e3.f9521b.clear();
                        c13524e3.f9522c.clear();
                        c13524e3.f9523d.clear();
                        try {
                            c0112b.m267k(strDecodeBase64);
                            if (!arrayList.isEmpty()) {
                                Log.e("WConverter_WRichTextParser", "not finished Annotater: " + arrayList.size());
                                for (InterfaceC12016a interfaceC12016a : arrayList) {
                                    Log.e("WConverter_WRichTextParser", "not finished Annotater: " + ("{IWAnnotater:, getStartTag=" + interfaceC12016a.mo13619e() + ", getNameTag=" + interfaceC12016a.mo13615a() + ", start=" + interfaceC12016a.start() + "}"));
                                    Log.i("WConverter_WRichTextParser", "xml : ".concat(strM15134S));
                                    if (interfaceC12016a.mo13615a().compareTo("sectionData") == 0) {
                                        interfaceC12016a.end(c13524e3.f9520a.length() > 0 ? c13524e3.f9520a.length() - 1 : 0);
                                        c13524e3.f9523d.add((C13494c) interfaceC12016a);
                                    } else {
                                        if (interfaceC12016a.mo13616b().compareTo("span") != 0) {
                                            throw new IllegalArgumentException("Wrong Annotater Type!!");
                                        }
                                        int length = c13524e3.f9520a.length() - 1;
                                        String strMo13615a = interfaceC12016a.mo13615a();
                                        int iStart = interfaceC12016a.start();
                                        AbstractC13495d abstractC13495dM14269h = AbstractC13495d.m14269h(strMo13615a);
                                        if (abstractC13495dM14269h != null) {
                                            Iterator it = c13524e3.f9521b.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    interfaceC12016a.end(length);
                                                    c13524e3.f9521b.add((AbstractC13495d) interfaceC12016a);
                                                    break;
                                                } else {
                                                    AbstractC13495d abstractC13495d = (AbstractC13495d) it.next();
                                                    if (abstractC13495d.f9471a != abstractC13495dM14269h.f9471a || abstractC13495d.f9472b >= length || abstractC13495d.f9473c <= iStart) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            String str = c13524e3.f9520a;
                            ArrayList<InterfaceC12016a> arrayList2 = c13524e3.f9522c;
                            if (!str.isEmpty() && arrayList2 != null && !arrayList2.isEmpty()) {
                                HashMap map = new HashMap();
                                int i2 = 0;
                                int i4 = 0;
                                for (int i5 = 0; i5 < str.length(); i5++) {
                                    char cCharAt = str.charAt(i5);
                                    if (cCharAt == '\n' || cCharAt == '\r') {
                                        if (i5 == 0) {
                                            map.put(-1, Integer.valueOf(i4));
                                            i4++;
                                        } else {
                                            map.put(Integer.valueOf(i2), Integer.valueOf(i4));
                                            i2 = i5;
                                            i4++;
                                        }
                                    }
                                }
                                map.put(Integer.valueOf(i2), Integer.valueOf(i4));
                                for (InterfaceC12016a interfaceC12016a2 : arrayList2) {
                                    int iIntValue = ((Integer) map.get(Integer.valueOf(interfaceC12016a2.start()))).intValue();
                                    interfaceC12016a2.start(iIntValue);
                                    interfaceC12016a2.end(iIntValue + 1);
                                }
                            }
                            for (AbstractC13495d abstractC13495d2 : c13524e3.f9521b) {
                                abstractC13495d2.f9473c++;
                                if (abstractC13495d2.f9472b < 0) {
                                    abstractC13495d2.f9472b = 0;
                                }
                            }
                            Iterator it2 = c13524e3.f9524e.iterator();
                            while (it2.hasNext()) {
                                ((C13492a) it2.next()).f9463d++;
                            }
                            c13524e = c13524e3;
                        } catch (UnsupportedEncodingException unused) {
                            throw new IllegalArgumentException("parseBodyText Error!");
                        }
                    } catch (UnsupportedEncodingException unused2) {
                        Log.d("WConverter_WRichTextParser", "fail decode base64 : ".concat(strM15134S));
                        throw new IllegalArgumentException("fail decode base64!!");
                    }
                }
                if (c13524e == null) {
                    Log.e("WCon_ObjectShape", "parseElement() : rtData is null!");
                    return;
                }
                C12956n c12956n = this.f9082b0;
                if (c12956n.f9223e == null) {
                    c12956n.f9223e = new C12960r();
                }
                C12960r c12960r = c12956n.f9223e;
                c12960r.f9243a = c13524e.f9520a;
                c12960r.f9244b = c13524e.f9521b;
                c12960r.f9245c = c13524e.f9522c;
                c12960r.f9252j = c13524e.f9523d;
                c12960r.f9246d = c13524e.f9524e;
                return;
            }
            if (name.equalsIgnoreCase("spanOrderDataList")) {
                AbstractC14517a.m15118C(xmlPullParser);
                while (true) {
                    if (eventType == 3 && xmlPullParser.getName().equals("spanOrderDataList")) {
                        return;
                    }
                    String strM15123H = AbstractC14517a.m15123H(xmlPullParser);
                    if (strM15123H.startsWith(Integer.toString(3) + ",") && !strM15123H.contains(Extension.DOT)) {
                        strM15123H = strM15123H.concat(".0");
                    }
                    this.f9088h0.add(strM15123H);
                    eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
                }
            } else {
                if (!name.equalsIgnoreCase("zeroLengthSpanList")) {
                    if (!name.equalsIgnoreCase("fillEffect")) {
                        super.mo13816p(xmlPullParser);
                        return;
                    }
                    int attributeCount = xmlPullParser.getAttributeCount();
                    while (true) {
                        if (i >= attributeCount) {
                            attributeValue = null;
                            break;
                        } else {
                            if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("type")) {
                                attributeValue = xmlPullParser.getAttributeValue(i);
                                break;
                            }
                            i++;
                        }
                    }
                    if (attributeValue != null) {
                        if (attributeValue.equals("background")) {
                            c12948f = new C12943a(4);
                        } else if (attributeValue.equals("color")) {
                            c12948f = new C12945c();
                        } else if (attributeValue.equals("image")) {
                            c12948f = new C12947e(this.f8988S);
                        } else if (attributeValue.equals("pattern")) {
                            c12948f = new C12948f(3);
                        }
                    }
                    if (c12948f != null) {
                        c12948f.mo13845d(xmlPullParser);
                        int i6 = c12948f.f9154a;
                        if (i6 == 1) {
                            if (c12952j.f9190c == null) {
                                c12952j.f9190c = (C12945c) c12948f;
                                return;
                            }
                            return;
                        } else if (i6 == 2) {
                            if (c12952j.f9191d == null) {
                                c12952j.f9191d = (C12947e) c12948f;
                                return;
                            }
                            return;
                        } else if (i6 == 3) {
                            if (c12952j.f9192e == null) {
                                c12952j.f9192e = (C12948f) c12948f;
                                return;
                            }
                            return;
                        } else {
                            if (i6 == 4 && c12952j.f9189b == null) {
                                c12952j.f9189b = (C12943a) c12948f;
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                AbstractC14517a.m15118C(xmlPullParser);
                while (true) {
                    if (eventType == 3 && xmlPullParser.getName().equals("zeroLengthSpanList")) {
                        return;
                    }
                    this.f9089i0.add(AbstractC14517a.m15123H(xmlPullParser));
                    eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
                }
            }
        }
    }

    /* JADX INFO: renamed from: u */
    public final int m13828u(C12020a c12020a, int i) {
        int i2;
        int i4;
        C12956n c12956n = this.f9082b0;
        if (c12956n.f9219a != ObjectShapeConst$EllipsisType.ELLIPSIS_TYPE_NONE.ordinal()) {
            c12020a.m13646s(i, c12956n.f9219a);
            i4 = i + 1;
            i2 = 4096;
        } else {
            i2 = 0;
            i4 = i;
        }
        if (c12956n.f9220b != ObjectShapeConst$AutoFitOption.AUTO_FIT_OPTION_BOTH.ordinal()) {
            c12020a.m13646s(i4, c12956n.f9220b);
            i4++;
            i2 |= 8192;
        }
        if (c12956n.f9221c != ObjectShapeConst$IMEActionType.IME_ACTION_TYPE_NONE.ordinal()) {
            c12020a.m13646s(i4, c12956n.f9221c);
            i4++;
            i2 |= 16384;
        }
        if (c12956n.f9222d != ObjectShapeConst$TextInputType.INPUT_TYPE_TEXT.ordinal()) {
            c12020a.m13646s(i4, c12956n.f9222d);
            i4++;
            i2 |= 32768;
        }
        this.f9087g0 = i4 - i;
        return i2;
    }

    public C12927m(int i, C6906i c6906i) {
        super(i, c6906i);
        this.f9085e0 = new ArrayList();
        this.f9086f0 = -1;
        this.f9087g0 = -1;
        this.f9088h0 = new ArrayList();
        this.f9089i0 = new ArrayList();
        this.f9080Z = new C12952j();
        this.f9081a0 = new C12954l();
        this.f9082b0 = new C12956n(c6906i);
        this.f9083c0 = new C12953k();
    }
}
