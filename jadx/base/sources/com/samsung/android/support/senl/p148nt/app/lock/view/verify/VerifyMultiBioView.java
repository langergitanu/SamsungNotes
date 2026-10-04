package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.multi.MultiBiometricPrompt;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockDialogUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockToastUtils;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.SprImageView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyMultiBioView extends AbsBaseBiometricView {
    private static final String TAG = LockLogger.createTag("VerifyMultiBioView");
    private FingerprintApi mFingerprintApi;
    private boolean mFingerprintCanceledManually;
    private final FingerprintApi.OnAuthenticationListener mFingerprintListener;
    private TextView mGuideTextView;
    private IrisApi mIrisApi;
    private boolean mIrisCanceledManually;
    private final IrisApi.OnAuthenticationListener mIrisListener;
    private boolean mMultiBiometricCanceledManually;
    private final MultiBiometricPrompt.IMultiBiometricListener mMultiBiometricListener;
    private MultiBiometricPrompt mMultiBiometricPrompt;
    private View mPreview;

    public VerifyMultiBioView() {
        this.mFingerprintListener = new FingerprintApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiBioView.1
            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationError(int i, CharSequence charSequence) {
                VerifyMultiBioView.this.setGuideText(charSequence);
                if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_TIMEOUT) {
                    VerifyMultiBioView.this.setIsAutoCloseCase(true);
                    return;
                }
                if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT) {
                    VerifyMultiBioView.this.onAuthenticationLockedOut();
                    return;
                }
                if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT_PERMANENT) {
                    VerifyMultiBioView.this.onAuthenticationLockOutPermanent(charSequence);
                    return;
                }
                if (i != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_CANCELED && i != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_USER_CANCELED) {
                    VerifyMultiBioView.this.changeToPasswordVerification(1);
                    return;
                }
                if (VerifyMultiBioView.this.mFingerprintCanceledManually) {
                    LockLogger.m7356d(VerifyMultiBioView.TAG, "Fingerprint canceled manually");
                    VerifyMultiBioView.this.mFingerprintCanceledManually = false;
                } else {
                    if (VerifyMultiBioView.this.isChangingToPasswordUI()) {
                        return;
                    }
                    VerifyMultiBioView.this.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationFailed() {
                VerifyMultiBioView.this.setGuideText(C8003R.string.lock_fingerprint_no_match);
                if (VerifyMultiBioView.this.mFingerprintApi == null || !VerifyMultiBioView.this.mFingerprintApi.isUsingFingerprintManager()) {
                    return;
                }
                VerifyMultiBioView.this.onOldBiometricAuthenticationFailed();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationHelp(CharSequence charSequence) {
                VerifyMultiBioView.this.setGuideText(charSequence);
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationSucceeded() {
                VerifyMultiBioView.this.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onUsePasswordClicked() {
                VerifyMultiBioView.this.cancelAuthenticate();
                VerifyMultiBioView.this.changeToPasswordVerification(1);
            }
        };
        this.mIrisListener = new IrisApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiBioView.2
            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationError(int i, CharSequence charSequence) {
                LockLogger.m7356d(VerifyMultiBioView.TAG, "Iris onAuthenticationError : " + i + "/" + ((Object) charSequence));
                VerifyMultiBioView.this.setGuideText(charSequence);
                if (VerifyMultiBioView.this.mIrisApi != null && VerifyMultiBioView.this.mIrisApi.isRetryCase(i)) {
                    VerifyMultiBioView.this.showRetryDialog(charSequence);
                    return;
                }
                if (i == IrisApi.OnAuthenticationListener.ERROR_TIMEOUT) {
                    VerifyMultiBioView.this.setIsAutoCloseCase(true);
                    return;
                }
                if (i == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT) {
                    VerifyMultiBioView.this.onAuthenticationLockedOut();
                    return;
                }
                if (i == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT_PERMANENT) {
                    VerifyMultiBioView.this.onAuthenticationLockOutPermanent(charSequence);
                    return;
                }
                if (i != IrisApi.OnAuthenticationListener.ERROR_CANCELED) {
                    VerifyMultiBioView.this.changeToPasswordVerification(1);
                    return;
                }
                if (VerifyMultiBioView.this.mIrisCanceledManually) {
                    LockLogger.m7356d(VerifyMultiBioView.TAG, "Iris canceled manually");
                    VerifyMultiBioView.this.mIrisCanceledManually = false;
                } else {
                    if (VerifyMultiBioView.this.isChangingToPasswordUI()) {
                        return;
                    }
                    VerifyMultiBioView.this.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationFailed() {
                if (VerifyMultiBioView.this.getContext() == null || VerifyMultiBioView.this.mIrisApi == null || !VerifyMultiBioView.this.mIrisApi.isUsingIrisManager()) {
                    return;
                }
                VerifyMultiBioView verifyMultiBioView = VerifyMultiBioView.this;
                verifyMultiBioView.showRetryDialog(verifyMultiBioView.getContext().getString(C8003R.string.lock_iris_dialog_no_match));
                VerifyMultiBioView.this.onOldBiometricAuthenticationFailed();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationHelp(CharSequence charSequence) {
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationSucceeded() {
                VerifyMultiBioView.this.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onUsePasswordClicked() {
                VerifyMultiBioView.this.cancelAuthenticate();
                VerifyMultiBioView.this.changeToPasswordVerification(1);
            }
        };
        this.mMultiBiometricListener = new MultiBiometricPrompt.IMultiBiometricListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiBioView.3
            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationCanceled() {
                VerifyMultiBioView.this.finishCancel();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationError(int i, CharSequence charSequence) {
                if (i == 3) {
                    VerifyMultiBioView.this.setIsAutoCloseCase(true);
                    return;
                }
                if (i == 7) {
                    VerifyMultiBioView.this.onAuthenticationLockedOut();
                    return;
                }
                if (i == 9) {
                    VerifyMultiBioView.this.onAuthenticationLockOutPermanent(charSequence);
                    return;
                }
                if (i != 5) {
                    VerifyMultiBioView.this.changeToPasswordVerification(1);
                    return;
                }
                if (VerifyMultiBioView.this.mMultiBiometricCanceledManually) {
                    LockLogger.m7356d(VerifyMultiBioView.TAG, "multi biometric canceled manually");
                    VerifyMultiBioView.this.mMultiBiometricCanceledManually = false;
                } else {
                    if (VerifyMultiBioView.this.isChangingToPasswordUI()) {
                        return;
                    }
                    VerifyMultiBioView.this.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationFailed() {
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationSucceeded() {
                VerifyMultiBioView.this.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onUsePasswordClicked() {
                VerifyMultiBioView.this.cancelAuthenticate();
                VerifyMultiBioView.this.changeToPasswordVerification(1);
            }
        };
    }

    private void authenticateFingerUnderQ() {
        setIsWaitingPromptUI(true);
        this.mFingerprintApi.authenticate(getContext(), this.mFingerprintListener);
    }

    private void authenticateIrisUnderQ() {
        Context context = getContext();
        setIsWaitingPromptUI(true);
        this.mIrisApi.authenticate(context, this.mPreview, this.mIrisListener);
    }

    @RequiresApi(29)
    private void authenticateQ() {
        this.mMultiBiometricPrompt = new MultiBiometricPrompt();
        setIsWaitingPromptUI(true);
        this.mMultiBiometricPrompt.authenticate(getContext(), this.mMultiBiometricListener);
    }

    private void authenticateUnderQ() {
        this.mFingerprintApi = new FingerprintApi(FingerprintApi.ImplType.FINGERPRINT_MANAGER);
        this.mIrisApi = new IrisApi(IrisApi.ImplType.IRIS_MANAGER);
        this.mGuideTextView.setText(C8003R.string.lock_verify_fingerprint_iris_guide_text);
        if (checkBiometricChanging()) {
            changeToPasswordVerification(1);
            return;
        }
        boolean z = this.mFingerprintApi.isUsingFingerprintManager() || this.mIrisApi.isUsingIrisManager();
        if (z && isOldBiometricBlockedPermanent()) {
            changeToPasswordVerification(1);
        } else if (z && isOldBiometricBlocked()) {
            showTimerDialog(((int) getSavedOldBiometricBlockingTime()) / 1000);
        } else {
            authenticateFingerUnderQ();
            authenticateIrisUnderQ();
        }
    }

    private boolean checkBiometricChanging() {
        boolean zHasChangedFingerprint = this.mFingerprintApi.hasChangedFingerprint(getContext());
        boolean zHasChangedIris = this.mIrisApi.hasChangedIris(getContext());
        if (!zHasChangedFingerprint && !zHasChangedIris) {
            return false;
        }
        if (zHasChangedFingerprint) {
            LockPrefUtils.setPrefUseFingerprint(getContext(), false);
        }
        if (zHasChangedIris) {
            LockPrefUtils.setPrefUseIris(getContext(), false);
        }
        LockToastUtils.showBiometricChangeToast(getContext(), zHasChangedFingerprint, zHasChangedIris);
        return true;
    }

    private View createDefaultView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.lock_fingerprint_iris, viewGroup, false);
        this.mPreview = viewInflate.findViewById(C8003R.id.iris_preview);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.iris_guide_text);
        this.mGuideTextView = textView;
        textView.setText(C8003R.string.lock_verify_fingerprint_iris_guide_text);
        viewInflate.findViewById(C8003R.id.use_password).setOnClickListener(new ViewOnClickListenerC8142g(this, 1));
        return viewInflate;
    }

    private View createDexView(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.lock_dex_dialog_view, (ViewGroup) null);
        ((SprImageView) viewInflate.findViewById(C8003R.id.fingerprint_icon)).setVisibility(0);
        viewInflate.findViewById(C8003R.id.icon_divider).setVisibility(0);
        ((SprImageView) viewInflate.findViewById(C8003R.id.iris_icon)).setVisibility(0);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.dex_guide_text);
        this.mGuideTextView = textView;
        textView.setText(C8003R.string.lock_dex_use_fingerprint);
        ((Button) viewInflate.findViewById(C8003R.id.use_password)).setOnClickListener(new ViewOnClickListenerC8142g(this, 0));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDefaultView$1(View view) {
        CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_VERIFY_MULTI_BIO_SCREEN, "3221");
        changeToPasswordVerification(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDexView$0(View view) {
        cancelAuthenticate();
        CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_VERIFY_MULTI_BIO_SCREEN, "3221");
        changeToPasswordVerification(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$2(Handler handler, DialogInterface dialogInterface, int i) {
        handler.post(new RunnableC8141f(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$3(Handler handler, DialogInterface dialogInterface, int i) {
        handler.post(new RunnableC8141f(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuideText(CharSequence charSequence) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRetryDialog(CharSequence charSequence) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        AlertDialog alertDialog = this.mRetryDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            cancelAuthenticate();
            final Handler handler = new Handler();
            final int i = 0;
            final int i2 = 1;
            this.mRetryDialog = LockDialogUtils.showRetryIrisDialogWithError(context, charSequence, new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.e

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VerifyMultiBioView f6139b;

                {
                    this.f6139b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    switch (i) {
                        case 0:
                            this.f6139b.lambda$showRetryDialog$2(handler, dialogInterface, i4);
                            break;
                        default:
                            this.f6139b.lambda$showRetryDialog$3(handler, dialogInterface, i4);
                            break;
                    }
                }
            }, new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.e

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VerifyMultiBioView f6139b;

                {
                    this.f6139b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    switch (i2) {
                        case 0:
                            this.f6139b.lambda$showRetryDialog$2(handler, dialogInterface, i4);
                            break;
                        default:
                            this.f6139b.lambda$showRetryDialog$3(handler, dialogInterface, i4);
                            break;
                    }
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView
    public void authenticate() {
        if (getContext() == null) {
            return;
        }
        this.mFingerprintCanceledManually = false;
        this.mIrisCanceledManually = false;
        this.mMultiBiometricCanceledManually = false;
        if (Build.VERSION.SDK_INT >= 29) {
            authenticateQ();
        } else {
            authenticateUnderQ();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView
    @SuppressLint({WarningType.NewApi})
    public void cancelAuthenticate() {
        FingerprintApi fingerprintApi = this.mFingerprintApi;
        if (fingerprintApi != null) {
            this.mFingerprintCanceledManually = true;
            fingerprintApi.cancelAuthenticate();
        }
        IrisApi irisApi = this.mIrisApi;
        if (irisApi != null) {
            this.mIrisCanceledManually = true;
            irisApi.cancelAuthenticate();
        }
        MultiBiometricPrompt multiBiometricPrompt = this.mMultiBiometricPrompt;
        if (multiBiometricPrompt != null) {
            this.mMultiBiometricCanceledManually = true;
            multiBiometricPrompt.cancelAuthenticate();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void finishCancel() {
        cancelAuthenticate();
        super.finishCancel();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void finishSuccess() {
        cancelAuthenticate();
        super.finishSuccess();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext())) {
            LockLogger.m7356d(TAG, "createDexView");
            return createDexView(layoutInflater);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            LockLogger.m7356d(TAG, "emptyView");
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        LockLogger.m7356d(TAG, "createDefaultView");
        return createDefaultView(layoutInflater, viewGroup);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView, androidx.fragment.app.Fragment
    public void onDestroy() {
        cancelAuthenticate();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(-1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LockLogger.m7356d(TAG, "onResume");
        super.onResume();
        if (isBlockedByMultiwindow()) {
            LockToastUtils.showMultiWindowImpossibleToast(getContext());
            exitMultiWindow();
        } else if (isPasswordBlocked()) {
            showTimerDialog(((int) getSavedPasswordBlockingTime()) / 1000);
        } else {
            authenticate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGuideText(@StringRes int i) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public VerifyMultiBioView(AbsBaseBiometricView.PASSWORDTYPE passwordtype) {
        super(passwordtype);
        this.mFingerprintListener = new FingerprintApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiBioView.1
            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationError(int i, CharSequence charSequence) {
                VerifyMultiBioView.this.setGuideText(charSequence);
                if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_TIMEOUT) {
                    VerifyMultiBioView.this.setIsAutoCloseCase(true);
                    return;
                }
                if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT) {
                    VerifyMultiBioView.this.onAuthenticationLockedOut();
                    return;
                }
                if (i == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT_PERMANENT) {
                    VerifyMultiBioView.this.onAuthenticationLockOutPermanent(charSequence);
                    return;
                }
                if (i != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_CANCELED && i != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_USER_CANCELED) {
                    VerifyMultiBioView.this.changeToPasswordVerification(1);
                    return;
                }
                if (VerifyMultiBioView.this.mFingerprintCanceledManually) {
                    LockLogger.m7356d(VerifyMultiBioView.TAG, "Fingerprint canceled manually");
                    VerifyMultiBioView.this.mFingerprintCanceledManually = false;
                } else {
                    if (VerifyMultiBioView.this.isChangingToPasswordUI()) {
                        return;
                    }
                    VerifyMultiBioView.this.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationFailed() {
                VerifyMultiBioView.this.setGuideText(C8003R.string.lock_fingerprint_no_match);
                if (VerifyMultiBioView.this.mFingerprintApi == null || !VerifyMultiBioView.this.mFingerprintApi.isUsingFingerprintManager()) {
                    return;
                }
                VerifyMultiBioView.this.onOldBiometricAuthenticationFailed();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationHelp(CharSequence charSequence) {
                VerifyMultiBioView.this.setGuideText(charSequence);
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationSucceeded() {
                VerifyMultiBioView.this.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onUsePasswordClicked() {
                VerifyMultiBioView.this.cancelAuthenticate();
                VerifyMultiBioView.this.changeToPasswordVerification(1);
            }
        };
        this.mIrisListener = new IrisApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiBioView.2
            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationError(int i, CharSequence charSequence) {
                LockLogger.m7356d(VerifyMultiBioView.TAG, "Iris onAuthenticationError : " + i + "/" + ((Object) charSequence));
                VerifyMultiBioView.this.setGuideText(charSequence);
                if (VerifyMultiBioView.this.mIrisApi != null && VerifyMultiBioView.this.mIrisApi.isRetryCase(i)) {
                    VerifyMultiBioView.this.showRetryDialog(charSequence);
                    return;
                }
                if (i == IrisApi.OnAuthenticationListener.ERROR_TIMEOUT) {
                    VerifyMultiBioView.this.setIsAutoCloseCase(true);
                    return;
                }
                if (i == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT) {
                    VerifyMultiBioView.this.onAuthenticationLockedOut();
                    return;
                }
                if (i == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT_PERMANENT) {
                    VerifyMultiBioView.this.onAuthenticationLockOutPermanent(charSequence);
                    return;
                }
                if (i != IrisApi.OnAuthenticationListener.ERROR_CANCELED) {
                    VerifyMultiBioView.this.changeToPasswordVerification(1);
                    return;
                }
                if (VerifyMultiBioView.this.mIrisCanceledManually) {
                    LockLogger.m7356d(VerifyMultiBioView.TAG, "Iris canceled manually");
                    VerifyMultiBioView.this.mIrisCanceledManually = false;
                } else {
                    if (VerifyMultiBioView.this.isChangingToPasswordUI()) {
                        return;
                    }
                    VerifyMultiBioView.this.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationFailed() {
                if (VerifyMultiBioView.this.getContext() == null || VerifyMultiBioView.this.mIrisApi == null || !VerifyMultiBioView.this.mIrisApi.isUsingIrisManager()) {
                    return;
                }
                VerifyMultiBioView verifyMultiBioView = VerifyMultiBioView.this;
                verifyMultiBioView.showRetryDialog(verifyMultiBioView.getContext().getString(C8003R.string.lock_iris_dialog_no_match));
                VerifyMultiBioView.this.onOldBiometricAuthenticationFailed();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationHelp(CharSequence charSequence) {
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationSucceeded() {
                VerifyMultiBioView.this.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onUsePasswordClicked() {
                VerifyMultiBioView.this.cancelAuthenticate();
                VerifyMultiBioView.this.changeToPasswordVerification(1);
            }
        };
        this.mMultiBiometricListener = new MultiBiometricPrompt.IMultiBiometricListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiBioView.3
            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationCanceled() {
                VerifyMultiBioView.this.finishCancel();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationError(int i, CharSequence charSequence) {
                if (i == 3) {
                    VerifyMultiBioView.this.setIsAutoCloseCase(true);
                    return;
                }
                if (i == 7) {
                    VerifyMultiBioView.this.onAuthenticationLockedOut();
                    return;
                }
                if (i == 9) {
                    VerifyMultiBioView.this.onAuthenticationLockOutPermanent(charSequence);
                    return;
                }
                if (i != 5) {
                    VerifyMultiBioView.this.changeToPasswordVerification(1);
                    return;
                }
                if (VerifyMultiBioView.this.mMultiBiometricCanceledManually) {
                    LockLogger.m7356d(VerifyMultiBioView.TAG, "multi biometric canceled manually");
                    VerifyMultiBioView.this.mMultiBiometricCanceledManually = false;
                } else {
                    if (VerifyMultiBioView.this.isChangingToPasswordUI()) {
                        return;
                    }
                    VerifyMultiBioView.this.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationFailed() {
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onAuthenticationSucceeded() {
                VerifyMultiBioView.this.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.multi.MultiBiometricPrompt.IMultiBiometricListener
            public void onUsePasswordClicked() {
                VerifyMultiBioView.this.cancelAuthenticate();
                VerifyMultiBioView.this.changeToPasswordVerification(1);
            }
        };
    }
}
