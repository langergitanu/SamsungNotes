package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001Bê\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010 J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u0010(\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010.\u001a\u00020/H\u0016J0\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J0\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00105J0\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b9\u00105J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010+J0\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b<\u00105J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010+J0\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030%2\u0006\u00101\u001a\u00020)2\u0006\u0010(\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00105R\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0018\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0014\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0019\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0011\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0015\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0016\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001c\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001a\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010\"\u001a\u00020\t8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0017\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u001d\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0019\u0010\u0013\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, m13886d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "selectionColors", "getSelectionColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "Landroidx/compose/runtime/State;", "containerColor$material3_release", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isError", "", "cursorColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "indicatorColor", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor$material3_release", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "labelColor$material3_release", "leadingIconColor", "leadingIconColor$material3_release", "placeholderColor$material3_release", "supportingTextColor", "supportingTextColor$material3_release", "textColor$material3_release", "trailingIconColor", "trailingIconColor$material3_release", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TextFieldColors {
    private final long containerColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorSupportingTextColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedSupportingTextColor;
    private final long focusedTrailingIconColor;
    private final long placeholderColor;
    private final long textColor;

    @NotNull
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long j, long j2, long j3, long j5, long j6, TextSelectionColors textSelectionColors, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j5, j6, textSelectionColors, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28);
    }

    /* JADX INFO: renamed from: indicatorColor$lambda-2, reason: not valid java name */
    private static final boolean m17361indicatorColor$lambda2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: labelColor$lambda-3, reason: not valid java name */
    private static final boolean m17362labelColor$lambda3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: leadingIconColor$lambda-0, reason: not valid java name */
    private static final boolean m17363leadingIconColor$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: supportingTextColor$lambda-4, reason: not valid java name */
    private static final boolean m17364supportingTextColor$lambda4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: trailingIconColor$lambda-1, reason: not valid java name */
    private static final boolean m17365trailingIconColor$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @Composable
    @NotNull
    public final State<Color> containerColor$material3_release(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(954653884);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(954653884, i, -1, "androidx.compose.material3.TextFieldColors.containerColor (TextFieldDefaults.kt:794)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(this.containerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> cursorColor$material3_release(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1885422187);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1885422187, i, -1, "androidx.compose.material3.TextFieldColors.cursorColor (TextFieldDefaults.kt:862)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(z ? this.errorCursorColor : this.cursorColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TextFieldColors)) {
            return false;
        }
        TextFieldColors textFieldColors = (TextFieldColors) other;
        return Color.m18526equalsimpl0(this.textColor, textFieldColors.textColor) && Color.m18526equalsimpl0(this.disabledTextColor, textFieldColors.disabledTextColor) && Color.m18526equalsimpl0(this.cursorColor, textFieldColors.cursorColor) && Color.m18526equalsimpl0(this.errorCursorColor, textFieldColors.errorCursorColor) && Intrinsics.areEqual(this.textSelectionColors, textFieldColors.textSelectionColors) && Color.m18526equalsimpl0(this.focusedIndicatorColor, textFieldColors.focusedIndicatorColor) && Color.m18526equalsimpl0(this.unfocusedIndicatorColor, textFieldColors.unfocusedIndicatorColor) && Color.m18526equalsimpl0(this.errorIndicatorColor, textFieldColors.errorIndicatorColor) && Color.m18526equalsimpl0(this.disabledIndicatorColor, textFieldColors.disabledIndicatorColor) && Color.m18526equalsimpl0(this.focusedLeadingIconColor, textFieldColors.focusedLeadingIconColor) && Color.m18526equalsimpl0(this.unfocusedLeadingIconColor, textFieldColors.unfocusedLeadingIconColor) && Color.m18526equalsimpl0(this.disabledLeadingIconColor, textFieldColors.disabledLeadingIconColor) && Color.m18526equalsimpl0(this.errorLeadingIconColor, textFieldColors.errorLeadingIconColor) && Color.m18526equalsimpl0(this.focusedTrailingIconColor, textFieldColors.focusedTrailingIconColor) && Color.m18526equalsimpl0(this.unfocusedTrailingIconColor, textFieldColors.unfocusedTrailingIconColor) && Color.m18526equalsimpl0(this.disabledTrailingIconColor, textFieldColors.disabledTrailingIconColor) && Color.m18526equalsimpl0(this.errorTrailingIconColor, textFieldColors.errorTrailingIconColor) && Color.m18526equalsimpl0(this.containerColor, textFieldColors.containerColor) && Color.m18526equalsimpl0(this.focusedLabelColor, textFieldColors.focusedLabelColor) && Color.m18526equalsimpl0(this.unfocusedLabelColor, textFieldColors.unfocusedLabelColor) && Color.m18526equalsimpl0(this.disabledLabelColor, textFieldColors.disabledLabelColor) && Color.m18526equalsimpl0(this.errorLabelColor, textFieldColors.errorLabelColor) && Color.m18526equalsimpl0(this.placeholderColor, textFieldColors.placeholderColor) && Color.m18526equalsimpl0(this.disabledPlaceholderColor, textFieldColors.disabledPlaceholderColor) && Color.m18526equalsimpl0(this.focusedSupportingTextColor, textFieldColors.focusedSupportingTextColor) && Color.m18526equalsimpl0(this.unfocusedSupportingTextColor, textFieldColors.unfocusedSupportingTextColor) && Color.m18526equalsimpl0(this.disabledSupportingTextColor, textFieldColors.disabledSupportingTextColor) && Color.m18526equalsimpl0(this.errorSupportingTextColor, textFieldColors.errorSupportingTextColor);
    }

    @Composable
    @JvmName(name = "getSelectionColors")
    @NotNull
    public final TextSelectionColors getSelectionColors(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(997785083);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(997785083, i, -1, "androidx.compose.material3.TextFieldColors.<get-selectionColors> (TextFieldDefaults.kt:870)");
        }
        TextSelectionColors textSelectionColors = this.textSelectionColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors;
    }

    public int hashCode() {
        return Color.m18532hashCodeimpl(this.errorSupportingTextColor) + AbstractC0622a.m1158d(this.disabledSupportingTextColor, AbstractC0622a.m1158d(this.unfocusedSupportingTextColor, AbstractC0622a.m1158d(this.focusedSupportingTextColor, AbstractC0622a.m1158d(this.disabledPlaceholderColor, AbstractC0622a.m1158d(this.placeholderColor, AbstractC0622a.m1158d(this.errorLabelColor, AbstractC0622a.m1158d(this.disabledLabelColor, AbstractC0622a.m1158d(this.unfocusedLabelColor, AbstractC0622a.m1158d(this.focusedLabelColor, AbstractC0622a.m1158d(this.containerColor, AbstractC0622a.m1158d(this.errorTrailingIconColor, AbstractC0622a.m1158d(this.disabledTrailingIconColor, AbstractC0622a.m1158d(this.unfocusedTrailingIconColor, AbstractC0622a.m1158d(this.focusedTrailingIconColor, AbstractC0622a.m1158d(this.errorLeadingIconColor, AbstractC0622a.m1158d(this.disabledLeadingIconColor, AbstractC0622a.m1158d(this.unfocusedLeadingIconColor, AbstractC0622a.m1158d(this.focusedLeadingIconColor, AbstractC0622a.m1158d(this.disabledIndicatorColor, AbstractC0622a.m1158d(this.errorIndicatorColor, AbstractC0622a.m1158d(this.unfocusedIndicatorColor, AbstractC0622a.m1158d(this.focusedIndicatorColor, (this.textSelectionColors.hashCode() + AbstractC0622a.m1158d(this.errorCursorColor, AbstractC0622a.m1158d(this.cursorColor, AbstractC0622a.m1158d(this.disabledTextColor, Color.m18532hashCodeimpl(this.textColor) * 31, 31), 31), 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    @Composable
    @NotNull
    public final State<Color> indicatorColor$material3_release(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        Composer composer2;
        State<Color> stateRememberUpdatedState;
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, -1877482635)) {
            ComposerKt.traceEventStart(-1877482635, i, -1, "androidx.compose.material3.TextFieldColors.indicatorColor (TextFieldDefaults.kt:770)");
        }
        long j = !z ? this.disabledIndicatorColor : z2 ? this.errorIndicatorColor : m17361indicatorColor$lambda2(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14)) ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
        if (z) {
            composer.startReplaceableGroup(715730990);
            composer2 = composer;
            stateRememberUpdatedState = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(j, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, composer2, 48, 4);
            composer2.endReplaceableGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceableGroup(715731095);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(j), composer2, 0);
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
    public final State<Color> labelColor$material3_release(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, 1167161306)) {
            ComposerKt.traceEventStart(1167161306, i, -1, "androidx.compose.material3.TextFieldColors.labelColor (TextFieldDefaults.kt:817)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(!z ? this.disabledLabelColor : z2 ? this.errorLabelColor : m17362labelColor$lambda3(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14)) ? this.focusedLabelColor : this.unfocusedLabelColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> leadingIconColor$material3_release(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, 925127045)) {
            ComposerKt.traceEventStart(925127045, i, -1, "androidx.compose.material3.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:718)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(!z ? this.disabledLeadingIconColor : z2 ? this.errorLeadingIconColor : m17363leadingIconColor$lambda0(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14)) ? this.focusedLeadingIconColor : this.unfocusedLeadingIconColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> placeholderColor$material3_release(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-117469162);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-117469162, i, -1, "androidx.compose.material3.TextFieldColors.placeholderColor (TextFieldDefaults.kt:804)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(z ? this.placeholderColor : this.disabledPlaceholderColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> supportingTextColor$material3_release(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, 1464709698)) {
            ComposerKt.traceEventStart(1464709698, i, -1, "androidx.compose.material3.TextFieldColors.supportingTextColor (TextFieldDefaults.kt:839)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(!z ? this.disabledSupportingTextColor : z2 ? this.errorSupportingTextColor : m17364supportingTextColor$lambda4(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14)) ? this.focusedSupportingTextColor : this.unfocusedSupportingTextColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> textColor$material3_release(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(2080722220);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2080722220, i, -1, "androidx.compose.material3.TextFieldColors.textColor (TextFieldDefaults.kt:834)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(z ? this.textColor : this.disabledTextColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    @NotNull
    public final State<Color> trailingIconColor$material3_release(boolean z, boolean z2, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i) {
        if (AbstractC1038a.m1224y(interactionSource, "interactionSource", composer, -109504137)) {
            ComposerKt.traceEventStart(-109504137, i, -1, "androidx.compose.material3.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:744)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m18515boximpl(!z ? this.disabledTrailingIconColor : z2 ? this.errorTrailingIconColor : m17365trailingIconColor$lambda1(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14)) ? this.focusedTrailingIconColor : this.unfocusedTrailingIconColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private TextFieldColors(long j, long j2, long j3, long j5, long j6, TextSelectionColors textSelectionColors, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28) {
        this.textColor = j;
        this.disabledTextColor = j2;
        this.containerColor = j3;
        this.cursorColor = j5;
        this.errorCursorColor = j6;
        this.textSelectionColors = textSelectionColors;
        this.focusedIndicatorColor = j7;
        this.unfocusedIndicatorColor = j8;
        this.errorIndicatorColor = j9;
        this.disabledIndicatorColor = j10;
        this.focusedLeadingIconColor = j11;
        this.unfocusedLeadingIconColor = j12;
        this.disabledLeadingIconColor = j13;
        this.errorLeadingIconColor = j14;
        this.focusedTrailingIconColor = j15;
        this.unfocusedTrailingIconColor = j16;
        this.disabledTrailingIconColor = j17;
        this.errorTrailingIconColor = j18;
        this.focusedLabelColor = j19;
        this.unfocusedLabelColor = j20;
        this.disabledLabelColor = j21;
        this.errorLabelColor = j22;
        this.placeholderColor = j23;
        this.disabledPlaceholderColor = j24;
        this.focusedSupportingTextColor = j25;
        this.unfocusedSupportingTextColor = j26;
        this.disabledSupportingTextColor = j27;
        this.errorSupportingTextColor = j28;
    }
}
