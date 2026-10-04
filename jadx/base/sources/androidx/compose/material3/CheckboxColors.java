package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.state.ToggleableState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bb\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "borderColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "boxColor$material3_release", "checkmarkColor", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CheckboxColors {
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            iArr[ToggleableState.Off.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CheckboxColors(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    @Composable
    @NotNull
    public final State<Color> borderColor$material3_release(boolean z, @NotNull ToggleableState state, @Nullable Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> stateRememberUpdatedState;
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(1009643462);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, i, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:446)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBorderColor;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j = this.uncheckedBorderColor;
            }
        } else {
            int i4 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i4 == 1) {
                j = this.disabledBorderColor;
            } else if (i4 != 2) {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j = this.disabledBorderColor;
            } else {
                j = this.disabledIndeterminateBorderColor;
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(1209369334);
            composer2 = composer;
            stateRememberUpdatedState = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(j2, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, null, 6, null), null, composer2, 0, 4);
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceableGroup(1209369520);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(j2), composer2, 0);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> boxColor$material3_release(boolean z, @NotNull ToggleableState state, @Nullable Composer composer, int i) {
        long j;
        Composer composer2;
        State<Color> stateRememberUpdatedState;
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(360729865);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, i, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:415)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBoxColor;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j = this.uncheckedBoxColor;
            }
        } else {
            int i4 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i4 == 1) {
                j = this.disabledCheckedBoxColor;
            } else if (i4 == 2) {
                j = this.disabledIndeterminateBoxColor;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j = this.disabledUncheckedBoxColor;
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(1143718194);
            composer2 = composer;
            stateRememberUpdatedState = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(j2, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, null, 6, null), null, composer2, 0, 4);
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceableGroup(1143718380);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(j2), composer2, 0);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> checkmarkColor$material3_release(@NotNull ToggleableState state, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceableGroup(-507585681);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, i, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:396)");
        }
        ToggleableState toggleableState = ToggleableState.Off;
        State<Color> stateM15287animateColorAsStateKTwxG1Y = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(state == toggleableState ? this.uncheckedCheckmarkColor : this.checkedCheckmarkColor, AnimationSpecKt.tween$default(state == toggleableState ? 100 : 50, 0, null, 6, null), null, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM15287animateColorAsStateKTwxG1Y;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) other;
        return Color.m18526equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m18526equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m18526equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m18526equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m18526equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m18526equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m18526equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m18526equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m18526equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m18526equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m18526equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    public int hashCode() {
        return Color.m18532hashCodeimpl(this.disabledIndeterminateBorderColor) + AbstractC0622a.m1158d(this.disabledBorderColor, AbstractC0622a.m1158d(this.uncheckedBorderColor, AbstractC0622a.m1158d(this.checkedBorderColor, AbstractC0622a.m1158d(this.disabledIndeterminateBoxColor, AbstractC0622a.m1158d(this.disabledUncheckedBoxColor, AbstractC0622a.m1158d(this.disabledCheckedBoxColor, AbstractC0622a.m1158d(this.uncheckedBoxColor, AbstractC0622a.m1158d(this.checkedBoxColor, AbstractC0622a.m1158d(this.uncheckedCheckmarkColor, Color.m18532hashCodeimpl(this.checkedCheckmarkColor) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    private CheckboxColors(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.checkedCheckmarkColor = j;
        this.uncheckedCheckmarkColor = j2;
        this.checkedBoxColor = j3;
        this.uncheckedBoxColor = j5;
        this.disabledCheckedBoxColor = j6;
        this.disabledUncheckedBoxColor = j7;
        this.disabledIndeterminateBoxColor = j8;
        this.checkedBorderColor = j9;
        this.uncheckedBorderColor = j10;
        this.disabledBorderColor = j11;
        this.disabledIndeterminateBorderColor = j12;
    }
}
