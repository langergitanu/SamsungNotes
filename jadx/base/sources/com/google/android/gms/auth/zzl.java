package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zzdc;
import com.google.android.gms.internal.auth.zzhs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanConstants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
public class zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    @ShowFirstParty
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    @ShowFirstParty
    public static final String[] zza = {"com.google", "com.google.work", "cn.google"};

    @ShowFirstParty
    @SuppressLint({"InlinedApi"})
    public static final String zzb = "androidPackageName";
    private static final ComponentName zzc = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final Logger zzd = zzd.zza("GoogleAuthUtil");

    public static void clearToken(Context context, String str) throws GoogleAuthException, IOException {
        zze(context, str, 0L);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        AccountChangeEventsRequest accountChangeEventsRequest = new AccountChangeEventsRequest();
        accountChangeEventsRequest.setAccountName(str);
        accountChangeEventsRequest.setEventIndex(i);
        zzdc.zze(context);
        if (zzhs.zzd() && zzo(context)) {
            try {
                AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzb(accountChangeEventsRequest), "account change events retrieval");
                zzj(accountChangeEventsResponse);
                return accountChangeEventsResponse.getEvents();
            } catch (ApiException e) {
                zzl(e, "account change events retrieval");
            }
        }
        return (List) zzh(context, zzc, new zzi(accountChangeEventsRequest), 0L);
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) {
        return getToken(context, account, str, new Bundle());
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    @ShowFirstParty
    @TargetApi(23)
    public static Bundle removeAccount(Context context, final Account account) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzn(account);
        zzk(context, 8400000);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzd(account), "account removal");
                zzj(bundle);
                return bundle;
            } catch (ApiException e) {
                zzl(e, "account removal");
            }
        }
        return (Bundle) zzh(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzg
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) throws IOException {
                Bundle bundleZzf = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzf(account);
                if (bundleZzf != null) {
                    return bundleZzf;
                }
                throw new IOException("Service call returned null.");
            }
        }, 0L);
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException {
        Preconditions.checkNotNull(context);
        zzk(context, 11400000);
        String str = context.getApplicationInfo().packageName;
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zze(str), "google accounts access request");
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                zzby zzbyVarZza = zzby.zza(string);
                if (zzby.SUCCESS.equals(zzbyVarZza)) {
                    return Boolean.TRUE;
                }
                if (!zzby.zzb(zzbyVarZza)) {
                    throw new GoogleAuthException(string);
                }
                zzd.m3237w("isUserRecoverableError status: ".concat(String.valueOf(zzbyVarZza)), new Object[0]);
                throw new UserRecoverableAuthException(string, intent);
            } catch (ApiException e) {
                zzl(e, "google accounts access request");
            }
        }
        return (Boolean) zzh(context, zzc, new zzj(str), 0L);
    }

    public static TokenData zza(Context context, final Account account, final String str, Bundle bundle) throws GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zzn(account);
        zzk(context, 8400000);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzm(context, bundle2);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle3 = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                zzj(bundle3);
                return zzg(bundle3);
            } catch (ApiException e) {
                zzl(e, "token retrieval");
            }
        }
        return (TokenData) zzh(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzf
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                return zzl.zzb(account, str, bundle2, iBinder);
            }
        }, 0L);
    }

    public static /* synthetic */ TokenData zzb(Account account, String str, Bundle bundle, IBinder iBinder) throws IOException {
        Bundle bundleZze = com.google.android.gms.internal.auth.zze.zzb(iBinder).zze(account, str, bundle);
        if (bundleZze != null) {
            return zzg(bundleZze);
        }
        throw new IOException("Service call returned null");
    }

    public static /* bridge */ /* synthetic */ Object zzd(Object obj) throws IOException {
        zzj(obj);
        return obj;
    }

    @ShowFirstParty
    public static void zze(Context context, String str, long j) throws GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        Bundle bundle = new Bundle();
        zzm(context, bundle);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            com.google.android.gms.internal.auth.zzg zzgVarZza = com.google.android.gms.internal.auth.zzh.zza(context);
            zzbw zzbwVar = new zzbw();
            zzbwVar.zza(str);
            try {
                zzi(zzgVarZza.zza(zzbwVar), "clear token");
                return;
            } catch (ApiException e) {
                zzl(e, "clear token");
            }
        }
        zzh(context, zzc, new zzh(str, bundle), 0L);
    }

    public static void zzf(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    private static TokenData zzg(Bundle bundle) throws GoogleAuthException, IOException {
        TokenData tokenData;
        Parcelable.Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        String string = bundle.getString("Error");
        Preconditions.checkNotNull(string);
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzby zzbyVarZza = zzby.zza(string);
        if (zzby.zzb(zzbyVarZza)) {
            zzd.m3237w("isUserRecoverableError status: ".concat(String.valueOf(zzbyVarZza)), new Object[0]);
            throw new UserRecoverableAuthException(string, intent);
        }
        if (zzby.NETWORK_ERROR.equals(zzbyVarZza) || zzby.SERVICE_UNAVAILABLE.equals(zzbyVarZza) || zzby.INTNERNAL_ERROR.equals(zzbyVarZza) || zzby.AUTH_SECURITY_ERROR.equals(zzbyVarZza) || zzby.ACCOUNT_NOT_PRESENT.equals(zzbyVarZza)) {
            throw new IOException(string);
        }
        throw new GoogleAuthException(string);
    }

    private static Object zzh(Context context, ComponentName componentName, zzk zzkVar, long j) throws IOException {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        try {
            try {
                if (!gmsClientSupervisor.bindService(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
                    throw new IOException("Could not bind to service.");
                }
                try {
                    return zzkVar.zza(blockingServiceConnection.getService());
                } catch (RemoteException | InterruptedException | TimeoutException e) {
                    Log.i("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                }
            } finally {
                gmsClientSupervisor.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
            }
        } catch (SecurityException e2) {
            Log.w("GoogleAuthUtil", "SecurityException while bind to auth service: " + e2.getMessage());
            throw new IOException("SecurityException while binding to Auth service.", e2);
        }
    }

    private static Object zzi(Task task, String str) throws IOException, ApiException {
        try {
            return Tasks.await(task);
        } catch (InterruptedException e) {
            String strM773o = AbstractC0541b.m773o("Interrupted while waiting for the task of ", str, " to finish.");
            zzd.m3237w(strM773o, new Object[0]);
            throw new IOException(strM773o, e);
        } catch (CancellationException e2) {
            String strM773o2 = AbstractC0541b.m773o("Canceled while waiting for the task of ", str, " to finish.");
            zzd.m3237w(strM773o2, new Object[0]);
            throw new IOException(strM773o2, e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof ApiException) {
                throw ((ApiException) cause);
            }
            String strM773o3 = AbstractC0541b.m773o("Unable to get a result for ", str, " due to ExecutionException.");
            zzd.m3237w(strM773o3, new Object[0]);
            throw new IOException(strM773o3, e3);
        }
    }

    private static Object zzj(Object obj) throws IOException {
        if (obj != null) {
            return obj;
        }
        zzd.m3237w("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    private static void zzk(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesIncorrectManifestValueException | GooglePlayServicesNotAvailableException e) {
            throw new GoogleAuthException(e.getMessage(), e);
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.getConnectionStatusCode(), e2.getMessage(), e2.getIntent());
        }
    }

    private static void zzl(ApiException apiException, String str) {
        zzd.m3237w("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(apiException));
    }

    private static void zzm(Context context, Bundle bundle) {
        String str = context.getApplicationInfo().packageName;
        bundle.putString(VexDocumentScanConstants.KEY_CLIENT_PACKAGE_NAME, str);
        String str2 = zzb;
        if (TextUtils.isEmpty(bundle.getString(str2))) {
            bundle.putString(str2, str);
        }
        bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
    }

    private static void zzn(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        String[] strArr = zza;
        for (int i = 0; i < 3; i++) {
            if (strArr[i].equals(account.type)) {
                return;
            }
        }
        throw new IllegalArgumentException("Account type not supported");
    }

    private static boolean zzo(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context, 17895000) != 0) {
            return false;
        }
        List listZzl = zzhs.zzb().zzl();
        String str = context.getApplicationInfo().packageName;
        Iterator it = listZzl.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        zzn(account);
        return zza(context, account, str, bundle).zza();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }
}
