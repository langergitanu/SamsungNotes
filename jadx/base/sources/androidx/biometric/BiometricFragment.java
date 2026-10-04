package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import p065P1.AbstractC0195a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@SuppressLint({"SyntheticAccessor"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BiometricFragment extends Fragment {
    private static final String TAG = "BiometricFragment";
    private android.hardware.biometrics.BiometricPrompt mBiometricPrompt;
    private Bundle mBundle;
    private CancellationSignal mCancellationSignal;

    @VisibleForTesting
    BiometricPrompt.AuthenticationCallback mClientAuthenticationCallback;

    @VisibleForTesting
    Executor mClientExecutor;

    @VisibleForTesting
    DialogInterface.OnClickListener mClientNegativeButtonListener;
    private Context mContext;
    private BiometricPrompt.CryptoObject mCryptoObject;
    private CharSequence mNegativeButtonText;
    private boolean mShowing;
    private boolean mStartRespectingCancel;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Executor mExecutor = new Executor() { // from class: androidx.biometric.BiometricFragment.1
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            BiometricFragment.this.mHandler.post(runnable);
        }
    };

    @VisibleForTesting
    final android.hardware.biometrics.BiometricPrompt$AuthenticationCallback mAuthenticationCallback = new android.hardware.biometrics.BiometricPrompt$AuthenticationCallback() { // from class: androidx.biometric.BiometricFragment.2
        public void onAuthenticationError(final int i, final CharSequence charSequence) {
            if (Utils.isConfirmingDeviceCredential()) {
                return;
            }
            BiometricFragment.this.mClientExecutor.execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    CharSequence charSequence2 = charSequence;
                    if (charSequence2 == null) {
                        charSequence2 = BiometricFragment.this.mContext.getString(C0595R.string.default_error_msg) + " " + i;
                    }
                    BiometricFragment.this.mClientAuthenticationCallback.onAuthenticationError(Utils.isUnknownError(i) ? 8 : i, charSequence2);
                }
            });
            BiometricFragment.this.cleanup();
        }

        public void onAuthenticationFailed() {
            BiometricFragment.this.mClientExecutor.execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.2.3
                @Override // java.lang.Runnable
                public void run() {
                    BiometricFragment.this.mClientAuthenticationCallback.onAuthenticationFailed();
                }
            });
        }

        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            final BiometricPrompt.AuthenticationResult authenticationResult2 = authenticationResult != null ? new BiometricPrompt.AuthenticationResult(BiometricFragment.unwrapCryptoObject(authenticationResult.getCryptoObject())) : new BiometricPrompt.AuthenticationResult(null);
            BiometricFragment.this.mClientExecutor.execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.2.2
                @Override // java.lang.Runnable
                public void run() {
                    BiometricFragment.this.mClientAuthenticationCallback.onAuthenticationSucceeded(authenticationResult2);
                }
            });
            BiometricFragment.this.cleanup();
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }
    };
    private final DialogInterface.OnClickListener mNegativeButtonListener = new DialogInterface.OnClickListener() { // from class: androidx.biometric.BiometricFragment.3
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            BiometricFragment.this.mClientNegativeButtonListener.onClick(dialogInterface, i);
        }
    };
    private final DialogInterface.OnClickListener mDeviceCredentialButtonListener = new DialogInterface.OnClickListener() { // from class: androidx.biometric.BiometricFragment.4
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                Utils.launchDeviceCredentialConfirmation(BiometricFragment.TAG, BiometricFragment.this.getActivity(), BiometricFragment.this.mBundle, null);
            }
        }
    };

    public static BiometricFragment newInstance() {
        return new BiometricFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BiometricPrompt.CryptoObject unwrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new BiometricPrompt.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new BiometricPrompt.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new BiometricPrompt.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    private static BiometricPrompt.CryptoObject wrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            AbstractC0195a.m455B();
            return AbstractC0195a.m468k(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            AbstractC0195a.m455B();
            return AbstractC0195a.m467j(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        AbstractC0195a.m455B();
        return AbstractC0195a.m469l(cryptoObject.getMac());
    }

    public void cancel() {
        if (Build.VERSION.SDK_INT >= 29 && isDeviceCredentialAllowed() && !this.mStartRespectingCancel) {
            Log.w(TAG, "Ignoring fast cancel signal");
            return;
        }
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        cleanup();
    }

    public void cleanup() {
        this.mShowing = false;
        FragmentActivity activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().detach(this).commitAllowingStateLoss();
        }
        Utils.maybeFinishHandler(activity);
    }

    @Nullable
    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public boolean isDeviceCredentialAllowed() {
        Bundle bundle = this.mBundle;
        return bundle != null && bundle.getBoolean("allow_device_credential", false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle bundle2;
        if (!this.mShowing && (bundle2 = this.mBundle) != null) {
            this.mNegativeButtonText = bundle2.getCharSequence("negative_text");
            AbstractC0195a.m475r();
            BiometricPrompt.Builder builderM464g = AbstractC0195a.m464g(getContext());
            builderM464g.setTitle(this.mBundle.getCharSequence("title")).setSubtitle(this.mBundle.getCharSequence("subtitle")).setDescription(this.mBundle.getCharSequence("description"));
            boolean z = this.mBundle.getBoolean("allow_device_credential");
            if (z && Build.VERSION.SDK_INT <= 28) {
                String string = getString(C0595R.string.confirm_device_credential_password);
                this.mNegativeButtonText = string;
                builderM464g.setNegativeButton(string, this.mClientExecutor, this.mDeviceCredentialButtonListener);
            } else if (!TextUtils.isEmpty(this.mNegativeButtonText)) {
                builderM464g.setNegativeButton(this.mNegativeButtonText, this.mClientExecutor, this.mNegativeButtonListener);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builderM464g.setConfirmationRequired(this.mBundle.getBoolean("require_confirmation", true));
                builderM464g.setDeviceCredentialAllowed(z);
            }
            if (z) {
                this.mStartRespectingCancel = false;
                this.mHandler.postDelayed(new Runnable() { // from class: androidx.biometric.BiometricFragment.5
                    @Override // java.lang.Runnable
                    public void run() {
                        BiometricFragment.this.mStartRespectingCancel = true;
                    }
                }, 250L);
            }
            this.mBiometricPrompt = builderM464g.build();
            CancellationSignal cancellationSignal = new CancellationSignal();
            this.mCancellationSignal = cancellationSignal;
            BiometricPrompt.CryptoObject cryptoObject = this.mCryptoObject;
            if (cryptoObject == null) {
                this.mBiometricPrompt.authenticate(cancellationSignal, this.mExecutor, this.mAuthenticationCallback);
            } else {
                this.mBiometricPrompt.authenticate(wrapCryptoObject(cryptoObject), this.mCancellationSignal, this.mExecutor, this.mAuthenticationCallback);
            }
        }
        this.mShowing = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void setBundle(@Nullable Bundle bundle) {
        this.mBundle = bundle;
    }

    public void setCallbacks(Executor executor, DialogInterface.OnClickListener onClickListener, BiometricPrompt.AuthenticationCallback authenticationCallback) {
        this.mClientExecutor = executor;
        this.mClientNegativeButtonListener = onClickListener;
        this.mClientAuthenticationCallback = authenticationCallback;
    }

    public void setCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        this.mCryptoObject = cryptoObject;
    }
}
