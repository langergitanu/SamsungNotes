package p010C;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.C6662a;
import com.samsung.android.app.notes.sync.C6751f;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.AbstractC6671a;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbstractC6718a;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6879f;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6883j;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.smp.Smp;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p025F0.C0094i;
import p042J1.AbstractC0155m;
import p068Q.C0204a;
import p079T.AbstractC0299q;
import p179f1.C11984d;
import p179f1.C11986f;
import p211o0.C13567a;
import p244u1.C14477a;

/* JADX INFO: renamed from: C.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0037b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f176a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f177b;

    public /* synthetic */ RunnableC0037b(Object obj, int i) {
        this.f176a = i;
        this.f177b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        C6715o c6715oM4808q;
        int i2;
        C6716p c6716pM4809q;
        ResultConsentData resultConsentData;
        FileInputStream fileInputStream;
        int length;
        JSONArray jSONArray;
        int length2;
        JSONArray jSONArray2;
        int i4 = this.f176a;
        boolean z = false;
        Object obj = this.f177b;
        switch (i4) {
            case 0:
                try {
                    ((C0038c) obj).f178a.m77n();
                    return;
                } catch (Exception e) {
                    AbstractC4539a.m3213w(e, new StringBuilder("bindSamsungCloudRPC() : fail to getSyncProfile() = "), "SCRPCSettingV1");
                    return;
                }
            case 1:
                C6785g c6785g = AbstractC6784f.f4180a;
                C6906i c6906i = (C6906i) obj;
                C0094i c0094i = (C0094i) ((C6903f) c6906i.f4484c).f4474b;
                c6785g.m4943b(c0094i.f306c, c0094i.f305b, c0094i.f304a);
                c6785g.m4948l();
                C6903f.m5117a((C6903f) c6906i.f4484c, (CompletableFuture) c6906i.f4483b, "HTTP_UNAUTHORIZED");
                return;
            case 2:
                if (AbstractC4539a.m3210t()) {
                    C13567a.m14371a().m14373d(new C6662a(this, 1));
                    return;
                } else {
                    if (UserManagerCompat.getInstance().isDigitalLegacyMode(((C6751f) obj).f4139a)) {
                        return;
                    }
                    C14477a.m15065b().m15071g("after signed in!");
                    return;
                }
            case 3:
                AbstractC6671a abstractC6671a = (AbstractC6671a) obj;
                try {
                    try {
                        if (!C6715o.m4808q().m4801j()) {
                            Debugger.m8609e("CoeditAbsShareHelper", "checkAuthorization() : SesSession is not connected!");
                            C6715o.m4808q().m4796c(3);
                            z = true;
                        }
                    } finally {
                        if (0 != 0) {
                            C6715o.m4808q().m4797d(3, null);
                        }
                    }
                } catch (Exception e2) {
                    Debugger.m8609e("CoeditAbsShareHelper", "Exception : " + e2.toString());
                    abstractC6671a.mo4767h(new C0204a("", 7));
                    if (0 == 0) {
                        return;
                    }
                }
                if (!C6715o.m4808q().m4801j()) {
                    Debugger.m8609e("CoeditAbsShareHelper", "checkAuthorization() : SesSession is not connected!!");
                    i = 3;
                    abstractC6671a.mo4767h(new C0204a("", 3));
                } else {
                    if (AbstractC6671a.m4766g(abstractC6671a)) {
                        if (!z) {
                            return;
                        }
                        c6715oM4808q = C6715o.m4808q();
                        i = 3;
                        c6715oM4808q.m4797d(i, null);
                        return;
                    }
                    i = 3;
                }
                if (z) {
                    c6715oM4808q = C6715o.m4808q();
                    c6715oM4808q.m4797d(i, null);
                    return;
                }
                return;
            case 4:
                AbstractC6718a abstractC6718a = (AbstractC6718a) obj;
                try {
                    try {
                        if (!C6716p.m4809q().m4801j()) {
                            Debugger.m8609e("AbsShareHelper", "checkAuthorization() : SesSession is not connected!");
                            C6716p.m4809q().m4796c(3);
                            z = true;
                        }
                    } catch (Exception e3) {
                        Debugger.m8609e("AbsShareHelper", "Exception : " + e3.toString());
                        abstractC6718a.mo4811h(new C0204a("", 7));
                        if (0 == 0) {
                            return;
                        }
                    }
                    if (!C6716p.m4809q().m4801j()) {
                        Debugger.m8609e("AbsShareHelper", "checkAuthorization() : SesSession is not connected!!");
                        i2 = 3;
                        abstractC6718a.mo4811h(new C0204a("", 3));
                    } else {
                        if (AbstractC6718a.m4810g(abstractC6718a)) {
                            if (!z) {
                                return;
                            }
                            c6716pM4809q = C6716p.m4809q();
                            i2 = 3;
                            c6716pM4809q.m4797d(i2, null);
                            return;
                        }
                        i2 = 3;
                    }
                    if (z) {
                        c6716pM4809q = C6716p.m4809q();
                        c6716pM4809q.m4797d(i2, null);
                        return;
                    }
                    return;
                } finally {
                    if (0 != 0) {
                        C6716p.m4809q().m4797d(3, null);
                    }
                }
            case 5:
                C6883j c6883j = (C6883j) obj;
                Debugger.m8607d("TaskRequestRequiredConsent", "run() : start TaskRequestRequiredConsentThread");
                try {
                    resultConsentData = (ResultConsentData) ((CompletableFuture) c6883j.f4420d).get(c6883j.f4418b, TimeUnit.SECONDS);
                    break;
                } catch (Exception e5) {
                    AbstractC0000a.m22s("[SA] run() : fail to waitForConsentData.get(), ", e5, "TaskRequestRequiredConsent");
                    resultConsentData = null;
                }
                if (((C6879f) c6883j.f4419c) != null) {
                    if (resultConsentData == null) {
                        Debugger.m8609e("TaskRequestRequiredConsent", "[SAE-6] run() : FAIL_CONSENT_INFO_TIMED_OUT");
                        ((C6879f) c6883j.f4419c).onError(StickyMemoSAConstants.EVENT_MORE_OPTION, StickyMemoSAConstants.EVENT_MORE_OPTION);
                        return;
                    }
                    if (!resultConsentData.getIsError()) {
                        ((C6879f) c6883j.f4419c).onReceived(resultConsentData);
                        return;
                    }
                    Debugger.m8609e("TaskRequestRequiredConsent", "[SAE-7] run() : fail to get consentData, errorCode = " + resultConsentData.getErrorCode());
                    String errorCode = resultConsentData.getErrorCode();
                    if (!TextUtils.isEmpty(errorCode)) {
                        String lowerCase = errorCode.toLowerCase();
                        lowerCase.getClass();
                        if (lowerCase.equals("unauthorized")) {
                            Debugger.m8609e("TaskRequestRequiredConsent", "[SA] prvHandleErrors() : setAccessTokenExpired");
                            C6875b c6875bM5062c = C6875b.m5062c();
                            c6875bM5062c.f4379e = c6875bM5062c.f4378d;
                            c6875bM5062c.f4376b = Boolean.TRUE;
                            c6875bM5062c.m5064b();
                        }
                    }
                    ((C6879f) c6883j.f4419c).onError(resultConsentData.getErrorCode(), resultConsentData.getErrorCode());
                    return;
                }
                return;
            case 6:
                String strM387b = AbstractC0155m.m387b(((C11984d) obj).f8596p, "memo.json");
                String str = C11984d.f8595q;
                AbstractC0299q.m643n(str, "restoreCategory. " + FileUtils.logPath(strM387b));
                ArrayList arrayList = new ArrayList();
                try {
                    fileInputStream = new FileInputStream(strM387b);
                    try {
                        JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                        if (jSONObjectM394i != null) {
                            jSONArray = jSONObjectM394i.getJSONArray("FolderList");
                            length = jSONArray.length();
                        } else {
                            length = 0;
                            jSONArray = null;
                        }
                        if (length < 1) {
                            AbstractC0299q.m646q(str, "Size Error.");
                        } else {
                            for (int i5 = 0; i5 < length; i5++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                                String string = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("title");
                                String uuid = PredefinedCategory.UNCATEGORIZED.getUuid();
                                if (jSONObject.has("parentUuid")) {
                                    String string3 = jSONObject.getString("parentUuid");
                                    if (!TextUtils.isEmpty(string3)) {
                                        uuid = string3;
                                    }
                                }
                                AbstractC0299q.m643n(C11984d.f8595q, "restore category uuid : " + string);
                                arrayList.add(new NotesCategoryTreeEntity(string, uuid, string2, null));
                            }
                            if (!arrayList.isEmpty()) {
                                FolderManager.getInstance().insert(arrayList);
                            }
                        }
                        fileInputStream.close();
                        return;
                    } finally {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                } catch (Exception e6) {
                    AbstractC6670b.m4762w(e6, new StringBuilder("Failed to restoreCategory() - "), C11984d.f8595q);
                    return;
                }
            case 7:
                String strM387b2 = AbstractC0155m.m387b(((C11986f) obj).f8600p, "QuickMemoPlusBackup_rename.json");
                String str2 = C11986f.f8599q;
                AbstractC0299q.m643n(str2, "restoreCategory. " + FileUtils.logPath(strM387b2));
                ArrayList arrayList2 = new ArrayList();
                try {
                    fileInputStream = new FileInputStream(strM387b2);
                    try {
                        JSONObject jSONObjectM394i2 = AbstractC0155m.m394i(fileInputStream);
                        if (jSONObjectM394i2 != null) {
                            jSONArray2 = jSONObjectM394i2.getJSONArray("FolderList");
                            length2 = jSONArray2.length();
                        } else {
                            length2 = 0;
                            jSONArray2 = null;
                        }
                        if (length2 < 1) {
                            AbstractC0299q.m646q(str2, "Size Error.");
                        } else {
                            for (int i6 = 0; i6 < length2; i6++) {
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i6);
                                String string4 = jSONObject2.getString("uuid");
                                String string5 = jSONObject2.getString("title");
                                String uuid2 = PredefinedCategory.UNCATEGORIZED.getUuid();
                                if (jSONObject2.has("parentUuid")) {
                                    String string6 = jSONObject2.getString("parentUuid");
                                    if (!TextUtils.isEmpty(string6)) {
                                        uuid2 = string6;
                                    }
                                }
                                AbstractC0299q.m643n(C11986f.f8599q, "restore category uuid : " + string4);
                                arrayList2.add(new NotesCategoryTreeEntity(string4, uuid2, string5, null));
                            }
                            if (!arrayList2.isEmpty()) {
                                FolderManager.getInstance().insert(arrayList2);
                            }
                        }
                        fileInputStream.close();
                        return;
                    } finally {
                    }
                } catch (Exception e7) {
                    AbstractC6670b.m4762w(e7, new StringBuilder("Failed to restoreCategory() - "), C11986f.f8599q);
                    return;
                }
            default:
                try {
                    Smp.clearData((Context) obj);
                    Debugger.m8615i("RegisterSmpUsingPam", "[PUSH] unregisterPush() finish");
                    return;
                } catch (Exception unused) {
                    Debugger.m8609e("RegisterSmpUsingPam", "[PUSH] unregisterPush : Exception = ");
                    return;
                }
        }
    }
}
