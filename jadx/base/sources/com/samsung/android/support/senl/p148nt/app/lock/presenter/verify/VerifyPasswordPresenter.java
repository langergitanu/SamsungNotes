package com.samsung.android.support.senl.p148nt.app.lock.presenter.verify;

import android.content.Context;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.samsung.android.sdk.pen.engine.drawLoop.RunnableC7449c;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.lock.model.timer.LockTimerModel;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.password.AbsPasswordPresenter;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.IVerifyPasswordContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/VerifyPasswordPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/AbsPasswordPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyPasswordContract$IPresenter;", "mView", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyPasswordContract$IView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyPasswordContract$IView;)V", "mTimerModel", "Lcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel;", "mMainThreadHandler", "Landroid/os/Handler;", "mTimerListener", "Lcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel$ILockTimerListener;", "verifyPassword", "", "context", "Landroid/content/Context;", "password", "", "failCount", "", "getFailCount", "()I", "onVerifySucceeded", "", "onVerifyFailed", "VerifyPasswordCallable", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VerifyPasswordPresenter extends AbsPasswordPresenter implements IVerifyPasswordContract.IPresenter {

    @NotNull
    private static final String TAG;

    @NotNull
    private static final ExecutorService mExecutor;

    @NotNull
    private final Handler mMainThreadHandler;

    @NotNull
    private final LockTimerModel.ILockTimerListener mTimerListener;

    @NotNull
    private final LockTimerModel mTimerModel;

    @NotNull
    private final IVerifyPasswordContract.IView mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.presenter.verify.VerifyPasswordPresenter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/lock/presenter/verify/VerifyPasswordPresenter$1", "Lcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel$ILockTimerListener;", "onStart", "", "blockingTime", "", "onTick", "remainTime", "", "onEnd", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C81091 implements LockTimerModel.ILockTimerListener {
        public C81091() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onEnd$lambda$2(VerifyPasswordPresenter verifyPasswordPresenter) {
            verifyPasswordPresenter.mView.onBlockingTimerEnded();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStart$lambda$0(VerifyPasswordPresenter verifyPasswordPresenter, long j) {
            verifyPasswordPresenter.mView.onBlockingTimerStarted(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onTick$lambda$1(VerifyPasswordPresenter verifyPasswordPresenter, int i) {
            verifyPasswordPresenter.mView.onBlockingTimeChanged(i);
        }

        @Override // com.samsung.android.support.senl.nt.app.lock.model.timer.LockTimerModel.ILockTimerListener
        public void onEnd() {
            LockLogger.m7356d(VerifyPasswordPresenter.TAG, "ILockTimerListener:onEnd");
            VerifyPasswordPresenter.this.mMainThreadHandler.post(new RunnableC8110a(VerifyPasswordPresenter.this, 2));
        }

        @Override // com.samsung.android.support.senl.nt.app.lock.model.timer.LockTimerModel.ILockTimerListener
        public void onStart(long blockingTime) {
            LockLogger.m7356d(VerifyPasswordPresenter.TAG, "ILockTimerListener:onStart");
            VerifyPasswordPresenter.this.mMainThreadHandler.post(new RunnableC7449c(VerifyPasswordPresenter.this, blockingTime));
        }

        @Override // com.samsung.android.support.senl.nt.app.lock.model.timer.LockTimerModel.ILockTimerListener
        public void onTick(int remainTime) {
            VerifyPasswordPresenter.this.mMainThreadHandler.post(new RunnableC0050f(VerifyPasswordPresenter.this, remainTime, 12));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/VerifyPasswordPresenter$VerifyPasswordCallable;", "Ljava/util/concurrent/Callable;", "", "mContext", "Landroid/content/Context;", "mPassword", "", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/VerifyPasswordPresenter;Landroid/content/Context;Ljava/lang/String;)V", NotificationCompat.CATEGORY_CALL, "", "()Ljava/lang/Boolean;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class VerifyPasswordCallable implements Callable<Object> {

        @Nullable
        private final Context mContext;

        @Nullable
        private final String mPassword;

        public VerifyPasswordCallable(@Nullable Context context, @Nullable String str) {
            this.mContext = context;
            this.mPassword = str;
        }

        @Override // java.util.concurrent.Callable
        @NotNull
        /* JADX INFO: renamed from: call, reason: merged with bridge method [inline-methods] */
        public Object call2() {
            VerifyPasswordPresenter.this.mView.ignoreInputEvent(true);
            ((AbsPasswordPresenter) VerifyPasswordPresenter.this).mPasswordModel.setEncryptedHashAndSalt(VerifyPasswordPresenter.this.mView.getEncryptedPasswordHash(), VerifyPasswordPresenter.this.mView.getEncryptedPasswordSalt());
            boolean zVerifyPassword = ((AbsPasswordPresenter) VerifyPasswordPresenter.this).mPasswordModel.verifyPassword(this.mContext, this.mPassword);
            VerifyPasswordPresenter.this.mView.ignoreInputEvent(false);
            if (zVerifyPassword) {
                VerifyPasswordPresenter.this.onVerifySucceeded();
            } else {
                VerifyPasswordPresenter.this.onVerifyFailed();
            }
            return Boolean.valueOf(zVerifyPassword);
        }
    }

    static {
        String strCreateTag = LockLogger.createTag("VerifyPasswordPresenter");
        TAG = strCreateTag;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(strCreateTag));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        mExecutor = executorServiceNewSingleThreadExecutor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyPasswordPresenter(@NotNull IVerifyPasswordContract.IView mView) {
        super(mView);
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.mMainThreadHandler = new Handler();
        C81091 c81091 = new C81091();
        this.mTimerListener = c81091;
        this.mTimerModel = new LockTimerModel(mView.getSavedFailCount(), mView.getSavedPasswordBlockingTime(), c81091);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVerifyFailed() {
        LockLogger.m7356d(TAG, "onVerifyFailed");
        this.mMainThreadHandler.post(new RunnableC8110a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVerifyFailed$lambda$1(VerifyPasswordPresenter verifyPasswordPresenter) {
        verifyPasswordPresenter.mView.setGuideWrongPasswordText();
        verifyPasswordPresenter.mTimerModel.increaseFailCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVerifySucceeded() {
        LockLogger.m7356d(TAG, "onVerifySucceeded");
        this.mMainThreadHandler.post(new RunnableC8110a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVerifySucceeded$lambda$0(VerifyPasswordPresenter verifyPasswordPresenter) {
        if (verifyPasswordPresenter.mView.isUseBiometricChecked()) {
            verifyPasswordPresenter.mView.setBiometricsEnabled();
        }
        verifyPasswordPresenter.mTimerModel.resetFailCount();
        verifyPasswordPresenter.mView.resetPasswordBlockingEndTime();
        verifyPasswordPresenter.mView.resetOldBiometricBlockingEndTime();
        verifyPasswordPresenter.finishSuccess();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IPresenter
    public int getFailCount() {
        return this.mTimerModel.getFailCount();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyPasswordContract.IPresenter
    public boolean verifyPassword(@Nullable Context context, @Nullable String password) {
        LockLogger.m7356d(TAG, "verifyPassword");
        try {
            Future futureSubmit = mExecutor.submit(new VerifyPasswordCallable(context, password));
            Intrinsics.checkNotNull(futureSubmit, "null cannot be cast to non-null type java.util.concurrent.FutureTask<kotlin.Boolean>");
            Object obj = ((FutureTask) futureSubmit).get();
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            return ((Boolean) obj).booleanValue();
        } catch (InterruptedException e) {
            LockLogger.m7357e(TAG, "verifyPassword# " + e.getMessage());
            return false;
        } catch (ExecutionException e2) {
            LockLogger.m7357e(TAG, "verifyPassword# " + e2.getMessage());
            return false;
        }
    }
}
