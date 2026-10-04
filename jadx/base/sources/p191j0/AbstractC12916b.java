package p191j0;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.base.SpenPointD;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.yubico.yubikit.core.fido.CtapException;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import okio.Utf8;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p178f0.C11979b;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12018c;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p194k0.C12963u;
import p194k0.C12966x;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: j0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12916b implements InterfaceC12019d, InterfaceC12018c, InterfaceC12017b, VariableComparator.Collector {

    /* JADX INFO: renamed from: A */
    public String f8970A;

    /* JADX INFO: renamed from: B */
    public final C12963u f8971B;

    /* JADX INFO: renamed from: C */
    public int f8972C;

    /* JADX INFO: renamed from: D */
    public String f8973D;

    /* JADX INFO: renamed from: E */
    public float f8974E;

    /* JADX INFO: renamed from: F */
    public float f8975F;

    /* JADX INFO: renamed from: G */
    public float f8976G;

    /* JADX INFO: renamed from: H */
    public float f8977H;

    /* JADX INFO: renamed from: I */
    public C12966x f8978I;

    /* JADX INFO: renamed from: J */
    public long f8979J;

    /* JADX INFO: renamed from: K */
    public long f8980K;

    /* JADX INFO: renamed from: L */
    public long f8981L;

    /* JADX INFO: renamed from: M */
    public int f8982M;

    /* JADX INFO: renamed from: O */
    public int f8984O;

    /* JADX INFO: renamed from: P */
    public final boolean f8985P;

    /* JADX INFO: renamed from: Q */
    public byte[] f8986Q;

    /* JADX INFO: renamed from: S */
    public final C6906i f8988S;

    /* JADX INFO: renamed from: T */
    public final C11979b f8989T;

    /* JADX INFO: renamed from: a */
    public int f8990a;

    /* JADX INFO: renamed from: b */
    public int f8991b;

    /* JADX INFO: renamed from: c */
    public boolean f8992c;

    /* JADX INFO: renamed from: d */
    public boolean f8993d;

    /* JADX INFO: renamed from: e */
    public boolean f8994e;

    /* JADX INFO: renamed from: f */
    public boolean f8995f;

    /* JADX INFO: renamed from: g */
    public boolean f8996g;

    /* JADX INFO: renamed from: h */
    public boolean f8997h;

    /* JADX INFO: renamed from: i */
    public boolean f8998i;

    /* JADX INFO: renamed from: j */
    public boolean f8999j;

    /* JADX INFO: renamed from: k */
    public boolean f9000k;

    /* JADX INFO: renamed from: l */
    public boolean f9001l;

    /* JADX INFO: renamed from: m */
    public int f9002m;

    /* JADX INFO: renamed from: n */
    public PointF f9003n;

    /* JADX INFO: renamed from: o */
    public boolean f9004o;

    /* JADX INFO: renamed from: q */
    public RectF f9006q;

    /* JADX INFO: renamed from: r */
    public int f9007r;

    /* JADX INFO: renamed from: s */
    public int f9008s;

    /* JADX INFO: renamed from: t */
    public int f9009t;

    /* JADX INFO: renamed from: u */
    public int f9010u;

    /* JADX INFO: renamed from: v */
    public int f9011v;

    /* JADX INFO: renamed from: w */
    public float f9012w;

    /* JADX INFO: renamed from: x */
    public int f9013x;

    /* JADX INFO: renamed from: y */
    public String f9014y;

    /* JADX INFO: renamed from: z */
    public final C12963u f9015z;

    /* JADX INFO: renamed from: p */
    public int f9005p = 0;

    /* JADX INFO: renamed from: N */
    public String f8983N = null;

    /* JADX INFO: renamed from: R */
    public boolean f8987R = false;

    public AbstractC12916b(int i, C6906i c6906i) {
        this.f8990a = i;
        this.f8988S = c6906i;
        this.f8989T = (C11979b) c6906i.f4483b;
        if (this.f8985P) {
            return;
        }
        this.f8982M = 0;
        this.f9008s = 0;
        this.f8972C = -1;
        this.f9009t = -1;
        this.f8997h = true;
        this.f8996g = true;
        this.f8992c = true;
        this.f8998i = true;
        this.f8993d = true;
        this.f8994e = true;
        this.f8995f = true;
        this.f9015z = new C12963u("sorBundle");
        this.f8971B = new C12963u("extraBundle");
        this.f8978I = new C12966x();
        this.f8985P = true;
        this.f9000k = true;
        this.f9001l = false;
        this.f9002m = -1;
        this.f9003n = new PointF(-3.4028235E38f, -3.4028235E38f);
        this.f9004o = true;
        this.f8984O = -1;
    }

    /* JADX INFO: renamed from: f */
    public static String m13803f(int i) {
        return (i == 1 || i == 15) ? "stroke" : i == 2 ? ExternalDataConstants.Column.TEXT_BOX : i == 3 ? "image" : i == 4 ? "container" : i == 7 ? VMetaDataKey.META_KEY_SHAPE : i == 8 ? "line" : i == 10 ? "voice" : i == 11 ? "formula" : i == 22 ? "tableNew" : i == 13 ? "web" : i == 14 ? ComposerCacheFileUtil.PAINTING_FOLDER_NAME : i == 17 ? "link" : i == 19 ? "unknown" : i == 21 ? "math" : i == 20 ? "plot" : i == 100 ? "strokeGroup" : i == 23 ? "codeBlock" : "none";
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws SyncException, IOException {
        if (this.f8983N != null) {
            StringBuilder sb = new StringBuilder("composeXml - id = [");
            sb.append(this.f8978I.f9296a);
            sb.append("], groupId = [");
            AbstractC4539a.m3209s(sb, this.f8983N, "]", "WCon_ObjectBase");
        }
        if (!AbstractC4539a.m3210t() || !NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b)) {
            mo13806e(c6742k);
            return;
        }
        C6742k c6742k2 = new C6742k(Xml.newSerializer());
        c6742k2.m4846F(CoeditServiceConstants.Element.NAME_OBJECT);
        mo13806e(c6742k2);
        c6742k2.m4856m(CoeditServiceConstants.Element.NAME_OBJECT);
        c6742k2.m4857n();
        try {
            c6742k.m4851h("type", m13803f(this.f8990a));
            C0158a.m407a().getClass();
            if (SyncState.isEdpMode()) {
                c6742k.m4851h("id", mo13811k());
            } else {
                c6742k.m4851h("id", this.f8978I.f9296a);
            }
            c6742k.m4851h("hash", mo13809i());
            c6742k.m4850f("modifiedTime", this.f8980K);
            if (this instanceof C12931q) {
                return;
            }
            c6742k.m4865w("encrypted", C0145c.m319d(((StringWriter) c6742k2.f4111c).toString()));
        } catch (Exception e) {
            Debugger.m8609e("WCon_ObjectBase", "composeEncryptedAttribute : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    @Override // p185h0.InterfaceC12018c
    /* JADX INFO: renamed from: b */
    public final boolean mo13589b(InterfaceC12018c interfaceC12018c, C6903f c6903f) {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public void mo13804c(C6742k c6742k) throws SyncException {
        try {
            c6742k.m4851h("type", m13803f(this.f8990a));
            c6742k.m4851h("id", this.f8978I.f9296a);
            c6742k.m4851h("hash", mo13809i());
            c6742k.m4848d(this.f9005p, DBSchema.DocumentExtra.FORMAT_VERSION);
            c6742k.m4852i("rotatable", this.f8992c);
            c6742k.m4852i("selectable", this.f8993d);
            c6742k.m4852i("movable", this.f8994e);
            c6742k.m4852i("flippable", this.f8995f);
            c6742k.m4852i("visible", this.f8996g);
            c6742k.m4852i("isReplayable", this.f8997h);
            c6742k.m4852i("clippable", this.f8998i);
            c6742k.m4852i("isTemplateObject", this.f8999j);
            c6742k.m4848d(this.f9007r, "timeStamp");
            c6742k.m4848d(this.f9008s, "resizable");
            c6742k.m4852i("haveBeenToAtt", this.f9000k);
            c6742k.m4852i("lockState", this.f9001l);
            float f = this.f9012w;
            if (f != 0.0f) {
                c6742k.m4849e("rotationDegree", f);
            }
            int i = this.f8972C;
            C11979b c11979b = this.f8989T;
            if (i != -1) {
                String strM13559e = c11979b.m13559e(i);
                this.f8973D = strM13559e;
                c6742k.m4851h("attachedFileId", strM13559e);
            }
            float f4 = this.f8974E;
            if (f4 != 0.0f || this.f8975F != 0.0f) {
                c6742k.m4849e("minWidth", f4);
                c6742k.m4849e("minHeight", this.f8975F);
            }
            float f5 = this.f8977H;
            if (f5 != 0.0f || this.f8976G != 0.0f) {
                c6742k.m4849e("maxWidth", f5);
                c6742k.m4849e("maxHeight", this.f8976G);
            }
            c6742k.m4850f(GroupContract.Group.CREATED_TIME, this.f8979J);
            c6742k.m4850f("modifiedTime", this.f8980K);
            long j = this.f8981L;
            if (j != 0) {
                c6742k.m4850f("appendTime", j);
            }
            int i2 = this.f9010u;
            if (i2 != 0 || this.f9011v != 0) {
                c6742k.m4848d(i2, "ownerPageWidth");
                c6742k.m4848d(this.f9011v, "ownerPageHeight");
            }
            String str = this.f9014y;
            if (str != null) {
                c6742k.m4853j("aoInfo", str);
            }
            String str2 = this.f8970A;
            if (str2 != null) {
                c6742k.m4853j("plugInLink", str2);
            }
            int i4 = this.f8982M;
            if (i4 != 0) {
                c6742k.m4848d(i4, "layoutType");
            }
            int i5 = this.f9002m;
            if (i5 >= 0) {
                c6742k.m4851h("thumbnailHash", c11979b.m13559e(i5));
            }
            String str3 = this.f8983N;
            if (str3 != null) {
                c6742k.m4853j("groupId", str3);
            }
            c6742k.m4852i("removable", this.f9004o);
            int i6 = this.f8984O;
            if (i6 >= 0) {
                c6742k.m4848d(i6, "pageIndex");
            }
        } catch (Exception e) {
            Debugger.m8609e("WCon_ObjectBase", "composeAttribute : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Collector
    public final VariableComparator.List collectVariables() {
        return new VariableComparator.List().addVar(new VariableComparator.IntVar("type", this.f8990a)).addVar(new C12915a("loadFormatVersion", this.f9005p)).addVar(new VariableComparator.BoolVar("rotatable", this.f8992c)).addVar(new VariableComparator.BoolVar("selectable", this.f8993d)).addVar(new VariableComparator.BoolVar("movable", this.f8994e)).addVar(new VariableComparator.BoolVar("flippable", this.f8995f)).addVar(new VariableComparator.BoolVar("haveBeenToAtt", this.f9000k)).addVar(new VariableComparator.BoolVar("visible", this.f8996g)).addVar(new VariableComparator.BoolVar("isReplayable", this.f8997h)).addVar(new VariableComparator.BoolVar("clippable", this.f8998i)).addVar(new VariableComparator.BoolVar("isTemplateObject", this.f8999j)).addVar(new VariableComparator.RectVar("rect", this.f9006q)).addVar(new VariableComparator.IntVar("timeStamp", this.f9007r)).addVar(new VariableComparator.IntVar("resizable", this.f9008s)).addVar(new VariableComparator.FloatVar("rotationDegree", this.f9012w)).addVar(new VariableComparator.StringVar("aoInfo", this.f9014y)).addVar(new VariableComparator.ComparisonVar("sorBundle", this.f9015z)).addVar(new VariableComparator.StringVar("plugInLink", this.f8970A)).addVar(new VariableComparator.ComparisonVar("extraBundle", this.f8971B)).addVar(new VariableComparator.IntVar("attachedFileId", this.f8972C)).addVar(new VariableComparator.StringVar("attachedFileHash", this.f8973D)).addVar(new VariableComparator.FloatVar("minWidth", this.f8974E)).addVar(new VariableComparator.FloatVar("minHeight", this.f8975F)).addVar(new VariableComparator.FloatVar("maxWidth", this.f8977H)).addVar(new VariableComparator.FloatVar("maxHeight", this.f8976G)).addVar(new VariableComparator.ComparisonVar("uuid", this.f8978I)).addVar(new VariableComparator.LongVar(GroupContract.Group.CREATED_TIME, this.f8979J)).addVar(new VariableComparator.LongVar("modifiedTime", this.f8980K)).addVar(new VariableComparator.LongVar("appendTime", this.f8981L)).addVar(new VariableComparator.IntVar("ownerPageWidth", this.f9010u)).addVar(new VariableComparator.IntVar("ownerPageHeight", this.f9011v)).addVar(new VariableComparator.BoolVar("isInitialized", this.f8985P)).addVar(new VariableComparator.IntVar("layoutType", this.f8982M)).addVar(new VariableComparator.BoolVar("lockState", this.f9001l)).addVar(new VariableComparator.StringVar("groupId", this.f8983N)).addVar(new VariableComparator.BoolVar("removable", this.f9004o)).addVar(new VariableComparator.IntVar("pageIndex", this.f8984O));
    }

    /* JADX INFO: renamed from: d */
    public void mo13805d(C6742k c6742k) throws IOException {
        c6742k.m4845D("rect", this.f9006q);
        this.f8971B.mo47a(c6742k);
        this.f9015z.mo47a(c6742k);
        PointF pointF = this.f9003n;
        if (pointF.x == -3.4028235E38f && pointF.y == -3.4028235E38f) {
            return;
        }
        c6742k.m4843B(pointF, "pivot");
    }

    /* JADX INFO: renamed from: e */
    public void mo13806e(C6742k c6742k) throws SyncException, IOException {
        mo13804c(c6742k);
        mo13805d(c6742k);
    }

    /* JADX INFO: renamed from: g */
    public int mo13807g() {
        return this.f8990a;
    }

    /* JADX INFO: renamed from: h */
    public long mo13808h() {
        return this.f8980K;
    }

    /* JADX INFO: renamed from: i */
    public String mo13809i() {
        byte[] bArr = this.f8986Q;
        if (bArr != null && bArr.length > 0) {
            return C14433b.m15034q(bArr);
        }
        Debugger.m8607d("WCon_ObjectBase", this.f8978I + "'s hash is null");
        return "";
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractC12916b) {
            return VariableComparator.compare(this, (AbstractC12916b) obj, "WCon_ObjectBase");
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public C12966x mo13810j() {
        return this.f8978I;
    }

    /* JADX INFO: renamed from: k */
    public String mo13811k() {
        return this.f8978I.f9296a;
    }

    /* JADX INFO: renamed from: l */
    public int mo13812l(C12020a c12020a, int i, int i2) throws IOException {
        int i4 = ((ByteBuffer) c12020a.f8772b).getInt(i);
        short s = ((ByteBuffer) c12020a.f8772b).getShort(i + 4);
        int i5 = i + 6;
        if (s != 0) {
            throw new IOException(AbstractC0541b.m767i(s, "ApplyOwnBinary() - Invalid data type [", "]"));
        }
        int i6 = ((ByteBuffer) c12020a.f8772b).getInt(i5);
        int i7 = i + 10;
        int i8 = i + 11;
        byte b = ((ByteBuffer) c12020a.f8772b).get(i7);
        short s2 = ((ByteBuffer) c12020a.f8772b).getShort(i8);
        int i9 = i8 + b;
        this.f8997h = (s2 & 16) != 0;
        this.f8996g = (s2 & 8) != 0;
        this.f8998i = (s2 & 32) != 0;
        this.f8999j = (s2 & 64) != 0;
        this.f8992c = (s2 & 1) != 0;
        this.f8993d = (s2 & 2) != 0;
        this.f8994e = (s2 & 4) != 0;
        this.f8995f = (s2 & 128) != 0;
        this.f9000k = (s2 & Http2CodecUtil.MAX_WEIGHT) != 0;
        this.f9001l = (s2 & 512) != 0;
        this.f9004o = (s2 & 4096) == 0;
        int i10 = (i9 - i7) + i7;
        int i11 = i10 + 1;
        byte b5 = ((ByteBuffer) c12020a.f8772b).get(i10);
        int i12 = ((ByteBuffer) c12020a.f8772b).getInt(i11);
        int i13 = i11 + b5;
        int i14 = ((ByteBuffer) c12020a.f8772b).getInt(i13);
        this.f9005p = i14;
        int i15 = i13 + 4;
        if (i14 > 5400) {
            Log.w("WCon_ObjectBase", "ApplyOwnBinary() - unknown format version = [" + this.f9005p + "]");
            this.f9005p = 5400;
        }
        int iM13870a = this.f8978I.m13870a(c12020a, i15) + i15;
        this.f8980K = ((ByteBuffer) c12020a.f8772b).getLong(iM13870a);
        SpenRectD spenRectDM13642o = c12020a.m13642o(iM13870a + 8);
        this.f9006q = new RectF((float) spenRectDM13642o.left, (float) spenRectDM13642o.top, (float) spenRectDM13642o.right, (float) spenRectDM13642o.bottom);
        this.f9007r = ((ByteBuffer) c12020a.f8772b).getInt(iM13870a + 40);
        this.f9008s = ((ByteBuffer) c12020a.f8772b).get(iM13870a + 44);
        if (i6 != 0) {
            int iM13861b = i + i6;
            if ((i12 & 1) != 0) {
                this.f9012w = ((ByteBuffer) c12020a.f8772b).getFloat(iM13861b);
                iM13861b += 4;
            } else {
                this.f9012w = 0.0f;
            }
            if ((i12 & 2) != 0) {
                short s3 = ((ByteBuffer) c12020a.f8772b).getShort(iM13861b);
                this.f9013x = s3;
                iM13861b = iM13861b + 2 + (s3 * 16);
            }
            if ((i12 & 4) != 0) {
                short s4 = ((ByteBuffer) c12020a.f8772b).getShort(iM13861b);
                int i16 = iM13861b + 2;
                this.f9014y = c12020a.m13645r(i16, s4);
                iM13861b = i16 + (s4 * 2);
            } else {
                this.f9014y = null;
            }
            if ((i12 & 8) != 0) {
                iM13861b += this.f9015z.m13861b(c12020a, iM13861b);
            } else {
                this.f9015z.m13867i();
            }
            if ((i12 & 16) != 0) {
                short s5 = ((ByteBuffer) c12020a.f8772b).getShort(iM13861b);
                int i17 = iM13861b + 2;
                this.f8970A = c12020a.m13645r(i17, s5);
                iM13861b = i17 + (s5 * 2);
            } else {
                this.f8970A = null;
            }
            if ((i12 & 32) != 0) {
                iM13861b += this.f8971B.m13861b(c12020a, iM13861b);
            } else {
                this.f8971B.m13867i();
            }
            if ((i12 & 64) != 0) {
                this.f8972C = ((ByteBuffer) c12020a.f8772b).getInt(iM13861b);
                iM13861b += 4;
            } else {
                this.f8972C = -1;
            }
            if ((i12 & 128) != 0) {
                this.f8974E = ((ByteBuffer) c12020a.f8772b).getFloat(iM13861b);
                this.f8975F = ((ByteBuffer) c12020a.f8772b).getFloat(iM13861b + 4);
                iM13861b += 8;
            } else {
                this.f8974E = 0.0f;
                this.f8975F = 0.0f;
            }
            if ((i12 & 256) != 0) {
                this.f8977H = ((ByteBuffer) c12020a.f8772b).getFloat(iM13861b);
                this.f8976G = ((ByteBuffer) c12020a.f8772b).getFloat(iM13861b + 4);
                iM13861b += 8;
            } else {
                this.f8977H = 0.0f;
                this.f8976G = 0.0f;
            }
            if ((i12 & 8192) != 0) {
                this.f8981L = ((ByteBuffer) c12020a.f8772b).getLong(iM13861b);
                iM13861b += 8;
            } else {
                this.f8981L = 0L;
            }
            if ((i12 & 16384) != 0) {
                this.f9010u = ((ByteBuffer) c12020a.f8772b).getInt(iM13861b);
                this.f9011v = ((ByteBuffer) c12020a.f8772b).getInt(iM13861b + 4);
                iM13861b += 8;
            } else {
                this.f9010u = 0;
                this.f9011v = 0;
            }
            if ((32768 & i12) != 0) {
                this.f8982M = ((ByteBuffer) c12020a.f8772b).get(iM13861b);
                iM13861b++;
            } else {
                this.f8982M = 0;
            }
            if ((65536 & i12) != 0) {
                iM13861b += 20;
            }
            if ((131072 & i12) != 0) {
                this.f9002m = ((ByteBuffer) c12020a.f8772b).getInt(iM13861b);
                iM13861b += 4;
            }
            if ((262144 & i12) != 0) {
                SpenPointD spenPointDM13640m = c12020a.m13640m(iM13861b);
                PointF pointF = this.f9003n;
                pointF.x = (float) spenPointDM13640m.x;
                pointF.y = (float) spenPointDM13640m.y;
                iM13861b += 16;
            }
            if ((524288 & i12) != 0) {
                short s6 = ((ByteBuffer) c12020a.f8772b).getShort(iM13861b);
                int i18 = iM13861b + 2;
                this.f8983N = c12020a.m13645r(i18, s6);
                iM13861b = i18 + (s6 * 2);
            } else {
                this.f8983N = null;
            }
            if ((1048576 & i12) != 0) {
                this.f8984O = ((ByteBuffer) c12020a.f8772b).getInt(iM13861b);
            }
        }
        if (this.f8983N != null) {
            StringBuilder sb = new StringBuilder("applyOwnBinary - id = [");
            sb.append(this.f8978I.f9296a);
            sb.append("], groupId = [");
            AbstractC4539a.m3209s(sb, this.f8983N, "]", "WCon_ObjectBase");
        }
        m13820t();
        return i4;
    }

    /* JADX INFO: renamed from: m */
    public int mo13813m(C12020a c12020a, int i) {
        int i2 = i + 18;
        int i4 = 1;
        short s = this.f8992c ? (short) 1 : (short) 0;
        if (this.f8993d) {
            s = (short) (s | 2);
        }
        if (this.f8994e) {
            s = (short) (s | 4);
        }
        if (this.f8995f) {
            s = (short) (s | 128);
        }
        if (this.f8996g) {
            s = (short) (s | 8);
        }
        if (this.f8997h) {
            s = (short) (s | 16);
        }
        if (this.f8998i) {
            s = (short) (s | 32);
        }
        if (this.f8999j) {
            s = (short) (s | 64);
        }
        if (this.f9000k) {
            s = (short) (s | Http2CodecUtil.MAX_WEIGHT);
        }
        if (this.f9001l) {
            s = (short) (s | 512);
        }
        if (!this.f9004o) {
            s = (short) (s | 4096);
        }
        c12020a.m13649v(i2, this.f9005p);
        int i5 = i + 22;
        int iM13871b = this.f8978I.m13871b(c12020a, i5) + i5;
        ((ByteBuffer) c12020a.f8772b).putLong(iM13871b, this.f8980K);
        c12020a.m13622A(iM13871b + 8, new SpenRectD(this.f9006q));
        c12020a.m13649v(iM13871b + 40, this.f9007r);
        c12020a.m13646s(iM13871b + 44, this.f9008s);
        int iM13863d = iM13871b + 45;
        int i6 = iM13863d - i;
        float f = this.f9012w;
        if (f != 0.0f) {
            c12020a.m13648u(f, iM13863d);
            iM13863d = iM13871b + 49;
        } else {
            i4 = 0;
        }
        String str = this.f9014y;
        if (str != null) {
            int length = str.length();
            c12020a.m13647t(iM13863d, length);
            c12020a.m13626E(iM13863d + 2, this.f9014y);
            iM13863d += (length * 2) + 2;
            i4 |= 4;
        }
        if (!this.f9015z.m13865g()) {
            iM13863d += this.f9015z.m13863d(c12020a, iM13863d);
            i4 |= 8;
        }
        String str2 = this.f8970A;
        if (str2 != null) {
            int length2 = str2.length();
            c12020a.m13647t(iM13863d, length2);
            c12020a.m13626E(iM13863d + 2, this.f8970A);
            iM13863d += (length2 * 2) + 2;
            i4 |= 16;
        }
        if (!this.f8971B.m13865g()) {
            iM13863d += this.f8971B.m13863d(c12020a, iM13863d);
            i4 |= 32;
        }
        int i7 = this.f8972C;
        if (i7 != -1) {
            c12020a.m13649v(iM13863d, i7);
            iM13863d += 4;
            i4 |= 64;
        }
        if (this.f8975F != 0.0f || this.f8974E != 0.0f) {
            c12020a.m13648u(this.f8974E, iM13863d);
            c12020a.m13648u(this.f8975F, iM13863d + 4);
            iM13863d += 8;
            i4 |= 128;
        }
        if (this.f8976G != 0.0f || this.f8977H != 0.0f) {
            c12020a.m13648u(this.f8977H, iM13863d);
            c12020a.m13648u(this.f8976G, iM13863d + 4);
            iM13863d += 8;
            i4 |= 256;
        }
        long j = this.f8981L;
        if (j != 0) {
            ((ByteBuffer) c12020a.f8772b).putLong(iM13863d, j);
            iM13863d += 8;
            i4 |= 8192;
        }
        int i8 = this.f9010u;
        if (i8 != 0 || this.f9011v != 0) {
            c12020a.m13649v(iM13863d, i8);
            c12020a.m13649v(iM13863d + 4, this.f9011v);
            iM13863d += 8;
            i4 |= 16384;
        }
        int i9 = this.f8982M;
        if (i9 != 0) {
            c12020a.m13646s(iM13863d, i9);
            iM13863d++;
            i4 |= 32768;
        }
        int i10 = this.f9002m;
        if (i10 >= 0) {
            c12020a.m13649v(iM13863d, i10);
            iM13863d += 4;
            i4 |= 131072;
        }
        PointF pointF = this.f9003n;
        float f4 = pointF.x;
        if (f4 != -3.4028235E38f || pointF.y != -3.4028235E38f) {
            c12020a.m13652y(iM13863d, new SpenPointD(f4, pointF.y));
            iM13863d += 16;
            i4 |= 262144;
        }
        String str3 = this.f8983N;
        if (str3 != null) {
            int length3 = str3.length();
            c12020a.m13647t(iM13863d, length3);
            int i11 = iM13863d + 2;
            c12020a.m13626E(i11, this.f8983N);
            iM13863d = i11 + (length3 * 2);
            i4 |= 524288;
        }
        int i12 = this.f8984O;
        if (i12 >= 0) {
            c12020a.m13649v(iM13863d, i12);
            iM13863d += 4;
            i4 |= 1048576;
        }
        int i13 = iM13863d - i;
        if (i4 == 0) {
            i6 = 0;
        }
        c12020a.m13649v(i, i13);
        c12020a.m13647t(i + 4, 0);
        c12020a.m13649v(i + 6, i6);
        c12020a.m13646s(i + 10, 2);
        ((ByteBuffer) c12020a.f8772b).putShort(i + 11, s);
        c12020a.m13646s(i + 13, 4);
        c12020a.m13649v(i + 14, i4);
        return this.f9005p;
    }

    /* JADX INFO: renamed from: n */
    public int mo13814n() {
        this.f8978I.getClass();
        int length = this.f9012w != 0.0f ? 109 : 105;
        int i = this.f9013x;
        if (i > 0) {
            length = AbstractC1974b.m1310c(i, 16, 2, length);
        }
        String str = this.f9014y;
        if (str != null) {
            length += (str.length() * 2) + 2;
        }
        if (!this.f9015z.m13865g()) {
            length += this.f9015z.m13864e();
        }
        String str2 = this.f8970A;
        if (str2 != null) {
            length += (str2.length() * 2) + 2;
        }
        if (!this.f8971B.m13865g()) {
            length += this.f8971B.m13864e();
        }
        if (this.f8972C != -1) {
            length += 4;
        }
        if (this.f8975F != 0.0f || this.f8974E != 0.0f) {
            length += 8;
        }
        if (this.f8976G != 0.0f || this.f8977H != 0.0f) {
            length += 8;
        }
        if (this.f8981L != 0) {
            length += 8;
        }
        if (this.f9010u != 0 || this.f9011v != 0) {
            length += 8;
        }
        if (this.f8982M != 0) {
            length++;
        }
        if (this.f9002m >= 0) {
            length += 4;
        }
        PointF pointF = this.f9003n;
        if (pointF.x != -3.4028235E38f || pointF.y != -3.4028235E38f) {
            length += 16;
        }
        String str3 = this.f8983N;
        if (str3 != null) {
            length += (str3.length() * 2) + 2;
        }
        return this.f8984O >= 0 ? length + 4 : length;
    }

    /* JADX INFO: renamed from: o */
    public void mo13815o(XmlPullParser xmlPullParser, int i) {
        int i2;
        String attributeName = xmlPullParser.getAttributeName(i);
        if (attributeName.equalsIgnoreCase("id")) {
            this.f8978I.f9296a = xmlPullParser.getAttributeValue(i);
            return;
        }
        if (attributeName.equalsIgnoreCase("hash")) {
            this.f8986Q = C14433b.m15032m(xmlPullParser.getAttributeValue(i));
            return;
        }
        if (!attributeName.equals("type")) {
            if (attributeName.equals(DBSchema.DocumentExtra.FORMAT_VERSION)) {
                this.f9005p = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("rotatable")) {
                this.f8992c = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("selectable")) {
                this.f8993d = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("movable")) {
                this.f8994e = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("flippable")) {
                this.f8995f = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("visible")) {
                this.f8996g = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("isReplayable")) {
                this.f8997h = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("clippable")) {
                this.f8998i = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("isTemplateObject")) {
                this.f8999j = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("timeStamp")) {
                this.f9007r = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("resizable")) {
                this.f9008s = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("haveBeenToAtt")) {
                this.f9000k = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("lockState")) {
                this.f9001l = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("rotationDegree")) {
                this.f9012w = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                return;
            }
            boolean zEqualsIgnoreCase = attributeName.equalsIgnoreCase("attachedFileId");
            C11979b c11979b = this.f8989T;
            if (zEqualsIgnoreCase) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                this.f8973D = attributeValue;
                this.f8972C = c11979b.m13558d(attributeValue);
                return;
            }
            if (attributeName.equalsIgnoreCase("minWidth")) {
                this.f8974E = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("minHeight")) {
                this.f8975F = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("maxWidth")) {
                this.f8977H = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("maxHeight")) {
                this.f8976G = AbstractC14517a.m15121F(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase(GroupContract.Group.CREATED_TIME)) {
                this.f8979J = Long.parseLong(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("modifiedTime")) {
                this.f8980K = Long.parseLong(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("appendTime")) {
                this.f8981L = Long.parseLong(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("ownerPageWidth")) {
                this.f9010u = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("ownerPageHeight")) {
                this.f9011v = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("aoInfo")) {
                this.f9014y = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("plugInLink")) {
                this.f8970A = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("layoutType")) {
                this.f8982M = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("thumbnailHash")) {
                this.f9002m = c11979b.m13558d(xmlPullParser.getAttributeValue(i));
                return;
            }
            if (attributeName.equalsIgnoreCase("groupId")) {
                this.f8983N = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(i));
                return;
            } else if (attributeName.equalsIgnoreCase("removable")) {
                this.f9004o = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                return;
            } else {
                if (attributeName.equalsIgnoreCase("pageIndex")) {
                    this.f8984O = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                    return;
                }
                return;
            }
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(i);
        attributeValue2.getClass();
        i2 = 14;
        switch (attributeValue2) {
            case "textBox":
                i2 = 2;
                break;
            case "codeBlock":
                i2 = 23;
                break;
            case "tableNew":
                i2 = 22;
                break;
            case "stroke":
                i2 = 1;
                break;
            case "formula":
                i2 = 11;
                break;
            case "container":
                i2 = 4;
                break;
            case "unknown":
                i2 = 19;
                break;
            case "web":
                i2 = 13;
                break;
            case "line":
                i2 = 8;
                break;
            case "link":
                i2 = 17;
                break;
            case "math":
                i2 = 21;
                break;
            case "plot":
                i2 = 20;
                break;
            case "image":
                i2 = 3;
                break;
            case "shape":
                i2 = 7;
                break;
            case "voice":
                i2 = 10;
                break;
            case "painting":
                break;
            case "strokeGroup":
                i2 = 100;
                break;
            default:
                i2 = 0;
                break;
        }
        this.f8990a = i2;
    }

    /* JADX INFO: renamed from: p */
    public void mo13816p(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (name.equalsIgnoreCase("rect")) {
            this.f9006q = AbstractC14517a.m15127L(xmlPullParser);
            return;
        }
        if (!name.equalsIgnoreCase("bundle")) {
            if (name.equalsIgnoreCase("pivot")) {
                this.f9003n = AbstractC14517a.m15124I(xmlPullParser);
                return;
            }
            return;
        }
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("name")) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                if (attributeValue.equalsIgnoreCase("extraBundle")) {
                    this.f8971B.m13866h(xmlPullParser);
                } else if (attributeValue.equalsIgnoreCase("sorBundle")) {
                    this.f9015z.m13866h(xmlPullParser);
                }
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public void mo13817q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, CoeditServiceConstants.Element.NAME_OBJECT);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            mo13815o(xmlPullParser, i);
        }
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals(CoeditServiceConstants.Element.NAME_OBJECT)) {
                return;
            }
            if (iM15119D == 2) {
                mo13816p(xmlPullParser);
            } else if (iM15119D != 3 && iM15119D != 4) {
                AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ObjectBase");
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m13818r(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (AbstractC4539a.m3210t() && AbstractC0299q.f769b && !(this instanceof C12931q)) {
            xmlPullParser.require(2, null, CoeditServiceConstants.Element.NAME_OBJECT);
            int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
            while (true) {
                if (iM15119D == 3 && xmlPullParser.getName().equals(CoeditServiceConstants.Element.NAME_OBJECT)) {
                    break;
                }
                if (iM15119D != 2) {
                    if (iM15119D != 3 && iM15119D != 4) {
                        AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ObjectBase");
                    }
                } else if (xmlPullParser.getName().equalsIgnoreCase("encrypted")) {
                    String strM317b = C0145c.m317b(AbstractC14517a.m15129N(xmlPullParser));
                    XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                    xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                    XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                    xmlPullParserNewPullParser.setInput(new StringReader(strM317b));
                    xmlPullParserNewPullParser.nextTag();
                    mo13817q(xmlPullParserNewPullParser);
                }
                iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
            }
        } else {
            mo13817q(xmlPullParser);
        }
        if (this.f8983N != null) {
            StringBuilder sb = new StringBuilder("parseXml - id = [");
            sb.append(this.f8978I.f9296a);
            sb.append("], groupId = [");
            AbstractC4539a.m3209s(sb, this.f8983N, "]", "WCon_ObjectBase");
        }
    }

    /* JADX INFO: renamed from: s */
    public void m13819s(RandomAccessFile randomAccessFile) throws IOException {
        long filePointer = randomAccessFile.getFilePointer();
        int iM606P = AbstractC0299q.m606P(randomAccessFile);
        byte b = randomAccessFile.readByte();
        if (b > 1) {
            randomAccessFile.skipBytes(b - 1);
        }
        byte b5 = randomAccessFile.readByte();
        this.f8997h = (b5 & 16) != 0;
        this.f8996g = (b5 & 8) != 0;
        this.f8998i = (b5 & 32) != 0;
        this.f8999j = (b5 & 64) != 0;
        this.f8992c = (b5 & 1) != 0;
        this.f8993d = (b5 & 2) != 0;
        this.f8994e = (b5 & 4) != 0;
        this.f8995f = (b5 & 128) != 0;
        this.f9000k = (b5 & 256) != 0;
        this.f9001l = (b5 & 512) != 0;
        this.f9004o = (b5 & 4096) == 0;
        randomAccessFile.skipBytes(1);
        this.f8991b = AbstractC0299q.m609S(randomAccessFile);
        this.f9006q = AbstractC0299q.m608R(randomAccessFile);
        this.f9007r = AbstractC0299q.m606P(randomAccessFile);
        this.f9008s = randomAccessFile.readByte();
        this.f9009t = AbstractC0299q.m606P(randomAccessFile);
        if (iM606P != 0) {
            randomAccessFile.seek(filePointer + ((long) iM606P));
            if ((this.f8991b & 1) != 0) {
                this.f9012w = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            } else {
                this.f9012w = 0.0f;
            }
            if ((this.f8991b & 4) != 0) {
                this.f9014y = AbstractC0299q.m611U(randomAccessFile, -1);
            } else {
                this.f9014y = null;
            }
            if ((this.f8991b & 8) != 0) {
                this.f9015z.m13862c(randomAccessFile);
            }
            if ((this.f8991b & 16) != 0) {
                this.f8970A = AbstractC0299q.m611U(randomAccessFile, -1);
            } else {
                this.f8970A = null;
            }
            if ((this.f8991b & 32) != 0) {
                this.f8971B.m13862c(randomAccessFile);
                if (this.f9009t == -1 && this.f8971B.f9257b.containsKey("SPEN_SDK_RESERVED_KEY_RUNTIME_HANDLE\u0000")) {
                    LinkedHashMap linkedHashMap = this.f8971B.f9257b;
                    this.f9009t = linkedHashMap.containsKey("SPEN_SDK_RESERVED_KEY_RUNTIME_HANDLE\u0000") ? ((Integer) linkedHashMap.get("SPEN_SDK_RESERVED_KEY_RUNTIME_HANDLE\u0000")).intValue() : -1;
                }
            }
            if ((this.f8991b & 64) != 0) {
                this.f8972C = AbstractC0299q.m606P(randomAccessFile);
            } else {
                this.f8972C = -1;
            }
            if ((this.f8991b & 128) != 0) {
                this.f8974E = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
                this.f8975F = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            } else {
                this.f8974E = 0.0f;
                this.f8975F = 0.0f;
            }
            if ((this.f8991b & 256) != 0) {
                this.f8977H = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
                this.f8976G = Float.intBitsToFloat(AbstractC0299q.m606P(randomAccessFile));
            } else {
                this.f8977H = 0.0f;
                this.f8976G = 0.0f;
            }
            if ((this.f8991b & 512) != 0) {
                AbstractC0299q.m607Q(randomAccessFile);
            }
            C12966x c12966x = new C12966x();
            this.f8978I = c12966x;
            if ((this.f8991b & 1024) != 0) {
                int iM609S = AbstractC0299q.m609S(randomAccessFile);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    if (iM609S <= 0) {
                        break;
                    }
                    byte b6 = randomAccessFile.readByte();
                    int i = iM609S - 1;
                    if (b6 == 0) {
                        iM609S = i;
                        break;
                    }
                    if ((b6 & 128) != 0) {
                        byte b7 = randomAccessFile.readByte();
                        int i2 = iM609S - 2;
                        if ((b6 & CtapException.ERR_EXTENSION_FIRST) != 192) {
                            byte b8 = randomAccessFile.readByte();
                            int i4 = iM609S - 3;
                            if ((b6 & CtapException.ERR_VENDOR_FIRST) != 224) {
                                byte b9 = randomAccessFile.readByte();
                                int i5 = iM609S - 4;
                                if ((b6 & 248) != 240) {
                                    randomAccessFile.readByte();
                                    i = iM609S - 5;
                                    if ((b6 & 252) != 248) {
                                        randomAccessFile.readByte();
                                        iM609S -= 6;
                                        if ((b6 & 254) != 252) {
                                            break;
                                        } else {
                                            sb.append((char) 9633);
                                        }
                                    } else {
                                        sb.append((char) 9633);
                                    }
                                } else {
                                    int i6 = ((b6 & 7) << 18) | ((b7 & Utf8.REPLACEMENT_BYTE) << 12) | ((b8 & Utf8.REPLACEMENT_BYTE) << 6) | (b9 & Utf8.REPLACEMENT_BYTE);
                                    int i7 = ((64512 & i6) >> 10) | 55296;
                                    int i8 = (i6 & 1023) | Utf8.LOG_SURROGATE_HEADER;
                                    sb.append((char) i7);
                                    sb.append((char) i8);
                                    iM609S = i5;
                                }
                            } else {
                                sb.append((char) (((b6 & 15) << 12) | ((b7 & Utf8.REPLACEMENT_BYTE) << 6) | (b8 & Utf8.REPLACEMENT_BYTE)));
                                iM609S = i4;
                            }
                        } else {
                            sb.append((char) (((b6 & 31) << 6) | (b7 & Utf8.REPLACEMENT_BYTE)));
                            iM609S = i2;
                        }
                    } else {
                        sb.append((char) b6);
                    }
                    iM609S = i;
                }
                if (iM609S > 0) {
                    randomAccessFile.skipBytes(iM609S);
                }
                String string = sb.toString();
                c12966x.f9296a = string;
                if (string.length() > 36) {
                    c12966x.f9296a = c12966x.f9296a.substring(0, 36);
                }
            }
            if ((this.f8991b & 4096) != 0) {
                this.f8980K = AbstractC0299q.m607Q(randomAccessFile);
            } else {
                this.f8980K = 0L;
            }
            if ((this.f8991b & 8192) != 0) {
                this.f8981L = AbstractC0299q.m607Q(randomAccessFile);
            } else {
                this.f8981L = 0L;
            }
            if ((this.f8991b & 16384) != 0) {
                this.f9010u = AbstractC0299q.m606P(randomAccessFile);
                this.f9011v = AbstractC0299q.m606P(randomAccessFile);
            } else {
                this.f9010u = 0;
                this.f9011v = 0;
            }
            if ((this.f8991b & 32768) != 0) {
                this.f8982M = randomAccessFile.readByte();
            } else {
                this.f8982M = 0;
            }
        }
        m13820t();
    }

    /* JADX INFO: renamed from: t */
    public final void m13820t() {
        this.f8986Q = C14433b.m15031l(mo13811k() + this.f8980K);
    }
}
