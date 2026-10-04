package p008B1;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.ocr.BuildConfig;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.C0152j;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p182g0.C12005o;
import p234q1.C14433b;
import p234q1.C14434c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: B1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0030c extends AbstractC0033f {

    /* JADX INFO: renamed from: d */
    public String f155d;

    /* JADX INFO: renamed from: e */
    public C11971a f156e;

    /* JADX INFO: renamed from: f */
    public C14433b f157f;

    /* JADX INFO: renamed from: b */
    public final void m59b() throws SyncException {
        Debugger.m8607d("SyncNote/SDocxCompareForUpSync", "start");
        Context context = (Context) this.f165b;
        C11971a c11971a = this.f156e;
        StringBuilder sb = new StringBuilder();
        C0097a c0097a = (C0097a) this.f166c;
        if (c0097a.f318a == 3) {
            sb.append("/samsungnotes/v3");
        } else {
            sb.append("/samsungnotes/v1");
        }
        sb.append("/notes/");
        String strM15044b = C14434c.m15043a().m15044b(AbstractC0622a.m1170p(this.f155d, "/compareForUpsync", sb));
        AbstractC0299q.f768a = c0097a;
        if (c0097a.f320c) {
            try {
                AbstractC0153k.m377f("SyncNote/SDocxCompareForUpSync", "Before grouping a note");
                c11971a.m13529d();
                c0097a.f320c = true;
            } catch (Exception unused) {
                throw new SyncException(326, "Fail to group strokes");
            }
        } else {
            c11971a.m13527a();
        }
        if (AbstractC0153k.m373b(context)) {
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f453b = "req";
            c0152jM378g.f455d = c11971a.m13534i(new C0097a(0));
            c0152jM378g.f462k = true;
            c0152jM378g.f452a = "compareForUpsync";
            c0152jM378g.f454c = BuildConfig.FLAVOR;
            c0152jM378g.m371b(context);
        }
        AbstractC0153k.m377f("SyncNote/SDocxCompareForUpSync", "Before XML composing for note tree");
        String strM13608h = c11971a.f8521e.m13608h(c0097a);
        Debugger.m8607d("SyncNote/SDocxCompareForUpSync", "[Stroke] size of the XML part = " + strM13608h.length());
        AbstractC0153k.m377f("SyncNote/SDocxCompareForUpSync", "Before uploading note tree");
        C6861l c6861l = new C6861l((C6903f) this.f164a, context, c0097a);
        c6861l.f4309j = "compareForUpsync";
        c6861l.f4304e = strM15044b;
        c6861l.f4303d = strM13608h;
        c6861l.m5035e();
        C6865p c6865pM5038h = c6861l.m5038h();
        int i = c6865pM5038h.f4344a;
        if (i == 200) {
            AbstractC0153k.m377f("SyncNote/SDocxCompareForUpSync", "Before XML parsing for note tree");
            C14433b c14433b = this.f157f;
            String str = c6865pM5038h.f4346c;
            try {
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                xmlPullParserNewPullParser.setInput(new StringReader(str));
                int eventType = xmlPullParserNewPullParser.getEventType();
                do {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xmlPullParserNewPullParser.getName();
                            if (name.equalsIgnoreCase("CompareForUpsyncView")) {
                                C12005o c12005o = new C12005o();
                                c14433b.f10228b = c12005o;
                                c12005o.m13607g(xmlPullParserNewPullParser);
                            } else {
                                Debugger.m8609e("UpdateWDocItem", "parseXml - invalid name = [" + name + "]");
                            }
                        } else if (eventType != 3 && eventType != 4) {
                            Debugger.m8607d("UpdateWDocItem", "parseXml - not handled eventType = [" + eventType + "]");
                        }
                    }
                    eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                    if (eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("noteTree")) {
                        break;
                    }
                } while (eventType != 1);
            } catch (Exception e) {
                Debugger.m8609e("UpdateWDocItem", "parseXml : " + e.getMessage());
                throw new SyncException(327, e.getMessage(), e);
            }
        } else if (i == 404) {
            Debugger.m8607d("SyncNote/SDocxCompareForUpSync", c6865pM5038h.f4346c);
        } else {
            AbstractC0299q.m600J(context, c6865pM5038h);
        }
        Debugger.m8607d("SyncNote/SDocxCompareForUpSync", "finished");
    }
}
