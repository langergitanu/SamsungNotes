package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", VPathDataCmd.RCurveTo, "getSlope", "Arc", "Companion", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@ExperimentalAnimationSpecApi
public final class ArcSpline {
    public static final int ArcAbove = 5;
    public static final int ArcBelow = 4;
    public static final int ArcStartFlip = 3;
    public static final int ArcStartHorizontal = 2;
    public static final int ArcStartLinear = 0;
    public static final int ArcStartVertical = 1;
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;

    @NotNull
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "(IFFFFFF)V", "arcDistance", "arcVelocity", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "isLinear", "", "()Z", "isVertical", "lut", "", "oneOverDeltaTime", "getTime1", "()F", "getTime2", "tmpCosAngle", "tmpSinAngle", "buildTable", "", "calcDX", "calcDY", "calcX", "calcY", "getLinearDX", "getLinearDY", "getLinearX", "time", "getLinearY", "lookup", VPathDataCmd.RCurveTo, "setPoint", "Companion", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nArcSpline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArcSpline.kt\nandroidx/compose/animation/core/ArcSpline$Arc\n+ 2 ArcSpline.jvm.kt\nandroidx/compose/animation/core/ArcSpline_jvmKt\n*L\n1#1,388:1\n21#2:389\n26#2:390\n*S KotlinDebug\n*F\n+ 1 ArcSpline.kt\nandroidx/compose/animation/core/ArcSpline$Arc\n*L\n322#1:389\n340#1:390\n*E\n"})
    public static final class Arc {
        private static final float Epsilon = 0.001f;

        @Nullable
        private static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX;
        private final float ellipseCenterY;
        private final boolean isLinear;
        private final boolean isVertical;

        @NotNull
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc$Companion;", "", "()V", "Epsilon", "", "_ourPercent", "", "ourPercent", "getOurPercent", "()[F", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float[] getOurPercent() {
                if (Arc._ourPercent != null) {
                    float[] fArr = Arc._ourPercent;
                    Intrinsics.checkNotNull(fArr);
                    return fArr;
                }
                Arc._ourPercent = new float[91];
                float[] fArr2 = Arc._ourPercent;
                Intrinsics.checkNotNull(fArr2);
                return fArr2;
            }

            private Companion() {
            }
        }

        public Arc(int i, float f, float f4, float f5, float f6, float f7, float f8) {
            this.time1 = f;
            this.time2 = f4;
            this.x1 = f5;
            this.y1 = f6;
            this.x2 = f7;
            this.y2 = f8;
            float f9 = f7 - f5;
            float f10 = f8 - f6;
            boolean z = true;
            boolean z2 = i == 1 || (i == 4 ? f10 > 0.0f : !(i != 5 || f10 >= 0.0f));
            this.isVertical = z2;
            float f11 = 1 / (f4 - f);
            this.oneOverDeltaTime = f11;
            boolean z3 = 3 == i;
            if (z3 || Math.abs(f9) < 0.001f || Math.abs(f10) < 0.001f) {
                float fHypot = (float) Math.hypot(f10, f9);
                this.arcDistance = fHypot;
                this.arcVelocity = fHypot * f11;
                this.ellipseCenterX = f9 / (f4 - f);
                this.ellipseCenterY = f10 / (f4 - f);
                this.lut = new float[101];
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.lut = new float[101];
                this.ellipseA = f9 * (z2 ? -1 : 1);
                this.ellipseB = f10 * (z2 ? 1 : -1);
                this.ellipseCenterX = z2 ? f7 : f5;
                this.ellipseCenterY = z2 ? f6 : f8;
                buildTable(f5, f6, f7, f8);
                this.arcVelocity = this.arcDistance * f11;
                z = z3;
            }
            this.isLinear = z;
        }

