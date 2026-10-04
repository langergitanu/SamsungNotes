package p182g0;

import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.adobe.internal.xmp.XMPConst;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p191j0.AbstractC12916b;
import p191j0.C12920f;
import p194k0.C12956n;
import p194k0.C12959q;
import p194k0.C12960r;
import p194k0.C12967y;
import p194k0.C12968z;
import p198l0.C13492a;
import p212o1.C13573a;

/* JADX INFO: renamed from: g0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11998h implements InterfaceC12019d, InterfaceC12017b, VariableComparator.Collector {

    /* JADX INFO: renamed from: A */
    public int f8643A;

    /* JADX INFO: renamed from: B */
    public int f8644B;

    /* JADX INFO: renamed from: C */
    public int f8645C;

    /* JADX INFO: renamed from: H */
    public int f8650H;

    /* JADX INFO: renamed from: I */
    public int f8651I;

    /* JADX INFO: renamed from: J */
    public String f8652J;

    /* JADX INFO: renamed from: K */
    public C12920f f8653K;

    /* JADX INFO: renamed from: L */
    public C12920f f8654L;

    /* JADX INFO: renamed from: N */
    public boolean f8656N;

    /* JADX INFO: renamed from: O */
    public boolean f8657O;

    /* JADX INFO: renamed from: R */
    public String f8660R;

    /* JADX INFO: renamed from: S */
    public long f8661S;

    /* JADX INFO: renamed from: T */
    public boolean f8662T;

    /* JADX INFO: renamed from: U */
    public long f8663U;

    /* JADX INFO: renamed from: V */
    public long f8664V;

    /* JADX INFO: renamed from: a */
    public final String f8669a;

    /* JADX INFO: renamed from: b */
    public String f8671b;

    /* JADX INFO: renamed from: c */
    public int f8673c;

    /* JADX INFO: renamed from: d */
    public int f8675d;

    /* JADX INFO: renamed from: f */
    public String f8679f;

    /* JADX INFO: renamed from: g */
    public String f8681g;

    /* JADX INFO: renamed from: g0 */
    public String f8682g0;

    /* JADX INFO: renamed from: h0 */
    public String f8684h0;

    /* JADX INFO: renamed from: i0 */
    public long f8686i0;

    /* JADX INFO: renamed from: j */
    public C11996f f8687j;

    /* JADX INFO: renamed from: j0 */
    public int f8688j0;

    /* JADX INFO: renamed from: k0 */
    public final C6906i f8690k0;

    /* JADX INFO: renamed from: s */
    public C12959q f8699s;

    /* JADX INFO: renamed from: u */
    public byte[] f8701u;

    /* JADX INFO: renamed from: v */
    public long f8702v;

    /* JADX INFO: renamed from: w */
    public long f8703w;

    /* JADX INFO: renamed from: x */
    public long f8704x;

    /* JADX INFO: renamed from: y */
    public int f8705y;

    /* JADX INFO: renamed from: z */
    public int f8706z;

    /* JADX INFO: renamed from: e */
    public String f8677e = "";

    /* JADX INFO: renamed from: h */
    public int f8683h = -1;

    /* JADX INFO: renamed from: i */
    public int f8685i = -1;

    /* JADX INFO: renamed from: k */
    public double f8689k = -1.0d;

    /* JADX INFO: renamed from: l */
    public double f8691l = -1.0d;

    /* JADX INFO: renamed from: m */
    public int f8693m = 0;

    /* JADX INFO: renamed from: n */
    public int f8694n = -1;

    /* JADX INFO: renamed from: o */
    public long f8695o = 0;

    /* JADX INFO: renamed from: p */
    public Map f8696p = new HashMap();

    /* JADX INFO: renamed from: q */
    public C11997g f8697q = new C11997g();

    /* JADX INFO: renamed from: r */
    public int f8698r = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: t */
    public ArrayList f8700t = new ArrayList();

    /* JADX INFO: renamed from: D */
    public int f8646D = SpenWNote.PageMode.LIST.ordinal();

    /* JADX INFO: renamed from: E */
    public int f8647E = SpenWNote.Orientation.PORTRAIT.ordinal();

    /* JADX INFO: renamed from: F */
    public int f8648F = SpenWNote.DocumentType.UNLOCKED_DOC.ordinal();

    /* JADX INFO: renamed from: G */
    public String f8649G = "";

    /* JADX INFO: renamed from: M */
    public boolean f8655M = true;

    /* JADX INFO: renamed from: P */
    public String f8658P = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL;

    /* JADX INFO: renamed from: Q */
    public String f8659Q = XMPConst.ARRAY_ITEM_NAME;

    /* JADX INFO: renamed from: W */
    public String f8665W = null;

    /* JADX INFO: renamed from: X */
    public long f8666X = 0;

    /* JADX INFO: renamed from: Y */
    public long f8667Y = -1;

    /* JADX INFO: renamed from: Z */
    public String f8668Z = "";

    /* JADX INFO: renamed from: a0 */
    public int f8670a0 = SpenWNote.TextDirection.TEXT_DIRECTION_DEFAULT.ordinal();

    /* JADX INFO: renamed from: b0 */
    public int f8672b0 = SpenWNote.BackgroundTheme.THEME_DEFAULT.ordinal();

    /* JADX INFO: renamed from: c0 */
    public String f8674c0 = "";

    /* JADX INFO: renamed from: d0 */
    public int f8676d0 = 0;

    /* JADX INFO: renamed from: e0 */
    public String f8678e0 = "";

    /* JADX INFO: renamed from: f0 */
    public ArrayList f8680f0 = null;

    /* JADX INFO: renamed from: l0 */
    public ArrayList f8692l0 = new ArrayList();

    public C11998h(C6906i c6906i) {
        this.f8690k0 = c6906i;
    }

    /* JADX INFO: renamed from: c */
    public static void m13596c(RandomAccessFile randomAccessFile, C12920f c12920f) throws IOException {
        long filePointer = randomAccessFile.getFilePointer();
        int iM606P = AbstractC0299q.m606P(randomAccessFile);
        byte[] bArr = new byte[iM606P];
        randomAccessFile.read(bArr);
        c12920f.mo13812l(new C12020a(bArr), 0, iM606P);
        randomAccessFile.seek(filePointer + 4 + ((long) iM606P));
    }

    /* JADX INFO: renamed from: d */
    public static void m13597d(RandomAccessFile randomAccessFile, C12920f c12920f) throws IOException {
        int iMo13814n = c12920f.mo13814n();
        AbstractC0299q.m632h0(randomAccessFile, iMo13814n);
        long filePointer = randomAccessFile.getFilePointer();
        C12020a c12020a = new C12020a(12, (byte) 0);
        c12020a.m13631J(iMo13814n);
        c12920f.mo13813m(c12020a, 0);
        randomAccessFile.write(((ByteBuffer) c12020a.f8772b).array(), 0, iMo13814n);
        randomAccessFile.seek(filePointer + ((long) iMo13814n));
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws SyncException, IOException {
        HashMap map;
        c6742k.m4852i("isBgColorInverted", this.f8655M);
        c6742k.m4848d(this.f8650H, DBSchema.DocumentExtra.FORMAT_VERSION);
        c6742k.m4848d(this.f8705y, "fileRevision");
        c6742k.m4850f("modifiedTime", this.f8704x);
        c6742k.m4850f("editTime", this.f8703w);
        c6742k.m4848d(this.f8706z, "width");
        c6742k.m4848d(this.f8643A, "height");
        c6742k.m4848d(this.f8644B, "pageHorizontalPadding");
        c6742k.m4848d(this.f8645C, "pageVerticalPadding");
        c6742k.m4848d(this.f8651I, "minFormatVersion");
        if (!TextUtils.isEmpty(this.f8652J)) {
            c6742k.m4853j("templateUri", this.f8652J);
        }
        c6742k.m4848d(this.f8693m, "lastEditedPageIndex");
        c6742k.m4848d(this.f8694n, "lastEditedPageImageId");
        c6742k.m4850f("lastEditedPageTime", this.f8695o);
        int i = this.f8698r;
        if (i != Integer.MIN_VALUE) {
            c6742k.m4848d(i, "bodyTextFontSizeDelta");
        }
        c6742k.m4848d(this.f8647E, "orientation");
        c6742k.m4848d(this.f8646D, DBSchema.Document.PAGE_MODE);
        c6742k.m4848d(this.f8648F, "documentType");
        c6742k.m4851h(GroupContract.Group.LEADER_ID, this.f8649G);
        c6742k.m4850f("lastRecognizedDataModifiedTime", this.f8666X);
        c6742k.m4851h("fixedFont", this.f8668Z);
        c6742k.m4848d(this.f8670a0, "fixedTextDirection");
        c6742k.m4848d(this.f8672b0, "fixedBackgroundTheme");
        if (!TextUtils.isEmpty(this.f8674c0)) {
            c6742k.m4853j("textSummarization", this.f8674c0);
        }
        int i2 = this.f8676d0;
        if (i2 > 0) {
            c6742k.m4848d(i2, "strokeGroupSize");
        }
        if (!TextUtils.isEmpty(this.f8678e0)) {
            c6742k.m4853j("AppCustomData", this.f8678e0);
        }
        c6742k.m4852i("isFavorite", this.f8657O);
        c6742k.m4851h("state", this.f8658P);
        c6742k.m4851h("bookmark", this.f8659Q);
        c6742k.m4851h("mappedUuid", this.f8660R);
        c6742k.m4850f(DBSchema.MappedDocument.MAPPED_AT, this.f8661S);
        c6742k.m4852i("isConverted", this.f8662T);
        c6742k.m4850f("displayCreatedTime", this.f8663U);
        c6742k.m4850f("displayModifiedTime", this.f8664V);
        String str = this.f8665W;
        if (str != null) {
            c6742k.m4853j("aiCover", str);
        }
        c6742k.m4851h(DBSchema.Document.MS_SYNC_ACCOUNT_ID, this.f8682g0);
        c6742k.m4851h("msSyncDocumentId", this.f8684h0);
        c6742k.m4850f(DBSchema.Document.MS_LAST_SYNC_TIME, this.f8686i0);
        c6742k.m4846F("title");
        c6742k.m4864v(CoeditServiceConstants.Element.NAME_OBJECT, this.f8653K);
        c6742k.m4856m("title");
        if (!TextUtils.isEmpty(this.f8679f) || this.f8683h != -1) {
            c6742k.m4846F("metaData");
            if (!TextUtils.isEmpty(this.f8679f)) {
                c6742k.m4853j("appName", this.f8679f);
            }
            int i4 = this.f8683h;
            if (i4 != -1) {
                c6742k.m4848d(i4, "appMajorVersion");
                c6742k.m4848d(this.f8685i, "appMinorVersion");
                c6742k.m4853j("appPatchName", this.f8681g);
            }
            c6742k.m4856m("metaData");
        }
        C11997g c11997g = this.f8697q;
        if (c11997g != null && (map = c11997g.f8640a) != null && !map.isEmpty()) {
            c6742k.m4846F("stringIdList");
            for (Integer num : this.f8697q.f8640a.keySet()) {
                int iIntValue = num.intValue();
                c6742k.m4846F("stringId");
                c6742k.m4848d(iIntValue, "id");
                c6742k.m4853j("text", (String) this.f8697q.f8640a.get(num));
                c6742k.m4856m("stringId");
            }
            c6742k.m4856m("stringIdList");
        }
        boolean z = false;
        if (this.f8699s != null) {
            c6742k.m4846F("penInfo");
            if (!TextUtils.isEmpty(this.f8699s.name)) {
                c6742k.m4853j("name", this.f8699s.name);
            }
            c6742k.m4849e("size", this.f8699s.size);
            c6742k.m4848d(this.f8699s.color, "color");
            c6742k.m4852i("isCurvable", this.f8699s.isCurvable);
            if (!TextUtils.isEmpty(this.f8699s.advancedSetting)) {
                c6742k.m4853j("advancedSetting", this.f8699s.advancedSetting);
            }
            c6742k.m4852i("isEraserEnabled", this.f8699s.isEraserEnabled);
            c6742k.m4848d(this.f8699s.sizeLevel, "sizeLevel");
            c6742k.m4848d(this.f8699s.particleDensity, "particleDensity");
            c6742k.m4849e("particleSize", this.f8699s.particleSize);
            c6742k.m4852i("isFixedWidth", this.f8699s.isFixedWidth);
            c6742k.m4849e("hsv0", this.f8699s.hsv[0]);
            c6742k.m4849e("hsv1", this.f8699s.hsv[1]);
            c6742k.m4849e("hsv2", this.f8699s.hsv[2]);
            c6742k.m4848d(this.f8699s.colorUIInfo, "colorUIInfo");
            c6742k.m4852i("isFixedOpacity", this.f8699s.isFixedOpacity);
            c6742k.m4852i("isAutoSizeEnabled", this.f8699s.isAutoSizeEnabled);
            c6742k.m4849e("fitRatio", this.f8699s.fitRatio);
            c6742k.m4856m("penInfo");
        }
        if (!this.f8700t.isEmpty()) {
            for (C12968z c12968z : this.f8700t) {
                if (c12968z.f9299a != -1 && !TextUtils.isEmpty(c12968z.f9300b) && !TextUtils.isEmpty(c12968z.f9301c) && c12968z.f9302d > 0) {
                    if (!z) {
                        c6742k.m4846F("voiceDataList");
                        z = true;
                    }
                    c12968z.mo47a(c6742k);
                }
            }
            if (z) {
                c6742k.m4856m("voiceDataList");
            }
        }
        if (!this.f8696p.isEmpty()) {
            c6742k.m4846F("attachedFileList");
            for (Map.Entry entry : this.f8696p.entrySet()) {
                String str2 = (String) entry.getKey();
                if (!TextUtils.isEmpty(str2)) {
                    c6742k.m4846F("attachedFile");
                    c6742k.m4867y("key", str2);
                    int iIntValue2 = ((Integer) entry.getValue()).intValue();
                    XmlSerializer xmlSerializer = (XmlSerializer) c6742k.f4110b;
                    xmlSerializer.startTag("", "attachedFileId");
                    xmlSerializer.attribute("", VElementFormulasCmd.FVAL, Integer.toString(iIntValue2));
                    xmlSerializer.endTag("", "attachedFileId");
                    c6742k.m4856m("attachedFile");
                }
            }
            c6742k.m4856m("attachedFileList");
        }
        ArrayList arrayList = this.f8680f0;
        if (arrayList != null) {
            c6742k.m4866x("tagList", "tag", arrayList);
        }
        c6742k.m4846F("mergedByServer");
        c6742k.m4848d(this.f8688j0, DBSchema.Document.MATH_MODE);
        c6742k.m4856m("mergedByServer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d9  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r5v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m13598b(RandomAccessFile randomAccessFile) throws IOException {
        ?? r16;
        int i;
        char c;
        int i2;
        int i4;
        float fIntBitsToFloat;
        int iM606P;
        int iM606P2;
        C12960r c12960r;
        randomAccessFile.seek(0L);
        int iM606P3 = AbstractC0299q.m606P(randomAccessFile);
        byte b = randomAccessFile.readByte();
        boolean z = true;
        if (b == 1) {
            this.f8673c = randomAccessFile.readByte();
        } else if (b == 4) {
            this.f8673c = AbstractC0299q.m606P(randomAccessFile);
        }
        this.f8655M = (this.f8673c & 8) != 0;
        byte b5 = randomAccessFile.readByte();
        int i5 = 2;
        if (b5 == 2) {
            this.f8675d = AbstractC0299q.m609S(randomAccessFile);
        } else if (b5 == 4) {
            this.f8675d = AbstractC0299q.m606P(randomAccessFile);
        }
        this.f8650H = AbstractC0299q.m606P(randomAccessFile);
        int i6 = -1;
        this.f8677e = AbstractC0299q.m611U(randomAccessFile, -1);
        this.f8705y = AbstractC0299q.m606P(randomAccessFile);
        this.f8702v = AbstractC0299q.m607Q(randomAccessFile);
        this.f8704x = AbstractC0299q.m607Q(randomAccessFile);
        this.f8706z = AbstractC0299q.m606P(randomAccessFile);
        this.f8643A = AbstractC0299q.m606P(randomAccessFile);
        this.f8644B = AbstractC0299q.m606P(randomAccessFile);
        this.f8645C = AbstractC0299q.m606P(randomAccessFile);
        this.f8651I = AbstractC0299q.m606P(randomAccessFile);
        int i7 = 1;
        C6906i c6906i = this.f8690k0;
        this.f8653K = new C12920f(i5, c6906i, i7);
        this.f8654L = new C12920f(i5, c6906i, i7);
        m13596c(randomAccessFile, this.f8653K);
        m13596c(randomAccessFile, this.f8654L);
        StringBuilder sb = new StringBuilder("load - tt = [");
        C12956n c12956n = this.f8653K.f9082b0;
        sb.append(LoggerBase.getEncode((c12956n == null || (c12960r = c12956n.f9223e) == null) ? null : c12960r.f9243a));
        sb.append("]");
        LoggerBase.m7130i("WCon_WNote", sb.toString());
        LoggerBase.m7130i("WCon_WNote", "load - bodyText Hash = [" + this.f8654L.mo13809i() + "]");
        randomAccessFile.seek((long) iM606P3);
        if ((this.f8675d & 1) != 0) {
            String strM611U = AbstractC0299q.m611U(randomAccessFile, 1024);
            this.f8679f = strM611U;
            if (strM611U == null) {
                this.f8679f = "";
            }
        }
        if ((this.f8675d & 2) != 0) {
            this.f8683h = AbstractC0299q.m606P(randomAccessFile);
            this.f8685i = AbstractC0299q.m606P(randomAccessFile);
            this.f8681g = AbstractC0299q.m611U(randomAccessFile, -1);
        }
        if ((this.f8675d & 4) != 0) {
            C11996f c11996f = new C11996f();
            c11996f.f8639d = -1;
            this.f8687j = c11996f;
            c11996f.f8636a = AbstractC0299q.m611U(randomAccessFile, 1024);
            this.f8687j.f8637b = AbstractC0299q.m611U(randomAccessFile, 1024);
            this.f8687j.f8638c = AbstractC0299q.m611U(randomAccessFile, 1024);
            this.f8687j.f8639d = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8675d & 8) != 0) {
            this.f8689k = Double.longBitsToDouble(AbstractC0299q.m607Q(randomAccessFile));
            this.f8691l = Double.longBitsToDouble(AbstractC0299q.m607Q(randomAccessFile));
        }
        if ((this.f8675d & 64) != 0) {
            this.f8652J = AbstractC0299q.m611U(randomAccessFile, 1024);
        } else {
            this.f8652J = null;
        }
        if ((this.f8675d & 128) != 0) {
            this.f8693m = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8675d & 512) != 0) {
            this.f8694n = AbstractC0299q.m606P(randomAccessFile);
            this.f8695o = AbstractC0299q.m607Q(randomAccessFile);
        }
        C11997g c11997g = this.f8697q;
        c11997g.f8640a.clear();
        c11997g.f8641b.clear();
        if ((this.f8675d & 1024) == 0 || AbstractC0299q.m606P(randomAccessFile) <= 0) {
            r16 = 1;
            i = 0;
        } else {
            C11997g c11997g2 = this.f8697q;
            c11997g2.getClass();
            int iM609S = AbstractC0299q.m609S(randomAccessFile);
            if (iM609S > 0) {
                int i8 = 0;
                int iM606P4 = 0;
                while (i8 < iM609S) {
                    iM606P4 = AbstractC0299q.m606P(randomAccessFile);
                    c11997g2.f8640a.put(Integer.valueOf(iM606P4), AbstractC0299q.m611U(randomAccessFile, -1));
                    c11997g2.f8641b.put(Integer.valueOf(iM606P4), 0);
                    i8++;
                    z = z;
                }
                r16 = z;
                i = 0;
                c11997g2.f8642c = iM606P4 + 1;
            }
        }
        if ((this.f8675d & 2048) != 0) {
            this.f8698r = AbstractC0299q.m606P(randomAccessFile);
        }
        this.f8699s = null;
        if ((this.f8675d & 4096) != 0) {
            String strM611U2 = AbstractC0299q.m611U(randomAccessFile, -1);
            float fIntBitsToFloat2 = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            int iM606P5 = AbstractC0299q.m606P(randomAccessFile);
            int iM606P6 = AbstractC0299q.m606P(randomAccessFile);
            String strM611U3 = AbstractC0299q.m611U(randomAccessFile, -1);
            int iM606P7 = AbstractC0299q.m606P(randomAccessFile);
            i2 = 32768;
            int iM606P8 = AbstractC0299q.m606P(randomAccessFile);
            c = 2;
            int iM606P9 = AbstractC0299q.m606P(randomAccessFile);
            float[] fArr = new float[3];
            for (int i9 = i; i9 < 3; i9++) {
                fArr[i9] = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            }
            int iM606P10 = AbstractC0299q.m606P(randomAccessFile);
            if ((this.f8675d & 32768) == 0) {
                C12959q c12959q = new C12959q();
                this.f8699s = c12959q;
                c12959q.name = strM611U2;
                c12959q.size = fIntBitsToFloat2;
                c12959q.color = iM606P5;
                c12959q.isCurvable = iM606P6 != 0 ? r16 : i;
                c12959q.advancedSetting = strM611U3;
                c12959q.isEraserEnabled = iM606P7 != 0 ? r16 : i;
                c12959q.sizeLevel = iM606P8;
                c12959q.particleDensity = iM606P9;
                float[] fArr2 = c12959q.hsv;
                fArr2[i] = fArr[i];
                fArr2[r16] = fArr[r16];
                fArr2[2] = fArr[2];
                c12959q.colorUIInfo = iM606P10;
            }
        } else {
            c = 2;
            i2 = 32768;
        }
        this.f8700t.clear();
        if ((this.f8675d & 8192) != 0) {
            int iM606P11 = AbstractC0299q.m606P(randomAccessFile);
            int i10 = i;
            while (i10 < iM606P11) {
                C12968z c12968z = new C12968z(c6906i);
                int iM606P12 = AbstractC0299q.m606P(randomAccessFile);
                long filePointer = randomAccessFile.getFilePointer();
                c12968z.f9299a = AbstractC0299q.m606P(randomAccessFile);
                c12968z.f9300b = AbstractC0299q.m611U(randomAccessFile, i6);
                c12968z.f9301c = AbstractC0299q.m611U(randomAccessFile, i6);
                c12968z.f9302d = AbstractC0299q.m607Q(randomAccessFile);
                int iM606P13 = AbstractC0299q.m606P(randomAccessFile);
                if (iM606P13 > 0) {
                    int i11 = i;
                    while (i11 < iM606P13) {
                        C12967y c12967y = new C12967y();
                        c12967y.f9297a = AbstractC0299q.m606P(randomAccessFile);
                        c12967y.f9298b = AbstractC0299q.m607Q(randomAccessFile);
                        c12968z.f9305g.add(c12967y);
                        i11++;
                        i10 = i10;
                    }
                }
                int i12 = i10;
                if (randomAccessFile.getFilePointer() - filePointer < iM606P12) {
                    c12968z.f9303e = AbstractC0299q.m607Q(randomAccessFile);
                }
                this.f8700t.add(c12968z);
                i10 = i12 + 1;
                i6 = -1;
            }
        }
        this.f8696p.clear();
        if ((this.f8675d & 16384) != 0) {
            int iM609S2 = AbstractC0299q.m609S(randomAccessFile);
            for (int i13 = i; i13 < iM609S2; i13++) {
                this.f8696p.put(AbstractC0299q.m611U(randomAccessFile, -1), Integer.valueOf(AbstractC0299q.m606P(randomAccessFile)));
            }
        }
        this.f8699s = null;
        if ((this.f8675d & i2) != 0) {
            long filePointer2 = randomAccessFile.getFilePointer();
            int iM606P14 = AbstractC0299q.m606P(randomAccessFile);
            String strM611U4 = AbstractC0299q.m611U(randomAccessFile, -1);
            float fIntBitsToFloat3 = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            int iM606P15 = AbstractC0299q.m606P(randomAccessFile);
            int iM606P16 = AbstractC0299q.m606P(randomAccessFile);
            String strM611U5 = AbstractC0299q.m611U(randomAccessFile, -1);
            int iM606P17 = AbstractC0299q.m606P(randomAccessFile);
            int iM606P18 = AbstractC0299q.m606P(randomAccessFile);
            int iM606P19 = AbstractC0299q.m606P(randomAccessFile);
            float fIntBitsToFloat4 = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            int iM606P20 = AbstractC0299q.m606P(randomAccessFile);
            float[] fArr3 = new float[3];
            for (int i14 = i; i14 < 3; i14++) {
                fArr3[i14] = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            }
            int iM606P21 = AbstractC0299q.m606P(randomAccessFile);
            long j = filePointer2 + ((long) iM606P14);
            if (randomAccessFile.getFilePointer() < j) {
                iM606P = AbstractC0299q.m606P(randomAccessFile);
                iM606P2 = AbstractC0299q.m606P(randomAccessFile);
                i4 = iM606P16;
                fIntBitsToFloat = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            } else {
                i4 = iM606P16;
                fIntBitsToFloat = 1.0f;
                iM606P = i;
                iM606P2 = iM606P;
            }
            C12959q c12959q2 = new C12959q();
            this.f8699s = c12959q2;
            c12959q2.name = strM611U4;
            c12959q2.size = fIntBitsToFloat3;
            c12959q2.color = iM606P15;
            c12959q2.isCurvable = i4 != 0 ? r16 : i;
            c12959q2.advancedSetting = strM611U5;
            c12959q2.isEraserEnabled = iM606P17 != 0 ? r16 : i;
            c12959q2.sizeLevel = iM606P18;
            c12959q2.particleDensity = iM606P19;
            c12959q2.particleSize = fIntBitsToFloat4;
            c12959q2.isFixedWidth = iM606P20 != 0 ? r16 : i;
            float[] fArr4 = c12959q2.hsv;
            fArr4[i] = fArr3[i];
            fArr4[r16] = fArr3[r16];
            fArr4[c] = fArr3[c];
            c12959q2.colorUIInfo = iM606P21;
            c12959q2.isFixedOpacity = iM606P != 0 ? r16 : i;
            c12959q2.isAutoSizeEnabled = iM606P2 != 0 ? r16 : i;
            c12959q2.fitRatio = fIntBitsToFloat;
            randomAccessFile.seek(j);
        }
        if ((this.f8675d & 65536) != 0) {
            this.f8667Y = AbstractC0299q.m607Q(randomAccessFile);
        }
        if ((this.f8675d & 131072) != 0) {
            this.f8668Z = AbstractC0299q.m611U(randomAccessFile, 1024);
        }
        if ((this.f8675d & 262144) != 0) {
            this.f8670a0 = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8675d & 524288) != 0) {
            this.f8672b0 = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8675d & 1048576) != 0) {
            this.f8674c0 = AbstractC0299q.m611U(randomAccessFile, -1);
        }
        if ((this.f8675d & 2097152) != 0) {
            this.f8676d0 = AbstractC0299q.m606P(randomAccessFile);
        }
        if ((this.f8675d & 4194304) != 0) {
            this.f8678e0 = AbstractC0299q.m612V(randomAccessFile);
        }
        byte[] bArr = new byte[32];
        randomAccessFile.read(bArr);
        this.f8701u = bArr;
        LoggerBase.m7130i("WCon_WNote", "loadNote - w/h     = [" + this.f8706z + "], [" + this.f8643A + "]");
        LoggerBase.m7130i("WCon_WNote", "loadNote - ct/mt   = [" + this.f8702v + "], [" + this.f8704x + "]");
        LoggerBase.m7130i("WCon_WNote", "loadNote - dct/dmt = [" + this.f8663U + "], [" + this.f8664V + "]");
        LoggerBase.m7130i("WCon_WNote", "loadNote - ver     = [" + this.f8650H + "], [" + this.f8651I + "]");
        ArrayList<C13492a> arrayList = this.f8654L.f9082b0.f9223e.f9246d;
        if (arrayList != null) {
            for (C13492a c13492a : arrayList) {
                AbstractC12916b abstractC12916b = c13492a.f9460a;
                if (abstractC12916b == null) {
                    StringBuilder sb2 = new StringBuilder("fillBodyObjectList - bodyObject is null. span pos[");
                    sb2.append(c13492a.f9462c);
                    sb2.append("/");
                    throw new IOException(AbstractC2821a.m2223n(sb2, "]", c13492a.f9463d));
                }
                this.f8692l0.add(abstractC12916b);
            }
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Collector
    public final VariableComparator.List collectVariables() {
        return new VariableComparator.List().addVar(new VariableComparator.StringVar("mNoteID", this.f8677e)).addVar(new VariableComparator.StringVar("mAppName", this.f8679f)).addVar(new VariableComparator.StringVar("mAppPatchName", this.f8681g)).addVar(new VariableComparator.IntVar("mAppMajorVersion", this.f8683h)).addVar(new VariableComparator.IntVar("mAppMinorVersion", this.f8685i)).addVar(new VariableComparator.ComparisonVar("mAuthorInfo", this.f8687j)).addVar(new VariableComparator.ComparisonVar("mTitleObject", this.f8653K)).addVar(new VariableComparator.DoubleVar("mGeoLatitude", this.f8689k)).addVar(new VariableComparator.DoubleVar("mGeoLongitude", this.f8691l)).addVar(new VariableComparator.IntVar("mLastEditedPageIndex", this.f8693m)).addVar(new VariableComparator.IntVar("mLastEditedPageImageId", this.f8694n)).addVar(new VariableComparator.LongVar("mLastEditedPageTime", this.f8695o)).addVar(new C11993c("mAttachedFileMap", this.f8696p)).addVar(new VariableComparator.IntVar("mWidth", this.f8706z)).addVar(new VariableComparator.IntVar("mHeight", this.f8643A)).addVar(new VariableComparator.IntVar("mPageHorizontalPadding", this.f8644B)).addVar(new VariableComparator.IntVar("mPageVerticalPadding", this.f8645C)).addVar(new VariableComparator.ComparisonVar("mStringIDManager", this.f8697q)).addVar(new VariableComparator.IntVar("mBodyTextFontSizeDelta", this.f8698r)).addVar(new VariableComparator.ComparisonVar("mPenInfo", this.f8699s)).addVar(new C11994d("mVoiceDataList", this.f8700t)).addVar(new VariableComparator.BoolVar("mIsBgColorInverted", this.f8655M)).addVar(new C11995e("mBodyObjectList", this.f8692l0));
    }

    /* JADX INFO: renamed from: e */
    public final void m13599e(XmlPullParser xmlPullParser, int i) {
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equals("isBgColorInverted")) {
            this.f8655M = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equals(DBSchema.DocumentExtra.FORMAT_VERSION)) {
            this.f8650H = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("fileRevision")) {
            this.f8705y = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("modifiedTime")) {
            this.f8704x = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("editTime")) {
            this.f8703w = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("width")) {
            this.f8706z = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("height")) {
            this.f8643A = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("pageHorizontalPadding")) {
            this.f8644B = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("pageVerticalPadding")) {
            this.f8645C = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("minFormatVersion")) {
            this.f8651I = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("templateUri")) {
            this.f8652J = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("lastEditedPageIndex")) {
            this.f8693m = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("lastEditedPageImageId")) {
            this.f8694n = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("lastEditedPageTime")) {
            this.f8695o = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("bodyTextFontSizeDelta")) {
            this.f8698r = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("orientation")) {
            this.f8647E = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase(DBSchema.Document.PAGE_MODE)) {
            this.f8646D = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("documentType")) {
            this.f8648F = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase(GroupContract.Group.LEADER_ID)) {
            this.f8649G = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase("isFavorite")) {
            this.f8657O = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("state")) {
            this.f8658P = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase("bookmark")) {
            this.f8659Q = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase("mappedUuid")) {
            this.f8660R = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase(DBSchema.MappedDocument.MAPPED_AT)) {
            this.f8661S = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("isConverted")) {
            this.f8662T = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("displayCreatedTime")) {
            this.f8663U = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("displayModifiedTime")) {
            this.f8664V = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("lastRecognizedDataModifiedTime")) {
            this.f8666X = Long.parseLong(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("fixedFont")) {
            this.f8668Z = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase("fixedTextDirection")) {
            this.f8670a0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("fixedBackgroundTheme")) {
            this.f8672b0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("textSummarization")) {
            this.f8674c0 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("strokeGroupSize")) {
            this.f8676d0 = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase("AppCustomData")) {
            this.f8678e0 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (attributeName.equalsIgnoreCase(DBSchema.Document.MS_SYNC_ACCOUNT_ID)) {
            this.f8682g0 = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase("msSyncDocumentId")) {
            this.f8684h0 = xmlPullParser.getAttributeValue(i);
        } else if (attributeName.equalsIgnoreCase(DBSchema.Document.MS_LAST_SYNC_TIME)) {
            this.f8686i0 = Long.parseLong(xmlPullParser.getAttributeValue(i));
        } else if (attributeName.equalsIgnoreCase("aiCover")) {
            this.f8665W = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m13600f(RandomAccessFile randomAccessFile) throws SyncException, IOException {
        C13573a c13573a;
        int iM3193c;
        ArrayList<C13492a> arrayList;
        randomAccessFile.seek(14L);
        this.f8673c = 0;
        if (this.f8655M) {
            this.f8673c = 8;
        }
        AbstractC0299q.m632h0(randomAccessFile, this.f8650H);
        AbstractC0299q.m640l0(randomAccessFile, this.f8677e);
        AbstractC0299q.m632h0(randomAccessFile, this.f8705y);
        AbstractC0299q.m634i0(randomAccessFile, this.f8702v);
        AbstractC0299q.m634i0(randomAccessFile, this.f8704x);
        AbstractC0299q.m632h0(randomAccessFile, this.f8706z);
        AbstractC0299q.m632h0(randomAccessFile, this.f8643A);
        AbstractC0299q.m632h0(randomAccessFile, this.f8644B);
        AbstractC0299q.m632h0(randomAccessFile, this.f8645C);
        AbstractC0299q.m632h0(randomAccessFile, this.f8651I);
        if (this.f8692l0 != null && (arrayList = this.f8654L.f9082b0.f9223e.f9246d) != null) {
            HashMap map = new HashMap();
            for (AbstractC12916b abstractC12916b : this.f8692l0) {
                map.put(abstractC12916b.mo13811k(), abstractC12916b);
            }
            for (C13492a c13492a : arrayList) {
                String str = c13492a.f9461b;
                AbstractC12916b abstractC12916b2 = (AbstractC12916b) map.get(str);
                if (abstractC12916b2 == null) {
                    throw new SyncException(327, AbstractC0541b.m773o("setBodyObjectToObjectSpan - Fail to find object [", str, "]"));
                }
                c13492a.f9460a = abstractC12916b2;
            }
        }
        LoggerBase.m7130i("WCon_WNote", "save - title, mt = [" + this.f8653K.f8980K + "]");
        m13597d(randomAccessFile, this.f8653K);
        LoggerBase.m7130i("WCon_WNote", "save - body text, mt = [" + this.f8654L.f8980K + "]");
        m13597d(randomAccessFile, this.f8654L);
        LoggerBase.m7130i("WCon_WNote", "save - w/h     = [" + this.f8706z + "], [" + this.f8643A + "]");
        LoggerBase.m7130i("WCon_WNote", "save - ct/mt   = [" + this.f8702v + "], [" + this.f8704x + "]");
        LoggerBase.m7130i("WCon_WNote", "save - dct/dmt = [" + this.f8663U + "], [" + this.f8664V + "]");
        LoggerBase.m7130i("WCon_WNote", "save - ver     = [" + this.f8650H + "], [" + this.f8651I + "]");
        StringBuilder sb = new StringBuilder("save - bodyText Hash = [");
        sb.append(this.f8654L.mo13809i());
        sb.append("]");
        LoggerBase.m7130i("WCon_WNote", sb.toString());
        long filePointer = randomAccessFile.getFilePointer();
        this.f8675d = 0;
        String str2 = this.f8679f;
        if (str2 != null) {
            this.f8675d = 1;
            AbstractC0299q.m640l0(randomAccessFile, str2);
        }
        int i = this.f8683h;
        int i2 = 2;
        if (i != -1) {
            this.f8675d |= 2;
            AbstractC0299q.m632h0(randomAccessFile, i);
            AbstractC0299q.m632h0(randomAccessFile, this.f8685i);
            AbstractC0299q.m640l0(randomAccessFile, this.f8681g);
        }
        C11996f c11996f = this.f8687j;
        if (c11996f != null) {
            this.f8675d |= 4;
            AbstractC0299q.m640l0(randomAccessFile, c11996f.f8636a);
            AbstractC0299q.m640l0(randomAccessFile, this.f8687j.f8637b);
            AbstractC0299q.m640l0(randomAccessFile, this.f8687j.f8638c);
            AbstractC0299q.m632h0(randomAccessFile, this.f8687j.f8639d);
        }
        double d = this.f8689k;
        if (d != -1.0d) {
            this.f8675d |= 8;
            AbstractC0299q.m628f0(randomAccessFile, d);
            AbstractC0299q.m628f0(randomAccessFile, this.f8691l);
        }
        String str3 = this.f8652J;
        if (str3 != null && !str3.isEmpty()) {
            this.f8675d |= 64;
            AbstractC0299q.m640l0(randomAccessFile, this.f8652J);
        }
        this.f8675d |= 128;
        AbstractC0299q.m632h0(randomAccessFile, this.f8693m);
        this.f8675d |= 512;
        AbstractC0299q.m632h0(randomAccessFile, this.f8694n);
        AbstractC0299q.m634i0(randomAccessFile, this.f8695o);
        if (this.f8697q.f8640a.size() > 0) {
            HashMap map2 = this.f8697q.f8640a;
            if (map2.isEmpty()) {
                iM3193c = 0;
            } else {
                Iterator it = map2.values().iterator();
                iM3193c = 2;
                while (it.hasNext()) {
                    iM3193c = AbstractC4539a.m3193c(2, iM3193c + 6, (String) it.next());
                }
            }
            if (iM3193c > 0) {
                this.f8675d |= 1024;
                AbstractC0299q.m632h0(randomAccessFile, iM3193c);
                HashMap map3 = this.f8697q.f8640a;
                AbstractC0299q.m636j0(randomAccessFile, map3.size());
                for (Map.Entry entry : map3.entrySet()) {
                    AbstractC0299q.m632h0(randomAccessFile, ((Integer) entry.getKey()).intValue());
                    AbstractC0299q.m640l0(randomAccessFile, (String) entry.getValue());
                }
            }
        }
        int i4 = this.f8698r;
        if (i4 != Integer.MIN_VALUE) {
            this.f8675d |= 2048;
            AbstractC0299q.m632h0(randomAccessFile, i4);
        }
        C12959q c12959q = this.f8699s;
        if (c12959q != null) {
            this.f8675d |= 4096;
            AbstractC0299q.m640l0(randomAccessFile, c12959q.name);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.size);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.color);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isCurvable ? 1 : 0);
            AbstractC0299q.m640l0(randomAccessFile, this.f8699s.advancedSetting);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isEraserEnabled ? 1 : 0);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.sizeLevel);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.particleDensity);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.hsv[0]);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.hsv[1]);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.hsv[2]);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.colorUIInfo);
        }
        int size = this.f8700t.size();
        if (size > 0) {
            this.f8675d |= 8192;
            AbstractC0299q.m632h0(randomAccessFile, size);
            int i5 = 0;
            while (i5 < size) {
                C12968z c12968z = (C12968z) this.f8700t.get(i5);
                String str4 = c12968z.f9300b;
                ArrayList<C12967y> arrayList2 = c12968z.f9305g;
                AbstractC0299q.m632h0(randomAccessFile, (arrayList2.size() * 12) + (c12968z.f9301c.length() * i2) + i2 + AbstractC4539a.m3193c(i2, 6, str4) + 12 + 8);
                AbstractC0299q.m632h0(randomAccessFile, c12968z.f9299a);
                AbstractC0299q.m640l0(randomAccessFile, c12968z.f9300b);
                AbstractC0299q.m640l0(randomAccessFile, c12968z.f9301c);
                int i6 = i2;
                AbstractC0299q.m634i0(randomAccessFile, c12968z.f9302d);
                int size2 = arrayList2.size();
                AbstractC0299q.m632h0(randomAccessFile, size2);
                if (size2 > 0) {
                    for (C12967y c12967y : arrayList2) {
                        AbstractC0299q.m632h0(randomAccessFile, c12967y.f9297a);
                        AbstractC0299q.m634i0(randomAccessFile, c12967y.f9298b);
                        i6 = i6;
                    }
                }
                AbstractC0299q.m634i0(randomAccessFile, c12968z.f9303e);
                i5++;
                i2 = i6;
            }
        }
        int i7 = i2;
        int size3 = this.f8696p.size();
        if (size3 != 0) {
            this.f8675d |= 16384;
            AbstractC0299q.m636j0(randomAccessFile, size3);
            for (Map.Entry entry2 : this.f8696p.entrySet()) {
                String str5 = (String) entry2.getKey();
                if (!TextUtils.isEmpty(str5)) {
                    AbstractC0299q.m640l0(randomAccessFile, str5);
                    AbstractC0299q.m632h0(randomAccessFile, ((Integer) entry2.getValue()).intValue());
                }
            }
        }
        if (this.f8699s != null) {
            this.f8675d |= 32768;
            long filePointer2 = randomAccessFile.getFilePointer();
            AbstractC0299q.m632h0(randomAccessFile, 0);
            AbstractC0299q.m640l0(randomAccessFile, this.f8699s.name);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.size);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.color);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isCurvable ? 1 : 0);
            AbstractC0299q.m640l0(randomAccessFile, this.f8699s.advancedSetting);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isEraserEnabled ? 1 : 0);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.sizeLevel);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.particleDensity);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.particleSize);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isFixedWidth ? 1 : 0);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.hsv[0]);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.hsv[1]);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.hsv[i7]);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.colorUIInfo);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isFixedOpacity ? 1 : 0);
            AbstractC0299q.m632h0(randomAccessFile, this.f8699s.isAutoSizeEnabled ? 1 : 0);
            AbstractC0299q.m630g0(randomAccessFile, this.f8699s.fitRatio);
            long filePointer3 = randomAccessFile.getFilePointer();
            randomAccessFile.seek(filePointer2);
            AbstractC0299q.m632h0(randomAccessFile, (int) (filePointer3 - filePointer2));
            randomAccessFile.seek(filePointer3);
        }
        long j = this.f8667Y;
        if (j != -1) {
            this.f8675d |= 65536;
            AbstractC0299q.m634i0(randomAccessFile, j);
        }
        if (!this.f8668Z.isEmpty()) {
            this.f8675d |= 131072;
            AbstractC0299q.m640l0(randomAccessFile, this.f8668Z);
        }
        int i8 = this.f8670a0;
        if (i8 != -1) {
            this.f8675d |= 262144;
            AbstractC0299q.m632h0(randomAccessFile, i8);
        }
        int i9 = this.f8672b0;
        if (i9 != -1) {
            this.f8675d |= 524288;
            AbstractC0299q.m632h0(randomAccessFile, i9);
        }
        if (!this.f8674c0.isEmpty()) {
            this.f8675d |= 1048576;
            AbstractC0299q.m640l0(randomAccessFile, this.f8674c0);
        }
        int i10 = this.f8676d0;
        if (i10 > 0) {
            this.f8675d |= 2097152;
            AbstractC0299q.m632h0(randomAccessFile, i10);
        }
        if (!this.f8678e0.isEmpty()) {
            this.f8675d |= 4194304;
            AbstractC0299q.m642m0(randomAccessFile, this.f8678e0);
        }
        long filePointer4 = randomAccessFile.getFilePointer();
        randomAccessFile.seek(0L);
        AbstractC0299q.m632h0(randomAccessFile, (int) filePointer);
        byte b = (byte) 4;
        randomAccessFile.write(b);
        AbstractC0299q.m632h0(randomAccessFile, this.f8673c);
        randomAccessFile.write(b);
        AbstractC0299q.m632h0(randomAccessFile, this.f8675d);
        randomAccessFile.seek(0L);
        byte[] bArr = new byte[(int) filePointer4];
        randomAccessFile.read(bArr);
        randomAccessFile.seek(filePointer4);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            c13573a = new C13573a(11, false);
            c13573a.m14387i(bArrDigest);
        } catch (NoSuchAlgorithmException unused) {
            c13573a = null;
        }
        if (c13573a != null) {
            byte[] bArr2 = (byte[]) c13573a.f9635b;
            this.f8701u = bArr2;
            randomAccessFile.write(bArr2);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11998h) {
            return VariableComparator.compare(this, (C11998h) obj, "WCon_WNote");
        }
        return false;
    }

    public C11998h(String str, C6906i c6906i) {
        this.f8669a = str;
        this.f8690k0 = c6906i;
    }
}
