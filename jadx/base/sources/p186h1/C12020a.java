package p186h1;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.MotionEventCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.microsoft.graph.GraphItem$RequestType;
import com.samsung.android.app.notes.sync.migration.common.Type$Flow;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.network.C6836a;
import com.samsung.android.app.notes.sync.network.C6837b;
import com.samsung.android.app.notes.sync.network.networkutils.AbstractC6854e;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.pen.base.SpenPointD;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.RunnableC9675B;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.MaxObjectLimitHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p007B0.C0020c;
import p010C.C0042g;
import p017D1.C0063d;
import p025F0.AbstractC0089d;
import p025F0.C0094i;
import p026F1.C0098b;
import p029G0.C0105b;
import p030G1.InterfaceC0107a;
import p033H0.C0111a;
import p036I.InterfaceC0121d;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0147e;
import p042J1.C0145c;
import p042J1.C0148f;
import p057N0.C0180a;
import p060O.InterfaceC0188b;
import p101Z.InterfaceC0349a;
import p174d1.C11972a;
import p182g0.C11998h;
import p206n0.C13533a;
import p234q1.C14434c;
import p243u0.AbstractC14471a;
import p243u0.C14476f;
import p249v1.C14499b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: h1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12020a implements InterfaceC6855f, InterfaceC0122a, InterfaceC0121d, InterfaceC0188b, InterfaceC6897a {

    /* JADX INFO: renamed from: c */
    public static C12020a f8770c;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8771a;

    /* JADX INFO: renamed from: b */
    public Object f8772b;

    public /* synthetic */ C12020a(char c, int i) {
        this.f8771a = i;
    }

    /* JADX INFO: renamed from: N */
    public static synchronized C12020a m13620N() {
        try {
            if (f8770c == null) {
                f8770c = new C12020a((char) 0, 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8770c;
    }

    /* JADX INFO: renamed from: f */
    public static int m13621f(String str) {
        if (str.isEmpty()) {
            return 2;
        }
        return str.getBytes().length + 2;
    }

    /* JADX INFO: renamed from: A */
    public void m13622A(int i, SpenRectD spenRectD) {
        ((ByteBuffer) this.f8772b).putDouble(i, spenRectD.left);
        ((ByteBuffer) this.f8772b).putDouble(i + 8, spenRectD.top);
        ((ByteBuffer) this.f8772b).putDouble(i + 16, spenRectD.right);
        ((ByteBuffer) this.f8772b).putDouble(i + 24, spenRectD.bottom);
    }

    /* JADX INFO: renamed from: B */
    public void m13623B(int i, RectF rectF) {
        ((ByteBuffer) this.f8772b).putFloat(i, rectF.left);
        ((ByteBuffer) this.f8772b).putFloat(i + 4, rectF.top);
        ((ByteBuffer) this.f8772b).putFloat(i + 8, rectF.right);
        ((ByteBuffer) this.f8772b).putFloat(i + 12, rectF.bottom);
    }

    /* JADX INFO: renamed from: C */
    public int m13624C(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("WRITE_STD_STRING - value is invalid.");
        }
        int i2 = 0;
        if (str.isEmpty()) {
            ((ByteBuffer) this.f8772b).putShort(i, (short) 0);
            return 2;
        }
        byte[] bytes = str.getBytes();
        m13647t(i, bytes.length);
        int i4 = i + 2;
        int length = bytes.length;
        while (i2 < length) {
            ((ByteBuffer) this.f8772b).put(i4, bytes[i2]);
            i2++;
            i4++;
        }
        return i4 - i;
    }

    /* JADX INFO: renamed from: D */
    public int m13625D(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("WRITE_STD_STRING - value is invalid.");
        }
        if (str.isEmpty()) {
            return 0;
        }
        byte[] bytes = str.getBytes();
        m13651x(i, bytes);
        return bytes.length;
    }

    /* JADX INFO: renamed from: E */
    public void m13626E(int i, String str) {
        byte[] bytes;
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            bytes = str.getBytes("UTF-16LE");
        } catch (UnsupportedEncodingException unused) {
            Debugger.m8609e("WDocBuffer", "Fail to encoding, text = [" + str + "]");
            bytes = null;
        }
        if (bytes != null) {
            int length = bytes.length;
            int i2 = 0;
            while (i2 < length) {
                ((ByteBuffer) this.f8772b).put(i, bytes[i2]);
                i2++;
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: F */
    public void m13627F(String str) {
        StringBuilder sb = (StringBuilder) this.f8772b;
        if (sb.length() != 0) {
            sb.append("\n");
        }
        if (str != null) {
            sb.append(str);
        }
    }

    /* JADX INFO: renamed from: G */
    public void m13628G(String str, String str2) {
        StringBuilder sb = (StringBuilder) this.f8772b;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AbstractC2821a.m2207B(sb, str, ": ", str2, "\n");
    }

    /* JADX INFO: renamed from: H */
    public void m13629H(HashMap map, String str) {
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap map2 = new HashMap(map);
        m13627F(str.concat(":"));
        for (Map.Entry entry : map2.entrySet()) {
            m13628G((String) entry.getKey(), (String) entry.getValue());
        }
    }

    /* JADX INFO: renamed from: I */
    public C11972a m13630I() {
        C11972a c11972a = (C11972a) this.f8772b;
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        c11972a.f8537b = C0148f.m352e();
        c11972a.f8545j = AbstractC14517a.m15155o(c11972a.f8544i);
        Type$Interface type$InterfaceM15156p = AbstractC14517a.m15156p(c11972a.f8544i);
        Type$Process type$ProcessM15158r = AbstractC14517a.m15158r(c11972a.f8544i);
        c11972a.f8546k = new C6903f(type$InterfaceM15156p, type$ProcessM15158r, Type$Flow.NONE);
        if (type$ProcessM15158r == Type$Process.INSTANT) {
            String strM15160t = AbstractC14517a.m15160t(c11972a.f8544i, "TARGET_PACKAGE");
            if (!TextUtils.isEmpty(strM15160t) && strM15160t.equals("SmartSwitch")) {
                c11972a.f8547l = "com.sec.android.easyMover";
                return c11972a;
            }
            c11972a.f8547l = "com.samsung.android.scloud";
        }
        return c11972a;
    }

    /* JADX INFO: renamed from: J */
    public void m13631J(int i) {
        if (i > ((ByteBuffer) this.f8772b).capacity()) {
            int iCapacity = ((ByteBuffer) this.f8772b).capacity();
            do {
                iCapacity *= 2;
            } while (i > iCapacity);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iCapacity);
            this.f8772b = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        ((ByteBuffer) this.f8772b).position(0);
    }

    /* JADX INFO: renamed from: K */
    public void m13632K(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            Debugger.m8614f("FolderWriteResolver", "[SyncDelete] deleteFolderDb, entityList: " + arrayList);
        }
        C13533a c13533a = (C13533a) this.f8772b;
        c13533a.getClass();
        Debugger.m8607d("SyncCategoryTreeRepository", "deleteFolderBySyncBatch ");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            SyncCategoryTreeDao syncCategoryTreeDao = c13533a.f9553b;
            syncCategoryTreeDao.deleteCategory(str);
            syncCategoryTreeDao.deleteCategoryClosure(str);
        }
    }

    /* JADX INFO: renamed from: L */
    public void m13633L(JSONObject jSONObject, String str) throws JSONException, SyncException {
        String string = jSONObject.getString("key");
        JSONObject jSONObject2 = new JSONObject(jSONObject.getString("value"));
        JSONArray jSONArray = jSONObject2.getJSONArray("FILEDETAIL");
        String string2 = jSONObject2.getJSONObject("FILES").getString("path");
        char c = '/';
        int i = 1;
        String strM1614d = AbstractC2322a.m1614d(4, 0, string2.substring(string2.lastIndexOf(47) + 1));
        int length = jSONArray.length();
        int i2 = 0;
        while (i2 < length) {
            String string3 = jSONArray.getJSONObject(i2).getString("path");
            String strSubstring = string3.substring(strM1614d.length() + string3.indexOf(strM1614d) + i);
            String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(c) + i);
            File file = new File(AbstractC0541b.m757C(str, "/", strSubstring));
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                throw new SyncException(312, "mkdirs failed");
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new SyncException(312, "mkdirs failed");
            }
            String strM15044b = C14434c.m15043a().m15044b("/ors/storage/sdcard0/SNote/" + string + c + strSubstring2 + "?action=download&cid=a1QGNqwu27");
            try {
                URL url = new URL(strM15044b);
                strM15044b = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toString();
            } catch (MalformedURLException | URISyntaxException e) {
                Debugger.m8609e("NT$LegacyNoteServiceHelper", e.getMessage());
            }
            boolean[] zArr = new boolean[i];
            zArr[0] = false;
            String str2 = (String) this.f8772b;
            AbstractC6854e.m5026f(str2, strM15044b, AbstractC0146d.m342a(str2), new C6837b(file, zArr));
            if (!zArr[0]) {
                throw new SyncException(312, "Getting legacy snote file failed.");
            }
            i2++;
            c = '/';
            i = 1;
        }
    }

    /* JADX INFO: renamed from: M */
    public ArrayList m13634M() throws JSONException {
        ArrayList arrayList = new ArrayList();
        String string = "";
        String[] strArr = {""};
        do {
            String strM15044b = C14434c.m15043a().m15044b("/kvs/items/?cid=a1QGNqwu27&count=1000&start=".concat(string));
            String str = (String) this.f8772b;
            AbstractC6854e.m5026f(str, strM15044b, AbstractC0146d.m342a(str), new C6836a(strArr, 0));
            JSONObject jSONObject = new JSONObject(strArr[0]);
            JSONArray jSONArray = jSONObject.getJSONArray(XmlErrorCodes.LIST);
            int length = jSONArray.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (!jSONObject2.getBoolean("deleted")) {
                        arrayList.add(jSONObject2);
                    }
                }
            }
            string = jSONObject.getString("nextKey");
            if (string == null) {
                break;
            }
        } while (string.length() > 0);
        return arrayList;
    }

    /* JADX INFO: renamed from: O */
    public void m13635O(XmlPullParser xmlPullParser) {
        ServerNoteInfo serverNoteInfo = (ServerNoteInfo) this.f8772b;
        C11998h c11998h = new C11998h(new C6906i(6));
        int attributeCount = xmlPullParser.getAttributeCount();
        boolean z = false;
        for (int i = 0; i < attributeCount; i++) {
            c11998h.m13599e(xmlPullParser, i);
        }
        serverNoteInfo.setModifiedTime(c11998h.f8664V);
        serverNoteInfo.setMinFormatVersion(c11998h.f8651I);
        if (!SyncState.isHighFormatVerTest() ? c11998h.f8651I > 5400 : c11998h.f8651I > 4000) {
            z = true;
        }
        Debugger.m8615i("ServerNoteInfoItem", "parseAttribute - minFormatVersion = " + c11998h.f8651I + ", isHighFormatVer = " + z);
        serverNoteInfo.setHighFormatVer(z);
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: a */
    public void mo5104a(int i, String str) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onFailed() : errorCode(", "), et = ");
        sbM778t.append(System.currentTimeMillis() - C14499b.f10315i);
        sbM778t.append(" , msg = ");
        sbM778t.append(str);
        Debugger.m8614f("SyncLogic", sbM778t.toString());
        if (i == 100 || i == 101) {
            C0145c.m309Q(C14499b.m15083b(), Boolean.TRUE);
        }
        C14499b.m15086f(i);
        if ((i & 101) == 101 && C0145c.m299G(C14499b.m15083b())) {
            SyncState.setWiFiNetworkFailed(true);
        } else {
            SyncState.setWiFiNetworkFailed(false);
        }
        AbstractC14471a abstractC14471aM15163w = AbstractC14517a.m15163w(i, C14499b.f10311e.f10329h.f322a);
        if (abstractC14471aM15163w instanceof C14476f) {
            C14476f c14476f = (C14476f) abstractC14471aM15163w;
            c14476f.f10279c = C14499b.f10314h;
            c14476f.f10280d = C14499b.f10311e.f10329h.f322a;
            c14476f.f10281e = new RunnableC9675B(2);
        }
        abstractC14471aM15163w.mo4791d();
        Debugger.m8615i("SyncLogic", "terminateSyncSelfService()");
        InterfaceC0349a interfaceC0349a = C14499b.f10317k;
        if (interfaceC0349a != null) {
            interfaceC0349a.mo672a();
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: b */
    public void mo5105b(C0098b c0098b) {
        Debugger.m8607d("SyncLogic", "[UiSyncProgress] onProgress() : ");
        ArrayList arrayList = C14499b.f10312f;
        synchronized (arrayList) {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((InterfaceC0107a) it.next()).onProgress(c0098b);
                    } catch (Exception e) {
                        Debugger.m8609e("SyncLogic", "onProgress() : Exception - " + e.getMessage());
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: c */
    public void mo5106c() {
        Debugger.m8607d("SyncLogic", "onSyncStart()");
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: d */
    public void mo5107d(int i) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onCancelled() cancelCode(", "), et = ");
        sbM778t.append(System.currentTimeMillis() - C14499b.f10315i);
        sbM778t.append("ms");
        Debugger.m8607d("SyncLogic", sbM778t.toString());
        if (SyncState.isWiFiNetworkFailed()) {
            SyncState.setWiFiNetworkFailed(false);
        }
        C14499b.m15086f(0);
        C0042g c0042gM78a = C0042g.m78a(C14499b.m15083b());
        if (c0042gM78a.m79b()) {
            c0042gM78a.f186b.mo70g();
        } else {
            Debugger.m8609e("SCRPCSettingManager", "notifySyncCancel() : fail!");
        }
        C0042g.m78a(C14499b.m15083b()).m82e();
        Debugger.m8615i("SyncLogic", "terminateSyncSelfService()");
        InterfaceC0349a interfaceC0349a = C14499b.f10317k;
        if (interfaceC0349a != null) {
            interfaceC0349a.mo672a();
        }
    }

    @Override // com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a
    /* JADX INFO: renamed from: e */
    public void mo5108e(int i) {
        C14499b c14499b = (C14499b) this.f8772b;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onEnded() resultCode(", "), et = ");
        sbM778t.append(System.currentTimeMillis() - C14499b.f10315i);
        sbM778t.append("ms");
        Debugger.m8607d("SyncLogic", sbM778t.toString());
        if (SyncState.isWiFiNetworkFailed()) {
            SyncState.setWiFiNetworkFailed(false);
        }
        C14499b.m15086f(0);
        if (UserManagerCompat.getInstance().isDigitalLegacyMode(C14499b.m15083b())) {
            if (i == 508 || i == 509) {
                C0042g c0042gM78a = C0042g.m78a(C14499b.m15083b());
                if (c0042gM78a.m79b()) {
                    c0042gM78a.f186b.mo72i(1);
                } else {
                    Debugger.m8609e("SCRPCSettingManager", "notifySyncError() : fail!");
                }
            }
            C0042g.m78a(C14499b.m15083b()).m82e();
        } else {
            C0042g.m78a(C14499b.m15083b()).m82e();
        }
        if (c14499b.f10319b == i && SystemClock.elapsedRealtime() - c14499b.f10320c < 60000) {
            Debugger.m8615i("SyncLogic", "isNeededToReFullSync() : false <- same resultCode and requested within 1 min");
        } else if (i == 351 || i == 508 || i == 509) {
            c14499b.f10319b = i;
            c14499b.f10320c = SystemClock.elapsedRealtime();
            C6904g c6904gM5132a = C6904g.m5132a();
            synchronized (c6904gM5132a) {
                if (c6904gM5132a.f4478a) {
                    Debugger.m8615i("SyncReSyncManager", "requestReSync() : is already scheduled");
                    return;
                }
                Debugger.m8615i("SyncReSyncManager", "requestReSync() : delaySec = 5");
                ((Timer) c6904gM5132a.f4479b).schedule(new C0180a(c6904gM5132a, 2), 5000);
                c6904gM5132a.f4478a = true;
                return;
            }
        }
        Debugger.m8615i("SyncLogic", "terminateSyncSelfService()");
        InterfaceC0349a interfaceC0349a = C14499b.f10317k;
        if (interfaceC0349a != null) {
            interfaceC0349a.mo672a();
        }
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        switch (this.f8771a) {
            case 3:
                C0020c c0020c = (C0020c) this.f8772b;
                String str = c0020c.f110a;
                String str2 = c0020c.f111b;
                MSLogger.m8632d(Bixby2Constants.BIXBY_ACTION_DELETE, "result deleteNote, onResult : " + c0124c);
                if (c0124c != null) {
                    try {
                        int i = c0124c.f387b;
                        if (i == -1) {
                            MSLogger.m8633e(Bixby2Constants.BIXBY_ACTION_DELETE, "Failed. HTTP_RESPONSE_COMMON_FAILED");
                            AbstractC6784f.f4180a.m4943b(str2, str, GraphItem$RequestType.DELETE);
                        } else if (i == 401) {
                            MSLogger.m8633e(Bixby2Constants.BIXBY_ACTION_DELETE, "Failed. HTTP_RESPONSE_UNAUTHORIZED");
                            C6785g c6785g = AbstractC6784f.f4180a;
                            c6785g.m4943b(str2, str, GraphItem$RequestType.DELETE);
                            c6785g.m4948l();
                        } else if (i == 429) {
                            MSLogger.m8633e(Bixby2Constants.BIXBY_ACTION_DELETE, "Failed. HTTP_RESPONSE_TOO_MANY_REQUESTS");
                        } else if (i == 404) {
                            MSLogger.m8633e(Bixby2Constants.BIXBY_ACTION_DELETE, "Failed. HTTP_RESOURCE_NOT_FOUND");
                            C6785g c6785g2 = AbstractC6784f.f4180a;
                            String str3 = c0020c.f111b;
                            c6785g2.getClass();
                            C6785g.m4940j(str3);
                            AbstractC0089d.m231c(System.currentTimeMillis());
                        } else if (c0124c.f386a.equals("NO_CONTENT")) {
                            C6785g c6785g3 = AbstractC6784f.f4180a;
                            String str4 = c0020c.f111b;
                            c6785g3.getClass();
                            C6785g.m4940j(str4);
                            AbstractC0089d.m231c(System.currentTimeMillis());
                        }
                    } catch (Exception e) {
                        AbstractC6670b.m4753n(e, new StringBuilder("Failed. "), Bixby2Constants.BIXBY_ACTION_DELETE);
                        return;
                    }
                }
                break;
            default:
                C0094i c0094i = (C0094i) ((C6742k) this.f8772b).f4110b;
                MSLogger.m8632d("UpdateNote", "result createNote, onResult : " + c0124c);
                if (c0124c != null) {
                    try {
                        int i2 = c0124c.f387b;
                        if (i2 == 401) {
                            MSLogger.m8632d("UpdateNote", "result deleteNote, HTTP_RESPONSE_UNAUTHORIZED");
                            C6785g c6785g4 = AbstractC6784f.f4180a;
                            c6785g4.m4943b(c0094i.f306c, c0094i.f305b, c0094i.f304a);
                            c6785g4.m4948l();
                        } else if (i2 == -1) {
                            MSLogger.m8632d("UpdateNote", "result deleteNote, HTTP_RESPONSE_COMMON_FAILED");
                        } else if (i2 == 429) {
                            MSLogger.m8632d("UpdateNote", "result deleteNote, HTTP_RESPONSE_TOO_MANY_REQUESTS");
                        } else {
                            JSONObject jSONObject = new JSONObject(c0124c.f386a);
                            String string = jSONObject.getString("id");
                            String string2 = jSONObject.getString("createdDateTime");
                            MSLogger.m8632d("UpdateNote", "createdDateTime : " + string2 + ",connectedNotesId : " + string);
                            if (TextUtils.isEmpty(string)) {
                                AbstractC6784f.f4180a.m4943b(c0094i.f306c, c0094i.f305b, c0094i.f304a);
                            } else {
                                int i4 = 0;
                                for (String str5 : c0094i.f308e) {
                                    if (DeviceInfo.isEngMode()) {
                                        MSLogger.m8632d("UpdateNote", "request add attachment. path : " + FileUtils.logPath(str5));
                                    }
                                    C0111a c0111aM256c = C0111a.m256c();
                                    i4++;
                                    C0105b c0105b = new C0105b(str5);
                                    c0111aM256c.getClass();
                                    C0111a.m254a(string, str5, i4, c0105b);
                                }
                                long jM15142b = AbstractC14517a.m15142b(string2);
                                C6785g c6785g5 = AbstractC6784f.f4180a;
                                String str6 = c0094i.f306c;
                                c6785g5.getClass();
                                C6785g.m4941o(1, str6, string);
                                AbstractC0089d.m231c(jM15142b);
                            }
                        }
                    } catch (Exception e2) {
                        AbstractC6670b.m4753n(e2, new StringBuilder("Failed. "), "UpdateNote");
                    }
                }
                break;
        }
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f
    /* JADX INFO: renamed from: h */
    public void mo142h() {
        C0063d c0063d = (C0063d) this.f8772b;
        c0063d.f238b.m219f(c0063d.f239c, "SyncSDocxCreateServerNote");
    }

    /* JADX INFO: renamed from: i */
    public void m13636i(int i) {
        ((ByteBuffer) this.f8772b).get(i);
    }

    /* JADX INFO: renamed from: j */
    public int m13637j(int i) {
        byte b = ((ByteBuffer) this.f8772b).get(i);
        return ((((ByteBuffer) this.f8772b).get(i + 1) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b & 255);
    }

    /* JADX INFO: renamed from: k */
    public PointF m13638k(int i) {
        PointF pointF = new PointF();
        pointF.x = ((ByteBuffer) this.f8772b).getFloat(i);
        pointF.y = ((ByteBuffer) this.f8772b).getFloat(i + 4);
        return pointF;
    }

    /* JADX INFO: renamed from: l */
    public void m13639l(int i, byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            bArr[i2] = ((ByteBuffer) this.f8772b).get(i);
            i2++;
            i++;
        }
    }

    /* JADX INFO: renamed from: m */
    public SpenPointD m13640m(int i) {
        SpenPointD spenPointD = new SpenPointD();
        spenPointD.x = ((ByteBuffer) this.f8772b).getDouble(i);
        spenPointD.y = ((ByteBuffer) this.f8772b).getDouble(i + 8);
        return spenPointD;
    }

    /* JADX INFO: renamed from: n */
    public Rect m13641n(int i) {
        Rect rect = new Rect();
        rect.left = ((ByteBuffer) this.f8772b).getInt(i);
        rect.top = ((ByteBuffer) this.f8772b).getInt(i + 4);
        rect.right = ((ByteBuffer) this.f8772b).getInt(i + 8);
        rect.bottom = ((ByteBuffer) this.f8772b).getInt(i + 12);
        return rect;
    }

    /* JADX INFO: renamed from: o */
    public SpenRectD m13642o(int i) {
        SpenRectD spenRectD = new SpenRectD();
        spenRectD.left = ((ByteBuffer) this.f8772b).getDouble(i);
        spenRectD.top = ((ByteBuffer) this.f8772b).getDouble(i + 8);
        spenRectD.right = ((ByteBuffer) this.f8772b).getDouble(i + 16);
        spenRectD.bottom = ((ByteBuffer) this.f8772b).getDouble(i + 24);
        return spenRectD;
    }

    /* JADX INFO: renamed from: p */
    public RectF m13643p(int i) {
        RectF rectF = new RectF();
        rectF.left = ((ByteBuffer) this.f8772b).getFloat(i);
        rectF.top = ((ByteBuffer) this.f8772b).getFloat(i + 4);
        rectF.right = ((ByteBuffer) this.f8772b).getFloat(i + 8);
        rectF.bottom = ((ByteBuffer) this.f8772b).getFloat(i + 12);
        return rectF;
    }

    /* JADX INFO: renamed from: q */
    public String m13644q(int i, int i2) {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        m13639l(i, bArr);
        return new String(bArr);
    }

    /* JADX INFO: renamed from: r */
    public String m13645r(int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        int i4 = i2 * 2;
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            bArr[i5] = ((ByteBuffer) this.f8772b).get(i);
            i5++;
            i++;
        }
        try {
            return new String(bArr, "UTF-16LE");
        } catch (UnsupportedEncodingException unused) {
            Debugger.m8609e("WDocBuffer", "Fail to decoding to text");
            return null;
        }
    }

    /* JADX INFO: renamed from: s */
    public void m13646s(int i, int i2) {
        ((ByteBuffer) this.f8772b).put(i, (byte) (i2 & 255));
    }

    /* JADX INFO: renamed from: t */
    public void m13647t(int i, int i2) {
        ((ByteBuffer) this.f8772b).put(i, (byte) (i2 & 255));
        ((ByteBuffer) this.f8772b).put(i + 1, (byte) ((i2 >> 8) & 255));
    }

    public String toString() {
        switch (this.f8771a) {
            case 5:
                return ((StringBuilder) this.f8772b).toString();
            default:
                return super.toString();
        }
    }

    /* JADX INFO: renamed from: u */
    public void m13648u(float f, int i) {
        ((ByteBuffer) this.f8772b).putFloat(i, f);
    }

    /* JADX INFO: renamed from: v */
    public void m13649v(int i, int i2) {
        ((ByteBuffer) this.f8772b).putInt(i, i2);
    }

    /* JADX INFO: renamed from: w */
    public void m13650w(int i, PointF pointF) {
        ((ByteBuffer) this.f8772b).putFloat(i, pointF.x);
        ((ByteBuffer) this.f8772b).putFloat(i + 4, pointF.y);
    }

    /* JADX INFO: renamed from: x */
    public void m13651x(int i, byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            ((ByteBuffer) this.f8772b).put(i + i2, bArr[i2]);
        }
    }

    /* JADX INFO: renamed from: y */
    public void m13652y(int i, SpenPointD spenPointD) {
        ((ByteBuffer) this.f8772b).putDouble(i, spenPointD.x);
        ((ByteBuffer) this.f8772b).putDouble(i + 8, spenPointD.y);
    }

    /* JADX INFO: renamed from: z */
    public void m13653z(int i, Rect rect) {
        ((ByteBuffer) this.f8772b).putInt(i, rect.left);
        ((ByteBuffer) this.f8772b).putInt(i + 4, rect.top);
        ((ByteBuffer) this.f8772b).putInt(i + 8, rect.right);
        ((ByteBuffer) this.f8772b).putInt(i + 12, rect.bottom);
    }

    public /* synthetic */ C12020a(Object obj, int i) {
        this.f8771a = i;
        this.f8772b = obj;
    }

    public C12020a(int i) {
        this.f8771a = 12;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.f8772b = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12020a(int i, byte b) {
        this(MaxObjectLimitHelper.STROKE_GROUP_LEVEL_1_LIMIT);
        this.f8771a = i;
        switch (i) {
            case 11:
                this.f8772b = new C11972a();
                break;
            case 12:
                break;
            default:
                this.f8772b = new ServerNoteInfo();
                break;
        }
    }

    public C12020a(byte[] bArr) {
        this.f8771a = 12;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f8772b = byteBufferWrap;
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
    }
}
