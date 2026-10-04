package com.samsung.android.support.senl.p148nt.app.lock.presenter.verify;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.AbsBasePresenter;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.IVerifyFingerprintContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/VerifyFingerprintPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/AbsBasePresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyFingerprintContract$IPresenter;", "mView", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyFingerprintContract$IView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyFingerprintContract$IView;)V", "mFingerprintApi", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi;", "mIsCanceledByManually", "", "onResume", "", "context", "Landroid/content/Context;", "authenticate", "cancelAuthenticate", "isBlocked", "()Z", "mAuthenticationListener", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VerifyFingerprintPresenter extends AbsBasePresenter implements IVerifyFingerprintContract.IPresenter {

    @NotNull
    private static final String TAG = LockLogger.createTag("VerifyFingerprintPresenter");

    @NotNull
    private final FingerprintApi.OnAuthenticationListener mAuthenticationListener;

    @Nullable
    private final FingerprintApi mFingerprintApi;
    private boolean mIsCanceledByManually;

    @Nullable
    private final IVerifyFingerprintContract.IView mView;

    public VerifyFingerprintPresenter(@Nullable IVerifyFingerprintContract.IView iView) {
        super(iView);
        this.mView = iView;
        this.mFingerprintApi = new FingerprintApi();
        this.mAuthenticationListener = new FingerprintApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.presenter.verify.VerifyFingerprintPresenter$mAuthenticationListener$1
            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationError(int errCode, CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                IVerifyFingerprintContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.setGuideText(errString);
                }
                if (errCode == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_TIMEOUT) {
                    IVerifyFingerprintContract.IView iView3 = this.this$0.mView;
                    if (iView3 != null) {
                        iView3.setIsAutoCloseCase(true);
                        return;
                    }
                    return;
                }
                if (errCode == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT) {
                    IVerifyFingerprintContract.IView iView4 = this.this$0.mView;
                    if (iView4 != null) {
                        iView4.onAuthenticationLockedOut();
                        return;
                    }
                    return;
                }
                if (errCode == FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_LOCKOUT_PERMANENT) {
                    IVerifyFingerprintContract.IView iView5 = this.this$0.mView;
                    if (iView5 != null) {
                        iView5.onAuthenticationLockOutPermanent(errString);
                        return;
                    }
                    return;
                }
                if (errCode != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_CANCELED && errCode != FingerprintApi.OnAuthenticationListener.PROMPT_ERROR_USER_CANCELED) {
                    IVerifyFingerprintContract.IView iView6 = this.this$0.mView;
                    if (iView6 != null) {
                        iView6.changeToPasswordVerification(1);
                        return;
                    }
                    return;
                }
                if (this.this$0.mView == null || this.this$0.mView.isChangingToPasswordUI() || this.this$0.mIsCanceledByManually) {
                    return;
                }
                this.this$0.mView.finishCancel();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationFailed() {
                IVerifyFingerprintContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.setGuideText(C8003R.string.lock_fingerprint_no_match);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationHelp(CharSequence helpString) {
                Intrinsics.checkNotNullParameter(helpString, "helpString");
                IVerifyFingerprintContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.setGuideText(helpString);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onAuthenticationSucceeded() {
                IVerifyFingerprintContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.onAuthenticationSuccess();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.fingerprint.FingerprintApi.OnAuthenticationListener
            public void onUsePasswordClicked() {
                this.this$0.cancelAuthenticate();
                IVerifyFingerprintContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.changeToPasswordVerification(1);
                }
            }
        };
    }

    private final boolean isBlocked() {
        IVerifyFingerprintContract.IView iView = this.mView;
        if (iView == null) {
            return false;
        }
        if (iView.isBiometricBlocked()) {
            IVerifyFingerprintContract.IView iView2 = this.mView;
            iView2.showTimerDialog(iView2.getRemainBlockTime());
            return true;
        }
        if (!this.mView.isPasswordBlocked()) {
            return false;
        }
        IVerifyFingerprintContract.IView iView3 = this.mView;
        iView3.showTimerDialog(((int) iView3.getSavedPasswordBlockingTime()) / 1000);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyFingerprintContract.IPresenter
    public void authenticate(@Nullable Context context) {
        FingerprintApi fingerprintApi = this.mFingerprintApi;
        if (fingerprintApi != null) {
            this.mIsCanceledByManually = false;
            fingerprintApi.authenticate(context, this.mAuthenticationListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyFingerprintContract.IPresenter
    public void cancelAuthenticate() {
        FingerprintApi fingerprintApi = this.mFingerprintApi;
        if (fingerprintApi != null) {
            this.mIsCanceledByManually = true;
            fingerprintApi.cancelAuthenticate();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyFingerprintContract.IPresenter
    public void onResume(@Nullable Context context) {
        if (isBlocked()) {
            return;
        }
        FingerprintApi fingerprintApi = this.mFingerprintApi;
        Intrinsics.checkNotNull(fingerprintApi);
        if (!fingerprintApi.hasChangedFingerprint(context)) {
            IVerifyFingerprintContract.IView iView = this.mView;
            if (iView != null) {
                iView.setIsWaitingPromptUI(true);
            }
            authenticate(context);
            return;
        }
        LockLogger.m7356d(TAG, "fingerprint changed");
        LockPrefUtils.setPrefUseFingerprint(context, false);
        IVerifyFingerprintContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.changeToPasswordVerification(2);
        }
    }
}
