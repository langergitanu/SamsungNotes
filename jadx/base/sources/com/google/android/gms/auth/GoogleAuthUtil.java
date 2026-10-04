package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GoogleAuthUtil extends zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;

    @NonNull
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";

    @NonNull
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    @NonNull
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(@NonNull Context context, @NonNull String str) throws GoogleAuthException, IOException {
        zzl.clearToken(context, str);
    }

    @NonNull
    public static List<AccountChangeEvent> getAccountChangeEvents(@NonNull Context context, int i, @NonNull String str) {
        return zzl.getAccountChangeEvents(context, i, str);
    }

    @NonNull
    public static String getAccountId(@NonNull Context context, @NonNull String str) {
        return zzl.getAccountId(context, str);
    }

    @NonNull
    public static String getToken(@NonNull Context context, @NonNull Account account, @NonNull String str) {
        return zzl.getToken(context, account, str);
    }

    @NonNull
    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(@NonNull Context context, @NonNull String str) {
        zzl.invalidateToken(context, str);
    }

    @NonNull
    @TargetApi(23)
    public static Bundle removeAccount(@NonNull Context context, @NonNull Account account) {
        return zzl.removeAccount(context, account);
    }

    @NonNull
    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(@NonNull Context context) {
        return zzl.requestGoogleAccountsAccess(context);
    }

    private static TokenData zzg(Context context, Account account, String str, Bundle bundle) throws GoogleAuthException, IOException {
        try {
            TokenData tokenDataZza = zzl.zza(context, account, str, bundle);
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            return tokenDataZza;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            Log.w("GoogleAuthUtil", "Error when getting token", e);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e);
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            Log.w("GoogleAuthUtil", "Error when getting token", e2);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e2);
        }
    }

    @NonNull
    public static String getToken(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle) {
        return zzl.getToken(context, account, str, bundle);
    }

    @NonNull
    @Deprecated
    public static String getToken(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return zzl.getToken(context, str, str2);
    }

    @NonNull
    @Deprecated
    public static String getToken(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        return zzl.getToken(context, str, str2, bundle);
    }

    @NonNull
    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle, @NonNull Intent intent) {
        zzl.zzf(intent);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("callback_intent", intent);
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @NonNull
    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle, @NonNull String str2, @NonNull Bundle bundle2) {
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @NonNull
    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @NonNull
    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle, @NonNull Intent intent) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @NonNull
    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle, @NonNull String str3, @NonNull Bundle bundle2) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }
}
