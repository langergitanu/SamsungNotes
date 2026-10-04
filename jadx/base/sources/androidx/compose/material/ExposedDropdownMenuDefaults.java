package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.RotateKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, m13886d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@ExperimentalMaterialApi
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    public final void TrailingIcon(final boolean z, @Nullable Function0<Unit> function0, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Function0<Unit> function02;
        Composer composerStartRestartGroup = composer.startRestartGroup(876077373);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function02 = function0;
        } else {
            function02 = i5 != 0 ? new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            } : function0;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876077373, i4, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:286)");
            }
            IconButtonKt.IconButton(function02, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            }), false, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 726122713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(726122713, i6, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.<anonymous> (ExposedDropdownMenu.kt:294)");
                    }
                    IconKt.m16774Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), "Trailing icon for exposed dropdown menu", RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 360.0f), 0L, composer2, 48, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composerStartRestartGroup, ((i4 >> 3) & 14) | 24576, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i6) {
                ExposedDropdownMenuDefaults.this.TrailingIcon(z, function02, composer2, i | 1, i2);
            }
        });
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m16746outlinedTextFieldColorsDlUQjxs(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, @Nullable Composer composer, int i, int i2, int i4, int i5) {
        long j24;
        long jM18524copywmQWz5c$default;
        long j25;
        long jM18524copywmQWz5c$default2;
        long j26;
        long jM18524copywmQWz5c$default3;
        long j27;
        long jM18524copywmQWz5c$default4;
        composer.startReplaceableGroup(1162641182);
        long jM18524copywmQWz5c$default5 = (i5 & 1) != 0 ? Color.m18524copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jM18524copywmQWz5c$default6 = (i5 & 2) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18560getTransparent0d7_KjU = (i5 & 4) != 0 ? Color.INSTANCE.m18560getTransparent0d7_KjU() : j3;
        long jM16676getPrimary0d7_KjU = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j5;
        long jM16670getError0d7_KjU = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j6;
        long jM18524copywmQWz5c$default7 = (i5 & 32) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default8 = (i5 & 64) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if ((i5 & 128) != 0) {
            long j28 = jM18524copywmQWz5c$default8;
            j24 = j28;
            jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(j28, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j24 = jM18524copywmQWz5c$default8;
            jM18524copywmQWz5c$default = j9;
        }
        long jM16670getError0d7_KjU2 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j10;
        long jM18524copywmQWz5c$default9 = (i5 & 512) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if ((i5 & 1024) != 0) {
            long j29 = jM18524copywmQWz5c$default9;
            jM18524copywmQWz5c$default2 = Color.m18524copywmQWz5c$default(j29, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j29;
        } else {
            j25 = jM18524copywmQWz5c$default9;
            jM18524copywmQWz5c$default2 = j12;
        }
        long j30 = (i5 & 2048) != 0 ? j25 : j13;
        long jM18524copywmQWz5c$default10 = (i5 & 4096) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long jM18524copywmQWz5c$default11 = (i5 & 8192) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((i5 & 16384) != 0) {
            long j31 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default3 = Color.m18524copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j26 = j31;
        } else {
            j26 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default3 = j16;
        }
        long jM16670getError0d7_KjU3 = (32768 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j17;
        long jM18524copywmQWz5c$default12 = (65536 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        long jM18524copywmQWz5c$default13 = (131072 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((262144 & i5) != 0) {
            long j32 = jM18524copywmQWz5c$default13;
            jM18524copywmQWz5c$default4 = Color.m18524copywmQWz5c$default(j32, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j27 = j32;
        } else {
            j27 = jM18524copywmQWz5c$default13;
            jM18524copywmQWz5c$default4 = j20;
        }
        long jM16670getError0d7_KjU4 = (524288 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j21;
        long jM18524copywmQWz5c$default14 = (1048576 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j22;
        long jM18524copywmQWz5c$default15 = (i5 & 2097152) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162641182, i, i2, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:455)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM18524copywmQWz5c$default5, jM18524copywmQWz5c$default6, jM16676getPrimary0d7_KjU, jM16670getError0d7_KjU, jM18524copywmQWz5c$default7, j24, jM16670getError0d7_KjU2, jM18524copywmQWz5c$default, j25, jM18524copywmQWz5c$default2, j30, j26, jM18524copywmQWz5c$default11, jM18524copywmQWz5c$default3, jM16670getError0d7_KjU3, jM18560getTransparent0d7_KjU, jM18524copywmQWz5c$default12, j27, jM18524copywmQWz5c$default4, jM16670getError0d7_KjU4, jM18524copywmQWz5c$default14, jM18524copywmQWz5c$default15, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m16747textFieldColorsDlUQjxs(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, @Nullable Composer composer, int i, int i2, int i4, int i5) {
        long j24;
        long jM18524copywmQWz5c$default;
        long j25;
        long jM18524copywmQWz5c$default2;
        long j26;
        long jM18524copywmQWz5c$default3;
        long j27;
        long jM18524copywmQWz5c$default4;
        composer.startReplaceableGroup(1208167904);
        long jM18524copywmQWz5c$default5 = (i5 & 1) != 0 ? Color.m18524copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jM18524copywmQWz5c$default6 = (i5 & 2) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM18524copywmQWz5c$default7 = (i5 & 4) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM16676getPrimary0d7_KjU = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU() : j5;
        long jM16670getError0d7_KjU = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j6;
        long jM18524copywmQWz5c$default8 = (i5 & 32) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM18524copywmQWz5c$default9 = (i5 & 64) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if ((i5 & 128) != 0) {
            long j28 = jM18524copywmQWz5c$default9;
            j24 = j28;
            jM18524copywmQWz5c$default = Color.m18524copywmQWz5c$default(j28, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j24 = jM18524copywmQWz5c$default9;
            jM18524copywmQWz5c$default = j9;
        }
        long jM16670getError0d7_KjU2 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j10;
        long jM18524copywmQWz5c$default10 = (i5 & 512) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if ((i5 & 1024) != 0) {
            long j29 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default2 = Color.m18524copywmQWz5c$default(j29, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j29;
        } else {
            j25 = jM18524copywmQWz5c$default10;
            jM18524copywmQWz5c$default2 = j12;
        }
        long j30 = (i5 & 2048) != 0 ? j25 : j13;
        long jM18524copywmQWz5c$default11 = (i5 & 4096) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long jM18524copywmQWz5c$default12 = (i5 & 8192) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((i5 & 16384) != 0) {
            long j31 = jM18524copywmQWz5c$default11;
            jM18524copywmQWz5c$default3 = Color.m18524copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j26 = j31;
        } else {
            j26 = jM18524copywmQWz5c$default11;
            jM18524copywmQWz5c$default3 = j16;
        }
        long jM16670getError0d7_KjU3 = (32768 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j17;
        long jM18524copywmQWz5c$default13 = (65536 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16676getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        long jM18524copywmQWz5c$default14 = (131072 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((262144 & i5) != 0) {
            long j32 = jM18524copywmQWz5c$default14;
            jM18524copywmQWz5c$default4 = Color.m18524copywmQWz5c$default(j32, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j27 = j32;
        } else {
            j27 = jM18524copywmQWz5c$default14;
            jM18524copywmQWz5c$default4 = j20;
        }
        long jM16670getError0d7_KjU4 = (524288 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m16670getError0d7_KjU() : j21;
        long jM18524copywmQWz5c$default15 = (1048576 & i5) != 0 ? Color.m18524copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m16675getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j22;
        long jM18524copywmQWz5c$default16 = (i5 & 2097152) != 0 ? Color.m18524copywmQWz5c$default(jM18524copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208167904, i, i2, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:352)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM18524copywmQWz5c$default5, jM18524copywmQWz5c$default6, jM16676getPrimary0d7_KjU, jM16670getError0d7_KjU, jM18524copywmQWz5c$default8, j24, jM16670getError0d7_KjU2, jM18524copywmQWz5c$default, j25, jM18524copywmQWz5c$default2, j30, j26, jM18524copywmQWz5c$default12, jM18524copywmQWz5c$default3, jM16670getError0d7_KjU3, jM18524copywmQWz5c$default7, jM18524copywmQWz5c$default13, j27, jM18524copywmQWz5c$default4, jM16670getError0d7_KjU4, jM18524copywmQWz5c$default15, jM18524copywmQWz5c$default16, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
