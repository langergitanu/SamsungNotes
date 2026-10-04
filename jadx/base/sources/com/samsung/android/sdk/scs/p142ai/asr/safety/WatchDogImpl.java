package com.samsung.android.sdk.scs.p142ai.asr.safety;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDogImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class WatchDogImpl implements WatchDog {
    private final String TAG;
    private final long createTime;
    private final boolean interrupt;
    private final Thread thread;
    private final List<TimeOutCheck> watchDogCallbacks;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeOutCheck {
        private final String TAG;
        private final WatchDogCallback callback;
        private final long startTime;
        private final long timeoutTime;

        public /* synthetic */ TimeOutCheck(String str, WatchDogCallback watchDogCallback, long j, int i) {
            this(str, watchDogCallback, j);
        }

        /* JADX INFO: renamed from: b */
        public static /* bridge */ /* synthetic */ boolean m6195b(WatchDogCallback watchDogCallback, TimeOutCheck timeOutCheck) {
            return timeOutCheck.isMatched(watchDogCallback);
        }

        private boolean isMatched(WatchDogCallback watchDogCallback) {
            return this.callback == watchDogCallback;
        }

        public boolean isTimeout() {
            return System.currentTimeMillis() > this.timeoutTime;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TimeCheck{callback=");
            sb.append(this.callback);
            sb.append(", timeoutTime=");
            sb.append(WatchDog.createTimeStr(this.timeoutTime));
            sb.append(", watchDog=");
            return AbstractC1038a.m1213n('}', this.TAG, sb);
        }

        private TimeOutCheck(String str, WatchDogCallback watchDogCallback, long j) {
            this.TAG = str;
            this.callback = watchDogCallback;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.startTime = jCurrentTimeMillis;
            this.timeoutTime = jCurrentTimeMillis + j;
        }
    }

    public WatchDogImpl(boolean z, Thread thread) {
        String str = "WatchDog@" + hashCode();
        this.TAG = str;
        this.watchDogCallbacks = Collections.synchronizedList(new ArrayList());
        this.interrupt = z;
        this.thread = thread;
        this.createTime = System.currentTimeMillis();
        Log.m6489i(str, "created " + z);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog, java.lang.AutoCloseable
    public void close() {
        this.watchDogCallbacks.clear();
        WatchDogService.remove(this.thread);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog
    public void executeWatchDog() {
        for (TimeOutCheck timeOutCheck : this.watchDogCallbacks) {
            if (timeOutCheck != null) {
                try {
                    if (timeOutCheck.isTimeout() && this.watchDogCallbacks.remove(timeOutCheck)) {
                        Log.m6489i(this.TAG, "start to handle watchdog " + timeOutCheck + " , " + this.thread);
                        try {
                            if (this.interrupt) {
                                this.thread.interrupt();
                            }
                            timeOutCheck.callback.onTimeoutDetected();
                        } catch (Throwable th) {
                            timeOutCheck.callback.onTimeoutDetected();
                            throw th;
                        }
                    }
                } catch (Exception e) {
                    if (WatchDog.isDevelop) {
                        Log.m6488e(this.TAG, "error to handle watchdog execution", e);
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog
    public boolean isWatching() {
        return !this.watchDogCallbacks.isEmpty();
    }

    public String toString() {
        return this.TAG + Parse.BRACKET_LCB + this.watchDogCallbacks.size() + ", createTime=" + WatchDog.createTimeStr(this.createTime) + '}';
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog
    /* JADX INFO: renamed from: unWatchBlocking */
    public void lambda$wrapBlocking$0(final WatchDogCallback watchDogCallback) {
        if (watchDogCallback != null) {
            List<TimeOutCheck> list = this.watchDogCallbacks;
            if (!list.removeAll((Collection) list.stream().filter(new Predicate() { // from class: com.samsung.android.sdk.scs.ai.asr.safety.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return WatchDogImpl.TimeOutCheck.m6195b(watchDogCallback, (WatchDogImpl.TimeOutCheck) obj);
                }
            }).collect(Collectors.toSet()))) {
                Log.m6490w(this.TAG, "unWatchBlocking failed. already handled by watchdog service. " + watchDogCallback);
            }
        } else {
            Log.m6490w(this.TAG, "ignore unWatchdog because callback is null");
        }
        if (this.watchDogCallbacks.isEmpty()) {
            return;
        }
        Log.m6490w(this.TAG, "remained " + this.watchDogCallbacks.size());
    }

    @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDog
    public void watchBlocking(WatchDogCallback watchDogCallback, long j) {
        if (watchDogCallback == null) {
            Log.m6490w(this.TAG, "ignore watchdog because callback is null");
        } else {
            this.watchDogCallbacks.add(new TimeOutCheck(this.TAG, watchDogCallback, j, 0));
            WatchDogService.triggerSchedule();
        }
    }
}
