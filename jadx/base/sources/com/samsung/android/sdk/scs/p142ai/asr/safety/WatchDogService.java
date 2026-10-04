package com.samsung.android.sdk.scs.p142ai.asr.safety;

import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class WatchDogService {
    private static final long CHECK_INTERVAL;
    private static final String TAG = "WatchDogService";
    static final ScheduledThreadPoolExecutor TIMER;
    private static final AtomicBoolean mIsObserving;
    private static final AtomicLong sThreadCnt;
    static final Map<Thread, WatchDog> watchDogHolders = new ConcurrentHashMap();
    private static final long WATCHDOG_MAX_ALIVE_TIME = TimeUnit.HOURS.toMillis(6);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RepeatableTask {
        private static final AtomicLong mCounting = new AtomicLong(0);
        private final Runnable mExec;
        private final ScheduledExecutorService mExecutor;
        private final long mPeriodInMs;
        private final Runnable mPost;
        private final Runnable mPre;
        private final BooleanSupplier mUntil;

        private synchronized void close() {
            try {
                Runnable runnable = this.mPost;
                if (runnable != null) {
                    runnable.run();
                }
                Log.m6489i(WatchDogService.TAG, "dec- " + mCounting.decrementAndGet());
            } catch (Throwable th) {
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exec() {
            Runnable runnable = this.mPre;
            if (runnable != null) {
                runnable.run();
            }
            iteration();
        }

        private boolean hasNext() {
            return this.mUntil.getAsBoolean();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iteration() {
            try {
                this.mExec.run();
                if (hasNext()) {
                    this.mExecutor.schedule(new RunnableC7704g(this, 1), this.mPeriodInMs, TimeUnit.MILLISECONDS);
                } else {
                    close();
                }
            } catch (Exception e) {
                Log.m6488e(WatchDogService.TAG, "error on iteration. so finish iteration.", e);
                close();
            }
        }

        private RepeatableTask(ScheduledExecutorService scheduledExecutorService, Runnable runnable, Runnable runnable2, Runnable runnable3, long j, BooleanSupplier booleanSupplier) {
            this.mExecutor = scheduledExecutorService;
            this.mPre = runnable;
            this.mExec = runnable2;
            this.mPost = runnable3;
            this.mPeriodInMs = j;
            this.mUntil = booleanSupplier;
            Log.m6489i(WatchDogService.TAG, "inc+ " + mCounting.incrementAndGet() + " with interval: " + j);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CHECK_INTERVAL = timeUnit.toMillis(1L);
        mIsObserving = new AtomicBoolean(false);
        sThreadCnt = new AtomicLong(0L);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new ThreadFactoryC7706i());
        TIMER = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, timeUnit);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private static void checkState() {
        Map<Thread, WatchDog> map = watchDogHolders;
        if (map.isEmpty()) {
            return;
        }
        Log.m6489i(TAG, "checkState " + map.size());
        for (Map.Entry<Thread, WatchDog> entry : map.entrySet()) {
            try {
                Log.m6489i(TAG, entry.getKey() + " : " + entry.getValue());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkWatchDog() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<Thread, WatchDog>> it = watchDogHolders.entrySet().iterator();
        while (it.hasNext()) {
            try {
                WatchDog value = it.next().getValue();
                if (value != null) {
                    if (jCurrentTimeMillis - value.getCreateTime() > WATCHDOG_MAX_ALIVE_TIME) {
                        it.remove();
                        Log.m6487e(TAG, "remove watchdog with expired " + value);
                    } else {
                        value.executeWatchDog();
                    }
                }
            } catch (Exception e) {
                if (WatchDog.isDevelop) {
                    Log.m6488e(TAG, "error to handle watch dog", e);
                }
            }
        }
    }

    public static WatchDog create(final boolean z) {
        return watchDogHolders.computeIfAbsent(Thread.currentThread(), new Function() { // from class: com.samsung.android.sdk.scs.ai.asr.safety.j
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return WatchDogService.lambda$create$0(z, (Thread) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWatching() {
        return watchDogHolders.values().stream().anyMatch(new C7705h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WatchDog lambda$create$0(boolean z, Thread thread) {
        return new WatchDogImpl(z, thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onStopSchedule() {
        Log.m6489i(TAG, "onStopSchedule " + watchDogHolders.size());
        mIsObserving.set(false);
    }

    public static void remove(Thread thread) {
        WatchDog watchDogRemove;
        if (thread != null && (watchDogRemove = watchDogHolders.remove(thread)) != null) {
            Log.m6489i(TAG, "Remove watchdog on " + thread + " = " + watchDogRemove);
        }
        checkState();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.samsung.android.sdk.scs.ai.asr.safety.e] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.samsung.android.sdk.scs.ai.asr.safety.e] */
    public static void triggerSchedule() {
        if (mIsObserving.compareAndSet(false, true)) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = TIMER;
            final int i = 0;
            ?? r32 = new Runnable() { // from class: com.samsung.android.sdk.scs.ai.asr.safety.e
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            WatchDogService.checkWatchDog();
                            break;
                        default:
                            WatchDogService.onStopSchedule();
                            break;
                    }
                }
            };
            final int i2 = 1;
            scheduledThreadPoolExecutor.execute(new RunnableC7704g(new RepeatableTask(scheduledThreadPoolExecutor, r32, new Runnable() { // from class: com.samsung.android.sdk.scs.ai.asr.safety.e
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            WatchDogService.checkWatchDog();
                            break;
                        default:
                            WatchDogService.onStopSchedule();
                            break;
                    }
                }
            }, CHECK_INTERVAL, new C7703f()), 0));
        }
    }

    public static Thread watchdogThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("WatchDog#" + sThreadCnt.getAndIncrement());
        return thread;
    }
}
