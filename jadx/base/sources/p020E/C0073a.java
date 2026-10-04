package p020E;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.controllers.C6666b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6679d;
import com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6730h;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6864o;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.push.base.PushRegState;
import com.samsung.android.app.notes.sync.quota.C6868a;
import com.samsung.android.app.notes.sync.quota.C6870c;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.app.notes.sync.quota.QuotaServiceTask;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncProcessTask;
import com.samsung.android.kmxservice.sdk.e2ee.FabricIdSupplier;
import com.samsung.android.scloud.rpc.SamsungCloudRPCContract;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.TagContentItem;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p007B0.C0026i;
import p008B1.C0029b;
import p010C.C0042g;
import p017D1.C0070k;
import p026F1.C0097a;
import p028G.InterfaceC0102a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p173d0.C11971a;
import p178f0.C11980c;
import p191j0.C12923i;
import p191j0.C12930p;
import p191j0.C12931q;
import p195k1.C12969a;
import p199l1.InterfaceC13518b;
import p207n1.C13541h;
import p211o0.C13569c;
import p212o1.C13573a;
import p239s1.C14464b;
import p239s1.RunnableC14463a;
import p253w1.InterfaceC14510a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: E.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0073a implements InterfaceC6864o, InterfaceC6855f, InterfaceC6717a, IAuthorizationListener, InterfaceC14510a, InterfaceC13518b, FabricIdSupplier {

    /* JADX INFO: renamed from: c */
    public static C0073a f252c;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f253a;

    /* JADX INFO: renamed from: b */
    public Object f254b;

    public /* synthetic */ C0073a(int i) {
        this.f253a = i;
    }

    /* JADX INFO: renamed from: d */
    public static void m193d(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                AbstractC0000a.m20q(e, new StringBuilder("Exception while closing closable. "), "SC$SS$MigrationWidgetUtils");
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public static synchronized C0073a m194g() {
        try {
            if (f252c == null) {
                C0073a c0073a = new C0073a(0);
                C6666b c6666b = new C6666b();
                c6666b.f3945a = BaseUtils.getApplicationContext();
                c0073a.f254b = c6666b;
                f252c = c0073a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f252c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX INFO: renamed from: i */
    public static String m195i(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0155m.m387b(str, str2));
        sb.append(".widget");
        ?? r5 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(sb.toString());
                try {
                    JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                    JSONArray jSONArray = jSONObjectM394i != null ? jSONObjectM394i.getJSONArray("file_info") : null;
                    JSONObject jSONObject = jSONArray != null ? jSONArray.getJSONObject(0) : null;
                    String string = jSONObject != null ? jSONObject.getString("uuid") : null;
                    m193d(fileInputStream);
                    return string;
                } catch (IOException e) {
                    e = e;
                    Debugger.m8607d("SC$SS$MigrationWidgetUtils", "Failed to Migration.getNewUUIDInfo() - " + e.getMessage());
                    m193d(fileInputStream);
                    return null;
                } catch (JSONException e2) {
                    e = e2;
                    Debugger.m8607d("SC$SS$MigrationWidgetUtils", "Failed to Migration.getNewUUIDInfo() - " + e.getMessage());
                    m193d(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r5 = sb;
                m193d(r5);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            Debugger.m8607d("SC$SS$MigrationWidgetUtils", "Failed to Migration.getNewUUIDInfo() - " + e.getMessage());
            m193d(fileInputStream);
            return null;
        } catch (JSONException e5) {
            e = e5;
            fileInputStream = null;
            Debugger.m8607d("SC$SS$MigrationWidgetUtils", "Failed to Migration.getNewUUIDInfo() - " + e.getMessage());
            m193d(fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            m193d(r5);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX INFO: renamed from: n */
    public static String m196n(int i) throws Throwable {
        String str;
        FileInputStream fileInputStream;
        PostLaunchManager.getInstance().executeBaseLogics();
        File parentFile = C0322h.m670a().f815a.getAppContext().getFilesDir().getParentFile();
        ?? r4 = 0;
        strM195i = null;
        strM195i = null;
        String strM195i = null;
        FileInputStream fileInputStream2 = null;
        if (parentFile == null) {
            return null;
        }
        String strM387b = AbstractC0155m.m387b(parentFile.getAbsolutePath(), "SDocData/SSWL");
        try {
            try {
                fileInputStream = new FileInputStream(AbstractC0155m.m387b(strM387b, Integer.toString(i)) + ".widget");
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException | JSONException e) {
            e = e;
            str = null;
        }
        try {
            JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
            JSONArray jSONArray = jSONObjectM394i != null ? jSONObjectM394i.getJSONArray("file_info") : null;
            JSONObject jSONObject = jSONArray != null ? jSONArray.getJSONObject(0) : null;
            if (jSONObject != null) {
                String string = jSONObject.getString("uuid");
                strM195i = m195i(strM387b, string);
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "AppWidgetID : " + i + ", uuid : " + string);
            }
            m193d(fileInputStream);
            r4 = strM195i;
        } catch (IOException e2) {
            e = e2;
            str = strM195i;
            fileInputStream2 = fileInputStream;
            Debugger.m8609e("SC$SS$MigrationWidgetUtils", "Failed to Migration.restoreWidgetInfo() - " + e.getMessage());
            m193d(fileInputStream2);
            r4 = str;
        } catch (JSONException e3) {
            e = e3;
            str = strM195i;
            fileInputStream2 = fileInputStream;
            Debugger.m8609e("SC$SS$MigrationWidgetUtils", "Failed to Migration.restoreWidgetInfo() - " + e.getMessage());
            m193d(fileInputStream2);
            r4 = str;
        } catch (Throwable th2) {
            th = th2;
            r4 = fileInputStream;
            m193d(r4);
            throw th;
        }
        AbstractC4539a.m3190D("newUUID : ", r4, "SC$SS$MigrationWidgetUtils");
        return r4;
    }

    /* JADX INFO: renamed from: o */
    public static String m197o(int i, String str) throws Throwable {
        String str2;
        FileInputStream fileInputStream;
        JSONArray jSONArray;
        JSONObject jSONObject;
        File parentFile = C0322h.m670a().f815a.getAppContext().getFilesDir().getParentFile();
        FileInputStream fileInputStream2 = null;
        string = null;
        String string = null;
        fileInputStream2 = null;
        if (parentFile == null) {
            Debugger.m8607d("SC$SS$MigrationWidgetUtils", "restoreWidgetInfoValue. No directory");
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(AbstractC0155m.m387b(AbstractC0155m.m387b(parentFile.getAbsolutePath(), "SDocData/SSWL"), Integer.toString(i)) + ".widget");
            } catch (Exception e) {
                e = e;
                str2 = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
            if (jSONObjectM394i != null) {
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "restoreWidgetInfoValue. Original JSON exists.");
                jSONArray = jSONObjectM394i.getJSONArray("file_info");
            } else {
                jSONArray = null;
            }
            if (jSONArray != null) {
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "restoreWidgetInfoValue. SDOC_JSON_FILEINFO exists");
                jSONObject = jSONArray.getJSONObject(0);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                string = jSONObject.getString(str);
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "WidgetId : " + i + SQLKeyword.COMMA + str + " : " + string);
            }
            m193d(fileInputStream);
            return string;
        } catch (Exception e2) {
            e = e2;
            str2 = string;
            fileInputStream2 = fileInputStream;
            Debugger.m8609e("SC$SS$MigrationWidgetUtils", "Failed to Migration.restoreWidgetInfoValue() - " + e.getMessage());
            m193d(fileInputStream2);
            return str2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            m193d(fileInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: p */
    public static int m198p(int i, String str) throws Throwable {
        FileInputStream fileInputStream;
        JSONArray jSONArray;
        File parentFile = C0322h.m670a().f815a.getAppContext().getFilesDir().getParentFile();
        int i2 = -1;
        if (parentFile == null) {
            Debugger.m8607d("SC$SS$MigrationWidgetUtils", "restoreWidgetInfoValue. No directory");
            return -1;
        }
        FileInputStream fileInputStream2 = null;
        JSONObject jSONObject = null;
        fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(AbstractC0155m.m387b(AbstractC0155m.m387b(parentFile.getAbsolutePath(), "SDocData/SSWL"), Integer.toString(i)) + ".widget");
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
            if (jSONObjectM394i != null) {
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "restoreWidgetInfoValue. Original JSON exists.");
                jSONArray = jSONObjectM394i.getJSONArray("file_info");
            } else {
                jSONArray = null;
            }
            if (jSONArray != null) {
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "restoreWidgetInfoValue. SDOC_JSON_FILEINFO exists");
                jSONObject = jSONArray.getJSONObject(0);
            }
            if (jSONObject != null) {
                i2 = jSONObject.getInt(str);
                Debugger.m8607d("SC$SS$MigrationWidgetUtils", "WidgetId : " + i + SQLKeyword.COMMA + str + " : " + i2);
            }
            m193d(fileInputStream);
            return i2;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            Debugger.m8609e("SC$SS$MigrationWidgetUtils", "Failed to Migration.restoreWidgetInfoValue() - " + e.getMessage());
            m193d(fileInputStream2);
            return i2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            m193d(fileInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m199a(int i, int i2) {
        Debugger.m8607d("SC$SS$MigrationWidgetUtils", "addRestoreWidgetList. old : " + i + ", new : " + i2);
        ((ArrayList) this.f254b).add(new Integer[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: b */
    public void mo200b(ArrayList arrayList) {
        ((C6730h) this.f254b).m4824c(arrayList);
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: c */
    public void mo201c() {
        C6730h c6730h = (C6730h) this.f254b;
        c6730h.getClass();
        Debugger.m8607d("ShareLogic", "onEnded()");
        AbstractC0299q.m615Y(c6730h.f4074c, true);
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: e */
    public void mo202e(String str) {
        AbstractC4539a.m3190D("onShareUpdated() : ", str, "ShareLogic");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.InterfaceC6717a
    /* JADX INFO: renamed from: f */
    public void mo203f() {
        Debugger.m8607d("ShareLogic", "onShareStart()");
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.FabricIdSupplier
    public String getGUID() {
        UserManagerCompat userManagerCompat = UserManagerCompat.getInstance();
        Context context = ((C13569c) this.f254b).f9618a;
        if (!userManagerCompat.isDigitalLegacyMode(context)) {
            return C13541h.m14287e().m14293g();
        }
        C0042g c0042gM78a = C0042g.m78a(context);
        c0042gM78a.m79b();
        Bundle bundleMo66c = c0042gM78a.f186b.mo66c();
        if (bundleMo66c != null) {
            return bundleMo66c.getString(SamsungCloudRPCContract.Meta.DIGITAL_LEGACY_USER_ID);
        }
        return null;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f
    /* JADX INFO: renamed from: h */
    public void mo142h() {
        C0070k c0070k = (C0070k) this.f254b;
        c0070k.f238b.m219f(c0070k.f239c, "SyncSDocxUpdateLocalNote");
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6864o
    public void handleBinaryBody(String str, String str2, byte[] bArr) {
        C0029b c0029b = (C0029b) this.f254b;
        C12969a c12969a = c0029b.f150f;
        String str3 = str2.split("_")[0];
        if ("strokeGroupResource".equals(str)) {
            if (AbstractC0299q.f769b) {
                ((C12931q) ((C11980c) ((C11971a) c12969a.f9309c).f8526j.f4484c).f8582d.get(str3)).m13836u(C13569c.m14375c().m14377a(bArr));
            } else {
                ((C12931q) ((C11980c) ((C11971a) c12969a.f9309c).f8526j.f4484c).f8582d.get(str3)).m13836u(bArr);
            }
            ((C0097a) c0029b.f166c).f320c = true;
            c0029b.f152h += (long) bArr.length;
            c0029b.f154j++;
            return;
        }
        if ("strokeResource".equals(str)) {
            if (AbstractC0299q.f769b) {
                ((C12930p) ((C11980c) ((C11971a) c12969a.f9309c).f8526j.f4484c).f8581c.get(str3)).m13831u(C13569c.m14375c().m14377a(bArr));
            } else {
                ((C12930p) ((C11980c) ((C11971a) c12969a.f9309c).f8526j.f4484c).f8581c.get(str3)).m13831u(bArr);
            }
            c0029b.f152h += (long) bArr.length;
            c0029b.f153i++;
            return;
        }
        if ("mathResource".equals(str)) {
            if (!AbstractC0299q.f769b) {
                ((C12923i) ((C11980c) ((C11971a) c12969a.f9309c).f8526j.f4484c).f8583e.get(str3)).m13827u(bArr);
            } else {
                ((C12923i) ((C11980c) ((C11971a) c12969a.f9309c).f8526j.f4484c).f8583e.get(str3)).m13827u(C13569c.m14375c().m14377a(bArr));
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6864o
    public void handleStringBody(String str, String str2) {
        Debugger.m8607d("SyncNote/SDocxCompareForDownSync", "[Stroke] size of the XML part = " + str2.length());
        ((C0029b) this.f254b).f150f.m13878g(str2);
    }

    @Override // p253w1.InterfaceC14510a
    public boolean isCancelled() {
        return ((SyncProcessTask) this.f254b).isCancelled();
    }

    /* JADX INFO: renamed from: j */
    public void m204j(int i) {
        synchronized (((C12969a) this.f254b).f9310d) {
            try {
                if (i == 0) {
                    ((C12969a) this.f254b).f9309c = PushRegState.REGISTERED;
                } else {
                    if (i == -1) {
                        ((C12969a) this.f254b).getClass();
                    }
                    ((C12969a) this.f254b).f9309c = PushRegState.NOT_REGISTERED;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public void m205k(XmlPullParser xmlPullParser) {
        int attributeCount;
        C13573a c13573a = (C13573a) this.f254b;
        int eventType = xmlPullParser.getEventType();
        xmlPullParser.require(2, null, "passcode");
        do {
            if (eventType != 2) {
                if (eventType != 3 && eventType != 4) {
                    Debugger.m8615i("DownSyncSettingsItem", "parsePasscode - invalid eventType = [" + eventType + "]");
                }
            } else if (xmlPullParser.getName().equalsIgnoreCase("passcode") && (attributeCount = xmlPullParser.getAttributeCount()) != 0) {
                for (int i = 0; i < attributeCount; i++) {
                    if (xmlPullParser.getAttributeName(i).equalsIgnoreCase("syncModifiedTime")) {
                        ((C0026i) c13573a.f9635b).f142c = Long.parseLong(xmlPullParser.getAttributeValue(i));
                    }
                }
                String[] strArrSplit = AbstractC14517a.m15134S(xmlPullParser).split(",");
                if (strArrSplit.length == 2) {
                    C0026i c0026i = (C0026i) c13573a.f9635b;
                    c0026i.f140a = strArrSplit[0];
                    c0026i.f141b = strArrSplit[1];
                } else {
                    Debugger.m8609e("DownSyncSettingsItem", "parsePasscode - invalid PasswordInfo : passInfos.length = " + strArrSplit.length);
                    ((C0026i) c13573a.f9635b).f142c = 0L;
                }
            }
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            if (xmlPullParser.getName().equals("passcode")) {
                return;
            }
        } while (!xmlPullParser.getName().equals("sorting"));
    }

    /* JADX INFO: renamed from: l */
    public boolean m206l() throws SyncException {
        List list;
        HashMap map;
        int i;
        boolean z;
        C0012a c0012a = (C0012a) this.f254b;
        ArrayList<String> arrayList = new ArrayList();
        boolean z2 = false;
        List tagUUIDListByDeleted = C0322h.m670a().f830p.getTagUUIDListByDeleted(false);
        if (tagUUIDListByDeleted == null) {
            Debugger.m8616s("SyncOldNote$SyncMergedTag", "Failed to getTagUUIDListByDeleted");
            return false;
        }
        Context context = c0012a.f262e;
        HashMap map2 = c0012a.f73n;
        long currentTime = TimeManager.getCurrentTime(context);
        String string = Long.toString(currentTime);
        int size = tagUUIDListByDeleted.size();
        AbstractC0000a.m17n(size, "tagUuidList size : ", "SyncOldNote$SyncMergedTag");
        boolean z3 = true;
        if (size > 1) {
            String str = (String) tagUUIDListByDeleted.get(0);
            int i2 = 1;
            while (i2 < size) {
                String str2 = (String) tagUUIDListByDeleted.get(i2);
                String tagName = C0322h.m670a().f830p.getTagName(str2);
                String tagName2 = C0322h.m670a().f830p.getTagName(str);
                if (tagName.equalsIgnoreCase(tagName2)) {
                    if (C0322h.m670a().f830p.getTagServerTimestamp(str2) <= C0322h.m670a().f830p.getTagServerTimestamp(str)) {
                        str2 = str;
                        str = str2;
                    }
                    List sDocUUIDListByTag = C0322h.m670a().f830p.getSDocUUIDListByTag(str, z2);
                    if (sDocUUIDListByTag == null) {
                        Debugger.m8616s("SyncOldNote$SyncMergedTag", "sDocUuidList is null!");
                        return z2;
                    }
                    if (!sDocUUIDListByTag.isEmpty()) {
                        Iterator it = sDocUUIDListByTag.iterator();
                        while (it.hasNext()) {
                            C0322h.m670a().f830p.setNoteTag(c0012a.f262e, (String) it.next(), str, str2);
                            tagUUIDListByDeleted = tagUUIDListByDeleted;
                            map2 = map2;
                        }
                    }
                    list = tagUUIDListByDeleted;
                    map = map2;
                    if (map.size() > 0) {
                        Iterator it2 = map.entrySet().iterator();
                        while (it2.hasNext()) {
                            for (TagContentItem tagContentItem : (ArrayList) ((Map.Entry) it2.next()).getValue()) {
                                if (str.equals(tagContentItem.getTagUUID())) {
                                    tagContentItem.setTagUUID(str2);
                                    if (!c0012a.f77r) {
                                        c0012a.f77r = true;
                                    }
                                }
                            }
                        }
                    }
                    arrayList.add(str);
                    i = i2;
                    String str3 = str;
                    String str4 = str2;
                    z = true;
                    C0322h.m670a().f830p.deleteTag(c0012a.f262e, str3, currentTime, C0322h.m670a().f831q.getSdocContractYes(), false);
                    StringBuilder sbM16m = AbstractC0000a.m16m("deleted - name:", tagName2, " , uuid:", str3, " -> ");
                    sbM16m.append(str4);
                    Debugger.m8616s("SyncOldNote$SyncMergedTag", sbM16m.toString());
                    str = str4;
                } else {
                    list = tagUUIDListByDeleted;
                    map = map2;
                    i = i2;
                    z = true;
                    str = str2;
                }
                i2 = i + 1;
                z3 = z;
                tagUUIDListByDeleted = list;
                map2 = map;
                z2 = false;
            }
        }
        boolean z4 = z3;
        AbstractC0153k.m376e("SyncOldNote$SyncMergedTag", "delete tag in server");
        if (!arrayList.isEmpty()) {
            C0158a.m407a().getClass();
            if (!C0158a.m410f()) {
                for (String str5 : arrayList) {
                    try {
                        AbstractC6848m.m5008a(c0012a.f69j, str5, string, new C6742k(this, str5, 9));
                    } catch (SyncException e) {
                        AbstractC6670b.m4752m(e, new StringBuilder("Failed to deleteFile - "), "SyncOldNote$SyncMergedTag");
                        throw e;
                    }
                }
            }
        }
        return z4;
    }

    /* JADX INFO: renamed from: m */
    public void m207m(InterfaceC0102a interfaceC0102a) {
        ((C6666b) this.f254b).getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = C6679d.f3972g;
        copyOnWriteArrayList.remove(interfaceC0102a);
        Debugger.m8607d("MdeDeleteLogic", "Removed progress listener - size : " + copyOnWriteArrayList.size());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onError(String str, String str2) {
        switch (this.f253a) {
            case 8:
                Debugger.m8610e("QT/QuotaHelper", AbstractC0541b.m774p("getQuota() : fail to get authorization, errCode = ", str, " errMsg = ", str2), null);
                break;
            default:
                Debugger.m8610e("SyncServerNoteInfoHelper", AbstractC0541b.m774p("requestNoteInfo() : fail to get authorization, errCode = ", str, " errMsg = ", str2), null);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onReceived(String str) {
        switch (this.f253a) {
            case 8:
                C6870c c6870c = (C6870c) this.f254b;
                C6871d c6871d = c6870c.f4364b;
                c6871d.f4368c = new QuotaServiceTask(c6871d.f4366a, str, (C6868a) c6871d.f4369d, c6870c.f4363a);
                ((QuotaServiceTask) c6871d.f4368c).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                break;
            default:
                SenlThreadFactory senlThreadFactory = new SenlThreadFactory("ServerNoteInfoTaskThread");
                C14464b c14464b = (C14464b) this.f254b;
                senlThreadFactory.newThread(new RunnableC14463a(str, c14464b.f10259c.f10260a, c14464b.f10258b)).start();
                break;
        }
    }

    public /* synthetic */ C0073a(Object obj, int i) {
        this.f253a = i;
        this.f254b = obj;
    }
}
