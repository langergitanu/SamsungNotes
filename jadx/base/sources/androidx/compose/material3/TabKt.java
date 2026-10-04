package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import androidx.compose.p109ui.layout.AlignmentLineKt;
import androidx.compose.p109ui.layout.LayoutIdKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0083\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u008b\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, m13886d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m17869getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = C2256Dp.m20968constructorimpl(72);
    private static final float HorizontalTextPadding = C2256Dp.m20968constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = C2256Dp.m20968constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = C2256Dp.m20968constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = C2256Dp.m20968constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:102:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0225 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17345LeadingIconTabwqdebIU(final boolean z, @NotNull final Function0<Unit> onClick, @NotNull final Function2<? super Composer, ? super Integer, Unit> text, @NotNull final Function2<? super Composer, ? super Integer, Unit> icon, @Nullable Modifier modifier, boolean z2, long j, long j2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        long jM18535unboximpl;
        int i6;
        long j3;
        final boolean z4;
        long j5;
        final MutableInteractionSource mutableInteractionSource2;
        final long j6;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(-777316544);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(text) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(icon) ? 2048 : 1024;
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            i4 |= 24576;
        } else {
            if ((57344 & i) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i2 & 32;
            if (i5 != 0) {
                if ((458752 & i) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                }
                if ((3670016 & i) == 0) {
                    jM18535unboximpl = j;
                    i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(jM18535unboximpl)) ? 1048576 : 524288;
                } else {
                    jM18535unboximpl = j;
                }
                if ((29360128 & i) == 0) {
                    i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                }
                i6 = i2 & 256;
                if (i6 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                }
                if ((i4 & 191739611) == 38347922 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource3 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    z5 = z3;
                    j6 = j2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        boolean z6 = i5 == 0 ? true : z2;
                        if ((i2 & 64) != 0) {
                            jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
                            i4 &= -3670017;
                        }
                        if ((i2 & 128) == 0) {
                            i4 = (-29360129) & i4;
                            j3 = jM18535unboximpl;
                        } else {
                            j3 = j2;
                        }
                        if (i6 == 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            z4 = z6;
                            j5 = j3;
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-777316544, i4, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
                            }
                            final Indication indicationM16977rememberRipple9IZ8Weo = RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, jM18535unboximpl, composerStartRestartGroup, ((i4 >> 12) & 896) | 6, 2);
                            final Modifier modifier4 = modifier2;
                            final int i8 = i4;
                            int i9 = i8 >> 18;
                            long j7 = j5;
                            m17348TabTransitionKlgxPg(jM18535unboximpl, j7, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer3, int i10) {
                                    if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-429037564, i10, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:170)");
                                    }
                                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m15856paddingVpY3zN4$default(SelectableKt.m16105selectableO2vRcR0(SizeKt.m15885height3ABfNKs(modifier4, TabKt.SmallTabHeight), z, mutableInteractionSource2, indicationM16977rememberRipple9IZ8Weo, z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), TabKt.HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = icon;
                                    int i11 = i8;
                                    Function2<Composer, Integer, Unit> function22 = text;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer3, 54);
                                    Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-501504408);
                                    function2.invoke(composer3, Integer.valueOf((i11 >> 9) & 14));
                                    SpacerKt.Spacer(SizeKt.m15896requiredWidth3ABfNKs(Modifier.INSTANCE, TabKt.TextDistanceFromLeadingIcon), composer3, 6);
                                    TextKt.ProvideTextStyle(TextStyle.m20465copyHL5avdY$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m20850boximpl(TextAlign.INSTANCE.m20857getCentere0LSkKk()), null, 0L, null, 245759, null), function22, composer3, (i11 >> 3) & 112);
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i9 & 112) | (i9 & 14) | 3072 | ((i8 << 6) & 896));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j6 = j7;
                            composer2 = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            z5 = z4;
                            modifier3 = modifier4;
                        } else {
                            z4 = z6;
                            j5 = j3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i4 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        z4 = z2;
                        j5 = j2;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Indication indicationM16977rememberRipple9IZ8Weo2 = RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, jM18535unboximpl, composerStartRestartGroup, ((i4 >> 12) & 896) | 6, 2);
                    final Modifier modifier42 = modifier2;
                    final int i82 = i4;
                    int i92 = i82 >> 18;
                    long j72 = j5;
                    m17348TabTransitionKlgxPg(jM18535unboximpl, j72, z, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@Nullable Composer composer3, int i10) {
                            if ((i10 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-429037564, i10, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:170)");
                            }
                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m15856paddingVpY3zN4$default(SelectableKt.m16105selectableO2vRcR0(SizeKt.m15885height3ABfNKs(modifier42, TabKt.SmallTabHeight), z, mutableInteractionSource2, indicationM16977rememberRipple9IZ8Weo2, z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), TabKt.HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function2 = icon;
                            int i11 = i82;
                            Function2<Composer, Integer, Unit> function22 = text;
                            composer3.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer3, 54);
                            Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                            if (composer3.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            composer3.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                            composer3.startReplaceableGroup(-678309503);
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer3.startReplaceableGroup(-501504408);
                            function2.invoke(composer3, Integer.valueOf((i11 >> 9) & 14));
                            SpacerKt.Spacer(SizeKt.m15896requiredWidth3ABfNKs(Modifier.INSTANCE, TabKt.TextDistanceFromLeadingIcon), composer3, 6);
                            TextKt.ProvideTextStyle(TextStyle.m20465copyHL5avdY$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m20850boximpl(TextAlign.INSTANCE.m20857getCentere0LSkKk()), null, 0L, null, 245759, null), function22, composer3, (i11 >> 3) & 112);
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composerStartRestartGroup, (i92 & 112) | (i92 & 14) | 3072 | ((i82 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j6 = j72;
                    composer2 = composerStartRestartGroup;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z5 = z4;
                    modifier3 = modifier42;
                }
                final long j8 = jM18535unboximpl;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Composer composer3, int i10) {
                        TabKt.m17345LeadingIconTabwqdebIU(z, onClick, text, icon, modifier3, z5, j8, j6, mutableInteractionSource3, composer3, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 196608;
            z3 = z2;
            if ((3670016 & i) == 0) {
            }
            if ((29360128 & i) == 0) {
            }
            i6 = i2 & 256;
            if (i6 != 0) {
            }
            if ((i4 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if (i6 == 0) {
                    }
                }
            }
            final long j82 = jM18535unboximpl;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((3670016 & i) == 0) {
        }
        if ((29360128 & i) == 0) {
        }
        i6 = i2 & 256;
        if (i6 != 0) {
        }
        if ((i4 & 191739611) == 38347922) {
        }
        final long j822 = jM18535unboximpl;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0208 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0119  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Tab-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17346TabbogVsAg(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z2, long j, long j2, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        long jM18535unboximpl;
        int i6;
        int i7;
        int i8;
        long j3;
        final boolean z4;
        long j5;
        final int i9;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource3;
        final long j6;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-202735880);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((57344 & i) == 0) {
                    jM18535unboximpl = j;
                    i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM18535unboximpl)) ? 16384 : 8192;
                } else {
                    jM18535unboximpl = j;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        i11 = i4;
                        i7 = i12;
                        int i13 = composerStartRestartGroup.changed(j2) ? 131072 : 65536;
                        i6 = i11 | i13;
                    } else {
                        i11 = i4;
                        i7 = i12;
                    }
                    i6 = i11 | i13;
                } else {
                    i6 = i4;
                    i7 = i12;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i6 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i6 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                }
                if ((i2 & 128) == 0) {
                    i10 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                    if ((23967451 & i6) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            boolean z6 = i5 == 0 ? true : z2;
                            if ((i2 & 16) != 0) {
                                jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
                                i6 &= -57345;
                            }
                            if ((i2 & 32) == 0) {
                                i6 = (-458753) & i6;
                                j3 = jM18535unboximpl;
                            } else {
                                j3 = j2;
                            }
                            if (i8 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                z4 = z6;
                                j5 = j3;
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                z4 = z6;
                                j5 = j3;
                                i9 = i6;
                                mutableInteractionSource2 = mutableInteractionSource;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-202735880, i9, -1, "androidx.compose.material3.Tab (Tab.kt:225)");
                                }
                                final Indication indicationM16977rememberRipple9IZ8Weo = RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, jM18535unboximpl, composerStartRestartGroup, ((i9 >> 6) & 896) | 6, 2);
                                final Modifier modifier4 = modifier2;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                boolean z7 = z4;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                    @Composable
                                    public final void invoke(@Nullable Composer composer3, int i14) {
                                        if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-551896140, i14, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:240)");
                                        }
                                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m16105selectableO2vRcR0(modifier4, z, mutableInteractionSource2, indicationM16977rememberRipple9IZ8Weo, z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), 0.0f, 1, null);
                                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                        Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                                        int i15 = ((i9 >> 12) & 7168) | 432;
                                        composer3.startReplaceableGroup(-483455358);
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                        Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                                        if (composer3.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        composer3.disableReusing();
                                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                        composer3.startReplaceableGroup(-1163856341);
                                        function3.invoke(ColumnScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                int i14 = i9 >> 12;
                                long j7 = j5;
                                m17348TabTransitionKlgxPg(jM18535unboximpl, j7, z, composableLambda, composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 3072 | ((i9 << 6) & 896));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                j6 = j7;
                                z5 = z7;
                                modifier3 = modifier4;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i6 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                            }
                            z4 = z2;
                            j5 = j2;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        i9 = i6;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Indication indicationM16977rememberRipple9IZ8Weo2 = RippleKt.m16977rememberRipple9IZ8Weo(true, 0.0f, jM18535unboximpl, composerStartRestartGroup, ((i9 >> 6) & 896) | 6, 2);
                        final Modifier modifier42 = modifier2;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        boolean z72 = z4;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -551896140, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i142) {
                                if ((i142 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-551896140, i142, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:240)");
                                }
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m16105selectableO2vRcR0(modifier42, z, mutableInteractionSource2, indicationM16977rememberRipple9IZ8Weo2, z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick), 0.0f, 1, null);
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Function3<ColumnScope, Composer, Integer, Unit> function3 = content;
                                int i15 = ((i9 >> 12) & 7168) | 432;
                                composer3.startReplaceableGroup(-483455358);
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                composer3.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                composer3.startReplaceableGroup(-1163856341);
                                function3.invoke(ColumnScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i142 = i9 >> 12;
                        long j72 = j5;
                        m17348TabTransitionKlgxPg(jM18535unboximpl, j72, z, composableLambda2, composerStartRestartGroup, (i142 & 112) | (i142 & 14) | 3072 | ((i9 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource42;
                        j6 = j72;
                        z5 = z72;
                        modifier3 = modifier42;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        j6 = j2;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    final long j8 = jM18535unboximpl;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i15) {
                            TabKt.m17346TabbogVsAg(z, onClick, modifier3, z5, j8, j6, mutableInteractionSource3, content, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i6 |= i10;
                if ((23967451 & i6) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        if (i8 == 0) {
                        }
                    }
                }
                final long j82 = jM18535unboximpl;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            i6 |= i10;
            if ((23967451 & i6) == 4793490) {
            }
            final long j822 = jM18535unboximpl;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        i6 |= i10;
        if ((23967451 & i6) == 4793490) {
        }
        final long j8222 = jM18535unboximpl;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0240 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0124  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Tab-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17347TabwqdebIU(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, long j, long j2, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i9;
        int i10;
        long jM18535unboximpl;
        int i11;
        long j3;
        boolean z4;
        long j5;
        MutableInteractionSource mutableInteractionSource2;
        final int i12;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final long j6;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final long j7;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-350627181);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i4 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 == 0) {
                    if ((i & 57344) == 0) {
                        function23 = function2;
                        i4 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                        i8 = 57344;
                        function24 = function22;
                    } else {
                        i8 = 57344;
                        function24 = function22;
                        if ((i & 458752) == 0) {
                            i4 |= composerStartRestartGroup.changed(function24) ? 131072 : 65536;
                        }
                    }
                    if ((i & 3670016) == 0) {
                        i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j)) ? 1048576 : 524288;
                    }
                    if ((i & 29360128) != 0) {
                        i9 = 458752;
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    } else {
                        i9 = 458752;
                    }
                    i10 = i2 & 256;
                    if (i10 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                    }
                    if ((191739611 & i4) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function23 = null;
                            }
                            if (i7 != 0) {
                                function24 = null;
                            }
                            if ((i2 & 64) == 0) {
                                jM18535unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m18535unboximpl();
                                i4 &= -3670017;
                            } else {
                                jM18535unboximpl = j;
                            }
                            if ((i2 & 128) == 0) {
                                i11 = i4 & (-29360129);
                                j3 = jM18535unboximpl;
                            } else {
                                i11 = i4;
                                j3 = j2;
                            }
                            if (i10 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                function26 = function23;
                                long j8 = j3;
                                i12 = i11;
                                z4 = z3;
                                function25 = function24;
                                j5 = j8;
                            } else {
                                long j9 = j3;
                                z4 = z3;
                                j5 = j9;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i12 = i11;
                                function25 = function24;
                                function26 = function23;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            jM18535unboximpl = j;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i12 = i4;
                            z4 = z3;
                            function25 = function24;
                            function26 = function23;
                            j5 = j2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350627181, i12, -1, "androidx.compose.material3.Tab (Tab.kt:91)");
                        }
                        final ComposableLambda composableLambda = function26 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$styledText$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i14) {
                                if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(708874428, i14, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:103)");
                                }
                                TextKt.ProvideTextStyle(TextStyle.m20465copyHL5avdY$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m20850boximpl(TextAlign.INSTANCE.m20857getCentere0LSkKk()), null, 0L, null, 245759, null), function26, composer3, (i12 >> 9) & 112);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull ColumnScope Tab, @Nullable Composer composer3, int i14) {
                                Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
                                if ((i14 & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1540996038, i14, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:118)");
                                }
                                TabKt.TabBaselineLayout(composableLambda, function25, composer3, (i12 >> 12) & 112);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i14 = 12582912 | (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168);
                        int i15 = i12 >> 6;
                        int i16 = i14 | (i15 & i8) | (i15 & i9) | (i15 & 3670016);
                        Function2<? super Composer, ? super Integer, Unit> function29 = function25;
                        Modifier modifier4 = modifier2;
                        long j10 = jM18535unboximpl;
                        m17346TabbogVsAg(z, onClick, modifier4, z4, j10, j5, mutableInteractionSource2, composableLambda2, composerStartRestartGroup, i16, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        composer2 = composerStartRestartGroup;
                        j6 = j5;
                        function27 = function29;
                        j7 = j10;
                        function28 = function26;
                        z5 = z4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        function27 = function24;
                        composer2 = composerStartRestartGroup;
                        function28 = function23;
                        j7 = j;
                        j6 = j2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i17) {
                            TabKt.m17347TabwqdebIU(z, onClick, modifier3, z5, function28, function27, j7, j6, mutableInteractionSource3, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 24576;
                function23 = function2;
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                if ((i & 3670016) == 0) {
                }
                if ((i & 29360128) != 0) {
                }
                i10 = i2 & 256;
                if (i10 == 0) {
                }
                if ((191739611 & i4) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if (i10 == 0) {
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda3 = function26 != null ? ComposableLambdaKt.composableLambda(composerStartRestartGroup, 708874428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$styledText$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i142) {
                                if ((i142 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(708874428, i142, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:103)");
                                }
                                TextKt.ProvideTextStyle(TextStyle.m20465copyHL5avdY$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m20850boximpl(TextAlign.INSTANCE.m20857getCentere0LSkKk()), null, 0L, null, 245759, null), function26, composer3, (i12 >> 9) & 112);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull ColumnScope Tab, @Nullable Composer composer3, int i142) {
                                Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
                                if ((i142 & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1540996038, i142, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:118)");
                                }
                                TabKt.TabBaselineLayout(composableLambda3, function25, composer3, (i12 >> 12) & 112);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i142 = 12582912 | (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168);
                        int i152 = i12 >> 6;
                        int i162 = i142 | (i152 & i8) | (i152 & i9) | (i152 & 3670016);
                        Function2<? super Composer, ? super Integer, Unit> function292 = function25;
                        Modifier modifier42 = modifier2;
                        long j102 = jM18535unboximpl;
                        m17346TabbogVsAg(z, onClick, modifier42, z4, j102, j5, mutableInteractionSource2, composableLambda22, composerStartRestartGroup, i162, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        composer2 = composerStartRestartGroup;
                        j6 = j5;
                        function27 = function292;
                        j7 = j102;
                        function28 = function26;
                        z5 = z4;
                        modifier3 = modifier42;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function23 = function2;
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            if ((i & 29360128) != 0) {
            }
            i10 = i2 & 256;
            if (i10 == 0) {
            }
            if ((191739611 & i4) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function23 = function2;
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        if ((i & 29360128) != 0) {
        }
        i10 = i2 & 256;
        if (i10 == 0) {
        }
        if ((191739611 & i4) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(514131524);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:302)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.TabKt.TabBaselineLayout.2
                @Override // androidx.compose.p109ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo15214measure3p2s80s(@NotNull final MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j) {
                    Placeable placeableMo19855measureBRTryo0;
                    Placeable placeableMo19855measureBRTryo02;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    if (function2 != null) {
                        for (Measurable measurable : measurables) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                                placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(Constraints.m20912copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    placeableMo19855measureBRTryo0 = null;
                    if (function22 != null) {
                        for (Measurable measurable2 : measurables) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                placeableMo19855measureBRTryo02 = measurable2.mo19855measureBRTryo0(j);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    placeableMo19855measureBRTryo02 = null;
                    final int iMax = Math.max(placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getWidth() : 0, placeableMo19855measureBRTryo02 != null ? placeableMo19855measureBRTryo02.getWidth() : 0);
                    final int iMax2 = Math.max(Layout.mo15540roundToPx0680j_4((placeableMo19855measureBRTryo0 == null || placeableMo19855measureBRTryo02 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight), Layout.mo15539roundToPxR2X_6o(TabKt.IconDistanceFromBaseline) + (placeableMo19855measureBRTryo02 != null ? placeableMo19855measureBRTryo02.getHeight() : 0) + (placeableMo19855measureBRTryo0 != null ? placeableMo19855measureBRTryo0.getHeight() : 0));
                    final Integer numValueOf = placeableMo19855measureBRTryo0 != null ? Integer.valueOf(placeableMo19855measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) : null;
                    final Integer numValueOf2 = placeableMo19855measureBRTryo0 != null ? Integer.valueOf(placeableMo19855measureBRTryo0.get(AlignmentLineKt.getLastBaseline())) : null;
                    final Placeable placeable = placeableMo19855measureBRTryo0;
                    final Placeable placeable2 = placeableMo19855measureBRTryo02;
                    return MeasureScope.layout$default(Layout, iMax, iMax2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                            Placeable placeable3;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Placeable placeable4 = placeable;
                            if (placeable4 == null || (placeable3 = placeable2) == null) {
                                if (placeable4 != null) {
                                    TabKt.placeTextOrIcon(layout, placeable4, iMax2);
                                    return;
                                }
                                Placeable placeable5 = placeable2;
                                if (placeable5 != null) {
                                    TabKt.placeTextOrIcon(layout, placeable5, iMax2);
                                    return;
                                }
                                return;
                            }
                            MeasureScope measureScope = Layout;
                            int i4 = iMax;
                            int i5 = iMax2;
                            Integer num = numValueOf;
                            Intrinsics.checkNotNull(num);
                            int iIntValue = num.intValue();
                            Integer num2 = numValueOf2;
                            Intrinsics.checkNotNull(num2);
                            TabKt.placeTextAndIcon(layout, measureScope, placeable4, placeable3, i4, i5, iIntValue, num2.intValue());
                        }
                    }, 4, null);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.INSTANCE;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(companion);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m18025setimpl(composerM18018constructorimpl, density, companion2.getSetDensity());
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            AbstractC1038a.m1220u(2058660585, 1480471867, composerStartRestartGroup, 720850841);
            if (function2 != null) {
                Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), HorizontalTextPadding, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-947514212);
                AbstractC1038a.m1222w(composerStartRestartGroup, i2 & 14, function2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (function22 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "icon");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierLayoutId);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1983967725);
                AbstractC1038a.m1222w(composerStartRestartGroup, (i2 >> 3) & 14, function22);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt.TabBaselineLayout.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                TabKt.TabBaselineLayout(function2, function22, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m17348TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        TwoWayConverter twoWayConverter;
        Composer composerStartRestartGroup = composer.startRestartGroup(735731848);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(function2) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:265)");
            }
            int i4 = i2 >> 6;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, composerStartRestartGroup, i4 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                @Composable
                @NotNull
                public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<Boolean> animateColor, @Nullable Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                    composer2.startReplaceableGroup(-899623535);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-899623535, i5, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:273)");
                    }
                    TweenSpec tweenSpecTween = animateColor.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing()) : AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return tweenSpecTween;
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1462136984);
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1997025499);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:287)");
            }
            long j3 = zBooleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            ColorSpace colorSpaceM18529getColorSpaceimpl = Color.m18529getColorSpaceimpl(j3);
            composerStartRestartGroup.startReplaceableGroup(-3686930);
            boolean zChanged = composerStartRestartGroup.changed(colorSpaceM18529getColorSpaceimpl);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM18529getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(1847725064);
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1997025499);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:287)");
            }
            long j5 = zBooleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Color colorM18515boximpl = Color.m18515boximpl(j5);
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(-1997025499);
            if (ComposerKt.isTraceInProgress()) {
                twoWayConverter = twoWayConverter2;
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:287)");
            } else {
                twoWayConverter = twoWayConverter2;
            }
            long j6 = zBooleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM18515boximpl, Color.m18515boximpl(j6), tabKt$TabTransition$color$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "ColorAnimation", composerStartRestartGroup, 32768);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(m17349TabTransition_Klgx_Pg$lambda5(stateCreateTransitionAnimation)))}, function2, composerStartRestartGroup, (i4 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabTransition$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i5) {
                TabKt.m17348TabTransitionKlgxPg(j, j2, z2, function2, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: renamed from: TabTransition_Klgx_Pg$lambda-5, reason: not valid java name */
    private static final long m17349TabTransition_Klgx_Pg$lambda5(State<Color> state) {
        return state.getValue().m18535unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i4, int i5) {
        int iMo15540roundToPx0680j_4 = density.mo15540roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m17867getActiveIndicatorHeightD9Ej5fM()) + density.mo15540roundToPx0680j_4(i4 == i5 ? SingleLineTextBaselineWithIcon : DoubleLineTextBaselineWithIcon);
        int iMo15539roundToPxR2X_6o = (density.mo15539roundToPxR2X_6o(IconDistanceFromBaseline) + placeable2.getHeight()) - i4;
        int i6 = (i2 - i5) - iMo15540roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, AbstractC1038a.m1205f(placeable, i, 2), i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, AbstractC1038a.m1205f(placeable2, i, 2), i6 - iMo15539roundToPxR2X_6o, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, AbstractC1038a.m1197B(placeable, i, 2), 0.0f, 4, null);
    }
}
