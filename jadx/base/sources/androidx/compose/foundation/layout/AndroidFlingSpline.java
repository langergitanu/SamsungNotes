package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "flingPosition-LfoxSSI", "(F)J", "FlingResult", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWindowInsetsConnection.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowInsetsConnection.android.kt\nandroidx/compose/foundation/layout/AndroidFlingSpline\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,725:1\n63#2,3:726\n*S KotlinDebug\n*F\n+ 1 WindowInsetsConnection.android.kt\nandroidx/compose/foundation/layout/AndroidFlingSpline\n*L\n700#1:726,3\n*E\n"})
final class AndroidFlingSpline {
    private static final int NbSamples = 100;

    @NotNull
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();

    @NotNull
    private static final float[] SplinePositions = new float[101];

    @NotNull
    private static final float[] SplineTimes = new float[101];

    static {
        float fM1155a;
        float f;
        float f4;
        float f5;
        float f6;
        float f7;
        float fM1155a2;
        float f8;
        float f9;
        float f10;
        float f11 = 0.0f;
        int i = 0;
        float f12 = 0.0f;
        while (true) {
            float f13 = 1.0f;
            if (i >= 100) {
                SplineTimes[100] = 1.0f;
                SplinePositions[100] = 1.0f;
                return;
            }
            float f14 = i / 100;
            float f15 = 1.0f;
            while (true) {
                fM1155a = AbstractC0622a.m1155a(f15, f11, 2.0f, f11);
                f = f13 - fM1155a;
                f4 = fM1155a * 3.0f * f;
                f5 = fM1155a * fM1155a * fM1155a;
                float fM1152B = AbstractC0622a.m1152B(fM1155a, 0.35000002f, f * 0.175f, f4) + f5;
                f6 = f13;
                f7 = f14;
                if (Math.abs(fM1152B - f14) < 1.0E-5d) {
                    break;
                }
                if (fM1152B > f7) {
                    f15 = fM1155a;
                } else {
                    f11 = fM1155a;
                }
                f13 = f6;
                f14 = f7;
            }
            SplinePositions[i] = (((f * 0.5f) + fM1155a) * f4) + f5;
            float f16 = f6;
            while (true) {
                fM1155a2 = AbstractC0622a.m1155a(f16, f12, 2.0f, f12);
                f8 = f6 - fM1155a2;
                f9 = fM1155a2 * 3.0f * f8;
                f10 = fM1155a2 * fM1155a2 * fM1155a2;
                float fM1152B2 = AbstractC0622a.m1152B(f8, 0.5f, fM1155a2, f9) + f10;
                if (Math.abs(fM1152B2 - f7) >= 1.0E-5d) {
                    if (fM1152B2 > f7) {
                        f16 = fM1155a2;
                    } else {
                        f12 = fM1155a2;
                    }
                }
            }
            SplineTimes[i] = (((fM1155a2 * 0.35000002f) + (f8 * 0.175f)) * f9) + f10;
            i++;
        }
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float velocity, float friction) {
        return Math.log(((double) (Math.abs(velocity) * 0.35f)) / ((double) friction));
    }

    /* JADX INFO: renamed from: flingPosition-LfoxSSI, reason: not valid java name */
    public final long m15724flingPositionLfoxSSI(float time) {
        float fM29z;
        float f;
        float f4 = 100;
        int i = (int) (f4 * time);
        if (i < 100) {
            float f5 = i / f4;
            int i2 = i + 1;
            float f6 = i2 / f4;
            float[] fArr = SplinePositions;
            float f7 = fArr[i];
            f = (fArr[i2] - f7) / (f6 - f5);
            fM29z = AbstractC0000a.m29z(time, f5, f, f7);
        } else {
            fM29z = 1.0f;
            f = 0.0f;
        }
        return FlingResult.m15726constructorimpl((((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(fM29z) << 32));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    @SourceDebugExtension({"SMAP\nWindowInsetsConnection.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowInsetsConnection.android.kt\nandroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,725:1\n72#2:726\n86#2:728\n22#3:727\n22#3:729\n*S KotlinDebug\n*F\n+ 1 WindowInsetsConnection.android.kt\nandroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult\n*L\n717#1:726\n722#1:728\n717#1:727\n722#1:729\n*E\n"})
    public static final class FlingResult {
        private final long packedValue;

        private /* synthetic */ FlingResult(long j) {
            this.packedValue = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FlingResult m15725boximpl(long j) {
            return new FlingResult(j);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m15727equalsimpl(long j, Object obj) {
            return (obj instanceof FlingResult) && j == ((FlingResult) obj).getPackedValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m15728equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: getDistanceCoefficient-impl, reason: not valid java name */
        public static final float m15729getDistanceCoefficientimpl(long j) {
            return Float.intBitsToFloat((int) (j >> 32));
        }

        /* JADX INFO: renamed from: getVelocityCoefficient-impl, reason: not valid java name */
        public static final float m15730getVelocityCoefficientimpl(long j) {
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m15731hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m15732toStringimpl(long j) {
            return "FlingResult(packedValue=" + j + PropertyUtils.MAPPED_DELIM2;
        }

        public boolean equals(Object obj) {
            return m15727equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m15731hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m15732toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ long getPackedValue() {
            return this.packedValue;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m15726constructorimpl(long j) {
            return j;
        }
    }
}
