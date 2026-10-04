package p191j0;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p178f0.C11980c;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12932r extends C12927m {

    /* JADX INFO: renamed from: k0 */
    public static final byte[] f9108k0 = {-1, -1, -1, -1, (byte) 4, (byte) 0, (byte) 0, (byte) 0, -96, 15, 0, 0};

    /* JADX INFO: renamed from: l0 */
    public static final int f9109l0 = 12;

    /* JADX INFO: renamed from: j0 */
    public byte[] f9110j0;

    public C12932r(C6906i c6906i) {
        super(22, c6906i);
    }

    /* JADX INFO: renamed from: v */
    public static int m13838v(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        byte[] bArr = this.f9110j0;
        if (bArr == null) {
            throw new IllegalStateException("composeElement - mTableData is null.");
        }
        int length = bArr.length;
        int i = f9109l0;
        byte[] bArr2 = new byte[i + length];
        System.arraycopy(f9108k0, 0, bArr2, 0, i);
        System.arraycopy(this.f9110j0, 0, bArr2, i, length);
        this.f9110j0 = null;
        c6742k.m4865w("tableBinary", Base64Utils.encodeBase64(bArr2));
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: g */
    public final int mo13807g() {
        return 22;
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12932r)) {
            return false;
        }
        C12932r c12932r = (C12932r) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectTable", " !! equals() - NE - super check");
            return false;
        }
        if (this.f8990a != c12932r.f8990a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f8990a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12932r.f8990a, "]", "WCon_ObjectTable", sb);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f8978I, c12932r.f8978I)) {
            Log.i("WCon_ObjectTable", " !! equals() - NE - uuid[" + this.f8978I + " - " + c12932r.f8978I + "]");
            return false;
        }
        if (this.f8980K == c12932r.f8980K) {
            if (Arrays.equals(this.f9110j0, c12932r.f9110j0)) {
                return true;
            }
            Log.i("WCon_ObjectTable", " !! equals() - NE - mTableData");
            return false;
        }
        Log.i("WCon_ObjectTable", " !! equals() - NE - modifiedTime[" + this.f8980K + " - " + c12932r.f8980K + "]");
        return false;
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectTable");
            return iMo13812l;
        }
        int i4 = ((ByteBuffer) c12020a.f8772b).getInt(i + iMo13812l) + iMo13812l;
        this.f9110j0 = Arrays.copyOfRange(((ByteBuffer) c12020a.f8772b).array(), i, i + i4);
        ((C11980c) this.f8988S.f4484c).f8584f.put(this.f8978I.f9296a, this);
        return i4;
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) throws SyncException {
        byte[] bArr = this.f9110j0;
        if (bArr == null) {
            throw new SyncException(327, "getBinary() - table data is empty");
        }
        c12020a.m13651x(i, bArr);
        return 5400;
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() throws SyncException {
        byte[] bArr = this.f9110j0;
        if (bArr != null) {
            return bArr.length;
        }
        throw new SyncException(327, "getBinarySize() - data data is empty");
    }

    @Override // p191j0.C12927m, p191j0.AbstractC12929o, p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getName().equalsIgnoreCase("tableBinary")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        if (xmlPullParser.getAttributeCount() != 0) {
            this.f9110j0 = Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15128M(xmlPullParser));
            return;
        }
        byte[] bArrDecodeBase64ToByteArray = Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15134S(xmlPullParser));
        this.f9005p = m13838v(8, bArrDecodeBase64ToByteArray);
        int iM13838v = m13838v(4, bArrDecodeBase64ToByteArray) + 8;
        int length = bArrDecodeBase64ToByteArray.length - iM13838v;
        byte[] bArr = new byte[length];
        this.f9110j0 = bArr;
        System.arraycopy(bArrDecodeBase64ToByteArray, iM13838v, bArr, 0, length);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: q */
    public final void mo13817q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, CoeditServiceConstants.Element.NAME_OBJECT);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            mo13815o(xmlPullParser, i);
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals(CoeditServiceConstants.Element.NAME_OBJECT)) {
                ((C11980c) this.f8988S.f4484c).f8584f.put(this.f8978I.f9296a, this);
                return;
            }
            if (iM15119D == 2) {
                mo13816p(xmlPullParser);
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ObjectTable");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }
}
