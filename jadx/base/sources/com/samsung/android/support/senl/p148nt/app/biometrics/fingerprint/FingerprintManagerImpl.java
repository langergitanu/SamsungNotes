package com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.util.SparseArray;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pass.Spass;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u0001`\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J(\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019H\u0002J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\tJ,\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u00132\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintManagerImpl;", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/IFingerprintApi;", "<init>", "()V", "mCancellationSignal", "Landroid/os/CancellationSignal;", "authenticate", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "cancelAuthenticate", "hasChangedFingerprint", "", "hasChangedFingerprint_POS", "getFingerprintId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "compareFingerprintUniqueID", "isSameIdList", "newList", "Landroid/util/SparseArray;", "oldList", "", "getUniqueIDFromDevice", "convertSparseArrayToHashSet", "sparseArray", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FingerprintManagerImpl implements IFingerprintApi {

    @NotNull
    private static final String TAG = "Biometrics$FingerprintManagerImpl";

    @Nullable
    private CancellationSignal mCancellationSignal;

    private final boolean compareFingerprintUniqueID(Context context) {
        if (context == null) {
            return false;
        }
        Set<String> prefFingerprintUniqueId = LockPrefUtils.getPrefFingerprintUniqueId(context);
        SparseArray<String> uniqueIDFromDevice = getUniqueIDFromDevice(context);
        if (isSameIdList(uniqueIDFromDevice, prefFingerprintUniqueId)) {
            Logger.m8697d(TAG, "all fingerprints match");
            LockPrefUtils.setPrefFingerprintUniqueId(context, convertSparseArrayToHashSet(uniqueIDFromDevice));
            new SpassFingerprint(context.getApplicationContext()).updateActiveUser();
            Logger.m8697d(TAG, "finish updateActiveUser");
            SparseArray<String> uniqueIDFromDevice2 = getUniqueIDFromDevice(context);
            if (isSameIdList(uniqueIDFromDevice2, prefFingerprintUniqueId)) {
                Logger.m8697d(TAG, "all fingerprints match");
                LockPrefUtils.setPrefFingerprintUniqueId(context, convertSparseArrayToHashSet(uniqueIDFromDevice2));
                return true;
            }
        }
        return false;
    }

    private final HashSet<String> convertSparseArrayToHashSet(SparseArray<String> sparseArray) {
        HashSet<String> hashSet = new HashSet<>();
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                hashSet.add(sparseArray.valueAt(i));
            }
        }
        return hashSet;
    }

    private final boolean hasChangedFingerprint_POS(Context context) {
        if (!LockPrefUtils.getPrefFingerprintChanged(context)) {
            return false;
        }
        LockPrefUtils.setPrefFingerprintChanged(context, false);
        return true;
    }

    private final boolean isSameIdList(SparseArray<String> newList, Set<String> oldList) {
        if (newList == null) {
            Logger.m8697d(TAG, "new list is null");
            return false;
        }
        Set<String> set = oldList;
        if (set == null || set.isEmpty()) {
            Logger.m8697d(TAG, "old list is null");
            return false;
        }
        if (newList.size() != oldList.size()) {
            Logger.m8697d(TAG, "size of list has changed");
            return false;
        }
        int size = newList.size();
        for (int i = 0; i < size; i++) {
            if (!oldList.contains(newList.valueAt(i))) {
                Logger.m8697d(TAG, "new item detected");
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    public void authenticate(@NotNull Context context, @NotNull final FingerprintApi.OnAuthenticationListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.m8697d(TAG, "authenticate");
        Object systemService = context.getSystemService("fingerprint");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.fingerprint.FingerprintManager");
        FingerprintManager.AuthenticationCallback authenticationCallback = new FingerprintManager.AuthenticationCallback() { // from class: com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintManagerImpl$authenticate$callback$1
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                Logger.m8697d("Biometrics$FingerprintManagerImpl", "onAuthenticationError : " + errorCode);
                listener.onAuthenticationError(errorCode, errString);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                Logger.m8697d("Biometrics$FingerprintManagerImpl", "onAuthenticationFailed");
                listener.onAuthenticationFailed();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                Intrinsics.checkNotNullParameter(helpString, "helpString");
                Logger.m8697d("Biometrics$FingerprintManagerImpl", "onAuthenticationHelp : " + helpCode);
                listener.onAuthenticationHelp(helpString);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Logger.m8697d("Biometrics$FingerprintManagerImpl", "onAuthenticationSucceeded");
                listener.onAuthenticationSucceeded();
            }
        };
        CancellationSignal cancellationSignal = new CancellationSignal();
        this.mCancellationSignal = cancellationSignal;
        ((FingerprintManager) systemService).authenticate(null, cancellationSignal, 0, authenticationCallback, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    public void cancelAuthenticate() {
        Logger.m8697d(TAG, "cancelAuthenticate");
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    @Nullable
    public HashSet<String> getFingerprintId(@Nullable Context context) {
        return convertSparseArrayToHashSet(getUniqueIDFromDevice(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SparseArray<String> getUniqueIDFromDevice(@Nullable Context context) {
        boolean z;
        boolean z2;
        SparseArray registeredFingerprintUniqueID;
        Logger.m8697d(TAG, "getFingerPrintUniqueID() 1");
        Spass spass = new Spass();
        Logger.m8697d(TAG, "getFingerPrintUniqueID() 2");
        try {
            spass.initialize(context);
            Logger.m8697d(TAG, "getFingerPrintUniqueID() 3");
            try {
                if (spass.isFeatureEnabled(0)) {
                    z2 = spass.isFeatureEnabled(3);
                    try {
                        Logger.m8697d(TAG, "getFingerPrintUniqueID() 4");
                    } catch (IllegalArgumentException e) {
                        z = z2;
                        e = e;
                        Logger.m8698e(TAG, "getFingerPrintUniqueID() : " + e);
                        z2 = z;
                    } catch (IllegalStateException e2) {
                        z = z2;
                        e = e2;
                        Logger.m8698e(TAG, "getFingerPrintUniqueID() : " + e);
                        z2 = z;
                    } catch (UnsupportedOperationException e3) {
                        z = z2;
                        e = e3;
                        Logger.m8698e(TAG, "getFingerPrintUniqueID() : " + e);
                        z2 = z;
                    }
                }
            } catch (IllegalArgumentException e5) {
                e = e5;
                z = false;
            } catch (IllegalStateException e6) {
                e = e6;
                z = false;
            } catch (UnsupportedOperationException e7) {
                e = e7;
                z = false;
            }
            if (!z2) {
                Logger.m8697d(TAG, "getFingerPrintUniqueID(). Fingerprint Service is not supported in the device.");
                return null;
            }
            SpassFingerprint spassFingerprint = new SpassFingerprint(context != null ? context.getApplicationContext() : null);
            Logger.m8697d(TAG, "getFingerPrintUniqueID() 5");
            AbstractC4539a.m3188B("getFingerPrintUniqueID(). Fingerprint Service is supported in the device. SDK version : ", spass.getVersionName(), TAG);
            try {
                registeredFingerprintUniqueID = spassFingerprint.getRegisteredFingerprintUniqueID();
                Logger.m8697d(TAG, "getFingerPrintUniqueID() 6");
            } catch (IllegalStateException e8) {
                Logger.m8698e(TAG, "getFingerPrintUniqueID() e : " + e8);
            } catch (UnsupportedOperationException e9) {
                Logger.m8698e(TAG, "getFingerPrintUniqueID() e : " + e9);
            }
            if (registeredFingerprintUniqueID == null) {
                Logger.m8697d(TAG, "getFingerPrintUniqueID() : Registered fingerprint is not existed.");
                return null;
            }
            Logger.m8697d(TAG, "getFingerPrintUniqueID() : Registered fingerprint is existed.");
            SparseArray<String> sparseArray = new SparseArray<>();
            int size = registeredFingerprintUniqueID.size();
            for (int i = 0; i < size; i++) {
                Object objValueAt = registeredFingerprintUniqueID.valueAt(i);
                if (objValueAt != null) {
                    sparseArray.put(registeredFingerprintUniqueID.keyAt(i), objValueAt.toString());
                }
            }
            return sparseArray;
        } catch (SsdkUnsupportedException e10) {
            Logger.m8698e(TAG, "getFingerPrintUniqueID() : " + e10);
            return null;
        } catch (SecurityException e11) {
            Logger.m8698e(TAG, "getFingerPrintUniqueID() : " + e11);
            return null;
        } catch (UnsupportedOperationException e12) {
            Logger.m8698e(TAG, "getFingerPrintUniqueID() : " + e12);
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    public boolean hasChangedFingerprint(@Nullable Context context) {
        return Build.VERSION.SDK_INT == 28 ? hasChangedFingerprint_POS(context) : !compareFingerprintUniqueID(context);
    }
}
