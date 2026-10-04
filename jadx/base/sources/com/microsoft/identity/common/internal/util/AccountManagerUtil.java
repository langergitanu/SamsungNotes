package com.microsoft.identity.common.internal.util;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.UserManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class AccountManagerUtil {
    private static final String MANIFEST_PERMISSION_MANAGE_ACCOUNTS = "android.permission.MANAGE_ACCOUNTS";
    private static final String TAG = "AccountManagerUtil";

    private AccountManagerUtil() {
    }

    public static boolean canUseAccountManagerOperation(Context context, Set<String> set) {
        String[] accountTypesWithManagementDisabled;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":canUseAccountManagerOperation:", new StringBuilder());
        if (((UserManager) context.getSystemService(IdentityApiContract.Token.USER)).hasUserRestriction("no_modify_accounts")) {
            Logger.verbose(strM1170p, "UserManager.DISALLOW_MODIFY_ACCOUNTS is enabled for this user.");
            return false;
        }
        DevicePolicyManager devicePolicyManager = getDevicePolicyManager(context);
        if (devicePolicyManager == null || (accountTypesWithManagementDisabled = devicePolicyManager.getAccountTypesWithManagementDisabled()) == null) {
            return true;
        }
        for (String str : accountTypesWithManagementDisabled) {
            if (set.contains(str)) {
                Logger.info(strM1170p, "Account type " + str + " is disabled by MDM.");
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static DevicePolicyManager getDevicePolicyManager(@NonNull Context context) {
        try {
            return (DevicePolicyManager) context.getSystemService("device_policy");
        } catch (Throwable unused) {
            Logger.verbose(AbstractC0622a.m1170p(TAG, ":getDevicePolicyManager", new StringBuilder()), "Cannot get DevicePolicyManager.");
            return null;
        }
    }

    public static boolean isPermissionGranted(@NonNull Context context, @NonNull String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isPermissionGranted", new StringBuilder());
        boolean z = context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        Logger.verbose(strM1170p, "is " + str + " granted? [" + z + "]");
        return z;
    }
}
