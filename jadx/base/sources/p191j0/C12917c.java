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

/* JADX INFO: renamed from: j0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12917c extends AbstractC12916b {

    /* JADX INFO: renamed from: V */
    public static final byte[] f9016V = {-1, -1, -1, -1, (byte) 4, (byte) 0, (byte) 0, (byte) 0, -96, 15, 0, 0};

    /* JADX INFO: renamed from: W */
    public static final int f9017W = 12;

    /* JADX INFO: renamed from: U */
    public byte[] f9018U;

    public C12917c(C6906i c6906i) {
        super(23, c6906i);
    }

    /* JADX INFO: renamed from: u */
    public static int m13821u(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        super.mo13805d(c6742k);
        byte[] bArr = this.f9018U;
        if (bArr == null) {
            throw new IllegalStateException("composeElement - mCodeBlockData is null.");
        }
        int length = bArr.length;
        int i = f9017W;
        byte[] bArr2 = new byte[i + length];
        System.arraycopy(f9016V, 0, bArr2, 0, i);
        System.arraycopy(this.f9018U, 0, bArr2, i, length);
        this.f9018U = null;
        c6742k.m4865w("codeBlockBinary", Base64Utils.encodeBase64(bArr2));
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: g */
    public final int mo13807g() {
        return 23;
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12917c)) {
            return false;
        }
        C12917c c12917c = (C12917c) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_ObjectCodeBlock", " !! equals() - NE - super check");
            return false;
        }
        if (this.f8990a != c12917c.f8990a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f8990a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12917c.f8990a, "]", "WCon_ObjectCodeBlock", sb);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f8978I, c12917c.f8978I)) {
            Log.i("WCon_ObjectCodeBlock", " !! equals() - NE - uuid[" + this.f8978I + " - " + c12917c.f8978I + "]");
            return false;
        }
        if (this.f8980K == c12917c.f8980K) {
            if (Arrays.equals(this.f9018U, c12917c.f9018U)) {
                return true;
            }
            Log.i("WCon_ObjectCodeBlock", " !! equals() - NE - mCodeBlockData");
            return false;
        }
        Log.i("WCon_ObjectCodeBlock", " !! equals() - NE - modifiedTime[" + this.f8980K + " - " + c12917c.f8980K + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectCodeBlock");
            return iMo13812l;
        }
        int i4 = ((ByteBuffer) c12020a.f8772b).getInt(i + iMo13812l) + iMo13812l;
        this.f9018U = Arrays.copyOfRange(((ByteBuffer) c12020a.f8772b).array(), i, i + i4);
        ((C11980c) this.f8988S.f4484c).f8585g.put(this.f8978I.f9296a, this);
        return i4;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) throws SyncException {
        byte[] bArr = this.f9018U;
        if (bArr == null) {
            throw new SyncException(327, "getBinary() - codeBlock data is empty");
        }
        c12020a.m13651x(i, bArr);
        return 5400;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() throws SyncException {
        byte[] bArr = this.f9018U;
        if (bArr != null) {
            return bArr.length;
        }
        throw new SyncException(327, "getBinarySize() - data data is empty");
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getName().equalsIgnoreCase("codeBlockBinary")) {
            super.mo13816p(xmlPullParser);
            return;
        }
        if (xmlPullParser.getAttributeCount() != 0) {
            this.f9018U = Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15128M(xmlPullParser));
            return;
        }
        byte[] bArrDecodeBase64ToByteArray = Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15134S(xmlPullParser));
        this.f9005p = m13821u(8, bArrDecodeBase64ToByteArray);
        int iM13821u = m13821u(4, bArrDecodeBase64ToByteArray) + 8;
        int length = bArrDecodeBase64ToByteArray.length - iM13821u;
        byte[] bArr = new byte[length];
        this.f9018U = bArr;
        System.arraycopy(bArrDecodeBase64ToByteArray, iM13821u, bArr, 0, length);
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
                ((C11980c) this.f8988S.f4484c).f8585g.put(this.f8978I.f9296a, this);
                return;
            }
            if (iM15119D == 2) {
                mo13816p(xmlPullParser);
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ObjectCodeBlock");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }
}
