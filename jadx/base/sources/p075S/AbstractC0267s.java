package p075S;

import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.ItemListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: S.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0267s {

    /* JADX INFO: renamed from: a */
    public static final Object f715a = new Object();

    /* JADX INFO: renamed from: a */
    public static ShareApi m543a() throws ShareException {
        try {
            return new ShareApi(C6715o.m4808q().m4798f(), 501);
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
    public static boolean m544b() {
        try {
            long totalCountUsage = m543a().getQuota().getResult().getTotalCountUsage();
            long limitCountUsage = m543a().getQuota().getResult().getLimitCountUsage();
            Debugger.m8607d("SesShareApi", "isStorageFull# totalCountUsage : " + totalCountUsage + ", limitCountUsage : " + limitCountUsage);
            return totalCountUsage > 0 && totalCountUsage >= limitCountUsage;
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("isStorageFull# Exception : "), "SesShareApi");
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public static SpaceResult m545c(String str, String str2) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture completableFuture = new CompletableFuture();
        m543a().requestSpaceUpdate(str, str2, "", new C0263o(completableFuture));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        completableFuture.get(100000L, timeUnit);
        CompletableFuture completableFuture2 = new CompletableFuture();
        if (m543a().requestSpaceUpdate(str, false, (ShareApi.SpaceResultCallback) new C0264p(completableFuture2)) == 1) {
            return (SpaceResult) completableFuture2.get(100000L, timeUnit);
        }
        Debugger.m8609e("SesShareApi", "Fail to requestSpaceUpdate");
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static synchronized ItemListResult m546d(String str, List list) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m543a().requestSharedItemDeletion(str, (List<String>) list, new C0266r(completableFuture)) == 1) {
            return (ItemListResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesShareApi", "Fail to requestSharedItemDeletion(List)");
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static BooleanResult m547e(String str) {
        ShareApi shareApiM543a = m543a();
        CompletableFuture completableFuture = new CompletableFuture();
        synchronized (f715a) {
            try {
                if (shareApiM543a.requestSharedItemSync(str, null, new C0257i(completableFuture)) != 1) {
                    Debugger.m8607d("SesShareApi", "requestSharedItemSync. Request Failure!");
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

    /* JADX INFO: renamed from: f */
    public static SpaceResult m548f(String str) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m543a().requestSpace(str, new C0258j(completableFuture)) == 1) {
            return (SpaceResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesShareApi", "Fail to requestSpace");
        return null;
    }

    /* JADX INFO: renamed from: g */
    public static BooleanResult m549g() {
        ShareApi shareApiM543a = m543a();
        CompletableFuture completableFuture = new CompletableFuture();
        synchronized (f715a) {
            try {
                if (shareApiM543a.requestSync(new C0259k(completableFuture)) != 1) {
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
}
