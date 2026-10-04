package p191j0;

import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6858i;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p079T.AbstractC0299q;
import p178f0.C11980c;
import p186h1.C12020a;
import p194k0.C12966x;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12931q extends AbstractC12916b {

    /* JADX INFO: renamed from: Y */
    public static final byte[] f9103Y = {-1, -1, -1, -1};

    /* JADX INFO: renamed from: U */
    public String f9104U;

    /* JADX INFO: renamed from: V */
    public final ArrayList f9105V;

    /* JADX INFO: renamed from: W */
    public byte[] f9106W;

    /* JADX INFO: renamed from: X */
    public C6858i f9107X;

    public C12931q(C6906i c6906i) {
        super(100, c6906i);
        this.f9104U = null;
        this.f9106W = null;
        this.f8980K = 0L;
        this.f9105V = new ArrayList();
    }

    /* JADX INFO: renamed from: v */
    public static int m13834v(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    /* JADX INFO: renamed from: w */
    public static boolean m13835w(byte[] bArr) {
        byte b = bArr[0];
        byte[] bArr2 = f9103Y;
        return b == bArr2[0] && bArr[1] == bArr2[1] && bArr[2] == bArr2[2] && bArr[3] == bArr2[3];
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: c */
    public final void mo13804c(C6742k c6742k) throws IOException {
        if (TextUtils.isEmpty(this.f9104U)) {
            try {
                m13837x();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        c6742k.m4851h("type", AbstractC12916b.m13803f(this.f8990a));
        c6742k.m4851h("id", mo13811k());
        c6742k.m4851h("hash", "STRGRP");
        c6742k.m4850f("modifiedTime", this.f8980K);
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: d */
    public final void mo13805d(C6742k c6742k) throws IOException {
        if (this.f8987R) {
            if (this.f9106W == null) {
                try {
                    m13837x();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            c6742k.m4865w(CoeditServiceConstants.Attribute.KEY_STROKE_BINARY, Base64Utils.encodeBase64(this.f9106W));
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: h */
    public final long mo13808h() {
        if (this.f8980K == 0) {
            try {
                m13837x();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return this.f8980K;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: i */
    public final String mo13809i() {
        return "STRGRP";
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: j */
    public final C12966x mo13810j() {
        return null;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: k */
    public final String mo13811k() {
        C12966x c12966x = this.f8978I;
        if (c12966x != null && !TextUtils.isEmpty(c12966x.f9296a)) {
            return this.f8978I.f9296a;
        }
        if (TextUtils.isEmpty(this.f9104U)) {
            try {
                m13837x();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return this.f9104U;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: m */
    public final int mo13813m(C12020a c12020a, int i) {
        int iMo13813m = super.mo13813m(c12020a, i);
        if (iMo13813m < 0) {
            AbstractC0541b.m758D(iMo13813m, "ObjectBase newGetBinary() fail. err = ", "WDocObjectStrokeGroup");
            return iMo13813m;
        }
        Log.d("WDocObjectStrokeGroup", "WDocObjectStrokeGroup skip get newGetBinary().");
        return iMo13813m;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: n */
    public final int mo13814n() {
        Log.d("WDocObjectStrokeGroup", "WDocObjectStrokeGroup skip get newGetBinarySize().");
        return 0;
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: p */
    public final void mo13816p(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getName().equalsIgnoreCase(CoeditServiceConstants.Attribute.KEY_STROKE_BINARY)) {
            this.f9106W = Base64Utils.decodeBase64(AbstractC14517a.m15128M(xmlPullParser)).getBytes();
        }
    }

    @Override // p191j0.AbstractC12916b
    /* JADX INFO: renamed from: q */
    public final void mo13817q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, CoeditServiceConstants.Element.NAME_OBJECT);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            super.mo13815o(xmlPullParser, i);
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals(CoeditServiceConstants.Element.NAME_OBJECT)) {
                ((C11980c) this.f8988S.f4484c).f8582d.put(mo13811k(), this);
                return;
            }
            if (iM15119D == 2) {
                mo13816p(xmlPullParser);
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WDocObjectStrokeGroup");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m13836u(byte[] bArr) {
        int iM13834v;
        this.f9005p = !m13835w(bArr) ? 0 : m13834v(8, bArr);
        if (m13835w(bArr)) {
            iM13834v = 8 + (!m13835w(bArr) ? 0 : m13834v(4, bArr));
        } else {
            iM13834v = 0;
        }
        int length = bArr.length - iM13834v;
        this.f9106W = new byte[length];
        Debugger.m8615i("WDocObjectStrokeGroup", "applySyncByteArray() : strokeGroupBytes # = " + bArr.length + ", realStrokeDataSize = " + length);
        System.arraycopy(bArr, iM13834v, this.f9106W, 0, length);
    }

    /* JADX INFO: renamed from: x */
    public final void m13837x() throws SyncException {
        ArrayList<C12930p> arrayList = this.f9105V;
        if (arrayList.isEmpty()) {
            throw new SyncException(328, "update ObjecStrokeGroup - mObjectList is empty");
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int iMo13814n = 2;
        for (int i = 0; i < arrayList.size(); i++) {
            C12930p c12930p = (C12930p) arrayList.get(i);
            int length = (c12930p.f8978I.f9296a.length() * 2) + iMo13814n + 2 + 12;
            try {
                iMo13814n = c12930p.mo13814n() + C12930p.f9099Z + length;
            } catch (SyncException e) {
                Debugger.m8609e("WDocObjectStrokeGroup", "getSyncStrokeGroupDataSize " + e);
                iMo13814n = length;
            }
        }
        C12020a c12020a = new C12020a(iMo13814n);
        c12020a.m13631J(iMo13814n);
        c12020a.m13647t(0, arrayList.size());
        int length2 = 2;
        for (C12930p c12930p2 : arrayList) {
            sb.append(c12930p2.f8978I.f9296a);
            this.f8980K = Math.max(this.f8980K, c12930p2.f8980K);
            sb2.append(c12930p2.mo13809i());
            byte[] bArrM13832w = c12930p2.m13832w();
            c12020a.m13647t(length2, c12930p2.f8978I.f9296a.length());
            int i2 = length2 + 2;
            c12020a.m13626E(i2, c12930p2.f8978I.f9296a);
            int iM3193c = AbstractC4539a.m3193c(2, i2, c12930p2.f8978I.f9296a);
            ((ByteBuffer) c12020a.f8772b).putLong(iM3193c, c12930p2.f8980K);
            c12020a.m13649v(iM3193c + 8, bArrM13832w.length);
            int i4 = iM3193c + 12;
            c12020a.m13651x(i4, bArrM13832w);
            length2 = i4 + bArrM13832w.length;
        }
        arrayList.clear();
        this.f9104U = AbstractC0299q.m597G(sb.toString().getBytes());
        this.f8986Q = C14433b.m15031l(sb2.toString());
        this.f9106W = ((ByteBuffer) c12020a.f8772b).array();
        Debugger.m8615i("WDocObjectStrokeGroup", "updateData() : mStrokeData # = " + this.f9106W.length);
    }
}
