package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.text.TextStyle;
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
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
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
@Metadata(m13885d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u001a}\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008f\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ar\u0010&\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001ar\u0010)\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u001ar\u0010+\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m13886d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", TokenizerME.NO_SPLIT, "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class FloatingActionButtonKt {

    @NotNull
    private static final ExitTransition ExtendedFabCollapseAnimation;

    @NotNull
    private static final EnterTransition ExtendedFabExpandAnimation;
    private static final float ExtendedFabStartIconPadding = C2256Dp.m20968constructorimpl(16);
    private static final float ExtendedFabEndIconPadding = C2256Dp.m20968constructorimpl(12);
    private static final float ExtendedFabTextPadding = C2256Dp.m20968constructorimpl(20);
    private static final float ExtendedFabMinimumWidth = C2256Dp.m20968constructorimpl(80);

    static {
        MotionTokens motionTokens = MotionTokens.INSTANCE;
        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, motionTokens.getEasingLinearCubicBezier(), 2, null), 0.0f, 2, null);
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(500, 0, motionTokens.getEasingEmphasizedCubicBezier(), 2, null);
        Alignment.Companion companion = Alignment.INSTANCE;
        ExtendedFabCollapseAnimation = exitTransitionFadeOut$default.plus(EnterExitTransitionKt.shrinkHorizontally$default(tweenSpecTween$default, companion.getStart(), false, null, 12, null));
        ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, motionTokens.getEasingLinearCubicBezier()), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(500, 0, motionTokens.getEasingEmphasizedCubicBezier(), 2, null), companion.getStart(), false, null, 12, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0294 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0126  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17183ExtendedFloatingActionButtonElI57k(@NotNull final Function2<? super Composer, ? super Integer, Unit> text, @NotNull final Function2<? super Composer, ? super Integer, Unit> icon, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        Shape shape2;
        int i6;
        long j3;
        int i7;
        int i8;
        long jM17098contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i9;
        final boolean z2;
        Shape extendedFabShape;
        long containerColor;
        FloatingActionButtonElevation floatingActionButtonElevationM17180elevationxZ9QkE;
        Shape shape3;
        long j5;
        long j6;
        MutableInteractionSource mutableInteractionSource2;
        final int i10;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource3;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        final long j7;
        final long j8;
        final Shape shape4;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1387401842);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(icon) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 != 0) {
                if ((i & 57344) == 0) {
                    i4 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
                }
                if ((i & 458752) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        int i12 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                        i4 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 3670016) == 0) {
                    i6 = 57344;
                    j3 = j;
                    i4 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j3)) ? 1048576 : 524288;
                } else {
                    i6 = 57344;
                    j3 = j;
                }
                if ((i & 29360128) == 0) {
                    i8 = 458752;
                    jM17098contentColorForek8zF_U = j2;
                    i7 = i4 | (((i2 & 128) == 0 && composerStartRestartGroup.changed(jM17098contentColorForek8zF_U)) ? 8388608 : 4194304);
                } else {
                    i7 = i4;
                    i8 = 458752;
                    jM17098contentColorForek8zF_U = j2;
                }
                if ((i & 234881024) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        int i13 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 67108864 : 33554432;
                        i7 |= i13;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i7 |= i13;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i9 = i2 & 512;
                if (i9 != 0) {
                    i7 |= DriveFile.MODE_READ_WRITE;
                } else if ((i & 1879048192) == 0) {
                    i7 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                }
                if ((i7 & 1533916891) == 306783378 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j8 = j3;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                    mutableInteractionSource3 = mutableInteractionSource;
                    j7 = jM17098contentColorForek8zF_U;
                    shape4 = shape2;
                    z3 = z;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        z2 = i5 == 0 ? true : z;
                        if ((i2 & 32) == 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i7 &= -458753;
                        } else {
                            extendedFabShape = shape2;
                        }
                        if ((i2 & 64) == 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i7 >> 18) & 14);
                            i7 &= -29360129;
                        }
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevationM17180elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m17180elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i7 &= -234881025;
                        } else {
                            floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        if (i9 == 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            long j9 = jM17098contentColorForek8zF_U;
                            shape3 = extendedFabShape;
                            j5 = containerColor;
                            j6 = j9;
                        } else {
                            long j10 = jM17098contentColorForek8zF_U;
                            shape3 = extendedFabShape;
                            j5 = containerColor;
                            j6 = j10;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        i10 = i7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 32) != 0) {
                            i7 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i7 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i7 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i7 &= -234881025;
                        }
                        j6 = jM17098contentColorForek8zF_U;
                        j5 = j3;
                        z2 = z;
                        floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation2;
                        shape3 = shape2;
                        i10 = i7;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1387401842, i10, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:335)");
                    }
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
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
                        public final void invoke(@Nullable Composer composer2, int i14) {
                            if ((i14 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1172118032, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:355)");
                            }
                            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, z2 ? FloatingActionButtonKt.ExtendedFabMinimumWidth : FabPrimaryTokens.INSTANCE.m17632getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), z2 ? FloatingActionButtonKt.ExtendedFabStartIconPadding : C2256Dp.m20968constructorimpl(0), 0.0f, z2 ? FloatingActionButtonKt.ExtendedFabTextPadding : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.Horizontal start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function2 = icon;
                            final int i15 = i10;
                            boolean z4 = z2;
                            final Function2<Composer, Integer, Unit> function22 = text;
                            composer2.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1368928116);
                            function2.invoke(composer2, Integer.valueOf((i15 >> 3) & 14));
                            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z4, (Modifier) null, FloatingActionButtonKt.ExtendedFabExpandAnimation, FloatingActionButtonKt.ExtendedFabCollapseAnimation, (String) null, ComposableLambdaKt.composableLambda(composer2, 176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                    invoke(animatedVisibilityScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer3, int i16) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(176242764, i16, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:374)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
                                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function23 = function22;
                                    int i17 = i15;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(Alignment.INSTANCE, Arrangement.INSTANCE.getStart(), composer3, 0, -1323940314);
                                    Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierClearAndSetSemantics);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-141102928);
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion2, FloatingActionButtonKt.ExtendedFabEndIconPadding), composer3, 6);
                                    if (AbstractC1038a.m1199D(composer3, i17 & 14, function23)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 1600518 | ((i15 >> 9) & 112), 18);
                            if (AbstractC1038a.m1225z(composer2)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i14 = i10 >> 6;
                    int i15 = i10 >> 9;
                    int i16 = (i15 & 3670016) | (i14 & 112) | (i14 & 14) | 12582912 | (i15 & 896) | (i15 & 7168) | (i15 & i6) | (i15 & i8);
                    modifier3 = modifier2;
                    long j11 = j6;
                    FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM17180elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    m17185FloatingActionButtonXz6DiA(onClick, modifier3, shape3, j5, j11, floatingActionButtonElevation4, mutableInteractionSource4, composableLambda, composerStartRestartGroup, i16, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource4;
                    floatingActionButtonElevation3 = floatingActionButtonElevation4;
                    j7 = j11;
                    j8 = j5;
                    shape4 = shape3;
                    z3 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$6
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
                        FloatingActionButtonKt.m17183ExtendedFloatingActionButtonElI57k(text, icon, onClick, modifier3, z3, shape4, j8, j7, floatingActionButtonElevation3, mutableInteractionSource3, composer2, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= 24576;
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            i9 = i2 & 512;
            if (i9 != 0) {
            }
            if ((i7 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) == 0) {
                    }
                    if (i9 == 0) {
                    }
                    i10 = i7;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
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
                        public final void invoke(@Nullable Composer composer2, int i142) {
                            if ((i142 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1172118032, i142, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:355)");
                            }
                            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, z2 ? FloatingActionButtonKt.ExtendedFabMinimumWidth : FabPrimaryTokens.INSTANCE.m17632getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), z2 ? FloatingActionButtonKt.ExtendedFabStartIconPadding : C2256Dp.m20968constructorimpl(0), 0.0f, z2 ? FloatingActionButtonKt.ExtendedFabTextPadding : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.Horizontal start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function2 = icon;
                            final int i152 = i10;
                            boolean z4 = z2;
                            final Function2<? super Composer, ? super Integer, Unit> function22 = text;
                            composer2.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                            Density density = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, density));
                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                            composer2.startReplaceableGroup(-678309503);
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(1368928116);
                            function2.invoke(composer2, Integer.valueOf((i152 >> 3) & 14));
                            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z4, (Modifier) null, FloatingActionButtonKt.ExtendedFabExpandAnimation, FloatingActionButtonKt.ExtendedFabCollapseAnimation, (String) null, ComposableLambdaKt.composableLambda(composer2, 176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                    invoke(animatedVisibilityScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer3, int i162) {
                                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(176242764, i162, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:374)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1.1
                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
                                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function23 = function22;
                                    int i17 = i152;
                                    composer3.startReplaceableGroup(693286680);
                                    MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(Alignment.INSTANCE, Arrangement.INSTANCE.getStart(), composer3, 0, -1323940314);
                                    Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierClearAndSetSemantics);
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    composer3.disableReusing();
                                    Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-141102928);
                                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion2, FloatingActionButtonKt.ExtendedFabEndIconPadding), composer3, 6);
                                    if (AbstractC1038a.m1199D(composer3, i17 & 14, function23)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 1600518 | ((i152 >> 9) & 112), 18);
                            if (AbstractC1038a.m1225z(composer2)) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i142 = i10 >> 6;
                    int i152 = i10 >> 9;
                    int i162 = (i152 & 3670016) | (i142 & 112) | (i142 & 14) | 12582912 | (i152 & 896) | (i152 & 7168) | (i152 & i6) | (i152 & i8);
                    modifier3 = modifier2;
                    long j112 = j6;
                    FloatingActionButtonElevation floatingActionButtonElevation42 = floatingActionButtonElevationM17180elevationxZ9QkE;
                    MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                    m17185FloatingActionButtonXz6DiA(onClick, modifier3, shape3, j5, j112, floatingActionButtonElevation42, mutableInteractionSource42, composableLambda2, composerStartRestartGroup, i162, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource42;
                    floatingActionButtonElevation3 = floatingActionButtonElevation42;
                    j7 = j112;
                    j8 = j5;
                    shape4 = shape3;
                    z3 = z2;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        i9 = i2 & 512;
        if (i9 != 0) {
        }
        if ((i7 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0232 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0115  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17184ExtendedFloatingActionButtonXz6DiA(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        Shape shape2;
        long j3;
        long j5;
        FloatingActionButtonElevation floatingActionButtonElevationM17180elevationxZ9QkE;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Shape extendedFabShape;
        int i7;
        long containerColor;
        long j6;
        int i8;
        Modifier modifier3;
        final int i9;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        MutableInteractionSource mutableInteractionSource3;
        long j7;
        Shape shape3;
        long j8;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource4;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        final long j9;
        final long j10;
        final Shape shape4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-326283107);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i11 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i4 |= i11;
                } else {
                    shape2 = shape;
                }
                i4 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 7168) != 0) {
                j3 = j;
                i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 57344) != 0) {
                j5 = j2;
                i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j5)) ? 16384 : 8192;
            } else {
                j5 = j2;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
                    int i12 = composerStartRestartGroup.changed(floatingActionButtonElevationM17180elevationxZ9QkE) ? 131072 : 65536;
                    i4 |= i12;
                } else {
                    floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
                }
                i4 |= i12;
            } else {
                floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i4 |= 1572864;
                i6 = 57344;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                i6 = 57344;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 3670016) == 0) {
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                }
            }
            if ((i2 & 128) == 0) {
                i4 |= 12582912;
            } else if ((29360128 & i) == 0) {
                i4 |= composerStartRestartGroup.changed(content) ? 8388608 : 4194304;
            }
            if ((23967451 & i4) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier modifier5 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) == 0) {
                        i4 &= -897;
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    } else {
                        extendedFabShape = shape2;
                    }
                    if ((i2 & 8) == 0) {
                        i7 = i4 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i7 = i4;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i7 >> 9) & 14);
                        i7 &= -57345;
                        j5 = jM17098contentColorForek8zF_U;
                    }
                    int i13 = i7;
                    if ((i2 & 32) == 0) {
                        j6 = containerColor;
                        floatingActionButtonElevationM17180elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m17180elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 = i13 & (-458753);
                    } else {
                        j6 = containerColor;
                        i8 = i13;
                    }
                    if (i5 == 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        i9 = i8;
                        shape3 = extendedFabShape;
                        j8 = j6;
                        modifier3 = modifier5;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM17180elevationxZ9QkE;
                    } else {
                        modifier3 = modifier5;
                        i9 = i8;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM17180elevationxZ9QkE;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j7 = j5;
                        shape3 = extendedFabShape;
                        j8 = j6;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-326283107, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:268)");
                        }
                        FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevation2;
                        m17185FloatingActionButtonXz6DiA(onClick, modifier3, shape3, j8, j7, floatingActionButtonElevation4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 398457247, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                                    ComposerKt.traceEventStart(398457247, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:286)");
                                }
                                Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabMinimumWidth, 0.0f, 0.0f, 0.0f, 14, null), FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 2, null);
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function3 = content;
                                int i15 = ((i9 >> 12) & 7168) | 438;
                                composer3.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer3, 54);
                                Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
                                function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, (i9 & 14) | 12582912 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (i9 & i6) | (i9 & 458752) | (i9 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        floatingActionButtonElevation3 = floatingActionButtonElevation4;
                        j9 = j7;
                        j10 = j8;
                        shape4 = shape3;
                        modifier4 = modifier3;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i4 &= -458753;
                    }
                    modifier3 = modifier2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM17180elevationxZ9QkE;
                    j8 = j3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    i9 = i4;
                    shape3 = shape2;
                }
                j7 = j5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                FloatingActionButtonElevation floatingActionButtonElevation42 = floatingActionButtonElevation2;
                m17185FloatingActionButtonXz6DiA(onClick, modifier3, shape3, j8, j7, floatingActionButtonElevation42, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 398457247, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                            ComposerKt.traceEventStart(398457247, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:286)");
                        }
                        Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.m15903sizeInqDBjuR0$default(Modifier.INSTANCE, FloatingActionButtonKt.ExtendedFabMinimumWidth, 0.0f, 0.0f, 0.0f, 14, null), FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 2, null);
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function3 = content;
                        int i15 = ((i9 >> 12) & 7168) | 438;
                        composer3.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer3, 54);
                        Density density = (Density) AbstractC1038a.m1211l(composer3, -1323940314);
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15856paddingVpY3zN4$default);
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
                        function3.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(((i15 >> 6) & 112) | 6));
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composerStartRestartGroup, (i9 & 14) | 12582912 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (i9 & i6) | (i9 & 458752) | (i9 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = composerStartRestartGroup;
                mutableInteractionSource4 = mutableInteractionSource3;
                floatingActionButtonElevation3 = floatingActionButtonElevation42;
                j9 = j7;
                j10 = j8;
                shape4 = shape3;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                shape4 = shape2;
                j10 = j3;
                mutableInteractionSource4 = mutableInteractionSource2;
                floatingActionButtonElevation3 = floatingActionButtonElevationM17180elevationxZ9QkE;
                composer2 = composerStartRestartGroup;
                j9 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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

                public final void invoke(@Nullable Composer composer3, int i14) {
                    FloatingActionButtonKt.m17184ExtendedFloatingActionButtonXz6DiA(onClick, modifier4, shape4, j10, j9, floatingActionButtonElevation3, mutableInteractionSource4, content, composer3, i | 1, i2);
                }
            });
            return;
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((23967451 & i4) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 == 0) {
                }
                if ((i2 & 4) == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i132 = i7;
                if ((i2 & 32) == 0) {
                }
                if (i5 == 0) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0113  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17185FloatingActionButtonXz6DiA(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        Shape shape2;
        long j3;
        final long j5;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i7;
        long containerColor;
        long j6;
        FloatingActionButtonElevation floatingActionButtonElevationM17180elevationxZ9QkE;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        final int i8;
        final Shape shape4;
        final long j7;
        final long j8;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource4;
        final FloatingActionButtonElevation floatingActionButtonElevation4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-731723913);
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
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i11 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i4 |= i11;
                } else {
                    shape2 = shape;
                }
                i4 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 7168) != 0) {
                j3 = j;
                i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 57344) != 0) {
                j5 = j2;
                i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(j5)) ? 16384 : 8192;
            } else {
                j5 = j2;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    int i12 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 131072 : 65536;
                    i4 |= i12;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i4 |= i12;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i4 |= 1572864;
                i6 = 57344;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                i6 = 57344;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 3670016) == 0) {
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                }
            }
            if ((i2 & 128) != 0) {
                i9 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                if ((23967451 & i4) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape4 = shape2;
                    floatingActionButtonElevation4 = floatingActionButtonElevation2;
                    j7 = j3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    j8 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) == 0) {
                            i4 &= -897;
                            shape3 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 8) == 0) {
                            i7 = i4 & (-7169);
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            i7 = i4;
                            containerColor = j3;
                        }
                        if ((i2 & 16) != 0) {
                            long jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i7 >> 9) & 14);
                            i7 &= -57345;
                            j5 = jM17098contentColorForek8zF_U;
                        }
                        int i13 = i7;
                        if ((i2 & 32) == 0) {
                            j6 = containerColor;
                            floatingActionButtonElevationM17180elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m17180elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i13 &= -458753;
                        } else {
                            j6 = containerColor;
                            floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        if (i5 == 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            modifier2 = modifier4;
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM17180elevationxZ9QkE;
                        } else {
                            modifier2 = modifier4;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM17180elevationxZ9QkE;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        i8 = i13;
                        shape4 = shape3;
                        j7 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i4 &= -458753;
                        }
                        i8 = i4;
                        shape4 = shape2;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        j7 = j3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-731723913, i8, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:93)");
                    }
                    int i14 = ((i8 >> 18) & 14) | ((i8 >> 12) & 112);
                    float fM20982unboximpl = floatingActionButtonElevation3.tonalElevation$material3_release(mutableInteractionSource3, composerStartRestartGroup, i14).getValue().m20982unboximpl();
                    float fM20982unboximpl2 = floatingActionButtonElevation3.shadowElevation$material3_release(mutableInteractionSource3, composerStartRestartGroup, i14).getValue().m20982unboximpl();
                    FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevation3;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
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
                                ComposerKt.traceEventStart(1249316354, i15, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:112)");
                            }
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j5))};
                            final Function2<Composer, Integer, Unit> function2 = content;
                            final int i16 = i8;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -945978686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                public final void invoke(@Nullable Composer composer3, int i17) {
                                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-945978686, i17, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:113)");
                                    }
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont());
                                    final Function2<Composer, Integer, Unit> function22 = function2;
                                    final int i18 = i16;
                                    TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer3, 167946739, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                        public final void invoke(@Nullable Composer composer4, int i19) {
                                            if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(167946739, i19, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:120)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            FabPrimaryTokens fabPrimaryTokens = FabPrimaryTokens.INSTANCE;
                                            Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(companion, fabPrimaryTokens.m17632getContainerWidthD9Ej5fM(), fabPrimaryTokens.m17631getContainerHeightD9Ej5fM());
                                            Alignment center = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function23 = function22;
                                            int i20 = i18;
                                            composer4.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                            Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15883defaultMinSizeVpY3zN4);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer4.startReplaceableGroup(595057145);
                                            if (AbstractC1038a.m1199D(composer4, (i20 >> 21) & 14, function23)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i15 = i8 << 3;
                    int i16 = (i8 & 126) | (i15 & 7168) | (i15 & i6) | (i15 & 458752) | ((i8 << 9) & 1879048192);
                    Modifier modifier5 = modifier2;
                    j8 = j5;
                    SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier5, false, shape4, j7, j8, fM20982unboximpl, fM20982unboximpl2, null, mutableInteractionSource3, composableLambda, composerStartRestartGroup, i16, 6, 260);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    floatingActionButtonElevation4 = floatingActionButtonElevation5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
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
                        FloatingActionButtonKt.m17185FloatingActionButtonXz6DiA(onClick, modifier3, shape4, j7, j8, floatingActionButtonElevation4, mutableInteractionSource4, content, composer2, i | 1, i2);
                    }
                });
                return;
            }
            i4 |= i9;
            if ((23967451 & i4) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 == 0) {
                    }
                    if ((i2 & 4) == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    int i132 = i7;
                    if ((i2 & 32) == 0) {
                    }
                    if (i5 == 0) {
                    }
                    i8 = i132;
                    shape4 = shape3;
                    j7 = j6;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i142 = ((i8 >> 18) & 14) | ((i8 >> 12) & 112);
                    float fM20982unboximpl3 = floatingActionButtonElevation3.tonalElevation$material3_release(mutableInteractionSource3, composerStartRestartGroup, i142).getValue().m20982unboximpl();
                    float fM20982unboximpl22 = floatingActionButtonElevation3.shadowElevation$material3_release(mutableInteractionSource3, composerStartRestartGroup, i142).getValue().m20982unboximpl();
                    FloatingActionButtonElevation floatingActionButtonElevation52 = floatingActionButtonElevation3;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1249316354, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
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
                        public final void invoke(@Nullable Composer composer2, int i152) {
                            if ((i152 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1249316354, i152, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:112)");
                            }
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j5))};
                            final Function2<? super Composer, ? super Integer, Unit> function2 = content;
                            final int i162 = i8;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer2, -945978686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2.1
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
                                public final void invoke(@Nullable Composer composer3, int i17) {
                                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-945978686, i17, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:113)");
                                    }
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont());
                                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                    final int i18 = i162;
                                    TextKt.ProvideTextStyle(textStyleFromToken, ComposableLambdaKt.composableLambda(composer3, 167946739, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt.FloatingActionButton.2.1.1
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
                                        public final void invoke(@Nullable Composer composer4, int i19) {
                                            if ((i19 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(167946739, i19, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:120)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            FabPrimaryTokens fabPrimaryTokens = FabPrimaryTokens.INSTANCE;
                                            Modifier modifierM15883defaultMinSizeVpY3zN4 = SizeKt.m15883defaultMinSizeVpY3zN4(companion, fabPrimaryTokens.m17632getContainerWidthD9Ej5fM(), fabPrimaryTokens.m17631getContainerHeightD9Ej5fM());
                                            Alignment center = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function23 = function22;
                                            int i20 = i18;
                                            composer4.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                            Density density = (Density) AbstractC1038a.m1211l(composer4, -1323940314);
                                            LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15883defaultMinSizeVpY3zN4);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer4, composer4), composer4, 2058660585);
                                            composer4.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer4.startReplaceableGroup(595057145);
                                            if (AbstractC1038a.m1199D(composer4, (i20 >> 21) & 14, function23)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    int i152 = i8 << 3;
                    int i162 = (i8 & 126) | (i152 & 7168) | (i152 & i6) | (i152 & 458752) | ((i8 << 9) & 1879048192);
                    Modifier modifier52 = modifier2;
                    j8 = j5;
                    SurfaceKt.m17328Surfaceo_FOJdg(onClick, modifier52, false, shape4, j7, j8, fM20982unboximpl3, fM20982unboximpl22, null, mutableInteractionSource3, composableLambda2, composerStartRestartGroup, i162, 6, 260);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier52;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    floatingActionButtonElevation4 = floatingActionButtonElevation52;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        i4 |= i9;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0207 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17186LargeFloatingActionButtonXz6DiA(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        Shape largeShape;
        long containerColor;
        long jM17098contentColorForek8zF_U;
        final FloatingActionButtonElevation floatingActionButtonElevationM17180elevationxZ9QkE;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        final MutableInteractionSource mutableInteractionSource3;
        final long j3;
        final long j5;
        final Shape shape2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1650866856);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    largeShape = shape;
                    int i8 = composerStartRestartGroup.changed(largeShape) ? 256 : 128;
                    i4 |= i8;
                } else {
                    largeShape = shape;
                }
                i4 |= i8;
            } else {
                largeShape = shape;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    containerColor = j;
                    int i9 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                    i4 |= i9;
                } else {
                    containerColor = j;
                }
                i4 |= i9;
            } else {
                containerColor = j;
            }
            if ((57344 & i) != 0) {
                jM17098contentColorForek8zF_U = j2;
                i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM17098contentColorForek8zF_U)) ? 16384 : 8192;
            } else {
                jM17098contentColorForek8zF_U = j2;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
                    int i10 = composerStartRestartGroup.changed(floatingActionButtonElevationM17180elevationxZ9QkE) ? 131072 : 65536;
                    i4 |= i10;
                } else {
                    floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
                }
                i4 |= i10;
            } else {
                floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i4 |= 1572864;
            } else {
                if ((3670016 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                }
                if ((i2 & 128) == 0) {
                    i6 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                    if ((23967451 & i4) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                                largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 8) != 0) {
                                containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 9) & 14);
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                floatingActionButtonElevationM17180elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m17180elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i4 = (-458753) & i4;
                            }
                            if (i5 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                        }
                        int i11 = i4;
                        Shape shape3 = largeShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1650866856, i11, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:213)");
                        }
                        FabPrimaryLargeTokens fabPrimaryLargeTokens = FabPrimaryLargeTokens.INSTANCE;
                        Modifier modifier4 = modifier2;
                        long j6 = containerColor;
                        long j7 = jM17098contentColorForek8zF_U;
                        FloatingActionButtonElevation floatingActionButtonElevation2 = floatingActionButtonElevationM17180elevationxZ9QkE;
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        m17185FloatingActionButtonXz6DiA(onClick, SizeKt.m15903sizeInqDBjuR0$default(modifier4, fabPrimaryLargeTokens.m17610getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens.m17609getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape3, j6, j7, floatingActionButtonElevation2, mutableInteractionSource4, content, composerStartRestartGroup, i11 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource4;
                        floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation2;
                        j3 = j7;
                        j5 = j6;
                        shape2 = shape3;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape2 = largeShape;
                        j5 = containerColor;
                        j3 = jM17098contentColorForek8zF_U;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$2
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

                        public final void invoke(@Nullable Composer composer2, int i12) {
                            FloatingActionButtonKt.m17186LargeFloatingActionButtonXz6DiA(onClick, modifier3, shape2, j5, j3, floatingActionButtonElevationM17180elevationxZ9QkE, mutableInteractionSource3, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i6;
                if ((23967451 & i4) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if (i5 == 0) {
                        }
                        int i112 = i4;
                        Shape shape32 = largeShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        FabPrimaryLargeTokens fabPrimaryLargeTokens2 = FabPrimaryLargeTokens.INSTANCE;
                        Modifier modifier42 = modifier2;
                        long j62 = containerColor;
                        long j72 = jM17098contentColorForek8zF_U;
                        FloatingActionButtonElevation floatingActionButtonElevation22 = floatingActionButtonElevationM17180elevationxZ9QkE;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        m17185FloatingActionButtonXz6DiA(onClick, SizeKt.m15903sizeInqDBjuR0$default(modifier42, fabPrimaryLargeTokens2.m17610getContainerWidthD9Ej5fM(), fabPrimaryLargeTokens2.m17609getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape32, j62, j72, floatingActionButtonElevation22, mutableInteractionSource42, content, composerStartRestartGroup, i112 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource42;
                        floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation22;
                        j3 = j72;
                        j5 = j62;
                        shape2 = shape32;
                        modifier3 = modifier42;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) == 0) {
            }
            i4 |= i6;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) == 0) {
        }
        i4 |= i6;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0207 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m17187SmallFloatingActionButtonXz6DiA(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable FloatingActionButtonElevation floatingActionButtonElevation, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        Shape smallShape;
        long containerColor;
        long jM17098contentColorForek8zF_U;
        final FloatingActionButtonElevation floatingActionButtonElevationM17180elevationxZ9QkE;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        final MutableInteractionSource mutableInteractionSource3;
        final long j3;
        final long j5;
        final Shape shape2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1444748300);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    smallShape = shape;
                    int i8 = composerStartRestartGroup.changed(smallShape) ? 256 : 128;
                    i4 |= i8;
                } else {
                    smallShape = shape;
                }
                i4 |= i8;
            } else {
                smallShape = shape;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    containerColor = j;
                    int i9 = composerStartRestartGroup.changed(containerColor) ? 2048 : 1024;
                    i4 |= i9;
                } else {
                    containerColor = j;
                }
                i4 |= i9;
            } else {
                containerColor = j;
            }
            if ((57344 & i) != 0) {
                jM17098contentColorForek8zF_U = j2;
                i4 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM17098contentColorForek8zF_U)) ? 16384 : 8192;
            } else {
                jM17098contentColorForek8zF_U = j2;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
                    int i10 = composerStartRestartGroup.changed(floatingActionButtonElevationM17180elevationxZ9QkE) ? 131072 : 65536;
                    i4 |= i10;
                } else {
                    floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
                }
                i4 |= i10;
            } else {
                floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation;
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i4 |= 1572864;
            } else {
                if ((3670016 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                }
                if ((i2 & 128) == 0) {
                    i6 = (29360128 & i) == 0 ? composerStartRestartGroup.changed(content) ? 8388608 : 4194304 : 12582912;
                    if ((23967451 & i4) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                                smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 8) != 0) {
                                containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                jM17098contentColorForek8zF_U = ColorSchemeKt.m17098contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 9) & 14);
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                floatingActionButtonElevationM17180elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m17180elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i4 = (-458753) & i4;
                            }
                            if (i5 == 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                        }
                        int i11 = i4;
                        Shape shape3 = smallShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1444748300, i11, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:161)");
                        }
                        FabPrimarySmallTokens fabPrimarySmallTokens = FabPrimarySmallTokens.INSTANCE;
                        Modifier modifier4 = modifier2;
                        long j6 = containerColor;
                        long j7 = jM17098contentColorForek8zF_U;
                        FloatingActionButtonElevation floatingActionButtonElevation2 = floatingActionButtonElevationM17180elevationxZ9QkE;
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        m17185FloatingActionButtonXz6DiA(onClick, SizeKt.m15903sizeInqDBjuR0$default(modifier4, fabPrimarySmallTokens.m17621getContainerWidthD9Ej5fM(), fabPrimarySmallTokens.m17620getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape3, j6, j7, floatingActionButtonElevation2, mutableInteractionSource4, content, composerStartRestartGroup, i11 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource4;
                        floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation2;
                        j3 = j7;
                        j5 = j6;
                        shape2 = shape3;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape2 = smallShape;
                        j5 = containerColor;
                        j3 = jM17098contentColorForek8zF_U;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$2
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

                        public final void invoke(@Nullable Composer composer2, int i12) {
                            FloatingActionButtonKt.m17187SmallFloatingActionButtonXz6DiA(onClick, modifier3, shape2, j5, j3, floatingActionButtonElevationM17180elevationxZ9QkE, mutableInteractionSource3, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i6;
                if ((23967451 & i4) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if (i5 == 0) {
                        }
                        int i112 = i4;
                        Shape shape32 = smallShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        FabPrimarySmallTokens fabPrimarySmallTokens2 = FabPrimarySmallTokens.INSTANCE;
                        Modifier modifier42 = modifier2;
                        long j62 = containerColor;
                        long j72 = jM17098contentColorForek8zF_U;
                        FloatingActionButtonElevation floatingActionButtonElevation22 = floatingActionButtonElevationM17180elevationxZ9QkE;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        m17185FloatingActionButtonXz6DiA(onClick, SizeKt.m15903sizeInqDBjuR0$default(modifier42, fabPrimarySmallTokens2.m17621getContainerWidthD9Ej5fM(), fabPrimarySmallTokens2.m17620getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape32, j62, j72, floatingActionButtonElevation22, mutableInteractionSource42, content, composerStartRestartGroup, i112 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource42;
                        floatingActionButtonElevationM17180elevationxZ9QkE = floatingActionButtonElevation22;
                        j3 = j72;
                        j5 = j62;
                        shape2 = shape32;
                        modifier3 = modifier42;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) == 0) {
            }
            i4 |= i6;
            if ((23967451 & i4) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) == 0) {
        }
        i4 |= i6;
        if ((23967451 & i4) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
