package p042J1;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import p001A.AbstractC0000a;
import p086V.C0322h;
import p211o0.C13569c;

/* JADX INFO: renamed from: J1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0145c {

    /* JADX INFO: renamed from: b */
    public static boolean f400b;

    /* JADX INFO: renamed from: c */
    public static boolean f401c;

    /* JADX INFO: renamed from: d */
    public static boolean f402d;

    /* JADX INFO: renamed from: e */
    public static boolean f403e;

    /* JADX INFO: renamed from: f */
    public static boolean f404f;

    /* JADX INFO: renamed from: g */
    public static boolean f405g;

    /* JADX INFO: renamed from: h */
    public static boolean f406h;

    /* JADX INFO: renamed from: i */
    public static boolean f407i;

    /* JADX INFO: renamed from: j */
    public static boolean f408j;

    /* JADX INFO: renamed from: k */
    public static boolean f409k;

    /* JADX INFO: renamed from: l */
    public static boolean f410l;

    /* JADX INFO: renamed from: m */
    public static boolean f411m;

    /* JADX INFO: renamed from: n */
    public static C0145c f412n;

    /* JADX INFO: renamed from: o */
    public static final char[] f413o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f'};

    /* JADX INFO: renamed from: p */
    public static String f414p;

    /* JADX INFO: renamed from: q */
    public static String f415q;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f416a;

    public /* synthetic */ C0145c(int i) {
        this.f416a = i;
    }

    /* JADX INFO: renamed from: A */
    public static boolean m293A(Context context) {
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isRoaming() : context is null");
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = (telephonyManager != null ? telephonyManager.isNetworkRoaming() : false) || (activeNetworkInfo != null ? activeNetworkInfo.isRoaming() : false);
        if (f407i != z) {
            f407i = z;
            Debugger.m8607d("SC/NetworkUtils", "isRoaming() : connection = " + f407i);
        }
        return f407i;
    }

    /* JADX INFO: renamed from: B */
    public static boolean m294B() {
        boolean zM323h = m323h("Settings", SettingsConstants.SETTINGS_BLOCKING_SYNC, false);
        AbstractC4539a.m3215y("SETTINGS_BLOCKING_SYNC is ", "SyncSettingsUtil", zM323h);
        return zM323h;
    }

    /* JADX INFO: renamed from: C */
    public static boolean m295C(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "isUserChangeSyncEnable() : context is null!");
            return false;
        }
        boolean z = context.getSharedPreferences("Settings", 0).getBoolean(SettingsConstants.SETTINGS_USERCHANGE_SYNCENABLE, false);
        AbstractC4539a.m3215y("SETTINGS_USERCHANGE_SYNCENABLE is ", "SyncSettingsUtil", z);
        return z;
    }

    /* JADX INFO: renamed from: D */
    public static boolean m296D(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "isUsingMobileDataWhenImporting() : context is null!");
            return false;
        }
        boolean z = context.getSharedPreferences("SyncService", 0).getBoolean("UsingDataWhenImport", false);
        AbstractC4539a.m3215y("SYNC_PREFERENCE_SYNC_USING_DATA_WHEN_IMPORT is ", "SyncSettingsUtil", z);
        return z;
    }

    /* JADX INFO: renamed from: E */
    public static boolean m297E(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean zHasCapability;
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isWiFiAvailable() : context is null");
            return false;
        }
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                zHasCapability = (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && !networkCapabilities.hasTransport(0)) ? networkCapabilities.hasCapability(12) : false;
                break;
            default:
                NetworkInfo networkInfoM321f = m321f(context);
                zHasCapability = false;
                if (networkInfoM321f != null && networkInfoM321f.getType() != 0) {
                    if (!networkInfoM321f.isConnectedOrConnecting()) {
                        if (networkInfoM321f.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) {
                            Debugger.m8615i("SC/NetworkUtilsUnderQosImpl", "isWiFiAvailable() : connection is BLOCKED");
                        }
                    } else if (networkInfoM321f.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) {
                        zHasCapability = true;
                    } else {
                        Debugger.m8609e("SC/NetworkUtilsUnderQosImpl", "isWiFiAvailable() : connection is BLOCKED");
                    }
                }
                break;
        }
        if (f404f != zHasCapability) {
            f404f = zHasCapability;
            Debugger.m8615i("SC/NetworkUtils", "isWiFiAvailable() : connection = " + f404f);
        }
        return f404f;
    }

    /* JADX INFO: renamed from: F */
    public static boolean m298F(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean z;
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isWiFiConnected() : context is null");
            return false;
        }
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                z = activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && !networkCapabilities.hasTransport(0);
                break;
            default:
                NetworkInfo networkInfoM321f = m321f(context);
                z = false;
                if (networkInfoM321f != null && networkInfoM321f.getType() != 0) {
                    z = true;
                }
                break;
        }
        if (f403e != z) {
            f403e = z;
            Debugger.m8615i("SC/NetworkUtils", "isWiFiConnected() : connection = " + f403e);
        }
        return f403e;
    }

    /* JADX INFO: renamed from: G */
    public static boolean m299G(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "isWiFiSyncOnly() : context is null!");
            return true;
        }
        boolean z = context.getSharedPreferences("Settings", 0).getBoolean("settings_wifi_sync_only", true);
        AbstractC4539a.m3215y("SETTINGS_WIFI_SYNC_ONLY is ", "SyncSettingsUtil", z);
        return z;
    }

    /* JADX INFO: renamed from: H */
    public static String m300H(String str, String str2) throws SyncException {
        if (str2 != null) {
            try {
                if (!str2.equals("")) {
                    try {
                        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str2.getBytes("UTF-8"));
                        char[] charArray = str.toCharArray();
                        int length = charArray.length;
                        if ((length & 1) != 0) {
                            throw new SyncException(332, "Odd number of characters.");
                        }
                        int i = length >> 1;
                        byte[] bArr = new byte[i];
                        int i2 = 0;
                        int i4 = 0;
                        while (i2 < length) {
                            int i5 = i2 + 1;
                            int iM315W = (m315W(charArray[i2], i2) << 4) | m315W(charArray[i5], i5);
                            i2 += 2;
                            bArr[i4] = (byte) (iM315W & 255);
                            i4++;
                        }
                        if (i != bArrDigest.length) {
                            throw new SyncException(332, "Lengths are different.");
                        }
                        byte[] bArr2 = new byte[i];
                        for (int i6 = 0; i6 < i; i6++) {
                            bArr2[i6] = (byte) (bArr[i6] ^ bArrDigest[i6]);
                        }
                        return m318c(bArr2);
                    } catch (NoSuchAlgorithmException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            } catch (UnsupportedEncodingException unused) {
                throw new SyncException(332, "failed to make checksum : UnsupportedEncodingException");
            }
        }
        throw new SyncException(332, "failed to make checksum with : invalid accessToken!");
    }

    /* JADX INFO: renamed from: I */
    public static void m301I(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean z;
        NetworkCapabilities networkCapabilities2;
        boolean zHasCapability;
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "[Network] printCurrentStates() : context is null");
            return;
        }
        Debugger.m8607d("SC/NetworkUtils", "[Network] isDataNetworkAvailable : " + m334s(context));
        Debugger.m8607d("SC/NetworkUtils", "[Network] isMobileConnected : " + m337v(context));
        Debugger.m8607d("SC/NetworkUtils", "[Network] isMobileAvailable : " + m336u(context));
        Debugger.m8607d("SC/NetworkUtils", "[Network] mIsWiFiConnected : " + m298F(context));
        Debugger.m8607d("SC/NetworkUtils", "[Network] isWiFiAvailable : " + m297E(context));
        StringBuilder sb = new StringBuilder("[Network] isNonMobileConnected : ");
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                z = activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && !networkCapabilities.hasTransport(0);
                break;
            default:
                NetworkInfo networkInfoM321f = m321f(context);
                z = false;
                if (networkInfoM321f != null && networkInfoM321f.getType() != 0) {
                    z = true;
                }
                break;
        }
        if (f405g != z) {
            f405g = z;
            Debugger.m8615i("SC/NetworkUtils", "isNonMobileConnected() : connection = " + f405g);
        }
        sb.append(f405g);
        Debugger.m8607d("SC/NetworkUtils", sb.toString());
        StringBuilder sb2 = new StringBuilder("[Network] isNonMobileAvailable : ");
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork2 = connectivityManager2.getActiveNetwork();
                zHasCapability = (activeNetwork2 != null && (networkCapabilities2 = connectivityManager2.getNetworkCapabilities(activeNetwork2)) != null && !networkCapabilities2.hasTransport(0)) ? networkCapabilities2.hasCapability(12) : false;
                break;
            default:
                NetworkInfo networkInfoM321f2 = m321f(context);
                zHasCapability = false;
                if (networkInfoM321f2 != null && networkInfoM321f2.getType() != 0) {
                    if (!networkInfoM321f2.isConnectedOrConnecting()) {
                        if (networkInfoM321f2.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) {
                            Debugger.m8615i("SC/NetworkUtilsUnderQosImpl", "isNonMobileAvailable() : connection is BLOCKED");
                        }
                    } else if (networkInfoM321f2.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) {
                        zHasCapability = true;
                    } else {
                        Debugger.m8609e("SC/NetworkUtilsUnderQosImpl", "isNonMobileAvailable() : connection is BLOCKED");
                    }
                }
                break;
        }
        if (f406h != zHasCapability) {
            f406h = zHasCapability;
            Debugger.m8615i("SC/NetworkUtils", "isNonMobileAvailable() : connection = " + f406h);
        }
        sb2.append(f406h);
        Debugger.m8607d("SC/NetworkUtils", sb2.toString());
        Debugger.m8607d("SC/NetworkUtils", "[Network] isRoaming : " + m293A(context));
        Debugger.m8607d("SC/NetworkUtils", "[Network] isFlightMode : " + m335t(context));
        Debugger.m8607d("SC/NetworkUtils", "[Network] isNonPhone : " + m339x(context));
    }

    /* JADX INFO: renamed from: J */
    public static void m302J(String str, String str2) {
        if (SharedPreferencesCompat.getInstance(str).contains(str2)) {
            SharedPreferencesCompat.getInstance(str).remove(str2);
            Debugger.m8607d("SharedPreferenceUtil", "remove " + str + " , " + str2);
        }
    }

    /* JADX INFO: renamed from: K */
    public static void m303K(Context context) {
        Boolean bool = Boolean.TRUE;
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setAppPermitted() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putBoolean(SettingsConstants.SETTINGS_ALLOW_APP_PERMISSION, true);
        editorEdit.apply();
        Debugger.m8607d("SyncSettingsUtil", "save as settings_app_permission= " + bool);
    }

    /* JADX INFO: renamed from: L */
    public static void m304L(String str, String str2, boolean z) {
        SharedPreferencesCompat.getInstance(str).putBoolean(str2, z);
        Debugger.m8607d("SharedPreferenceUtil", "save as " + str + " , " + str2 + " = " + Logger.getEncode(Boolean.toString(z)));
    }

    /* JADX INFO: renamed from: M */
    public static void m305M(Context context, String str) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setCoeditWiFiSyncType() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putString(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE, str);
        editorEdit.apply();
        AbstractC4539a.m3190D("save as settings_coedit_note_sync_type= ", str, "SyncSettingsUtil");
    }

    /* JADX INFO: renamed from: N */
    public static void m306N(int i, String str, String str2) {
        SharedPreferencesCompat.getInstance(str).putInt(str2, i);
        Debugger.m8607d("SharedPreferenceUtil", "save as " + str + " , " + str2 + " = " + Logger.getEncode(Integer.toString(i)));
    }

    /* JADX INFO: renamed from: O */
    public static void m307O(Context context, long j) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setLastOldSyncErrorTime() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putLong(SettingsConstants.SETTINGS_LAST_OLD_SYNC_ERROR_TIME, j);
        editorEdit.apply();
        Debugger.m8607d("SyncSettingsUtil", "save as settings_last_old_sync_error_time= " + j);
    }

    /* JADX INFO: renamed from: P */
    public static void m308P(long j, String str, String str2) {
        SharedPreferencesCompat.getInstance(str).putLong(str2, j);
        StringBuilder sb = new StringBuilder("save as ");
        AbstractC2821a.m2207B(sb, str, " , ", str2, " = ");
        sb.append(Logger.getEncode(Long.toString(j)));
        Debugger.m8607d("SharedPreferenceUtil", sb.toString());
    }

    /* JADX INFO: renamed from: Q */
    public static void m309Q(Context context, Boolean bool) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setNeededToSync() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("SyncService", 0).edit();
        editorEdit.putBoolean("NeedToSync", bool.booleanValue());
        editorEdit.apply();
        Debugger.m8607d("SyncSettingsUtil", "save as NeedToSync= " + bool);
    }

    /* JADX INFO: renamed from: R */
    public static void m310R(String str, String str2, String str3) {
        SharedPreferencesCompat.getInstance(str).putString(str2, str3);
        Debugger.m8607d("SharedPreferenceUtil", "save as " + str + " , " + str2 + " = " + Logger.getEncode(str3));
    }

    /* JADX INFO: renamed from: S */
    public static void m311S(Context context, Boolean bool) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setSyncEnableMode() : context is null!");
            return;
        }
        Debugger.m8614f("SyncSettingsUtil", "setSyncEnableMode() : enable = " + bool + ", callee: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, bool.booleanValue());
        editorEdit.apply();
        Debugger.m8615i("SyncSettingsUtil", "save as settings_sync_notes= " + bool);
    }

    /* JADX INFO: renamed from: T */
    public static void m312T(Context context, Boolean bool) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setUserChangeSyncEnable() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putBoolean(SettingsConstants.SETTINGS_USERCHANGE_SYNCENABLE, bool.booleanValue());
        editorEdit.apply();
        Debugger.m8607d("SyncSettingsUtil", "save as settings_userchange_syncenable= " + bool);
    }

    /* JADX INFO: renamed from: U */
    public static void m313U(Context context, Boolean bool) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setUsingMobileDataWhenImporting() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("SyncService", 0).edit();
        editorEdit.putBoolean("UsingDataWhenImport", bool.booleanValue());
        editorEdit.apply();
        Debugger.m8607d("SyncSettingsUtil", "save as UsingDataWhenImport= " + bool);
    }

    /* JADX INFO: renamed from: V */
    public static void m314V(Context context, Boolean bool) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setWiFiSyncOnly() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putBoolean("settings_wifi_sync_only", bool.booleanValue());
        editorEdit.apply();
        Debugger.m8607d("SyncSettingsUtil", "save as settings_wifi_sync_only= " + bool);
    }

    /* JADX INFO: renamed from: W */
    public static int m315W(char c, int i) throws SyncException {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new SyncException(332, "Illegal hexadecimal character " + c + " at index " + i);
    }

    /* JADX INFO: renamed from: a */
    public static void m316a(String str) {
        SharedPreferencesCompat.getInstance(str).clear();
        Debugger.m8607d("SharedPreferenceUtil", "clear " + str);
    }

    /* JADX INFO: renamed from: b */
    public static String m317b(byte[] bArr) {
        return new String(C13569c.m14375c().m14377a(bArr), StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: c */
    public static String m318c(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            int i4 = (b & CtapException.ERR_VENDOR_FIRST) >>> 4;
            char[] cArr2 = f413o;
            cArr[i] = cArr2[i4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: d */
    public static String m319d(String str) {
        byte[] bArrEncryptData;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        C13569c c13569cM14375c = C13569c.m14375c();
        c13569cM14375c.getClass();
        try {
            bArrEncryptData = c13569cM14375c.f9619b.encryptData("si-6vqcx5t", bytes);
        } catch (Exception e) {
            AbstractC0000a.m22s("[EDP] encoding() : ", e, "KmxSdkManager");
            bArrEncryptData = null;
        }
        return Base64Utils.encodeBase64(bArrEncryptData);
    }

    /* JADX INFO: renamed from: e */
    public static String m320e() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append((char) (97 + ((int) (random.nextFloat() * 26))));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    public static NetworkInfo m321f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            Debugger.m8609e("SC/NetworkUtilsUnderQosImpl", "ConnectivityManager is null!");
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Debugger.m8609e("SC/NetworkUtilsUnderQosImpl", "activeNetworkInfo is null!");
        }
        return activeNetworkInfo;
    }

    /* JADX INFO: renamed from: g */
    public static String m322g() {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        if (appContext == null) {
            Debugger.m8609e("AppUtil", "getAppVersion() : appContext is null!");
            return f414p;
        }
        if (f414p == null) {
            try {
                String str = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
                f414p = str;
                return str;
            } catch (Exception e) {
                Debugger.m8607d("AppUtil", "getAppVersion exception " + e.getMessage());
            }
        }
        return f414p;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m323h(String str, String str2, boolean z) {
        return SharedPreferencesCompat.getInstance(str).getBoolean(str2, z);
    }

    /* JADX INFO: renamed from: i */
    public static String m324i(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "getCoeditNoteSyncType() : context is null!");
            return "settings_wifi_sync_only";
        }
        String string = context.getSharedPreferences("Settings", 0).getString(SettingsConstants.SETTINGS_COEDIT_NOTES_SYNC_TYPE, "settings_wifi_sync_only");
        AbstractC4539a.m3190D("SETTINGS_COEDIT_NOTES_SYNC_TYPE is ", string, "SyncSettingsUtil");
        return string;
    }

    /* JADX INFO: renamed from: j */
    public static String m325j(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return Settings.Secure.getString(context.getContentResolver(), SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID);
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager.getDeviceId() != null ? telephonyManager.getDeviceId() : Settings.Secure.getString(context.getContentResolver(), SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID);
        } catch (SecurityException e) {
            Debugger.m8609e("DeviceUtil", "getDeviceId() : " + e.toString());
            return "None";
        }
    }

    /* JADX INFO: renamed from: k */
    public static Object m326k() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> cls = Class.forName("android.os.ServiceManager");
        return Class.forName("android.os.IDeviceIdleController$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(Class.forName("android.os.IDeviceIdleController$Stub"), cls.getDeclaredMethod("getService", String.class).invoke(cls, "deviceidle"));
    }

    /* JADX INFO: renamed from: l */
    public static String m327l(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr, 0, 1024);
                    if (i <= 0) {
                        String strM318c = m318c(messageDigest.digest());
                        fileInputStream.close();
                        return strM318c;
                    }
                    messageDigest.update(bArr, 0, i);
                }
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException(e);
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: m */
    public static long m328m(long j, String str, String str2) {
        return SharedPreferencesCompat.getInstance(str).getLong(str2, j);
    }

    /* JADX INFO: renamed from: n */
    public static synchronized C0145c m329n() {
        try {
            if (f412n == null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    f412n = new C0145c(0);
                } else {
                    f412n = new C0145c(1);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f412n;
    }

    /* JADX INFO: renamed from: o */
    public static String m330o() {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        if (appContext == null) {
            Debugger.m8609e("AppUtil", "getApplicationID() : appContext is null!");
            return "";
        }
        if (f415q == null) {
            f415q = appContext.getPackageName();
        }
        return f415q;
    }

    /* JADX INFO: renamed from: p */
    public static String m331p(String str, String str2, String str3) {
        String string = SharedPreferencesCompat.getInstance(str).getString(str2, str3);
        StringBuilder sbM16m = AbstractC0000a.m16m("read as ", str, " , ", str2, " = ");
        sbM16m.append(Logger.getEncode(string));
        Debugger.m8607d("SharedPreferenceUtil", sbM16m.toString());
        return string;
    }

    /* JADX INFO: renamed from: q */
    public static boolean m332q(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "isAppPermitted() : context is null!");
            return false;
        }
        boolean z = context.getSharedPreferences("Settings", 0).getBoolean(SettingsConstants.SETTINGS_ALLOW_APP_PERMISSION, SettingsCompat.getInstance().isRDUModel(context));
        AbstractC4539a.m3215y("SETTINGS_ALLOW_APP_PERMISSION is ", "SyncSettingsUtil", z);
        return z;
    }

    /* JADX INFO: renamed from: r */
    public static boolean m333r(Context context) {
        boolean zEquals;
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "isCoeditNoteSyncWiFiOnly() : context is null!");
            zEquals = true;
        } else {
            zEquals = "settings_wifi_sync_only".equals(m324i(context));
        }
        return zEquals && !m298F(context);
    }

    /* JADX INFO: renamed from: s */
    public static boolean m334s(Context context) {
        boolean zHasCapability;
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isDataNetworkAvailable() : context is null");
            return false;
        }
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                zHasCapability = (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? false : networkCapabilities.hasCapability(12);
                break;
            default:
                NetworkInfo networkInfoM321f = m321f(context);
                zHasCapability = false;
                if (networkInfoM321f != null) {
                    if (!networkInfoM321f.isConnectedOrConnecting()) {
                        if (networkInfoM321f.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) {
                            Debugger.m8615i("SC/NetworkUtilsUnderQosImpl", "isDataNetworkAvailable() : connection is BLOCKED");
                        }
                    } else if (networkInfoM321f.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) {
                        zHasCapability = true;
                    } else {
                        Debugger.m8609e("SC/NetworkUtilsUnderQosImpl", "isDataNetworkAvailable() : connection is BLOCKED");
                    }
                }
                break;
        }
        if (f400b != zHasCapability) {
            f400b = zHasCapability;
            Debugger.m8615i("SC/NetworkUtils", "isDataNetworkAvailable : connection = " + f400b);
        }
        return f400b;
    }

    /* JADX INFO: renamed from: t */
    public static boolean m335t(Context context) {
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isFlightMode() : context is null");
            return false;
        }
        boolean z = Settings.Global.getInt(context.getApplicationContext().getContentResolver(), "airplane_mode_on", 0) != 0;
        if (f409k != z) {
            f409k = z;
            Debugger.m8615i("SC/NetworkUtils", "isFlightMode() : mIsFlightMode = " + f409k);
        }
        return f409k;
    }

    /* JADX INFO: renamed from: u */
    public static boolean m336u(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean zHasCapability;
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isMobileAvailable() : context is null");
            return false;
        }
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                zHasCapability = (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasTransport(0)) ? networkCapabilities.hasCapability(12) : false;
                break;
            default:
                NetworkInfo networkInfoM321f = m321f(context);
                zHasCapability = false;
                if (networkInfoM321f != null && networkInfoM321f.getType() == 0) {
                    if (!networkInfoM321f.isConnectedOrConnecting()) {
                        if (networkInfoM321f.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) {
                            Debugger.m8615i("SC/NetworkUtilsUnderQosImpl", "isMobileAvailable() : connection is BLOCKED");
                        }
                    } else if (networkInfoM321f.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) {
                        zHasCapability = true;
                    } else {
                        Debugger.m8609e("SC/NetworkUtilsUnderQosImpl", "isMobileAvailable() : connection is BLOCKED");
                    }
                }
                break;
        }
        if (f402d != zHasCapability) {
            f402d = zHasCapability;
            Debugger.m8615i("SC/NetworkUtils", "isMobileAvailable() : connection = " + f402d);
        }
        return f402d;
    }

    /* JADX INFO: renamed from: v */
    public static boolean m337v(Context context) {
        NetworkCapabilities networkCapabilities;
        boolean z;
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isMobileConnected() : context is null");
            return false;
        }
        switch (m329n().f416a) {
            case 0:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                z = activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasTransport(0);
                break;
            default:
                NetworkInfo networkInfoM321f = m321f(context);
                z = false;
                if (networkInfoM321f != null && networkInfoM321f.getType() == 0) {
                    z = true;
                }
                break;
        }
        if (f401c != z) {
            f401c = z;
            Debugger.m8615i("SC/NetworkUtils", "isMobileConnected() : connection = " + f401c);
        }
        return f401c;
    }

    /* JADX INFO: renamed from: w */
    public static boolean m338w(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "isNeededToSync() : context is null!");
            return false;
        }
        boolean z = context.getSharedPreferences("SyncService", 0).getBoolean("NeedToSync", false);
        AbstractC4539a.m3215y("SYNC_PREFERENCE_SYNC_SERVICE_NEED_TO_SYNC is ", "SyncSettingsUtil", z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX INFO: renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m339x(Context context) {
        if (context == null) {
            Debugger.m8609e("SC/NetworkUtils", "isNonPhone() : context is null");
            return true;
        }
        if (!f411m) {
            boolean z = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getPhoneType() == 0;
            if (z) {
                try {
                    NetworkInfo networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(0);
                    if (networkInfo != null) {
                        boolean z2 = networkInfo.isAvailable() ? false : z;
                        z = z2;
                    }
                } catch (Exception e) {
                    AbstractC4539a.m3213w(e, new StringBuilder("isNonPhone() : Exception = "), "SC/NetworkUtils");
                }
            }
            if (f410l != z) {
                f410l = z;
                Debugger.m8615i("SC/NetworkUtils", "isNonPhone() : mIsNonPhone = " + f410l);
            }
            f411m = true;
        }
        return f410l;
    }

    /* JADX INFO: renamed from: y */
    public static boolean m340y() {
        Method declaredMethod;
        try {
            Object objM326k = m326k();
            if (objM326k == null || (declaredMethod = objM326k.getClass().getDeclaredMethod("isPowerSaveWhitelistApp", String.class)) == null) {
                return true;
            }
            Debugger.m8615i("AppUtil", "isNotesPowerSaveAllowlistApp : call DeviceIdleService.isPowerSaveAllowlistApp");
            return ((Boolean) declaredMethod.invoke(objM326k, "com.samsung.android.app.notes")).booleanValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Debugger.m8609e("AppUtil", "isNotesPowerSaveAllowlistApp : " + e);
            return true;
        }
    }

    /* JADX INFO: renamed from: z */
    public static boolean m341z(Context context) {
        return DeviceUtils.isPowerSavingMode(context) && AbstractC0155m.m404s(context);
    }
}
