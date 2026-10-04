package com.samsung.android.support.senl.p148nt.app.lock.presenter.verify;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.AbsBasePresenter;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.IVerifyIrisContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockToastUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/VerifyIrisPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/AbsBasePresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyIrisContract$IPresenter;", "mView", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyIrisContract$IView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyIrisContract$IView;)V", "mIrisApi", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi;", "onResume", "", "context", "Landroid/content/Context;", "authenticate", "cancelAuthenticate", "mOnAuthenticationListener", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$OnAuthenticationListener;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VerifyIrisPresenter extends AbsBasePresenter implements IVerifyIrisContract.IPresenter {

    @NotNull
    private static final String TAG = LockLogger.createTag("VerifyIrisPresenter");

    @NotNull
    private final IrisApi mIrisApi;

    @NotNull
    private final IrisApi.OnAuthenticationListener mOnAuthenticationListener;

    @NotNull
    private final IVerifyIrisContract.IView mView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyIrisPresenter(@NotNull IVerifyIrisContract.IView mView) {
        super(mView);
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.mIrisApi = new IrisApi();
        this.mOnAuthenticationListener = new IrisApi.OnAuthenticationListener() { // from class: com.samsung.android.support.senl.nt.app.lock.presenter.verify.VerifyIrisPresenter$mOnAuthenticationListener$1
            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationError(int errCode, CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                this.this$0.mView.setGuideText(errString);
                if (this.this$0.mIrisApi.isRetryCase(errCode)) {
                    this.this$0.mView.showRetryDialog(errString);
                    return;
                }
                if (errCode == IrisApi.OnAuthenticationListener.ERROR_TIMEOUT) {
                    this.this$0.mView.setIsAutoCloseCase(true);
                    return;
                }
                if (errCode == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT) {
                    this.this$0.mView.onAuthenticationLockedOut();
                    return;
                }
                if (errCode == IrisApi.OnAuthenticationListener.ERROR_LOCKOUT_PERMANENT) {
                    this.this$0.mView.onAuthenticationLockOutPermanent(errString);
                } else if (errCode != IrisApi.OnAuthenticationListener.ERROR_CANCELED) {
                    this.this$0.mView.changeToPasswordVerification(1);
                } else {
                    if (this.this$0.mView.isChangingToPasswordUI()) {
                        return;
                    }
                    this.this$0.finishCancel();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationFailed() {
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationHelp(CharSequence helpString) {
                Intrinsics.checkNotNullParameter(helpString, "helpString");
                this.this$0.mView.setGuideText(helpString);
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onAuthenticationSucceeded() {
                this.this$0.mView.onAuthenticationSuccess();
            }

            @Override // com.samsung.android.support.senl.nt.app.biometrics.iris.IrisApi.OnAuthenticationListener
            public void onUsePasswordClicked() {
                this.this$0.cancelAuthenticate();
                this.this$0.mView.changeToPasswordVerification(1);
            }
        };
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IPresenter
    public void authenticate(@Nullable Context context) {
        if (context == null) {
            return;
        }
        if (this.mView.isPasswordBlocked()) {
            IVerifyIrisContract.IView iView = this.mView;
            iView.showTimerDialog(((int) iView.getSavedPasswordBlockingTime()) / 1000);
        } else if (!this.mIrisApi.hasChangedIris(context)) {
            this.mView.setIsWaitingPromptUI(true);
            this.mIrisApi.authenticate(context, this.mView.getPreView(), this.mOnAuthenticationListener);
        } else {
            LockLogger.m7356d(TAG, "iris changed");
            LockToastUtils.showBiometricChangeToast(context, false, true);
            LockPrefUtils.setPrefUseIris(context, false);
            this.mView.changeToPasswordVerification(1);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IPresenter
    public void cancelAuthenticate() {
        this.mIrisApi.cancelAuthenticate();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IPresenter
    public void onResume(@Nullable Context context) {
        authenticate(context);
    }
}
