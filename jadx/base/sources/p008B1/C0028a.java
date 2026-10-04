package p008B1;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import p007B0.C0022e;
import p007B0.C0023f;
import p026F1.C0097a;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p234q1.C14434c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: B1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0028a extends AbstractC0033f {

    /* JADX INFO: renamed from: d */
    public final String f147d;

    public /* synthetic */ C0028a(C6903f c6903f, Context context, C0097a c0097a, String str) {
        super(c6903f, context, c0097a);
        this.f147d = str;
    }

    /* JADX INFO: renamed from: b */
    public C0023f m56b() {
        Context context = (Context) this.f165b;
        StringBuilder sb = new StringBuilder("lastChangePoint = ");
        String str = this.f147d;
        sb.append(str);
        Debugger.m8615i("SyncNote/SDocxChanges", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        C0097a c0097a = (C0097a) this.f166c;
        if (c0097a.f318a == 3) {
            sb2.append("/samsungnotes/v3");
        } else {
            sb2.append("/samsungnotes/v1");
        }
        sb2.append("/notes/changes");
        String strM15044b = C14434c.m15043a().m15044b(sb2.toString());
        C6861l c6861l = new C6861l((C6903f) this.f164a, context, c0097a);
        c6861l.f4309j = "getNoteChanges";
        c6861l.f4304e = strM15044b;
        c6861l.m5035e();
        c6861l.f4301b.put("lastChangePoint", str);
        C6865p c6865pM5034d = c6861l.m5034d();
        C0023f c0023f = new C0023f();
        c0023f.f126b = false;
        c0023f.f127c = null;
        c0023f.f125a = str;
        if (c6865pM5034d.f4344a != 200) {
            AbstractC0299q.m600J(context, c6865pM5034d);
            return c0023f;
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
                        if (!name.equalsIgnoreCase("NoteChangesView")) {
                            if (name.equalsIgnoreCase("hasNext")) {
                                c0023f.f126b = AbstractC14517a.m15131P(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("lastChangePoint")) {
                                c0023f.f125a = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("changes")) {
                                c0023f.f127c = new C0022e();
                            } else if (name.equalsIgnoreCase("serverId")) {
                                ((C0022e) c0023f.f127c).f116a = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("resourceId")) {
                                ((C0022e) c0023f.f127c).f117b = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("syncModifiedTime")) {
                                ((C0022e) c0023f.f127c).f118c = AbstractC14517a.m15133R(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("isDeleted")) {
                                ((C0022e) c0023f.f127c).f119d = AbstractC14517a.m15131P(xmlPullParserNewPullParser);
                            } else if (name.equalsIgnoreCase("isLocked")) {
                                ((C0022e) c0023f.f127c).f120e = AbstractC14517a.m15131P(xmlPullParserNewPullParser);
                            } else if (!name.equalsIgnoreCase("isEncrypted") && !name.equalsIgnoreCase(GroupContract.Group.LEADER_ID)) {
                                if (name.equalsIgnoreCase(IdentityApiContract.Parameter.MODEL_NAME)) {
                                    ((C0022e) c0023f.f127c).f121f = AbstractC14517a.m15130O(xmlPullParserNewPullParser);
                                } else if (name.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID)) {
                                    ((C0022e) c0023f.f127c).f122g = AbstractC0155m.m400o(AbstractC14517a.m15134S(xmlPullParserNewPullParser));
                                } else if (name.equalsIgnoreCase("deviceId")) {
                                    Debugger.m8607d("NoteChangeItem", "parseXml - ignore device id!");
                                } else if (name.equalsIgnoreCase("isUpdatedByDevice")) {
                                    ((C0022e) c0023f.f127c).f123h = AbstractC14517a.m15131P(xmlPullParserNewPullParser);
                                } else if (name.equalsIgnoreCase("sdkVersion")) {
                                    try {
                                        ((C0022e) c0023f.f127c).f124i = AbstractC14517a.m15132Q(xmlPullParserNewPullParser);
                                    } catch (Exception unused) {
                                        ((C0022e) c0023f.f127c).f124i = 0;
                                    }
                                    Debugger.m8615i("NoteChangeItem", "fromXMLString - sdkVersion = " + ((C0022e) c0023f.f127c).f124i);
                                } else {
                                    Debugger.m8615i("NoteChangeItem", "fromXMLString - unknown name = [" + name + "]");
                                }
                            }
                        }
                    } else if (eventType != 3 && eventType != 4) {
                        Debugger.m8607d("NoteChangeItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                    }
                }
                eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                if (eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("NoteChangesView")) {
                    break;
                }
            } while (eventType != 1);
            return c0023f;
        } catch (Exception e) {
            Debugger.m8609e("NoteChangeItem", "fromXMLString : " + e.getMessage());
            throw new SyncException(327, e.getMessage(), e);
        }
    }

    /* JADX INFO: renamed from: c */
    public C12020a m57c() {
        Context context = (Context) this.f165b;
        StringBuilder sb = new StringBuilder("serverResourceId = ");
        String str = this.f147d;
        sb.append(str);
        Debugger.m8607d("SyncNote/SDocxNoteInfo", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        C0097a c0097a = (C0097a) this.f166c;
        if (c0097a.f318a == 3) {
            sb2.append("/samsungnotes/v3");
        } else {
            sb2.append("/samsungnotes/v1");
        }
        String strM15044b = C14434c.m15043a().m15044b(AbstractC2322a.m1626p(sb2, "/notes/", str, "/info"));
        C6861l c6861l = new C6861l((C6903f) this.f164a, context, c0097a);
        c6861l.f4309j = "getNoteInfo";
        c6861l.f4304e = strM15044b;
        c6861l.m5035e();
        C6865p c6865pM5034d = c6861l.m5034d();
        C12020a c12020a = new C12020a(1, (byte) 0);
        ServerNoteInfo serverNoteInfo = (ServerNoteInfo) c12020a.f8772b;
        int i = c6865pM5034d.f4344a;
        if (i != 200) {
            if (i == 404) {
                serverNoteInfo.setExists(false);
                return c12020a;
            }
            AbstractC0299q.m600J(context, c6865pM5034d);
            return c12020a;
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
                        if (name.equalsIgnoreCase("GetNoteInfoView")) {
                            int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeName = xmlPullParserNewPullParser.getAttributeName(i2);
                                if (attributeName.equalsIgnoreCase("resourceId")) {
                                    serverNoteInfo.setDocUuid(xmlPullParserNewPullParser.getAttributeValue(i2));
                                } else if (attributeName.equalsIgnoreCase("serverResourceId")) {
                                    serverNoteInfo.setServerId(xmlPullParserNewPullParser.getAttributeValue(i2));
                                } else if (attributeName.equalsIgnoreCase("syncModifiedTime")) {
                                    serverNoteInfo.setSyncModifiedTime(Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(i2)));
                                } else if (attributeName.equalsIgnoreCase(IdentityApiContract.Parameter.MODEL_NAME)) {
                                    serverNoteInfo.setModelName(Base64Utils.decodeBase64(xmlPullParserNewPullParser.getAttributeValue(i2)));
                                } else if (attributeName.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID)) {
                                    serverNoteInfo.setCommitId(xmlPullParserNewPullParser.getAttributeValue(i2));
                                } else {
                                    Debugger.m8615i("ServerNoteInfoItem", "fromXMLString - unknown attributeName = " + attributeName + SQLKeyword.COMMA + xmlPullParserNewPullParser.getAttributeValue(i2));
                                }
                            }
                        } else if (name.equalsIgnoreCase(NativeAuthConstants.GrantType.ATTRIBUTES)) {
                            c12020a.m13635O(xmlPullParserNewPullParser);
                        }
                    } else if (eventType != 3 && eventType != 4) {
                        Debugger.m8607d("ServerNoteInfoItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                    }
                }
                eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                if (eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("GetNoteInfoView")) {
                    break;
                }
            } while (eventType != 1);
            return c12020a;
        } catch (Exception e) {
            Debugger.m8609e("ServerNoteInfoItem", "fromXMLString : " + e.getMessage());
            throw new SyncException(327, e.getMessage(), e);
        }
    }
}
