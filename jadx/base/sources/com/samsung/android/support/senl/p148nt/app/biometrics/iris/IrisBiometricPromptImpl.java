package com.samsung.android.support.senl.p148nt.app.biometrics.iris;

import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.CancellationSignal;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p145cm.base.framework.lock.BiometricPromptHelper;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p065P1.AbstractC0195a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisBiometricPromptImpl;", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IIrisApiImpl;", "<init>", "()V", "mCancellationSignal", "Landroid/os/CancellationSignal;", "authenticate", "", "context", "Landroid/content/Context;", "preview", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$OnAuthenticationListener;", "cancelAuthenticate", "getIrisId", "", "isRetryCase", "", "errCode", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class IrisBiometricPromptImpl implements IIrisApiImpl {

    @NotNull
    private static final String TAG = "Biometrics$IrisManagerImpl";

    @Nullable
    private CancellationSignal mCancellationSignal;

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.iris.IIrisApiImpl
    @RequiresApi(29)
    public void authenticate(@Nullable Context context, @Nullable View preview, @NotNull final IrisApi.OnAuthenticationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.m8697d(TAG, "authenticate");
        if (context == null) {
            return;
        }
        BiometricPrompt.Builder biometricType = BiometricPromptHelper.setBiometricType(AbstractC0195a.m464g(context).setTitle(context.getString(C8003R.string.base_string_verify_identity)).setNegativeButton(context.getString(C8003R.string.lock_fingerprint_dialog_use_password), context.getMainExecutor(), new DialogInterfaceOnClickListenerC0161a(listener, 1)).setConfirmationRequired(false), 4);
        BiometricPrompt biometricPromptBuild = biometricType != null ? biometricType.build() : null;
        BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallback = new BiometricPrompt$AuthenticationCallback() { // from class: com.samsung.android.support.senl.nt.app.biometrics.iris.IrisBiometricPromptImpl$authenticate$callback$1
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                Logger.m8697d("Biometrics$IrisManagerImpl", "onAuthenticationError : " + errorCode);
                listener.onAuthenticationError(errorCode, errString);
            }

            public void onAuthenticationFailed() {
                Logger.m8697d("Biometrics$IrisManagerImpl", "onAuthenticationFailed");
                super.onAuthenticationFailed();
            }

            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                Intrinsics.checkNotNullParameter(helpString, "helpString");
                Logger.m8697d("Biometrics$IrisManagerImpl", "onAuthenticationHelp : " + helpCode);
                listener.onAuthenticationHelp(helpString);
            }

            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Logger.m8697d("Biometrics$IrisManagerImpl", "onAuthenticationSucceeded");
                listener.onAuthenticationSucceeded();
            }
        };
        CancellationSignal cancellationSignal = new CancellationSignal();
        this.mCancellationSignal = cancellationSignal;
        if (biometricPromptBuild != null) {
            Intrinsics.checkNotNull(cancellationSignal);
            biometricPromptBuild.authenticate(cancellationSignal, context.getMainExecutor(), biometricPrompt$AuthenticationCallback);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.iris.IIrisApiImpl
    public void cancelAuthenticate() {
        Logger.m8697d(TAG, "cancelAuthenticate");
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.iris.IIrisApiImpl
    @Nullable
    public String getIrisId(@Nullable Context context) {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.biometrics.iris.IIrisApiImpl
    public boolean isRetryCase(int errCode) {
        return false;
    }
}
