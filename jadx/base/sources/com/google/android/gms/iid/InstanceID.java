package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.sec.spp.push.Config;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class InstanceID {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    private static final zzaj<Boolean> zzbu = zzai.zzy().zzd("gcm_check_for_different_iid_in_token", true);
    private static Map<String, InstanceID> zzbv = new ArrayMap();
    private static final long zzbw = TimeUnit.DAYS.toMillis(7);
    private static zzak zzbx;
    private static zzaf zzby;
    private static String zzbz;
    private String zzca;
    private Context zzl;

    @ShowFirstParty
    private InstanceID(Context context, String str) {
        this.zzca = "";
        this.zzl = context.getApplicationContext();
        this.zzca = str;
    }

    @Deprecated
    public static InstanceID getInstance(Context context) {
        return getInstance(context, null);
    }

    private final KeyPair getKeyPair() {
        return zzbx.zzj(this.zzca).getKeyPair();
    }

    public static String zzd(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) ((bArrDigest[0] & 15) + 112);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("InstanceID", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public static int zzg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            return 0;
        }
    }

    public static String zzh(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            return null;
        }
    }

    public static zzak zzp() {
        return zzbx;
    }

    @Deprecated
    public void deleteInstanceID() throws IOException {
        zzd("*", "*", null);
        zzo();
    }

    @Deprecated
    public void deleteToken(String str, String str2) throws IOException {
        zzd(str, str2, null);
    }

    @Deprecated
    public long getCreationTime() {
        return zzbx.zzj(this.zzca).getCreationTime();
    }

    @Deprecated
    public String getId() {
        return zzd(getKeyPair());
    }

    @KeepForSdk
    public String getSubtype() {
        return this.zzca;
    }

    @Deprecated
    public String getToken(String str, String str2) {
        return getToken(str, str2, null);
    }

    public final String zze(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString(Config.NOTIFICATION_INTENT_SENDER, str);
        String str3 = "".equals(this.zzca) ? str : this.zzca;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString(Contract.SUBSCRIPTION, str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        String strZzi = zzaf.zzi(zzby.zzd(bundle, getKeyPair()));
        if (!"RST".equals(strZzi) && !strZzi.startsWith("RST|")) {
            return strZzi;
        }
        InstanceIDListenerService.zzd(this.zzl, zzbx);
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final void zzo() {
        zzbx.zzk(this.zzca);
    }

    @KeepForSdk
    public static synchronized InstanceID getInstance(Context context, Bundle bundle) {
        String string;
        InstanceID instanceID;
        if (bundle == null) {
            string = "";
        } else {
            try {
                string = bundle.getString("subtype");
            } catch (Throwable th) {
                throw th;
            }
        }
        if (string == null) {
            string = "";
        }
        Context applicationContext = context.getApplicationContext();
        if (zzbx == null) {
            String packageName = applicationContext.getPackageName();
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 73);
            sb.append("Instance ID SDK is deprecated, ");
            sb.append(packageName);
            sb.append(" should update to use Firebase Instance ID");
            Log.w("InstanceID", sb.toString());
            zzbx = new zzak(applicationContext);
            zzby = new zzaf(applicationContext);
        }
        zzbz = Integer.toString(zzg(applicationContext));
        instanceID = zzbv.get(string);
        if (instanceID == null) {
            instanceID = new InstanceID(applicationContext, string);
            zzbv.put(string, instanceID);
        }
        return instanceID;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getToken(String str, String str2, Bundle bundle) throws IOException {
        String strZzf;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String str3 = zzbx.get("appVersion");
        if (str3 == null || !str3.equals(zzbz)) {
            strZzf = null;
        } else {
            long jZzg = zzbx.zzg(this.zzca, str, str2);
            if (jZzg >= 0 && System.currentTimeMillis() - jZzg < zzbw) {
                strZzf = zzbx.zzf(this.zzca, str, str2);
            }
        }
        if (strZzf != null) {
            return strZzf;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        String strZze = zze(str, str2, bundle);
        if (zzbu.get().booleanValue() && strZze.contains(":") && !strZze.startsWith(String.valueOf(getId()).concat(":"))) {
            InstanceIDListenerService.zzd(this.zzl, zzbx);
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        if (strZze != null) {
            zzbx.zzd(this.zzca, str, str2, strZze, zzbz);
        }
        return strZze;
    }

    @ShowFirstParty
    public final void zzd(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            zzbx.zzh(this.zzca, str, str2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Config.NOTIFICATION_INTENT_SENDER, str);
            if (str2 != null) {
                bundle.putString("scope", str2);
            }
            bundle.putString(Contract.SUBSCRIPTION, str);
            bundle.putString(OpenSessionApi.ITEM_LIMIT_DELETE, "1");
            bundle.putString("X-delete", "1");
            bundle.putString("subtype", "".equals(this.zzca) ? str : this.zzca);
            if (!"".equals(this.zzca)) {
                str = this.zzca;
            }
            bundle.putString("X-subtype", str);
            zzaf.zzi(zzby.zzd(bundle, getKeyPair()));
            return;
        }
        throw new IOException("MAIN_THREAD");
    }
}
