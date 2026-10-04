package p234q1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6681f;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6728f;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.RunnableC6726d;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.migration.C6798g;
import com.samsung.android.app.notes.sync.network.AbstractC6848m;
import com.samsung.android.app.notes.sync.network.C6845j;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.quota.C6869b;
import com.samsung.android.app.notes.sync.quota.OneDriverTask;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.RecoveryTask;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocCategoryResolverContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.SharedFileUpdatedListener;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;
import p001A.AbstractC0000a;
import p002A0.C0009i;
import p003A1.C0012a;
import p017D1.AbstractC0067h;
import p022E1.C0082h;
import p025F0.AbstractC0089d;
import p025F0.C0094i;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p037I0.InterfaceC0123b;
import p042J1.AbstractC0153k;
import p042J1.C0143a;
import p044K.C0158a;
import p063P.InterfaceC0192a;
import p063P.InterfaceC0193b;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p093X.C0338f;
import p093X.RunnableC0336d;
import p253w1.InterfaceC14510a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: q1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14433b implements InterfaceC6855f, InterfaceC0122a, InterfaceC6669a, InterfaceC0193b, IAuthorizationListener, InterfaceC14510a {

    /* JADX INFO: renamed from: c */
    public static C14433b f10226c;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10227a;

    /* JADX INFO: renamed from: b */
    public Object f10228b;

    public /* synthetic */ C14433b(int i, boolean z) {
        this.f10227a = i;
    }

    /* JADX INFO: renamed from: l */
    public static byte[] m15031l(String str) {
        byte[] bArrCopyOf = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest.length == 32) {
                bArrCopyOf = Arrays.copyOf(bArrDigest, 32);
            } else {
                Log.e("WCon_WDocHashBlock", "fail to setHash : data size is not same");
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
        }
        return bArrCopyOf;
    }

    /* JADX INFO: renamed from: m */
    public static byte[] m15032m(String str) throws XmlPullParserException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest.length == 32) {
                return Arrays.copyOf(bArrDigest, 32);
            }
            Log.e("WCon_WDocHashBlock", "fail to setHash : data size is not same");
            return null;
        } catch (IOException | NoSuchAlgorithmException unused) {
            throw new XmlPullParserException("Fail to create hash block for hash.");
        }
    }

    /* JADX INFO: renamed from: p */
    public static synchronized C14433b m15033p(Context context) {
        try {
            if (f10226c == null) {
                C14433b c14433b = new C14433b(0, false);
                context.getApplicationContext();
                f10226c = c14433b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10226c;
    }

    /* JADX INFO: renamed from: q */
    public static String m15034q(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    @Override // p063P.InterfaceC0193b
    /* JADX INFO: renamed from: a */
    public void mo452a(String str) {
        Debugger.m8607d("MdeImportLogic", "onEnded()");
        ((C6728f) this.f10228b).getClass();
        Debugger.m8607d("MdeImportLogic", "onImportEnded : " + Long.toString(System.currentTimeMillis() - C6728f.f4084f) + "ms");
        ArrayList arrayList = C6728f.f4086h;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0192a) it.next()).onEnded(str, -1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: b */
    public void mo4732b(ArrayList arrayList) {
        ((C6681f) this.f10228b).m4776b(arrayList);
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: c */
    public void mo4733c() {
        C6681f c6681f = (C6681f) this.f10228b;
        c6681f.getClass();
        Debugger.m8607d("CoeditShareLogic", "onEnded()");
        AbstractC0299q.m615Y(c6681f.f3969c, true);
    }

    @Override // p063P.InterfaceC0193b
    /* JADX INFO: renamed from: d */
    public void mo453d(String str, ArrayList arrayList) {
        Debugger.m8607d("MdeImportLogic", "onError()");
        new Handler(Looper.getMainLooper()).post(new RunnableC6726d(this, str, arrayList, 1));
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: e */
    public void mo4734e(String str) {
        ArrayList arrayList = C6681f.f3981f;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((SharedFileUpdatedListener) it.next()).onSharedFileUpdated(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.InterfaceC6669a
    /* JADX INFO: renamed from: f */
    public void mo4735f() {
        Debugger.m8607d("CoeditShareLogic", "onShareStart()");
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        String string;
        switch (this.f10227a) {
            case 3:
                C0094i c0094i = (C0094i) ((C6742k) this.f10228b).f4110b;
                MSLogger.m8632d("UpdateNote", "result updateNote, onResult : " + c0124c);
                if (c0124c != null) {
                    try {
                        int i = c0124c.f387b;
                        if (i == 401) {
                            MSLogger.m8632d("UpdateNote", "result deleteNote, HTTP_RESPONSE_UNAUTHORIZED");
                            C6785g c6785g = AbstractC6784f.f4180a;
                            c6785g.m4943b(c0094i.f306c, c0094i.f305b, c0094i.f304a);
                            c6785g.m4948l();
                        } else if (i == -1) {
                            MSLogger.m8632d("UpdateNote", "result deleteNote, HTTP_RESPONSE_COMMON_FAILED");
                        } else if (i != 429) {
                            JSONObject jSONObject = new JSONObject(c0124c.f386a);
                            String string2 = jSONObject.getString("id");
                            try {
                                string = jSONObject.getString("lastModifiedDateTime");
                            } catch (JSONException unused) {
                                MSLogger.m8632d("UpdateNote", "updateNote, lastModifiedDateTime is not exist");
                                string = null;
                            }
                            if (string != null) {
                                MSLogger.m8632d("UpdateNote", "lastModifiedDateTime : " + string + ", connectedNotesId : " + string2);
                            }
                            if (TextUtils.isEmpty(string2)) {
                                AbstractC6784f.f4180a.m4943b(c0094i.f306c, c0094i.f305b, c0094i.f304a);
                            } else if (string != null) {
                                long jM15142b = AbstractC14517a.m15142b(string);
                                C6785g c6785g2 = AbstractC6784f.f4180a;
                                String str = c0094i.f306c;
                                c6785g2.getClass();
                                C6785g.m4941o(0, str, string2);
                                AbstractC0089d.m231c(jM15142b);
                            }
                        } else {
                            MSLogger.m8632d("UpdateNote", "result deleteNote, HTTP_RESPONSE_TOO_MANY_REQUESTS");
                        }
                    } catch (Exception e) {
                        AbstractC6670b.m4753n(e, new StringBuilder("Failed. "), "UpdateNote");
                        return;
                    }
                }
                break;
            default:
                InterfaceC0123b interfaceC0123b = (InterfaceC0123b) this.f10228b;
                MSLogger.m8632d("GraphHttpHelper", "onResult : " + c0124c);
                if (c0124c != null) {
                    int i2 = c0124c.f387b;
                    if (i2 == 401) {
                        MSLogger.m8632d("GraphHttpHelper", "onResult : HTTP_UNAUTHORIZED");
                        interfaceC0123b.onFailure(null);
                    } else if (i2 == 429) {
                        MSLogger.m8632d("GraphHttpHelper", "onResult : HTTP_TOO_MANY_REQUESTS");
                    } else if (i2 == -1) {
                        MSLogger.m8632d("GraphHttpHelper", "onResult : HTTP_RESPONSE_COMMON_FAILED");
                        interfaceC0123b.onFailure("HTTP_RESPONSE_COMMON_FAILED");
                    } else {
                        try {
                            JSONObject jSONObject2 = new JSONObject(c0124c.f386a);
                            String string3 = jSONObject2.getString("displayName");
                            String string4 = jSONObject2.getString("mail");
                            if (TextUtils.isEmpty(string4) || "null".equalsIgnoreCase(string4)) {
                                string4 = jSONObject2.getString("userPrincipalName");
                            }
                            interfaceC0123b.onSuccess(string3, string4);
                        } catch (Exception e2) {
                            MSLogger.m8633e("GraphHttpHelper", "Failed. " + e2.getMessage());
                            interfaceC0123b.onFailure(e2.getMessage());
                        }
                    }
                    break;
                }
                break;
        }
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f
    /* JADX INFO: renamed from: h */
    public void mo142h() throws SyncException {
        AbstractC0067h abstractC0067h = (AbstractC0067h) this.f10228b;
        C0082h c0082h = abstractC0067h.f238b;
        c0082h.m219f(abstractC0067h.f239c, "downloadFiles");
        c0082h.getClass();
        C0082h.m217e(null);
    }

    /* JADX INFO: renamed from: i */
    public C0338f m15035i() {
        C0338f c0338f = (C0338f) this.f10228b;
        if (c0338f.f856a.getIsDeleted() == 2) {
            FolderManager.getInstance().executeOperation(new RunnableC0336d(this));
        }
        if (c0338f.f858c) {
            try {
                long createdTime = SpenSDocFile.getCreatedTime(c0338f.f856a.getFilePath());
                long modifiedTime = SpenSDocFile.getModifiedTime(c0338f.f856a.getFilePath());
                if (createdTime == 0) {
                    Debugger.m8609e("SaveParamBuilder", "createdTime is 0. so set it to " + modifiedTime);
                    createdTime = modifiedTime;
                }
                c0338f.f856a.getTimeSaveParam().setTime(Long.valueOf(createdTime), Long.valueOf(modifiedTime));
                return c0338f;
            } catch (SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException unused) {
                Debugger.m8607d("SaveParamBuilder", "SaveParam file failed getModifiedTime");
            }
        }
        return c0338f;
    }

    @Override // p253w1.InterfaceC14510a
    public boolean isCancelled() {
        return ((RecoveryTask) this.f10228b).isCancelled();
    }

    /* JADX INFO: renamed from: j */
    public boolean m15036j(String str, String str2) {
        SDocCategoryResolverContractImpl sDocCategoryResolverContractImpl = C0322h.m670a().f829o;
        C0012a c0012a = (C0012a) this.f10228b;
        Context context = c0012a.f262e;
        HashMap map = c0012a.f70k;
        List uUIDListByCategory = sDocCategoryResolverContractImpl.getUUIDListByCategory(context, str, false);
        if (uUIDListByCategory == null) {
            Debugger.m8616s("SyncOldNote$SyncMergedCategory", "uuidList is null!");
            return false;
        }
        if (!uUIDListByCategory.isEmpty()) {
            Iterator it = uUIDListByCategory.iterator();
            while (it.hasNext()) {
                C0322h.m670a().f829o.setNoteCategory(c0012a.f262e, (String) it.next(), str2);
            }
        }
        if (map.size() > 0) {
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                C0009i c0009i = (C0009i) ((Map.Entry) it2.next()).getValue();
                if (str.equals(c0009i.f45h)) {
                    c0009i.f45h = str2;
                    if (!c0012a.f76q) {
                        c0012a.f76q = true;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: k */
    public void m15037k(String str) {
        Debugger.m8614f("SyncDelayInfoRepository", "delete, uuid : " + str);
        ((SyncDelayInfoDao) this.f10228b).delete(str);
    }

    /* JADX INFO: renamed from: n */
    public void m15038n(String str, String str2, IAuthorizationListener iAuthorizationListener) {
        Debugger.m8615i("SCloudAuthorizationManager", "getAuthorizationAsync()");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Debugger.m8609e("SCloudAuthorizationManager", "getAuthorizationAsync() : accessToken or userId is empty!");
        } else if (SCloudPamHelper.isInitializedForAccount()) {
            new SenlThreadFactory("GetAuthorizationThread1").newThread(new RunnableC14432a(this, str, str2, iAuthorizationListener, 0)).start();
        } else {
            new SenlThreadFactory("GetAuthorizationThread2").newThread(new RunnableC14432a(this, str, str2, iAuthorizationListener, 1)).start();
        }
    }

    /* JADX INFO: renamed from: o */
    public String m15039o(String str, String str2) {
        Debugger.m8615i("SCloudAuthorizationManager", "getAuthorizationSync()");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Debugger.m8609e("SCloudAuthorizationManager", "getAuthorizationSync() : accessToken or userId is empty!");
            return null;
        }
        if (!SCloudPamHelper.isInitializedForAccount()) {
            if (!SCloudPamHelper.initializeForAccount(str, str2)) {
                return null;
            }
            this.f10228b = str;
            return SCloudPamHelper.getToken();
        }
        Debugger.m8615i("SCloudAuthorizationManager", "getAuthorizationSync() : already initializedForAccount!");
        if (!str.equals((String) this.f10228b)) {
            SCloudPamHelper.updateAccountInfo(str, str2);
            this.f10228b = str;
        }
        return SCloudPamHelper.getToken();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onError(String str, String str2) {
        Debugger.m8610e("QT/QuotaHelper", AbstractC0541b.m774p("initQuotaUi() : fail to get authorization, errCode = ", str, " errMsg = ", str2), null);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onReceived(String str) {
        new OneDriverTask(((C6869b) this.f10228b).f4361a, str).execute(new Void[0]);
    }

    @Override // p063P.InterfaceC0193b
    public void onStart() {
        Debugger.m8607d("MdeImportLogic", "onStart()");
    }

    /* JADX INFO: renamed from: r */
    public void m15040r() {
        AbstractC0299q.m643n(C6798g.f4220k, "onBackUpCompleted");
        ((C6798g) this.f10228b).m4970o();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x012f, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0156, code lost:
    
        if (m15036j(r6, r12) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0159, code lost:
    
        r0.add(r6);
        p086V.C0322h.m670a().f829o.deleteCategory(r19.f262e, r6, r7, p086V.C0322h.m670a().f831q.getSdocContractYes(), false);
        r4 = p001A.AbstractC0000a.m16m("deleted2 - name:", r12, r2, r6, r15);
        r4.append(r12);
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8616s("SyncOldNote$SyncMergedCategory", r4.toString());
     */
    /* JADX INFO: renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m15041s() throws SyncException {
        String str;
        C0012a c0012a;
        String str2;
        int i;
        int i2;
        boolean z;
        String str3;
        String str4;
        ArrayList<String> arrayList = new ArrayList();
        C0012a c0012a2 = (C0012a) this.f10228b;
        long currentTime = TimeManager.getCurrentTime(c0012a2.f262e);
        SDocCategoryResolverContractImpl sDocCategoryResolverContractImpl = C0322h.m670a().f829o;
        Context context = c0012a2.f262e;
        boolean z2 = false;
        List categoryUUIDListByDeleted = sDocCategoryResolverContractImpl.getCategoryUUIDListByDeleted(context, false);
        if (categoryUUIDListByDeleted == null) {
            Debugger.m8616s("SyncOldNote$SyncMergedCategory", "Failed to getCategoryUUIDListByDeleted");
            return false;
        }
        int size = categoryUUIDListByDeleted.size();
        AbstractC0000a.m17n(size, "clist size : ", "SyncOldNote$SyncMergedCategory");
        String str5 = " -> ";
        String str6 = " , uuid:";
        boolean z3 = true;
        if (size > 1) {
            String str7 = (String) categoryUUIDListByDeleted.get(0);
            int i4 = 1;
            while (i4 < size) {
                String str8 = (String) categoryUUIDListByDeleted.get(i4);
                boolean z4 = z2;
                String categoryName = C0322h.m670a().f829o.getCategoryName(context, str8);
                List list = categoryUUIDListByDeleted;
                if (categoryName.equals(C0322h.m670a().f829o.getCategoryName(context, str7))) {
                    String str9 = str5;
                    if (str8.hashCode() > str7.hashCode()) {
                        str4 = str8;
                        str8 = str7;
                    } else {
                        str4 = str7;
                    }
                    if (!m15036j(str8, str4)) {
                        return z4;
                    }
                    arrayList.add(str8);
                    i = i4;
                    i2 = size;
                    str3 = str9;
                    c0012a = c0012a2;
                    str2 = str6;
                    z = true;
                    C0322h.m670a().f829o.deleteCategory(c0012a2.f262e, str8, currentTime, C0322h.m670a().f831q.getSdocContractYes(), false);
                    StringBuilder sbM16m = AbstractC0000a.m16m("deleted - name:", categoryName, str2, str8, str3);
                    sbM16m.append(str4);
                    Debugger.m8616s("SyncOldNote$SyncMergedCategory", sbM16m.toString());
                    str7 = str4;
                } else {
                    c0012a = c0012a2;
                    str2 = str6;
                    i = i4;
                    i2 = size;
                    z = true;
                    str3 = str5;
                    str7 = str8;
                }
                i4 = i + 1;
                str6 = str2;
                str5 = str3;
                z2 = z4;
                size = i2;
                categoryUUIDListByDeleted = list;
                c0012a2 = c0012a;
                z3 = z;
            }
        }
        C0012a c0012a3 = c0012a2;
        String str10 = str5;
        String str11 = str6;
        boolean z5 = z3;
        boolean z6 = z2;
        AbstractC0153k.m376e("SyncOldNote$SyncMergedCategory", "handle the predefines");
        List<String> categoryUUIDListByDeleted2 = C0322h.m670a().f829o.getCategoryUUIDListByDeleted(context, z6);
        if (categoryUUIDListByDeleted2 == null) {
            Debugger.m8616s("SyncOldNote$SyncMergedCategory", "Failed to getCategoryUUIDListByDeleted");
            return z6;
        }
        for (String str12 : categoryUUIDListByDeleted2) {
            String categoryName2 = C0322h.m670a().f829o.getCategoryName(context, str12);
            Iterator it = C0143a.m292a(context).f398b.iterator();
            while (true) {
                if (it.hasNext()) {
                    String str13 = (String) it.next();
                    if (str13 != null && str13.equals(categoryName2)) {
                        str = "2";
                        break;
                    }
                } else {
                    for (String str14 : C0143a.m292a(context).f397a) {
                        if (str14 == null || !str14.equals(categoryName2)) {
                            c0012a3 = c0012a3;
                        } else {
                            str = "1";
                        }
                    }
                }
            }
        }
        C0012a c0012a4 = c0012a3;
        AbstractC0153k.m376e("SyncOldNote$SyncMergedCategory", "delete category in server");
        if (!arrayList.isEmpty()) {
            C0158a.m407a().getClass();
            if (!C0158a.m410f()) {
                String string = Long.toString(currentTime);
                for (String str15 : arrayList) {
                    try {
                        C6845j c6845j = c0012a4.f69j;
                        C0112b c0112b = new C0112b();
                        c0112b.f362a = this;
                        c0112b.f363b = str15;
                        AbstractC6848m.m5008a(c6845j, str15, string, c0112b);
                    } catch (SyncException e) {
                        AbstractC6670b.m4752m(e, new StringBuilder("Failed to deleteFile - "), "SyncOldNote$SyncMergedCategory");
                        throw e;
                    }
                }
            }
        }
        return z5;
    }

    /* JADX INFO: renamed from: t */
    public void m15042t(long j) {
        C0338f c0338f = (C0338f) this.f10228b;
        c0338f.f856a.setServerTimestamp(Long.valueOf(j));
        c0338f.f856a.setKeepServerTimestamp(true);
    }

    public /* synthetic */ C14433b(Object obj, int i) {
        this.f10227a = i;
        this.f10228b = obj;
    }

    public C14433b(int i) {
        this.f10227a = i;
        switch (i) {
            case 12:
                this.f10228b = NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                break;
            default:
                this.f10228b = new C0338f();
                break;
        }
    }
}
