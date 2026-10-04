package com.samsung.android.sdk.ocr;

import android.os.Looper;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SafeCloser {
    private static final String TAG = "SafeCloser";
    private static final int THREAD_SLEEP_TIME_INTERVAL = 10;
    private final int[] API_CALL_COUNTS;
    private int mInstanceID;

    public SafeCloser(int i) {
        this.mInstanceID = 0;
        int[] iArr = new int[RecognizerApi.values().length];
        this.API_CALL_COUNTS = iArr;
        this.mInstanceID = i;
        Arrays.fill(iArr, 0);
    }

    private int getAllApiCallingCount() {
        return Arrays.stream(this.API_CALL_COUNTS).sum();
    }

    private void waitingSeveralTimes(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC11014a.m12328m(i2, "waitUntilOtherThreadIsDone() : waiting check [", "]th", TAG);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (getAllApiCallingCount() > 0) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized void decreaseCallingCountOf(RecognizerApi recognizerApi) {
        int index = recognizerApi.toIndex();
        Log.i(TAG, "decreaseCallingCountOf : [" + this.mInstanceID + "] apiName = " + recognizerApi.toName() + ", apiIndex = " + index);
        StringBuilder sb = new StringBuilder("decreaseCallingCountOf : [");
        sb.append(this.mInstanceID);
        sb.append("] currCount = ");
        sb.append(this.API_CALL_COUNTS[index]);
        Log.d(TAG, sb.toString());
        this.API_CALL_COUNTS[index] = Math.max(r7[index] - 1, 0);
        Log.d(TAG, "decreaseCallingCountOf : [" + this.mInstanceID + "] nextCount = " + this.API_CALL_COUNTS[index]);
    }

    public synchronized void increaseCallingCountOf(RecognizerApi recognizerApi) {
        int index = recognizerApi.toIndex();
        Log.i(TAG, "increaseCallingCountOf : [" + this.mInstanceID + "] apiName = " + recognizerApi.toName() + ", apiIndex = " + index);
        StringBuilder sb = new StringBuilder("increaseCallingCountOf : [");
        sb.append(this.mInstanceID);
        sb.append("] currCount = ");
        sb.append(this.API_CALL_COUNTS[index]);
        Log.d(TAG, sb.toString());
        int[] iArr = this.API_CALL_COUNTS;
        iArr[index] = Math.min(iArr[index] + 1, Integer.MAX_VALUE);
        Log.d(TAG, "increaseCallingCountOf : [" + this.mInstanceID + "] nextCount = " + this.API_CALL_COUNTS[index]);
    }

    public void waitUntilOtherThreadIsDone() {
        int allApiCallingCount = getAllApiCallingCount();
        Log.i(TAG, "waitUntilOtherThreadIsDone() : [" + this.mInstanceID + "] workingApiCount = " + allApiCallingCount);
        if (allApiCallingCount > 0) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Log.i(TAG, "waitUntilOtherThreadIsDone() : This is main thread, so cannot wait!");
                return;
            }
            Log.i(TAG, "waitUntilOtherThreadIsDone() : This is worker thread, so wait until ocr process will be done.");
            waitingSeveralTimes(2);
            Log.i(TAG, "waitUntilOtherThreadIsDone() : workingApiCount is 0, so resume this thread.");
        }
    }
}
