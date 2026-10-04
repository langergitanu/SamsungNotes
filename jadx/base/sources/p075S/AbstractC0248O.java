package p075S;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.ContentDownloadResult;
import com.samsung.android.sdk.mobileservice.social.share.result.ItemListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListResult;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p042J1.C0145c;

/* JADX INFO: renamed from: S.O */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0248O {

    /* JADX INFO: renamed from: a */
    public static final Object f699a = new Object();

    /* JADX INFO: renamed from: a */
    public static ShareApi m527a() throws ShareException {
        try {
            return new ShareApi(C6716p.m4809q().m4798f(), 104);
        } catch (NotAuthorizedException e) {
            String str = "NotAuthorizedException : " + e.getMessage();
            Debugger.m8609e("SesShareApi", str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
        } catch (NotConnectedException e2) {
            String str2 = "NotConnectedException : " + e2.getMessage();
            Debugger.m8609e("SesShareApi", str2);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
        } catch (NotSupportedApiException e3) {
            String str3 = "NotSupportedApiException : " + e3.getMessage();
            Debugger.m8609e("SesShareApi", str3);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
        } catch (Exception e5) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized ContentDownloadResult m528b(String str, List list, String str2, PendingIntent pendingIntent) {
        try {
            CompletableFuture completableFuture = new CompletableFuture();
            ArrayList arrayList = new ArrayList(list);
            try {
                if ((Build.VERSION.SDK_INT > 29 ? m527a().requestSharedContentDownload(str, arrayList, new C0245L(completableFuture), pendingIntent, null) : m527a().requestSharedContentDownload(str, arrayList, new C0246M(completableFuture), pendingIntent, (Bundle) null, str2)) == 1) {
                    return (ContentDownloadResult) completableFuture.get(600000L, TimeUnit.MILLISECONDS);
                }
                Debugger.m8609e("SesShareApi", "Fail to requestSharedContentDownload");
                return null;
            } catch (Exception e) {
                Debugger.m8609e("SesShareApi", "requestSharedContentDownload" + e.getMessage() + " " + e.toString());
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized ItemListResult m529c(String str, ArrayList arrayList) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m527a().requestSharedItemDeletion(str, arrayList, new C0247N(completableFuture)) == 1) {
            return (ItemListResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesShareApi", "Fail to requestSharedItemDeletion(List)");
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static void m530d(String str) throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSharedItemSync failed - wifi only");
        }
        ShareApi shareApiM527a = m527a();
        CompletableFuture completableFuture = new CompletableFuture();
        synchronized (f699a) {
            try {
                if (shareApiM527a.requestSharedItemSync(str, null, new C0273y(completableFuture)) != 1) {
                    Debugger.m8607d("SesShareApi", "requestSharedItemSync. Request Failure!");
                    return;
                }
                try {
                } catch (InterruptedException e) {
                    Debugger.m8609e("SesShareApi", "InterruptedException : " + e.toString());
                } catch (TimeoutException e2) {
                    Debugger.m8609e("SesShareApi", "TimeoutException : " + e2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static synchronized SharedItemListResult m531e(String str, ArrayList arrayList) {
        CompletableFuture completableFuture;
        completableFuture = new CompletableFuture();
        m527a().requestSharedItemUpdate(str, arrayList, new C0274z(completableFuture), null, null).setShareStatusListener(new C0234A());
        return (SharedItemListResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: f */
    public static void m532f(String str, ShareApi.SpaceResultCallback spaceResultCallback) throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSpace failed - wifi only");
        }
        CompletableFuture completableFuture = new CompletableFuture();
        new SenlThreadFactory("SesShareApi").newThread(new RunnableC0237D(spaceResultCallback, completableFuture, str)).start();
        ((Integer) completableFuture.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS)).getClass();
    }

    /* JADX INFO: renamed from: g */
    public static BooleanResult m533g() throws ShareException {
        ShareApi shareApiM527a = m527a();
        CompletableFuture completableFuture = new CompletableFuture();
        synchronized (f699a) {
            try {
                if (shareApiM527a.requestSync(new C0242I(completableFuture)) != 1) {
                    Debugger.m8607d("SesShareApi", "requestSync. Request Failure!");
                    return null;
                }
                try {
                    return (BooleanResult) completableFuture.get(TimeUnit.MINUTES.toMillis(2L), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Debugger.m8609e("SesShareApi", "InterruptedException : " + e.toString());
                    return null;
                } catch (TimeoutException e2) {
                    Debugger.m8609e("SesShareApi", "TimeoutException : " + e2.toString());
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m534h(ShareApi.ShareSyncResultCallback shareSyncResultCallback) throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSync failed - wifi only");
        }
        CompletableFuture completableFuture = new CompletableFuture();
        new SenlThreadFactory("SesShareApi").newThread(new RunnableC0241H(shareSyncResultCallback, completableFuture)).start();
        ((Integer) completableFuture.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS)).getClass();
    }
}
