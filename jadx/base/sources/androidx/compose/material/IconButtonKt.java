package androidx.compose.material;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
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
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aZ\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m13886d2 = {"RippleRadius", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IconButtonKt {
    private static final float RippleRadius = C2256Dp.m20968constructorimpl(24);

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f1  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Composer composer2;
        final boolean z3;
        float disabled;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-111063634);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 896) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 == 0) {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
                    }
                    if ((i2 & 16) == 0) {
                        i4 |= 24576;
                    } else if ((57344 & i) == 0) {
                        i4 |= composerStartRestartGroup.changed(content) ? 16384 : 8192;
                    }
                    i7 = i4;
                    if ((46811 & i7) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                        boolean z4 = i5 == 0 ? true : z2;
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-111063634, i7, -1, "androidx.compose.material.IconButton (IconButton.kt:58)");
                        }
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        composer2 = composerStartRestartGroup;
                        z3 = z4;
                        Modifier modifierM15440clickableO2vRcR0$default = ClickableKt.m15440clickableO2vRcR0$default(TouchTargetKt.minimumTouchTargetSize(modifier4), mutableInteractionSource4, RippleKt.m16977rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z3, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15440clickableO2vRcR0$default);
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.useNode();
                        } else {
                            composer2.createNode(constructor);
                        }
                        composer2.disableReusing();
                        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-2146259096);
                        if (z3) {
                            composer2.startReplaceableGroup(753555801);
                            disabled = ContentAlpha.INSTANCE.getDisabled(composer2, 6);
                        } else {
                            composer2.startReplaceableGroup(753555775);
                            disabled = ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                        }
                        composer2.endReplaceableGroup();
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, content, composer2, ((i7 >> 9) & 112) | 8);
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource4;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        composer2 = composerStartRestartGroup;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.IconButtonKt.IconButton.3
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

                        public final void invoke(@Nullable Composer composer3, int i9) {
                            IconButtonKt.IconButton(onClick, modifier3, z3, mutableInteractionSource3, content, composer3, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 16) == 0) {
                }
                i7 = i4;
                if ((46811 & i7) == 9362) {
                    if (i8 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                    composer2 = composerStartRestartGroup;
                    z3 = z4;
                    Modifier modifierM15440clickableO2vRcR0$default2 = ClickableKt.m15440clickableO2vRcR0$default(TouchTargetKt.minimumTouchTargetSize(modifier4), mutableInteractionSource42, RippleKt.m16977rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z3, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                    Density density2 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15440clickableO2vRcR0$default2);
                    if (composer2.getApplier() == null) {
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(-2146259096);
                    if (z3) {
                    }
                    composer2.endReplaceableGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, content, composer2, ((i7 >> 9) & 112) | 8);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource42;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i2 & 8;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 16) == 0) {
            }
            i7 = i4;
            if ((46811 & i7) == 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 8;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 16) == 0) {
        }
        i7 = i4;
        if ((46811 & i7) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0213 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c9  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconToggleButton(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        boolean z3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        final boolean z5;
        MutableInteractionSource mutableInteractionSource3;
        float disabled;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-54657793);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else if ((i & 14) == 0) {
            z3 = z;
            i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
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
                    z4 = z2;
                    i4 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((i2 & 32) != 0) {
                        i7 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                        if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z4;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            z5 = i5 == 0 ? true : z4;
                            if (i6 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-54657793, i4, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:101)");
                            }
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            int i9 = i4;
                            Modifier modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(TouchTargetKt.minimumTouchTargetSize(modifier4), z3, mutableInteractionSource5, RippleKt.m16977rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m20259boximpl(Role.INSTANCE.m20267getCheckboxo7Vup1c()), onCheckedChange);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                            Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16110toggleableO2vRcR0);
                            if (composerStartRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.useNode();
                            } else {
                                composerStartRestartGroup.createNode(constructor);
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-430124743);
                            if (z5) {
                                composerStartRestartGroup.startReplaceableGroup(-1866758076);
                                disabled = ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, 6);
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-1866758102);
                                disabled = ((Number) composerStartRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, content, composerStartRestartGroup, ((i9 >> 12) & 112) | 8);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource5;
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.IconButtonKt.IconToggleButton.3
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

                            public final void invoke(@Nullable Composer composer2, int i10) {
                                IconButtonKt.IconToggleButton(z, onCheckedChange, modifier3, z5, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i7;
                    if ((374491 & i4) == 74898) {
                        if (i8 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                        int i92 = i4;
                        Modifier modifierM16110toggleableO2vRcR02 = ToggleableKt.m16110toggleableO2vRcR0(TouchTargetKt.minimumTouchTargetSize(modifier4), z3, mutableInteractionSource52, RippleKt.m16977rememberRipple9IZ8Weo(false, RippleRadius, 0L, composerStartRestartGroup, 54, 4), z5, Role.m20259boximpl(Role.INSTANCE.m20267getCheckboxo7Vup1c()), onCheckedChange);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM16110toggleableO2vRcR02);
                        if (composerStartRestartGroup.getApplier() == null) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                        AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-430124743);
                        if (z5) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(disabled))}, content, composerStartRestartGroup, ((i92 >> 12) & 112) | 8);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource4 = mutableInteractionSource52;
                        modifier3 = modifier4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                }
                i4 |= i7;
                if ((374491 & i4) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
            }
            i4 |= i7;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) != 0) {
        }
        i4 |= i7;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
