package androidx.compose.animation.core;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cJ \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J8\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J#\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006%"}, m13886d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "([F[[FF)V", "isExtrapolate", "", "slopeTemp", "tangents", "[[F", "timePoints", "values", "diff", "h", "x", "y1", "y2", "t1", "t2", "getPos", "", VPathDataCmd.RCurveTo, "Landroidx/compose/animation/core/AnimationVector;", "index", "", "t", "j", "getSlope", "interpolate", "makeFloatArray", "a", "b", "(II)[[F", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@ExperimentalAnimationSpecApi
public final class MonoSpline {
    public static final int $stable = 8;
    private final boolean isExtrapolate = true;

    @NotNull
    private final float[] slopeTemp;

    @NotNull
    private final float[][] tangents;

    @NotNull
    private final float[] timePoints;

    @NotNull
    private final float[][] values;

    public MonoSpline(@NotNull float[] fArr, @NotNull float[][] fArr2, float f) {
        int i;
        int length = fArr.length;
        int i2 = 0;
        int length2 = fArr2[0].length;
        this.slopeTemp = new float[length2];
        int i4 = length - 1;
        float[][] fArrMakeFloatArray = makeFloatArray(i4, length2);
        float[][] fArrMakeFloatArray2 = makeFloatArray(length, length2);
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = 0;
            while (i6 < i4) {
                int i7 = i6 + 1;
                float f4 = fArr[i7] - fArr[i6];
                float[] fArr3 = fArrMakeFloatArray[i6];
                float f5 = (fArr2[i7][i5] - fArr2[i6][i5]) / f4;
                fArr3[i5] = f5;
                if (i6 == 0) {
                    fArrMakeFloatArray2[i6][i5] = f5;
                } else {
                    fArrMakeFloatArray2[i6][i5] = (fArrMakeFloatArray[i6 - 1][i5] + f5) * 0.5f;
                }
                i6 = i7;
            }
            fArrMakeFloatArray2[i4][i5] = fArrMakeFloatArray[length - 2][i5];
        }
        if (!Float.isNaN(f)) {
            for (int i8 = 0; i8 < length2; i8++) {
                float[] fArr4 = fArrMakeFloatArray[length - 2];
                float f6 = (1 - f) * fArr4[i8];
                float[] fArr5 = fArrMakeFloatArray[0];
                float f7 = (fArr5[i8] * f) + f6;
                fArr5[i8] = f7;
                fArr4[i8] = f7;
                fArrMakeFloatArray2[i4][i8] = f7;
                fArrMakeFloatArray2[0][i8] = f7;
            }
        }
        int i9 = 0;
        while (i9 < i4) {
            int i10 = i2;
            while (i10 < length2) {
                float f8 = fArrMakeFloatArray[i9][i10];
                if (f8 == 0.0f) {
                    fArrMakeFloatArray2[i9][i10] = 0.0f;
                    fArrMakeFloatArray2[i9 + 1][i10] = 0.0f;
                    i = length2;
                } else {
                    float f9 = fArrMakeFloatArray2[i9][i10] / f8;
                    int i11 = i9 + 1;
                    float f10 = fArrMakeFloatArray2[i11][i10] / f8;
                    i = length2;
                    float fHypot = (float) Math.hypot(f9, f10);
                    if (fHypot > 9.0d) {
                        float f11 = 3.0f / fHypot;
                        float[] fArr6 = fArrMakeFloatArray2[i9];
                        float[] fArr7 = fArrMakeFloatArray[i9];
                        fArr6[i10] = f9 * f11 * fArr7[i10];
                        fArrMakeFloatArray2[i11][i10] = f11 * f10 * fArr7[i10];
                    }
                }
                i10++;
                length2 = i;
            }
            i9++;
            i2 = 0;
        }
        this.timePoints = fArr;
        this.values = fArr2;
        this.tangents = fArrMakeFloatArray2;
    }

    private final float diff(float h, float x, float y1, float y2, float t1, float t2) {
        float f = x * x;
        float f4 = 6;
        float f5 = f4 * x;
        float fM1154D = AbstractC0622a.m1154D(f4, f, y1, (y2 * f5) + (((-6) * f) * y2)) - (f5 * y1);
        float f6 = 3 * h;
        return (h * t1) + ((AbstractC0622a.m1154D(f6, t1, f, AbstractC0622a.m1154D(f6, t2, f, fM1154D)) - (((2 * h) * t2) * x)) - (((4 * h) * t1) * x));
    }

    public static /* synthetic */ void getPos$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getPos(f, animationVector, i);
    }

    public static /* synthetic */ void getSlope$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getSlope(f, animationVector, i);
    }

    private final float interpolate(float h, float x, float y1, float y2, float t1, float t2) {
        float f = x * x;
        float f4 = f * x;
        float f5 = 3 * f;
        float f6 = 2;
        float f7 = t2 * h;
        float fM1154D = (f7 * f4) + (AbstractC0622a.m1154D(f6, f4, y1, (y2 * f5) + (((-2) * f4) * y2)) - (f5 * y1)) + y1;
        float f8 = h * t1;
        return (f8 * x) + ((((f4 * f8) + fM1154D) - (f7 * f)) - (((f6 * h) * t1) * f));
    }

    private final float[][] makeFloatArray(int a, int b) {
        float[][] fArr = new float[a][];
        for (int i = 0; i < a; i++) {
            fArr[i] = new float[b];
        }
        return fArr;
    }

    public final float getPos(float t, int j) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i = 0;
        if (this.isExtrapolate) {
            float f = fArr[0];
            if (t <= f) {
                return ((t - f) * getSlope(f, j)) + this.values[0][j];
            }
            int i2 = length - 1;
            float f4 = fArr[i2];
            if (t >= f4) {
                return ((t - f4) * getSlope(f4, j)) + this.values[i2][j];
            }
        } else {
            if (t <= fArr[0]) {
                return this.values[0][j];
            }
            int i4 = length - 1;
            if (t >= fArr[i4]) {
                return this.values[i4][j];
            }
        }
        int i5 = length - 1;
        while (i < i5) {
            float[] fArr2 = this.timePoints;
            float f5 = fArr2[i];
            if (t == f5) {
                return this.values[i][j];
            }
            int i6 = i + 1;
            float f6 = fArr2[i6];
            if (t < f6) {
                float f7 = f6 - f5;
                float f8 = (t - f5) / f7;
                float[][] fArr3 = this.values;
                float f9 = fArr3[i][j];
                float f10 = fArr3[i6][j];
                float[][] fArr4 = this.tangents;
                return interpolate(f7, f8, f9, f10, fArr4[i][j], fArr4[i6][j]);
            }
            i = i6;
        }
        return 0.0f;
    }

    public final void getSlope(float time, @NotNull float[] v) {
        float f;
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int length2 = this.values[0].length;
        float f4 = fArr[0];
        if (time <= f4) {
            f = f4;
        } else {
            f = fArr[length - 1];
            if (time < f) {
                f = time;
            }
        }
        int i = length - 1;
        int i2 = 0;
        while (i2 < i) {
            float[] fArr2 = this.timePoints;
            int i4 = i2 + 1;
            float f5 = fArr2[i4];
            if (f <= f5) {
                float f6 = fArr2[i2];
                float f7 = f5 - f6;
                float f8 = (f - f6) / f7;
                int i5 = 0;
                while (i5 < length2) {
                    float[][] fArr3 = this.values;
                    float f9 = fArr3[i2][i5];
                    float f10 = fArr3[i4][i5];
                    float[][] fArr4 = this.tangents;
                    float f11 = fArr4[i2][i5];
                    float f12 = fArr4[i4][i5];
                    float f13 = f7;
                    v[i5] = diff(f13, f8, f9, f10, f11, f12) / f13;
                    i5++;
                    f7 = f13;
                }
                return;
            }
            i2 = i4;
        }
    }

    public final void getSlope(float time, @NotNull AnimationVector v, int index) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int length2 = this.values[0].length;
        if (time <= fArr[0]) {
            for (int i = 0; i < length2; i++) {
                v.set$animation_core_release(i, this.tangents[0][i]);
            }
            return;
        }
        int i2 = length - 1;
        if (time >= fArr[i2]) {
            for (int i4 = 0; i4 < length2; i4++) {
                v.set$animation_core_release(i4, this.tangents[i2][i4]);
            }
            return;
        }
        int i5 = index;
        while (i5 < i2) {
            float[] fArr2 = this.timePoints;
            int i6 = i5 + 1;
            float f = fArr2[i6];
            if (time <= f) {
                float f4 = fArr2[i5];
                float f5 = f - f4;
                float f6 = (time - f4) / f5;
                int i7 = 0;
                while (i7 < length2) {
                    float[][] fArr3 = this.values;
                    float f7 = fArr3[i5][i7];
                    float f8 = fArr3[i6][i7];
                    float[][] fArr4 = this.tangents;
                    float f9 = f5;
                    v.set$animation_core_release(i7, diff(f9, f6, f7, f8, fArr4[i5][i7], fArr4[i6][i7]) / f9);
                    i7++;
                    f5 = f9;
                }
                return;
            }
            i5 = i6;
        }
    }

    public final void getPos(float time, @NotNull AnimationVector v, int index) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i = 0;
        int length2 = this.values[0].length;
        if (this.isExtrapolate) {
            float f = fArr[0];
            if (time <= f) {
                getSlope(f, this.slopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    v.set$animation_core_release(i2, ((time - this.timePoints[0]) * this.slopeTemp[i2]) + this.values[0][i2]);
                }
                return;
            }
            int i4 = length - 1;
            float f4 = fArr[i4];
            if (time >= f4) {
                getSlope(f4, this.slopeTemp);
                while (i < length2) {
                    v.set$animation_core_release(i, ((time - this.timePoints[i4]) * this.slopeTemp[i]) + this.values[i4][i]);
                    i++;
                }
                return;
            }
        } else {
            if (time <= fArr[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    v.set$animation_core_release(i5, this.values[0][i5]);
                }
                return;
            }
            int i6 = length - 1;
            if (time >= fArr[i6]) {
                while (i < length2) {
                    v.set$animation_core_release(i, this.values[i6][i]);
                    i++;
                }
                return;
            }
        }
        int i7 = length - 1;
        int i8 = index;
        while (i8 < i7) {
            if (time == this.timePoints[i8]) {
                for (int i9 = 0; i9 < length2; i9++) {
                    v.set$animation_core_release(i9, this.values[i8][i9]);
                }
            }
            float[] fArr2 = this.timePoints;
            int i10 = i8 + 1;
            float f5 = fArr2[i10];
            if (time < f5) {
                float f6 = fArr2[i8];
                float f7 = f5 - f6;
                float f8 = (time - f6) / f7;
                int i11 = 0;
                while (i11 < length2) {
                    float[][] fArr3 = this.values;
                    float f9 = fArr3[i8][i11];
                    float f10 = fArr3[i10][i11];
                    float[][] fArr4 = this.tangents;
                    float f11 = f7;
                    v.set$animation_core_release(i11, interpolate(f11, f8, f9, f10, fArr4[i8][i11], fArr4[i10][i11]));
                    i11++;
                    f7 = f11;
                }
                return;
            }
            i8 = i10;
        }
    }

    private final float getSlope(float time, int j) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i = 0;
        float f = fArr[0];
        if (time < f) {
            time = f;
        } else {
            float f4 = fArr[length - 1];
            if (time >= f4) {
                time = f4;
            }
        }
        int i2 = length - 1;
        while (i < i2) {
            float[] fArr2 = this.timePoints;
            int i4 = i + 1;
            float f5 = fArr2[i4];
            if (time <= f5) {
                float f6 = fArr2[i];
                float f7 = f5 - f6;
                float f8 = (time - f6) / f7;
                float[][] fArr3 = this.values;
                float f9 = fArr3[i][j];
                float f10 = fArr3[i4][j];
                float[][] fArr4 = this.tangents;
                return diff(f7, f8, f9, f10, fArr4[i][j], fArr4[i4][j]) / f7;
            }
            i = i4;
        }
        return 0.0f;
    }
}
