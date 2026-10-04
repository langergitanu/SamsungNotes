package p007B0;

import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p185h0.InterfaceC12019d;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: B0.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0024g implements InterfaceC12019d {

    /* JADX INFO: renamed from: a */
    public final String f128a;

    /* JADX INFO: renamed from: b */
    public final String f129b;

    /* JADX INFO: renamed from: c */
    public final String f130c;

    public C0024g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        xmlPullParser.require(2, null, Contract.ERRORS);
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                try {
                    if (name.equalsIgnoreCase("field")) {
                        this.f128a = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("value")) {
                        this.f129b = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("reason")) {
                        this.f130c = AbstractC14517a.m15134S(xmlPullParser);
                    }
                } catch (XmlPullParserException unused) {
                    Debugger.m8609e("ServerErrorItem.Error", "failed to parse " + name);
                }
            } else if (eventType != 3 && eventType != 4) {
                Logger.m8698e("ServerErrorItem", "parseXml - invalid eventType = [" + eventType + "]");
            }
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            if (eventType == 3 && xmlPullParser.getName().equals(Contract.ERRORS)) {
                return;
            }
        }
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Error [ field=");
        sb.append(this.f128a);
        sb.append(", value=");
        sb.append(this.f129b);
        sb.append(", reason=");
        return AbstractC0622a.m1170p(this.f130c, "]", sb);
    }
}
