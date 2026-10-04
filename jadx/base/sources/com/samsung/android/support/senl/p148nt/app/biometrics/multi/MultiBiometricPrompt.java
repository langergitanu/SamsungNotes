package com.samsung.android.support.senl.p148nt.app.biometrics.multi;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.multi.MultiBiometricPrompt;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p065P1.AbstractC0195a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/multi/MultiBiometricPrompt;", "", "<init>", "()V", "mCancellationSignal", "Landroid/os/CancellationSignal;", "mListener", "Lcom/samsung/android/support/senl/nt/app/biometrics/multi/MultiBiometricPrompt$IMultiBiometricListener;", "authenticate", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "cancelAuthenticate", "mCallback", "Landroid/hardware/biometrics/BiometricPrompt$AuthenticationCallback;", "IMultiBiometricListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MultiBiometricPrompt {

    @NotNull
    public static final String TAG = "Biometrics$MultiBiometricPrompt";

    @NotNull
    private final BiometricPrompt$AuthenticationCallback mCallback = new BiometricPrompt$AuthenticationCallback() { // from class: com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt$mCallback$1
        public void onAuthenticationError(int errorCode, CharSequence errString) {
            Intrinsics.checkNotNullParameter(errString, "errString");
            Logger.m8697d(MultiBiometricPrompt.TAG, "onAuthenticationError : " + errorCode);
            if (errorCode == 10) {
                MultiBiometricPrompt.IMultiBiometricListener iMultiBiometricListener = this.this$0.mListener;
                if (iMultiBiometricListener != null) {
                    iMultiBiometricListener.onAuthenticationCanceled();
                    return;
                }
                return;
            }
            MultiBiometricPrompt.IMultiBiometricListener iMultiBiometricListener2 = this.this$0.mListener;
            if (iMultiBiometricListener2 != null) {
                iMultiBiometricListener2.onAuthenticationError(errorCode, errString);
            }
        }

        public void onAuthenticationFailed() {
            Logger.m8697d(MultiBiometricPrompt.TAG, "onAuthenticationFailed");
            MultiBiometricPrompt.IMultiBiometricListener iMultiBiometricListener = this.this$0.mListener;
            if (iMultiBiometricListener != null) {
                iMultiBiometricListener.onAuthenticationFailed();
            }
        }

        public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
            Intrinsics.checkNotNullParameter(helpString, "helpString");
            Logger.m8697d(MultiBiometricPrompt.TAG, "onAuthenticationHelp : " + helpCode);
        }

        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Logger.m8697d(MultiBiometricPrompt.TAG, "onAuthenticationSucceeded");
            MultiBiometricPrompt.IMultiBiometricListener iMultiBiometricListener = this.this$0.mListener;
            if (iMultiBiometricListener != null) {
                iMultiBiometricListener.onAuthenticationSucceeded();
            }
        }
    };

    @Nullable
    private CancellationSignal mCancellationSignal;

    @Nullable
    private IMultiBiometricListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/multi/MultiBiometricPrompt$IMultiBiometricListener;", "", "onAuthenticationSucceeded", "", "onAuthenticationError", "errorCode", "", "errString", "", "onAuthenticationFailed", "onAuthenticationCanceled", "onUsePasswordClicked", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IMultiBiometricListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int PROMPT_ERROR_CANCELED = 5;
        public static final int PROMPT_ERROR_LOCKOUT = 7;
        public static final int PROMPT_ERROR_LOCKOUT_PERMANENT = 9;
        public static final int PROMPT_ERROR_TIMEOUT = 3;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/multi/MultiBiometricPrompt$IMultiBiometricListener$Companion;", "", "<init>", "()V", "PROMPT_ERROR_TIMEOUT", "", "PROMPT_ERROR_LOCKOUT", "PROMPT_ERROR_LOCKOUT_PERMANENT", "PROMPT_ERROR_CANCELED", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int PROMPT_ERROR_CANCELED = 5;
            public static final int PROMPT_ERROR_LOCKOUT = 7;
            public static final int PROMPT_ERROR_LOCKOUT_PERMANENT = 9;
            public static final int PROMPT_ERROR_TIMEOUT = 3;

            private Companion() {
            }
        }

        void onAuthenticationCanceled();

        void onAuthenticationError(int errorCode, @Nullable CharSequence errString);

        void onAuthenticationFailed();

        void onAuthenticationSucceeded();

        void onUsePasswordClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authenticate$lambda$0(MultiBiometricPrompt multiBiometricPrompt, DialogInterface dialogInterface, int i) {
        IMultiBiometricListener iMultiBiometricListener = multiBiometricPrompt.mListener;
        if (iMultiBiometricListener != null) {
            iMultiBiometricListener.onUsePasswordClicked();
        }
    }

    public final void authenticate(@Nullable Context context, @NotNull IMultiBiometricListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.m8697d(TAG, "authenticate");
        if (context == null) {
            return;
        }
        this.mListener = listener;
        BiometricPrompt biometricPromptBuild = AbstractC0195a.m464g(context).setTitle(context.getString(C8003R.string.base_string_verify_identity)).setNegativeButton(context.getString(C8003R.string.lock_fingerprint_dialog_use_password), context.getMainExecutor(), new DialogInterfaceOnClickListenerC0161a(this, 2)).setConfirmationRequired(false).build();
        Intrinsics.checkNotNullExpressionValue(biometricPromptBuild, "build(...)");
        CancellationSignal cancellationSignal = new CancellationSignal();
        this.mCancellationSignal = cancellationSignal;
        Intrinsics.checkNotNull(cancellationSignal);
        biometricPromptBuild.authenticate(cancellationSignal, context.getMainExecutor(), this.mCallback);
    }

    public final void cancelAuthenticate() {
        Logger.m8697d(TAG, "cancelAuthenticate");
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }
}
