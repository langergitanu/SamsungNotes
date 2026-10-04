package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    private final Clock mClock;
    final Scheduler mImmediateScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    public DelayedWorkTracker(@NonNull Scheduler scheduler, @NonNull RunnableScheduler runnableScheduler, @NonNull Clock clock) {
        this.mImmediateScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mClock = clock;
    }

    public void schedule(@NonNull final WorkSpec workSpec, long j) {
        Runnable runnableRemove = this.mRunnables.remove(workSpec.id);
        if (runnableRemove != null) {
            this.mRunnableScheduler.cancel(runnableRemove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.get().debug(DelayedWorkTracker.TAG, "Scheduling work " + workSpec.id);
                DelayedWorkTracker.this.mImmediateScheduler.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.id, runnable);
        this.mRunnableScheduler.scheduleWithDelay(j - this.mClock.currentTimeMillis(), runnable);
    }

    public void unschedule(@NonNull String str) {
        Runnable runnableRemove = this.mRunnables.remove(str);
        if (runnableRemove != null) {
            this.mRunnableScheduler.cancel(runnableRemove);
        }
    }
}
