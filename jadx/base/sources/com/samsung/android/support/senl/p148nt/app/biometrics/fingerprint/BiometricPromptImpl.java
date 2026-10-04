package com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.support.senl.p145cm.base.framework.lock.BiometricPromptHelper;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashSet;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p065P1.AbstractC0195a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\tH\u0017J\b\u0010\u000f\u001a\u00020\tH\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/BiometricPromptImpl;", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/IFingerprintApi;", "<init>", "()V", "mCancellationSignal", "Landroid/os/CancellationSignal;", "mCallback", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/BiometricPromptImpl$AuthenticationCallback;", "authenticate", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "cancelAuthenticate", "release", "hasChangedFingerprint", "", "getFingerprintId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "AuthenticationCallback", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BiometricPromptImpl implements IFingerprintApi {

    @NotNull
    private static final String TAG = "Biometrics$BiometricPromptImpl";

    @Nullable
    private AuthenticationCallback mCallback;

    @Nullable
    private CancellationSignal mCancellationSignal;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(28)
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0006\u0010\u0018\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/BiometricPromptImpl$AuthenticationCallback;", "Landroid/hardware/biometrics/BiometricPrompt$AuthenticationCallback;", "Landroid/content/DialogInterface$OnClickListener;", "mListener", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;)V", "onAuthenticationError", "", "errorCode", "", "errString", "", "onAuthenticationHelp", "helpCode", "helpString", "onAuthenticationSucceeded", "result", "Landroid/hardware/biometrics/BiometricPrompt$AuthenticationResult;", "onAuthenticationFailed", "onClick", "dialog", "Landroid/content/DialogInterface;", "which", "release", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AuthenticationCallback extends BiometricPrompt$AuthenticationCallback implements DialogInterface.OnClickListener {

        @Nullable
        private FingerprintApi.OnAuthenticationListener mListener;

        public AuthenticationCallback(@Nullable FingerprintApi.OnAuthenticationListener onAuthenticationListener) {
            this.mListener = onAuthenticationListener;
        }

        public void onAuthenticationError(int errorCode, @NotNull CharSequence errString) {
            Intrinsics.checkNotNullParameter(errString, "errString");
            Logger.m8697d(BiometricPromptImpl.TAG, "onAuthenticationError : " + errorCode);
            FingerprintApi.OnAuthenticationListener onAuthenticationListener = this.mListener;
            if (onAuthenticationListener != null) {
                onAuthenticationListener.onAuthenticationError(errorCode, errString);
            }
        }

        public void onAuthenticationFailed() {
            Logger.m8697d(BiometricPromptImpl.TAG, "onAuthenticationFailed");
            super.onAuthenticationFailed();
        }

        public void onAuthenticationHelp(int helpCode, @NotNull CharSequence helpString) {
            Intrinsics.checkNotNullParameter(helpString, "helpString");
            Logger.m8697d(BiometricPromptImpl.TAG, "onAuthenticationHelp : " + helpCode);
            FingerprintApi.OnAuthenticationListener onAuthenticationListener = this.mListener;
            if (onAuthenticationListener != null) {
                onAuthenticationListener.onAuthenticationHelp(helpString);
            }
        }

        public void onAuthenticationSucceeded(@NotNull BiometricPrompt.AuthenticationResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Logger.m8697d(BiometricPromptImpl.TAG, "onAuthenticationSucceeded");
            FingerprintApi.OnAuthenticationListener onAuthenticationListener = this.mListener;
            if (onAuthenticationListener != null) {
                onAuthenticationListener.onAuthenticationSucceeded();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(@Nullable DialogInterface dialog, int which) {
            FingerprintApi.OnAuthenticationListener onAuthenticationListener = this.mListener;
            if (onAuthenticationListener != null) {
                onAuthenticationListener.onUsePasswordClicked();
            }
        }

        public final void release() {
            this.mListener = null;
            Logger.m8697d(BiometricPromptImpl.TAG, "Callback#release");
        }
    }

    @RequiresApi(28)
    private final void release() {
        AuthenticationCallback authenticationCallback = this.mCallback;
        if (authenticationCallback != null) {
            Intrinsics.checkNotNull(authenticationCallback);
            authenticationCallback.release();
            this.mCallback = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    @RequiresApi(28)
    public void authenticate(@NotNull Context context, @NotNull FingerprintApi.OnAuthenticationListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.m8697d(TAG, "authenticate");
        this.mCallback = new AuthenticationCallback(listener);
        AbstractC0195a.m475r();
        BiometricPrompt.Builder title = AbstractC0195a.m464g(context.getApplicationContext()).setTitle(context.getString(C8003R.string.base_string_verify_identity));
        String string = context.getString(C8003R.string.lock_fingerprint_dialog_use_password);
        Executor mainExecutor = context.getMainExecutor();
        AuthenticationCallback authenticationCallback = this.mCallback;
        Intrinsics.checkNotNull(authenticationCallback);
        BiometricPrompt.Builder biometricType = BiometricPromptHelper.setBiometricType(title.setNegativeButton(string, mainExecutor, authenticationCallback), 1);
        BiometricPrompt biometricPromptBuild = biometricType != null ? biometricType.build() : null;
        CancellationSignal cancellationSignal = new CancellationSignal();
        this.mCancellationSignal = cancellationSignal;
        if (biometricPromptBuild != null) {
            Intrinsics.checkNotNull(cancellationSignal);
            Executor mainExecutor2 = context.getMainExecutor();
            AuthenticationCallback authenticationCallback2 = this.mCallback;
            Intrinsics.checkNotNull(authenticationCallback2);
            biometricPromptBuild.authenticate(cancellationSignal, mainExecutor2, AbstractC7150s.m5504h(authenticationCallback2));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    @RequiresApi(28)
    public void cancelAuthenticate() {
        Logger.m8697d(TAG, "cancelAuthenticate");
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            Intrinsics.checkNotNull(cancellationSignal);
            cancellationSignal.cancel();
            this.mCancellationSignal = null;
        }
        release();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    @Nullable
    public HashSet<String> getFingerprintId(@Nullable Context context) {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.IFingerprintApi
    public boolean hasChangedFingerprint(@Nullable Context context) {
        if (!LockPrefUtils.getPrefFingerprintChanged(context)) {
            return false;
        }
        Logger.m8697d(TAG, "Fingerprint has changed");
        LockPrefUtils.setPrefFingerprintChanged(context, false);
        return true;
    }
}
