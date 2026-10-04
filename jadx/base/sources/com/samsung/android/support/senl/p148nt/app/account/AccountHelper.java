package com.samsung.android.support.senl.p148nt.app.account;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.sdk.mobileservice.auth.AuthConstants;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AccountHelper {
    private static final String EXTRA_SETTINGS_FRAGMENT_ARGS_KEY = ":settings:fragment_args_key";
    private static final String EXTRA_SETTINGS_SHOW_FRAGMENT_ARGS = ":settings:show_fragment_args";
    private static final String EXTRA_SETTINGS_SHOW_FRAGMENT_TAB = ":settings:show_fragment_tab";
    private static final String INTELLIGENCE_SERVICE_GLOBAL_SETTINGS_ACTION = "com.samsung.android.settings.action.INTELLIGENCE_SERVICE_GLOBAL_SETTINGS";
    private static final String PREVENT_ONLINE_PROCESSING = "prevent_online_processing";
    private static final int PRIVATE_TAB = 2;
    private static final String TAG = "AccountHelper";

    public static void confirmSamsungAccountByFragment(Fragment fragment, int i) {
        Context context;
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intent confirmSamsungAccountIntent = getConfirmSamsungAccountIntent();
        if (context.getPackageManager().queryIntentActivities(confirmSamsungAccountIntent, 0).isEmpty()) {
            return;
        }
        fragment.startActivityForResult(confirmSamsungAccountIntent, i);
    }

    @NonNull
    private static Intent getConfirmSamsungAccountIntent() {
        Logger.m8697d(TAG, "[SA] getSamsungAccountConfirmIntent()");
        if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.WEB) {
            throw new UnsupportedOperationException();
        }
        Intent intent = new Intent();
        intent.setClassName("com.osp.app.signin", "com.osp.app.signin.AccountView");
        intent.putExtra("client_id", CommonUtils.getAppServiceId());
        intent.putExtra("OSP_VER", "OSP_02");
        intent.putExtra("account_mode", "ACCOUNT_VERIFY");
        return intent;
    }

    @NonNull
    private static Intent getLoginSamsungAccountForLockIntent(Context context) {
        Logger.m8697d(TAG, "[SA] getLoginSamsungAccountForLockIntent()");
        return new Intent(context, (Class<?>) SamsungAccountLoginForLockActivity.class);
    }

    @NonNull
    public static Intent getLoginSamsungAccountPopupIntent(Context context) {
        Debugger.m8615i(TAG, "[SA] getLoginSamsungAccountPopupIntent()");
        if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.WEB) {
            return new Intent(context, (Class<?>) SamsungAccountPrimaryLoginActivity.class);
        }
        Intent intentM2214e = AbstractC2821a.m2214e("com.msc.action.samsungaccount.SIGNIN_POPUP", "com.osp.app.signin");
        intentM2214e.putExtra("client_id", CommonUtils.getAppServiceId());
        intentM2214e.putExtra("mypackage", context.getPackageName());
        intentM2214e.putExtra("OSP_VER", "OSP_02");
        intentM2214e.putExtra("MODE", "ADD_ACCOUNT");
        return intentM2214e;
    }

    @NonNull
    private static Intent getPreventOnlineProcessingSettingsIntent() {
        Bundle bundleM2215f = AbstractC2821a.m2215f(":settings:fragment_args_key", "prevent_online_processing");
        Intent intent = new Intent();
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setAction(INTELLIGENCE_SERVICE_GLOBAL_SETTINGS_ACTION);
        boolean zIsSecureFolderMode = UserHandleCompat.getInstance().isSecureFolderMode();
        if (zIsSecureFolderMode) {
            bundleM2215f.putInt(EXTRA_SETTINGS_SHOW_FRAGMENT_TAB, 2);
        }
        intent.putExtra(":settings:show_fragment_args", bundleM2215f);
        Logger.m8697d(TAG, "getPreventOnlineProcessingSettingsIntent, isSecureFolderMode: " + zIsSecureFolderMode);
        return intent;
    }

    @NonNull
    public static Intent getRequestAccessTokenIntent(Context context) {
        Debugger.m8615i(TAG, "[SA] getRequestAccessTokenIntent()");
        if (((AccountSamsungType) C13541h.m14287e().f9592e) == AccountSamsungType.WEB) {
            return new Intent(context, (Class<?>) SamsungAccountPrimaryLoginActivity.class);
        }
        Intent intentM2214e = AbstractC2821a.m2214e("com.msc.action.samsungaccount.REQUEST_ACCESSTOKEN", "com.osp.app.signin");
        intentM2214e.putExtra("client_id", CommonUtils.getAppServiceId());
        intentM2214e.putExtra("additional", new String[]{SearchIndexablesContract.RawData.COLUMN_USER_ID, "server_url", AuthConstants.EXTRA_AUTH_SERVER_URL, AuthConstants.EXTRA_API_SERVER_URL, "login_id", "mcc", LogBuilders.Property.COUNTRY_CODE, "is_child_account"});
        return intentM2214e;
    }

    @NonNull
    private static Intent getRequestSystemAiPermission(Context context) {
        Logger.m8697d(TAG, "getRequestSystemAiPermission()");
        Intent intent = new Intent("com.samsung.android.settings.action.INTELLIGENCE_SERVICE_SETTINGS");
        intent.putExtra("key_calling_package", context.getPackageName());
        intent.setPackage("com.android.settings");
        return intent;
    }

    public static void loginPopupSamsungAccount(Activity activity) {
        loginPopupSamsungAccount(activity, -1);
    }

    public static void loginRequestAccessToken(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        Intent requestAccessTokenIntent = getRequestAccessTokenIntent(activity);
        if (activity.getPackageManager().queryIntentActivities(requestAccessTokenIntent, 0).isEmpty()) {
            return;
        }
        if (i < 0) {
            activity.startActivity(requestAccessTokenIntent);
        } else {
            activity.startActivityForResult(requestAccessTokenIntent, i);
        }
    }

    public static boolean loginSamsungAccountByFragment(Fragment fragment, int i) {
        Context context;
        if (fragment == null || (context = fragment.getContext()) == null) {
            return false;
        }
        Intent loginSamsungAccountPopupIntent = getLoginSamsungAccountPopupIntent(context);
        if (context.getPackageManager().queryIntentActivities(loginSamsungAccountPopupIntent, 0).isEmpty()) {
            return false;
        }
        fragment.startActivityForResult(loginSamsungAccountPopupIntent, i);
        return true;
    }

    public static void loginSamsungAccountForLock(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        Intent loginSamsungAccountForLockIntent = getLoginSamsungAccountForLockIntent(activity);
        if (activity.getPackageManager().queryIntentActivities(loginSamsungAccountForLockIntent, 0).isEmpty()) {
            return;
        }
        activity.startActivityForResult(loginSamsungAccountForLockIntent, i);
    }

    public static void requestPreventOnlineProcessingSettings(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        Intent preventOnlineProcessingSettingsIntent = getPreventOnlineProcessingSettingsIntent();
        if (activity.getPackageManager().queryIntentActivities(preventOnlineProcessingSettingsIntent, 0).isEmpty()) {
            return;
        }
        try {
            if (i < 0) {
                activity.startActivity(preventOnlineProcessingSettingsIntent);
            } else {
                activity.startActivityForResult(preventOnlineProcessingSettingsIntent, i);
            }
        } catch (ActivityNotFoundException e) {
            Logger.m8697d(TAG, "loginSamsungAccountForAiPermission# " + e.getMessage());
        }
    }

    public static void requestSystemAiPermission(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        Intent requestSystemAiPermission = getRequestSystemAiPermission(activity);
        if (activity.getPackageManager().queryIntentActivities(requestSystemAiPermission, 0).isEmpty()) {
            return;
        }
        try {
            if (i < 0) {
                activity.startActivity(requestSystemAiPermission);
            } else {
                activity.startActivityForResult(requestSystemAiPermission, i);
            }
        } catch (ActivityNotFoundException e) {
            Logger.m8697d(TAG, "loginSamsungAccountForAiPermission# " + e.getMessage());
        }
    }

    public static void loginPopupSamsungAccount(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        Intent loginSamsungAccountPopupIntent = getLoginSamsungAccountPopupIntent(activity);
        if (activity.getPackageManager().queryIntentActivities(loginSamsungAccountPopupIntent, 0).isEmpty()) {
            return;
        }
        if (i < 0) {
            activity.startActivity(loginSamsungAccountPopupIntent);
        } else {
            activity.startActivityForResult(loginSamsungAccountPopupIntent, i);
        }
    }
}
