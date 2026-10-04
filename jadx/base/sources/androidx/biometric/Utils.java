package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class Utils {
    private Utils() {
    }

    public static boolean isConfirmingDeviceCredential() {
        DeviceCredentialHandlerBridge instanceIfNotNull = DeviceCredentialHandlerBridge.getInstanceIfNotNull();
        return instanceIfNotNull != null && instanceIfNotNull.isConfirmingDeviceCredential();
    }

    private static boolean isModelInPrefixList(@NonNull Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnknownError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return false;
            case 6:
            default:
                return true;
        }
    }

    private static boolean isVendorInList(@NonNull Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(21)
    public static void launchDeviceCredentialConfirmation(@NonNull String str, @Nullable FragmentActivity fragmentActivity, @Nullable Bundle bundle, @Nullable Runnable runnable) {
        CharSequence charSequence;
        CharSequence charSequence2;
        if (!(fragmentActivity instanceof DeviceCredentialHandlerActivity)) {
            Log.e(str, "Failed to check device credential. Parent handler not found.");
            return;
        }
        DeviceCredentialHandlerActivity deviceCredentialHandlerActivity = (DeviceCredentialHandlerActivity) fragmentActivity;
        KeyguardManager keyguardManager = (KeyguardManager) deviceCredentialHandlerActivity.getSystemService(KeyguardManager.class);
        if (keyguardManager == null) {
            Log.e(str, "Failed to check device credential. KeyguardManager was null.");
            deviceCredentialHandlerActivity.handleDeviceCredentialResult(0);
            return;
        }
        if (bundle != null) {
            charSequence = bundle.getCharSequence("title");
            charSequence2 = bundle.getCharSequence("subtitle");
        } else {
            charSequence = null;
            charSequence2 = null;
        }
        Intent intentCreateConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        if (intentCreateConfirmDeviceCredentialIntent == null) {
            Log.e(str, "Failed to check device credential. Got null intent from Keyguard.");
            deviceCredentialHandlerActivity.handleDeviceCredentialResult(0);
            return;
        }
        DeviceCredentialHandlerBridge deviceCredentialHandlerBridge = DeviceCredentialHandlerBridge.getInstance();
        deviceCredentialHandlerBridge.setConfirmingDeviceCredential(true);
        deviceCredentialHandlerBridge.startIgnoringReset();
        if (runnable != null) {
            runnable.run();
        }
        intentCreateConfirmDeviceCredentialIntent.setFlags(134742016);
        deviceCredentialHandlerActivity.startActivityForResult(intentCreateConfirmDeviceCredentialIntent, 0);
    }

    public static void maybeFinishHandler(@Nullable FragmentActivity fragmentActivity) {
        if (!(fragmentActivity instanceof DeviceCredentialHandlerActivity) || fragmentActivity.isFinishing()) {
            return;
        }
        fragmentActivity.finish();
    }

    public static boolean shouldHideFingerprintDialog(@NonNull Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return isModelInPrefixList(context, str, C0595R.array.hide_fingerprint_instantly_prefixes);
    }

    public static boolean shouldUseFingerprintForCrypto(@NonNull Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return isVendorInList(context, str, C0595R.array.crypto_fingerprint_fallback_vendors) || isModelInPrefixList(context, str2, C0595R.array.crypto_fingerprint_fallback_prefixes);
    }
}
