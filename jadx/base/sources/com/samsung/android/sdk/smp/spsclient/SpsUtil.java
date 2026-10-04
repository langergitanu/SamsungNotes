package com.samsung.android.sdk.smp.spsclient;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.SmpAppFilter;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpsUtil {
    private static final String APP_FILTER_KEY_DEVICE_ID = "p_deviceId";
    private static final String AUTHORITY_SPS_PROVIDER = "com.sec.spp.smpc.provider";
    private static final String PATH_APP_CLIENT_INIT = "appclientinit";
    private static final String PATH_DEVICE_ID = "deviceid";
    private static final String PATH_SPS_POLICY = "spspolicy";
    private static final String PATH_TEST_DEVICE = "testdevice";
    private static final String TAG = "SpsUtil";

    public static String getSeedFromSps(Context context) {
        return queryValueFromSps(context, "deviceid");
    }

    public static JSONObject getSpsPolicy(Context context) throws Throwable {
        String strQueryValueFromSps = queryValueFromSps(context, "spspolicy");
        if (TextUtils.isEmpty(strQueryValueFromSps)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strQueryValueFromSps);
            SmpLog.m6498i(TAG, "getSpsPolicy success. policy : " + strQueryValueFromSps);
            return jSONObject;
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, "getSpsPolicy error. " + e.toString());
            return null;
        }
    }

    public static String getTestDeviceName(Context context) {
        return queryValueFromSps(context, PATH_TEST_DEVICE);
    }

    public static boolean isDeviceIdAppFilterIncluded(Map<String, String> map) {
        return !TextUtils.isEmpty(map.get(APP_FILTER_KEY_DEVICE_ID));
    }

    public static int notifyAppClientInit(Context context) {
        return updateToSps(context, PATH_APP_CLIENT_INIT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String queryValueFromSps(Context context, String str) throws Throwable {
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        ?? r8 = 0;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.spp.smpc.provider/" + str), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(str));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e) {
                        exc = e;
                        SmpLog.m6494e(TAG, "queryValueFromSps error. " + exc.toString());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                }
                SmpLog.m6494e(TAG, "queryValueFromSps error. query fail");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                r8 = context;
                if (r8 != 0) {
                    throw th;
                }
                r8.close();
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r8 != 0) {
            }
        }
    }

    public static boolean setDeviceIdAppFilter(Context context, String str) {
        SmpLog.m6498i(TAG, "setDeviceIdAppFilter. deviceId:" + str);
        try {
            SmpAppFilter.set(context, APP_FILTER_KEY_DEVICE_ID, str);
            PrefManager.getInstance(context).setRandomSmpIdGenerated(true);
            return true;
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("setDeviceIdAppFilter error. "), TAG);
            return false;
        }
    }

    private static int updateToSps(Context context, String str) {
        try {
            return context.getContentResolver().update(Uri.parse("content://com.sec.spp.smpc.provider/" + str), null, null, null);
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("updateToSps error. "), TAG);
            return 0;
        }
    }
}
