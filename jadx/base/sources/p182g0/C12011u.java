package p182g0;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.converters.WDocExceedObjectException;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.MaxObjectLimitHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p178f0.C11979b;
import p178f0.C11980c;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12018c;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p191j0.AbstractC12916b;
import p191j0.C12918d;
import p194k0.C12964v;
import p194k0.C12966x;
import p212o1.C13573a;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: g0.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12011u implements InterfaceC12019d, InterfaceC12018c, InterfaceC12017b, VariableComparator.Collector {

    /* JADX INFO: renamed from: A */
    public int f8733A;

    /* JADX INFO: renamed from: B */
    public int f8734B;

    /* JADX INFO: renamed from: C */
    public int f8735C;

    /* JADX INFO: renamed from: D */
    public LinkedHashMap f8736D;

    /* JADX INFO: renamed from: E */
    public int f8737E;

    /* JADX INFO: renamed from: F */
    public long f8738F;

    /* JADX INFO: renamed from: G */
    public ArrayList f8739G;

    /* JADX INFO: renamed from: a */
    public String f8740a;

    /* JADX INFO: renamed from: b */
    public String f8741b;

    /* JADX INFO: renamed from: c */
    public int f8742c;

    /* JADX INFO: renamed from: d */
    public int f8743d;

    /* JADX INFO: renamed from: e */
    public String f8744e;

    /* JADX INFO: renamed from: f */
    public boolean f8745f;

    /* JADX INFO: renamed from: g */
    public int f8746g;

    /* JADX INFO: renamed from: h */
    public int f8747h;

    /* JADX INFO: renamed from: i */
    public int f8748i;

    /* JADX INFO: renamed from: j */
    public int f8749j;

    /* JADX INFO: renamed from: k */
    public int f8750k;

    /* JADX INFO: renamed from: l */
    public RectF f8751l;

    /* JADX INFO: renamed from: m */
    public List f8752m;

    /* JADX INFO: renamed from: n */
    public int f8753n;

    /* JADX INFO: renamed from: o */
    public int f8754o;

    /* JADX INFO: renamed from: p */
    public int f8755p;

    /* JADX INFO: renamed from: q */
    public C6906i f8756q;

    /* JADX INFO: renamed from: r */
    public byte[] f8757r;

    /* JADX INFO: renamed from: s */
    public ArrayList f8758s;

    /* JADX INFO: renamed from: t */
    public long f8759t;

    /* JADX INFO: renamed from: u */
    public long f8760u;

    /* JADX INFO: renamed from: v */
    public List f8761v;

    /* JADX INFO: renamed from: w */
    public int f8762w;

    /* JADX INFO: renamed from: x */
    public String f8763x;

    /* JADX INFO: renamed from: y */
    public int f8764y;

    /* JADX INFO: renamed from: z */
    public int f8765z;

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws SyncException, IOException {
        if (!AbstractC4539a.m3210t() || !NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b)) {
            m13609c(c6742k);
            m13610d(c6742k);
            return;
        }
        C6742k c6742k2 = new C6742k(Xml.newSerializer());
        c6742k2.m4846F("page");
        m13609c(c6742k2);
        m13610d(c6742k2);
        c6742k2.m4856m("page");
        c6742k2.m4857n();
        c6742k.m4851h("id", this.f8744e);
        c6742k.m4851h("hash", m13611e());
        c6742k.m4850f("modifiedTime", this.f8760u);
        c6742k.m4865w("encrypted", C0145c.m319d(((StringWriter) c6742k2.f4111c).toString()));
        c6742k.m4868z("layerList", "layer", this.f8761v);
    }

    @Override // p185h0.InterfaceC12018c
    /* JADX INFO: renamed from: b */
    public final boolean mo13589b(InterfaceC12018c interfaceC12018c, C6903f c6903f) {
        LinkedHashMap linkedHashMap = this.f8736D;
        if (this == interfaceC12018c) {
            return true;
        }
        if (!(interfaceC12018c instanceof C12011u)) {
            return false;
        }
        C12011u c12011u = (C12011u) interfaceC12018c;
        this.f8742c = c12011u.f8742c;
        this.f8743d = c12011u.f8743d;
        this.f8744e = c12011u.f8744e;
        this.f8745f = c12011u.f8745f;
        this.f8746g = c12011u.f8746g;
        this.f8747h = c12011u.f8747h;
        this.f8748i = c12011u.f8748i;
        this.f8749j = c12011u.f8749j;
        this.f8750k = c12011u.f8750k;
        this.f8751l = c12011u.f8751l;
        this.f8752m = c12011u.f8752m;
        this.f8758s = c12011u.f8758s;
        linkedHashMap.clear();
        for (Map.Entry entry : c12011u.f8736D.entrySet()) {
            Integer num = (Integer) entry.getKey();
            num.getClass();
            linkedHashMap.put(num, (C12009s) entry.getValue());
        }
        this.f8753n = c12011u.f8753n;
        this.f8754o = c12011u.f8754o;
        this.f8755p = c12011u.f8755p;
        this.f8756q = c12011u.f8756q;
        this.f8759t = c12011u.f8759t;
        this.f8760u = c12011u.f8760u;
        this.f8735C = c12011u.f8735C;
        this.f8761v = c6903f.m5128l(c12011u.f8744e);
        this.f8762w = c12011u.f8762w;
        this.f8763x = c12011u.f8763x;
        this.f8764y = c12011u.f8764y;
        this.f8765z = c12011u.f8765z;
        this.f8733A = c12011u.f8733A;
        this.f8734B = c12011u.f8734B;
        this.f8737E = c12011u.f8737E;
        this.f8738F = c12011u.f8738F;
        this.f8739G = c12011u.f8739G;
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final void m13609c(C6742k c6742k) throws IOException {
        c6742k.m4851h("id", this.f8744e);
        c6742k.m4851h("hash", m13611e());
        c6742k.m4852i("isTextOnly", this.f8745f);
        c6742k.m4848d(this.f8750k, "orientation");
        c6742k.m4848d(this.f8746g, "width");
        c6742k.m4848d(this.f8747h, "height");
        c6742k.m4848d(this.f8748i, "offsetX");
        c6742k.m4848d(this.f8749j, "offsetY");
        c6742k.m4848d(this.f8734B, DBSchema.DocumentExtra.FORMAT_VERSION);
        if (!TextUtils.isEmpty(this.f8763x)) {
            c6742k.m4853j("templateUri", this.f8763x);
        }
        int i = this.f8753n;
        if (i != -1) {
            c6742k.m4848d(i, "bgImageId");
        }
        int i2 = this.f8764y;
        if (i2 != 0) {
            c6742k.m4848d(i2, "bgImageMode");
        }
        int i4 = this.f8765z;
        if (i4 != -1) {
            c6742k.m4848d(i4, "bgColor");
        }
        int i5 = this.f8754o;
        if (i5 != 0) {
            c6742k.m4848d(i5, "bgWidth");
        }
        int i6 = this.f8755p;
        if (i6 != 0) {
            c6742k.m4848d(i6, "bgRotation");
        }
        c6742k.m4848d(this.f8733A, "minFormatVersion");
        c6742k.m4848d(this.f8762w, "currentLayerIndex");
        c6742k.m4850f(GroupContract.Group.CREATED_TIME, this.f8759t);
        c6742k.m4850f("modifiedTime", this.f8760u);
        int i7 = this.f8735C;
        if (i7 != 0) {
            c6742k.m4848d(i7, "templateType");
        }
        int i8 = this.f8737E;
        if (i8 != 0) {
            c6742k.m4848d(i8, "importedDataHeight");
        }
        long j = this.f8738F;
        if (j != 0) {
            c6742k.m4850f("recognizedDataModifiedTime", j);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Collector
    public final VariableComparator.List collectVariables() {
        return new VariableComparator.List().addVar(new VariableComparator.StringVar("mUuid", this.f8744e)).addVar(new VariableComparator.BoolVar("mFlagTextOnly", this.f8745f)).addVar(new VariableComparator.IntVar("mPageWidth", this.f8746g)).addVar(new VariableComparator.IntVar("mPageHeight", this.f8747h)).addVar(new VariableComparator.IntVar("mOffsetX", this.f8748i)).addVar(new VariableComparator.IntVar("mOffsetY", this.f8749j)).addVar(new VariableComparator.IntVar("mNoteOrientation", this.f8750k)).addVar(new VariableComparator.RectVar("mPageDrawnRectF", this.f8751l)).addVar(new VariableComparator.ObjectVar("mTagList", this.f8752m)).addVar(new C12007q("canvasCacheDataMap", this.f8736D)).addVar(new VariableComparator.IntVar("mBgImageUriMediaId", this.f8753n)).addVar(new VariableComparator.IntVar("mBgWidth", this.f8754o)).addVar(new VariableComparator.IntVar("mBgRotation", this.f8755p)).addVar(new VariableComparator.ComparisonVar("mContentFileManager", (C11979b) this.f8756q.f4483b)).addVar(new VariableComparator.LongVar("mCreatedTime", this.f8759t)).addVar(new VariableComparator.LongVar("mModifiedTime", this.f8760u)).addVar(new VariableComparator.IntVar("mTemplateType", this.f8735C)).addVar(new C12008r("mLayerList", this.f8761v)).addVar(new VariableComparator.IntVar("mCurrentLayerIndex", this.f8762w)).addVar(new VariableComparator.StringVar("mTemplateUri", this.f8763x)).addVar(new VariableComparator.IntVar("mBgImageMode", this.f8764y)).addVar(new VariableComparator.IntVar("mBgColor", this.f8765z)).addVar(new VariableComparator.IntVar("mMinFormatVersion", this.f8733A)).addVar(new C12006p("mFormatVersion", this.f8734B)).addVar(new VariableComparator.IntVar("mImportedDataHeight", this.f8737E)).addVar(new VariableComparator.LongVar("mRecognizedDataModifiedTime", this.f8738F)).addVar(new VariableComparator.ObjectVar("mCustomObjectList", this.f8739G));
    }

    /* JADX INFO: renamed from: d */
    public final void m13610d(C6742k c6742k) throws SyncException {
        LinkedHashMap linkedHashMap = this.f8736D;
        try {
            RectF rectF = this.f8751l;
            if (rectF != null && (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f)) {
                c6742k.m4845D("drawnRect", rectF);
            }
            if (!linkedHashMap.isEmpty()) {
                c6742k.m4846F("canvasCacheDataMap");
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    c6742k.m4846F("pair");
                    c6742k.m4848d(((Integer) entry.getKey()).intValue(), "key");
                    C12009s c12009s = (C12009s) entry.getValue();
                    int i = c12009s.f8720a;
                    int[] iArr = c12009s.f8725f;
                    c6742k.m4848d(i, "fileId");
                    c6742k.m4848d(c12009s.f8721b, "width");
                    c6742k.m4848d(c12009s.f8722c, "height");
                    c6742k.m4852i("isDarkMode", c12009s.f8723d);
                    c6742k.m4848d(c12009s.f8724e, "backgroundColor");
                    c6742k.m4848d(iArr[0], "version0");
                    c6742k.m4848d(iArr[1], "version1");
                    c6742k.m4848d(iArr[2], "version2");
                    c6742k.m4848d(c12009s.f8726g, "cacheVersion");
                    c6742k.m4848d(c12009s.f8727h, "property");
                    c6742k.m4848d(c12009s.f8728i, "localeListId");
                    c6742k.m4848d(c12009s.f8729j, "systemFontPathHash");
                    c6742k.m4856m("pair");
                }
                c6742k.m4856m("canvasCacheDataMap");
            }
            ArrayList arrayList = this.f8758s;
            if (arrayList != null && !arrayList.isEmpty()) {
                c6742k.m4846F("pdfDataList");
                for (C12010t c12010t : this.f8758s) {
                    c6742k.m4846F("pdfData");
                    c6742k.m4848d(c12010t.f8730a, "pageIndex");
                    c6742k.m4851h("hash", ((C11979b) this.f8756q.f4483b).m13559e(c12010t.f8732c));
                    RectF rectF2 = c12010t.f8731b;
                    c6742k.m4844C("pdfRect", new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom));
                    c6742k.m4856m("pdfData");
                }
                c6742k.m4856m("pdfDataList");
            }
            C0158a.m407a().getClass();
            if (!SyncState.isEdpMode() || !NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b)) {
                c6742k.m4868z("layerList", "layer", this.f8761v);
            }
            try {
                if (this.f8739G.isEmpty()) {
                    return;
                }
                c6742k.m4868z("customObjectList", "customObject", this.f8739G);
                Debugger.printMemory("WCon_Page", "[CurrentMemoryState] After composing a mCustomObjectList");
            } catch (Exception e) {
                Debugger.m8609e("WCon_Page", "composeElement : " + e.getMessage());
                throw new SyncException(326, e);
            }
        } catch (Exception e2) {
            Debugger.m8609e("WCon_Page", "composeXml : " + e2.getMessage());
            throw new SyncException(326, e2);
        }
    }

    /* JADX INFO: renamed from: e */
    public final String m13611e() {
        byte[] bArr = this.f8757r;
        if (bArr != null && bArr.length > 0) {
            return C14433b.m15034q(bArr);
        }
        Debugger.m8607d("WCon_Page", this.f8744e + "'s hash is null");
        return "";
    }

    /* JADX INFO: renamed from: f */
    public final void m13612f(RandomAccessFile randomAccessFile) throws Exception {
        int i;
        int i2;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        int iM606P = AbstractC0299q.m606P(randomAccessFile);
        randomAccessFile.seek(0L);
        int i5 = 4;
        randomAccessFile.skipBytes(4);
        int iM606P2 = AbstractC0299q.m606P(randomAccessFile);
        randomAccessFile.skipBytes(1);
        int iM606P3 = AbstractC0299q.m606P(randomAccessFile);
        this.f8743d = iM606P3;
        int i6 = 0;
        this.f8745f = (iM606P3 & 1) != 0;
        randomAccessFile.skipBytes(1);
        this.f8742c = AbstractC0299q.m606P(randomAccessFile);
        this.f8750k = AbstractC0299q.m606P(randomAccessFile);
        this.f8746g = AbstractC0299q.m606P(randomAccessFile);
        this.f8747h = AbstractC0299q.m606P(randomAccessFile);
        this.f8748i = AbstractC0299q.m606P(randomAccessFile);
        this.f8749j = AbstractC0299q.m606P(randomAccessFile);
        this.f8744e = AbstractC0299q.m611U(randomAccessFile, -1);
        this.f8760u = AbstractC0299q.m607Q(randomAccessFile);
        this.f8734B = AbstractC0299q.m606P(randomAccessFile);
        this.f8733A = AbstractC0299q.m606P(randomAccessFile);
        long j = iM606P2;
        if (j != randomAccessFile.getFilePointer()) {
            randomAccessFile.seek(j);
        }
        if ((this.f8742c & 1) != 0) {
            SpenRectD spenRectD = new SpenRectD();
            spenRectD.left = Double.longBitsToDouble(AbstractC0299q.m607Q(randomAccessFile));
            spenRectD.top = Double.longBitsToDouble(AbstractC0299q.m607Q(randomAccessFile));
            spenRectD.right = Double.longBitsToDouble(AbstractC0299q.m607Q(randomAccessFile));
            spenRectD.bottom = Double.longBitsToDouble(AbstractC0299q.m607Q(randomAccessFile));
            this.f8751l = new RectF((float) spenRectD.left, (float) spenRectD.top, (float) spenRectD.right, (float) spenRectD.bottom);
        } else {
            this.f8751l = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.f8752m.clear();
        if ((this.f8742c & 2) != 0) {
            int iM609S = AbstractC0299q.m609S(randomAccessFile);
            for (int i7 = 0; i7 < iM609S; i7++) {
                String strM611U = AbstractC0299q.m611U(randomAccessFile, 1024);
                if (strM611U != null) {
                    this.f8752m.add(strM611U);
                }
            }
        }
        this.f8763x = null;
        if ((this.f8742c & 4) != 0) {
            this.f8763x = AbstractC0299q.m611U(randomAccessFile, -1);
        }
        this.f8753n = -1;
        if ((this.f8742c & 8) != 0) {
            this.f8753n = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8742c & 16) != 0) {
            this.f8764y = AbstractC0299q.m606P(randomAccessFile);
        } else {
            this.f8764y = 0;
        }
        if ((this.f8742c & 32) != 0) {
            this.f8765z = AbstractC0299q.m606P(randomAccessFile);
        } else {
            this.f8765z = -1;
        }
        this.f8754o = (this.f8742c & 64) != 0 ? AbstractC0299q.m606P(randomAccessFile) : 0;
        this.f8755p = (this.f8742c & 128) != 0 ? AbstractC0299q.m606P(randomAccessFile) : 0;
        if ((this.f8742c & 256) != 0) {
            this.f8758s.clear();
            int iM609S2 = AbstractC0299q.m609S(randomAccessFile);
            for (int i8 = 0; i8 < iM609S2; i8++) {
                C12010t c12010t = new C12010t();
                c12010t.f8732c = AbstractC0299q.m606P(randomAccessFile);
                c12010t.f8730a = AbstractC0299q.m606P(randomAccessFile);
                if (this.f8734B < 2034) {
                    c12010t.f8731b = AbstractC0299q.m608R(randomAccessFile);
                } else {
                    Rect rect = new Rect();
                    rect.left = AbstractC0299q.m606P(randomAccessFile);
                    rect.top = AbstractC0299q.m606P(randomAccessFile);
                    rect.right = AbstractC0299q.m606P(randomAccessFile);
                    rect.bottom = AbstractC0299q.m606P(randomAccessFile);
                    c12010t.f8731b = new RectF(rect.left, rect.top, rect.right, rect.bottom);
                }
                this.f8758s.add(c12010t);
            }
        }
        if ((this.f8742c & 512) != 0) {
            this.f8735C = AbstractC0299q.m606P(randomAccessFile);
        }
        LinkedHashMap linkedHashMap = this.f8736D;
        linkedHashMap.clear();
        if ((this.f8742c & 1024) != 0) {
            int iM606P4 = AbstractC0299q.m606P(randomAccessFile);
            int iM609S3 = AbstractC0299q.m609S(randomAccessFile);
            if (iM609S3 != 49) {
                randomAccessFile.seek(randomAccessFile.getFilePointer() + ((long) (iM609S3 * iM606P4)));
            } else {
                for (int i9 = 0; i9 < iM606P4; i9++) {
                    int iM606P5 = AbstractC0299q.m606P(randomAccessFile);
                    C12009s c12009s = new C12009s();
                    c12009s.f8720a = AbstractC0299q.m606P(randomAccessFile);
                    c12009s.f8721b = AbstractC0299q.m606P(randomAccessFile);
                    c12009s.f8722c = AbstractC0299q.m606P(randomAccessFile);
                    c12009s.f8723d = randomAccessFile.readByte() == 1;
                    c12009s.f8724e = AbstractC0299q.m606P(randomAccessFile);
                    for (int i10 = 0; i10 < 3; i10++) {
                        c12009s.f8725f[i10] = AbstractC0299q.m606P(randomAccessFile);
                    }
                    c12009s.f8726g = AbstractC0299q.m606P(randomAccessFile);
                    c12009s.f8727h = AbstractC0299q.m606P(randomAccessFile);
                    c12009s.f8728i = AbstractC0299q.m606P(randomAccessFile);
                    c12009s.f8729j = AbstractC0299q.m606P(randomAccessFile);
                    linkedHashMap.put(Integer.valueOf(iM606P5), c12009s);
                }
            }
        }
        if ((this.f8742c & 2048) != 0) {
            this.f8737E = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8742c & 4096) != 0) {
            randomAccessFile.skipBytes(4);
        }
        this.f8739G.clear();
        if ((this.f8742c & 262144) != 0) {
            int iM606P6 = AbstractC0299q.m606P(randomAccessFile);
            int i11 = 0;
            while (i11 < iM606P6) {
                C12964v c12964v = new C12964v(AbstractC0299q.m606P(randomAccessFile), this.f8756q);
                long filePointer = randomAccessFile.getFilePointer();
                int iM606P7 = AbstractC0299q.m606P(randomAccessFile);
                byte[] bArr = new byte[iM606P7];
                randomAccessFile.read(bArr);
                C12020a c12020a = new C12020a(bArr);
                ((ByteBuffer) c12020a.f8772b).getInt(i6);
                byte b = ((ByteBuffer) c12020a.f8772b).get(i5);
                int i12 = b + 5;
                int i13 = b + 6;
                byte b5 = ((ByteBuffer) c12020a.f8772b).get(i12);
                ((ByteBuffer) c12020a.f8772b).getShort(i13);
                int i14 = b5 + i13;
                int iM13870a = c12964v.f9261a.m13870a(c12020a, i14);
                if (iM13870a < 0) {
                    Log.e("WCon_CustomObject", "applyOwnBinary: Fail to load uuid");
                    i = i5;
                    i2 = iM606P6;
                    i4 = i11;
                    z = false;
                } else {
                    int i15 = i14 + iM13870a;
                    int i16 = ((ByteBuffer) c12020a.f8772b).getInt(i15);
                    int i17 = i15 + i5;
                    if (c12964v.f9264d == null) {
                        c12964v.f9264d = new HashMap();
                    }
                    c12964v.f9264d.clear();
                    int i18 = 0;
                    while (i18 < i16) {
                        int i19 = i5;
                        String strM13644q = c12020a.m13644q(i17 + 4, ((ByteBuffer) c12020a.f8772b).getInt(i17));
                        int length = (strM13644q.isEmpty() ? i19 : strM13644q.getBytes().length + 4) + i17;
                        int i20 = ((ByteBuffer) c12020a.f8772b).getInt(length);
                        int i21 = length + 4;
                        int i22 = iM606P6;
                        if (i20 != -1) {
                            c12964v.f9264d.put(strM13644q, Integer.valueOf(i20));
                        }
                        i18++;
                        i17 = i21;
                        i5 = i19;
                        iM606P6 = i22;
                    }
                    i = i5;
                    i2 = iM606P6;
                    int i23 = ((ByteBuffer) c12020a.f8772b).getInt(i17);
                    int i24 = i17 + 4;
                    if (c12964v.f9265e == null) {
                        c12964v.f9265e = new HashMap();
                    }
                    c12964v.f9265e.clear();
                    int i25 = 0;
                    while (i25 < i23) {
                        String strM13644q2 = c12020a.m13644q(i24 + 4, ((ByteBuffer) c12020a.f8772b).getInt(i24));
                        int length2 = (strM13644q2.isEmpty() ? i : strM13644q2.getBytes().length + 4) + i24;
                        String strM13644q3 = c12020a.m13644q(length2 + 4, ((ByteBuffer) c12020a.f8772b).getInt(length2));
                        int length3 = length2 + (strM13644q3.isEmpty() ? i : strM13644q3.getBytes().length + 4);
                        if (!strM13644q2.isEmpty() && !strM13644q3.isEmpty()) {
                            c12964v.f9265e.put(strM13644q2, strM13644q3);
                        }
                        i25++;
                        i24 = length3;
                    }
                    SpenRectD spenRectDM13642o = c12020a.m13642o(i24);
                    i4 = i11;
                    c12964v.f9263c = new RectF((float) spenRectDM13642o.left, (float) spenRectDM13642o.top, (float) spenRectDM13642o.right, (float) spenRectDM13642o.bottom);
                    z = true;
                }
                if (!z) {
                    Log.e("WCon_CustomObject", "CustomObject newApplyBinary() fail to apply own binary. err = " + z);
                }
                randomAccessFile.seek(filePointer + 4 + ((long) iM606P7));
                this.f8739G.add(c12964v);
                i11 = i4 + 1;
                i5 = i;
                iM606P6 = i2;
                i6 = 0;
            }
        }
        int i26 = i5;
        randomAccessFile.seek(iM606P);
        this.f8761v.clear();
        int iM609S4 = AbstractC0299q.m609S(randomAccessFile);
        this.f8762w = AbstractC0299q.m609S(randomAccessFile);
        int i27 = 0;
        while (i27 < iM609S4) {
            randomAccessFile.skipBytes(i26);
            C11992b c11992b = new C11992b(this.f8756q);
            int iM606P8 = AbstractC0299q.m606P(randomAccessFile);
            randomAccessFile.readByte();
            byte b6 = randomAccessFile.readByte();
            randomAccessFile.readByte();
            byte b7 = randomAccessFile.readByte();
            if ((b6 & 2) != 0) {
                z2 = true;
                c11992b.f8622a = true;
                z3 = false;
            } else {
                z2 = true;
                z3 = false;
                c11992b.f8622a = false;
            }
            if ((b6 & 1) == 0) {
                c11992b.f8623b = z2;
            } else {
                c11992b.f8623b = z3;
            }
            if ((b6 & 4) != 0) {
                c11992b.f8632k = z2;
            } else {
                c11992b.f8632k = z3;
            }
            c11992b.f8624c = AbstractC0299q.m606P(randomAccessFile);
            long j2 = iM606P8;
            if (j2 != randomAccessFile.getFilePointer()) {
                randomAccessFile.seek(j2);
            }
            if ((b7 & 1) != 0) {
                c11992b.f8625d = randomAccessFile.readByte();
            }
            if ((b7 & 2) != 0) {
                c11992b.f8626e = AbstractC0299q.m606P(randomAccessFile);
            }
            if ((b7 & 4) != 0) {
                c11992b.f8627f = AbstractC0299q.m611U(randomAccessFile, -1);
            }
            if ((b7 & 8) != 0) {
                c11992b.f8628g = AbstractC0299q.m611U(randomAccessFile, 1024);
            }
            if ((b7 & 16) != 0) {
                c11992b.f8630i = AbstractC0299q.m607Q(randomAccessFile);
            }
            if ((b7 & 32) != 0) {
                c11992b.f8633l = AbstractC0299q.m606P(randomAccessFile);
            }
            int iM606P9 = AbstractC0299q.m606P(randomAccessFile);
            C6906i c6906i = c11992b.f8634m;
            ((C11980c) c6906i.f4484c).f8579a += iM606P9;
            AbstractC11014a.m12328m(iM606P9, "readWDoc - object count = [", "]", "WCon_Layer");
            c11992b.m13594g(randomAccessFile, iM606P9, null);
            StringBuilder sb = new StringBuilder("readWDoc - total object count = [");
            sb.append(((C11980c) c6906i.f4484c).f8579a);
            sb.append("], stroke = [");
            AbstractC11014a.m12329n(((C11980c) c6906i.f4484c).f8580b, "]", "WCon_Layer", sb);
            int i28 = AbstractC0299q.f770c;
            C11980c c11980c = (C11980c) c6906i.f4484c;
            if (MaxObjectLimitHelper.isMaxStrokeObjectLimit(i28, c11980c.f8579a, c11980c.f8580b)) {
                StringBuilder sb2 = new StringBuilder("Too many [");
                sb2.append(((C11980c) c6906i.f4484c).f8579a);
                sb2.append(",");
                throw new WDocExceedObjectException(AbstractC2322a.m1625o(sb2, ((C11980c) c6906i.f4484c).f8580b, iM606P9, "] objects are included. Fail to add [", "] objects."));
            }
            byte[] bArr2 = new byte[32];
            randomAccessFile.read(bArr2);
            c11992b.f8635n = bArr2;
            Log.d("WCon_Layer", "readWDoc - layer Hash = [" + C14433b.m15034q(c11992b.f8635n) + "]");
            this.f8761v.add(c11992b);
            i27++;
            i26 = 4;
        }
    }

    /* JADX INFO: renamed from: g */
    public final int m13613g(XmlPullParser xmlPullParser) {
        String str;
        int i;
        String str2;
        String attributeValue;
        String str3;
        int i2;
        int i4;
        int i5;
        int i6;
        int iM15119D;
        C12011u c12011u = this;
        int attributeCount = xmlPullParser.getAttributeCount();
        int i7 = 0;
        while (true) {
            str = "height";
            i = 2;
            if (i7 >= attributeCount) {
                break;
            }
            String attributeName = xmlPullParser.getAttributeName(i7);
            if (attributeName.equalsIgnoreCase("id")) {
                c12011u.f8744e = xmlPullParser.getAttributeValue(i7);
            } else if (attributeName.equalsIgnoreCase("hash")) {
                c12011u.f8757r = C14433b.m15032m(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("isTextOnly")) {
                c12011u.f8745f = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("orientation")) {
                int i8 = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
                c12011u.f8750k = i8;
                if (i8 < 0) {
                    Log.w("WCon_Page", "parseAttribute - invalid orientation = [" + c12011u.f8750k + "]");
                    c12011u.f8750k = 2;
                }
            } else if (attributeName.equalsIgnoreCase("width")) {
                c12011u.f8746g = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("height")) {
                c12011u.f8747h = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("offsetX")) {
                c12011u.f8748i = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("offsetY")) {
                c12011u.f8749j = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase(DBSchema.DocumentExtra.FORMAT_VERSION)) {
                int i9 = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
                c12011u.f8734B = i9;
                if (i9 > 5400) {
                    Log.w("WCon_Page", "parseAttribute - unknown format version = [" + c12011u.f8734B + "]");
                    c12011u.f8734B = 5400;
                }
            } else if (attributeName.equalsIgnoreCase("templateUri")) {
                c12011u.f8763x = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("bgImageId")) {
                c12011u.f8753n = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("bgImageMode")) {
                c12011u.f8764y = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("bgColor")) {
                c12011u.f8765z = (int) Long.parseLong(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("bgWidth")) {
                c12011u.f8754o = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("bgRotation")) {
                c12011u.f8755p = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("minFormatVersion")) {
                c12011u.f8733A = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("currentLayerIndex")) {
                c12011u.f8762w = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase(GroupContract.Group.CREATED_TIME)) {
                c12011u.f8759t = Long.parseLong(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("modifiedTime")) {
                c12011u.f8760u = Long.parseLong(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("templateType")) {
                c12011u.f8735C = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("importedDataHeight")) {
                c12011u.f8737E = Integer.parseInt(xmlPullParser.getAttributeValue(i7));
            } else if (attributeName.equalsIgnoreCase("recognizedDataModifiedTime")) {
                c12011u.f8738F = Long.parseLong(xmlPullParser.getAttributeValue(i7));
            }
            i7++;
        }
        int i10 = 1;
        int iM15119D2 = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            int i11 = 3;
            if (iM15119D2 == 3 && xmlPullParser.getName().equals("page")) {
                return iM15119D2;
            }
            if (iM15119D2 == i) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("drawnRect")) {
                    c12011u.f8751l = AbstractC14517a.m15127L(xmlPullParser);
                } else {
                    if (name.equalsIgnoreCase("canvasCacheDataMap")) {
                        int iM15119D3 = AbstractC14517a.m15119D(xmlPullParser, i10);
                        while (true) {
                            if (iM15119D3 == i11 && xmlPullParser.getName().equals("canvasCacheDataMap")) {
                                break;
                            }
                            int attributeCount2 = xmlPullParser.getAttributeCount();
                            C12009s c12009s = new C12009s();
                            int i12 = 0;
                            int i13 = 0;
                            while (i12 < attributeCount2) {
                                int i14 = i10;
                                String attributeName2 = xmlPullParser.getAttributeName(i12);
                                if (attributeName2.equalsIgnoreCase("key")) {
                                    i13 = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("fileId")) {
                                    c12009s.f8720a = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("width")) {
                                    c12009s.f8721b = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase(str)) {
                                    c12009s.f8722c = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("isDarkMode")) {
                                    c12009s.f8723d = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("backgroundColor")) {
                                    c12009s.f8724e = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("version0")) {
                                    c12009s.f8725f[0] = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("version1")) {
                                    c12009s.f8725f[i14] = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("version2")) {
                                    c12009s.f8725f[i] = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("cacheVersion")) {
                                    c12009s.f8726g = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("property")) {
                                    c12009s.f8727h = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("localeListId")) {
                                    c12009s.f8728i = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                } else if (attributeName2.equalsIgnoreCase("systemFontPathHash")) {
                                    c12009s.f8729j = Integer.parseInt(xmlPullParser.getAttributeValue(i12));
                                }
                                i12++;
                                i10 = i14;
                            }
                            c12011u.f8736D.put(Integer.valueOf(i13), c12009s);
                            iM15119D3 = AbstractC14517a.m15119D(xmlPullParser, i);
                            i10 = i10;
                            i11 = 3;
                        }
                        i6 = i10;
                        str2 = str;
                        i5 = i;
                    } else {
                        int i15 = i10;
                        C12010t c12010t = null;
                        if (name.equalsIgnoreCase("pdfDataList")) {
                            int eventType = xmlPullParser.getEventType();
                            xmlPullParser.require(i, null, "pdfDataList");
                            while (true) {
                                if (eventType == i) {
                                    String name2 = xmlPullParser.getName();
                                    if (name2.equalsIgnoreCase("pdfData")) {
                                        c12010t = new C12010t();
                                        c12011u.f8758s.add(c12010t);
                                        int attributeCount3 = xmlPullParser.getAttributeCount();
                                        for (int i16 = 0; i16 < attributeCount3; i16++) {
                                            String attributeName3 = xmlPullParser.getAttributeName(i16);
                                            if (attributeName3.equalsIgnoreCase("pageIndex")) {
                                                c12010t.f8730a = Integer.parseInt(xmlPullParser.getAttributeValue(i16));
                                            } else if (attributeName3.equalsIgnoreCase("hash")) {
                                                c12010t.f8732c = ((C11979b) c12011u.f8756q.f4483b).m13558d(xmlPullParser.getAttributeValue(i16));
                                            }
                                        }
                                    } else if (!name2.equalsIgnoreCase("rect")) {
                                        if (name2.equalsIgnoreCase("pdfRect") && c12010t != null) {
                                            Rect rectM15125J = AbstractC14517a.m15125J(xmlPullParser);
                                            str2 = str;
                                            c12010t.f8731b = new RectF(rectM15125J.left, rectM15125J.top, rectM15125J.right, rectM15125J.bottom);
                                        }
                                        iM15119D = AbstractC14517a.m15119D(xmlPullParser, i15);
                                        if (iM15119D != 3 && xmlPullParser.getName().equals("pdfDataList")) {
                                            break;
                                        }
                                        eventType = iM15119D;
                                        str = str2;
                                        i = 2;
                                        i15 = 1;
                                    } else if (c12010t != null && c12010t.f8731b == null) {
                                        c12010t.f8731b = AbstractC14517a.m15127L(xmlPullParser);
                                    }
                                } else if (eventType != 3 && eventType != 4) {
                                    AbstractC2322a.m1632v(eventType, "parseXml - invalid eventType = [", "]", "WCon_Page");
                                }
                                str2 = str;
                                iM15119D = AbstractC14517a.m15119D(xmlPullParser, i15);
                                if (iM15119D != 3) {
                                }
                                eventType = iM15119D;
                                str = str2;
                                i = 2;
                                i15 = 1;
                            }
                        } else {
                            str2 = str;
                            if (name.equalsIgnoreCase("layerList")) {
                                c12011u.f8761v = new ArrayList();
                            } else if (name.equalsIgnoreCase("layer")) {
                                C11992b c11992b = new C11992b(c12011u.f8756q);
                                int i17 = 2;
                                xmlPullParser.require(2, null, "layer");
                                C0158a.m407a().getClass();
                                if (SyncState.isEdpMode() && AbstractC0299q.f769b) {
                                    xmlPullParser.require(2, null, "layer");
                                    int iM15119D4 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                    while (true) {
                                        if (iM15119D4 == 3 && xmlPullParser.getName().equals("layer")) {
                                            break;
                                        }
                                        if (iM15119D4 != i17) {
                                            if (iM15119D4 != 3 && iM15119D4 != 4) {
                                                AbstractC2322a.m1632v(iM15119D4, "parseXml - invalid eventType = [", "]", "WCon_Layer");
                                            }
                                        } else if (xmlPullParser.getName().equals("encrypted")) {
                                            Debugger.m8615i("WCon_Layer", "parseEncryptedElement()");
                                            String strM317b = C0145c.m317b(AbstractC14517a.m15129N(xmlPullParser));
                                            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                                            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                                            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                                            xmlPullParserNewPullParser.setInput(new StringReader(strM317b));
                                            xmlPullParserNewPullParser.nextTag();
                                            c11992b.m13595k(xmlPullParserNewPullParser);
                                        } else {
                                            iM15119D4 = c11992b.m13595k(xmlPullParser);
                                        }
                                        if (iM15119D4 != 3 || !xmlPullParser.getName().equals("layer")) {
                                            iM15119D4 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                        }
                                        i17 = 2;
                                    }
                                } else {
                                    c11992b.m13595k(xmlPullParser);
                                }
                                c12011u.f8761v.add(c11992b);
                            } else if (name.equalsIgnoreCase("customObjectList")) {
                                c12011u.f8739G = new ArrayList();
                            } else {
                                String str4 = "customObject";
                                if (name.equalsIgnoreCase("customObject")) {
                                    int attributeCount4 = xmlPullParser.getAttributeCount();
                                    int i18 = 0;
                                    while (true) {
                                        if (i18 >= attributeCount4) {
                                            attributeValue = null;
                                            break;
                                        }
                                        if (xmlPullParser.getAttributeName(i18).equalsIgnoreCase("type")) {
                                            attributeValue = xmlPullParser.getAttributeValue(i18);
                                            break;
                                        }
                                        i18++;
                                    }
                                    C12964v c12964v = new C12964v(Integer.parseInt(attributeValue), c12011u.f8756q);
                                    xmlPullParser.require(2, null, "customObject");
                                    int attributeCount5 = xmlPullParser.getAttributeCount();
                                    int i19 = 0;
                                    while (i19 < attributeCount5) {
                                        String attributeName4 = xmlPullParser.getAttributeName(i19);
                                        if (attributeName4.equalsIgnoreCase("id")) {
                                            i4 = attributeCount5;
                                            c12964v.f9261a.f9296a = xmlPullParser.getAttributeValue(i19);
                                        } else {
                                            i4 = attributeCount5;
                                            if (attributeName4.equals("type")) {
                                                c12964v.f9262b = Integer.parseInt(xmlPullParser.getAttributeValue(i19));
                                            }
                                        }
                                        i19++;
                                        attributeCount5 = i4;
                                    }
                                    int iM15119D5 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                    while (true) {
                                        if (iM15119D5 == 3 && xmlPullParser.getName().equals(str4)) {
                                            break;
                                        }
                                        if (iM15119D5 != 2) {
                                            if (iM15119D5 != 3 && iM15119D5 != 4) {
                                                AbstractC2322a.m1632v(iM15119D5, "parseXml - invalid eventType = [", "]", "WCon_CustomObject");
                                            }
                                            str3 = str4;
                                        } else {
                                            String name3 = xmlPullParser.getName();
                                            if (name3.equalsIgnoreCase("attachedFileList")) {
                                                int iM15119D6 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                                while (true) {
                                                    if (iM15119D6 == 3 && xmlPullParser.getName().equals("attachedFileList")) {
                                                        break;
                                                    }
                                                    int attributeCount6 = xmlPullParser.getAttributeCount();
                                                    int i20 = 0;
                                                    int iM13558d = 0;
                                                    String strDecodeBase64 = null;
                                                    while (i20 < attributeCount6) {
                                                        String str5 = str4;
                                                        String attributeName5 = xmlPullParser.getAttributeName(i20);
                                                        if (attributeName5.equalsIgnoreCase("key")) {
                                                            strDecodeBase64 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i20));
                                                        } else {
                                                            if (attributeName5.equalsIgnoreCase("value")) {
                                                                i2 = attributeCount6;
                                                                iM13558d = c12964v.f9266f.m13558d(xmlPullParser.getAttributeValue(i20));
                                                            }
                                                            i20++;
                                                            str4 = str5;
                                                            attributeCount6 = i2;
                                                        }
                                                        i2 = attributeCount6;
                                                        i20++;
                                                        str4 = str5;
                                                        attributeCount6 = i2;
                                                    }
                                                    c12964v.f9264d.put(strDecodeBase64, Integer.valueOf(iM13558d));
                                                    iM15119D6 = AbstractC14517a.m15119D(xmlPullParser, 2);
                                                    str4 = str4;
                                                }
                                                str3 = str4;
                                            } else {
                                                str3 = str4;
                                                String str6 = "customDataList";
                                                if (name3.equalsIgnoreCase("customDataList")) {
                                                    int iM15119D7 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                                    while (true) {
                                                        if (iM15119D7 == 3 && xmlPullParser.getName().equals(str6)) {
                                                            break;
                                                        }
                                                        int attributeCount7 = xmlPullParser.getAttributeCount();
                                                        int i21 = 0;
                                                        String strDecodeBase642 = null;
                                                        String strDecodeBase643 = null;
                                                        while (i21 < attributeCount7) {
                                                            String str7 = str6;
                                                            String attributeName6 = xmlPullParser.getAttributeName(i21);
                                                            if (attributeName6.equalsIgnoreCase("key")) {
                                                                strDecodeBase643 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i21));
                                                            } else if (attributeName6.equalsIgnoreCase("value")) {
                                                                strDecodeBase642 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i21));
                                                            }
                                                            i21++;
                                                            str6 = str7;
                                                        }
                                                        String str8 = str6;
                                                        if (strDecodeBase642 == null) {
                                                            strDecodeBase642 = "";
                                                        }
                                                        c12964v.f9265e.put(strDecodeBase643, strDecodeBase642);
                                                        iM15119D7 = AbstractC14517a.m15119D(xmlPullParser, 2);
                                                        str6 = str8;
                                                    }
                                                } else {
                                                    if (name3.equalsIgnoreCase("rect")) {
                                                        c12964v.f9263c = AbstractC14517a.m15127L(xmlPullParser);
                                                    }
                                                    iM15119D5 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                                    c12011u = this;
                                                    str4 = str3;
                                                }
                                            }
                                        }
                                        iM15119D5 = AbstractC14517a.m15119D(xmlPullParser, 1);
                                        c12011u = this;
                                        str4 = str3;
                                    }
                                    c12011u.f8739G.add(c12964v);
                                }
                            }
                        }
                        i5 = 2;
                        i6 = 1;
                    }
                    iM15119D2 = AbstractC14517a.m15119D(xmlPullParser, i6);
                    c12011u = this;
                    i = i5;
                    i10 = i6;
                    str = str2;
                }
            } else if (iM15119D2 != 3 && iM15119D2 != 4) {
                AbstractC2322a.m1632v(iM15119D2, "parseXml - invalid eventType = [", "]", "WCon_Page");
            }
            i6 = i10;
            str2 = str;
            i5 = i;
            iM15119D2 = AbstractC14517a.m15119D(xmlPullParser, i6);
            c12011u = this;
            i = i5;
            i10 = i6;
            str = str2;
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m13614h(RandomAccessFile randomAccessFile) throws IOException {
        C13573a c13573a;
        int i;
        int i2;
        int i4;
        C13573a c13573a2;
        ByteArrayOutputStream byteArrayOutputStream;
        int i5;
        LinkedHashMap linkedHashMap = this.f8736D;
        randomAccessFile.seek(0L);
        randomAccessFile.seek(18);
        int i6 = 0;
        this.f8743d = 0;
        if (this.f8745f) {
            this.f8743d = 1;
        }
        AbstractC0299q.m632h0(randomAccessFile, this.f8750k);
        AbstractC0299q.m632h0(randomAccessFile, this.f8746g);
        AbstractC0299q.m632h0(randomAccessFile, this.f8747h);
        AbstractC0299q.m632h0(randomAccessFile, this.f8748i);
        AbstractC0299q.m632h0(randomAccessFile, this.f8749j);
        AbstractC0299q.m640l0(randomAccessFile, this.f8744e);
        AbstractC0299q.m634i0(randomAccessFile, this.f8760u);
        AbstractC0299q.m632h0(randomAccessFile, this.f8734B);
        AbstractC0299q.m632h0(randomAccessFile, this.f8733A);
        long filePointer = randomAccessFile.getFilePointer();
        this.f8742c = 0;
        RectF rectF = this.f8751l;
        if (rectF != null && (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f)) {
            this.f8742c = 1;
            SpenRectD spenRectD = new SpenRectD(rectF);
            AbstractC0299q.m628f0(randomAccessFile, spenRectD.left);
            AbstractC0299q.m628f0(randomAccessFile, spenRectD.top);
            AbstractC0299q.m628f0(randomAccessFile, spenRectD.right);
            AbstractC0299q.m628f0(randomAccessFile, spenRectD.bottom);
        }
        int size = this.f8752m.size();
        if (size > 0) {
            this.f8742c |= 2;
            AbstractC0299q.m636j0(randomAccessFile, size);
            Iterator it = this.f8752m.iterator();
            while (it.hasNext()) {
                AbstractC0299q.m640l0(randomAccessFile, (String) it.next());
            }
        }
        String str = this.f8763x;
        int i7 = 4;
        if (str != null) {
            this.f8742c |= 4;
            AbstractC0299q.m640l0(randomAccessFile, str);
        }
        int i8 = this.f8753n;
        int i9 = -1;
        if (i8 != -1) {
            this.f8742c |= 8;
            AbstractC0299q.m632h0(randomAccessFile, i8);
        }
        int i10 = this.f8764y;
        if (i10 != 0) {
            this.f8742c |= 16;
            AbstractC0299q.m632h0(randomAccessFile, i10);
        }
        int i11 = this.f8765z;
        if (i11 != -1) {
            this.f8742c |= 32;
            AbstractC0299q.m632h0(randomAccessFile, i11);
        }
        int i12 = this.f8754o;
        if (i12 != 0) {
            this.f8742c |= 64;
            AbstractC0299q.m632h0(randomAccessFile, i12);
        }
        int i13 = this.f8755p;
        if (i13 != 0) {
            this.f8742c |= 128;
            AbstractC0299q.m632h0(randomAccessFile, i13);
        }
        int size2 = this.f8758s.size();
        if (size2 > 0) {
            this.f8742c |= 256;
            AbstractC0299q.m636j0(randomAccessFile, size2);
            for (int i14 = 0; i14 < size2; i14++) {
                C12010t c12010t = (C12010t) this.f8758s.get(i14);
                AbstractC0299q.m632h0(randomAccessFile, c12010t.f8732c);
                AbstractC0299q.m632h0(randomAccessFile, c12010t.f8730a);
                RectF rectF2 = c12010t.f8731b;
                Rect rect = new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                AbstractC0299q.m632h0(randomAccessFile, rect.left);
                AbstractC0299q.m632h0(randomAccessFile, rect.top);
                AbstractC0299q.m632h0(randomAccessFile, rect.right);
                AbstractC0299q.m632h0(randomAccessFile, rect.bottom);
            }
        }
        int i15 = this.f8735C;
        if (i15 != 0) {
            AbstractC0299q.m632h0(randomAccessFile, i15);
            this.f8742c |= 512;
        }
        int size3 = linkedHashMap.size();
        if (size3 > 0) {
            this.f8742c |= 1024;
            AbstractC0299q.m632h0(randomAccessFile, size3);
            AbstractC0299q.m636j0(randomAccessFile, 49);
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iIntValue = ((Integer) entry.getKey()).intValue();
                C12009s c12009s = (C12009s) entry.getValue();
                AbstractC0299q.m632h0(randomAccessFile, iIntValue);
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8720a);
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8721b);
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8722c);
                randomAccessFile.write((byte) ((c12009s.f8723d ? 1 : 0) & 255));
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8724e);
                for (int i16 = 0; i16 < 3; i16++) {
                    AbstractC0299q.m632h0(randomAccessFile, c12009s.f8725f[i16]);
                }
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8726g);
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8727h);
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8728i);
                AbstractC0299q.m632h0(randomAccessFile, c12009s.f8729j);
            }
        }
        int i17 = this.f8737E;
        if (i17 != 0) {
            AbstractC0299q.m632h0(randomAccessFile, i17);
            this.f8742c |= 2048;
        }
        int size4 = this.f8739G.size();
        if (size4 > 0) {
            this.f8742c |= 262144;
            AbstractC0299q.m632h0(randomAccessFile, size4);
            int i18 = 0;
            while (i18 < size4) {
                C12964v c12964v = (C12964v) this.f8739G.get(i18);
                int i19 = c12964v.f9262b;
                C12966x c12966x = c12964v.f9261a;
                AbstractC0299q.m632h0(randomAccessFile, i19);
                c12966x.getClass();
                int iM2212c = 51;
                for (Map.Entry entry2 : c12964v.f9264d.entrySet()) {
                    if (((Integer) entry2.getValue()).intValue() != i9) {
                        iM2212c = AbstractC2821a.m2212c(iM2212c + 4, i7, (String) entry2.getKey());
                    }
                }
                int iM2212c2 = iM2212c + 4;
                for (Map.Entry entry3 : c12964v.f9265e.entrySet()) {
                    if (((String) entry3.getKey()).length() != 0 && ((String) entry3.getValue()).length() != 0) {
                        iM2212c2 = AbstractC2821a.m2212c(iM2212c2 + 4, i7, (String) entry3.getKey()) + ((String) entry3.getValue()).length();
                    }
                }
                int i20 = iM2212c2 + 32;
                AbstractC0299q.m632h0(randomAccessFile, i20);
                long filePointer2 = randomAccessFile.getFilePointer();
                C12020a c12020a = new C12020a(12, (byte) 0);
                c12020a.m13631J(i20);
                int iM13871b = c12966x.m13871b(c12020a, 9);
                int i21 = iM13871b + 9;
                int size5 = c12964v.f9264d.size();
                c12020a.m13649v(i21, size5);
                int i22 = iM13871b + 13;
                int i23 = i7;
                int i24 = i6;
                for (Map.Entry entry4 : c12964v.f9264d.entrySet()) {
                    if (((Integer) entry4.getValue()).intValue() != i9) {
                        c12020a.m13649v(i22, ((String) entry4.getKey()).length());
                        int i25 = i22 + 4;
                        int iM13625D = c12020a.m13625D(i25, ((String) entry4.getKey()).toString()) + i25;
                        c12020a.m13649v(iM13625D, ((Integer) entry4.getValue()).intValue());
                        i22 = iM13625D + 4;
                        i24++;
                    }
                }
                if (size5 != i24) {
                    c12020a.m13649v(i21, i24);
                }
                int size6 = c12964v.f9265e.size();
                c12020a.m13649v(i22, size6);
                int iM13625D2 = i22 + 4;
                int i26 = 0;
                for (Map.Entry entry5 : c12964v.f9265e.entrySet()) {
                    if (!((String) entry5.getKey()).isEmpty() && !((String) entry5.getValue()).isEmpty()) {
                        c12020a.m13649v(iM13625D2, ((String) entry5.getKey()).length());
                        int i27 = iM13625D2 + 4;
                        int iM13625D3 = c12020a.m13625D(i27, ((String) entry5.getKey()).toString()) + i27;
                        c12020a.m13649v(iM13625D3, ((String) entry5.getValue()).length());
                        int i28 = iM13625D3 + 4;
                        iM13625D2 = c12020a.m13625D(i28, ((String) entry5.getValue()).toString()) + i28;
                        i26++;
                    }
                }
                if (size6 != i26) {
                    c12020a.m13649v(i22, i26);
                }
                c12020a.m13622A(iM13625D2, new SpenRectD(c12964v.f9263c));
                c12020a.m13649v(0, 0);
                c12020a.m13646s(i23, 1);
                c12020a.m13646s(5, 0);
                c12020a.m13646s(6, 2);
                c12020a.m13647t(7, 0);
                randomAccessFile.write(((ByteBuffer) c12020a.f8772b).array(), 0, i20);
                randomAccessFile.seek(filePointer2 + ((long) i20));
                i18++;
                i6 = 0;
                i7 = 4;
                i9 = -1;
            }
        }
        int i29 = 2;
        long filePointer3 = randomAccessFile.getFilePointer();
        randomAccessFile.seek(0L);
        AbstractC0299q.m632h0(randomAccessFile, (int) filePointer3);
        AbstractC0299q.m632h0(randomAccessFile, (int) filePointer);
        byte b = (byte) 4;
        randomAccessFile.write(b);
        AbstractC0299q.m632h0(randomAccessFile, this.f8743d);
        randomAccessFile.write(b);
        AbstractC0299q.m632h0(randomAccessFile, this.f8742c);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        randomAccessFile.seek(filePointer3);
        int size7 = this.f8761v.size();
        AbstractC0299q.m636j0(randomAccessFile, this.f8761v.size());
        AbstractC0299q.m636j0(randomAccessFile, this.f8762w);
        int i30 = 0;
        while (i30 < size7) {
            C11992b c11992b = (C11992b) this.f8761v.get(i30);
            c11992b.getClass();
            long filePointer4 = randomAccessFile.getFilePointer();
            if (filePointer4 < 0) {
                throw new IOException("writeWDoc() - invalid file pointer");
            }
            randomAccessFile.seek(((long) 12) + filePointer4);
            int i31 = c11992b.f8622a ? i29 : 0;
            if (!c11992b.f8623b) {
                i31 |= 1;
            }
            if (c11992b.f8632k) {
                i31 |= 4;
            }
            AbstractC0299q.m632h0(randomAccessFile, c11992b.f8624c);
            long filePointer5 = randomAccessFile.getFilePointer();
            int i32 = c11992b.f8625d;
            int i33 = size7;
            if (i32 != 255) {
                AbstractC0299q.m632h0(randomAccessFile, i32);
                i = 1;
            } else {
                i = 0;
            }
            int i34 = c11992b.f8626e;
            int i35 = i;
            if (i34 != -1) {
                i2 = i35 | 2;
                AbstractC0299q.m632h0(randomAccessFile, i34);
            } else {
                i2 = i35;
            }
            String str2 = c11992b.f8627f;
            if (str2 != null) {
                i2 |= 4;
                AbstractC0299q.m640l0(randomAccessFile, str2);
            }
            String str3 = c11992b.f8628g;
            if (str3 != null) {
                i2 |= 8;
                AbstractC0299q.m640l0(randomAccessFile, str3);
            }
            int i36 = i2 | 16;
            int i37 = i2;
            AbstractC0299q.m634i0(randomAccessFile, c11992b.f8630i);
            int i38 = c11992b.f8633l;
            if (i38 != -1) {
                AbstractC0299q.m632h0(randomAccessFile, i38);
                i4 = i37 | 48;
            } else {
                i4 = i36;
            }
            int i39 = i30;
            Debugger.m8607d("WCon_Layer", "save - id = [" + c11992b.f8628g + "], mt = [" + c11992b.f8630i + "]");
            ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
            long filePointer6 = randomAccessFile.getFilePointer();
            randomAccessFile.seek(filePointer4);
            AbstractC0299q.m632h0(randomAccessFile, (int) (filePointer6 - filePointer4));
            AbstractC0299q.m632h0(randomAccessFile, (int) filePointer5);
            byte b5 = (byte) 1;
            randomAccessFile.write(b5);
            randomAccessFile.write((byte) (i31 & 255));
            randomAccessFile.write(b5);
            randomAccessFile.write((byte) (i4 & 255));
            randomAccessFile.seek(filePointer6);
            C14433b c14433b = new C14433b(11, false);
            c14433b.f10228b = new ByteArrayOutputStream();
            int size8 = c11992b.f8631j.size();
            AbstractC0299q.m632h0(randomAccessFile, size8);
            Log.d("WCon_Layer", "writeWDoc    >>>    object count = [" + size8 + "]");
            C12020a c12020a2 = new C12020a(12, (byte) 0);
            for (int i40 = 0; i40 < size8; i40 = i5 + 1) {
                AbstractC12916b abstractC12916b = (AbstractC12916b) c11992b.f8631j.get(i40);
                int iMo13807g = abstractC12916b.mo13807g();
                Log.d("WCon_Layer", AbstractC0622a.m1164j(i40, iMo13807g, "writeWDoc    >>>    object - index = [", "], type = [", "]"));
                if (iMo13807g == 100) {
                    Log.d("WCon_Layer", "writeWDoc    >>>    SKIP WRITE TYPE = [" + iMo13807g + "]");
                    i5 = i40;
                } else {
                    randomAccessFile.write((byte) (iMo13807g & 255));
                    StringBuilder sb = new StringBuilder("writeWDoc    >>>    object - raf = [");
                    i5 = i40;
                    sb.append(randomAccessFile.getFilePointer());
                    sb.append("]");
                    Log.d("WCon_Layer", sb.toString());
                    if (iMo13807g == 4) {
                        C11992b.m13588j(randomAccessFile, c12020a2, (C12918d) abstractC12916b, c14433b);
                    } else {
                        C11992b.m13587i(randomAccessFile, c12020a2, abstractC12916b, 0, c14433b);
                    }
                }
            }
            Debugger.printMemory("WCon_Layer", "[CurrentMemoryState] Writing the strokes in a layer to file");
            c11992b.f8631j.clear();
            byte[] bArrM15031l = C14433b.m15031l(c11992b.f8628g + c11992b.f8630i);
            if (bArrM15031l == null) {
                throw new IOException("writeWDoc() - layerDataHash is null");
            }
            ((ByteArrayOutputStream) c14433b.f10228b).write(bArrM15031l);
            ByteArrayOutputStream byteArrayOutputStream4 = (ByteArrayOutputStream) c14433b.f10228b;
            try {
                byte[] byteArray = byteArrayOutputStream4.toByteArray();
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(byteArray);
                byte[] bArrDigest = messageDigest.digest();
                C13573a c13573a3 = new C13573a(11, false);
                c13573a3.m14387i(bArrDigest);
                byteArrayOutputStream4.reset();
                c13573a2 = c13573a3;
            } catch (NoSuchAlgorithmException unused) {
                c13573a2 = null;
            }
            if (c13573a2 == null) {
                throw new IOException("writeWDoc() - layerHash block is null");
            }
            byte[] bArr = (byte[]) c13573a2.f9635b;
            c11992b.f8635n = bArr;
            randomAccessFile.write(bArr);
            Log.d("WCon_Layer", "writeWDoc - layer Hash = [" + c11992b.m13592e() + "]");
            byte[] bArr2 = c11992b.f8635n;
            if (bArr2 != null) {
                byteArrayOutputStream = byteArrayOutputStream3;
                byteArrayOutputStream.write(bArr2);
            } else {
                byteArrayOutputStream = byteArrayOutputStream3;
                Log.e("WCon_WDocHashGenerator", "appendChildHash fail : hashByte is null.");
            }
            i30 = i39 + 1;
            byteArrayOutputStream2 = byteArrayOutputStream;
            size7 = i33;
            i29 = 2;
        }
        ByteArrayOutputStream byteArrayOutputStream5 = byteArrayOutputStream2;
        byte[] bArrM15031l2 = C14433b.m15031l(this.f8744e + this.f8760u);
        if (bArrM15031l2 != null) {
            byteArrayOutputStream5.write(bArrM15031l2);
        } else {
            Log.e("WCon_WDocHashGenerator", "appendChildHash fail : hashByte is null.");
        }
        try {
            byte[] byteArray2 = byteArrayOutputStream5.toByteArray();
            MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
            messageDigest2.update(byteArray2);
            byte[] bArrDigest2 = messageDigest2.digest();
            C13573a c13573a4 = new C13573a(11, false);
            c13573a4.m14387i(bArrDigest2);
            byteArrayOutputStream5.reset();
            c13573a = c13573a4;
        } catch (NoSuchAlgorithmException unused2) {
            c13573a = null;
        }
        if (c13573a != null) {
            byte[] bArr3 = (byte[]) c13573a.f9635b;
            this.f8757r = bArr3;
            randomAccessFile.write(bArr3);
        }
        Log.d("WCon_Page", "writePage - page Hash = [" + m13611e() + "]");
        AbstractC0299q.m638k0(randomAccessFile, "Page for SAMSUNG S-Pen SDK");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C12011u) {
            return VariableComparator.compare(this, (C12011u) obj, "WCon_Page");
        }
        return false;
    }
}
