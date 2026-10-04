package com.samsung.android.support.senl.p148nt.app.lock.model.timer;

import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel;", "", "failCount", "", "mBlockingTime", "", "mListener", "Lcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel$ILockTimerListener;", "<init>", "(IJLcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel$ILockTimerListener;)V", "getFailCount", "()I", "setFailCount", "(I)V", "mRemainSeconds", "mTimer", "Ljava/util/Timer;", "checkSavedData", "", "startTimer", "increaseFailCount", "resetFailCount", "ILockTimerListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockTimerModel {
    private static final long MAX_BLOCKING_TIME = 30000;
    private int failCount;
    private long mBlockingTime;

    @NotNull
    private final ILockTimerListener mListener;
    private int mRemainSeconds;

    @Nullable
    private Timer mTimer;

    @NotNull
    private static final String TAG = LockLogger.createTag("LockTimerModel");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/model/timer/LockTimerModel$ILockTimerListener;", "", "onStart", "", "blockingTime", "", "onTick", "remainTime", "", "onEnd", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ILockTimerListener {
        void onEnd();

        void onStart(long blockingTime);

        void onTick(int remainTime);
    }

    public LockTimerModel(int i, long j, @NotNull ILockTimerListener mListener) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.failCount = i;
        this.mBlockingTime = j;
        this.mListener = mListener;
        checkSavedData();
    }

    private final void checkSavedData() {
        long j = this.mBlockingTime;
        if (j > 30000) {
            j = 0;
        }
        this.mBlockingTime = j;
        if (j > 0) {
            startTimer();
        }
    }

    private final void startTimer() {
        Logger.m8697d(TAG, "startTimer");
        this.mListener.onStart(this.mBlockingTime);
        this.mRemainSeconds = ((int) (this.mBlockingTime / ((long) 1000))) + 1;
        this.mTimer = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.samsung.android.support.senl.nt.app.lock.model.timer.LockTimerModel$startTimer$timeTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.mRemainSeconds--;
                if (this.this$0.mRemainSeconds > 0) {
                    this.this$0.mListener.onTick(this.this$0.mRemainSeconds);
                    return;
                }
                Timer timer = this.this$0.mTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this.this$0.mTimer = null;
                this.this$0.mListener.onEnd();
            }
        };
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.schedule(timerTask, 0L, 1000L);
        }
    }

    public final int getFailCount() {
        return this.failCount;
    }

    public final void increaseFailCount() {
        int i = this.failCount + 1;
        this.failCount = i;
        if (i % 5 == 0) {
            this.mBlockingTime = 30000L;
            startTimer();
        }
    }

    public final void resetFailCount() {
        this.failCount = 0;
    }

    public final void setFailCount(int i) {
        this.failCount = i;
    }
}