        private final void buildTable(float x12, float y1, float x2, float y2) {
            float f = x2 - x12;
            float f4 = y1 - y2;
            int length = INSTANCE.getOurPercent().length;
            float fHypot = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            int i = 0;
            while (i < length) {
                Companion companion = INSTANCE;
                double radians = (float) Math.toRadians((((double) i) * 90.0d) / ((double) (companion.getOurPercent().length - 1)));
                float fSin = ((float) Math.sin(radians)) * f;
                float fCos = ((float) Math.cos(radians)) * f4;
                if (i > 0) {
                    fHypot += (float) Math.hypot(fSin - f5, fCos - f6);
                    companion.getOurPercent()[i] = fHypot;
                }
                i++;
                f6 = fCos;
                f5 = fSin;
            }
            this.arcDistance = fHypot;
            int length2 = INSTANCE.getOurPercent().length;
            for (int i2 = 0; i2 < length2; i2++) {
                float[] ourPercent = INSTANCE.getOurPercent();
                ourPercent[i2] = ourPercent[i2] / fHypot;
            }
            int length3 = this.lut.length;
            for (int i4 = 0; i4 < length3; i4++) {
                float length4 = i4 / (this.lut.length - 1);
                Companion companion2 = INSTANCE;
                int iBinarySearch$default = ArraysKt___ArraysJvmKt.binarySearch$default(companion2.getOurPercent(), length4, 0, 0, 6, (Object) null);
                if (iBinarySearch$default >= 0) {
                    this.lut[i4] = iBinarySearch$default / (companion2.getOurPercent().length - 1);
                } else if (iBinarySearch$default == -1) {
                    this.lut[i4] = 0.0f;
                } else {
                    int i5 = -iBinarySearch$default;
                    int i6 = i5 - 2;
                    this.lut[i4] = (((length4 - companion2.getOurPercent()[i6]) / (companion2.getOurPercent()[i5 - 1] - companion2.getOurPercent()[i6])) + i6) / (companion2.getOurPercent().length - 1);
                }
            }
        }

