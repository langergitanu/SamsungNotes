package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;

    /* JADX INFO: renamed from: mV */
    private float f1232mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d) {
        double d2 = this.mStiffness;
        double d3 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d2 / ((double) this.mMass)) * d) * 4.0d)) + 1.0d);
        double d4 = d / ((double) iSqrt);
        int i = 0;
        while (i < iSqrt) {
            float f = this.mPos;
            double d5 = this.mTargetPos;
            float f4 = this.f1232mV;
            double d6 = d2;
            double d7 = ((-d2) * (((double) f) - d5)) - (((double) f4) * d3);
            float f5 = this.mMass;
            double d8 = d3;
            double d9 = (((d7 / ((double) f5)) * d4) / 2.0d) + ((double) f4);
            double d10 = ((((-((((d4 * d9) / 2.0d) + ((double) f)) - d5)) * d6) - (d9 * d8)) / ((double) f5)) * d4;
            float f6 = (float) (((double) f4) + d10);
            this.f1232mV = f6;
            float f7 = (float) ((((d10 / 2.0d) + ((double) f4)) * d4) + ((double) f));
            this.mPos = f7;
            int i2 = this.mBoundaryMode;
            if (i2 > 0) {
                if (f7 < 0.0f && (i2 & 1) == 1) {
                    this.mPos = -f7;
                    this.f1232mV = -f6;
                }
                float f8 = this.mPos;
                if (f8 > 1.0f && (i2 & 2) == 2) {
                    this.mPos = 2.0f - f8;
                    this.f1232mV = -this.f1232mV;
                }
            }
            i++;
            d2 = d6;
            d3 = d8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        double d = this.mStiffness;
        return ((float) (((-d) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.f1232mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        compute(f - this.mLastTime);
        this.mLastTime = f;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = ((double) this.mPos) - this.mTargetPos;
        double d2 = this.mStiffness;
        double d3 = this.f1232mV;
        return Math.sqrt((((d2 * d) * d) + ((d3 * d3) * ((double) this.mMass))) / d2) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f, float f4, float f5, float f6, float f7, float f8, float f9, int i) {
        this.mTargetPos = f4;
        this.mDamping = f8;
        this.mInitialized = false;
        this.mPos = f;
        this.mLastVelocity = f5;
        this.mStiffness = f7;
        this.mMass = f6;
        this.mStopThreshold = f9;
        this.mBoundaryMode = i;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.f1232mV;
    }
}
