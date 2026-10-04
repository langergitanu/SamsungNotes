package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u0004R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\u0004\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "(F)V", "dampedFreq", "", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "gammaMinus", "gammaPlus", "initialized", "", "naturalFreq", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", "init", "", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SpringSimulation {
    public static final int $stable = 8;
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f) {
        this.finalPosition = f;
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f = this.dampingRatio;
        double d = ((double) f) * ((double) f);
        if (f > 1.0f) {
            double d2 = this.naturalFreq;
            double d3 = d - ((double) 1);
            this.gammaPlus = (Math.sqrt(d3) * d2) + (((double) (-f)) * d2);
            double d4 = -this.dampingRatio;
            double d5 = this.naturalFreq;
            this.gammaMinus = (d4 * d5) - (Math.sqrt(d3) * d5);
        } else if (f >= 0.0f && f < 1.0f) {
            this.dampedFreq = Math.sqrt(((double) 1) - d) * this.naturalFreq;
        }
        this.initialized = true;
    }

    public final float getAcceleration(float lastDisplacement, float lastVelocity) {
        float f = lastDisplacement - this.finalPosition;
        double d = this.naturalFreq;
        return (float) (((-(d * d)) * ((double) f)) - (((d * 2.0d) * ((double) this.dampingRatio)) * ((double) lastVelocity)));
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        double d = this.naturalFreq;
        return (float) (d * d);
    }

    public final void setDampingRatio(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f;
        this.initialized = false;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float f) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f);
        this.initialized = false;
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m15343updateValuesIJZedt4$animation_core_release(float lastDisplacement, float lastVelocity, long timeElapsed) {
        double dCos;
        double dExp;
        double dExp2;
        double dExp3;
        init();
        float f = lastDisplacement - this.finalPosition;
        double d = timeElapsed / 1000.0d;
        float f4 = this.dampingRatio;
        if (f4 > 1.0f) {
            double d2 = f;
            double d3 = this.gammaMinus;
            double d4 = lastVelocity;
            double d5 = this.gammaPlus;
            double d6 = d2 - (((d3 * d2) - d4) / (d3 - d5));
            double d7 = ((d2 * d3) - d4) / (d3 - d5);
            dExp = (Math.exp(this.gammaPlus * d) * d7) + (Math.exp(d3 * d) * d6);
            double d8 = this.gammaMinus;
            dExp2 = Math.exp(d8 * d) * d6 * d8;
            double d9 = this.gammaPlus;
            dExp3 = Math.exp(d9 * d) * d7 * d9;
        } else {
            if (f4 != 1.0f) {
                double d10 = ((double) 1) / this.dampedFreq;
                double d11 = this.naturalFreq;
                double d12 = f;
                double d13 = ((((double) f4) * d11 * d12) + ((double) lastVelocity)) * d10;
                double dExp4 = Math.exp(((double) (-f4)) * d11 * d) * ((Math.sin(this.dampedFreq * d) * d13) + (Math.cos(this.dampedFreq * d) * d12));
                double d14 = this.naturalFreq;
                float f5 = this.dampingRatio;
                double d15 = (-d14) * dExp4 * ((double) f5);
                double dExp5 = Math.exp(((double) (-f5)) * d14 * d);
                double d16 = this.dampedFreq;
                double dSin = Math.sin(d16 * d) * (-d16) * d12;
                double d17 = this.dampedFreq;
                dCos = (((Math.cos(d17 * d) * d13 * d17) + dSin) * dExp5) + d15;
                dExp = dExp4;
                return SpringSimulationKt.Motion((float) (dExp + ((double) this.finalPosition)), (float) dCos);
            }
            double d18 = this.naturalFreq;
            double d19 = f;
            double d20 = (d18 * d19) + ((double) lastVelocity);
            double d21 = (d20 * d) + d19;
            dExp = Math.exp((-d18) * d) * d21;
            double dExp6 = Math.exp((-this.naturalFreq) * d) * d21;
            double d22 = this.naturalFreq;
            dExp2 = dExp6 * (-d22);
            dExp3 = Math.exp((-d22) * d) * d20;
        }
        dCos = dExp3 + dExp2;
        return SpringSimulationKt.Motion((float) (dExp + ((double) this.finalPosition)), (float) dCos);
    }
}
