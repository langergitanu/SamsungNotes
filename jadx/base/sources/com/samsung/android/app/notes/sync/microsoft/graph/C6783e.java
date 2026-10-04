package com.samsung.android.app.notes.sync.microsoft.graph;

import android.app.Activity;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalServiceException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import p016D0.C0059d;
import p025F0.AbstractC0089d;
import p033H0.C0112b;
import p042J1.C0145c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.microsoft.graph.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6783e implements AuthenticationCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6785g f4179a;

    public C6783e(C6785g c6785g) {
        this.f4179a = c6785g;
    }

    @Override // com.microsoft.identity.client.AuthenticationCallback
    public final void onCancel() {
        MSLogger.m8632d("GraphManager", "Authentication canceled");
    }

    @Override // com.microsoft.identity.client.SilentAuthenticationCallback
    public final void onError(MsalException msalException) {
        MSLogger.m8632d("GraphManager", "Authentication error");
        GraphManager$State graphManager$State = GraphManager$State.NONE;
        C6785g c6785g = this.f4179a;
        c6785g.f4184d = graphManager$State;
        WeakReference weakReference = c6785g.f4187g;
        if (weakReference == null) {
            return;
        }
        Activity activity = (Activity) weakReference.get();
        if (msalException instanceof MsalUiRequiredException) {
            MSLogger.m8632d("GraphManager", "Interactive login required");
            C0059d.m139g(BaseUtils.getApplicationContext()).getClass();
            AbstractC0089d.m230b(true);
            return;
        }
        if (!(msalException instanceof MsalClientException)) {
            if (msalException instanceof MsalServiceException) {
                MSLogger.m8633e("GraphManager", "Service error authenticating" + msalException);
                return;
            }
            return;
        }
        if (MsalClientException.NO_CURRENT_ACCOUNT.equals(msalException.getErrorCode())) {
            MSLogger.m8632d("GraphManager", "No current account, interactive login required");
            if (activity != null) {
                C0059d.m139g(BaseUtils.getApplicationContext()).m140c(activity, new C6783e(c6785g));
                return;
            } else {
                C0059d.m139g(BaseUtils.getApplicationContext()).getClass();
                AbstractC0089d.m230b(true);
                return;
            }
        }
        MSLogger.m8633e("GraphManager", "Client error authenticating" + msalException);
        c6785g.m4949m(false);
        c6785g.f4182b.clear();
        MSLogger.m8632d("GraphManager", "clear document list");
        c6785g.f4181a.clear();
        C0145c.m304L("GRAPH_PREFERENCE", "key_is_skipped_feed_sync_exist", false);
        MSLogger.m8633e("GraphManager", "can not continue upload. disable feed upload" + msalException.getErrorCode() + "," + msalException.getMessage());
    }

    @Override // com.microsoft.identity.client.SilentAuthenticationCallback
    public final void onSuccess(IAuthenticationResult iAuthenticationResult) {
        String accessToken = iAuthenticationResult.getAccessToken();
        MSLogger.m8632d("GraphManager", "Access token received");
        C0112b.m261h().m269m(accessToken, iAuthenticationResult.getAccount());
        AbstractC0089d.m230b(false);
        GraphManager$State graphManager$State = GraphManager$State.IDLE;
        C6785g c6785g = this.f4179a;
        c6785g.f4184d = graphManager$State;
        ConcurrentHashMap concurrentHashMap = c6785g.f4182b;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        MSLogger.m8632d("GraphManager", "Retry failed item. count : " + concurrentHashMap.size());
        c6785g.f4181a.putAll(concurrentHashMap);
        concurrentHashMap.clear();
        c6785g.m4947k(null);
    }
}
