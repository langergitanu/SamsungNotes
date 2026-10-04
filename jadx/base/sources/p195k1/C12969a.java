package p195k1;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.samsung.android.app.notes.sync.C6751f;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.push.base.PushRegState;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p001A.AbstractC0000a;
import p007B0.C0020c;
import p010C.RunnableC0037b;
import p020E.C0073a;
import p026F1.C0099c;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p173d0.C11971a;
import p178f0.C11978a;
import p178f0.C11979b;
import p182g0.C11991a;
import p182g0.C11997g;
import p182g0.C11998h;
import p182g0.C12005o;
import p182g0.C12011u;
import p187i1.C12033b;
import p191j0.AbstractC12916b;
import p191j0.C12920f;
import p191j0.C12933s;
import p194k0.C12956n;
import p194k0.C12959q;
import p194k0.C12960r;
import p194k0.C12965w;
import p194k0.C12967y;
import p194k0.C12968z;
import p202m1.C13527b;
import p212o1.C13573a;
import p244u1.C14477a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: k1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12969a {

    /* JADX INFO: renamed from: f */
    public static C12969a f9306f;

    /* JADX INFO: renamed from: a */
    public Object f9307a;

    /* JADX INFO: renamed from: b */
    public Object f9308b;

    /* JADX INFO: renamed from: c */
    public Object f9309c;

    /* JADX INFO: renamed from: d */
    public Object f9310d;

    /* JADX INFO: renamed from: e */
    public Object f9311e;

    public C12969a(Context context, String str) {
        this.f9307a = context;
        this.f9308b = str;
        this.f9310d = new HashMap();
        this.f9311e = new C0020c();
    }

    /* JADX INFO: renamed from: b */
    public static synchronized C12969a m13872b(Context context) {
        try {
            if (f9306f == null) {
                f9306f = new C12969a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9306f;
    }

    /* JADX INFO: renamed from: a */
    public String m13873a(String str) {
        HashMap map = (HashMap) this.f9310d;
        if (map.containsKey(str)) {
            return (String) map.get(str);
        }
        throw new SyncException(0, AbstractC0541b.m773o("DownSyncItemhash or uuid [", str, "] does not existed in url map"));
    }

    /* JADX INFO: renamed from: c */
    public boolean m13874c() {
        ((C13573a) this.f9308b).getClass();
        boolean z = C0158a.m407a().m413c() && ((PushRegState) this.f9309c) == PushRegState.NOT_REGISTERED;
        AbstractC4539a.m3215y("isPushRegNeeded : ", "PushManager", z);
        return z;
    }

    /* JADX INFO: renamed from: d */
    public void m13875d(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            Debugger.m8609e("PushManager", "Received smp push token is invalid!");
            return;
        }
        C0145c.m310R("SMP_PREFERENCE", "smp_push_type", str);
        C0145c.m310R("SMP_PREFERENCE", "smp_push_token", str2);
        C0145c.m310R("SMP_PREFERENCE", "smp_reg_last_error", "");
        C0145c.m306N(-1, "SMP_PREFERENCE", "smp_activate_last_error");
        this.f9309c = PushRegState.NOT_REGISTERED;
    }

    /* JADX INFO: renamed from: e */
    public void m13876e(String str) {
        C6903f c6903f;
        for (String str2 : str.split("\\r?\\n")) {
            if (TextUtils.isEmpty(str2)) {
                c6903f = null;
            } else {
                c6903f = new C6903f(10);
                try {
                    String[] strArrSplit = str2.split(":");
                    c6903f.f4474b = strArrSplit[0].trim();
                    C6903f c6903fM5120e = C6903f.m5120e(strArrSplit[1].trim());
                    c6903f.f4476d = (Map) c6903fM5120e.f4476d;
                    c6903f.f4475c = (String) c6903fM5120e.f4475c;
                } catch (Exception e) {
                    Debugger.m8610e("SyncHttpResponse", "failed to parseLine " + str2, e);
                }
            }
            if (((String) c6903f.f4474b).toLowerCase().contains("Content-Disposition".toLowerCase())) {
                Map map = (Map) c6903f.f4476d;
                this.f9309c = map != null ? (String) map.get("name") : null;
                Map map2 = (Map) c6903f.f4476d;
                this.f9308b = map2 != null ? (String) map2.get(UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME) : null;
            } else if (((String) c6903f.f4474b).toLowerCase().contains("Content-Type".toLowerCase())) {
                this.f9311e = (String) c6903f.f4475c;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:414:0x0b98, code lost:
    
        if (r8 == null) goto L659;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x0b9b, code lost:
    
        if (r9 == (-1)) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0b9d, code lost:
    
        r3.f8696p.put(r8, java.lang.Integer.valueOf(r9));
     */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m13877f(XmlPullParser xmlPullParser) throws XmlPullParserException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        String str;
        C0020c c0020c;
        String str2;
        String str3;
        String str4;
        C11971a c11971a;
        int i;
        String attributeValue;
        Object obj;
        String str5;
        String str6;
        String str7;
        int i2;
        String str8;
        String str9;
        String str10;
        String str11;
        C6906i c6906i;
        String str12;
        C12960r c12960r;
        C11971a c11971a2;
        String str13;
        String str14;
        int i4;
        String str15;
        String str16;
        int i5;
        C12969a c12969a = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        C0020c c0020c2 = (C0020c) c12969a.f9311e;
        int eventType = xmlPullParser2.getEventType();
        while (true) {
            String str17 = "CompareNoteView";
            if (eventType == 0) {
                str = "CompareNoteView";
            } else if (eventType != 2) {
                if (eventType != 3) {
                    if (eventType != 4) {
                        Debugger.m8607d("DownSyncItem", "fromXMLString - not handled eventType = [" + eventType + "]");
                    }
                } else if (xmlPullParser2.getName().equalsIgnoreCase("downloadUrl")) {
                    ((HashMap) c12969a.f9310d).put(c0020c2.f110a, c0020c2.f111b);
                }
                str = "CompareNoteView";
            } else {
                String name = xmlPullParser2.getName();
                if (name.equalsIgnoreCase("CompareNoteView")) {
                    if (((C11971a) c12969a.f9309c) == null) {
                        c12969a.f9309c = new C11971a((Context) c12969a.f9307a, (String) c12969a.f9308b);
                    }
                    C11971a c11971a3 = (C11971a) c12969a.f9309c;
                    if (c11971a3.f8531o) {
                        throw new IllegalStateException("parseXml() - WDocData is already initialized.");
                    }
                    String str18 = "WCon_WDocData";
                    LoggerBase.m7130i("WCon_WDocData", "parseXml() - start");
                    c11971a3.f8527k = new C12965w();
                    int iNextTag = xmlPullParser2.nextTag();
                    String name2 = xmlPullParser2.getName();
                    String str19 = "NoteResource";
                    if (!name2.equalsIgnoreCase("NoteResource")) {
                        throw new XmlPullParserException("WDocData() - invalid parser.");
                    }
                    while (true) {
                        if (iNextTag != 2) {
                            if (iNextTag != 3 && iNextTag != 4) {
                                LoggerBase.m7126e(str18, "parseXml - invalid eventType = [" + iNextTag + "]");
                            }
                            c0020c = c0020c2;
                            c11971a = c11971a3;
                            str = str17;
                            str2 = str18;
                            str3 = str19;
                            i = 1;
                        } else {
                            String name3 = xmlPullParser2.getName();
                            boolean zEqualsIgnoreCase = name3.equalsIgnoreCase(str19);
                            String str20 = GroupContract.Group.CREATED_TIME;
                            int i6 = 0;
                            if (zEqualsIgnoreCase) {
                                int attributeCount = xmlPullParser2.getAttributeCount();
                                while (i6 < attributeCount) {
                                    String attributeName = xmlPullParser2.getAttributeName(i6);
                                    if (attributeName.equalsIgnoreCase("id")) {
                                        c11971a3.f8532p = xmlPullParser2.getAttributeValue(i6);
                                        str16 = str18;
                                        i5 = attributeCount;
                                    } else if (attributeName.equalsIgnoreCase("syncModifiedTime")) {
                                        str16 = str18;
                                        i5 = attributeCount;
                                        c11971a3.f8533q = Long.parseLong(xmlPullParser2.getAttributeValue(i6));
                                    } else {
                                        str16 = str18;
                                        i5 = attributeCount;
                                        if (attributeName.equalsIgnoreCase(GroupContract.Group.CREATED_TIME)) {
                                            c11971a3.f8517a = Long.parseLong(xmlPullParser2.getAttributeValue(i6));
                                        } else if (attributeName.equalsIgnoreCase("isLocked")) {
                                            c11971a3.f8518b = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i6));
                                        } else if (attributeName.equalsIgnoreCase("isEncrypted")) {
                                            c11971a3.f8520d = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i6));
                                        } else if (attributeName.equalsIgnoreCase(GroupContract.Group.LEADER_ID)) {
                                            c11971a3.f8519c = xmlPullParser2.getAttributeValue(i6);
                                        } else if (attributeName.equalsIgnoreCase("xmlVer")) {
                                            C6906i c6906i2 = c11971a3.f8526j;
                                            Integer.parseInt(xmlPullParser2.getAttributeValue(i6));
                                            c6906i2.getClass();
                                        }
                                    }
                                    i6++;
                                    attributeCount = i5;
                                    str18 = str16;
                                }
                                str2 = str18;
                                if (c11971a3.f8520d) {
                                    throw new SpenUnsupportedTypeException("parseXml - Can't support encrypted file at this version");
                                }
                            } else {
                                str2 = str18;
                                if (name3.equalsIgnoreCase("noteTree")) {
                                    C12005o c12005o = new C12005o();
                                    c12005o.f8712a = 0;
                                    c12005o.f8713b = new ArrayList();
                                    c12005o.f8714c = new ArrayList();
                                    c12005o.f8715d = new ArrayList();
                                    c12005o.f8716e = null;
                                    c11971a3.f8521e = c12005o;
                                    c12005o.m13607g(xmlPullParser2);
                                } else if (name3.equalsIgnoreCase("contentFileList")) {
                                    ((C11979b) c11971a3.f8526j.f4483b).f8576d.clear();
                                } else {
                                    int i7 = 0;
                                    String str21 = "name";
                                    if (name3.equalsIgnoreCase(CoeditServiceConstants.Element.NAME_CONTENT_FILE)) {
                                        str = str17;
                                        C11991a c11991a = new C11991a(c11971a3.f8530n);
                                        xmlPullParser2.require(2, null, CoeditServiceConstants.Element.NAME_CONTENT_FILE);
                                        int attributeCount2 = xmlPullParser2.getAttributeCount();
                                        int i8 = 0;
                                        while (i8 < attributeCount2) {
                                            String attributeName2 = xmlPullParser2.getAttributeName(i8);
                                            if (attributeName2.equalsIgnoreCase("id")) {
                                                c11991a.f8618k = xmlPullParser2.getAttributeValue(i8);
                                                i4 = attributeCount2;
                                            } else {
                                                i4 = attributeCount2;
                                                if (attributeName2.equalsIgnoreCase("bindNumber")) {
                                                    c11991a.f8608a = Integer.parseInt(xmlPullParser2.getAttributeValue(i8));
                                                } else if (attributeName2.equalsIgnoreCase("name")) {
                                                    c11991a.f8613f = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i8));
                                                    c11991a.f8610c = c11991a.f8609b + "/media/" + c11991a.f8613f;
                                                } else if (attributeName2.equalsIgnoreCase(CoeditServiceConstants.Attribute.KEY_REF_COUNT)) {
                                                    c11991a.f8616i = Integer.parseInt(xmlPullParser2.getAttributeValue(i8));
                                                } else {
                                                    if (attributeName2.equalsIgnoreCase(str20)) {
                                                        str15 = str20;
                                                        c11991a.f8614g = Long.parseLong(xmlPullParser2.getAttributeValue(i8));
                                                    } else {
                                                        str15 = str20;
                                                        if (attributeName2.equalsIgnoreCase("modifiedTime")) {
                                                            c11991a.f8615h = Long.parseLong(xmlPullParser2.getAttributeValue(i8));
                                                        } else if (attributeName2.equalsIgnoreCase("hash")) {
                                                            c11991a.f8612e = xmlPullParser2.getAttributeValue(i8);
                                                        } else if (attributeName2.equalsIgnoreCase("isFileAttached")) {
                                                            c11991a.f8619l = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i8));
                                                        } else if (attributeName2.equalsIgnoreCase("uploadToken")) {
                                                            c11991a.f8620m = xmlPullParser2.getAttributeValue(i8);
                                                        }
                                                    }
                                                    i8++;
                                                    attributeCount2 = i4;
                                                    str20 = str15;
                                                }
                                            }
                                            str15 = str20;
                                            i8++;
                                            attributeCount2 = i4;
                                            str20 = str15;
                                        }
                                        int iM15119D = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                        while (true) {
                                            if (iM15119D == 3 && xmlPullParser2.getName().equals(CoeditServiceConstants.Element.NAME_CONTENT_FILE)) {
                                                if (!((C11979b) c11971a3.f8526j.f4483b).f8575c.containsKey(c11991a.f8618k)) {
                                                    c11991a.f8621n = true;
                                                }
                                                C11979b c11979b = (C11979b) c11971a3.f8526j.f4483b;
                                                c11979b.getClass();
                                                String str22 = c11991a.f8618k;
                                                if (c11979b.f8575c.containsKey(str22)) {
                                                    LoggerBase.m7130i("WCon_ContentFileManager", "registerContentFile - hash[" + str22 + "] already exist. update file info");
                                                    C11978a c11978a = (C11978a) c11979b.f8575c.get(str22);
                                                    if (c11978a == null) {
                                                        throw new IOException(AbstractC0541b.m773o("registerContentFile - fail to find file info, hash[", str22, "]"));
                                                    }
                                                    LoggerBase.m7130i("WCon_ContentFileManager", "registerContentFile - old id[" + c11978a.f8569a + "], name[" + LoggerBase.getEncode(c11978a.f8570b) + "], refCount[" + c11978a.f8572d + "]");
                                                    c11978a.f8569a = c11991a.f8608a;
                                                    c11978a.f8572d = c11991a.f8616i;
                                                    String str23 = c11991a.f8613f;
                                                    if (TextUtils.equals(c11978a.f8570b, str23)) {
                                                        c0020c = c0020c2;
                                                        c11971a2 = c11971a3;
                                                        str13 = name3;
                                                        str3 = str19;
                                                    } else {
                                                        if (TextUtils.isEmpty(str22)) {
                                                            throw new IllegalArgumentException("getFilePath - hash is null");
                                                        }
                                                        if (TextUtils.isEmpty(c11979b.f8573a)) {
                                                            throw new IllegalStateException("getFilePath - cache path is invalid");
                                                        }
                                                        HashMap map = c11979b.f8575c;
                                                        if (map == null) {
                                                            throw new IllegalStateException("getFilePath - hash file map is invalid");
                                                        }
                                                        if (!map.containsKey(str22) || c11979b.f8575c.get(str22) == null) {
                                                            LoggerBase.m7126e("WCon_ContentFileManager", "getFilePath - can not find hash[" + str22 + "]");
                                                            str14 = null;
                                                        } else {
                                                            str14 = c11979b.f8574b + File.separator + ((C11978a) c11979b.f8575c.get(str22)).f8570b;
                                                            if (!AbstractC2322a.m1607A(str14)) {
                                                                StringBuilder sbM15l = AbstractC0000a.m15l("getFilePath - hash[", str22, "], file[");
                                                                sbM15l.append(LoggerBase.getEncode(str14));
                                                                sbM15l.append("] is not exist");
                                                                LoggerBase.m7126e("WCon_ContentFileManager", sbM15l.toString());
                                                                str14 = str14;
                                                            }
                                                        }
                                                        File file = new File(str14);
                                                        if (!file.exists()) {
                                                            throw new IOException("registerContentFile - srcFile[" + LoggerBase.getEncode(str14) + "] is not exist.");
                                                        }
                                                        String str24 = str14;
                                                        String str25 = c11991a.f8610c;
                                                        c0020c = c0020c2;
                                                        File file2 = new File(str25);
                                                        str3 = str19;
                                                        c11971a2 = c11971a3;
                                                        if (file2.exists()) {
                                                            str13 = name3;
                                                            LoggerBase.m7130i("WCon_ContentFileManager", "registerContentFile - dest file [" + LoggerBase.getEncode(str25) + "] is exist. Add temp file list.");
                                                            c11979b.f8578f.add(str25);
                                                            String str26 = file2 + DiskFileUpload.postfix;
                                                            File file3 = new File(str26);
                                                            if (file3.exists()) {
                                                                LoggerBase.m7130i("WCon_ContentFileManager", "registerContentFile - dest temp file [" + LoggerBase.getEncode(str26) + "] is exist. Delete.");
                                                                if (!file3.delete()) {
                                                                    throw new IOException("registerContentFile - fail to delete dest file [" + LoggerBase.getEncode(str26) + "].");
                                                                }
                                                            }
                                                            if (!file.renameTo(file3)) {
                                                                throw new IOException("registerContentFile - fail to rename [" + LoggerBase.getEncode(str24) + "] to [" + LoggerBase.getEncode(str26) + "]");
                                                            }
                                                        } else {
                                                            str13 = name3;
                                                            if (!file.renameTo(file2)) {
                                                                throw new IOException("registerContentFile - fail to rename [" + LoggerBase.getEncode(str24) + "] to [" + LoggerBase.getEncode(str25) + "]");
                                                            }
                                                        }
                                                        c11978a.f8570b = str23;
                                                    }
                                                    int i9 = 0;
                                                    while (true) {
                                                        if (i9 >= c11979b.f8577e.size()) {
                                                            break;
                                                        }
                                                        C11991a c11991a2 = (C11991a) c11979b.f8577e.get(i9);
                                                        if (TextUtils.equals(c11991a2.f8618k, str22)) {
                                                            c11979b.f8577e.remove(c11991a2);
                                                            break;
                                                        }
                                                        i9++;
                                                    }
                                                    c11979b.f8577e.add(i9, c11991a);
                                                    LoggerBase.m7130i("WCon_ContentFileManager", "registerContentFile - new id[" + c11978a.f8569a + "], name[" + LoggerBase.getEncode(c11978a.f8570b) + "], refCount[" + c11978a.f8572d + "]");
                                                } else {
                                                    c0020c = c0020c2;
                                                    c11971a2 = c11971a3;
                                                    str13 = name3;
                                                    str3 = str19;
                                                    c11979b.m13555a(c11991a);
                                                }
                                                xmlPullParser2 = xmlPullParser;
                                                c11971a = c11971a2;
                                                str4 = str13;
                                            } else {
                                                C0020c c0020c3 = c0020c2;
                                                C11971a c11971a4 = c11971a3;
                                                String str27 = name3;
                                                String str28 = str19;
                                                if (iM15119D != 2) {
                                                    if (iM15119D != 3 && iM15119D != 4) {
                                                        AbstractC2322a.m1632v(iM15119D, "parseXml - invalid eventType = [", "]", "WCon_ContentFile");
                                                    }
                                                } else if (xmlPullParser.getName().equalsIgnoreCase("fileHash")) {
                                                    String strM15134S = AbstractC14517a.m15134S(xmlPullParser);
                                                    if (!TextUtils.equals(c11991a.f8618k, strM15134S)) {
                                                        throw new XmlPullParserException(AbstractC0622a.m1170p(c11991a.f8618k, "]", AbstractC0000a.m15l("parseElement - file hash [", strM15134S, "] is different from id [")));
                                                    }
                                                }
                                                xmlPullParser2 = xmlPullParser;
                                                iM15119D = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                c0020c2 = c0020c3;
                                                str19 = str28;
                                                c11971a3 = c11971a4;
                                                name3 = str27;
                                            }
                                        }
                                    } else {
                                        c0020c = c0020c2;
                                        C11971a c11971a5 = c11971a3;
                                        str = str17;
                                        String str29 = GroupContract.Group.CREATED_TIME;
                                        str3 = str19;
                                        String str30 = NativeAuthConstants.GrantType.ATTRIBUTES;
                                        str4 = name3;
                                        if (str4.equalsIgnoreCase(NativeAuthConstants.GrantType.ATTRIBUTES)) {
                                            c11971a = c11971a5;
                                            C11998h c11998h = new C11998h(c11971a.f8526j);
                                            c11971a.f8522f = c11998h;
                                            xmlPullParser2.require(2, null, NativeAuthConstants.GrantType.ATTRIBUTES);
                                            int attributeCount3 = xmlPullParser2.getAttributeCount();
                                            for (int i10 = 0; i10 < attributeCount3; i10++) {
                                                c11998h.m13599e(xmlPullParser2, i10);
                                            }
                                            Debugger.m8615i("WCon_WNote", "parseXml() - end - ct/mt = [" + c11998h.f8702v + "][" + c11998h.f8704x + "], dct/dmt = [" + c11998h.f8663U + "][" + c11998h.f8664V + "]");
                                            int iM15119D2 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                            while (true) {
                                                if (iM15119D2 == 3 && xmlPullParser2.getName().equals(str30)) {
                                                    if (c11998h.f8650H > 5400) {
                                                        Log.w("WCon_WNote", "Version mismatch. parsed version = " + c11998h.f8650H + ", current version = 5400");
                                                        c11998h.f8650H = 5400;
                                                    }
                                                    if (c11998h.f8651I > 5400) {
                                                        throw new SpenUnsupportedVersionException(AbstractC2821a.m2223n(new StringBuilder("parseXml - UnsupportedVersion!!! - required version = "), ", current version = 5400", c11998h.f8651I));
                                                    }
                                                    int i11 = c11971a.f8522f.f8650H;
                                                    if (i11 < 2034) {
                                                        throw new SpenUnsupportedTypeException(AbstractC0541b.m767i(i11, "Invalid version, parsed version = ", ", base version = 2034"));
                                                    }
                                                    if (i11 >= 5000 && i11 < 5200) {
                                                        throw new SpenUnsupportedTypeException(AbstractC0000a.m11h(i11, "Deprecated version, parsed version = "));
                                                    }
                                                } else {
                                                    if (iM15119D2 != 2) {
                                                        if (iM15119D2 != 3 && iM15119D2 != 4) {
                                                            AbstractC2322a.m1632v(iM15119D2, "parseXml - invalid eventType = [", "]", "WCon_WNote");
                                                        }
                                                        str5 = str30;
                                                        str6 = str29;
                                                        i2 = 1;
                                                        str7 = str21;
                                                    } else {
                                                        int eventType2 = xmlPullParser2.getEventType();
                                                        String name4 = xmlPullParser2.getName();
                                                        if (name4.equalsIgnoreCase(str30)) {
                                                            str5 = str30;
                                                            str6 = str29;
                                                            str7 = str21;
                                                            i2 = 1;
                                                        } else {
                                                            boolean zEqualsIgnoreCase2 = name4.equalsIgnoreCase("title");
                                                            C6906i c6906i3 = c11998h.f8690k0;
                                                            if (zEqualsIgnoreCase2) {
                                                                c11998h.f8653K = new C12920f(2, c6906i3, 1);
                                                                AbstractC14517a.m15118C(xmlPullParser2);
                                                                c11998h.f8653K.m13818r(xmlPullParser2);
                                                                StringBuilder sb = new StringBuilder("parseXml() - tt = [");
                                                                C12956n c12956n = c11998h.f8653K.f9082b0;
                                                                sb.append(LoggerBase.getEncode((c12956n == null || (c12960r = c12956n.f9223e) == null) ? null : c12960r.f9243a));
                                                                sb.append("]");
                                                                LoggerBase.m7130i("WCon_WNote", sb.toString());
                                                            } else if (name4.equalsIgnoreCase("metaData")) {
                                                                int attributeCount4 = xmlPullParser2.getAttributeCount();
                                                                for (int i12 = i7; i12 < attributeCount4; i12++) {
                                                                    String attributeName3 = xmlPullParser2.getAttributeName(i12);
                                                                    if (attributeName3.equalsIgnoreCase("appName")) {
                                                                        c11998h.f8679f = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i12));
                                                                    } else if (attributeName3.equalsIgnoreCase("appMajorVersion")) {
                                                                        c11998h.f8683h = Integer.parseInt(xmlPullParser2.getAttributeValue(i12));
                                                                    } else if (attributeName3.equalsIgnoreCase("appMinorVersion")) {
                                                                        c11998h.f8685i = Integer.parseInt(xmlPullParser2.getAttributeValue(i12));
                                                                    } else if (attributeName3.equalsIgnoreCase("appPatchName")) {
                                                                        c11998h.f8681g = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i12));
                                                                    }
                                                                }
                                                            } else if (name4.equalsIgnoreCase("stringIdList")) {
                                                                c11998h.f8697q = new C11997g();
                                                                AbstractC14517a.m15118C(xmlPullParser2);
                                                                while (true) {
                                                                    if (eventType2 == 3 && xmlPullParser2.getName().equals("stringIdList")) {
                                                                        break;
                                                                    }
                                                                    int attributeCount5 = xmlPullParser2.getAttributeCount();
                                                                    int i13 = i7;
                                                                    int i14 = i13;
                                                                    String strDecodeBase64 = null;
                                                                    while (i13 < attributeCount5) {
                                                                        String attributeName4 = xmlPullParser2.getAttributeName(i13);
                                                                        if (attributeName4.equalsIgnoreCase("id")) {
                                                                            str12 = str30;
                                                                            i14 = Integer.parseInt(xmlPullParser2.getAttributeValue(i13));
                                                                        } else {
                                                                            str12 = str30;
                                                                            if (attributeName4.equalsIgnoreCase("text")) {
                                                                                strDecodeBase64 = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i13));
                                                                            }
                                                                        }
                                                                        i13++;
                                                                        str30 = str12;
                                                                    }
                                                                    String str31 = str30;
                                                                    C11997g c11997g = c11998h.f8697q;
                                                                    c11997g.f8640a.put(Integer.valueOf(i14), strDecodeBase64);
                                                                    c11997g.f8641b.put(Integer.valueOf(i14), Integer.valueOf(i7));
                                                                    c11997g.f8642c = i14 + 1;
                                                                    AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                    eventType2 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                    str30 = str31;
                                                                }
                                                            } else {
                                                                str5 = str30;
                                                                if (name4.equalsIgnoreCase("penInfo")) {
                                                                    c11998h.f8699s = new C12959q();
                                                                    int eventType3 = xmlPullParser2.getEventType();
                                                                    int i15 = 2;
                                                                    xmlPullParser2.require(2, null, "penInfo");
                                                                    while (true) {
                                                                        if (eventType3 != i15) {
                                                                            if (eventType3 != 3 && eventType3 != 4) {
                                                                                AbstractC2322a.m1632v(eventType3, "parseXml - invalid eventType = [", "]", "WCon_WNote");
                                                                            }
                                                                        } else if (xmlPullParser2.getName().equalsIgnoreCase("penInfo")) {
                                                                            int attributeCount6 = xmlPullParser2.getAttributeCount();
                                                                            for (int i16 = i7; i16 < attributeCount6; i16++) {
                                                                                String attributeName5 = xmlPullParser2.getAttributeName(i16);
                                                                                if (attributeName5.equalsIgnoreCase(str21)) {
                                                                                    c11998h.f8699s.name = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("size")) {
                                                                                    c11998h.f8699s.size = AbstractC14517a.m15121F(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("color")) {
                                                                                    c11998h.f8699s.color = (int) Long.parseLong(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("isCurvable")) {
                                                                                    c11998h.f8699s.isCurvable = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("advancedSetting")) {
                                                                                    c11998h.f8699s.advancedSetting = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("isEraserEnabled")) {
                                                                                    c11998h.f8699s.isEraserEnabled = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("sizeLevel")) {
                                                                                    c11998h.f8699s.sizeLevel = Integer.parseInt(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("particleDensity")) {
                                                                                    c11998h.f8699s.particleDensity = Integer.parseInt(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("particleSize")) {
                                                                                    c11998h.f8699s.particleSize = AbstractC14517a.m15121F(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("isFixedWidth")) {
                                                                                    c11998h.f8699s.isFixedWidth = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("colorUIInfo")) {
                                                                                    c11998h.f8699s.colorUIInfo = Integer.parseInt(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("hsv0")) {
                                                                                    c11998h.f8699s.hsv[i7] = AbstractC14517a.m15121F(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("hsv1")) {
                                                                                    c11998h.f8699s.hsv[1] = AbstractC14517a.m15121F(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("hsv2")) {
                                                                                    c11998h.f8699s.hsv[2] = AbstractC14517a.m15121F(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("isFixedOpacity")) {
                                                                                    c11998h.f8699s.isFixedOpacity = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("isAutoSizeEnabled")) {
                                                                                    c11998h.f8699s.isAutoSizeEnabled = Boolean.parseBoolean(xmlPullParser2.getAttributeValue(i16));
                                                                                } else if (attributeName5.equalsIgnoreCase("fitRatio")) {
                                                                                    c11998h.f8699s.fitRatio = AbstractC14517a.m15121F(xmlPullParser2.getAttributeValue(i16));
                                                                                }
                                                                            }
                                                                        }
                                                                        int iM15119D3 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                        if (iM15119D3 == 3 && xmlPullParser2.getName().equals("penInfo")) {
                                                                            break;
                                                                        }
                                                                        eventType3 = iM15119D3;
                                                                        i15 = 2;
                                                                    }
                                                                } else {
                                                                    String str32 = "voiceDataList";
                                                                    if (name4.equalsIgnoreCase("voiceDataList")) {
                                                                        c11998h.f8700t = new ArrayList();
                                                                        AbstractC14517a.m15118C(xmlPullParser2);
                                                                        int i17 = 3;
                                                                        while (true) {
                                                                            if (eventType2 == i17 && xmlPullParser2.getName().equals(str32)) {
                                                                                break;
                                                                            }
                                                                            C12968z c12968z = new C12968z(c6906i3);
                                                                            String str33 = "voiceData";
                                                                            xmlPullParser2.require(2, null, "voiceData");
                                                                            int attributeCount7 = xmlPullParser2.getAttributeCount();
                                                                            int i18 = i7;
                                                                            while (i18 < attributeCount7) {
                                                                                String attributeName6 = xmlPullParser2.getAttributeName(i18);
                                                                                String str34 = str32;
                                                                                if (attributeName6.equalsIgnoreCase("attachFile")) {
                                                                                    c12968z.f9299a = c12968z.f9304f.m13558d(xmlPullParser2.getAttributeValue(i18));
                                                                                } else if (attributeName6.equalsIgnoreCase(str21)) {
                                                                                    c12968z.f9300b = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i18));
                                                                                } else if (attributeName6.equalsIgnoreCase(DBSchema.DocumentThumbnail.PLAY_TIME)) {
                                                                                    c12968z.f9301c = Base64Utils.decodeBase64(xmlPullParser2.getAttributeValue(i18));
                                                                                } else {
                                                                                    str10 = str29;
                                                                                    if (attributeName6.equalsIgnoreCase(str10)) {
                                                                                        str11 = str21;
                                                                                        c6906i = c6906i3;
                                                                                        c12968z.f9302d = Long.parseLong(xmlPullParser2.getAttributeValue(i18));
                                                                                    } else {
                                                                                        str11 = str21;
                                                                                        c6906i = c6906i3;
                                                                                        if (attributeName6.equalsIgnoreCase("recordingTime")) {
                                                                                            c12968z.f9303e = Long.parseLong(xmlPullParser2.getAttributeValue(i18));
                                                                                        }
                                                                                    }
                                                                                    i18++;
                                                                                    str21 = str11;
                                                                                    c6906i3 = c6906i;
                                                                                    str29 = str10;
                                                                                    str32 = str34;
                                                                                }
                                                                                c6906i = c6906i3;
                                                                                str10 = str29;
                                                                                str11 = str21;
                                                                                i18++;
                                                                                str21 = str11;
                                                                                c6906i3 = c6906i;
                                                                                str29 = str10;
                                                                                str32 = str34;
                                                                            }
                                                                            String str35 = str32;
                                                                            C6906i c6906i4 = c6906i3;
                                                                            String str36 = str29;
                                                                            int i19 = 1;
                                                                            String str37 = str21;
                                                                            int iM15119D4 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                            while (true) {
                                                                                if (iM15119D4 != 3 || !xmlPullParser2.getName().equals(str33)) {
                                                                                    if (iM15119D4 == 2) {
                                                                                        String str38 = "propertyList";
                                                                                        if (xmlPullParser2.getName().equalsIgnoreCase("propertyList")) {
                                                                                            ArrayList arrayList = c12968z.f9305g;
                                                                                            arrayList.clear();
                                                                                            int iM15118C = AbstractC14517a.m15118C(xmlPullParser2);
                                                                                            while (true) {
                                                                                                if (iM15118C == 3 && xmlPullParser2.getName().equals(str38)) {
                                                                                                    break;
                                                                                                }
                                                                                                C12967y c12967y = new C12967y();
                                                                                                int attributeCount8 = xmlPullParser2.getAttributeCount();
                                                                                                int i20 = i7;
                                                                                                while (i20 < attributeCount8) {
                                                                                                    String str39 = str36;
                                                                                                    String attributeName7 = xmlPullParser2.getAttributeName(i20);
                                                                                                    C12968z c12968z2 = c12968z;
                                                                                                    if (attributeName7.equalsIgnoreCase("action")) {
                                                                                                        c12967y.f9297a = Integer.parseInt(xmlPullParser2.getAttributeValue(i20));
                                                                                                    } else {
                                                                                                        if (attributeName7.equalsIgnoreCase("timeStamp")) {
                                                                                                            str8 = str38;
                                                                                                            str9 = str33;
                                                                                                            c12967y.f9298b = Long.parseLong(xmlPullParser2.getAttributeValue(i20));
                                                                                                        }
                                                                                                        i20++;
                                                                                                        str33 = str9;
                                                                                                        str36 = str39;
                                                                                                        c12968z = c12968z2;
                                                                                                        str38 = str8;
                                                                                                    }
                                                                                                    str8 = str38;
                                                                                                    str9 = str33;
                                                                                                    i20++;
                                                                                                    str33 = str9;
                                                                                                    str36 = str39;
                                                                                                    c12968z = c12968z2;
                                                                                                    str38 = str8;
                                                                                                }
                                                                                                arrayList.add(c12967y);
                                                                                                iM15118C = AbstractC14517a.m15119D(xmlPullParser2, 2);
                                                                                                c12968z = c12968z;
                                                                                                str38 = str38;
                                                                                            }
                                                                                        }
                                                                                    } else if (iM15119D4 != 3 && iM15119D4 != 4) {
                                                                                        AbstractC2322a.m1632v(iM15119D4, "parseXml - invalid eventType = [", "]", "WCon_VoiceData");
                                                                                    }
                                                                                    String str40 = str36;
                                                                                    str33 = str33;
                                                                                    i19 = 1;
                                                                                    c12968z = c12968z;
                                                                                    iM15119D4 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                                    str36 = str40;
                                                                                }
                                                                            }
                                                                            c11998h.f8700t.add(c12968z);
                                                                            eventType2 = AbstractC14517a.m15119D(xmlPullParser2, i19);
                                                                            i17 = 3;
                                                                            str21 = str37;
                                                                            c6906i3 = c6906i4;
                                                                            str29 = str36;
                                                                            str32 = str35;
                                                                        }
                                                                    } else {
                                                                        str6 = str29;
                                                                        str7 = str21;
                                                                        if (name4.equalsIgnoreCase("attachedFileList")) {
                                                                            c11998h.f8696p.clear();
                                                                            AbstractC14517a.m15118C(xmlPullParser2);
                                                                            while (true) {
                                                                                int i21 = 3;
                                                                                if (eventType2 == 3 && xmlPullParser2.getName().equals("attachedFileList")) {
                                                                                    break;
                                                                                }
                                                                                String strM15123H = null;
                                                                                int i22 = -1;
                                                                                while (true) {
                                                                                    if (eventType2 == i21 && xmlPullParser2.getName().equals("attachedFile")) {
                                                                                        break;
                                                                                    }
                                                                                    String name5 = xmlPullParser2.getName();
                                                                                    if (name5.equalsIgnoreCase("key")) {
                                                                                        strM15123H = AbstractC14517a.m15123H(xmlPullParser2);
                                                                                    } else if (name5.equalsIgnoreCase("attachedFileId")) {
                                                                                        int eventType4 = xmlPullParser2.getEventType();
                                                                                        String name6 = xmlPullParser2.getName();
                                                                                        if (eventType4 != 2) {
                                                                                            throw new XmlPullParserException("current tag is not start tag.");
                                                                                        }
                                                                                        i22 = Integer.parseInt(xmlPullParser2.getAttributeValue(i7));
                                                                                        for (String name7 = name6; eventType4 != 3 && TextUtils.equals(name6, name7); name7 = xmlPullParser2.getName()) {
                                                                                            eventType4 = xmlPullParser2.next();
                                                                                        }
                                                                                    }
                                                                                    eventType2 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                                    i21 = 3;
                                                                                    i7 = 0;
                                                                                }
                                                                                eventType2 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                            }
                                                                        } else if (name4.equalsIgnoreCase("tagList")) {
                                                                            c11998h.f8680f0 = new ArrayList();
                                                                            AbstractC14517a.m15118C(xmlPullParser2);
                                                                            while (true) {
                                                                                if (eventType2 == 3 && xmlPullParser2.getName().equals("tagList")) {
                                                                                    break;
                                                                                }
                                                                                c11998h.f8680f0.add(AbstractC14517a.m15123H(xmlPullParser2));
                                                                                eventType2 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                                            }
                                                                        } else if (name4.equalsIgnoreCase("mergedByServer")) {
                                                                            int attributeCount9 = xmlPullParser2.getAttributeCount();
                                                                            for (int i23 = 0; i23 < attributeCount9; i23++) {
                                                                                if (xmlPullParser2.getAttributeName(i23).equalsIgnoreCase(DBSchema.Document.MATH_MODE)) {
                                                                                    c11998h.f8688j0 = Integer.parseInt(xmlPullParser2.getAttributeValue(i23));
                                                                                }
                                                                            }
                                                                        }
                                                                        i2 = 1;
                                                                    }
                                                                }
                                                                str6 = str29;
                                                                str7 = str21;
                                                                i2 = 1;
                                                            }
                                                            str5 = str30;
                                                            str6 = str29;
                                                            str7 = str21;
                                                            i2 = 1;
                                                        }
                                                    }
                                                    iM15119D2 = AbstractC14517a.m15119D(xmlPullParser2, i2);
                                                    str21 = str7;
                                                    str30 = str5;
                                                    str29 = str6;
                                                    i7 = 0;
                                                }
                                            }
                                        } else {
                                            c11971a = c11971a5;
                                            if (str4.equalsIgnoreCase("pageList")) {
                                                c11971a.f8524h = new ArrayList();
                                                c11971a.f8523g = new ArrayList();
                                            } else if (str4.equalsIgnoreCase("page")) {
                                                C6906i c6906i5 = c11971a.f8526j;
                                                C12011u c12011u = new C12011u();
                                                c12011u.f8751l = new RectF();
                                                c12011u.f8752m = new ArrayList();
                                                c12011u.f8753n = -1;
                                                c12011u.f8758s = new ArrayList();
                                                c12011u.f8761v = new ArrayList();
                                                c12011u.f8765z = -1;
                                                c12011u.f8733A = 4000;
                                                c12011u.f8734B = 4000;
                                                c12011u.f8735C = 0;
                                                c12011u.f8736D = new LinkedHashMap();
                                                c12011u.f8737E = 0;
                                                c12011u.f8738F = 0L;
                                                new ArrayList();
                                                c12011u.f8739G = new ArrayList();
                                                c12011u.f8756q = c6906i5;
                                                int i24 = 2;
                                                xmlPullParser2.require(2, null, "page");
                                                C0158a.m407a().getClass();
                                                if (SyncState.isEdpMode() && AbstractC0299q.f769b) {
                                                    xmlPullParser2.require(2, null, "page");
                                                    int iM15119D5 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                    int i25 = 3;
                                                    while (true) {
                                                        if (iM15119D5 == i25 && xmlPullParser2.getName().equals("page")) {
                                                            break;
                                                        }
                                                        if (iM15119D5 == i24) {
                                                            Log.i("WCon_Page", "parseEncryptedXml - encrypted , " + xmlPullParser2.getName());
                                                            if (xmlPullParser2.getName().equals("encrypted")) {
                                                                Debugger.m8615i("WCon_Page", "parseEncryptedElement()");
                                                                String strM317b = C0145c.m317b(AbstractC14517a.m15129N(xmlPullParser2));
                                                                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                                                                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                                                                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                                                                xmlPullParserNewPullParser.setInput(new StringReader(strM317b));
                                                                xmlPullParserNewPullParser.nextTag();
                                                                c12011u.m13613g(xmlPullParserNewPullParser);
                                                            } else {
                                                                iM15119D5 = c12011u.m13613g(xmlPullParser2);
                                                            }
                                                        } else if (iM15119D5 != i25 && iM15119D5 != 4) {
                                                            AbstractC2322a.m1632v(iM15119D5, "parseXml - invalid eventType = [", "]", "WCon_Page");
                                                        }
                                                        if (iM15119D5 != 3 || !xmlPullParser2.getName().equals("page")) {
                                                            iM15119D5 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                        }
                                                        i25 = 3;
                                                        i24 = 2;
                                                    }
                                                } else {
                                                    c12011u.m13613g(xmlPullParser2);
                                                }
                                                c11971a.f8524h.add(c12011u);
                                                c11971a.f8523g.add(c12011u.f8744e);
                                            } else if (str4.equalsIgnoreCase("floatingObjectList")) {
                                                C11998h c11998h2 = c11971a.f8522f;
                                                C6906i c6906i6 = c11998h2.f8690k0;
                                                int i26 = 2;
                                                xmlPullParser2.require(2, null, "floatingObjectList");
                                                int iM15119D6 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                while (true) {
                                                    if (iM15119D6 == 3 && xmlPullParser2.getName().equals("floatingObjectList")) {
                                                        break;
                                                    }
                                                    if (iM15119D6 == i26) {
                                                        if (xmlPullParser2.getName().equalsIgnoreCase(CoeditServiceConstants.Element.NAME_OBJECT)) {
                                                            int attributeCount10 = xmlPullParser2.getAttributeCount();
                                                            int i27 = 0;
                                                            while (true) {
                                                                if (i27 >= attributeCount10) {
                                                                    attributeValue = null;
                                                                    break;
                                                                } else {
                                                                    if (xmlPullParser2.getAttributeName(i27).equalsIgnoreCase("type")) {
                                                                        attributeValue = xmlPullParser2.getAttributeValue(i27);
                                                                        break;
                                                                    }
                                                                    i27++;
                                                                }
                                                            }
                                                            AbstractC12916b abstractC12916bM15144d = AbstractC14517a.m15144d(attributeValue, c6906i6);
                                                            if (abstractC12916bM15144d != null) {
                                                                abstractC12916bM15144d.m13818r(xmlPullParser2);
                                                                obj = abstractC12916bM15144d;
                                                            } else {
                                                                if (attributeValue == null) {
                                                                    AbstractC14517a.m15138W(xmlPullParser2);
                                                                    break;
                                                                }
                                                                C12933s c12933s = new C12933s(c6906i6);
                                                                c12933s.f9116Z = true;
                                                                c12933s.m13818r(xmlPullParser2);
                                                                c12933s.f9116Z = false;
                                                                obj = c12933s;
                                                            }
                                                            c11998h2.f8692l0.add(obj);
                                                        }
                                                        iM15119D6 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                        i26 = 2;
                                                    } else if (iM15119D6 != 3 && iM15119D6 != 4) {
                                                        AbstractC2322a.m1632v(iM15119D6, "readBodyObjectsFromXml - invalid eventType = [", "]", "WCon_WNote");
                                                    }
                                                    iM15119D6 = AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                    i26 = 2;
                                                }
                                            } else {
                                                i = 1;
                                                if (str4.equalsIgnoreCase(ExternalDataConstants.Column.BODY_TEXT)) {
                                                    AbstractC14517a.m15119D(xmlPullParser2, 1);
                                                    C12920f c12920f = new C12920f(2, c11971a.f8526j, 1);
                                                    c12920f.m13818r(xmlPullParser2);
                                                    c11971a.f8522f.f8654L = c12920f;
                                                }
                                                name2 = str4;
                                            }
                                        }
                                    }
                                    i = 1;
                                    name2 = str4;
                                }
                            }
                            c0020c = c0020c2;
                            str = str17;
                            str4 = name3;
                            str3 = str19;
                            i = 1;
                            c11971a = c11971a3;
                            name2 = str4;
                        }
                        int iM15119D7 = AbstractC14517a.m15119D(xmlPullParser2, i);
                        String str41 = str3;
                        if ((iM15119D7 == 3 && TextUtils.equals(name2, str41)) || TextUtils.equals(name2, "downloadUrls") || iM15119D7 == i) {
                            break;
                        }
                        str19 = str41;
                        c11971a3 = c11971a;
                        str18 = str2;
                        str17 = str;
                        c0020c2 = c0020c;
                        iNextTag = iM15119D7;
                    }
                    C11998h c11998h3 = c11971a.f8522f;
                    c11998h3.f8702v = c11971a.f8517a;
                    c11998h3.f8656N = c11971a.f8520d;
                    c11998h3.f8649G = c11971a.f8519c;
                    c11971a.f8527k.m13868a(c11998h3);
                    c11971a.f8531o = true;
                } else {
                    c0020c = c0020c2;
                    str = "CompareNoteView";
                    if (!name.equalsIgnoreCase("noteResource") && !name.equalsIgnoreCase("downloadUrls") && !name.equalsIgnoreCase("downloadUrl")) {
                        if (name.equalsIgnoreCase("id")) {
                            c0020c2 = c0020c;
                            c0020c2.f110a = AbstractC14517a.m15134S(xmlPullParser2);
                        } else {
                            c0020c2 = c0020c;
                            if (name.equalsIgnoreCase("url")) {
                                c0020c2.f111b = AbstractC14517a.m15134S(xmlPullParser2);
                            } else if (name.equalsIgnoreCase(IdentityApiContract.Parameter.MODEL_NAME)) {
                                c12969a = this;
                                ((C11971a) c12969a.f9309c).f8535s = AbstractC14517a.m15130O(xmlPullParser2);
                            } else {
                                c12969a = this;
                                if (name.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID)) {
                                    ((C11971a) c12969a.f9309c).f8534r = AbstractC0155m.m400o(AbstractC14517a.m15134S(xmlPullParser2));
                                } else {
                                    Debugger.m8609e("DownSyncItem", "fromXMLString - invalid name = [" + name + "]");
                                }
                            }
                        }
                        c12969a = this;
                    }
                }
                c12969a = this;
                c0020c2 = c0020c;
            }
            int iM15119D8 = AbstractC14517a.m15119D(xmlPullParser2, 1);
            if ((iM15119D8 == 3 && xmlPullParser2.getName() != null && xmlPullParser2.getName().equals(str)) || iM15119D8 == 1) {
                return;
            } else {
                eventType = iM15119D8;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public void m13878g(String str) {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            m13877f(xmlPullParserNewPullParser);
        } catch (SpenUnsupportedTypeException e) {
            Debugger.m8609e("DownSyncItem", "parseXml : " + e.getMessage());
            SyncException syncException = new SyncException(336);
            syncException.setSpenUnsupportedTypeException(e);
            throw syncException;
        } catch (SpenUnsupportedVersionException unused) {
            throw new SyncException(12000, "High formated note");
        } catch (Exception e2) {
            Debugger.m8609e("DownSyncItem", "parseXml : " + e2.getMessage());
            throw new SyncException(327, e2.getMessage(), e2);
        }
    }

    /* JADX INFO: renamed from: h */
    public void m13879h(C12033b c12033b) throws SyncException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c12033b.m13726b(byteArrayOutputStream);
                if (((String) this.f9311e).contains("application/octet-stream")) {
                    this.f9310d = byteArrayOutputStream.toByteArray();
                } else {
                    this.f9307a = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                }
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new SyncException(312, e);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m13880i() {
        synchronized (this.f9310d) {
            try {
                if (((PushRegState) this.f9309c) != PushRegState.NOT_REGISTERED) {
                    Debugger.m8607d("PushManager", "[PUSH] ignore registerPush() due to the registering state");
                    return;
                }
                this.f9309c = PushRegState.REGISTERING;
                if (!C0158a.m407a().m414e()) {
                    Debugger.m8609e("PushManager", "[PUSH] ignore registerPush() due to the limited data network");
                } else {
                    Debugger.m8615i("PushManager", "[PUSH] registerPush() start");
                    ((C13573a) this.f9308b).m14386f((Context) this.f9307a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void m13881j(String str) {
        Context context = (Context) this.f9307a;
        AbstractC4539a.m3190D("sendPushMessage() : appId = ", str, "PushManager");
        C0073a c0073a = (C0073a) this.f9311e;
        if (c0073a == null) {
            if (!C0145c.m338w(context)) {
                C0145c.m309Q(context, Boolean.TRUE);
            }
            Debugger.m8615i("PushManager", "mPushMessageListener is null!");
            return;
        }
        Context context2 = ((C6751f) c0073a.f254b).f4139a;
        if (!C0158a.m407a().m413c()) {
            Debugger.m8615i("GeneralManager", "onPushMessageReceived() : Ignore " + str);
            if (C0145c.m338w(context2)) {
                return;
            }
            C0145c.m309Q(context2, Boolean.TRUE);
            return;
        }
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncByPush() : " + str);
        if (C0322h.m670a().f833s.isBackgroundDownloading()) {
            C0322h.m670a().f833s.stopBackgroundDownload();
        }
        c14477aM15065b.f10283a.m5100j(CommonUtils.getNewNotesServiceId().equals(str) ? new C0099c(2) : new C0099c(4));
    }

    /* JADX INFO: renamed from: k */
    public void m13882k() {
        if (!C0158a.m407a().m414e()) {
            Debugger.m8609e("PushManager", "[PUSH] ignore unregisterPush() due to the limited data network");
            return;
        }
        synchronized (this.f9310d) {
            try {
                PushRegState pushRegState = (PushRegState) this.f9309c;
                PushRegState pushRegState2 = PushRegState.NOT_REGISTERED;
                if (pushRegState != pushRegState2) {
                    this.f9309c = pushRegState2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8615i("PushManager", "[PUSH] unregisterPush");
        C13573a c13573a = (C13573a) this.f9308b;
        Context context = (Context) this.f9307a;
        if (((C13527b) c13573a.f9635b) != null) {
            new SenlThreadFactory("unregisterPushThread").newThread(new RunnableC0037b(context, 8)).start();
        } else {
            Debugger.m8609e("PushClient", "[PUSH] unregisterPush : mRegisterMethod is null!");
        }
    }

    public C12969a(Context context) {
        this.f9308b = null;
        this.f9309c = PushRegState.NOT_REGISTERED;
        this.f9310d = new Object();
        this.f9311e = null;
        C0073a c0073a = new C0073a(this, 10);
        this.f9307a = context;
        C13573a c13573a = new C13573a(12, false);
        C13527b c13527b = new C13527b();
        c13527b.f9528a = c0073a;
        c13573a.f9635b = c13527b;
        this.f9308b = c13573a;
    }
}
