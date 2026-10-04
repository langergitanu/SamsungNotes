package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/material3/SliderPositions;", "", "initialPositionFraction", "", "initialTickFractions", "", "(F[F)V", "<set-?>", "positionFraction", "getPositionFraction", "()F", "setPositionFraction$material3_release", "(F)V", "positionFraction$delegate", "Landroidx/compose/runtime/MutableState;", "tickFractions", "getTickFractions", "()[F", "setTickFractions$material3_release", "([F)V", "tickFractions$delegate", "equals", "", "other", "hashCode", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SliderPositions {

    /* JADX INFO: renamed from: positionFraction$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState positionFraction;

    /* JADX INFO: renamed from: tickFractions$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState tickFractions;

    public SliderPositions(float f, @NotNull float[] initialTickFractions) {
        Intrinsics.checkNotNullParameter(initialTickFractions, "initialTickFractions");
        this.positionFraction = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f), null, 2, null);
        this.tickFractions = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialTickFractions, null, 2, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SliderPositions)) {
            return false;
        }
        SliderPositions sliderPositions = (SliderPositions) other;
        return getPositionFraction() == sliderPositions.getPositionFraction() && Arrays.equals(getTickFractions(), sliderPositions.getTickFractions());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getPositionFraction() {
        return ((Number) this.positionFraction.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final float[] getTickFractions() {
        return (float[]) this.tickFractions.getValue();
    }

    public int hashCode() {
        return Arrays.hashCode(getTickFractions()) + (Float.hashCode(getPositionFraction()) * 31);
    }

    public final void setPositionFraction$material3_release(float f) {
        this.positionFraction.setValue(Float.valueOf(f));
    }

    public final void setTickFractions$material3_release(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.tickFractions.setValue(fArr);
    }
}