        private final float lookup(float v) {
            if (v <= 0.0f) {
                return 0.0f;
            }
            if (v >= 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.lut;
            float length = v * (fArr.length - 1);
            int i = (int) length;
            float f = length - i;
            float f4 = fArr[i];
            return AbstractC0000a.m29z(fArr[i + 1], f4, f, f4);
        }

        public final float calcDX() {
            float f = this.ellipseA * this.tmpCosAngle;
            float fHypot = this.arcVelocity / ((float) Math.hypot(f, (-this.ellipseB) * this.tmpSinAngle));
            return this.isVertical ? (-f) * fHypot : f * fHypot;
        }

        public final float calcDY() {
            float f = this.ellipseA * this.tmpCosAngle;
            float f4 = (-this.ellipseB) * this.tmpSinAngle;
            float fHypot = this.arcVelocity / ((float) Math.hypot(f, f4));
            return this.isVertical ? (-f4) * fHypot : f4 * fHypot;
        }

        public final float calcX() {
            return (this.ellipseA * this.tmpSinAngle) + this.ellipseCenterX;
        }

        public final float calcY() {
            return (this.ellipseB * this.tmpCosAngle) + this.ellipseCenterY;
        }

        /* JADX INFO: renamed from: getLinearDX, reason: from getter */
        public final float getEllipseCenterX() {
            return this.ellipseCenterX;
        }

        /* JADX INFO: renamed from: getLinearDY, reason: from getter */
        public final float getEllipseCenterY() {
            return this.ellipseCenterY;
        }

        public final float getLinearX(float time) {
            float f = (time - this.time1) * this.oneOverDeltaTime;
            float f4 = this.x1;
            return AbstractC0000a.m29z(this.x2, f4, f, f4);
        }

        public final float getLinearY(float time) {
            float f = (time - this.time1) * this.oneOverDeltaTime;
            float f4 = this.y1;
            return AbstractC0000a.m29z(this.y2, f4, f, f4);
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        /* JADX INFO: renamed from: isLinear, reason: from getter */
        public final boolean getIsLinear() {
            return this.isLinear;
        }

        public final void setPoint(float time) {
            double dLookup = lookup((this.isVertical ? this.time2 - time : time - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(dLookup);
            this.tmpCosAngle = (float) Math.cos(dLookup);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[PHI: r10
      0x0028: PHI (r10v1 int) = (r10v0 int), (r10v5 int), (r10v6 int) binds: [B:5:0x0018, B:10:0x0021, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcSpline(@NotNull int[] iArr, @NotNull float[] fArr, @NotNull float[][] fArr2) {
        int i;
        int length = fArr.length - 1;
        Arc[][] arcArr = new Arc[length][];
        int i2 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i5 < length) {
            int i6 = iArr[i5];
            int i7 = 3;
            if (i6 == 0) {
                i = i7;
            } else if (i6 == 1) {
                i2 = 1;
                i = i2;
            } else {
                if (i6 != 2) {
                    if (i6 != 3) {
                        i7 = 4;
                        if (i6 != 4) {
                            i7 = 5;
                            if (i6 != 5) {
                                i = i4;
                            }
                        }
                    } else {
                        if (i2 == 1) {
                        }
                        i = i2;
                    }
                }
                i2 = 2;
                i = i2;
            }
            float[] fArr3 = fArr2[i5];
            int length2 = (fArr3.length % 2) + (fArr3.length / 2);
            Arc[] arcArr2 = new Arc[length2];
            for (int i8 = 0; i8 < length2; i8++) {
                int i9 = i8 * 2;
                float f = fArr[i5];
                int i10 = i5 + 1;
                float f4 = fArr[i10];
                float[] fArr4 = fArr2[i5];
                float f5 = fArr4[i9];
                int i11 = i9 + 1;
                float f6 = fArr4[i11];
                float[] fArr5 = fArr2[i10];
                arcArr2[i8] = new Arc(i, f, f4, f5, f6, fArr5[i9], fArr5[i11]);
            }
            arcArr[i5] = arcArr2;
            i5++;
            i4 = i;
        }
        this.arcs = arcArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        if (r9 > r0[r0.length - 1][0].getTime2()) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getPos(float time, @NotNull float[] v) {
        float time1;
        int length;
        int i = 0;
        if (this.isExtrapolate) {
            if (time >= this.arcs[0][0].getTime1()) {
                Arc[][] arcArr = this.arcs;
            }
            Arc[][] arcArr2 = this.arcs;
            if (time > arcArr2[arcArr2.length - 1][0].getTime2()) {
                Arc[][] arcArr3 = this.arcs;
                length = arcArr3.length - 1;
                time1 = arcArr3[arcArr3.length - 1][0].getTime2();
            } else {
                time1 = this.arcs[0][0].getTime1();
                length = 0;
            }
            float f = time - time1;
            int i2 = 0;
            while (i < v.length) {
                if (this.arcs[length][i2].getIsLinear()) {
                    v[i] = (this.arcs[length][i2].getEllipseCenterX() * f) + this.arcs[length][i2].getLinearX(time1);
                    v[i + 1] = (this.arcs[length][i2].getEllipseCenterY() * f) + this.arcs[length][i2].getLinearY(time1);
                } else {
                    this.arcs[length][i2].setPoint(time1);
                    v[i] = (this.arcs[length][i2].calcDX() * f) + this.arcs[length][i2].calcX();
                    v[i + 1] = (this.arcs[length][i2].calcDY() * f) + this.arcs[length][i2].calcY();
                }
                i += 2;
                i2++;
            }
            return;
        }
        if (time < this.arcs[0][0].getTime1()) {
            time = this.arcs[0][0].getTime1();
        }
        Arc[][] arcArr4 = this.arcs;
        if (time > arcArr4[arcArr4.length - 1][0].getTime2()) {
            Arc[][] arcArr5 = this.arcs;
            time = arcArr5[arcArr5.length - 1][0].getTime2();
        }
        int length2 = this.arcs.length;
        boolean z = false;
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < v.length) {
                if (time <= this.arcs[i4][i6].getTime2()) {
                    if (this.arcs[i4][i6].getIsLinear()) {
                        v[i5] = this.arcs[i4][i6].getLinearX(time);
                        v[i5 + 1] = this.arcs[i4][i6].getLinearY(time);
                    } else {
                        this.arcs[i4][i6].setPoint(time);
                        v[i5] = this.arcs[i4][i6].calcX();
                        v[i5 + 1] = this.arcs[i4][i6].calcY();
                    }
                    z = true;
                }
                i5 += 2;
                i6++;
            }
            if (z) {
                return;
            }
        }
    }

    public final void getSlope(float time, @NotNull float[] v) {
        if (time < this.arcs[0][0].getTime1()) {
            time = this.arcs[0][0].getTime1();
        } else {
            Arc[][] arcArr = this.arcs;
            if (time > arcArr[arcArr.length - 1][0].getTime2()) {
                Arc[][] arcArr2 = this.arcs;
                time = arcArr2[arcArr2.length - 1][0].getTime2();
            }
        }
        int length = this.arcs.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            int i4 = 0;
            while (i2 < v.length) {
                if (time <= this.arcs[i][i4].getTime2()) {
                    if (this.arcs[i][i4].getIsLinear()) {
                        v[i2] = this.arcs[i][i4].getEllipseCenterX();
                        v[i2 + 1] = this.arcs[i][i4].getEllipseCenterY();
                    } else {
                        this.arcs[i][i4].setPoint(time);
                        v[i2] = this.arcs[i][i4].calcDX();
                        v[i2 + 1] = this.arcs[i][i4].calcDY();
                    }
                    z = true;
                }
                i2 += 2;
                i4++;
            }
            if (z) {
                return;
            }
        }
    }
}
