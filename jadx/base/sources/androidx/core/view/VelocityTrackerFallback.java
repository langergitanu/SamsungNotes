package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j;
        int i = this.mDataPointsBufferSize;
        if (i < 2) {
            return 0.0f;
        }
        int i2 = this.mDataPointsBufferLastUsedIndex;
        int i4 = ((i2 + 20) - (i - 1)) % 20;
        long j2 = this.mEventTimes[i2];
        while (true) {
            jArr = this.mEventTimes;
            j = jArr[i4];
            if (j2 - j <= 100) {
                break;
            }
            this.mDataPointsBufferSize--;
            i4 = (i4 + 1) % 20;
        }
        int i5 = this.mDataPointsBufferSize;
        if (i5 < 2) {
            return 0.0f;
        }
        if (i5 == 2) {
            int i6 = (i4 + 1) % 20;
            if (j == jArr[i6]) {
                return 0.0f;
            }
            return this.mMovements[i6] / (r2 - j);
        }
        float f = 0.0f;
        int i7 = 0;
        for (int i8 = 0; i8 < this.mDataPointsBufferSize - 1; i8++) {
            int i9 = i8 + i4;
            long[] jArr2 = this.mEventTimes;
            long j3 = jArr2[i9 % 20];
            int i10 = (i9 + 1) % 20;
            if (jArr2[i10] != j3) {
                i7++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float f4 = this.mMovements[i10] / (this.mEventTimes[i10] - j3);
                float fAbs = (Math.abs(f4) * (f4 - fKineticEnergyToVelocity)) + f;
                if (i7 == 1) {
                    fAbs *= 0.5f;
                }
                f = fAbs;
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }

    public void addMovement(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i;
        int i2 = this.mDataPointsBufferSize;
        if (i2 != 20) {
            this.mDataPointsBufferSize = i2 + 1;
        }
        this.mMovements[i] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i) {
        computeCurrentVelocity(i, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int i) {
        if (i != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i, float f) {
        float currentVelocity = getCurrentVelocity() * i;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f))) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }
}
