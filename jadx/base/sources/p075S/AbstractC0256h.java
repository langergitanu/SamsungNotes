package p075S;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.mobileservice.profile.ProfileApi;
import com.samsung.android.sdk.mobileservice.profile.result.ProfileResult;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: S.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0256h {
    /* JADX INFO: renamed from: a */
    public static ProfileApi m541a() throws ShareException {
        try {
            return new ProfileApi(C6715o.m4808q().m4798f());
        } catch (NotAuthorizedException e) {
            String str = "NotAuthorizedException : " + e.getMessage();
            Debugger.m8609e("SesCoeditProfileApi", str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
        } catch (NotConnectedException e2) {
            String str2 = "NotConnectedException : " + e2.getMessage();
            Debugger.m8609e("SesCoeditProfileApi", str2);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
        } catch (NotSupportedApiException e3) {
            String str3 = "NotSupportedApiException : " + e3.getMessage();
            Debugger.m8609e("SesCoeditProfileApi", str3);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
        } catch (Exception e5) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m542b() {
        if (!DeviceInfo.isVSTModel()) {
            try {
                ProfileResult profile = m541a().getProfile();
                CommonResultStatus status = profile.getStatus();
                if (status.getCode() != 1) {
                    Debugger.m8609e("SesCoeditProfileApi", "getUserName failed : " + status.getDisplayMessage());
                    return "";
                }
                Profile result = profile.getResult();
                if (result == null) {
                    Debugger.m8609e("SesCoeditProfileApi", "getUserName profile is null");
                    return "";
                }
                Profile.AccountName accountNameInstance = result.getAccountNameInstance();
                if ((accountNameInstance.getFamilyName() + accountNameInstance.getGivenName()).codePoints().anyMatch(new C0255g(0))) {
                    return accountNameInstance.getFamilyName() + accountNameInstance.getGivenName();
                }
                return accountNameInstance.getGivenName() + " " + accountNameInstance.getFamilyName();
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("getUserName exception "), "SesCoeditProfileApi");
                return "";
            }
        }
        String string = null;
        try {
            Cursor cursorQuery = BaseUtils.getApplicationContext().getContentResolver().query(Uri.parse("content://com.samsung.android.mobileservice.profileProvider/new_profile_single"), new String[]{"account_family_name", "account_given_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    Bundle extras = cursorQuery.getExtras();
                    cursorQuery.moveToFirst();
                    if (extras == null || !extras.containsKey("extra_info_display_full_name")) {
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("account_family_name"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("account_given_name"));
                        if ((string2 + string3).codePoints().anyMatch(new C0255g(0))) {
                            string = string2 + string3;
                        } else {
                            string = string3 + " " + string2;
                        }
                    } else {
                        string = extras.getString("extra_info_display_full_name");
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (Exception e2) {
            Debugger.m8615i("SesCoeditProfileApi", "exception : " + e2);
            return string;
        }
    }
}
