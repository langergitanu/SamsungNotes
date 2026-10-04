package androidx.constraintlayout.core.motion.utils;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f) {
        this.mDone = false;
        float f4 = this.mStage1Duration;
        if (f <= f4) {
            float f5 = this.mStage1Velocity;
            return ((((this.mStage2Velocity - f5) * f) * f) / (f4 * 2.0f)) + (f5 * f);
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return this.mStage1EndPosition;
        }
        float f6 = f - f4;
        float f7 = this.mStage2Duration;
        if (f6 < f7) {
            float f8 = this.mStage1EndPosition;
            float f9 = this.mStage2Velocity;
            return ((((this.mStage3Velocity - f9) * f6) * f6) / (f7 * 2.0f)) + (f9 * f6) + f8;
        }
        if (i == 2) {
            return this.mStage2EndPosition;
        }
        float f10 = f6 - f7;
        float f11 = this.mStage3Duration;
        if (f10 > f11) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f12 = this.mStage2EndPosition;
        float f13 = this.mStage3Velocity;
        return ((f13 * f10) + f12) - (((f13 * f10) * f10) / (f11 * 2.0f));
    }

    private void setup(float f, float f4, float f5, float f6, float f7) {
        this.mDone = false;
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.mStage1Velocity = f;
        float f8 = f / f5;
        float f9 = (f8 * f) / 2.0f;
        if (f < 0.0f) {
            float fSqrt = (float) Math.sqrt((f4 - ((((-f) / f5) * f) / 2.0f)) * f5);
            if (fSqrt < f6) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                float f10 = (fSqrt - f) / f5;
                this.mStage1Duration = f10;
                this.mStage2Duration = fSqrt / f5;
                this.mStage1EndPosition = ((f + fSqrt) * f10) / 2.0f;
                this.mStage2EndPosition = f4;
                this.mStage3EndPosition = f4;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f6;
            this.mStage3Velocity = f6;
            float f11 = (f6 - f) / f5;
            this.mStage1Duration = f11;
            float f12 = f6 / f5;
            this.mStage3Duration = f12;
            float f13 = ((f + f6) * f11) / 2.0f;
            float f14 = (f12 * f6) / 2.0f;
            this.mStage2Duration = ((f4 - f13) - f14) / f6;
            this.mStage1EndPosition = f13;
            this.mStage2EndPosition = f4 - f14;
            this.mStage3EndPosition = f4;
            return;
        }
        if (f9 >= f4) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f4;
            this.mStage1Duration = (2.0f * f4) / f;
            return;
        }
        float f15 = f4 - f9;
        float f16 = f15 / f;
        if (f16 + f8 < f7) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f15;
            this.mStage2EndPosition = f4;
            this.mStage1Duration = f16;
            this.mStage2Duration = f8;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f * f) / 2.0f) + (f5 * f4));
        float f17 = (fSqrt2 - f) / f5;
        this.mStage1Duration = f17;
        float f18 = fSqrt2 / f5;
        this.mStage2Duration = f18;
        if (fSqrt2 < f6) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f17;
            this.mStage2Duration = f18;
            this.mStage1EndPosition = ((f + fSqrt2) * f17) / 2.0f;
            this.mStage2EndPosition = f4;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f;
        this.mStage2Velocity = f6;
        this.mStage3Velocity = f6;
        float f19 = (f6 - f) / f5;
        this.mStage1Duration = f19;
        float f20 = f6 / f5;
        this.mStage3Duration = f20;
        float f21 = ((f + f6) * f19) / 2.0f;
        float f22 = (f20 * f6) / 2.0f;
        this.mStage2Duration = ((f4 - f21) - f22) / f6;
        this.mStage1EndPosition = f21;
        this.mStage2EndPosition = f4 - f22;
        this.mStage3EndPosition = f4;
    }

    public void config(float f, float f4, float f5, float f6, float f7, float f8) {
        this.mDone = false;
        this.mStartPosition = f;
        boolean z = f > f4;
        this.mBackwards = z;
        if (z) {
            setup(-f5, f - f4, f7, f8, f6);
        } else {
            setup(f5, f4 - f, f7, f8, f6);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        StringBuilder sbM781w = AbstractC0541b.m781w(AbstractC0622a.m1170p(this.mType, "\n", AbstractC0541b.m781w(str, " ===== ")), str);
        sbM781w.append(this.mBackwards ? "backwards" : "forward ");
        sbM781w.append(" time = ");
        sbM781w.append(f);
        sbM781w.append("  stages ");
        String strM2223n = AbstractC2821a.m2223n(sbM781w, "\n", this.mNumberOfStages);
        StringBuilder sb = new StringBuilder();
        sb.append(strM2223n);
        sb.append(str);
        sb.append(" dur ");
        sb.append(this.mStage1Duration);
        sb.append(" vel ");
        sb.append(this.mStage1Velocity);
        sb.append(" pos ");
        String strM1217r = AbstractC1038a.m1217r(sb, "\n", this.mStage1EndPosition);
        if (this.mNumberOfStages > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strM1217r);
            sb2.append(str);
            sb2.append(" dur ");
            sb2.append(this.mStage2Duration);
            sb2.append(" vel ");
            sb2.append(this.mStage2Velocity);
            sb2.append(" pos ");
            strM1217r = AbstractC1038a.m1217r(sb2, "\n", this.mStage2EndPosition);
        }
        if (this.mNumberOfStages > 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(strM1217r);
            sb3.append(str);
            sb3.append(" dur ");
            sb3.append(this.mStage3Duration);
            sb3.append(" vel ");
            sb3.append(this.mStage3Velocity);
            sb3.append(" pos ");
            strM1217r = AbstractC1038a.m1217r(sb3, "\n", this.mStage3EndPosition);
        }
        float f4 = this.mStage1Duration;
        if (f <= f4) {
            return AbstractC0541b.m757C(strM1217r, str, "stage 0\n");
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return AbstractC0541b.m757C(strM1217r, str, "end stage 0\n");
        }
        float f5 = f - f4;
        float f6 = this.mStage2Duration;
        return f5 < f6 ? AbstractC0541b.m757C(strM1217r, str, " stage 1\n") : i == 2 ? AbstractC0541b.m757C(strM1217r, str, "end stage 1\n") : f5 - f6 < this.mStage3Duration ? AbstractC0541b.m757C(strM1217r, str, " stage 2\n") : AbstractC0541b.m757C(strM1217r, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        float fCalcY = calcY(f);
        this.mLastPosition = f;
        return this.mBackwards ? this.mStartPosition - fCalcY : this.mStartPosition + fCalcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        float f4;
        float f5;
        float f6 = this.mStage1Duration;
        if (f <= f6) {
            f4 = this.mStage1Velocity;
            f5 = this.mStage2Velocity;
        } else {
            int i = this.mNumberOfStages;
            if (i == 1) {
                return 0.0f;
            }
            f -= f6;
            f6 = this.mStage2Duration;
            if (f >= f6) {
                if (i == 2) {
                    return this.mStage2EndPosition;
                }
                float f7 = f - f6;
                float f8 = this.mStage3Duration;
                if (f7 >= f8) {
                    return this.mStage3EndPosition;
                }
                float f9 = this.mStage3Velocity;
                return f9 - ((f7 * f9) / f8);
            }
            f4 = this.mStage2Velocity;
            f5 = this.mStage3Velocity;
        }
        return (((f5 - f4) * f) / f6) + f4;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
