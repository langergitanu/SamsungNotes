package p182g0;

import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p026F1.C0097a;
import p042J1.AbstractC0155m;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: g0.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12005o implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f8712a = 0;

    /* JADX INFO: renamed from: b */
    public ArrayList f8713b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public ArrayList f8714c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public ArrayList f8715d = new ArrayList();

    /* JADX INFO: renamed from: e */
    public C12000j f8716e = null;

    /* JADX INFO: renamed from: f */
    public String f8717f;

    /* JADX INFO: renamed from: g */
    public String f8718g;

    /* JADX INFO: renamed from: h */
    public boolean f8719h;

    /* JADX INFO: renamed from: c */
    public static void m13602c(C6742k c6742k, AbstractC11999i abstractC11999i) throws IOException {
        if (abstractC11999i != null) {
            c6742k.m4851h("id", abstractC11999i.f8707a);
            c6742k.m4850f("t", abstractC11999i.f8708b);
            c6742k.m4851h("h", abstractC11999i.f8709c);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m13603d(C6742k c6742k, ArrayList arrayList, String str) throws IOException {
        if (arrayList.isEmpty()) {
            return;
        }
        c6742k.m4846F(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C12003m c12003m = (C12003m) it.next();
            c6742k.m4846F(CoeditServiceConstants.Element.NAME_OBJECT);
            m13602c(c6742k, c12003m);
            c6742k.m4856m(CoeditServiceConstants.Element.NAME_OBJECT);
        }
        c6742k.m4856m(str);
    }

    /* JADX INFO: renamed from: e */
    public static void m13604e(XmlPullParser xmlPullParser, AbstractC11999i abstractC11999i) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals("id")) {
                abstractC11999i.f8707a = xmlPullParser.getAttributeValue(i);
            } else if (xmlPullParser.getAttributeName(i).equals("t")) {
                abstractC11999i.f8708b = Long.parseLong(xmlPullParser.getAttributeValue(i));
            } else if (xmlPullParser.getAttributeName(i).equals("h")) {
                abstractC11999i.f8709c = xmlPullParser.getAttributeValue(i);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m13605f(XmlPullParser xmlPullParser, String str, ArrayList arrayList) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, str);
        int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        while (true) {
            if (iM15119D == 3 && xmlPullParser.getName().equals(str)) {
                return;
            }
            if (iM15119D != 2) {
                if (iM15119D != 3 && iM15119D != 4) {
                    AbstractC2322a.m1632v(iM15119D, "parseBodyObjectsFromXml - invalid eventType = [", "]", "WCon_NoteTree");
                }
            } else if (xmlPullParser.getName().equalsIgnoreCase(CoeditServiceConstants.Element.NAME_OBJECT)) {
                C12003m c12003m = new C12003m();
                m13604e(xmlPullParser, c12003m);
                arrayList.add(c12003m);
            }
            iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
        }
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws SyncException {
        try {
            c6742k.m4848d(this.f8712a, "ver");
            if (AbstractC0299q.f768a.f318a >= 3) {
                C0158a.m407a().getClass();
                if (SyncState.isEdpMode() && !CoverStickerConstants.Category.NONE.NAME.equals(AbstractC0299q.f768a.f319b)) {
                    c6742k.m4852i("encrypted", NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(AbstractC0299q.f768a.f319b));
                }
                c6742k.m4852i("isStrokeGrouped", AbstractC0299q.f768a.f320c);
            }
            if (!this.f8713b.isEmpty()) {
                c6742k.m4846F("pageList");
                for (C12004n c12004n : this.f8713b) {
                    c6742k.m4846F("page");
                    m13602c(c6742k, c12004n);
                    c6742k.m4846F("layerList");
                    for (C12002l c12002l : c12004n.f8711d) {
                        c6742k.m4846F("layer");
                        m13602c(c6742k, c12002l);
                        m13603d(c6742k, c12002l.f8710d, "objectList");
                        c6742k.m4856m("layer");
                    }
                    c6742k.m4856m("layerList");
                    c6742k.m4856m("page");
                }
                c6742k.m4856m("pageList");
            }
            if (!this.f8714c.isEmpty()) {
                c6742k.m4846F("contentFileList");
                for (C12001k c12001k : this.f8714c) {
                    c6742k.m4846F(CoeditServiceConstants.Element.NAME_CONTENT_FILE);
                    m13602c(c6742k, c12001k);
                    c6742k.m4856m(CoeditServiceConstants.Element.NAME_CONTENT_FILE);
                }
                c6742k.m4856m("contentFileList");
            }
            m13603d(c6742k, this.f8715d, "floatingObjectList");
            if (this.f8716e != null) {
                c6742k.m4846F(ExternalDataConstants.Column.BODY_TEXT);
                m13602c(c6742k, this.f8716e);
                c6742k.m4856m(ExternalDataConstants.Column.BODY_TEXT);
            }
        } catch (Exception e) {
            Debugger.m8611e("WCon_NoteTree", e);
            throw new SyncException(326, e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final HashMap m13606b() {
        HashMap map = new HashMap();
        for (C12004n c12004n : this.f8713b) {
            map.put(c12004n.f8707a, c12004n);
            for (C12002l c12002l : c12004n.f8711d) {
                map.put(c12002l.f8707a, c12002l);
                for (C12003m c12003m : c12002l.f8710d) {
                    map.put(c12003m.f8707a, c12003m);
                }
            }
        }
        for (C12001k c12001k : this.f8714c) {
            map.put(c12001k.f8707a, c12001k);
        }
        for (C12003m c12003m2 : this.f8715d) {
            map.put(c12003m2.f8707a, c12003m2);
        }
        C12000j c12000j = this.f8716e;
        if (c12000j != null) {
            map.put(c12000j.f8707a, c12000j);
        }
        return map;
    }

    /* JADX INFO: renamed from: g */
    public final void m13607g(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        C12004n c12004n = null;
        C12002l c12002l = null;
        while (true) {
            if (eventType == 2) {
                String name2 = xmlPullParser.getName();
                if (name2.equalsIgnoreCase(name)) {
                    int attributeCount = xmlPullParser.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        String attributeName = xmlPullParser.getAttributeName(i);
                        if (attributeName.equalsIgnoreCase("ver")) {
                            this.f8712a = Integer.parseInt(xmlPullParser.getAttributeValue(i));
                        } else if (AbstractC4539a.m3210t() && attributeName.equalsIgnoreCase("encrypted")) {
                            AbstractC0299q.f769b = Boolean.parseBoolean(xmlPullParser.getAttributeValue(i));
                        }
                    }
                } else if (name2.equalsIgnoreCase("page")) {
                    c12004n = new C12004n();
                    m13604e(xmlPullParser, c12004n);
                    this.f8713b.add(c12004n);
                } else if (name2.equalsIgnoreCase("layer")) {
                    if (c12004n != null) {
                        c12002l = new C12002l();
                        m13604e(xmlPullParser, c12002l);
                        c12004n.f8711d.add(c12002l);
                    }
                } else if (name2.equalsIgnoreCase("objectList")) {
                    if (c12002l != null) {
                        m13605f(xmlPullParser, "objectList", c12002l.f8710d);
                    }
                } else if (name2.equalsIgnoreCase(CoeditServiceConstants.Element.NAME_CONTENT_FILE)) {
                    C12001k c12001k = new C12001k();
                    m13604e(xmlPullParser, c12001k);
                    this.f8714c.add(c12001k);
                } else if (name2.equalsIgnoreCase("floatingObjectList")) {
                    m13605f(xmlPullParser, "floatingObjectList", this.f8715d);
                } else if (name2.equalsIgnoreCase(ExternalDataConstants.Column.BODY_TEXT)) {
                    C12000j c12000j = new C12000j();
                    this.f8716e = c12000j;
                    m13604e(xmlPullParser, c12000j);
                } else if (name2.equalsIgnoreCase(IdentityApiContract.Parameter.MODEL_NAME)) {
                    this.f8718g = AbstractC14517a.m15130O(xmlPullParser);
                } else if (name2.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID)) {
                    this.f8717f = AbstractC0155m.m400o(AbstractC14517a.m15134S(xmlPullParser));
                } else if (name2.equalsIgnoreCase("deviceId")) {
                    Log.d("WCon_NoteTree", "parseXml - ignore device id!");
                } else if (name2.equalsIgnoreCase("isUpdatedByDevice")) {
                    this.f8719h = AbstractC14517a.m15131P(xmlPullParser);
                }
            } else if (eventType != 3 && eventType != 4) {
                AbstractC2322a.m1632v(eventType, "parseXml - invalid eventType = [", "]", "WCon_NoteTree");
            }
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            if (eventType == 3 && xmlPullParser.getName().equals(name)) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final String m13608h(C0097a c0097a) throws SyncException {
        AbstractC0299q.f768a = c0097a;
        try {
            C6742k c6742k = new C6742k(Xml.newSerializer());
            c6742k.m4846F("noteTree");
            mo47a(c6742k);
            c6742k.m4856m("noteTree");
            c6742k.m4857n();
            return ((StringWriter) c6742k.f4111c).toString();
        } catch (Exception e) {
            Debugger.m8609e("WCon_NoteTree", "toXml : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12005o)) {
            return false;
        }
        C12005o c12005o = (C12005o) obj;
        if (this.f8712a != c12005o.f8712a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mVersion[");
            sb.append(this.f8712a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12005o.f8712a, "]", "WCon_NoteTree", sb);
            return false;
        }
        if (!AbstractC0299q.m631h(this.f8713b, c12005o.f8713b)) {
            Log.i("WCon_NoteTree", " !! equals() - NE - mPageList[" + this.f8713b + " - " + c12005o.f8713b + "]");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f8714c, c12005o.f8714c)) {
            Log.i("WCon_NoteTree", " !! equals() - NE - mContentFileList[" + this.f8714c + " - " + c12005o.f8714c + "]");
            return false;
        }
        if (!AbstractC0299q.m631h(this.f8715d, c12005o.f8715d)) {
            Log.i("WCon_NoteTree", " !! equals() - NE - mFloatingObjectList[" + this.f8715d + " - " + c12005o.f8715d + "]");
            return false;
        }
        if (AbstractC0299q.m635j(this.f8716e, c12005o.f8716e)) {
            return true;
        }
        Log.i("WCon_NoteTree", " !! equals() - NE - mBodyText[" + this.f8716e + " - " + c12005o.f8716e + "]");
        return false;
    }
}
