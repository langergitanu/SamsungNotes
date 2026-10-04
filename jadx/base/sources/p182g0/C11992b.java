package p182g0;

import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p178f0.C11980c;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12018c;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p191j0.AbstractC12916b;
import p191j0.C12918d;
import p191j0.C12930p;
import p191j0.C12933s;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: g0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11992b implements InterfaceC12019d, InterfaceC12018c, InterfaceC12017b, VariableComparator.Collector {

    /* JADX INFO: renamed from: c */
    public int f8624c;

    /* JADX INFO: renamed from: f */
    public String f8627f;

    /* JADX INFO: renamed from: g */
    public String f8628g;

    /* JADX INFO: renamed from: h */
    public long f8629h;

    /* JADX INFO: renamed from: i */
    public long f8630i;

    /* JADX INFO: renamed from: m */
    public final C6906i f8634m;

    /* JADX INFO: renamed from: n */
    public byte[] f8635n;

    /* JADX INFO: renamed from: j */
    public List f8631j = new ArrayList();

    /* JADX INFO: renamed from: a */
    public boolean f8622a = true;

    /* JADX INFO: renamed from: b */
    public boolean f8623b = true;

    /* JADX INFO: renamed from: k */
    public boolean f8632k = false;

    /* JADX INFO: renamed from: d */
    public int f8625d = 255;

    /* JADX INFO: renamed from: e */
    public int f8626e = -1;

    /* JADX INFO: renamed from: l */
    public int f8633l = -1;

    public C11992b(C6906i c6906i) {
        this.f8634m = c6906i;
    }

    /* JADX INFO: renamed from: h */
    public static void m13586h(RandomAccessFile randomAccessFile, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            int iM606P = AbstractC0299q.m606P(randomAccessFile);
            randomAccessFile.readByte();
            int iM609S = AbstractC0299q.m609S(randomAccessFile);
            randomAccessFile.seek(randomAccessFile.getFilePointer() + ((long) iM606P));
            m13586h(randomAccessFile, iM609S);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m13587i(RandomAccessFile randomAccessFile, C12020a c12020a, AbstractC12916b abstractC12916b, int i, C14433b c14433b) throws IOException {
        AbstractC0299q.m636j0(randomAccessFile, i);
        int iMo13814n = abstractC12916b.mo13814n();
        int i2 = iMo13814n + 32;
        c12020a.m13631J(i2);
        abstractC12916b.mo13813m(c12020a, 0);
        Log.d("WCon_Layer", "writeDefaultObject - object id = [" + abstractC12916b.mo13810j().f9296a + "], mt = [" + abstractC12916b.mo13808h() + "]");
        StringBuilder sb = new StringBuilder();
        sb.append(abstractC12916b.mo13811k());
        sb.append(abstractC12916b.mo13808h());
        byte[] bArrM15031l = C14433b.m15031l(sb.toString());
        if (bArrM15031l == null) {
            throw new IOException("newWriteDefaultObject() - objectHash is null");
        }
        c12020a.m13651x(iMo13814n, bArrM15031l);
        ((ByteArrayOutputStream) c14433b.f10228b).write(bArrM15031l);
        Log.d("WCon_Layer", "writeDefaultObject - object Hash = [" + C14433b.m15034q(bArrM15031l) + "]");
        AbstractC0299q.m632h0(randomAccessFile, i2);
        randomAccessFile.write(((ByteBuffer) c12020a.f8772b).array(), 0, i2);
    }

    /* JADX INFO: renamed from: j */
    public static void m13588j(RandomAccessFile randomAccessFile, C12020a c12020a, C12918d c12918d, C14433b c14433b) throws IOException {
        int size = c12918d.f9022X.size();
        m13587i(randomAccessFile, c12020a, c12918d, size, c14433b);
        for (int i = 0; i < size; i++) {
            AbstractC12916b abstractC12916b = (AbstractC12916b) c12918d.f9022X.get(i);
            int i2 = abstractC12916b.f8990a;
            if (i2 == 4) {
                randomAccessFile.write((byte) (i2 & 255));
                m13588j(randomAccessFile, c12020a, (C12918d) abstractC12916b, c14433b);
            } else {
                int iMo13807g = abstractC12916b.mo13807g();
                Log.d("WCon_Layer", AbstractC0622a.m1164j(i, iMo13807g, "writeObjectContainer    >>>    object - index = [", "], type = [", "]"));
                randomAccessFile.write((byte) (iMo13807g & 255));
                m13587i(randomAccessFile, c12020a, abstractC12916b, 0, c14433b);
            }
        }
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws SyncException, IOException {
        if (!AbstractC4539a.m3210t() || !NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b)) {
            m13590c(c6742k);
            m13591d(c6742k);
            return;
        }
        C6742k c6742k2 = new C6742k(Xml.newSerializer());
        c6742k2.m4846F("layer");
        m13590c(c6742k2);
        m13591d(c6742k2);
        c6742k2.m4856m("layer");
        c6742k2.m4857n();
        c6742k.m4851h("id", this.f8628g);
        c6742k.m4851h("hash", m13592e());
        c6742k.m4850f("modifiedTime", this.f8630i);
        try {
            c6742k.m4865w("encrypted", C0145c.m319d(((StringWriter) c6742k2.f4111c).toString()));
            if (this.f8631j.isEmpty()) {
                return;
            }
            c6742k.m4868z("objectList", CoeditServiceConstants.Element.NAME_OBJECT, this.f8631j);
        } catch (Exception e) {
            Debugger.m8609e("WCon_Layer", "composeElement : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    @Override // p185h0.InterfaceC12018c
    /* JADX INFO: renamed from: b */
    public final boolean mo13589b(InterfaceC12018c interfaceC12018c, C6903f c6903f) {
        if (this == interfaceC12018c) {
            return true;
        }
        if (!(interfaceC12018c instanceof C11992b)) {
            return false;
        }
        C11992b c11992b = (C11992b) interfaceC12018c;
        this.f8622a = c11992b.f8622a;
        this.f8623b = c11992b.f8623b;
        this.f8632k = c11992b.f8632k;
        this.f8624c = c11992b.f8624c;
        this.f8625d = c11992b.f8625d;
        this.f8626e = c11992b.f8626e;
        this.f8627f = c11992b.f8627f;
        this.f8628g = c11992b.f8628g;
        this.f8629h = c11992b.f8629h;
        this.f8630i = c11992b.f8630i;
        this.f8633l = c11992b.f8633l;
        this.f8631j = c6903f.m5128l(c11992b.f8628g);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final void m13590c(C6742k c6742k) throws IOException {
        c6742k.m4851h("id", this.f8628g);
        c6742k.m4851h("hash", m13592e());
        c6742k.m4852i("flagEventForwardable", this.f8622a);
        c6742k.m4852i("visible", this.f8623b);
        c6742k.m4852i("lockState", this.f8632k);
        c6742k.m4848d(this.f8624c, "layerNumber");
        int i = this.f8625d;
        if (i != 255) {
            c6742k.m4848d(i, "transparency");
        }
        int i2 = this.f8626e;
        if (i2 != -1) {
            c6742k.m4848d(i2, "bgColor");
        }
        if (!TextUtils.isEmpty(this.f8627f)) {
            c6742k.m4853j("name", this.f8627f);
        }
        c6742k.m4850f(GroupContract.Group.CREATED_TIME, this.f8629h);
        c6742k.m4850f("modifiedTime", this.f8630i);
        c6742k.m4848d(this.f8633l, "thumbnail");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Collector
    public final VariableComparator.List collectVariables() {
        return new VariableComparator.List().addVar(new VariableComparator.BoolVar("mVisible", this.f8623b)).addVar(new VariableComparator.BoolVar("mLockState", this.f8632k)).addVar(new VariableComparator.IntVar("mLayerId", this.f8624c)).addVar(new VariableComparator.IntVar("mTransparency", this.f8625d)).addVar(new VariableComparator.IntVar("mBgColor", this.f8626e)).addVar(new VariableComparator.StringVar("mLayerName", this.f8627f)).addVar(new VariableComparator.StringVar("mUuid", this.f8628g)).addVar(new VariableComparator.LongVar("mCreatedTime", this.f8629h)).addVar(new VariableComparator.LongVar("mModifiedTime", this.f8630i)).addVar(new VariableComparator.IntVar("mThumbnailMediaId", this.f8633l));
    }

    /* JADX INFO: renamed from: d */
    public final void m13591d(C6742k c6742k) throws SyncException {
        if (AbstractC4539a.m3210t() && NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b)) {
            return;
        }
        try {
            if (this.f8631j.isEmpty()) {
                return;
            }
            c6742k.m4868z("objectList", CoeditServiceConstants.Element.NAME_OBJECT, this.f8631j);
            Debugger.printMemory("WCon_Layer", "[CurrentMemoryState] After composing a layer");
        } catch (Exception e) {
            Debugger.m8609e("WCon_Layer", "composeElement : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    /* JADX INFO: renamed from: e */
    public final String m13592e() {
        byte[] bArr = this.f8635n;
        if (bArr != null && bArr.length > 0) {
            return C14433b.m15034q(bArr);
        }
        Debugger.m8607d("WCon_Layer", "hash is null");
        return "";
    }

    /* JADX INFO: renamed from: f */
    public final void m13593f(RandomAccessFile randomAccessFile, int i, int i2, C12918d c12918d) throws Exception {
        C6906i c6906i = this.f8634m;
        if (i == 4) {
            C12918d c12918d2 = new C12918d(c6906i);
            int iM606P = AbstractC0299q.m606P(randomAccessFile);
            if (iM606P > 2097152) {
                throw new SyncException(339, AbstractC0541b.m767i(iM606P, "invalid container object size [", "]"));
            }
            byte[] bArr = new byte[iM606P];
            randomAccessFile.read(bArr);
            c12918d2.mo13812l(new C12020a(bArr), 0, iM606P);
            if (c12918d != null) {
                c12918d.f9022X.add(c12918d2);
            } else {
                this.f8631j.add(c12918d2);
            }
            m13594g(randomAccessFile, i2, c12918d2);
            return;
        }
        AbstractC12916b abstractC12916bM15143c = AbstractC14517a.m15143c(i, c6906i);
        if (abstractC12916bM15143c != null) {
            if (i == 1 || i == 15) {
                ((C11980c) c6906i.f4484c).f8580b++;
            } else if (i == 21) {
                ((C11980c) c6906i.f4484c).getClass();
            }
            int iM606P2 = AbstractC0299q.m606P(randomAccessFile);
            if (i != 19 && iM606P2 > 2097152) {
                throw new SyncException(339, AbstractC0541b.m767i(iM606P2, "invalid object size [", "]"));
            }
            byte[] bArr2 = new byte[iM606P2];
            randomAccessFile.read(bArr2);
            C12020a c12020a = new C12020a(bArr2);
            if (i == 15) {
                ((C12930p) abstractC12916bM15143c).m13833y(c12020a, iM606P2);
            } else {
                abstractC12916bM15143c.mo13812l(c12020a, 0, iM606P2);
            }
            if (c12918d == null) {
                this.f8631j.add(abstractC12916bM15143c);
            } else {
                abstractC12916bM15143c.f8987R = true;
                c12918d.f9022X.add(abstractC12916bM15143c);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m13594g(RandomAccessFile randomAccessFile, int i, C12918d c12918d) throws Exception {
        int i2 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            byte b = randomAccessFile.readByte();
            int iM609S = AbstractC0299q.m609S(randomAccessFile);
            switch (b) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                case 8:
                case 10:
                case 11:
                case 13:
                case 14:
                case 15:
                case 17:
                case 19:
                case 20:
                case 21:
                case 23:
                    m13593f(randomAccessFile, b, iM609S, c12918d);
                    i2++;
                    break;
                case 5:
                case 6:
                case 9:
                case 12:
                case 16:
                case 18:
                case 22:
                default:
                    try {
                        m13586h(randomAccessFile, iM609S);
                        i4++;
                    } catch (Exception e) {
                        Log.e("WCon_Layer", AbstractC0622a.m1164j(i5, b, "loadObjectList - Fail to load object [", "], type = [", "]"));
                        throw e;
                    }
                    break;
            }
        }
        Log.d("WCon_Layer", AbstractC0622a.m1164j(i2, i4, "loadObjectList - object loaded [", "], skip [", "]"));
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11992b)) {
            return false;
        }
        C11992b c11992b = (C11992b) obj;
        if (!VariableComparator.compare(this, c11992b, "WCon_Layer")) {
            return false;
        }
        for (int i = 0; i < this.f8631j.size(); i++) {
            AbstractC11014a.m12328m(i, " !! equals() - object index = [", "] check", "WCon_Layer");
            if (!AbstractC0299q.m635j(this.f8631j.get(i), c11992b.f8631j.get(i))) {
                AbstractC11014a.m12328m(i, " !! equals() - NE - mObjectList - object index = [", "]", "WCon_Layer");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: k */
    public final int m13595k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue;
        Object obj;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("id")) {
                this.f8628g = xmlPullParser.getAttributeValue(i);
            } else if (attributeName.equalsIgnoreCase("hash")) {
                this.f8635n = C14433b.m15032m(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("flagEventForwardable")) {
                this.f8622a = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("visible")) {
                this.f8623b = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("lockState")) {
                this.f8632k = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("layerNumber")) {
                this.f8624c = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("transparency")) {
                this.f8625d = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("bgColor")) {
                this.f8626e = (int) Long.parseLong(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("name")) {
                this.f8627f = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase(GroupContract.Group.CREATED_TIME)) {
                this.f8629h = Long.parseLong(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("modifiedTime")) {
                this.f8630i = Long.parseLong(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("thumbnail")) {
                this.f8633l = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            }
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals("layer")) {
                return iM15119D;
            }
            if (iM15119D == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("objectList")) {
                    this.f8631j = new ArrayList();
                } else if (name.equalsIgnoreCase(CoeditServiceConstants.Element.NAME_OBJECT)) {
                    int attributeCount2 = xmlPullParser.getAttributeCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= attributeCount2) {
                            attributeValue = null;
                            break;
                        }
                        if (xmlPullParser.getAttributeName(i2).equalsIgnoreCase("type")) {
                            attributeValue = xmlPullParser.getAttributeValue(i2);
                            break;
                        }
                        i2++;
                    }
                    C6906i c6906i = this.f8634m;
                    AbstractC12916b abstractC12916bM15144d = AbstractC14517a.m15144d(attributeValue, c6906i);
                    if (abstractC12916bM15144d != null) {
                        abstractC12916bM15144d.m13818r(xmlPullParser);
                        obj = abstractC12916bM15144d;
                    } else if (attributeValue != null) {
                        C12933s c12933s = new C12933s(c6906i);
                        c12933s.f9116Z = true;
                        c12933s.m13818r(xmlPullParser);
                        c12933s.f9116Z = false;
                        obj = c12933s;
                    } else {
                        AbstractC14517a.m15138W(xmlPullParser);
                    }
                    this.f8631j.add(obj);
                }
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_Layer");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }
}
