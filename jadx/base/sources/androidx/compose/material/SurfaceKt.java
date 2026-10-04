package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.draw.ShadowKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.Shape;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.semantics.Role;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010'\u001a/\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, m13886d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0343 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012c  */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    @Composable
    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: Surface-9VG74zQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16871Surface9VG74zQ(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z, @Nullable String str, @Nullable Role role, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        Shape rectangleShape;
        long jM16680getSurface0d7_KjU;
        int i7;
        long jM16694contentColorForek8zF_U;
        int i8;
        BorderStroke borderStroke2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        Shape shape2;
        final int i20;
        String str2;
        long j3;
        final BorderStroke borderStroke3;
        final Role role2;
        final float f4;
        Modifier modifier3;
        final boolean z2;
        Shape shape3;
        final long j5;
        Composer composer2;
        final Role role3;
        final Shape shape4;
        final String str3;
        final Modifier modifier4;
        final boolean z3;
        final Indication indication3;
        final MutableInteractionSource mutableInteractionSource3;
        final float f5;
        final BorderStroke borderStroke4;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1585925488);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
        } else if ((i & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        int i21 = i4 & 2;
        if (i21 != 0) {
            i5 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i & 896) == 0) {
                    rectangleShape = shape;
                    i5 |= composerStartRestartGroup.changed(rectangleShape) ? 256 : 128;
                }
                if ((i & 7168) == 0) {
                    jM16680getSurface0d7_KjU = j;
                    i5 |= ((i4 & 8) == 0 && composerStartRestartGroup.changed(jM16680getSurface0d7_KjU)) ? 2048 : 1024;
                } else {
                    jM16680getSurface0d7_KjU = j;
                }
                if ((i & 57344) == 0) {
                    if ((i4 & 16) == 0) {
                        i7 = i21;
                        jM16694contentColorForek8zF_U = j2;
                        int i22 = composerStartRestartGroup.changed(jM16694contentColorForek8zF_U) ? 16384 : 8192;
                        i5 |= i22;
                    } else {
                        i7 = i21;
                        jM16694contentColorForek8zF_U = j2;
                    }
                    i5 |= i22;
                } else {
                    i7 = i21;
                    jM16694contentColorForek8zF_U = j2;
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= 196608;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 458752) == 0) {
                        i5 |= composerStartRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                    }
                }
                i9 = i4 & 64;
                if (i9 != 0) {
                    i5 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i5 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
                }
                i10 = i4 & 128;
                if (i10 != 0) {
                    i5 |= 12582912;
                } else {
                    if ((i & 29360128) == 0) {
                        i11 = i10;
                        i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                    }
                    if ((i & 234881024) == 0) {
                        i5 |= ((i4 & 256) == 0 && composerStartRestartGroup.changed(indication)) ? 67108864 : 33554432;
                    }
                    i12 = i4 & 512;
                    if (i12 != 0) {
                        if ((i & 1879048192) == 0) {
                            i13 = i12;
                            i5 |= composerStartRestartGroup.changed(z) ? 536870912 : 268435456;
                        }
                        i14 = i4 & 1024;
                        if (i14 != 0) {
                            i16 = i2 | 6;
                            i15 = i14;
                        } else if ((i2 & 14) == 0) {
                            i15 = i14;
                            i16 = i2 | (composerStartRestartGroup.changed(str) ? 4 : 2);
                        } else {
                            i15 = i14;
                            i16 = i2;
                        }
                        i17 = i4 & 2048;
                        if (i17 != 0) {
                            i16 |= 48;
                            i18 = i17;
                        } else if ((i2 & 112) == 0) {
                            i18 = i17;
                            i16 |= composerStartRestartGroup.changed(role) ? 32 : 16;
                        } else {
                            i18 = i17;
                        }
                        i19 = i16;
                        if ((i4 & 4096) != 0) {
                            i19 |= 384;
                        } else if ((i2 & 896) == 0) {
                            i19 |= composerStartRestartGroup.changed(content) ? 256 : 128;
                        }
                        if ((1533916891 & i5) == 306783378 && (i19 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            z3 = z;
                            role3 = role;
                            composer2 = composerStartRestartGroup;
                            shape4 = rectangleShape;
                            j6 = jM16694contentColorForek8zF_U;
                            j5 = jM16680getSurface0d7_KjU;
                            modifier4 = modifier2;
                            borderStroke4 = borderStroke2;
                            f5 = f;
                            mutableInteractionSource3 = mutableInteractionSource;
                            indication3 = indication;
                            str3 = str;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i7 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i6 != 0) {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i4 & 8) != 0) {
                                    jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                    i5 &= -7169;
                                }
                                if ((i4 & 16) != 0) {
                                    jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i5 >> 9) & 14);
                                    i5 &= -57345;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                }
                                float fM20968constructorimpl = i9 == 0 ? C2256Dp.m20968constructorimpl(0) : f;
                                if (i11 == 0) {
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
                                if ((i4 & 256) == 0) {
                                    indication2 = (Indication) composerStartRestartGroup.consume(IndicationKt.getLocalIndication());
                                    i5 &= -234881025;
                                } else {
                                    indication2 = indication;
                                }
                                boolean z4 = i13 == 0 ? true : z;
                                shape2 = rectangleShape;
                                i20 = i5;
                                str2 = i15 == 0 ? null : str;
                                j3 = jM16694contentColorForek8zF_U;
                                borderStroke3 = borderStroke2;
                                role2 = i18 == 0 ? null : role;
                                f4 = fM20968constructorimpl;
                                modifier3 = modifier2;
                                z2 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 8) != 0) {
                                    i5 &= -7169;
                                }
                                if ((i4 & 16) != 0) {
                                    i5 &= -57345;
                                }
                                if ((i4 & 256) != 0) {
                                    i5 &= -234881025;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                indication2 = indication;
                                shape2 = rectangleShape;
                                j3 = jM16694contentColorForek8zF_U;
                                modifier3 = modifier2;
                                borderStroke3 = borderStroke2;
                                f4 = f;
                                z2 = z;
                                role2 = role;
                                i20 = i5;
                                str2 = str;
                            }
                            composerStartRestartGroup.endDefaults();
                            final Modifier modifier5 = modifier3;
                            if (ComposerKt.isTraceInProgress()) {
                                shape3 = shape2;
                            } else {
                                shape3 = shape2;
                                ComposerKt.traceEventStart(1585925488, i20, i19, "androidx.compose.material.Surface (Surface.kt:571)");
                            }
                            final float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + f4);
                            final int i23 = i19;
                            final Shape shape5 = shape3;
                            final String str4 = str2;
                            final long j7 = jM16680getSurface0d7_KjU;
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            final Indication indication4 = indication2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl2))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 149594672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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
                                public final void invoke(@Nullable Composer composer3, int i24) {
                                    if ((i24 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(149594672, i24, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:590)");
                                    }
                                    Modifier modifierThen = SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier5), shape5, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j7, (ElevationOverlay) composer3.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl2, composer3, (i20 >> 9) & 14), borderStroke3, f4).then(ClickableKt.m15439clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource4, indication4, z2, str4, role2, onClick));
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i25 = i23;
                                    composer3.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer3, 48, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-1300719946);
                                    if (AbstractC1038a.m1199D(composer3, (i25 >> 6) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j5 = j7;
                            composer2 = composerStartRestartGroup;
                            role3 = role2;
                            shape4 = shape5;
                            str3 = str4;
                            modifier4 = modifier5;
                            z3 = z2;
                            indication3 = indication4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            f5 = f4;
                            borderStroke4 = borderStroke3;
                            j6 = j3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$14
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

                            public final void invoke(@Nullable Composer composer3, int i24) {
                                SurfaceKt.m16871Surface9VG74zQ(onClick, modifier4, shape4, j5, j6, borderStroke4, f5, mutableInteractionSource3, indication3, z3, str3, role3, content, composer3, i | 1, i2, i4);
                            }
                        });
                        return;
                    }
                    i5 |= DriveFile.MODE_READ_WRITE;
                    i13 = i12;
                    i14 = i4 & 1024;
                    if (i14 != 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 != 0) {
                    }
                    i19 = i16;
                    if ((i4 & 4096) != 0) {
                    }
                    if ((1533916891 & i5) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i7 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i4 & 8) != 0) {
                            }
                            if ((i4 & 16) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 == 0) {
                            }
                            if (i11 == 0) {
                            }
                            if ((i4 & 256) == 0) {
                            }
                            if (i13 == 0) {
                            }
                            shape2 = rectangleShape;
                            i20 = i5;
                            str2 = i15 == 0 ? null : str;
                            j3 = jM16694contentColorForek8zF_U;
                            borderStroke3 = borderStroke2;
                            if (i18 == 0) {
                            }
                            f4 = fM20968constructorimpl;
                            modifier3 = modifier2;
                            z2 = z4;
                            composerStartRestartGroup.endDefaults();
                            final Modifier modifier52 = modifier3;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final float fM20968constructorimpl22 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + f4);
                            final int i232 = i19;
                            final Shape shape52 = shape3;
                            final String str42 = str2;
                            final long j72 = jM16680getSurface0d7_KjU;
                            final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                            final Indication indication42 = indication2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl22))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 149594672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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
                                public final void invoke(@Nullable Composer composer3, int i24) {
                                    if ((i24 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(149594672, i24, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:590)");
                                    }
                                    Modifier modifierThen = SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier52), shape52, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j72, (ElevationOverlay) composer3.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl22, composer3, (i20 >> 9) & 14), borderStroke3, f4).then(ClickableKt.m15439clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource42, indication42, z2, str42, role2, onClick));
                                    Function2<Composer, Integer, Unit> function2 = content;
                                    int i25 = i232;
                                    composer3.startReplaceableGroup(733328855);
                                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer3, 48, -1323940314);
                                    Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierThen);
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
                                    Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                    AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                    composer3.startReplaceableGroup(-2137368960);
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    composer3.startReplaceableGroup(-1300719946);
                                    if (AbstractC1038a.m1199D(composer3, (i25 >> 6) & 14, function2)) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j5 = j72;
                            composer2 = composerStartRestartGroup;
                            role3 = role2;
                            shape4 = shape52;
                            str3 = str42;
                            modifier4 = modifier52;
                            z3 = z2;
                            indication3 = indication42;
                            mutableInteractionSource3 = mutableInteractionSource42;
                            f5 = f4;
                            borderStroke4 = borderStroke3;
                            j6 = j3;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i11 = i10;
                if ((i & 234881024) == 0) {
                }
                i12 = i4 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 1024;
                if (i14 != 0) {
                }
                i17 = i4 & 2048;
                if (i17 != 0) {
                }
                i19 = i16;
                if ((i4 & 4096) != 0) {
                }
                if ((1533916891 & i5) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            rectangleShape = shape;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            i8 = i4 & 32;
            if (i8 != 0) {
            }
            i9 = i4 & 64;
            if (i9 != 0) {
            }
            i10 = i4 & 128;
            if (i10 != 0) {
            }
            i11 = i10;
            if ((i & 234881024) == 0) {
            }
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 1024;
            if (i14 != 0) {
            }
            i17 = i4 & 2048;
            if (i17 != 0) {
            }
            i19 = i16;
            if ((i4 & 4096) != 0) {
            }
            if ((1533916891 & i5) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        rectangleShape = shape;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        i8 = i4 & 32;
        if (i8 != 0) {
        }
        i9 = i4 & 64;
        if (i9 != 0) {
        }
        i10 = i4 & 128;
        if (i10 != 0) {
        }
        i11 = i10;
        if ((i & 234881024) == 0) {
        }
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 1024;
        if (i14 != 0) {
        }
        i17 = i4 & 2048;
        if (i17 != 0) {
        }
        i19 = i16;
        if ((i4 & 4096) != 0) {
        }
        if ((1533916891 & i5) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16872SurfaceFjzlyU(@Nullable Modifier modifier, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        long jM16680getSurface0d7_KjU;
        long j3;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        final int i7;
        final long j5;
        final float fM20968constructorimpl;
        final Modifier modifier3;
        final Shape shape2;
        final BorderStroke borderStroke3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1412203386);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                rectangleShape = shape;
                i4 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    jM16680getSurface0d7_KjU = j;
                    int i11 = composerStartRestartGroup.changed(jM16680getSurface0d7_KjU) ? 256 : 128;
                    i4 |= i11;
                } else {
                    jM16680getSurface0d7_KjU = j;
                }
                i4 |= i11;
            } else {
                jM16680getSurface0d7_KjU = j;
            }
            if ((i & 7168) != 0) {
                j3 = j2;
                i4 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j2;
            }
            i5 = i2 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else {
                if ((57344 & i) == 0) {
                    borderStroke2 = borderStroke;
                    i4 |= composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((i & 458752) == 0) {
                    i4 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
                }
                if ((i2 & 64) == 0) {
                    i8 = (i & 3670016) == 0 ? composerStartRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                    if ((i4 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i10 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                                jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                            }
                            if ((i2 & 8) != 0) {
                                long jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                                j3 = jM16694contentColorForek8zF_U;
                            }
                            if (i5 != 0) {
                                borderStroke2 = null;
                            }
                            if (i6 == 0) {
                                long j6 = jM16680getSurface0d7_KjU;
                                i7 = i4;
                                j5 = j6;
                                fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
                                shape2 = rectangleShape;
                                borderStroke3 = borderStroke2;
                                modifier3 = modifier4;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1412203386, i7, -1, "androidx.compose.material.Surface (Surface.kt:103)");
                                }
                                final float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + fM20968constructorimpl);
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl2))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1

                                    /* JADX INFO: renamed from: androidx.compose.material.SurfaceKt$Surface$1$2 */
                                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                                    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                                    @DebugMetadata(m14020c = "androidx.compose.material.SurfaceKt$Surface$1$2", m14021f = "Surface.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                                    public static final class C16212 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                                        int label;

                                        public C16212(Continuation<? super C16212> continuation) {
                                            super(2, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @NotNull
                                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                            return new C16212(continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        @Nullable
                                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                                            return ((C16212) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            if (this.label != 0) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                            return Unit.INSTANCE;
                                        }
                                    }

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
                                    public final void invoke(@Nullable Composer composer2, int i12) {
                                        if ((i12 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1822160838, i12, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:116)");
                                        }
                                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m16878surface8ww4TTg(modifier3, shape2, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j5, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl2, composer2, (i7 >> 6) & 14), borderStroke3, fM20968constructorimpl), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }
                                        }), Unit.INSTANCE, new C16212(null));
                                        Function2<Composer, Integer, Unit> function2 = content;
                                        int i13 = i7;
                                        composer2.startReplaceableGroup(733328855);
                                        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPointerInput);
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
                                        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                        composer2.startReplaceableGroup(-2137368960);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer2.startReplaceableGroup(1539610176);
                                        if (AbstractC1038a.m1199D(composer2, (i13 >> 18) & 14, function2)) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composerStartRestartGroup, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                long j7 = jM16680getSurface0d7_KjU;
                                i7 = i4;
                                j5 = j7;
                                fM20968constructorimpl = f;
                                modifier3 = modifier4;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            long j8 = jM16680getSurface0d7_KjU;
                            i7 = i4;
                            j5 = j8;
                            fM20968constructorimpl = f;
                            modifier3 = modifier2;
                        }
                        shape2 = rectangleShape;
                        borderStroke3 = borderStroke2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final float fM20968constructorimpl22 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + fM20968constructorimpl);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(j3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl22))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1

                            /* JADX INFO: renamed from: androidx.compose.material.SurfaceKt$Surface$1$2 */
                            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                            @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
                            @DebugMetadata(m14020c = "androidx.compose.material.SurfaceKt$Surface$1$2", m14021f = "Surface.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                            public static final class C16212 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                                int label;

                                public C16212(Continuation<? super C16212> continuation) {
                                    super(2, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new C16212(continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                @Nullable
                                public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                                    return ((C16212) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label != 0) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                            }

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
                            public final void invoke(@Nullable Composer composer2, int i12) {
                                if ((i12 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1822160838, i12, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:116)");
                                }
                                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m16878surface8ww4TTg(modifier3, shape2, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j5, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl22, composer2, (i7 >> 6) & 14), borderStroke3, fM20968constructorimpl), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
                                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }
                                }), Unit.INSTANCE, new C16212(null));
                                Function2<Composer, Integer, Unit> function2 = content;
                                int i13 = i7;
                                composer2.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierPointerInput);
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
                                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                composer2.startReplaceableGroup(-2137368960);
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                composer2.startReplaceableGroup(1539610176);
                                if (AbstractC1038a.m1199D(composer2, (i13 >> 18) & 14, function2)) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composerStartRestartGroup, 56);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        fM20968constructorimpl = f;
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j5 = jM16680getSurface0d7_KjU;
                        borderStroke3 = borderStroke2;
                    }
                    final long j9 = j3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$2
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
                            SurfaceKt.m16872SurfaceFjzlyU(modifier3, shape2, j5, j9, borderStroke3, fM20968constructorimpl, content, composer2, i | 1, i2);
                        }
                    });
                    return;
                }
                i4 |= i8;
                if ((i4 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 == 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                    }
                }
                final long j92 = j3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i4 |= i8;
            if ((i4 & 2995931) == 599186) {
            }
            final long j922 = j3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        rectangleShape = shape;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i4 |= i8;
        if ((i4 & 2995931) == 599186) {
        }
        final long j9222 = j3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0269 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16873SurfaceLPr_se0(@NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Shape rectangleShape;
        long jM16680getSurface0d7_KjU;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        long jM16694contentColorForek8zF_U;
        final Modifier modifier3;
        final long j3;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        final int i12;
        final Shape shape2;
        final float f4;
        final long j5;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z4;
        final Shape shape3;
        final BorderStroke borderStroke4;
        final float f5;
        final long j6;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1560876237);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(onClick) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
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
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 7168) == 0) {
                        rectangleShape = shape;
                        i4 |= composerStartRestartGroup.changed(rectangleShape) ? 2048 : 1024;
                    }
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            jM16680getSurface0d7_KjU = j;
                            int i14 = composerStartRestartGroup.changed(jM16680getSurface0d7_KjU) ? 16384 : 8192;
                            i4 |= i14;
                        } else {
                            jM16680getSurface0d7_KjU = j;
                        }
                        i4 |= i14;
                    } else {
                        jM16680getSurface0d7_KjU = j;
                    }
                    if ((458752 & i) == 0) {
                        i4 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(j2)) ? 131072 : 65536;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 3670016) == 0) {
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        }
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                        i4 |= 12582912;
                    } else {
                        if ((29360128 & i) == 0) {
                            i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                        }
                        i9 = i2 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else {
                            if ((i & 234881024) == 0) {
                                i10 = i9;
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                            if ((i2 & 512) != 0) {
                                if ((1879048192 & i) == 0) {
                                    i11 = composerStartRestartGroup.changed(content) ? 536870912 : 268435456;
                                }
                                if ((1533916891 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    modifier4 = modifier2;
                                    z4 = z2;
                                    shape3 = rectangleShape;
                                    j5 = jM16680getSurface0d7_KjU;
                                    borderStroke4 = borderStroke2;
                                    j6 = j2;
                                    f5 = f;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i13 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i5 != 0) {
                                            z2 = true;
                                        }
                                        if (i6 != 0) {
                                            rectangleShape = RectangleShapeKt.getRectangleShape();
                                        }
                                        if ((i2 & 16) != 0) {
                                            jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                            i4 &= -57345;
                                        }
                                        if ((i2 & 32) == 0) {
                                            jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i4 >> 12) & 14);
                                            i4 &= -458753;
                                        } else {
                                            jM16694contentColorForek8zF_U = j2;
                                        }
                                        if (i7 != 0) {
                                            borderStroke2 = null;
                                        }
                                        float fM20968constructorimpl = i8 == 0 ? C2256Dp.m20968constructorimpl(0) : f;
                                        if (i10 == 0) {
                                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            composerStartRestartGroup.endReplaceableGroup();
                                            long j7 = jM16680getSurface0d7_KjU;
                                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                            modifier3 = modifier2;
                                            j3 = j7;
                                            z3 = z2;
                                            borderStroke3 = borderStroke2;
                                        } else {
                                            modifier3 = modifier2;
                                            j3 = jM16680getSurface0d7_KjU;
                                            borderStroke3 = borderStroke2;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            z3 = z2;
                                        }
                                        i12 = i4;
                                        shape2 = rectangleShape;
                                        f4 = fM20968constructorimpl;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i2 & 16) != 0) {
                                            i4 &= -57345;
                                        }
                                        if ((i2 & 32) != 0) {
                                            i4 &= -458753;
                                        }
                                        jM16694contentColorForek8zF_U = j2;
                                        modifier3 = modifier2;
                                        j3 = jM16680getSurface0d7_KjU;
                                        borderStroke3 = borderStroke2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        z3 = z2;
                                        i12 = i4;
                                        shape2 = rectangleShape;
                                        f4 = f;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1560876237, i12, -1, "androidx.compose.material.Surface (Surface.kt:208)");
                                    }
                                    final float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + f4);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM16694contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl2))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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
                                                ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                                            }
                                            Modifier modifierM15440clickableO2vRcR0$default = ClickableKt.m15440clickableO2vRcR0$default(SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier3), shape2, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j3, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl2, composer2, (i12 >> 12) & 14), borderStroke3, f4), mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z3, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i16 = i12;
                                            composer2.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                                            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
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
                                                composer2.createNode(constructor);
                                            } else {
                                                composer2.useNode();
                                            }
                                            composer2.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                            composer2.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer2.startReplaceableGroup(-390905273);
                                            if (AbstractC1038a.m1199D(composer2, (i16 >> 27) & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    j5 = j3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z4 = z3;
                                    shape3 = shape2;
                                    borderStroke4 = borderStroke3;
                                    f5 = f4;
                                    j6 = jM16694contentColorForek8zF_U;
                                    modifier4 = modifier3;
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$5
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
                                        SurfaceKt.m16873SurfaceLPr_se0(onClick, modifier4, z4, shape3, j5, j6, borderStroke4, f5, mutableInteractionSource3, content, composer2, i | 1, i2);
                                    }
                                });
                                return;
                            }
                            i11 = DriveFile.MODE_READ_WRITE;
                            i4 |= i11;
                            if ((1533916891 & i4) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0) {
                                    if (i13 != 0) {
                                    }
                                    if (i5 != 0) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    if ((i2 & 16) != 0) {
                                    }
                                    if ((i2 & 32) == 0) {
                                    }
                                    if (i7 != 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    i12 = i4;
                                    shape2 = rectangleShape;
                                    f4 = fM20968constructorimpl;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    final float fM20968constructorimpl22 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + f4);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM16694contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl22))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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
                                                ComposerKt.traceEventStart(2031491085, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:224)");
                                            }
                                            Modifier modifierM15440clickableO2vRcR0$default = ClickableKt.m15440clickableO2vRcR0$default(SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier3), shape2, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j3, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl22, composer2, (i12 >> 12) & 14), borderStroke3, f4), mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z3, null, Role.m20259boximpl(Role.INSTANCE.m20266getButtono7Vup1c()), onClick, 8, null);
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i16 = i12;
                                            composer2.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer2, 48, -1323940314);
                                            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
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
                                                composer2.createNode(constructor);
                                            } else {
                                                composer2.useNode();
                                            }
                                            composer2.disableReusing();
                                            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 2058660585);
                                            composer2.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer2.startReplaceableGroup(-390905273);
                                            if (AbstractC1038a.m1199D(composer2, (i16 >> 27) & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composerStartRestartGroup, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    j5 = j3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z4 = z3;
                                    shape3 = shape2;
                                    borderStroke4 = borderStroke3;
                                    f5 = f4;
                                    j6 = jM16694contentColorForek8zF_U;
                                    modifier4 = modifier3;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i10 = i9;
                        if ((i2 & 512) != 0) {
                        }
                        i4 |= i11;
                        if ((1533916891 & i4) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i2 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    if ((i2 & 512) != 0) {
                    }
                    i4 |= i11;
                    if ((1533916891 & i4) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                rectangleShape = shape;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) == 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i2 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i2 & 512) != 0) {
                }
                i4 |= i11;
                if ((1533916891 & i4) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            rectangleShape = shape;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) == 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i2 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 512) != 0) {
            }
            i4 |= i11;
            if ((1533916891 & i4) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        rectangleShape = shape;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) == 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i2 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 512) != 0) {
        }
        i4 |= i11;
        if ((1533916891 & i4) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0106  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16874SurfaceNy5ogXk(final boolean z, @NotNull final Function0<Unit> onClick, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, final int i4) {
        final boolean z3;
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z4;
        int i7;
        Shape shape2;
        long j3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier3;
        int i14;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U;
        int i15;
        final float fM20968constructorimpl;
        final int i16;
        final Shape shape3;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Shape shape4;
        final MutableInteractionSource mutableInteractionSource3;
        final BorderStroke borderStroke3;
        final long j5;
        final boolean z5;
        final Modifier modifier4;
        final float f4;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(262027249);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i5 = i;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i17 = i4 & 4;
        if (i17 != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z4 = z2;
                    i5 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        shape2 = shape;
                        i5 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    }
                    if ((i & 458752) == 0) {
                        i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(j)) ? 131072 : 65536;
                    }
                    if ((i & 3670016) != 0) {
                        j3 = j2;
                        i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(j3)) ? 1048576 : 524288;
                    } else {
                        j3 = j2;
                    }
                    i8 = i4 & 128;
                    if (i8 == 0) {
                        i5 |= 12582912;
                    } else {
                        if ((29360128 & i) == 0) {
                            i5 |= composerStartRestartGroup.changed(borderStroke) ? 8388608 : 4194304;
                        }
                        i9 = i4 & 256;
                        if (i9 != 0) {
                            i5 |= 100663296;
                        } else {
                            if ((i & 234881024) == 0) {
                                i10 = i9;
                                i5 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                            }
                            i11 = i4 & 512;
                            if (i11 != 0) {
                                if ((i & 1879048192) == 0) {
                                    i12 = i11;
                                    i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                                }
                                if ((i4 & 1024) != 0) {
                                    i13 = i2 | 6;
                                } else if ((i2 & 14) == 0) {
                                    i13 = i2 | (composerStartRestartGroup.changed(content) ? 4 : 2);
                                } else {
                                    i13 = i2;
                                }
                                if ((i5 & 1533916891) == 306783378 && (i13 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    borderStroke3 = borderStroke;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    composer2 = composerStartRestartGroup;
                                    modifier4 = modifier2;
                                    z5 = z4;
                                    f4 = f;
                                    j6 = j3;
                                    shape4 = shape2;
                                    j5 = j;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        modifier3 = i17 == 0 ? Modifier.INSTANCE : modifier2;
                                        if (i6 != 0) {
                                            z4 = true;
                                        }
                                        Shape rectangleShape = i7 == 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                                        if ((i4 & 32) == 0) {
                                            i14 = i5 & (-458753);
                                            jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                        } else {
                                            i14 = i5;
                                            jM16680getSurface0d7_KjU = j;
                                        }
                                        if ((i4 & 64) == 0) {
                                            jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i14 >> 15) & 14);
                                            i15 = (-3670017) & i14;
                                        } else {
                                            jM16694contentColorForek8zF_U = j2;
                                            i15 = i14;
                                        }
                                        BorderStroke borderStroke4 = i8 == 0 ? null : borderStroke;
                                        fM20968constructorimpl = i10 == 0 ? C2256Dp.m20968constructorimpl(0) : f;
                                        if (i12 == 0) {
                                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            composerStartRestartGroup.endReplaceableGroup();
                                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                            BorderStroke borderStroke5 = borderStroke4;
                                            i16 = i15;
                                            shape3 = rectangleShape;
                                            borderStroke2 = borderStroke5;
                                        } else {
                                            BorderStroke borderStroke6 = borderStroke4;
                                            i16 = i15;
                                            shape3 = rectangleShape;
                                            borderStroke2 = borderStroke6;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 32) != 0) {
                                            i5 &= -458753;
                                        }
                                        if ((i4 & 64) != 0) {
                                            i5 &= -3670017;
                                        }
                                        borderStroke2 = borderStroke;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        jM16694contentColorForek8zF_U = j3;
                                        modifier3 = modifier2;
                                        shape3 = shape2;
                                        fM20968constructorimpl = f;
                                        i16 = i5;
                                        jM16680getSurface0d7_KjU = j;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(262027249, i16, i13, "androidx.compose.material.Surface (Surface.kt:323)");
                                    }
                                    final float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + fM20968constructorimpl);
                                    final Modifier modifier5 = modifier3;
                                    final int i18 = i13;
                                    composer2 = composerStartRestartGroup;
                                    final long j7 = jM16680getSurface0d7_KjU;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM16694contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl2))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
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
                                        public final void invoke(@Nullable Composer composer3, int i19) {
                                            if ((i19 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1391199439, i19, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:340)");
                                            }
                                            Modifier modifierM16105selectableO2vRcR0 = SelectableKt.m16105selectableO2vRcR0(SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier5), shape3, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j7, (ElevationOverlay) composer3.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl2, composer3, (i16 >> 15) & 14), borderStroke2, fM20968constructorimpl), z3, mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer3, 0, 7), z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick);
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i20 = i18;
                                            composer3.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer3, 48, -1323940314);
                                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16105selectableO2vRcR0);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                            composer3.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer3.startReplaceableGroup(23612267);
                                            if (AbstractC1038a.m1199D(composer3, i20 & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape4 = shape3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    borderStroke3 = borderStroke2;
                                    j5 = j7;
                                    z5 = z4;
                                    modifier4 = modifier5;
                                    f4 = fM20968constructorimpl;
                                    j6 = jM16694contentColorForek8zF_U;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$8
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

                                    public final void invoke(@Nullable Composer composer3, int i19) {
                                        SurfaceKt.m16874SurfaceNy5ogXk(z, onClick, modifier4, z5, shape4, j5, j6, borderStroke3, f4, mutableInteractionSource3, content, composer3, i | 1, i2, i4);
                                    }
                                });
                                return;
                            }
                            i5 |= DriveFile.MODE_READ_WRITE;
                            i12 = i11;
                            if ((i4 & 1024) != 0) {
                            }
                            if ((i5 & 1533916891) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0) {
                                    if (i17 == 0) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if ((i4 & 32) == 0) {
                                    }
                                    if ((i4 & 64) == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    final float fM20968constructorimpl22 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + fM20968constructorimpl);
                                    final Modifier modifier52 = modifier3;
                                    final int i182 = i13;
                                    composer2 = composerStartRestartGroup;
                                    final long j72 = jM16680getSurface0d7_KjU;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM16694contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl22))}, ComposableLambdaKt.composableLambda(composer2, -1391199439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
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
                                        public final void invoke(@Nullable Composer composer3, int i19) {
                                            if ((i19 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1391199439, i19, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:340)");
                                            }
                                            Modifier modifierM16105selectableO2vRcR0 = SelectableKt.m16105selectableO2vRcR0(SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier52), shape3, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j72, (ElevationOverlay) composer3.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl22, composer3, (i16 >> 15) & 14), borderStroke2, fM20968constructorimpl), z3, mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer3, 0, 7), z4, Role.m20259boximpl(Role.INSTANCE.m20272getTabo7Vup1c()), onClick);
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i20 = i182;
                                            composer3.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer3, 48, -1323940314);
                                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16105selectableO2vRcR0);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                            composer3.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer3.startReplaceableGroup(23612267);
                                            if (AbstractC1038a.m1199D(composer3, i20 & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    shape4 = shape3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    borderStroke3 = borderStroke2;
                                    j5 = j72;
                                    z5 = z4;
                                    modifier4 = modifier52;
                                    f4 = fM20968constructorimpl;
                                    j6 = jM16694contentColorForek8zF_U;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i10 = i9;
                        i11 = i4 & 512;
                        if (i11 != 0) {
                        }
                        i12 = i11;
                        if ((i4 & 1024) != 0) {
                        }
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i4 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i4 & 512;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    if ((i4 & 1024) != 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                shape2 = shape;
                if ((i & 458752) == 0) {
                }
                if ((i & 3670016) != 0) {
                }
                i8 = i4 & 128;
                if (i8 == 0) {
                }
                i9 = i4 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i4 & 512;
                if (i11 != 0) {
                }
                i12 = i11;
                if ((i4 & 1024) != 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            shape2 = shape;
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) != 0) {
            }
            i8 = i4 & 128;
            if (i8 == 0) {
            }
            i9 = i4 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 512;
            if (i11 != 0) {
            }
            i12 = i11;
            if ((i4 & 1024) != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z4 = z2;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        shape2 = shape;
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) != 0) {
        }
        i8 = i4 & 128;
        if (i8 == 0) {
        }
        i9 = i4 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 512;
        if (i11 != 0) {
        }
        i12 = i11;
        if ((i4 & 1024) != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m16878surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Modifier modifierM18189shadows4CzXII$default = ShadowKt.m18189shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null);
        Modifier modifierBorder = Modifier.INSTANCE;
        if (borderStroke != null) {
            modifierBorder = BorderKt.border(modifierBorder, borderStroke, shape);
        }
        return ClipKt.clip(BackgroundKt.m15408backgroundbw27NRU(modifierM18189shadows4CzXII$default.then(modifierBorder), j, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m16879surfaceColorAtElevationcq6XJ1M(long j, ElevationOverlay elevationOverlay, float f, Composer composer, int i) {
        Composer composer2;
        long jMo16710apply7g2Lkgo;
        composer.startReplaceableGroup(1561611256);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, i, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:632)");
        }
        if (!Color.m18526equalsimpl0(j, MaterialTheme.INSTANCE.getColors(composer, 6).m16680getSurface0d7_KjU()) || elevationOverlay == null) {
            composer2 = composer;
            jMo16710apply7g2Lkgo = j;
        } else {
            composer2 = composer;
            jMo16710apply7g2Lkgo = elevationOverlay.mo16710apply7g2Lkgo(j, f, composer2, (i & 14) | ((i >> 3) & 112) | ((i << 3) & 896));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return jMo16710apply7g2Lkgo;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0106  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m16875SurfaceNy5ogXk(final boolean z, @NotNull final Function1<? super Boolean, Unit> onCheckedChange, @Nullable Modifier modifier, boolean z2, @Nullable Shape shape, long j, long j2, @Nullable BorderStroke borderStroke, float f, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, final int i, final int i2, final int i4) {
        final boolean z3;
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z4;
        int i7;
        Shape shape2;
        long j3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier3;
        int i14;
        long jM16680getSurface0d7_KjU;
        long jM16694contentColorForek8zF_U;
        int i15;
        final float fM20968constructorimpl;
        final int i16;
        final Shape shape3;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Shape shape4;
        final MutableInteractionSource mutableInteractionSource3;
        final BorderStroke borderStroke3;
        final long j5;
        final boolean z5;
        final Modifier modifier4;
        final float f4;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1341569296);
        if ((i4 & 1) != 0) {
            i5 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i5 = i;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(onCheckedChange) ? 32 : 16;
        }
        int i17 = i4 & 4;
        if (i17 != 0) {
            i5 |= 384;
        } else {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i & 7168) == 0) {
                    z4 = z2;
                    i5 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((57344 & i) == 0) {
                        shape2 = shape;
                        i5 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                    }
                    if ((i & 458752) == 0) {
                        i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(j)) ? 131072 : 65536;
                    }
                    if ((i & 3670016) != 0) {
                        j3 = j2;
                        i5 |= ((i4 & 64) == 0 && composerStartRestartGroup.changed(j3)) ? 1048576 : 524288;
                    } else {
                        j3 = j2;
                    }
                    i8 = i4 & 128;
                    if (i8 == 0) {
                        i5 |= 12582912;
                    } else {
                        if ((29360128 & i) == 0) {
                            i5 |= composerStartRestartGroup.changed(borderStroke) ? 8388608 : 4194304;
                        }
                        i9 = i4 & 256;
                        if (i9 != 0) {
                            i5 |= 100663296;
                        } else {
                            if ((i & 234881024) == 0) {
                                i10 = i9;
                                i5 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                            }
                            i11 = i4 & 512;
                            if (i11 != 0) {
                                if ((i & 1879048192) == 0) {
                                    i12 = i11;
                                    i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                                }
                                if ((i4 & 1024) != 0) {
                                    i13 = i2 | 6;
                                } else if ((i2 & 14) == 0) {
                                    i13 = i2 | (composerStartRestartGroup.changed(content) ? 4 : 2);
                                } else {
                                    i13 = i2;
                                }
                                if ((i5 & 1533916891) == 306783378 && (i13 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    borderStroke3 = borderStroke;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    composer2 = composerStartRestartGroup;
                                    modifier4 = modifier2;
                                    z5 = z4;
                                    f4 = f;
                                    j6 = j3;
                                    shape4 = shape2;
                                    j5 = j;
                                } else {
                                    composerStartRestartGroup.startDefaults();
                                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 32) != 0) {
                                            i5 &= -458753;
                                        }
                                        if ((i4 & 64) != 0) {
                                            i5 &= -3670017;
                                        }
                                        borderStroke2 = borderStroke;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        jM16694contentColorForek8zF_U = j3;
                                        modifier3 = modifier2;
                                        shape3 = shape2;
                                        fM20968constructorimpl = f;
                                        i16 = i5;
                                        jM16680getSurface0d7_KjU = j;
                                    } else {
                                        modifier3 = i17 == 0 ? Modifier.INSTANCE : modifier2;
                                        if (i6 != 0) {
                                            z4 = true;
                                        }
                                        Shape rectangleShape = i7 == 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                                        if ((i4 & 32) == 0) {
                                            i14 = i5 & (-458753);
                                            jM16680getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m16680getSurface0d7_KjU();
                                        } else {
                                            i14 = i5;
                                            jM16680getSurface0d7_KjU = j;
                                        }
                                        if ((i4 & 64) == 0) {
                                            jM16694contentColorForek8zF_U = ColorsKt.m16694contentColorForek8zF_U(jM16680getSurface0d7_KjU, composerStartRestartGroup, (i14 >> 15) & 14);
                                            i15 = (-3670017) & i14;
                                        } else {
                                            jM16694contentColorForek8zF_U = j2;
                                            i15 = i14;
                                        }
                                        BorderStroke borderStroke4 = i8 == 0 ? null : borderStroke;
                                        fM20968constructorimpl = i10 == 0 ? C2256Dp.m20968constructorimpl(0) : f;
                                        if (i12 == 0) {
                                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            composerStartRestartGroup.endReplaceableGroup();
                                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                            BorderStroke borderStroke5 = borderStroke4;
                                            i16 = i15;
                                            shape3 = rectangleShape;
                                            borderStroke2 = borderStroke5;
                                        } else {
                                            BorderStroke borderStroke6 = borderStroke4;
                                            i16 = i15;
                                            shape3 = rectangleShape;
                                            borderStroke2 = borderStroke6;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        }
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1341569296, i16, i13, "androidx.compose.material.Surface (Surface.kt:440)");
                                    }
                                    final float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + fM20968constructorimpl);
                                    final Modifier modifier5 = modifier3;
                                    final int i18 = i13;
                                    composer2 = composerStartRestartGroup;
                                    final long j7 = jM16680getSurface0d7_KjU;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM16694contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl2))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
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
                                        public final void invoke(@Nullable Composer composer3, int i19) {
                                            if ((i19 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-311657392, i19, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                                            }
                                            Modifier modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier5), shape3, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j7, (ElevationOverlay) composer3.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl2, composer3, (i16 >> 15) & 14), borderStroke2, fM20968constructorimpl), z3, mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer3, 0, 7), z4, Role.m20259boximpl(Role.INSTANCE.m20271getSwitcho7Vup1c()), onCheckedChange);
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i20 = i18;
                                            composer3.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer3, 48, -1323940314);
                                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16110toggleableO2vRcR0);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                            composer3.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer3.startReplaceableGroup(1103154314);
                                            if (AbstractC1038a.m1199D(composer3, i20 & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape4 = shape3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    borderStroke3 = borderStroke2;
                                    j5 = j7;
                                    z5 = z4;
                                    modifier4 = modifier5;
                                    f4 = fM20968constructorimpl;
                                    j6 = jM16694contentColorForek8zF_U;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                    return;
                                }
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$11
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

                                    public final void invoke(@Nullable Composer composer3, int i19) {
                                        SurfaceKt.m16875SurfaceNy5ogXk(z, onCheckedChange, modifier4, z5, shape4, j5, j6, borderStroke3, f4, mutableInteractionSource3, content, composer3, i | 1, i2, i4);
                                    }
                                });
                                return;
                            }
                            i5 |= DriveFile.MODE_READ_WRITE;
                            i12 = i11;
                            if ((i4 & 1024) != 0) {
                            }
                            if ((i5 & 1533916891) == 306783378) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) == 0) {
                                    if (i17 == 0) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if ((i4 & 32) == 0) {
                                    }
                                    if ((i4 & 64) == 0) {
                                    }
                                    if (i8 == 0) {
                                    }
                                    if (i10 == 0) {
                                    }
                                    if (i12 == 0) {
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    final float fM20968constructorimpl22 = C2256Dp.m20968constructorimpl(((C2256Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m20982unboximpl() + fM20968constructorimpl);
                                    final Modifier modifier52 = modifier3;
                                    final int i182 = i13;
                                    composer2 = composerStartRestartGroup;
                                    final long j72 = jM16680getSurface0d7_KjU;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m18515boximpl(jM16694contentColorForek8zF_U)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C2256Dp.m20966boximpl(fM20968constructorimpl22))}, ComposableLambdaKt.composableLambda(composer2, -311657392, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
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
                                        public final void invoke(@Nullable Composer composer3, int i19) {
                                            if ((i19 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-311657392, i19, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                                            }
                                            Modifier modifierM16110toggleableO2vRcR0 = ToggleableKt.m16110toggleableO2vRcR0(SurfaceKt.m16878surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(modifier52), shape3, SurfaceKt.m16879surfaceColorAtElevationcq6XJ1M(j72, (ElevationOverlay) composer3.consume(ElevationOverlayKt.getLocalElevationOverlay()), fM20968constructorimpl22, composer3, (i16 >> 15) & 14), borderStroke2, fM20968constructorimpl), z3, mutableInteractionSource2, RippleKt.m16977rememberRipple9IZ8Weo(false, 0.0f, 0L, composer3, 0, 7), z4, Role.m20259boximpl(Role.INSTANCE.m20271getSwitcho7Vup1c()), onCheckedChange);
                                            Function2<Composer, Integer, Unit> function2 = content;
                                            int i20 = i182;
                                            composer3.startReplaceableGroup(733328855);
                                            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, true, composer3, 48, -1323940314);
                                            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM16110toggleableO2vRcR0);
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
                                            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
                                            AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer3, composer3), composer3, 2058660585);
                                            composer3.startReplaceableGroup(-2137368960);
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            composer3.startReplaceableGroup(1103154314);
                                            if (AbstractC1038a.m1199D(composer3, i20 & 14, function2)) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    shape4 = shape3;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    borderStroke3 = borderStroke2;
                                    j5 = j72;
                                    z5 = z4;
                                    modifier4 = modifier52;
                                    f4 = fM20968constructorimpl;
                                    j6 = jM16694contentColorForek8zF_U;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i10 = i9;
                        i11 = i4 & 512;
                        if (i11 != 0) {
                        }
                        i12 = i11;
                        if ((i4 & 1024) != 0) {
                        }
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i9 = i4 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i4 & 512;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    if ((i4 & 1024) != 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                shape2 = shape;
                if ((i & 458752) == 0) {
                }
                if ((i & 3670016) != 0) {
                }
                i8 = i4 & 128;
                if (i8 == 0) {
                }
                i9 = i4 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i4 & 512;
                if (i11 != 0) {
                }
                i12 = i11;
                if ((i4 & 1024) != 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z4 = z2;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            shape2 = shape;
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) != 0) {
            }
            i8 = i4 & 128;
            if (i8 == 0) {
            }
            i9 = i4 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 512;
            if (i11 != 0) {
            }
            i12 = i11;
            if ((i4 & 1024) != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z4 = z2;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        shape2 = shape;
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) != 0) {
        }
        i8 = i4 & 128;
        if (i8 == 0) {
        }
        i9 = i4 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 512;
        if (i11 != 0) {
        }
        i12 = i11;
        if ((i4 & 1024) != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
