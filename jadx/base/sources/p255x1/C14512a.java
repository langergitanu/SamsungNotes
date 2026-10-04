package p255x1;

import android.content.Context;
import android.util.Xml;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import p007B0.C0025h;
import p007B0.C0027j;
import p008B1.AbstractC0033f;
import p026F1.C0097a;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p234q1.C14434c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: x1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14512a extends AbstractC0033f {

    /* JADX INFO: renamed from: d */
    public final Object f10341d;

    public /* synthetic */ C14512a(C6903f c6903f, Context context, C0097a c0097a, Object obj) {
        super(c6903f, context, c0097a);
        this.f10341d = obj;
    }

    /* JADX INFO: renamed from: b */
    public C6742k m15111b() {
        Context context = (Context) this.f165b;
        C6903f c6903f = (C6903f) this.f164a;
        c6903f.m5131p("FD");
        StringBuilder sb = new StringBuilder("lastChangePoint = ");
        String str = (String) this.f10341d;
        sb.append(str);
        Debugger.m8615i("SyncFolder/SDocxChanges", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        C0097a c0097a = (C0097a) this.f166c;
        if (c0097a.f318a == 3) {
            sb2.append("/samsungnotes/v3");
        } else {
            sb2.append("/samsungnotes/v1");
        }
        sb2.append("/folder/changes");
        String strM15044b = C14434c.m15043a().m15044b(sb2.toString());
        C6861l c6861l = new C6861l(c6903f, context, c0097a);
        c6861l.f4304e = strM15044b;
        c6861l.f4301b.put("lastChangePoint", str);
        c6861l.f4309j = "getFolderChanges";
        c6861l.m5035e();
        C6865p c6865pM5034d = c6861l.m5034d();
        c6903f.f4475c = null;
        C6742k c6742k = new C6742k(1);
        c6742k.f4110b = "";
        c6742k.f4111c = null;
        if (c6865pM5034d.f4344a != 200) {
            AbstractC0299q.m600J(context, c6865pM5034d);
            return c6742k;
        }
        String str2 = c6865pM5034d.f4346c;
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str2));
            int eventType = xmlPullParserNewPullParser.getEventType();
            do {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (!name.equalsIgnoreCase("FolderChangesView")) {
                            if (name.equalsIgnoreCase("lastChangePoint")) {
                                c6742k.f4110b = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("FolderResource")) {
                                c6742k.m4860r(xmlPullParserNewPullParser);
                            } else {
                                Debugger.m8615i("FolderChangeItem", "fromXMLString - invalid name = [" + name + "]");
                            }
                        }
                    } else if (eventType != 3 && eventType != 4) {
                        Debugger.m8607d("FolderChangeItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                    }
                }
                eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                if (eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("FolderChangesView")) {
                    break;
                }
            } while (eventType != 1);
            return c6742k;
        } catch (Exception e) {
            Debugger.m8609e("FolderChangeItem", "fromXMLString : " + e.getMessage());
            throw new SyncException(327, e.getMessage(), e);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m15112c() {
        C6865p c6865pM5040b;
        int i;
        Context context = (Context) this.f165b;
        C6903f c6903f = (C6903f) this.f164a;
        c6903f.m5131p("FU");
        C0097a c0097a = (C0097a) this.f166c;
        C0027j c0027j = (C0027j) this.f10341d;
        ArrayList arrayList = (ArrayList) c0027j.f145c;
        if (arrayList == null || arrayList.isEmpty()) {
            Debugger.m8615i("SyncFolder/SDocxUpdateFolder", "sendRequest() : No node!");
            c6865pM5040b = null;
        } else {
            Debugger.m8615i("SyncFolder/SDocxUpdateFolder", "sendRequest() start : " + arrayList.size());
            StringBuilder sb = new StringBuilder();
            if (c0097a.f318a == 3) {
                sb.append("/samsungnotes/v3");
            } else {
                sb.append("/samsungnotes/v1");
            }
            sb.append("/folder");
            String strM15044b = C14434c.m15043a().m15044b(sb.toString());
            C6861l c6861l = new C6861l(c6903f, context, c0097a);
            c6861l.f4309j = "updateFolders";
            c6861l.f4304e = strM15044b;
            c0027j.f144b = c0097a.f319b;
            try {
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                C6742k c6742k = new C6742k(xmlSerializerNewSerializer);
                c6742k.m4846F("FolderResource");
                c6742k.m4863u("syncModifiedTime", c0027j.m54e());
                C0158a.m407a().getClass();
                if (SyncState.isEdpMode() && !CoverStickerConstants.Category.NONE.NAME.equals(c0027j.f144b)) {
                    if (NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(c0027j.f144b)) {
                        xmlSerializerNewSerializer.startTag("", "encrypted");
                        xmlSerializerNewSerializer.text(Boolean.toString(true));
                        xmlSerializerNewSerializer.endTag("", "encrypted");
                    } else {
                        xmlSerializerNewSerializer.startTag("", "encrypted");
                        xmlSerializerNewSerializer.text(Boolean.toString(false));
                        xmlSerializerNewSerializer.endTag("", "encrypted");
                    }
                }
                c6742k.m4846F("nodeList");
                c0027j.m53d(c6742k);
                c6742k.m4856m("nodeList");
                c6742k.m4856m("FolderResource");
                c6742k.m4857n();
                c6861l.f4303d = ((StringWriter) c6742k.f4111c).toString();
                c6861l.m5035e();
                c6861l.f4305f = "PATCH";
                c6865pM5040b = c6861l.m5033c().m5040b();
            } catch (Exception e) {
                Debugger.m8609e("UpdateFolderItem", "toXml : " + e.getMessage());
                throw new SyncException(326, e);
            }
        }
        c6903f.f4475c = null;
        if (c6865pM5040b == null || (i = c6865pM5040b.f4344a) == 200) {
            return;
        }
        if (i == 403) {
            C0025h c0025h = new C0025h();
            c0025h.m48b(c6865pM5040b.f4346c);
            if (c0025h.f136f == 128409) {
                AbstractC0299q.m621c("d");
                AbstractC0299q.m625e("5039");
                Debugger.m8612ef("SyncFolder/SDocxUpdateFolder", "checkAndHandleFutureTimeError() : Future time error!");
            }
        } else {
            if (i == 409) {
                AbstractC14517a.m15139X(c6865pM5040b);
                throw null;
            }
            if (i == 500) {
                C0025h c0025h2 = new C0025h();
                c0025h2.m48b(c6865pM5040b.f4346c);
                if (c0025h2.f136f == 128900) {
                    Debugger.m8609e("SyncFolder/SDocxUpdateFolder", "checkEntireFolderNotEncryptedError() : Entire Folder should be encrypted!");
                    C0145c.m310R("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=");
                }
            }
        }
        AbstractC0299q.m600J(context, c6865pM5040b);
    }
}
