package p075S;

import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupMemberResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: S.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0254f {
    /* JADX INFO: renamed from: a */
    public static GroupApi m535a() throws ShareException {
        try {
            return new GroupApi(C6715o.m4808q().m4798f(), 501);
        } catch (NotAuthorizedException e) {
            String str = "NotAuthorizedException : " + e.getMessage();
            Debugger.m8609e("SesGroupApi", str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
        } catch (NotConnectedException e2) {
            String str2 = "NotConnectedException : " + e2.getMessage();
            Debugger.m8609e("SesGroupApi", str2);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
        } catch (NotSupportedApiException e3) {
            String str3 = "NotSupportedApiException : " + e3.getMessage();
            Debugger.m8609e("SesGroupApi", str3);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
        } catch (Exception e5) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized GroupResult m536b(String str) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m535a().requestGroup(str, new C0251c(completableFuture)) == 1) {
            return (GroupResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesGroupApi", "Fail to requestGroup");
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m537c(String str) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m535a().requestGroupInvitationRejection(str, new C0252d(completableFuture)) == 1) {
        } else {
            Debugger.m8609e("SesGroupApi", "Fail to requestGroupInvitationRejection");
        }
    }

    /* JADX INFO: renamed from: d */
    public static synchronized GroupMemberResult m538d(String str) {
        Debugger.m8607d("SesGroupApi", "start requestGroupMemberList");
        CompletableFuture completableFuture = new CompletableFuture();
        if (m535a().requestGroupMemberList(str, new C0253e(completableFuture)) == 1) {
            return (GroupMemberResult) completableFuture.get(10000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesGroupApi", "Fail to requestGroupMemberList");
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static synchronized BooleanResult m539e(String str) {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m535a().requestLeave(str, new C0249a(completableFuture)) == 1) {
            return (BooleanResult) completableFuture.get(10000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesGroupApi", "Fail to requestLeave");
        return null;
    }

    /* JADX INFO: renamed from: f */
    public static synchronized void m540f() {
        CompletableFuture completableFuture = new CompletableFuture();
        if (m535a().requestSync(new C0250b(completableFuture)) == 1) {
        } else {
            Debugger.m8609e("SesGroupApi", "Fail to requestSync");
        }
    }
}
