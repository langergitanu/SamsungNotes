package p012C1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6696j;
import com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6714n;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6708h;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.C6850a;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6883j;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6885l;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyItem;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p017D1.C0064e;
import p026F1.C0097a;
import p045K0.InterfaceC0160a;
import p069Q0.C0207b;
import p079T.AbstractC0299q;
import p079T.C0283a;
import p186h1.C12020a;
import p202m1.C13526a;
import p202m1.C13527b;
import p207n1.C13537d;
import p207n1.C13541h;
import p211o0.C13571e;
import p211o0.C13572f;
import p211o0.InterfaceC13568b;
import p212o1.C13573a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: C1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0045a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f188a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f189b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f190c;

    public /* synthetic */ RunnableC0045a(int i, Object obj, boolean z, Object obj2) {
        this.f188a = i;
        this.f189b = obj;
        this.f190c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:233:0x047e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r9v1, types: [org.json.JSONObject] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        boolean zM14382c;
        Throwable th;
        ?? r6;
        FileOutputStream fileOutputStream;
        StringBuilder sb;
        Bundle bundleCall;
        switch (this.f188a) {
            case 0:
                C13541h c13541h = (C13541h) this.f190c;
                if (((SyncException) c13541h.f9588a) != null) {
                    return;
                }
                try {
                    ((C6903f) this.f189b).m5129m();
                    return;
                } catch (SyncException e) {
                    c13541h.f9588a = e;
                    return;
                }
            case 1:
                StringBuilder sb2 = new StringBuilder("run() : result = ");
                boolean[] zArr = (boolean[]) this.f189b;
                sb2.append(zArr[0]);
                Debugger.m8615i("SyncNote/SyncSDocxCreateTempLocalNote", sb2.toString());
                ITempServerNoteListener iTempServerNoteListener = ((C0064e) this.f190c).f244h;
                if (iTempServerNoteListener == null) {
                    Debugger.m8615i("SyncNote/SyncSDocxCreateTempLocalNote", "run() : No listener");
                    return;
                }
                try {
                    if (zArr[0]) {
                        iTempServerNoteListener.onReceived();
                    } else {
                        iTempServerNoteListener.onFailed(0);
                    }
                    return;
                } catch (Exception e2) {
                    AbstractC0000a.m22s("perform() : After calling a listener, Exception = ", e2, "SyncNote/SyncSDocxCreateTempLocalNote");
                    return;
                }
            case 2:
                try {
                    zM14382c = C13573a.m14382c((C13573a) this.f190c);
                } catch (Exception e3) {
                    Logger.m8698e("OnenoteAccountLinkingStatusManager", e3.toString());
                    zM14382c = false;
                }
                try {
                    ((InterfaceC0160a) this.f189b).onFinished(zM14382c);
                    return;
                } catch (Exception e5) {
                    Logger.m8698e("OnenoteAccountLinkingStatusManager", e5.toString());
                    return;
                }
            case 3:
                C6903f c6903f = (C6903f) this.f189b;
                String str = (String) this.f190c;
                String str2 = C0207b.f638d;
                AbstractC0299q.m643n(str2, "create start");
                AbstractC0299q.m643n(str2, "createCategoryItems start");
                ArrayList arrayList = new ArrayList();
                Iterator<NotesFolder> it = FolderManager.getInstance().getAllNotesFolders(false).iterator();
                while (it.hasNext()) {
                    try {
                        NotesFolder next = it.next();
                        String uuid = next.getUuid();
                        if (uuid.equals(PredefinedCategory.UNCATEGORIZED.getUuid()) || uuid.equals(PredefinedCategory.SCREEN_OFF_MEMO.getUuid()) || uuid.equals(PredefinedCategory.MATH_NOTES.getUuid()) || uuid.equals(PredefinedCategory.RECYCLE_BIN.getUuid()) || uuid.equals(PredefinedCategory.OLD_NOTES.getUuid()) || uuid.equals("1") || uuid.equals("2")) {
                            AbstractC0299q.m643n(str2, "createCategoryItems skip uncategorized, screen off memo or recycle bin");
                        } else {
                            arrayList.add(next);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r6 = it;
                    }
                }
                try {
                    String string = BaseUtils.getApplicationContext().getString(C7943R.string.uncategorised);
                    ?? jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        NotesFolder notesFolder = (NotesFolder) arrayList.get(i);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("category_uuid", notesFolder.getUuid());
                        jSONObject2.put("id", notesFolder.getUuid());
                        jSONObject2.put("parentFolderNodeId", notesFolder.getParentUuid());
                        jSONObject2.put("name", TextUtils.isEmpty(notesFolder.getDisplayName()) ? string : notesFolder.getDisplayName());
                        String str3 = string;
                        jSONObject2.put("timestamp", notesFolder.getCreatedAt());
                        jSONObject2.put(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME, notesFolder.getLastModifiedAt());
                        jSONObject2.put("syncModifiedTime", notesFolder.getServerTimeStamp());
                        jSONObject2.put("restorePath", notesFolder.getRestorePath());
                        jSONObject2.put("deleted", notesFolder.getIsDeleted() == 2);
                        jSONObject2.put("categoryNameColor", notesFolder.getDisplayNameColor());
                        jSONObject2.put("order", notesFolder.getReorder());
                        jSONObject2.put(DBSchema.CategoryTree.IS_SYNC_WITH_MS, notesFolder.isSyncWithMS());
                        jSONObject2.put("recycle_bin_time_moved", notesFolder.getRecycleBinTimeMoved());
                        jSONArray.put(jSONObject2);
                        if (i % 50 == 0) {
                            AbstractC14517a.m15136U(c6903f, 7);
                        }
                        i++;
                        string = str3;
                    }
                    jSONObject.put("category_info", jSONArray);
                    File file = new File(str, "category.list");
                    if (file.exists() && !file.delete()) {
                        AbstractC0299q.m646q(str2, "create failed to delete category.list file");
                    }
                    if (file.createNewFile()) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                            break;
                        } catch (IOException e6) {
                            e = e6;
                            AbstractC0299q.m646q(str2, "create failed to backupCategoryInfo " + e.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    e = e7;
                                    sb = new StringBuilder("create exception while closing stream ");
                                    AbstractC0000a.m1B(e, sb, str2);
                                }
                            }
                            break;
                        } catch (JSONException e8) {
                            e = e8;
                            AbstractC0299q.m646q(str2, "create failed to backupCategoryInfo " + e.getMessage());
                            if (fileOutputStream != null) {
                            }
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e9) {
                            e = e9;
                            sb = new StringBuilder("create exception while closing stream ");
                            AbstractC0000a.m1B(e, sb, str2);
                        }
                    }
                    break;
                } catch (IOException e10) {
                    e = e10;
                    fileOutputStream = null;
                    AbstractC0299q.m646q(str2, "create failed to backupCategoryInfo " + e.getMessage());
                    if (fileOutputStream != null) {
                    }
                    AbstractC14517a.m15136U(c6903f, 8);
                    AbstractC0299q.m643n(str2, "create finish");
                    return;
                } catch (JSONException e11) {
                    e = e11;
                    fileOutputStream = null;
                    AbstractC0299q.m646q(str2, "create failed to backupCategoryInfo " + e.getMessage());
                    if (fileOutputStream != null) {
                    }
                    AbstractC14517a.m15136U(c6903f, 8);
                    AbstractC0299q.m643n(str2, "create finish");
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    r6 = 0;
                    if (r6 == 0) {
                        throw th;
                    }
                    try {
                        r6.close();
                        throw th;
                    } catch (IOException e12) {
                        AbstractC0000a.m1B(e12, new StringBuilder("create exception while closing stream "), str2);
                        throw th;
                    }
                }
                AbstractC14517a.m15136U(c6903f, 8);
                AbstractC0299q.m643n(str2, "create finish");
                return;
            case 4:
                ((CompletableFuture) this.f189b).complete(((C6696j) this.f190c).m4783a());
                return;
            case 5:
                C6708h c6708h = (C6708h) this.f189b;
                try {
                    c6708h.f4027c.onConnected();
                    break;
                } catch (Exception e13) {
                    AbstractC0000a.m21r(e13, new StringBuilder("[CS0-1] Exception in Ui listener: "), ((AbstractC6714n) this.f190c).mo4794a());
                }
                c6708h.f4028d = true;
                return;
            case 6:
                Debugger.m8607d("HttpClientSet", "clear thread start : " + ((C6850a) this.f189b).hashCode() + ", cnt : " + ((C6850a) this.f189b).f4282c);
                synchronized (((C6850a) this.f189b)) {
                    try {
                        if (((C6850a) this.f189b).f4282c != 0) {
                            return;
                        }
                        try {
                            ((C6850a) this.f190c).f4281b.close();
                            break;
                        } catch (IOException e14) {
                            Debugger.m8610e("HttpClientSet", "HTTP_CLIENT close err : ", e14);
                        }
                        synchronized (((C6850a) this.f189b)) {
                            C6850a c6850a = (C6850a) this.f189b;
                            c6850a.f4280a = null;
                            c6850a.f4281b = null;
                            c6850a.f4282c = -1;
                            break;
                        }
                        ArrayList arrayList2 = C6850a.f4278g;
                        synchronized (arrayList2) {
                            arrayList2.remove((C6850a) this.f189b);
                            Debugger.m8607d("HttpClientSet", "HttpClientSet closed.. - set : " + ((C6850a) this.f189b).hashCode() + ", total : " + arrayList2.size());
                            break;
                        }
                        return;
                    } finally {
                    }
                }
            case 7:
                C0283a c0283a = (C0283a) this.f190c;
                Context context = (Context) this.f189b;
                Uri uri = Uri.parse("content://com.samsung.android.samsungaccount.accountmanagerprovider");
                Bundle bundleCall2 = null;
                try {
                    Debugger.m8615i("AccountManagerProvider", "[SA] setVisability() : call getVisability");
                    bundleCall = context.getContentResolver().call(uri, "getSamsungAccountVisibilityByPackageName", CommonUtils.getAppServiceId(), (Bundle) null);
                } catch (Exception e15) {
                    AbstractC0000a.m22s("[SA] getVisability, Exception = ", e15, "AccountManagerProvider");
                    bundleCall = null;
                }
                if (bundleCall == null) {
                    Debugger.m8609e("AccountManagerProvider", "[SA] getVisability, Result is null!");
                } else if (bundleCall.containsKey("result_code")) {
                    int i2 = bundleCall.getInt("result_code");
                    if (i2 == 0) {
                        Debugger.m8615i("AccountManagerProvider", "[SA] getVisability, succeed!");
                        if (bundleCall.containsKey("result_value")) {
                            int i4 = bundleCall.getInt("result_value");
                            AbstractC0000a.m0A(i4, "result_value = ", "AccountManagerProvider");
                            if (i4 == 1 || i4 == 2) {
                                AbstractC0000a.m0A(i4, "[SA] getVisability, Visable = ", "AccountManagerProvider");
                                return;
                            }
                        } else {
                            Debugger.m8609e("AccountManagerProvider", "No result_value");
                        }
                    } else if (i2 == 1) {
                        Debugger.m8609e("AccountManagerProvider", "[SA] getVisability, fail!");
                        C0283a.m560a(c0283a, bundleCall);
                    } else {
                        Debugger.m8609e("AccountManagerProvider", "[SA] getVisability, result_code is invalid, " + i2);
                    }
                } else {
                    Debugger.m8609e("AccountManagerProvider", "[SA] getVisability, No result_code");
                }
                try {
                    Debugger.m8615i("AccountManagerProvider", "[SA] setVisability() : setVisability");
                    bundleCall2 = context.getContentResolver().call(uri, "setSamsungAccountVisibleByPackageName", CommonUtils.getAppServiceId(), (Bundle) null);
                } catch (Exception e16) {
                    AbstractC0000a.m22s("[SA] setVisability, Exception = ", e16, "AccountManagerProvider");
                }
                if (bundleCall2 == null) {
                    Debugger.m8609e("AccountManagerProvider", "[SA] setVisability, Result is null!");
                    return;
                }
                if (!bundleCall2.containsKey("result_code")) {
                    Debugger.m8609e("AccountManagerProvider", "[SA] getVisability, No result_code");
                    return;
                }
                int i5 = bundleCall2.getInt("result_code");
                if (i5 == 0) {
                    Debugger.m8614f("AccountManagerProvider", "[SA] setVisability, succeed!");
                    return;
                }
                if (i5 != 1) {
                    Debugger.m8609e("AccountManagerProvider", "[SA] setVisability, result_code is invalid, " + i5);
                    return;
                } else {
                    Debugger.m8609e("AccountManagerProvider", "[SA] setVisability, fail!");
                    C0283a.m560a(c0283a, bundleCall2);
                    return;
                }
                break;
            case 8:
                C6883j c6883j = (C6883j) this.f190c;
                Debugger.m8607d("TaskRequestRequiredConsent", "run() : start RequestRequiredConsentApiThread");
                try {
                    c6883j.m5084d();
                    C13537d c13537d = (C13537d) this.f189b;
                    Debugger.m8615i("TaskRequestRequiredConsent", "[SA] requestRequiredConsent()");
                    c6883j.f4421e = new C6885l(c6883j, c13537d, new C13573a(c6883j, 10));
                    C6875b.m5062c().m5066e((C6885l) c6883j.f4421e);
                    return;
                } catch (Exception e17) {
                    c6883j.m5080e(e17);
                    return;
                }
            case 9:
                ((C13527b) this.f190c).m14277a((Context) this.f189b);
                return;
            case 10:
                StringBuilder sb3 = new StringBuilder("[SA] notifyResultToListeners() : ");
                CountryPolicyListener countryPolicyListener = (CountryPolicyListener) this.f189b;
                sb3.append(countryPolicyListener);
                Debugger.m8615i("CountryPolicyController", sb3.toString());
                countryPolicyListener.onReceived((CountryPolicyItem) this.f190c);
                return;
            case 11:
                StringBuilder sb4 = new StringBuilder("[SA] notifyResultToListeners() : ");
                ConsentDataListener consentDataListener = (ConsentDataListener) this.f189b;
                sb4.append(consentDataListener);
                Debugger.m8615i("RequestRequiredConsentController", sb4.toString());
                consentDataListener.onReceived((ResultConsentData) this.f190c);
                return;
            case 12:
                StringBuilder sb5 = new StringBuilder("[EDP] notifyResultToStateListeners() : ");
                InterfaceC13568b interfaceC13568b = (InterfaceC13568b) this.f189b;
                sb5.append(interfaceC13568b);
                Debugger.m8615i("EdpInfoManager", sb5.toString());
                interfaceC13568b.mo4727b((C13572f) this.f190c);
                return;
            default:
                C13526a c13526a = (C13526a) ((C13573a) this.f190c).f9635b;
                Debugger.m8615i("RequestEdpStateTask", "[EDP] run() : start AuthApiThread");
                try {
                    C0097a c0097a = new C0097a();
                    String str4 = (String) this.f189b;
                    C6871d c6871d = new C6871d();
                    c6871d.f4368c = new C6903f(str4);
                    c6871d.f4366a = BaseUtils.getApplicationContext();
                    c6871d.f4369d = c0097a;
                    c6871d.m5060e((C12020a) c13526a.f9526b);
                    return;
                } catch (Exception e18) {
                    AbstractC0000a.m22s("[EDP] onReceived() : ", e18, "RequestEdpStateTask");
                    ((C13571e) c13526a.f9527c).f9627d = new C13572f(604, e18.toString());
                    ((C13571e) c13526a.f9527c).f9625b.countDown();
                    return;
                }
        }
    }

    public /* synthetic */ RunnableC0045a(Object obj, Object obj2, int i) {
        this.f188a = i;
        this.f190c = obj;
        this.f189b = obj2;
    }

    public RunnableC0045a(C0207b c0207b, C6903f c6903f, String str) {
        this.f188a = 3;
        this.f189b = c6903f;
        this.f190c = str;
    }
}
