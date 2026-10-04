package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001an\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001a`\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001an\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001aV\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001ad\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001c\u001al\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010 \u001az\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\"¨\u0006#"}, m13886d2 = {"FilledIconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "IconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconButton", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IconButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledIconButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable IconButtonColors iconButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape shape2;
        IconButtonColors iconButtonColorsM17188filledIconButtonColorsro_MJ88;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Shape filledShape;
        int i7;
        final int i8;
        IconButtonColors iconButtonColors2;
        boolean z3;
        final Shape shape3;
        final IconButtonColors iconButtonColors3;
        final boolean z4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1594730011);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i4 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColorsM17188filledIconButtonColorsro_MJ88 = iconButtonColors;
                        int i12 = composerStartRestartGroup.changed(iconButtonColorsM17188filledIconButtonColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        iconButtonColorsM17188filledIconButtonColorsro_MJ88 = iconButtonColors;
                    }
                    i4 |= i12;
                } else {
                    iconButtonColorsM17188filledIconButtonColorsro_MJ88 = iconButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = (3670016 & i) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z4 = z2;
                            shape3 = shape2;
                            iconButtonColors3 = iconButtonColorsM17188filledIconButtonColorsro_MJ88;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i5 == 0 ? true : z2;
                                if ((i2 & 8) == 0) {
                                    i4 &= -7169;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                } else {
                                    filledShape = shape2;
                                }
                                int i13 = i4;
                                if ((i2 & 16) == 0) {
                                    iconButtonColorsM17188filledIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m17188filledIconButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i7 = i13 & (-57345);
                                } else {
                                    i7 = i13;
                                }
                                if (i6 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    modifier2 = modifier4;
                                    z3 = z5;
                                    shape2 = filledShape;
                                    i8 = i7;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i8 = i7;
                                    iconButtonColors2 = iconButtonColorsM17188filledIconButtonColorsro_MJ88;
                                    modifier2 = modifier4;
                                    z3 = z5;
                                    shape2 = filledShape;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1594730011, i8, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:196)");
                                    }
                                    int i14 = ((i8 >> 6) & 14) | ((i8 >> 9) & 112);
                                    IconButtonColors iconButtonColors4 = iconButtonColors2;
                                    Modifier modifier5 = modifier2;
                                    Shape shape4 = shape2;
                                    SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier5, z3, shape4, iconButtonColors2.containerColor$material3_release(z3, composerStartRestartGroup, i14).getValue().m18535unboximpl(), iconButtonColors2.contentColor$material3_release(z3, composerStartRestartGroup, i14).getValue().m18535unboximpl(), 0.0f, 0.0f, null, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1560623888, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconButton.2
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

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer2, int i15) {
                                            if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1560623888, i15, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:212)");
                                            }
                                            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m17676getContainerSizeD9Ej5fM());
                                            Alignment center = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i16 = i8;
                                            composer2.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                            if (composer2.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer2.startReusableNode();
                                            if (composer2.getInserting()) {
                                                composer2.createNode(constructor);
                                            } else {
                                                composer2.useNode();
                                            }
                                            composer2.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                            composer2.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer2.startReplaceableGroup(30997674);
                                            if (AbstractC1038a.m1199D(composer2, (i16 >> 18) & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i8 & 8190) | ((i8 << 12) & 1879048192), 6, 448);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape3 = shape4;
                                    iconButtonColors3 = iconButtonColors4;
                                    z4 = z3;
                                    modifier3 = modifier5;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                i8 = i4;
                                z3 = z2;
                            }
                            iconButtonColors2 = iconButtonColorsM17188filledIconButtonColorsro_MJ88;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i142 = ((i8 >> 6) & 14) | ((i8 >> 9) & 112);
                            IconButtonColors iconButtonColors42 = iconButtonColors2;
                            Modifier modifier52 = modifier2;
                            Shape shape42 = shape2;
                            SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier52, z3, shape42, iconButtonColors2.containerColor$material3_release(z3, composerStartRestartGroup, i142).getValue().m18535unboximpl(), iconButtonColors2.contentColor$material3_release(z3, composerStartRestartGroup, i142).getValue().m18535unboximpl(), 0.0f, 0.0f, null, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1560623888, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconButton.2
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1560623888, i15, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:212)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m17676getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i16 = i8;
                                    composer2.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(30997674);
                                    if (AbstractC1038a.m1199D(composer2, (i16 >> 18) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i8 & 8190) | ((i8 << 12) & 1879048192), 6, 448);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape3 = shape42;
                            iconButtonColors3 = iconButtonColors42;
                            z4 = z3;
                            modifier3 = modifier52;
                        }
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconButton.3
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

                            public final void invoke(@Nullable Composer composer2, int i15) {
                                IconButtonKt.FilledIconButton(onClick, modifier3, z4, shape3, iconButtonColors3, mutableInteractionSource3, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i9;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i10 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 8) == 0) {
                            }
                            int i132 = i4;
                            if ((i2 & 16) == 0) {
                            }
                            if (i6 == 0) {
                            }
                        }
                    }
                    final MutableInteractionSource mutableInteractionSource32 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                }
                i4 |= i9;
                if ((2995931 & i4) == 599186) {
                }
                final MutableInteractionSource mutableInteractionSource322 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
            }
            i4 |= i9;
            if ((2995931 & i4) == 599186) {
            }
            final MutableInteractionSource mutableInteractionSource3222 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
        }
        i4 |= i9;
        if ((2995931 & i4) == 599186) {
        }
        final MutableInteractionSource mutableInteractionSource32222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x023c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010a  */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledIconToggleButton(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, @Nullable IconToggleButtonColors iconToggleButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape shape2;
        IconToggleButtonColors iconToggleButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Shape filledShape;
        boolean z4;
        IconToggleButtonColors iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc;
        final int i7;
        MutableInteractionSource mutableInteractionSource3;
        boolean z5;
        Shape shape3;
        ?? r12;
        final Shape shape4;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors3;
        final boolean z6;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1708189280);
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
            i4 |= composerStartRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
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
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i10 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i4 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        int i11 = composerStartRestartGroup.changed(iconToggleButtonColors2) ? 131072 : 65536;
                        i4 |= i11;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i4 |= i11;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        i8 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z6 = z3;
                            shape4 = shape2;
                            iconToggleButtonColors3 = iconToggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z7 = i5 == 0 ? true : z3;
                                if ((i2 & 16) == 0) {
                                    i4 &= -57345;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                } else {
                                    filledShape = shape2;
                                }
                                int i12 = i4;
                                if ((i2 & 32) == 0) {
                                    z4 = true;
                                    iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m17189filledIconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i7 = i12 & (-458753);
                                } else {
                                    z4 = true;
                                    iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc = iconToggleButtonColors2;
                                    i7 = i12;
                                }
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
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z5 = z7;
                                shape3 = filledShape;
                                r12 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                r12 = 1;
                                modifier3 = modifier2;
                                z5 = z3;
                                shape3 = shape2;
                                i7 = i4;
                                iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc = iconToggleButtonColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1708189280, i7, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:314)");
                            }
                            int i13 = i7 >> 9;
                            int i14 = (i13 & 896) | (i13 & 14) | ((i7 << 3) & 112);
                            IconToggleButtonColors iconToggleButtonColors4 = iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc;
                            Modifier modifier5 = modifier3;
                            SurfaceKt.m17327Surfaced85dljk(z, onCheckedChange, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                                }
                            }, r12, null), z5, shape3, iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc.containerColor$material3_release(z5, z, composerStartRestartGroup, i14).getValue().m18535unboximpl(), iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc.contentColor$material3_release(z5, z, composerStartRestartGroup, i14).getValue().m18535unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1235871670, r12, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.3
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1235871670, i15, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:332)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m17676getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i16 = i7;
                                    composer2.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-1855390096);
                                    if (AbstractC1038a.m1199D(composer2, (i16 >> 21) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconToggleButtonColors3 = iconToggleButtonColors4;
                            z6 = z5;
                            modifier4 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.4
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

                            public final void invoke(@Nullable Composer composer2, int i15) {
                                IconButtonKt.FilledIconToggleButton(z, onCheckedChange, modifier4, z6, shape4, iconToggleButtonColors3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i8;
                    if ((23967451 & i4) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            int i122 = i4;
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            z5 = z7;
                            shape3 = filledShape;
                            r12 = z4;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = i7 >> 9;
                            int i142 = (i132 & 896) | (i132 & 14) | ((i7 << 3) & 112);
                            IconToggleButtonColors iconToggleButtonColors42 = iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc;
                            Modifier modifier52 = modifier3;
                            SurfaceKt.m17327Surfaced85dljk(z, onCheckedChange, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                                }
                            }, r12, null), z5, shape3, iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc.containerColor$material3_release(z5, z, composerStartRestartGroup, i142).getValue().m18535unboximpl(), iconToggleButtonColorsM17189filledIconToggleButtonColors5tl4gsc.contentColor$material3_release(z5, z, composerStartRestartGroup, i142).getValue().m18535unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1235871670, r12, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledIconToggleButton.3
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1235871670, i15, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:332)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m17676getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i16 = i7;
                                    composer2.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-1855390096);
                                    if (AbstractC1038a.m1199D(composer2, (i16 >> 21) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape4 = shape3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconToggleButtonColors3 = iconToggleButtonColors42;
                            z6 = z5;
                            modifier4 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                i4 |= i8;
                if ((23967451 & i4) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            i4 |= i8;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
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
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        i4 |= i8;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalIconButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable IconButtonColors iconButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape shape2;
        IconButtonColors iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Shape filledShape;
        int i7;
        final int i8;
        IconButtonColors iconButtonColors2;
        boolean z3;
        final Shape shape3;
        final IconButtonColors iconButtonColors3;
        final boolean z4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-783937767);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i4 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88 = iconButtonColors;
                        int i12 = composerStartRestartGroup.changed(iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88 = iconButtonColors;
                    }
                    i4 |= i12;
                } else {
                    iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88 = iconButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = (3670016 & i) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z4 = z2;
                            shape3 = shape2;
                            iconButtonColors3 = iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i5 == 0 ? true : z2;
                                if ((i2 & 8) == 0) {
                                    i4 &= -7169;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                } else {
                                    filledShape = shape2;
                                }
                                int i13 = i4;
                                if ((i2 & 16) == 0) {
                                    iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m17190filledTonalIconButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i7 = i13 & (-57345);
                                } else {
                                    i7 = i13;
                                }
                                if (i6 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                    modifier2 = modifier4;
                                    z3 = z5;
                                    shape2 = filledShape;
                                    i8 = i7;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i8 = i7;
                                    iconButtonColors2 = iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88;
                                    modifier2 = modifier4;
                                    z3 = z5;
                                    shape2 = filledShape;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-783937767, i8, -1, "androidx.compose.material3.FilledTonalIconButton (IconButton.kt:257)");
                                    }
                                    int i14 = ((i8 >> 6) & 14) | ((i8 >> 9) & 112);
                                    IconButtonColors iconButtonColors4 = iconButtonColors2;
                                    Modifier modifier5 = modifier2;
                                    Shape shape4 = shape2;
                                    SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier5, z3, shape4, iconButtonColors2.containerColor$material3_release(z3, composerStartRestartGroup, i14).getValue().m18535unboximpl(), iconButtonColors2.contentColor$material3_release(z3, composerStartRestartGroup, i14).getValue().m18535unboximpl(), 0.0f, 0.0f, null, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1772884636, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconButton.2
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

                                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                        @Composable
                                        public final void invoke(@Nullable Composer composer2, int i15) {
                                            if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1772884636, i15, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:273)");
                                            }
                                            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m17692getContainerSizeD9Ej5fM());
                                            Alignment center = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i16 = i8;
                                            composer2.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                            if (composer2.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer2.startReusableNode();
                                            if (composer2.getInserting()) {
                                                composer2.createNode(constructor);
                                            } else {
                                                composer2.useNode();
                                            }
                                            composer2.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                            composer2.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer2.startReplaceableGroup(-366642710);
                                            if (AbstractC1038a.m1199D(composer2, (i16 >> 18) & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, (i8 & 8190) | ((i8 << 12) & 1879048192), 6, 448);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape3 = shape4;
                                    iconButtonColors3 = iconButtonColors4;
                                    z4 = z3;
                                    modifier3 = modifier5;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                i8 = i4;
                                z3 = z2;
                            }
                            iconButtonColors2 = iconButtonColorsM17190filledTonalIconButtonColorsro_MJ88;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i142 = ((i8 >> 6) & 14) | ((i8 >> 9) & 112);
                            IconButtonColors iconButtonColors42 = iconButtonColors2;
                            Modifier modifier52 = modifier2;
                            Shape shape42 = shape2;
                            SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier52, z3, shape42, iconButtonColors2.containerColor$material3_release(z3, composerStartRestartGroup, i142).getValue().m18535unboximpl(), iconButtonColors2.contentColor$material3_release(z3, composerStartRestartGroup, i142).getValue().m18535unboximpl(), 0.0f, 0.0f, null, mutableInteractionSource2, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1772884636, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconButton.2
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1772884636, i15, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:273)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m17692getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i16 = i8;
                                    composer2.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(-366642710);
                                    if (AbstractC1038a.m1199D(composer2, (i16 >> 18) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, (i8 & 8190) | ((i8 << 12) & 1879048192), 6, 448);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape3 = shape42;
                            iconButtonColors3 = iconButtonColors42;
                            z4 = z3;
                            modifier3 = modifier52;
                        }
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconButton.3
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

                            public final void invoke(@Nullable Composer composer2, int i15) {
                                IconButtonKt.FilledTonalIconButton(onClick, modifier3, z4, shape3, iconButtonColors3, mutableInteractionSource3, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i9;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i10 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 8) == 0) {
                            }
                            int i132 = i4;
                            if ((i2 & 16) == 0) {
                            }
                            if (i6 == 0) {
                            }
                        }
                    }
                    final MutableInteractionSource mutableInteractionSource32 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                }
                i4 |= i9;
                if ((2995931 & i4) == 599186) {
                }
                final MutableInteractionSource mutableInteractionSource322 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
            }
            i4 |= i9;
            if ((2995931 & i4) == 599186) {
            }
            final MutableInteractionSource mutableInteractionSource3222 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
        }
        i4 |= i9;
        if ((2995931 & i4) == 599186) {
        }
        final MutableInteractionSource mutableInteractionSource32222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x023c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010a  */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalIconToggleButton(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, @Nullable IconToggleButtonColors iconToggleButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape shape2;
        IconToggleButtonColors iconToggleButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Shape filledShape;
        boolean z4;
        IconToggleButtonColors iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc;
        final int i7;
        MutableInteractionSource mutableInteractionSource3;
        boolean z5;
        Shape shape3;
        ?? r12;
        final Shape shape4;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors3;
        final boolean z6;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1676089246);
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
            i4 |= composerStartRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
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
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i10 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i4 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        int i11 = composerStartRestartGroup.changed(iconToggleButtonColors2) ? 131072 : 65536;
                        i4 |= i11;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i4 |= i11;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        i8 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z6 = z3;
                            shape4 = shape2;
                            iconToggleButtonColors3 = iconToggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                modifier3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z7 = i5 == 0 ? true : z3;
                                if ((i2 & 16) == 0) {
                                    i4 &= -57345;
                                    filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, 6);
                                } else {
                                    filledShape = shape2;
                                }
                                int i12 = i4;
                                if ((i2 & 32) == 0) {
                                    z4 = true;
                                    iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m17191filledTonalIconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i7 = i12 & (-458753);
                                } else {
                                    z4 = true;
                                    iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc = iconToggleButtonColors2;
                                    i7 = i12;
                                }
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
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z5 = z7;
                                shape3 = filledShape;
                                r12 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                r12 = 1;
                                modifier3 = modifier2;
                                z5 = z3;
                                shape3 = shape2;
                                i7 = i4;
                                iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc = iconToggleButtonColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1676089246, i7, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:378)");
                            }
                            int i13 = i7 >> 9;
                            int i14 = (i13 & 896) | (i13 & 14) | ((i7 << 3) & 112);
                            IconToggleButtonColors iconToggleButtonColors4 = iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc;
                            Modifier modifier5 = modifier3;
                            SurfaceKt.m17327Surfaced85dljk(z, onCheckedChange, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                                }
                            }, r12, null), z5, shape3, iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc.containerColor$material3_release(z5, z, composerStartRestartGroup, i14).getValue().m18535unboximpl(), iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc.contentColor$material3_release(z5, z, composerStartRestartGroup, i14).getValue().m18535unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -58218680, r12, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.3
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-58218680, i15, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:396)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m17692getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i16 = i7;
                                    composer2.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(2083239118);
                                    if (AbstractC1038a.m1199D(composer2, (i16 >> 21) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconToggleButtonColors3 = iconToggleButtonColors4;
                            z6 = z5;
                            modifier4 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.4
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

                            public final void invoke(@Nullable Composer composer2, int i15) {
                                IconButtonKt.FilledTonalIconToggleButton(z, onCheckedChange, modifier4, z6, shape4, iconToggleButtonColors3, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i8;
                    if ((23967451 & i4) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            int i122 = i4;
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            z5 = z7;
                            shape3 = filledShape;
                            r12 = z4;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = i7 >> 9;
                            int i142 = (i132 & 896) | (i132 & 14) | ((i7 << 3) & 112);
                            IconToggleButtonColors iconToggleButtonColors42 = iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc;
                            Modifier modifier52 = modifier3;
                            SurfaceKt.m17327Surfaced85dljk(z, onCheckedChange, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                                }
                            }, r12, null), z5, shape3, iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc.containerColor$material3_release(z5, z, composerStartRestartGroup, i142).getValue().m18535unboximpl(), iconToggleButtonColorsM17191filledTonalIconToggleButtonColors5tl4gsc.contentColor$material3_release(z5, z, composerStartRestartGroup, i142).getValue().m18535unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -58218680, r12, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.FilledTonalIconToggleButton.3
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

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i15) {
                                    if ((i15 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-58218680, i15, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:396)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m17692getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i16 = i7;
                                    composer2.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    composer2.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                    composer2.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(2083239118);
                                    if (AbstractC1038a.m1199D(composer2, (i16 >> 21) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape4 = shape3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconToggleButtonColors3 = iconToggleButtonColors42;
                            z6 = z5;
                            modifier4 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                i4 |= i8;
                if ((23967451 & i4) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            i4 |= i8;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
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
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        i4 |= i8;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0268 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0147  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable IconButtonColors iconButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        IconButtonColors iconButtonColorsM17192iconButtonColorsro_MJ88;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i7;
        boolean z3;
        IconButtonColors iconButtonColors2;
        Modifier modifier3;
        final boolean z4;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier4;
        final IconButtonColors iconButtonColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1142896114);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        iconButtonColorsM17192iconButtonColorsro_MJ88 = iconButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconButtonColorsM17192iconButtonColorsro_MJ88) ? 2048 : 1024;
                        i4 |= i10;
                    } else {
                        iconButtonColorsM17192iconButtonColorsro_MJ88 = iconButtonColors;
                    }
                    i4 |= i10;
                } else {
                    iconButtonColorsM17192iconButtonColorsro_MJ88 = iconButtonColors;
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
                        i8 = (458752 & i) == 0 ? composerStartRestartGroup.changed(content) ? 131072 : 65536 : 196608;
                        if ((374491 & i4) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z4 = z2;
                            iconButtonColors3 = iconButtonColorsM17192iconButtonColorsro_MJ88;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                    iconButtonColorsM17192iconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m17192iconButtonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                }
                                if (i6 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    i7 = i4;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i7 = i4;
                                }
                                z3 = z2;
                                iconButtonColors2 = iconButtonColorsM17192iconButtonColorsro_MJ88;
                                modifier3 = modifier5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                i7 = i4;
                                iconButtonColors2 = iconButtonColorsM17192iconButtonColorsro_MJ88;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                z3 = z2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1142896114, i7, -1, "androidx.compose.material3.IconButton (IconButton.kt:72)");
                            }
                            Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier3);
                            IconButtonTokens iconButtonTokens = IconButtonTokens.INSTANCE;
                            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(modifierMinimumTouchTargetSize, iconButtonTokens.m17712getStateLayerSizeD9Ej5fM());
                            int i11 = (i7 >> 6) & 126;
                            z4 = z3;
                            composer2 = composerStartRestartGroup;
                            Modifier modifierM15440clickableO2vRcR0$default = ClickableKt.m15440clickableO2vRcR0$default(BackgroundKt.m15409backgroundbw27NRU$default(modifierM15899size3ABfNKs, iconButtonColors2.containerColor$material3_release(z3, composerStartRestartGroup, i11).getValue().m18535unboximpl(), null, 2, null), mutableInteractionSource3, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(iconButtonTokens.m17712getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
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
                            composer2.startReplaceableGroup(1428615496);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(iconButtonColors2.contentColor$material3_release(z4, composer2, i11).getValue().m18535unboximpl()))}, content, composer2, ((i7 >> 12) & 112) | 8);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            iconButtonColors3 = iconButtonColors2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.IconButton.3
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

                            public final void invoke(@Nullable Composer composer3, int i12) {
                                IconButtonKt.IconButton(onClick, modifier4, z4, iconButtonColors3, mutableInteractionSource4, content, composer3, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i8;
                    if ((374491 & i4) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if (i6 == 0) {
                            }
                            z3 = z2;
                            iconButtonColors2 = iconButtonColorsM17192iconButtonColorsro_MJ88;
                            modifier3 = modifier5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Modifier modifierMinimumTouchTargetSize2 = TouchTargetKt.minimumTouchTargetSize(modifier3);
                            IconButtonTokens iconButtonTokens2 = IconButtonTokens.INSTANCE;
                            Modifier modifierM15899size3ABfNKs2 = SizeKt.m15899size3ABfNKs(modifierMinimumTouchTargetSize2, iconButtonTokens2.m17712getStateLayerSizeD9Ej5fM());
                            int i112 = (i7 >> 6) & 126;
                            z4 = z3;
                            composer2 = composerStartRestartGroup;
                            Modifier modifierM15440clickableO2vRcR0$default2 = ClickableKt.m15440clickableO2vRcR0$default(BackgroundKt.m15409backgroundbw27NRU$default(modifierM15899size3ABfNKs2, iconButtonColors2.containerColor$material3_release(z3, composerStartRestartGroup, i112).getValue().m18535unboximpl(), null, 2, null), mutableInteractionSource3, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(iconButtonTokens2.m17712getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
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
                            composer2.startReplaceableGroup(1428615496);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(iconButtonColors2.contentColor$material3_release(z4, composer2, i112).getValue().m18535unboximpl()))}, content, composer2, ((i7 >> 12) & 112) | 8);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource4 = mutableInteractionSource3;
                            modifier4 = modifier3;
                            iconButtonColors3 = iconButtonColors2;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                }
                i4 |= i8;
                if ((374491 & i4) == 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
            }
            i4 |= i8;
            if ((374491 & i4) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) != 0) {
        }
        i4 |= i8;
        if ((374491 & i4) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0118  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconToggleButton(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable IconToggleButtonColors iconToggleButtonColors, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        IconToggleButtonColors iconToggleButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        IconToggleButtonColors iconToggleButtonColorsM17193iconToggleButtonColors5tl4gsc;
        int i7;
        IconToggleButtonColors iconToggleButtonColors3;
        Modifier modifier3;
        final boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(692561811);
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
            i4 |= composerStartRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
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
                    if ((i2 & 16) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconToggleButtonColors2) ? 16384 : 8192;
                        i4 |= i10;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i4 |= i10;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((458752 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if ((i2 & 64) != 0) {
                        i8 = (3670016 & i) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                        if ((2995931 & i4) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z4 = z3;
                            iconToggleButtonColors4 = iconToggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i5 == 0 ? true : z3;
                                if ((i2 & 16) == 0) {
                                    iconToggleButtonColorsM17193iconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m17193iconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i4 &= -57345;
                                } else {
                                    iconToggleButtonColorsM17193iconToggleButtonColors5tl4gsc = iconToggleButtonColors2;
                                }
                                if (i6 == 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    IconToggleButtonColors iconToggleButtonColors5 = iconToggleButtonColorsM17193iconToggleButtonColors5tl4gsc;
                                    i7 = i4;
                                    iconToggleButtonColors3 = iconToggleButtonColors5;
                                    modifier3 = modifier5;
                                    z4 = z5;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    IconToggleButtonColors iconToggleButtonColors6 = iconToggleButtonColorsM17193iconToggleButtonColors5tl4gsc;
                                    i7 = i4;
                                    iconToggleButtonColors3 = iconToggleButtonColors6;
                                    modifier3 = modifier5;
                                    z4 = z5;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                i7 = i4;
                                modifier3 = modifier2;
                                z4 = z3;
                                iconToggleButtonColors3 = iconToggleButtonColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(692561811, i7, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:132)");
                            }
                            Modifier modifierMinimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(modifier3);
                            IconButtonTokens iconButtonTokens = IconButtonTokens.INSTANCE;
                            Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(modifierMinimumTouchTargetSize, iconButtonTokens.m17712getStateLayerSizeD9Ej5fM());
                            int i11 = ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 6) & 896);
                            int i12 = i7;
                            IconToggleButtonColors iconToggleButtonColors7 = iconToggleButtonColors3;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            Modifier modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(BackgroundKt.m15409backgroundbw27NRU$default(modifierM15899size3ABfNKs, iconToggleButtonColors3.containerColor$material3_release(z4, z, composerStartRestartGroup, i11).getValue().m18535unboximpl(), null, 2, null), z, mutableInteractionSource5, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(iconButtonTokens.m17712getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m20259boximpl(Role.INSTANCE.m20267getCheckboxo7Vup1c()), onCheckedChange);
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
                            composerStartRestartGroup.startReplaceableGroup(-1952715315);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(iconToggleButtonColors7.contentColor$material3_release(z4, z, composerStartRestartGroup, i11).getValue().m18535unboximpl()))}, content, composerStartRestartGroup, ((i12 >> 15) & 112) | 8);
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
                            iconToggleButtonColors4 = iconToggleButtonColors7;
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.IconToggleButton.3
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

                            public final void invoke(@Nullable Composer composer2, int i13) {
                                IconButtonKt.IconToggleButton(z, onCheckedChange, modifier4, z4, iconToggleButtonColors4, mutableInteractionSource4, content, composer2, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i8;
                    if ((2995931 & i4) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 16) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Modifier modifierMinimumTouchTargetSize2 = TouchTargetKt.minimumTouchTargetSize(modifier3);
                            IconButtonTokens iconButtonTokens2 = IconButtonTokens.INSTANCE;
                            Modifier modifierM15899size3ABfNKs2 = SizeKt.m15899size3ABfNKs(modifierMinimumTouchTargetSize2, iconButtonTokens2.m17712getStateLayerSizeD9Ej5fM());
                            int i112 = ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 6) & 896);
                            int i122 = i7;
                            IconToggleButtonColors iconToggleButtonColors72 = iconToggleButtonColors3;
                            MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                            Modifier modifierM16110toggleableO2vRcR02 = ToggleableKt.m16110toggleableO2vRcR0(BackgroundKt.m15409backgroundbw27NRU$default(modifierM15899size3ABfNKs2, iconToggleButtonColors3.containerColor$material3_release(z4, z, composerStartRestartGroup, i112).getValue().m18535unboximpl(), null, 2, null), z, mutableInteractionSource52, RippleKt.m16977rememberRipple9IZ8Weo(false, C2256Dp.m20968constructorimpl(iconButtonTokens2.m17712getStateLayerSizeD9Ej5fM() / 2), 0L, composerStartRestartGroup, 54, 4), z4, Role.m20259boximpl(Role.INSTANCE.m20267getCheckboxo7Vup1c()), onCheckedChange);
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
                            composerStartRestartGroup.startReplaceableGroup(-1952715315);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(iconToggleButtonColors72.contentColor$material3_release(z4, z, composerStartRestartGroup, i112).getValue().m18535unboximpl()))}, content, composerStartRestartGroup, ((i122 >> 15) & 112) | 8);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource4 = mutableInteractionSource52;
                            iconToggleButtonColors4 = iconToggleButtonColors72;
                            modifier4 = modifier3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) != 0) {
                }
                i4 |= i8;
                if ((2995931 & i4) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) != 0) {
            }
            i4 |= i8;
            if ((2995931 & i4) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) != 0) {
        }
        i4 |= i8;
        if ((2995931 & i4) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x024f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedIconButton(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, @Nullable IconButtonColors iconButtonColors, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        Shape shape2;
        IconButtonColors iconButtonColors2;
        BorderStroke borderStroke2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Shape outlinedShape;
        boolean z3;
        Composer composer2;
        boolean z4;
        IconButtonColors iconButtonColorsM17194outlinedIconButtonColorsro_MJ88;
        BorderStroke borderStrokeOutlinedIconButtonBorder;
        MutableInteractionSource mutableInteractionSource3;
        IconButtonColors iconButtonColors3;
        BorderStroke borderStroke3;
        Shape shape3;
        Composer composer3;
        final Shape shape4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final IconButtonColors iconButtonColors4;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1746603025);
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
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i9 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i4 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconButtonColors2) ? 16384 : 8192;
                        i4 |= i10;
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i4 |= i10;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        borderStroke2 = borderStroke;
                        int i11 = composerStartRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                        i4 |= i11;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i4 |= i11;
                } else {
                    borderStroke2 = borderStroke;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else {
                    if ((3670016 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        i7 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z5 = z2;
                            shape4 = shape2;
                            iconButtonColors4 = iconButtonColors2;
                            borderStroke4 = borderStroke2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer3 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) == 0) {
                                    i4 &= -7169;
                                    outlinedShape = IconButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                } else {
                                    outlinedShape = shape2;
                                }
                                int i12 = i4;
                                if ((i2 & 16) == 0) {
                                    composer2 = composerStartRestartGroup;
                                    z3 = z2;
                                    z4 = true;
                                    iconButtonColorsM17194outlinedIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m17194outlinedIconButtonColorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                    i12 &= -57345;
                                } else {
                                    z3 = z2;
                                    composer2 = composerStartRestartGroup;
                                    z4 = true;
                                    iconButtonColorsM17194outlinedIconButtonColorsro_MJ88 = iconButtonColors2;
                                }
                                if ((i2 & 32) == 0) {
                                    borderStrokeOutlinedIconButtonBorder = IconButtonDefaults.INSTANCE.outlinedIconButtonBorder(z3, composer2, ((i12 >> 6) & 14) | 48);
                                    i12 &= -458753;
                                } else {
                                    borderStrokeOutlinedIconButtonBorder = borderStroke;
                                }
                                if (i6 == 0) {
                                    composer2.startReplaceableGroup(-492369756);
                                    Object objRememberedValue = composer2.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(objRememberedValue);
                                    }
                                    composer2.endReplaceableGroup();
                                    z2 = z3;
                                    iconButtonColors3 = iconButtonColorsM17194outlinedIconButtonColorsro_MJ88;
                                    borderStroke3 = borderStrokeOutlinedIconButtonBorder;
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    shape3 = outlinedShape;
                                    i4 = i12;
                                    modifier2 = modifier4;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    z2 = z3;
                                    modifier2 = modifier4;
                                    iconButtonColors3 = iconButtonColorsM17194outlinedIconButtonColorsro_MJ88;
                                    borderStroke3 = borderStrokeOutlinedIconButtonBorder;
                                    shape3 = outlinedShape;
                                    i4 = i12;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                shape3 = shape2;
                                iconButtonColors3 = iconButtonColors2;
                                borderStroke3 = borderStroke2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                z4 = true;
                                composer2 = composerStartRestartGroup;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1746603025, i4, -1, "androidx.compose.material3.OutlinedIconButton (IconButton.kt:444)");
                            }
                            int i13 = ((i4 >> 6) & 14) | ((i4 >> 9) & 112);
                            long jM18535unboximpl = iconButtonColors3.containerColor$material3_release(z2, composer2, i13).getValue().m18535unboximpl();
                            long jM18535unboximpl2 = iconButtonColors3.contentColor$material3_release(z2, composer2, i13).getValue().m18535unboximpl();
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 582332538, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer4, int i14) {
                                    if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(582332538, i14, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:462)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m17777getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i15 = i4;
                                    composer4.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer4.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    composer4.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer4);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                    composer4.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer4.startReplaceableGroup(-1497510528);
                                    if (AbstractC1038a.m1199D(composer4, (i15 >> 21) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i14 = i4 & 8190;
                            int i15 = i4 << 9;
                            Modifier modifier5 = modifier2;
                            Composer composer4 = composer2;
                            boolean z6 = z2;
                            IconButtonColors iconButtonColors5 = iconButtonColors3;
                            SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier5, z6, shape3, jM18535unboximpl, jM18535unboximpl2, 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, composableLambda, composer4, i14 | (234881024 & i15) | (i15 & 1879048192), 6, 192);
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconButtonColors4 = iconButtonColors5;
                            z5 = z6;
                            modifier3 = modifier5;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconButton.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer5, int i16) {
                                IconButtonKt.OutlinedIconButton(onClick, modifier3, z5, shape4, iconButtonColors4, borderStroke4, mutableInteractionSource4, content, composer5, i | 1, i2);
                            }
                        });
                        return;
                    }
                    i4 |= i7;
                    if ((23967451 & i4) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 8) == 0) {
                            }
                            int i122 = i4;
                            if ((i2 & 16) == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i132 = ((i4 >> 6) & 14) | ((i4 >> 9) & 112);
                            long jM18535unboximpl3 = iconButtonColors3.containerColor$material3_release(z2, composer2, i132).getValue().m18535unboximpl();
                            long jM18535unboximpl22 = iconButtonColors3.contentColor$material3_release(z2, composer2, i132).getValue().m18535unboximpl();
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, 582332538, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconButton.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer42, Integer num) {
                                    invoke(composer42, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer42, int i142) {
                                    if ((i142 & 11) == 2 && composer42.getSkipping()) {
                                        composer42.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(582332538, i142, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:462)");
                                    }
                                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m17777getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i152 = i4;
                                    composer42.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer42, 6);
                                    Density density = (Density) AbstractC1038a.m1211l(composer42, -1323940314);
                                    LayoutDirection layoutDirection = (LayoutDirection) composer42.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer42.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                    if (composer42.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer42.startReusableNode();
                                    if (composer42.getInserting()) {
                                        composer42.createNode(constructor);
                                    } else {
                                        composer42.useNode();
                                    }
                                    composer42.disableReusing();
                                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer42);
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer42, composer42), composer42, 2058660585);
                                    composer42.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer42.startReplaceableGroup(-1497510528);
                                    if (AbstractC1038a.m1199D(composer42, (i152 >> 21) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            int i142 = i4 & 8190;
                            int i152 = i4 << 9;
                            Modifier modifier52 = modifier2;
                            Composer composer42 = composer2;
                            boolean z62 = z2;
                            IconButtonColors iconButtonColors52 = iconButtonColors3;
                            SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier52, z62, shape3, jM18535unboximpl3, jM18535unboximpl22, 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, composableLambda2, composer42, i142 | (234881024 & i152) | (i152 & 1879048192), 6, 192);
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconButtonColors4 = iconButtonColors52;
                            z5 = z62;
                            modifier3 = modifier52;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                i4 |= i7;
                if ((23967451 & i4) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            i4 |= i7;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((458752 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        i4 |= i7;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0286 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedIconToggleButton(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, @Nullable IconToggleButtonColors iconToggleButtonColors, @Nullable BorderStroke borderStroke, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        final int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape shape2;
        IconToggleButtonColors iconToggleButtonColors2;
        BorderStroke borderStroke2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        Shape outlinedShape;
        boolean z4;
        int i7;
        IconToggleButtonColors iconToggleButtonColorsM17195outlinedIconToggleButtonColors5tl4gsc;
        BorderStroke borderStrokeOutlinedIconToggleButtonBorder;
        int i8;
        MutableInteractionSource mutableInteractionSource3;
        IconToggleButtonColors iconToggleButtonColors3;
        BorderStroke borderStroke3;
        Shape shape3;
        final Shape shape4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors4;
        final boolean z5;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1470292106);
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
            i4 |= composerStartRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
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
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i4 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        int i12 = composerStartRestartGroup.changed(iconToggleButtonColors2) ? 131072 : 65536;
                        i4 |= i12;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i4 |= i12;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        borderStroke2 = borderStroke;
                        int i13 = composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        i4 |= i13;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i4 |= i13;
                } else {
                    borderStroke2 = borderStroke;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i4 |= 12582912;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 29360128) == 0) {
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                    }
                }
                if ((i2 & 256) == 0) {
                    i9 = (234881024 & i) == 0 ? composerStartRestartGroup.changed(content) ? 67108864 : 33554432 : 100663296;
                    if ((191739611 & i4) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) == 0) {
                                i4 &= -57345;
                                outlinedShape = IconButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                            } else {
                                outlinedShape = shape2;
                            }
                            int i14 = i4;
                            if ((i2 & 32) == 0) {
                                i7 = i6;
                                z4 = z3;
                                iconToggleButtonColorsM17195outlinedIconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m17195outlinedIconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i14 &= -458753;
                            } else {
                                z4 = z3;
                                i7 = i6;
                                iconToggleButtonColorsM17195outlinedIconToggleButtonColors5tl4gsc = iconToggleButtonColors2;
                            }
                            if ((i2 & 64) == 0) {
                                borderStrokeOutlinedIconToggleButtonBorder = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonBorder(z4, z, composerStartRestartGroup, ((i14 >> 9) & 14) | 384 | ((i14 << 3) & 112));
                                i8 = i14 & (-3670017);
                            } else {
                                borderStrokeOutlinedIconToggleButtonBorder = borderStroke;
                                i8 = i14;
                            }
                            if (i7 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            iconToggleButtonColors3 = iconToggleButtonColorsM17195outlinedIconToggleButtonColors5tl4gsc;
                            borderStroke3 = borderStrokeOutlinedIconToggleButtonBorder;
                            i4 = i8;
                            shape3 = outlinedShape;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            IconToggleButtonColors iconToggleButtonColors5 = iconToggleButtonColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            iconToggleButtonColors3 = iconToggleButtonColors5;
                            modifier3 = modifier2;
                            z4 = z3;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1470292106, i4, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:505)");
                        }
                        int i15 = i4 >> 9;
                        int i16 = (i15 & 896) | (i15 & 14) | ((i4 << 3) & 112);
                        IconToggleButtonColors iconToggleButtonColors6 = iconToggleButtonColors3;
                        Modifier modifier5 = modifier3;
                        SurfaceKt.m17327Surfaced85dljk(z, onCheckedChange, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                            }
                        }, 1, null), z4, shape3, iconToggleButtonColors3.containerColor$material3_release(z4, z, composerStartRestartGroup, i16).getValue().m18535unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z4, z, composerStartRestartGroup, i16).getValue().m18535unboximpl(), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.3
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

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer2, int i17) {
                                if ((i17 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1207657396, i17, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:525)");
                                }
                                Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m17777getContainerSizeD9Ej5fM());
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function2 = content;
                                int i18 = i4;
                                composer2.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(392741306);
                                if (AbstractC1038a.m1199D(composer2, (i18 >> 24) & 14, function2)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (64638 & i4) | ((i4 << 9) & 1879048192), ((i4 >> 21) & 14) | 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        iconToggleButtonColors4 = iconToggleButtonColors6;
                        z5 = z4;
                        modifier4 = modifier5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z3;
                        iconToggleButtonColors4 = iconToggleButtonColors2;
                        borderStroke4 = borderStroke2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        shape4 = shape2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.4
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

                        public final void invoke(@Nullable Composer composer2, int i17) {
                            IconButtonKt.OutlinedIconToggleButton(z, onCheckedChange, modifier4, z5, shape4, iconToggleButtonColors4, borderStroke4, mutableInteractionSource4, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i9;
                if ((191739611 & i4) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        int i142 = i4;
                        if ((i2 & 32) == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if (i7 != 0) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        iconToggleButtonColors3 = iconToggleButtonColorsM17195outlinedIconToggleButtonColors5tl4gsc;
                        borderStroke3 = borderStrokeOutlinedIconToggleButtonBorder;
                        i4 = i8;
                        shape3 = outlinedShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i152 = i4 >> 9;
                        int i162 = (i152 & 896) | (i152 & 14) | ((i4 << 3) & 112);
                        IconToggleButtonColors iconToggleButtonColors62 = iconToggleButtonColors3;
                        Modifier modifier52 = modifier3;
                        SurfaceKt.m17327Surfaced85dljk(z, onCheckedChange, SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.m20285setRolekuIjeqM(semantics, Role.INSTANCE.m20267getCheckboxo7Vup1c());
                            }
                        }, 1, null), z4, shape3, iconToggleButtonColors3.containerColor$material3_release(z4, z, composerStartRestartGroup, i162).getValue().m18535unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z4, z, composerStartRestartGroup, i162).getValue().m18535unboximpl(), 0.0f, 0.0f, borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt.OutlinedIconToggleButton.3
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

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer2, int i17) {
                                if ((i17 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1207657396, i17, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:525)");
                                }
                                Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m17777getContainerSizeD9Ej5fM());
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function2 = content;
                                int i18 = i4;
                                composer2.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                composer2.disableReusing();
                                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(392741306);
                                if (AbstractC1038a.m1199D(composer2, (i18 >> 24) & 14, function2)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (64638 & i4) | ((i4 << 9) & 1879048192), ((i4 >> 21) & 14) | 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        iconToggleButtonColors4 = iconToggleButtonColors62;
                        z5 = z4;
                        modifier4 = modifier52;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            if ((57344 & i) == 0) {
            }
            if ((458752 & i) == 0) {
            }
            if ((3670016 & i) == 0) {
            }
            i6 = i2 & 128;
            if (i6 != 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i4 |= i9;
            if ((191739611 & i4) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
        if ((3670016 & i) == 0) {
        }
        i6 = i2 & 128;
        if (i6 != 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i4 |= i9;
        if ((191739611 & i4) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
