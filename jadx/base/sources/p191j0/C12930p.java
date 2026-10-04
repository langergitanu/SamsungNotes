package p191j0;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6858i;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p178f0.C11980c;
import p186h1.C12020a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12930p extends AbstractC12916b {

    /* JADX INFO: renamed from: X */
    public static final byte[] f9097X = {-1, -1, -1, -1};

    /* JADX INFO: renamed from: Y */
    public static final byte[] f9098Y = {-1, -1, -1, -1, (byte) 4, (byte) 0, (byte) 0, (byte) 0, -96, 15, 0, 0};

    /* JADX INFO: renamed from: Z */
    public static final int f9099Z = 12;

    /* JADX INFO: renamed from: U */
    public byte[] f9100U;

    /* JADX INFO: renamed from: V */
    public C6858i f9101V;

    /* JADX INFO: renamed from: W */
    public boolean f9102W;

    public C12930p(C6906i c6906i) {
        super(1, c6906i);
        this.f9102W = false;
    }

    /* JADX INFO: renamed from: v */
    public static int m13829v(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    /* JADX INFO: renamed from: x */
    public static boolean m13830x(byte[] bArr) {
        byte b = bArr[0];
        byte[] bArr2 = f9097X;
        return b == bArr2[0] && bArr[1] == bArr2[1] && bArr[2] == bArr2[2] && bArr[3] == bArr2[3];
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws IOException {
        c6742k.m4851h("type", AbstractC12916b.m13803f(this.f8990a));
        c6742k.m4851h("id", this.f8978I.f9296a);
        c6742k.m4851h("hash", mo13809i());
        c6742k.m4850f("modifiedTime", this.f8980K);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        if (this.f8987R) {
            if (this.f9100U == null) {
                throw new IllegalStateException("composeElement - mStrokeData is null.");
            }
            c6742k.m4865w(CoeditServiceConstants.Attribute.KEY_STROKE_BINARY, Base64Utils.encodeBase64(m13832w()));
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: g */
    public final int mo13807g() {
        return this.f9102W ? 15 : 1;
    }

    @Override // p191j0.AbstractC12916b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12930p)) {
            return false;
        }
        C12930p c12930p = (C12930p) obj;
        if (this.f8990a != c12930p.f8990a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f8990a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12930p.f8990a, "]", "WCon_ObjectStroke", sb);
            return false;
        }
        if (!AbstractC0299q.m635j(this.f8978I, c12930p.f8978I)) {
            Log.i("WCon_ObjectStroke", " !! equals() - NE - uuid[" + this.f8978I + " - " + c12930p.f8978I + "]");
            return false;
        }
        if (this.f8980K == c12930p.f8980K) {
            if (Arrays.equals(this.f9100U, c12930p.f9100U)) {
                return true;
            }
            Log.i("WCon_ObjectStroke", " !! equals() - NE - mStrokeData");
            return false;
        }
        Log.i("WCon_ObjectStroke", " !! equals() - NE - modifiedTime[" + this.f8980K + " - " + c12930p.f8980K + "]");
        return false;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: l */
    public final int mo13812l(C12020a c12020a, int i, int i2) throws SyncException, IOException {
        int iMo13812l = super.mo13812l(c12020a, i, i2);
        if (iMo13812l < 0) {
            AbstractC0541b.m758D(iMo13812l, "ObjectBase newApplyBinary() fail. err = ", "WCon_ObjectStroke");
            return iMo13812l;
        }
        int i4 = ((ByteBuffer) c12020a.f8772b).getInt(i + iMo13812l) + iMo13812l;
        if (i4 > 2097152) {
            throw new SyncException(339, AbstractC0541b.m767i(i4, "invalid binary size [", "]"));
        }
        this.f9100U = Arrays.copyOfRange(((ByteBuffer) c12020a.f8772b).array(), i, i + i4);
        ((C11980c) this.f8988S.f4484c).f8581c.put(this.f8978I.f9296a, this);
        return i4;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) throws SyncException {
        byte[] bArr = this.f9100U;
        if (bArr == null) {
            throw new SyncException(327, "ObjectStroke.getBinary() - stroke data is empty");
        }
        c12020a.m13651x(i, bArr);
        return 4000;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() throws SyncException {
        byte[] bArr = this.f9100U;
        if (bArr != null) {
            return bArr.length;
        }
        throw new SyncException(327, "ObjectStroke.getBinarySize() - stroke data is empty");
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: o */
    public final void mo13815o(XmlPullParser xmlPullParser, int i) {
        if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("strokeDataHash")) {
            this.f9100U = Base64Utils.decodeBase64ToByteArray(xmlPullParser.getAttributeValue(i));
        } else {
            super.mo13815o(xmlPullParser, i);
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getName().equalsIgnoreCase(CoeditServiceConstants.Attribute.KEY_STROKE_BINARY)) {
            if (xmlPullParser.getAttributeCount() != 0) {
                this.f9100U = Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15128M(xmlPullParser));
            } else {
                m13831u(Base64Utils.decodeBase64ToByteArray(AbstractC14517a.m15134S(xmlPullParser)));
            }
        }
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
                ((C11980c) this.f8988S.f4484c).f8581c.put(this.f8978I.f9296a, this);
                return;
            }
            if (iM15119D == 2) {
                mo13816p(xmlPullParser);
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ObjectStroke");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m13831u(byte[] bArr) {
        int iM13829v;
        if (!m13830x(bArr)) {
            this.f9005p = 0;
            this.f9100U = bArr;
            this.f9102W = true;
            return;
        }
        this.f9005p = !m13830x(bArr) ? 0 : m13829v(8, bArr);
        if (m13830x(bArr)) {
            iM13829v = 8 + (!m13830x(bArr) ? 0 : m13829v(4, bArr));
        } else {
            iM13829v = 0;
        }
        int length = bArr.length - iM13829v;
        byte[] bArr2 = new byte[length];
        this.f9100U = bArr2;
        System.arraycopy(bArr, iM13829v, bArr2, 0, length);
    }

    /* JADX INFO: renamed from: w */
    public final byte[] m13832w() {
        if (this.f9102W) {
            return this.f9100U;
        }
        byte[] bArr = this.f9100U;
        if (bArr == null) {
            Debugger.m8609e("WCon_ObjectStroke", "strokeData is null");
            return null;
        }
        int length = bArr.length;
        int i = f9099Z;
        byte[] bArr2 = new byte[i + length];
        System.arraycopy(f9098Y, 0, bArr2, 0, i);
        System.arraycopy(this.f9100U, 0, bArr2, i, length);
        this.f9100U = null;
        return bArr2;
    }

    /* JADX INFO: renamed from: y */
    public final void m13833y(C12020a c12020a, int i) throws IOException {
        String str = "stroke" + hashCode() + ".stroke";
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8989T.f8574b);
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0622a.m1170p(File.separator, str, sb), InternalZipConstants.WRITE_MODE);
        try {
            try {
                AbstractC0299q.m632h0(randomAccessFile, i);
                randomAccessFile.write(((ByteBuffer) c12020a.f8772b).array(), 0, i);
                randomAccessFile.seek(4L);
                try {
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(filePointer - 4);
                    int iM606P = AbstractC0299q.m606P(randomAccessFile);
                    AbstractC0299q.m606P(randomAccessFile);
                    super.m13819s(randomAccessFile);
                    this.f9100U = new byte[(int) (((((long) iM606P) + filePointer) - 32) - filePointer)];
                    randomAccessFile.seek(filePointer);
                    randomAccessFile.read(this.f9100U);
                } catch (IOException e) {
                    Debugger.m8611e("WCon_ObjectStroke", e);
                }
                this.f9102W = true;
                ((C11980c) this.f8988S.f4484c).f8581c.put(this.f8978I.f9296a, this);
                randomAccessFile.close();
            } catch (IOException unused) {
                throw new IOException("newApplyBinaryForOldStroke - fail to write temp stroke data.");
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
