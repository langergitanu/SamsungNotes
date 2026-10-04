package com.samsung.android.support.senl.p148nt.app.lock.presenter.create;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.lock.model.password.PasswordModel;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.create.ICreateContract;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.password.AbsPasswordPresenter;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;
import p066P2.RunnableC0201c;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/create/CreatePasswordPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/AbsPasswordPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/create/ICreateContract$IPresenter;", "mView", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/create/ICreateContract$IView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/create/ICreateContract$IView;)V", "savePassword", "", "context", "Landroid/content/Context;", "password", "", "finishSuccess", "finishCancel", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CreatePasswordPresenter extends AbsPasswordPresenter implements ICreateContract.IPresenter {

    @NotNull
    private static final String TAG = LockLogger.createTag("CreatePasswordPresenter");

    @Nullable
    private final ICreateContract.IView mView;

    public CreatePasswordPresenter(@Nullable ICreateContract.IView iView) {
        super(iView);
        this.mView = iView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void savePassword$lambda$0(final CreatePasswordPresenter createPasswordPresenter, final Context context, String str) {
        ICreateContract.IView iView = createPasswordPresenter.mView;
        if (iView != null) {
            iView.ignoreInputEvent(true);
        }
        if (context == null || str == null) {
            return;
        }
        createPasswordPresenter.mPasswordModel.savePassword(context, str, new PasswordModel.OnSaveResultListener() { // from class: com.samsung.android.support.senl.nt.app.lock.presenter.create.CreatePasswordPresenter$savePassword$1$1
            @Override // com.samsung.android.support.senl.nt.app.lock.model.password.PasswordModel.OnSaveResultListener
            public void onFailure() {
                LockLogger.m7356d(CreatePasswordPresenter.TAG, "savePassword : onFailure");
                ICreateContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.ignoreInputEvent(false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.lock.model.password.PasswordModel.OnSaveResultListener
            public void onSuccess() {
                LockLogger.m7356d(CreatePasswordPresenter.TAG, "savePassword : onSuccess");
                ICreateContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.ignoreInputEvent(false);
                }
                ICreateContract.IView iView3 = this.this$0.mView;
                if (iView3 != null && iView3.isUseBiometricChecked()) {
                    this.this$0.mView.setBiometricsEnabled();
                }
                ICreateContract.IView iView4 = this.this$0.mView;
                if (iView4 != null) {
                    iView4.updatePasswordOwnerGuid();
                }
                C0145c.m308P(TimeManager.INSTANCE.getCurrentTime(context), "serverPassword", "serverPasswordKey");
                C14477a.m15065b().m15073i();
                ICreateContract.IView iView5 = this.this$0.mView;
                if (iView5 != null) {
                    iView5.resetOldBiometricBlockingEndTime();
                }
                this.this$0.finishSuccess();
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.presenter.base.AbsBasePresenter, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IPresenter
    public void finishCancel() {
        ICreateContract.IView iView = this.mView;
        if (iView != null) {
            iView.finishCancel();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.presenter.base.AbsBasePresenter, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IPresenter
    public void finishSuccess() {
        ICreateContract.IView iView = this.mView;
        if (iView != null) {
            iView.finishSuccess();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.create.ICreateContract.IPresenter
    public void savePassword(@Nullable Context context, @Nullable String password) {
        String str = TAG;
        LockLogger.m7356d(str, "savePassword");
        new SenlThreadFactory(str).newThread(new RunnableC0201c(this, 24, context, password)).start();
    }
}
