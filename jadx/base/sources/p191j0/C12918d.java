package p191j0;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12918d extends AbstractC12916b {

    /* JADX INFO: renamed from: U */
    public boolean f9019U;

    /* JADX INFO: renamed from: V */
    public boolean f9020V;

    /* JADX INFO: renamed from: W */
    public final boolean f9021W;

    /* JADX INFO: renamed from: X */
    public ArrayList f9022X;

    public C12918d(C6906i c6906i) {
        super(4, c6906i);
        this.f9019U = true;
        this.f9020V = true;
        this.f9021W = true;
        this.f9022X = new ArrayList();
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws SyncException, IOException {
        super.mo13804c(c6742k);
        c6742k.m4852i("isUngroupable", this.f9019U);
        c6742k.m4852i("invisibleChildResizing", this.f9020V);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws SyncException, IOException {
        super.mo13805d(c6742k);
        c6742k.m4868z("objectList", CoeditServiceConstants.Element.NAME_OBJECT, this.f9022X);
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12918d)) {
            return false;
        }
        C12918d c12918d = (C12918d) obj;
        boolean z = c12918d.f9021W;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectContainer", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9019U != c12918d.f9019U) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - isUngroupable[");
            sb.append(this.f9019U);
            sb.append(" - ");
            AbstractC11014a.m12339x(sb, "]", "WCon_ObjectContainer", c12918d.f9019U);
            return false;
        }
        if (this.f9020V != c12918d.f9020V) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - invisibleChildresizing[");
            sb2.append(this.f9020V);
            sb2.append(" - ");
            AbstractC11014a.m12339x(sb2, "]", "WCon_ObjectContainer", c12918d.f9020V);
            return false;
        }
        boolean z2 = this.f9021W;
        if (z2 != z) {
            Log.i("WCon_ObjectContainer", " !! equals() - NE - reservedSetRectFlag[" + z2 + " - " + z + "]");
            return false;
        }
        if (AbstractC0299q.m631h(this.f9022X, c12918d.f9022X)) {
            return true;
        }
        Log.i("WCon_ObjectContainer", " !! equals() - NE - mObjectList[" + this.f9022X + " - " + c12918d.f9022X + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectContainer");
            return iMo13812l;
        }
        int i4 = i + iMo13812l;
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i4 + 4);
        int i6 = i4 + 6;
        if (s != 4) {
            AbstractC2322a.m1632v(s, "applyOwnBinary() - Invalid data type [", "]", "WCon_ObjectContainer");
            i5 = -1;
        } else {
            ((ByteBuffer) c12020a.f8772b).getInt(i6);
            int i7 = i4 + 10;
            int i8 = i4 + 11;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i7);
            byte b5 = ((ByteBuffer) c12020a.f8772b).get(i8);
            int i9 = i8 + b;
            ((ByteBuffer) c12020a.f8772b).get(i9);
            c12020a.m13636i(i9 + 1);
            if ((b5 & 1) == 0) {
                this.f9019U = false;
            } else {
                this.f9019U = true;
            }
            if ((b5 & 2) != 0) {
                this.f9020V = false;
            } else {
                this.f9020V = true;
            }
        }
        if (i5 >= 0) {
            return i5 + iMo13812l;
        }
        AbstractC0541b.m758D(i5, "ObjectContainer newApplyBinary() fail to apply own binary. err = ", "WCon_ObjectContainer");
        return i5;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WCon_ObjectContainer");
            return iMo13813m;
        }
        int iMo13814n = i + super.mo13814n();
        int i2 = iMo13814n + 14;
        int i4 = this.f9019U ? 1 : 0;
        if (!this.f9020V) {
            i4 |= 2;
        }
        c12020a.m13649v(iMo13814n, i2 - iMo13814n);
        c12020a.m13647t(iMo13814n + 4, 4);
        c12020a.m13649v(iMo13814n + 6, 0);
        c12020a.m13646s(iMo13814n + 10, 1);
        c12020a.m13646s(iMo13814n + 11, i4);
        c12020a.m13646s(iMo13814n + 12, 1);
        c12020a.m13646s(iMo13814n + 13, 0);
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        return super.mo13814n() + 14;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equalsIgnoreCase("isUngroupable")) {
            this.f9019U = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("invisibleChildResizing")) {
            this.f9020V = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue;
        String name = xmlPullParser.getName();
        if (name.equalsIgnoreCase("objectList")) {
            this.f9022X = new ArrayList();
            return;
        }
        if (!name.equalsIgnoreCase(CoeditServiceConstants.Element.NAME_OBJECT)) {
            super.mo13816p(xmlPullParser);
            return;
        }
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
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
        AbstractC12916b abstractC12916bM15144d = AbstractC14517a.m15144d(attributeValue, this.f8988S);
        if (abstractC12916bM15144d == null) {
            AbstractC14517a.m15138W(xmlPullParser);
        } else {
            abstractC12916bM15144d.m13818r(xmlPullParser);
            this.f9022X.add(abstractC12916bM15144d);
        }
    }
}
