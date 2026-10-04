package androidx.transition;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (Math.sqrt(Math.abs(f) * 2.0f) * ((double) Math.signum(f)));
    }

    public void addDataPoint(long j, float f) {
        int i = (this.mIndex + 1) % 20;
        this.mIndex = i;
        this.mTimeSamples[i] = j;
        this.mDataSamples[i] = f;
    }

    public float calculateVelocity() {
        float fKineticEnergyToVelocity;
        int i = this.mIndex;
        if (i == 0 && this.mTimeSamples[i] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j = this.mTimeSamples[i];
        int i2 = 0;
        long j2 = j;
        while (true) {
            long j3 = this.mTimeSamples[i];
            if (j3 == Long.MIN_VALUE) {
                break;
            }
            float f = j - j3;
            float fAbs = Math.abs(j3 - j2);
            if (f > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i == 0) {
                i = 20;
            }
            i--;
            i2++;
            if (i2 >= 20) {
                break;
            }
            j2 = j3;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        if (i2 == 2) {
            int i4 = this.mIndex;
            int i5 = i4 == 0 ? 19 : i4 - 1;
            long[] jArr = this.mTimeSamples;
            float f4 = jArr[i4] - jArr[i5];
            if (f4 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            fKineticEnergyToVelocity = (fArr[i4] - fArr[i5]) / f4;
        } else {
            int i6 = this.mIndex;
            int i7 = ((i6 - i2) + 21) % 20;
            int i8 = (i6 + 21) % 20;
            long j5 = this.mTimeSamples[i7];
            float f5 = this.mDataSamples[i7];
            int i9 = i7 + 1;
            float f6 = 0.0f;
            for (int i10 = i9 % 20; i10 != i8; i10 = (i10 + 1) % 20) {
                long j6 = this.mTimeSamples[i10];
                float f7 = j6 - j5;
                if (f7 != 0.0f) {
                    float f8 = this.mDataSamples[i10];
                    float f9 = (f8 - f5) / f7;
                    float fAbs2 = (Math.abs(f9) * (f9 - kineticEnergyToVelocity(f6))) + f6;
                    if (i10 == i9) {
                        fAbs2 *= 0.5f;
                    }
                    f6 = fAbs2;
                    f5 = f8;
                    j5 = j6;
                }
            }
            fKineticEnergyToVelocity = kineticEnergyToVelocity(f6);
        }
        return fKineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
