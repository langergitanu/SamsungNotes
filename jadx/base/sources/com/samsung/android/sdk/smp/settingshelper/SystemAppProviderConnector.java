package com.samsung.android.sdk.smp.settingshelper;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SystemAppProviderConnector {
    private static final String AUTHORITY_POST_FIX = ".smpProvider";
    private static final String COLUMN_URI = "uri";
    private static final String PROVIDER_PERMISSION_NAME = "com.sec.spp.push.permission.SMP_LANDING_PROVIDER";
    private static final String TAG = "SystemAppProviderConnector";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.database.Cursor] */
    public static String getUriData(Context context, String str) throws Throwable {
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        Uri uriBuild = Uri.parse(str).buildUpon().build();
        ?? r8 = 0;
        try {
            if (!isProviderHasPermission(context, uriBuild)) {
                SmpLog.m6494e(TAG, "fail to getUriData. provider does not have permission.");
                return null;
            }
            try {
                cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("uri"));
                            SmpLog.m6492d(TAG, "landingUri: " + string);
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e) {
                        exc = e;
                        SmpLog.m6494e(TAG, "getData exception. " + exc.toString());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                }
                SmpLog.m6494e(TAG, "cursor is null");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (Exception e2) {
                exc = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (r8 == 0) {
                    throw th;
                }
                r8.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r8 = context;
        }
    }

    private static boolean isProviderHasPermission(Context context, Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            SmpLog.m6494e(TAG, "fail to check permission. authority is empty");
            return false;
        }
        if (isProviderInSamePackage(context, authority)) {
            return true;
        }
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider != null) {
            return PROVIDER_PERMISSION_NAME.equals(providerInfoResolveContentProvider.readPermission);
        }
        SmpLog.m6494e(TAG, "fail to check permission. ProviderInfo is null");
        return false;
    }

    private static boolean isProviderInSamePackage(Context context, String str) {
        return context.getPackageName().equals(str.replace(AUTHORITY_POST_FIX, ""));
    }
}
