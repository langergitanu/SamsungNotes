package p075S;

import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupListResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupMemberResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupResult;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import p042J1.C0145c;
import p079T.C0293k;

/* JADX INFO: renamed from: S.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0272x {
    /* JADX INFO: renamed from: a */
    public static GroupApi m550a() throws ShareException {
        try {
            return new GroupApi(C6716p.m4809q().m4798f(), 104);
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
    public static GroupListResult m551b() throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "getGroupList failed - wifi only");
        }
        return m550a().getGroupList();
    }

    /* JADX INFO: renamed from: c */
    public static synchronized GroupResult m552c(String str) {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "getGroupList sync failed - wifi only");
        }
        CompletableFuture completableFuture = new CompletableFuture();
        if (m550a().requestGroup(str, new C0268t(completableFuture)) == 1) {
            return (GroupResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesGroupApi", "Fail to requestGroup");
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static synchronized BooleanResult m553d(String str) {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestGroupInvitationAcceptance sync failed - wifi only");
        }
        CompletableFuture completableFuture = new CompletableFuture();
        if (m550a().requestGroupInvitationAcceptance(str, new C0269u(completableFuture)) == 1) {
            return (BooleanResult) completableFuture.get(10000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesGroupApi", "Fail to requestGroupInvitationAcceptance");
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static void m554e(String str, GroupApi.GroupResultCallback groupResultCallback) throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestGroupInvitationAcceptance failed - wifi only");
        }
        m550a().requestGroupInvitationAcceptance(str, groupResultCallback);
    }

    /* JADX INFO: renamed from: f */
    public static synchronized void m555f(String str) {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestGroupInvitationRejection sync failed - wifi only");
        }
        CompletableFuture completableFuture = new CompletableFuture();
        if (m550a().requestGroupInvitationRejection(str, new C0270v(completableFuture)) == 1) {
        } else {
            Debugger.m8609e("SesGroupApi", "Fail to requestGroupInvitationRejection");
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m556g(String str, GroupApi.GroupResultCallback groupResultCallback) throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestGroupInvitationRejection failed - wifi only");
        }
        m550a().requestGroupInvitationRejection(str, groupResultCallback);
    }

    /* JADX INFO: renamed from: h */
    public static synchronized GroupMemberResult m557h(String str) {
        Debugger.m8607d("SesGroupApi", "start requestGroupMemberList");
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestGroupMemberList sync  failed - wifi only");
        }
        CompletableFuture completableFuture = new CompletableFuture();
        if (m550a().requestGroupMemberList(str, new C0271w(completableFuture)) == 1) {
            return (GroupMemberResult) completableFuture.get(10000L, TimeUnit.MILLISECONDS);
        }
        Debugger.m8609e("SesGroupApi", "Fail to requestGroupMemberList");
        return null;
    }

    /* JADX INFO: renamed from: i */
    public static void m558i(String str, C0293k c0293k) throws ShareException {
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestGroupMemberList failed - wifi only");
        }
        m550a().requestGroupMemberList(str, c0293k);
    }
}
