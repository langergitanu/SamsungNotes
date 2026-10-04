package p007B0;

import android.util.Xml;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p185h0.InterfaceC12019d;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: B0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0025h implements InterfaceC12019d {

    /* JADX INFO: renamed from: a */
    public String f131a;

    /* JADX INFO: renamed from: b */
    public String f132b;

    /* JADX INFO: renamed from: c */
    public String f133c;

    /* JADX INFO: renamed from: d */
    public long f134d;

    /* JADX INFO: renamed from: e */
    public String f135e;

    /* JADX INFO: renamed from: f */
    public int f136f;

    /* JADX INFO: renamed from: g */
    public String f137g;

    /* JADX INFO: renamed from: h */
    public int f138h;

    /* JADX INFO: renamed from: i */
    public ArrayList f139i = new ArrayList();

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) {
    }

    /* JADX INFO: renamed from: b */
    public final void m48b(String str) {
        try {
            StringReader stringReader = new StringReader(str);
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                xmlPullParserNewPullParser.setInput(stringReader);
                xmlPullParserNewPullParser.nextTag();
                m49c(xmlPullParserNewPullParser);
                stringReader.close();
            } catch (Throwable th) {
                try {
                    stringReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (SpenUnsupportedVersionException | IOException | XmlPullParserException e) {
            Debugger.m8609e("ServerErrorItem", e.getMessage() + ", failed to parse body = " + str);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m49c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        xmlPullParser.require(2, null, "ErrorResource");
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                try {
                    if (name.equalsIgnoreCase("serverResourceId")) {
                        this.f131a = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("uri")) {
                        this.f133c = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("timestamp")) {
                        this.f134d = AbstractC14517a.m15133R(xmlPullParser);
                    } else if (name.equalsIgnoreCase("trid")) {
                        this.f135e = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("code")) {
                        this.f136f = AbstractC14517a.m15132Q(xmlPullParser);
                    } else if (name.equalsIgnoreCase("message")) {
                        this.f137g = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("status")) {
                        this.f138h = AbstractC14517a.m15132Q(xmlPullParser);
                    } else if (name.equalsIgnoreCase(Contract.ERRORS)) {
                        this.f139i = new ArrayList();
                        AbstractC14517a.m15118C(xmlPullParser);
                        while (true) {
                            this.f139i.add(new C0024g(xmlPullParser));
                            if (AbstractC14517a.m15119D(xmlPullParser, 1) == 3 && xmlPullParser.getName().equalsIgnoreCase(Contract.ERRORS)) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase("uuid")) {
                        this.f132b = AbstractC14517a.m15134S(xmlPullParser);
                    }
                } catch (XmlPullParserException unused) {
                    AbstractC4539a.m3190D("failed to parse ", name, "ServerErrorItem");
                }
            } else if (eventType != 3 && eventType != 4) {
                Logger.m8698e("ServerErrorItem", "parseXml - invalid eventType = [" + eventType + "]");
            }
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            if (eventType == 3 && xmlPullParser.getName().equals("ErrorResource")) {
                return;
            }
        }
    }

    public final String toString() {
        return "ServerErrorItem [ServerResourceId=" + this.f131a + ", uuid=" + this.f132b + ", requestUri=" + this.f133c + ", timestamp=" + this.f134d + ", transactionId=" + this.f135e + ", code=" + this.f136f + ", message=" + this.f137g + ", status=" + this.f138h + ", errors=" + this.f139i + "]";
    }
}
