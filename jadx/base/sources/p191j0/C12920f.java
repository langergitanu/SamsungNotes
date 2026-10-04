package p191j0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.ObjectShapeConst$BorderType;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.PatternSyntaxException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p178f0.C11979b;
import p186h1.C12020a;
import p194k0.C12952j;
import p194k0.C12953k;
import p194k0.C12956n;
import p194k0.C12960r;
import p198l0.AbstractC13495d;
import p201m0.C13525f;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12920f extends C12927m {

    /* JADX INFO: renamed from: j0 */
    public final /* synthetic */ int f9040j0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C12920f(int i, C6906i c6906i, int i2) {
        super(i, c6906i);
        this.f9040j0 = i2;
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws IOException {
        switch (this.f9040j0) {
            case 0:
                super.mo13804c(c6742k);
                C12952j c12952j = this.f9080Z;
                int i = c12952j.f9194g;
                if (i != 0) {
                    c6742k.m4848d(i, "borderColor");
                }
                float f = c12952j.f9195h;
                if (f != 0.0f) {
                    c6742k.m4849e("borderWidth", f);
                }
                int i2 = c12952j.f9196i;
                if (i2 != 0) {
                    c6742k.m4848d(i2, "borderType");
                }
                C12953k c12953k = this.f9083c0;
                int i4 = c12953k.f9202c;
                C11979b c11979b = this.f8989T;
                if (i4 >= 0) {
                    String strM13559e = c11979b.m13559e(i4);
                    c12953k.f9203d = strM13559e;
                    c6742k.m4851h("borderImageId", strM13559e);
                }
                int i5 = c12953k.f9205f;
                if (i5 != 0) {
                    c6742k.m4848d(i5, "borderNinePatchWidth");
                }
                int i6 = c12953k.f9207h;
                if (i6 >= 0) {
                    String strM13559e2 = c11979b.m13559e(i6);
                    c12953k.f9208i = strM13559e2;
                    c6742k.m4851h("originalImageId", strM13559e2);
                }
                break;
            default:
                super.mo13804c(c6742k);
                C12952j c12952j2 = this.f9080Z;
                int i7 = c12952j2.f9194g;
                if (i7 != 0) {
                    c6742k.m4848d(i7, "borderColor");
                }
                float f4 = c12952j2.f9195h;
                if (f4 != 0.0f) {
                    c6742k.m4849e("borderWidth", f4);
                }
                int i8 = c12952j2.f9196i;
                if (i8 != 0) {
                    c6742k.m4848d(i8, "borderType");
                }
                break;
        }
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public void mo13805d(C6742k c6742k) throws IOException {
        Rect rect;
        switch (this.f9040j0) {
            case 0:
                super.mo13805d(c6742k);
                C12953k c12953k = this.f9083c0;
                Rect rect2 = c12953k.f9200a;
                if (rect2 != null && (rect2.left != 0 || rect2.top != 0 || rect2.right != 0 || rect2.bottom != 0)) {
                    c6742k.m4844C("cropRect", rect2);
                }
                if (c12953k.f9202c >= 0 && (rect = c12953k.f9204e) != null && (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0)) {
                    c6742k.m4844C("borderNinePatchRect", rect);
                }
                RectF rectF = c12953k.f9201b;
                if (rectF != null && (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f)) {
                    c6742k.m4845D("imageBorderLineWidth", rectF);
                }
                Rect rect3 = c12953k.f9210k;
                if (rect3 != null) {
                    if (rect3.left != 0 || rect3.top != 0 || rect3.right != 0 || rect3.bottom != 0) {
                        c6742k.m4844C("imageOriginalRect", rect3);
                    }
                }
                break;
            default:
                super.mo13805d(c6742k);
                break;
        }
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) {
        int i4;
        switch (this.f9040j0) {
            case 0:
                int iMo13812l = super.mo13812l(c12020a, i, i2);
                if (iMo13812l < 0) {
                    AbstractC0541b.m758D(iMo13812l, "ObjectImage::NewApplyBinary() fail. baseSize: ", "WCon_ObjectImage");
                    return iMo13812l;
                }
                int i5 = i + iMo13812l;
                int i6 = ((ByteBuffer) c12020a.f8772b).getInt(i5);
                int i7 = i5 + 6;
                if (((ByteBuffer) c12020a.f8772b).getShort(i5 + 4) != 3) {
                    i6 = -1;
                } else {
                    int i8 = ((ByteBuffer) c12020a.f8772b).getInt(i7);
                    int i9 = ((ByteBuffer) c12020a.f8772b).get(i5 + 10) + i5 + 11;
                    ((ByteBuffer) c12020a.f8772b).get(i9);
                    int i10 = ((ByteBuffer) c12020a.f8772b).getInt(i9 + 1);
                    if (i8 != 0) {
                        int i11 = i5 + i8;
                        int i12 = i10 & 2;
                        C12953k c12953k = this.f9083c0;
                        if (i12 != 0) {
                            Rect rectM13641n = c12020a.m13641n(i11);
                            i11 += 16;
                            c12953k.f9200a = rectM13641n;
                        }
                        int i13 = i10 & 8;
                        C12952j c12952j = this.f9080Z;
                        if (i13 != 0) {
                            c12952j.f9194g = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                            i11 += 4;
                        }
                        if ((i10 & 16) != 0) {
                            c12952j.f9195h = ((ByteBuffer) c12020a.f8772b).getFloat(i11);
                            i11 += 4;
                        }
                        if ((i10 & 32) != 0) {
                            c12952j.f9196i = ((ByteBuffer) c12020a.f8772b).getShort(i11);
                            i11 += 2;
                        }
                        int i14 = i10 & 512;
                        C11979b c11979b = this.f8989T;
                        if (i14 != 0) {
                            int i15 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                            i11 += 4;
                            if (i15 >= 0) {
                                c12953k.f9202c = i15;
                                c12953k.f9203d = c11979b.m13559e(i15);
                            }
                        }
                        if ((i10 & 1024) != 0) {
                            Rect rectM13641n2 = c12020a.m13641n(i11);
                            i11 += 16;
                            if (c12953k.f9202c >= 0) {
                                c12953k.f9204e = rectM13641n2;
                            }
                        }
                        if ((i10 & 2048) != 0) {
                            c12953k.f9201b = c12020a.m13643p(i11);
                            i11 += 16;
                        }
                        if ((i10 & 4096) != 0) {
                            c12953k.f9205f = ((ByteBuffer) c12020a.f8772b).getInt(i11);
                            i11 += 4;
                        }
                        if ((131072 & i10) != 0) {
                            SpenRectD spenRectDM13642o = c12020a.m13642o(i11);
                            c12953k.f9210k = new Rect((int) spenRectDM13642o.left, (int) spenRectDM13642o.top, (int) spenRectDM13642o.right, (int) spenRectDM13642o.bottom);
                            i11 += 32;
                        }
                        if ((262144 & i10) != 0 && (i4 = ((ByteBuffer) c12020a.f8772b).getInt(i11)) >= 0) {
                            c12953k.f9207h = i4;
                            c12953k.f9208i = c11979b.m13559e(i4);
                        }
                    }
                }
                if (i6 >= 0) {
                    return iMo13812l + i6;
                }
                AbstractC0541b.m758D(i6, "ObjectImage::NewApplyBinary() fail to apply own binary. ", "WCon_ObjectImage");
                return i6;
            default:
                int iMo13812l2 = super.mo13812l(c12020a, i, i2);
                if (iMo13812l2 < 0) {
                    AbstractC0541b.m758D(iMo13812l2, "ObjectText::NewApplyBinary() fail. baseSize: ", "WCon_ObjectTextBox");
                    return iMo13812l2;
                }
                int i16 = i + iMo13812l2;
                int i17 = ((ByteBuffer) c12020a.f8772b).getInt(i16);
                short s = ((ByteBuffer) c12020a.f8772b).getShort(i16 + 4);
                int i18 = i16 + 6;
                if (s != 2) {
                    AbstractC0541b.m758D(s, "ApplyTextboxOwnBinary() - Invalid data type ", "WCon_ObjectShape");
                    i17 = -1;
                } else {
                    int i19 = ((ByteBuffer) c12020a.f8772b).getInt(i18);
                    int i20 = ((ByteBuffer) c12020a.f8772b).get(i16 + 10) + i16 + 11;
                    int i21 = i20 + 1;
                    byte b = ((ByteBuffer) c12020a.f8772b).get(i20);
                    short s2 = (b <= 2 && b != 2) ? b == 1 ? ((ByteBuffer) c12020a.f8772b).get(i21) : (short) 0 : ((ByteBuffer) c12020a.f8772b).getShort(i21);
                    if (i19 != 0) {
                        int i22 = i16 + i19;
                        C12952j c12952j2 = this.f9080Z;
                        c12952j2.getClass();
                        if ((s2 & 2) != 0) {
                            c12952j2.f9194g = ((ByteBuffer) c12020a.f8772b).getInt(i22);
                            i22 += 4;
                        }
                        if ((s2 & 4) != 0) {
                            c12952j2.f9195h = ((ByteBuffer) c12020a.f8772b).getFloat(i22);
                            i22 += 4;
                        }
                        if ((s2 & 8) != 0) {
                            c12952j2.f9196i = ((ByteBuffer) c12020a.f8772b).getShort(i22);
                        }
                    }
                }
                if (i17 >= 0) {
                    return iMo13812l2 + i17;
                }
                AbstractC0541b.m758D(i17, "ObjectText::NewApplyBinary() fail to apply own binary. ", "WCon_ObjectTextBox");
                return i17;
        }
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int i2;
        short s;
        switch (this.f9040j0) {
            case 0:
                int iMo13813m = super.mo13813m(c12020a, i);
                if (iMo13813m < 0) {
                    AbstractC0541b.m758D(iMo13813m, "ObjectImage newGetBinary() fail. err = ", "WCon_ObjectImage");
                } else {
                    int iMo13814n = i + super.mo13814n();
                    int i4 = iMo13814n + 17;
                    int i5 = i4 - iMo13814n;
                    C12953k c12953k = this.f9083c0;
                    Rect rect = c12953k.f9200a;
                    if (rect.left == 0 && rect.right == 0 && rect.top == 0 && rect.bottom == 0) {
                        i2 = 0;
                    } else {
                        c12020a.m13653z(i4, rect);
                        i4 = iMo13814n + 33;
                        i2 = 2;
                    }
                    C12952j c12952j = this.f9080Z;
                    int i6 = c12952j.f9194g;
                    if (i6 != 0) {
                        c12020a.m13649v(i4, i6);
                        i4 += 4;
                        i2 |= 8;
                    }
                    float f = c12952j.f9195h;
                    if (f != 0.0f) {
                        c12020a.m13648u(f, i4);
                        i4 += 4;
                        i2 |= 16;
                    }
                    if (c12952j.f9196i != ObjectShapeConst$BorderType.BORDER_TYPE_NONE.ordinal()) {
                        c12020a.m13647t(i4, c12952j.f9196i);
                        i4 += 2;
                        i2 |= 32;
                    }
                    String str = c12953k.f9203d;
                    C11979b c11979b = this.f8989T;
                    if (str != null) {
                        int iM13558d = c11979b.m13558d(str);
                        c12953k.f9202c = iM13558d;
                        c12020a.m13649v(i4, iM13558d);
                        i4 += 4;
                        i2 |= 512;
                    }
                    Rect rect2 = c12953k.f9204e;
                    if (rect2 != null && (rect2.left != 0 || rect2.right != 0 || rect2.top != 0 || rect2.bottom != 0)) {
                        c12020a.m13653z(i4, rect2);
                        i4 += 16;
                        i2 |= 1024;
                    }
                    RectF rectF = c12953k.f9201b;
                    if (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f) {
                        c12020a.m13623B(i4, rectF);
                        i4 += 16;
                        i2 |= 2048;
                    }
                    int i7 = c12953k.f9205f;
                    if (i7 != 0) {
                        c12020a.m13649v(i4, i7);
                        i4 += 4;
                        i2 |= 4096;
                    }
                    Rect rect3 = c12953k.f9210k;
                    int i8 = rect3.left;
                    if (i8 != 0 || rect3.right != 0 || rect3.top != 0 || rect3.bottom != 0) {
                        c12020a.m13622A(i4, new SpenRectD(i8, rect3.top, rect3.right, rect3.bottom));
                        i4 += 32;
                        i2 |= 131072;
                    }
                    String str2 = c12953k.f9208i;
                    if (str2 != null) {
                        int iM13558d2 = c11979b.m13558d(str2);
                        c12953k.f9207h = iM13558d2;
                        c12020a.m13649v(i4, iM13558d2);
                        i4 += 4;
                        i2 |= 262144;
                    }
                    int i9 = i4 - iMo13814n;
                    if (i2 == 0) {
                        i5 = 0;
                    }
                    c12020a.m13649v(iMo13814n, i9);
                    c12020a.m13647t(iMo13814n + 4, 3);
                    c12020a.m13649v(iMo13814n + 6, i5);
                    c12020a.m13646s(iMo13814n + 10, 1);
                    c12020a.m13646s(iMo13814n + 11, 0);
                    c12020a.m13646s(iMo13814n + 12, 4);
                    c12020a.m13649v(iMo13814n + 13, i2);
                }
                return iMo13813m;
            default:
                int iMo13813m2 = super.mo13813m(c12020a, i);
                if (iMo13813m2 < 0) {
                    AbstractC0541b.m758D(iMo13813m2, "ObjectText newGetBinary() fail. err = ", "WCon_ObjectTextBox");
                } else {
                    int iMo13814n2 = i + super.mo13814n();
                    int i10 = iMo13814n2 + 15;
                    int i11 = i10 - iMo13814n2;
                    C12952j c12952j2 = this.f9080Z;
                    int i12 = c12952j2.f9194g;
                    if (i12 != 0) {
                        c12020a.m13649v(i10, i12);
                        i10 = iMo13814n2 + 19;
                        s = (short) 2;
                    } else {
                        s = 0;
                    }
                    float f4 = c12952j2.f9195h;
                    if (f4 != 0.0f) {
                        c12020a.m13648u(f4, i10);
                        i10 += 4;
                        s = (short) (s | 4);
                    }
                    int i13 = c12952j2.f9196i;
                    if (i13 != 0) {
                        c12020a.m13647t(i10, i13);
                        i10 += 2;
                        s = (short) (s | 8);
                    }
                    int i14 = i10 - iMo13814n2;
                    if (s == 0) {
                        i11 = 0;
                    }
                    c12020a.m13649v(iMo13814n2, i14);
                    c12020a.m13647t(iMo13814n2 + 4, 2);
                    c12020a.m13649v(iMo13814n2 + 6, i11);
                    c12020a.m13646s(iMo13814n2 + 10, 1);
                    c12020a.m13646s(iMo13814n2 + 11, 0);
                    c12020a.m13646s(iMo13814n2 + 12, 2);
                    ((ByteBuffer) c12020a.f8772b).putShort(iMo13814n2 + 13, s);
                }
                return iMo13813m2;
        }
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        switch (this.f9040j0) {
            case 0:
                int iMo13814n = super.mo13814n();
                C12953k c12953k = this.f9083c0;
                Rect rect = c12953k.f9200a;
                int i = (rect.left == 0 && rect.right == 0 && rect.top == 0 && rect.bottom == 0) ? 17 : 33;
                C12952j c12952j = this.f9080Z;
                if (c12952j.f9194g != 0) {
                    i += 4;
                }
                if (c12952j.f9195h != 0.0f) {
                    i += 4;
                }
                if (c12952j.f9196i != 0) {
                    i += 2;
                }
                int i2 = c12953k.f9202c;
                if (i2 >= 0) {
                    i += 4;
                }
                Rect rect2 = c12953k.f9204e;
                if (rect2 != null && (rect2.left != 0 || rect2.right != 0 || rect2.top != 0 || rect2.bottom != 0)) {
                    i += 16;
                }
                RectF rectF = c12953k.f9201b;
                if (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f) {
                    i += 16;
                }
                if ((i2 >= 0 ? c12953k.f9205f : 0) != 0) {
                    i += 4;
                }
                Rect rect3 = c12953k.f9210k;
                if (rect3.left != 0 || rect3.right != 0 || rect3.top != 0 || rect3.bottom != 0) {
                    i += 32;
                }
                if (c12953k.f9207h >= 0) {
                    i += 4;
                }
                return iMo13814n + i;
            default:
                int iMo13814n2 = super.mo13814n();
                C12952j c12952j2 = this.f9080Z;
                int i4 = c12952j2.f9194g != 0 ? 19 : 15;
                if (c12952j2.f9195h != 0.0f) {
                    i4 += 4;
                }
                if (c12952j2.f9196i != 0) {
                    i4 += 2;
                }
                return iMo13814n2 + i4;
        }
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        switch (this.f9040j0) {
            case 0:
                String attributeName = xmlPullParser.getAttributeName(i);
                boolean zEqualsIgnoreCase = attributeName.equalsIgnoreCase("borderColor");
                C12952j c12952j = this.f9080Z;
                if (zEqualsIgnoreCase) {
                    c12952j.f9194g = (int) Long.parseLong(xmlPullParser.getAttributeValue(i));
                } else if (attributeName.equalsIgnoreCase("borderWidth")) {
                    c12952j.f9195h = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                } else if (!attributeName.equalsIgnoreCase("borderType")) {
                    boolean zEqualsIgnoreCase2 = attributeName.equalsIgnoreCase("borderImageId");
                    C11979b c11979b = this.f8989T;
                    C12953k c12953k = this.f9083c0;
                    if (zEqualsIgnoreCase2) {
                        String attributeValue = xmlPullParser.getAttributeValue(i);
                        c12953k.f9203d = attributeValue;
                        c12953k.f9202c = c11979b.m13558d(attributeValue);
                    } else if (attributeName.equalsIgnoreCase("borderNinePatchWidth")) {
                        c12953k.f9205f = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                    } else if (!attributeName.equalsIgnoreCase("originalImageId")) {
                        super.mo13815o(xmlPullParser, i);
                    } else {
                        String attributeValue2 = xmlPullParser.getAttributeValue(i);
                        c12953k.f9208i = attributeValue2;
                        c12953k.f9207h = c11979b.m13558d(attributeValue2);
                    }
                } else {
                    c12952j.f9196i = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                }
                break;
            default:
                String attributeName2 = xmlPullParser.getAttributeName(i);
                boolean zEqualsIgnoreCase3 = attributeName2.equalsIgnoreCase("borderColor");
                C12952j c12952j2 = this.f9080Z;
                if (zEqualsIgnoreCase3) {
                    c12952j2.f9194g = (int) Long.parseLong(xmlPullParser.getAttributeValue(i));
                } else if (attributeName2.equalsIgnoreCase("borderWidth")) {
                    c12952j2.f9195h = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                } else if (!attributeName2.equalsIgnoreCase("borderType")) {
                    super.mo13815o(xmlPullParser, i);
                } else {
                    c12952j2.f9196i = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                }
                break;
        }
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public void mo13816p(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        switch (this.f9040j0) {
            case 0:
                String name = xmlPullParser.getName();
                boolean zEqualsIgnoreCase = name.equalsIgnoreCase("cropRect");
                C12953k c12953k = this.f9083c0;
                if (zEqualsIgnoreCase) {
                    c12953k.f9200a = AbstractC14517a.m15125J(xmlPullParser);
                } else if (name.equalsIgnoreCase("borderNinePatchRect")) {
                    c12953k.f9204e = AbstractC14517a.m15125J(xmlPullParser);
                } else if (name.equalsIgnoreCase("imageBorderLineWidth")) {
                    c12953k.f9201b = AbstractC14517a.m15127L(xmlPullParser);
                } else if (!name.equalsIgnoreCase("imageOriginalRect")) {
                    super.mo13816p(xmlPullParser);
                } else {
                    SpenRectD spenRectDM15126K = AbstractC14517a.m15126K(xmlPullParser);
                    c12953k.f9210k = new Rect((int) spenRectDM15126K.left, (int) spenRectDM15126K.top, (int) spenRectDM15126K.right, (int) spenRectDM15126K.bottom);
                }
                break;
            default:
                super.mo13816p(xmlPullParser);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010a  */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v35 */
    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo13817q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int iIndexOf;
        int i;
        ?? Mo14276m;
        C12960r c12960r;
        switch (this.f9040j0) {
            case 1:
                xmlPullParser.require(2, null, CoeditServiceConstants.Element.NAME_OBJECT);
                int attributeCount = xmlPullParser.getAttributeCount();
                int i2 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    mo13815o(xmlPullParser, i4);
                }
                int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
                while (true) {
                    if (iM15119D == 3 && xmlPullParser.getName().equals(CoeditServiceConstants.Element.NAME_OBJECT)) {
                        ArrayList<String> arrayList = this.f9089i0;
                        boolean zIsEmpty = arrayList.isEmpty();
                        C12956n c12956n = this.f9082b0;
                        if (!zIsEmpty) {
                            for (String str : arrayList) {
                                if (str != null && (iIndexOf = str.indexOf(",")) >= 0) {
                                    try {
                                        i = Integer.parseInt(str.substring(i2, iIndexOf));
                                    } catch (NumberFormatException e) {
                                        Log.e("WCon_TextSpanBase", "fail to extractType : " + str + " : " + e);
                                        i = i2;
                                    }
                                } else {
                                    i = i2;
                                }
                                AbstractC13495d abstractC13495dM15146f = AbstractC14517a.m15146f(i);
                                if (abstractC13495dM15146f != null) {
                                    if (str == null) {
                                        Mo14276m = i2;
                                    } else {
                                        try {
                                            String[] strArrSplit = str.split(",");
                                            if (strArrSplit != null) {
                                                if (strArrSplit.length >= 5) {
                                                    try {
                                                        abstractC13495dM15146f.f9472b = Integer.parseInt(strArrSplit[1]);
                                                        abstractC13495dM15146f.f9473c = Integer.parseInt(strArrSplit[2]);
                                                        abstractC13495dM15146f.f9474d = Integer.parseInt(strArrSplit[3]);
                                                        StringBuilder sb = new StringBuilder(strArrSplit[4]);
                                                        for (int i5 = 5; i5 < strArrSplit.length; i5++) {
                                                            sb.append(",");
                                                            sb.append(strArrSplit[i5]);
                                                            break;
                                                        }
                                                        Mo14276m = abstractC13495dM15146f.mo14276m(sb.toString());
                                                    } catch (NumberFormatException e2) {
                                                        e = e2;
                                                        Log.e("WCon_TextSpanBase", "fail to split : " + str + " : " + e);
                                                        Mo14276m = 0;
                                                    } catch (PatternSyntaxException e3) {
                                                        e = e3;
                                                        Log.e("WCon_TextSpanBase", "fail to split : " + str + " : " + e);
                                                        Mo14276m = 0;
                                                    }
                                                }
                                            }
                                            Log.e("WCon_TextSpanBase", "value is wrong : ".concat(str));
                                        } catch (NumberFormatException e5) {
                                            e = e5;
                                            Log.e("WCon_TextSpanBase", "fail to split : " + str + " : " + e);
                                            Mo14276m = 0;
                                            if (Mo14276m == 1) {
                                                c12960r.f9244b.add(abstractC13495dM15146f);
                                            }
                                            i2 = 0;
                                        } catch (PatternSyntaxException e6) {
                                            e = e6;
                                            Log.e("WCon_TextSpanBase", "fail to split : " + str + " : " + e);
                                            Mo14276m = 0;
                                            if (Mo14276m == 1) {
                                            }
                                            i2 = 0;
                                        }
                                        Mo14276m = 0;
                                    }
                                    if (Mo14276m == 1 && (c12960r = c12956n.f9223e) != null) {
                                        c12960r.f9244b.add(abstractC13495dM15146f);
                                    }
                                    i2 = 0;
                                }
                                break;
                            }
                            arrayList.clear();
                        }
                        ArrayList arrayList2 = this.f9088h0;
                        if (!arrayList2.isEmpty()) {
                            C12960r c12960r2 = c12956n.f9223e;
                            if (c12960r2 != null) {
                                ArrayList arrayList3 = c12960r2.f9244b;
                                if (arrayList3 == null || arrayList3.isEmpty()) {
                                    Log.e("WConverter_WRichTextParser", "sortSpanListWithOrderData - no span data");
                                } else if (arrayList2.isEmpty()) {
                                    Log.e("WConverter_WRichTextParser", "sortSpanListWithOrderData - no orderData");
                                } else if (arrayList2.size() != arrayList3.size()) {
                                    Log.e("WConverter_WRichTextParser", "sortSpanListWithOrderData - mismatch data");
                                } else {
                                    Iterator it = arrayList3.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            AbstractC13495d abstractC13495d = (AbstractC13495d) it.next();
                                            int iIndexOf2 = arrayList2.indexOf(abstractC13495d.m14274k());
                                            if (iIndexOf2 < 0) {
                                                Log.e("WConverter_WRichTextParser", "sortSpanListWithOrderData - mismatch data : " + abstractC13495d.m14274k());
                                            } else {
                                                abstractC13495d.f9475e = iIndexOf2;
                                            }
                                        } else {
                                            Collections.sort(arrayList3, new C13525f());
                                        }
                                    }
                                }
                            }
                            arrayList2.clear();
                        }
                    } else {
                        if (iM15119D == 2) {
                            super.mo13816p(xmlPullParser);
                        } else if (iM15119D != 3 && iM15119D != 4) {
                            AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ObjectTextBox");
                        }
                        iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
                        i2 = 0;
                    }
                    break;
                }
                break;
            default:
                super.mo13817q(xmlPullParser);
                break;
        }
    }
}
