package p008B1;

import android.content.Context;
import android.util.Xml;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.ocr.BuildConfig;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;
import p020E.C0073a;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.C0152j;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p195k1.C12969a;
import p234q1.C14434c;

/* JADX INFO: renamed from: B1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0029b extends AbstractC0033f {

    /* JADX INFO: renamed from: d */
    public final String f148d;

    /* JADX INFO: renamed from: e */
    public final C11971a f149e;

    /* JADX INFO: renamed from: f */
    public final C12969a f150f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC6855f f151g;

    /* JADX INFO: renamed from: h */
    public long f152h;

    /* JADX INFO: renamed from: i */
    public int f153i;

    /* JADX INFO: renamed from: j */
    public int f154j;

    public C0029b(C6903f c6903f, Context context, C0097a c0097a, String str, C11971a c11971a, C12969a c12969a, InterfaceC6855f interfaceC6855f) {
        super(c6903f, context, c0097a);
        this.f152h = 0L;
        this.f153i = 0;
        this.f154j = 0;
        this.f148d = str;
        this.f149e = c11971a;
        this.f150f = c12969a;
        this.f151g = interfaceC6855f;
    }

    /* JADX INFO: renamed from: b */
    public final void m58b() throws SyncException {
        String strM13608h;
        Context context = (Context) this.f165b;
        StringBuilder sb = new StringBuilder();
        C0097a c0097a = (C0097a) this.f166c;
        if (c0097a.f318a == 3) {
            sb.append("/samsungnotes/v3");
        } else {
            sb.append("/samsungnotes/v1");
        }
        sb.append("/notes/");
        String strM15044b = C14434c.m15043a().m15044b(AbstractC0622a.m1170p(this.f148d, "/compareForDownsync", sb));
        C11971a c11971a = this.f149e;
        if (c11971a == null) {
            AbstractC0299q.f768a = c0097a;
            try {
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                if (xmlSerializerNewSerializer == null) {
                    throw new IllegalArgumentException("xmlSerializer is null.");
                }
                StringWriter stringWriter = new StringWriter();
                xmlSerializerNewSerializer.setOutput(stringWriter);
                xmlSerializerNewSerializer.startTag("", "noteTree");
                xmlSerializerNewSerializer.attribute("", "ver", Integer.toString(0));
                if (AbstractC0299q.f768a.f318a >= 3) {
                    C0158a.m407a().getClass();
                    if (SyncState.isEdpMode() && !CoverStickerConstants.Category.NONE.NAME.equals(AbstractC0299q.f768a.f319b)) {
                        xmlSerializerNewSerializer.attribute("", "encrypted", Boolean.toString(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b)));
                    }
                    xmlSerializerNewSerializer.attribute("", "isStrokeGrouped", Boolean.toString(AbstractC0299q.f768a.f320c));
                }
                xmlSerializerNewSerializer.endTag("", "noteTree");
                xmlSerializerNewSerializer.endDocument();
                strM13608h = stringWriter.toString();
            } catch (Exception e) {
                Debugger.m8609e("WCon_NoteTree", "toXmlForEmptyTree : " + e.getMessage());
                throw new SyncException(326, e);
            }
        } else {
            AbstractC0299q.f768a = c0097a;
            if (c0097a.f320c) {
                try {
                    AbstractC0153k.m377f("SyncNote/SDocxCompareForDownSync", "Before grouping a note");
                    c11971a.m13529d();
                    c0097a.f320c = true;
                } catch (Exception unused) {
                    throw new SyncException(326, "Fail to group strokes");
                }
            } else {
                c11971a.m13527a();
            }
            AbstractC0153k.m377f("SyncNote/SDocxCompareForDownSync", "Before XML composing");
            strM13608h = c11971a.f8521e.m13608h(c0097a);
        }
        if (AbstractC0153k.m373b(context)) {
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f453b = "req";
            c0152jM378g.f455d = c11971a == null ? strM13608h : c11971a.m13534i(new C0097a(0));
            c0152jM378g.f462k = true;
            c0152jM378g.f452a = "compareForDownsync";
            c0152jM378g.f454c = BuildConfig.FLAVOR;
            c0152jM378g.m371b(context);
        }
        AbstractC0153k.m377f("SyncNote/SDocxCompareForDownSync", "Before uploading note string and binary data");
        C6861l c6861l = new C6861l((C6903f) this.f164a, context, c0097a);
        c6861l.f4304e = strM15044b;
        c6861l.f4303d = strM13608h;
        c6861l.f4309j = "compareForDownsync";
        c6861l.f4300a.put("Accept", "multipart/form-data");
        c6861l.f4312m = this.f151g;
        c6861l.m5035e();
        c6861l.f4311l = new C0073a(this, 2);
        C6865p c6865pM5038h = c6861l.m5038h();
        if (this.f153i != 0) {
            Debugger.m8615i("SyncNote/SDocxCompareForDownSync", "[Stroke] download total stroke # = " + this.f153i + ", total size = " + this.f152h);
        }
        if (this.f154j != 0) {
            Debugger.m8615i("SyncNote/SDocxCompareForDownSync", "[Stroke] download total stroke group " + this.f154j + ", total size = " + this.f152h);
        }
        Debugger.m8607d("SyncNote/SDocxCompareForDownSync", "CompareForDownSync result = " + c6865pM5038h);
        if (c6865pM5038h.f4344a == 200) {
            return;
        }
        AbstractC0299q.m600J(context, c6865pM5038h);
    }
}
