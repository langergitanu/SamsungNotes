package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.biometric.BiometricPrompt;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceCredentialHandlerBridge {
    private static final int IGNORING_NEXT_RESET = 1;
    private static final int IGNORING_RESET = 2;
    private static final int NOT_IGNORING_RESET = 0;
    static final int RESULT_ERROR = 2;
    static final int RESULT_NONE = 0;
    static final int RESULT_SUCCESS = 1;

    @Nullable
    private static DeviceCredentialHandlerBridge sInstance;

    @Nullable
    private BiometricPrompt.AuthenticationCallback mAuthenticationCallback;

    @Nullable
    private BiometricFragment mBiometricFragment;
    private int mClientThemeResId;
    private boolean mConfirmingDeviceCredential;

    @Nullable
    private Executor mExecutor;

    @Nullable
    private FingerprintDialogFragment mFingerprintDialogFragment;

    @Nullable
    private FingerprintHelperFragment mFingerprintHelperFragment;

    @Nullable
    private DialogInterface.OnClickListener mOnClickListener;
    private int mDeviceCredentialResult = 0;
    private int mIgnoreResetState = 0;

    private DeviceCredentialHandlerBridge() {
    }

    @NonNull
    public static DeviceCredentialHandlerBridge getInstance() {
        if (sInstance == null) {
            sInstance = new DeviceCredentialHandlerBridge();
        }
        return sInstance;
    }

    @Nullable
    public static DeviceCredentialHandlerBridge getInstanceIfNotNull() {
        return sInstance;
    }

    @Nullable
    public BiometricPrompt.AuthenticationCallback getAuthenticationCallback() {
        return this.mAuthenticationCallback;
    }

    @Nullable
    public BiometricFragment getBiometricFragment() {
        return this.mBiometricFragment;
    }

    public int getClientThemeResId() {
        return this.mClientThemeResId;
    }

    public int getDeviceCredentialResult() {
        return this.mDeviceCredentialResult;
    }

    @Nullable
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Nullable
    public FingerprintDialogFragment getFingerprintDialogFragment() {
        return this.mFingerprintDialogFragment;
    }

    @Nullable
    public FingerprintHelperFragment getFingerprintHelperFragment() {
        return this.mFingerprintHelperFragment;
    }

    @Nullable
    public DialogInterface.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public void ignoreNextReset() {
        if (this.mIgnoreResetState == 0) {
            this.mIgnoreResetState = 1;
        }
    }

    public boolean isConfirmingDeviceCredential() {
        return this.mConfirmingDeviceCredential;
    }

    public void reset() {
        int i = this.mIgnoreResetState;
        if (i == 2) {
            return;
        }
        if (i == 1) {
            stopIgnoringReset();
            return;
        }
        this.mClientThemeResId = 0;
        this.mBiometricFragment = null;
        this.mFingerprintDialogFragment = null;
        this.mFingerprintHelperFragment = null;
        this.mExecutor = null;
        this.mOnClickListener = null;
        this.mAuthenticationCallback = null;
        this.mDeviceCredentialResult = 0;
        this.mConfirmingDeviceCredential = false;
        sInstance = null;
    }

    public void setBiometricFragment(@Nullable BiometricFragment biometricFragment) {
        this.mBiometricFragment = biometricFragment;
    }

    @SuppressLint({"LambdaLast"})
    public void setCallbacks(@NonNull Executor executor, @NonNull DialogInterface.OnClickListener onClickListener, @NonNull BiometricPrompt.AuthenticationCallback authenticationCallback) {
        this.mExecutor = executor;
        this.mOnClickListener = onClickListener;
        this.mAuthenticationCallback = authenticationCallback;
        BiometricFragment biometricFragment = this.mBiometricFragment;
        if (biometricFragment != null && Build.VERSION.SDK_INT >= 28) {
            biometricFragment.setCallbacks(executor, onClickListener, authenticationCallback);
            return;
        }
        FingerprintDialogFragment fingerprintDialogFragment = this.mFingerprintDialogFragment;
        if (fingerprintDialogFragment == null || this.mFingerprintHelperFragment == null) {
            return;
        }
        fingerprintDialogFragment.setNegativeButtonListener(onClickListener);
        this.mFingerprintHelperFragment.setCallback(executor, authenticationCallback);
        this.mFingerprintHelperFragment.setHandler(this.mFingerprintDialogFragment.getHandler());
    }

    public void setClientThemeResId(int i) {
        this.mClientThemeResId = i;
    }

    public void setConfirmingDeviceCredential(boolean z) {
        this.mConfirmingDeviceCredential = z;
    }

    public void setDeviceCredentialResult(int i) {
        this.mDeviceCredentialResult = i;
    }

    public void setFingerprintFragments(@Nullable FingerprintDialogFragment fingerprintDialogFragment, @Nullable FingerprintHelperFragment fingerprintHelperFragment) {
        this.mFingerprintDialogFragment = fingerprintDialogFragment;
        this.mFingerprintHelperFragment = fingerprintHelperFragment;
    }

    public void startIgnoringReset() {
        this.mIgnoreResetState = 2;
    }

    public void stopIgnoringReset() {
        this.mIgnoreResetState = 0;
    }
}
