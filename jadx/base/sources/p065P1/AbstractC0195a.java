package p065P1;

import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: renamed from: P1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC0195a {
    /* JADX INFO: renamed from: B */
    public static /* synthetic */ void m455B() {
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ BiometricPrompt.Builder m464g(Context context) {
        return new BiometricPrompt.Builder(context);
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ BiometricPrompt.CryptoObject m467j(Signature signature) {
        return new BiometricPrompt.CryptoObject(signature);
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ BiometricPrompt.CryptoObject m468k(Cipher cipher) {
        return new BiometricPrompt.CryptoObject(cipher);
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ BiometricPrompt.CryptoObject m469l(Mac mac) {
        return new BiometricPrompt.CryptoObject(mac);
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ void m475r() {
    }
}
