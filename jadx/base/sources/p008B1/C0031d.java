package p008B1;

import android.content.Context;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.io.StringReader;
import java.util.Iterator;
import org.apache.http.entity.ContentType;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import p001A.AbstractC0000a;
import p007B0.C0018a;
import p007B0.C0024g;
import p007B0.C0025h;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0152j;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p178f0.C11980c;
import p182g0.C11992b;
import p182g0.C12011u;
import p186h1.C12020a;
import p191j0.AbstractC12916b;
import p191j0.C12930p;
import p191j0.C12931q;
import p234q1.C14434c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: B1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0031d extends AbstractC0033f {

    /* JADX INFO: renamed from: d */
    public C11971a f158d;

    /* JADX INFO: renamed from: e */
    public C12020a f159e;

    /* JADX INFO: renamed from: f */
    public C0025h f160f;

    /* JADX INFO: renamed from: g */
    public StringBuilder f161g;

    /* JADX INFO: renamed from: b */
    public final C0018a m60b() throws SyncException {
        C11971a c11971a = this.f158d;
        C0097a c0097a = (C0097a) this.f166c;
        Context context = (Context) this.f165b;
        if (AbstractC0153k.m373b(context)) {
            StringBuilder sb = new StringBuilder();
            this.f161g = sb;
            sb.append("upSyncedStrokeResources\n");
        }
        StringBuilder sb2 = new StringBuilder();
        if (c0097a.f318a == 3) {
            sb2.append("/samsungnotes/v3");
        } else {
            sb2.append("/samsungnotes/v1");
        }
        sb2.append("/notes");
        String strM15044b = C14434c.m15043a().m15044b(sb2.toString());
        boolean zEquals = NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(c0097a.f319b);
        AbstractC0299q.f768a = c0097a;
        if (c0097a.f320c) {
            try {
                AbstractC0153k.m377f("SyncNote/SDocxCreateNote", "Before grouping a note");
                c11971a.m13529d();
                c0097a.f320c = true;
            } catch (Exception unused) {
                throw new SyncException(326, "Fail to group strokes");
            }
        } else {
            c11971a.m13527a();
        }
        AbstractC0153k.m377f("SyncNote/SDocxCreateNote", "Before XML composing");
        String strM13534i = c11971a.m13534i(c0097a);
        Debugger.m8607d("SyncNote/SDocxCreateNote", "[Stroke] size of the XML part = " + strM13534i.length());
        C6861l c6861l = new C6861l((C6903f) this.f164a, context, c0097a);
        c6861l.f4309j = "createNote";
        c6861l.f4304e = strM15044b;
        c6861l.f4312m = this.f159e;
        c6861l.m5036f();
        c6861l.f4313n.addTextBody("noteResource", strM13534i, ContentType.APPLICATION_XML);
        c6861l.f4303d = strM13534i;
        c6861l.m5035e();
        AbstractC0153k.m377f("SyncNote/SDocxCreateNote", "Before addingMultiPart");
        Debugger.printMemory("SyncNote/SDocxCreateNote", "[CurrentMemoryState] Before adding multiparts");
        Iterator it = c11971a.f8524h.iterator();
        int i = 0;
        int length = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Iterator it2 = ((C12011u) it.next()).f8761v.iterator();
            while (it2.hasNext()) {
                for (AbstractC12916b abstractC12916b : ((C11992b) it2.next()).f8631j) {
                    if (abstractC12916b instanceof C12930p) {
                        C12930p c12930p = (C12930p) abstractC12916b;
                        c6861l.m5031a(c12930p, zEquals);
                        if (AbstractC0153k.m373b(context)) {
                            StringBuilder sb3 = this.f161g;
                            sb3.append(i);
                            sb3.append(" : ");
                            sb3.append(c12930p.f8978I);
                            sb3.append('\n');
                        }
                        int i4 = i + 1;
                        if (i % 1000 == 0) {
                            AbstractC0000a.m0A(i4, "upload stroke ", "SyncNote/SDocxCreateNote");
                        }
                        byte[] bArr = c12930p.f9100U;
                        length += bArr != null ? C12930p.f9099Z + bArr.length : 0;
                        i = i4;
                    } else if (abstractC12916b instanceof C12931q) {
                        C12931q c12931q = (C12931q) abstractC12916b;
                        c6861l.m5032b(c12931q, zEquals);
                        byte[] bArr2 = c12931q.f9106W;
                        length += bArr2 != null ? bArr2.length : 0;
                        if (AbstractC0153k.m373b(context)) {
                            StringBuilder sb4 = this.f161g;
                            sb4.append(i2);
                            sb4.append(" : ");
                            sb4.append((Object) null);
                            sb4.append('\n');
                        }
                        int i5 = i2 + 1;
                        if (i2 % 10 == 0) {
                            AbstractC0000a.m0A(i5, "upload stroke group ", "SyncNote/SDocxCreateNote");
                        }
                        i2 = i5;
                    }
                }
            }
        }
        if (i != 0) {
            Debugger.m8615i("SyncNote/SDocxCreateNote", "[Stroke] upload total created stroke # = " + i + ", total size = " + length);
        }
        if (i2 != 0) {
            Debugger.m8615i("SyncNote/SDocxCreateNote", "[Stroke] upload total created stroke group " + i2 + ", total size = " + length);
        }
        Debugger.printMemory("SyncNote/SDocxCreateNote", "[CurrentMemoryState] After adding multiparts");
        C6906i c6906i = c11971a.f8526j;
        C11980c c11980c = (C11980c) c6906i.f4484c;
        c11980c.f8581c = null;
        c11980c.f8583e = null;
        c11980c.f8582d = null;
        c11980c.f8584f = null;
        c11980c.f8585g = null;
        c6906i.f4484c = null;
        c11971a.f8526j = null;
        c11971a.f8524h = null;
        AbstractC0153k.m377f("SyncNote/SDocxCreateNote", "Before uploading note string and binary data");
        C6865p c6865pM5038h = c6861l.m5038h();
        AbstractC0153k.m377f("SyncNote/SDocxCreateNote", "After uploading note string and binary data");
        Debugger.m8607d("SyncNote/SDocxCreateNote", "createNote response = " + c6865pM5038h);
        Debugger.printMemory("SyncNote/SDocxCreateNote", "[CurrentMemoryState] After sending multiparts");
        C0018a c0018a = new C0018a(0);
        c0018a.f98f = false;
        int i6 = c6865pM5038h.f4344a;
        if (i6 == 201) {
            String str = c6865pM5038h.f4346c;
            try {
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                xmlPullParserNewPullParser.setInput(new StringReader(str));
                int eventType = xmlPullParserNewPullParser.getEventType();
                do {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (!name.equalsIgnoreCase("DefaultView")) {
                            if (name.equalsIgnoreCase("resourceId")) {
                                c0018a.f94b = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("requestId")) {
                                c0018a.f95c = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("timestamp")) {
                                c0018a.f96d = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID)) {
                                c0018a.f97e = AbstractC0155m.m400o(AbstractC14517a.m15134S(xmlPullParserNewPullParser));
                            } else {
                                Debugger.m8609e("CreateNoteItem", "fromXMLString - invalid name = [" + name + "]");
                            }
                        }
                    } else if (eventType != 3 && eventType != 4) {
                        Debugger.m8607d("CreateNoteItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                    }
                    eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                    if (eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("DefaultView")) {
                        break;
                    }
                } while (eventType != 1);
            } catch (Exception e) {
                Debugger.m8609e("CreateNoteItem", "fromXMLString : " + e.getMessage());
                throw new SyncException(327, e);
            }
        } else if (i6 == 202) {
            Debugger.m8615i("SyncNote/SDocxCreateNote", "createNote() status code = HTTP_RESOURCE_ACCEPTED");
        } else {
            C0025h c0025h = this.f160f;
            if (i6 == 403) {
                Debugger.m8607d("SyncNote/SDocxCreateNote", "createNote() response body = " + c6865pM5038h.f4346c);
                c0025h.m48b(c6865pM5038h.f4346c);
                if (c0025h.f136f == 403) {
                    Iterator it3 = c0025h.f139i.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        C0024g c0024g = (C0024g) it3.next();
                        if (c0024g.f128a.equals("id")) {
                            String str2 = c0024g.f130c;
                            c0018a.f94b = str2.substring(str2.indexOf(58) + 1).trim();
                            c0018a.f98f = true;
                            break;
                        }
                    }
                }
            } else {
                if (i6 == 422) {
                    throw new SyncException(335, "fail to SDocxCreateNote : " + c6865pM5038h);
                }
                c11971a.m13530e();
                AbstractC0299q.m600J(context, c6865pM5038h);
            }
        }
        if (AbstractC0153k.m373b(context)) {
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f454c = "upSyncedStrokeResources";
            c0152jM378g.f455d = this.f161g.toString();
            c0152jM378g.m371b(context);
        }
        return c0018a;
    }
}
