package com.samsung.android.sdk.mobileservice;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.samsung.android.sdk.mobileservice.common.CommonConstants;
import com.samsung.android.sdk.mobileservice.common.CommonUtils;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SeMobileService {
    private static final String APP_ID_DAILY_BOARD = "wbu28c1241";
    private static final String APP_ID_GALLERY = "22n6hzkam0";
    private static final String APP_ID_SES_CALENDAR = "ses_calendar";
    private static final String APP_ID_SOCIAL_APP = "504k7c7fnz";
    private static final int COMMON_COLUMN_INDEX_LATEST_VERSION = 0;
    private static final String MOBILE_SERVICE_PROVIDER_PATH_ACCOUNT_BASE_SERVICE = "accountbaseservice";
    private static final String MOBILE_SERVICE_PROVIDER_PATH_COMMON = "common";
    private static final String MOBILE_SERVICE_PROVIDER_PATH_SERVICE_FEATURE = "feature";
    private static final String MOBILE_SERVICE_PROVIDER_PATH_SERVICE_STATUS = "status";
    private static final String MOBILE_SERVICE_PROVIDER_PATH_SOCIALFEATURE = "socialfeature";
    private static final String MOBILE_SERVICE_PROVIDER_URI = "com.samsung.android.mobileservice.provider.MobileServiceCapabilityProvider";
    private static final String SAMSUNG_ACCOUNT_PROVIDER_URI = "com.samsung.android.samsungaccount.mobileservice.SamsungAccountCapabilityProvider";
    public static final String SOCIAL_FEATURE_ACCOUNT_BASED_SERVICE = "account_based_service";
    public static final String SOCIAL_FEATURE_ACTIVITY_FEEDBACK_SERVICE = "activity_feedback_service";
    public static final String SOCIAL_FEATURE_ACTIVITY_HASH_CONTENTS = "activity_hash_contents";
    public static final String SOCIAL_FEATURE_APP_UPDATE_AND_LAUNCH_FOR_BUDDY = "app_update_and_launch_for_buddy";
    public static final String SOCIAL_FEATURE_BUDDY_CERTIFICATE_SHARING = "buddy_certificate_sharing";
    public static final String SOCIAL_FEATURE_CAPABILITY_SHARING = "capability_sharing";
    public static final String SOCIAL_FEATURE_DYNAMIC_SHARING_SETTINGS = "dynamic_sharing_settings";
    public static final String SOCIAL_FEATURE_FAMILY_GROUP_SHARING = "family_group_sharing";
    public static final String SOCIAL_FEATURE_GLOBAL_GROUP_SHARING = "global_group_sharing";
    public static final String SOCIAL_FEATURE_INSTANT_SHARING = "instant_sharing";
    public static final String SOCIAL_FEATURE_INVITATION_LINK = "invitation_link";
    public static final String SOCIAL_FEATURE_LOCAL_GROUP_SHARING = "local_group_sharing";
    public static final String SOCIAL_FEATURE_NOTE_COEDIT = "note_coedit";
    public static final String SOCIAL_FEATURE_PROFILE_CARD = "profile_card";
    public static final String SOCIAL_FEATURE_SA_FAMILY_GROUP = "sa_family_group";
    public static final String SOCIAL_FEATURE_SA_FAMILY_GROUP_TRASHBIN = "sa_family_group_trashbin";
    public static final String SOCIAL_FEATURE_SHARE_DATE_TAKEN = "share_date_taken";
    public static final String SOCIAL_FEATURE_SHARE_QUOTA = "share_quota";
    public static final String SOCIAL_FEATURE_SHARE_WEBLINK = "share_weblink";
    public static final String SOCIAL_FEATURE_SOCIAL_ACTIVITY_SERVICE = "social_activity_service";
    private static final String TAG = "SeMobileService";

    public static int getAgentLatestVersionInGalaxyApps(Context context) {
        List<Object> commonListFromAgentProvider = getCommonListFromAgentProvider(context);
        if (!CommonUtils.isAgentSupportMinVersion(CommonConstants.SupportedApiMinVersion.VERSION_4_1, context)) {
            return -1;
        }
        try {
            if (commonListFromAgentProvider.size() > 0) {
                return Integer.valueOf((String) commonListFromAgentProvider.get(0)).intValue();
            }
        } catch (Exception unused) {
            SdkLog.m5784i(TAG, "Exception during get agent latest version");
        }
        return -1;
    }

    public static int getAgentVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.mobileservice", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            SdkLog.m5785s(e);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3 A[PHI: r8
      0x00a3: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v4 android.database.Cursor) binds: [B:27:0x00a1, B:24:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, Integer> getApiStatusList(Context context, String[] strArr) {
        HashMap map = new HashMap();
        String strValueOf = String.valueOf(BuildConfig.VERSION_CODE);
        List<String> listAsList = Arrays.asList(strArr);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            if (!CommonUtils.isAgentSupportMinVersion(CommonConstants.SupportedApiMinVersion.VERSION_4_1, context)) {
                return null;
            }
            try {
                cursorQuery = contentResolver.query(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath("status").build(), null, strValueOf, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(0);
                        int iIntValue = Integer.valueOf(cursorQuery.getString(1)).intValue();
                        if (iIntValue < -4) {
                            iIntValue = -99;
                        }
                        SdkLog.m5784i(TAG, "api:" + string + ",status:" + iIntValue);
                        if (listAsList.contains(string)) {
                            map.put(string, Integer.valueOf(iIntValue));
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception e) {
                SdkLog.m5785s(e);
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (CommonUtils.isStandAloneSamsungAccountSupported(context)) {
                mergeApiStatusListOfSaAgent(context, map, listAsList);
            }
            for (String str : listAsList) {
                if (!map.containsKey(str)) {
                    map.put(str, -1);
                }
            }
            return map;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[PHI: r8
      0x0060: PHI (r8v4 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:18:0x005e, B:15:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<Object> getCommonListFromAgentProvider(Context context) {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath("common").build(), null, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(0);
                    SdkLog.m5782d(TAG, "latestVersionInGalaxyApps:" + string);
                    arrayList.add(string);
                }
            } catch (Exception e) {
                SdkLog.m5785s(e);
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private static List<Object> getCommonListFromSaAgentProvider(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").encodedAuthority(SAMSUNG_ACCOUNT_PROVIDER_URI).appendEncodedPath("common").build(), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        String string = cursorQuery.getString(0);
                        SdkLog.m5782d(TAG, "latestVersionInGalaxyApps:" + string);
                        arrayList.add(string);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Exception e) {
            SdkLog.m5785s(e);
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, List<String>> getFeatureList(Context context) {
        HashMap map = new HashMap();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        if (!CommonUtils.isAgentSupportMinVersion(CommonConstants.SupportedApiMinVersion.VERSION_4_1, context)) {
            return null;
        }
        try {
            try {
                cursorQuery = contentResolver.query(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath("feature").build(), null, null, null, null);
            } catch (Exception e) {
                SdkLog.m5785s(e);
                if (cursorQuery != null) {
                }
                if (CommonUtils.isStandAloneSamsungAccountSupported(context)) {
                }
                return map;
            }
            if (cursorQuery != null && cursorQuery.getCount() >= 1) {
                cursorQuery.moveToFirst();
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    SdkLog.m5784i(TAG, "feature service:" + string + ",api:" + string2);
                    if (map.containsKey(string)) {
                        ((List) map.get(string)).add(string2);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(string2);
                        map.put(string, arrayList);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                if (CommonUtils.isStandAloneSamsungAccountSupported(context)) {
                    mergeFeatureListOfSaAgent(context, map);
                }
                return map;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
                return map;
            }
            return map;
        } finally {
        }
    }

    public static int getSaAgentLatestVersionInGalaxyApps(Context context) {
        List<Object> commonListFromSaAgentProvider = getCommonListFromSaAgentProvider(context);
        if (CommonUtils.isSaAgentSupportMinVersion(CommonConstants.SupportedApiMinVersion.VERSION_11_0, context) && commonListFromSaAgentProvider != null) {
            try {
                if (commonListFromSaAgentProvider.size() > 0) {
                    return Integer.valueOf((String) commonListFromSaAgentProvider.get(0)).intValue();
                }
            } catch (Exception unused) {
                SdkLog.m5784i(TAG, "Exception during get samsung account agent latest version");
            }
        }
        return -1;
    }

    public static int getSaAgentVersion(Context context) {
        if (!CommonUtils.isStandAloneSamsungAccountSupported(context)) {
            return -1;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.osp.app.signin", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            SdkLog.m5785s(e);
            return -1;
        }
    }

    public static int getSdkVersionCode() {
        SdkLog.m5782d(TAG, "SDK Version Code = 1303200000");
        return BuildConfig.VERSION_CODE;
    }

    public static String getSdkVersionName() {
        SdkLog.m5782d(TAG, "SDK Version Name = 13.0.32");
        return BuildConfig.VERSION_NAME;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[PHI: r8
      0x007a: PHI (r8v4 android.database.Cursor) = (r8v3 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:24:0x0078, B:21:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Set<String> getSupportedSocialFeatureList(Context context, String str) {
        int agentVersion = getAgentVersion(context);
        if (agentVersion < 1010000000) {
            return getSupportedSocialFeatureListLegacy(agentVersion, str);
        }
        HashSet hashSet = new HashSet();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath(MOBILE_SERVICE_PROVIDER_PATH_SOCIALFEATURE).build(), null, str, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(0);
                        hashSet.add(string);
                        SdkLog.m5784i(TAG, "feature: " + string);
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception e) {
                SdkLog.m5785s(e);
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return hashSet;
        } finally {
        }
    }

    private static Set<String> getSupportedSocialFeatureListLegacy(int i, String str) {
        HashSet hashSet = new HashSet();
        if (str.equals(APP_ID_GALLERY)) {
            if (i >= 410000000) {
                if (i < 1000000000) {
                    hashSet.add(SOCIAL_FEATURE_GLOBAL_GROUP_SHARING);
                    hashSet.add(SOCIAL_FEATURE_FAMILY_GROUP_SHARING);
                    return hashSet;
                }
                hashSet.add(SOCIAL_FEATURE_GLOBAL_GROUP_SHARING);
                hashSet.add(SOCIAL_FEATURE_LOCAL_GROUP_SHARING);
                hashSet.add(SOCIAL_FEATURE_FAMILY_GROUP_SHARING);
                return hashSet;
            }
        } else if (str.equals(APP_ID_DAILY_BOARD)) {
            if (i >= 420000000) {
                if (i < 1000000000) {
                    hashSet.add(SOCIAL_FEATURE_GLOBAL_GROUP_SHARING);
                    hashSet.add(SOCIAL_FEATURE_FAMILY_GROUP_SHARING);
                    return hashSet;
                }
                hashSet.add(SOCIAL_FEATURE_GLOBAL_GROUP_SHARING);
                hashSet.add(SOCIAL_FEATURE_LOCAL_GROUP_SHARING);
                hashSet.add(SOCIAL_FEATURE_FAMILY_GROUP_SHARING);
                return hashSet;
            }
        } else if (str.equals(APP_ID_SOCIAL_APP)) {
            if (i >= 1000000000) {
                hashSet.add(SOCIAL_FEATURE_ACTIVITY_FEEDBACK_SERVICE);
                hashSet.add(SOCIAL_FEATURE_SOCIAL_ACTIVITY_SERVICE);
                return hashSet;
            }
        } else {
            if (!str.equals(APP_ID_SES_CALENDAR)) {
                SdkLog.m5782d(TAG, "appId :" + str + " is not support in getSupportedSocialFeatureListLegacy versionCode : " + i);
                return hashSet;
            }
            if (i >= 1000600000) {
                hashSet.add(SOCIAL_FEATURE_FAMILY_GROUP_SHARING);
                return hashSet;
            }
        }
        return hashSet;
    }

    public static boolean isAgentEnabled(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.mobileservice", 1).applicationInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m5784i(TAG, "Agent not installed");
            return false;
        }
    }

    public static boolean isAgentInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.samsung.android.mobileservice", 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m5784i(TAG, "Agent not installed");
            return false;
        }
    }

    public static boolean isSaAgentInstalled(Context context) {
        if (CommonUtils.isStandAloneSamsungAccountSupported(context)) {
            try {
                context.getPackageManager().getPackageInfo("com.osp.app.signin", 1);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                SdkLog.m5784i(TAG, "Samsung Account Agent not installed");
            }
        }
        return false;
    }

    public static Boolean isSupportAccountBasedService(Context context) {
        if (getAgentVersion(context) < 1210000000) {
            return Boolean.FALSE;
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        try {
            Cursor cursorQuery = contentResolver.query(new Uri.Builder().scheme("content").encodedAuthority(MOBILE_SERVICE_PROVIDER_URI).appendEncodedPath(MOBILE_SERVICE_PROVIDER_PATH_ACCOUNT_BASE_SERVICE).build(), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        z = true;
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e) {
            SdkLog.m5785s(e);
        }
        return Boolean.valueOf(z);
    }

    private static void mergeApiStatusListOfSaAgent(Context context, Map<String, Integer> map, List<String> list) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").encodedAuthority(SAMSUNG_ACCOUNT_PROVIDER_URI).appendEncodedPath("status").build(), null, String.valueOf(BuildConfig.VERSION_CODE), null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            String string = cursorQuery.getString(0);
                            int iIntValue = Integer.valueOf(cursorQuery.getString(1)).intValue();
                            if (iIntValue < -4) {
                                iIntValue = -99;
                            }
                            SdkLog.m5784i(TAG, "api:" + string + ",status:" + iIntValue);
                            if (list.contains(string)) {
                                map.put(string, Integer.valueOf(iIntValue));
                            }
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e) {
            SdkLog.m5785s(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void mergeFeatureListOfSaAgent(Context context, Map<String, List<String>> map) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").encodedAuthority(SAMSUNG_ACCOUNT_PROVIDER_URI).appendEncodedPath("feature").build(), null, null, null, null);
        } catch (Exception e) {
            SdkLog.m5785s(e);
            return;
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() >= 1) {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        SdkLog.m5784i(TAG, "feature service:" + string + ",api:" + string2);
                        if (map.containsKey(string)) {
                            map.get(string).add(string2);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(string2);
                            map.put(string, arrayList);
                        }
                    } while (cursorQuery.moveToNext());
                } else if (cursorQuery == null) {
                    return;
                }
            } finally {
            }
            SdkLog.m5785s(e);
            return;
        }
        if (cursorQuery == null) {
        }
        cursorQuery.close();
    }
}
