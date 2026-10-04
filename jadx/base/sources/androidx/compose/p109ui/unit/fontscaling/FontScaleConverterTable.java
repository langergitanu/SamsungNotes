package androidx.compose.p109ui.unit.fontscaling;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fromSp", "", "toDp", "([F[F)V", "mFromSpValues", "getMFromSpValues$annotations", "()V", "getMFromSpValues", "()[F", "mToDpValues", "getMToDpValues$annotations", "getMToDpValues", "convertDpToSp", "", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "convertSpToDp", "sp", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class FontScaleConverterTable implements FontScaleConverter {

    @NotNull
    private final float[] mFromSpValues;

    @NotNull
    private final float[] mToDpValues;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable$Companion;", "", "()V", "lookupAndInterpolate", "", "sourceValue", "sourceValues", "", "targetValues", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float lookupAndInterpolate(float sourceValue, float[] sourceValues, float[] targetValues) {
            float f;
            float f4;
            float f5;
            float fConstrainedMap;
            float fAbs = Math.abs(sourceValue);
            float fSignum = Math.signum(sourceValue);
            int iBinarySearch = Arrays.binarySearch(sourceValues, fAbs);
            if (iBinarySearch >= 0) {
                fConstrainedMap = targetValues[iBinarySearch];
            } else {
                int i = -(iBinarySearch + 1);
                int i2 = i - 1;
                float f6 = 0.0f;
                if (i2 >= sourceValues.length - 1) {
                    float f7 = sourceValues[sourceValues.length - 1];
                    float f8 = targetValues[sourceValues.length - 1];
                    if (f7 == 0.0f) {
                        return 0.0f;
                    }
                    return (f8 / f7) * sourceValue;
                }
                if (i2 == -1) {
                    f = sourceValues[0];
                    f5 = targetValues[0];
                    f4 = 0.0f;
                } else {
                    f6 = sourceValues[i2];
                    f = sourceValues[i];
                    f4 = targetValues[i2];
                    f5 = targetValues[i];
                }
                fConstrainedMap = MathUtils.INSTANCE.constrainedMap(f4, f5, f6, f, fAbs);
            }
            return fSignum * fConstrainedMap;
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public FontScaleConverterTable(@NotNull float[] fArr, @NotNull float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.mFromSpValues = fArr;
        this.mToDpValues = fArr2;
    }

    @Override // androidx.compose.p109ui.unit.fontscaling.FontScaleConverter
    public float convertDpToSp(float dp) {
        return INSTANCE.lookupAndInterpolate(dp, this.mToDpValues, this.mFromSpValues);
    }

    @Override // androidx.compose.p109ui.unit.fontscaling.FontScaleConverter
    public float convertSpToDp(float sp) {
        return INSTANCE.lookupAndInterpolate(sp, this.mFromSpValues, this.mToDpValues);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof FontScaleConverterTable)) {
            return false;
        }
        FontScaleConverterTable fontScaleConverterTable = (FontScaleConverterTable) other;
        return Arrays.equals(this.mFromSpValues, fontScaleConverterTable.mFromSpValues) && Arrays.equals(this.mToDpValues, fontScaleConverterTable.mToDpValues);
    }

    @NotNull
    public final float[] getMFromSpValues() {
        return this.mFromSpValues;
    }

    @NotNull
    public final float[] getMToDpValues() {
        return this.mToDpValues;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mToDpValues) + (Arrays.hashCode(this.mFromSpValues) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.mFromSpValues);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        sb.append(", toDpValues=");
        String string2 = Arrays.toString(this.mToDpValues);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this)");
        sb.append(string2);
        sb.append('}');
        return sb.toString();
    }

    @VisibleForTesting
    public static /* synthetic */ void getMFromSpValues$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMToDpValues$annotations() {
    }
}
