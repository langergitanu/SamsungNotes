package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QuickSaveTimerController {
    private static final int MSG_ID_ON_TIME = 0;
    private static final long TIME_DELAY_DURATION = 10000;
    private static final long TIME_DURATION = 10000;
    private static final long TIME_LONG_DURATION = 180000;
    private boolean mIsAutoSaveOptionEnabled = true;
    private final TimeHandler mTimeHandler = new TimeHandler(Looper.getMainLooper());
    private OnTimeListener mTimeListener;
    private static final String TAG = Logger.createTag("QuickSaveTimerController");
    private static final ConcurrentHashMap<Tag, Long> mLockTagMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Empty extends QuickSaveTimerController {
        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void cancel(@Nullable String str) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void lock(Tag tag) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void pause(@Nullable String str) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void reset(@Nullable String str) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void setAutoSaveOptionEnabled(boolean z) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void setTimeListener(OnTimeListener onTimeListener) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void unLock(long j, @Nullable String str) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void lock(@Nullable String str) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void unLock(Tag tag) {
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController
        public void unLock(@Nullable String str) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTimeListener {
        void onTime();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Tag {
        Default,
        OnDragAndDrop
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeHandler extends Handler {
        private static final String TAG = Logger.createTag("QuickSaveTimerController$TimeHandler");
        private final AtomicBoolean mIsLock;
        private long mLastUnLockTime;
        private long timeUnlockDelay;

        public TimeHandler(@NonNull Looper looper) {
            super(looper);
            this.mIsLock = new AtomicBoolean(false);
            this.mLastUnLockTime = 0L;
            this.timeUnlockDelay = 10000L;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            if (message.what == 0 && (obj = message.obj) != null && (obj instanceof OnTimeListener)) {
                if (this.mIsLock.get() || !QuickSaveTimerController.mLockTagMap.isEmpty()) {
                    Logger.m11003i(TAG, "handleMessage, in lock state, sendMessageDelayed, delayedTime: " + this.timeUnlockDelay);
                    sendMessageDelayed(obtainMessage(0, message.obj), this.timeUnlockDelay);
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = this.mLastUnLockTime + this.timeUnlockDelay;
                if (jCurrentTimeMillis >= j) {
                    Logger.m10999d(TAG, "handleMessage, onTime");
                    ((OnTimeListener) message.obj).onTime();
                    return;
                }
                long j2 = j - jCurrentTimeMillis;
                Logger.m11003i(TAG, "handleMessage, sendMessageDelayed, delayedTime: " + j2);
                sendMessageDelayed(obtainMessage(0, message.obj), j2);
            }
        }

        public void lock() {
            if (this.mIsLock.get()) {
                return;
            }
            Logger.m11003i(TAG, "timer lock");
            this.mIsLock.set(true);
        }

        public void unLock(long j) {
            this.mLastUnLockTime = System.currentTimeMillis();
            this.timeUnlockDelay = j;
            if (this.mIsLock.get()) {
                this.mIsLock.set(false);
                Logger.m11003i(TAG, "timer unLock, TIME_LOCK_DELAYED: " + this.timeUnlockDelay + ", mLastUnLockTime: " + Logger.getTimeString(this.mLastUnLockTime));
            }
        }
    }

    public void cancel(@Nullable String str) {
        AbstractC8014b.m7197C("cancel, message: ", str, TAG);
        this.mTimeHandler.removeMessages(0);
        this.mTimeListener = null;
        mLockTagMap.clear();
    }

    public void lock(@Nullable String str) {
        AbstractC8014b.m7196B("lock, message: ", str, TAG);
        this.mTimeHandler.lock();
    }

    public void pause(@Nullable String str) {
        AbstractC8014b.m7197C("pause, message: ", str, TAG);
        this.mTimeHandler.removeMessages(0);
    }

    public void reset(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            AbstractC8014b.m7197C("timer reset, message: ", str, TAG);
        }
        if (this.mTimeListener == null) {
            Logger.m11004w(TAG, "reset, time listener is null.");
            return;
        }
        this.mTimeHandler.removeMessages(0);
        Message messageObtainMessage = this.mTimeHandler.obtainMessage(0, this.mTimeListener);
        if (this.mIsAutoSaveOptionEnabled) {
            this.mTimeHandler.sendMessageDelayed(messageObtainMessage, 10000L);
        } else {
            this.mTimeHandler.sendMessageDelayed(messageObtainMessage, TIME_LONG_DURATION);
        }
    }

    public void setAutoSaveOptionEnabled(boolean z) {
        this.mIsAutoSaveOptionEnabled = z;
    }

    public void setTimeListener(OnTimeListener onTimeListener) {
        this.mTimeListener = onTimeListener;
        reset("schedule");
    }

    public void unLock(@Nullable String str) {
        unLock(10000L, str);
    }

    public void unLock(long j, @Nullable String str) {
        Logger.m10999d(TAG, "unLock, delayTime: " + j + ", message: " + str);
        this.mTimeHandler.unLock(j);
    }

    public void unLock(Tag tag) {
        ConcurrentHashMap<Tag, Long> concurrentHashMap = mLockTagMap;
        if (concurrentHashMap.containsKey(tag)) {
            Logger.m10999d(TAG, "unLock, tag: " + tag + ", LockTime: " + Logger.getTimeString(concurrentHashMap.get(tag).longValue()) + ", mLockTagMap: " + concurrentHashMap.size());
            concurrentHashMap.remove(tag);
            return;
        }
        Logger.m10999d(TAG, "unLock, There is no '" + tag + "'. mLockTagMap: " + concurrentHashMap.size());
    }

    public void lock(Tag tag) {
        Logger.m10999d(TAG, "lock, tag: " + tag);
        mLockTagMap.put(tag, Long.valueOf(System.currentTimeMillis()));
    }
}
